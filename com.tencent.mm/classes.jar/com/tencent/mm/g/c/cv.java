package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class cv
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fDK = "retryCount".hashCode();
  private static final int fDd;
  private static final int fHA;
  private static final int fHB;
  private static final int fHC;
  private static final int fHD;
  private static final int fHE;
  private static final int fHF;
  private static final int fHG;
  private static final int fHH;
  private static final int fHI;
  private static final int fHJ;
  private static final int fHK;
  private static final int fHL;
  private static final int fHM = "retryCountLimit".hashCode();
  private static final int fHN = "businessInfo".hashCode();
  private static final int fHO = "opCode".hashCode();
  private static final int fHy = "cgi".hashCode();
  private static final int fHz = "cmdid".hashCode();
  private static final int fjl;
  private static final int flv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fCT = true;
  private boolean fDu = true;
  private boolean fHh = true;
  private boolean fHi = true;
  private boolean fHj = true;
  private boolean fHk = true;
  private boolean fHl = true;
  private boolean fHm = true;
  private boolean fHn = true;
  private boolean fHo = true;
  private boolean fHp = true;
  private boolean fHq = true;
  private boolean fHr = true;
  private boolean fHs = true;
  private boolean fHt = true;
  private boolean fHu = true;
  private boolean fHv = true;
  private boolean fHw = true;
  private boolean fHx = true;
  public long field_actionTime;
  public de field_addMsg;
  public rx field_businessInfo;
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
  private boolean fji = true;
  private boolean flq = true;
  
  static
  {
    fHA = "functionmsgid".hashCode();
    flv = "version".hashCode();
    fHB = "preVersion".hashCode();
    fHC = "retryinterval".hashCode();
    fHD = "reportid".hashCode();
    fHE = "successkey".hashCode();
    fHF = "failkey".hashCode();
    fHG = "finalfailkey".hashCode();
    fHH = "custombuff".hashCode();
    fHI = "addMsg".hashCode();
    fjl = "status".hashCode();
    fHJ = "needShow".hashCode();
    fHK = "defaultContent".hashCode();
    fDd = "actionTime".hashCode();
    fHL = "delayTime".hashCode();
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
      if (fHy != k) {
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
      if (fHz == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (fHA == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.fHj = true;
      }
      else if (flv == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (fHB == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (fHC == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (fHD == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (fHE == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (fHF == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (fHG == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (fHH == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (fHI == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((de)new de().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (fjl == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (fHJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (fHK == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (fDd == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (fHL == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (fDK == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (fHM == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (fHN == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((rx)new rx().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (fHO == k) {
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
    if (this.fHh) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.fHi) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.fHj) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.flq) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.fHk) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.fHl) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.fHm) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.fHn) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.fHo) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.fHp) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.fHq) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.fHr) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.fji) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.fHs) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.fHt) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.fCT) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.fHu) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.fDu) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.fHv) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.fHw) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.fHx) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.cv
 * JD-Core Version:    0.7.0.1
 */