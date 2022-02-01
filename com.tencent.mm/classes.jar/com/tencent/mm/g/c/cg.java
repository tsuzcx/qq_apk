package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGk = "scene".hashCode();
  private static final int eSk = "showTips".hashCode();
  private static final int eWU = "localId".hashCode();
  private static final int faB = "likeAction".hashCode();
  private static final int faC = "contextObj".hashCode();
  private static final int faD = "isPrivate".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGi = true;
  private boolean eRV = true;
  private boolean eWS = true;
  private boolean faA = true;
  private boolean fay = true;
  private boolean faz = true;
  public arn field_contextObj;
  public boolean field_isPrivate;
  public int field_likeAction;
  public long field_localId;
  public int field_scene;
  public boolean field_showTips;
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IBN.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "localId";
    locala.columns[1] = "likeAction";
    locala.IBN.put("likeAction", "INTEGER");
    localStringBuilder.append(" likeAction INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "scene";
    locala.IBN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "showTips";
    locala.IBN.put("showTips", "INTEGER");
    localStringBuilder.append(" showTips INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "contextObj";
    locala.IBN.put("contextObj", "BLOB");
    localStringBuilder.append(" contextObj BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "isPrivate";
    locala.IBN.put("isPrivate", "INTEGER");
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
      if (eWU != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eWS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (faB == k)
      {
        this.field_likeAction = paramCursor.getInt(i);
      }
      else if (eGk == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eSk == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showTips = bool;
            break;
          }
        }
        if (faC == k)
        {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_contextObj = ((arn)new arn().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            ae.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
          }
        }
        else
        {
          if (faD == k)
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
    if (this.eWS) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.fay) {
      localContentValues.put("likeAction", Integer.valueOf(this.field_likeAction));
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eRV) {
      localContentValues.put("showTips", Boolean.valueOf(this.field_showTips));
    }
    if ((this.faz) && (this.field_contextObj != null)) {}
    try
    {
      localContentValues.put("contextObj", this.field_contextObj.toByteArray());
      if (this.faA) {
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
        ae.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cg
 * JD-Core Version:    0.7.0.1
 */