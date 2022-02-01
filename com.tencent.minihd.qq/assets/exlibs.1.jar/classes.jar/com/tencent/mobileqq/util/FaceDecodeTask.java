package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kpi;
import kpj;

public class FaceDecodeTask
{
  public static final int a = 1;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static Looper jdField_a_of_type_AndroidOsLooper;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.FaceDecodeTask";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static kpj[] jdField_a_of_type_ArrayOfKpj;
  public static final int b = 4;
  public static final int c = 11;
  public static final int d = 101;
  private static int e = 111;
  private static int f = 2;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceInfo jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = null;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public FaceDecodeTask(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDecodeCompletionListener);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a()
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilArrayList != null) {
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if (jdField_a_of_type_AndroidOsHandler != null) {
          jdField_a_of_type_AndroidOsHandler.removeMessages(e);
        }
        if (jdField_a_of_type_ArrayOfKpj != null)
        {
          i = 0;
          if (i < jdField_a_of_type_ArrayOfKpj.length)
          {
            if (jdField_a_of_type_ArrayOfKpj[i] == null) {
              break label107;
            }
            jdField_a_of_type_ArrayOfKpj[i].a();
            break label107;
          }
        }
        synchronized (jdField_a_of_type_JavaUtilArrayList)
        {
          jdField_a_of_type_JavaUtilArrayList.notifyAll();
          jdField_a_of_type_ArrayOfKpj = null;
          jdField_a_of_type_AndroidOsLooper = null;
          jdField_a_of_type_AndroidOsHandler = null;
          return;
        }
      }
      label107:
      i += 1;
    }
  }
  
  public static void a(FaceDecodeTask paramFaceDecodeTask)
  {
    
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramFaceDecodeTask);
      jdField_a_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  private static void b()
  {
    if (jdField_a_of_type_ArrayOfKpj == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ArrayOfKpj == null)
        {
          jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
          jdField_a_of_type_AndroidOsHandler = new kpi(jdField_a_of_type_AndroidOsLooper);
          jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          jdField_a_of_type_ArrayOfKpj = new kpj[f];
          int i = 0;
          while (i < jdField_a_of_type_ArrayOfKpj.length)
          {
            jdField_a_of_type_ArrayOfKpj[i] = new kpj(null);
            jdField_a_of_type_ArrayOfKpj[i].start();
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  private static void c(FaceDecodeTask paramFaceDecodeTask)
  {
    byte b1 = 0;
    if ((paramFaceDecodeTask == null) || (paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null)) {}
    for (;;)
    {
      return;
      FaceInfo localFaceInfo = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo;
      try
      {
        if (localFaceInfo.jdField_a_of_type_Int == 101)
        {
          paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap = ((DiscussionHandler)paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(localFaceInfo.jdField_a_of_type_JavaLangString, false);
          paramFaceDecodeTask.jdField_a_of_type_Boolean = false;
          try
          {
            jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
            return;
          }
          catch (Exception paramFaceDecodeTask) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
          return;
        }
        Object localObject1;
        if ((localFaceInfo.jdField_a_of_type_Int == 4) && (((HotChatManager)paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).d(localFaceInfo.jdField_a_of_type_JavaLangString)))
        {
          localObject1 = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localFaceInfo.jdField_a_of_type_Int, localFaceInfo.jdField_a_of_type_JavaLangString, (byte)localFaceInfo.jdField_b_of_type_Int, localFaceInfo.d);
          paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject1);
          if (paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap == null)
          {
            int i = HotChatManager.a(localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.a.getResources(), i);
            paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject1, paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          try
          {
            jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
            return;
          }
          catch (Exception paramFaceDecodeTask) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
          return;
        }
        if (!paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localFaceInfo.jdField_a_of_type_Int, localFaceInfo.jdField_a_of_type_JavaLangString, localFaceInfo.d)) {}
        for (boolean bool = true;; bool = false)
        {
          paramFaceDecodeTask.jdField_a_of_type_Boolean = bool;
          bool = paramFaceDecodeTask.jdField_a_of_type_Boolean;
          if (!bool) {
            break label396;
          }
          try
          {
            jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
            return;
          }
          catch (Exception paramFaceDecodeTask) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
          return;
        }
        label396:
        if (localFaceInfo.jdField_a_of_type_Int != 101)
        {
          localObject1 = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localFaceInfo.jdField_a_of_type_Int, localFaceInfo.jdField_a_of_type_JavaLangString, localFaceInfo.d);
          if ((localObject1 != null) && (((Boolean)((Pair)localObject1).first).booleanValue()))
          {
            localFaceInfo.jdField_b_of_type_Byte = 1;
            FaceDecoder.b(paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
          }
        }
        switch (localFaceInfo.jdField_a_of_type_Byte)
        {
        case 1: 
        case 2: 
          for (;;)
          {
            paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localFaceInfo.jdField_a_of_type_Int, localFaceInfo.jdField_a_of_type_JavaLangString, (byte)localFaceInfo.jdField_b_of_type_Int, false, b1, localFaceInfo.d);
            if ((QLog.isColorLevel()) && (paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
              QLog.d("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString);
            }
            try
            {
              jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
              return;
            }
            catch (Exception paramFaceDecodeTask) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
            return;
            b1 = 2;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, localThrowable);
        }
        try
        {
          jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
          return;
        }
        catch (Exception paramFaceDecodeTask) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
        return;
      }
      finally
      {
        for (;;)
        {
          try
          {
            jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
            throw localObject2;
          }
          catch (Exception paramFaceDecodeTask)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
            continue;
          }
          b1 = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */