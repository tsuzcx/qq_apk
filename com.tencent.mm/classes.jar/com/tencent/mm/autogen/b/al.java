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

public abstract class al
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizEnterprise");
  public static final Column USERNAME;
  public static final Column jRA;
  public static final Column jRB;
  public static final Column jRC;
  public static final Column jRD;
  public static final Column jRE;
  public static final Column jRF;
  public static final Column jRG;
  public static final Column jRH;
  public static final Column jRI;
  public static final Column jRJ;
  public static final Column jRK;
  public static final Column jRL;
  public static final Column jRM;
  public static final Column jRx;
  public static final Column jRy;
  public static final Column jRz;
  private static final int jSd;
  private static final int jSe;
  private static final int jSf;
  private static final int jSg;
  private static final int jSh;
  private static final int jSi;
  private static final int jSj;
  private static final int jSk;
  private static final int jSl;
  private static final int jSm;
  private static final int jSn;
  private static final int jSo;
  private static final int jSp;
  private static final int jSq;
  private static final int jSr;
  private static final int jSs;
  private static final StorageObserverOwner<al> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetuserName = true;
  public boolean field_chatOpen;
  public boolean field_hide_colleage_invite;
  public boolean field_hide_create_chat;
  public boolean field_hide_mod_chat_member;
  public int field_qyUin;
  public byte[] field_raw_attrs;
  public boolean field_show_confirm;
  public boolean field_use_preset_banner_tips;
  public int field_userFlag;
  public String field_userName;
  public int field_userType;
  public int field_userUin;
  public long field_wwCorpId;
  public int field_wwExposeTimes;
  public int field_wwMaxExposeTimes;
  public int field_wwUnreadCnt;
  public long field_wwUserVid;
  private boolean jRN = true;
  private boolean jRO = true;
  private boolean jRP = true;
  private boolean jRQ = true;
  private boolean jRR = true;
  private boolean jRS = true;
  private boolean jRT = true;
  private boolean jRU = true;
  private boolean jRV = true;
  private boolean jRW = true;
  private boolean jRX = true;
  private boolean jRY = true;
  private boolean jRZ = true;
  private boolean jSa = true;
  private boolean jSb = true;
  private boolean jSc = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    jRx = new Column("qyUin", "int", TABLE.getName(), "");
    jRy = new Column("userUin", "int", TABLE.getName(), "");
    jRz = new Column("userFlag", "int", TABLE.getName(), "");
    jRA = new Column("wwExposeTimes", "int", TABLE.getName(), "");
    jRB = new Column("wwMaxExposeTimes", "int", TABLE.getName(), "");
    jRC = new Column("wwCorpId", "long", TABLE.getName(), "");
    jRD = new Column("wwUserVid", "long", TABLE.getName(), "");
    jRE = new Column("userType", "int", TABLE.getName(), "");
    jRF = new Column("chatOpen", "boolean", TABLE.getName(), "");
    jRG = new Column("wwUnreadCnt", "int", TABLE.getName(), "");
    jRH = new Column("show_confirm", "boolean", TABLE.getName(), "");
    jRI = new Column("use_preset_banner_tips", "boolean", TABLE.getName(), "");
    jRJ = new Column("hide_create_chat", "boolean", TABLE.getName(), "");
    jRK = new Column("hide_mod_chat_member", "boolean", TABLE.getName(), "");
    jRL = new Column("hide_colleage_invite", "boolean", TABLE.getName(), "");
    jRM = new Column("raw_attrs", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    userName_HASHCODE = "userName".hashCode();
    jSd = "qyUin".hashCode();
    jSe = "userUin".hashCode();
    jSf = "userFlag".hashCode();
    jSg = "wwExposeTimes".hashCode();
    jSh = "wwMaxExposeTimes".hashCode();
    jSi = "wwCorpId".hashCode();
    jSj = "wwUserVid".hashCode();
    jSk = "userType".hashCode();
    jSl = "chatOpen".hashCode();
    jSm = "wwUnreadCnt".hashCode();
    jSn = "show_confirm".hashCode();
    jSo = "use_preset_banner_tips".hashCode();
    jSp = "hide_create_chat".hashCode();
    jSq = "hide_mod_chat_member".hashCode();
    jSr = "hide_colleage_invite".hashCode();
    jSs = "raw_attrs".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "qyUin";
    localMAutoDBInfo.colsMap.put("qyUin", "INTEGER");
    localStringBuilder.append(" qyUin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "userUin";
    localMAutoDBInfo.colsMap.put("userUin", "INTEGER");
    localStringBuilder.append(" userUin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "userFlag";
    localMAutoDBInfo.colsMap.put("userFlag", "INTEGER");
    localStringBuilder.append(" userFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "wwExposeTimes";
    localMAutoDBInfo.colsMap.put("wwExposeTimes", "INTEGER");
    localStringBuilder.append(" wwExposeTimes INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "wwMaxExposeTimes";
    localMAutoDBInfo.colsMap.put("wwMaxExposeTimes", "INTEGER");
    localStringBuilder.append(" wwMaxExposeTimes INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "wwCorpId";
    localMAutoDBInfo.colsMap.put("wwCorpId", "LONG");
    localStringBuilder.append(" wwCorpId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "wwUserVid";
    localMAutoDBInfo.colsMap.put("wwUserVid", "LONG");
    localStringBuilder.append(" wwUserVid LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "userType";
    localMAutoDBInfo.colsMap.put("userType", "INTEGER");
    localStringBuilder.append(" userType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "chatOpen";
    localMAutoDBInfo.colsMap.put("chatOpen", "INTEGER");
    localStringBuilder.append(" chatOpen INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "wwUnreadCnt";
    localMAutoDBInfo.colsMap.put("wwUnreadCnt", "INTEGER default '0' ");
    localStringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "show_confirm";
    localMAutoDBInfo.colsMap.put("show_confirm", "INTEGER");
    localStringBuilder.append(" show_confirm INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "use_preset_banner_tips";
    localMAutoDBInfo.colsMap.put("use_preset_banner_tips", "INTEGER");
    localStringBuilder.append(" use_preset_banner_tips INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "hide_create_chat";
    localMAutoDBInfo.colsMap.put("hide_create_chat", "INTEGER");
    localStringBuilder.append(" hide_create_chat INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "hide_mod_chat_member";
    localMAutoDBInfo.colsMap.put("hide_mod_chat_member", "INTEGER");
    localStringBuilder.append(" hide_mod_chat_member INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "hide_colleage_invite";
    localMAutoDBInfo.colsMap.put("hide_colleage_invite", "INTEGER default 'true' ");
    localStringBuilder.append(" hide_colleage_invite INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "raw_attrs";
    localMAutoDBInfo.colsMap.put("raw_attrs", "BLOB");
    localStringBuilder.append(" raw_attrs BLOB");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("qyUin"))
    {
      this.field_qyUin = paramContentValues.getAsInteger("qyUin").intValue();
      if (paramBoolean) {
        this.jRN = true;
      }
    }
    if (paramContentValues.containsKey("userUin"))
    {
      this.field_userUin = paramContentValues.getAsInteger("userUin").intValue();
      if (paramBoolean) {
        this.jRO = true;
      }
    }
    if (paramContentValues.containsKey("userFlag"))
    {
      this.field_userFlag = paramContentValues.getAsInteger("userFlag").intValue();
      if (paramBoolean) {
        this.jRP = true;
      }
    }
    if (paramContentValues.containsKey("wwExposeTimes"))
    {
      this.field_wwExposeTimes = paramContentValues.getAsInteger("wwExposeTimes").intValue();
      if (paramBoolean) {
        this.jRQ = true;
      }
    }
    if (paramContentValues.containsKey("wwMaxExposeTimes"))
    {
      this.field_wwMaxExposeTimes = paramContentValues.getAsInteger("wwMaxExposeTimes").intValue();
      if (paramBoolean) {
        this.jRR = true;
      }
    }
    if (paramContentValues.containsKey("wwCorpId"))
    {
      this.field_wwCorpId = paramContentValues.getAsLong("wwCorpId").longValue();
      if (paramBoolean) {
        this.jRS = true;
      }
    }
    if (paramContentValues.containsKey("wwUserVid"))
    {
      this.field_wwUserVid = paramContentValues.getAsLong("wwUserVid").longValue();
      if (paramBoolean) {
        this.jRT = true;
      }
    }
    if (paramContentValues.containsKey("userType"))
    {
      this.field_userType = paramContentValues.getAsInteger("userType").intValue();
      if (paramBoolean) {
        this.jRU = true;
      }
    }
    if (paramContentValues.containsKey("chatOpen"))
    {
      if (paramContentValues.getAsInteger("chatOpen").intValue() == 0) {
        break label586;
      }
      bool1 = true;
      this.field_chatOpen = bool1;
      if (paramBoolean) {
        this.jRV = true;
      }
    }
    if (paramContentValues.containsKey("wwUnreadCnt"))
    {
      this.field_wwUnreadCnt = paramContentValues.getAsInteger("wwUnreadCnt").intValue();
      if (paramBoolean) {
        this.jRW = true;
      }
    }
    if (paramContentValues.containsKey("show_confirm"))
    {
      if (paramContentValues.getAsInteger("show_confirm").intValue() == 0) {
        break label591;
      }
      bool1 = true;
      label370:
      this.field_show_confirm = bool1;
      if (paramBoolean) {
        this.jRX = true;
      }
    }
    if (paramContentValues.containsKey("use_preset_banner_tips"))
    {
      if (paramContentValues.getAsInteger("use_preset_banner_tips").intValue() == 0) {
        break label596;
      }
      bool1 = true;
      label407:
      this.field_use_preset_banner_tips = bool1;
      if (paramBoolean) {
        this.jRY = true;
      }
    }
    if (paramContentValues.containsKey("hide_create_chat"))
    {
      if (paramContentValues.getAsInteger("hide_create_chat").intValue() == 0) {
        break label601;
      }
      bool1 = true;
      label444:
      this.field_hide_create_chat = bool1;
      if (paramBoolean) {
        this.jRZ = true;
      }
    }
    if (paramContentValues.containsKey("hide_mod_chat_member")) {
      if (paramContentValues.getAsInteger("hide_mod_chat_member").intValue() == 0) {
        break label606;
      }
    }
    label586:
    label591:
    label596:
    label601:
    label606:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_hide_mod_chat_member = bool1;
      if (paramBoolean) {
        this.jSa = true;
      }
      if (paramContentValues.containsKey("hide_colleage_invite"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("hide_colleage_invite").intValue() != 0) {
          bool1 = true;
        }
        this.field_hide_colleage_invite = bool1;
        if (paramBoolean) {
          this.jSb = true;
        }
      }
      if (paramContentValues.containsKey("raw_attrs"))
      {
        this.field_raw_attrs = paramContentValues.getAsByteArray("raw_attrs");
        if (paramBoolean) {
          this.jSc = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label370;
      bool1 = false;
      break label407;
      bool1 = false;
      break label444;
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
      if (userName_HASHCODE != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.__hadSetuserName = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jSd == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (jSe == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (jSf == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (jSg == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (jSh == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (jSi == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (jSj == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (jSk == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (jSl == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (jSm == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (jSn == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (jSo == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (jSp == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_create_chat = bool;
              break;
            }
          }
          if (jSq == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_mod_chat_member = bool;
              break;
            }
          }
          if (jSr == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_colleage_invite = bool;
              break;
            }
          }
          if (jSs == k) {
            this.field_raw_attrs = paramCursor.getBlob(i);
          } else if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.jRN) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.jRO) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.jRP) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.jRQ) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.jRR) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.jRS) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.jRT) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.jRU) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.jRV) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.jRW) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.jRX) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.jRY) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.jRZ) {
      localContentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
    }
    if (this.jSa) {
      localContentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
    }
    if (this.jSb) {
      localContentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
    }
    if (this.jSc) {
      localContentValues.put("raw_attrs", this.field_raw_attrs);
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
  
  public StorageObserverOwner<? extends al> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_userName;
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
 * Qualified Name:     com.tencent.mm.autogen.b.al
 * JD-Core Version:    0.7.0.1
 */