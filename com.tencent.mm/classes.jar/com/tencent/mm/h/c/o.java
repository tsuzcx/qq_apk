package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class o
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cst;
  private static final int ctl = "appId".hashCode();
  private static final int cug;
  private static final int cuh;
  private static final int cui;
  private static final int cuj;
  private static final int cuk;
  private static final int cul;
  private static final int cum;
  private boolean crV = true;
  private boolean csU = true;
  private boolean ctZ = true;
  private boolean cua = true;
  private boolean cub = true;
  private boolean cuc = true;
  private boolean cud = true;
  private boolean cue = true;
  private boolean cuf = true;
  public String field_appId;
  public String field_descInfo;
  public double field_evaluateScore;
  public String field_logo;
  public String field_nickName;
  public bjt field_recommendWxa;
  public long field_sessionId;
  public String field_userName;
  public String field_words;
  
  static
  {
    cst = "userName".hashCode();
    cug = "nickName".hashCode();
    cuh = "logo".hashCode();
    cui = "sessionId".hashCode();
    cuj = "descInfo".hashCode();
    cuk = "evaluateScore".hashCode();
    cul = "words".hashCode();
    cum = "recommendWxa".hashCode();
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
      if (ctl != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.csU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cst == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (cug == k) {
        this.field_nickName = paramCursor.getString(i);
      } else if (cuh == k) {
        this.field_logo = paramCursor.getString(i);
      } else if (cui == k) {
        this.field_sessionId = paramCursor.getLong(i);
      } else if (cuj == k) {
        this.field_descInfo = paramCursor.getString(i);
      } else if (cuk == k) {
        this.field_evaluateScore = paramCursor.getDouble(i);
      } else if (cul == k) {
        this.field_words = paramCursor.getString(i);
      } else if (cum == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_recommendWxa = ((bjt)new bjt().aH(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          y.e("MicroMsg.SDK.BaseAppBrandRecommendWxa", localIOException.getMessage());
        }
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
    if (this.crV) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.ctZ) {
      localContentValues.put("nickName", this.field_nickName);
    }
    if (this.cua) {
      localContentValues.put("logo", this.field_logo);
    }
    if (this.cub) {
      localContentValues.put("sessionId", Long.valueOf(this.field_sessionId));
    }
    if (this.cuc) {
      localContentValues.put("descInfo", this.field_descInfo);
    }
    if (this.cud) {
      localContentValues.put("evaluateScore", Double.valueOf(this.field_evaluateScore));
    }
    if (this.cue) {
      localContentValues.put("words", this.field_words);
    }
    if ((this.cuf) && (this.field_recommendWxa != null)) {}
    try
    {
      localContentValues.put("recommendWxa", this.field_recommendWxa.toByteArray());
      if (this.ujK > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.ujK));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseAppBrandRecommendWxa", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.o
 * JD-Core Version:    0.7.0.1
 */