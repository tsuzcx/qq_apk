package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class aw
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("chatroom");
  public static final Column jNg;
  public static final Column jQK;
  private static final int jRk;
  public static final Column jWQ;
  public static final Column jWR;
  public static final Column jWS;
  public static final Column jWT;
  public static final Column jWU;
  public static final Column jWV;
  public static final Column jWW;
  public static final Column jWX;
  public static final Column jWY;
  public static final Column jWZ;
  private static final int jXT;
  private static final int jXU;
  private static final int jXV;
  private static final int jXW;
  private static final int jXX;
  private static final int jXY;
  private static final int jXZ;
  public static final Column jXa;
  public static final Column jXb;
  public static final Column jXc;
  public static final Column jXd;
  public static final Column jXe;
  public static final Column jXf;
  public static final Column jXg;
  public static final Column jXh;
  public static final Column jXi;
  public static final Column jXj;
  public static final Column jXk;
  public static final Column jXl;
  public static final Column jXm;
  public static final Column jXn;
  public static final Column jXo;
  public static final Column jXp;
  public static final Column jXq;
  private static final int jYa;
  private static final int jYb;
  private static final int jYc;
  private static final int jYd;
  private static final int jYe;
  private static final int jYf;
  private static final int jYg;
  private static final int jYh;
  private static final int jYi;
  private static final int jYj;
  private static final int jYk;
  private static final int jYl;
  private static final int jYm;
  private static final int jYn;
  private static final int jYo;
  private static final int jYp;
  private static final int jYq;
  private static final int jYr;
  private static final int jYs;
  private static final int jYt;
  private static final int jYu;
  private static final StorageObserverOwner<aw> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_addtime;
  public String field_associateOpenIMRoomName;
  public long field_chatroomLocalVersion;
  public int field_chatroomNoticeNew;
  public int field_chatroomStatus;
  public int field_chatroomVersion;
  public int field_chatroomdataflag;
  public long field_chatroomfamilystatusmodifytime;
  public String field_chatroomname;
  public String field_chatroomnick;
  public String field_chatroomnotice;
  public String field_chatroomnoticeEditor;
  public long field_chatroomnoticePublishTime;
  public String field_displayname;
  public String field_handleByteVersion;
  public int field_isShowname;
  public djd field_localChatRoomWatchMembers;
  public int field_memberCount;
  public String field_memberlist;
  public long field_modifytime;
  public int field_oldChatroomVersion;
  public int field_openIMRoomMigrateStatus;
  public byte[] field_roomInfoDetailResByte;
  public byte[] field_roomdata;
  public int field_roomflag;
  public String field_roomowner;
  public String field_saveByteVersion;
  public String field_selfDisplayName;
  public int field_style;
  private boolean jQX = true;
  private boolean jXA = true;
  private boolean jXB = true;
  private boolean jXC = true;
  private boolean jXD = true;
  private boolean jXE = true;
  private boolean jXF = true;
  private boolean jXG = true;
  private boolean jXH = true;
  private boolean jXI = true;
  private boolean jXJ = true;
  private boolean jXK = true;
  private boolean jXL = true;
  private boolean jXM = true;
  private boolean jXN = true;
  private boolean jXO = true;
  private boolean jXP = true;
  private boolean jXQ = true;
  private boolean jXR = true;
  private boolean jXS = true;
  private boolean jXr = true;
  private boolean jXs = true;
  private boolean jXt = true;
  private boolean jXu = true;
  private boolean jXv = true;
  private boolean jXw = true;
  private boolean jXx = true;
  private boolean jXy = true;
  private boolean jXz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jWQ = new Column("chatroomname", "string", TABLE.getName(), "");
    jWR = new Column("addtime", "long", TABLE.getName(), "");
    jWS = new Column("memberlist", "string", TABLE.getName(), "");
    jWT = new Column("displayname", "string", TABLE.getName(), "");
    jWU = new Column("chatroomnick", "string", TABLE.getName(), "");
    jQK = new Column("roomflag", "int", TABLE.getName(), "");
    jWV = new Column("roomowner", "string", TABLE.getName(), "");
    jWW = new Column("roomdata", "byte[]", TABLE.getName(), "");
    jWX = new Column("isShowname", "int", TABLE.getName(), "");
    jWY = new Column("selfDisplayName", "string", TABLE.getName(), "");
    jWZ = new Column("style", "int", TABLE.getName(), "");
    jXa = new Column("chatroomdataflag", "int", TABLE.getName(), "");
    jNg = new Column("modifytime", "long", TABLE.getName(), "");
    jXb = new Column("chatroomnotice", "string", TABLE.getName(), "");
    jXc = new Column("chatroomVersion", "int", TABLE.getName(), "");
    jXd = new Column("chatroomnoticeEditor", "string", TABLE.getName(), "");
    jXe = new Column("chatroomnoticePublishTime", "long", TABLE.getName(), "");
    jXf = new Column("chatroomNoticeNew", "int", TABLE.getName(), "");
    jXg = new Column("chatroomLocalVersion", "long", TABLE.getName(), "");
    jXh = new Column("chatroomStatus", "int", TABLE.getName(), "");
    jXi = new Column("memberCount", "int", TABLE.getName(), "");
    jXj = new Column("chatroomfamilystatusmodifytime", "long", TABLE.getName(), "");
    jXk = new Column("associateOpenIMRoomName", "string", TABLE.getName(), "");
    jXl = new Column("openIMRoomMigrateStatus", "int", TABLE.getName(), "");
    jXm = new Column("saveByteVersion", "string", TABLE.getName(), "");
    jXn = new Column("handleByteVersion", "string", TABLE.getName(), "");
    jXo = new Column("roomInfoDetailResByte", "byte[]", TABLE.getName(), "");
    jXp = new Column("oldChatroomVersion", "int", TABLE.getName(), "");
    jXq = new Column("localChatRoomWatchMembers", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LocalChatRoomWatchMembers");
    INDEX_CREATE = new String[0];
    jXT = "chatroomname".hashCode();
    jXU = "addtime".hashCode();
    jXV = "memberlist".hashCode();
    jXW = "displayname".hashCode();
    jXX = "chatroomnick".hashCode();
    jRk = "roomflag".hashCode();
    jXY = "roomowner".hashCode();
    jXZ = "roomdata".hashCode();
    jYa = "isShowname".hashCode();
    jYb = "selfDisplayName".hashCode();
    jYc = "style".hashCode();
    jYd = "chatroomdataflag".hashCode();
    jYe = "modifytime".hashCode();
    jYf = "chatroomnotice".hashCode();
    jYg = "chatroomVersion".hashCode();
    jYh = "chatroomnoticeEditor".hashCode();
    jYi = "chatroomnoticePublishTime".hashCode();
    jYj = "chatroomNoticeNew".hashCode();
    jYk = "chatroomLocalVersion".hashCode();
    jYl = "chatroomStatus".hashCode();
    jYm = "memberCount".hashCode();
    jYn = "chatroomfamilystatusmodifytime".hashCode();
    jYo = "associateOpenIMRoomName".hashCode();
    jYp = "openIMRoomMigrateStatus".hashCode();
    jYq = "saveByteVersion".hashCode();
    jYr = "handleByteVersion".hashCode();
    jYs = "roomInfoDetailResByte".hashCode();
    jYt = "oldChatroomVersion".hashCode();
    jYu = "localChatRoomWatchMembers".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[29];
    localMAutoDBInfo.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "chatroomname";
    localMAutoDBInfo.colsMap.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "chatroomname";
    localMAutoDBInfo.columns[1] = "addtime";
    localMAutoDBInfo.colsMap.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "memberlist";
    localMAutoDBInfo.colsMap.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "displayname";
    localMAutoDBInfo.colsMap.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "chatroomnick";
    localMAutoDBInfo.colsMap.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "roomflag";
    localMAutoDBInfo.colsMap.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "roomowner";
    localMAutoDBInfo.colsMap.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "roomdata";
    localMAutoDBInfo.colsMap.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "isShowname";
    localMAutoDBInfo.colsMap.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "selfDisplayName";
    localMAutoDBInfo.colsMap.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "style";
    localMAutoDBInfo.colsMap.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "chatroomdataflag";
    localMAutoDBInfo.colsMap.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "modifytime";
    localMAutoDBInfo.colsMap.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "chatroomnotice";
    localMAutoDBInfo.colsMap.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "chatroomVersion";
    localMAutoDBInfo.colsMap.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "chatroomnoticeEditor";
    localMAutoDBInfo.colsMap.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "chatroomnoticePublishTime";
    localMAutoDBInfo.colsMap.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "chatroomNoticeNew";
    localMAutoDBInfo.colsMap.put("chatroomNoticeNew", "INTEGER");
    localStringBuilder.append(" chatroomNoticeNew INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "chatroomLocalVersion";
    localMAutoDBInfo.colsMap.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "chatroomStatus";
    localMAutoDBInfo.colsMap.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "memberCount";
    localMAutoDBInfo.colsMap.put("memberCount", "INTEGER default '-1' ");
    localStringBuilder.append(" memberCount INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "chatroomfamilystatusmodifytime";
    localMAutoDBInfo.colsMap.put("chatroomfamilystatusmodifytime", "LONG default '0' ");
    localStringBuilder.append(" chatroomfamilystatusmodifytime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "associateOpenIMRoomName";
    localMAutoDBInfo.colsMap.put("associateOpenIMRoomName", "TEXT");
    localStringBuilder.append(" associateOpenIMRoomName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "openIMRoomMigrateStatus";
    localMAutoDBInfo.colsMap.put("openIMRoomMigrateStatus", "INTEGER default '0' ");
    localStringBuilder.append(" openIMRoomMigrateStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "saveByteVersion";
    localMAutoDBInfo.colsMap.put("saveByteVersion", "TEXT");
    localStringBuilder.append(" saveByteVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "handleByteVersion";
    localMAutoDBInfo.colsMap.put("handleByteVersion", "TEXT");
    localStringBuilder.append(" handleByteVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "roomInfoDetailResByte";
    localMAutoDBInfo.colsMap.put("roomInfoDetailResByte", "BLOB");
    localStringBuilder.append(" roomInfoDetailResByte BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "oldChatroomVersion";
    localMAutoDBInfo.colsMap.put("oldChatroomVersion", "INTEGER");
    localStringBuilder.append(" oldChatroomVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "localChatRoomWatchMembers";
    localMAutoDBInfo.colsMap.put("localChatRoomWatchMembers", "BLOB");
    localStringBuilder.append(" localChatRoomWatchMembers BLOB");
    localMAutoDBInfo.columns[29] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("chatroomname"))
    {
      this.field_chatroomname = paramContentValues.getAsString("chatroomname");
      if (paramBoolean) {
        this.jXr = true;
      }
    }
    if (paramContentValues.containsKey("addtime"))
    {
      this.field_addtime = paramContentValues.getAsLong("addtime").longValue();
      if (paramBoolean) {
        this.jXs = true;
      }
    }
    if (paramContentValues.containsKey("memberlist"))
    {
      this.field_memberlist = paramContentValues.getAsString("memberlist");
      if (paramBoolean) {
        this.jXt = true;
      }
    }
    if (paramContentValues.containsKey("displayname"))
    {
      this.field_displayname = paramContentValues.getAsString("displayname");
      if (paramBoolean) {
        this.jXu = true;
      }
    }
    if (paramContentValues.containsKey("chatroomnick"))
    {
      this.field_chatroomnick = paramContentValues.getAsString("chatroomnick");
      if (paramBoolean) {
        this.jXv = true;
      }
    }
    if (paramContentValues.containsKey("roomflag"))
    {
      this.field_roomflag = paramContentValues.getAsInteger("roomflag").intValue();
      if (paramBoolean) {
        this.jQX = true;
      }
    }
    if (paramContentValues.containsKey("roomowner"))
    {
      this.field_roomowner = paramContentValues.getAsString("roomowner");
      if (paramBoolean) {
        this.jXw = true;
      }
    }
    if (paramContentValues.containsKey("roomdata"))
    {
      this.field_roomdata = paramContentValues.getAsByteArray("roomdata");
      if (paramBoolean) {
        this.jXx = true;
      }
    }
    if (paramContentValues.containsKey("isShowname"))
    {
      this.field_isShowname = paramContentValues.getAsInteger("isShowname").intValue();
      if (paramBoolean) {
        this.jXy = true;
      }
    }
    if (paramContentValues.containsKey("selfDisplayName"))
    {
      this.field_selfDisplayName = paramContentValues.getAsString("selfDisplayName");
      if (paramBoolean) {
        this.jXz = true;
      }
    }
    if (paramContentValues.containsKey("style"))
    {
      this.field_style = paramContentValues.getAsInteger("style").intValue();
      if (paramBoolean) {
        this.jXA = true;
      }
    }
    if (paramContentValues.containsKey("chatroomdataflag"))
    {
      this.field_chatroomdataflag = paramContentValues.getAsInteger("chatroomdataflag").intValue();
      if (paramBoolean) {
        this.jXB = true;
      }
    }
    if (paramContentValues.containsKey("modifytime"))
    {
      this.field_modifytime = paramContentValues.getAsLong("modifytime").longValue();
      if (paramBoolean) {
        this.jXC = true;
      }
    }
    if (paramContentValues.containsKey("chatroomnotice"))
    {
      this.field_chatroomnotice = paramContentValues.getAsString("chatroomnotice");
      if (paramBoolean) {
        this.jXD = true;
      }
    }
    if (paramContentValues.containsKey("chatroomVersion"))
    {
      this.field_chatroomVersion = paramContentValues.getAsInteger("chatroomVersion").intValue();
      if (paramBoolean) {
        this.jXE = true;
      }
    }
    if (paramContentValues.containsKey("chatroomnoticeEditor"))
    {
      this.field_chatroomnoticeEditor = paramContentValues.getAsString("chatroomnoticeEditor");
      if (paramBoolean) {
        this.jXF = true;
      }
    }
    if (paramContentValues.containsKey("chatroomnoticePublishTime"))
    {
      this.field_chatroomnoticePublishTime = paramContentValues.getAsLong("chatroomnoticePublishTime").longValue();
      if (paramBoolean) {
        this.jXG = true;
      }
    }
    if (paramContentValues.containsKey("chatroomNoticeNew"))
    {
      this.field_chatroomNoticeNew = paramContentValues.getAsInteger("chatroomNoticeNew").intValue();
      if (paramBoolean) {
        this.jXH = true;
      }
    }
    if (paramContentValues.containsKey("chatroomLocalVersion"))
    {
      this.field_chatroomLocalVersion = paramContentValues.getAsLong("chatroomLocalVersion").longValue();
      if (paramBoolean) {
        this.jXI = true;
      }
    }
    if (paramContentValues.containsKey("chatroomStatus"))
    {
      this.field_chatroomStatus = paramContentValues.getAsInteger("chatroomStatus").intValue();
      if (paramBoolean) {
        this.jXJ = true;
      }
    }
    if (paramContentValues.containsKey("memberCount"))
    {
      this.field_memberCount = paramContentValues.getAsInteger("memberCount").intValue();
      if (paramBoolean) {
        this.jXK = true;
      }
    }
    if (paramContentValues.containsKey("chatroomfamilystatusmodifytime"))
    {
      this.field_chatroomfamilystatusmodifytime = paramContentValues.getAsLong("chatroomfamilystatusmodifytime").longValue();
      if (paramBoolean) {
        this.jXL = true;
      }
    }
    if (paramContentValues.containsKey("associateOpenIMRoomName"))
    {
      this.field_associateOpenIMRoomName = paramContentValues.getAsString("associateOpenIMRoomName");
      if (paramBoolean) {
        this.jXM = true;
      }
    }
    if (paramContentValues.containsKey("openIMRoomMigrateStatus"))
    {
      this.field_openIMRoomMigrateStatus = paramContentValues.getAsInteger("openIMRoomMigrateStatus").intValue();
      if (paramBoolean) {
        this.jXN = true;
      }
    }
    if (paramContentValues.containsKey("saveByteVersion"))
    {
      this.field_saveByteVersion = paramContentValues.getAsString("saveByteVersion");
      if (paramBoolean) {
        this.jXO = true;
      }
    }
    if (paramContentValues.containsKey("handleByteVersion"))
    {
      this.field_handleByteVersion = paramContentValues.getAsString("handleByteVersion");
      if (paramBoolean) {
        this.jXP = true;
      }
    }
    if (paramContentValues.containsKey("roomInfoDetailResByte"))
    {
      this.field_roomInfoDetailResByte = paramContentValues.getAsByteArray("roomInfoDetailResByte");
      if (paramBoolean) {
        this.jXQ = true;
      }
    }
    if (paramContentValues.containsKey("oldChatroomVersion"))
    {
      this.field_oldChatroomVersion = paramContentValues.getAsInteger("oldChatroomVersion").intValue();
      if (paramBoolean) {
        this.jXR = true;
      }
    }
    if (paramContentValues.containsKey("localChatRoomWatchMembers")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("localChatRoomWatchMembers");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_localChatRoomWatchMembers = ((djd)new djd().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.jXS = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseChatRoomMember", localIOException.getMessage());
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
      if (jXT != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.jXr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jXU == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (jXV == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (jXW == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (jXX == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (jRk == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (jXY == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (jXZ == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (jYa == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (jYb == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (jYc == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (jYd == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (jYe == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (jYf == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (jYg == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (jYh == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (jYi == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (jYj == k) {
        this.field_chatroomNoticeNew = paramCursor.getInt(i);
      } else if (jYk == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (jYl == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (jYm == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (jYn == k) {
        this.field_chatroomfamilystatusmodifytime = paramCursor.getLong(i);
      } else if (jYo == k) {
        this.field_associateOpenIMRoomName = paramCursor.getString(i);
      } else if (jYp == k) {
        this.field_openIMRoomMigrateStatus = paramCursor.getInt(i);
      } else if (jYq == k) {
        this.field_saveByteVersion = paramCursor.getString(i);
      } else if (jYr == k) {
        this.field_handleByteVersion = paramCursor.getString(i);
      } else if (jYs == k) {
        this.field_roomInfoDetailResByte = paramCursor.getBlob(i);
      } else if (jYt == k) {
        this.field_oldChatroomVersion = paramCursor.getInt(i);
      } else if (jYu == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_localChatRoomWatchMembers = ((djd)new djd().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseChatRoomMember", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_chatroomname == null) {
      this.field_chatroomname = "";
    }
    if (this.jXr) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.jXs) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.jXt) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.jXu) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.jXv) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.jQX) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.jXw) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.jXx) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.jXy) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.jXz) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.jXA) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.jXB) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.jXC) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.jXD) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.jXE) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.jXF) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.jXG) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.jXH) {
      localContentValues.put("chatroomNoticeNew", Integer.valueOf(this.field_chatroomNoticeNew));
    }
    if (this.jXI) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.jXJ) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.jXK) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.jXL) {
      localContentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
    }
    if (this.jXM) {
      localContentValues.put("associateOpenIMRoomName", this.field_associateOpenIMRoomName);
    }
    if (this.jXN) {
      localContentValues.put("openIMRoomMigrateStatus", Integer.valueOf(this.field_openIMRoomMigrateStatus));
    }
    if (this.jXO) {
      localContentValues.put("saveByteVersion", this.field_saveByteVersion);
    }
    if (this.jXP) {
      localContentValues.put("handleByteVersion", this.field_handleByteVersion);
    }
    if (this.jXQ) {
      localContentValues.put("roomInfoDetailResByte", this.field_roomInfoDetailResByte);
    }
    if (this.jXR) {
      localContentValues.put("oldChatroomVersion", Integer.valueOf(this.field_oldChatroomVersion));
    }
    if ((this.jXS) && (this.field_localChatRoomWatchMembers != null)) {}
    try
    {
      localContentValues.put("localChatRoomWatchMembers", this.field_localChatRoomWatchMembers.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseChatRoomMember", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends aw> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_chatroomname;
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
 * Qualified Name:     com.tencent.mm.autogen.b.aw
 * JD-Core Version:    0.7.0.1
 */