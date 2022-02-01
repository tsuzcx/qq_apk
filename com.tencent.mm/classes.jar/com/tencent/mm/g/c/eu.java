package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ehx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class eu
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fTj = "tipId".hashCode();
  private static final int fTk = "tipVersion".hashCode();
  private static final int fTl = "tipkey".hashCode();
  private static final int fTm = "tipType".hashCode();
  private static final int fTn = "isExit".hashCode();
  private static final int fTo = "hadRead".hashCode();
  private static final int fTp = "isReject".hashCode();
  private static final int fTq = "beginShowTime".hashCode();
  private static final int fTr = "disappearTime".hashCode();
  private static final int fTs = "overdueTime".hashCode();
  private static final int fTt = "tipsShowInfo".hashCode();
  private static final int fTu = "pagestaytime".hashCode();
  private static final int fpP = "extInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fSX = true;
  private boolean fSY = true;
  private boolean fSZ = true;
  private boolean fTa = true;
  private boolean fTb = true;
  private boolean fTc = true;
  private boolean fTd = true;
  private boolean fTe = true;
  private boolean fTf = true;
  private boolean fTg = true;
  private boolean fTh = true;
  private boolean fTi = true;
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
  public ehx field_tipsShowInfo;
  private boolean fpB = true;
  
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
      if (fTj != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.fSX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fTk == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (fTl == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (fTm == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fTn == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (fTo == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (fTp == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (fTq == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (fTr == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (fTs == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (fTt == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((ehx)new ehx().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (fpP == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (fTu == k) {
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
    if (this.fSX) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.fSY) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.fSZ) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.fTa) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.fTb) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.fTc) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.fTd) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.fTe) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.fTf) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.fTg) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.fTh) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.fpB) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.fTi) {
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
        Log.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.eu
 * JD-Core Version:    0.7.0.1
 */