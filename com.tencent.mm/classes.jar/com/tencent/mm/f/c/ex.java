package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class ex
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ID;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("MultiTaskInfo");
  private static final int createTime_HASHCODE;
  public static final Column hoE;
  private static final int hoM = "data".hashCode();
  private static final int id_HASHCODE;
  public static final Column ime;
  private static final int imh;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public long field_createTime;
  public byte[] field_data;
  public String field_id;
  public dar field_showData;
  public int field_type;
  public long field_updateTime;
  private boolean hoI = true;
  private boolean imf = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "MultiTaskInfo", "");
    C_ID = new Column("id", "string", "MultiTaskInfo", "");
    C_TYPE = new Column("type", "int", "MultiTaskInfo", "");
    C_CREATETIME = new Column("createtime", "long", "MultiTaskInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "MultiTaskInfo", "");
    ime = new Column("showdata", "proto", "MultiTaskInfo", "com.tencent.mm.protocal.protobuf.MultiTaskShowData");
    hoE = new Column("data", "byte[]", "MultiTaskInfo", "");
    id_HASHCODE = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    imh = "showData".hashCode();
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (imh == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_showData = ((dar)new dar().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseMultiTaskInfo", localIOException.getMessage());
        }
      } else if (hoM == k) {
        this.field_data = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.imf) && (this.field_showData != null)) {}
    try
    {
      localContentValues.put("showData", this.field_showData.toByteArray());
      if (this.hoI) {
        localContentValues.put("data", this.field_data);
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
        Log.e("MicroMsg.SDK.BaseMultiTaskInfo", localIOException.getMessage());
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "MultiTaskInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ex
 * JD-Core Version:    0.7.0.1
 */