package com.tencent.mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;

public final class XIPCInvoker
{
  public static <T extends i<InputType, ResultType>, InputType, ResultType> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(114100);
    paramString = (XIPCInvoker.WrapperParcelable)f.a(paramString, new XIPCInvoker.WrapperParcelable(paramClass.getName(), paramInputType), XIPCInvoker.c.class);
    if (paramString == null)
    {
      com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
      AppMethodBeat.o(114100);
      return null;
    }
    paramString = paramString.eEI;
    AppMethodBeat.o(114100);
    return paramString;
  }
  
  public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType, ResultType> void a(String paramString, InputType paramInputType, Class<T> paramClass, c<ResultType> paramc)
  {
    AppMethodBeat.i(114099);
    f.a(paramString, new XIPCInvoker.WrapperParcelable(paramClass.getName(), paramInputType), a.class, new XIPCInvoker.1(paramc));
    AppMethodBeat.o(114099);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.a<XIPCInvoker.WrapperParcelable, XIPCInvoker.WrapperParcelable>
  {}
  
  static final class b
    implements c, com.tencent.mm.ipcinvoker.e.a
  {
    c<XIPCInvoker.WrapperParcelable> eEJ;
    com.tencent.mm.ipcinvoker.e.a eEK;
    
    b(c<XIPCInvoker.WrapperParcelable> paramc)
    {
      AppMethodBeat.i(114092);
      this.eEJ = paramc;
      if ((paramc instanceof com.tencent.mm.ipcinvoker.e.a)) {
        this.eEK = ((com.tencent.mm.ipcinvoker.e.a)paramc);
      }
      AppMethodBeat.o(114092);
    }
    
    public final void a(com.tencent.mm.ipcinvoker.e.b paramb)
    {
      AppMethodBeat.i(114094);
      if (this.eEK == null)
      {
        AppMethodBeat.o(114094);
        return;
      }
      this.eEK.a(paramb);
      AppMethodBeat.o(114094);
    }
    
    public final void ad(Object paramObject)
    {
      AppMethodBeat.i(114093);
      if (this.eEJ != null) {
        this.eEJ.ad(new XIPCInvoker.WrapperParcelable(null, paramObject));
      }
      AppMethodBeat.o(114093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker
 * JD-Core Version:    0.7.0.1
 */