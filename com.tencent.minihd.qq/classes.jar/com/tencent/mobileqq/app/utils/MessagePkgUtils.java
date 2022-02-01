package com.tencent.mobileqq.app.utils;

import MessageSvcPack.stConfMsgRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MessagePkgUtils
{
  private static final String a = "MessagePkgUtils";
  
  public static MarkFaceMessage a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    if (paramArrayOfByte[0] == 1) {}
    for (;;)
    {
      try
      {
        i = PkgTools.a(paramArrayOfByte, 1);
        localObject = PkgTools.a(paramArrayOfByte, 3, i);
        if (!QLog.isColorLevel()) {
          break label227;
        }
        QLog.d("MessagePkgUtils", 2, "getMarkFaceMessage marketFaceNameTmp = " + (String)localObject);
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject;
        paramArrayOfByte.printStackTrace();
        return null;
      }
      i += 3;
      if (QLog.isColorLevel()) {
        QLog.d("MessagePkgUtils", 2, "getMarkFaceMessage  offset = " + i);
      }
      localObject = new MarkFaceMessage();
      ((MarkFaceMessage)localObject).dwMSGItemType = ((int)PkgTools.b(paramArrayOfByte, i));
      i += 4;
      ((MarkFaceMessage)localObject).cFaceInfo = paramArrayOfByte[i];
      i += 1;
      ((MarkFaceMessage)localObject).wSize = PkgTools.a(paramArrayOfByte, i);
      i += 2;
      ((MarkFaceMessage)localObject).sbufID = new byte[16];
      PkgTools.a(((MarkFaceMessage)localObject).sbufID, 0, paramArrayOfByte, i, 16);
      i += 16;
      ((MarkFaceMessage)localObject).dwTabID = ((int)PkgTools.a(paramArrayOfByte, i));
      i += 4;
      ((MarkFaceMessage)localObject).cSubType = paramArrayOfByte[i];
      i += 1;
      ((MarkFaceMessage)localObject).sbfKey = new byte[16];
      PkgTools.a(((MarkFaceMessage)localObject).sbfKey, 0, paramArrayOfByte, i, 16);
      return localObject;
      label227:
      i += 3;
    }
  }
  
  public static MessageForMarketFace a(String paramString, byte[] paramArrayOfByte, stConfMsgRecord paramstConfMsgRecord, int paramInt, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    paramQQAppInterface = new MessageForMarketFace();
    try
    {
      MarkFaceMessage localMarkFaceMessage = new MarkFaceMessage();
      localMarkFaceMessage.dwMSGItemType = ((int)PkgTools.b(paramArrayOfByte, 3));
      localMarkFaceMessage.cFaceInfo = paramArrayOfByte[7];
      localMarkFaceMessage.wSize = PkgTools.a(paramArrayOfByte, 8);
      localMarkFaceMessage.sbufID = new byte[16];
      PkgTools.a(localMarkFaceMessage.sbufID, 0, paramArrayOfByte, 10, 16);
      localMarkFaceMessage.dwTabID = ((int)PkgTools.a(paramArrayOfByte, 26));
      localMarkFaceMessage.cSubType = paramArrayOfByte[30];
      localMarkFaceMessage.sbfKey = new byte[16];
      PkgTools.a(localMarkFaceMessage.sbfKey, 0, paramArrayOfByte, 31, 16);
      localMarkFaceMessage.index = paramLong;
      paramQQAppInterface.mMarkFaceMessage = localMarkFaceMessage;
      paramQQAppInterface.msgData = a(localMarkFaceMessage);
      if (paramQQAppInterface.mMarkFaceMessage != null)
      {
        paramQQAppInterface.init(Long.valueOf(paramString).longValue(), paramstConfMsgRecord.lConfUin, paramstConfMsgRecord.lSendUin, "it is markFace", paramstConfMsgRecord.uMsgTime, paramInt, 3000, paramstConfMsgRecord.uMsgTime);
        paramQQAppInterface.shmsgseq = paramstConfMsgRecord.uMsgSeq;
        return paramQQAppInterface;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static Object a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte)).readObject();
  }
  
  public static byte[] a(int paramInt, long paramLong)
  {
    byte[] arrayOfByte = new byte[12];
    PkgTools.a(arrayOfByte, 0, (short)2052);
    PkgTools.a(arrayOfByte, 2, 0L);
    PkgTools.a(arrayOfByte, 6, (int)paramLong);
    PkgTools.a(arrayOfByte, 10, (short)paramInt);
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong, MarkFaceMessage paramMarkFaceMessage, String paramString)
  {
    paramMarkFaceMessage = a(paramMarkFaceMessage, paramString);
    short s = (short)(paramMarkFaceMessage.length + 8);
    paramString = new byte[s + 5];
    paramString[0] = 1;
    PkgTools.a(paramString, 1, (short)4);
    PkgTools.a(paramString, 3, s);
    PkgTools.a(paramString, 5, (short)2052);
    PkgTools.a(paramString, 7, paramLong);
    PkgTools.a(paramString, 11, (short)2);
    PkgTools.a(paramString, 13, paramMarkFaceMessage, paramMarkFaceMessage.length);
    return paramString;
  }
  
  public static byte[] a(MarkFaceMessage paramMarkFaceMessage, String paramString)
  {
    if (paramMarkFaceMessage == null) {
      paramMarkFaceMessage = null;
    }
    byte[] arrayOfByte2;
    byte[] arrayOfByte1;
    do
    {
      return paramMarkFaceMessage;
      arrayOfByte2 = new byte[47];
      arrayOfByte2[0] = 2;
      PkgTools.a(arrayOfByte2, 1, (short)44);
      PkgTools.b(arrayOfByte2, 3, paramMarkFaceMessage.dwMSGItemType);
      arrayOfByte2[7] = ((byte)paramMarkFaceMessage.cFaceInfo);
      PkgTools.a(arrayOfByte2, 8, (short)paramMarkFaceMessage.wSize);
      i = paramMarkFaceMessage.sbufID.length;
      PkgTools.a(arrayOfByte2, 10, paramMarkFaceMessage.sbufID, i);
      PkgTools.a(arrayOfByte2, 26, paramMarkFaceMessage.dwTabID);
      arrayOfByte2[30] = ((byte)paramMarkFaceMessage.cSubType);
      i = paramMarkFaceMessage.sbfKey.length;
      PkgTools.a(arrayOfByte2, 31, paramMarkFaceMessage.sbfKey, i);
      i = arrayOfByte2.length;
      arrayOfByte1 = new byte[i + 3];
      arrayOfByte1[0] = 12;
      PkgTools.a(arrayOfByte1, 1, (short)i);
      PkgTools.a(arrayOfByte1, 3, arrayOfByte2, arrayOfByte2.length);
      arrayOfByte2 = PkgTools.d(paramString);
      int j = arrayOfByte1.length;
      i = j;
      if (arrayOfByte2 != null) {
        i = j + (arrayOfByte2.length + 1 + 2);
      }
      paramString = new byte[i];
      PkgTools.a(paramString, 0, arrayOfByte1, arrayOfByte1.length);
      paramMarkFaceMessage = paramString;
    } while (arrayOfByte2 == null);
    int i = arrayOfByte1.length;
    paramString[i] = 11;
    i += 1;
    PkgTools.a(paramString, i, (short)arrayOfByte2.length);
    PkgTools.a(paramString, i + 2, arrayOfByte2, arrayOfByte2.length);
    return paramString;
  }
  
  public static byte[] a(Serializable paramSerializable)
  {
    if (paramSerializable == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSerializable);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] b(long paramLong, MarkFaceMessage paramMarkFaceMessage, String paramString)
  {
    byte[] arrayOfByte = a(2, paramLong);
    paramMarkFaceMessage = a(paramMarkFaceMessage, paramString);
    paramString = new byte[arrayOfByte.length + 5 + paramMarkFaceMessage.length];
    paramString[0] = 1;
    PkgTools.a(paramString, 1, (short)119);
    PkgTools.a(paramString, 3, (short)(arrayOfByte.length + paramMarkFaceMessage.length));
    PkgTools.a(paramString, 5, arrayOfByte, arrayOfByte.length);
    PkgTools.a(paramString, arrayOfByte.length + 5, paramMarkFaceMessage, paramMarkFaceMessage.length);
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "hex =" + PkgTools.b(paramString));
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessagePkgUtils
 * JD-Core Version:    0.7.0.1
 */