package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class en
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKz = "extInfo".hashCode();
  private static final int fmD = "tipId".hashCode();
  private static final int fmE = "tipVersion".hashCode();
  private static final int fmF = "tipkey".hashCode();
  private static final int fmG = "tipType".hashCode();
  private static final int fmH = "isExit".hashCode();
  private static final int fmI = "hadRead".hashCode();
  private static final int fmJ = "isReject".hashCode();
  private static final int fmK = "beginShowTime".hashCode();
  private static final int fmL = "disappearTime".hashCode();
  private static final int fmM = "overdueTime".hashCode();
  private static final int fmN = "tipsShowInfo".hashCode();
  private static final int fmO = "pagestaytime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKl = true;
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
  public dne field_tipsShowInfo;
  private boolean fmA = true;
  private boolean fmB = true;
  private boolean fmC = true;
  private boolean fmr = true;
  private boolean fms = true;
  private boolean fmt = true;
  private boolean fmu = true;
  private boolean fmv = true;
  private boolean fmw = true;
  private boolean fmx = true;
  private boolean fmy = true;
  private boolean fmz = true;
  
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
      if (fmD != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.fmr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fmE == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (fmF == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (fmG == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fmH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (fmI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (fmJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (fmK == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (fmL == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (fmM == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (fmN == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((dne)new dne().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (eKz == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (fmO == k) {
          this.field_pagestaytime = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fmr) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.fms) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.fmt) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.fmu) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.fmv) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.fmw) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.fmx) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.fmy) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.fmz) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.fmA) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.fmB) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.eKl) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.fmC) {
        localContentValues.put("pagestaytime", Long.valueOf(this.field_pagestaytime));
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.en
 * JD-Core Version:    0.7.0.1
 */