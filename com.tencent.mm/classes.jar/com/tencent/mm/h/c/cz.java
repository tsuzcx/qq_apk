package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class cz
  extends c
{
  private static final int cTc = "acctTypeId".hashCode();
  private static final int cTd;
  private static final int cTh;
  private static final int cTi;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctG;
  private boolean cSZ = true;
  private boolean cTa = true;
  private boolean cTf = true;
  private boolean cTg = true;
  private boolean ctE = true;
  public String field_acctTypeId;
  public dj field_appRec;
  public String field_appid;
  public String field_language;
  public long field_updateTime;
  
  static
  {
    cTh = "appid".hashCode();
    cTd = "language".hashCode();
    cTi = "appRec".hashCode();
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
      if (cTh != k) {
        break label60;
      }
      this.field_appid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cTd == k) {
        this.field_language = paramCursor.getString(i);
      } else if (cTi == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_appRec = ((dj)new dj().aH(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          y.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
        }
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (cTc == k) {
        this.field_acctTypeId = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cTf) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.cTa) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.cTg) && (this.field_appRec != null)) {}
    try
    {
      localContentValues.put("appRec", this.field_appRec.toByteArray());
      if (this.ctE) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
      }
      if (this.cSZ) {
        localContentValues.put("acctTypeId", this.field_acctTypeId);
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
        y.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.cz
 * JD-Core Version:    0.7.0.1
 */