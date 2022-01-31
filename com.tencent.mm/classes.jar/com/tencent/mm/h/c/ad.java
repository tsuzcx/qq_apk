package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ad
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cst = "userName".hashCode();
  private static final int cxY = "qyUin".hashCode();
  private static final int cxZ = "userUin".hashCode();
  private static final int cya = "userFlag".hashCode();
  private static final int cyb = "wwExposeTimes".hashCode();
  private static final int cyc = "wwMaxExposeTimes".hashCode();
  private static final int cyd = "wwCorpId".hashCode();
  private static final int cye = "wwUserVid".hashCode();
  private static final int cyf = "userType".hashCode();
  private static final int cyg = "chatOpen".hashCode();
  private static final int cyh = "wwUnreadCnt".hashCode();
  private static final int cyi = "show_confirm".hashCode();
  private static final int cyj = "use_preset_banner_tips".hashCode();
  private boolean crV = true;
  private boolean cxM = true;
  private boolean cxN = true;
  private boolean cxO = true;
  private boolean cxP = true;
  private boolean cxQ = true;
  private boolean cxR = true;
  private boolean cxS = true;
  private boolean cxT = true;
  private boolean cxU = true;
  private boolean cxV = true;
  private boolean cxW = true;
  private boolean cxX = true;
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
      if (cst != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.crV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cxY == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (cxZ == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (cya == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (cyb == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (cyc == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (cyd == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (cye == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (cyf == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (cyg == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (cyh == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (cyi == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (cyj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (crh == k) {
            this.ujK = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crV) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.cxM) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.cxN) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.cxO) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.cxP) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.cxQ) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.cxR) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.cxS) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.cxT) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.cxU) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.cxV) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.cxW) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.cxX) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.ad
 * JD-Core Version:    0.7.0.1
 */