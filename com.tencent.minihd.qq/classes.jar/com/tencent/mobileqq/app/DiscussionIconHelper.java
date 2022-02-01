package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hiw;
import hix;
import hiy;
import hiz;
import hja;
import hjb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class DiscussionIconHelper
  extends FriendListObserver
  implements Handler.Callback
{
  private static final byte jdField_a_of_type_Byte = 1;
  public static final int a = 5;
  static final String jdField_a_of_type_JavaLangString = "Q.qqhead.dih";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final byte jdField_b_of_type_Byte = 2;
  public static final int b = 4;
  private static final byte jdField_c_of_type_Byte = 3;
  private static int e = 72;
  private static final int f = 9527;
  private static final int g = 300;
  private static final int h = 8;
  private static final int i = 3600000;
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private hix jdField_a_of_type_Hix = null;
  private hjb jdField_a_of_type_Hjb;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Comparator jdField_a_of_type_JavaUtilComparator = new hiw(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private int j = 60000;
  private int k = 90000;
  
  public DiscussionIconHelper(String paramString, DiscussionHandler paramDiscussionHandler)
  {
    this.c = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create DiscussionIconHelper For [" + this.c + "]");
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_Hjb = new hjb(paramDiscussionHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper(), this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = paramDiscussionHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hiy(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
  }
  
  private Pair a(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return Pair.create(Boolean.valueOf(false), null);
    }
    boolean bool = true;
    float f2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 1.0F;
    }
    int i1 = (int)(50.0F * f1 + 0.5D);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon density=" + f1 + ";imageWidth=" + i1);
    }
    paramString1 = paramString1.split(";");
    if (paramString1.length > 5) {}
    Bitmap[] arrayOfBitmap;
    for (int m = 5;; m = paramString1.length)
    {
      arrayOfBitmap = new Bitmap[m];
      int n = 0;
      while (n < m)
      {
        String str = paramString1[n];
        Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, 0, 0);
        if (!((Boolean)localPair.first).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "getScaledFaceBitmap fail, disUin=" + paramString2 + ", uin=" + str);
          }
          paramArrayList.remove(str);
          bool = false;
        }
        arrayOfBitmap[n] = ((Bitmap)localPair.second);
        n += 1;
      }
    }
    try
    {
      paramString1 = a(i1, arrayOfBitmap);
      return Pair.create(Boolean.valueOf(bool), paramString1);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        bool = false;
        paramString1 = null;
      }
    }
  }
  
  private hiz a(String paramString, boolean paramBoolean1, hiz paramhiz, boolean paramBoolean2)
  {
    Object localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = ((DiscussionManager)localObject1).b(paramString);
    label89:
    Object localObject3;
    Object localObject4;
    if (QLog.isColorLevel())
    {
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is empty...");
      }
    }
    else
    {
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0)) {
        break label453;
      }
      paramhiz.jdField_a_of_type_Int = 0;
      localObject3 = a((ArrayList)localObject2, paramString, paramBoolean2);
      paramhiz.jdField_a_of_type_JavaLangString = ((String)localObject3);
      if (paramBoolean1)
      {
        localObject1 = ((DiscussionManager)localObject1).a(paramString);
        if (localObject1 != null)
        {
          localObject4 = ((DiscussionInfo)localObject1).faceUinSet;
          if (((localObject4 != null) && (!"".equals(((String)localObject4).trim()))) || ((localObject3 != null) && (!"".equals(((String)localObject3).trim())))) {
            break label465;
          }
          paramBoolean1 = false;
        }
      }
    }
    for (;;)
    {
      paramhiz.jdField_a_of_type_Boolean = paramBoolean1;
      if (QLog.isColorLevel())
      {
        localObject2 = ((DiscussionInfo)localObject1).discussionName;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 3) {
            localObject1 = ((String)localObject2).substring(0, 2) + "." + ((String)localObject2).charAt(((String)localObject2).length() - 1);
          }
        }
        QLog.d("Q.qqhead.dih", 2, "getDiscussionIconInfo. disUin=" + paramString + ", isChanged=" + paramBoolean1 + ", name=" + (String)localObject1 + ", faceUinSet=" + (String)localObject4 + ", newFaceUinSet=" + (String)localObject3);
      }
      return paramhiz;
      localObject3 = new StringBuilder();
      localObject4 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        if ((str != null) && (str.length() > 5)) {
          ((StringBuilder)localObject3).append(str.substring(0, 4));
        }
        for (;;)
        {
          ((StringBuilder)localObject3).append(";");
          break;
          ((StringBuilder)localObject3).append(str);
        }
      }
      QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is:" + ((StringBuilder)localObject3).toString());
      break;
      label453:
      paramhiz.jdField_a_of_type_Int = ((ArrayList)localObject2).size();
      break label89;
      label465:
      if ((localObject3 != null) && (!((String)localObject3).equals(localObject4))) {
        paramBoolean1 = true;
      } else if ((localObject4 != null) && (!((String)localObject4).equals(localObject3))) {
        paramBoolean1 = true;
      } else if ((paramhiz.jdField_a_of_type_Byte == 2) && (localObject3 != null) && (!((String)localObject3).equals(paramhiz.jdField_b_of_type_JavaLangString))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
    }
  }
  
  private String a(ArrayList paramArrayList, String paramString, boolean paramBoolean)
  {
    int n = 0;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramString = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      int m = 0;
      while (m < arrayOfString.length)
      {
        arrayOfString[m] = ((String)paramArrayList.get(m));
        m += 1;
      }
      Arrays.sort(arrayOfString, this.jdField_a_of_type_JavaUtilComparator);
      int i1 = 0;
      m = n;
      n = i1;
      for (;;)
      {
        if (m < arrayOfString.length)
        {
          paramString.append(arrayOfString[m]).append(";");
          n += 1;
          if ((!paramBoolean) || (!a()) || (n < 4)) {
            break label147;
          }
        }
        label147:
        while (n >= 5) {
          return paramString.toString();
        }
        m += 1;
      }
    }
    return " ";
  }
  
  private void a(String paramString, hiz paramhiz, boolean paramBoolean)
  {
    if (paramhiz.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + paramhiz.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramhiz.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject1 = b(paramhiz.jdField_a_of_type_JavaLangString, paramString, paramhiz.jdField_a_of_type_JavaUtilArrayList);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    String str;
    if (bool1)
    {
      paramhiz.jdField_b_of_type_Int += 1;
      str = a(paramhiz.jdField_a_of_type_JavaUtilArrayList, paramString, paramBoolean);
      paramhiz.jdField_b_of_type_JavaLangString = str;
      localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject1 == null) {
        break label510;
      }
    }
    label510:
    for (localObject1 = ((DiscussionManager)localObject1).a(paramString);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        ((DiscussionInfo)localObject1).faceUinSet = str;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        ((EntityManager)localObject2).a((Entity)localObject1);
        ((EntityManager)localObject2).a();
      }
      if ((paramhiz.jdField_a_of_type_JavaUtilArrayList.size() >= paramhiz.jdField_a_of_type_Int) && (bool2)) {
        paramhiz.jdField_a_of_type_Byte = 3;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(bool1, bool2, paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      if (localObject1 != null)
      {
        localObject2 = ((DiscussionInfo)localObject1).discussionName;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() <= 3) {}
        }
      }
      for (localObject1 = ((String)localObject2).substring(0, 2) + "." + ((String)localObject2).charAt(((String)localObject2).length() - 1);; localObject1 = null)
      {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: " + paramString + ", name=" + (String)localObject1 + ", state=" + paramhiz.jdField_a_of_type_Byte + ", iconCount=" + paramhiz.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramhiz.jdField_a_of_type_Int + ", isComplete=" + bool2 + ", faceUinSet=" + paramhiz.jdField_a_of_type_JavaLangString + ", newFaceUinSet=" + str);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + paramhiz.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramhiz.jdField_a_of_type_Int);
        return;
      }
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = System.currentTimeMillis();
        hiz localhiz;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localhiz = (hiz)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localhiz.jdField_a_of_type_Byte == 3)
          {
            m = 1;
            if (((m == 0) && (l - localhiz.jdField_a_of_type_Long < this.k)) || ((m != 0) && (!paramBoolean) && (l - localhiz.jdField_a_of_type_Long < 3600000L))) {
              return false;
            }
            localhiz.a(localhiz.jdField_a_of_type_Byte);
            localhiz.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localhiz);
            return true;
          }
        }
        else
        {
          localhiz = new hiz(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localhiz);
        }
      }
      int m = 0;
    }
  }
  
  /* Error */
  private Pair b(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +15 -> 20
    //   8: iconst_0
    //   9: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   12: iconst_0
    //   13: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   16: invokestatic 162	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   19: areturn
    //   20: aload_0
    //   21: getfield 130	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   24: getfield 112	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: bipush 101
    //   29: aload_2
    //   30: iconst_0
    //   31: invokevirtual 431	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   34: astore 8
    //   36: aload_0
    //   37: getfield 131	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   40: bipush 101
    //   42: aload_2
    //   43: iconst_1
    //   44: iconst_0
    //   45: invokevirtual 434	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   48: astore 9
    //   50: new 436	java/io/File
    //   53: dup
    //   54: aload 8
    //   56: invokespecial 438	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 10
    //   61: aload_1
    //   62: invokevirtual 270	java/lang/String:trim	()Ljava/lang/String;
    //   65: invokevirtual 150	java/lang/String:length	()I
    //   68: ifgt +49 -> 117
    //   71: aload 10
    //   73: invokevirtual 441	java/io/File:exists	()Z
    //   76: ifeq +17 -> 93
    //   79: aload 10
    //   81: invokevirtual 444	java/io/File:isFile	()Z
    //   84: ifeq +9 -> 93
    //   87: aload 10
    //   89: invokevirtual 447	java/io/File:delete	()Z
    //   92: pop
    //   93: aload_0
    //   94: getfield 131	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   97: aload 9
    //   99: invokestatic 452	com/tencent/mobileqq/utils/ImageUtil:e	()Landroid/graphics/Bitmap;
    //   102: invokevirtual 455	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   105: iconst_1
    //   106: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   109: iconst_1
    //   110: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: invokestatic 162	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   116: areturn
    //   117: aload_0
    //   118: aload_1
    //   119: aload_2
    //   120: aload_3
    //   121: invokespecial 457	com/tencent/mobileqq/app/DiscussionIconHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Landroid/util/Pair;
    //   124: astore_3
    //   125: aload_3
    //   126: getfield 221	android/util/Pair:second	Ljava/lang/Object;
    //   129: checkcast 199	android/graphics/Bitmap
    //   132: astore 7
    //   134: aload_3
    //   135: getfield 205	android/util/Pair:first	Ljava/lang/Object;
    //   138: checkcast 152	java/lang/Boolean
    //   141: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
    //   144: istore 5
    //   146: aload 7
    //   148: ifnonnull +25 -> 173
    //   151: iconst_0
    //   152: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   155: iconst_0
    //   156: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   159: invokestatic 162	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   162: areturn
    //   163: astore_3
    //   164: iconst_1
    //   165: istore 5
    //   167: aconst_null
    //   168: astore 7
    //   170: goto -24 -> 146
    //   173: aload 10
    //   175: invokevirtual 441	java/io/File:exists	()Z
    //   178: ifne +9 -> 187
    //   181: aload 10
    //   183: invokevirtual 460	java/io/File:createNewFile	()Z
    //   186: pop
    //   187: new 462	java/io/FileOutputStream
    //   190: dup
    //   191: aload 10
    //   193: invokespecial 465	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   196: astore_3
    //   197: aload 7
    //   199: getstatic 471	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   202: bipush 90
    //   204: aload_3
    //   205: invokevirtual 475	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   208: istore 6
    //   210: aload_3
    //   211: invokevirtual 478	java/io/FileOutputStream:flush	()V
    //   214: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   217: ifeq +66 -> 283
    //   220: ldc 14
    //   222: iconst_4
    //   223: new 79	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 483
    //   233: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload 6
    //   238: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: ldc_w 485
    //   244: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_2
    //   248: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 485
    //   254: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_1
    //   258: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 485
    //   264: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 8
    //   269: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 88
    //   274: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: getfield 131	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   287: aload 9
    //   289: aload 7
    //   291: invokevirtual 455	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   294: iload 6
    //   296: istore 4
    //   298: aload_3
    //   299: ifnull +11 -> 310
    //   302: aload_3
    //   303: invokevirtual 490	java/io/FileOutputStream:close	()V
    //   306: iload 6
    //   308: istore 4
    //   310: iload 4
    //   312: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   315: iload 5
    //   317: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   320: invokestatic 162	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   323: areturn
    //   324: astore_1
    //   325: aload_1
    //   326: invokevirtual 493	java/io/IOException:printStackTrace	()V
    //   329: iload 6
    //   331: istore 4
    //   333: goto -23 -> 310
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_1
    //   339: aload_1
    //   340: ifnull +52 -> 392
    //   343: aload_1
    //   344: invokevirtual 490	java/io/FileOutputStream:close	()V
    //   347: iconst_0
    //   348: istore 4
    //   350: goto -40 -> 310
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 493	java/io/IOException:printStackTrace	()V
    //   358: goto -11 -> 347
    //   361: astore_1
    //   362: aconst_null
    //   363: astore_3
    //   364: aload_3
    //   365: ifnull +7 -> 372
    //   368: aload_3
    //   369: invokevirtual 490	java/io/FileOutputStream:close	()V
    //   372: aload_1
    //   373: athrow
    //   374: astore_2
    //   375: aload_2
    //   376: invokevirtual 493	java/io/IOException:printStackTrace	()V
    //   379: goto -7 -> 372
    //   382: astore_1
    //   383: goto -19 -> 364
    //   386: astore_1
    //   387: aload_3
    //   388: astore_1
    //   389: goto -50 -> 339
    //   392: iconst_0
    //   393: istore 4
    //   395: goto -85 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	DiscussionIconHelper
    //   0	398	1	paramString1	String
    //   0	398	2	paramString2	String
    //   0	398	3	paramArrayList	ArrayList
    //   296	98	4	bool1	boolean
    //   144	172	5	bool2	boolean
    //   208	122	6	bool3	boolean
    //   132	158	7	localBitmap	Bitmap
    //   34	234	8	str1	String
    //   48	240	9	str2	String
    //   59	133	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   117	146	163	java/lang/Throwable
    //   302	306	324	java/io/IOException
    //   173	187	336	java/lang/Throwable
    //   187	197	336	java/lang/Throwable
    //   343	347	353	java/io/IOException
    //   173	187	361	finally
    //   187	197	361	finally
    //   368	372	374	java/io/IOException
    //   197	283	382	finally
    //   283	294	382	finally
    //   197	283	386	java/lang/Throwable
    //   283	294	386	java/lang/Throwable
  }
  
  private void f(String paramString)
  {
    this.jdField_a_of_type_Hjb.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Hjb.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Hjb.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: invokestatic 518	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 519	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6: ldc_w 520
    //   9: invokestatic 526	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   12: astore 4
    //   14: iload_1
    //   15: aload_2
    //   16: aload 4
    //   18: fconst_1
    //   19: invokestatic 531	com/tencent/mobileqq/util/PuzzleAvatarUtil:a	(I[Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_3
    //   25: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +38 -> 66
    //   31: aload_2
    //   32: astore_3
    //   33: aload_2
    //   34: ifnonnull +32 -> 66
    //   37: ldc 14
    //   39: iconst_2
    //   40: new 79	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 533
    //   50: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: astore_3
    //   66: aload_3
    //   67: areturn
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -11 -> 66
    //   80: ldc 14
    //   82: iconst_2
    //   83: aload 4
    //   85: invokevirtual 537	java/lang/Exception:toString	()Ljava/lang/String;
    //   88: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_2
    //   92: areturn
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -36 -> 66
    //   105: ldc 14
    //   107: iconst_2
    //   108: aload 4
    //   110: invokevirtual 538	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   113: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_2
    //   117: areturn
    //   118: astore 4
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: astore_3
    //   124: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -61 -> 66
    //   130: ldc 14
    //   132: iconst_2
    //   133: aload 4
    //   135: invokevirtual 539	java/lang/Error:toString	()Ljava/lang/String;
    //   138: invokestatic 487	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_2
    //   142: areturn
    //   143: astore 4
    //   145: goto -23 -> 122
    //   148: astore 4
    //   150: goto -53 -> 97
    //   153: astore 4
    //   155: goto -83 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	DiscussionIconHelper
    //   0	158	1	paramInt	int
    //   0	158	2	paramArrayOfBitmap	Bitmap[]
    //   24	100	3	arrayOfBitmap	Bitmap[]
    //   12	42	4	localBitmap	Bitmap
    //   68	16	4	localException1	java.lang.Exception
    //   93	16	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   118	16	4	localError1	java.lang.Error
    //   143	1	4	localError2	java.lang.Error
    //   148	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   153	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	23	68	java/lang/Exception
    //   0	23	93	java/lang/OutOfMemoryError
    //   0	23	118	java/lang/Error
    //   25	31	143	java/lang/Error
    //   37	64	143	java/lang/Error
    //   25	31	148	java/lang/OutOfMemoryError
    //   37	64	148	java/lang/OutOfMemoryError
    //   25	31	153	java/lang/Exception
    //   37	64	153	java/lang/Exception
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        hiz localhiz = (hiz)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
        if ((localhiz != null) && (localhiz.jdField_a_of_type_JavaLangString != null) && (localhiz.jdField_a_of_type_Byte != 3))
        {
          String str2 = localhiz.jdField_a_of_type_JavaLangString;
          if ((paramBoolean) && (str2.contains(paramString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            localhiz.jdField_a_of_type_JavaUtilArrayList.add(paramString);
            f(str1);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "DiscussionIconHelper release.");
    }
    if (this.jdField_a_of_type_Hix != null) {
      this.jdField_a_of_type_Hix.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          hiz localhiz = (hiz)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if ((localhiz != null) && (localhiz.jdField_a_of_type_Byte != 3)) {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(false, true, str);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void b(String paramString)
  {
    boolean bool = a(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDisIcon: " + paramString + ", isNeedToDo=" + bool);
    }
    if (bool) {
      f(paramString);
    }
  }
  
  public void c(String paramString)
  {
    boolean bool = a(paramString, false);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "checkDisIcon: " + paramString + ", isNeedToDo=" + bool);
      }
      paramString = new hja(this, 1, paramString);
      ThreadManager.a().post(paramString);
    }
  }
  
  public void d(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) && (l - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(paramString)).longValue() < this.j))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon repeat: " + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + paramString);
    }
    this.jdField_a_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(l));
    paramString = new hja(this, 3, paramString);
    ThreadManager.a().post(paramString);
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "removeDiscussion: " + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = new hja(this, 2, (String)paramMessage.obj);
      ThreadManager.a().post(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionIconHelper
 * JD-Core Version:    0.7.0.1
 */