package com.tencent.mobileqq.dating;

import EncounterSvc.NeighborBanner;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearbyBannerMgr
  implements Handler.Callback, URLDrawable.URLDrawableListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  volatile boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_b_of_type_AndroidOsHandler;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  volatile boolean jdField_b_of_type_Boolean = false;
  List c;
  
  public NearbyBannerMgr(NearbyActivity paramNearbyActivity, Handler paramHandler, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.c = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramNearbyActivity.getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramNearbyActivity.app;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    if (a(a(), false, true)) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  /* Error */
  private List a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 88	java/io/ObjectInputStream
    //   5: dup
    //   6: new 90	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 54	com/tencent/mobileqq/dating/NearbyBannerMgr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   14: new 92	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: getfield 59	com/tencent/mobileqq/dating/NearbyBannerMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 98	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   28: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 104
    //   33: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokevirtual 113	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   42: invokespecial 116	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 117	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: invokevirtual 121	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   55: checkcast 123	java/util/List
    //   58: astore_3
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 126	java/io/ObjectInputStream:close	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 134
    //   78: iconst_2
    //   79: new 92	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   86: ldc 136
    //   88: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload_3
    //   105: areturn
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +33 -> 147
    //   117: aload_2
    //   118: astore_1
    //   119: ldc 134
    //   121: iconst_2
    //   122: new 92	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   129: ldc 145
    //   131: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 146	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   138: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 126	java/io/ObjectInputStream:close	()V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_1
    //   158: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +31 -> 192
    //   164: ldc 134
    //   166: iconst_2
    //   167: new 92	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   174: ldc 136
    //   176: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   183: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_3
    //   195: aload_1
    //   196: astore_2
    //   197: aload_3
    //   198: astore_1
    //   199: aload_2
    //   200: ifnull +7 -> 207
    //   203: aload_2
    //   204: invokevirtual 126	java/io/ObjectInputStream:close	()V
    //   207: aload_1
    //   208: athrow
    //   209: astore_2
    //   210: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -6 -> 207
    //   216: ldc 134
    //   218: iconst_2
    //   219: new 92	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   226: ldc 136
    //   228: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   235: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto -37 -> 207
    //   247: astore_3
    //   248: aload_1
    //   249: astore_2
    //   250: aload_3
    //   251: astore_1
    //   252: goto -53 -> 199
    //   255: astore_3
    //   256: goto -147 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	NearbyBannerMgr
    //   1	50	1	localObject1	Object
    //   69	23	1	localIOException1	java.io.IOException
    //   110	9	1	localObject2	Object
    //   157	39	1	localIOException2	java.io.IOException
    //   198	54	1	localObject3	Object
    //   48	156	2	localObject4	Object
    //   209	23	2	localIOException3	java.io.IOException
    //   249	1	2	localObject5	Object
    //   58	47	3	localList	List
    //   106	29	3	localException1	java.lang.Exception
    //   194	4	3	localObject6	Object
    //   247	4	3	localObject7	Object
    //   255	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	67	69	java/io/IOException
    //   2	49	106	java/lang/Exception
    //   151	155	157	java/io/IOException
    //   2	49	194	finally
    //   203	207	209	java/io/IOException
    //   51	59	247	finally
    //   111	117	247	finally
    //   119	147	247	finally
    //   51	59	255	java/lang/Exception
  }
  
  private List a(boolean paramBoolean)
  {
    int j = 0;
    this.jdField_b_of_type_Boolean = false;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2;
    int i;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        localArrayList2 = new ArrayList(this.c);
        i = 0;
        if ((i >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_b_of_type_Boolean)) {
          break;
        }
        if (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(i))) {
          i += 1;
        }
      }
      NeighborBanner localNeighborBanner = (NeighborBanner)this.jdField_a_of_type_JavaUtilList.get(i);
      String str = new String(localNeighborBanner.pic_url);
      URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      ??? = localURLDrawable;
      if (localURLDrawable == null)
      {
        ??? = URLDrawable.getDrawable(str);
        ((URLDrawable)???).setURLDrawableListener(this);
        ((URLDrawable)???).startDownload();
        this.jdField_a_of_type_JavaUtilHashMap.put(str, ???);
      }
      int k = ((URLDrawable)???).getStatus();
      if (k == 1)
      {
        k = localNeighborBanner.postion;
        if ((k - 1 <= localArrayList1.size() + localArrayList2.size()) && (k > 0)) {
          localArrayList1.add(Integer.valueOf(i));
        }
      }
      else if ((k == 3) || (k == 2))
      {
        ((URLDrawable)???).restartDownload();
      }
    }
    if (localArrayList1.size() != 0)
    {
      i = j;
      if (!this.jdField_b_of_type_Boolean) {}
    }
    else
    {
      return null;
    }
    while ((i < localArrayList1.size()) && (!this.jdField_b_of_type_Boolean))
    {
      ??? = (NeighborBanner)this.jdField_a_of_type_JavaUtilList.get(((Integer)localArrayList1.get(i)).intValue());
      if (??? != null) {
        localArrayList2.add(((NeighborBanner)???).postion - 1, ???);
      }
      i += 1;
    }
    if (i == localArrayList1.size())
    {
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
      if (paramBoolean) {
        return localArrayList2;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, localArrayList2).sendToTarget();
      }
    }
    return null;
  }
  
  private boolean a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    localList = this.jdField_a_of_type_JavaUtilList;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (!paramBoolean2) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        bool1 = true;
        paramBoolean1 = bool1;
        if (paramList != null) {
          paramBoolean1 = bool1 | this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
        return paramBoolean1;
      }
      finally {}
      paramBoolean1 = bool1;
      if (!this.jdField_a_of_type_Boolean)
      {
        paramBoolean1 = bool1;
        if (paramList != null) {
          paramBoolean1 = this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 236	java/io/ObjectOutputStream
    //   5: dup
    //   6: new 238	java/io/BufferedOutputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 54	com/tencent/mobileqq/dating/NearbyBannerMgr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   14: new 92	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: getfield 59	com/tencent/mobileqq/dating/NearbyBannerMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 98	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   28: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 104
    //   33: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: iconst_0
    //   40: invokevirtual 242	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   43: invokespecial 245	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: invokespecial 246	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: getfield 40	com/tencent/mobileqq/dating/NearbyBannerMgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   56: astore_3
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: monitorenter
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 40	com/tencent/mobileqq/dating/NearbyBannerMgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   66: invokevirtual 250	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   69: aload_3
    //   70: monitorexit
    //   71: aload_2
    //   72: astore_1
    //   73: aload_2
    //   74: invokevirtual 253	java/io/ObjectOutputStream:flush	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 254	java/io/ObjectOutputStream:close	()V
    //   85: return
    //   86: astore 4
    //   88: aload_3
    //   89: monitorexit
    //   90: aload_2
    //   91: astore_1
    //   92: aload 4
    //   94: athrow
    //   95: astore_3
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 257	java/lang/Exception:printStackTrace	()V
    //   102: aload_2
    //   103: ifnull -18 -> 85
    //   106: aload_2
    //   107: invokevirtual 254	java/io/ObjectOutputStream:close	()V
    //   110: return
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   116: return
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   122: return
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload_3
    //   127: astore_1
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 254	java/io/ObjectOutputStream:close	()V
    //   136: aload_1
    //   137: athrow
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   143: goto -7 -> 136
    //   146: astore_3
    //   147: aload_1
    //   148: astore_2
    //   149: aload_3
    //   150: astore_1
    //   151: goto -23 -> 128
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: goto -61 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	NearbyBannerMgr
    //   1	97	1	localObject1	Object
    //   111	2	1	localIOException1	java.io.IOException
    //   117	8	1	localIOException2	java.io.IOException
    //   127	24	1	localObject2	Object
    //   49	84	2	localObject3	Object
    //   138	2	2	localIOException3	java.io.IOException
    //   148	9	2	localObject4	Object
    //   56	33	3	localList	List
    //   95	4	3	localException1	java.lang.Exception
    //   123	4	3	localObject5	Object
    //   146	4	3	localObject6	Object
    //   154	1	3	localException2	java.lang.Exception
    //   86	7	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   61	71	86	finally
    //   88	90	86	finally
    //   52	57	95	java/lang/Exception
    //   59	61	95	java/lang/Exception
    //   73	77	95	java/lang/Exception
    //   92	95	95	java/lang/Exception
    //   106	110	111	java/io/IOException
    //   81	85	117	java/io/IOException
    //   2	50	123	finally
    //   132	136	138	java/io/IOException
    //   52	57	146	finally
    //   59	61	146	finally
    //   73	77	146	finally
    //   92	95	146	finally
    //   98	102	146	finally
    //   2	50	154	java/lang/Exception
  }
  
  public List a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBoolean1) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (a(paramList, true, paramBoolean1))
    {
      paramList = localObject2;
      if (paramBoolean2) {
        paramList = a(true);
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    do
    {
      do
      {
        return paramList;
        paramList = localObject1;
      } while (paramBoolean1);
      paramList = localObject1;
    } while (this.jdField_b_of_type_JavaUtilList.size() >= this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(2);
    return null;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
    case 2: 
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
      a(false);
      return false;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    b();
    return false;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyBannerMgr
 * JD-Core Version:    0.7.0.1
 */