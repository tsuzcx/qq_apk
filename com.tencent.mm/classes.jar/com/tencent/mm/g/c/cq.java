package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class cq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eHT;
  private static final int eZy;
  private static final int faa = "retryCount".hashCode();
  private static final int fdh = "cgi".hashCode();
  private static final int fdi = "cmdid".hashCode();
  private static final int fdj = "functionmsgid".hashCode();
  private static final int fdk;
  private static final int fdl;
  private static final int fdm;
  private static final int fdn;
  private static final int fdo;
  private static final int fdp;
  private static final int fdq;
  private static final int fdr;
  private static final int fds;
  private static final int fdt;
  private static final int fdu;
  private static final int fdv = "retryCountLimit".hashCode();
  private static final int fdw = "businessInfo".hashCode();
  private static final int fdx = "opCode".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eHO = true;
  private boolean eZP = true;
  private boolean eZo = true;
  private boolean fcQ = true;
  private boolean fcR = true;
  private boolean fcS = true;
  private boolean fcT = true;
  private boolean fcU = true;
  private boolean fcV = true;
  private boolean fcW = true;
  private boolean fcX = true;
  private boolean fcY = true;
  private boolean fcZ = true;
  private boolean fda = true;
  private boolean fdb = true;
  private boolean fdc = true;
  private boolean fdd = true;
  private boolean fde = true;
  private boolean fdf = true;
  private boolean fdg = true;
  public long field_actionTime;
  public cv field_addMsg;
  public qw field_businessInfo;
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
    eHT = "version".hashCode();
    fdk = "preVersion".hashCode();
    fdl = "retryinterval".hashCode();
    fdm = "reportid".hashCode();
    fdn = "successkey".hashCode();
    fdo = "failkey".hashCode();
    fdp = "finalfailkey".hashCode();
    fdq = "custombuff".hashCode();
    fdr = "addMsg".hashCode();
    eEL = "status".hashCode();
    fds = "needShow".hashCode();
    fdt = "defaultContent".hashCode();
    eZy = "actionTime".hashCode();
    fdu = "delayTime".hashCode();
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
      if (fdh != k) {
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
      if (fdi == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (fdj == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.fcS = true;
      }
      else if (eHT == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (fdk == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (fdl == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (fdm == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (fdn == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (fdo == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (fdp == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (fdq == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (fdr == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((cv)new cv().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ae.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (eEL == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (fds == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (fdt == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (eZy == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (fdu == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (faa == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (fdv == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (fdw == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((qw)new qw().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            ae.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (fdx == k) {
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
    if (this.fcQ) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.fcR) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.fcS) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.eHO) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.fcT) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.fcU) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.fcV) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.fcW) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.fcX) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.fcY) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.fcZ) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.fda) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.eEI) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.fdb) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.fdc) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.eZo) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.fdd) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.eZP) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.fde) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.fdf) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.fdg) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ae.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ae.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cq
 * JD-Core Version:    0.7.0.1
 */