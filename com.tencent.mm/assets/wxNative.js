;var injectNativateRet = "ok";
if (typeof wx !== 'undefined') {
  if (typeof wxNative === 'undefined' && wx.getBaseMethods) {
    wxNative = function () {
      var _baseMethods = wx.getBaseMethods();

      var _invokeMethod = _baseMethods.invokeMethod;
      var _onMethod = _baseMethods.onMethod;

      var _openWCPayOverseaPaymentReceive = function (args) {
        _invokeMethod("openWCPayOverseaPaymentReceive", args);
      };

      var _requestOfflineUserBindQuery = function (args) {
        _invokeMethod("requestOfflineUserBindQuery", args);
      };

      var _private_onWebPageUrlExposed = function(args) {
          _invokeMethod("private_onWebPageUrlExposed", args)
      };
      var _handleWCPayOverseaWalletBuffer = function (args) {
        _invokeMethod("handleWCPayOverseaWalletBuffer", args);
      };

      var _shareFinderEndorsementToFriend = function (args) {
        _invokeMethod("shareFinderEndorsementToFriend", args);
      }

      var _openFinderProfile = function (args) {
        _invokeMethod("openFinderProfile", args);
      }

      var _endorsementFinished = function (args) {
        _invokeMethod("endorsementFinished", args);
      }

      var _kvReport = function (args) {
        _invokeMethod("kvReport", args);
      }

      var _declareOriginalFinished = function (args) {
        _invokeMethod("declareOriginalFinished", args);
      }

      var _handleMPChannelAction = function (args) {
        _invokeMethod("handleMPChannelAction", args)
      }

      var _openWebViewUseFastLoad = function (args) {
        _invokeMethod("openWebViewUseFastLoad", args);
      };

      var _sendRedCoverAppMsg = function (args) {
        _invokeMethod("sendRedCoverAppMsg", args);
      };

      var _jumpRedPacketEnvelopeList = function (args) {
        _invokeMethod("jumpRedPacketEnvelopeList", args);
      };

      var _jumpRedPacketEnvelopePreview = function (args) {
        _invokeMethod("jumpRedPacketEnvelopePreview", args);
      };

      var _phoneBindCardEntry = function (args) {
          _invokeMethod("phoneBindCardEntry", args);
      };

      var _requestSnsPayment = function (args) {
          _invokeMethod("requestSnsPayment", args);
      };

      function transWxmlToHtml(url) {
        if (typeof url !== 'string') {
          return url;
        } else {
          var path = url.split('?')[0];
          var query = url.split('?')[1];
          path += '.html';

          if (typeof query !== 'undefined') {
            return path + "?" + query;
          } else {
            return path;
          }
        }
      }

      var _navigateToMiniProgram = function (args) {
        if (args.path) {
            args.path = transWxmlToHtml(args.path);
        }
        _invokeMethod("navigateToMiniProgram", args);
      };

      var _onWxNativeEvent = function (callback) {
        _onMethod('onWxNativeEvent', callback);
      };

      var _onUpdateChannelFeedsEvent = function (callback) {
        _onMethod('onUpdateChannelFeeds', callback);
      };

      var _onGetRecentUsageListResult = function (callback) {
         _onMethod('onGetRecentUsageListResult', callback);
      };

      var _saveSplashScreenshot = function(args) {
        _invokeMethod("saveSplashScreenshot", args)
      }
      var _hideSplashScreenshot = function(args) {
        _invokeMethod("hideSplashScreenshot", args)
      }

      var _removeSplashScreenshot = function(args) {
        _invokeMethod("removeSplashScreenshot", args)
      }

      var _getRecentUsageList = function(args) {
         _invokeMethod("getRecentUsageList", args)
      }

      var _operateRecentUsageList = function(args) {
         _invokeMethod("operateRecentUsageList", args)
      }

      var _openWCExDeviceList = function(args) {
          _invokeMethod("openWCExDeviceList", args)
      }

      var _checkStrangerContactListIsFriend = function(args) {
          _invokeMethod("checkStrangerContactListIsFriend", args)
      }

      var _openTextStateMessage = function(args) {
          _invokeMethod("openTextStateMessage", args)
      }

      var _openChannelsPostPage = function(args) {
          _invokeMethod("openChannelsPostPage", args)
      }

      var _openChannelsCreateContact = function(args) {
          _invokeMethod("openChannelsCreateContact", args)
      }

      var _recordOperateUserDataInWa = function(args) {
          _invokeMethod("recordOperateUserDataInWa", args)
      }


      /**** Add JsApi Here ****/

      var methodsList = {
        openWCPayOverseaPaymentReceive: _openWCPayOverseaPaymentReceive,
        requestOfflineUserBindQuery: _requestOfflineUserBindQuery,
        private_onWebPageUrlExposed: _private_onWebPageUrlExposed,
        handleWCPayOverseaWalletBuffer: _handleWCPayOverseaWalletBuffer,
        navigateToMiniProgram: _navigateToMiniProgram,
        shareFinderEndorsementToFriend : _shareFinderEndorsementToFriend,
        openFinderProfile : _openFinderProfile,
        endorsementFinished : _endorsementFinished,
        kvReport : _kvReport,
        declareOriginalFinished : _declareOriginalFinished,
        saveSplashScreenshot : _saveSplashScreenshot,
        hideSplashScreenshot : _hideSplashScreenshot,
        removeSplashScreenshot : _removeSplashScreenshot,
        handleMPChannelAction : _handleMPChannelAction,
        openWebViewUseFastLoad : _openWebViewUseFastLoad,
        getRecentUsageList: _getRecentUsageList,
        operateRecentUsageList: _operateRecentUsageList,
        openWCExDeviceList: _openWCExDeviceList,
        openChannelsPostPage: _openChannelsPostPage,
        openChannelsCreateContact: _openChannelsCreateContact,
        openWCExDeviceList: _openWCExDeviceList,
        sendRedCoverAppMsg: _sendRedCoverAppMsg,
        jumpRedPacketEnvelopeList: _jumpRedPacketEnvelopeList,
        jumpRedPacketEnvelopePreview: _jumpRedPacketEnvelopePreview,
        openTextStateMessage: _openTextStateMessage,
        checkStrangerContactListIsFriend: _checkStrangerContactListIsFriend,
        phoneBindCardEntry: _phoneBindCardEntry,
        requestSnsPayment: _requestSnsPayment,
        recordOperateUserDataInWa : _recordOperateUserDataInWa,
      };
      /**** Add JsApiEvent Here ****/

      var eventList = {
        onWxNativeEvent: _onWxNativeEvent,
        onUpdateChannelFeedsEvent: _onUpdateChannelFeedsEvent,
        onGetRecentUsageListResult: _onGetRecentUsageListResult
      };
      /**** canIUse ****/

      var canIUse = function canIUse(name) {
        name = name || ''
        return !!methodsList[name];
      };

      return Object.assign({
        canIUse: canIUse
      }, methodsList, eventList);
    }();
    injectNativateRet = "ok"
  } else {
    injectNativateRet = "fail:init wxNative fail, already init"
  }
} else {
  injectNativateRet = "fail:init wxNative fail, wx is null"
}

injectNativateRet