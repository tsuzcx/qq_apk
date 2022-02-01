package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class aq
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fnB = "url".hashCode();
  private static final int fne;
  private static final int fnf;
  private static final int frA = "card_type".hashCode();
  private static final int frB;
  private static final int frC;
  private static final int frD;
  private static final int frE;
  private static final int frF;
  private static final int frG;
  private static final int frH;
  private static final int frI = "buttonData".hashCode();
  private static final int frJ = "operData".hashCode();
  private static final int frK = "report_scene".hashCode();
  private static final int frL = "read_state".hashCode();
  private static final int frM = "accept_buttons".hashCode();
  private static final int frN = "consumed_box_id".hashCode();
  private static final int frO = "jump_buttons".hashCode();
  private static final int frP = "logo_color".hashCode();
  private static final int frQ = "unavailable_qr_code_list".hashCode();
  private static final int frR = "all_unavailable".hashCode();
  private static final int frS = "need_pull_card_entrance".hashCode();
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
  private boolean fnb = true;
  private boolean fnc = true;
  private boolean fnx = true;
  private boolean frh = true;
  private boolean fri = true;
  private boolean frj = true;
  private boolean frk = true;
  private boolean frl = true;
  private boolean frm = true;
  private boolean frn = true;
  private boolean fro = true;
  private boolean frp = true;
  private boolean frq = true;
  private boolean frr = true;
  private boolean frs = true;
  private boolean frt = true;
  private boolean fru = true;
  private boolean frv = true;
  private boolean frw = true;
  private boolean frx = true;
  private boolean fry = true;
  private boolean frz = true;
  
  static
  {
    fne = "title".hashCode();
    fnf = "description".hashCode();
    frB = "logo_url".hashCode();
    frC = "time".hashCode();
    frD = "card_id".hashCode();
    frE = "card_tp_id".hashCode();
    frF = "msg_id".hashCode();
    frG = "msg_type".hashCode();
    frH = "jump_type".hashCode();
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
      if (frA != k) {
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
      if (fne == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (fnf == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (frB == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (frC == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (frD == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (frE == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (frF == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.frm = true;
      }
      else if (frG == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (frH == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (fnB == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (frI == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (frJ == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (frK == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (frL == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (frM == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (frN == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (frO == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (frP == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (frQ == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (frR == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (frS == k)
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
    if (this.frh) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fnc) {
      localContentValues.put("description", this.field_description);
    }
    if (this.fri) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.frj) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.frk) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.frl) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.frm) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.frn) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.fro) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.frp) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.frq) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.frr) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.frs) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.frt) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.fru) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.frv) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.frw) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.frx) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.fry) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.frz) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.aq
 * JD-Core Version:    0.7.0.1
 */