package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class aq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("CardMsgInfo");
  public static final Column hsH;
  private static final int hsP = "url".hashCode();
  public static final Column hsa;
  public static final Column hsb;
  private static final int hsg;
  private static final int hsh;
  public static final Column hxX;
  public static final Column hxY;
  public static final Column hxZ;
  private static final int hyJ;
  private static final int hyK;
  private static final int hyL;
  private static final int hyM;
  private static final int hyN;
  private static final int hyO;
  private static final int hyP;
  private static final int hyQ;
  private static final int hyR = "buttonData".hashCode();
  private static final int hyS = "operData".hashCode();
  private static final int hyT = "report_scene".hashCode();
  private static final int hyU = "read_state".hashCode();
  private static final int hyV = "accept_buttons".hashCode();
  private static final int hyW = "consumed_box_id".hashCode();
  private static final int hyX = "jump_buttons".hashCode();
  private static final int hyY = "logo_color".hashCode();
  private static final int hyZ = "unavailable_qr_code_list".hashCode();
  public static final Column hya;
  public static final Column hyb;
  public static final Column hyc;
  public static final Column hyd;
  public static final Column hye;
  public static final Column hyf;
  public static final Column hyg;
  public static final Column hyh;
  public static final Column hyi;
  public static final Column hyj;
  public static final Column hyk;
  public static final Column hyl;
  public static final Column hym;
  public static final Column hyn;
  public static final Column hyo;
  public static final Column hyp;
  private static final int hza = "all_unavailable".hashCode();
  private static final int hzb = "need_pull_card_entrance".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_accept_buttons;
  public boolean field_all_unavailable;
  public byte[] field_buttonData;
  public String field_card_id;
  public String field_card_tp_id;
  public int field_card_type;
  public String field_consumed_box_id;
  public String field_description;
  public String field_jump_buttons;
  public int field_jump_type;
  public String field_logo_color;
  public String field_logo_url;
  public String field_msg_id;
  public int field_msg_type;
  public boolean field_need_pull_card_entrance;
  public byte[] field_operData;
  public int field_read_state;
  public int field_report_scene;
  public int field_time;
  public String field_title;
  public String field_unavailable_qr_code_list;
  public String field_url;
  private boolean hsL = true;
  private boolean hsd = true;
  private boolean hse = true;
  private boolean hyA = true;
  private boolean hyB = true;
  private boolean hyC = true;
  private boolean hyD = true;
  private boolean hyE = true;
  private boolean hyF = true;
  private boolean hyG = true;
  private boolean hyH = true;
  private boolean hyI = true;
  private boolean hyq = true;
  private boolean hyr = true;
  private boolean hys = true;
  private boolean hyt = true;
  private boolean hyu = true;
  private boolean hyv = true;
  private boolean hyw = true;
  private boolean hyx = true;
  private boolean hyy = true;
  private boolean hyz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "CardMsgInfo", "");
    hxX = new Column("card_type", "int", "CardMsgInfo", "");
    hsa = new Column("title", "string", "CardMsgInfo", "");
    hsb = new Column("description", "string", "CardMsgInfo", "");
    hxY = new Column("logo_url", "string", "CardMsgInfo", "");
    hxZ = new Column("time", "int", "CardMsgInfo", "");
    hya = new Column("card_id", "string", "CardMsgInfo", "");
    hyb = new Column("card_tp_id", "string", "CardMsgInfo", "");
    hyc = new Column("msg_id", "string", "CardMsgInfo", "");
    hyd = new Column("msg_type", "int", "CardMsgInfo", "");
    hye = new Column("jump_type", "int", "CardMsgInfo", "");
    hsH = new Column("url", "string", "CardMsgInfo", "");
    hyf = new Column("buttondata", "byte[]", "CardMsgInfo", "");
    hyg = new Column("operdata", "byte[]", "CardMsgInfo", "");
    hyh = new Column("report_scene", "int", "CardMsgInfo", "");
    hyi = new Column("read_state", "int", "CardMsgInfo", "");
    hyj = new Column("accept_buttons", "string", "CardMsgInfo", "");
    hyk = new Column("consumed_box_id", "string", "CardMsgInfo", "");
    hyl = new Column("jump_buttons", "string", "CardMsgInfo", "");
    hym = new Column("logo_color", "string", "CardMsgInfo", "");
    hyn = new Column("unavailable_qr_code_list", "string", "CardMsgInfo", "");
    hyo = new Column("all_unavailable", "boolean", "CardMsgInfo", "");
    hyp = new Column("need_pull_card_entrance", "boolean", "CardMsgInfo", "");
    hyJ = "card_type".hashCode();
    hsg = "title".hashCode();
    hsh = "description".hashCode();
    hyK = "logo_url".hashCode();
    hyL = "time".hashCode();
    hyM = "card_id".hashCode();
    hyN = "card_tp_id".hashCode();
    hyO = "msg_id".hashCode();
    hyP = "msg_type".hashCode();
    hyQ = "jump_type".hashCode();
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
      if (hyJ != k) {
        break label60;
      }
      this.field_card_type = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hsg == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (hsh == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (hyK == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (hyL == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (hyM == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (hyN == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (hyO == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.hyv = true;
      }
      else if (hyP == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (hyQ == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (hsP == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (hyR == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (hyS == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (hyT == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (hyU == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (hyV == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (hyW == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (hyX == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (hyY == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (hyZ == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (hza == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (hzb == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_need_pull_card_entrance = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hyq) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.hse) {
      localContentValues.put("description", this.field_description);
    }
    if (this.hyr) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.hys) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.hyt) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.hyu) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.hyv) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.hyw) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.hyx) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.hyy) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.hyz) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.hyA) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.hyB) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.hyC) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.hyD) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.hyE) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.hyF) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.hyG) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.hyH) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.hyI) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
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
    return "CardMsgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.aq
 * JD-Core Version:    0.7.0.1
 */