package com.tencent.mobileqq.troop.data;

import MessageSvcPack.SvcResponseGroupMsgReadConfirm;
import PushNotifyPack.GroupMsgReadedNotify;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.message.BaseMessageProcessorForTroopAndDisc;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.structmsg.StructMsgHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kky;
import kkz;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;

public class TroopMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public static final int b = 1;
  public static final int c = 2;
  public static final String c = "Q.msg.TroopMessageProcessor";
  public static final int d = 3;
  public static final int e = 4;
  public Comparator b = new kky(this);
  
  public TroopMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  /* Error */
  private long a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, String paramString1, String paramString2, MessageInfo paramMessageInfo)
  {
    // Byte code:
    //   0: new 37	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 40	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 43	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   16: aload 4
    //   18: invokevirtual 53	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;)J
    //   21: lstore 10
    //   23: aload_1
    //   24: ifnonnull +6 -> 30
    //   27: lload 10
    //   29: lreturn
    //   30: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +41 -> 74
    //   36: ldc 12
    //   38: iconst_2
    //   39: new 61	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   46: ldc 64
    //   48: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 4
    //   53: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 70
    //   58: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 74	java/util/ArrayList:size	()I
    //   65: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 88	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   78: astore 26
    //   80: aload 26
    //   82: invokeinterface 93 1 0
    //   87: ifeq +669 -> 756
    //   90: aload 26
    //   92: invokeinterface 97 1 0
    //   97: checkcast 99	msf/msgcomm/msg_comm$Msg
    //   100: astore 27
    //   102: aload 27
    //   104: ifnull -24 -> 80
    //   107: aload 27
    //   109: getfield 103	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   112: invokevirtual 109	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 105	msf/msgcomm/msg_comm$MsgHead
    //   118: astore_1
    //   119: aload_1
    //   120: getfield 113	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: i2l
    //   127: lstore 12
    //   129: aload_1
    //   130: getfield 121	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   133: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   136: lstore 14
    //   138: aload_1
    //   139: getfield 129	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   142: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   145: lstore 16
    //   147: aload_1
    //   148: getfield 129	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   151: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   154: lstore 18
    //   156: aload_1
    //   157: getfield 132	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   160: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   163: i2l
    //   164: lstore 20
    //   166: aload_1
    //   167: getfield 135	msf/msgcomm/msg_comm$MsgHead:user_active	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   170: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   173: istore 7
    //   175: aload_1
    //   176: getfield 138	msf/msgcomm/msg_comm$MsgHead:from_instid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: istore 8
    //   184: aload_1
    //   185: getfield 142	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   188: invokevirtual 145	msf/msgcomm/msg_comm$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   191: checkcast 144	msf/msgcomm/msg_comm$GroupInfo
    //   194: astore_1
    //   195: aload_1
    //   196: getfield 148	msf/msgcomm/msg_comm$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   202: istore 9
    //   204: aload_1
    //   205: getfield 151	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   208: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   211: lstore 22
    //   213: aload_1
    //   214: getfield 154	msf/msgcomm/msg_comm$GroupInfo:group_info_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   217: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   220: lstore 24
    //   222: aload_1
    //   223: getfield 158	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   226: invokevirtual 163	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   229: ifeq +497 -> 726
    //   232: aload_1
    //   233: getfield 158	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 166	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: ifnull +487 -> 726
    //   242: aload_1
    //   243: getfield 158	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   246: invokevirtual 166	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   249: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   252: astore_1
    //   253: new 174	java/lang/String
    //   256: dup
    //   257: aload_1
    //   258: ldc 176
    //   260: invokespecial 179	java/lang/String:<init>	([BLjava/lang/String;)V
    //   263: astore_1
    //   264: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +173 -> 440
    //   270: ldc 12
    //   272: iconst_2
    //   273: new 61	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   280: ldc 64
    //   282: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 4
    //   287: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 181
    //   292: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: lload 18
    //   297: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: ldc 186
    //   302: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: lload 16
    //   307: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: ldc 188
    //   312: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: lload 20
    //   317: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: ldc 190
    //   322: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: lload 12
    //   327: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   330: ldc 192
    //   332: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: lload 14
    //   337: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: ldc 194
    //   342: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload 7
    //   347: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc 196
    //   352: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload 8
    //   357: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: ldc 198
    //   362: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: lload 22
    //   367: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: ldc 200
    //   372: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload 9
    //   377: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: ldc 202
    //   382: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: lload 24
    //   387: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: ldc 204
    //   392: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_1
    //   396: invokestatic 209	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   399: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc 211
    //   404: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 27
    //   409: getfield 215	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   412: invokevirtual 218	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   415: invokevirtual 221	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   418: ldc 223
    //   420: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 27
    //   425: getfield 227	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   428: invokevirtual 230	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   431: invokevirtual 221	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   434: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: new 37	java/util/ArrayList
    //   443: dup
    //   444: invokespecial 40	java/util/ArrayList:<init>	()V
    //   447: astore 28
    //   449: new 232	com/tencent/mobileqq/service/message/PBDecodeContext
    //   452: dup
    //   453: invokespecial 233	com/tencent/mobileqq/service/message/PBDecodeContext:<init>	()V
    //   456: astore_1
    //   457: aload_1
    //   458: aload 4
    //   460: invokestatic 239	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   463: invokevirtual 242	java/lang/Long:longValue	()J
    //   466: putfield 245	com/tencent/mobileqq/service/message/PBDecodeContext:e	J
    //   469: aload_1
    //   470: iconst_1
    //   471: putfield 247	com/tencent/mobileqq/service/message/PBDecodeContext:c	I
    //   474: aload_1
    //   475: iload 9
    //   477: putfield 249	com/tencent/mobileqq/service/message/PBDecodeContext:d	I
    //   480: aload 27
    //   482: getfield 253	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   485: invokevirtual 256	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   488: ifeq +112 -> 600
    //   491: aload 27
    //   493: getfield 253	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   496: invokevirtual 257	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   499: checkcast 255	msf/msgcomm/msg_comm$ContentHead
    //   502: astore 29
    //   504: aload 29
    //   506: getfield 260	msf/msgcomm/msg_comm$ContentHead:div_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   509: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   512: istore 7
    //   514: aload 29
    //   516: getfield 263	msf/msgcomm/msg_comm$ContentHead:pkg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   519: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   522: istore 8
    //   524: aload 29
    //   526: getfield 266	msf/msgcomm/msg_comm$ContentHead:pkg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   529: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   532: istore 9
    //   534: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +63 -> 600
    //   540: ldc 12
    //   542: iconst_2
    //   543: new 61	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 268
    //   553: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 4
    //   558: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 270
    //   564: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: iload 7
    //   569: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: ldc_w 272
    //   575: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload 8
    //   580: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: ldc_w 274
    //   586: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iload 9
    //   591: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   603: lstore 14
    //   605: aload_0
    //   606: aload 27
    //   608: aload 28
    //   610: aload_1
    //   611: iconst_0
    //   612: aload 6
    //   614: invokevirtual 282	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;Lcom/tencent/mobileqq/service/message/PBDecodeContext;ZLcom/tencent/mobileqq/troop/data/MessageInfo;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   617: astore_1
    //   618: aload_1
    //   619: ifnull +10 -> 629
    //   622: aload 5
    //   624: aload_1
    //   625: invokevirtual 286	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   628: pop
    //   629: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq +49 -> 681
    //   635: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   638: lstore 16
    //   640: ldc 12
    //   642: iconst_2
    //   643: new 61	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 288
    //   653: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 4
    //   658: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc_w 290
    //   664: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: lload 16
    //   669: lload 14
    //   671: lsub
    //   672: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: aload 28
    //   683: ifnull -603 -> 80
    //   686: aload 28
    //   688: invokevirtual 74	java/util/ArrayList:size	()I
    //   691: ifeq -611 -> 80
    //   694: aload 28
    //   696: invokestatic 295	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Ljava/util/List;)V
    //   699: aload_3
    //   700: aload 28
    //   702: invokevirtual 299	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   705: pop
    //   706: lload 12
    //   708: lload 10
    //   710: lcmp
    //   711: ifle +42 -> 753
    //   714: lload 12
    //   716: lstore 10
    //   718: goto -638 -> 80
    //   721: astore_1
    //   722: aload_1
    //   723: invokevirtual 302	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   726: aconst_null
    //   727: astore_1
    //   728: goto -464 -> 264
    //   731: astore_1
    //   732: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq +13 -> 748
    //   738: ldc 12
    //   740: iconst_2
    //   741: ldc_w 304
    //   744: aload_1
    //   745: invokestatic 308	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   748: aconst_null
    //   749: astore_1
    //   750: goto -132 -> 618
    //   753: goto -35 -> 718
    //   756: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   759: lstore 12
    //   761: aload_0
    //   762: getfield 43	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   765: bipush 8
    //   767: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   770: checkcast 314	com/tencent/mobileqq/app/FriendsManagerImp
    //   773: aload 5
    //   775: invokevirtual 317	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/util/List;)Z
    //   778: pop
    //   779: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq +119 -> 901
    //   785: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   788: lstore 14
    //   790: ldc 12
    //   792: iconst_2
    //   793: new 61	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 319
    //   803: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload 4
    //   808: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 290
    //   814: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: lload 14
    //   819: lload 12
    //   821: lsub
    //   822: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   825: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: lload 14
    //   833: lstore 12
    //   835: aload_3
    //   836: ifnull +10 -> 846
    //   839: aload_0
    //   840: aload_3
    //   841: aload_2
    //   842: iconst_1
    //   843: invokevirtual 322	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    //   846: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   849: ifeq +49 -> 898
    //   852: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   855: lstore 14
    //   857: ldc 12
    //   859: iconst_2
    //   860: new 61	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 324
    //   870: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload 4
    //   875: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: ldc_w 290
    //   881: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: lload 14
    //   886: lload 12
    //   888: lsub
    //   889: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   892: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   898: lload 10
    //   900: lreturn
    //   901: goto -66 -> 835
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	904	0	this	TroopMessageProcessor
    //   0	904	1	paramArrayList1	ArrayList
    //   0	904	2	paramArrayList2	ArrayList
    //   0	904	3	paramArrayList3	ArrayList
    //   0	904	4	paramString1	String
    //   0	904	5	paramString2	String
    //   0	904	6	paramMessageInfo	MessageInfo
    //   173	395	7	i	int
    //   182	397	8	j	int
    //   202	388	9	k	int
    //   21	878	10	l1	long
    //   127	760	12	l2	long
    //   136	749	14	l3	long
    //   145	523	16	l4	long
    //   154	142	18	l5	long
    //   164	152	20	l6	long
    //   211	155	22	l7	long
    //   220	166	24	l8	long
    //   78	13	26	localIterator	java.util.Iterator
    //   100	507	27	localMsg	msg_comm.Msg
    //   447	254	28	localArrayList	ArrayList
    //   502	23	29	localContentHead	msg_comm.ContentHead
    // Exception table:
    //   from	to	target	type
    //   253	264	721	java/io/UnsupportedEncodingException
    //   605	618	731	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    paramToServiceMsg.extraData.getLong("groupuin");
    paramToServiceMsg.extraData.getLong("lastReadSeq");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label115;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label115;
      }
    }
    label115:
    while ((480000L != l2) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "<ReadReport><E>_Group_reqSeq:" + l1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseGroupMsgReadConfirm paramSvcResponseGroupMsgReadConfirm)
  {
    paramToServiceMsg.getServiceCmd();
    paramToServiceMsg.extraData.getLong("groupuin");
    paramToServiceMsg.extraData.getLong("lastReadSeq");
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l) == null) {}
    while (paramSvcResponseGroupMsgReadConfirm == null) {
      return;
    }
    int i = paramSvcResponseGroupMsgReadConfirm.cReplyCode;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "<ReadReport><R>_Group_reqSeq:" + l + " replyCode:" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, String paramString)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
    }
    localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1);
    if (paramArrayList != null)
    {
      MessageInfo localMessageInfo = new MessageInfo();
      l1 = a(paramArrayList, (ArrayList)localObject2, (ArrayList)localObject3, (String)localObject1, paramString, localMessageInfo);
      ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a((String)localObject1, localMessageInfo);
    }
    for (;;)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      int i = 0;
      long l2;
      if ((paramPbGetGroupMsgResp.result.get() == 104) && (((ArrayList)localObject2).size() == 0))
      {
        l2 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetGroupMsgResp.return_end_seq.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "initGetPullTroopMsg reply 104 !! reqEndSeq = " + l2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1, l2);
      }
      for (int j = 1;; j = 0)
      {
        paramArrayList = new StringBuilder(128);
        if (((ArrayList)localObject2).size() > 0)
        {
          Collections.sort((List)localObject2, this.b);
          paramToServiceMsg = new ArrayList();
          i = ((ArrayList)localObject2).size() - 1;
          if (i >= 0)
          {
            paramPbGetGroupMsgResp = (MessageRecord)((ArrayList)localObject2).get(i);
            if (QLog.isColorLevel())
            {
              paramArrayList.setLength(0);
              paramArrayList.append("----------initGetPullTroopMsg update send message  mr.senderuin: ").append(paramPbGetGroupMsgResp.senderuin).append(" mr.msgtype: ").append(paramPbGetGroupMsgResp.msgtype).append(" mr.frienduin: ").append(paramPbGetGroupMsgResp.frienduin).append(" mr.shmsgseq: ").append(paramPbGetGroupMsgResp.shmsgseq).append(" mr.time:").append(paramPbGetGroupMsgResp.time).append(" mr.msg: ").append(paramPbGetGroupMsgResp.getLogColorContent());
              QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
            }
            if (((paramPbGetGroupMsgResp.senderuin != null) && (paramPbGetGroupMsgResp.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) || ((AnonymousChatHelper.a(paramPbGetGroupMsgResp)) && (AnonymousChatHelper.b(paramPbGetGroupMsgResp))))
            {
              if (AnonymousChatHelper.a(paramPbGetGroupMsgResp))
              {
                paramPbGetGroupMsgResp.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                localObject3 = AnonymousChatHelper.a(paramPbGetGroupMsgResp);
                AnonymousChatHelper.a().a(paramPbGetGroupMsgResp.frienduin, paramPbGetGroupMsgResp.vipBubbleID, ((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_b_of_type_Int, ((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_b_of_type_JavaLangString, ((AnonymousChatHelper.AnonymousExtInfo)localObject3).c, ((AnonymousChatHelper.AnonymousExtInfo)localObject3).a);
              }
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPbGetGroupMsgResp.frienduin, 1, paramPbGetGroupMsgResp);
              if (localObject3 != null)
              {
                if (((paramPbGetGroupMsgResp instanceof MessageForText)) && ((localObject3 instanceof MessageForText)) && (paramPbGetGroupMsgResp.getRepeatCount() > 0))
                {
                  ((MessageRecord)localObject3).setRepeatCount(paramPbGetGroupMsgResp.getRepeatCount());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.TroopMessageProcessor", 2, "<---initGetPullTroopMsg_PB ===> update findMr.repeatCount=" + paramPbGetGroupMsgResp.getRepeatCount());
                  }
                }
                if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f()) {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramPbGetGroupMsgResp.frienduin, 1, ((MessageRecord)localObject3).uniseq, paramPbGetGroupMsgResp.shmsgseq, paramPbGetGroupMsgResp.time);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, paramPbGetGroupMsgResp.shmsgseq);
              }
            }
            for (;;)
            {
              i -= 1;
              break;
              paramToServiceMsg.add(0, paramPbGetGroupMsgResp);
            }
          }
          if (paramToServiceMsg.size() > 0)
          {
            paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
            if (paramArrayList == null) {
              break label1109;
            }
            l2 = ((Long)paramArrayList[0]).longValue();
            int k = paramToServiceMsg.size();
            i = 0;
            while (i < k)
            {
              if ((((MessageRecord)paramToServiceMsg.get(i)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(i)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
              {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
                ((MessageRecord)paramToServiceMsg.get(i)).issend = 2;
              }
              if (l2 >= ((MessageRecord)paramToServiceMsg.get(i)).shmsgseq) {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
              }
              i += 1;
            }
            paramArrayList = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1);
            if (paramArrayList.a((String)localObject1, 1, paramToServiceMsg, paramString)) {
              break label1109;
            }
            bool2 = MessageHandlerUtils.a(paramToServiceMsg);
            boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
            i = MsgProxyUtils.a(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramPbGetGroupMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
            {
              bool1 = true;
              paramPbGetGroupMsgResp.a(paramToServiceMsg, paramString, bool1, false);
              paramArrayList.c((String)localObject1, 1, l2);
              bool1 = bool3;
            }
          }
        }
        for (;;)
        {
          if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1) == 1))
          {
            l2 = ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localObject1)[0]).longValue();
            ((BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1)).c((String)localObject1, 1, l2);
          }
          if (l1 >= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMessageProcessor", 2, "groupMsgRecordHandle info.lGroupCode: " + (String)localObject1 + " info.lsMsgSeq: " + l1);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, l1);
          }
          a("initGetPullTroopMsg", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool1, paramToServiceMsg), false);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
          return;
          bool1 = false;
          break;
          j = 1;
          i = 0;
          bool1 = false;
          bool2 = false;
          continue;
          j = 1;
          paramToServiceMsg = (ToServiceMsg)localObject2;
          continue;
          label1109:
          i = 0;
          bool1 = false;
          bool2 = false;
        }
      }
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 37	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 40	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: new 414	com/tencent/mobileqq/troop/data/MessageInfo
    //   12: dup
    //   13: invokespecial 415	com/tencent/mobileqq/troop/data/MessageInfo:<init>	()V
    //   16: astore 22
    //   18: aload_3
    //   19: ifnull +680 -> 699
    //   22: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 12
    //   30: iconst_2
    //   31: new 61	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 617
    //   41: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 74	java/util/ArrayList:size	()I
    //   48: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: new 37	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 40	java/util/ArrayList:<init>	()V
    //   64: astore 23
    //   66: aload_3
    //   67: invokevirtual 88	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   70: astore 24
    //   72: aload 24
    //   74: invokeinterface 93 1 0
    //   79: ifeq +602 -> 681
    //   82: aload 24
    //   84: invokeinterface 97 1 0
    //   89: checkcast 99	msf/msgcomm/msg_comm$Msg
    //   92: astore 25
    //   94: aload 25
    //   96: ifnull -24 -> 72
    //   99: aload 25
    //   101: getfield 103	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   104: invokevirtual 109	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 105	msf/msgcomm/msg_comm$MsgHead
    //   110: astore_3
    //   111: aload_3
    //   112: getfield 113	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: i2l
    //   119: lstore 8
    //   121: aload_3
    //   122: getfield 121	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   125: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   128: lstore 10
    //   130: aload_3
    //   131: getfield 620	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   134: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   137: lstore 12
    //   139: aload_3
    //   140: getfield 129	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   143: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   146: lstore 14
    //   148: aload_3
    //   149: getfield 132	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   152: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   155: i2l
    //   156: lstore 16
    //   158: aload_3
    //   159: getfield 135	msf/msgcomm/msg_comm$MsgHead:user_active	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   162: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   165: istore 5
    //   167: aload_3
    //   168: getfield 138	msf/msgcomm/msg_comm$MsgHead:from_instid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore 6
    //   176: aload_3
    //   177: getfield 142	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   180: invokevirtual 145	msf/msgcomm/msg_comm$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   183: checkcast 144	msf/msgcomm/msg_comm$GroupInfo
    //   186: astore 26
    //   188: aload 26
    //   190: getfield 148	msf/msgcomm/msg_comm$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   193: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   196: istore 7
    //   198: aload 26
    //   200: getfield 151	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   203: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   206: lstore 18
    //   208: aload 26
    //   210: getfield 154	msf/msgcomm/msg_comm$GroupInfo:group_info_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: lstore 20
    //   218: aload 26
    //   220: getfield 158	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 163	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   226: ifeq +428 -> 654
    //   229: aload 26
    //   231: getfield 158	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   234: invokevirtual 166	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   237: ifnull +417 -> 654
    //   240: aload 26
    //   242: getfield 158	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   245: invokevirtual 166	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   248: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   251: astore_3
    //   252: new 174	java/lang/String
    //   255: dup
    //   256: aload_3
    //   257: ldc 176
    //   259: invokespecial 179	java/lang/String:<init>	([BLjava/lang/String;)V
    //   262: astore_3
    //   263: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +181 -> 447
    //   269: ldc 12
    //   271: iconst_2
    //   272: new 61	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 622
    //   282: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: lload 14
    //   287: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   290: ldc 186
    //   292: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: lload 12
    //   297: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: ldc 188
    //   302: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: lload 16
    //   307: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: ldc 190
    //   312: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: lload 8
    //   317: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: ldc 192
    //   322: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: lload 10
    //   327: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   330: ldc 194
    //   332: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 5
    //   337: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc 196
    //   342: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload 6
    //   347: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc 198
    //   352: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: lload 18
    //   357: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: ldc 200
    //   362: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 7
    //   367: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: ldc 202
    //   372: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 20
    //   377: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: ldc_w 624
    //   383: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 26
    //   388: getfield 158	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   391: invokevirtual 163	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   394: invokevirtual 221	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: ldc 204
    //   399: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_3
    //   403: invokestatic 209	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   406: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc 211
    //   411: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 25
    //   416: getfield 215	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   419: invokevirtual 218	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   422: invokevirtual 221	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   425: ldc 223
    //   427: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 25
    //   432: getfield 227	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   435: invokevirtual 230	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   438: invokevirtual 221	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   441: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: new 37	java/util/ArrayList
    //   450: dup
    //   451: invokespecial 40	java/util/ArrayList:<init>	()V
    //   454: astore 26
    //   456: new 232	com/tencent/mobileqq/service/message/PBDecodeContext
    //   459: dup
    //   460: invokespecial 233	com/tencent/mobileqq/service/message/PBDecodeContext:<init>	()V
    //   463: astore_3
    //   464: aload_3
    //   465: aload_2
    //   466: getfield 409	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   469: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   472: putfield 245	com/tencent/mobileqq/service/message/PBDecodeContext:e	J
    //   475: aload_3
    //   476: iconst_1
    //   477: putfield 247	com/tencent/mobileqq/service/message/PBDecodeContext:c	I
    //   480: aload_3
    //   481: iload 7
    //   483: putfield 249	com/tencent/mobileqq/service/message/PBDecodeContext:d	I
    //   486: aload 25
    //   488: getfield 253	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   491: invokevirtual 256	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   494: ifeq +101 -> 595
    //   497: aload 25
    //   499: getfield 253	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   502: invokevirtual 257	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   505: checkcast 255	msf/msgcomm/msg_comm$ContentHead
    //   508: astore 27
    //   510: aload 27
    //   512: getfield 260	msf/msgcomm/msg_comm$ContentHead:div_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   515: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   518: istore 5
    //   520: aload 27
    //   522: getfield 263	msf/msgcomm/msg_comm$ContentHead:pkg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   525: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   528: istore 6
    //   530: aload 27
    //   532: getfield 266	msf/msgcomm/msg_comm$ContentHead:pkg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   535: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   538: istore 7
    //   540: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +52 -> 595
    //   546: ldc 12
    //   548: iconst_2
    //   549: new 61	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 626
    //   559: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 5
    //   564: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: ldc_w 272
    //   570: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: iload 6
    //   575: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   578: ldc_w 274
    //   581: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: iload 7
    //   586: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload_0
    //   596: aload 25
    //   598: aload 26
    //   600: aload_3
    //   601: iconst_0
    //   602: aload 22
    //   604: invokevirtual 282	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;Lcom/tencent/mobileqq/service/message/PBDecodeContext;ZLcom/tencent/mobileqq/troop/data/MessageInfo;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   607: astore_3
    //   608: aload_3
    //   609: ifnull +10 -> 619
    //   612: aload 23
    //   614: aload_3
    //   615: invokevirtual 286	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   618: pop
    //   619: aload 26
    //   621: invokevirtual 74	java/util/ArrayList:size	()I
    //   624: ifeq -552 -> 72
    //   627: aload 26
    //   629: invokestatic 295	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Ljava/util/List;)V
    //   632: aload 4
    //   634: ifnull -562 -> 72
    //   637: aload_0
    //   638: aload 26
    //   640: aload 4
    //   642: iconst_1
    //   643: invokevirtual 322	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    //   646: goto -574 -> 72
    //   649: astore_3
    //   650: aload_3
    //   651: invokevirtual 302	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   654: aconst_null
    //   655: astore_3
    //   656: goto -393 -> 263
    //   659: astore_3
    //   660: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +13 -> 676
    //   666: ldc 12
    //   668: iconst_2
    //   669: ldc_w 304
    //   672: aload_3
    //   673: invokestatic 308	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   676: aconst_null
    //   677: astore_3
    //   678: goto -70 -> 608
    //   681: aload_0
    //   682: getfield 43	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   685: bipush 8
    //   687: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   690: checkcast 314	com/tencent/mobileqq/app/FriendsManagerImp
    //   693: aload 23
    //   695: invokevirtual 317	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/util/List;)Z
    //   698: pop
    //   699: aload 4
    //   701: invokevirtual 88	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   704: astore_3
    //   705: aload_3
    //   706: invokeinterface 93 1 0
    //   711: ifeq +55 -> 766
    //   714: aload_3
    //   715: invokeinterface 97 1 0
    //   720: checkcast 452	com/tencent/mobileqq/data/MessageRecord
    //   723: astore 23
    //   725: aload 23
    //   727: getfield 460	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   730: ifnull +27 -> 757
    //   733: aload 23
    //   735: getfield 460	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   738: aload_0
    //   739: getfield 43	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   742: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   745: invokevirtual 563	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   748: ifeq +9 -> 757
    //   751: aload 23
    //   753: iconst_2
    //   754: putfield 570	com/tencent/mobileqq/data/MessageRecord:issend	I
    //   757: aload 23
    //   759: iconst_1
    //   760: putfield 567	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   763: goto -58 -> 705
    //   766: aload 4
    //   768: aload_0
    //   769: getfield 28	com/tencent/mobileqq/troop/data/TroopMessageProcessor:b	Ljava/util/Comparator;
    //   772: invokestatic 447	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   775: aload_2
    //   776: getfield 409	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   779: invokevirtual 627	java/lang/Object:toString	()Ljava/lang/String;
    //   782: astore_3
    //   783: aload_0
    //   784: getfield 43	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   787: bipush 36
    //   789: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   792: checkcast 419	com/tencent/mobileqq/model/TroopInfoManager
    //   795: aload_3
    //   796: aload 22
    //   798: invokevirtual 422	com/tencent/mobileqq/model/TroopInfoManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/troop/data/MessageInfo;)Lcom/tencent/mobileqq/troop/data/MessageInfo;
    //   801: pop
    //   802: aload_1
    //   803: getfield 338	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   806: ldc_w 629
    //   809: invokevirtual 633	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   812: astore_1
    //   813: new 37	java/util/ArrayList
    //   816: dup
    //   817: invokespecial 40	java/util/ArrayList:<init>	()V
    //   820: astore_3
    //   821: aload_1
    //   822: ifnull +39 -> 861
    //   825: aload_1
    //   826: ldc_w 635
    //   829: aload_2
    //   830: getfield 638	msf/msgsvc/msg_svc$PbGetGroupMsgResp:return_begin_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   833: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   836: invokevirtual 641	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   839: aload_1
    //   840: ldc_w 643
    //   843: aload_2
    //   844: getfield 430	msf/msgsvc/msg_svc$PbGetGroupMsgResp:return_end_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   847: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   850: invokevirtual 641	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   853: aload_1
    //   854: ldc_w 645
    //   857: iconst_1
    //   858: invokevirtual 649	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   861: aload_0
    //   862: getfield 43	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   865: invokevirtual 521	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   868: aload_2
    //   869: getfield 409	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   872: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   875: invokestatic 412	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   878: iconst_1
    //   879: aload 4
    //   881: aload_3
    //   882: aload_1
    //   883: invokevirtual 652	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Landroid/os/Bundle;)V
    //   886: aload_0
    //   887: getfield 328	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   890: aload_3
    //   891: invokevirtual 614	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/util/ArrayList;)V
    //   894: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	895	0	this	TroopMessageProcessor
    //   0	895	1	paramToServiceMsg	ToServiceMsg
    //   0	895	2	paramPbGetGroupMsgResp	msg_svc.PbGetGroupMsgResp
    //   0	895	3	paramArrayList	ArrayList
    //   0	895	4	paramString	String
    //   165	398	5	i	int
    //   174	400	6	j	int
    //   196	389	7	k	int
    //   119	197	8	l1	long
    //   128	198	10	l2	long
    //   137	159	12	l3	long
    //   146	140	14	l4	long
    //   156	150	16	l5	long
    //   206	150	18	l6	long
    //   216	160	20	l7	long
    //   16	781	22	localMessageInfo	MessageInfo
    //   64	694	23	localObject1	Object
    //   70	13	24	localIterator	java.util.Iterator
    //   92	505	25	localMsg	msg_comm.Msg
    //   186	453	26	localObject2	Object
    //   508	23	27	localContentHead	msg_comm.ContentHead
    // Exception table:
    //   from	to	target	type
    //   252	263	649	java/io/UnsupportedEncodingException
    //   595	608	659	java/lang/Exception
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---TroopMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).group_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject3 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
    long l4 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l1 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    long l2 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int n = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i1 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l7 = ((msg_comm.GroupInfo)localObject3).group_code.get();
    int m = ((msg_comm.GroupInfo)localObject3).group_type.get();
    long l8 = ((msg_comm.GroupInfo)localObject3).group_info_seq.get();
    label173:
    long l3;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      l3 = ((Long)localObject1).longValue();
      if ((!((msg_comm.GroupInfo)localObject3).group_card.has()) || (((msg_comm.GroupInfo)localObject3).group_card.get() == null)) {
        break label483;
      }
      localObject1 = ((msg_comm.GroupInfo)localObject3).group_card.get().toByteArray();
    }
    for (;;)
    {
      Object localObject4;
      label483:
      label489:
      label495:
      boolean bool2;
      label1295:
      label1316:
      boolean bool3;
      for (;;)
      {
        ArrayList localArrayList;
        PBDecodeContext localPBDecodeContext;
        TroopInfoManager localTroopInfoManager;
        try
        {
          localObject1 = new String((byte[])localObject1, "utf-8");
          localObject3 = new ArrayList();
          if (!paramMsg.content_head.has()) {
            break label1638;
          }
          localObject4 = (msg_comm.ContentHead)paramMsg.content_head.get();
          k = ((msg_comm.ContentHead)localObject4).div_seq.get();
          i = ((msg_comm.ContentHead)localObject4).pkg_index.get();
          j = ((msg_comm.ContentHead)localObject4).pkg_num.get();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.aO = n;
          localObject4 = String.valueOf(l7);
          if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
          localArrayList = new ArrayList();
          localPBDecodeContext = new PBDecodeContext();
          localPBDecodeContext.e = l7;
          localPBDecodeContext.c = 1;
          localPBDecodeContext.d = m;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4) != 2) {
            break label489;
          }
          bool1 = true;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a()) {
            break;
          }
          localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          if (bool1) {
            break label495;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, new Object[] { paramMsg, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : unfinished troopuin=" + (String)localObject4);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
        break label173;
        Object localObject2 = null;
        continue;
        bool1 = false;
        continue;
        Object localObject5;
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder("<---handleMsgPush_PB_Group : before analysis :");
          ((StringBuilder)localObject5).append(" fromUin:").append(l4).append(" toUin:").append(l5).append(" msgTime:").append(l2).append(" msgSeq:").append(l1).append(" msgUid:").append(l6).append(" userActive:").append(n).append(" fromInstid:").append(i1).append(" groupCode:").append(l7).append(" groupType:").append(m).append(" groupSeq:").append(l8).append(" cardName:").append(Utils.a((String)localObject2)).append(" hasAppShare:").append(paramMsg.appshare_info.has()).append(" bFinished:").append(bool1).append(" divSeq:").append(k).append(" pkgIndex:").append(i).append(" pkgNum:").append(j);
          QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject5).toString());
          if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
          {
            l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() / 1000L;
            QLog.d("Q.msg.TroopMessageProcessor", 2, "push_cost=" + (l4 - l2) + ",type=GROUP_PUSH_MSG");
          }
        }
        paramFromServiceMsg = new MessageInfo();
        try
        {
          a(paramMsg, (ArrayList)localObject3, localPBDecodeContext, true, paramFromServiceMsg);
          MessageHandlerUtils.a((List)localObject3);
          if (((ArrayList)localObject3).size() == 0)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
            return;
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
            }
          }
          if (localArrayList != null) {
            a((ArrayList)localObject3, localArrayList, true);
          }
          paramMsg = new ArrayList();
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            j = localArrayList.size();
            i = 0;
            if (i < j)
            {
              localObject2 = (MessageRecord)localArrayList.get(i);
              if (QLog.isColorLevel())
              {
                localObject5 = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
                ((StringBuilder)localObject5).append(" mr.senderuin:").append(((MessageRecord)localObject2).senderuin).append(" mr.msgtype:").append(((MessageRecord)localObject2).msgtype).append(" mr.frienduin:").append(((MessageRecord)localObject2).frienduin).append(" mr.shmsgseq:").append(((MessageRecord)localObject2).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject2).time).append(" mr.msg:").append(((MessageRecord)localObject2).getLogColorContent());
                QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject5).toString());
              }
              if (((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) || ((AnonymousChatHelper.a((MessageRecord)localObject2)) && (AnonymousChatHelper.b((MessageRecord)localObject2))))
              {
                if (AnonymousChatHelper.a((MessageRecord)localObject2))
                {
                  ((MessageRecord)localObject2).senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  localObject5 = AnonymousChatHelper.a((MessageRecord)localObject2);
                  AnonymousChatHelper.a().a(String.valueOf(localPBDecodeContext.e), ((MessageRecord)localObject2).vipBubbleID, ((AnonymousChatHelper.AnonymousExtInfo)localObject5).jdField_b_of_type_Int, ((AnonymousChatHelper.AnonymousExtInfo)localObject5).jdField_b_of_type_JavaLangString, ((AnonymousChatHelper.AnonymousExtInfo)localObject5).c, ((AnonymousChatHelper.AnonymousExtInfo)localObject5).a);
                }
                localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, 1, (MessageRecord)localObject2);
                if (localObject5 != null)
                {
                  if (((localObject2 instanceof MessageForText)) && ((localObject5 instanceof MessageForText)) && (((MessageRecord)localObject2).getRepeatCount() > 0))
                  {
                    ((MessageRecord)localObject5).setRepeatCount(((MessageRecord)localObject2).getRepeatCount());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group ===> update findMr.repeatCount=" + ((MessageRecord)localObject5).getRepeatCount());
                    }
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
                  if (((MessageRecord)localObject5).msgtype == -2017)
                  {
                    byte[] arrayOfByte = MsgProxyUtils.a((MessageRecord)localObject5, (MessageRecord)localObject2);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject5).uniseq, arrayOfByte);
                    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject5)) {
                      break label1411;
                    }
                    a((MessageRecord)localObject5);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, ((MessageRecord)localObject2).shmsgseq);
                  }
                }
              }
              for (;;)
              {
                i += 1;
                break;
                if (!StructMsgHelper.a((MessageRecord)localObject5)) {
                  break label1295;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject5).uniseq);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject2).msgData);
                a(999, true, ((MessageRecord)localObject2).frienduin);
                break label1295;
                label1411:
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((MessageRecord)localObject2, (MessageRecord)localObject5);
                break label1316;
                ((MessageRecord)localObject2).isread = true;
                ((MessageRecord)localObject2).issend = 2;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject2).shmsgseq);
                paramMsg.add(localObject2);
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMsg);
          bool2 = MessageHandlerUtils.a(paramMsg);
          bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsg);
          i = MsgProxyUtils.a(paramMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localTroopInfoManager.a((String)localObject4, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("OpenTroopDebug", 2, "addMessage to facade.");
          }
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (!bool2) {
            break label1632;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {}
      label1632:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramFromServiceMsg.a(paramMsg, String.valueOf(l3), bool1);
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, l1);
        }
        if (m == 127) {
          break;
        }
        a("handleMsgPush_PB_Group", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3, paramMsg), false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramMsg);
        return;
      }
      label1638:
      int k = 0;
      int i = 0;
      int j = 0;
    }
  }
  
  protected TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    return super.a(paramMsg, paramArrayList, paramPBDecodeContext, paramBoolean, paramMessageInfo);
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 2))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetGroupMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[2], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], (msg_svc.PbGetGroupMsgResp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcResponseGroupMsgReadConfirm)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a(true, false, false, 0L, new kkz(this, paramLong1, paramLong2));
  }
  
  public void a(GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    String str = String.valueOf(paramGroupMsgReadedNotify.lGroupCode);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "GroupMsgReadedNotify lGroupCode is " + paramGroupMsgReadedNotify.lGroupCode + ", lMemberSeq  is " + paramGroupMsgReadedNotify.lMemberSeq);
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramGroupMsgReadedNotify.lMemberSeq) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, new Object[] { Long.valueOf(paramGroupMsgReadedNotify.lMemberSeq), Long.valueOf(paramGroupMsgReadedNotify.lGroupMsgSeq) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1, paramGroupMsgReadedNotify.lMemberSeq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, paramGroupMsgReadedNotify.lMemberSeq);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "doSomeAfterGetPullTroopMsg doSome:" + paramInt + " troopUin:" + paramString);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a("" + paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageProcessor
 * JD-Core Version:    0.7.0.1
 */