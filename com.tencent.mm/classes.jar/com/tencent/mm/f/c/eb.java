package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class eb
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("IPCallRecord");
  public static final Column hTM;
  private static final int hUk = "duration".hashCode();
  private static final int hmC = "status".hashCode();
  public static final Column hmw;
  public static final Column iff;
  public static final Column ifg;
  public static final Column ifh;
  public static final Column ifi;
  private static final int ifn;
  private static final int ifo;
  private static final int ifp = "addressId".hashCode();
  private static final int ifq = "phoneType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  private boolean hTY = true;
  private boolean hmz = true;
  private boolean ifj = true;
  private boolean ifk = true;
  private boolean ifl = true;
  private boolean ifm = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "IPCallRecord", "");
    iff = new Column("phonenumber", "string", "IPCallRecord", "");
    ifg = new Column("calltime", "long", "IPCallRecord", "");
    hTM = new Column("duration", "long", "IPCallRecord", "");
    hmw = new Column("status", "int", "IPCallRecord", "");
    ifh = new Column("addressid", "long", "IPCallRecord", "");
    ifi = new Column("phonetype", "int", "IPCallRecord", "");
    ifn = "phonenumber".hashCode();
    ifo = "calltime".hashCode();
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
      if (ifn != k) {
        break label60;
      }
      this.field_phonenumber = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ifo == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (hUk == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (ifp == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (ifq == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ifj) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.ifk) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.hTY) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ifl) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.ifm) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
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
    return "IPCallRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.eb
 * JD-Core Version:    0.7.0.1
 */