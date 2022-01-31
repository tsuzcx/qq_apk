package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dkC = "url".hashCode();
  private static final int dkj;
  private static final int dkk;
  private static final int dnQ = "card_type".hashCode();
  private static final int dnR;
  private static final int dnS;
  private static final int dnT;
  private static final int dnU;
  private static final int dnV;
  private static final int dnW;
  private static final int dnX;
  private static final int dnY = "buttonData".hashCode();
  private static final int dnZ = "operData".hashCode();
  private static final int doa = "report_scene".hashCode();
  private static final int dob = "read_state".hashCode();
  private static final int doc = "accept_buttons".hashCode();
  private static final int dod = "consumed_box_id".hashCode();
  private static final int doe = "jump_buttons".hashCode();
  private static final int dof = "logo_color".hashCode();
  private static final int dog = "unavailable_qr_code_list".hashCode();
  private static final int doh = "all_unavailable".hashCode();
  private static final int doi = "need_pull_card_entrance".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dkg = true;
  private boolean dkh = true;
  private boolean dky = true;
  private boolean dnA = true;
  private boolean dnB = true;
  private boolean dnC = true;
  private boolean dnD = true;
  private boolean dnE = true;
  private boolean dnF = true;
  private boolean dnG = true;
  private boolean dnH = true;
  private boolean dnI = true;
  private boolean dnJ = true;
  private boolean dnK = true;
  private boolean dnL = true;
  private boolean dnM = true;
  private boolean dnN = true;
  private boolean dnO = true;
  private boolean dnP = true;
  private boolean dnx = true;
  private boolean dny = true;
  private boolean dnz = true;
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
    dkj = "title".hashCode();
    dkk = "description".hashCode();
    dnR = "logo_url".hashCode();
    dnS = "time".hashCode();
    dnT = "card_id".hashCode();
    dnU = "card_tp_id".hashCode();
    dnV = "msg_id".hashCode();
    dnW = "msg_type".hashCode();
    dnX = "jump_type".hashCode();
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
      if (dnQ != k) {
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
      if (dkj == k)
      {
        this.field_title = paramCursor.getString(i);
      }
      else if (dkk == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (dnR == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (dnS == k)
      {
        this.field_time = paramCursor.getInt(i);
      }
      else if (dnT == k)
      {
        this.field_card_id = paramCursor.getString(i);
      }
      else if (dnU == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (dnV == k)
      {
        this.field_msg_id = paramCursor.getString(i);
        this.dnC = true;
      }
      else if (dnW == k)
      {
        this.field_msg_type = paramCursor.getInt(i);
      }
      else if (dnX == k)
      {
        this.field_jump_type = paramCursor.getInt(i);
      }
      else if (dkC == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (dnY == k)
      {
        this.field_buttonData = paramCursor.getBlob(i);
      }
      else if (dnZ == k)
      {
        this.field_operData = paramCursor.getBlob(i);
      }
      else if (doa == k)
      {
        this.field_report_scene = paramCursor.getInt(i);
      }
      else if (dob == k)
      {
        this.field_read_state = paramCursor.getInt(i);
      }
      else if (doc == k)
      {
        this.field_accept_buttons = paramCursor.getString(i);
      }
      else if (dod == k)
      {
        this.field_consumed_box_id = paramCursor.getString(i);
      }
      else if (doe == k)
      {
        this.field_jump_buttons = paramCursor.getString(i);
      }
      else if (dof == k)
      {
        this.field_logo_color = paramCursor.getString(i);
      }
      else if (dog == k)
      {
        this.field_unavailable_qr_code_list = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (doh == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_all_unavailable = bool;
            break;
          }
        }
        if (doi == k)
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
    if (this.dnx) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.dkh) {
      localContentValues.put("description", this.field_description);
    }
    if (this.dny) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.dnz) {
      localContentValues.put("time", Integer.valueOf(this.field_time));
    }
    if (this.dnA) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.dnB) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.dnC) {
      localContentValues.put("msg_id", this.field_msg_id);
    }
    if (this.dnD) {
      localContentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
    }
    if (this.dnE) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.dky) {
      localContentValues.put("url", this.field_url);
    }
    if (this.dnF) {
      localContentValues.put("buttonData", this.field_buttonData);
    }
    if (this.dnG) {
      localContentValues.put("operData", this.field_operData);
    }
    if (this.dnH) {
      localContentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
    }
    if (this.dnI) {
      localContentValues.put("read_state", Integer.valueOf(this.field_read_state));
    }
    if (this.dnJ) {
      localContentValues.put("accept_buttons", this.field_accept_buttons);
    }
    if (this.dnK) {
      localContentValues.put("consumed_box_id", this.field_consumed_box_id);
    }
    if (this.dnL) {
      localContentValues.put("jump_buttons", this.field_jump_buttons);
    }
    if (this.dnM) {
      localContentValues.put("logo_color", this.field_logo_color);
    }
    if (this.dnN) {
      localContentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
    }
    if (this.dnO) {
      localContentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
    }
    if (this.dnP) {
      localContentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.aj
 * JD-Core Version:    0.7.0.1
 */