package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.openim.b.k;
import com.tencent.mm.openim.b.m;
import com.tencent.mm.openim.d.j;
import com.tencent.mm.openim.room.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public final com.tencent.mm.roomsdk.a.c.a G(String paramString, int paramInt)
  {
    AppMethodBeat.i(151299);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(false);
    localb.ghA = new com.tencent.mm.openim.b.f(paramString, paramInt);
    AppMethodBeat.o(151299);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a H(String paramString, int paramInt)
  {
    AppMethodBeat.i(151302);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(false);
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localc.Iqt = new com.tencent.mm.openim.d.c(paramString, paramInt);
      AppMethodBeat.o(151302);
      return localc;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a X(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151300);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(false);
    localb.ghA = new m(paramString2, paramString1);
    AppMethodBeat.o(151300);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151303);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(false);
    localc.Iqt = new com.tencent.mm.openim.d.g(paramString1, paramString2);
    AppMethodBeat.o(151303);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.e Yi()
  {
    AppMethodBeat.i(151292);
    com.tencent.mm.roomsdk.a.c.e locale = new com.tencent.mm.roomsdk.a.c.e();
    AppMethodBeat.o(151292);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(151293);
    paramString = com.tencent.mm.roomsdk.a.c.a.ww(false);
    paramString.ghA = new com.tencent.mm.openim.b.c(b.a.aE(paramList));
    AppMethodBeat.o(151293);
    return paramString;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(151295);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(false);
    localb.ghA = new com.tencent.mm.openim.b.d(paramString, b.a.aE(paramList));
    AppMethodBeat.o(151295);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(218750);
    paramObject = com.tencent.mm.roomsdk.a.c.a.ww(false);
    paramObject.ghA = new k(paramString, b.a.aE(paramList));
    AppMethodBeat.o(218750);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bv parambv)
  {
    AppMethodBeat.i(151297);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.ww(false);
    paramString2.ghA = new k(paramString1, b.a.aE(paramList));
    AppMethodBeat.o(151297);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(218749);
    paramObject = com.tencent.mm.roomsdk.a.c.a.ww(false);
    paramObject.ghA = new com.tencent.mm.openim.b.a(paramString1, b.a.aE(paramList), paramString2);
    AppMethodBeat.o(218749);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(218748);
    paramString1 = com.tencent.mm.roomsdk.a.c.a.ww(false);
    paramString1.ghA = new com.tencent.mm.openim.b.c(b.a.aE(paramList));
    AppMethodBeat.o(218748);
    return paramString1;
  }
  
  public final void a(an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(151307);
    if (paramBoolean)
    {
      paraman.acS();
      if (x.p(paraman))
      {
        paraman.kb(43);
        paraman.tp(com.tencent.mm.platformtools.f.Jl(paraman.adF()));
        paraman.tq(com.tencent.mm.platformtools.f.Jk(paraman.adF()));
        paraman.ts(com.tencent.mm.platformtools.f.Jk(paraman.adG()));
        paraman.tt(paraman.adG());
      }
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().c(paraman.field_username, paraman);
      ((r)com.tencent.mm.kernel.g.ab(r.class)).ws(paraman.field_username);
      AppMethodBeat.o(151307);
      return;
    }
    ((r)com.tencent.mm.kernel.g.ab(r.class)).wt(paraman.field_username);
    AppMethodBeat.o(151307);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151304);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(false);
    localc.Iqt = new com.tencent.mm.openim.d.b(paramString1, paramString2);
    AppMethodBeat.o(151304);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(151306);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.wx(false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString2.Iqt = new com.tencent.mm.openim.d.e(paramString1, i);
      AppMethodBeat.o(151306);
      return paramString2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151305);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.wx(false);
    paramString2.Iqt = new com.tencent.mm.openim.d.d(paramString1, paramString3);
    AppMethodBeat.o(151305);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a vc(String paramString)
  {
    AppMethodBeat.i(151298);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(false);
    localb.ghA = new com.tencent.mm.openim.b.e(paramString);
    AppMethodBeat.o(151298);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a vd(String paramString)
  {
    AppMethodBeat.i(151301);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(false);
    localc.Iqt = new j(paramString);
    AppMethodBeat.o(151301);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a
 * JD-Core Version:    0.7.0.1
 */