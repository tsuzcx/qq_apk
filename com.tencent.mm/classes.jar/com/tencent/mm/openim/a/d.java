package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContactCache;", "", "()V", "cacheContact", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "clear", "", "get", "key", "set", "contact", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a prL;
  final f<String, c> prM;
  
  static
  {
    AppMethodBeat.i(236019);
    prL = new d.a((byte)0);
    AppMethodBeat.o(236019);
  }
  
  public d()
  {
    AppMethodBeat.i(236014);
    this.prM = ((f)new com.tencent.mm.memory.a.c(20));
    AppMethodBeat.o(236014);
  }
  
  public final c RJ(String paramString)
  {
    AppMethodBeat.i(236027);
    s.u(paramString, "key");
    paramString = (c)this.prM.ct(paramString);
    if (paramString != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString.field_username;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(236027);
        return paramString;
      }
    }
    AppMethodBeat.o(236027);
    return null;
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(236032);
    s.u(paramString, "key");
    s.u(paramc, "contact");
    this.prM.B(paramString, paramc);
    AppMethodBeat.o(236032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.d
 * JD-Core Version:    0.7.0.1
 */