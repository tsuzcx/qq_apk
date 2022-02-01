package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedList;
import kpl;
import kpm;

public class FaceDecoder
  implements FaceDecodeTask.DecodeCompletionListener
{
  public static final byte a = 1;
  private static final int jdField_a_of_type_Int = 5;
  private static final long jdField_a_of_type_Long = 300000L;
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.FaceDecoder";
  public static final byte b = 11;
  public static final byte c = 4;
  private static final int c = 4;
  public static final byte d = 101;
  public static final byte e = 103;
  public static final byte f = 100;
  public static final byte g = 32;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private kpl jdField_a_of_type_Kpl;
  private kpm jdField_a_of_type_Kpm;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public FaceDecoder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramFaceInfo);
      if (paramFaceInfo.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramFaceInfo);
      }
      while ((this.jdField_b_of_type_Int < 4) && (!this.jdField_a_of_type_Boolean))
      {
        e();
        return;
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramFaceInfo);
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    int i = 204;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "onUpdateHead, uin=" + paramString + ", type=" + paramInt1 + ",subtype=" + paramInt2 + ",isSuccess=" + paramBoolean + ", mPause=" + this.jdField_a_of_type_Boolean);
    }
    String str = FaceInfo.a(paramInt1, paramString, paramInt2);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      if (paramInt1 == 32) {
        if (paramInt2 == 202) {
          i = 3001;
        }
      }
      do
      {
        for (;;)
        {
          Bitmap localBitmap = a(paramInt1, paramString, i);
          if (localBitmap == null) {
            break;
          }
          this.jdField_a_of_type_JavaUtilHashMap.remove(str);
          if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener.a(this.jdField_b_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramInt1, paramString, localBitmap);
          }
          return;
          if (paramInt2 != 204) {
            i = 3000;
          }
        }
        if ((FaceInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str) != null)
        {
          a((FaceInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str));
          return;
        }
        paramString = (FaceInfo)this.jdField_b_of_type_JavaUtilHashMap.remove(str);
      } while (paramString == null);
      paramString.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramString);
      a(paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(str);
  }
  
  protected static void b(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo.jdField_a_of_type_Int == 1) || (paramFaceInfo.jdField_a_of_type_Int == 103)) {
      ((FriendListHandler)paramQQAppInterface.a(1)).a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_c_of_type_Byte, paramFaceInfo.jdField_a_of_type_Byte, paramFaceInfo.jdField_b_of_type_Byte, paramFaceInfo.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramFaceInfo.jdField_a_of_type_Int == 11)
      {
        ((FriendListHandler)paramQQAppInterface.a(1)).b(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (paramFaceInfo.jdField_a_of_type_Int == 4)
      {
        ((FriendListHandler)paramQQAppInterface.a(1)).a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_b_of_type_Byte);
        return;
      }
    } while (paramFaceInfo.jdField_a_of_type_Int != 32);
    ((FriendListHandler)paramQQAppInterface.a(1)).a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_c_of_type_Int, paramFaceInfo.jdField_a_of_type_Byte, paramFaceInfo.jdField_b_of_type_Byte);
  }
  
  private void e()
  {
    localObject1 = null;
    do
    {
      try
      {
        FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if ((localFaceInfo.jdField_a_of_type_Int == 101) && (this.jdField_a_of_type_Kpl == null))
          {
            this.jdField_a_of_type_Kpl = new kpl(this, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Kpl);
          }
          this.jdField_b_of_type_Int += 1;
          FaceDecodeTask.a(new FaceDecodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceInfo, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject1 = localThrowable1;
            Object localObject2 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      this.jdField_b_of_type_Int -= 1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.FaceDecoder", 2, "runNextTask Exception. faceInfo=" + localObject1, localThrowable1);
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    if (paramInt == 32) {
      return null;
    }
    byte b1 = 3;
    if (paramInt == 101) {
      b1 = 1;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, b1, 0);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 101) {}
    for (byte b1 = 1;; b1 = 3)
    {
      int j = 0;
      int i = j;
      if (paramInt1 == 32)
      {
        if (paramInt2 != 3000) {
          break label57;
        }
        i = 200;
      }
      for (;;)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString, b1, i);
        return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
        label57:
        if (paramInt2 == 3001)
        {
          i = 202;
        }
        else
        {
          i = j;
          if (paramInt2 == 3002) {
            i = 204;
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    this.jdField_b_of_type_Int -= 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "onDecodeTaskCompletedNeedDownload, uin=" + paramFaceInfo.jdField_a_of_type_JavaLangString + ", iRunningRequests=" + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramFaceInfo.a()))
    {
      if (this.jdField_a_of_type_Kpm == null)
      {
        this.jdField_a_of_type_Kpm = new kpm(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Kpm);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFaceInfo);
    }
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_b_of_type_Int < 4)) {
      e();
    }
  }
  
  public void a(FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "onDecodeTaskCompleted, uin=" + paramFaceInfo.jdField_a_of_type_JavaLangString + ", iRunningRequests=" + this.jdField_b_of_type_Int + ", readyRequests=" + this.jdField_a_of_type_JavaUtilLinkedList.size() + ", avatar=" + paramBitmap + ", listener=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramFaceInfo.a());
    this.jdField_b_of_type_Int -= 1;
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (!this.jdField_a_of_type_Boolean)) {
      e();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener != null) && (paramBitmap != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener.a(this.jdField_b_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {
      return;
    }
    int i;
    if (paramInt == 3000) {
      i = 200;
    }
    for (;;)
    {
      FaceInfo localFaceInfo = new FaceInfo(32, paramString, false, (byte)1, 3, null, false, paramInt, i);
      String str = FaceInfo.a(32, paramString, i);
      if (this.jdField_b_of_type_JavaUtilHashMap.get(str) == null) {
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localFaceInfo);
      }
      if (this.jdField_a_of_type_Kpm == null)
      {
        this.jdField_a_of_type_Kpm = new kpm(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Kpm);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, paramInt, paramLong);
      return;
      if (paramInt == 3001)
      {
        i = 202;
      }
      else
      {
        if (paramInt != 3002) {
          break;
        }
        i = 204;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Entity paramEntity, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    String str = null;
    int i = -1;
    if ((paramEntity instanceof Friends))
    {
      str = ((Friends)paramEntity).uin;
      i = 1;
    }
    for (;;)
    {
      if (str != null)
      {
        if (a(i, str) != null) {
          bool2 = true;
        }
        bool1 = bool2;
        if (!bool2) {
          bool1 = a(str, i, paramBoolean);
        }
      }
      return bool1;
      if ((paramEntity instanceof PublicAccountInfo))
      {
        str = String.valueOf(((PublicAccountInfo)paramEntity).uin);
        i = 1;
      }
      else if ((paramEntity instanceof TroopInfo))
      {
        str = ((TroopInfo)paramEntity).troopuin;
        i = 4;
      }
      else if ((paramEntity instanceof DiscussionInfo))
      {
        str = ((DiscussionInfo)paramEntity).uin;
        i = 101;
      }
    }
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, (byte)0);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean, byte paramByte)
  {
    return a(paramString, 0, false, paramInt, paramBoolean, paramByte, null);
  }
  
  public boolean a(String paramString1, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() < 5) || ((paramInt2 == 100) && ((paramString2 == null) || (TextUtils.isEmpty(paramString2)))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoder", 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString1 + ", encid=" + paramString2);
      }
      return false;
    }
    int j = 200;
    int i = j;
    if (paramInt2 == 32)
    {
      if (paramInt1 != 3000) {
        break label221;
      }
      i = 200;
    }
    String str;
    long l;
    for (;;)
    {
      str = FaceInfo.a(paramInt2, paramString1, i);
      FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      l = SystemClock.uptimeMillis();
      if ((localFaceInfo == null) || (Math.abs(localFaceInfo.jdField_a_of_type_Long - l) >= 300000L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoder", 2, "requestDecodeFace, uin repeat. uin=" + paramString1);
      }
      if ((localFaceInfo.jdField_a_of_type_Boolean) && (!paramBoolean2)) {
        localFaceInfo.jdField_a_of_type_Boolean = false;
      }
      return true;
      label221:
      if (paramInt1 == 3001)
      {
        i = 202;
      }
      else
      {
        i = j;
        if (paramInt1 == 3002) {
          i = 204;
        }
      }
    }
    j = 3;
    if (paramInt2 == 101) {
      j = 1;
    }
    paramString2 = new FaceInfo(paramInt2, paramString1, paramBoolean2, paramByte, j, paramString2, false, paramInt1, i);
    paramString2.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "requestDecodeFace. uin=" + paramString1 + ", type=" + paramInt2 + ", iRunningRequests=" + this.jdField_b_of_type_Int + ", mPause=" + this.jdField_a_of_type_Boolean);
    }
    a(paramString2);
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, null);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    while ((this.jdField_b_of_type_Int < 4) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "cancelPendingRequests ");
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "destory ");
    }
    c();
    if (this.jdField_a_of_type_Kpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Kpl);
    }
    if (this.jdField_a_of_type_Kpm != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Kpm);
      this.jdField_a_of_type_Kpm = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecoder
 * JD-Core Version:    0.7.0.1
 */