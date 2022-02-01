package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class dz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRe = "tipId".hashCode();
  private static final int eRf = "tipVersion".hashCode();
  private static final int eRg = "tipkey".hashCode();
  private static final int eRh = "tipType".hashCode();
  private static final int eRi = "isExit".hashCode();
  private static final int eRj = "hadRead".hashCode();
  private static final int eRk = "isReject".hashCode();
  private static final int eRl = "beginShowTime".hashCode();
  private static final int eRm = "disappearTime".hashCode();
  private static final int eRn = "overdueTime".hashCode();
  private static final int eRo = "tipsShowInfo".hashCode();
  private static final int eRp = "pagestaytime".hashCode();
  private static final int erm = "extInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQS = true;
  private boolean eQT = true;
  private boolean eQU = true;
  private boolean eQV = true;
  private boolean eQW = true;
  private boolean eQX = true;
  private boolean eQY = true;
  private boolean eQZ = true;
  private boolean eRa = true;
  private boolean eRb = true;
  private boolean eRc = true;
  private boolean eRd = true;
  private boolean eqY = true;
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
  public dcc field_tipsShowInfo;
  
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
      if (eRe != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.eQS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eRf == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (eRg == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (eRh == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eRi == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (eRj == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (eRk == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (eRl == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (eRm == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (eRn == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (eRo == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((dcc)new dcc().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (erm == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (eRp == k) {
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
    if (this.eQS) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.eQT) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.eQU) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.eQV) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.eQW) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.eQX) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.eQY) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.eQZ) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.eRa) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.eRb) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.eRc) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.eqY) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.eRd) {
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
 * Qualified Name:     com.tencent.mm.g.c.dz
 * JD-Core Version:    0.7.0.1
 */