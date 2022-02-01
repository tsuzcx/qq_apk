package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class ff
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OpenIMAppIdInfo");
  public static final Column hnz;
  public static final Column ipP;
  public static final Column ipQ;
  private static final int ipV = "acctTypeId".hashCode();
  private static final int ipW;
  public static final Column ipY;
  private static final int iqb;
  private static final int iqc;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_acctTypeId;
  public ew field_appRec;
  public String field_appid;
  public String field_language;
  public long field_updateTime;
  private boolean ipS = true;
  private boolean ipT = true;
  private boolean ipZ = true;
  private boolean iqa = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "OpenIMAppIdInfo", "");
    hnz = new Column("appid", "string", "OpenIMAppIdInfo", "");
    ipQ = new Column("language", "string", "OpenIMAppIdInfo", "");
    ipY = new Column("apprec", "proto", "OpenIMAppIdInfo", "com.tencent.mm.protocal.protobuf.AppIdResource");
    C_UPDATETIME = new Column("updatetime", "long", "OpenIMAppIdInfo", "");
    ipP = new Column("accttypeid", "string", "OpenIMAppIdInfo", "");
    iqb = "appid".hashCode();
    ipW = "language".hashCode();
    iqc = "appRec".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (iqb != k) {
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
      if (ipW == k) {
        this.field_language = paramCursor.getString(i);
      } else if (iqc == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_appRec = ((ew)new ew().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
        }
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (ipV == k) {
        this.field_acctTypeId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ipZ) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.ipT) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.iqa) && (this.field_appRec != null)) {}
    try
    {
      localContentValues.put("appRec", this.field_appRec.toByteArray());
      if (this.__hadSetupdateTime) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
      }
      if (this.ipS) {
        localContentValues.put("acctTypeId", this.field_acctTypeId);
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
        Log.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "OpenIMAppIdInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ff
 * JD-Core Version:    0.7.0.1
 */