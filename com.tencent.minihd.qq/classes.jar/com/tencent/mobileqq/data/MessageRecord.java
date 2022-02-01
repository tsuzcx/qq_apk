package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.MsgUtils;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,senderuin,msgData,istroop,shmsgseq,msgseq")
public class MessageRecord
  extends Entity
{
  public static final int EXTRA_STREAM_PTT_FLAG = 10001;
  public static final int MIN_VERSION_CODE_SUPPORT_IMAGE_MD5_TRANS = 2;
  public static final int MSG_TYPE_0x7F = -2006;
  public static final int MSG_TYPE_ACTIVATE_FRIENDS = -5003;
  public static final int MSG_TYPE_ACTIVITY = -4002;
  public static final int MSG_TYPE_AUTHORIZE_FAILED = -4005;
  public static final int MSG_TYPE_AUTOREPLY = -10000;
  public static final int MSG_TYPE_BAT_PROCESS_FILE = -3013;
  public static final int MSG_TYPE_BIZ_DATA = -2023;
  public static final int MSG_TYPE_C2C_CHAT_FREQ_CALL_TIP = -1014;
  public static final int MSG_TYPE_C2C_KEYWORD_CALL_TIP = -1015;
  public static final int MSG_TYPE_C2C_MIXED = -30002;
  public static final int MSG_TYPE_COLOR_RING_TIPS = -3012;
  public static final int MSG_TYPE_CONFIGURABLE_GRAY_TIPS = 2024;
  public static final int MSG_TYPE_DATE_FEED = -1042;
  public static final int MSG_TYPE_DEVICE_FILE = -4500;
  public static final int MSG_TYPE_DEVICE_PTT = -4501;
  public static final int MSG_TYPE_DEVICE_SHORT_VIDEO = -4503;
  public static final int MSG_TYPE_DEVICE_SINGLESTRUCT = -4502;
  public static final int MSG_TYPE_DISCUSS_PUSH = -1004;
  public static final int MSG_TYPE_DISC_CREATE_CALL_TIP = -1016;
  public static final int MSG_TYPE_DISC_PTT_FREQ_CALL_TIP = -1017;
  public static final int MSG_TYPE_ENTER_TROOP = -4003;
  public static final int MSG_TYPE_FAILED_MSG = -2013;
  public static final int MSG_TYPE_FILE_RECEIPT = -3008;
  public static final int MSG_TYPE_FORWARD_IMAGE = -20000;
  public static final int MSG_TYPE_GAME_INVITE = -3004;
  public static final int MSG_TYPE_GAME_SHARE = -3005;
  public static final int MSG_TYPE_GRAY_TIPS = -5000;
  public static final int MSG_TYPE_GRAY_TIPS_TAB_VISIBLE = -5001;
  public static final int MSG_TYPE_GROUPDISC_FILE = -2014;
  public static final int MSG_TYPE_HONGBAO_KEYWORDS_TIPS = -1045;
  public static final int MSG_TYPE_HOT_CHAT_TO_SEE_TIP = 1018;
  public static final int MSG_TYPE_INCOMPATIBLE_GRAY_TIPS = -5002;
  public static final int MSG_TYPE_LBS_FANPAIZI_TIP = -1025;
  public static final int MSG_TYPE_LIFEONLINEACCOUNT = -5004;
  public static final int MSG_TYPE_LIGHTALK_MSG = -2026;
  public static final int MSG_TYPE_LOCAL_COMMON = -4000;
  public static final int MSG_TYPE_LOCAL_URL = -4001;
  public static final int MSG_TYPE_LONG_MIX = -1036;
  public static final int MSG_TYPE_LONG_TEXT = -1037;
  public static final int MSG_TYPE_MEDIA_EMO = -2001;
  public static final int MSG_TYPE_MEDIA_FILE = -2005;
  public static final int MSG_TYPE_MEDIA_FUNNY_FACE = -2010;
  public static final int MSG_TYPE_MEDIA_MARKFACE = -2007;
  public static final int MSG_TYPE_MEDIA_MULTI09 = -2003;
  public static final int MSG_TYPE_MEDIA_MULTI513 = -2004;
  public static final int MSG_TYPE_MEDIA_PIC = -2000;
  public static final int MSG_TYPE_MEDIA_PTT = -2002;
  public static final int MSG_TYPE_MEDIA_SECRETFILE = -2008;
  public static final int MSG_TYPE_MEDIA_SHORTVIDEO = -2022;
  public static final int MSG_TYPE_MEDIA_VIDEO = -2009;
  public static final int MSG_TYPE_MIX = -1035;
  public static final int MSG_TYPE_MULTI_TEXT_VIDEO = -4008;
  public static final int MSG_TYPE_MULTI_VIDEO = -2016;
  public static final int MSG_TYPE_MY_ENTER_TROOP = -4004;
  public static final int MSG_TYPE_NEARBY_DATING_SAFETY_TIP = -1028;
  public static final int MSG_TYPE_NEARBY_DATING_TIP = -1024;
  public static final int MSG_TYPE_NEW_FRIEND_TIPS = -1013;
  public static final int MSG_TYPE_NEW_FRIEND_TIPS_GAME_ADDEE = -1019;
  public static final int MSG_TYPE_NEW_FRIEND_TIPS_GAME_ADDER = -1018;
  public static final int MSG_TYPE_NULL = -999;
  public static final int MSG_TYPE_ONLINE_FILE_REQ = -3007;
  public static final int MSG_TYPE_OPERATE_TIPS = -1041;
  public static final int MSG_TYPE_PC_PUSH = -3001;
  public static final int MSG_TYPE_PIC_AND_TEXT_MIXED = -3000;
  public static final int MSG_TYPE_PIC_QSECRETARY = -1032;
  public static final int MSG_TYPE_PTT_QSECRETARY = -1031;
  public static final int MSG_TYPE_PUBLIC_ACCOUNT = -3006;
  public static final int MSG_TYPE_QLINK_AP_CREATE_SUC_TIPS = -3011;
  public static final int MSG_TYPE_QLINK_FILE_TIPS = -3009;
  public static final int MSG_TYPE_QLINK_SEND_FILE_TIPS = -3010;
  public static final int MSG_TYPE_QQWALLET_MSG = -2025;
  public static final int MSG_TYPE_QZONE_NEWEST_FEED = -2015;
  public static final int MSG_TYPE_RED_PACKET_TIPS = -1044;
  public static final int MSG_TYPE_RENEWAL_TAIL_TIP = -4020;
  public static final int MSG_TYPE_SENSITIVE_MSG_MASK_TIPS = -1046;
  public static final int MSG_TYPE_SHAKE_WINDOW = -2020;
  public static final int MSG_TYPE_SHARE_LBS_PUSH = -4010;
  public static final int MSG_TYPE_SHIELD_MSG = -2012;
  public static final int MSG_TYPE_SINGLE_WAY_FRIEND_MSG = -2019;
  public static final int MSG_TYPE_SOUGOU_INPUT_TIPS = -1043;
  public static final int MSG_TYPE_SPECIALCARE_TIPS = -5005;
  public static final int MSG_TYPE_STRUCT_MSG = -2011;
  public static final int MSG_TYPE_STRUCT_TROOP_NOTIFICATION = -2021;
  public static final int MSG_TYPE_SYSTEM_STRUCT_MSG = -2018;
  public static final int MSG_TYPE_TEXT = -1000;
  public static final int MSG_TYPE_TEXT_FRIEND_FEED = -1034;
  public static final int MSG_TYPE_TEXT_GROUPMAN_ACCEPT = -1021;
  public static final int MSG_TYPE_TEXT_GROUPMAN_ADDREQUEST = -1020;
  public static final int MSG_TYPE_TEXT_GROUPMAN_INVITE = -1023;
  public static final int MSG_TYPE_TEXT_GROUPMAN_REFUSE = -1022;
  public static final int MSG_TYPE_TEXT_QSECRETARY = -1003;
  public static final int MSG_TYPE_TEXT_RECOMMEND_CIRCLE = -1033;
  public static final int MSG_TYPE_TEXT_RECOMMEND_CONTACT = -1030;
  public static final int MSG_TYPE_TEXT_RECOMMEND_TROOP = -1039;
  public static final int MSG_TYPE_TEXT_RECOMMEND_TROOP_BUSINESS = -1040;
  public static final int MSG_TYPE_TEXT_SAFE = -1002;
  public static final int MSG_TYPE_TEXT_SYSTEM_ACCEPT = -1008;
  public static final int MSG_TYPE_TEXT_SYSTEM_ACCEPTANDADD = -1007;
  public static final int MSG_TYPE_TEXT_SYSTEM_ADDREQUEST = -1006;
  public static final int MSG_TYPE_TEXT_SYSTEM_ADDSUCCESS = -1010;
  public static final int MSG_TYPE_TEXT_SYSTEM_OLD_VERSION_ADDREQUEST = -1011;
  public static final int MSG_TYPE_TEXT_SYSTEM_REFUSE = -1009;
  public static final int MSG_TYPE_TEXT_VIDEO = -1001;
  public static final int MSG_TYPE_TROOP_MIXED = -30003;
  public static final int MSG_TYPE_TROOP_OBJ_MSG = -2017;
  public static final int MSG_TYPE_TROOP_TIPS_ADD_MEMBER = -1012;
  public static final int MSG_TYPE_TROOP_UNREAD_TIPS = -4009;
  public static final int MSG_TYPE_UNCOMMONLY_USED_CONTACTS = -1026;
  public static final int MSG_TYPE_UNCOMMONLY_USED_CONTACTS_CANCEL_SET = -1027;
  public static final int MSG_VERSION_CODE = 3;
  public static final int MSG_VERSION_CODE_FOR_PICPTT = 3;
  public static final String QUERY_NEW_TABLE_FIELDS = "_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong";
  public static final String QUERY_OLD_TABLE_FIELDS = "_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong";
  public static final String[] QUERY_OLD_TABLE_FIELDS_ARRAY = { "_id", "extraflag", "frienduin", "isread", "issend", "istroop", "msg", "msgId", "msgseq", "msgtype", "selfuin", "senderuin", "shmsgseq", "time" };
  public static final int SEND_FAIL_CODE_DEFAULT = 0;
  public int extInt;
  public int extLong;
  public String extStr;
  public int extraflag;
  public String frienduin;
  @notColumn
  public boolean isMultiMsg = false;
  public boolean isValid = true;
  public boolean isread;
  public int issend;
  public int istroop;
  public int longMsgCount;
  public int longMsgId;
  public int longMsgIndex;
  @notColumn
  public String msg;
  public byte[] msgData;
  @Deprecated
  public long msgId;
  public long msgUid;
  public long msgseq;
  public int msgtype;
  public String selfuin;
  public int sendFailCode;
  public String senderuin;
  public long shmsgseq;
  public long time;
  public long uniseq;
  public int versionCode = 3;
  public long vipBubbleID;
  
  public MessageRecord()
  {
    createMessageUniseq();
  }
  
  public static void copyMessageRecordBaseField(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramMessageRecord1.selfuin = paramMessageRecord2.selfuin;
    paramMessageRecord1.senderuin = paramMessageRecord2.senderuin;
    paramMessageRecord1.msgtype = paramMessageRecord2.msgtype;
    paramMessageRecord1.msg = paramMessageRecord2.msg;
    paramMessageRecord1.time = paramMessageRecord2.time;
    paramMessageRecord1.shmsgseq = paramMessageRecord2.shmsgseq;
    paramMessageRecord1.msgseq = paramMessageRecord2.msgseq;
    paramMessageRecord1.isread = paramMessageRecord2.isread;
    paramMessageRecord1.issend = paramMessageRecord2.issend;
    paramMessageRecord1.frienduin = paramMessageRecord2.frienduin;
    paramMessageRecord1.istroop = paramMessageRecord2.istroop;
    paramMessageRecord1.extraflag = paramMessageRecord2.extraflag;
    paramMessageRecord1.sendFailCode = paramMessageRecord2.sendFailCode;
    paramMessageRecord1.msgUid = paramMessageRecord2.msgUid;
    paramMessageRecord1.uniseq = paramMessageRecord2.uniseq;
    paramMessageRecord1.extInt = paramMessageRecord2.extInt;
    paramMessageRecord1.extLong = paramMessageRecord2.extLong;
    paramMessageRecord1.extStr = paramMessageRecord2.extStr;
    paramMessageRecord1.isValid = paramMessageRecord2.isValid;
    paramMessageRecord1.versionCode = paramMessageRecord2.versionCode;
    paramMessageRecord1.vipBubbleID = paramMessageRecord2.vipBubbleID;
    paramMessageRecord1.longMsgCount = paramMessageRecord2.longMsgCount;
    paramMessageRecord1.longMsgId = paramMessageRecord2.longMsgId;
    paramMessageRecord1.longMsgIndex = paramMessageRecord2.longMsgIndex;
    paramMessageRecord1.msgData = paramMessageRecord2.msgData;
  }
  
  public static void copyMessageRecordStatusField(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramMessageRecord1.time = paramMessageRecord2.time;
    paramMessageRecord1.shmsgseq = paramMessageRecord2.shmsgseq;
    paramMessageRecord1.msgseq = paramMessageRecord2.msgseq;
    paramMessageRecord1.isread = paramMessageRecord2.isread;
    paramMessageRecord1.issend = paramMessageRecord2.issend;
    paramMessageRecord1.extraflag = paramMessageRecord2.extraflag;
    paramMessageRecord1.sendFailCode = paramMessageRecord2.sendFailCode;
    paramMessageRecord1.msgUid = paramMessageRecord2.msgUid;
    paramMessageRecord1.uniseq = paramMessageRecord2.uniseq;
    paramMessageRecord1.extInt = paramMessageRecord2.extInt;
    paramMessageRecord1.extLong = paramMessageRecord2.extLong;
    paramMessageRecord1.extStr = paramMessageRecord2.extStr;
    paramMessageRecord1.isValid = paramMessageRecord2.isValid;
    paramMessageRecord1.versionCode = paramMessageRecord2.versionCode;
    paramMessageRecord1.vipBubbleID = paramMessageRecord2.vipBubbleID;
    paramMessageRecord1.longMsgCount = paramMessageRecord2.longMsgCount;
    paramMessageRecord1.longMsgId = paramMessageRecord2.longMsgId;
    paramMessageRecord1.longMsgIndex = paramMessageRecord2.longMsgIndex;
  }
  
  public static long getDatabaseMsgID(long paramLong)
  {
    if (getVersionCode(paramLong) > 0) {
      return paramLong;
    }
    return -100L - paramLong;
  }
  
  public static long getLogicMsgID(long paramLong, int paramInt)
  {
    if (paramInt > 0) {
      return paramLong;
    }
    return -100L - paramLong;
  }
  
  public static String getOldTableName(String paramString, int paramInt)
  {
    String str = "friend";
    switch (paramInt)
    {
    }
    for (;;)
    {
      return "mr_" + str + "_" + MsgProxyUtils.a(paramString);
      str = "troop";
      continue;
      str = "discusssion";
      continue;
      str = "contact";
    }
  }
  
  public static String getTableName(String paramString, int paramInt)
  {
    String str = "friend";
    switch (paramInt)
    {
    }
    for (;;)
    {
      return "mr_" + str + "_" + MsgProxyUtils.a(paramString) + "_New";
      str = "troop";
      continue;
      str = "discusssion";
      continue;
      str = "contact";
      continue;
      str = "devicemsg";
    }
  }
  
  public static int getTypeByTableName(String paramString)
  {
    if (paramString.startsWith("mr_troop")) {
      return 1;
    }
    if (paramString.startsWith("mr_discusssion")) {
      return 3000;
    }
    if (paramString.startsWith("mr_contact")) {
      return 1006;
    }
    if (paramString.startsWith("mr_devicemsg")) {
      return 9501;
    }
    return 0;
  }
  
  public static int getVersionCode(long paramLong)
  {
    if (paramLong < 0L) {
      return 0;
    }
    return 3;
  }
  
  public void createMessageUniseq()
  {
    this.uniseq = ((int)this.time);
    if (this.uniseq == 0L) {
      this.uniseq = ((int)(System.currentTimeMillis() / 1000L));
    }
    this.uniseq = (this.uniseq << 32 | Math.abs(new Random().nextInt()));
  }
  
  public String getBaseInfoString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageRecord BaseInfo=");
    localStringBuilder.append("friendUin:").append(this.frienduin).append(",_id:").append(getId()).append(",shmsgseq:").append(this.shmsgseq).append(",uid:").append(this.msgUid).append(",uniseq:").append(this.uniseq).append(",time:").append(this.time).append(",extraFlag:").append(this.extraflag).append(",istroop:").append(this.istroop).append(",msgType:").append(this.msgtype).append(",msg:").append(Utils.a(this.msg));
    if (isLongMsg()) {
      localStringBuilder.append(",longMsgId:").append(this.longMsgId).append(",longMsgCount:").append(this.longMsgCount).append(",longMsgIndex:").append(this.longMsgIndex);
    }
    return localStringBuilder.toString();
  }
  
  protected Class getClassForTable()
  {
    return MessageRecord.class;
  }
  
  public String getExtInfoFromExtStr(String paramString)
  {
    if ((this.extLong & 0x1) != 1) {
      return "";
    }
    if (TextUtils.isEmpty(this.extStr)) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.extStr);
      if (localJSONObject.has(paramString)) {
        return localJSONObject.getString(paramString);
      }
      return "";
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String getLogColorContent()
  {
    return Utils.a(this.msg);
  }
  
  public String getLongMsgInfoString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageRecord LongMsgInfo=");
    localStringBuilder.append("friendUin:").append(this.frienduin).append(",istroop:").append(this.istroop).append(",msgType:").append(this.msgtype).append(",msg:").append(Utils.a(this.msg)).append(",time:").append(this.time);
    if (isLongMsg()) {
      localStringBuilder.append(",longMsgId:").append(this.longMsgId).append(",longMsgCount:").append(this.longMsgCount).append(",longMsgIndex:").append(this.longMsgIndex);
    }
    return localStringBuilder.toString();
  }
  
  public int getPttStreamFlag()
  {
    return (short)(this.extInt & 0xFFFF);
  }
  
  public int getRepeatCount()
  {
    return (short)(this.extInt >> 16);
  }
  
  public String getTableName()
  {
    if (this.isMultiMsg) {
      return "mr_multimessage";
    }
    return getTableName(this.frienduin, this.istroop);
  }
  
  public String getUserLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageRecord=");
    if ((this.frienduin != null) && (this.frienduin.length() >= 4)) {
      localStringBuilder.append("friendUin:").append(this.frienduin.substring(this.frienduin.length() - 4));
    }
    if ((this.senderuin != null) && (this.senderuin.length() >= 4)) {
      localStringBuilder.append("senderuin:").append(this.senderuin.substring(this.senderuin.length() - 4));
    }
    localStringBuilder.append(",istroop:").append(this.istroop).append(",msgType:").append(this.msgtype).append(",time:").append(this.time).append(",shmsgseq:").append(this.shmsgseq);
    return localStringBuilder.toString();
  }
  
  public void init(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt1, int paramInt2, long paramLong5)
  {
    this.selfuin = String.valueOf(paramLong1);
    this.frienduin = String.valueOf(paramLong2);
    this.senderuin = String.valueOf(paramLong3);
    this.msg = paramString;
    paramLong1 = paramLong4;
    if (paramLong4 <= 0L) {
      paramLong1 = (int)MessageCache.a();
    }
    this.time = paramLong1;
    this.msgtype = paramInt1;
    this.istroop = paramInt2;
    this.msgseq = paramLong5;
  }
  
  public void init(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    this.selfuin = paramString1;
    this.frienduin = paramString2;
    this.senderuin = paramString3;
    this.msg = paramString4;
    long l = paramLong1;
    if (paramLong1 <= 0L) {
      l = (int)MessageCache.a();
    }
    this.time = l;
    this.msgtype = paramInt1;
    this.istroop = paramInt2;
    this.msgseq = paramLong2;
  }
  
  public boolean isLongMsg()
  {
    return this.longMsgCount > 1;
  }
  
  public boolean isSend()
  {
    if ((AnonymousChatHelper.a(this)) && (AnonymousChatHelper.b(this))) {
      return true;
    }
    return MsgUtils.a(this.issend);
  }
  
  public boolean isSendFromLocal()
  {
    return MsgUtils.b(this.issend);
  }
  
  public boolean isSendFromOtherTerminal()
  {
    return MsgUtils.c(this.issend);
  }
  
  public boolean needVipBubble()
  {
    return (this.istroop == 0) || (this.istroop == 1) || (this.istroop == 3000);
  }
  
  protected void postRead()
  {
    try
    {
      if (this.versionCode > 0) {
        this.msg = new String(this.msgData, "UTF-8");
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  protected void postwrite() {}
  
  protected void prewrite()
  {
    if (this.msg != null) {}
    try
    {
      if (this.versionCode > 0) {
        this.msgData = this.msg.getBytes("UTF-8");
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  public void removeExtInfoToExtStr(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(this.extStr)) {
        return;
      }
      JSONObject localJSONObject = new JSONObject(this.extStr);
      if (localJSONObject.has(paramString))
      {
        localJSONObject.remove(paramString);
        this.extStr = localJSONObject.toString();
      }
      if (localJSONObject.length() == 0)
      {
        this.extStr = null;
        this.extLong = ((int)(this.extLong & 0xFFFFFFFE));
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void saveExtInfoToExtStr(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject;
      if (TextUtils.isEmpty(this.extStr))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put(paramString1, paramString2);
      }
      for (this.extStr = localJSONObject.toString();; this.extStr = localJSONObject.toString())
      {
        this.extLong |= 0x1;
        return;
        localJSONObject = new JSONObject(this.extStr);
        localJSONObject.put(paramString1, paramString2);
      }
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setPttStreamFlag(int paramInt)
  {
    this.extInt &= 0xFFFF0000;
    this.extInt = ((short)paramInt & 0xFFFF | this.extInt);
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.extInt &= 0xFFFF;
    this.extInt = (paramInt << 16 | this.extInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("-----Dump MessageRecord-----");
    localStringBuilder.append(",classname:").append(getClass().getSimpleName()).append(",selfUin:").append(this.selfuin).append(",friendUin:").append(this.frienduin).append(",senderUin:").append(this.senderuin).append(",shmsgseq:").append(this.shmsgseq).append(",uid:").append(this.msgUid).append(",time:").append(this.time).append(",isRead:").append(this.isread).append(",isSend:").append(this.issend).append(",extraFlag:").append(this.extraflag).append(",sendFailCode:").append(this.sendFailCode).append(",istroop:").append(this.istroop).append(",msgType:").append(this.msgtype).append(",msg:").append(Utils.a(this.msg)).append(",bubbleid:").append(this.vipBubbleID).append(",uniseq:").append(this.uniseq).append(",isMultiMsg:").append(this.isMultiMsg).append(",msgseq:").append(this.msgseq);
    if (isLongMsg()) {
      localStringBuilder.append(",longMsgId:").append(this.longMsgId).append(",longMsgCount:").append(this.longMsgCount).append(",longMsgIndex:").append(this.longMsgIndex);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageRecord
 * JD-Core Version:    0.7.0.1
 */