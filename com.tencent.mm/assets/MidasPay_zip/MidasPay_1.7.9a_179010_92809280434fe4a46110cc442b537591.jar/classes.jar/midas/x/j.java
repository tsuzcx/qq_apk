package midas.x;

import android.app.Activity;
import android.text.TextUtils;
import com.pay.api.APAndroidPayAPI;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  public static String a = "!function(){function e(e,r){\"function\"==typeof o[e]&&o[e](r)}function r(e,r){switch(r||(r=\"iframe\"),r){case\"iframe\":a.src=\"Midas://\"+JSON.stringify(e);break;case\"alert\":alert(\"midas_js_bridge_\"+JSON.stringify(e));break;default:console.log&&console.log(\"_send_type error\")}}var a,t={uuid:function(e){var r,a,t=\"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\".split(\"\"),c=[];for(c[8]=c[13]=c[18]=c[23]=\"-\",c[14]=\"4\",r=0;36>r;++r)c[r]||(a=0|16*Math.random(),c[r]=t[19==r?3&a|8:a]);return c.join(\"\")+(e?\"-\"+Date.now():\"\")},base64:{encode:function(e){if(void 0===e)return e;var r,a,t,c,n,o;for(t=e.length,a=0,r=\"\";t>a;){if(c=255&e.charCodeAt(a++),a==t){r+=base64encodechars.charAt(c>>2),r+=base64encodechars.charAt((3&c)<<4),r+=\"==\";break}if(n=e.charCodeAt(a++),a==t){r+=base64encodechars.charAt(c>>2),r+=base64encodechars.charAt((3&c)<<4|(240&n)>>4),r+=base64encodechars.charAt((15&n)<<2),r+=\"=\";break}o=e.charCodeAt(a++),r+=base64encodechars.charAt(c>>2),r+=base64encodechars.charAt((3&c)<<4|(240&n)>>4),r+=base64encodechars.charAt((15&n)<<2|(192&o)>>6),r+=base64encodechars.charAt(63&o)}return r}},utf8:{encode:function(e){e=e.replace(/\\r\\n/g,\"\\n\");for(var r=\"\",a=0;a<e.length;a++){var t=e.charCodeAt(a);128>t?r+=String.fromCharCode(t):t>127&&2048>t?(r+=String.fromCharCode(t>>6|192),r+=String.fromCharCode(63&t|128)):(r+=String.fromCharCode(t>>12|224),r+=String.fromCharCode(t>>6&63|128),r+=String.fromCharCode(63&t|128))}return r},decode:function(e){for(var r=\"\",a=0,t=c1=c2=0;a<e.length;)t=e.charCodeAt(a),128>t?(r+=String.fromCharCode(t),a++):t>191&&224>t?(c2=e.charCodeAt(a+1),r+=String.fromCharCode((31&t)<<6|63&c2),a+=2):(c2=e.charCodeAt(a+1),c3=e.charCodeAt(a+2),r+=String.fromCharCode((15&t)<<12|(63&c2)<<6|63&c3),a+=3);return r}}},c=window.MidasJSBridge={},n={},o={};c.call=function(e,a,c){if(e&&\"string\"==typeof e){\"object\"!=typeof a&&(a={});var o=t.uuid(!0);\"function\"==typeof c&&(n[o]=c);var i={__msg_type:\"call\",__callback_id:o,func:e,params:a};r(i,\"alert\")}},c.callSync=function(e,r){var a={__msg_type:\"call\",func:e,params:r};return prompt(JSON.stringify(a))},c.on=function(e,r){e&&\"string\"==typeof e&&\"function\"==typeof r&&(o[e]=r)},c._handleMsgFromMidas=function(r){switch(r.__msg_type){case\"callback\":if(\"string\"==typeof r.__callback_id&&\"function\"==typeof n[r.__callback_id]){var a=n[r.__callback_id](r.params);delete n[r.__callback_id]}return JSON.stringify({__err_code:\"cb404\"});case\"event\":return\"string\"==typeof r.__event_id&&\"function\"==typeof o[r.__event_id]&&(a=e(r.__event_id,r.params)),JSON.stringify({__err_code:\"ev404\"})}};var i=document.createEvent(\"Events\");i.initEvent(\"MidasJSBridgeReady\"),document.dispatchEvent(i)}();";
  public static String b = "";
  public static String c = "launchSign";
  public static String d = "1.0.1";
  public static String e = "5.0.1";
  public static String f = "!function(){function a(a,b){\"function\"==typeof i[a]&&i[a](b)}function b(a,b){switch(b||(b=\"iframe\"),b){case\"iframe\":d.src=\"WSJPay://\"+JSON.stringify(a);break;case\"alert\":alert(\"WSJPay_js_bridge_\"+JSON.stringify(a));break;default:console.log&&console.log(\"_send_type error\")}}function c(a){void 0===a&&(a={__err_code:\"rp404\"}),a.__scene||(a.__scene=\"SCENE_HANDLEMSGFROMJS\"),_setResultIframe.src=\"WSJPay://\"+e.base64.encode(e.utf8.encode(a))}var d,e={base64:{encode:function(a){if(void 0===a)return a;var b,c,d,e,f,g;for(d=a.length,c=0,b=\"\";d>c;){if(e=255&a.charCodeAt(c++),c==d){b+=base64encodechars.charAt(e>>2),b+=base64encodechars.charAt((3&e)<<4),b+=\"==\";break}if(f=a.charCodeAt(c++),c==d){b+=base64encodechars.charAt(e>>2),b+=base64encodechars.charAt((3&e)<<4|(240&f)>>4),b+=base64encodechars.charAt((15&f)<<2),b+=\"=\";break}g=a.charCodeAt(c++),b+=base64encodechars.charAt(e>>2),b+=base64encodechars.charAt((3&e)<<4|(240&f)>>4),b+=base64encodechars.charAt((15&f)<<2|(192&g)>>6),b+=base64encodechars.charAt(63&g)}return b}},utf8:{encode:function(a){a=a.replace(/\\r\\n/g,\"\\n\");for(var b=\"\",c=0;c<a.length;c++){var d=a.charCodeAt(c);128>d?b+=String.fromCharCode(d):d>127&&2048>d?(b+=String.fromCharCode(d>>6|192),b+=String.fromCharCode(63&d|128)):(b+=String.fromCharCode(d>>12|224),b+=String.fromCharCode(d>>6&63|128),b+=String.fromCharCode(63&d|128))}return b},decode:function(a){for(var b=\"\",c=0,d=c1=c2=0;c<a.length;)d=a.charCodeAt(c),128>d?(b+=String.fromCharCode(d),c++):d>191&&224>d?(c2=a.charCodeAt(c+1),b+=String.fromCharCode((31&d)<<6|63&c2),c+=2):(c2=a.charCodeAt(c+1),c3=a.charCodeAt(c+2),b+=String.fromCharCode((15&d)<<12|(63&c2)<<6|63&c3),c+=3);return b}}},f=window.WSJPayJSBridge={},g=1e4,h={},i={};f.call=function(a,c,d){if(a&&\"string\"==typeof a){\"object\"!=typeof c&&(c={});var e=(g++).toString();\"function\"==typeof d&&(h[e]=d);var f={__msg_type:\"call\",__callback_id:e,func:a,params:c};b(f,\"alert\")}},f.on=function(a,b){a&&\"string\"==typeof a&&\"function\"==typeof b&&(i[a]=b)},f._handleMsgFromWSJPay=function(b){switch(b.__msg_type){case\"callback\":if(\"string\"==typeof b.__callback_id&&\"function\"==typeof h[b.__callback_id]){var d=h[b.__callback_id](b.params);return delete h[b.__callback_id],g--,c(d),JSON.stringify(d)}return c({__err_code:\"cb404\"}),JSON.stringify({__err_code:\"cb404\"});case\"event\":if(\"string\"==typeof b.__event_id&&\"function\"==typeof i[b.__event_id]){var d=a(b.__event_id,b.params);return c(d),JSON.stringify(d)}return c({__err_code:\"ev404\"}),JSON.stringify({__err_code:\"ev404\"})}};var j=document.createEvent(\"Events\");j.initEvent(\"WSJPayJSBridgeReady\"),document.dispatchEvent(j)}();/*  |xGv00|72c867bfaaddc7751d60fcdb2f7a7a1d */";
  
  public static int a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("midas_js_bridge_")))
    {
      b = paramString2.substring(16);
      try
      {
        paramString1 = new JSONObject(b);
        a(paramActivity, paramString1.getString("func"), new JSONObject(paramString1.getString("params")));
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
      }
      return 0;
    }
    return -1;
  }
  
  public static void a(Activity paramActivity, String paramString, JSONObject paramJSONObject)
  {
    if (c.equals(paramString)) {
      APAndroidPayAPI.launchSign(paramActivity, paramJSONObject);
    }
  }
  
  public String a()
  {
    if (c())
    {
      APLog.i("APMidasJS", "getJSContent isWSJSDK");
      return f;
    }
    return a;
  }
  
  public String b()
  {
    if (c())
    {
      APLog.i("APMidasJS", "getJSVersion isWSJSDK");
      return e;
    }
    return d;
  }
  
  public final boolean c()
  {
    try
    {
      try
      {
        Class.forName("com.tencent.midas.control.APMidasPayHelper").getDeclaredField("wsjIdentify");
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isWSJ3 e:");
        localStringBuilder.append(localException.toString());
        APLog.i("APMidasJS", localStringBuilder.toString());
      }
      return true;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isWSJ2 e:");
      localStringBuilder.append(localNoSuchFieldException.toString());
      APLog.i("APMidasJS", localStringBuilder.toString());
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isWSJ1 e:");
      localStringBuilder.append(localClassNotFoundException.toString());
      APLog.i("APMidasJS", localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j
 * JD-Core Version:    0.7.0.1
 */