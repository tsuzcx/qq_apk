package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cy;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class i
  extends cy
{
  public static IAutoDBItem.MAutoDBInfo info;
  private LinkedList<db> fav = null;
  
  static
  {
    AppMethodBeat.i(114786);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[22];
    localMAutoDBInfo.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "cgi";
    localMAutoDBInfo.colsMap.put("cgi", "TEXT");
    localStringBuilder.append(" cgi TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "cmdid";
    localMAutoDBInfo.colsMap.put("cmdid", "INTEGER");
    localStringBuilder.append(" cmdid INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "functionmsgid";
    localMAutoDBInfo.colsMap.put("functionmsgid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "functionmsgid";
    localMAutoDBInfo.columns[3] = "version";
    localMAutoDBInfo.colsMap.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "preVersion";
    localMAutoDBInfo.colsMap.put("preVersion", "LONG");
    localStringBuilder.append(" preVersion LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "retryinterval";
    localMAutoDBInfo.colsMap.put("retryinterval", "INTEGER");
    localStringBuilder.append(" retryinterval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "reportid";
    localMAutoDBInfo.colsMap.put("reportid", "INTEGER");
    localStringBuilder.append(" reportid INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "successkey";
    localMAutoDBInfo.colsMap.put("successkey", "INTEGER");
    localStringBuilder.append(" successkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "failkey";
    localMAutoDBInfo.colsMap.put("failkey", "INTEGER");
    localStringBuilder.append(" failkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "finalfailkey";
    localMAutoDBInfo.colsMap.put("finalfailkey", "INTEGER");
    localStringBuilder.append(" finalfailkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "custombuff";
    localMAutoDBInfo.colsMap.put("custombuff", "TEXT");
    localStringBuilder.append(" custombuff TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "addMsg";
    localMAutoDBInfo.colsMap.put("addMsg", "BLOB");
    localStringBuilder.append(" addMsg BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "needShow";
    localMAutoDBInfo.colsMap.put("needShow", "INTEGER default 'false' ");
    localStringBuilder.append(" needShow INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "defaultContent";
    localMAutoDBInfo.colsMap.put("defaultContent", "TEXT");
    localStringBuilder.append(" defaultContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "actionTime";
    localMAutoDBInfo.colsMap.put("actionTime", "LONG default '-1' ");
    localStringBuilder.append(" actionTime LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "delayTime";
    localMAutoDBInfo.colsMap.put("delayTime", "LONG default '-1' ");
    localStringBuilder.append(" delayTime LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER default '0' ");
    localStringBuilder.append(" retryCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "retryCountLimit";
    localMAutoDBInfo.colsMap.put("retryCountLimit", "INTEGER default '0' ");
    localStringBuilder.append(" retryCountLimit INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "businessInfo";
    localMAutoDBInfo.colsMap.put("businessInfo", "BLOB");
    localStringBuilder.append(" businessInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "opCode";
    localMAutoDBInfo.colsMap.put("opCode", "INTEGER default '-1' ");
    localStringBuilder.append(" opCode INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "addMsgs";
    localMAutoDBInfo.colsMap.put("addMsgs", "BLOB");
    localStringBuilder.append(" addMsgs BLOB");
    localMAutoDBInfo.columns[22] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(114786);
  }
  
  public final int ZB()
  {
    return this.field_opCode;
  }
  
  public final LinkedList<db> ZC()
  {
    AppMethodBeat.i(225684);
    if (this.field_addMsgs == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(225684);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.field_addMsgs.RIP;
    AppMethodBeat.o(225684);
    return localLinkedList;
  }
  
  public final String ZD()
  {
    return this.field_functionmsgid;
  }
  
  public final long ZE()
  {
    return this.field_preVersion;
  }
  
  public final String ZF()
  {
    return this.field_custombuff;
  }
  
  public final db ZG()
  {
    return this.field_addMsg;
  }
  
  public final rq ZH()
  {
    return this.field_businessInfo;
  }
  
  public final long ZI()
  {
    return this.field_delayTime;
  }
  
  public final long ZJ()
  {
    return this.field_actionTime;
  }
  
  public final void ZK()
  {
    this.field_status = -1;
  }
  
  public final void ZL()
  {
    this.field_retryCount = 0;
  }
  
  public final void a(db paramdb)
  {
    if (paramdb != null) {
      this.field_addMsg = paramdb;
    }
  }
  
  public final void a(rq paramrq)
  {
    this.field_businessInfo = paramrq;
  }
  
  public final void bB(long paramLong)
  {
    this.field_version = paramLong;
  }
  
  public final void bC(long paramLong)
  {
    this.field_preVersion = paramLong;
  }
  
  public final void bD(long paramLong)
  {
    this.field_delayTime = paramLong;
  }
  
  public final void bE(long paramLong)
  {
    this.field_actionTime = paramLong;
  }
  
  public final void de(boolean paramBoolean)
  {
    this.field_needShow = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114784);
    if ((paramObject instanceof i))
    {
      paramObject = (i)paramObject;
      if ((paramObject.field_functionmsgid.equals(this.field_functionmsgid)) && (paramObject.systemRowid == this.systemRowid))
      {
        AppMethodBeat.o(114784);
        return true;
      }
      AppMethodBeat.o(114784);
      return false;
    }
    AppMethodBeat.o(114784);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
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
  
  public final void gi(String paramString)
  {
    AppMethodBeat.i(114780);
    if (!Util.isNullOrNil(paramString)) {
      this.field_cgi = paramString;
    }
    AppMethodBeat.o(114780);
  }
  
  public final void gj(String paramString)
  {
    AppMethodBeat.i(114781);
    if (!Util.isNullOrNil(paramString)) {
      this.field_functionmsgid = paramString;
    }
    AppMethodBeat.o(114781);
  }
  
  public final void gk(String paramString)
  {
    AppMethodBeat.i(114782);
    if (!Util.isNullOrNil(paramString)) {
      this.field_custombuff = paramString;
    }
    AppMethodBeat.o(114782);
  }
  
  public final void gl(String paramString)
  {
    if (paramString != null) {
      this.field_defaultContent = paramString;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(114783);
    int i = this.field_functionmsgid.hashCode();
    AppMethodBeat.o(114783);
    return i;
  }
  
  public final void jS(int paramInt)
  {
    this.field_opCode = paramInt;
  }
  
  public final void jT(int paramInt)
  {
    this.field_reportid = paramInt;
  }
  
  public final void jU(int paramInt)
  {
    this.field_successkey = paramInt;
  }
  
  public final void jV(int paramInt)
  {
    this.field_failkey = paramInt;
  }
  
  public final void jW(int paramInt)
  {
    this.field_finalfailkey = paramInt;
  }
  
  public final void jX(int paramInt)
  {
    this.field_retryCountLimit = paramInt;
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
    AppMethodBeat.i(114785);
    String str2 = "@null";
    String str1 = str2;
    if (!Util.isNullOrNil(this.field_cgi))
    {
      String[] arrayOfString = this.field_cgi.split("/");
      str1 = str2;
      if (arrayOfString.length > 0) {
        str1 = arrayOfString[(arrayOfString.length - 1)];
      }
    }
    str1 = "FunctionMsgItem{cgi='" + str1 + '\'' + ", cmdid=" + this.field_cmdid + ", functionmsgid='" + this.field_functionmsgid + '\'' + ", version=" + this.field_version + ", preVersion=" + this.field_preVersion + ", status=" + this.field_status + ", actionTime=" + this.field_actionTime + ", delayTime=" + this.field_delayTime + ", retryCount=" + this.field_retryCount + ", retryCountLimit=" + this.field_retryCountLimit + '}';
    AppMethodBeat.o(114785);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.api.i
 * JD-Core Version:    0.7.0.1
 */