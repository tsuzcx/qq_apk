package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.erz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class ez
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("NewTipsInfo");
  public static final Column hvK;
  private static final int hwm = "extInfo".hashCode();
  private static final int ioK;
  private static final int ioL;
  private static final int ioM;
  private static final int ioN;
  private static final int ioO;
  private static final int ioP;
  private static final int ioQ;
  private static final int ioR;
  private static final int ioS;
  private static final int ioT;
  private static final int ioU;
  private static final int ioV = "pagestaytime".hashCode();
  public static final Column iom;
  public static final Column ion;
  public static final Column ioo;
  public static final Column iop;
  public static final Column ioq;
  public static final Column ior;
  public static final Column ios;
  public static final Column iot;
  public static final Column iou;
  public static final Column iov;
  public static final Column iow;
  public static final Column iox;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  public erz field_tipsShowInfo;
  private boolean hvY = true;
  private boolean ioA = true;
  private boolean ioB = true;
  private boolean ioC = true;
  private boolean ioD = true;
  private boolean ioE = true;
  private boolean ioF = true;
  private boolean ioG = true;
  private boolean ioH = true;
  private boolean ioI = true;
  private boolean ioJ = true;
  private boolean ioy = true;
  private boolean ioz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "NewTipsInfo", "");
    iom = new Column("tipid", "int", "NewTipsInfo", "");
    ion = new Column("tipversion", "int", "NewTipsInfo", "");
    ioo = new Column("tipkey", "string", "NewTipsInfo", "");
    iop = new Column("tiptype", "int", "NewTipsInfo", "");
    ioq = new Column("isexit", "boolean", "NewTipsInfo", "");
    ior = new Column("hadread", "boolean", "NewTipsInfo", "");
    ios = new Column("isreject", "boolean", "NewTipsInfo", "");
    iot = new Column("beginshowtime", "long", "NewTipsInfo", "");
    iou = new Column("disappeartime", "long", "NewTipsInfo", "");
    iov = new Column("overduetime", "long", "NewTipsInfo", "");
    iow = new Column("tipsshowinfo", "proto", "NewTipsInfo", "com.tencent.mm.protocal.protobuf.TipsShowInfo");
    hvK = new Column("extinfo", "string", "NewTipsInfo", "");
    iox = new Column("pagestaytime", "long", "NewTipsInfo", "");
    ioK = "tipId".hashCode();
    ioL = "tipVersion".hashCode();
    ioM = "tipkey".hashCode();
    ioN = "tipType".hashCode();
    ioO = "isExit".hashCode();
    ioP = "hadRead".hashCode();
    ioQ = "isReject".hashCode();
    ioR = "beginShowTime".hashCode();
    ioS = "disappearTime".hashCode();
    ioT = "overdueTime".hashCode();
    ioU = "tipsShowInfo".hashCode();
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
      if (ioK != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.ioy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ioL == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (ioM == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (ioN == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (ioO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (ioP == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (ioQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (ioR == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (ioS == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (ioT == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (ioU == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((erz)new erz().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (hwm == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (ioV == k) {
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
    if (this.ioy) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.ioz) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.ioA) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.ioB) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.ioC) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.ioD) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.ioE) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.ioF) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.ioG) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.ioH) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.ioI) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.hvY) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.ioJ) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "NewTipsInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.c.ez
 * JD-Core Version:    0.7.0.1
 */