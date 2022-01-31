package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dh
  extends c
{
  private static final int cTL = "hit".hashCode();
  private static final int cTM = "hitTimeMS".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csy;
  private static final int ctl = "appId".hashCode();
  private boolean cTJ = true;
  private boolean cTK = true;
  private boolean csU = true;
  private boolean csa = true;
  public String field_appId;
  public int field_hit;
  public long field_hitTimeMS;
  public int field_type;
  
  static
  {
    csy = "type".hashCode();
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (ctl != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (cTL == k) {
        this.field_hit = paramCursor.getInt(i);
      } else if (cTM == k) {
        this.field_hitTimeMS = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cTJ) {
      localContentValues.put("hit", Integer.valueOf(this.field_hit));
    }
    if (this.cTK) {
      localContentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.dh
 * JD-Core Version:    0.7.0.1
 */