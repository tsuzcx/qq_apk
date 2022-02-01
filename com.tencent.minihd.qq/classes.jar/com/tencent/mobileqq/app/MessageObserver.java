package com.tencent.mobileqq.app;

import QQService.RespTmpChatPicDownload;
import android.os.Bundle;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, RespTmpChatPicDownload paramRespTmpChatPicDownload) {}
  
  public void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  public void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  public void a(boolean paramBoolean, String[] paramArrayOfString) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void c() {}
  
  public void c(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean, String paramString) {}
  
  public void d() {}
  
  public void d(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean, String paramString) {}
  
  protected void e() {}
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean) {}
  
  public void g(boolean paramBoolean) {}
  
  public void h(boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    String str2 = null;
    String str3 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject2 = null;
    Object localObject8 = null;
    String str1 = null;
    int i = 0;
    if ((paramObject instanceof Object[])) {}
    for (Object localObject1 = (Object[])paramObject;; localObject1 = null)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 6008: 
        d(paramBoolean);
        return;
      case 999: 
        if ((paramObject instanceof String))
        {
          d(paramBoolean, (String)paramObject);
          return;
        }
        d(paramBoolean, "");
        return;
      case 6005: 
        c(paramBoolean);
        return;
      case 6004: 
        a(paramBoolean, paramObject);
        return;
      case 6006: 
        i(paramBoolean);
        return;
      case 1000: 
        e();
        return;
      case 1003: 
        a(paramBoolean);
        return;
      case 1004: 
        if ((paramObject instanceof HashMap)) {
          localObject1 = (Object[])((HashMap)paramObject).get("ERROR_DATA");
        }
        break;
      }
      for (localObject2 = (Boolean)((HashMap)paramObject).get("CODE_51");; localObject2 = null)
      {
        boolean bool;
        if ((localObject1 != null) && (localObject1.length >= 2)) {
          if ((localObject1[0] != null) && ((localObject1[0] instanceof Boolean)))
          {
            bool = ((Boolean)localObject1[0]).booleanValue();
            label641:
            if ((localObject1[1] != null) && ((localObject1[1] instanceof String))) {
              localObject1 = (String)localObject1[1];
            }
          }
        }
        for (;;)
        {
          if ((paramObject instanceof Long)) {
            paramObject = (Long)paramObject;
          }
          for (;;)
          {
            a(paramBoolean, bool, (String)localObject1, paramObject);
            return;
            paramObject = str1;
            if (localObject2 != null)
            {
              paramObject = str1;
              if (((Boolean)localObject2).booleanValue()) {
                paramObject = "CODE_51";
              }
            }
          }
          b(paramBoolean);
          return;
          b();
          return;
          d();
          a();
          return;
          a();
          return;
          if ((localObject1 == null) || (localObject1.length <= 2)) {
            break;
          }
          str1 = (String)localObject1[0];
          paramInt = ((Integer)localObject1[1]).intValue();
          i = ((Integer)localObject1[2]).intValue();
          long l1;
          long l2;
          if (localObject1.length >= 6)
          {
            paramObject = (SendMessageHandler)localObject1[3];
            l1 = ((Long)localObject1[4]).longValue();
            l2 = ((Long)localObject1[5]).longValue();
          }
          for (;;)
          {
            localObject2 = "";
            if (localObject1.length >= 7) {
              localObject2 = (String)localObject1[6];
            }
            a(str1, paramInt, i, paramObject, l1, l2, (String)localObject2);
            return;
            l1 = 96000L;
            l2 = 0L;
            paramObject = localObject3;
          }
          if ((localObject1 == null) || (localObject1.length <= 2)) {
            break;
          }
          a((String)localObject1[0], ((Integer)localObject1[1]).intValue(), ((Integer)localObject1[2]).intValue());
          return;
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramObject = new String[localObject1.length];
            paramInt = i;
            while (paramInt < paramObject.length)
            {
              paramObject[paramInt] = ((String)localObject1[paramInt]);
              paramInt += 1;
            }
            a(paramBoolean, paramObject);
            return;
          }
          a(paramBoolean, null);
          return;
          if (paramBoolean)
          {
            paramObject = localObject4;
            if (localObject1 != null)
            {
              paramObject = localObject4;
              if (localObject1.length > 0) {
                paramObject = (RespTmpChatPicDownload)localObject1[0];
              }
            }
            a(paramBoolean, paramObject);
            return;
          }
          a(paramBoolean, null);
          return;
          a(paramBoolean, false);
          return;
          a(false, true);
          return;
          paramObject = (ToServiceMsg)paramObject;
          str2 = (String)paramObject.getAttribute("_tag_LOGSTR");
          paramInt = paramObject.extraData.getInt("system_msg_action_type");
          localObject1 = paramObject.extraData.getString("system_msg_action_resp_key");
          localObject2 = paramObject.extraData.getString("system_msg_action_resp_error_key");
          i = paramObject.extraData.getInt("system_msg_action_resp_result_code_key");
          int j = paramObject.extraData.getInt("system_msg_action_resp_type_key");
          str1 = paramObject.extraData.getString("system_msg_action_resp_invalid_decided_key");
          int k = paramObject.extraData.getInt("system_msg_action_resp_remark_result_key");
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = str1;
          if (str1 == null) {
            localObject2 = "";
          }
          if (QLog.isColorLevel()) {
            QLog.d("MessageObserver", 2, "sendSystemMsgActionResult logStr=" + str2 + ";actionType=" + paramInt + ";msgDetail=" + paramObject + ";resultCode=" + i + ";respType=" + j + ";msgFail=" + (String)localObject1 + ";msgInvalidDecided=" + (String)localObject2 + ";remarkRet=" + k);
          }
          a(paramBoolean, str2, paramInt, paramObject, i, j, (String)localObject1, (String)localObject2, k);
          return;
          a((String)((ToServiceMsg)paramObject).getAttribute("_tag_LOGSTR"));
          return;
          e(paramBoolean);
          return;
          f(paramBoolean);
          return;
          if ((localObject1 == null) || (localObject1.length < 1)) {
            break;
          }
          a(paramBoolean, (String)localObject1[0]);
          return;
          h(paramBoolean);
          return;
          if (paramBoolean) {
            if ((localObject1 == null) || (localObject1.length < 1)) {
              break label2192;
            }
          }
          label2182:
          label2192:
          for (paramObject = (byte[])localObject1[0];; paramObject = null)
          {
            localObject2 = str2;
            if (localObject1 != null)
            {
              localObject2 = str2;
              if (localObject1.length >= 2) {
                localObject2 = (MessageObserver.StatictisInfo)localObject1[1];
              }
            }
            a(paramBoolean, paramObject, (MessageObserver.StatictisInfo)localObject2);
            return;
            if ((localObject1 != null) && (localObject1.length >= 2)) {}
            for (paramObject = (MessageObserver.StatictisInfo)localObject1[1];; paramObject = null)
            {
              a(paramBoolean, null, paramObject);
              return;
              if (paramBoolean) {
                if ((localObject1 == null) || (localObject1.length < 1)) {
                  break label2182;
                }
              }
              for (paramObject = (MessageFactoryReceiver.OffLineFileInfo)localObject1[0];; paramObject = null)
              {
                localObject2 = str3;
                if (localObject1 != null)
                {
                  localObject2 = str3;
                  if (localObject1.length >= 2) {
                    localObject2 = (MessageObserver.StatictisInfo)localObject1[1];
                  }
                }
                a(paramBoolean, paramObject, (MessageObserver.StatictisInfo)localObject2);
                return;
                if ((localObject1 != null) && (localObject1.length >= 2)) {}
                for (paramObject = (MessageObserver.StatictisInfo)localObject1[1];; paramObject = null)
                {
                  a(paramBoolean, null, paramObject);
                  return;
                  if (paramBoolean)
                  {
                    paramObject = localObject5;
                    if (localObject1 != null)
                    {
                      paramObject = localObject5;
                      if (localObject1.length >= 1) {
                        paramObject = (MessageFactoryReceiver.OffLineFileInfo)localObject1[0];
                      }
                    }
                    a(paramBoolean, paramObject);
                    return;
                  }
                  a(paramBoolean, null);
                  return;
                  g(paramBoolean);
                  return;
                  if ((localObject1 != null) && (localObject1.length >= 2))
                  {
                    a(paramBoolean, ((Long)localObject1[0]).longValue(), ((Long)localObject1[1]).longValue());
                    return;
                  }
                  a(paramBoolean, 0L, 0L);
                  return;
                  if ((localObject1 != null) && (localObject1.length >= 1))
                  {
                    a(paramBoolean, (MessageFactoryReceiver.UploadStreamStruct)localObject1[0]);
                    return;
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  if ("Stream ptt:UploadStreamStruct : arrayLength:" + localObject1 == null) {}
                  for (paramObject = "null";; paramObject = localObject1.length + "")
                  {
                    QLog.d("streamptt.send", 2, paramObject);
                    return;
                  }
                  if (!(paramObject instanceof String)) {
                    break;
                  }
                  b(paramBoolean, (String)paramObject);
                  return;
                  if (!(paramObject instanceof String)) {
                    break;
                  }
                  c(paramBoolean, (String)paramObject);
                  return;
                  if ((localObject1 == null) || (localObject1.length <= 1)) {
                    break;
                  }
                  a(((Byte)localObject1[0]).byteValue(), ((Byte)localObject1[1]).byteValue());
                  return;
                  paramObject = localObject6;
                  if (localObject1 != null)
                  {
                    paramObject = localObject6;
                    if (localObject1.length >= 1) {
                      paramObject = (MessageObserver.StatictisInfo)localObject1[0];
                    }
                  }
                  a(paramBoolean, paramObject);
                  return;
                  if ((localObject1 == null) || (localObject1.length < 2)) {
                    break;
                  }
                  paramObject = (Integer)localObject1[0];
                  localObject2 = (String)localObject1[1];
                  localObject1 = (String)localObject1[2];
                  a(paramBoolean, (String)localObject2, paramObject.intValue(), (String)localObject1);
                  return;
                  c();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_GET_MSG");
                  }
                  localObject1 = localObject7;
                  if (paramObject != null) {
                    localObject1 = ((SubAccountBackProtocData)paramObject).c;
                  }
                  b(paramBoolean, (String)localObject1, (SubAccountBackProtocData)paramObject);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_MSG_NUM_READED_CONFIRM isSucc=" + paramBoolean + " data=" + String.valueOf(paramObject));
                  }
                  if ((paramObject instanceof String[]))
                  {
                    localObject1 = (String[])paramObject;
                    if (localObject1.length == 2) {
                      paramObject = localObject1[0];
                    }
                  }
                  for (localObject1 = localObject1[1];; localObject1 = localObject2)
                  {
                    a(paramBoolean, paramObject, (String)localObject1);
                    return;
                    localObject1 = localObject8;
                    if (paramObject != null) {
                      localObject1 = ((SubAccountBackProtocData)paramObject).c;
                    }
                    a(paramBoolean, (String)localObject1, (SubAccountBackProtocData)paramObject);
                    return;
                    if ((localObject1 == null) || (localObject1.length != 6)) {
                      break;
                    }
                    paramObject = (Boolean)localObject1[0];
                    localObject2 = (String)localObject1[1];
                    str1 = (String)localObject1[2];
                    str2 = (String)localObject1[3];
                    str3 = (String)localObject1[4];
                    localObject1 = (ArrayList)localObject1[5];
                    a(paramBoolean, paramObject.booleanValue(), (String)localObject2, str1, str2, str3, (ArrayList)localObject1);
                    return;
                    if ((localObject1 == null) || (localObject1.length != 4)) {
                      break;
                    }
                    a(paramBoolean, (String)localObject1[0], (String)localObject1[1], (String)localObject1[2], (String)localObject1[3]);
                    return;
                    paramObject = null;
                  }
                }
              }
            }
          }
          localObject1 = null;
          continue;
          bool = false;
          break label641;
          localObject1 = null;
          bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageObserver
 * JD-Core Version:    0.7.0.1
 */