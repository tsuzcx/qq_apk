package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class ed
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eUo = "tipId".hashCode();
  private static final int eUp = "tipVersion".hashCode();
  private static final int eUq = "tipkey".hashCode();
  private static final int eUr = "tipType".hashCode();
  private static final int eUs = "isExit".hashCode();
  private static final int eUt = "hadRead".hashCode();
  private static final int eUu = "isReject".hashCode();
  private static final int eUv = "beginShowTime".hashCode();
  private static final int eUw = "disappearTime".hashCode();
  private static final int eUx = "overdueTime".hashCode();
  private static final int eUy = "tipsShowInfo".hashCode();
  private static final int eUz = "pagestaytime".hashCode();
  private static final int etq = "extInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eUc = true;
  private boolean eUd = true;
  private boolean eUe = true;
  private boolean eUf = true;
  private boolean eUg = true;
  private boolean eUh = true;
  private boolean eUi = true;
  private boolean eUj = true;
  private boolean eUk = true;
  private boolean eUl = true;
  private boolean eUm = true;
  private boolean eUn = true;
  private boolean etc = true;
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
  public dhp field_tipsShowInfo;
  
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
      if (eUo != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.eUc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUp == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (eUq == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (eUr == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eUs == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (eUt == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (eUu == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (eUv == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (eUw == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (eUx == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (eUy == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((dhp)new dhp().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            ac.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (etq == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (eUz == k) {
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
    if (this.eUc) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.eUd) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.eUe) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.eUf) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.eUg) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.eUh) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.eUi) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.eUj) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.eUk) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.eUl) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.eUm) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.etc) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.eUn) {
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
        ac.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ed
 * JD-Core Version:    0.7.0.1
 */