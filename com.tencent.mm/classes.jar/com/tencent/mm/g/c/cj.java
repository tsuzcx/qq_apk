package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cj
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_revoke_id ON FinderRedDotInfo(revokeId)" };
  private static final int eNV = "time".hashCode();
  private static final int fbO = "tipsId".hashCode();
  private static final int fbP = "ctrInfo".hashCode();
  private static final int fbQ = "revokeId".hashCode();
  private static final int fbR = "tipsShowEntranceExtInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNC = true;
  private boolean fbK = true;
  private boolean fbL = true;
  private boolean fbM = true;
  private boolean fbN = true;
  public arj field_ctrInfo;
  public String field_revokeId;
  public long field_time;
  public String field_tipsId;
  public ass field_tipsShowEntranceExtInfo;
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tipsId";
    locala.IBN.put("tipsId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tipsId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "tipsId";
    locala.columns[1] = "ctrInfo";
    locala.IBN.put("ctrInfo", "BLOB");
    localStringBuilder.append(" ctrInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "time";
    locala.IBN.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "revokeId";
    locala.IBN.put("revokeId", "TEXT");
    localStringBuilder.append(" revokeId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "tipsShowEntranceExtInfo";
    locala.IBN.put("tipsShowEntranceExtInfo", "BLOB");
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
      if (fbO != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.fbK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fbP == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_ctrInfo = ((arj)new arj().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ae.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
        }
      } else if (eNV == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (fbQ == k) {
        this.field_revokeId = paramCursor.getString(i);
      } else if (fbR == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tipsShowEntranceExtInfo = ((ass)new ass().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ae.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbK) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if ((this.fbL) && (this.field_ctrInfo != null)) {}
    try
    {
      localContentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
      if (this.eNC) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.fbM) {
        localContentValues.put("revokeId", this.field_revokeId);
      }
      if ((!this.fbN) || (this.field_tipsShowEntranceExtInfo == null)) {}
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
        ae.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ae.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cj
 * JD-Core Version:    0.7.0.1
 */