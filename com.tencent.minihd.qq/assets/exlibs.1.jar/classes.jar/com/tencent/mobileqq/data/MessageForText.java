package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.eqq.CrmIvrText;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.widgets.PubAccountQQText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class MessageForText
  extends ChatMessage
{
  private static final boolean DEBUG_LOG = true;
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForText";
  public String action;
  public ArrayList atInfoList;
  private CharSequence floatSb;
  public String latitude;
  public String location;
  public URL locationUrl;
  public String longitude;
  public int msgVia;
  public CharSequence sb;
  public String url;
  
  protected void doParse()
  {
    boolean bool2 = true;
    doParse(false);
    String str1 = getExtInfoFromExtStr("sens_msg_need_parse");
    if (!TextUtils.isEmpty(str1)) {}
    String str2;
    do
    {
      for (;;)
      {
        try
        {
          bool1 = Boolean.parseBoolean(str1);
          if (bool1) {
            break;
          }
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        bool1 = true;
      }
      str2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty(str2));
    Object localObject = getExtInfoFromExtStr("sens_msg_confirmed");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase("1"))) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (!bool1) {
        saveExtInfoToExtStr("sens_msg_original_text", this.msg);
      }
      localObject = new CopyOnWriteArrayList();
      ((List)localObject).add(this);
      MQPSensitiveMsgUtil.a(this, (List)localObject, bool1, HexUtil.hexStr2Bytes(str2));
      return;
    }
  }
  
  protected void doParse(boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject3 = this.msg;
    Object localObject1 = localObject3;
    if (this.msgtype == -1003)
    {
      localObject1 = ActionMsgUtil.a((String)localObject3);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    if (!paramBoolean)
    {
      int i = ((String)localObject3).indexOf("http://maps.google.com/maps?q=");
      if (i != -1)
      {
        this.url = ((String)localObject3).substring(i);
        localObject1 = MessageUtils.a(this.url);
        this.latitude = localObject1[0];
        this.longitude = localObject1[1];
        this.location = localObject1[2];
        try
        {
          i = AIOUtils.a(200.0F, BaseApplication.getContext().getResources());
          int j = AIOUtils.a(100.0F, BaseApplication.getContext().getResources());
          localObject1 = new StringBuilder("https://st.map.soso.com/api");
          ((StringBuilder)localObject1).append("?size=").append(i).append("*").append(j);
          ((StringBuilder)localObject1).append("&center=").append(this.longitude).append(",").append(this.latitude);
          ((StringBuilder)localObject1).append("&zoom=14");
          ((StringBuilder)localObject1).append("&markers=").append(this.longitude).append(",").append(this.latitude).append(",").append("red");
          this.locationUrl = new URL(((StringBuilder)localObject1).toString());
          return;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.locationUrl = null;
          localMalformedURLException.printStackTrace();
          return;
        }
      }
    }
    if (this.istroop == 1008)
    {
      this.sb = new PubAccountQQText((CharSequence)localObject3, 13);
      ((PubAccountQQText)this.sb).a = this.selfuin;
      ((PubAccountQQText)this.sb).b = this.frienduin;
      return;
    }
    Object localObject2;
    if ((this.istroop == 1024) && (!isSendFromLocal()))
    {
      localObject2 = null;
      for (;;)
      {
        try
        {
          localAppRuntime = BaseApplicationImpl.a.getAppRuntime(this.selfuin);
          localObject2 = localAppRuntime;
          if (!QQAppInterface.class.isInstance(localAppRuntime)) {
            continue;
          }
          localObject2 = localAppRuntime;
          paramBoolean = CrmUtils.b((QQAppInterface)localAppRuntime, this.frienduin, this.istroop);
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          AppRuntime localAppRuntime;
          localAccountNotMatchException.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MessageForText", 2, String.format("User %s don't match current accound", new Object[] { this.selfuin }));
          paramBoolean = bool;
          Object localObject4 = localObject2;
          continue;
          this.sb = new QQText((CharSequence)localObject3, 13, 32, this.istroop);
          return;
        }
        if (!paramBoolean) {
          continue;
        }
        this.sb = new CrmIvrText((CharSequence)localObject3, 13, 32, this.istroop, this.frienduin, this.selfuin, (QQAppInterface)localAppRuntime);
        return;
        localObject2 = localAppRuntime;
        if (QLog.isColorLevel())
        {
          localObject2 = localAppRuntime;
          QLog.d("MessageForText", 2, "We get error AppRuntime");
        }
        paramBoolean = false;
      }
    }
    this.sb = new QQText((CharSequence)localObject3, 13, 32, this.istroop);
  }
  
  public CharSequence getFloatSb()
  {
    if ((this.floatSb == null) && ((this.sb instanceof QQText)))
    {
      QQText localQQText = (QQText)this.sb;
      this.floatSb = new QQText(localQQText.g, 5, 24, localQQText.n);
    }
    return this.floatSb;
  }
  
  protected void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText
 * JD-Core Version:    0.7.0.1
 */