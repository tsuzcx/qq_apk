package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bv
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)" };
  private static final int eDL = "localId".hashCode();
  private static final int eDM = "modItem".hashCode();
  private static final int env = "scene".hashCode();
  private static final int euN = "time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eDJ = true;
  private boolean eDK = true;
  private boolean ent = true;
  private boolean euu = true;
  public long field_localId;
  public ahb field_modItem;
  public int field_scene;
  public long field_time;
  public int field_type;
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.GvH.put("localId", "LONG");
    localStringBuilder.append(" localId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "modItem";
    locala.GvH.put("modItem", "BLOB");
    localStringBuilder.append(" modItem BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "time";
    locala.GvH.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.GvH.put("scene", "INTEGER default '1' ");
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
      if (eDL != k) {
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
      if (eDM == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_modItem = ((ahb)new ahb().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ac.e("MicroMsg.SDK.BaseFavEditInfo", localIOException.getMessage());
        }
      } else if (euN == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (env == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDJ) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if ((this.eDK) && (this.field_modItem != null)) {}
    try
    {
      localContentValues.put("modItem", this.field_modItem.toByteArray());
      if (this.euu) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.ent) {
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
        ac.e("MicroMsg.SDK.BaseFavEditInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bv
 * JD-Core Version:    0.7.0.1
 */