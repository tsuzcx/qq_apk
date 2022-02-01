package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cl
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderDbMention");
  public static final Column TYPE;
  public static final Column USERNAME;
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int id_HASHCODE;
  public static final Column jOO;
  private static final int jOU;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column jRp;
  private static final int jSZ;
  public static final Column jSx;
  public static final Column jTk;
  private static final int jTs;
  public static final Column keq;
  private static final int kfT;
  private static final int kiD;
  public static final Column kiu;
  private static final int kmN;
  public static final Column kmt;
  public static final Column kpC;
  public static final Column kpD;
  public static final Column kpE;
  public static final Column kpF;
  public static final Column kpG;
  public static final Column kpH;
  public static final Column kpI;
  public static final Column kpJ;
  public static final Column kpK;
  public static final Column kpL;
  public static final Column kpM;
  public static final Column kpN;
  public static final Column kpO;
  public static final Column kpP;
  public static final Column kpQ;
  public static final Column kpR;
  public static final Column kpS;
  public static final Column kpT;
  public static final Column kpU;
  public static final Column kpV;
  public static final Column kpW;
  public static final Column kpX;
  public static final Column kpY;
  private static final int kqA;
  private static final int kqB;
  private static final int kqC;
  private static final int kqD;
  private static final int kqE;
  private static final int kqF;
  private static final int kqG;
  private static final int kqH;
  private static final int kqI;
  private static final int kqJ;
  private static final int kqK;
  private static final int kqL;
  private static final int kqM;
  private static final int kqN;
  private static final int kqO;
  private static final int kqP;
  private static final int kqQ;
  private static final int kqR;
  private static final int kqS;
  private static final int kqT;
  private static final int kqU;
  private static final int kqx;
  private static final int kqy;
  private static final int kqz;
  private static final StorageObserverOwner<cl> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean __hadSettype = true;
  private boolean __hadSetusername = true;
  public bpe field_aggregatedContacts;
  public FinderContact field_authorContact;
  public String field_clientMsgId;
  public long field_commentId;
  public avc field_commentMentionedUser;
  public FinderContact field_contact;
  public String field_content;
  public int field_createTime;
  public String field_description;
  public int field_extFlag;
  public bpg field_extInfo;
  public long field_fansId;
  public int field_flag;
  public long field_followExpireTime;
  public long field_followId;
  public String field_headUrl;
  public long field_id;
  public long field_likeId;
  public int field_likeType;
  public int field_mediaType;
  public String field_nickname;
  public bqv field_notify;
  public long field_objectId;
  public String field_objectNonceId;
  public long field_objectType;
  public String field_refContent;
  public long field_refVideoObjectId;
  public String field_refVideoObjectNonceId;
  public int field_relationType;
  public String field_replayNickname;
  public String field_replayUsername;
  public FinderContact field_replyContact;
  public String field_thumbUrl;
  public int field_type;
  public int field_userVersion;
  public String field_username;
  private boolean jOR = true;
  private boolean jOX = true;
  private boolean jSL = true;
  private boolean jTo = true;
  private boolean kff = true;
  private boolean kiy = true;
  private boolean kmD = true;
  private boolean kpZ = true;
  private boolean kqa = true;
  private boolean kqb = true;
  private boolean kqc = true;
  private boolean kqd = true;
  private boolean kqe = true;
  private boolean kqf = true;
  private boolean kqg = true;
  private boolean kqh = true;
  private boolean kqi = true;
  private boolean kqj = true;
  private boolean kqk = true;
  private boolean kql = true;
  private boolean kqm = true;
  private boolean kqn = true;
  private boolean kqo = true;
  private boolean kqp = true;
  private boolean kqq = true;
  private boolean kqr = true;
  private boolean kqs = true;
  private boolean kqt = true;
  private boolean kqu = true;
  private boolean kqv = true;
  private boolean kqw = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kpC = new Column("headUrl", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "int", TABLE.getName(), "");
    keq = new Column("thumbUrl", "string", TABLE.getName(), "");
    ID = new Column("id", "long", TABLE.getName(), "");
    kpD = new Column("objectId", "long", TABLE.getName(), "");
    kpE = new Column("commentId", "long", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    kpF = new Column("refContent", "string", TABLE.getName(), "");
    kiu = new Column("extFlag", "int", TABLE.getName(), "");
    kpG = new Column("mediaType", "int", TABLE.getName(), "");
    jOO = new Column("description", "string", TABLE.getName(), "");
    kpH = new Column("notify", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderNotification");
    kpI = new Column("replayUsername", "string", TABLE.getName(), "");
    kpJ = new Column("replayNickname", "string", TABLE.getName(), "");
    kmt = new Column("objectNonceId", "string", TABLE.getName(), "");
    jRp = new Column("userVersion", "int", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    kpK = new Column("contact", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderContact");
    kpL = new Column("replyContact", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderContact");
    kpM = new Column("aggregatedContacts", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderMentionAggregatedContacts");
    kpN = new Column("followExpireTime", "long", TABLE.getName(), "");
    kpO = new Column("clientMsgId", "string", TABLE.getName(), "");
    kpP = new Column("followId", "long", TABLE.getName(), "");
    kpQ = new Column("objectType", "long", TABLE.getName(), "");
    kpR = new Column("refVideoObjectId", "long", TABLE.getName(), "");
    kpS = new Column("refVideoObjectNonceId", "string", TABLE.getName(), "");
    kpT = new Column("likeId", "long", TABLE.getName(), "");
    kpU = new Column("fansId", "long", TABLE.getName(), "");
    kpV = new Column("authorContact", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderContact");
    kpW = new Column("likeType", "int", TABLE.getName(), "");
    kpX = new Column("commentMentionedUser", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderCommentMentionedUser");
    kpY = new Column("relationType", "int", TABLE.getName(), "");
    jSx = new Column("extInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderMentionExtInfo");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON FinderDbMention(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON FinderDbMention(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON FinderDbMention(commentId)" };
    kqx = "headUrl".hashCode();
    jTs = "nickname".hashCode();
    type_HASHCODE = "type".hashCode();
    content_HASHCODE = "content".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    kfT = "thumbUrl".hashCode();
    id_HASHCODE = "id".hashCode();
    kqy = "objectId".hashCode();
    kqz = "commentId".hashCode();
    jOZ = "flag".hashCode();
    kqA = "refContent".hashCode();
    kiD = "extFlag".hashCode();
    kqB = "mediaType".hashCode();
    jOU = "description".hashCode();
    kqC = "notify".hashCode();
    kqD = "replayUsername".hashCode();
    kqE = "replayNickname".hashCode();
    kmN = "objectNonceId".hashCode();
    kqF = "userVersion".hashCode();
    username_HASHCODE = "username".hashCode();
    kqG = "contact".hashCode();
    kqH = "replyContact".hashCode();
    kqI = "aggregatedContacts".hashCode();
    kqJ = "followExpireTime".hashCode();
    kqK = "clientMsgId".hashCode();
    kqL = "followId".hashCode();
    kqM = "objectType".hashCode();
    kqN = "refVideoObjectId".hashCode();
    kqO = "refVideoObjectNonceId".hashCode();
    kqP = "likeId".hashCode();
    kqQ = "fansId".hashCode();
    kqR = "authorContact".hashCode();
    kqS = "likeType".hashCode();
    kqT = "commentMentionedUser".hashCode();
    kqU = "relationType".hashCode();
    jSZ = "extInfo".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[36];
    localMAutoDBInfo.columns = new String[37];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "headUrl";
    localMAutoDBInfo.colsMap.put("headUrl", "TEXT");
    localStringBuilder.append(" headUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "id";
    localMAutoDBInfo.colsMap.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "objectId";
    localMAutoDBInfo.colsMap.put("objectId", "LONG");
    localStringBuilder.append(" objectId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "commentId";
    localMAutoDBInfo.colsMap.put("commentId", "LONG");
    localStringBuilder.append(" commentId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "refContent";
    localMAutoDBInfo.colsMap.put("refContent", "TEXT");
    localStringBuilder.append(" refContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "extFlag";
    localMAutoDBInfo.colsMap.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "mediaType";
    localMAutoDBInfo.colsMap.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "notify";
    localMAutoDBInfo.colsMap.put("notify", "BLOB");
    localStringBuilder.append(" notify BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "replayUsername";
    localMAutoDBInfo.colsMap.put("replayUsername", "TEXT");
    localStringBuilder.append(" replayUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "replayNickname";
    localMAutoDBInfo.colsMap.put("replayNickname", "TEXT");
    localStringBuilder.append(" replayNickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "objectNonceId";
    localMAutoDBInfo.colsMap.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "userVersion";
    localMAutoDBInfo.colsMap.put("userVersion", "INTEGER");
    localStringBuilder.append(" userVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "contact";
    localMAutoDBInfo.colsMap.put("contact", "BLOB");
    localStringBuilder.append(" contact BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "replyContact";
    localMAutoDBInfo.colsMap.put("replyContact", "BLOB");
    localStringBuilder.append(" replyContact BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "aggregatedContacts";
    localMAutoDBInfo.colsMap.put("aggregatedContacts", "BLOB");
    localStringBuilder.append(" aggregatedContacts BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "followExpireTime";
    localMAutoDBInfo.colsMap.put("followExpireTime", "LONG");
    localStringBuilder.append(" followExpireTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "clientMsgId";
    localMAutoDBInfo.colsMap.put("clientMsgId", "TEXT");
    localStringBuilder.append(" clientMsgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "followId";
    localMAutoDBInfo.colsMap.put("followId", "LONG");
    localStringBuilder.append(" followId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "objectType";
    localMAutoDBInfo.colsMap.put("objectType", "LONG");
    localStringBuilder.append(" objectType LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "refVideoObjectId";
    localMAutoDBInfo.colsMap.put("refVideoObjectId", "LONG");
    localStringBuilder.append(" refVideoObjectId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "refVideoObjectNonceId";
    localMAutoDBInfo.colsMap.put("refVideoObjectNonceId", "TEXT");
    localStringBuilder.append(" refVideoObjectNonceId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "likeId";
    localMAutoDBInfo.colsMap.put("likeId", "LONG");
    localStringBuilder.append(" likeId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "fansId";
    localMAutoDBInfo.colsMap.put("fansId", "LONG");
    localStringBuilder.append(" fansId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "authorContact";
    localMAutoDBInfo.colsMap.put("authorContact", "BLOB");
    localStringBuilder.append(" authorContact BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "likeType";
    localMAutoDBInfo.colsMap.put("likeType", "INTEGER");
    localStringBuilder.append(" likeType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "commentMentionedUser";
    localMAutoDBInfo.colsMap.put("commentMentionedUser", "BLOB");
    localStringBuilder.append(" commentMentionedUser BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "relationType";
    localMAutoDBInfo.colsMap.put("relationType", "INTEGER");
    localStringBuilder.append(" relationType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localMAutoDBInfo.columns[36] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("headUrl"))
    {
      this.field_headUrl = paramContentValues.getAsString("headUrl");
      if (paramBoolean) {
        this.kpZ = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsInteger("createTime").intValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("thumbUrl"))
    {
      this.field_thumbUrl = paramContentValues.getAsString("thumbUrl");
      if (paramBoolean) {
        this.kff = true;
      }
    }
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsLong("id").longValue();
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("objectId"))
    {
      this.field_objectId = paramContentValues.getAsLong("objectId").longValue();
      if (paramBoolean) {
        this.kqa = true;
      }
    }
    if (paramContentValues.containsKey("commentId"))
    {
      this.field_commentId = paramContentValues.getAsLong("commentId").longValue();
      if (paramBoolean) {
        this.kqb = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("refContent"))
    {
      this.field_refContent = paramContentValues.getAsString("refContent");
      if (paramBoolean) {
        this.kqc = true;
      }
    }
    if (paramContentValues.containsKey("extFlag"))
    {
      this.field_extFlag = paramContentValues.getAsInteger("extFlag").intValue();
      if (paramBoolean) {
        this.kiy = true;
      }
    }
    if (paramContentValues.containsKey("mediaType"))
    {
      this.field_mediaType = paramContentValues.getAsInteger("mediaType").intValue();
      if (paramBoolean) {
        this.kqd = true;
      }
    }
    if (paramContentValues.containsKey("description"))
    {
      this.field_description = paramContentValues.getAsString("description");
      if (paramBoolean) {
        this.jOR = true;
      }
    }
    if (paramContentValues.containsKey("notify")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("notify");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_notify = ((bqv)new bqv().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kqe = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("replayUsername"))
    {
      this.field_replayUsername = paramContentValues.getAsString("replayUsername");
      if (paramBoolean) {
        this.kqf = true;
      }
    }
    if (paramContentValues.containsKey("replayNickname"))
    {
      this.field_replayNickname = paramContentValues.getAsString("replayNickname");
      if (paramBoolean) {
        this.kqg = true;
      }
    }
    if (paramContentValues.containsKey("objectNonceId"))
    {
      this.field_objectNonceId = paramContentValues.getAsString("objectNonceId");
      if (paramBoolean) {
        this.kmD = true;
      }
    }
    if (paramContentValues.containsKey("userVersion"))
    {
      this.field_userVersion = paramContentValues.getAsInteger("userVersion").intValue();
      if (paramBoolean) {
        this.kqh = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("contact")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("contact");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_contact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kqi = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("replyContact")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("replyContact");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_replyContact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kqj = true;
        }
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException3.getMessage());
      }
    }
    if (paramContentValues.containsKey("aggregatedContacts")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("aggregatedContacts");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_aggregatedContacts = ((bpe)new bpe().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kqk = true;
        }
      }
    }
    catch (IOException localIOException4)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException4.getMessage());
      }
    }
    if (paramContentValues.containsKey("followExpireTime"))
    {
      this.field_followExpireTime = paramContentValues.getAsLong("followExpireTime").longValue();
      if (paramBoolean) {
        this.kql = true;
      }
    }
    if (paramContentValues.containsKey("clientMsgId"))
    {
      this.field_clientMsgId = paramContentValues.getAsString("clientMsgId");
      if (paramBoolean) {
        this.kqm = true;
      }
    }
    if (paramContentValues.containsKey("followId"))
    {
      this.field_followId = paramContentValues.getAsLong("followId").longValue();
      if (paramBoolean) {
        this.kqn = true;
      }
    }
    if (paramContentValues.containsKey("objectType"))
    {
      this.field_objectType = paramContentValues.getAsLong("objectType").longValue();
      if (paramBoolean) {
        this.kqo = true;
      }
    }
    if (paramContentValues.containsKey("refVideoObjectId"))
    {
      this.field_refVideoObjectId = paramContentValues.getAsLong("refVideoObjectId").longValue();
      if (paramBoolean) {
        this.kqp = true;
      }
    }
    if (paramContentValues.containsKey("refVideoObjectNonceId"))
    {
      this.field_refVideoObjectNonceId = paramContentValues.getAsString("refVideoObjectNonceId");
      if (paramBoolean) {
        this.kqq = true;
      }
    }
    if (paramContentValues.containsKey("likeId"))
    {
      this.field_likeId = paramContentValues.getAsLong("likeId").longValue();
      if (paramBoolean) {
        this.kqr = true;
      }
    }
    if (paramContentValues.containsKey("fansId"))
    {
      this.field_fansId = paramContentValues.getAsLong("fansId").longValue();
      if (paramBoolean) {
        this.kqs = true;
      }
    }
    if (paramContentValues.containsKey("authorContact")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("authorContact");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_authorContact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kqt = true;
        }
      }
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException5.getMessage());
      }
    }
    if (paramContentValues.containsKey("likeType"))
    {
      this.field_likeType = paramContentValues.getAsInteger("likeType").intValue();
      if (paramBoolean) {
        this.kqu = true;
      }
    }
    if (paramContentValues.containsKey("commentMentionedUser")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("commentMentionedUser");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_commentMentionedUser = ((avc)new avc().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kqv = true;
        }
      }
    }
    catch (IOException localIOException6)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException6.getMessage());
      }
    }
    if (paramContentValues.containsKey("relationType"))
    {
      this.field_relationType = paramContentValues.getAsInteger("relationType").intValue();
      if (paramBoolean) {
        this.kqw = true;
      }
    }
    if (paramContentValues.containsKey("extInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("extInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_extInfo = ((bpg)new bpg().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.jSL = true;
        }
      }
    }
    catch (IOException localIOException7)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException7.getMessage());
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (kqx != k) {
        break label60;
      }
      this.field_headUrl = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (kfT == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (id_HASHCODE == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (kqy == k) {
        this.field_objectId = paramCursor.getLong(i);
      } else if (kqz == k) {
        this.field_commentId = paramCursor.getLong(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (kqA == k) {
        this.field_refContent = paramCursor.getString(i);
      } else if (kiD == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (kqB == k) {
        this.field_mediaType = paramCursor.getInt(i);
      } else if (jOU == k) {
        this.field_description = paramCursor.getString(i);
      } else if (kqC == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_notify = ((bqv)new bqv().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException1.getMessage());
        }
      } else if (kqD == k) {
        this.field_replayUsername = paramCursor.getString(i);
      } else if (kqE == k) {
        this.field_replayNickname = paramCursor.getString(i);
      } else if (kmN == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (kqF == k) {
        this.field_userVersion = paramCursor.getInt(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (kqG == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_contact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException2.getMessage());
        }
      } else if (kqH == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_replyContact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException3.getMessage());
        }
      } else if (kqI == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_aggregatedContacts = ((bpe)new bpe().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException4.getMessage());
        }
      } else if (kqJ == k) {
        this.field_followExpireTime = paramCursor.getLong(i);
      } else if (kqK == k) {
        this.field_clientMsgId = paramCursor.getString(i);
      } else if (kqL == k) {
        this.field_followId = paramCursor.getLong(i);
      } else if (kqM == k) {
        this.field_objectType = paramCursor.getLong(i);
      } else if (kqN == k) {
        this.field_refVideoObjectId = paramCursor.getLong(i);
      } else if (kqO == k) {
        this.field_refVideoObjectNonceId = paramCursor.getString(i);
      } else if (kqP == k) {
        this.field_likeId = paramCursor.getLong(i);
      } else if (kqQ == k) {
        this.field_fansId = paramCursor.getLong(i);
      } else if (kqR == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_authorContact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException5.getMessage());
        }
      } else if (kqS == k) {
        this.field_likeType = paramCursor.getInt(i);
      } else if (kqT == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_commentMentionedUser = ((avc)new avc().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException6.getMessage());
        }
      } else if (kqU == k) {
        this.field_relationType = paramCursor.getInt(i);
      } else if (jSZ == k) {
        try
        {
          byte[] arrayOfByte7 = paramCursor.getBlob(i);
          if ((arrayOfByte7 == null) || (arrayOfByte7.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((bpg)new bpg().parseFrom(arrayOfByte7));
        }
        catch (IOException localIOException7)
        {
          Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException7.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kpZ) {
      localContentValues.put("headUrl", this.field_headUrl);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.kff) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.__hadSetid) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.kqa) {
      localContentValues.put("objectId", Long.valueOf(this.field_objectId));
    }
    if (this.kqb) {
      localContentValues.put("commentId", Long.valueOf(this.field_commentId));
    }
    if (this.jOX) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.kqc) {
      localContentValues.put("refContent", this.field_refContent);
    }
    if (this.kiy) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.kqd) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.jOR) {
      localContentValues.put("description", this.field_description);
    }
    if ((this.kqe) && (this.field_notify != null)) {}
    try
    {
      localContentValues.put("notify", this.field_notify.toByteArray());
      if (this.kqf) {
        localContentValues.put("replayUsername", this.field_replayUsername);
      }
      if (this.kqg) {
        localContentValues.put("replayNickname", this.field_replayNickname);
      }
      if (this.kmD) {
        localContentValues.put("objectNonceId", this.field_objectNonceId);
      }
      if (this.kqh) {
        localContentValues.put("userVersion", Integer.valueOf(this.field_userVersion));
      }
      if (this.__hadSetusername) {
        localContentValues.put("username", this.field_username);
      }
      if ((!this.kqi) || (this.field_contact == null)) {}
    }
    catch (IOException localIOException6)
    {
      try
      {
        localContentValues.put("contact", this.field_contact.toByteArray());
        if ((!this.kqj) || (this.field_replyContact == null)) {}
      }
      catch (IOException localIOException6)
      {
        try
        {
          localContentValues.put("replyContact", this.field_replyContact.toByteArray());
          if ((!this.kqk) || (this.field_aggregatedContacts == null)) {}
        }
        catch (IOException localIOException6)
        {
          try
          {
            localContentValues.put("aggregatedContacts", this.field_aggregatedContacts.toByteArray());
            if (this.kql) {
              localContentValues.put("followExpireTime", Long.valueOf(this.field_followExpireTime));
            }
            if (this.kqm) {
              localContentValues.put("clientMsgId", this.field_clientMsgId);
            }
            if (this.kqn) {
              localContentValues.put("followId", Long.valueOf(this.field_followId));
            }
            if (this.kqo) {
              localContentValues.put("objectType", Long.valueOf(this.field_objectType));
            }
            if (this.kqp) {
              localContentValues.put("refVideoObjectId", Long.valueOf(this.field_refVideoObjectId));
            }
            if (this.kqq) {
              localContentValues.put("refVideoObjectNonceId", this.field_refVideoObjectNonceId);
            }
            if (this.kqr) {
              localContentValues.put("likeId", Long.valueOf(this.field_likeId));
            }
            if (this.kqs) {
              localContentValues.put("fansId", Long.valueOf(this.field_fansId));
            }
            if ((!this.kqt) || (this.field_authorContact == null)) {}
          }
          catch (IOException localIOException6)
          {
            try
            {
              localContentValues.put("authorContact", this.field_authorContact.toByteArray());
              if (this.kqu) {
                localContentValues.put("likeType", Integer.valueOf(this.field_likeType));
              }
              if ((!this.kqv) || (this.field_commentMentionedUser == null)) {}
            }
            catch (IOException localIOException6)
            {
              try
              {
                localContentValues.put("commentMentionedUser", this.field_commentMentionedUser.toByteArray());
                if (this.kqw) {
                  localContentValues.put("relationType", Integer.valueOf(this.field_relationType));
                }
                if ((!this.jSL) || (this.field_extInfo == null)) {}
              }
              catch (IOException localIOException6)
              {
                try
                {
                  for (;;)
                  {
                    localContentValues.put("extInfo", this.field_extInfo.toByteArray());
                    if (this.systemRowid > 0L) {
                      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
                    }
                    return localContentValues;
                    localIOException1 = localIOException1;
                    Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException1.getMessage());
                    continue;
                    localIOException2 = localIOException2;
                    Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException2.getMessage());
                    continue;
                    localIOException3 = localIOException3;
                    Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException3.getMessage());
                    continue;
                    localIOException4 = localIOException4;
                    Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException4.getMessage());
                    continue;
                    localIOException5 = localIOException5;
                    Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException5.getMessage());
                  }
                  localIOException6 = localIOException6;
                  Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException6.getMessage());
                }
                catch (IOException localIOException7)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.SDK.BaseFinderDbMention", localIOException7.getMessage());
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends cl> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cl
 * JD-Core Version:    0.7.0.1
 */