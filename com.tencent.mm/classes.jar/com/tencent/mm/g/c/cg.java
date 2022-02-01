package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cg
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_revoke_id ON FinderRedDotInfo(revokeId)" };
  private static final int eHT = "tipsId".hashCode();
  private static final int eHU = "ctrInfo".hashCode();
  private static final int eHV = "revokeId".hashCode();
  private static final int eHW = "tipsShowEntranceExtInfo".hashCode();
  private static final int euN = "time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHP = true;
  private boolean eHQ = true;
  private boolean eHR = true;
  private boolean eHS = true;
  private boolean euu = true;
  public ani field_ctrInfo;
  public String field_revokeId;
  public long field_time;
  public String field_tipsId;
  public aom field_tipsShowEntranceExtInfo;
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tipsId";
    locala.GvH.put("tipsId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tipsId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "tipsId";
    locala.columns[1] = "ctrInfo";
    locala.GvH.put("ctrInfo", "BLOB");
    localStringBuilder.append(" ctrInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "time";
    locala.GvH.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "revokeId";
    locala.GvH.put("revokeId", "TEXT");
    localStringBuilder.append(" revokeId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "tipsShowEntranceExtInfo";
    locala.GvH.put("tipsShowEntranceExtInfo", "BLOB");
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
      if (eHT != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.eHP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eHU == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_ctrInfo = ((ani)new ani().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ac.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
        }
      } else if (euN == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (eHV == k) {
        this.field_revokeId = paramCursor.getString(i);
      } else if (eHW == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tipsShowEntranceExtInfo = ((aom)new aom().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ac.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eHP) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if ((this.eHQ) && (this.field_ctrInfo != null)) {}
    try
    {
      localContentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
      if (this.euu) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.eHR) {
        localContentValues.put("revokeId", this.field_revokeId);
      }
      if ((!this.eHS) || (this.field_tipsShowEntranceExtInfo == null)) {}
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
        ac.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.cg
 * JD-Core Version:    0.7.0.1
 */