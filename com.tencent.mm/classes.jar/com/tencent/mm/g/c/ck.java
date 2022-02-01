package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ck
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fEG;
  private static final int fEH = "contextObj".hashCode();
  private static final int fEI = "isPrivate".hashCode();
  private static final int fjQ;
  private static final int fvO;
  private static final int localId_HASHCODE = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetlocalId = true;
  private boolean fED = true;
  private boolean fEE = true;
  private boolean fEF = true;
  public bbn field_contextObj;
  public boolean field_isPrivate;
  public int field_likeAction;
  public long field_localId;
  public int field_scene;
  public boolean field_showTips;
  private boolean fjO = true;
  private boolean fvy = true;
  
  static
  {
    fEG = "likeAction".hashCode();
    fjQ = "scene".hashCode();
    fvO = "showTips".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fEG == k)
      {
        this.field_likeAction = paramCursor.getInt(i);
      }
      else if (fjQ == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fvO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showTips = bool;
            break;
          }
        }
        if (fEH == k)
        {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_contextObj = ((bbn)new bbn().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
          }
        }
        else
        {
          if (fEI == k)
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
    if (this.fED) {
      localContentValues.put("likeAction", Integer.valueOf(this.field_likeAction));
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fvy) {
      localContentValues.put("showTips", Boolean.valueOf(this.field_showTips));
    }
    if ((this.fEE) && (this.field_contextObj != null)) {}
    try
    {
      localContentValues.put("contextObj", this.field_contextObj.toByteArray());
      if (this.fEF) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ck
 * JD-Core Version:    0.7.0.1
 */