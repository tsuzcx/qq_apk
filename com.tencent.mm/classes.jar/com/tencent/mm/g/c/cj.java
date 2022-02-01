package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cj
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_revoke_id ON FinderRedDotInfo(revokeId)" };
  private static final int eMk = "time".hashCode();
  private static final int eZZ = "tipsId".hashCode();
  private static final int faa = "ctrInfo".hashCode();
  private static final int fab = "revokeId".hashCode();
  private static final int fac = "tipsShowEntranceExtInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eLR = true;
  private boolean eZV = true;
  private boolean eZW = true;
  private boolean eZX = true;
  private boolean eZY = true;
  public aqu field_ctrInfo;
  public String field_revokeId;
  public long field_time;
  public String field_tipsId;
  public asd field_tipsShowEntranceExtInfo;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tipsId";
    locala.IhC.put("tipsId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tipsId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "tipsId";
    locala.columns[1] = "ctrInfo";
    locala.IhC.put("ctrInfo", "BLOB");
    localStringBuilder.append(" ctrInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "time";
    locala.IhC.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "revokeId";
    locala.IhC.put("revokeId", "TEXT");
    localStringBuilder.append(" revokeId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "tipsShowEntranceExtInfo";
    locala.IhC.put("tipsShowEntranceExtInfo", "BLOB");
    localStringBuilder.append(" tipsShowEntranceExtInfo BLOB");
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
      if (eZZ != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.eZV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (faa == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_ctrInfo = ((aqu)new aqu().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
        }
      } else if (eMk == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (fab == k) {
        this.field_revokeId = paramCursor.getString(i);
      } else if (fac == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tipsShowEntranceExtInfo = ((asd)new asd().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eZV) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if ((this.eZW) && (this.field_ctrInfo != null)) {}
    try
    {
      localContentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
      if (this.eLR) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.eZX) {
        localContentValues.put("revokeId", this.field_revokeId);
      }
      if ((!this.eZY) || (this.field_tipsShowEntranceExtInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tipsShowEntranceExtInfo", this.field_tipsShowEntranceExtInfo.toByteArray());
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ad.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cj
 * JD-Core Version:    0.7.0.1
 */