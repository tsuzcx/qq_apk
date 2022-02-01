package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bw
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)" };
  private static final int eGk = "scene".hashCode();
  private static final int eNV;
  private static final int eWU = "localId".hashCode();
  private static final int eWV = "modItem".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eGi = true;
  private boolean eNC = true;
  private boolean eWS = true;
  private boolean eWT = true;
  public long field_localId;
  public akb field_modItem;
  public int field_scene;
  public long field_time;
  public int field_type;
  
  static
  {
    eNV = "time".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IBN.put("localId", "LONG");
    localStringBuilder.append(" localId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "modItem";
    locala.IBN.put("modItem", "BLOB");
    localStringBuilder.append(" modItem BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "time";
    locala.IBN.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.IBN.put("scene", "INTEGER default '1' ");
    localStringBuilder.append(" scene INTEGER default '1' ");
    locala.columns[5] = "rowid";
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
        break label60;
      }
      this.field_localId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eWV == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_modItem = ((akb)new akb().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.SDK.BaseFavEditInfo", localIOException.getMessage());
        }
      } else if (eNV == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eGk == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eWS) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if ((this.eWT) && (this.field_modItem != null)) {}
    try
    {
      localContentValues.put("modItem", this.field_modItem.toByteArray());
      if (this.eNC) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.eGi) {
        localContentValues.put("scene", Integer.valueOf(this.field_scene));
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
        ae.e("MicroMsg.SDK.BaseFavEditInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bw
 * JD-Core Version:    0.7.0.1
 */