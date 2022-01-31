package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class cy
  extends c
{
  private static final int cTc;
  private static final int cTd;
  private static final int cTe;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctG;
  private boolean cSZ = true;
  private boolean cTa = true;
  private boolean cTb = true;
  private boolean ctE = true;
  public as field_accTypeRec;
  public String field_acctTypeId;
  public String field_language;
  public long field_updateTime;
  
  static
  {
    cTc = "acctTypeId".hashCode();
    cTd = "language".hashCode();
    cTe = "accTypeRec".hashCode();
    ctG = "updateTime".hashCode();
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
      if (cTc != k) {
        break label60;
      }
      this.field_acctTypeId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cTd == k) {
        this.field_language = paramCursor.getString(i);
      } else if (cTe == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_accTypeRec = ((as)new as().aH(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          y.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
        }
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cSZ) {
      localContentValues.put("acctTypeId", this.field_acctTypeId);
    }
    if (this.cTa) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.cTb) && (this.field_accTypeRec != null)) {}
    try
    {
      localContentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
      if (this.ctE) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
        y.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.cy
 * JD-Core Version:    0.7.0.1
 */