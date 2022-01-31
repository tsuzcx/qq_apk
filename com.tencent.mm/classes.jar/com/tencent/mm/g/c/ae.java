package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ae
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgK = "userName".hashCode();
  private static final int dlZ = "qyUin".hashCode();
  private static final int dma = "userUin".hashCode();
  private static final int dmb = "userFlag".hashCode();
  private static final int dmc = "wwExposeTimes".hashCode();
  private static final int dmd = "wwMaxExposeTimes".hashCode();
  private static final int dme = "wwCorpId".hashCode();
  private static final int dmf = "wwUserVid".hashCode();
  private static final int dmg = "userType".hashCode();
  private static final int dmh = "chatOpen".hashCode();
  private static final int dmi = "wwUnreadCnt".hashCode();
  private static final int dmj = "show_confirm".hashCode();
  private static final int dmk = "use_preset_banner_tips".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dgn = true;
  private boolean dlN = true;
  private boolean dlO = true;
  private boolean dlP = true;
  private boolean dlQ = true;
  private boolean dlR = true;
  private boolean dlS = true;
  private boolean dlT = true;
  private boolean dlU = true;
  private boolean dlV = true;
  private boolean dlW = true;
  private boolean dlX = true;
  private boolean dlY = true;
  public boolean field_chatOpen;
  public int field_qyUin;
  public boolean field_show_confirm;
  public boolean field_use_preset_banner_tips;
  public int field_userFlag;
  public String field_userName;
  public int field_userType;
  public int field_userUin;
  public long field_wwCorpId;
  public int field_wwExposeTimes;
  public int field_wwMaxExposeTimes;
  public int field_wwUnreadCnt;
  public long field_wwUserVid;
  
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
      if (dgK != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.dgn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dlZ == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (dma == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (dmb == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (dmc == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (dmd == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (dme == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (dmf == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (dmg == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (dmh == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (dmi == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (dmj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (dmk == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.dlN) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.dlO) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.dlP) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.dlQ) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.dlR) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.dlS) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.dlT) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.dlU) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.dlV) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.dlW) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.dlX) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.dlY) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ae
 * JD-Core Version:    0.7.0.1
 */