package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEB = "scene".hashCode();
  private static final int eQz = "showTips".hashCode();
  private static final int eVj = "localId".hashCode();
  private static final int eYO = "likeAction".hashCode();
  private static final int eYP = "contextObj".hashCode();
  private static final int eYQ = "isPrivate".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEz = true;
  private boolean eQk = true;
  private boolean eVh = true;
  private boolean eYL = true;
  private boolean eYM = true;
  private boolean eYN = true;
  public aqy field_contextObj;
  public boolean field_isPrivate;
  public int field_likeAction;
  public long field_localId;
  public int field_scene;
  public boolean field_showTips;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IhC.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "localId";
    locala.columns[1] = "likeAction";
    locala.IhC.put("likeAction", "INTEGER");
    localStringBuilder.append(" likeAction INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "scene";
    locala.IhC.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "showTips";
    locala.IhC.put("showTips", "INTEGER");
    localStringBuilder.append(" showTips INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "contextObj";
    locala.IhC.put("contextObj", "BLOB");
    localStringBuilder.append(" contextObj BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "isPrivate";
    locala.IhC.put("isPrivate", "INTEGER");
    localStringBuilder.append(" isPrivate INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eVj != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eYO == k)
      {
        this.field_likeAction = paramCursor.getInt(i);
      }
      else if (eEB == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eQz == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showTips = bool;
            break;
          }
        }
        if (eYP == k)
        {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_contextObj = ((aqy)new aqy().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
          }
        }
        else
        {
          if (eYQ == k)
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
    if (this.eVh) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.eYL) {
      localContentValues.put("likeAction", Integer.valueOf(this.field_likeAction));
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eQk) {
      localContentValues.put("showTips", Boolean.valueOf(this.field_showTips));
    }
    if ((this.eYM) && (this.field_contextObj != null)) {}
    try
    {
      localContentValues.put("contextObj", this.field_contextObj.toByteArray());
      if (this.eYN) {
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
        ad.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cg
 * JD-Core Version:    0.7.0.1
 */