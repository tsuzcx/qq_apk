package com.tencent.mobileqq.structmsg;

import android.util.SparseArray;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemMore;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPrice;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTimer;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVote;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVoteCover;
import java.util.HashMap;

public class StructMsgElementFactory
{
  private static final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private static final String jdField_a_of_type_JavaLangString = StructMsgElementFactory.class.getSimpleName();
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put("picture", StructMsgItemCover.class);
    jdField_a_of_type_JavaUtilHashMap.put("title", StructMsgItemTitle.class);
    jdField_a_of_type_JavaUtilHashMap.put("summary", StructMsgItemSummary.class);
    jdField_a_of_type_JavaUtilHashMap.put("timer", StructMsgItemTimer.class);
    jdField_a_of_type_JavaUtilHashMap.put("hr", StructMsgItemHr.class);
    jdField_a_of_type_JavaUtilHashMap.put("image", StructMsgItemImage.class);
    jdField_a_of_type_JavaUtilHashMap.put("more", StructMsgItemMore.class);
    jdField_a_of_type_JavaUtilHashMap.put("progress", StructMsgItemProgress.class);
    jdField_a_of_type_JavaUtilHashMap.put("checklist", StructMsgItemVote.class);
    jdField_a_of_type_JavaUtilHashMap.put("vote", StructMsgItemVoteCover.class);
    jdField_a_of_type_JavaUtilHashMap.put("price", StructMsgItemPrice.class);
    jdField_a_of_type_JavaUtilHashMap.put("button", StructMsgItemButton.class);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.append(0, StructMsgItemLayoutDefault.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(1, StructMsgItemLayout1.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(2, StructMsgItemLayout2.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(3, StructMsgItemLayout3.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(4, StructMsgItemLayout4.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(5, StructMsgItemLayout5.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(6, StructMsgItemLayout6.class);
  }
  
  public static AbsStructMsgElement a(String paramString)
  {
    return a(paramString, 0);
  }
  
  /* Error */
  public static AbsStructMsgElement a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 112
    //   2: aload_0
    //   3: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +47 -> 53
    //   9: getstatic 25	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 12	java/lang/Class
    //   19: astore_0
    //   20: aload_0
    //   21: ifnull +317 -> 338
    //   24: aload_0
    //   25: invokevirtual 126	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   28: checkcast 128	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   31: astore_2
    //   32: aload_0
    //   33: ifnonnull +34 -> 67
    //   36: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +12 -> 51
    //   42: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: iconst_2
    //   46: ldc 136
    //   48: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_2
    //   52: areturn
    //   53: getstatic 82	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   56: iload_1
    //   57: invokevirtual 143	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   60: checkcast 12	java/lang/Class
    //   63: astore_0
    //   64: goto -44 -> 20
    //   67: aload_2
    //   68: ifnonnull -17 -> 51
    //   71: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq -23 -> 51
    //   77: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: iconst_2
    //   81: new 145	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   88: ldc 148
    //   90: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   97: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 153
    //   102: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_2
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnonnull +20 -> 137
    //   120: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +213 -> 336
    //   126: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   129: iconst_2
    //   130: ldc 136
    //   132: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aconst_null
    //   136: areturn
    //   137: iconst_0
    //   138: ifne +198 -> 336
    //   141: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +192 -> 336
    //   147: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: iconst_2
    //   151: new 145	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   158: ldc 148
    //   160: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   167: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 153
    //   172: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aconst_null
    //   182: areturn
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_0
    //   186: aload_0
    //   187: ifnonnull +20 -> 207
    //   190: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +143 -> 336
    //   196: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_2
    //   200: ldc 136
    //   202: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aconst_null
    //   206: areturn
    //   207: iconst_0
    //   208: ifne +128 -> 336
    //   211: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +122 -> 336
    //   217: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   220: iconst_2
    //   221: new 145	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   228: ldc 148
    //   230: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   237: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 153
    //   242: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_2
    //   254: aconst_null
    //   255: astore_0
    //   256: aload_0
    //   257: ifnonnull +20 -> 277
    //   260: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +12 -> 275
    //   266: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   269: iconst_2
    //   270: ldc 136
    //   272: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_2
    //   276: athrow
    //   277: iconst_0
    //   278: ifne -3 -> 275
    //   281: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq -9 -> 275
    //   287: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   290: iconst_2
    //   291: new 145	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   298: ldc 148
    //   300: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   307: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 153
    //   312: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: goto -46 -> 275
    //   324: astore_2
    //   325: goto -69 -> 256
    //   328: astore_2
    //   329: goto -143 -> 186
    //   332: astore_2
    //   333: goto -217 -> 116
    //   336: aconst_null
    //   337: areturn
    //   338: aconst_null
    //   339: astore_2
    //   340: goto -308 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramString	String
    //   0	343	1	paramInt	int
    //   31	81	2	localAbsStructMsgElement	AbsStructMsgElement
    //   253	23	2	localObject1	Object
    //   324	1	2	localObject2	Object
    //   328	1	2	localInstantiationException	java.lang.InstantiationException
    //   332	1	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   339	1	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	20	113	java/lang/IllegalAccessException
    //   53	64	113	java/lang/IllegalAccessException
    //   0	20	183	java/lang/InstantiationException
    //   53	64	183	java/lang/InstantiationException
    //   0	20	253	finally
    //   53	64	253	finally
    //   24	32	324	finally
    //   24	32	328	java/lang/InstantiationException
    //   24	32	332	java/lang/IllegalAccessException
  }
  
  /* Error */
  public static AbsStructMsgItem a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 82	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3: iload_0
    //   4: invokevirtual 143	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   7: checkcast 12	java/lang/Class
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +287 -> 299
    //   15: aload_2
    //   16: invokevirtual 126	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   19: checkcast 159	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   22: astore_1
    //   23: aload_2
    //   24: ifnonnull +20 -> 44
    //   27: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +267 -> 297
    //   33: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_2
    //   37: ldc 136
    //   39: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: areturn
    //   44: aload_1
    //   45: ifnonnull +252 -> 297
    //   48: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +246 -> 297
    //   54: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   57: iconst_2
    //   58: new 145	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   65: ldc 148
    //   67: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   74: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 153
    //   79: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_1
    //   89: areturn
    //   90: astore_1
    //   91: aload_2
    //   92: ifnonnull +20 -> 112
    //   95: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +197 -> 295
    //   101: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   104: iconst_2
    //   105: ldc 136
    //   107: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aconst_null
    //   111: areturn
    //   112: iconst_0
    //   113: ifne +182 -> 295
    //   116: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +176 -> 295
    //   122: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   125: iconst_2
    //   126: new 145	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   133: ldc 148
    //   135: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   142: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 153
    //   147: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_1
    //   159: aload_2
    //   160: ifnonnull +20 -> 180
    //   163: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +129 -> 295
    //   169: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: iconst_2
    //   173: ldc 136
    //   175: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aconst_null
    //   179: areturn
    //   180: iconst_0
    //   181: ifne +114 -> 295
    //   184: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +108 -> 295
    //   190: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: iconst_2
    //   194: new 145	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   201: ldc 148
    //   203: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_2
    //   207: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   210: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 153
    //   215: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_1
    //   227: aload_2
    //   228: ifnonnull +20 -> 248
    //   231: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +12 -> 246
    //   237: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: iconst_2
    //   241: ldc 136
    //   243: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload_1
    //   247: athrow
    //   248: iconst_0
    //   249: ifne -3 -> 246
    //   252: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq -9 -> 246
    //   258: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   261: iconst_2
    //   262: new 145	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   269: ldc 148
    //   271: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_2
    //   275: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   278: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 153
    //   283: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -46 -> 246
    //   295: aconst_null
    //   296: areturn
    //   297: aload_1
    //   298: areturn
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -278 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramInt	int
    //   22	67	1	localAbsStructMsgItem1	AbsStructMsgItem
    //   90	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   158	1	1	localInstantiationException	java.lang.InstantiationException
    //   226	72	1	localAbsStructMsgItem2	AbsStructMsgItem
    //   300	1	1	localObject	Object
    //   10	265	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   15	23	90	java/lang/IllegalAccessException
    //   15	23	158	java/lang/InstantiationException
    //   15	23	226	finally
  }
  
  /* Error */
  public static AbsStructMsgItem a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: getstatic 82	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3: iload_0
    //   4: invokevirtual 143	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   7: checkcast 12	java/lang/Class
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +454 -> 466
    //   15: aload_3
    //   16: iconst_1
    //   17: anewarray 12	java/lang/Class
    //   20: dup
    //   21: iconst_0
    //   22: getstatic 170	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   25: aastore
    //   26: invokevirtual 174	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   29: astore_2
    //   30: aload_2
    //   31: iconst_1
    //   32: invokevirtual 180	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   35: aload_2
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: iload_1
    //   43: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokevirtual 187	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 159	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   53: astore_2
    //   54: aload_3
    //   55: ifnonnull +20 -> 75
    //   58: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +403 -> 464
    //   64: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: iconst_2
    //   68: ldc 136
    //   70: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_2
    //   74: areturn
    //   75: aload_2
    //   76: ifnonnull +388 -> 464
    //   79: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +382 -> 464
    //   85: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: iconst_2
    //   89: new 145	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   96: ldc 148
    //   98: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_3
    //   102: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   105: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 153
    //   110: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_2
    //   120: areturn
    //   121: astore_2
    //   122: aload_3
    //   123: ifnonnull +20 -> 143
    //   126: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +333 -> 462
    //   132: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   135: iconst_2
    //   136: ldc 136
    //   138: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aconst_null
    //   142: areturn
    //   143: iconst_0
    //   144: ifne +318 -> 462
    //   147: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +312 -> 462
    //   153: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   156: iconst_2
    //   157: new 145	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   164: ldc 148
    //   166: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   173: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 153
    //   178: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_2
    //   190: aload_3
    //   191: ifnonnull +20 -> 211
    //   194: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +265 -> 462
    //   200: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   203: iconst_2
    //   204: ldc 136
    //   206: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aconst_null
    //   210: areturn
    //   211: iconst_0
    //   212: ifne +250 -> 462
    //   215: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +244 -> 462
    //   221: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   224: iconst_2
    //   225: new 145	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   232: ldc 148
    //   234: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_3
    //   238: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   241: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 153
    //   246: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aconst_null
    //   256: areturn
    //   257: astore_2
    //   258: aload_3
    //   259: ifnonnull +20 -> 279
    //   262: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +197 -> 462
    //   268: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   271: iconst_2
    //   272: ldc 136
    //   274: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: aconst_null
    //   278: areturn
    //   279: iconst_0
    //   280: ifne +182 -> 462
    //   283: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +176 -> 462
    //   289: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   292: iconst_2
    //   293: new 145	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   300: ldc 148
    //   302: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_3
    //   306: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   309: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc 153
    //   314: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aconst_null
    //   324: areturn
    //   325: astore_2
    //   326: aload_3
    //   327: ifnonnull +20 -> 347
    //   330: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +129 -> 462
    //   336: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   339: iconst_2
    //   340: ldc 136
    //   342: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aconst_null
    //   346: areturn
    //   347: iconst_0
    //   348: ifne +114 -> 462
    //   351: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +108 -> 462
    //   357: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: iconst_2
    //   361: new 145	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   368: ldc 148
    //   370: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_3
    //   374: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   377: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: ldc 153
    //   382: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aconst_null
    //   392: areturn
    //   393: astore_2
    //   394: aload_3
    //   395: ifnonnull +20 -> 415
    //   398: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +12 -> 413
    //   404: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   407: iconst_2
    //   408: ldc 136
    //   410: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: aload_2
    //   414: athrow
    //   415: iconst_0
    //   416: ifne -3 -> 413
    //   419: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq -9 -> 413
    //   425: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   428: iconst_2
    //   429: new 145	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   436: ldc 148
    //   438: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_3
    //   442: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   445: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc 153
    //   450: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: goto -46 -> 413
    //   462: aconst_null
    //   463: areturn
    //   464: aload_2
    //   465: areturn
    //   466: aconst_null
    //   467: astore_2
    //   468: goto -414 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	paramInt1	int
    //   0	471	1	paramInt2	int
    //   29	91	2	localObject1	Object
    //   121	1	2	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   189	1	2	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   257	1	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   325	1	2	localInstantiationException	java.lang.InstantiationException
    //   393	72	2	localAbsStructMsgItem	AbsStructMsgItem
    //   467	1	2	localObject2	Object
    //   10	432	3	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   15	54	121	java/lang/NoSuchMethodException
    //   15	54	189	java/lang/reflect/InvocationTargetException
    //   15	54	257	java/lang/IllegalAccessException
    //   15	54	325	java/lang/InstantiationException
    //   15	54	393	finally
  }
  
  /* Error */
  public static AbsStructMsgItem a(int paramInt, java.util.Collection paramCollection)
  {
    // Byte code:
    //   0: getstatic 82	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3: iload_0
    //   4: invokevirtual 143	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   7: checkcast 12	java/lang/Class
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +450 -> 462
    //   15: aload_2
    //   16: iconst_1
    //   17: anewarray 12	java/lang/Class
    //   20: dup
    //   21: iconst_0
    //   22: ldc 190
    //   24: aastore
    //   25: invokevirtual 174	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   28: astore_3
    //   29: aload_3
    //   30: iconst_1
    //   31: invokevirtual 180	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   34: aload_3
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: invokevirtual 187	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 159	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   49: astore_1
    //   50: aload_2
    //   51: ifnonnull +20 -> 71
    //   54: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +403 -> 460
    //   60: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: iconst_2
    //   64: ldc 136
    //   66: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_1
    //   70: areturn
    //   71: aload_1
    //   72: ifnonnull +388 -> 460
    //   75: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +382 -> 460
    //   81: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: iconst_2
    //   85: new 145	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   92: ldc 148
    //   94: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   101: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 153
    //   106: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_1
    //   116: areturn
    //   117: astore_1
    //   118: aload_2
    //   119: ifnonnull +20 -> 139
    //   122: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +333 -> 458
    //   128: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: iconst_2
    //   132: ldc 136
    //   134: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aconst_null
    //   138: areturn
    //   139: iconst_0
    //   140: ifne +318 -> 458
    //   143: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +312 -> 458
    //   149: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   152: iconst_2
    //   153: new 145	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   160: ldc 148
    //   162: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_2
    //   166: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   169: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 153
    //   174: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_1
    //   186: aload_2
    //   187: ifnonnull +20 -> 207
    //   190: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +265 -> 458
    //   196: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_2
    //   200: ldc 136
    //   202: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aconst_null
    //   206: areturn
    //   207: iconst_0
    //   208: ifne +250 -> 458
    //   211: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +244 -> 458
    //   217: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   220: iconst_2
    //   221: new 145	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   228: ldc 148
    //   230: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_2
    //   234: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   237: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 153
    //   242: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_1
    //   254: aload_2
    //   255: ifnonnull +20 -> 275
    //   258: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +197 -> 458
    //   264: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   267: iconst_2
    //   268: ldc 136
    //   270: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aconst_null
    //   274: areturn
    //   275: iconst_0
    //   276: ifne +182 -> 458
    //   279: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +176 -> 458
    //   285: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   288: iconst_2
    //   289: new 145	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   296: ldc 148
    //   298: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_2
    //   302: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   305: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 153
    //   310: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: astore_1
    //   322: aload_2
    //   323: ifnonnull +20 -> 343
    //   326: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +129 -> 458
    //   332: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   335: iconst_2
    //   336: ldc 136
    //   338: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aconst_null
    //   342: areturn
    //   343: iconst_0
    //   344: ifne +114 -> 458
    //   347: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +108 -> 458
    //   353: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   356: iconst_2
    //   357: new 145	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   364: ldc 148
    //   366: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_2
    //   370: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   373: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 153
    //   378: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aconst_null
    //   388: areturn
    //   389: astore_1
    //   390: aload_2
    //   391: ifnonnull +20 -> 411
    //   394: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +12 -> 409
    //   400: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   403: iconst_2
    //   404: ldc 136
    //   406: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_1
    //   410: athrow
    //   411: iconst_0
    //   412: ifne -3 -> 409
    //   415: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq -9 -> 409
    //   421: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   424: iconst_2
    //   425: new 145	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   432: ldc 148
    //   434: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_2
    //   438: invokevirtual 16	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   441: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc 153
    //   446: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto -46 -> 409
    //   458: aconst_null
    //   459: areturn
    //   460: aload_1
    //   461: areturn
    //   462: aconst_null
    //   463: astore_1
    //   464: goto -414 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramInt	int
    //   0	467	1	paramCollection	java.util.Collection
    //   10	428	2	localClass	Class
    //   28	7	3	localConstructor	java.lang.reflect.Constructor
    // Exception table:
    //   from	to	target	type
    //   15	50	117	java/lang/NoSuchMethodException
    //   15	50	185	java/lang/reflect/InvocationTargetException
    //   15	50	253	java/lang/IllegalAccessException
    //   15	50	321	java/lang/InstantiationException
    //   15	50	389	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgElementFactory
 * JD-Core Version:    0.7.0.1
 */