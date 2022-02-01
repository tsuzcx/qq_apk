package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.LbsInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.TagInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.UserRole;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class cz
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameChatRoomContact");
  public static final Column hPQ;
  public static final Column hWV;
  public static final Column hWW;
  public static final Column hWX;
  public static final Column hWY;
  public static final Column hWZ;
  private static final int hXA;
  private static final int hXB;
  private static final int hXC;
  private static final int hXD;
  private static final int hXE;
  private static final int hXF;
  private static final int hXG;
  private static final int hXH;
  private static final int hXI;
  private static final int hXJ;
  private static final int hXK;
  private static final int hXL;
  private static final int hXM;
  private static final int hXN;
  private static final int hXO;
  public static final Column hXa;
  public static final Column hXb;
  public static final Column hXc;
  public static final Column hXd;
  public static final Column hXe;
  public static final Column hXf;
  public static final Column hXg;
  public static final Column hXh;
  public static final Column hXi;
  private static final int hXz;
  public static final Column hwx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hXj = true;
  private boolean hXk = true;
  private boolean hXl = true;
  private boolean hXm = true;
  private boolean hXn = true;
  private boolean hXo = true;
  private boolean hXp = true;
  private boolean hXq = true;
  private boolean hXr = true;
  private boolean hXs = true;
  private boolean hXt = true;
  private boolean hXu = true;
  private boolean hXv = true;
  private boolean hXw = true;
  private boolean hXx = true;
  private boolean hXy = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameChatRoomContact", "");
    C_USERNAME = new Column("username", "string", "GameChatRoomContact", "");
    hWV = new Column("roomname", "string", "GameChatRoomContact", "");
    hwx = new Column("nickname", "string", "GameChatRoomContact", "");
    hPQ = new Column("avatarurl", "string", "GameChatRoomContact", "");
    hWW = new Column("sex", "int", "GameChatRoomContact", "");
    hWX = new Column("jumpinfo", "proto", "GameChatRoomContact", "com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo");
    hWY = new Column("isauthorized", "boolean", "GameChatRoomContact", "");
    hWZ = new Column("taginfo", "proto", "GameChatRoomContact", "com.tencent.mm.plugin.game.autogen.chatroom.TagInfo");
    hXa = new Column("lbsinfo", "proto", "GameChatRoomContact", "com.tencent.mm.plugin.game.autogen.chatroom.LbsInfo");
    hXb = new Column("role", "int", "GameChatRoomContact", "");
    hXc = new Column("canbeat", "boolean", "GameChatRoomContact", "");
    hXd = new Column("isrobot", "boolean", "GameChatRoomContact", "");
    hXe = new Column("cankickmember", "boolean", "GameChatRoomContact", "");
    hXf = new Column("userrole", "proto", "GameChatRoomContact", "com.tencent.mm.plugin.game.autogen.chatroom.UserRole");
    hXg = new Column("canbekicked", "boolean", "GameChatRoomContact", "");
    hXh = new Column("canatall", "boolean", "GameChatRoomContact", "");
    hXi = new Column("rawpbdata", "byte[]", "GameChatRoomContact", "");
    C_UPDATETIME = new Column("updatetime", "long", "GameChatRoomContact", "");
    userName_HASHCODE = "userName".hashCode();
    hXz = "roomName".hashCode();
    hXA = "nickName".hashCode();
    hXB = "avatarURL".hashCode();
    hXC = "sex".hashCode();
    hXD = "jumpInfo".hashCode();
    hXE = "isAuthorized".hashCode();
    hXF = "tagInfo".hashCode();
    hXG = "lbsInfo".hashCode();
    hXH = "role".hashCode();
    hXI = "canBeAt".hashCode();
    hXJ = "isRobot".hashCode();
    hXK = "canKickMember".hashCode();
    hXL = "userRole".hashCode();
    hXM = "canBeKicked".hashCode();
    hXN = "canAtAll".hashCode();
    hXO = "rawPbData".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (hXz == k)
      {
        this.field_roomName = paramCursor.getString(i);
      }
      else if (hXA == k)
      {
        this.field_nickName = paramCursor.getString(i);
      }
      else if (hXB == k)
      {
        this.field_avatarURL = paramCursor.getString(i);
      }
      else if (hXC == k)
      {
        this.field_sex = paramCursor.getInt(i);
      }
      else if (hXD == k)
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
        if (hXE == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isAuthorized = bool;
            break;
          }
        }
        if (hXF == k)
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
        else if (hXG == k)
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
        else if (hXH == k)
        {
          this.field_role = paramCursor.getInt(i);
        }
        else
        {
          if (hXI == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_canBeAt = bool;
              break;
            }
          }
          if (hXJ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRobot = bool;
              break;
            }
          }
          if (hXK == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_canKickMember = bool;
              break;
            }
          }
          if (hXL == k)
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
            if (hXM == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_canBeKicked = bool;
                break;
              }
            }
            if (hXN == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_canAtAll = bool;
                break;
              }
            }
            if (hXO == k) {
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
    if (this.hXj) {
      localContentValues.put("roomName", this.field_roomName);
    }
    if (this.field_nickName == null) {
      this.field_nickName = "";
    }
    if (this.hXk) {
      localContentValues.put("nickName", this.field_nickName);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.hXl) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.hXm) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.hXn) && (this.field_jumpInfo != null)) {}
    try
    {
      localContentValues.put("jumpInfo", this.field_jumpInfo.toByteArray());
      if (this.hXo) {
        localContentValues.put("isAuthorized", Boolean.valueOf(this.field_isAuthorized));
      }
      if ((!this.hXp) || (this.field_tagInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("tagInfo", this.field_tagInfo.toByteArray());
        if ((!this.hXq) || (this.field_lbsInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("lbsInfo", this.field_lbsInfo.toByteArray());
          if (this.hXr) {
            localContentValues.put("role", Integer.valueOf(this.field_role));
          }
          if (this.hXs) {
            localContentValues.put("canBeAt", Boolean.valueOf(this.field_canBeAt));
          }
          if (this.hXt) {
            localContentValues.put("isRobot", Boolean.valueOf(this.field_isRobot));
          }
          if (this.hXu) {
            localContentValues.put("canKickMember", Boolean.valueOf(this.field_canKickMember));
          }
          if ((!this.hXv) || (this.field_userRole == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("userRole", this.field_userRole.toByteArray());
              if (this.hXw) {
                localContentValues.put("canBeKicked", Boolean.valueOf(this.field_canBeKicked));
              }
              if (this.hXx) {
                localContentValues.put("canAtAll", Boolean.valueOf(this.field_canAtAll));
              }
              if (this.hXy) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "GameChatRoomContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.cz
 * JD-Core Version:    0.7.0.1
 */