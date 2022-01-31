package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bm
  extends c
{
  private static final int cHJ;
  private static final int cHK;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)" };
  private static final int crh = "rowid".hashCode();
  private static final int csS;
  private static final int csy;
  private static final int czQ;
  private boolean cHH = true;
  private boolean cHI = true;
  private boolean csQ = true;
  private boolean csa = true;
  private boolean czy = true;
  public long field_localId;
  public xz field_modItem;
  public int field_scene;
  public long field_time;
  public int field_type;
  
  static
  {
    cHJ = "localId".hashCode();
    cHK = "modItem".hashCode();
    czQ = "time".hashCode();
    csy = "type".hashCode();
    csS = "scene".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.ujN.put("localId", "LONG");
    localStringBuilder.append(" localId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "modItem";
    locala.ujN.put("modItem", "BLOB");
    localStringBuilder.append(" modItem BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "time";
    locala.ujN.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "scene";
    locala.ujN.put("scene", "INTEGER default '1' ");
    localStringBuilder.append(" scene INTEGER default '1' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHJ != k) {
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
      if (cHK == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_modItem = ((xz)new xz().aH(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          y.e("MicroMsg.SDK.BaseFavEditInfo", localIOException.getMessage());
        }
      } else if (czQ == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHH) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if ((this.cHI) && (this.field_modItem != null)) {}
    try
    {
      localContentValues.put("modItem", this.field_modItem.toByteArray());
      if (this.czy) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.csa) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.csQ) {
        localContentValues.put("scene", Integer.valueOf(this.field_scene));
      }
      if (this.ujK > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.ujK));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseFavEditInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.bm
 * JD-Core Version:    0.7.0.1
 */