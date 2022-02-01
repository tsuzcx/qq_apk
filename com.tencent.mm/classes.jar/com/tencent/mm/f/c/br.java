package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class br
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_SUBTYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ExptItem");
  public static final Column hHh;
  private static final int hIJ;
  public static final Column hJV;
  public static final Column hJW;
  public static final Column hJX;
  public static final Column hJY;
  public static final Column hJZ;
  private static final int hKf;
  private static final int hKg;
  private static final int hKh;
  private static final int hKi;
  private static final int hKj = "exptCheckSum".hashCode();
  public static final Column hmH;
  public static final Column hmI;
  private static final int hmV;
  private static final int hmW;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int subType_HASHCODE;
  private boolean __hadSetsubType = true;
  public long field_endTime;
  public String field_exptCheckSum;
  public String field_exptContent;
  public int field_exptId;
  public int field_exptSeq;
  public int field_exptType;
  public int field_groupId;
  public long field_startTime;
  public int field_subType;
  private boolean hHV = true;
  private boolean hKa = true;
  private boolean hKb = true;
  private boolean hKc = true;
  private boolean hKd = true;
  private boolean hKe = true;
  private boolean hmO = true;
  private boolean hmP = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ExptItem", "");
    hJV = new Column("exptid", "int", "ExptItem", "");
    hHh = new Column("groupid", "int", "ExptItem", "");
    hJW = new Column("exptseq", "int", "ExptItem", "");
    hJX = new Column("exptcontent", "string", "ExptItem", "");
    hmH = new Column("starttime", "long", "ExptItem", "");
    hmI = new Column("endtime", "long", "ExptItem", "");
    hJY = new Column("expttype", "int", "ExptItem", "");
    C_SUBTYPE = new Column("subtype", "int", "ExptItem", "");
    hJZ = new Column("exptchecksum", "string", "ExptItem", "");
    hKf = "exptId".hashCode();
    hIJ = "groupId".hashCode();
    hKg = "exptSeq".hashCode();
    hKh = "exptContent".hashCode();
    hmV = "startTime".hashCode();
    hmW = "endTime".hashCode();
    hKi = "exptType".hashCode();
    subType_HASHCODE = "subType".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (hKf != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.hKa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hIJ == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (hKg == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (hKh == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (hmV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (hmW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (hKi == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (hKj == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hKa) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.hHV) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.hKb) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.hKc) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.hmO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.hmP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.hKd) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.hKe) {
      localContentValues.put("exptCheckSum", this.field_exptCheckSum);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "ExptItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.br
 * JD-Core Version:    0.7.0.1
 */