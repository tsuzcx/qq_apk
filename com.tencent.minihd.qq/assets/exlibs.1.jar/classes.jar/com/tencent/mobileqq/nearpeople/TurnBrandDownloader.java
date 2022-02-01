package com.tencent.mobileqq.nearpeople;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import jku;
import jkv;
import jkw;

public class TurnBrandDownloader
{
  static int jdField_a_of_type_Int = 200;
  private static final String jdField_a_of_type_JavaLangString = "TurnBrandDownloader";
  private static final int jdField_b_of_type_Int = 1052688;
  private static final int jdField_c_of_type_Int = 2105376;
  private static final int d = 3158064;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TurnBrandDownloader.ImageCallback jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader$ImageCallback;
  private Queue jdField_a_of_type_JavaUtilQueue;
  private Stack jdField_a_of_type_JavaUtilStack;
  private boolean jdField_a_of_type_Boolean = true;
  private Handler jdField_b_of_type_AndroidOsHandler = new jkv(this);
  private Queue jdField_b_of_type_JavaUtilQueue;
  private Queue jdField_c_of_type_JavaUtilQueue;
  
  public TurnBrandDownloader(TurnBrandDownloader.ImageCallback paramImageCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader$ImageCallback = paramImageCallback;
    this.jdField_a_of_type_AndroidOsHandler = new jkw(this, ThreadManager.b());
    this.jdField_a_of_type_JavaUtilStack = new Stack();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_b_of_type_JavaUtilQueue = new LinkedList();
    this.c = new LinkedList();
  }
  
  private Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if (i > j) {
      if (i > jdField_a_of_type_Int)
      {
        j = i / jdField_a_of_type_Int;
        if (i % jdField_a_of_type_Int < jdField_a_of_type_Int / 2.0D) {
          break label160;
        }
      }
    }
    label160:
    for (i = j + 1;; i = j)
    {
      localOptions.inSampleSize = i;
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandDownloader", 2, "makeBitmap sampleSize=" + i);
      }
      localOptions.inJustDecodeBounds = false;
      try
      {
        paramFile = BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
        return paramFile;
      }
      catch (Exception paramFile)
      {
        return localBitmap;
      }
      catch (OutOfMemoryError paramFile)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TurnBrandDownloader", 2, "makeBitmap OutOfMemoryError happened!");
        return localBitmap;
      }
      i = j;
      break;
    }
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TurnBrand://").append(paramString);
    localObject = BaseApplicationImpl.a.get(((StringBuilder)localObject).toString());
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandDownloader", 2, "getBitmapFromCache: url: " + paramString + ", bitmap: " + localObject);
    }
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    return null;
  }
  
  private Bitmap a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new File(a(paramString1));
      boolean bool = HttpDownloadUtil.a(null, paramString2, (File)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandDownloader", 2, "getBitmapFromUrl: suc: " + bool);
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TurnBrandDownloader", 2, "getBitmapFromUrl: image size: " + ((File)localObject).length());
        }
        localObject = a((File)localObject);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TurnBrandDownloader", 2, "getBitmapFromUrl: tinyId: " + paramString1 + ", url: " + paramString2 + ", bitmap: " + localObject);
          }
          a(paramString2, (Bitmap)localObject);
        }
        return localObject;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (SystemUtil.a()) {}
    for (String str = AppConstants.bG;; str = SystemUtil.a + "turnbrand/")
    {
      localStringBuilder.append(str);
      str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandDownloader", 2, "sendRequest: mImageLoaderIdle: " + this.jdField_a_of_type_Boolean + ", mTurnBrandQueue size: " + this.jdField_a_of_type_JavaUtilStack.size() + ", mPreloadQueue size: " + this.jdField_a_of_type_JavaUtilQueue.size() + ", mRequestQueue size: " + this.jdField_b_of_type_JavaUtilQueue.size());
    }
    TurnBrandDownloader.ImageRef localImageRef;
    Message localMessage;
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
        break label169;
      }
      if ((!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) && (this.jdField_a_of_type_Boolean))
      {
        localImageRef = (TurnBrandDownloader.ImageRef)this.jdField_a_of_type_JavaUtilQueue.poll();
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1052688, localImageRef);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_JavaUtilQueue.offer(localImageRef);
      }
    }
    for (;;)
    {
      return;
      try
      {
        label169:
        if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
        {
          localImageRef = (TurnBrandDownloader.ImageRef)this.jdField_a_of_type_JavaUtilStack.pop();
          localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1052688, localImageRef);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_JavaUtilQueue.offer(localImageRef);
          return;
        }
      }
      catch (EmptyStackException localEmptyStackException)
      {
        localEmptyStackException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandDownloader", 2, "cancelLoadImages!");
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3158064);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TurnBrand://").append(paramString);
    paramString = localStringBuilder.toString();
    BaseApplicationImpl.a.put(paramString, paramBitmap);
    this.c.offer(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Bitmap localBitmap = a(paramString2);
    if (localBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandDownloader", 2, "downloadImage from cache: tinyId: " + paramString1 + ", faceUrl: " + paramString2 + ", bitmap: " + localBitmap);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader$ImageCallback.a(localBitmap, paramString2);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() > 0) {
      this.jdField_a_of_type_JavaUtilStack.clear();
    }
    this.jdField_a_of_type_JavaUtilStack.push(new TurnBrandDownloader.ImageRef(this, paramString1, paramString2));
    d();
  }
  
  public void a(Queue paramQueue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandDownloader", 2, "preloadImages: " + paramQueue);
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 0) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    while (!paramQueue.isEmpty())
    {
      jku localjku = (jku)paramQueue.poll();
      this.jdField_a_of_type_JavaUtilQueue.offer(new TurnBrandDownloader.ImageRef(this, localjku.a, localjku.b));
    }
    d();
  }
  
  public void b()
  {
    while (!this.c.isEmpty())
    {
      String str = (String)this.c.poll();
      BaseApplicationImpl.a.remove(str);
    }
  }
  
  public void c()
  {
    try
    {
      if (SystemUtil.a()) {}
      for (Object localObject = AppConstants.bG;; localObject = SystemUtil.a + "turnbrand/")
      {
        localObject = new File((String)localObject);
        if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break;
        }
        localObject = ((File)localObject).listFiles();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.TurnBrandDownloader
 * JD-Core Version:    0.7.0.1
 */