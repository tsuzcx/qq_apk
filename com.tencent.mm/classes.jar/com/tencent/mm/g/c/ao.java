package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ao
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eoG;
  private static final int eoH;
  private static final int eoZ = "url".hashCode();
  private static final int esH = "card_type".hashCode();
  private static final int esI;
  private static final int esJ;
  private static final int esK;
  private static final int esL;
  private static final int esM;
  private static final int esN;
  private static final int esO;
  private static final int esP = "buttonData".hashCode();
  private static final int esQ = "operData".hashCode();
  private static final int esR = "report_scene".hashCode();
  private static final int esS = "read_state".hashCode();
  private static final int esT = "accept_buttons".hashCode();
  private static final int esU = "consumed_box_id".hashCode();
  private static final int esV = "jump_buttons".hashCode();
  private static final int esW = "logo_color".hashCode();
  private static final int esX = "unavailable_qr_code_list".hashCode();
  private static final int esY = "all_unavailable".hashCode();
  private static final int esZ = "need_pull_card_entrance".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eoD = true;
  private boolean eoE = true;
  private boolean eoV = true;
  private boolean esA = true;
  private boolean esB = true;
  private boolean esC = true;
  private boolean esD = true;
  private boolean esE = true;
  private boolean esF = true;
  private boolean esG = true;
  private boolean eso = true;
  private boolean esp = true;
  private boolean esq = true;
  private boolean esr = true;
  private boolean ess = true;
  private boolean est = true;
  private boolean esu = true;
  private boolean esv = true;
  private boolean esw = true;
  private boolean esx = true;
  private boolean esy = true;
  private boolean esz = true;
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
    eoG = "title".hashCode();
    eoH = "description".hashCode();
    esI = "logo_url".hashCode();
    esJ = "time".hashCode();
    esK = "card_id".hashCode();
    esL = "card_tp_id".hashCode();
    esM = "msg_id".hashCode();
    esN = "msg_type".hashCode();
    esO = "jump_type".hashCode();
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
      if (esH != k) {
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
      if (eoG == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (eoH == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (esI == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (esJ == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (esK == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (esL == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (esM == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.est = true;
      }
      else if (esN == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (esO == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (eoZ == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (esP == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (esQ == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (esR == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (esS == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (esT == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (esU == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (esV == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (esW == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (esX == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (esY == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (esZ == k)
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
    if (this.eso) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eoE) {
      localContentValues.put("description", this.field_description);
    }
    if (this.esp) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.esq) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.esr) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.ess) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.est) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.esu) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.esv) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.eoV) {
      localContentValues.put("url", this.field_url);
    }
    if (this.esw) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.esx) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.esy) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.esz) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.esA) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.esB) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.esC) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.esD) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.esE) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.esF) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.esG) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ao
 * JD-Core Version:    0.7.0.1
 */