package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class cw
  extends c
{
  private static final int cSH;
  private static final int cSI;
  private static final int cSJ;
  private static final int cSK;
  private static final int cSL;
  private static final int cSM;
  private static final int cSN;
  private static final int cSO;
  private static final int cSP;
  private static final int cSQ;
  private static final int cSR;
  private static final int cSS = "pagestaytime".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cyC;
  private boolean cSA = true;
  private boolean cSB = true;
  private boolean cSC = true;
  private boolean cSD = true;
  private boolean cSE = true;
  private boolean cSF = true;
  private boolean cSG = true;
  private boolean cSv = true;
  private boolean cSw = true;
  private boolean cSx = true;
  private boolean cSy = true;
  private boolean cSz = true;
  private boolean cyo = true;
  public long field_beginShowTime;
  public long field_disappearTime;
  public String field_extInfo;
  public boolean field_hadRead;
  public boolean field_isExit;
  public boolean field_isReject;
  public long field_overdueTime;
  public long field_pagestaytime;
  public int field_tipId;
  public int field_tipType;
  public int field_tipVersion;
  public String field_tipkey;
  public bxw field_tipsShowInfo;
  
  static
  {
    cSH = "tipId".hashCode();
    cSI = "tipVersion".hashCode();
    cSJ = "tipkey".hashCode();
    cSK = "tipType".hashCode();
    cSL = "isExit".hashCode();
    cSM = "hadRead".hashCode();
    cSN = "isReject".hashCode();
    cSO = "beginShowTime".hashCode();
    cSP = "disappearTime".hashCode();
    cSQ = "overdueTime".hashCode();
    cSR = "tipsShowInfo".hashCode();
    cyC = "extInfo".hashCode();
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
      if (cSH != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.cSv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cSI == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (cSJ == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (cSK == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (cSL == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (cSM == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (cSN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (cSO == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (cSP == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (cSQ == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (cSR == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((bxw)new bxw().aH(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            y.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (cyC == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (cSS == k) {
          this.field_pagestaytime = paramCursor.getLong(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cSv) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.cSw) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.cSx) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.cSy) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.cSz) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.cSA) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.cSB) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.cSC) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.cSD) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.cSE) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.cSF) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.cyo) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.cSG) {
        localContentValues.put("pagestaytime", Long.valueOf(this.field_pagestaytime));
      }
      if (this.ujK > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.ujK));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.cw
 * JD-Core Version:    0.7.0.1
 */