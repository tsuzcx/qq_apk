package com.tencent.biz.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;
import cgg;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;

public class QQHeadFace
{
  public static final String a = "com.tencent.qqhead.getheadreq";
  public static final String b = "com.tencent.qqhead.getheadresp";
  private float jdField_a_of_type_Float = 1.0F;
  private final int jdField_a_of_type_Int = 60;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cgg(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
  private QQHeadFace.IGetQQHeadCallBack jdField_a_of_type_ComTencentBizHelperQQHeadFace$IGetQQHeadCallBack;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int = 54;
  private LruCache jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
  private int c = 54;
  
  public QQHeadFace(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    b();
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int j = this.jdField_b_of_type_Int;
    int i = this.c;
    float f2 = this.jdField_a_of_type_Float;
    int k = paramBitmap.getWidth();
    float f1 = f2;
    if (k > 0)
    {
      f1 = f2;
      if (k < j * f2) {
        f1 = k / j;
      }
    }
    j = (int)(j * f1);
    i = (int)(f1 * i);
    return ImageUtil.a(paramBitmap, j, j, i);
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
    paramString = new Intent("com.tencent.qqhead.getheadreq");
    paramString.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramString.putExtra("faceType", paramInt);
    paramString.putStringArrayListExtra("uinList", this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramString, "com.tencent.qqhead.permission.getheadresp2");
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qqhead.getheadresp");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp2", null);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  /* Error */
  public Bitmap a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/biz/helper/QQHeadFace:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   4: aload_1
    //   5: invokevirtual 160	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 86	android/graphics/Bitmap
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +6 -> 21
    //   18: aload 4
    //   20: areturn
    //   21: aload_0
    //   22: getfield 36	com/tencent/biz/helper/QQHeadFace:jdField_b_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   25: aload_1
    //   26: invokevirtual 160	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 162	java/lang/String
    //   32: astore 4
    //   34: aload 4
    //   36: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +101 -> 140
    //   42: aload 4
    //   44: invokestatic 174	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnull +76 -> 127
    //   54: aload_0
    //   55: aload 5
    //   57: invokespecial 176	com/tencent/biz/helper/QQHeadFace:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   60: astore 4
    //   62: aload 5
    //   64: invokevirtual 180	android/graphics/Bitmap:isRecycled	()Z
    //   67: ifne +8 -> 75
    //   70: aload 5
    //   72: invokevirtual 183	android/graphics/Bitmap:recycle	()V
    //   75: aload 4
    //   77: ifnull +45 -> 122
    //   80: aload_0
    //   81: getfield 34	com/tencent/biz/helper/QQHeadFace:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   84: aload_1
    //   85: aload 4
    //   87: invokevirtual 187	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload 4
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 190	java/lang/OutOfMemoryError:printStackTrace	()V
    //   99: aload_0
    //   100: getfield 49	com/tencent/biz/helper/QQHeadFace:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   103: areturn
    //   104: astore 5
    //   106: aload 5
    //   108: invokevirtual 191	java/lang/Exception:printStackTrace	()V
    //   111: goto -36 -> 75
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 191	java/lang/Exception:printStackTrace	()V
    //   119: goto -20 -> 99
    //   122: aload_0
    //   123: getfield 49	com/tencent/biz/helper/QQHeadFace:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   126: areturn
    //   127: iload_3
    //   128: ifeq -29 -> 99
    //   131: aload_0
    //   132: aload_1
    //   133: iload_2
    //   134: invokespecial 193	com/tencent/biz/helper/QQHeadFace:a	(Ljava/lang/String;I)V
    //   137: goto -38 -> 99
    //   140: iload_3
    //   141: ifeq -42 -> 99
    //   144: aload_0
    //   145: aload_1
    //   146: iload_2
    //   147: invokespecial 193	com/tencent/biz/helper/QQHeadFace:a	(Ljava/lang/String;I)V
    //   150: goto -51 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	QQHeadFace
    //   0	153	1	paramString	String
    //   0	153	2	paramInt	int
    //   0	153	3	paramBoolean	boolean
    //   11	81	4	localObject	Object
    //   47	24	5	localBitmap	Bitmap
    //   104	3	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	13	94	java/lang/OutOfMemoryError
    //   21	49	94	java/lang/OutOfMemoryError
    //   54	62	94	java/lang/OutOfMemoryError
    //   62	75	94	java/lang/OutOfMemoryError
    //   80	91	94	java/lang/OutOfMemoryError
    //   106	111	94	java/lang/OutOfMemoryError
    //   122	127	94	java/lang/OutOfMemoryError
    //   131	137	94	java/lang/OutOfMemoryError
    //   144	150	94	java/lang/OutOfMemoryError
    //   62	75	104	java/lang/Exception
    //   0	13	114	java/lang/Exception
    //   21	49	114	java/lang/Exception
    //   54	62	114	java/lang/Exception
    //   80	91	114	java/lang/Exception
    //   106	111	114	java/lang/Exception
    //   122	127	114	java/lang/Exception
    //   131	137	114	java/lang/Exception
    //   144	150	114	java/lang/Exception
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
    c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(QQHeadFace.IGetQQHeadCallBack paramIGetQQHeadCallBack)
  {
    this.jdField_a_of_type_ComTencentBizHelperQQHeadFace$IGetQQHeadCallBack = paramIGetQQHeadCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.helper.QQHeadFace
 * JD-Core Version:    0.7.0.1
 */