// 参考yywxjs实现
(function () {

    //防止重复注入
if (typeof window.document === 'object' && typeof window.document !== null && typeof window.document.__wx_web_prefetcher_js_isLoaded === 'string' && window.document.__wx_web_prefetcher_js_isLoaded == 'loaded') {
    return;
}

    var _sendMessageQueue = [], // page to native的消息队列
        _callback_count = 1000, // 第一个事件的id，后面递增。
        _callback_map = {}, // 回调表 'callbackID' => callback
        _CALLBACK_ID = '__callback_id',
        _EVENT_ID = '__event_id',
        _MSG_QUEUE = '__msg_queue',
        _JSON_MESSAGE = '__json_message',
        _SHA_KEY = '__sha_key',
        _xxyy = __wxPrefetcher._getDgtVerifyRandomStr && __wxPrefetcher._getDgtVerifyRandomStr(),
        isDgtVerifyEnabled = __wxPrefetcher._isDgtVerifyEnabled && __wxPrefetcher._isDgtVerifyEnabled();

    var _handleMessageIdentifier = _handleMessageFromWeixin;
    var _fetchQueueIdentifier = _fetchQueue;
    var _callIdentifier = _call;
    var _logIdentifier = _log;

    // UTF8
  var UTF8 = {

    // public method for url encoding
    encode: function (string) {
      string = string.replace(/\r\n/g, "\n");
      var utftext = "";

      for (var n = 0; n < string.length; n++) {

        var c = string.charCodeAt(n);

        if (c < 128) {
          utftext += String.fromCharCode(c);
        } else if ((c > 127) && (c < 2048)) {
          utftext += String.fromCharCode((c >> 6) | 192);
          utftext += String.fromCharCode((c & 63) | 128);
        } else {
          utftext += String.fromCharCode((c >> 12) | 224);
          utftext += String.fromCharCode(((c >> 6) & 63) | 128);
          utftext += String.fromCharCode((c & 63) | 128);
        }

      }

      return utftext;
    },

    // public method for url decoding
    decode: function (utftext) {
      var string = "";
      var i = 0;
      var c = c1 = c2 = 0;

      while (i < utftext.length) {

        c = utftext.charCodeAt(i);

        if (c < 128) {
          string += String.fromCharCode(c);
          i++;
        } else if ((c > 191) && (c < 224)) {
          c2 = utftext.charCodeAt(i + 1);
          string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
          i += 2;
        } else {
          c2 = utftext.charCodeAt(i + 1);
          c3 = utftext.charCodeAt(i + 2);
          string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
          i += 3;
        }

      }

      return string;
    }

  };

  var HEX = {
    encode: function (str) {
      var r = "";
      var e = str.length;
      var c = 0;
      var h;
      while (c < e) {
        h = str.charCodeAt(c++).toString(16);
        while (h.length < 2) h = "0" + h;
        r += h;
      }
      return r.toUpperCase();
    },

    decode: function (str) {
      var r = "";
      var e = str.length;
      var s;
      while (e >= 0) {
        s = e - 2;
        r = String.fromCharCode("0x" + str.substring(s, e)) + r;
        e = s;
      }
      return r;
    }
  };

  var base64encodechars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

  function base64encode(str) {
    if (str === undefined) {
      return str;
    }

    var out, i, len;
    var c1, c2, c3;
    len = str.length;
    i = 0;
    out = "";
    while (i < len) {
      c1 = str.charCodeAt(i++) & 0xff;
      if (i == len) {
        out += base64encodechars.charAt(c1 >> 2);
        out += base64encodechars.charAt((c1 & 0x3) << 4);
        out += "==";
        break;
      }
      c2 = str.charCodeAt(i++);
      if (i == len) {
        out += base64encodechars.charAt(c1 >> 2);
        out += base64encodechars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xf0) >> 4));
        out += base64encodechars.charAt((c2 & 0xf) << 2);
        out += "=";
        break;
      }
      c3 = str.charCodeAt(i++);
      out += base64encodechars.charAt(c1 >> 2);
      out += base64encodechars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xf0) >> 4));
      out += base64encodechars.charAt(((c2 & 0xf) << 2) | ((c3 & 0xc0) >> 6));
      out += base64encodechars.charAt(c3 & 0x3f);
    }
    return out;
  }


var CryptoJS = CryptoJS || function (e, m) {
    var p = {},
      j = p.lib = {},
      l = function () {},
      f = j.Base = {
        extend: function (a) {
          l.prototype = this;
          var c = new l;
          a && c.mixIn(a);
          c.hasOwnProperty("init") || (c.init = function () {
            c.$super.init.apply(this, arguments)
          });
          c.init.prototype = c;
          c.$super = this;
          return c
        },
        create: function () {
          var a = this.extend();
          a.init.apply(a, arguments);
          return a
        },
        init: function () {},
        mixIn: function (a) {
          for (var c in a) a.hasOwnProperty(c) && (this[c] = a[c]);
          a.hasOwnProperty("toString") && (this.toString = a.toString)
        },
        clone: function () {
          return this.init.prototype.extend(this)
        }
      },
      n = j.WordArray = f.extend({
        init: function (a, c) {
          a = this.words = a || [];
          this.sigBytes = c != m ? c : 4 * a.length
        },
        toString: function (a) {
          return (a || h).stringify(this)
        },
        concat: function (a) {
          var c = this.words,
            q = a.words,
            d = this.sigBytes;
          a = a.sigBytes;
          this.clamp();
          if (d % 4)
            for (var b = 0; b < a; b++) c[d + b >>> 2] |= (q[b >>> 2] >>> 24 - 8 * (b % 4) & 255) << 24 - 8 * ((d + b) % 4);
          else if (65535 < q.length)
            for (b = 0; b < a; b += 4) c[d + b >>> 2] = q[b >>> 2];
          else c.push.apply(c, q);
          this.sigBytes += a;
          return this
        },
        clamp: function () {
          var a = this.words,
            c = this.sigBytes;
          a[c >>> 2] &= 4294967295 << 32 - 8 * (c % 4);
          a.length = e.ceil(c / 4)
        },
        clone: function () {
          var a = f.clone.call(this);
          a.words = this.words.slice(0);
          return a
        },
        random: function (a) {
          for (var c = [], b = 0; b < a; b += 4) c.push(4294967296 * e.random() | 0);
          return new n.init(c, a)
        }
      }),
      b = p.enc = {},
      h = b.Hex = {
        stringify: function (a) {
          var c = a.words;
          a = a.sigBytes;
          for (var b = [], d = 0; d < a; d++) {
            var f = c[d >>> 2] >>> 24 - 8 * (d % 4) & 255;
            b.push((f >>> 4).toString(16));
            b.push((f & 15).toString(16))
          }
          return b.join("")
        },
        parse: function (a) {
          for (var c = a.length,
              b = [], d = 0; d < c; d += 2) b[d >>> 3] |= parseInt(a.substr(d, 2), 16) << 24 - 4 * (d % 8);
          return new n.init(b, c / 2)
        }
      },
      g = b.Latin1 = {
        stringify: function (a) {
          var c = a.words;
          a = a.sigBytes;
          for (var b = [], d = 0; d < a; d++) b.push(String.fromCharCode(c[d >>> 2] >>> 24 - 8 * (d % 4) & 255));
          return b.join("")
        },
        parse: function (a) {
          for (var c = a.length,
              b = [], d = 0; d < c; d++) b[d >>> 2] |= (a.charCodeAt(d) & 255) << 24 - 8 * (d % 4);
          return new n.init(b, c)
        }
      },
      r = b.Utf8 = {
        stringify: function (a) {
          try {
            return decodeURIComponent(escape(g.stringify(a)))
          } catch (c) {
            throw Error("Malformed UTF-8 data");
          }
        },
        parse: function (a) {
          return g.parse(unescape(encodeURIComponent(a)))
        }
      },
      k = j.BufferedBlockAlgorithm = f.extend({
        reset: function () {
          this._data = new n.init;
          this._nDataBytes = 0
        },
        _append: function (a) {
          "string" == typeof a && (a = r.parse(a));
          this._data.concat(a);
          this._nDataBytes += a.sigBytes
        },
        _process: function (a) {
          var c = this._data,
            b = c.words,
            d = c.sigBytes,
            f = this.blockSize,
            h = d / (4 * f),
            h = a ? e.ceil(h) : e.max((h | 0) - this._minBufferSize, 0);
          a = h * f;
          d = e.min(4 * a, d);
          if (a) {
            for (var g = 0; g < a; g += f) this._doProcessBlock(b, g);
            g = b.splice(0, a);
            c.sigBytes -= d
          }
          return new n.init(g, d)
        },
        clone: function () {
          var a = f.clone.call(this);
          a._data = this._data.clone();
          return a
        },
        _minBufferSize: 0
      });
    j.Hasher = k.extend({
      cfg: f.extend(),
      init: function (a) {
        this.cfg = this.cfg.extend(a);
        this.reset()
      },
      reset: function () {
        k.reset.call(this);
        this._doReset()
      },
      update: function (a) {
        this._append(a);
        this._process();
        return this
      },
      finalize: function (a) {
        a && this._append(a);
        return this._doFinalize()
      },
      blockSize: 16,
      _createHelper: function (a) {
        return function (c, b) {
          return (new a.init(b)).finalize(c)
        }
      },
      _createHmacHelper: function (a) {
        return function (b, f) {
          return (new s.HMAC.init(a, f)).finalize(b)
        }
      }
    });
    var s = p.algo = {};
    return p
  }(Math);

  (function () {
    var e = CryptoJS,
      m = e.lib,
      p = m.WordArray,
      j = m.Hasher,
      l = [],
      m = e.algo.SHA1 = j.extend({
        _doReset: function () {
          this._hash = new p.init([1732584193, 4023233417, 2562383102, 271733878, 3285377520])
        },
        _doProcessBlock: function (f, n) {
          for (var b = this._hash.words,
              h = b[0], g = b[1], e = b[2], k = b[3], j = b[4], a = 0; 80 > a; a++) {
            if (16 > a) l[a] = f[n + a] | 0;
            else {
              var c = l[a - 3] ^ l[a - 8] ^ l[a - 14] ^ l[a - 16];
              l[a] = c << 1 | c >>> 31
            }
            c = (h << 5 | h >>> 27) + j + l[a];
            c = 20 > a ? c + ((g & e | ~g & k) + 1518500249) : 40 > a ? c + ((g ^ e ^ k) + 1859775393) : 60 > a ? c + ((g & e | g & k | e & k) - 1894007588) : c + ((g ^ e ^ k) - 899497514);
            j = k;
            k = e;
            e = g << 30 | g >>> 2;
            g = h;
            h = c
          }
          b[0] = b[0] + h | 0;
          b[1] = b[1] + g | 0;
          b[2] = b[2] + e | 0;
          b[3] = b[3] + k | 0;
          b[4] = b[4] + j | 0
        },
        _doFinalize: function () {
          var f = this._data,
            e = f.words,
            b = 8 * this._nDataBytes,
            h = 8 * f.sigBytes;
          e[h >>> 5] |= 128 << 24 - h % 32;
          e[(h + 64 >>> 9 << 4) + 14] = Math.floor(b / 4294967296);
          e[(h + 64 >>> 9 << 4) + 15] = b;
          f.sigBytes = 4 * e.length;
          this._process();
          return this._hash
        },
        clone: function () {
          var e = j.clone.call(this);
          e._hash = this._hash.clone();
          return e
        }
      });
    e.SHA1 = j._createHelper(m);
    e.HmacSHA1 = j._createHmacHelper(m)
  })();

    function _log(msg) {
        var curFuncIdentifier = __WeixinPrefecherJSBridge.log;
        if (curFuncIdentifier !== _logIdentifier) {
          return;
        }
        _call('log', {
          'msg': msg
        });
    }

    function _sendMessage(message) {
        _sendMessageQueue.push(message);
        var fetchQueueMsg = _fetchQueue();
        __wxPrefetcher._sendMessage(fetchQueueMsg);
    };


    function _fetchQueue() {
        var curFuncIdentifier = __WeixinPrefecherJSBridge._fetchQueue;
        if (curFuncIdentifier !== _fetchQueueIdentifier) {
            return '';
        }
        var messageQueueString = JSON.stringify(_sendMessageQueue);

        if (isDgtVerifyEnabled) {
          var arr = new Array;
          arr[0] = messageQueueString;
          arr[1] = _xxyy;
          var str = arr.join("");
          var msgSha = '';

          var shaObj = CryptoJS.SHA1(str);
          msgSha = shaObj.toString();

          var retMap = {};
          retMap[_JSON_MESSAGE] = _sendMessageQueue;
          retMap[_SHA_KEY] = msgSha;
          messageQueueString = JSON.stringify(retMap);
        }
        _sendMessageQueue = [];
        return messageQueueString
    };

    function _handleMessageFromWeixin(originMessage) {
        var curFuncIdentifier = __WeixinPrefecherJSBridge._handleMessageFromWeixin;

        if (curFuncIdentifier !== _handleMessageIdentifier) {
            return '{}';
        }

        var message;
        if (isDgtVerifyEnabled) {
          var realMessage = originMessage[_JSON_MESSAGE];
          if('sys:updateRandomStr' == realMessage[_EVENT_ID]) {
            _xxyy = realMessage["randomStr"]
            return "{}";
          }
          var shaStr = originMessage[_SHA_KEY];
          var arr = new Array;
          arr[0] = JSON.stringify(realMessage);
          arr[1] = _xxyy;
          var str = arr.join("");
          var msgSha = '';
          var shaObj = CryptoJS.SHA1(str);
          msgSha = shaObj.toString();
          if (msgSha !== shaStr) {
            _log('_handleMessageFromWeixin , shaStr : ' + shaStr + ' , str : ' + str + ' , msgSha : ' + msgSha);
            return '{}';
          }
          message = realMessage;
        }
        else {
          _log('_handleMessageFromWeixin isDgtVerifyEnabled is false');
          message = originMessage;
        }

        var ret;
        if (typeof message[_CALLBACK_ID] === 'string' && typeof _callback_map[message[_CALLBACK_ID]] === 'function') {
            ret = _callback_map[message[_CALLBACK_ID]](message['__params']);
            delete _callback_map[message[_CALLBACK_ID]]; // can only call once
            return JSON.stringify(ret);
        }
        return JSON.stringify({
            '__err_code': 'cb404'
        });
    };



    function _call(func, params, callback) {
        var curFuncIdentifier = __WeixinPrefecherJSBridge.invoke;
        if (curFuncIdentifier !== _callIdentifier) {
            return;
        }
        if (!func || typeof func !== 'string') {
            return;
        }
        if (typeof params !== 'object') {
            params = {};
        }

        var callbackID = (_callback_count++).toString();

        if (typeof callback === 'function') {
            _callback_map[callbackID] = callback;
        }

        var msgObj = {
            'func': func,
            'params': params
        };
        msgObj[_CALLBACK_ID] = callbackID;

        _sendMessage(JSON.stringify(msgObj));
    };


    var __WeixinPrefecherJSBridge = {
        // public
        invoke: _call,
        // private
        _fetchQueue: _fetchQueue,
        log: _log
    };

    try {
        Object.defineProperty(__WeixinPrefecherJSBridge, '_handleMessageFromWeixin', {
            value: _handleMessageFromWeixin,
            writable: false,
            configurable: false
        })
    } catch (e) {
        return;
    }

    if (!window.WeixinPrefecherJSBridge) {
        try {
            Object.defineProperty(window, 'WeixinPrefecherJSBridge', {
                value: __WeixinPrefecherJSBridge,
                writable: false,
                configurable: false
            })
        } catch (e) {
            return;
        }
    }
})();
