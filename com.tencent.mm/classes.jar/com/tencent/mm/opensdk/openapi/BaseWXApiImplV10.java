package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.channel.a.a.a;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Req;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Resp;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Req;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Resp;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Req;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Req;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Resp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Req;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Resp;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Req;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Resp;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

class BaseWXApiImplV10
  implements IWXAPI
{
  protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  private static String wxappPayEntryClassname = null;
  protected String appId;
  protected boolean checkSignature = false;
  protected Context context;
  protected boolean detached = false;
  
  BaseWXApiImplV10(Context paramContext, String paramString, boolean paramBoolean)
  {
    Log.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + paramString + ", checkSignature = " + paramBoolean);
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
  }
  
  private boolean checkSumConsistent(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label67;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label67:
    return true;
  }
  
  private boolean createChatroom(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_create_chatroom_group_id", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_name", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_create_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private String getTokenFromWX(Context paramContext)
  {
    Object localObject = null;
    Cursor localCursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[] { this.appId, "620824064" }, null);
    paramContext = localObject;
    if (localCursor != null)
    {
      paramContext = localObject;
      if (localCursor.moveToFirst())
      {
        paramContext = localCursor.getString(0);
        Log.i("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX token is " + paramContext);
        localCursor.close();
      }
    }
    return paramContext;
  }
  
  private boolean handleWxInternalRespType(String paramString, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, extInfo = " + paramString);
    try
    {
      paramString = Uri.parse(paramString);
      Object localObject = paramString.getQueryParameter("wx_internal_resptype");
      Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, respType = " + (String)localObject);
      if (d.b((String)localObject))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, respType is null");
        return false;
      }
      String str;
      if (((String)localObject).equals("subscribemessage"))
      {
        localObject = new SubscribeMessage.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((SubscribeMessage.Resp)localObject).errCode = d.c(str);
        }
        ((SubscribeMessage.Resp)localObject).openId = paramString.getQueryParameter("openid");
        ((SubscribeMessage.Resp)localObject).templateID = paramString.getQueryParameter("template_id");
        ((SubscribeMessage.Resp)localObject).scene = d.c(paramString.getQueryParameter("scene"));
        ((SubscribeMessage.Resp)localObject).action = paramString.getQueryParameter("action");
        ((SubscribeMessage.Resp)localObject).reserved = paramString.getQueryParameter("reserved");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        return true;
      }
      if (((String)localObject).contains("invoice_auth_insert"))
      {
        localObject = new WXInvoiceAuthInsert.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((WXInvoiceAuthInsert.Resp)localObject).errCode = d.c(str);
        }
        ((WXInvoiceAuthInsert.Resp)localObject).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        return true;
      }
      if (((String)localObject).contains("payinsurance"))
      {
        localObject = new WXPayInsurance.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((WXPayInsurance.Resp)localObject).errCode = d.c(str);
        }
        ((WXPayInsurance.Resp)localObject).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        return true;
      }
      if (((String)localObject).contains("nontaxpay"))
      {
        localObject = new WXNontaxPay.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((WXNontaxPay.Resp)localObject).errCode = d.c(str);
        }
        ((WXNontaxPay.Resp)localObject).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        return true;
      }
      if (("subscribeminiprogrammsg".equals(localObject)) || ("5".equals(localObject)))
      {
        localObject = new SubscribeMiniProgramMsg.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((SubscribeMiniProgramMsg.Resp)localObject).errCode = d.c(str);
        }
        ((SubscribeMiniProgramMsg.Resp)localObject).openId = paramString.getQueryParameter("openid");
        ((SubscribeMiniProgramMsg.Resp)localObject).unionId = paramString.getQueryParameter("unionid");
        ((SubscribeMiniProgramMsg.Resp)localObject).nickname = paramString.getQueryParameter("nickname");
        ((SubscribeMiniProgramMsg.Resp)localObject).errStr = paramString.getQueryParameter("errmsg");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        return true;
      }
      Log.e("MicroMsg.SDK.WXApiImplV10", "this open sdk version not support the request type");
      return false;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, ex = " + paramString.getMessage());
    }
    return false;
  }
  
  private boolean joinChatroom(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_join_chatroom_group_id", ""), paramBundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_join_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendAddCardToWX(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_add_card_to_wx_card_list"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendChooseCardFromWX(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[] { paramBundle.getString("_wxapi_choose_card_from_wx_card_app_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_location_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), paramBundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), paramBundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendHandleScanResult(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_scan_qrcode_result") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendInvoiceAuthInsert(Context paramContext, BaseReq paramBaseReq)
  {
    paramBaseReq = (WXInvoiceAuthInsert.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "2", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendJumpToBizProfileReq(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_scene"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendJumpToBizTempSessionReq(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_webview_req_session_from"), paramBundle.getInt("_wxapi_jump_to_biz_webview_req_show_type") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendJumpToBizWebviewReq(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_webview_req_scene") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendJumpToOfflinePayReq(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[] { this.appId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendLaunchWXMiniprogram(Context paramContext, BaseReq paramBaseReq)
  {
    paramBaseReq = (WXLaunchMiniProgram.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[] { this.appId, paramBaseReq.userName, paramBaseReq.path, paramBaseReq.miniprogramType, paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendNonTaxPay(Context paramContext, BaseReq paramBaseReq)
  {
    paramBaseReq = (WXNontaxPay.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "3", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenBusiLuckyMoney(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), paramBundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), paramBundle.getString("_wxapi_open_busi_lucky_money_signType"), paramBundle.getString("_wxapi_open_busi_lucky_money_signature"), paramBundle.getString("_wxapi_open_busi_lucky_money_package") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenBusinessWebview(Context paramContext, BaseReq paramBaseReq)
  {
    WXOpenBusinessWebview.Req localReq = (WXOpenBusinessWebview.Req)paramBaseReq;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
    paramBaseReq = "";
    paramContext = paramBaseReq;
    if (localReq.queryInfo != null)
    {
      paramContext = paramBaseReq;
      if (localReq.queryInfo.size() > 0) {
        paramContext = new JSONObject(localReq.queryInfo).toString();
      }
    }
    paramContext = localContentResolver.query(localUri, null, null, new String[] { this.appId, localReq.businessType, paramContext }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenRankListReq(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenWebview(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_webview_url"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendPayInSurance(Context paramContext, BaseReq paramBaseReq)
  {
    paramBaseReq = (WXPayInsurance.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "4", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendPayReq(Context paramContext, Bundle paramBundle)
  {
    if (wxappPayEntryClassname == null)
    {
      wxappPayEntryClassname = new MMSharedPreferences(paramContext).getString("_wxapp_pay_entry_classname_", null);
      Log.d("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
      if (wxappPayEntryClassname == null) {}
      try
      {
        wxappPayEntryClassname = paramContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
        if (wxappPayEntryClassname == null)
        {
          Log.e("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + localException.getMessage());
        }
      }
    }
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.bundle = paramBundle;
    localArgs.targetPkgName = "com.tencent.mm";
    localArgs.targetClassName = wxappPayEntryClassname;
    return MMessageActV2.send(paramContext, localArgs);
  }
  
  private boolean sendSubscribeMessage(Context paramContext, BaseReq paramBaseReq)
  {
    paramBaseReq = (SubscribeMessage.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "1", String.valueOf(paramBaseReq.scene), paramBaseReq.templateID, paramBaseReq.reserved }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendSubscribeMiniProgramMsg(Context paramContext, BaseReq paramBaseReq)
  {
    paramBaseReq = (SubscribeMiniProgramMsg.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "5", paramBaseReq.miniProgramAppId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  public void detach()
  {
    Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    this.context = null;
  }
  
  public int getWXAppSupportAPI()
  {
    int i = 0;
    if (this.detached) {
      throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
    }
    if (!isWXAppInstalled()) {
      Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
    }
    int j;
    do
    {
      return i;
      j = new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
      i = j;
    } while (j != 0);
    try
    {
      i = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + localException.getMessage());
    }
    return j;
  }
  
  public boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    try
    {
      if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token"))
      {
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
        return false;
      }
      if (this.detached) {
        throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
      }
    }
    catch (Exception paramIntent)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = " + paramIntent.getMessage());
      return false;
    }
    Object localObject1 = paramIntent.getStringExtra("_mmessage_content");
    int i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
    Object localObject2 = paramIntent.getStringExtra("_mmessage_appPackage");
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
      return false;
    }
    if (!checkSumConsistent(paramIntent.getByteArrayExtra("_mmessage_checksum"), b.a((String)localObject1, i, (String)localObject2)))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
      return false;
    }
    i = paramIntent.getIntExtra("_wxapi_command_type", 0);
    Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, cmd = " + i);
    switch (i)
    {
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + i);
      return false;
      paramIWXAPIEventHandler.onResp(new SendAuth.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new SendMessageToWX.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onReq(new GetMessageFromWX.Req(paramIntent.getExtras()));
      return true;
      paramIntent = new ShowMessageFromWX.Req(paramIntent.getExtras());
      localObject2 = paramIntent.message.messageExt;
      boolean bool;
      if ((localObject2 != null) && (((String)localObject2).contains("wx_internal_resptype")))
      {
        bool = handleWxInternalRespType((String)localObject2, paramIWXAPIEventHandler);
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, extInfo contains wx_internal_resptype, ret = " + bool);
        return bool;
      }
      if (localObject2 != null)
      {
        bool = ((String)localObject2).contains("openbusinesswebview");
        if (!bool) {}
      }
      try
      {
        localObject1 = Uri.parse((String)localObject2);
        if ((localObject1 != null) && ("openbusinesswebview".equals(((Uri)localObject1).getHost())))
        {
          localObject2 = new WXOpenBusinessWebview.Resp();
          String str = ((Uri)localObject1).getQueryParameter("ret");
          if ((str != null) && (str.length() > 0)) {
            ((WXOpenBusinessWebview.Resp)localObject2).errCode = d.c(str);
          }
          ((WXOpenBusinessWebview.Resp)localObject2).resultInfo = ((Uri)localObject1).getQueryParameter("resultInfo");
          ((WXOpenBusinessWebview.Resp)localObject2).errStr = ((Uri)localObject1).getQueryParameter("errmsg");
          localObject1 = ((Uri)localObject1).getQueryParameter("type");
          if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
            ((WXOpenBusinessWebview.Resp)localObject2).businessType = d.c((String)localObject1);
          }
          paramIWXAPIEventHandler.onResp((BaseResp)localObject2);
          return true;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "not openbusinesswebview %" + (String)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.WXApiImplV10", "parse fail, ex = " + localException.getMessage());
        }
      }
      paramIWXAPIEventHandler.onReq(paramIntent);
      return true;
      paramIWXAPIEventHandler.onResp(new PayResp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onReq(new LaunchFromWX.Req(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new CreateChatroom.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new JoinChatroom.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new OpenWebview.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new HandleScanResult.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(paramIntent.getExtras()));
      return true;
      paramIWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(paramIntent.getExtras()));
      return true;
    }
  }
  
  public boolean isWXAppInstalled()
  {
    if (this.detached) {
      throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    }
    try
    {
      PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (localPackageInfo == null) {
        return false;
      }
      boolean bool = WXApiImplComm.validateAppSignature(this.context, localPackageInfo.signatures, this.checkSignature);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public boolean openWXApp()
  {
    if (this.detached) {
      throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }
    if (!isWXAppInstalled())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return false;
    }
    try
    {
      this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "startActivity fail, exception = " + localException.getMessage());
    }
    return false;
  }
  
  public boolean registerApp(String paramString)
  {
    return registerApp(paramString, 0L);
  }
  
  public boolean registerApp(String paramString, long paramLong)
  {
    if (this.detached) {
      throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
      return false;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + paramString);
    if (paramString != null) {
      this.appId = paramString;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + paramString);
    if (paramString != null) {
      this.appId = paramString;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
    paramString = new a.a();
    paramString.a = "com.tencent.mm";
    paramString.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
    paramString.content = ("weixin://registerapp?appid=" + this.appId);
    paramString.b = paramLong;
    return a.a(this.context, paramString);
  }
  
  public boolean sendReq(BaseReq paramBaseReq)
  {
    if (this.detached) {
      throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
      return false;
    }
    if (!paramBaseReq.checkArgs())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
      return false;
    }
    Log.i("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + paramBaseReq.getType());
    Bundle localBundle = new Bundle();
    paramBaseReq.toBundle(localBundle);
    if (paramBaseReq.getType() == 5) {
      return sendPayReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 7) {
      return sendJumpToBizProfileReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 8) {
      return sendJumpToBizWebviewReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 10) {
      return sendJumpToBizTempSessionReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 9) {
      return sendAddCardToWX(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 16) {
      return sendChooseCardFromWX(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 11) {
      return sendOpenRankListReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 12) {
      return sendOpenWebview(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 25) {
      return sendOpenBusinessWebview(this.context, paramBaseReq);
    }
    if (paramBaseReq.getType() == 13) {
      return sendOpenBusiLuckyMoney(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 14) {
      return createChatroom(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 15) {
      return joinChatroom(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 17) {
      return sendHandleScanResult(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 18) {
      return sendSubscribeMessage(this.context, paramBaseReq);
    }
    if (paramBaseReq.getType() == 23) {
      return sendSubscribeMiniProgramMsg(this.context, paramBaseReq);
    }
    if (paramBaseReq.getType() == 19) {
      return sendLaunchWXMiniprogram(this.context, paramBaseReq);
    }
    if (paramBaseReq.getType() == 20) {
      return sendInvoiceAuthInsert(this.context, paramBaseReq);
    }
    if (paramBaseReq.getType() == 21) {
      return sendNonTaxPay(this.context, paramBaseReq);
    }
    if (paramBaseReq.getType() == 22) {
      return sendPayInSurance(this.context, paramBaseReq);
    }
    if (paramBaseReq.getType() == 24) {
      return sendJumpToOfflinePayReq(this.context, localBundle);
    }
    SendMessageToWX.Req localReq;
    if ((paramBaseReq.getType() == 2) && (localBundle.getInt("_wxapi_sendmessagetowx_req_media_type") == 36))
    {
      localReq = (SendMessageToWX.Req)paramBaseReq;
      if (getWXAppSupportAPI() >= 620756993) {
        break label637;
      }
      localObject = new WXWebpageObject();
      ((WXWebpageObject)localObject).webpageUrl = localBundle.getString("_wxminiprogram_webpageurl");
      localReq.message.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
    }
    label637:
    WXMiniProgramObject localWXMiniProgramObject;
    do
    {
      if (localReq.scene != 3) {
        localReq.scene = 0;
      }
      paramBaseReq.toBundle(localBundle);
      paramBaseReq = getTokenFromWX(this.context);
      localObject = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject).bundle = localBundle;
      ((MMessageActV2.Args)localObject).content = ("weixin://sendreq?appid=" + this.appId);
      ((MMessageActV2.Args)localObject).targetPkgName = "com.tencent.mm";
      ((MMessageActV2.Args)localObject).targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
      ((MMessageActV2.Args)localObject).token = paramBaseReq;
      return MMessageActV2.send(this.context, (MMessageActV2.Args)localObject);
      localWXMiniProgramObject = (WXMiniProgramObject)localReq.message.mediaObject;
      localWXMiniProgramObject.userName += "@app";
      localObject = localWXMiniProgramObject.path;
    } while (d.b((String)localObject));
    Object localObject = ((String)localObject).split("\\?");
    if (localObject.length > 1) {}
    for (localObject = localObject[0] + ".html?" + localObject[1];; localObject = localObject[0] + ".html")
    {
      localWXMiniProgramObject.path = ((String)localObject);
      break;
    }
  }
  
  public boolean sendResp(BaseResp paramBaseResp)
  {
    if (this.detached) {
      throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
      return false;
    }
    if (!paramBaseResp.checkArgs())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
      return false;
    }
    Bundle localBundle = new Bundle();
    paramBaseResp.toBundle(localBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.bundle = localBundle;
    paramBaseResp.content = ("weixin://sendresp?appid=" + this.appId);
    paramBaseResp.targetPkgName = "com.tencent.mm";
    paramBaseResp.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    return MMessageActV2.send(this.context, paramBaseResp);
  }
  
  public void setLogImpl(ILog paramILog)
  {
    Log.setLogImpl(paramILog);
  }
  
  public void unregisterApp()
  {
    if (this.detached) {
      throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
      return;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
      return;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
    a.a locala = new a.a();
    locala.a = "com.tencent.mm";
    locala.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
    locala.content = ("weixin://unregisterapp?appid=" + this.appId);
    a.a(this.context, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.BaseWXApiImplV10
 * JD-Core Version:    0.7.0.1
 */