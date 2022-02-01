package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.b.m;
import com.tencent.mm.openim.d.j;
import com.tencent.mm.openim.room.a.b.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public final com.tencent.mm.roomsdk.a.c.a D(String paramString, int paramInt)
  {
    AppMethodBeat.i(151299);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(false);
    localb.AxZ = new com.tencent.mm.openim.b.f(paramString, paramInt);
    AppMethodBeat.o(151299);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a E(String paramString, int paramInt)
  {
    AppMethodBeat.i(151302);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(false);
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localc.ENn = new com.tencent.mm.openim.d.c(paramString, paramInt);
      AppMethodBeat.o(151302);
      return localc;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a U(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151300);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(false);
    localb.AxZ = new m(paramString2, paramString1);
    AppMethodBeat.o(151300);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.d UL()
  {
    AppMethodBeat.i(151292);
    com.tencent.mm.roomsdk.a.c.d locald = new com.tencent.mm.roomsdk.a.c.d();
    AppMethodBeat.o(151292);
    return locald;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a V(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151303);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(false);
    localc.ENn = new com.tencent.mm.openim.d.g(paramString1, paramString2);
    AppMethodBeat.o(151303);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a X(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151304);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(false);
    localc.ENn = new com.tencent.mm.openim.d.b(paramString1, paramString2);
    AppMethodBeat.o(151304);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(151293);
    paramString = com.tencent.mm.roomsdk.a.c.a.uA(false);
    paramString.AxZ = new com.tencent.mm.openim.b.c(b.a.aG(paramList));
    AppMethodBeat.o(151293);
    return paramString;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(151295);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(false);
    localb.AxZ = new com.tencent.mm.openim.b.d(paramString, b.a.aG(paramList));
    AppMethodBeat.o(151295);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(151294);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(false);
    localb.AxZ = new com.tencent.mm.openim.b.a(paramString1, b.a.aG(paramList), paramString2);
    AppMethodBeat.o(151294);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bl parambl)
  {
    AppMethodBeat.i(151297);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.uA(false);
    paramString2.AxZ = new com.tencent.mm.openim.b.k(paramString1, b.a.aG(paramList));
    AppMethodBeat.o(151297);
    return paramString2;
  }
  
  public final void a(af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(151307);
    if (paramBoolean)
    {
      paramaf.Zk();
      if (w.i(paramaf))
      {
        paramaf.jD(43);
        paramaf.ne(com.tencent.mm.platformtools.f.Bs(paramaf.ZW()));
        paramaf.nf(com.tencent.mm.platformtools.f.Br(paramaf.ZW()));
        paramaf.nh(com.tencent.mm.platformtools.f.Br(paramaf.ZX()));
        paramaf.ni(paramaf.ZX());
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramaf.field_username, paramaf);
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Bf(paramaf.field_username);
      AppMethodBeat.o(151307);
      return;
    }
    ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Bg(paramaf.field_username);
    AppMethodBeat.o(151307);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(151306);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.uB(false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString2.ENn = new com.tencent.mm.openim.d.e(paramString1, i);
      AppMethodBeat.o(151306);
      return paramString2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(151296);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(false);
    localb.AxZ = new com.tencent.mm.openim.b.k(paramString, b.a.aG(paramList));
    AppMethodBeat.o(151296);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151305);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.uB(false);
    paramString2.ENn = new com.tencent.mm.openim.d.d(paramString1, paramString3);
    AppMethodBeat.o(151305);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a oL(String paramString)
  {
    AppMethodBeat.i(151298);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(false);
    localb.AxZ = new com.tencent.mm.openim.b.e(paramString);
    AppMethodBeat.o(151298);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a oM(String paramString)
  {
    AppMethodBeat.i(151301);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(false);
    localc.ENn = new j(paramString);
    AppMethodBeat.o(151301);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a
 * JD-Core Version:    0.7.0.1
 */