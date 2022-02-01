package com.tencent.mobileqq.activity;

import KQQ.ReqItem;
import KQQ.RespItem;
import KQQ.UserBitFlagReq;
import KQQ.UserBitFlagRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQSettingMe$UserBitFlagCheckUpdate
  implements CheckUpdateItemInterface
{
  private QQAppInterface a;
  
  public QQSettingMe$UserBitFlagCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 1;
    localReqItem.eServiceID = 106;
    UserBitFlagReq localUserBitFlagReq = new UserBitFlagReq();
    localUserBitFlagReq.cEmotionMall = 0;
    localUserBitFlagReq.cMyWallet = ((byte)QQSettingUtil.a(this.a));
    localUserBitFlagReq.cPtt2Text = 0;
    localUserBitFlagReq.cAccout2Dis = 0;
    localReqItem.vecParam = localUserBitFlagReq.toByteArray();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "handleCheckUpdateItemData");
    }
    if (paramRespItem.eServiceID == 106)
    {
      UserBitFlagRes localUserBitFlagRes = new UserBitFlagRes();
      localUserBitFlagRes.readFrom(new JceInputStream(paramRespItem.vecUpdate));
      int i = localUserBitFlagRes.cEmotionMall;
      int j = localUserBitFlagRes.cMyWallet;
      int k = localUserBitFlagRes.cAccout2Dis;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "vEmotion=" + i + ",cMyWallet=" + j + ",cPtt2Text=" + localUserBitFlagRes.cPtt2Text + " ,cAccout2Dis=" + k);
      }
      if (this.a != null)
      {
        this.a.a().getApplicationContext().getSharedPreferences(this.a.a(), 0).edit().putInt("mywallet_flag", j).putInt("select_member_contacts_flag", k).commit();
        paramRespItem = this.a;
        if (localUserBitFlagRes.cPtt2Text != 1) {
          break label211;
        }
      }
    }
    for (;;)
    {
      SttManager.a(paramRespItem, bool);
      return;
      label211:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.UserBitFlagCheckUpdate
 * JD-Core Version:    0.7.0.1
 */