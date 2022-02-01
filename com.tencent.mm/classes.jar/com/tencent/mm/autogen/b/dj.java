package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.LbsInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.TagInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.UserRole;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dj
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameChatRoomContact");
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  public static final Column jTk;
  public static final Column kna;
  private static final int kwL;
  private static final int kwM;
  private static final int kwN;
  private static final int kwO;
  private static final int kwP;
  private static final int kwQ;
  private static final int kwR;
  private static final int kwS;
  private static final int kwT;
  private static final int kwU;
  private static final int kwV;
  private static final int kwW;
  private static final int kwX;
  private static final int kwY;
  private static final int kwZ;
  public static final Column kwh;
  public static final Column kwi;
  public static final Column kwj;
  public static final Column kwk;
  public static final Column kwl;
  public static final Column kwm;
  public static final Column kwn;
  public static final Column kwo;
  public static final Column kwp;
  public static final Column kwq;
  public static final Column kwr;
  public static final Column kws;
  public static final Column kwt;
  public static final Column kwu;
  private static final int kxa;
  private static final StorageObserverOwner<dj> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetuserName = true;
  public String field_avatarURL;
  public boolean field_canAtAll;
  public boolean field_canBeAt;
  public boolean field_canBeKicked;
  public boolean field_canKickMember;
  public boolean field_isAuthorized;
  public boolean field_isRobot;
  public JumpInfo field_jumpInfo;
  public LbsInfo field_lbsInfo;
  public String field_nickName;
  public byte[] field_rawPbData;
  public int field_role;
  public String field_roomName;
  public int field_sex;
  public TagInfo field_tagInfo;
  public long field_updateTime;
  public String field_userName;
  public UserRole field_userRole;
  private boolean kwA = true;
  private boolean kwB = true;
  private boolean kwC = true;
  private boolean kwD = true;
  private boolean kwE = true;
  private boolean kwF = true;
  private boolean kwG = true;
  private boolean kwH = true;
  private boolean kwI = true;
  private boolean kwJ = true;
  private boolean kwK = true;
  private boolean kwv = true;
  private boolean kww = true;
  private boolean kwx = true;
  private boolean kwy = true;
  private boolean kwz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    kwh = new Column("roomName", "string", TABLE.getName(), "");
    jTk = new Column("nickName", "string", TABLE.getName(), "");
    kna = new Column("avatarURL", "string", TABLE.getName(), "");
    kwi = new Column("sex", "int", TABLE.getName(), "");
    kwj = new Column("jumpInfo", "proto", TABLE.getName(), "com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo");
    kwk = new Column("isAuthorized", "boolean", TABLE.getName(), "");
    kwl = new Column("tagInfo", "proto", TABLE.getName(), "com.tencent.mm.plugin.game.autogen.chatroom.TagInfo");
    kwm = new Column("lbsInfo", "proto", TABLE.getName(), "com.tencent.mm.plugin.game.autogen.chatroom.LbsInfo");
    kwn = new Column("role", "int", TABLE.getName(), "");
    kwo = new Column("canBeAt", "boolean", TABLE.getName(), "");
    kwp = new Column("isRobot", "boolean", TABLE.getName(), "");
    kwq = new Column("canKickMember", "boolean", TABLE.getName(), "");
    kwr = new Column("userRole", "proto", TABLE.getName(), "com.tencent.mm.plugin.game.autogen.chatroom.UserRole");
    kws = new Column("canBeKicked", "boolean", TABLE.getName(), "");
    kwt = new Column("canAtAll", "boolean", TABLE.getName(), "");
    kwu = new Column("rawPbData", "byte[]", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    userName_HASHCODE = "userName".hashCode();
    kwL = "roomName".hashCode();
    kwM = "nickName".hashCode();
    kwN = "avatarURL".hashCode();
    kwO = "sex".hashCode();
    kwP = "jumpInfo".hashCode();
    kwQ = "isAuthorized".hashCode();
    kwR = "tagInfo".hashCode();
    kwS = "lbsInfo".hashCode();
    kwT = "role".hashCode();
    kwU = "canBeAt".hashCode();
    kwV = "isRobot".hashCode();
    kwW = "canKickMember".hashCode();
    kwX = "userRole".hashCode();
    kwY = "canBeKicked".hashCode();
    kwZ = "canAtAll".hashCode();
    kxa = "rawPbData".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "roomName";
    localMAutoDBInfo.colsMap.put("roomName", "TEXT default '' ");
    localStringBuilder.append(" roomName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickName";
    localMAutoDBInfo.colsMap.put("nickName", "TEXT default '' ");
    localStringBuilder.append(" nickName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "avatarURL";
    localMAutoDBInfo.colsMap.put("avatarURL", "TEXT default '' ");
    localStringBuilder.append(" avatarURL TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "sex";
    localMAutoDBInfo.colsMap.put("sex", "INTEGER default '0' ");
    localStringBuilder.append(" sex INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "jumpInfo";
    localMAutoDBInfo.colsMap.put("jumpInfo", "BLOB");
    localStringBuilder.append(" jumpInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isAuthorized";
    localMAutoDBInfo.colsMap.put("isAuthorized", "INTEGER default 'true' ");
    localStringBuilder.append(" isAuthorized INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "tagInfo";
    localMAutoDBInfo.colsMap.put("tagInfo", "BLOB");
    localStringBuilder.append(" tagInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lbsInfo";
    localMAutoDBInfo.colsMap.put("lbsInfo", "BLOB");
    localStringBuilder.append(" lbsInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "role";
    localMAutoDBInfo.colsMap.put("role", "INTEGER default '0' ");
    localStringBuilder.append(" role INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "canBeAt";
    localMAutoDBInfo.colsMap.put("canBeAt", "INTEGER default 'true' ");
    localStringBuilder.append(" canBeAt INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "isRobot";
    localMAutoDBInfo.colsMap.put("isRobot", "INTEGER default 'false' ");
    localStringBuilder.append(" isRobot INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "canKickMember";
    localMAutoDBInfo.colsMap.put("canKickMember", "INTEGER default 'false' ");
    localStringBuilder.append(" canKickMember INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "userRole";
    localMAutoDBInfo.colsMap.put("userRole", "BLOB");
    localStringBuilder.append(" userRole BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "canBeKicked";
    localMAutoDBInfo.colsMap.put("canBeKicked", "INTEGER default 'true' ");
    localStringBuilder.append(" canBeKicked INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "canAtAll";
    localMAutoDBInfo.colsMap.put("canAtAll", "INTEGER default 'false' ");
    localStringBuilder.append(" canAtAll INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "rawPbData";
    localMAutoDBInfo.colsMap.put("rawPbData", "BLOB");
    localStringBuilder.append(" rawPbData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[18] = "rowid";
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
    if (paramContentValues.containsKey("roomName"))
    {
      this.field_roomName = paramContentValues.getAsString("roomName");
      if (paramBoolean) {
        this.kwv = true;
      }
    }
    if (paramContentValues.containsKey("nickName"))
    {
      this.field_nickName = paramContentValues.getAsString("nickName");
      if (paramBoolean) {
        this.kww = true;
      }
    }
    if (paramContentValues.containsKey("avatarURL"))
    {
      this.field_avatarURL = paramContentValues.getAsString("avatarURL");
      if (paramBoolean) {
        this.kwx = true;
      }
    }
    if (paramContentValues.containsKey("sex"))
    {
      this.field_sex = paramContentValues.getAsInteger("sex").intValue();
      if (paramBoolean) {
        this.kwy = true;
      }
    }
    if (paramContentValues.containsKey("jumpInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("jumpInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_jumpInfo = ((JumpInfo)new JumpInfo().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kwz = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException1.getMessage());
        continue;
        bool1 = false;
      }
    }
    if (paramContentValues.containsKey("isAuthorized"))
    {
      if (paramContentValues.getAsInteger("isAuthorized").intValue() == 0) {
        break label724;
      }
      bool1 = true;
      this.field_isAuthorized = bool1;
      if (paramBoolean) {
        this.kwA = true;
      }
    }
    if (paramContentValues.containsKey("tagInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("tagInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_tagInfo = ((TagInfo)new TagInfo().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kwB = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("lbsInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("lbsInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_lbsInfo = ((LbsInfo)new LbsInfo().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kwC = true;
        }
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException3.getMessage());
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
    if (paramContentValues.containsKey("role"))
    {
      this.field_role = paramContentValues.getAsInteger("role").intValue();
      if (paramBoolean) {
        this.kwD = true;
      }
    }
    if (paramContentValues.containsKey("canBeAt"))
    {
      if (paramContentValues.getAsInteger("canBeAt").intValue() == 0) {
        break label761;
      }
      bool1 = true;
      this.field_canBeAt = bool1;
      if (paramBoolean) {
        this.kwE = true;
      }
    }
    if (paramContentValues.containsKey("isRobot"))
    {
      if (paramContentValues.getAsInteger("isRobot").intValue() == 0) {
        break label766;
      }
      bool1 = true;
      this.field_isRobot = bool1;
      if (paramBoolean) {
        this.kwF = true;
      }
    }
    if (paramContentValues.containsKey("canKickMember"))
    {
      if (paramContentValues.getAsInteger("canKickMember").intValue() == 0) {
        break label771;
      }
      bool1 = true;
      this.field_canKickMember = bool1;
      if (paramBoolean) {
        this.kwG = true;
      }
    }
    if (paramContentValues.containsKey("userRole")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("userRole");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_userRole = ((UserRole)new UserRole().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kwH = true;
        }
      }
    }
    catch (IOException localIOException4)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException4.getMessage());
        continue;
        bool1 = false;
      }
    }
    if (paramContentValues.containsKey("canBeKicked"))
    {
      if (paramContentValues.getAsInteger("canBeKicked").intValue() == 0) {
        break label792;
      }
      bool1 = true;
      this.field_canBeKicked = bool1;
      if (paramBoolean) {
        this.kwI = true;
      }
    }
    if (paramContentValues.containsKey("canAtAll"))
    {
      bool1 = bool2;
      if (paramContentValues.getAsInteger("canAtAll").intValue() != 0) {
        bool1 = true;
      }
      this.field_canAtAll = bool1;
      if (paramBoolean) {
        this.kwJ = true;
      }
    }
    if (paramContentValues.containsKey("rawPbData"))
    {
      this.field_rawPbData = paramContentValues.getAsByteArray("rawPbData");
      if (paramBoolean) {
        this.kwK = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
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
      if (kwL == k)
      {
        this.field_roomName = paramCursor.getString(i);
      }
      else if (kwM == k)
      {
        this.field_nickName = paramCursor.getString(i);
      }
      else if (kwN == k)
      {
        this.field_avatarURL = paramCursor.getString(i);
      }
      else if (kwO == k)
      {
        this.field_sex = paramCursor.getInt(i);
      }
      else if (kwP == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_jumpInfo = ((JumpInfo)new JumpInfo().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException1.getMessage());
        }
      }
      else
      {
        boolean bool;
        if (kwQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isAuthorized = bool;
            break;
          }
        }
        if (kwR == k)
        {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_tagInfo = ((TagInfo)new TagInfo().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException2.getMessage());
          }
        }
        else if (kwS == k)
        {
          try
          {
            byte[] arrayOfByte3 = paramCursor.getBlob(i);
            if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
              continue;
            }
            this.field_lbsInfo = ((LbsInfo)new LbsInfo().parseFrom(arrayOfByte3));
          }
          catch (IOException localIOException3)
          {
            Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException3.getMessage());
          }
        }
        else if (kwT == k)
        {
          this.field_role = paramCursor.getInt(i);
        }
        else
        {
          if (kwU == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_canBeAt = bool;
              break;
            }
          }
          if (kwV == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRobot = bool;
              break;
            }
          }
          if (kwW == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_canKickMember = bool;
              break;
            }
          }
          if (kwX == k)
          {
            try
            {
              byte[] arrayOfByte4 = paramCursor.getBlob(i);
              if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
                continue;
              }
              this.field_userRole = ((UserRole)new UserRole().parseFrom(arrayOfByte4));
            }
            catch (IOException localIOException4)
            {
              Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException4.getMessage());
            }
          }
          else
          {
            if (kwY == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_canBeKicked = bool;
                break;
              }
            }
            if (kwZ == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_canAtAll = bool;
                break;
              }
            }
            if (kxa == k) {
              this.field_rawPbData = paramCursor.getBlob(i);
            } else if (updateTime_HASHCODE == k) {
              this.field_updateTime = paramCursor.getLong(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_roomName == null) {
      this.field_roomName = "";
    }
    if (this.kwv) {
      localContentValues.put("roomName", this.field_roomName);
    }
    if (this.field_nickName == null) {
      this.field_nickName = "";
    }
    if (this.kww) {
      localContentValues.put("nickName", this.field_nickName);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.kwx) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.kwy) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.kwz) && (this.field_jumpInfo != null)) {}
    try
    {
      localContentValues.put("jumpInfo", this.field_jumpInfo.toByteArray());
      if (this.kwA) {
        localContentValues.put("isAuthorized", Boolean.valueOf(this.field_isAuthorized));
      }
      if ((!this.kwB) || (this.field_tagInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("tagInfo", this.field_tagInfo.toByteArray());
        if ((!this.kwC) || (this.field_lbsInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("lbsInfo", this.field_lbsInfo.toByteArray());
          if (this.kwD) {
            localContentValues.put("role", Integer.valueOf(this.field_role));
          }
          if (this.kwE) {
            localContentValues.put("canBeAt", Boolean.valueOf(this.field_canBeAt));
          }
          if (this.kwF) {
            localContentValues.put("isRobot", Boolean.valueOf(this.field_isRobot));
          }
          if (this.kwG) {
            localContentValues.put("canKickMember", Boolean.valueOf(this.field_canKickMember));
          }
          if ((!this.kwH) || (this.field_userRole == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("userRole", this.field_userRole.toByteArray());
              if (this.kwI) {
                localContentValues.put("canBeKicked", Boolean.valueOf(this.field_canBeKicked));
              }
              if (this.kwJ) {
                localContentValues.put("canAtAll", Boolean.valueOf(this.field_canAtAll));
              }
              if (this.kwK) {
                localContentValues.put("rawPbData", this.field_rawPbData);
              }
              if (this.__hadSetupdateTime) {
                localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
              }
              if (this.systemRowid > 0L) {
                localContentValues.put("rowid", Long.valueOf(this.systemRowid));
              }
              return localContentValues;
              localIOException1 = localIOException1;
              Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              Log.e("MicroMsg.SDK.BaseGameChatRoomContact", localIOException4.getMessage());
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
  
  public StorageObserverOwner<? extends dj> getObserverOwner()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.dj
 * JD-Core Version:    0.7.0.1
 */