package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fb
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LocalRedPacketStoryInfo");
  public static final Column jON;
  public static final Column jOO;
  private static final int jOT;
  private static final int jOU;
  public static final Column jUR;
  private static final int jVD;
  public static final Column kIS;
  public static final Column kIT;
  public static final Column kIU;
  public static final Column kIV;
  public static final Column kIW;
  public static final Column kIX;
  public static final Column kIY;
  public static final Column kIZ;
  private static final int kJA;
  private static final int kJB;
  public static final Column kJa;
  public static final Column kJb;
  public static final Column kJc;
  public static final Column kJd;
  private static final int kJq;
  private static final int kJr;
  private static final int kJs;
  private static final int kJt;
  private static final int kJu;
  private static final int kJv;
  private static final int kJw;
  private static final int kJx;
  private static final int kJy;
  private static final int kJz;
  private static final StorageObserverOwner<fb> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_action_app_nickname;
  public String field_action_app_username;
  public int field_action_emotion_designer_uin;
  public String field_action_jump_text;
  public int field_action_type;
  public String field_action_url;
  public String field_corp_name;
  public String field_description;
  public String field_logo_md5;
  public String field_logo_url;
  public String field_packet_id;
  public String field_same_receive_link;
  public int field_subtype_id;
  public String field_title;
  public long field_update_time;
  private boolean jOQ = true;
  private boolean jOR = true;
  private boolean jVk = true;
  private boolean kJe = true;
  private boolean kJf = true;
  private boolean kJg = true;
  private boolean kJh = true;
  private boolean kJi = true;
  private boolean kJj = true;
  private boolean kJk = true;
  private boolean kJl = true;
  private boolean kJm = true;
  private boolean kJn = true;
  private boolean kJo = true;
  private boolean kJp = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    jUR = new Column("logo_url", "string", TABLE.getName(), "");
    kIS = new Column("logo_md5", "string", TABLE.getName(), "");
    jOO = new Column("description", "string", TABLE.getName(), "");
    kIT = new Column("corp_name", "string", TABLE.getName(), "");
    kIU = new Column("action_type", "int", TABLE.getName(), "");
    kIV = new Column("action_url", "string", TABLE.getName(), "");
    kIW = new Column("action_app_username", "string", TABLE.getName(), "");
    kIX = new Column("action_app_nickname", "string", TABLE.getName(), "");
    kIY = new Column("packet_id", "string", TABLE.getName(), "");
    kIZ = new Column("update_time", "long", TABLE.getName(), "");
    kJa = new Column("subtype_id", "int", TABLE.getName(), "");
    kJb = new Column("action_emotion_designer_uin", "int", TABLE.getName(), "");
    kJc = new Column("action_jump_text", "string", TABLE.getName(), "");
    kJd = new Column("same_receive_link", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS LocalRedPacketStoryInfoPacketIdIndex ON LocalRedPacketStoryInfo(packet_id)" };
    jOT = "title".hashCode();
    jVD = "logo_url".hashCode();
    kJq = "logo_md5".hashCode();
    jOU = "description".hashCode();
    kJr = "corp_name".hashCode();
    kJs = "action_type".hashCode();
    kJt = "action_url".hashCode();
    kJu = "action_app_username".hashCode();
    kJv = "action_app_nickname".hashCode();
    kJw = "packet_id".hashCode();
    kJx = "update_time".hashCode();
    kJy = "subtype_id".hashCode();
    kJz = "action_emotion_designer_uin".hashCode();
    kJA = "action_jump_text".hashCode();
    kJB = "same_receive_link".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[15];
    localMAutoDBInfo.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "logo_url";
    localMAutoDBInfo.colsMap.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "logo_md5";
    localMAutoDBInfo.colsMap.put("logo_md5", "TEXT");
    localStringBuilder.append(" logo_md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "corp_name";
    localMAutoDBInfo.colsMap.put("corp_name", "TEXT");
    localStringBuilder.append(" corp_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "action_type";
    localMAutoDBInfo.colsMap.put("action_type", "INTEGER");
    localStringBuilder.append(" action_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "action_url";
    localMAutoDBInfo.colsMap.put("action_url", "TEXT");
    localStringBuilder.append(" action_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "action_app_username";
    localMAutoDBInfo.colsMap.put("action_app_username", "TEXT");
    localStringBuilder.append(" action_app_username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "action_app_nickname";
    localMAutoDBInfo.colsMap.put("action_app_nickname", "TEXT");
    localStringBuilder.append(" action_app_nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "packet_id";
    localMAutoDBInfo.colsMap.put("packet_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packet_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "packet_id";
    localMAutoDBInfo.columns[10] = "update_time";
    localMAutoDBInfo.colsMap.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "subtype_id";
    localMAutoDBInfo.colsMap.put("subtype_id", "INTEGER");
    localStringBuilder.append(" subtype_id INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "action_emotion_designer_uin";
    localMAutoDBInfo.colsMap.put("action_emotion_designer_uin", "INTEGER");
    localStringBuilder.append(" action_emotion_designer_uin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "action_jump_text";
    localMAutoDBInfo.colsMap.put("action_jump_text", "TEXT");
    localStringBuilder.append(" action_jump_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "same_receive_link";
    localMAutoDBInfo.colsMap.put("same_receive_link", "TEXT");
    localStringBuilder.append(" same_receive_link TEXT");
    localMAutoDBInfo.columns[15] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("logo_url"))
    {
      this.field_logo_url = paramContentValues.getAsString("logo_url");
      if (paramBoolean) {
        this.jVk = true;
      }
    }
    if (paramContentValues.containsKey("logo_md5"))
    {
      this.field_logo_md5 = paramContentValues.getAsString("logo_md5");
      if (paramBoolean) {
        this.kJe = true;
      }
    }
    if (paramContentValues.containsKey("description"))
    {
      this.field_description = paramContentValues.getAsString("description");
      if (paramBoolean) {
        this.jOR = true;
      }
    }
    if (paramContentValues.containsKey("corp_name"))
    {
      this.field_corp_name = paramContentValues.getAsString("corp_name");
      if (paramBoolean) {
        this.kJf = true;
      }
    }
    if (paramContentValues.containsKey("action_type"))
    {
      this.field_action_type = paramContentValues.getAsInteger("action_type").intValue();
      if (paramBoolean) {
        this.kJg = true;
      }
    }
    if (paramContentValues.containsKey("action_url"))
    {
      this.field_action_url = paramContentValues.getAsString("action_url");
      if (paramBoolean) {
        this.kJh = true;
      }
    }
    if (paramContentValues.containsKey("action_app_username"))
    {
      this.field_action_app_username = paramContentValues.getAsString("action_app_username");
      if (paramBoolean) {
        this.kJi = true;
      }
    }
    if (paramContentValues.containsKey("action_app_nickname"))
    {
      this.field_action_app_nickname = paramContentValues.getAsString("action_app_nickname");
      if (paramBoolean) {
        this.kJj = true;
      }
    }
    if (paramContentValues.containsKey("packet_id"))
    {
      this.field_packet_id = paramContentValues.getAsString("packet_id");
      if (paramBoolean) {
        this.kJk = true;
      }
    }
    if (paramContentValues.containsKey("update_time"))
    {
      this.field_update_time = paramContentValues.getAsLong("update_time").longValue();
      if (paramBoolean) {
        this.kJl = true;
      }
    }
    if (paramContentValues.containsKey("subtype_id"))
    {
      this.field_subtype_id = paramContentValues.getAsInteger("subtype_id").intValue();
      if (paramBoolean) {
        this.kJm = true;
      }
    }
    if (paramContentValues.containsKey("action_emotion_designer_uin"))
    {
      this.field_action_emotion_designer_uin = paramContentValues.getAsInteger("action_emotion_designer_uin").intValue();
      if (paramBoolean) {
        this.kJn = true;
      }
    }
    if (paramContentValues.containsKey("action_jump_text"))
    {
      this.field_action_jump_text = paramContentValues.getAsString("action_jump_text");
      if (paramBoolean) {
        this.kJo = true;
      }
    }
    if (paramContentValues.containsKey("same_receive_link"))
    {
      this.field_same_receive_link = paramContentValues.getAsString("same_receive_link");
      if (paramBoolean) {
        this.kJp = true;
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
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (jOT != k) {
        break label60;
      }
      this.field_title = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jVD == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (kJq == k)
      {
        this.field_logo_md5 = paramCursor.getString(i);
      }
      else if (jOU == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (kJr == k)
      {
        this.field_corp_name = paramCursor.getString(i);
      }
      else if (kJs == k)
      {
        this.field_action_type = paramCursor.getInt(i);
      }
      else if (kJt == k)
      {
        this.field_action_url = paramCursor.getString(i);
      }
      else if (kJu == k)
      {
        this.field_action_app_username = paramCursor.getString(i);
      }
      else if (kJv == k)
      {
        this.field_action_app_nickname = paramCursor.getString(i);
      }
      else if (kJw == k)
      {
        this.field_packet_id = paramCursor.getString(i);
        this.kJk = true;
      }
      else if (kJx == k)
      {
        this.field_update_time = paramCursor.getLong(i);
      }
      else if (kJy == k)
      {
        this.field_subtype_id = paramCursor.getInt(i);
      }
      else if (kJz == k)
      {
        this.field_action_emotion_designer_uin = paramCursor.getInt(i);
      }
      else if (kJA == k)
      {
        this.field_action_jump_text = paramCursor.getString(i);
      }
      else if (kJB == k)
      {
        this.field_same_receive_link = paramCursor.getString(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.jVk) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.kJe) {
      localContentValues.put("logo_md5", this.field_logo_md5);
    }
    if (this.jOR) {
      localContentValues.put("description", this.field_description);
    }
    if (this.kJf) {
      localContentValues.put("corp_name", this.field_corp_name);
    }
    if (this.kJg) {
      localContentValues.put("action_type", Integer.valueOf(this.field_action_type));
    }
    if (this.kJh) {
      localContentValues.put("action_url", this.field_action_url);
    }
    if (this.kJi) {
      localContentValues.put("action_app_username", this.field_action_app_username);
    }
    if (this.kJj) {
      localContentValues.put("action_app_nickname", this.field_action_app_nickname);
    }
    if (this.kJk) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.kJl) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.kJm) {
      localContentValues.put("subtype_id", Integer.valueOf(this.field_subtype_id));
    }
    if (this.kJn) {
      localContentValues.put("action_emotion_designer_uin", Integer.valueOf(this.field_action_emotion_designer_uin));
    }
    if (this.kJo) {
      localContentValues.put("action_jump_text", this.field_action_jump_text);
    }
    if (this.kJp) {
      localContentValues.put("same_receive_link", this.field_same_receive_link);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends fb> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_packet_id;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.fb
 * JD-Core Version:    0.7.0.1
 */