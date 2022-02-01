package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.b.k;
import com.tencent.mm.openim.b.m;
import com.tencent.mm.openim.d.j;
import com.tencent.mm.openim.room.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public final com.tencent.mm.roomsdk.a.c.a Dt(String paramString)
  {
    AppMethodBeat.i(151298);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    localb.gNg = new com.tencent.mm.openim.b.e(paramString);
    AppMethodBeat.o(151298);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Du(String paramString)
  {
    AppMethodBeat.i(151301);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(false);
    localc.NDQ = new j(paramString);
    AppMethodBeat.o(151301);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a H(String paramString, int paramInt)
  {
    AppMethodBeat.i(151299);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    localb.gNg = new com.tencent.mm.openim.b.f(paramString, paramInt);
    AppMethodBeat.o(151299);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a I(String paramString, int paramInt)
  {
    AppMethodBeat.i(151302);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(false);
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localc.NDQ = new com.tencent.mm.openim.d.c(paramString, paramInt);
      AppMethodBeat.o(151302);
      return localc;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151300);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    localb.gNg = new m(paramString2, paramString1);
    AppMethodBeat.o(151300);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(151293);
    paramString = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    paramString.gNg = new com.tencent.mm.openim.b.c(b.a.aM(paramList));
    AppMethodBeat.o(151293);
    return paramString;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(151295);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    localb.gNg = new com.tencent.mm.openim.b.d(paramString, b.a.aM(paramList));
    AppMethodBeat.o(151295);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(223650);
    paramObject = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    paramObject.gNg = new k(paramString, b.a.aM(paramList));
    AppMethodBeat.o(223650);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, ca paramca)
  {
    AppMethodBeat.i(151297);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    paramString2.gNg = new k(paramString1, b.a.aM(paramList));
    AppMethodBeat.o(151297);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(223649);
    paramObject = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    paramObject.gNg = new com.tencent.mm.openim.b.a(paramString1, b.a.aM(paramList), paramString2);
    AppMethodBeat.o(223649);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(223648);
    paramString1 = com.tencent.mm.roomsdk.a.c.a.Aw(false);
    paramString1.gNg = new com.tencent.mm.openim.b.c(b.a.aM(paramList));
    AppMethodBeat.o(223648);
    return paramString1;
  }
  
  public final void a(as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(151307);
    if (paramBoolean)
    {
      paramas.aqQ();
      if (ab.p(paramas))
      {
        paramas.nd(43);
        paramas.BF(com.tencent.mm.platformtools.f.Si(paramas.arI()));
        paramas.BG(com.tencent.mm.platformtools.f.Sh(paramas.arI()));
        paramas.BI(com.tencent.mm.platformtools.f.Sh(paramas.arJ()));
        paramas.BJ(paramas.arJ());
      }
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().c(paramas.field_username, paramas);
      ((r)com.tencent.mm.kernel.g.af(r.class)).EH(paramas.field_username);
      AppMethodBeat.o(151307);
      return;
    }
    ((r)com.tencent.mm.kernel.g.af(r.class)).EI(paramas.field_username);
    AppMethodBeat.o(151307);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151303);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(false);
    localc.NDQ = new com.tencent.mm.openim.d.g(paramString1, paramString2);
    AppMethodBeat.o(151303);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a ab(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a ac(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151304);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(false);
    localc.NDQ = new com.tencent.mm.openim.d.b(paramString1, paramString2);
    AppMethodBeat.o(151304);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.e alV()
  {
    AppMethodBeat.i(151292);
    com.tencent.mm.roomsdk.a.c.e locale = com.tencent.mm.roomsdk.a.c.e.gvQ();
    AppMethodBeat.o(151292);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(151306);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.Ax(false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString2.NDQ = new com.tencent.mm.openim.d.e(paramString1, i);
      AppMethodBeat.o(151306);
      return paramString2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151305);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.Ax(false);
    paramString2.NDQ = new com.tencent.mm.openim.d.d(paramString1, paramString3);
    AppMethodBeat.o(151305);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a
 * JD-Core Version:    0.7.0.1
 */