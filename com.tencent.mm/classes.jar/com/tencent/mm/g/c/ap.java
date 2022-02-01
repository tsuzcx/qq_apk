package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ap
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJC;
  private static final int eJD;
  private static final int eJV = "url".hashCode();
  private static final int eNT = "card_type".hashCode();
  private static final int eNU;
  private static final int eNV;
  private static final int eNW;
  private static final int eNX;
  private static final int eNY;
  private static final int eNZ;
  private static final int eOa;
  private static final int eOb = "buttonData".hashCode();
  private static final int eOc = "operData".hashCode();
  private static final int eOd = "report_scene".hashCode();
  private static final int eOe = "read_state".hashCode();
  private static final int eOf = "accept_buttons".hashCode();
  private static final int eOg = "consumed_box_id".hashCode();
  private static final int eOh = "jump_buttons".hashCode();
  private static final int eOi = "logo_color".hashCode();
  private static final int eOj = "unavailable_qr_code_list".hashCode();
  private static final int eOk = "all_unavailable".hashCode();
  private static final int eOl = "need_pull_card_entrance".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJA = true;
  private boolean eJR = true;
  private boolean eJz = true;
  private boolean eNA = true;
  private boolean eNB = true;
  private boolean eNC = true;
  private boolean eND = true;
  private boolean eNE = true;
  private boolean eNF = true;
  private boolean eNG = true;
  private boolean eNH = true;
  private boolean eNI = true;
  private boolean eNJ = true;
  private boolean eNK = true;
  private boolean eNL = true;
  private boolean eNM = true;
  private boolean eNN = true;
  private boolean eNO = true;
  private boolean eNP = true;
  private boolean eNQ = true;
  private boolean eNR = true;
  private boolean eNS = true;
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
    eJC = "title".hashCode();
    eJD = "description".hashCode();
    eNU = "logo_url".hashCode();
    eNV = "time".hashCode();
    eNW = "card_id".hashCode();
    eNX = "card_tp_id".hashCode();
    eNY = "msg_id".hashCode();
    eNZ = "msg_type".hashCode();
    eOa = "jump_type".hashCode();
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
      if (eNT != k) {
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
      if (eJC == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (eJD == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (eNU == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (eNV == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (eNW == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (eNX == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (eNY == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.eNF = true;
      }
      else if (eNZ == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (eOa == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (eJV == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (eOb == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (eOc == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (eOd == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (eOe == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (eOf == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (eOg == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (eOh == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (eOi == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (eOj == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eOk == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (eOl == k)
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
    if (this.eNA) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eJA) {
      localContentValues.put("description", this.field_description);
    }
    if (this.eNB) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.eNC) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.eND) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eNE) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.eNF) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.eNG) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.eNH) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eNI) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.eNJ) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.eNK) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.eNL) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.eNM) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.eNN) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.eNO) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.eNP) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.eNQ) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.eNR) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.eNS) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ap
 * JD-Core Version:    0.7.0.1
 */