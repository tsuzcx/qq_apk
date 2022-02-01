package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cp
  extends IAutoDBItem
{
  public static final Column C_LOCALID;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FinderLocalOperation");
  private static final int hEK = "showTips".hashCode();
  public static final Column hEc;
  private static final int hTA;
  private static final int hTB = "contextObj".hashCode();
  private static final int hTC = "isPrivate".hashCode();
  public static final Column hTu;
  public static final Column hTv;
  public static final Column hTw;
  public static final Column hnt;
  private static final int hnx;
  private static final int localId_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetlocalId = true;
  public bid field_contextObj;
  public boolean field_isPrivate;
  public int field_likeAction;
  public long field_localId;
  public int field_scene;
  public boolean field_showTips;
  private boolean hEt = true;
  private boolean hTx = true;
  private boolean hTy = true;
  private boolean hTz = true;
  private boolean hnv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderLocalOperation", "");
    C_LOCALID = new Column("localid", "long", "FinderLocalOperation", "");
    hTu = new Column("likeaction", "int", "FinderLocalOperation", "");
    hnt = new Column("scene", "int", "FinderLocalOperation", "");
    hEc = new Column("showtips", "boolean", "FinderLocalOperation", "");
    hTv = new Column("contextobj", "proto", "FinderLocalOperation", "com.tencent.mm.protocal.protobuf.FinderReportContextObj");
    hTw = new Column("isprivate", "boolean", "FinderLocalOperation", "");
    localId_HASHCODE = "localId".hashCode();
    hTA = "likeAction".hashCode();
    hnx = "scene".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "likeAction";
    localMAutoDBInfo.colsMap.put("likeAction", "INTEGER");
    localStringBuilder.append(" likeAction INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "showTips";
    localMAutoDBInfo.colsMap.put("showTips", "INTEGER");
    localStringBuilder.append(" showTips INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "contextObj";
    localMAutoDBInfo.colsMap.put("contextObj", "BLOB");
    localStringBuilder.append(" contextObj BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isPrivate";
    localMAutoDBInfo.colsMap.put("isPrivate", "INTEGER");
    localStringBuilder.append(" isPrivate INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hTA == k)
      {
        this.field_likeAction = paramCursor.getInt(i);
      }
      else if (hnx == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (hEK == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showTips = bool;
            break;
          }
        }
        if (hTB == k)
        {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_contextObj = ((bid)new bid().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
          }
        }
        else
        {
          if (hTC == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isPrivate = bool;
              break;
            }
          }
          if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.hTx) {
      localContentValues.put("likeAction", Integer.valueOf(this.field_likeAction));
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.hEt) {
      localContentValues.put("showTips", Boolean.valueOf(this.field_showTips));
    }
    if ((this.hTy) && (this.field_contextObj != null)) {}
    try
    {
      localContentValues.put("contextObj", this.field_contextObj.toByteArray());
      if (this.hTz) {
        localContentValues.put("isPrivate", Boolean.valueOf(this.field_isPrivate));
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderLocalOperation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.cp
 * JD-Core Version:    0.7.0.1
 */