package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bx;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends bx
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(59562);
    c.a locala = new c.a();
    locala.yrK = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "cgi";
    locala.yrM.put("cgi", "TEXT");
    localStringBuilder.append(" cgi TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cmdid";
    locala.yrM.put("cmdid", "INTEGER");
    localStringBuilder.append(" cmdid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "functionmsgid";
    locala.yrM.put("functionmsgid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "functionmsgid";
    locala.columns[3] = "version";
    locala.yrM.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "preVersion";
    locala.yrM.put("preVersion", "LONG");
    localStringBuilder.append(" preVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "retryinterval";
    locala.yrM.put("retryinterval", "INTEGER");
    localStringBuilder.append(" retryinterval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportid";
    locala.yrM.put("reportid", "INTEGER");
    localStringBuilder.append(" reportid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "successkey";
    locala.yrM.put("successkey", "INTEGER");
    localStringBuilder.append(" successkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "failkey";
    locala.yrM.put("failkey", "INTEGER");
    localStringBuilder.append(" failkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "finalfailkey";
    locala.yrM.put("finalfailkey", "INTEGER");
    localStringBuilder.append(" finalfailkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "custombuff";
    locala.yrM.put("custombuff", "TEXT");
    localStringBuilder.append(" custombuff TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "addMsg";
    locala.yrM.put("addMsg", "BLOB");
    localStringBuilder.append(" addMsg BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.yrM.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "needShow";
    locala.yrM.put("needShow", "INTEGER default 'false' ");
    localStringBuilder.append(" needShow INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "defaultContent";
    locala.yrM.put("defaultContent", "TEXT");
    localStringBuilder.append(" defaultContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "actionTime";
    locala.yrM.put("actionTime", "LONG default '-1' ");
    localStringBuilder.append(" actionTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "delayTime";
    locala.yrM.put("delayTime", "LONG default '-1' ");
    localStringBuilder.append(" delayTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "retryCount";
    locala.yrM.put("retryCount", "INTEGER default '0' ");
    localStringBuilder.append(" retryCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "retryCountLimit";
    locala.yrM.put("retryCountLimit", "INTEGER default '0' ");
    localStringBuilder.append(" retryCountLimit INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "businessInfo";
    locala.yrM.put("businessInfo", "BLOB");
    localStringBuilder.append(" businessInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[20] = "opCode";
    locala.yrM.put("opCode", "INTEGER default '-1' ");
    localStringBuilder.append(" opCode INTEGER default '-1' ");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(59562);
  }
  
  public final int Ac()
  {
    return this.field_opCode;
  }
  
  public final String Ad()
  {
    return this.field_functionmsgid;
  }
  
  public final long Ae()
  {
    return this.field_preVersion;
  }
  
  public final String Af()
  {
    return this.field_custombuff;
  }
  
  public final cm Ag()
  {
    return this.field_addMsg;
  }
  
  public final long Ah()
  {
    return this.field_delayTime;
  }
  
  public final long Ai()
  {
    return this.field_actionTime;
  }
  
  public final void Aj()
  {
    this.field_status = -1;
  }
  
  public final void Ak()
  {
    this.field_retryCount = 0;
  }
  
  public final void a(cm paramcm)
  {
    if (paramcm != null) {
      this.field_addMsg = paramcm;
    }
  }
  
  public final void a(nf paramnf)
  {
    this.field_businessInfo = paramnf;
  }
  
  public final void aC(long paramLong)
  {
    this.field_version = paramLong;
  }
  
  public final void aD(long paramLong)
  {
    this.field_preVersion = paramLong;
  }
  
  public final void aE(long paramLong)
  {
    this.field_delayTime = paramLong;
  }
  
  public final void aF(long paramLong)
  {
    this.field_actionTime = paramLong;
  }
  
  public final void bl(boolean paramBoolean)
  {
    this.field_needShow = paramBoolean;
  }
  
  public final void cW(String paramString)
  {
    AppMethodBeat.i(59556);
    if (!bo.isNullOrNil(paramString)) {
      this.field_cgi = paramString;
    }
    AppMethodBeat.o(59556);
  }
  
  public final void cX(String paramString)
  {
    AppMethodBeat.i(59557);
    if (!bo.isNullOrNil(paramString)) {
      this.field_functionmsgid = paramString;
    }
    AppMethodBeat.o(59557);
  }
  
  public final void cY(String paramString)
  {
    AppMethodBeat.i(59558);
    if (!bo.isNullOrNil(paramString)) {
      this.field_custombuff = paramString;
    }
    AppMethodBeat.o(59558);
  }
  
  public final void cZ(String paramString)
  {
    if (paramString != null) {
      this.field_defaultContent = paramString;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59560);
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if ((paramObject.field_functionmsgid.equals(this.field_functionmsgid)) && (paramObject.systemRowid == this.systemRowid))
      {
        AppMethodBeat.o(59560);
        return true;
      }
      AppMethodBeat.o(59560);
      return false;
    }
    AppMethodBeat.o(59560);
    return false;
  }
  
  public final void fU(int paramInt)
  {
    this.field_opCode = paramInt;
  }
  
  public final void fV(int paramInt)
  {
    this.field_reportid = paramInt;
  }
  
  public final void fW(int paramInt)
  {
    this.field_successkey = paramInt;
  }
  
  public final void fX(int paramInt)
  {
    this.field_failkey = paramInt;
  }
  
  public final void fY(int paramInt)
  {
    this.field_finalfailkey = paramInt;
  }
  
  public final void fZ(int paramInt)
  {
    this.field_retryCountLimit = paramInt;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final int getStatus()
  {
    return this.field_status;
  }
  
  public final long getVersion()
  {
    return this.field_version;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59559);
    int i = this.field_functionmsgid.hashCode();
    AppMethodBeat.o(59559);
    return i;
  }
  
  public final void setCmdId(int paramInt)
  {
    this.field_cmdid = paramInt;
  }
  
  public final void setRetryInterval(int paramInt)
  {
    this.field_retryinterval = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59561);
    String str2 = "@null";
    String str1 = str2;
    if (!bo.isNullOrNil(this.field_cgi))
    {
      String[] arrayOfString = this.field_cgi.split("/");
      str1 = str2;
      if (arrayOfString.length > 0) {
        str1 = arrayOfString[(arrayOfString.length - 1)];
      }
    }
    str1 = "FunctionMsgItem{cgi='" + str1 + '\'' + ", cmdid=" + this.field_cmdid + ", functionmsgid='" + this.field_functionmsgid + '\'' + ", version=" + this.field_version + ", preVersion=" + this.field_preVersion + ", status=" + this.field_status + ", actionTime=" + this.field_actionTime + ", delayTime=" + this.field_delayTime + ", retryCount=" + this.field_retryCount + ", retryCount=" + this.field_opCode + '}';
    AppMethodBeat.o(59561);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.f
 * JD-Core Version:    0.7.0.1
 */