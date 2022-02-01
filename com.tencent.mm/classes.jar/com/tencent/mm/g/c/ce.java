package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ce
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)" };
  private static final int eFd = "tipsId".hashCode();
  private static final int eFe = "ctrInfo".hashCode();
  private static final int esJ = "time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFb = true;
  private boolean eFc = true;
  private boolean esq = true;
  public akv field_ctrInfo;
  public long field_time;
  public String field_tipsId;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tipsId";
    locala.EYv.put("tipsId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tipsId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "tipsId";
    locala.columns[1] = "ctrInfo";
    locala.EYv.put("ctrInfo", "BLOB");
    localStringBuilder.append(" ctrInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "time";
    locala.EYv.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    locala.columns[3] = "rowid";
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
      if (eFd != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.eFb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFe == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_ctrInfo = ((akv)new akv().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException.getMessage());
        }
      } else if (esJ == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFb) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if ((this.eFc) && (this.field_ctrInfo != null)) {}
    try
    {
      localContentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
      if (this.esq) {
        localContentValues.put("time", Long.valueOf(this.field_time));
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
        ad.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ce
 * JD-Core Version:    0.7.0.1
 */