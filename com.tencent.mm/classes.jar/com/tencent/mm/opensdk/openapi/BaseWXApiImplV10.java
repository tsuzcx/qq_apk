package com.tencent.mm.opensdk.openapi;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.channel.a.a.a;
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
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed.Req;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed.Resp;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive.Req;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive.Resp;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile.Req;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile.Resp;
import com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo.Req;
import com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo.Resp;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Req;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Req;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Resp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Req;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Req;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Resp;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Req;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Resp;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment.Req;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment.Resp;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class BaseWXApiImplV10
  implements IWXAPI
{
  protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  private static String wxappPayEntryClassname;
  private byte _hellAccFlag_;
  protected String appId;
  protected boolean checkSignature;
  protected Context context;
  protected boolean detached;
  private int launchMode;
  private int wxSdkVersion;
  
  BaseWXApiImplV10(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(254372);
    this.checkSignature = false;
    this.detached = false;
    this.launchMode = 2;
    Log.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + paramString + ", checkSignature = " + paramBoolean + ", launchMode = " + paramInt);
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
    this.launchMode = paramInt;
    b.a = paramContext.getApplicationContext();
    AppMethodBeat.o(254372);
  }
  
  private boolean checkSumConsistent(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(3825);
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
    {
      if (paramArrayOfByte1.length != paramArrayOfByte2.length)
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
        AppMethodBeat.o(3825);
        return false;
      }
      int i = 0;
      while (i < paramArrayOfByte1.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
        {
          AppMethodBeat.o(3825);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(3825);
      return true;
    }
    Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
    AppMethodBeat.o(3825);
    return false;
  }
  
  private boolean createChatroom(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3810);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_create_chatroom_group_id", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_name", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_create_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3810);
    return true;
  }
  
  private String getTokenFromWX(Context paramContext)
  {
    AppMethodBeat.i(3800);
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[] { this.appId, "637992960" }, null);
    if ((paramContext != null) && (paramContext.moveToFirst()))
    {
      String str = paramContext.getString(0);
      Log.i("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX token is ".concat(String.valueOf(str)));
      paramContext.close();
      AppMethodBeat.o(3800);
      return str;
    }
    AppMethodBeat.o(3800);
    return null;
  }
  
  private boolean handleWxInternalRespType(String paramString, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    AppMethodBeat.i(3795);
    Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, extInfo = ".concat(String.valueOf(paramString)));
    try
    {
      paramString = Uri.parse(paramString);
      localObject = paramString.getQueryParameter("wx_internal_resptype");
      Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, respType = ".concat(String.valueOf(localObject)));
      if (b.b((String)localObject))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, respType is null");
        AppMethodBeat.o(3795);
        return false;
      }
      if (((String)localObject).equals("subscribemessage"))
      {
        localObject = new SubscribeMessage.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((BaseResp)localObject).errCode = b.a(str, 0);
        }
        ((BaseResp)localObject).openId = paramString.getQueryParameter("openid");
        ((SubscribeMessage.Resp)localObject).templateID = paramString.getQueryParameter("template_id");
        ((SubscribeMessage.Resp)localObject).scene = b.a(paramString.getQueryParameter("scene"), 0);
        ((SubscribeMessage.Resp)localObject).action = paramString.getQueryParameter("action");
        ((SubscribeMessage.Resp)localObject).reserved = paramString.getQueryParameter("reserved");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        AppMethodBeat.o(3795);
        return true;
      }
      if (((String)localObject).contains("invoice_auth_insert"))
      {
        localObject = new WXInvoiceAuthInsert.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((BaseResp)localObject).errCode = b.a(str, 0);
        }
        ((WXInvoiceAuthInsert.Resp)localObject).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        AppMethodBeat.o(3795);
        return true;
      }
      if (((String)localObject).contains("payinsurance"))
      {
        localObject = new WXPayInsurance.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((BaseResp)localObject).errCode = b.a(str, 0);
        }
        ((WXPayInsurance.Resp)localObject).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        AppMethodBeat.o(3795);
        return true;
      }
      if (((String)localObject).contains("nontaxpay"))
      {
        localObject = new WXNontaxPay.Resp();
        str = paramString.getQueryParameter("ret");
        if ((str != null) && (str.length() > 0)) {
          ((BaseResp)localObject).errCode = b.a(str, 0);
        }
        ((WXNontaxPay.Resp)localObject).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject);
        AppMethodBeat.o(3795);
        return true;
      }
      if (("subscribeminiprogrammsg".equals(localObject)) || ("5".equals(localObject))) {
        break label445;
      }
      Log.e("MicroMsg.SDK.WXApiImplV10", "this open sdk version not support the request type");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        String str;
        Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, ex = " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(3795);
    return false;
    label445:
    localObject = new SubscribeMiniProgramMsg.Resp();
    str = paramString.getQueryParameter("ret");
    if ((str != null) && (str.length() > 0)) {
      ((BaseResp)localObject).errCode = b.a(str, 0);
    }
    ((BaseResp)localObject).openId = paramString.getQueryParameter("openid");
    ((SubscribeMiniProgramMsg.Resp)localObject).unionId = paramString.getQueryParameter("unionid");
    ((SubscribeMiniProgramMsg.Resp)localObject).nickname = paramString.getQueryParameter("nickname");
    ((BaseResp)localObject).errStr = paramString.getQueryParameter("errmsg");
    paramIWXAPIEventHandler.onResp((BaseResp)localObject);
    AppMethodBeat.o(3795);
    return true;
  }
  
  private boolean joinChatroom(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3811);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_join_chatroom_group_id", ""), paramBundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_join_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3811);
    return true;
  }
  
  private void launchWXIfNeed()
  {
    AppMethodBeat.i(3802);
    if ((Build.VERSION.SDK_INT >= 29) && (this.launchMode == 2))
    {
      launchWXUsingPendingIntent();
      AppMethodBeat.o(3802);
      return;
    }
    openWXApp();
    AppMethodBeat.o(3802);
  }
  
  private void launchWXUsingPendingIntent()
  {
    AppMethodBeat.i(254380);
    if (!this.detached)
    {
      if (!isWXAppInstalled())
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "openWXApp failed, not installed or signature check failed");
        AppMethodBeat.o(254380);
        return;
      }
      try
      {
        Log.i("MicroMsg.SDK.WXApiImplV10", "launchWXUsingPendingIntent");
        Intent localIntent = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        PendingIntent.getActivity(this.context, 1, localIntent, 134217728).send(this.context, 2, null, new PendingIntent.OnFinished()
        {
          public void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(253496);
            Log.d("MicroMsg.SDK.WXApiImplV10", "onSendFinished resultCode: " + paramAnonymousInt + ", resultData: " + paramAnonymousString);
            AppMethodBeat.o(253496);
          }
        }, null);
        AppMethodBeat.o(254380);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "launchWXUsingPendingIntent pendingIntent send failed: " + localException.getMessage());
        openWXApp();
        AppMethodBeat.o(254380);
        return;
      }
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    AppMethodBeat.o(254380);
    throw localIllegalStateException;
  }
  
  private boolean sendAddCardToWX(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3803);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_add_card_to_wx_card_list"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3803);
    return true;
  }
  
  private boolean sendChooseCardFromWX(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3804);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[] { paramBundle.getString("_wxapi_choose_card_from_wx_card_app_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_location_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), paramBundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), paramBundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3804);
    return true;
  }
  
  private boolean sendFinderOpenFeed(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(254400);
    launchWXIfNeed();
    Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderOpenFeed");
    paramBaseReq = (WXChannelOpenFeed.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenFeed"), null, null, new String[] { this.appId, paramBaseReq.feedID, paramBaseReq.nonceID, String.valueOf(paramBaseReq.notGetReleatedList) }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(254400);
    return true;
  }
  
  private boolean sendFinderOpenLive(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(254399);
    launchWXIfNeed();
    Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderOpenLive");
    paramBaseReq = (WXChannelOpenLive.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenLive"), null, null, new String[] { this.appId, paramBaseReq.feedID, paramBaseReq.nonceID }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(254399);
    return true;
  }
  
  private boolean sendFinderOpenProfile(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(254398);
    launchWXIfNeed();
    Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderOpenProfile");
    paramBaseReq = (WXChannelOpenProfile.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenProfile"), null, null, new String[] { this.appId, paramBaseReq.userName }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(254398);
    return true;
  }
  
  private boolean sendFinderShareVideo(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(254397);
    launchWXIfNeed();
    Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderShareVideo");
    paramBaseReq = (WXChannelShareVideo.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderShareVideo"), null, null, new String[] { this.appId, paramBaseReq.videoPath, "", "", paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(254397);
    return true;
  }
  
  private boolean sendHandleScanResult(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3812);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_scan_qrcode_result") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3812);
    return true;
  }
  
  private boolean sendInvoiceAuthInsert(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3815);
    launchWXIfNeed();
    paramBaseReq = (WXInvoiceAuthInsert.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "2", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3815);
    return true;
  }
  
  private boolean sendJumpToOfflinePayReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3808);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[] { this.appId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3808);
    return true;
  }
  
  private boolean sendLaunchWXMiniprogram(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3820);
    launchWXIfNeed();
    paramBaseReq = (WXLaunchMiniProgram.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[] { this.appId, paramBaseReq.userName, paramBaseReq.path, paramBaseReq.miniprogramType, paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3820);
    return true;
  }
  
  private boolean sendLaunchWXMiniprogramWithToken(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3819);
    launchWXIfNeed();
    paramBaseReq = (WXLaunchMiniProgramWithToken.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[] { this.appId, paramBaseReq.token }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3819);
    return true;
  }
  
  private boolean sendNonTaxPay(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3816);
    launchWXIfNeed();
    paramBaseReq = (WXNontaxPay.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "3", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3816);
    return true;
  }
  
  private boolean sendOpenBusiLuckyMoney(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3809);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), paramBundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), paramBundle.getString("_wxapi_open_busi_lucky_money_signType"), paramBundle.getString("_wxapi_open_busi_lucky_money_signature"), paramBundle.getString("_wxapi_open_busi_lucky_money_package") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3809);
    return true;
  }
  
  private boolean sendOpenBusinessView(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3821);
    launchWXIfNeed();
    paramBaseReq = (WXOpenBusinessView.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[] { this.appId, paramBaseReq.businessType, paramBaseReq.query, paramBaseReq.extInfo, paramBaseReq.transaction, paramBaseReq.openId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3821);
    return true;
  }
  
  private boolean sendOpenBusinessWebview(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3807);
    launchWXIfNeed();
    WXOpenBusinessWebview.Req localReq = (WXOpenBusinessWebview.Req)paramBaseReq;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
    paramBaseReq = "";
    HashMap localHashMap = localReq.queryInfo;
    paramContext = paramBaseReq;
    if (localHashMap != null)
    {
      paramContext = paramBaseReq;
      if (localHashMap.size() > 0) {
        paramContext = new JSONObject(localReq.queryInfo).toString();
      }
    }
    paramContext = localContentResolver.query(localUri, null, null, new String[] { this.appId, localReq.businessType, paramContext }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3807);
    return true;
  }
  
  private boolean sendOpenRankListReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3805);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3805);
    return true;
  }
  
  private boolean sendOpenWebview(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3806);
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_webview_url"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3806);
    return true;
  }
  
  private boolean sendPayInSurance(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3817);
    launchWXIfNeed();
    paramBaseReq = (WXPayInsurance.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "4", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3817);
    return true;
  }
  
  private boolean sendPayReq(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(3801);
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
          AppMethodBeat.o(3801);
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
    localArgs.launchMode = this.launchMode;
    boolean bool = MMessageActV2.send(paramContext, localArgs);
    AppMethodBeat.o(3801);
    return bool;
  }
  
  private boolean sendPreloadWXMiniProgramEnvironment(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(254394);
    paramBaseReq = (WXPreloadMiniProgramEnvironment.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogramEnvironment"), null, null, new String[] { this.appId, paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(254394);
    return true;
  }
  
  private boolean sendPreloadWXMiniprogram(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3818);
    paramBaseReq = (WXPreloadMiniProgram.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram"), null, null, new String[] { this.appId, paramBaseReq.userName, paramBaseReq.path, paramBaseReq.miniprogramType, paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3818);
    return true;
  }
  
  private boolean sendSubscribeMessage(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3813);
    launchWXIfNeed();
    paramBaseReq = (SubscribeMessage.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "1", String.valueOf(paramBaseReq.scene), paramBaseReq.templateID, paramBaseReq.reserved }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3813);
    return true;
  }
  
  private boolean sendSubscribeMiniProgramMsg(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3814);
    launchWXIfNeed();
    paramBaseReq = (SubscribeMiniProgramMsg.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "5", paramBaseReq.miniProgramAppId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    AppMethodBeat.o(3814);
    return true;
  }
  
  private boolean sendToWxaRedirectingPage(Context paramContext, BaseReq paramBaseReq)
  {
    AppMethodBeat.i(254395);
    launchWXIfNeed();
    paramBaseReq = (WXLaunchWxaRedirectingPage.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWxaOpenApiRedirectingPage");
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(0, this.appId);
      localArrayList.addAll(Arrays.asList(paramBaseReq.toArray()));
      paramContext = paramContext.query(localUri, null, null, (String[])localArrayList.toArray(new String[0]), null);
      if (paramContext != null) {
        paramContext.close();
      }
      return true;
    }
    finally
    {
      AppMethodBeat.o(254395);
    }
  }
  
  public void detach()
  {
    AppMethodBeat.i(3823);
    Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    this.context = null;
    AppMethodBeat.o(3823);
  }
  
  public int getWXAppSupportAPI()
  {
    AppMethodBeat.i(3797);
    if (!this.detached)
    {
      if (!isWXAppInstalled())
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
        AppMethodBeat.o(3797);
        return 0;
      }
      this.wxSdkVersion = 0;
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      b.e.submit(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(3764);
          try
          {
            MMSharedPreferences localMMSharedPreferences = new MMSharedPreferences(BaseWXApiImplV10.this.context);
            BaseWXApiImplV10.access$002(BaseWXApiImplV10.this, localMMSharedPreferences.getInt("_build_info_sdk_int_", 0));
            localCountDownLatch.countDown();
            AppMethodBeat.o(3764);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.w("MicroMsg.SDK.WXApiImplV10", localException.getMessage());
            }
          }
        }
      });
      try
      {
        localCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
        Log.d("MicroMsg.SDK.WXApiImplV10", "wxSdkVersion = " + this.wxSdkVersion);
        if (this.wxSdkVersion == 0) {}
        try
        {
          this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
          Log.d("MicroMsg.SDK.WXApiImplV10", "OPEN_SDK_VERSION = " + this.wxSdkVersion);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + localException.getMessage());
          }
        }
        i = this.wxSdkVersion;
        AppMethodBeat.o(3797);
        return i;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.w("MicroMsg.SDK.WXApiImplV10", localInterruptedException.getMessage());
        }
      }
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3797);
    throw localIllegalStateException;
  }
  
  public boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    AppMethodBeat.i(3794);
    try
    {
      if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token"))
      {
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
        AppMethodBeat.o(3794);
        return false;
      }
      if (this.detached) {
        break label1296;
      }
      localObject1 = paramIntent.getStringExtra("_mmessage_content");
      int i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
      localObject2 = paramIntent.getStringExtra("_mmessage_appPackage");
      if ((localObject2 == null) || (((String)localObject2).length() == 0)) {
        break label1280;
      }
      if (!checkSumConsistent(paramIntent.getByteArrayExtra("_mmessage_checksum"), com.tencent.mm.opensdk.channel.a.a.a((String)localObject1, i, (String)localObject2)))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
        AppMethodBeat.o(3794);
        return false;
      }
      i = paramIntent.getIntExtra("_wxapi_command_type", 0);
      Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, cmd = ".concat(String.valueOf(i)));
      switch (i)
      {
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 13: 
      case 18: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      default: 
        Log.e("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + i);
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        Log.e("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = " + paramIntent.getMessage());
      }
      paramIWXAPIEventHandler.onReq(new GetMessageFromWX.Req(paramIntent.getExtras()));
      AppMethodBeat.o(3794);
      return true;
    }
    AppMethodBeat.o(3794);
    return false;
    paramIWXAPIEventHandler.onResp(new WXChannelOpenFeed.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXChannelOpenLive.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXChannelOpenProfile.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXChannelShareVideo.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXPreloadMiniProgramEnvironment.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new SendTdiAuth.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXLaunchWxaRedirectingPage.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXLaunchMiniProgramWithToken.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXPreloadMiniProgram.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXJointPay.JointPayResp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new HandleScanResult.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new JoinChatroom.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new CreateChatroom.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new OpenWebview.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onReq(new LaunchFromWX.Req(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new PayResp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIntent = new ShowMessageFromWX.Req(paramIntent.getExtras());
    localObject2 = paramIntent.message.messageExt;
    if ((localObject2 != null) && (((String)localObject2).contains("wx_internal_resptype")))
    {
      bool = handleWxInternalRespType((String)localObject2, paramIWXAPIEventHandler);
      Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, extInfo contains wx_internal_resptype, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(3794);
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
          ((BaseResp)localObject2).errCode = b.a(str, 0);
        }
        ((WXOpenBusinessWebview.Resp)localObject2).resultInfo = ((Uri)localObject1).getQueryParameter("resultInfo");
        ((BaseResp)localObject2).errStr = ((Uri)localObject1).getQueryParameter("errmsg");
        localObject1 = ((Uri)localObject1).getQueryParameter("type");
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
          ((WXOpenBusinessWebview.Resp)localObject2).businessType = b.a((String)localObject1, 0);
        }
        paramIWXAPIEventHandler.onResp((BaseResp)localObject2);
        AppMethodBeat.o(3794);
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
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new SendMessageToWX.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    paramIWXAPIEventHandler.onResp(new SendAuth.Resp(paramIntent.getExtras()));
    AppMethodBeat.o(3794);
    return true;
    label1280:
    Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
    AppMethodBeat.o(3794);
    return false;
    label1296:
    paramIntent = new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3794);
    throw paramIntent;
  }
  
  public boolean isWXAppInstalled()
  {
    AppMethodBeat.i(3796);
    if (!this.detached) {
      try
      {
        PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
        if (localPackageInfo == null)
        {
          AppMethodBeat.o(3796);
          return false;
        }
        boolean bool = WXApiImplComm.validateAppSignature(this.context, localPackageInfo.signatures, this.checkSignature);
        AppMethodBeat.o(3796);
        return bool;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(3796);
        return false;
      }
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3796);
    throw localIllegalStateException;
  }
  
  public boolean openWXApp()
  {
    AppMethodBeat.i(3798);
    if (!this.detached)
    {
      if (!isWXAppInstalled())
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
        AppMethodBeat.o(3798);
        return false;
      }
      try
      {
        Context localContext = this.context;
        Object localObject = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/opensdk/openapi/BaseWXApiImplV10", "openWXApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/opensdk/openapi/BaseWXApiImplV10", "openWXApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(3798);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "startActivity fail, exception = " + localException.getMessage());
        AppMethodBeat.o(3798);
        return false;
      }
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3798);
    throw localIllegalStateException;
  }
  
  public boolean registerApp(String paramString)
  {
    AppMethodBeat.i(3791);
    boolean bool = registerApp(paramString, 0L);
    AppMethodBeat.o(3791);
    return bool;
  }
  
  public boolean registerApp(String paramString, long paramLong)
  {
    AppMethodBeat.i(3792);
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
        AppMethodBeat.o(3792);
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
      paramString.b = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
      paramString.c = ("weixin://registerapp?appid=" + this.appId);
      paramString.d = paramLong;
      boolean bool = com.tencent.mm.opensdk.channel.a.a.a(this.context, paramString);
      AppMethodBeat.o(3792);
      return bool;
    }
    paramString = new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3792);
    throw paramString;
  }
  
  public boolean sendReq(BaseReq paramBaseReq)
  {
    AppMethodBeat.i(3799);
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
        AppMethodBeat.o(3799);
        return false;
      }
      Object localObject1;
      Object localObject3;
      if (paramBaseReq.getType() == 2)
      {
        localObject1 = (SendMessageToWX.Req)paramBaseReq;
        if (((SendMessageToWX.Req)localObject1).scene == 4)
        {
          localObject2 = ((SendMessageToWX.Req)localObject1).sceneDataObject;
          if ((localObject2 instanceof WXStateSceneDataObject))
          {
            localObject2 = (WXStateSceneDataObject)localObject2;
            localObject3 = ((SendMessageToWX.Req)localObject1).message;
            if (((WXMediaMessage)localObject3).mediaObject == null) {
              ((WXMediaMessage)localObject3).mediaObject = new WXTextObject();
            }
            if (((SendMessageToWX.Req)localObject1).message.getType() == 1)
            {
              localObject3 = ((WXStateSceneDataObject)localObject2).stateTitle;
              if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                ((WXStateSceneDataObject)localObject2).stateTitle = ((WXTextObject)((SendMessageToWX.Req)localObject1).message.mediaObject).text;
              }
            }
          }
        }
      }
      if (!paramBaseReq.checkArgs())
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
        AppMethodBeat.o(3799);
        return false;
      }
      Log.i("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + paramBaseReq.getType());
      Object localObject2 = new Bundle();
      paramBaseReq.toBundle((Bundle)localObject2);
      if ((paramBaseReq.getType() != 5) && (paramBaseReq.getType() != 27))
      {
        if (paramBaseReq.getType() == 9)
        {
          bool = sendAddCardToWX(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 16)
        {
          bool = sendChooseCardFromWX(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 11)
        {
          bool = sendOpenRankListReq(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 12)
        {
          bool = sendOpenWebview(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 25)
        {
          bool = sendOpenBusinessWebview(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 13)
        {
          bool = sendOpenBusiLuckyMoney(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 14)
        {
          bool = createChatroom(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 15)
        {
          bool = joinChatroom(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 17)
        {
          bool = sendHandleScanResult(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 18)
        {
          bool = sendSubscribeMessage(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 28)
        {
          bool = sendPreloadWXMiniprogram(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 29)
        {
          bool = sendLaunchWXMiniprogramWithToken(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 23)
        {
          bool = sendSubscribeMiniProgramMsg(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 19)
        {
          bool = sendLaunchWXMiniprogram(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 32)
        {
          bool = sendPreloadWXMiniProgramEnvironment(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 30)
        {
          bool = sendToWxaRedirectingPage(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 26)
        {
          bool = sendOpenBusinessView(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 33)
        {
          bool = sendFinderShareVideo(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 34)
        {
          bool = sendFinderOpenProfile(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 35)
        {
          bool = sendFinderOpenLive(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 36)
        {
          bool = sendFinderOpenFeed(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 20)
        {
          bool = sendInvoiceAuthInsert(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 21)
        {
          bool = sendNonTaxPay(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 22)
        {
          bool = sendPayInSurance(this.context, paramBaseReq);
          AppMethodBeat.o(3799);
          return bool;
        }
        if (paramBaseReq.getType() == 24)
        {
          bool = sendJumpToOfflinePayReq(this.context, (Bundle)localObject2);
          AppMethodBeat.o(3799);
          return bool;
        }
        int i;
        if (paramBaseReq.getType() == 2)
        {
          localObject3 = (SendMessageToWX.Req)paramBaseReq;
          i = ((SendMessageToWX.Req)localObject3).message.getType();
          if (b.a(i))
          {
            if (getWXAppSupportAPI() >= 620756993) {
              break label1138;
            }
            localObject1 = new WXWebpageObject();
            ((WXWebpageObject)localObject1).webpageUrl = ((Bundle)localObject2).getString("_wxminiprogram_webpageurl");
            ((SendMessageToWX.Req)localObject3).message.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
          }
        }
        for (;;)
        {
          i = ((SendMessageToWX.Req)localObject3).scene;
          if ((i != 3) && (i != 1)) {
            ((SendMessageToWX.Req)localObject3).scene = 0;
          }
          paramBaseReq.toBundle((Bundle)localObject2);
          localObject1 = new MMessageActV2.Args();
          ((MMessageActV2.Args)localObject1).bundle = ((Bundle)localObject2);
          ((MMessageActV2.Args)localObject1).content = ("weixin://sendreq?appid=" + this.appId);
          ((MMessageActV2.Args)localObject1).targetPkgName = "com.tencent.mm";
          ((MMessageActV2.Args)localObject1).targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
          ((MMessageActV2.Args)localObject1).launchMode = this.launchMode;
          if (paramBaseReq.getType() == 2) {}
          try
          {
            ((MMessageActV2.Args)localObject1).token = getTokenFromWX(this.context);
            bool = MMessageActV2.send(this.context, (MMessageActV2.Args)localObject1);
            AppMethodBeat.o(3799);
            return bool;
            label1138:
            if ((i == 46) && (getWXAppSupportAPI() < 620953856))
            {
              localObject1 = new WXWebpageObject();
              ((WXWebpageObject)localObject1).webpageUrl = ((Bundle)localObject2).getString("_wxminiprogram_webpageurl");
              ((SendMessageToWX.Req)localObject3).message.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
            }
            else
            {
              WXMiniProgramObject localWXMiniProgramObject = (WXMiniProgramObject)((SendMessageToWX.Req)localObject3).message.mediaObject;
              localWXMiniProgramObject.userName += "@app";
              localObject1 = localWXMiniProgramObject.path;
              if (!b.b((String)localObject1))
              {
                localObject1 = ((String)localObject1).split("\\?");
                if (localObject1.length > 1) {}
                for (localObject1 = localObject1[0] + ".html?" + localObject1[1];; localObject1 = localObject1[0] + ".html")
                {
                  localWXMiniProgramObject.path = ((String)localObject1);
                  break;
                }
              }
            }
          }
          catch (Exception paramBaseReq)
          {
            for (;;)
            {
              Log.e("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX fail, exception = " + paramBaseReq.getMessage());
            }
          }
        }
      }
      boolean bool = sendPayReq(this.context, (Bundle)localObject2);
      AppMethodBeat.o(3799);
      return bool;
    }
    paramBaseReq = new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3799);
    throw paramBaseReq;
  }
  
  public boolean sendResp(BaseResp paramBaseResp)
  {
    AppMethodBeat.i(3822);
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
        AppMethodBeat.o(3822);
        return false;
      }
      if (!paramBaseResp.checkArgs())
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
        AppMethodBeat.o(3822);
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
      AppMethodBeat.o(3822);
      return bool;
    }
    paramBaseResp = new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3822);
    throw paramBaseResp;
  }
  
  public void setLogImpl(ILog paramILog)
  {
    AppMethodBeat.i(3824);
    Log.setLogImpl(paramILog);
    AppMethodBeat.o(3824);
  }
  
  public void unregisterApp()
  {
    AppMethodBeat.i(3793);
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
        AppMethodBeat.o(3793);
        return;
      }
      Log.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
      localObject = this.appId;
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        Log.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
        localObject = new a.a();
        ((a.a)localObject).a = "com.tencent.mm";
        ((a.a)localObject).b = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
        ((a.a)localObject).c = ("weixin://unregisterapp?appid=" + this.appId);
        com.tencent.mm.opensdk.channel.a.a.a(this.context, (a.a)localObject);
        AppMethodBeat.o(3793);
        return;
      }
      Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
      AppMethodBeat.o(3793);
      return;
    }
    Object localObject = new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
    AppMethodBeat.o(3793);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.BaseWXApiImplV10
 * JD-Core Version:    0.7.0.1
 */