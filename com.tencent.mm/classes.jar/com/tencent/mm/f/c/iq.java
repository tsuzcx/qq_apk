package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class iq
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxagGameInfo");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int hVT;
  public static final Column hnz;
  public static final Column hpM;
  private static final int hpW;
  public static final Column hpi;
  public static final Column hqn;
  public static final Column iOa;
  public static final Column iOb;
  public static final Column iOc;
  private static final int iOd;
  private static final int iOe;
  private static final int iOf;
  private static final int iOg;
  private static final int iOh;
  private static final int iOi;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_AppId;
  public String field_AppName;
  public String field_BriefIntro;
  public String field_IconUrl;
  public String field_RecordId;
  public String field_UserName;
  public long field_createTime;
  public int field_debugType;
  public boolean field_isSync;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxagGameInfo", "");
    hpi = new Column("recordid", "string", "WxagGameInfo", "");
    hnz = new Column("appid", "string", "WxagGameInfo", "");
    hqn = new Column("appname", "string", "WxagGameInfo", "");
    C_USERNAME = new Column("username", "string", "WxagGameInfo", "");
    iOa = new Column("iconurl", "string", "WxagGameInfo", "");
    iOb = new Column("briefintro", "string", "WxagGameInfo", "");
    iOc = new Column("issync", "boolean", "WxagGameInfo", "");
    hpM = new Column("debugtype", "int", "WxagGameInfo", "");
    C_CREATETIME = new Column("createtime", "long", "WxagGameInfo", "");
    iOd = "RecordId".hashCode();
    iOe = "AppId".hashCode();
    iOf = "AppName".hashCode();
    hVT = "UserName".hashCode();
    iOg = "IconUrl".hashCode();
    iOh = "BriefIntro".hashCode();
    iOi = "isSync".hashCode();
    hpW = "debugType".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        int k = arrayOfString[i].hashCode();
        if (iOd == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (iOe == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (iOf == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hVT == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (iOg == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (iOh == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (iOi == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (hpW == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (createTime_HASHCODE == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
        i += 1;
      }
    }
  }
  
  public ContentValues convertTo()
  {
    new ContentValues();
    throw null;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WxagGameInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.iq
 * JD-Core Version:    0.7.0.1
 */