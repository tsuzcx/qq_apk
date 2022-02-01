package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class en
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eMi = "extInfo".hashCode();
  private static final int foD = "tipId".hashCode();
  private static final int foE = "tipVersion".hashCode();
  private static final int foF = "tipkey".hashCode();
  private static final int foG = "tipType".hashCode();
  private static final int foH = "isExit".hashCode();
  private static final int foI = "hadRead".hashCode();
  private static final int foJ = "isReject".hashCode();
  private static final int foK = "beginShowTime".hashCode();
  private static final int foL = "disappearTime".hashCode();
  private static final int foM = "overdueTime".hashCode();
  private static final int foN = "tipsShowInfo".hashCode();
  private static final int foO = "pagestaytime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eLU = true;
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
  public dob field_tipsShowInfo;
  private boolean foA = true;
  private boolean foB = true;
  private boolean foC = true;
  private boolean jdField_for = true;
  private boolean fos = true;
  private boolean fot = true;
  private boolean fou = true;
  private boolean fov = true;
  private boolean fow = true;
  private boolean fox = true;
  private boolean foy = true;
  private boolean foz = true;
  
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
      if (foD != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.jdField_for = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (foE == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (foF == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (foG == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (foH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (foI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (foJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (foK == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (foL == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (foM == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (foN == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((dob)new dob().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            ae.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (eMi == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (foO == k) {
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
    if (this.jdField_for) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.fos) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.fot) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.fou) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.fov) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.fow) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.fox) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.foy) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.foz) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.foA) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.foB) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.eLU) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.foC) {
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
        ae.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.en
 * JD-Core Version:    0.7.0.1
 */