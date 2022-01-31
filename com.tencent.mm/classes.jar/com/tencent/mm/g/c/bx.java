package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class bx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfJ = "status".hashCode();
  private static final int diB;
  private static final int dzG = "cgi".hashCode();
  private static final int dzH = "cmdid".hashCode();
  private static final int dzI = "functionmsgid".hashCode();
  private static final int dzJ;
  private static final int dzK;
  private static final int dzL;
  private static final int dzM;
  private static final int dzN;
  private static final int dzO;
  private static final int dzP;
  private static final int dzQ;
  private static final int dzR = "needShow".hashCode();
  private static final int dzS = "defaultContent".hashCode();
  private static final int dzT = "actionTime".hashCode();
  private static final int dzU = "delayTime".hashCode();
  private static final int dzV = "retryCount".hashCode();
  private static final int dzW = "retryCountLimit".hashCode();
  private static final int dzX = "businessInfo".hashCode();
  private static final int dzY = "opCode".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfG = true;
  private boolean div = true;
  private boolean dzA = true;
  private boolean dzB = true;
  private boolean dzC = true;
  private boolean dzD = true;
  private boolean dzE = true;
  private boolean dzF = true;
  private boolean dzn = true;
  private boolean dzo = true;
  private boolean dzp = true;
  private boolean dzq = true;
  private boolean dzr = true;
  private boolean dzs = true;
  private boolean dzt = true;
  private boolean dzu = true;
  private boolean dzv = true;
  private boolean dzw = true;
  private boolean dzx = true;
  private boolean dzy = true;
  private boolean dzz = true;
  public long field_actionTime;
  public cm field_addMsg;
  public nf field_businessInfo;
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
    diB = "version".hashCode();
    dzJ = "preVersion".hashCode();
    dzK = "retryinterval".hashCode();
    dzL = "reportid".hashCode();
    dzM = "successkey".hashCode();
    dzN = "failkey".hashCode();
    dzO = "finalfailkey".hashCode();
    dzP = "custombuff".hashCode();
    dzQ = "addMsg".hashCode();
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
      if (dzG != k) {
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
      if (dzH == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (dzI == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.dzp = true;
      }
      else if (diB == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (dzJ == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (dzK == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (dzL == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (dzM == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (dzN == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (dzO == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (dzP == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (dzQ == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((cm)new cm().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ab.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (dfJ == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (dzR == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (dzS == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (dzT == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (dzU == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (dzV == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (dzW == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (dzX == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((nf)new nf().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            ab.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (dzY == k) {
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
    if (this.dzn) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.dzo) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.dzp) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.div) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.dzq) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.dzr) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.dzs) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.dzt) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.dzu) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.dzv) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.dzw) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.dzx) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.dfG) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.dzy) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.dzz) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.dzA) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.dzB) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.dzC) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.dzD) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.dzE) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.dzF) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ab.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.bx
 * JD-Core Version:    0.7.0.1
 */