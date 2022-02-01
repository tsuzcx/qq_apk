package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class fe
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OpenIMAccTypeInfo");
  public static final Column ipP;
  public static final Column ipQ;
  public static final Column ipR;
  private static final int ipV;
  private static final int ipW;
  private static final int ipX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public az field_accTypeRec;
  public String field_acctTypeId;
  public String field_language;
  public long field_updateTime;
  private boolean ipS = true;
  private boolean ipT = true;
  private boolean ipU = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "OpenIMAccTypeInfo", "");
    ipP = new Column("accttypeid", "string", "OpenIMAccTypeInfo", "");
    ipQ = new Column("language", "string", "OpenIMAccTypeInfo", "");
    ipR = new Column("acctyperec", "proto", "OpenIMAccTypeInfo", "com.tencent.mm.protocal.protobuf.AcctTypeResource");
    C_UPDATETIME = new Column("updatetime", "long", "OpenIMAccTypeInfo", "");
    ipV = "acctTypeId".hashCode();
    ipW = "language".hashCode();
    ipX = "accTypeRec".hashCode();
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
      if (ipV != k) {
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
      if (ipW == k) {
        this.field_language = paramCursor.getString(i);
      } else if (ipX == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_accTypeRec = ((az)new az().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
        }
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ipS) {
      localContentValues.put("acctTypeId", this.field_acctTypeId);
    }
    if (this.ipT) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.ipU) && (this.field_accTypeRec != null)) {}
    try
    {
      localContentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
      if (this.__hadSetupdateTime) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
        Log.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "OpenIMAccTypeInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.fe
 * JD-Core Version:    0.7.0.1
 */