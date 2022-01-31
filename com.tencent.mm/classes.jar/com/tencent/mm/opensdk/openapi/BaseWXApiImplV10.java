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
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Req;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class BaseWXApiImplV10
  implements IWXAPI
{
  protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  private static String wxappPayEntryClassname = null;
  protected String appId;
  protected boolean checkSignature;
  protected Context context;
  protected boolean detached;
  private int wxSdkVersion;
  
  BaseWXApiImplV10(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(128102);
    this.checkSignature = false;
    this.detached = false;
    Log.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + paramString + ", checkSignature = " + paramBoolean);
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
    AppMethodBeat.o(128102);
  }
  
  private boolean checkSumConsistent(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(128137);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
      AppMethodBeat.o(128137);
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
      AppMethodBeat.o(128137);
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        AppMethodBeat.o(128137);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(128137);
    return true;
  }
  
  private boolean createChatroom(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128124);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_create_chatroom_group_id", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_name", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_create_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128124);
    return true;
  }
  
  private String getTokenFromWX(Context paramContext)
  {
    AppMethodBeat.i(128112);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[] { this.appId, "620954624" }, null);
    if ((paramContext != null) && (paramContext.moveToFirst()))
    {
      String str = paramContext.getString(0);
      Log.i("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX token is ".concat(String.valueOf(str)));
      paramContext.close();
      AppMethodBeat.o(128112);
      return str;
    }
    AppMethodBeat.o(128112);
    return null;
  }
  
  private boolean handleWxInternalRespType(String paramString, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    AppMethodBeat.i(128107);
    Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, extInfo = ".concat(String.valueOf(paramString)));
    try
    {
      paramString = Uri.parse(paramString);
      Object localObject = paramString.getQueryParameter("wx_internal_resptype");
      Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, respType = ".concat(String.valueOf(localObject)));
      if (d.b((String)localObject))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, respType is null");
        AppMethodBeat.o(128107);
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
        AppMethodBeat.o(128107);
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
        AppMethodBeat.o(128107);
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
        AppMethodBeat.o(128107);
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
        AppMethodBeat.o(128107);
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
        AppMethodBeat.o(128107);
        return true;
      }
      Log.e("MicroMsg.SDK.WXApiImplV10", "this open sdk version not support the request type");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, ex = " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(128107);
    return false;
  }
  
  private boolean joinChatroom(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128125);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_join_chatroom_group_id", ""), paramBundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_join_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128125);
    return true;
  }
  
  private boolean sendAddCardToWX(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128117);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_add_card_to_wx_card_list"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128117);
    return true;
  }
  
  private boolean sendChooseCardFromWX(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[] { paramBundle.getString("_wxapi_choose_card_from_wx_card_app_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_location_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), paramBundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), paramBundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128118);
    return true;
  }
  
  private boolean sendHandleScanResult(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128126);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_scan_qrcode_result") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128126);
    return true;
  }
  
  private boolean sendInvoiceAuthInsert(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128129);
    paramBaseReq = (WXInvoiceAuthInsert.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "2", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128129);
    return true;
  }
  
  private boolean sendJumpToBizProfileReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128114);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_scene"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128114);
    return true;
  }
  
  private boolean sendJumpToBizTempSessionReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128116);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_webview_req_session_from"), paramBundle.getInt("_wxapi_jump_to_biz_webview_req_show_type") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128116);
    return true;
  }
  
  private boolean sendJumpToBizWebviewReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128115);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_webview_req_scene") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128115);
    return true;
  }
  
  private boolean sendJumpToOfflinePayReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128122);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[] { this.appId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128122);
    return true;
  }
  
  private boolean sendLaunchWXMiniprogram(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128132);
    paramBaseReq = (WXLaunchMiniProgram.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[] { this.appId, paramBaseReq.userName, paramBaseReq.path, paramBaseReq.miniprogramType, paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128132);
    return true;
  }
  
  private boolean sendNonTaxPay(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128130);
    paramBaseReq = (WXNontaxPay.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "3", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128130);
    return true;
  }
  
  private boolean sendOpenBusiLuckyMoney(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128123);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), paramBundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), paramBundle.getString("_wxapi_open_busi_lucky_money_signType"), paramBundle.getString("_wxapi_open_busi_lucky_money_signature"), paramBundle.getString("_wxapi_open_busi_lucky_money_package") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128123);
    return true;
  }
  
  private boolean sendOpenBusinessView(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128133);
    paramBaseReq = (WXOpenBusinessView.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[] { this.appId, paramBaseReq.businessType, paramBaseReq.query, paramBaseReq.extInfo }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128133);
    return true;
  }
  
  private boolean sendOpenBusinessWebview(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128121);
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
    AppMethodBeat.o(128121);
    return true;
  }
  
  private boolean sendOpenRankListReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128119);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128119);
    return true;
  }
  
  private boolean sendOpenWebview(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128120);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_webview_url"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128120);
    return true;
  }
  
  private boolean sendPayInSurance(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128131);
    paramBaseReq = (WXPayInsurance.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "4", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128131);
    return true;
  }
  
  private boolean sendPayReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(128113);
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
          AppMethodBeat.o(128113);
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
    boolean bool = MMessageActV2.send(paramContext, localArgs);
    AppMethodBeat.o(128113);
    return bool;
  }
  
  private boolean sendSubscribeMessage(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128127);
    paramBaseReq = (SubscribeMessage.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "1", String.valueOf(paramBaseReq.scene), paramBaseReq.templateID, paramBaseReq.reserved }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128127);
    return true;
  }
  
  private boolean sendSubscribeMiniProgramMsg(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128128);
    paramBaseReq = (SubscribeMiniProgramMsg.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "5", paramBaseReq.miniProgramAppId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(128128);
    return true;
  }
  
  public void detach()
  {
    AppMethodBeat.i(128135);
    Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    this.context = null;
    AppMethodBeat.o(128135);
  }
  
  public int getWXAppSupportAPI()
  {
    AppMethodBeat.i(128109);
    if (this.detached)
    {
      localObject = new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128109);
      throw ((Throwable)localObject);
    }
    if (!isWXAppInstalled())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      AppMethodBeat.o(128109);
      return 0;
    }
    this.wxSdkVersion = 0;
    Object localObject = new CountDownLatch(1);
    new Thread(new BaseWXApiImplV10.1(this, (CountDownLatch)localObject)).run();
    try
    {
      ((CountDownLatch)localObject).await(1000L, TimeUnit.MILLISECONDS);
      Log.d("MicroMsg.SDK.WXApiImplV10", "_build_info_sdk_int_ = " + this.wxSdkVersion);
      if (this.wxSdkVersion != 0) {}
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
        Log.d("MicroMsg.SDK.WXApiImplV10", "OPEN_SDK_VERSION = " + this.wxSdkVersion);
        int i = this.wxSdkVersion;
        AppMethodBeat.o(128109);
        return i;
        localInterruptedException = localInterruptedException;
        Log.w("MicroMsg.SDK.WXApiImplV10", localInterruptedException.getMessage());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + localException.getMessage());
        }
      }
    }
  }
  
  public boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    AppMethodBeat.i(128106);
    try
    {
      if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token"))
      {
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
        AppMethodBeat.o(128106);
        return false;
      }
      if (!this.detached) {
        break label92;
      }
      paramIntent = new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128106);
      throw paramIntent;
    }
    catch (Exception paramIntent)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = " + paramIntent.getMessage());
    }
    AppMethodBeat.o(128106);
    return false;
    label92:
    Object localObject1 = paramIntent.getStringExtra("_mmessage_content");
    int i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
    Object localObject2 = paramIntent.getStringExtra("_mmessage_appPackage");
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
      AppMethodBeat.o(128106);
      return false;
    }
    if (!checkSumConsistent(paramIntent.getByteArrayExtra("_mmessage_checksum"), b.a((String)localObject1, i, (String)localObject2)))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
      AppMethodBeat.o(128106);
      return false;
    }
    i = paramIntent.getIntExtra("_wxapi_command_type", 0);
    Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, cmd = ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "unknown cmd = ".concat(String.valueOf(i)));
      break;
      paramIWXAPIEventHandler.onResp(new SendAuth.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new SendMessageToWX.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onReq(new GetMessageFromWX.Req(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIntent = new ShowMessageFromWX.Req(paramIntent.getExtras());
      localObject2 = paramIntent.message.messageExt;
      boolean bool;
      if ((localObject2 != null) && (((String)localObject2).contains("wx_internal_resptype")))
      {
        bool = handleWxInternalRespType((String)localObject2, paramIWXAPIEventHandler);
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, extInfo contains wx_internal_resptype, ret = ".concat(String.valueOf(bool)));
        AppMethodBeat.o(128106);
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
          AppMethodBeat.o(128106);
          return true;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "not openbusinesswebview %".concat(String.valueOf(localObject2)));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.WXApiImplV10", "parse fail, ex = " + localException.getMessage());
        }
      }
      paramIWXAPIEventHandler.onReq(paramIntent);
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new PayResp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onReq(new LaunchFromWX.Req(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new CreateChatroom.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new JoinChatroom.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new OpenWebview.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new HandleScanResult.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
      paramIWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(paramIntent.getExtras()));
      AppMethodBeat.o(128106);
      return true;
    }
  }
  
  public boolean isWXAppInstalled()
  {
    AppMethodBeat.i(128108);
    Object localObject;
    if (this.detached)
    {
      localObject = new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128108);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (localObject == null)
      {
        AppMethodBeat.o(128108);
        return false;
      }
      boolean bool = WXApiImplComm.validateAppSignature(this.context, ((PackageInfo)localObject).signatures, this.checkSignature);
      AppMethodBeat.o(128108);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(128108);
    }
    return false;
  }
  
  public boolean openWXApp()
  {
    AppMethodBeat.i(128110);
    if (this.detached)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128110);
      throw localIllegalStateException;
    }
    if (!isWXAppInstalled())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      AppMethodBeat.o(128110);
      return false;
    }
    try
    {
      this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
      AppMethodBeat.o(128110);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "startActivity fail, exception = " + localException.getMessage());
      AppMethodBeat.o(128110);
    }
    return false;
  }
  
  public boolean registerApp(String paramString)
  {
    AppMethodBeat.i(128103);
    boolean bool = registerApp(paramString, 0L);
    AppMethodBeat.o(128103);
    return bool;
  }
  
  public boolean registerApp(String paramString, long paramLong)
  {
    AppMethodBeat.i(128104);
    if (this.detached)
    {
      paramString = new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128104);
      throw paramString;
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
      AppMethodBeat.o(128104);
      return false;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = ".concat(String.valueOf(paramString)));
    if (paramString != null) {
      this.appId = paramString;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = ".concat(String.valueOf(paramString)));
    if (paramString != null) {
      this.appId = paramString;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
    paramString = new a.a();
    paramString.a = "com.tencent.mm";
    paramString.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
    paramString.content = ("weixin://registerapp?appid=" + this.appId);
    paramString.b = paramLong;
    boolean bool = a.a(this.context, paramString);
    AppMethodBeat.o(128104);
    return bool;
  }
  
  public boolean sendReq(BaseReq paramBaseReq)
  {
    AppMethodBeat.i(128111);
    if (this.detached)
    {
      paramBaseReq = new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128111);
      throw paramBaseReq;
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
      AppMethodBeat.o(128111);
      return false;
    }
    if (!paramBaseReq.checkArgs())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
      AppMethodBeat.o(128111);
      return false;
    }
    Log.i("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + paramBaseReq.getType());
    Bundle localBundle = new Bundle();
    paramBaseReq.toBundle(localBundle);
    boolean bool;
    if (paramBaseReq.getType() == 5)
    {
      bool = sendPayReq(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 7)
    {
      bool = sendJumpToBizProfileReq(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 8)
    {
      bool = sendJumpToBizWebviewReq(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 10)
    {
      bool = sendJumpToBizTempSessionReq(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 9)
    {
      bool = sendAddCardToWX(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 16)
    {
      bool = sendChooseCardFromWX(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 11)
    {
      bool = sendOpenRankListReq(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 12)
    {
      bool = sendOpenWebview(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 25)
    {
      bool = sendOpenBusinessWebview(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 13)
    {
      bool = sendOpenBusiLuckyMoney(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 14)
    {
      bool = createChatroom(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 15)
    {
      bool = joinChatroom(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 17)
    {
      bool = sendHandleScanResult(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 18)
    {
      bool = sendSubscribeMessage(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 23)
    {
      bool = sendSubscribeMiniProgramMsg(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 19)
    {
      bool = sendLaunchWXMiniprogram(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 26)
    {
      bool = sendOpenBusinessView(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 20)
    {
      bool = sendInvoiceAuthInsert(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 21)
    {
      bool = sendNonTaxPay(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 22)
    {
      bool = sendPayInSurance(this.context, paramBaseReq);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 24)
    {
      bool = sendJumpToOfflinePayReq(this.context, localBundle);
      AppMethodBeat.o(128111);
      return bool;
    }
    if (paramBaseReq.getType() == 2)
    {
      SendMessageToWX.Req localReq = (SendMessageToWX.Req)paramBaseReq;
      int i = localReq.message.getType();
      if (d.a(i))
      {
        if (getWXAppSupportAPI() >= 620756993) {
          break label836;
        }
        localObject = new WXWebpageObject();
        ((WXWebpageObject)localObject).webpageUrl = localBundle.getString("_wxminiprogram_webpageurl");
        localReq.message.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
      }
      label836:
      WXMiniProgramObject localWXMiniProgramObject;
      do
      {
        for (;;)
        {
          if (localReq.scene != 3) {
            localReq.scene = 0;
          }
          paramBaseReq.toBundle(localBundle);
          if ((localReq.scene != 3) || (!TextUtils.isEmpty(localReq.openId))) {
            break label1031;
          }
          Log.e("MicroMsg.SDK.WXApiImplV10", "Send specifiedContact openid can not be null.");
          AppMethodBeat.o(128111);
          return false;
          if ((i != 46) || (getWXAppSupportAPI() >= 620953856)) {
            break;
          }
          localObject = new WXWebpageObject();
          ((WXWebpageObject)localObject).webpageUrl = localBundle.getString("_wxminiprogram_webpageurl");
          localReq.message.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
        }
        localWXMiniProgramObject = (WXMiniProgramObject)localReq.message.mediaObject;
        localWXMiniProgramObject.userName += "@app";
        localObject = localWXMiniProgramObject.path;
      } while (d.b((String)localObject));
      localObject = ((String)localObject).split("\\?");
      if (localObject.length > 1) {}
      for (localObject = localObject[0] + ".html?" + localObject[1];; localObject = localObject[0] + ".html")
      {
        localWXMiniProgramObject.path = ((String)localObject);
        break;
      }
    }
    label1031:
    Object localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    ((MMessageActV2.Args)localObject).content = ("weixin://sendreq?appid=" + this.appId);
    ((MMessageActV2.Args)localObject).targetPkgName = "com.tencent.mm";
    ((MMessageActV2.Args)localObject).targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    if (paramBaseReq.getType() == 2) {}
    try
    {
      ((MMessageActV2.Args)localObject).token = getTokenFromWX(this.context);
      bool = MMessageActV2.send(this.context, (MMessageActV2.Args)localObject);
      AppMethodBeat.o(128111);
      return bool;
    }
    catch (Exception paramBaseReq)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX fail, exception = " + paramBaseReq.getMessage());
      }
    }
  }
  
  public boolean sendResp(BaseResp paramBaseResp)
  {
    AppMethodBeat.i(128134);
    if (this.detached)
    {
      paramBaseResp = new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128134);
      throw paramBaseResp;
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
      AppMethodBeat.o(128134);
      return false;
    }
    if (!paramBaseResp.checkArgs())
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
      AppMethodBeat.o(128134);
      return false;
    }
    Bundle localBundle = new Bundle();
    paramBaseResp.toBundle(localBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.bundle = localBundle;
    paramBaseResp.content = ("weixin://sendresp?appid=" + this.appId);
    paramBaseResp.targetPkgName = "com.tencent.mm";
    paramBaseResp.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    boolean bool = MMessageActV2.send(this.context, paramBaseResp);
    AppMethodBeat.o(128134);
    return bool;
  }
  
  public void setLogImpl(ILog paramILog)
  {
    AppMethodBeat.i(128136);
    Log.setLogImpl(paramILog);
    AppMethodBeat.o(128136);
  }
  
  public void unregisterApp()
  {
    AppMethodBeat.i(128105);
    if (this.detached)
    {
      localObject = new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
      AppMethodBeat.o(128105);
      throw ((Throwable)localObject);
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
      AppMethodBeat.o(128105);
      return;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
      AppMethodBeat.o(128105);
      return;
    }
    Log.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
    Object localObject = new a.a();
    ((a.a)localObject).a = "com.tencent.mm";
    ((a.a)localObject).action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
    ((a.a)localObject).content = ("weixin://unregisterapp?appid=" + this.appId);
    a.a(this.context, (a.a)localObject);
    AppMethodBeat.o(128105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.BaseWXApiImplV10
 * JD-Core Version:    0.7.0.1
 */