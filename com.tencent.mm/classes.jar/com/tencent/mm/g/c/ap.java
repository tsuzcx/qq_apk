package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ap
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHT;
  private static final int eHU;
  private static final int eIm;
  private static final int eMA = "need_pull_card_entrance".hashCode();
  private static final int eMi = "card_type".hashCode();
  private static final int eMj;
  private static final int eMk;
  private static final int eMl;
  private static final int eMm;
  private static final int eMn;
  private static final int eMo;
  private static final int eMp;
  private static final int eMq;
  private static final int eMr;
  private static final int eMs;
  private static final int eMt;
  private static final int eMu;
  private static final int eMv;
  private static final int eMw;
  private static final int eMx;
  private static final int eMy;
  private static final int eMz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHQ = true;
  private boolean eHR = true;
  private boolean eIi = true;
  private boolean eLP = true;
  private boolean eLQ = true;
  private boolean eLR = true;
  private boolean eLS = true;
  private boolean eLT = true;
  private boolean eLU = true;
  private boolean eLV = true;
  private boolean eLW = true;
  private boolean eLX = true;
  private boolean eLY = true;
  private boolean eLZ = true;
  private boolean eMa = true;
  private boolean eMb = true;
  private boolean eMc = true;
  private boolean eMd = true;
  private boolean eMe = true;
  private boolean eMf = true;
  private boolean eMg = true;
  private boolean eMh = true;
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
  
  static
  {
    eHT = "title".hashCode();
    eHU = "description".hashCode();
    eMj = "logo_url".hashCode();
    eMk = "time".hashCode();
    eMl = "card_id".hashCode();
    eMm = "card_tp_id".hashCode();
    eMn = "msg_id".hashCode();
    eMo = "msg_type".hashCode();
    eMp = "jump_type".hashCode();
    eIm = "url".hashCode();
    eMq = "buttonData".hashCode();
    eMr = "operData".hashCode();
    eMs = "report_scene".hashCode();
    eMt = "read_state".hashCode();
    eMu = "accept_buttons".hashCode();
    eMv = "consumed_box_id".hashCode();
    eMw = "jump_buttons".hashCode();
    eMx = "logo_color".hashCode();
    eMy = "unavailable_qr_code_list".hashCode();
    eMz = "all_unavailable".hashCode();
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
      if (eMi != k) {
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
      if (eHT == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (eHU == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (eMj == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (eMk == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (eMl == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (eMm == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (eMn == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.eLU = true;
      }
      else if (eMo == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (eMp == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (eIm == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (eMq == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (eMr == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (eMs == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (eMt == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (eMu == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (eMv == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (eMw == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (eMx == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (eMy == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eMz == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (eMA == k)
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
    if (this.eLP) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eHR) {
      localContentValues.put("description", this.field_description);
    }
    if (this.eLQ) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.eLR) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.eLS) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eLT) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.eLU) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.eLV) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.eLW) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.eIi) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eLX) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.eLY) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.eLZ) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.eMa) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.eMb) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.eMc) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.eMd) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.eMe) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.eMf) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.eMg) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.eMh) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ap
 * JD-Core Version:    0.7.0.1
 */