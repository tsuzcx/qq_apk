package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ao
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eqK;
  private static final int eqL;
  private static final int erd = "url".hashCode();
  private static final int euL = "card_type".hashCode();
  private static final int euM;
  private static final int euN;
  private static final int euO;
  private static final int euP;
  private static final int euQ;
  private static final int euR;
  private static final int euS;
  private static final int euT = "buttonData".hashCode();
  private static final int euU = "operData".hashCode();
  private static final int euV = "report_scene".hashCode();
  private static final int euW = "read_state".hashCode();
  private static final int euX = "accept_buttons".hashCode();
  private static final int euY = "consumed_box_id".hashCode();
  private static final int euZ = "jump_buttons".hashCode();
  private static final int eva = "logo_color".hashCode();
  private static final int evb = "unavailable_qr_code_list".hashCode();
  private static final int evc = "all_unavailable".hashCode();
  private static final int evd = "need_pull_card_entrance".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eqH = true;
  private boolean eqI = true;
  private boolean eqZ = true;
  private boolean euA = true;
  private boolean euB = true;
  private boolean euC = true;
  private boolean euD = true;
  private boolean euE = true;
  private boolean euF = true;
  private boolean euG = true;
  private boolean euH = true;
  private boolean euI = true;
  private boolean euJ = true;
  private boolean euK = true;
  private boolean eus = true;
  private boolean eut = true;
  private boolean euu = true;
  private boolean euv = true;
  private boolean euw = true;
  private boolean eux = true;
  private boolean euy = true;
  private boolean euz = true;
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
    eqK = "title".hashCode();
    eqL = "description".hashCode();
    euM = "logo_url".hashCode();
    euN = "time".hashCode();
    euO = "card_id".hashCode();
    euP = "card_tp_id".hashCode();
    euQ = "msg_id".hashCode();
    euR = "msg_type".hashCode();
    euS = "jump_type".hashCode();
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
      if (euL != k) {
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
      if (eqK == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (eqL == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (euM == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (euN == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (euO == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (euP == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (euQ == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.eux = true;
      }
      else if (euR == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (euS == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (erd == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (euT == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (euU == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (euV == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (euW == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (euX == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (euY == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (euZ == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (eva == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (evb == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (evc == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (evd == k)
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
    if (this.eus) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eqI) {
      localContentValues.put("description", this.field_description);
    }
    if (this.eut) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.euu) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.euv) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.euw) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.eux) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.euy) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.euz) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.euA) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.euB) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.euC) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.euD) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.euE) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.euF) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.euG) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.euH) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.euI) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.euJ) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.euK) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ao
 * JD-Core Version:    0.7.0.1
 */