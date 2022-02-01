package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class cl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGp = "actionTime".hashCode();
  private static final int eJh = "cgi".hashCode();
  private static final int eJi = "cmdid".hashCode();
  private static final int eJj = "functionmsgid".hashCode();
  private static final int eJk;
  private static final int eJl;
  private static final int eJm;
  private static final int eJn;
  private static final int eJo;
  private static final int eJp;
  private static final int eJq;
  private static final int eJr;
  private static final int eJs;
  private static final int eJt;
  private static final int eJu = "delayTime".hashCode();
  private static final int eJv = "retryCount".hashCode();
  private static final int eJw = "retryCountLimit".hashCode();
  private static final int eJx = "businessInfo".hashCode();
  private static final int eJy = "opCode".hashCode();
  private static final int elV;
  private static final int epb = "version".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGf = true;
  private boolean eIP = true;
  private boolean eIQ = true;
  private boolean eIR = true;
  private boolean eIS = true;
  private boolean eIT = true;
  private boolean eIU = true;
  private boolean eIV = true;
  private boolean eIW = true;
  private boolean eIX = true;
  private boolean eIY = true;
  private boolean eIZ = true;
  private boolean eJa = true;
  private boolean eJb = true;
  private boolean eJc = true;
  private boolean eJd = true;
  private boolean eJe = true;
  private boolean eJf = true;
  private boolean eJg = true;
  private boolean elS = true;
  private boolean eoW = true;
  public long field_actionTime;
  public cu field_addMsg;
  public pp field_businessInfo;
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
    eJk = "preVersion".hashCode();
    eJl = "retryinterval".hashCode();
    eJm = "reportid".hashCode();
    eJn = "successkey".hashCode();
    eJo = "failkey".hashCode();
    eJp = "finalfailkey".hashCode();
    eJq = "custombuff".hashCode();
    eJr = "addMsg".hashCode();
    elV = "status".hashCode();
    eJs = "needShow".hashCode();
    eJt = "defaultContent".hashCode();
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
      if (eJh != k) {
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
      if (eJi == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (eJj == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.eIR = true;
      }
      else if (epb == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (eJk == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (eJl == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (eJm == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (eJn == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (eJo == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (eJp == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (eJq == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (eJr == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((cu)new cu().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ac.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (elV == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (eJs == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (eJt == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (eGp == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (eJu == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (eJv == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (eJw == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (eJx == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((pp)new pp().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            ac.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (eJy == k) {
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
    if (this.eIP) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.eIQ) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.eIR) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.eoW) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.eIS) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.eIT) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.eIU) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.eIV) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.eIW) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.eIX) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.eIY) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.eIZ) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.elS) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.eJa) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.eJb) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.eGf) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.eJc) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.eJd) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.eJe) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.eJf) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.eJg) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ac.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cl
 * JD-Core Version:    0.7.0.1
 */