package com.tencent.mobileqq.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class WXPayHelper
  implements IWXAPIEventHandler
{
  private static WXPayHelper jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper = null;
  private static final String jdField_a_of_type_JavaLangString = "wxf0a80d0ac2e82aa7";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private IWXAPI jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.a().getApplicationContext(), "wxf0a80d0ac2e82aa7", true);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  
  private WXPayHelper()
  {
    registerApp();
  }
  
  public static WXPayHelper getInstance()
  {
    if (jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper == null) {
        jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper = new WXPayHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper;
    }
  }
  
  public void addObserver(Handler paramHandler)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramHandler)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramHandler);
      }
      return;
    }
  }
  
  public int getWXAppSupportAPI()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.getWXAppSupportAPI();
  }
  
  public void handleIntent(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public boolean isWXinstalled()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public boolean isWXsupportApi()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.isWXAppSupportAPI();
  }
  
  public boolean isWXsupportPayApi()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.getWXAppSupportAPI() >= 570425345;
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    Log.d("CFT", "Helper onResp:" + paramBaseResp.getType());
    Log.d("CFT", "Helper onResp, errCode = " + paramBaseResp.errCode);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        Handler localHandler = (Handler)localIterator.next();
        Message localMessage = new Message();
        localMessage.what = 10;
        Bundle localBundle = new Bundle();
        localBundle.putInt("errCode", paramBaseResp.errCode);
        localBundle.putString("errStr", paramBaseResp.errStr);
        localBundle.putString("openId", paramBaseResp.openId);
        localBundle.putString("transaction", paramBaseResp.transaction);
        localMessage.setData(localBundle);
        localHandler.sendMessage(localMessage);
      }
    }
  }
  
  public void registerApp()
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.registerApp("wxf0a80d0ac2e82aa7");
  }
  
  public void removeObserver(Handler paramHandler)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramHandler)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramHandler);
      }
      return;
    }
  }
  
  public void sendReq(Bundle paramBundle)
  {
    PayReq localPayReq = new PayReq();
    localPayReq.appId = "wxf0a80d0ac2e82aa7";
    localPayReq.partnerId = paramBundle.getString("partnerid");
    localPayReq.prepayId = paramBundle.getString("prepayid");
    localPayReq.nonceStr = paramBundle.getString("noncestr");
    localPayReq.timeStamp = paramBundle.getString("timestamp");
    localPayReq.packageValue = paramBundle.getString("package");
    localPayReq.sign = paramBundle.getString("sign");
    Log.d("CFT", "api.sendReq:" + localPayReq.appId + "," + localPayReq.partnerId + "," + localPayReq.prepayId + "," + localPayReq.nonceStr + "," + localPayReq.timeStamp + "," + localPayReq.packageValue + "," + localPayReq.sign);
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq(localPayReq);
  }
  
  public void unRegisterApp()
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.unregisterApp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXPayHelper
 * JD-Core Version:    0.7.0.1
 */