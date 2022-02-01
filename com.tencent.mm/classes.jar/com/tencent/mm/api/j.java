package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.di;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.LinkedList;

public final class j
  extends di
{
  public static IAutoDBItem.MAutoDBInfo info;
  private LinkedList<dl> hdW = null;
  
  static
  {
    AppMethodBeat.i(114786);
    info = aJm();
    AppMethodBeat.o(114786);
  }
  
  public final void a(dl paramdl)
  {
    if (paramdl != null) {
      this.field_addMsg = paramdl;
    }
  }
  
  public final LinkedList<dl> aBt()
  {
    AppMethodBeat.i(236249);
    if (this.field_addMsgs == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(236249);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.field_addMsgs.YFQ;
    AppMethodBeat.o(236249);
    return localLinkedList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114784);
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
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
  
  public final void hL(String paramString)
  {
    AppMethodBeat.i(114782);
    if (!Util.isNullOrNil(paramString)) {
      this.field_custombuff = paramString;
    }
    AppMethodBeat.o(114782);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(114783);
    int i = this.field_functionmsgid.hashCode();
    AppMethodBeat.o(114783);
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.j
 * JD-Core Version:    0.7.0.1
 */