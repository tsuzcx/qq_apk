package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "T", "", "()V", "Failure", "Success", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Failure;", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h<T>
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Failure;", "T", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<T>
    extends h<T>
  {
    public final int errCode;
    public final String errMsg;
    
    public a(int paramInt, String paramString)
    {
      super();
      AppMethodBeat.i(183689);
      this.errCode = paramInt;
      this.errMsg = paramString;
      AppMethodBeat.o(183689);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(183692);
      if (this == paramObject)
      {
        AppMethodBeat.o(183692);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(183692);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.errCode != paramObject.errCode)
      {
        AppMethodBeat.o(183692);
        return false;
      }
      if (!s.p(this.errMsg, paramObject.errMsg))
      {
        AppMethodBeat.o(183692);
        return false;
      }
      AppMethodBeat.o(183692);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(183691);
      int i = this.errCode;
      int j = this.errMsg.hashCode();
      AppMethodBeat.o(183691);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183690);
      String str = "Failure(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
      AppMethodBeat.o(183690);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "T", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "ret", "(Ljava/lang/Object;)V", "getRet", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b<T>
    extends h<T>
  {
    public final T smv;
    
    public b(T paramT)
    {
      super();
      this.smv = paramT;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(183695);
      if (this == paramObject)
      {
        AppMethodBeat.o(183695);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(183695);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.smv, paramObject.smv))
      {
        AppMethodBeat.o(183695);
        return false;
      }
      AppMethodBeat.o(183695);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(183694);
      if (this.smv == null)
      {
        AppMethodBeat.o(183694);
        return 0;
      }
      int i = this.smv.hashCode();
      AppMethodBeat.o(183694);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183693);
      String str = "Success(ret=" + this.smv + ')';
      AppMethodBeat.o(183693);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.h
 * JD-Core Version:    0.7.0.1
 */