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

public abstract class dy
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GoogleFriend");
  public static final Column USERNAME;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jRo;
  public static final Column jTk;
  private static final int jTs;
  public static final Column kAA;
  public static final Column kAB;
  private static final int kAP;
  private static final int kAQ;
  private static final int kAR;
  private static final int kAS;
  private static final int kAT;
  private static final int kAU;
  private static final int kAV;
  private static final int kAW;
  private static final int kAX;
  private static final int kAY;
  private static final int kAZ;
  public static final Column kAq;
  public static final Column kAr;
  public static final Column kAs;
  public static final Column kAt;
  public static final Column kAu;
  public static final Column kAv;
  public static final Column kAw;
  public static final Column kAx;
  public static final Column kAy;
  public static final Column kAz;
  private static final int kBa;
  private static final int kBb;
  private static final StorageObserverOwner<dy> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_big_url;
  public String field_contecttype;
  public int field_googlecgistatus;
  public String field_googlegmail;
  public String field_googleid;
  public String field_googleitemid;
  public String field_googlename;
  public String field_googlenamepy;
  public String field_googlephotourl;
  public String field_nickname;
  public String field_nicknameqp;
  public int field_ret;
  public String field_small_url;
  public int field_status;
  public String field_username;
  public String field_usernamepy;
  private boolean jIC = true;
  private boolean jTo = true;
  private boolean kAC = true;
  private boolean kAD = true;
  private boolean kAE = true;
  private boolean kAF = true;
  private boolean kAG = true;
  private boolean kAH = true;
  private boolean kAI = true;
  private boolean kAJ = true;
  private boolean kAK = true;
  private boolean kAL = true;
  private boolean kAM = true;
  private boolean kAN = true;
  private boolean kAO = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kAq = new Column("googleid", "string", TABLE.getName(), "");
    kAr = new Column("googlename", "string", TABLE.getName(), "");
    kAs = new Column("googlephotourl", "string", TABLE.getName(), "");
    kAt = new Column("googlegmail", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kAu = new Column("nicknameqp", "string", TABLE.getName(), "");
    jRo = new Column("usernamepy", "string", TABLE.getName(), "");
    kAv = new Column("small_url", "string", TABLE.getName(), "");
    kAw = new Column("big_url", "string", TABLE.getName(), "");
    kAx = new Column("ret", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kAy = new Column("googleitemid", "string", TABLE.getName(), "");
    kAz = new Column("googlecgistatus", "int", TABLE.getName(), "");
    kAA = new Column("contecttype", "string", TABLE.getName(), "");
    kAB = new Column("googlenamepy", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kAP = "googleid".hashCode();
    kAQ = "googlename".hashCode();
    kAR = "googlephotourl".hashCode();
    kAS = "googlegmail".hashCode();
    username_HASHCODE = "username".hashCode();
    jTs = "nickname".hashCode();
    kAT = "nicknameqp".hashCode();
    kAU = "usernamepy".hashCode();
    kAV = "small_url".hashCode();
    kAW = "big_url".hashCode();
    kAX = "ret".hashCode();
    jIF = "status".hashCode();
    kAY = "googleitemid".hashCode();
    kAZ = "googlecgistatus".hashCode();
    kBa = "contecttype".hashCode();
    kBb = "googlenamepy".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[16];
    localMAutoDBInfo.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "googleid";
    localMAutoDBInfo.colsMap.put("googleid", "TEXT");
    localStringBuilder.append(" googleid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "googlename";
    localMAutoDBInfo.colsMap.put("googlename", "TEXT");
    localStringBuilder.append(" googlename TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "googlephotourl";
    localMAutoDBInfo.colsMap.put("googlephotourl", "TEXT");
    localStringBuilder.append(" googlephotourl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "googlegmail";
    localMAutoDBInfo.colsMap.put("googlegmail", "TEXT");
    localStringBuilder.append(" googlegmail TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "nicknameqp";
    localMAutoDBInfo.colsMap.put("nicknameqp", "TEXT");
    localStringBuilder.append(" nicknameqp TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "usernamepy";
    localMAutoDBInfo.colsMap.put("usernamepy", "TEXT");
    localStringBuilder.append(" usernamepy TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "small_url";
    localMAutoDBInfo.colsMap.put("small_url", "TEXT");
    localStringBuilder.append(" small_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "big_url";
    localMAutoDBInfo.colsMap.put("big_url", "TEXT");
    localStringBuilder.append(" big_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "ret";
    localMAutoDBInfo.colsMap.put("ret", "INTEGER");
    localStringBuilder.append(" ret INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "googleitemid";
    localMAutoDBInfo.colsMap.put("googleitemid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "googleitemid";
    localMAutoDBInfo.columns[13] = "googlecgistatus";
    localMAutoDBInfo.colsMap.put("googlecgistatus", "INTEGER default '2' ");
    localStringBuilder.append(" googlecgistatus INTEGER default '2' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "contecttype";
    localMAutoDBInfo.colsMap.put("contecttype", "TEXT");
    localStringBuilder.append(" contecttype TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "googlenamepy";
    localMAutoDBInfo.colsMap.put("googlenamepy", "TEXT");
    localStringBuilder.append(" googlenamepy TEXT");
    localMAutoDBInfo.columns[16] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("googleid"))
    {
      this.field_googleid = paramContentValues.getAsString("googleid");
      if (paramBoolean) {
        this.kAC = true;
      }
    }
    if (paramContentValues.containsKey("googlename"))
    {
      this.field_googlename = paramContentValues.getAsString("googlename");
      if (paramBoolean) {
        this.kAD = true;
      }
    }
    if (paramContentValues.containsKey("googlephotourl"))
    {
      this.field_googlephotourl = paramContentValues.getAsString("googlephotourl");
      if (paramBoolean) {
        this.kAE = true;
      }
    }
    if (paramContentValues.containsKey("googlegmail"))
    {
      this.field_googlegmail = paramContentValues.getAsString("googlegmail");
      if (paramBoolean) {
        this.kAF = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("nicknameqp"))
    {
      this.field_nicknameqp = paramContentValues.getAsString("nicknameqp");
      if (paramBoolean) {
        this.kAG = true;
      }
    }
    if (paramContentValues.containsKey("usernamepy"))
    {
      this.field_usernamepy = paramContentValues.getAsString("usernamepy");
      if (paramBoolean) {
        this.kAH = true;
      }
    }
    if (paramContentValues.containsKey("small_url"))
    {
      this.field_small_url = paramContentValues.getAsString("small_url");
      if (paramBoolean) {
        this.kAI = true;
      }
    }
    if (paramContentValues.containsKey("big_url"))
    {
      this.field_big_url = paramContentValues.getAsString("big_url");
      if (paramBoolean) {
        this.kAJ = true;
      }
    }
    if (paramContentValues.containsKey("ret"))
    {
      this.field_ret = paramContentValues.getAsInteger("ret").intValue();
      if (paramBoolean) {
        this.kAK = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("googleitemid"))
    {
      this.field_googleitemid = paramContentValues.getAsString("googleitemid");
      if (paramBoolean) {
        this.kAL = true;
      }
    }
    if (paramContentValues.containsKey("googlecgistatus"))
    {
      this.field_googlecgistatus = paramContentValues.getAsInteger("googlecgistatus").intValue();
      if (paramBoolean) {
        this.kAM = true;
      }
    }
    if (paramContentValues.containsKey("contecttype"))
    {
      this.field_contecttype = paramContentValues.getAsString("contecttype");
      if (paramBoolean) {
        this.kAN = true;
      }
    }
    if (paramContentValues.containsKey("googlenamepy"))
    {
      this.field_googlenamepy = paramContentValues.getAsString("googlenamepy");
      if (paramBoolean) {
        this.kAO = true;
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
      if (kAP != k) {
        break label60;
      }
      this.field_googleid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kAQ == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (kAR == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (kAS == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (username_HASHCODE == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (jTs == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (kAT == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (kAU == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (kAV == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (kAW == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (kAX == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (jIF == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (kAY == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.kAL = true;
      }
      else if (kAZ == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (kBa == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (kBb == k)
      {
        this.field_googlenamepy = paramCursor.getString(i);
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
    if (this.kAC) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.kAD) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.kAE) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.kAF) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.kAG) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.kAH) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.kAI) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.kAJ) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.kAK) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kAL) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.kAM) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.kAN) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.kAO) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
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
  
  public StorageObserverOwner<? extends dy> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_googleitemid;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dy
 * JD-Core Version:    0.7.0.1
 */