package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Auth_Rst;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_CheckAuth_Req;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_CheckAuth_Rsp;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Req;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Rsp;
import com.tencent.pb.chatbgInfo.chatbgInfo.Platform_Comm_Req;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class ChatBackgroundAuthHandler
  extends BusinessHandler
{
  public static final String a = "Background.checkAuth";
  public static final String b = "ChatBackgroundAuthHandler";
  public static final String c = "lastChabgAuthTime";
  protected QQAppInterface b;
  
  protected ChatBackgroundAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Background.checkAuth".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatBackgroundAuthHandler", 2, "onReceive called.");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(List paramList)
  {
    Object localObject = this.b.a();
    chatbgInfo.Platform_Comm_Req localPlatform_Comm_Req = new chatbgInfo.Platform_Comm_Req();
    localPlatform_Comm_Req.ImPlat.set(109L);
    localPlatform_Comm_Req.mqqver.set("5.9.3.3468");
    localPlatform_Comm_Req.osver.set(Build.VERSION.RELEASE);
    chatbgInfo.Bg_CheckAuth_Req localBg_CheckAuth_Req = new chatbgInfo.Bg_CheckAuth_Req();
    if ((paramList != null) && (paramList.size() > 0)) {
      localBg_CheckAuth_Req.IdList.set(paramList);
    }
    paramList = new chatbgInfo.Bg_Req();
    paramList.cmd.set(1);
    paramList.comm.set(localPlatform_Comm_Req);
    paramList.reqcmd_0x01.set(localBg_CheckAuth_Req);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "Background.checkAuth");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ChatBackgroundAuthHandler", 2, "sendPbReq called.");
    }
  }
  
  public void a(Map paramMap)
  {
    HashMap localHashMap = ((ChatBackgroundManager)this.b.getManager(61)).a();
    Object localObject1 = this.b.getApplication().getApplicationContext();
    Object localObject2 = this.b.a();
    localObject1 = ((Context)localObject1).getSharedPreferences("chat_background_path_" + (String)localObject2, 0).edit();
    if (localHashMap != null)
    {
      localObject2 = localHashMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = (String)localHashMap.get(str1);
        if ((str2 != null) && (!str2.equals("null")) && (!str2.equals("custom"))) {
          try
          {
            int i = Integer.valueOf(str2).intValue();
            if ((paramMap.containsKey(Integer.valueOf(i))) && (((Integer)paramMap.get(Integer.valueOf(i))).intValue() == 1)) {
              ((SharedPreferences.Editor)localObject1).putString(str1, "null");
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ChatBackgroundAuthHandler", 2, "背景id转化int型出错");
            }
            localException.printStackTrace();
          }
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        paramToServiceMsg = new chatbgInfo.Bg_Rsp();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.ret.get() != 0L) {
          break label168;
        }
        paramFromServiceMsg = ((chatbgInfo.Bg_CheckAuth_Rsp)paramToServiceMsg.rspcmd_0x01.get()).AuthRst.get();
        paramToServiceMsg = new HashMap();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        if (!paramFromServiceMsg.hasNext()) {
          break label181;
        }
        paramObject = (chatbgInfo.Bg_Auth_Rst)paramFromServiceMsg.next();
        j = paramObject.bgId.get();
        paramObject = String.valueOf(paramObject.result.get());
        if (paramObject.endsWith("001")) {
          break label187;
        }
        if (!paramObject.equals("1004")) {
          break label175;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        paramToServiceMsg.printStackTrace();
      }
      paramToServiceMsg.put(Integer.valueOf(j), Integer.valueOf(i));
      continue;
      label168:
      return;
      i = 0;
      break;
      label175:
      i = 1;
      continue;
      label181:
      a(paramToServiceMsg);
      return;
      label187:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ChatBackgroundAuthHandler
 * JD-Core Version:    0.7.0.1
 */