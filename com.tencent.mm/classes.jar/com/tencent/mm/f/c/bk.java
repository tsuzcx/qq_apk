package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bk
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmojiInfoDesc");
  public static final Column hFS;
  private static final int hGS;
  public static final Column hGW;
  public static final Column hHh;
  private static final int hIJ = "groupId".hashCode();
  private static final int hIy;
  public static final Column hJm;
  public static final Column hJn;
  public static final Column hJo;
  public static final Column hJp;
  private static final int hJu;
  private static final int hJv;
  private static final int hJw = "click_flag".hashCode();
  private static final int hJx = "download_flag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  private boolean hGs = true;
  private boolean hHK = true;
  private boolean hHV = true;
  private boolean hJq = true;
  private boolean hJr = true;
  private boolean hJs = true;
  private boolean hJt = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmojiInfoDesc", "");
    hJm = new Column("md5_lang", "string", "EmojiInfoDesc", "");
    hGW = new Column("md5", "string", "EmojiInfoDesc", "");
    hFS = new Column("lang", "string", "EmojiInfoDesc", "");
    hJn = new Column("desc", "string", "EmojiInfoDesc", "");
    hHh = new Column("groupid", "string", "EmojiInfoDesc", "");
    hJo = new Column("click_flag", "int", "EmojiInfoDesc", "");
    hJp = new Column("download_flag", "int", "EmojiInfoDesc", "");
    hJu = "md5_lang".hashCode();
    hIy = "md5".hashCode();
    hGS = "lang".hashCode();
    hJv = "desc".hashCode();
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
      if (hJu != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.hJq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hIy == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (hGS == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (hJv == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (hIJ == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (hJw == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (hJx == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hJq) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hGs) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.hJr) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.hHV) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.hJs) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.hJt) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
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
    return "EmojiInfoDesc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.bk
 * JD-Core Version:    0.7.0.1
 */