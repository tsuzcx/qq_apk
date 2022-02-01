package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "T", "", "()V", "Failure", "Success", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Failure;", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class e<T>
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Failure;", "T", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a<T>
    extends e<T>
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
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.errCode != paramObject.errCode) || (!p.j(this.errMsg, paramObject.errMsg))) {}
        }
      }
      else
      {
        AppMethodBeat.o(183692);
        return true;
      }
      AppMethodBeat.o(183692);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(183691);
      int j = this.errCode;
      String str = this.errMsg;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(183691);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183690);
      String str = "Failure(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
      AppMethodBeat.o(183690);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "T", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "ret", "(Ljava/lang/Object;)V", "getRet", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class b<T>
    extends e<T>
  {
    public final T miW;
    
    public b(T paramT)
    {
      super();
      this.miW = paramT;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(183695);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (!p.j(this.miW, paramObject.miW)) {}
        }
      }
      else
      {
        AppMethodBeat.o(183695);
        return true;
      }
      AppMethodBeat.o(183695);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(183694);
      Object localObject = this.miW;
      if (localObject != null)
      {
        int i = localObject.hashCode();
        AppMethodBeat.o(183694);
        return i;
      }
      AppMethodBeat.o(183694);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183693);
      String str = "Success(ret=" + this.miW + ")";
      AppMethodBeat.o(183693);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e
 * JD-Core Version:    0.7.0.1
 */