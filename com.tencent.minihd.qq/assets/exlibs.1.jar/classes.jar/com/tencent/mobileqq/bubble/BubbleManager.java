package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import hut;
import huu;
import huv;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleManager
  implements Manager
{
  public static long a = 0L;
  public static final String a;
  public static volatile boolean a = false;
  public static final String b = "%04d.png";
  public static final String c = "bubble_info";
  public static final String d = "file:///android_assets/bubbles/";
  public static final String e = "aio_user_bg_nor.9.png";
  public static final String f = "aio_user_pic_nor.9.png";
  public static final String g = "chat_bubble_thumbnail.png";
  protected static final String h = "Bubble_download_succ";
  protected static final String i = "Bubble_download_cancel";
  protected static final String j = "Bubble_download";
  public static final String k = "bubble_local.cfg";
  public static final String l = "id";
  public static final String m = "version";
  public static final String n = "update";
  public static final String o = "full_download";
  public static final String p = "updatelist";
  private static final String q = "https://i.gtimg.cn/club/item/avatar/zip/%1$d/a%2$d/%3$s";
  private static final String r = "https://i.gtimg.cn/club/item/avatar/json/%1$d/a%2$d/%3$s";
  float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 2000000;
  protected Context a;
  protected AppInterface a;
  public BubbleManager.BubbleInfoLruCache a;
  public BubbleManager.LruLinkedHashMap a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new hut(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  public IPCDownloadListener a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  protected Vector a;
  public ConcurrentHashMap a;
  JSONArray jdField_a_of_type_OrgJsonJSONArray = null;
  DownloadListener b = new huu(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  
  static
  {
    jdField_a_of_type_JavaLangString = BubbleManager.class.getSimpleName();
    jdField_a_of_type_Long = 1000L;
  }
  
  public BubbleManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache = null;
    this.jdField_a_of_type_JavaUtilVector = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = null;
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache = new BubbleManager.BubbleInfoLruCache(this, 10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = new BubbleManager.LruLinkedHashMap(this, 6);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramAppInterface.getManager(46));
    paramAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if (paramAppInterface.density == 160.0F) {}
    for (float f1 = 1.0F;; f1 = paramAppInterface.density)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_a_of_type_OrgJsonJSONArray = a();
      this.jdField_a_of_type_JavaUtilVector = new Vector(16);
      return;
    }
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("T")) {
        if (paramBoolean) {}
      }
      do
      {
        return 3;
        return 4;
        if (paramString.equals("L"))
        {
          if (!paramBoolean) {
            return 2;
          }
          return 7;
        }
        if (paramString.equals("TL"))
        {
          if (!paramBoolean) {
            return 0;
          }
          return 5;
        }
        if (!paramString.equals("B")) {
          break;
        }
      } while (paramBoolean);
      return 4;
      if (paramString.equals("BL"))
      {
        if (!paramBoolean) {
          return 1;
        }
        return 6;
      }
      if (paramString.equals("R"))
      {
        if (!paramBoolean) {
          return 7;
        }
        return 2;
      }
      if (paramString.equals("TR"))
      {
        if (!paramBoolean) {
          return 5;
        }
        return 0;
      }
      if (paramString.equals("BR"))
      {
        if (!paramBoolean) {
          return 6;
        }
        return 1;
      }
    }
    return -1;
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.set((int)(paramInt1 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt2 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt3 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt4 / 2.0F * this.jdField_a_of_type_Float));
    return localRect;
  }
  
  private AnimationConfig.AnimationStep a(String paramString, JSONObject paramJSONObject)
  {
    paramString = new AnimationConfig.AnimationStep();
    if (paramJSONObject.has("count")) {
      paramString.jdField_d_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("cycle_count")) {
      paramString.jdField_e_of_type_Int = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("prefix_name")) {
      paramString.jdField_a_of_type_JavaLangString = paramJSONObject.getString("prefix_name");
    }
    return paramString;
  }
  
  private AnimationConfig a(int paramInt, JSONObject paramJSONObject)
  {
    AnimationConfig localAnimationConfig = new AnimationConfig();
    localAnimationConfig.j = paramInt;
    if (paramJSONObject.has("rect"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
      localAnimationConfig.jdField_a_of_type_ArrayOfInt = new int[4];
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        localAnimationConfig.jdField_a_of_type_ArrayOfInt[paramInt] = localJSONArray.getInt(paramInt);
        paramInt += 1;
      }
    }
    if (paramJSONObject.has("cycle_count")) {
      localAnimationConfig.k = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("count")) {
      localAnimationConfig.l = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localAnimationConfig.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("second_zip_name")) {
      localAnimationConfig.jdField_c_of_type_JavaLangString = paramJSONObject.getString("second_zip_name");
    }
    if (paramJSONObject.has("align")) {
      localAnimationConfig.d = paramJSONObject.getString("align");
    }
    if ((!paramJSONObject.has("count_stiil")) || (paramJSONObject.has("alpha"))) {
      localAnimationConfig.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("alpha");
    }
    a(localAnimationConfig, paramJSONObject);
    localAnimationConfig.m = paramJSONObject.getInt("time");
    return localAnimationConfig;
  }
  
  private BubbleInfo.CommonAttrs a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AnimationConfig localAnimationConfig = a(paramInt, paramString);
    if (localAnimationConfig == null) {
      return null;
    }
    Object localObject2 = new BubbleInfo.CommonAttrs();
    ((BubbleInfo.CommonAttrs)localObject2).jdField_c_of_type_Int = localAnimationConfig.l;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_e_of_type_Int = localAnimationConfig.m;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_d_of_type_Int = localAnimationConfig.k;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_c_of_type_Boolean = localAnimationConfig.jdField_c_of_type_Boolean;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_g_of_type_Int = localAnimationConfig.n;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig = localAnimationConfig;
    File localFile;
    Object localObject1;
    int i1;
    label146:
    boolean bool;
    if (((BubbleInfo.CommonAttrs)localObject2).jdField_d_of_type_Int <= 1)
    {
      ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_Boolean = true;
      localFile = new File(a(paramInt, false), localAnimationConfig.jdField_a_of_type_JavaLangString);
      localObject1 = new String[localAnimationConfig.l];
      if (localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray != null) {
        break label493;
      }
      i1 = 0;
      if (i1 >= localObject1.length) {
        break label847;
      }
      localObject1[i1] = (localFile.getAbsolutePath() + File.separatorChar + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) }));
      bool = new File(localObject1[i1]).exists();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleSource|pngs[" + i1 + "]=" + localObject1[i1] + ",isFileExists=" + bool);
      }
      if (bool) {
        break label484;
      }
      i1 = 1;
    }
    for (;;)
    {
      label484:
      label493:
      int i3;
      int i2;
      label512:
      AnimationConfig.AnimationStep localAnimationStep;
      int i4;
      if ((paramBoolean1) && ((i1 != 0) || (a(paramInt, localAnimationConfig.jdField_a_of_type_JavaLangString).booleanValue())))
      {
        localObject1 = a(paramInt, localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        localObject2 = new File(a(paramInt, true), localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        paramString = new Bundle();
        paramString.putString("name", localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        paramString.putInt("id", paramInt);
        localObject1 = new DownloadTask((String)localObject1, (File)localObject2);
        ((DownloadTask)localObject1).e = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.b, paramString);
        return null;
        ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_Boolean = false;
        break;
        i1 += 1;
        break label146;
        int i5 = localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.size();
        i3 = 0;
        i2 = 0;
        i1 = 0;
        if (i3 >= i5) {
          break label844;
        }
        localAnimationStep = (AnimationConfig.AnimationStep)localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i3);
        i4 = 0;
        label537:
        if (i4 >= localAnimationStep.jdField_d_of_type_Int) {
          break label841;
        }
        localObject1[(i4 + i2)] = (localFile.getAbsolutePath() + File.separatorChar + localAnimationStep.jdField_a_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i4 + 1) }));
        bool = new File(localObject1[(i4 + i2)]).exists();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleSource|pngs[" + i4 + "]=" + localObject1[i4] + ",isFileExists=" + bool);
        }
        if (!bool) {
          i1 = 1;
        }
      }
      label841:
      for (;;)
      {
        if (i1 != 0)
        {
          break;
          i4 += 1;
          break label537;
        }
        i4 = localAnimationStep.jdField_d_of_type_Int;
        i3 += 1;
        i2 += i4;
        break label512;
        if (i1 != 0) {
          return null;
        }
        if (localObject1.length > 0) {}
        for (;;)
        {
          ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
          ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_JavaLangString = paramString;
          ((BubbleInfo.CommonAttrs)localObject2).jdField_f_of_type_Int = a(localAnimationConfig.d, paramBoolean2);
          if ((localAnimationConfig.jdField_a_of_type_ArrayOfInt != null) && (localAnimationConfig.jdField_a_of_type_ArrayOfInt.length > 0)) {
            ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_AndroidGraphicsRect = a(localAnimationConfig.jdField_a_of_type_ArrayOfInt[0], localAnimationConfig.jdField_a_of_type_ArrayOfInt[1], localAnimationConfig.jdField_a_of_type_ArrayOfInt[2], localAnimationConfig.jdField_a_of_type_ArrayOfInt[3]);
          }
          return localObject2;
          localObject1 = null;
        }
      }
      label844:
      continue;
      label847:
      i1 = 0;
    }
  }
  
  private BubbleNewAnimConf a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    BubbleNewAnimConf.PendantAnimConf localPendantAnimConf;
    do
    {
      return localObject;
      localPendantAnimConf = new BubbleNewAnimConf.PendantAnimConf();
      if (paramJSONObject.has("key")) {
        localPendantAnimConf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("duration")) {
        localPendantAnimConf.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("repeat")) {
        localPendantAnimConf.jdField_d_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("pendent_prefix")) {
        localPendantAnimConf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("pendent_prefix");
      }
      if (paramJSONObject.has("img_count")) {
        localPendantAnimConf.jdField_e_of_type_Int = paramJSONObject.getInt("img_count");
      }
      localObject = localPendantAnimConf;
    } while (!paramJSONObject.has("play_with"));
    localPendantAnimConf.jdField_c_of_type_JavaLangString = paramJSONObject.getString("play_with");
    return localPendantAnimConf;
  }
  
  /* Error */
  private Boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   14: ifnonnull +10 -> 24
    //   17: iconst_0
    //   18: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: astore_1
    //   22: aload_1
    //   23: areturn
    //   24: new 341	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 498	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/io/File;
    //   32: ldc 43
    //   34: invokespecial 347	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 386	java/io/File:exists	()Z
    //   42: ifeq +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 501	java/io/File:delete	()Z
    //   49: pop
    //   50: new 503	java/io/RandomAccessFile
    //   53: dup
    //   54: aload_2
    //   55: ldc_w 505
    //   58: invokespecial 506	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   66: astore 4
    //   68: aload 4
    //   70: monitorenter
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   76: invokevirtual 507	org/json/JSONArray:toString	()Ljava/lang/String;
    //   79: invokevirtual 511	java/lang/String:getBytes	()[B
    //   82: invokevirtual 515	java/io/RandomAccessFile:write	([B)V
    //   85: aload_2
    //   86: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   89: aload 5
    //   91: astore_3
    //   92: aload 4
    //   94: monitorexit
    //   95: iconst_1
    //   96: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   99: astore_2
    //   100: aload_2
    //   101: astore_1
    //   102: iconst_0
    //   103: ifeq -81 -> 22
    //   106: new 520	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 521	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   119: aload_2
    //   120: areturn
    //   121: astore_3
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: astore_2
    //   126: aload_1
    //   127: astore_3
    //   128: aload 4
    //   130: monitorexit
    //   131: aload_1
    //   132: astore_3
    //   133: aload_1
    //   134: astore 4
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aload_3
    //   140: astore_1
    //   141: aload_2
    //   142: invokevirtual 525	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   153: iconst_0
    //   154: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   157: areturn
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   163: goto -10 -> 153
    //   166: astore_2
    //   167: aload 4
    //   169: astore_1
    //   170: aload_2
    //   171: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   174: aload 4
    //   176: ifnull -23 -> 153
    //   179: aload 4
    //   181: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   184: goto -31 -> 153
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   192: goto -39 -> 153
    //   195: astore_3
    //   196: aload_1
    //   197: astore_2
    //   198: aload_3
    //   199: astore_1
    //   200: aload_2
    //   201: ifnull +7 -> 208
    //   204: aload_2
    //   205: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   208: aload_1
    //   209: athrow
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   215: goto -7 -> 208
    //   218: astore_1
    //   219: goto -19 -> 200
    //   222: astore_1
    //   223: aload_2
    //   224: astore 4
    //   226: aload_1
    //   227: astore_2
    //   228: goto -61 -> 167
    //   231: astore_1
    //   232: aload_2
    //   233: astore_3
    //   234: aload_1
    //   235: astore_2
    //   236: goto -97 -> 139
    //   239: astore_2
    //   240: aload_3
    //   241: astore_1
    //   242: goto -116 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	BubbleManager
    //   4	98	1	localObject1	Object
    //   114	2	1	localIOException1	IOException
    //   123	18	1	localObject2	Object
    //   158	2	1	localIOException2	IOException
    //   169	1	1	localObject3	Object
    //   187	10	1	localIOException3	IOException
    //   199	10	1	localObject4	Object
    //   218	1	1	localObject5	Object
    //   222	5	1	localIOException4	IOException
    //   231	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   241	1	1	localObject6	Object
    //   37	100	2	localObject7	Object
    //   138	4	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   166	5	2	localIOException5	IOException
    //   197	8	2	localIOException6	IOException
    //   210	14	2	localIOException7	IOException
    //   227	9	2	localObject8	Object
    //   239	1	2	localObject9	Object
    //   9	83	3	localObject10	Object
    //   121	4	3	localObject11	Object
    //   127	23	3	localObject12	Object
    //   195	4	3	localObject13	Object
    //   233	8	3	localObject14	Object
    //   1	224	4	localObject15	Object
    //   6	84	5	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   106	114	114	java/io/IOException
    //   71	89	121	finally
    //   50	62	138	java/io/FileNotFoundException
    //   136	138	138	java/io/FileNotFoundException
    //   149	153	158	java/io/IOException
    //   50	62	166	java/io/IOException
    //   136	138	166	java/io/IOException
    //   179	184	187	java/io/IOException
    //   50	62	195	finally
    //   136	138	195	finally
    //   141	145	195	finally
    //   170	174	195	finally
    //   204	208	210	java/io/IOException
    //   62	71	218	finally
    //   62	71	222	java/io/IOException
    //   62	71	231	java/io/FileNotFoundException
    //   92	95	239	finally
    //   128	131	239	finally
  }
  
  private Boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return Boolean.valueOf(true);
    }
    paramString = paramString.split(",");
    int i1 = 0;
    String[] arrayOfString;
    while (i1 < paramString.length)
    {
      arrayOfString = paramString[i1].split("\\|");
      if ((arrayOfString.length == 4) && (Long.parseLong(arrayOfString[1]) == 1L)) {
        return Boolean.valueOf(false);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < paramString.length)
    {
      arrayOfString = paramString[i1].split("\\|");
      if ((arrayOfString.length == 4) && (Long.parseLong(arrayOfString[3]) == 0L)) {
        return Boolean.valueOf(false);
      }
      i1 += 1;
    }
    return Boolean.valueOf(true);
  }
  
  private String a(String paramString)
  {
    paramString = new FileReader(paramString);
    char[] arrayOfChar = new char[1024];
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i1 = paramString.read(arrayOfChar);
      if (i1 <= 0) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i1);
    }
    paramString.close();
    return localStringBuilder.toString();
  }
  
  private ArrayList a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i1 = 0;
    if (i1 < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.getJSONObject(i1);
      if (((JSONObject)localObject).has("pendent_prefix")) {}
      for (localObject = a((JSONObject)localObject);; localObject = b((JSONObject)localObject))
      {
        localArrayList.add(localObject);
        i1 += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  private JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animations")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animations");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
  }
  
  private void a(int paramInt)
  {
    File localFile1 = b();
    Object localObject = Integer.toString(paramInt);
    localFile1 = new File(localFile1, (String)localObject);
    if (localFile1.exists())
    {
      File[] arrayOfFile1 = localFile1.listFiles();
      paramInt = 0;
      if (paramInt < arrayOfFile1.length)
      {
        File localFile2 = arrayOfFile1[paramInt];
        if (localFile2.isDirectory())
        {
          File[] arrayOfFile2 = localFile2.listFiles();
          if (arrayOfFile2 != null)
          {
            int i2 = arrayOfFile2.length;
            int i1 = 0;
            while (i1 < i2)
            {
              arrayOfFile2[i1].delete();
              i1 += 1;
            }
            localFile2.delete();
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          arrayOfFile1[paramInt].delete();
        }
      }
      localFile1.delete();
    }
    localObject = new File(c(), (String)localObject);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  private void a(AnimationConfig paramAnimationConfig, JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject.has("type"))
    {
      localObject = paramJSONObject.getString("type");
      if ("line".equalsIgnoreCase((String)localObject)) {
        paramAnimationConfig.n = 10;
      }
      if ("circle".equalsIgnoreCase((String)localObject)) {
        paramAnimationConfig.n = 11;
      }
      if ("static".equalsIgnoreCase((String)localObject)) {
        paramAnimationConfig.n = 1;
      }
    }
    if (paramJSONObject.has("padding"))
    {
      localObject = paramJSONObject.getJSONArray("padding");
      paramAnimationConfig.o = ((JSONArray)localObject).getInt(0);
      paramAnimationConfig.q = ((JSONArray)localObject).getInt(1);
      paramAnimationConfig.p = ((JSONArray)localObject).getInt(2);
      paramAnimationConfig.r = ((JSONArray)localObject).getInt(3);
    }
    if (!paramJSONObject.has("step")) {}
    do
    {
      return;
      if (paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray == null) {
        paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
      }
      paramJSONObject = paramJSONObject.getJSONObject("step");
      if (paramJSONObject.has("static"))
      {
        localObject = paramJSONObject.getJSONObject("static");
        paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(0, a("static", (JSONObject)localObject));
      }
      if (paramJSONObject.has("moving"))
      {
        localObject = paramJSONObject.getJSONObject("moving");
        paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(1, a("moving", (JSONObject)localObject));
      }
    } while (!paramJSONObject.has("turnback"));
    paramJSONObject = paramJSONObject.getJSONObject("turnback");
    paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(2, a("turnback", paramJSONObject));
  }
  
  private boolean a(BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|bubbleInfo is null");
      }
      return false;
    }
    if ((!TextUtils.isEmpty(paramBubbleInfo.d)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|bubbleId=" + paramBubbleInfo.jdField_c_of_type_Int + ",chkStaticSrcAndUpdate is ok | not empty");
      }
      return true;
    }
    String str3 = a(paramBubbleInfo.jdField_c_of_type_Int, false).getAbsolutePath() + File.separatorChar + "static" + File.separatorChar;
    String str1 = str3 + "aio_user_bg_nor.9.png";
    String str2 = str3 + "aio_user_pic_nor.9.png";
    str3 = str3 + "chat_bubble_thumbnail.png";
    Object localObject = new ArrayList();
    ((List)localObject).add(str1);
    ((List)localObject).add(str2);
    ((List)localObject).add(str3);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str4 = (String)((Iterator)localObject).next();
      if (!new File(str4).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + paramBubbleInfo.jdField_c_of_type_Int + ",strFilePath=" + str4);
        }
        return false;
      }
    }
    paramBubbleInfo.d = str3;
    paramBubbleInfo.jdField_a_of_type_JavaLangString = str1;
    paramBubbleInfo.jdField_b_of_type_JavaLangString = str2;
    return true;
  }
  
  private BubbleNewAnimConf b(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    BubbleNewAnimConf.PathAnimConf localPathAnimConf;
    do
    {
      return localObject;
      localPathAnimConf = new BubbleNewAnimConf.PathAnimConf();
      if (paramJSONObject.has("key")) {
        localPathAnimConf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("start_end"))
      {
        localObject = paramJSONObject.getJSONArray("start_end");
        localPathAnimConf.jdField_a_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localPathAnimConf.jdField_b_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localPathAnimConf.c = ((float)((JSONArray)localObject).getDouble(2));
        localPathAnimConf.jdField_d_of_type_Float = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("bezier"))
      {
        localObject = paramJSONObject.getJSONArray("bezier");
        localPathAnimConf.jdField_e_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localPathAnimConf.jdField_f_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localPathAnimConf.jdField_g_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localPathAnimConf.jdField_h_of_type_Float = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("duration")) {
        localPathAnimConf.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("speed")) {
        localPathAnimConf.jdField_f_of_type_Int = paramJSONObject.getInt("speed");
      }
      if (paramJSONObject.has("img_prefix")) {
        localPathAnimConf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("img_prefix");
      }
      if (paramJSONObject.has("img_reverse")) {
        localPathAnimConf.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("img_reverse");
      }
      if (paramJSONObject.has("img_alpha"))
      {
        localObject = paramJSONObject.getJSONArray("img_alpha");
        localPathAnimConf.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(0);
        localPathAnimConf.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("repeat")) {
        localPathAnimConf.jdField_d_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("img_rotate"))
      {
        localObject = paramJSONObject.getJSONArray("img_rotate");
        localPathAnimConf.i = ((JSONArray)localObject).getInt(0);
        localPathAnimConf.j = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("img_count")) {
        localPathAnimConf.jdField_e_of_type_Int = paramJSONObject.getInt("img_count");
      }
      if (paramJSONObject.has("periodical")) {
        localPathAnimConf.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("periodical");
      }
      localObject = localPathAnimConf;
    } while (!paramJSONObject.has("period_length"));
    localPathAnimConf.k = paramJSONObject.getInt("period_length");
    return localPathAnimConf;
  }
  
  private JSONObject b(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animation_sets")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animation_sets");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject = (Pair)BaseApplicationImpl.a.get("bubble_thumb_" + paramInt);
    if (localObject != null) {
      return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    if (paramInt < 0) {
      return null;
    }
    BubbleInfo localBubbleInfo = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
    localObject = localBubbleInfo;
    if (localBubbleInfo == null)
    {
      localObject = localBubbleInfo;
      if (a(paramInt, true)) {
        localObject = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
      }
    }
    if ((localObject != null) && (!TextUtils.isEmpty(((BubbleInfo)localObject).d)))
    {
      localObject = BubbleInfo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((BubbleInfo)localObject).d);
      if (localObject != null)
      {
        BaseApplicationImpl.a.put("bubble_thumb_" + paramInt, new Pair(((Drawable)((Pair)localObject).first).getConstantState(), ((Pair)localObject).second));
        return (Drawable)((Pair)localObject).first;
      }
    }
    if (0 == 0) {
      return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837983);
    }
    return null;
  }
  
  public AnimationConfig a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1, false);
    if (localObject1 == null) {
      return null;
    }
    switch (paramInt2)
    {
    case 4: 
    default: 
      localObject1 = null;
    }
    Object localObject2;
    Object localObject3;
    File localFile;
    int i1;
    for (;;)
    {
      if (localObject1 != null) {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(((AnimationConfig)localObject1).jdField_b_of_type_JavaLangString))
        {
          return localObject1;
          localObject1 = ((BubbleConfig)localObject1).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
          AnimationConfig.a((AnimationConfig)localObject1);
          continue;
          localObject1 = ((BubbleConfig)localObject1).d;
        }
        else if ((localObject1 != null) && (((AnimationConfig)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (((AnimationConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject2 = ((AnimationConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          paramInt2 = 1;
          if (!((Iterator)localObject2).hasNext()) {
            break label302;
          }
          localObject3 = (BubbleNewAnimConf)((Iterator)localObject2).next();
          localFile = new File(a(paramInt1, false), ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString);
          i1 = 0;
          label175:
          if (i1 >= ((BubbleNewAnimConf)localObject3).jdField_e_of_type_Int) {
            break label505;
          }
          String str = localFile.getAbsolutePath() + File.separatorChar + ((BubbleNewAnimConf)localObject3).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
          if (!new File(str).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, "pendent anim conf, file is not exit, " + str);
            }
            paramInt2 = 0;
          }
        }
      }
    }
    label302:
    label505:
    for (;;)
    {
      break;
      i1 += 1;
      break label175;
      return null;
      if ((paramInt2 == 0) || (a(paramInt1, ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString).booleanValue()))
      {
        localObject3 = a(paramInt1, ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString + ".zip");
        localFile = new File(a(paramInt1, true), ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString + ".zip");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("name", ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString + ".zip");
        ((Bundle)localObject2).putInt("id", paramInt1);
        localObject1 = new DownloadTask((String)localObject3, localFile);
        ((DownloadTask)localObject1).e = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.b, (Bundle)localObject2);
        return null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AnimationConfig)localObject1).jdField_b_of_type_JavaLangString, localObject1);
      return localObject1;
    }
  }
  
  public AnimationConfig a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null) {
      return null;
    }
    if ((((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = ((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AnimationConfig localAnimationConfig = (AnimationConfig)((Iterator)localObject).next();
        if (localAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString)) {
          return localAnimationConfig;
        }
      }
    }
    return null;
  }
  
  /* Error */
  public BubbleConfig a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_2
    //   11: invokespecial 805	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 5
    //   16: aload 5
    //   18: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   35: iconst_2
    //   36: new 352	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 807
    //   46: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload 5
    //   62: astore_2
    //   63: getstatic 812	android/os/Build$VERSION:SDK_INT	I
    //   66: bipush 10
    //   68: if_icmpgt +37 -> 105
    //   71: aload 5
    //   73: astore_2
    //   74: aload 5
    //   76: invokevirtual 527	java/lang/String:length	()I
    //   79: iconst_1
    //   80: if_icmple +25 -> 105
    //   83: aload 5
    //   85: astore_2
    //   86: aload 5
    //   88: iconst_0
    //   89: invokevirtual 816	java/lang/String:charAt	(I)C
    //   92: ldc_w 817
    //   95: if_icmpne +10 -> 105
    //   98: aload 5
    //   100: iconst_1
    //   101: invokevirtual 820	java/lang/String:substring	(I)Ljava/lang/String;
    //   104: astore_2
    //   105: new 775	com/tencent/mobileqq/bubble/BubbleConfig
    //   108: dup
    //   109: iload_1
    //   110: invokespecial 821	com/tencent/mobileqq/bubble/BubbleConfig:<init>	(I)V
    //   113: astore 6
    //   115: new 242	org/json/JSONObject
    //   118: dup
    //   119: aload_2
    //   120: invokespecial 822	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   123: astore 7
    //   125: aload 6
    //   127: aload 7
    //   129: ldc_w 422
    //   132: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: putfield 824	com/tencent/mobileqq/bubble/BubbleConfig:m	Ljava/lang/String;
    //   138: aload 7
    //   140: ldc_w 826
    //   143: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +62 -> 208
    //   149: aload 7
    //   151: ldc_w 826
    //   154: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 5
    //   159: aload 5
    //   161: astore_2
    //   162: aload 5
    //   164: ldc_w 828
    //   167: invokevirtual 831	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   170: ifeq +10 -> 180
    //   173: aload 5
    //   175: iconst_2
    //   176: invokevirtual 820	java/lang/String:substring	(I)Ljava/lang/String;
    //   179: astore_2
    //   180: aload 6
    //   182: new 352	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 833
    //   192: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 838	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   205: putfield 840	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_Int	I
    //   208: aload 7
    //   210: ldc_w 842
    //   213: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   216: ifeq +62 -> 278
    //   219: aload 7
    //   221: ldc_w 842
    //   224: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 5
    //   229: aload 5
    //   231: astore_2
    //   232: aload 5
    //   234: ldc_w 828
    //   237: invokevirtual 831	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   240: ifeq +10 -> 250
    //   243: aload 5
    //   245: iconst_2
    //   246: invokevirtual 820	java/lang/String:substring	(I)Ljava/lang/String;
    //   249: astore_2
    //   250: aload 6
    //   252: new 352	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 833
    //   262: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_2
    //   266: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 838	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   275: putfield 843	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_Int	I
    //   278: aload 7
    //   280: ldc_w 845
    //   283: invokevirtual 275	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   286: astore_2
    //   287: aload 6
    //   289: iconst_2
    //   290: newarray int
    //   292: dup
    //   293: iconst_0
    //   294: aload_2
    //   295: iconst_0
    //   296: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   299: iastore
    //   300: dup
    //   301: iconst_1
    //   302: aload_2
    //   303: iconst_1
    //   304: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   307: iastore
    //   308: putfield 846	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ArrayOfInt	[I
    //   311: aload 7
    //   313: ldc_w 848
    //   316: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   319: ifeq +70 -> 389
    //   322: aload 7
    //   324: ldc_w 848
    //   327: invokevirtual 573	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   330: astore_2
    //   331: aload_2
    //   332: ldc_w 850
    //   335: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   338: ifeq +51 -> 389
    //   341: aload_0
    //   342: aload_2
    //   343: ldc_w 850
    //   346: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: aload 7
    //   351: invokespecial 852	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   354: astore 5
    //   356: aload 5
    //   358: ifnull +31 -> 389
    //   361: aload_0
    //   362: iconst_0
    //   363: aload 5
    //   365: invokespecial 854	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   368: astore 5
    //   370: aload 5
    //   372: aload_2
    //   373: ldc_w 850
    //   376: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   379: putfield 770	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   382: aload 6
    //   384: aload 5
    //   386: putfield 795	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   389: aload 7
    //   391: ldc_w 856
    //   394: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   397: ifeq +106 -> 503
    //   400: aload 7
    //   402: ldc_w 856
    //   405: invokevirtual 573	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore_2
    //   409: aload_2
    //   410: ldc_w 850
    //   413: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   416: ifeq +87 -> 503
    //   419: aload_0
    //   420: aload_2
    //   421: ldc_w 850
    //   424: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   427: aload 7
    //   429: invokespecial 852	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   432: astore 8
    //   434: aload 8
    //   436: ifnull +67 -> 503
    //   439: aload_0
    //   440: iconst_2
    //   441: aload 8
    //   443: invokespecial 854	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   446: astore 5
    //   448: aload 8
    //   450: ldc_w 858
    //   453: invokevirtual 275	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   456: astore 8
    //   458: aload 5
    //   460: iconst_2
    //   461: newarray int
    //   463: dup
    //   464: iconst_0
    //   465: aload 8
    //   467: iconst_0
    //   468: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   471: iastore
    //   472: dup
    //   473: iconst_1
    //   474: aload 8
    //   476: iconst_1
    //   477: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   480: iastore
    //   481: putfield 860	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfInt	[I
    //   484: aload 5
    //   486: aload_2
    //   487: ldc_w 850
    //   490: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   493: putfield 770	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   496: aload 6
    //   498: aload 5
    //   500: putfield 797	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   503: aload 7
    //   505: ldc_w 862
    //   508: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   511: ifeq +123 -> 634
    //   514: aload 7
    //   516: ldc_w 862
    //   519: invokevirtual 573	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   522: astore_2
    //   523: aload_2
    //   524: ldc_w 850
    //   527: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   530: ifeq +104 -> 634
    //   533: aload_0
    //   534: aload_2
    //   535: ldc_w 850
    //   538: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   541: aload 7
    //   543: invokespecial 852	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   546: astore 5
    //   548: aload 5
    //   550: ifnull +84 -> 634
    //   553: aload_0
    //   554: iconst_3
    //   555: aload 5
    //   557: invokespecial 854	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   560: astore 5
    //   562: aload 5
    //   564: aload_2
    //   565: ldc_w 850
    //   568: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   571: putfield 770	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   574: aload_2
    //   575: ldc_w 864
    //   578: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +46 -> 627
    //   584: aload_2
    //   585: ldc_w 864
    //   588: invokevirtual 250	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   591: istore_3
    //   592: aload 5
    //   594: aload_0
    //   595: getfield 157	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   598: ldc_w 866
    //   601: invokevirtual 870	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   604: checkcast 872	android/view/WindowManager
    //   607: invokeinterface 876 1 0
    //   612: invokevirtual 881	android/view/Display:getWidth	()I
    //   615: i2d
    //   616: iload_3
    //   617: i2d
    //   618: ldc2_w 882
    //   621: ddiv
    //   622: dmul
    //   623: d2i
    //   624: putfield 886	com/tencent/mobileqq/bubble/AnimationConfig:s	I
    //   627: aload 6
    //   629: aload 5
    //   631: putfield 777	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   634: aload 7
    //   636: ldc_w 888
    //   639: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   642: ifeq +345 -> 987
    //   645: aload 7
    //   647: ldc_w 888
    //   650: invokevirtual 275	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   653: astore_2
    //   654: new 555	java/util/ArrayList
    //   657: dup
    //   658: invokespecial 635	java/util/ArrayList:<init>	()V
    //   661: astore 5
    //   663: iconst_0
    //   664: istore_3
    //   665: iload_3
    //   666: aload_2
    //   667: invokevirtual 284	org/json/JSONArray:length	()I
    //   670: if_icmpge +310 -> 980
    //   673: aload_2
    //   674: iload_3
    //   675: invokevirtual 560	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   678: astore 8
    //   680: aload 8
    //   682: ldc_w 850
    //   685: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   688: ifeq +541 -> 1229
    //   691: aload_0
    //   692: aload 8
    //   694: ldc_w 850
    //   697: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   700: aload 7
    //   702: invokespecial 852	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   705: astore 9
    //   707: aload 9
    //   709: ifnonnull +131 -> 840
    //   712: goto +517 -> 1229
    //   715: astore_2
    //   716: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq -511 -> 208
    //   722: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   725: iconst_2
    //   726: ldc_w 890
    //   729: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: goto -524 -> 208
    //   735: astore_2
    //   736: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq +36 -> 775
    //   742: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   745: iconst_2
    //   746: new 352	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 892
    //   756: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: iload_1
    //   760: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: ldc_w 894
    //   766: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 897	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aconst_null
    //   776: areturn
    //   777: astore_2
    //   778: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq -503 -> 278
    //   784: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   787: iconst_2
    //   788: ldc_w 899
    //   791: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: goto -516 -> 278
    //   797: astore_2
    //   798: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq -26 -> 775
    //   804: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   807: iconst_2
    //   808: new 352	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   815: ldc_w 892
    //   818: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: iload_1
    //   822: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: ldc_w 901
    //   828: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 897	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: goto -62 -> 775
    //   840: aload_0
    //   841: iconst_1
    //   842: aload 9
    //   844: invokespecial 854	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   847: astore 9
    //   849: aload 8
    //   851: ldc_w 903
    //   854: invokevirtual 275	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   857: astore 10
    //   859: aload 9
    //   861: aload 10
    //   863: invokevirtual 284	org/json/JSONArray:length	()I
    //   866: anewarray 208	java/lang/String
    //   869: putfield 905	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   872: iconst_0
    //   873: istore 4
    //   875: iload 4
    //   877: aload 10
    //   879: invokevirtual 284	org/json/JSONArray:length	()I
    //   882: if_icmpge +27 -> 909
    //   885: aload 9
    //   887: getfield 905	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   890: iload 4
    //   892: aload 10
    //   894: iload 4
    //   896: invokevirtual 907	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   899: aastore
    //   900: iload 4
    //   902: iconst_1
    //   903: iadd
    //   904: istore 4
    //   906: goto -31 -> 875
    //   909: aload 9
    //   911: aload 8
    //   913: ldc_w 850
    //   916: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   919: putfield 770	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   922: aload 5
    //   924: aload 9
    //   926: invokevirtual 565	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   929: pop
    //   930: goto +299 -> 1229
    //   933: astore_2
    //   934: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   937: ifeq -162 -> 775
    //   940: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   943: iconst_2
    //   944: new 352	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   951: ldc_w 892
    //   954: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: iload_1
    //   958: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   961: ldc_w 909
    //   964: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload_2
    //   968: invokevirtual 912	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 897	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   977: goto -202 -> 775
    //   980: aload 6
    //   982: aload 5
    //   984: putfield 798	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   987: aload 7
    //   989: ldc_w 914
    //   992: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   995: ifeq +211 -> 1206
    //   998: aload 7
    //   1000: ldc_w 914
    //   1003: invokevirtual 573	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1006: astore 5
    //   1008: new 266	com/tencent/mobileqq/bubble/AnimationConfig
    //   1011: dup
    //   1012: invokespecial 267	com/tencent/mobileqq/bubble/AnimationConfig:<init>	()V
    //   1015: astore_2
    //   1016: aload 5
    //   1018: ldc_w 916
    //   1021: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1024: ifeq +15 -> 1039
    //   1027: aload_2
    //   1028: aload 5
    //   1030: ldc_w 916
    //   1033: invokevirtual 250	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1036: putfield 919	com/tencent/mobileqq/bubble/AnimationConfig:t	I
    //   1039: aload 5
    //   1041: ldc_w 921
    //   1044: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1047: ifeq +159 -> 1206
    //   1050: aload 5
    //   1052: ldc_w 921
    //   1055: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1058: astore 5
    //   1060: aload_2
    //   1061: aload 5
    //   1063: putfield 770	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1066: aload_0
    //   1067: aload 5
    //   1069: aload 7
    //   1071: invokespecial 923	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1074: astore 7
    //   1076: aload 7
    //   1078: ifnull +128 -> 1206
    //   1081: aload_2
    //   1082: aload 7
    //   1084: ldc_w 293
    //   1087: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1090: putfield 294	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1093: aload 7
    //   1095: ldc_w 925
    //   1098: invokevirtual 275	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1101: astore 5
    //   1103: aload 7
    //   1105: ldc_w 600
    //   1108: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1111: ifeq +66 -> 1177
    //   1114: aload 7
    //   1116: ldc_w 600
    //   1119: invokevirtual 275	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1122: astore 7
    //   1124: aload 7
    //   1126: ifnull +51 -> 1177
    //   1129: aload 7
    //   1131: invokevirtual 284	org/json/JSONArray:length	()I
    //   1134: ifle +43 -> 1177
    //   1137: aload_2
    //   1138: aload 7
    //   1140: iconst_0
    //   1141: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1144: putfield 602	com/tencent/mobileqq/bubble/AnimationConfig:o	I
    //   1147: aload_2
    //   1148: aload 7
    //   1150: iconst_1
    //   1151: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1154: putfield 604	com/tencent/mobileqq/bubble/AnimationConfig:q	I
    //   1157: aload_2
    //   1158: aload 7
    //   1160: iconst_2
    //   1161: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1164: putfield 606	com/tencent/mobileqq/bubble/AnimationConfig:p	I
    //   1167: aload_2
    //   1168: aload 7
    //   1170: iconst_3
    //   1171: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1174: putfield 608	com/tencent/mobileqq/bubble/AnimationConfig:r	I
    //   1177: aload 5
    //   1179: ifnull +21 -> 1200
    //   1182: aload 5
    //   1184: invokevirtual 284	org/json/JSONArray:length	()I
    //   1187: ifle +13 -> 1200
    //   1190: aload_2
    //   1191: aload_0
    //   1192: aload 5
    //   1194: invokespecial 927	com/tencent/mobileqq/bubble/BubbleManager:a	(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    //   1197: putfield 785	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1200: aload 6
    //   1202: aload_2
    //   1203: putfield 782	com/tencent/mobileqq/bubble/BubbleConfig:d	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   1206: aload 6
    //   1208: areturn
    //   1209: astore_2
    //   1210: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1213: ifeq -438 -> 775
    //   1216: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1219: iconst_2
    //   1220: ldc_w 929
    //   1223: invokestatic 897	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1226: goto -451 -> 775
    //   1229: iload_3
    //   1230: iconst_1
    //   1231: iadd
    //   1232: istore_3
    //   1233: goto -568 -> 665
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1236	0	this	BubbleManager
    //   0	1236	1	paramInt	int
    //   0	1236	2	paramString	String
    //   591	642	3	i1	int
    //   873	32	4	i2	int
    //   14	1179	5	localObject1	Object
    //   113	1094	6	localBubbleConfig	BubbleConfig
    //   123	1046	7	localObject2	Object
    //   432	480	8	localObject3	Object
    //   705	220	9	localObject4	Object
    //   857	36	10	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   180	208	715	java/lang/Exception
    //   9	24	735	java/io/FileNotFoundException
    //   26	60	735	java/io/FileNotFoundException
    //   63	71	735	java/io/FileNotFoundException
    //   74	83	735	java/io/FileNotFoundException
    //   86	105	735	java/io/FileNotFoundException
    //   105	159	735	java/io/FileNotFoundException
    //   162	180	735	java/io/FileNotFoundException
    //   180	208	735	java/io/FileNotFoundException
    //   208	229	735	java/io/FileNotFoundException
    //   232	250	735	java/io/FileNotFoundException
    //   250	278	735	java/io/FileNotFoundException
    //   278	356	735	java/io/FileNotFoundException
    //   361	389	735	java/io/FileNotFoundException
    //   389	434	735	java/io/FileNotFoundException
    //   439	503	735	java/io/FileNotFoundException
    //   503	548	735	java/io/FileNotFoundException
    //   553	627	735	java/io/FileNotFoundException
    //   627	634	735	java/io/FileNotFoundException
    //   634	663	735	java/io/FileNotFoundException
    //   665	707	735	java/io/FileNotFoundException
    //   716	732	735	java/io/FileNotFoundException
    //   778	794	735	java/io/FileNotFoundException
    //   840	872	735	java/io/FileNotFoundException
    //   875	900	735	java/io/FileNotFoundException
    //   909	930	735	java/io/FileNotFoundException
    //   980	987	735	java/io/FileNotFoundException
    //   987	1039	735	java/io/FileNotFoundException
    //   1039	1076	735	java/io/FileNotFoundException
    //   1081	1124	735	java/io/FileNotFoundException
    //   1129	1177	735	java/io/FileNotFoundException
    //   1182	1200	735	java/io/FileNotFoundException
    //   1200	1206	735	java/io/FileNotFoundException
    //   250	278	777	java/lang/Exception
    //   9	24	797	java/io/IOException
    //   26	60	797	java/io/IOException
    //   63	71	797	java/io/IOException
    //   74	83	797	java/io/IOException
    //   86	105	797	java/io/IOException
    //   105	159	797	java/io/IOException
    //   162	180	797	java/io/IOException
    //   180	208	797	java/io/IOException
    //   208	229	797	java/io/IOException
    //   232	250	797	java/io/IOException
    //   250	278	797	java/io/IOException
    //   278	356	797	java/io/IOException
    //   361	389	797	java/io/IOException
    //   389	434	797	java/io/IOException
    //   439	503	797	java/io/IOException
    //   503	548	797	java/io/IOException
    //   553	627	797	java/io/IOException
    //   627	634	797	java/io/IOException
    //   634	663	797	java/io/IOException
    //   665	707	797	java/io/IOException
    //   716	732	797	java/io/IOException
    //   778	794	797	java/io/IOException
    //   840	872	797	java/io/IOException
    //   875	900	797	java/io/IOException
    //   909	930	797	java/io/IOException
    //   980	987	797	java/io/IOException
    //   987	1039	797	java/io/IOException
    //   1039	1076	797	java/io/IOException
    //   1081	1124	797	java/io/IOException
    //   1129	1177	797	java/io/IOException
    //   1182	1200	797	java/io/IOException
    //   1200	1206	797	java/io/IOException
    //   9	24	933	org/json/JSONException
    //   26	60	933	org/json/JSONException
    //   63	71	933	org/json/JSONException
    //   74	83	933	org/json/JSONException
    //   86	105	933	org/json/JSONException
    //   105	159	933	org/json/JSONException
    //   162	180	933	org/json/JSONException
    //   180	208	933	org/json/JSONException
    //   208	229	933	org/json/JSONException
    //   232	250	933	org/json/JSONException
    //   250	278	933	org/json/JSONException
    //   278	356	933	org/json/JSONException
    //   361	389	933	org/json/JSONException
    //   389	434	933	org/json/JSONException
    //   439	503	933	org/json/JSONException
    //   503	548	933	org/json/JSONException
    //   553	627	933	org/json/JSONException
    //   627	634	933	org/json/JSONException
    //   634	663	933	org/json/JSONException
    //   665	707	933	org/json/JSONException
    //   716	732	933	org/json/JSONException
    //   778	794	933	org/json/JSONException
    //   840	872	933	org/json/JSONException
    //   875	900	933	org/json/JSONException
    //   909	930	933	org/json/JSONException
    //   980	987	933	org/json/JSONException
    //   987	1039	933	org/json/JSONException
    //   1039	1076	933	org/json/JSONException
    //   1081	1124	933	org/json/JSONException
    //   1129	1177	933	org/json/JSONException
    //   1182	1200	933	org/json/JSONException
    //   1200	1206	933	org/json/JSONException
    //   9	24	1209	java/lang/Exception
    //   26	60	1209	java/lang/Exception
    //   63	71	1209	java/lang/Exception
    //   74	83	1209	java/lang/Exception
    //   86	105	1209	java/lang/Exception
    //   105	159	1209	java/lang/Exception
    //   162	180	1209	java/lang/Exception
    //   208	229	1209	java/lang/Exception
    //   232	250	1209	java/lang/Exception
    //   278	356	1209	java/lang/Exception
    //   361	389	1209	java/lang/Exception
    //   389	434	1209	java/lang/Exception
    //   439	503	1209	java/lang/Exception
    //   503	548	1209	java/lang/Exception
    //   553	627	1209	java/lang/Exception
    //   627	634	1209	java/lang/Exception
    //   634	663	1209	java/lang/Exception
    //   665	707	1209	java/lang/Exception
    //   716	732	1209	java/lang/Exception
    //   778	794	1209	java/lang/Exception
    //   840	872	1209	java/lang/Exception
    //   875	900	1209	java/lang/Exception
    //   909	930	1209	java/lang/Exception
    //   980	987	1209	java/lang/Exception
    //   987	1039	1209	java/lang/Exception
    //   1039	1076	1209	java/lang/Exception
    //   1081	1124	1209	java/lang/Exception
    //   1129	1177	1209	java/lang/Exception
    //   1182	1200	1209	java/lang/Exception
    //   1200	1206	1209	java/lang/Exception
  }
  
  public BubbleConfig a(int paramInt, boolean paramBoolean)
  {
    BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    Object localObject = localBubbleConfig;
    if (localBubbleConfig == null)
    {
      localObject = a(paramInt, false).getAbsolutePath() + File.separatorChar + "config.json";
      localBubbleConfig = a(paramInt, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleConfig bubbleId=" + paramInt + ",filePath=" + (String)localObject + ",bubbleConfig=" + localBubbleConfig);
      }
      if (localBubbleConfig == null) {
        break label198;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramInt), localBubbleConfig);
      localObject = localBubbleConfig;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleConfig bubbleId=" + paramInt + ",autoDownload=" + paramBoolean + ",bubbleConfig=" + localObject);
      }
      return localObject;
      label198:
      localObject = localBubbleConfig;
      if (paramBoolean)
      {
        a(paramInt, "config.json");
        localObject = localBubbleConfig;
      }
    }
  }
  
  public BubbleInfo a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      ??? = null;
    }
    Object localObject2;
    do
    {
      return ???;
      localObject2 = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
      if (localObject2 == null) {
        break;
      }
      ??? = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleInfo bubbleId=" + paramInt + " from cache");
    return localObject2;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        localObject2 = new huv(this, paramInt);
        this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
        ThreadManager.b((Runnable)localObject2);
      }
    }
    return null;
  }
  
  public Pair a(int paramInt, AnimationConfig paramAnimationConfig, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramAnimationConfig == null) || (TextUtils.isEmpty(paramAnimationConfig.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramAnimationConfig.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    BubbleInfo.CommonAttrs localCommonAttrs = a(paramInt, paramAnimationConfig.jdField_b_of_type_JavaLangString, paramBoolean, false);
    if (localCommonAttrs == null) {
      return null;
    }
    if (paramAnimationConfig.jdField_a_of_type_JavaLangString.equals(paramAnimationConfig.jdField_c_of_type_JavaLangString)) {
      bool = true;
    }
    return new Pair(localCommonAttrs, a(paramInt, paramAnimationConfig.jdField_c_of_type_JavaLangString, paramBoolean, bool));
  }
  
  public Pair a(int paramInt, String paramString, Pair paramPair)
  {
    Object localObject = paramPair;
    if (paramPair == null)
    {
      paramString = a(paramInt, a(paramInt, paramString), true);
      localObject = paramString;
      if (paramString != null)
      {
        paramPair = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
        localObject = paramString;
        if (paramPair != null)
        {
          paramPair.jdField_a_of_type_JavaUtilList.add(paramString);
          localObject = paramString;
        }
      }
    }
    return localObject;
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File a(int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath() + File.separatorChar + "bubble_info" + File.separatorChar + "unzip_temp" + File.separatorChar + paramInt;
    File localFile = new File(str);
    if (localFile.exists()) {
      FileUtils.a(str);
    }
    localFile.mkdirs();
    return localFile;
  }
  
  public File a(int paramInt, boolean paramBoolean)
  {
    String str = a().getAbsolutePath();
    Object localObject = str;
    if (paramBoolean) {
      localObject = str + "/temp";
    }
    localObject = new File((String)localObject + File.separatorChar + paramInt);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  /* Error */
  public Boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   4: ifnonnull +8 -> 12
    //   7: iconst_0
    //   8: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   11: areturn
    //   12: new 341	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokevirtual 498	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/io/File;
    //   20: iload_1
    //   21: invokestatic 578	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   24: invokespecial 347	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokevirtual 386	java/io/File:exists	()Z
    //   30: ifne +41 -> 71
    //   33: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +30 -> 66
    //   39: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: iconst_2
    //   43: new 352	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 988
    //   53: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_1
    //   57: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iconst_0
    //   67: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: areturn
    //   71: aload_0
    //   72: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   75: astore 5
    //   77: aload 5
    //   79: monitorenter
    //   80: iconst_0
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   86: invokevirtual 284	org/json/JSONArray:length	()I
    //   89: istore_3
    //   90: iload_2
    //   91: iload_3
    //   92: if_icmpge +71 -> 163
    //   95: aload_0
    //   96: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   99: iload_2
    //   100: invokevirtual 560	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   103: astore 6
    //   105: aload 6
    //   107: ldc 46
    //   109: invokevirtual 250	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   112: iload_1
    //   113: if_icmpne +58 -> 171
    //   116: aload 6
    //   118: ldc 55
    //   120: invokevirtual 250	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   123: iconst_1
    //   124: if_icmpne +23 -> 147
    //   127: iconst_1
    //   128: istore 4
    //   130: aload 5
    //   132: monitorexit
    //   133: iload 4
    //   135: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   138: areturn
    //   139: astore 6
    //   141: aload 5
    //   143: monitorexit
    //   144: aload 6
    //   146: athrow
    //   147: iconst_0
    //   148: istore 4
    //   150: goto -20 -> 130
    //   153: astore 6
    //   155: aload 6
    //   157: invokevirtual 989	org/json/JSONException:printStackTrace	()V
    //   160: goto +11 -> 171
    //   163: aload 5
    //   165: monitorexit
    //   166: iconst_0
    //   167: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   170: areturn
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: istore_2
    //   175: goto -93 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	BubbleManager
    //   0	178	1	paramInt	int
    //   81	94	2	i1	int
    //   89	4	3	i2	int
    //   128	21	4	bool	boolean
    //   75	89	5	localJSONArray	JSONArray
    //   103	14	6	localJSONObject	JSONObject
    //   139	6	6	localObject	Object
    //   153	3	6	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   82	90	139	finally
    //   95	127	139	finally
    //   130	139	139	finally
    //   141	144	139	finally
    //   155	160	139	finally
    //   163	166	139	finally
    //   95	127	153	org/json/JSONException
  }
  
  /* Error */
  public Boolean a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 991	com/tencent/mobileqq/bubble/BubbleManager:b	(I)Lorg/json/JSONObject;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnonnull +16 -> 29
    //   16: iconst_0
    //   17: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: iload_3
    //   26: iconst_1
    //   27: iadd
    //   28: istore_3
    //   29: iload_3
    //   30: aload_0
    //   31: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   34: invokevirtual 284	org/json/JSONArray:length	()I
    //   37: if_icmpge +131 -> 168
    //   40: aload_0
    //   41: getfield 118	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   44: iload_3
    //   45: invokevirtual 560	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   48: astore 5
    //   50: aload 5
    //   52: ldc 46
    //   54: invokevirtual 250	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   57: iload_1
    //   58: if_icmpne -33 -> 25
    //   61: aload 5
    //   63: aload_2
    //   64: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifne +11 -> 78
    //   70: iconst_0
    //   71: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   74: astore_2
    //   75: goto -54 -> 21
    //   78: aload 5
    //   80: aload_2
    //   81: invokevirtual 250	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   84: aload 4
    //   86: aload_2
    //   87: invokevirtual 250	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   90: if_icmpge -65 -> 25
    //   93: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +46 -> 142
    //   99: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: iconst_2
    //   103: new 352	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 993
    //   113: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_1
    //   117: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc_w 995
    //   123: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_2
    //   127: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 997
    //   133: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: iconst_1
    //   143: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   146: astore_2
    //   147: goto -126 -> 21
    //   150: astore_2
    //   151: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +14 -> 168
    //   157: getstatic 87	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   160: iconst_2
    //   161: aload_2
    //   162: invokevirtual 1000	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: iconst_0
    //   169: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   172: astore_2
    //   173: goto -152 -> 21
    //   176: astore_2
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	BubbleManager
    //   0	181	1	paramInt	int
    //   0	181	2	paramString	String
    //   1	44	3	i1	int
    //   9	76	4	localJSONObject1	JSONObject
    //   48	31	5	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   29	75	150	java/lang/Exception
    //   78	142	150	java/lang/Exception
    //   4	11	176	finally
    //   29	75	176	finally
    //   78	142	176	finally
    //   151	168	176	finally
  }
  
  protected String a(int paramInt, String paramString)
  {
    return EmosmUtils.insertMtype("VIP_bubble", String.format("https://i.gtimg.cn/club/item/avatar/zip/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), paramString }));
  }
  
  public JSONArray a()
  {
    Object localObject1 = new File(a(), "bubble_local.cfg");
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      try
      {
        localObject1 = a(((File)localObject1).getAbsolutePath());
        if (localObject1 != null)
        {
          localObject1 = new JSONArray((String)localObject1);
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new JSONArray();
          }
          return localObject3;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = null;
    }
  }
  
  public JSONObject a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject;
    for (;;)
    {
      try
      {
        if (!a(paramInt).booleanValue()) {
          continue;
        }
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "已经下载");
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
        switch (((DownloadTask)localObject).a())
        {
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "queryInfo bubbleId=" + paramInt + ",json=" + localJSONObject1.toString());
      }
      return localJSONObject1;
      localObject = a(paramInt, "all.zip");
      localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((String)localObject);
      if ((localObject != null) && (!((DownloadTask)localObject).b())) {
        continue;
      }
      localJSONObject2.put("status", 1);
      localJSONObject2.put("progress", 0);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "未在下载");
    }
    for (;;)
    {
      localJSONException.put("status", 1);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "未知状态");
      for (;;)
      {
        localJSONException.put("progress", ((DownloadTask)localObject).jdField_a_of_type_Float);
        break;
        localJSONException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载中");
        continue;
        localJSONException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", "下载失败");
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return;
    }
    String str = b(paramInt, paramString);
    File localFile = new File(a(paramInt, true), paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("name", paramString);
    localBundle.putInt("id", paramInt);
    paramString = new DownloadTask(str, localFile);
    paramString.e = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramString, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    String str = Integer.toString(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), str, paramString2, String.valueOf(paramLong));
      return;
      paramString2 = "unknow";
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = DownloaderFactory.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext());
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!a(paramInt).booleanValue()) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "bubbleId=" + paramInt + ",isQualityNetwork=" + bool3 + ",canFullDown=" + bool1);
    }
    return bool1;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = a(paramInt, paramBoolean);
    if (localObject1 == null)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject4;
    if (((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = 0;
      while (i1 < ((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject4 = (AnimationConfig)((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i1);
        int i2 = 0;
        while (i2 < ((AnimationConfig)localObject4).jdField_b_of_type_ArrayOfJavaLangString.length)
        {
          String str = localObject4.jdField_b_of_type_ArrayOfJavaLangString[i2];
          ((ArrayList)localObject2).add(str);
          ((HashMap)localObject3).put(str, ((AnimationConfig)localObject4).jdField_b_of_type_JavaLangString);
          i2 += 1;
        }
        i1 += 1;
      }
    }
    localObject1 = new BubbleInfo(paramInt, "", "", "", ((BubbleConfig)localObject1).jdField_b_of_type_Int, ((BubbleConfig)localObject1).jdField_c_of_type_Int, (String[])((ArrayList)localObject2).toArray(new String[0]), null, 0, 0, null, null, (HashMap)localObject3);
    boolean bool1;
    if (paramBoolean)
    {
      bool1 = a(paramInt, "static").booleanValue();
      boolean bool2 = false;
      if (!bool1) {
        bool2 = a((BubbleInfo)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createBubbleInfo bubbleId=" + paramInt + " hasUpdate=" + bool1 + ",isCheckOk=" + bool2 + ",autoAsyncDownload=" + paramBoolean);
      }
      if (bool2) {
        break label512;
      }
      if (paramBoolean)
      {
        if (!a(paramInt)) {
          break label486;
        }
        localObject2 = "all.zip";
      }
    }
    for (localObject1 = new File(a(paramInt, true), "all.zip");; localObject1 = new File(a(paramInt, true), "static.zip"))
    {
      localObject4 = a(paramInt, (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleInfo bubbleId=" + paramInt + " will down " + (String)localObject2 + ",file cacheKey=" + ((File)localObject1).getAbsolutePath());
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("name", (String)localObject2);
      ((Bundle)localObject3).putInt("id", paramInt);
      localObject1 = new DownloadTask((String)localObject4, (File)localObject1);
      ((DownloadTask)localObject1).e = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.b, (Bundle)localObject3);
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
      bool1 = false;
      break;
      label486:
      localObject2 = "static.zip";
    }
    label512:
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.put(Integer.valueOf(paramInt), localObject1);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(ChatActivity.class);
      if (localObject1 != null)
      {
        ((Handler)localObject1).removeMessages(16711697);
        ((Handler)localObject1).sendMessageDelayed(((Handler)localObject1).obtainMessage(16711697), jdField_a_of_type_Long);
      }
    }
    this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.containsKey(Integer.valueOf((int)paramLong)));
  }
  
  public File b()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  protected String b(int paramInt, String paramString)
  {
    return EmosmUtils.insertMtype("VIP_bubble_json", String.format("https://i.gtimg.cn/club/item/avatar/json/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), paramString }));
  }
  
  public JSONObject b(int paramInt)
  {
    Object localObject1 = a(paramInt, false).getAbsolutePath() + File.separatorChar + "version.json";
    try
    {
      localObject1 = a((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      localObject1 = new JSONObject((String)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
    return localObject1;
  }
  
  public void b(int paramInt, String paramString)
  {
    int i1 = 0;
    Object localObject = new JSONObject();
    JSONObject localJSONObject1 = b(paramInt);
    if (localJSONObject1 != null) {}
    for (;;)
    {
      try
      {
        if (!localJSONObject1.has("global_version")) {
          break label251;
        }
        i2 = localJSONObject1.getInt("global_version");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        continue;
        i1 = -1;
        continue;
      }
      synchronized (this.jdField_a_of_type_OrgJsonJSONArray)
      {
        if (i1 < this.jdField_a_of_type_OrgJsonJSONArray.length())
        {
          JSONObject localJSONObject2 = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
          if (localJSONObject2.getInt("id") == paramInt)
          {
            localObject = localJSONObject2;
            if (paramString == null)
            {
              if (localJSONObject1 == null) {
                break label257;
              }
              localJSONObject1.put("full_download", 1);
              paramString = localJSONObject1;
              paramString.put("id", paramInt);
              paramString.put("version", i2);
              if (paramString.has("updatelist")) {
                paramString.remove("updatelist");
              }
              if (paramString.has("update")) {
                paramString.remove("update");
              }
              if (i1 == -1) {
                continue;
              }
              this.jdField_a_of_type_OrgJsonJSONArray.put(i1, paramString);
              a();
            }
          }
          else
          {
            i1 += 1;
            continue;
          }
          if ((localJSONObject1 == null) || (!localJSONObject1.has(paramString))) {
            break label257;
          }
          ((JSONObject)localObject).put(paramString, localJSONObject1.getString(paramString));
          break label257;
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
        }
      }
      label251:
      int i2 = 0;
      continue;
      label257:
      paramString = (String)localObject;
    }
  }
  
  public boolean b(int paramInt)
  {
    try
    {
      File localFile2 = new File(c(), paramInt + ".zip");
      File localFile3 = b();
      try
      {
        File localFile1 = a(paramInt);
        ZipUtils.a(localFile2, localFile1.getAbsolutePath() + File.separatorChar);
        localFile2 = new File(localFile3.getAbsolutePath() + File.separatorChar + paramInt);
        if (localFile2.exists()) {
          a(paramInt);
        }
        FileUtils.a(localFile1, localFile2);
        FileUtils.a(localFile1.getAbsolutePath());
        bool = true;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "unzip bubble resource failure,bubbleId=" + paramInt, localIOException);
          }
          boolean bool = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipBubbleResource bubbleId=" + paramInt + " ret=" + bool);
      }
      return bool;
    }
    finally {}
  }
  
  public File c()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath() + File.separatorChar + "bubble_info" + File.separatorChar + "temp");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONObject c(int paramInt)
  {
    String str = a(paramInt, "all.zip");
    int i1 = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(false, str);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("status", i1);
        if (i1 != 0) {
          continue;
        }
        str = "设置成功";
        localJSONObject.put("message", str);
        localJSONObject.put("id", paramInt);
        localJSONObject.put("result", 0);
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "stopDownload id=" + paramInt + ",status=" + i1);
      }
      return localJSONObject;
      str = "未启动下载";
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownload id=" + paramInt);
    }
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      localBundle.putInt("srcType", 3);
      localBundle.putString("callbackId", paramString);
    }
    if (a(paramInt).booleanValue()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(paramInt, 3, localBundle);
      }
    }
    do
    {
      return;
      if (NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null) || (paramString == null));
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(paramInt, -1, localBundle);
    return;
    paramString = a(paramInt, "all.zip");
    File localFile = new File(c(), paramInt + ".zip");
    localBundle.putString("name", "all.zip");
    localBundle.putInt("id", paramInt);
    paramString = new DownloadTask(paramString, localFile);
    paramString.jdField_b_of_type_Boolean = true;
    paramString.e = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramString, this.b, localBundle);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy...");
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.clear();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager
 * JD-Core Version:    0.7.0.1
 */