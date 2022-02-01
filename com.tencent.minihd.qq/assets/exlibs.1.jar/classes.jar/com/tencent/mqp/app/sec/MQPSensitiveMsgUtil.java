package com.tencent.mqp.app.sec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.ims.bankcode_info.ElemPos;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kzq;
import kzs;
import kzt;
import kzu;
import kzv;
import kzw;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MQPSensitiveMsgUtil
{
  public static final int a = 1;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new kzu();
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  private static MQPSensitiveMsgUtil jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil;
  public static final String a = "Safe_SensMsg";
  private static int b = 0;
  public static final String b = "sens_msg_need_parse";
  private static final int c = 10;
  public static final String c = "sens_msg_need_mask";
  public static final String d = "sens_msg_original_text";
  public static final String e = "sens_msg_uniseq";
  public static final String f = "sens_msg_confirmed";
  public static final String g = "sens_msg_ctrl_info";
  public static final String h = "sens_msg_attr";
  public static final String i = "sens_msg_has_not_confirmed_msg";
  public static final String j = "0";
  public static final String k = "1";
  private static final String l = "sp_confirmed_sensmsg";
  private static String m;
  
  static
  {
    jdField_a_of_type_AndroidOsBundle = new Bundle();
    m = "0";
    jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil = null;
  }
  
  private static int a(String paramString, int paramInt)
  {
    int i2 = 0;
    int n;
    int i3;
    int i1;
    if (paramInt > 0)
    {
      n = paramInt;
      if (i2 >= paramInt) {
        return n;
      }
      i3 = paramString.codePointAt(i2);
      if (i3 != 20) {
        break label50;
      }
      i1 = n + 1;
    }
    for (;;)
    {
      i2 += 1;
      n = i1;
      break;
      n = 0;
      break;
      label50:
      i1 = n;
      if (EmotcationConstants.a.get(i3, -1) >= 0)
      {
        i1 = n;
        if (i3 > 65535) {
          i1 = n + 1;
        }
      }
    }
    return n;
  }
  
  public static MQPSensitiveMsgUtil a()
  {
    if (jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil == null)
    {
      jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil = new MQPSensitiveMsgUtil();
      a();
    }
    return jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil;
  }
  
  private static Object a(String paramString, int paramInt, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    return new kzw(paramString, paramInt, paramLong, paramBankcodeCtrlInfo, paramBoolean);
  }
  
  private static void a()
  {
    Object localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    BaseApplication.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {}
    while (!((AppRuntime)localObject).isLogin()) {
      return;
    }
    c(((AppRuntime)localObject).getAccount());
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Object[] arrayOfObject = paramSpannableStringBuilder.getSpans(paramInt1, paramInt2, Object.class);
    int i1 = arrayOfObject.length;
    int n = 0;
    label22:
    Object localObject;
    int i2;
    int i3;
    int i4;
    if (n < i1)
    {
      localObject = arrayOfObject[n];
      i2 = paramSpannableStringBuilder.getSpanStart(localObject);
      i3 = paramSpannableStringBuilder.getSpanEnd(localObject);
      i4 = paramSpannableStringBuilder.getSpanFlags(localObject);
      if ((i2 >= paramInt1) || (i3 > paramInt2)) {
        break label88;
      }
      paramSpannableStringBuilder.setSpan(localObject, i2, paramInt1, i4);
    }
    for (;;)
    {
      n += 1;
      break label22;
      break;
      label88:
      if ((i2 >= paramInt1) && (i3 <= paramInt2) && (!(localObject instanceof QQText.EmotcationSpan)))
      {
        paramSpannableStringBuilder.removeSpan(localObject);
      }
      else if ((i2 > paramInt1) && (i2 < paramInt2) && (i3 > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, i3, i4);
      }
      else if ((i2 < paramInt1) && (i3 > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, i2, paramInt1, i4);
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, i3, i4);
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject3 = new bankcode_info.BankcodeCtrlInfo();
    for (;;)
    {
      int n;
      try
      {
        ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.a((String)localObject1));
        if (!((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.has()) {
          break label253;
        }
        localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.get();
        if (localObject1 == null) {
          break;
        }
        localObject3 = ((List)localObject1).iterator();
        n = 0;
        if (((Iterator)localObject3).hasNext())
        {
          bankcode_info.BankcodeElem localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
          if (!localBankcodeElem.bankcode_attr.has()) {
            break label248;
          }
          i1 = localBankcodeElem.bankcode_attr.get();
          if (i1 <= n) {
            break label243;
          }
          n = i1;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = null;
        continue;
      }
      if (n != 20) {
        break;
      }
      localObject3 = ((List)localObject2).iterator();
      label236:
      label238:
      label241:
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
          if (!((bankcode_info.BankcodeElem)localObject2).bankcode_attr.has()) {
            break label238;
          }
        }
        for (n = ((bankcode_info.BankcodeElem)localObject2).bankcode_attr.get();; n = 0)
        {
          if (n != 20) {
            break label241;
          }
          if (((bankcode_info.BankcodeElem)localObject2).clean_bankcode.has()) {}
          for (localObject2 = ((bankcode_info.BankcodeElem)localObject2).clean_bankcode.get();; localObject2 = null)
          {
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label236;
            }
            a().a((String)localObject2);
            break;
            paramMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
            return;
          }
          break;
        }
      }
      label243:
      int i1 = n;
      continue;
      label248:
      i1 = 0;
      continue;
      label253:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public static void a(MessageRecord paramMessageRecord, List paramList, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 14
    //   6: aconst_null
    //   7: astore 15
    //   9: new 186	com/tencent/ims/bankcode_info$BankcodeCtrlInfo
    //   12: dup
    //   13: invokespecial 187	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:<init>	()V
    //   16: astore 16
    //   18: aload 16
    //   20: aload_3
    //   21: invokevirtual 196	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   24: pop
    //   25: aload 16
    //   27: getfield 260	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   30: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   33: ifeq +1103 -> 1136
    //   36: aload 16
    //   38: getfield 260	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   41: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   44: istore 5
    //   46: aload 15
    //   48: astore_3
    //   49: aload 16
    //   51: getfield 200	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   54: invokevirtual 205	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   57: ifeq +12 -> 69
    //   60: aload 16
    //   62: getfield 200	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   65: invokevirtual 208	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   68: astore_3
    //   69: iload 5
    //   71: istore 8
    //   73: aload_3
    //   74: astore 15
    //   76: aload 16
    //   78: astore_3
    //   79: aload 15
    //   81: ifnonnull +26 -> 107
    //   84: return
    //   85: astore 15
    //   87: aconst_null
    //   88: astore_3
    //   89: iconst_0
    //   90: istore 5
    //   92: aload 15
    //   94: invokevirtual 238	java/lang/Exception:printStackTrace	()V
    //   97: aconst_null
    //   98: astore 15
    //   100: iload 5
    //   102: istore 8
    //   104: goto -25 -> 79
    //   107: aload_0
    //   108: ldc 36
    //   110: invokevirtual 178	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 16
    //   115: aload 16
    //   117: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +484 -> 604
    //   123: aload 16
    //   125: invokestatic 270	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore 5
    //   130: iload 14
    //   132: istore 13
    //   134: iload 5
    //   136: bipush 20
    //   138: if_icmpne +26 -> 164
    //   141: aload_0
    //   142: ldc 39
    //   144: invokevirtual 178	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 16
    //   149: aload 16
    //   151: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +534 -> 688
    //   157: aload 16
    //   159: invokestatic 276	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   162: istore 13
    //   164: iload_2
    //   165: ifne +937 -> 1102
    //   168: iload 8
    //   170: iconst_1
    //   171: if_icmpne +931 -> 1102
    //   174: iload 5
    //   176: bipush 30
    //   178: if_icmpeq +15 -> 193
    //   181: iload 5
    //   183: bipush 20
    //   185: if_icmpne +917 -> 1102
    //   188: iload 13
    //   190: ifeq +912 -> 1102
    //   193: iconst_1
    //   194: istore 13
    //   196: aload_0
    //   197: ldc 21
    //   199: iload 13
    //   201: invokestatic 280	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   204: invokevirtual 255	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_1
    //   208: invokeinterface 214 1 0
    //   213: astore 17
    //   215: iconst_0
    //   216: istore 9
    //   218: iconst_0
    //   219: istore 6
    //   221: aload 17
    //   223: invokeinterface 219 1 0
    //   228: ifeq -144 -> 84
    //   231: aload 17
    //   233: invokeinterface 223 1 0
    //   238: checkcast 175	com/tencent/mobileqq/data/MessageRecord
    //   241: astore 18
    //   243: aload 18
    //   245: instanceof 282
    //   248: ifeq +796 -> 1044
    //   251: iload 13
    //   253: ifeq +710 -> 963
    //   256: aload 15
    //   258: invokeinterface 214 1 0
    //   263: astore 19
    //   265: aload 19
    //   267: invokeinterface 219 1 0
    //   272: ifeq +691 -> 963
    //   275: aload 19
    //   277: invokeinterface 223 1 0
    //   282: checkcast 225	com/tencent/ims/bankcode_info$BankcodeElem
    //   285: astore 20
    //   287: iconst_0
    //   288: istore 7
    //   290: iconst_0
    //   291: istore 5
    //   293: aload 20
    //   295: getfield 286	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   298: invokevirtual 289	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   301: ifeq +791 -> 1092
    //   304: aload 20
    //   306: getfield 286	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   309: invokevirtual 292	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   312: checkcast 288	com/tencent/ims/bankcode_info$ElemPos
    //   315: astore_1
    //   316: aload_1
    //   317: getfield 295	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   320: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   323: ifeq +12 -> 335
    //   326: aload_1
    //   327: getfield 295	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   330: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   333: istore 5
    //   335: iload 5
    //   337: istore 7
    //   339: aload_1
    //   340: getfield 298	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   343: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   346: ifeq +746 -> 1092
    //   349: aload_1
    //   350: getfield 298	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   353: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   356: istore 10
    //   358: iload 5
    //   360: istore 11
    //   362: iload 10
    //   364: iload 9
    //   366: if_icmplt -101 -> 265
    //   369: iload 11
    //   371: aload 18
    //   373: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   376: invokevirtual 304	java/lang/String:length	()I
    //   379: iload 9
    //   381: iadd
    //   382: if_icmpgt -117 -> 265
    //   385: iconst_0
    //   386: istore 7
    //   388: iconst_0
    //   389: istore 5
    //   391: aload 20
    //   393: getfield 307	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   396: invokevirtual 289	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   399: ifeq +687 -> 1086
    //   402: aload 20
    //   404: getfield 307	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   407: invokevirtual 292	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   410: checkcast 288	com/tencent/ims/bankcode_info$ElemPos
    //   413: astore_1
    //   414: aload_1
    //   415: getfield 295	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   418: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   421: ifeq +12 -> 433
    //   424: aload_1
    //   425: getfield 295	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   428: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   431: istore 5
    //   433: iload 5
    //   435: istore 7
    //   437: aload_1
    //   438: getfield 298	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   441: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   444: ifeq +642 -> 1086
    //   447: aload_1
    //   448: getfield 298	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   451: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   454: istore 12
    //   456: iload 5
    //   458: istore 7
    //   460: iload 12
    //   462: istore 5
    //   464: aload 18
    //   466: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   469: iload 11
    //   471: iload 6
    //   473: iadd
    //   474: iload 9
    //   476: isub
    //   477: invokestatic 309	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   480: istore 11
    //   482: aload 18
    //   484: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   487: iload 10
    //   489: iload 6
    //   491: iadd
    //   492: iload 9
    //   494: isub
    //   495: invokestatic 309	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   498: istore 12
    //   500: iload 7
    //   502: iload 11
    //   504: iadd
    //   505: istore 7
    //   507: iload 5
    //   509: iload 11
    //   511: iadd
    //   512: istore 10
    //   514: aload 18
    //   516: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   519: iload 11
    //   521: iload 12
    //   523: iconst_1
    //   524: iadd
    //   525: invokevirtual 313	java/lang/String:substring	(II)Ljava/lang/String;
    //   528: astore 21
    //   530: ldc_w 315
    //   533: astore_1
    //   534: iconst_0
    //   535: istore 5
    //   537: iload 5
    //   539: aload 21
    //   541: invokevirtual 304	java/lang/String:length	()I
    //   544: if_icmpge +290 -> 834
    //   547: aload 21
    //   549: iload 5
    //   551: invokevirtual 319	java/lang/String:charAt	(I)C
    //   554: istore 4
    //   556: iload 8
    //   558: tableswitch	default:+18 -> 576, 1:+241->799
    //   577: astore 16
    //   579: iload 5
    //   581: iconst_1
    //   582: iadd
    //   583: istore 5
    //   585: aload 16
    //   587: astore_1
    //   588: goto -51 -> 537
    //   591: astore 16
    //   593: aload 16
    //   595: invokevirtual 238	java/lang/Exception:printStackTrace	()V
    //   598: iconst_0
    //   599: istore 5
    //   601: goto -471 -> 130
    //   604: aload 15
    //   606: invokeinterface 214 1 0
    //   611: astore 16
    //   613: iload 6
    //   615: istore 5
    //   617: aload 16
    //   619: invokeinterface 219 1 0
    //   624: ifeq +509 -> 1133
    //   627: aload 16
    //   629: invokeinterface 223 1 0
    //   634: checkcast 225	com/tencent/ims/bankcode_info$BankcodeElem
    //   637: astore 17
    //   639: aload 17
    //   641: getfield 229	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   644: invokevirtual 232	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   647: ifeq +480 -> 1127
    //   650: aload 17
    //   652: getfield 229	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   655: invokevirtual 235	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   658: istore 6
    //   660: iload 6
    //   662: iload 5
    //   664: if_icmple +456 -> 1120
    //   667: iload 6
    //   669: istore 5
    //   671: goto -54 -> 617
    //   674: astore 16
    //   676: aload 16
    //   678: invokevirtual 238	java/lang/Exception:printStackTrace	()V
    //   681: iload 14
    //   683: istore 13
    //   685: goto -521 -> 164
    //   688: aload 15
    //   690: invokeinterface 214 1 0
    //   695: astore 17
    //   697: iconst_0
    //   698: istore 13
    //   700: aload 17
    //   702: invokeinterface 219 1 0
    //   707: ifeq +410 -> 1117
    //   710: aload 17
    //   712: invokeinterface 223 1 0
    //   717: checkcast 225	com/tencent/ims/bankcode_info$BankcodeElem
    //   720: astore 16
    //   722: iconst_0
    //   723: istore 6
    //   725: aload 16
    //   727: getfield 229	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   730: invokevirtual 232	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   733: ifeq +13 -> 746
    //   736: aload 16
    //   738: getfield 229	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   741: invokevirtual 235	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   744: istore 6
    //   746: iload 6
    //   748: bipush 20
    //   750: if_icmpne -50 -> 700
    //   753: aload 16
    //   755: getfield 242	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   758: invokevirtual 245	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   761: ifeq +350 -> 1111
    //   764: aload 16
    //   766: getfield 242	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   769: invokevirtual 247	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   772: astore 16
    //   774: aload 16
    //   776: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   779: ifne +329 -> 1108
    //   782: invokestatic 249	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	()Lcom/tencent/mqp/app/sec/MQPSensitiveMsgUtil;
    //   785: aload 16
    //   787: invokevirtual 321	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;)Z
    //   790: ifne +318 -> 1108
    //   793: iconst_1
    //   794: istore 13
    //   796: goto -96 -> 700
    //   799: aload_1
    //   800: astore 16
    //   802: iload 4
    //   804: invokestatic 327	java/lang/Character:isDigit	(C)Z
    //   807: ifeq -228 -> 579
    //   810: new 329	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   817: aload_1
    //   818: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: iload 4
    //   823: invokevirtual 337	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   826: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: astore 16
    //   831: goto -252 -> 579
    //   834: aload_1
    //   835: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   838: ifne -573 -> 265
    //   841: aload 20
    //   843: getfield 242	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   846: invokevirtual 245	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   849: ifeq +231 -> 1080
    //   852: aload 20
    //   854: getfield 242	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   857: invokevirtual 247	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   860: astore 16
    //   862: aload_1
    //   863: aload 16
    //   865: invokestatic 343	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   868: ifeq -603 -> 265
    //   871: ldc_w 315
    //   874: astore_1
    //   875: iconst_0
    //   876: istore 5
    //   878: iload 5
    //   880: iload 10
    //   882: iconst_1
    //   883: iadd
    //   884: iload 7
    //   886: isub
    //   887: if_icmpge +33 -> 920
    //   890: new 329	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   897: aload_1
    //   898: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: ldc_w 345
    //   904: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: astore_1
    //   911: iload 5
    //   913: iconst_1
    //   914: iadd
    //   915: istore 5
    //   917: goto -39 -> 878
    //   920: new 146	android/text/SpannableStringBuilder
    //   923: dup
    //   924: aload 18
    //   926: checkcast 282	com/tencent/mobileqq/data/MessageForText
    //   929: getfield 349	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   932: invokespecial 352	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   935: astore 16
    //   937: aload 16
    //   939: iload 7
    //   941: iload 10
    //   943: iconst_1
    //   944: iadd
    //   945: aload_1
    //   946: invokevirtual 356	android/text/SpannableStringBuilder:replace	(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   949: pop
    //   950: aload 18
    //   952: checkcast 282	com/tencent/mobileqq/data/MessageForText
    //   955: aload 16
    //   957: putfield 349	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   960: goto -695 -> 265
    //   963: aload_0
    //   964: getfield 359	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   967: aload_0
    //   968: getfield 362	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   971: aload_0
    //   972: getfield 366	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   975: iload_2
    //   976: aload_3
    //   977: aload 18
    //   979: checkcast 282	com/tencent/mobileqq/data/MessageForText
    //   982: iload 9
    //   984: iload 6
    //   986: isub
    //   987: invokestatic 369	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;IJZLcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;Lcom/tencent/mobileqq/data/MessageForText;I)V
    //   990: iload 6
    //   992: aload 18
    //   994: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   997: aload 18
    //   999: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1002: invokevirtual 304	java/lang/String:length	()I
    //   1005: invokestatic 309	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   1008: aload 18
    //   1010: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1013: invokevirtual 304	java/lang/String:length	()I
    //   1016: isub
    //   1017: iadd
    //   1018: istore 5
    //   1020: aload 18
    //   1022: getfield 301	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1025: invokevirtual 304	java/lang/String:length	()I
    //   1028: iload 9
    //   1030: iadd
    //   1031: istore 6
    //   1033: iload 6
    //   1035: istore 9
    //   1037: iload 5
    //   1039: istore 6
    //   1041: goto -820 -> 221
    //   1044: iload 9
    //   1046: iconst_1
    //   1047: iadd
    //   1048: istore 7
    //   1050: iload 6
    //   1052: istore 5
    //   1054: iload 7
    //   1056: istore 6
    //   1058: goto -25 -> 1033
    //   1061: astore 15
    //   1063: iconst_0
    //   1064: istore 5
    //   1066: aload 16
    //   1068: astore_3
    //   1069: goto -977 -> 92
    //   1072: astore 15
    //   1074: aload 16
    //   1076: astore_3
    //   1077: goto -985 -> 92
    //   1080: aconst_null
    //   1081: astore 16
    //   1083: goto -221 -> 862
    //   1086: iconst_0
    //   1087: istore 5
    //   1089: goto -625 -> 464
    //   1092: iconst_0
    //   1093: istore 10
    //   1095: iload 7
    //   1097: istore 11
    //   1099: goto -737 -> 362
    //   1102: iconst_0
    //   1103: istore 13
    //   1105: goto -909 -> 196
    //   1108: goto -312 -> 796
    //   1111: aconst_null
    //   1112: astore 16
    //   1114: goto -340 -> 774
    //   1117: goto -953 -> 164
    //   1120: iload 5
    //   1122: istore 6
    //   1124: goto -457 -> 667
    //   1127: iconst_0
    //   1128: istore 6
    //   1130: goto -470 -> 660
    //   1133: goto -1003 -> 130
    //   1136: iconst_0
    //   1137: istore 5
    //   1139: goto -1093 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1142	0	paramMessageRecord	MessageRecord
    //   0	1142	1	paramList	List
    //   0	1142	2	paramBoolean	boolean
    //   0	1142	3	paramArrayOfByte	byte[]
    //   554	268	4	c1	char
    //   44	1094	5	n	int
    //   1	1128	6	i1	int
    //   288	808	7	i2	int
    //   71	486	8	i3	int
    //   216	832	9	i4	int
    //   356	738	10	i5	int
    //   360	738	11	i6	int
    //   454	71	12	i7	int
    //   132	972	13	bool1	boolean
    //   4	678	14	bool2	boolean
    //   7	73	15	arrayOfByte	byte[]
    //   85	8	15	localException1	Exception
    //   98	591	15	localObject1	Object
    //   1061	1	15	localException2	Exception
    //   1072	1	15	localException3	Exception
    //   16	570	16	localObject2	Object
    //   591	3	16	localException4	Exception
    //   611	17	16	localIterator1	Iterator
    //   674	3	16	localException5	Exception
    //   720	393	16	localObject3	Object
    //   213	498	17	localObject4	Object
    //   241	780	18	localMessageRecord	MessageRecord
    //   263	13	19	localIterator2	Iterator
    //   285	568	20	localBankcodeElem	bankcode_info.BankcodeElem
    //   528	20	21	str	String
    // Exception table:
    //   from	to	target	type
    //   9	18	85	java/lang/Exception
    //   123	130	591	java/lang/Exception
    //   157	164	674	java/lang/Exception
    //   18	46	1061	java/lang/Exception
    //   49	69	1072	java/lang/Exception
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (((BaseActivity.sTopActivity instanceof MultiForwardActivity)) || ((BaseActivity.sTopActivity instanceof ChatHistoryForC2C))) {}
    Object localObject1;
    int i6;
    int i4;
    int i5;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        } while (localObject1 == null);
        localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(19);
      } while (localObject1 == null);
      localObject2 = ((QQMessageFacade)localObject1).a(paramString1, paramInt, paramLong);
      i6 = 0;
      i1 = 0;
      i4 = 0;
      i5 = 0;
      n = 0;
      localObject3 = ((MessageRecord)localObject2).getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty((CharSequence)localObject3));
    i3 = i5;
    i2 = i6;
    for (;;)
    {
      try
      {
        Object localObject4 = new bankcode_info.BankcodeCtrlInfo();
        i3 = i5;
        i2 = i6;
        ((bankcode_info.BankcodeCtrlInfo)localObject4).mergeFrom(HexUtil.a((String)localObject3));
        i3 = i5;
        i2 = i6;
        if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.has())
        {
          i3 = i5;
          i2 = i6;
          i1 = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.get();
        }
        i3 = i5;
        i2 = i1;
        if (!((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.has()) {
          continue;
        }
        i3 = i5;
        i2 = i1;
        localObject3 = ((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.get().iterator();
        i4 = n;
        i3 = n;
        i2 = i1;
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        i3 = n;
        i2 = i1;
        localObject4 = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
        i3 = n;
        i2 = i1;
        if (!((bankcode_info.BankcodeElem)localObject4).bankcode_attr.has()) {
          continue;
        }
        i3 = n;
        i2 = i1;
        i4 = ((bankcode_info.BankcodeElem)localObject4).bankcode_attr.get();
        i2 = i4;
      }
      catch (Exception localException)
      {
        n = i3;
        localException.printStackTrace();
        i1 = i2;
        continue;
        i2 = n;
        continue;
        i2 = 0;
        continue;
      }
      if (i2 <= n) {
        continue;
      }
      n = i2;
    }
    n = i4;
    Object localObject2 = ((MessageRecord)localObject2).senderuin;
    Object localObject3 = DialogUtil.a(BaseActivity.sTopActivity, 230);
    ((QQCustomDialog)localObject3).setTitle(paramString2);
    ((QQCustomDialog)localObject3).setMessage(paramString3);
    if (!TextUtils.isEmpty(paramString4)) {
      ((QQCustomDialog)localObject3).setPositiveButton(paramString4, new kzq((String)localObject2, i1, n, (QQMessageFacade)localObject1, paramString1, paramInt, paramLong));
    }
    if (!TextUtils.isEmpty(paramString5)) {
      ((QQCustomDialog)localObject3).setNegativeButton(paramString5, new kzs((String)localObject2, i1, n));
    }
    ((QQCustomDialog)localObject3).show();
  }
  
  private static void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, MessageForText paramMessageForText, int paramInt2)
  {
    if ((paramBankcodeCtrlInfo == null) || (!paramBankcodeCtrlInfo.bankcode_elems.has())) {
      return;
    }
    if (paramBankcodeCtrlInfo.msgtail_id.has()) {}
    label266:
    label408:
    for (int i2 = paramBankcodeCtrlInfo.msgtail_id.get();; i2 = 0)
    {
      int i3 = 0;
      label41:
      Object localObject;
      if (i3 < paramBankcodeCtrlInfo.bankcode_elems.size())
      {
        localObject = (bankcode_info.BankcodeElem)paramBankcodeCtrlInfo.bankcode_elems.get(i3);
        if (localObject != null) {
          break label83;
        }
      }
      label290:
      label306:
      label448:
      for (;;)
      {
        i3 += 1;
        break label41;
        break;
        label83:
        int i4 = 0;
        int n = 0;
        int i1 = i4;
        if (((bankcode_info.BankcodeElem)localObject).bankcode_pos.has())
        {
          localObject = (bankcode_info.ElemPos)((bankcode_info.BankcodeElem)localObject).bankcode_pos.get();
          i1 = i4;
          if (localObject != null)
          {
            if (((bankcode_info.ElemPos)localObject).start_offset.has()) {
              n = ((bankcode_info.ElemPos)localObject).start_offset.get();
            }
            i1 = n;
            if (((bankcode_info.ElemPos)localObject).end_offset.has())
            {
              i1 = ((bankcode_info.ElemPos)localObject).end_offset.get();
              i4 = n;
              n = i1;
            }
          }
        }
        for (;;)
        {
          if ((n < paramInt2) || (i4 > paramMessageForText.sb.length() + paramInt2)) {
            break label448;
          }
          String str = paramMessageForText.getExtInfoFromExtStr("sens_msg_original_text");
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = paramMessageForText.sb.toString();
          }
          int i5 = a((String)localObject, i4 - paramInt2);
          int i6 = a((String)localObject, n - paramInt2);
          n = i5;
          if ((i2 == 1) && (!Character.isDigit(paramMessageForText.sb.charAt(n))))
          {
            i1 = n;
            if (n < 0) {
              i1 = 0;
            }
            n = i6;
            if ((i2 != 1) || (Character.isDigit(paramMessageForText.sb.charAt(n)))) {
              break label408;
            }
          }
          for (;;)
          {
            localObject = new SpannableStringBuilder(paramMessageForText.sb);
            a((SpannableStringBuilder)localObject, i1, n);
            ((SpannableStringBuilder)localObject).setSpan(a(paramString, paramInt1, paramLong, paramBoolean, paramBankcodeCtrlInfo), i5, i6 + 1, 33);
            paramMessageForText.sb = ((CharSequence)localObject);
            break;
            i1 = n - 1;
            n = i1;
            if (i1 >= 0) {
              break label266;
            }
            n = i1;
            break label290;
            i4 = n + 1;
            n = i4;
            if (i4 < paramMessageForText.sb.length()) {
              break label306;
            }
            n = i4;
          }
          n = 0;
          i4 = i1;
        }
      }
    }
  }
  
  private static void c(String paramString)
  {
    b = 0;
    m = paramString;
    if (!TextUtils.isEmpty(m))
    {
      jdField_a_of_type_AndroidOsBundle.putBundle(m, null);
      ThreadManager.c(new kzv());
    }
  }
  
  public void a(String paramString)
  {
    String str1;
    String str2;
    Bundle localBundle;
    if ((!TextUtils.isEmpty(paramString)) && (!a(paramString)))
    {
      b = (b + 1) % 10;
      str1 = MD5Utils.b(paramString);
      str2 = Integer.toString(b);
      localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(m);
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        String str3;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          str3 = localBundle.getString(paramString);
        } while ((TextUtils.isEmpty(str3)) || (!str3.equals(str2)));
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localBundle.remove(paramString);
      }
      localBundle.putString(str1, str2);
      ThreadManager.c(new kzt(this, str2, str1));
      return;
      paramString = null;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(m);
      bool1 = bool2;
      if (localBundle != null)
      {
        bool1 = bool2;
        if (localBundle.containsKey(MD5Utils.b(paramString))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil
 * JD-Core Version:    0.7.0.1
 */