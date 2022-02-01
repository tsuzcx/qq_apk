package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class cj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDV = "actionTime".hashCode();
  private static final int eGA;
  private static final int eGB;
  private static final int eGC = "delayTime".hashCode();
  private static final int eGD = "retryCount".hashCode();
  private static final int eGE = "retryCountLimit".hashCode();
  private static final int eGF = "businessInfo".hashCode();
  private static final int eGG = "opCode".hashCode();
  private static final int eGp = "cgi".hashCode();
  private static final int eGq = "cmdid".hashCode();
  private static final int eGr = "functionmsgid".hashCode();
  private static final int eGs;
  private static final int eGt;
  private static final int eGu;
  private static final int eGv;
  private static final int eGw;
  private static final int eGx;
  private static final int eGy;
  private static final int eGz;
  private static final int ejR;
  private static final int emV = "version".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDL = true;
  private boolean eFX = true;
  private boolean eFY = true;
  private boolean eFZ = true;
  private boolean eGa = true;
  private boolean eGb = true;
  private boolean eGc = true;
  private boolean eGd = true;
  private boolean eGe = true;
  private boolean eGf = true;
  private boolean eGg = true;
  private boolean eGh = true;
  private boolean eGi = true;
  private boolean eGj = true;
  private boolean eGk = true;
  private boolean eGl = true;
  private boolean eGm = true;
  private boolean eGn = true;
  private boolean eGo = true;
  private boolean ejO = true;
  private boolean emQ = true;
  public long field_actionTime;
  public cs field_addMsg;
  public pi field_businessInfo;
  public String field_cgi;
  public int field_cmdid;
  public String field_custombuff;
  public String field_defaultContent;
  public long field_delayTime;
  public int field_failkey;
  public int field_finalfailkey;
  public String field_functionmsgid;
  public boolean field_needShow;
  public int field_opCode;
  public long field_preVersion;
  public int field_reportid;
  public int field_retryCount;
  public int field_retryCountLimit;
  public int field_retryinterval;
  public int field_status;
  public int field_successkey;
  public long field_version;
  
  static
  {
    eGs = "preVersion".hashCode();
    eGt = "retryinterval".hashCode();
    eGu = "reportid".hashCode();
    eGv = "successkey".hashCode();
    eGw = "failkey".hashCode();
    eGx = "finalfailkey".hashCode();
    eGy = "custombuff".hashCode();
    eGz = "addMsg".hashCode();
    ejR = "status".hashCode();
    eGA = "needShow".hashCode();
    eGB = "defaultContent".hashCode();
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
      if (eGp != k) {
        break label60;
      }
      this.field_cgi = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eGq == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (eGr == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.eFZ = true;
      }
      else if (emV == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (eGs == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (eGt == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (eGu == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (eGv == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (eGw == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (eGx == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (eGy == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (eGz == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((cs)new cs().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (ejR == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (eGA == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (eGB == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (eDV == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (eGC == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (eGD == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (eGE == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (eGF == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((pi)new pi().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (eGG == k) {
          this.field_opCode = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFX) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.eFY) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.eFZ) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.emQ) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.eGa) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.eGb) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.eGc) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.eGd) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.eGe) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.eGf) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.eGg) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.eGh) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.ejO) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.eGi) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.eGj) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.eDL) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.eGk) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.eGl) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.eGm) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.eGn) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.eGo) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cj
 * JD-Core Version:    0.7.0.1
 */