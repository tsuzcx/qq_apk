package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai
  extends c
{
  private static final int cAa = "accept_buttons".hashCode();
  private static final int cAb = "consumed_box_id".hashCode();
  private static final int cAc = "jump_buttons".hashCode();
  private static final int cAd = "logo_color".hashCode();
  private static final int cAe = "unavailable_qr_code_list".hashCode();
  private static final int cAf = "all_unavailable".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cvZ;
  private static final int cwa;
  private static final int cwu;
  private static final int czO = "card_type".hashCode();
  private static final int czP;
  private static final int czQ;
  private static final int czR;
  private static final int czS;
  private static final int czT;
  private static final int czU;
  private static final int czV;
  private static final int czW;
  private static final int czX;
  private static final int czY;
  private static final int czZ;
  private boolean cvV = true;
  private boolean cvW = true;
  private boolean cwp = true;
  private boolean czA = true;
  private boolean czB = true;
  private boolean czC = true;
  private boolean czD = true;
  private boolean czE = true;
  private boolean czF = true;
  private boolean czG = true;
  private boolean czH = true;
  private boolean czI = true;
  private boolean czJ = true;
  private boolean czK = true;
  private boolean czL = true;
  private boolean czM = true;
  private boolean czN = true;
  private boolean czw = true;
  private boolean czx = true;
  private boolean czy = true;
  private boolean czz = true;
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
  public byte[] field_operData;
  public int field_read_state;
  public int field_report_scene;
  public int field_time;
  public String field_title;
  public String field_unavailable_qr_code_list;
  public String field_url;
  
  static
  {
    cvZ = "title".hashCode();
    cwa = "description".hashCode();
    czP = "logo_url".hashCode();
    czQ = "time".hashCode();
    czR = "card_id".hashCode();
    czS = "card_tp_id".hashCode();
    czT = "msg_id".hashCode();
    czU = "msg_type".hashCode();
    czV = "jump_type".hashCode();
    cwu = "url".hashCode();
    czW = "buttonData".hashCode();
    czX = "operData".hashCode();
    czY = "report_scene".hashCode();
    czZ = "read_state".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (czO != k) {
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
      if (cvZ == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (cwa == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (czP == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (czQ == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (czR == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (czS == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (czT == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.czB = true;
      }
      else if (czU == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (czV == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (cwu == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (czW == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (czX == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (czY == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (czZ == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (cAa == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (cAb == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (cAc == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (cAd == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (cAe == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        if (cAf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.czw) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cvW) {
      localContentValues.put("description", this.field_description);
    }
    if (this.czx) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.czy) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.czz) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.czA) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.czB) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.czC) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.czD) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.cwp) {
      localContentValues.put("url", this.field_url);
    }
    if (this.czE) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.czF) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.czG) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.czH) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.czI) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.czJ) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.czK) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.czL) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.czM) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.czN) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.ai
 * JD-Core Version:    0.7.0.1
 */