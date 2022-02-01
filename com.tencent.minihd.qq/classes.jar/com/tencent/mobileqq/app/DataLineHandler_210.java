package com.tencent.mobileqq.app;

import IMMsgBodyPack.MsgType0x210SubMsgType0x13;
import IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem;
import IMMsgBodyPack.Type_1_QQDataTextMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.service.TextMsgPush;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class DataLineHandler_210
  extends DataLineHandler
{
  DataLineHandler_210(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type == 1L) {
      b(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
    }
  }
  
  private void b(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type != 1L) {}
    TextMsgPush localTextMsgPush;
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid)))
      {
        localTextMsgPush = new TextMsgPush(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint32_size), Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid), localTextMsgPush);
      }
      for (;;)
      {
        Type_1_QQDataTextMsg localType_1_QQDataTextMsg = new Type_1_QQDataTextMsg();
        localType_1_QQDataTextMsg.readFrom(new JceInputStream(paramMsgType0x210SubMsgType0x13.bytes_buf));
        localObject = new String();
        int i = 0;
        while (i < localType_1_QQDataTextMsg.msg_item.size())
        {
          String str = new String(((MsgType0x210SubMsgType0x13_MsgItem)localType_1_QQDataTextMsg.msg_item.get(i)).bytes_text);
          localObject = (String)localObject + str;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, str);
          }
          i += 1;
        }
        localTextMsgPush = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      }
      localTextMsgPush.a((int)paramMsgType0x210SubMsgType0x13.uint32_index, (String)localObject);
    } while (!localTextMsgPush.a());
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
    Object localObject = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject).msgId = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).sessionid = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).msg = localTextMsgPush.a();
    ((DataLineMsgRecord)localObject).msgtype = -1000;
    ((DataLineMsgRecord)localObject).issend = 0;
    ((DataLineMsgRecord)localObject).isread = false;
    ((DataLineMsgRecord)localObject).time = paramInt;
    ((DataLineMsgRecord)localObject).issuc = true;
    ((DataLineMsgRecord)localObject).sessionid = ((DataLineMsgRecord)localObject).msgId;
    ((DataLineMsgRecord)localObject).shmsgseq = paramShort;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((DataLineMsgRecord)localObject, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    b(8, true, new Object[] { Integer.valueOf(paramInt), localTextMsgPush.a() });
  }
  
  /* Error */
  public void a(msf.msgcomm.msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 199	com/tencent/mobileqq/app/DataLineHandler:a	(Lmsf/msgcomm/msg_comm$Msg;)V
    //   5: new 201	msf/msgcomm/msg_comm$MsgType0x210
    //   8: dup
    //   9: invokespecial 202	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: getfield 208	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   20: invokevirtual 213	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   23: checkcast 210	tencent/im/msg/im_msg_body$MsgBody
    //   26: getfield 217	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   29: invokevirtual 222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   32: invokevirtual 228	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   35: invokevirtual 232	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   38: checkcast 201	msf/msgcomm/msg_comm$MsgType0x210
    //   41: astore 5
    //   43: aload 5
    //   45: astore 4
    //   47: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +11 -> 61
    //   53: ldc 110
    //   55: iconst_2
    //   56: ldc 234
    //   58: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: new 57	com/qq/taf/jce/JceInputStream
    //   64: dup
    //   65: aload 4
    //   67: getfield 235	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   70: invokevirtual 222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   73: invokevirtual 228	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   76: invokespecial 64	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   79: astore 5
    //   81: new 237	IMMsgBodyPack/MsgType0x210
    //   84: dup
    //   85: invokespecial 238	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   88: astore 4
    //   90: aload 4
    //   92: aload 5
    //   94: invokevirtual 239	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   97: new 130	com/tencent/mobileqq/data/DataLineMsgRecord
    //   100: dup
    //   101: invokespecial 131	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   104: astore 5
    //   106: aload 5
    //   108: aload_1
    //   109: getfield 243	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   112: invokevirtual 246	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 245	msf/msgcomm/msg_comm$MsgHead
    //   118: getfield 250	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: invokevirtual 254	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   124: i2l
    //   125: putfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   128: aload 5
    //   130: aload_1
    //   131: getfield 243	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   134: invokevirtual 246	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   137: checkcast 245	msf/msgcomm/msg_comm$MsgHead
    //   140: getfield 257	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: invokevirtual 254	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   146: i2l
    //   147: putfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   150: aload 5
    //   152: aload_1
    //   153: getfield 243	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   156: invokevirtual 246	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   159: checkcast 245	msf/msgcomm/msg_comm$MsgHead
    //   162: getfield 261	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   165: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   168: putfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   171: aload_0
    //   172: aload 5
    //   174: invokevirtual 269	com/tencent/mobileqq/app/DataLineHandler_210:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;)Z
    //   177: ifeq +82 -> 259
    //   180: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +53 -> 236
    //   186: ldc 110
    //   188: iconst_2
    //   189: new 93	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 271
    //   199: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 5
    //   204: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   207: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: ldc_w 276
    //   213: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 5
    //   218: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   221: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: ldc_w 278
    //   227: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: return
    //   237: astore 5
    //   239: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +14 -> 256
    //   245: ldc 110
    //   247: iconst_2
    //   248: ldc_w 280
    //   251: aload 5
    //   253: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: goto -209 -> 47
    //   259: aload_0
    //   260: getfield 166	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   263: bipush 9
    //   265: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   268: checkcast 289	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   271: astore_1
    //   272: aload_1
    //   273: ifnull +38 -> 311
    //   276: aload_1
    //   277: invokevirtual 291	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	()I
    //   280: istore_2
    //   281: aload_1
    //   282: invokevirtual 293	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:e	()I
    //   285: istore_3
    //   286: iload_2
    //   287: iconst_1
    //   288: if_icmpne +8 -> 296
    //   291: iload_2
    //   292: iconst_2
    //   293: if_icmpeq +8 -> 301
    //   296: aload_1
    //   297: iconst_1
    //   298: invokevirtual 296	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	(I)V
    //   301: iload_3
    //   302: iconst_1
    //   303: if_icmpeq +8 -> 311
    //   306: aload_1
    //   307: iconst_1
    //   308: invokevirtual 298	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:b	(I)V
    //   311: aload 4
    //   313: getfield 301	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   316: ldc2_w 302
    //   319: lcmp
    //   320: ifne +76 -> 396
    //   323: aload_0
    //   324: aload 4
    //   326: getfield 307	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   329: getfield 310	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   332: l2i
    //   333: aload 4
    //   335: getfield 307	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   338: getfield 313	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   341: l2i
    //   342: invokevirtual 316	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   345: ifne -109 -> 236
    //   348: aload_0
    //   349: aload 4
    //   351: getfield 307	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   354: getfield 319	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   357: l2i
    //   358: aload 4
    //   360: getfield 307	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   363: getfield 322	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   366: l2i
    //   367: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   370: ifeq -134 -> 236
    //   373: aload_0
    //   374: aload 5
    //   376: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   379: l2i
    //   380: aload 5
    //   382: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   385: l2i
    //   386: i2s
    //   387: aload 4
    //   389: getfield 307	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   392: invokespecial 326	com/tencent/mobileqq/app/DataLineHandler_210:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   395: return
    //   396: aload 4
    //   398: getfield 301	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   401: ldc2_w 327
    //   404: lcmp
    //   405: ifne +176 -> 581
    //   408: aload_0
    //   409: aload 4
    //   411: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   414: getfield 337	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   417: l2i
    //   418: aload 4
    //   420: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   423: getfield 340	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   426: l2i
    //   427: invokevirtual 316	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   430: ifne -194 -> 236
    //   433: aload_0
    //   434: aload 4
    //   436: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   439: getfield 343	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   442: l2i
    //   443: aload 4
    //   445: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   448: getfield 346	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   451: l2i
    //   452: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   455: ifeq -219 -> 236
    //   458: aload_0
    //   459: getfield 349	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   462: aload 4
    //   464: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   467: getfield 352	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   470: aload 4
    //   472: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   475: getfield 355	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   478: aload 4
    //   480: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   483: getfield 358	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   486: new 70	java/lang/String
    //   489: dup
    //   490: aload 4
    //   492: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   495: getfield 361	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   498: invokespecial 91	java/lang/String:<init>	([B)V
    //   501: aload 4
    //   503: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   506: getfield 364	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   509: aload 4
    //   511: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   514: getfield 367	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   517: new 70	java/lang/String
    //   520: dup
    //   521: aload 4
    //   523: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   526: getfield 370	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   529: invokespecial 91	java/lang/String:<init>	([B)V
    //   532: aload 4
    //   534: getfield 332	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   537: getfield 373	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   540: iconst_0
    //   541: iconst_0
    //   542: iconst_0
    //   543: iconst_0
    //   544: aload 5
    //   546: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   549: l2i
    //   550: i2l
    //   551: aload 5
    //   553: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   556: l2i
    //   557: i2s
    //   558: i2l
    //   559: aload 5
    //   561: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   564: iconst_0
    //   565: invokevirtual 379	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFTNNotify_0x210	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   568: astore_1
    //   569: aload_0
    //   570: getfield 382	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   573: aload_1
    //   574: invokevirtual 388	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   577: return
    //   578: astore_1
    //   579: aload_1
    //   580: athrow
    //   581: aload 4
    //   583: getfield 301	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   586: ldc2_w 389
    //   589: lcmp
    //   590: ifne +190 -> 780
    //   593: aload_0
    //   594: aload 4
    //   596: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   599: getfield 397	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   602: l2i
    //   603: aload 4
    //   605: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   608: getfield 398	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   611: l2i
    //   612: invokevirtual 316	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   615: ifne -379 -> 236
    //   618: aload_0
    //   619: aload 4
    //   621: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   624: getfield 399	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   627: l2i
    //   628: aload 4
    //   630: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   633: getfield 400	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   636: l2i
    //   637: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   640: ifeq -404 -> 236
    //   643: aload_0
    //   644: getfield 349	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   647: aload 4
    //   649: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   652: getfield 401	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   655: aload 4
    //   657: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   660: getfield 402	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   663: aload 4
    //   665: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   668: getfield 403	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   671: new 70	java/lang/String
    //   674: dup
    //   675: aload 4
    //   677: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   680: getfield 404	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   683: invokespecial 91	java/lang/String:<init>	([B)V
    //   686: aload 4
    //   688: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   691: getfield 407	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   694: aload 4
    //   696: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   699: getfield 410	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   702: aload 4
    //   704: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   707: getfield 413	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   710: aload 4
    //   712: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   715: getfield 416	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   718: aload 4
    //   720: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   723: getfield 419	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   726: aload 4
    //   728: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   731: getfield 422	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   734: aload 4
    //   736: getfield 394	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   739: getfield 423	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   742: iconst_0
    //   743: iconst_0
    //   744: iconst_0
    //   745: iconst_0
    //   746: aload 5
    //   748: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   751: l2i
    //   752: i2l
    //   753: aload 5
    //   755: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   758: l2i
    //   759: i2s
    //   760: i2l
    //   761: aload 5
    //   763: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   766: iconst_0
    //   767: invokevirtual 427	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromNFCNotify_0x210	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   770: astore_1
    //   771: aload_0
    //   772: getfield 382	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   775: aload_1
    //   776: invokevirtual 388	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   779: return
    //   780: aload 4
    //   782: getfield 301	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   785: ldc2_w 428
    //   788: lcmp
    //   789: ifne -553 -> 236
    //   792: aload_0
    //   793: aload 4
    //   795: getfield 433	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   798: getfield 436	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   801: l2i
    //   802: aload 4
    //   804: getfield 433	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   807: getfield 437	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   810: l2i
    //   811: invokevirtual 316	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   814: ifne -578 -> 236
    //   817: aload_0
    //   818: aload 4
    //   820: getfield 433	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   823: getfield 438	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   826: l2i
    //   827: aload 4
    //   829: getfield 433	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   832: getfield 439	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   835: l2i
    //   836: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   839: ifeq -603 -> 236
    //   842: aload_0
    //   843: getfield 349	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   846: aload 4
    //   848: getfield 433	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   851: getfield 440	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   854: aload 4
    //   856: getfield 433	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   859: getfield 443	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   862: iconst_0
    //   863: aload 5
    //   865: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   868: l2i
    //   869: aload 5
    //   871: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   874: l2i
    //   875: i2s
    //   876: invokevirtual 447	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFileControl_0x210	(JJIIS)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   879: astore_1
    //   880: aload_0
    //   881: getfield 382	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   884: aload_1
    //   885: invokevirtual 388	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   888: return
    //   889: astore_1
    //   890: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	this	DataLineHandler_210
    //   0	891	1	paramMsg	msf.msgcomm.msg_comm.Msg
    //   280	14	2	i	int
    //   285	19	3	j	int
    //   12	843	4	localObject1	Object
    //   41	176	5	localObject2	Object
    //   237	633	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   14	43	237	java/lang/Exception
    //   90	236	578	finally
    //   259	272	578	finally
    //   276	286	578	finally
    //   296	301	578	finally
    //   306	311	578	finally
    //   311	395	578	finally
    //   396	577	578	finally
    //   581	779	578	finally
    //   780	888	578	finally
    //   90	236	889	java/lang/Exception
    //   259	272	889	java/lang/Exception
    //   276	286	889	java/lang/Exception
    //   296	301	889	java/lang/Exception
    //   306	311	889	java/lang/Exception
    //   311	395	889	java/lang/Exception
    //   396	577	889	java/lang/Exception
    //   581	779	889	java/lang/Exception
    //   780	888	889	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler_210
 * JD-Core Version:    0.7.0.1
 */