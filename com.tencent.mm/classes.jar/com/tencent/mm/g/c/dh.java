package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class dh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dIR = "tipId".hashCode();
  private static final int dIS = "tipVersion".hashCode();
  private static final int dIT = "tipkey".hashCode();
  private static final int dIU = "tipType".hashCode();
  private static final int dIV = "isExit".hashCode();
  private static final int dIW = "hadRead".hashCode();
  private static final int dIX = "isReject".hashCode();
  private static final int dIY = "beginShowTime".hashCode();
  private static final int dIZ = "disappearTime".hashCode();
  private static final int dJa = "overdueTime".hashCode();
  private static final int dJb = "tipsShowInfo".hashCode();
  private static final int dJc = "pagestaytime".hashCode();
  private static final int dmD = "extInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dIF = true;
  private boolean dIG = true;
  private boolean dIH = true;
  private boolean dII = true;
  private boolean dIJ = true;
  private boolean dIK = true;
  private boolean dIL = true;
  private boolean dIM = true;
  private boolean dIN = true;
  private boolean dIO = true;
  private boolean dIP = true;
  private boolean dIQ = true;
  private boolean dmp = true;
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
  public ckh field_tipsShowInfo;
  
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
      if (dIR != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.dIF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dIS == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (dIT == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (dIU == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (dIV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (dIW == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (dIX == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (dIY == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (dIZ == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (dJa == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (dJb == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((ckh)new ckh().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            ab.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (dmD == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (dJc == k) {
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
    if (this.dIF) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.dIG) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.dIH) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.dII) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.dIJ) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.dIK) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.dIL) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.dIM) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.dIN) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.dIO) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.dIP) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.dmp) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.dIQ) {
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
        ab.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.dh
 * JD-Core Version:    0.7.0.1
 */