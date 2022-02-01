package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TroopFileUtils
{
  public static final int a = 102;
  public static final long a = 8888L;
  public static final String a = "BizTechReport";
  public static final int b = 104;
  public static final String b = "troop_troopfile";
  public static final int c = 105;
  public static final String c = "upload";
  public static final int d = 106;
  public static final String d = "download";
  public static final int e = 3;
  public static final String e = "0";
  public static final int f = 25;
  public static final String f = "1";
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L) {
      return 0;
    }
    long l1 = paramLong1;
    long l2 = paramLong2;
    if (paramLong1 > paramLong2)
    {
      l1 = paramLong2;
      l2 = paramLong2;
    }
    while (l2 > 2147483647L)
    {
      l2 >>= 1;
      l1 >>= 1;
    }
    return (int)(l1 / l2 * 100.0D);
  }
  
  public static int a(Context paramContext)
  {
    int j = 2;
    int k = NetworkUtil.a(paramContext);
    if (k == 0) {
      j = 0;
    }
    while ((2 != k) && (3 != k) && (4 != k)) {
      return j;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong)
  {
    int j = a(paramContext);
    if (j == 0) {
      TroopFileError.a(paramQQAppInterface, paramLong, 106);
    }
    return j;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt, String paramString4, long paramLong2)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2017);
    localMessageRecord.selfuin = paramQQAppInterface.a();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramQQAppInterface.a();
    localMessageRecord.msgUid = MessageUtils.a(paramInt);
    localMessageRecord.msg = MsgUtils.a(null);
    localMessageRecord.msgtype = -2017;
    localMessageRecord.isread = true;
    localMessageRecord.issend = 1;
    localMessageRecord.istroop = 1;
    paramString1 = paramQQAppInterface.a().a(localMessageRecord.senderuin, 1, false);
    if ((paramString1 != null) && (!paramString1.isEmpty())) {}
    for (localMessageRecord.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;; localMessageRecord.shmsgseq = Math.abs(new Random().nextInt()))
    {
      localMessageRecord.time = MessageCache.a();
      paramString1 = (MessageForTroopFile)localMessageRecord;
      paramString1.fileName = paramString2;
      paramString1.uuid = paramString3;
      paramString1.fileSize = paramLong1;
      paramString1.FromUin = paramString4;
      paramString1.entitySessionId = paramLong2;
      if (localMessageRecord.isSend()) {
        ((SVIPHandler)paramQQAppInterface.a(12)).a(localMessageRecord);
      }
      paramString1.serial();
      paramQQAppInterface.a().a(localMessageRecord, paramQQAppInterface.a());
      QLog.i("TroopFile", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(localMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(localMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], vipBubbleID[" + String.valueOf(-1) + "]");
      return localMessageRecord.uniseq;
    }
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    Object localObject = ImageUtil.a(paramString, paramInt);
    int k;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramString == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      j = paramString.getWidth();
      k = paramString.getHeight();
      localObject = new Rect();
      if (j < k) {
        break label141;
      }
    }
    ((Rect)localObject).top = 0;
    ((Rect)localObject).left = ((j - k) / 2);
    int j = k;
    for (;;)
    {
      ((Rect)localObject).bottom = (((Rect)localObject).top + j);
      ((Rect)localObject).right = (j + ((Rect)localObject).left);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      if (localBitmap != null) {
        new Canvas(localBitmap).drawBitmap(paramString, (Rect)localObject, new Rect(0, 0, paramInt, paramInt), null);
      }
      paramString.recycle();
      return localBitmap;
      label141:
      ((Rect)localObject).left = 0;
      ((Rect)localObject).top = ((k - j) / 2);
    }
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    Object localObject = null;
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong1);
    paramQQAppInterface = localObject;
    if (localTroopFileTransferManager != null)
    {
      paramQQAppInterface = localObject;
      if (!TextUtils.isEmpty(paramString1)) {
        paramQQAppInterface = localTroopFileTransferManager.a(UUID.fromString(paramString1));
      }
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      paramString1 = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = localTroopFileTransferManager.a(paramString2);
      }
    }
    paramQQAppInterface = new TroopFileStatusInfo(paramString1);
    if (TextUtils.isEmpty(paramQQAppInterface.jdField_e_of_type_JavaLangString)) {
      paramQQAppInterface.jdField_e_of_type_JavaLangString = paramString3;
    }
    if (paramQQAppInterface.b == 0L) {
      paramQQAppInterface.b = paramLong2;
    }
    if (paramInt != 0) {
      paramQQAppInterface.jdField_e_of_type_Int = paramInt;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.d)) {
      paramQQAppInterface.d = paramString2;
    }
    return paramQQAppInterface;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    Object localObject = null;
    if (paramMessageForTroopFile == null) {
      return null;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localTroopFileTransferManager != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!TextUtils.isEmpty(paramMessageForTroopFile.uuid)) {
        paramQQAppInterface = localTroopFileTransferManager.a(UUID.fromString(paramMessageForTroopFile.uuid));
      }
    }
    localObject = paramQQAppInterface;
    if (localTroopFileTransferManager != null)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        localObject = paramQQAppInterface;
        if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
          localObject = localTroopFileTransferManager.a(paramMessageForTroopFile.url);
        }
      }
    }
    paramQQAppInterface = new TroopFileStatusInfo((TroopFileStatusInfo)localObject);
    if (TextUtils.isEmpty(paramQQAppInterface.jdField_e_of_type_JavaLangString)) {
      paramQQAppInterface.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.fileName;
    }
    if (paramQQAppInterface.b == 0L) {
      paramQQAppInterface.b = paramMessageForTroopFile.fileSize;
    }
    if (paramMessageForTroopFile.bisID != 0) {
      paramQQAppInterface.jdField_e_of_type_Int = paramMessageForTroopFile.bisID;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
      paramQQAppInterface.d = paramMessageForTroopFile.url;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.frienduin)) {
      paramQQAppInterface.a = Long.valueOf(paramMessageForTroopFile.frienduin).longValue();
    }
    return paramQQAppInterface;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return a(paramQQAppInterface, paramFileManagerEntity.TroopUin, paramFileManagerEntity.strTroopFileID, paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.busId);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.0");
    double d1 = 1024.0D * 1024.0D;
    double d2 = 1024.0D * d1;
    if (paramLong < d1) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < d2) {
      return localDecimalFormat.format(paramLong / d1) + "M";
    }
    return localDecimalFormat.format(paramLong / d2) + "G";
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong = 1000L * paramLong;
    long l = System.currentTimeMillis();
    if (paramLong <= l) {
      return paramContext.getString(2131363285);
    }
    paramLong = (paramLong - l) / 86400000L;
    return paramLong + 1L + paramContext.getString(2131363284);
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = "";
    }
    int j;
    do
    {
      do
      {
        return localObject;
        j = paramString.lastIndexOf(".");
        if (j == -1) {
          break;
        }
        localObject = paramString;
      } while (j <= 9);
      if (j != -1) {
        break;
      }
      localObject = paramString;
    } while (paramString.length() <= 13);
    String str;
    if (j == -1)
    {
      str = "";
      localObject = paramString;
      paramString = str;
    }
    for (;;)
    {
      localObject = ((String)localObject).substring(0, 3) + "..." + ((String)localObject).substring(((String)localObject).length() - 3);
      return (String)localObject + paramString;
      localObject = paramString.substring(j);
      str = paramString.substring(0, j);
      paramString = (String)localObject;
      localObject = str;
    }
  }
  
  public static void a(Context paramContext, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString1, String paramString2)
  {
    Toast.makeText(paramContext, paramString1, 0).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopFileError.a(paramQQAppInterface, paramLong, 106);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, long paramLong1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong2, long paramLong3, String paramString6, String paramString7, int paramInt2)
  {
    long l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = System.currentTimeMillis();
    }
    long l2;
    label34:
    int j;
    if (l1 < 1L)
    {
      paramLong1 = 0L;
      if (paramLong1 > 0L) {
        break label478;
      }
      paramLong1 = 0L;
      l2 = 0L;
      j = HttpUtil.a();
      if ((j >= AppConstants.b.length) || (j < 0)) {
        break label499;
      }
    }
    label478:
    label499:
    for (String str = AppConstants.b[j];; str = "NONE")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("netType", str);
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("troopUin", String.valueOf(paramString3));
      localHashMap.put("filePath", paramString5);
      localHashMap.put("errorCode", String.valueOf(paramInt1));
      localHashMap.put("transferedSize", String.valueOf(paramLong2));
      localHashMap.put("fileSize", String.valueOf(paramLong3));
      localHashMap.put("url", String.valueOf(paramString6));
      localHashMap.put("rspHeader", String.valueOf(paramString7));
      localHashMap.put("retry", String.valueOf(paramInt2));
      if (paramBoolean == true) {}
      for (j = 0;; j = 1)
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "troop_troopfile", paramString1, 0, j, paramString3, paramString4, paramLong1 + "KB/s", localHashMap.toString());
        if (QLog.isColorLevel()) {
          QLog.d("BizTechReport", 2, "ReportTransferFailedInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(paramBoolean) + "], errorCode[" + String.valueOf(paramInt1) + "], startTime[" + String.valueOf(l1) + "], duration[" + String.valueOf(l2) + "],  transferSize[" + String.valueOf(paramLong2) + "], fileSize[" + String.valueOf(paramLong3) + "], fileType[" + paramString4 + "], netType[" + str + "], fileTransferSpeed[" + String.valueOf(paramLong1) + " KB/s], serverip[" + paramString2 + "], url[" + String.valueOf(paramString6) + "], rspHeader[" + String.valueOf(paramString7) + "], retryTimes[" + String.valueOf(paramInt2) + "]");
        }
        return;
        paramLong1 = System.currentTimeMillis() - l1;
        break;
        long l3 = paramLong2 / paramLong1;
        l2 = paramLong1;
        paramLong1 = l3;
        break label34;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopInfo localTroopInfo = ((FriendManager)paramQQAppInterface.getManager(8)).a(paramLong + "");
    return (localTroopInfo != null) && (((localTroopInfo.troopowneruin != null) && (paramQQAppInterface.a().equals(localTroopInfo.troopowneruin))) || ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(paramQQAppInterface.a()))));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    Bitmap localBitmap = a(paramString1, paramInt);
    if (localBitmap == null) {}
    for (;;)
    {
      return false;
      paramString1 = new File(paramString2);
      if (paramString1.exists()) {
        paramString1.delete();
      }
      try
      {
        paramString1.createNewFile();
      }
      catch (IOException paramString2)
      {
        try
        {
          for (;;)
          {
            paramString1 = new FileOutputStream(paramString1);
            if (paramString1 == null) {
              break;
            }
            localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString1);
            localBitmap.recycle();
            try
            {
              paramString1.flush();
              paramString1.close();
              return true;
            }
            catch (IOException paramString1)
            {
              paramString1.printStackTrace();
            }
            paramString2 = paramString2;
            paramString2.printStackTrace();
          }
        }
        catch (FileNotFoundException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUtils
 * JD-Core Version:    0.7.0.1
 */