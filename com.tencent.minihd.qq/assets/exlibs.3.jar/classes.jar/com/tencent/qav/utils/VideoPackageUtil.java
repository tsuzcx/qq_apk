package com.tencent.qav.utils;

public class VideoPackageUtil
{
  static final int CMD_CREATE_ROOM_REQ = 1;
  static final int CMD_CREATE_ROOM_RSP = 2;
  static final int CMD_IGNORE_INVITE_REQ = 8;
  static final int CMD_IGNORE_INVITE_RSP = 9;
  static final int CMD_INVITE_REACHED_REQ = 18;
  static final int CMD_INVITE_USERS_REQ = 4;
  static final int CMD_INVITE_USERS_RSP = 5;
  static final int CMD_QUERY_INFO_REQ = 12;
  static final int CMD_QUERY_INFO_RSP = 13;
  static final int CMD_REFUSE_INVITE_REQ = 6;
  static final int CMD_REFUSE_INVITE_RSP = 7;
  static final int CMD_S2C_BUSINESS_CHANGE_REQ = 11;
  static final int CMD_S2C_INVITE_REQ = 3;
  static final int CMD_S2C_INVITE_RSP = 21;
  static final int CMD_S2C_IOS_VOIP_PUSHNOTIFY_REQ = 20;
  static final int CMD_S2C_NOTIFY_HAVE_ROOM_REQ = 19;
  static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_ACCEPT_REQ = 22;
  static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_LOGOUT_REQ = 23;
  static final int CMD_S2C_ROOM_DESTROY_REQ = 14;
  static final int CMD_S2C_USER_STAT_NOTIFY_REQ = 10;
  static final int CMD_SDK_INFO_REPORT_REQ = 24;
  static final int CMD_SDK_INFO_REPORT_RSP = 25;
  static final int CMD_SDK_STAT_REPORT_REQ = 16;
  static final int CMD_SDK_STAT_REPORT_RSP = 17;
  static final int CMD_TERM_ACT_NOTIFY_REQ = 15;
  static final String TAG = "VideoPackageUtil";
  
  /* Error */
  public static VideoPacket parse(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 73	tencent/im/cs/longconn/hd_video$MsgBody
    //   5: dup
    //   6: invokespecial 74	tencent/im/cs/longconn/hd_video$MsgBody:<init>	()V
    //   9: aload_0
    //   10: invokevirtual 78	tencent/im/cs/longconn/hd_video$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13: checkcast 73	tencent/im/cs/longconn/hd_video$MsgBody
    //   16: astore_0
    //   17: new 6	com/tencent/qav/utils/VideoPackageUtil$VideoPacket
    //   20: dup
    //   21: invokespecial 79	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:<init>	()V
    //   24: astore_2
    //   25: aload_0
    //   26: getfield 83	tencent/im/cs/longconn/hd_video$MsgBody:msg_video_head	Ltencent/im/cs/longconn/hd_video$VideoHead;
    //   29: invokevirtual 89	tencent/im/cs/longconn/hd_video$VideoHead:has	()Z
    //   32: ifeq +197 -> 229
    //   35: aload_0
    //   36: getfield 83	tencent/im/cs/longconn/hd_video$MsgBody:msg_video_head	Ltencent/im/cs/longconn/hd_video$VideoHead;
    //   39: invokevirtual 93	tencent/im/cs/longconn/hd_video$VideoHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   42: checkcast 85	tencent/im/cs/longconn/hd_video$VideoHead
    //   45: astore_3
    //   46: aload_2
    //   47: aload_3
    //   48: getfield 97	tencent/im/cs/longconn/hd_video$VideoHead:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   51: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   54: putfield 106	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:uin	J
    //   57: aload_2
    //   58: aload_3
    //   59: getfield 110	tencent/im/cs/longconn/hd_video$VideoHead:enum_body_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   62: invokevirtual 115	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   65: putfield 118	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:bodyType	I
    //   68: aload_2
    //   69: aload_3
    //   70: getfield 121	tencent/im/cs/longconn/hd_video$VideoHead:uint64_room_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   73: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   76: putfield 124	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:roomId	J
    //   79: aload_2
    //   80: aload_3
    //   81: getfield 128	tencent/im/cs/longconn/hd_video$VideoHead:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 131	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   87: putfield 134	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:seq	I
    //   90: aload_3
    //   91: getfield 138	tencent/im/cs/longconn/hd_video$VideoHead:int32_sub_service_type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   94: invokevirtual 141	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   97: ifeq +161 -> 258
    //   100: aload_3
    //   101: getfield 138	tencent/im/cs/longconn/hd_video$VideoHead:int32_sub_service_type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   104: invokevirtual 142	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   107: istore_1
    //   108: aload_2
    //   109: iload_1
    //   110: putfield 145	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:subServiceType	I
    //   113: aload_2
    //   114: aload_3
    //   115: getfield 149	tencent/im/cs/longconn/hd_video$VideoHead:str_from_mobile	Lcom/tencent/mobileqq/pb/PBStringField;
    //   118: invokevirtual 154	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   121: putfield 156	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:str_from_mobile	Ljava/lang/String;
    //   124: aload_2
    //   125: aload_3
    //   126: getfield 159	tencent/im/cs/longconn/hd_video$VideoHead:str_from_nation	Lcom/tencent/mobileqq/pb/PBStringField;
    //   129: invokevirtual 154	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   132: putfield 161	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:str_from_nation	Ljava/lang/String;
    //   135: aload_0
    //   136: getfield 165	tencent/im/cs/longconn/hd_video$MsgBody:msg_invite_body	Ltencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody;
    //   139: invokevirtual 168	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody:has	()Z
    //   142: ifeq +114 -> 256
    //   145: aload_0
    //   146: getfield 165	tencent/im/cs/longconn/hd_video$MsgBody:msg_invite_body	Ltencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody;
    //   149: invokevirtual 169	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   152: checkcast 167	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody
    //   155: astore_0
    //   156: aload_2
    //   157: aload_0
    //   158: getfield 172	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   161: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   164: putfield 175	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:fromuin	J
    //   167: aload_2
    //   168: aload_0
    //   169: getfield 178	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody:uint32_new_business_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   172: invokevirtual 131	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   175: putfield 181	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:business_flag	I
    //   178: aload_2
    //   179: aload_0
    //   180: getfield 185	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody:bool_terminal_switch_flag	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   183: invokevirtual 189	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   186: putfield 193	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:terminal_switch_flag	Z
    //   189: aload_0
    //   190: getfield 197	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody:msg_temp_session	Ltencent/im/cs/longconn/hd_video$InviteTempSessionData;
    //   193: invokevirtual 200	tencent/im/cs/longconn/hd_video$InviteTempSessionData:has	()Z
    //   196: ifeq +60 -> 256
    //   199: aload_0
    //   200: getfield 197	tencent/im/cs/longconn/hd_video$CmdS2CInviteReqBody:msg_temp_session	Ltencent/im/cs/longconn/hd_video$InviteTempSessionData;
    //   203: astore_0
    //   204: aload_2
    //   205: aload_0
    //   206: getfield 203	tencent/im/cs/longconn/hd_video$InviteTempSessionData:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   209: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   212: putfield 205	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:uint64_group_uin	J
    //   215: aload_2
    //   216: aload_0
    //   217: getfield 208	tencent/im/cs/longconn/hd_video$InviteTempSessionData:uint32_relationship_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   220: invokevirtual 131	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   223: putfield 211	com/tencent/qav/utils/VideoPackageUtil$VideoPacket:u32AccountType	I
    //   226: goto +30 -> 256
    //   229: ldc 62
    //   231: ldc 213
    //   233: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: goto -101 -> 135
    //   239: astore_0
    //   240: ldc 62
    //   242: ldc 221
    //   244: aload_0
    //   245: invokestatic 224	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_2
    //   249: areturn
    //   250: astore_0
    //   251: aload_3
    //   252: astore_2
    //   253: goto -13 -> 240
    //   256: aload_2
    //   257: areturn
    //   258: iconst_m1
    //   259: istore_1
    //   260: goto -152 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramArrayOfByte	byte[]
    //   107	153	1	i	int
    //   24	233	2	localObject	Object
    //   1	251	3	localVideoHead	tencent.im.cs.longconn.hd_video.VideoHead
    // Exception table:
    //   from	to	target	type
    //   25	108	239	java/lang/Exception
    //   108	135	239	java/lang/Exception
    //   135	226	239	java/lang/Exception
    //   229	236	239	java/lang/Exception
    //   2	25	250	java/lang/Exception
  }
  
  public static class VideoPacket
  {
    public int bodyType = 0;
    public int business_flag = 0;
    public long fromuin = 0L;
    public long roomId = 0L;
    public int seq = 0;
    public String str_from_mobile;
    public String str_from_nation;
    public int subServiceType = 0;
    public boolean terminal_switch_flag = false;
    public int u32AccountType = 0;
    public long uin = 0L;
    public long uint64_group_uin = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.utils.VideoPackageUtil
 * JD-Core Version:    0.7.0.1
 */