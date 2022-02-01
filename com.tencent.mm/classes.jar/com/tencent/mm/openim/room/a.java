package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.b.k;
import com.tencent.mm.openim.b.m;
import com.tencent.mm.openim.d.j;
import com.tencent.mm.openim.room.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public final com.tencent.mm.roomsdk.a.c.a F(String paramString, int paramInt)
  {
    AppMethodBeat.i(151299);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(false);
    localb.DqO = new com.tencent.mm.openim.b.f(paramString, paramInt);
    AppMethodBeat.o(151299);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a G(String paramString, int paramInt)
  {
    AppMethodBeat.i(151302);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wp(false);
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localc.HWl = new com.tencent.mm.openim.d.c(paramString, paramInt);
      AppMethodBeat.o(151302);
      return localc;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a X(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151300);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(false);
    localb.DqO = new m(paramString2, paramString1);
    AppMethodBeat.o(151300);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.e XY()
  {
    AppMethodBeat.i(151292);
    com.tencent.mm.roomsdk.a.c.e locale = new com.tencent.mm.roomsdk.a.c.e();
    AppMethodBeat.o(151292);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151303);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wp(false);
    localc.HWl = new com.tencent.mm.openim.d.g(paramString1, paramString2);
    AppMethodBeat.o(151303);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(151293);
    paramString = com.tencent.mm.roomsdk.a.c.a.wo(false);
    paramString.DqO = new com.tencent.mm.openim.b.c(b.a.aE(paramList));
    AppMethodBeat.o(151293);
    return paramString;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(151295);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(false);
    localb.DqO = new com.tencent.mm.openim.b.d(paramString, b.a.aE(paramList));
    AppMethodBeat.o(151295);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(195297);
    paramObject = com.tencent.mm.roomsdk.a.c.a.wo(false);
    paramObject.DqO = new k(paramString, b.a.aE(paramList));
    AppMethodBeat.o(195297);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bu parambu)
  {
    AppMethodBeat.i(151297);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.wo(false);
    paramString2.DqO = new k(paramString1, b.a.aE(paramList));
    AppMethodBeat.o(151297);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(195296);
    paramObject = com.tencent.mm.roomsdk.a.c.a.wo(false);
    paramObject.DqO = new com.tencent.mm.openim.b.a(paramString1, b.a.aE(paramList), paramString2);
    AppMethodBeat.o(195296);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(195295);
    paramString1 = com.tencent.mm.roomsdk.a.c.a.wo(false);
    paramString1.DqO = new com.tencent.mm.openim.b.c(b.a.aE(paramList));
    AppMethodBeat.o(195295);
    return paramString1;
  }
  
  public final void a(am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(151307);
    if (paramBoolean)
    {
      paramam.acH();
      if (w.i(paramam))
      {
        paramam.jZ(43);
        paramam.sU(com.tencent.mm.platformtools.f.IM(paramam.adu()));
        paramam.sV(com.tencent.mm.platformtools.f.IL(paramam.adu()));
        paramam.sX(com.tencent.mm.platformtools.f.IL(paramam.adv()));
        paramam.sY(paramam.adv());
      }
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().c(paramam.field_username, paramam);
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).IA(paramam.field_username);
      AppMethodBeat.o(151307);
      return;
    }
    ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).IB(paramam.field_username);
    AppMethodBeat.o(151307);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151304);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wp(false);
    localc.HWl = new com.tencent.mm.openim.d.b(paramString1, paramString2);
    AppMethodBeat.o(151304);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(151306);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.wp(false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString2.HWl = new com.tencent.mm.openim.d.e(paramString1, i);
      AppMethodBeat.o(151306);
      return paramString2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151305);
    paramString2 = com.tencent.mm.roomsdk.a.c.a.wp(false);
    paramString2.HWl = new com.tencent.mm.openim.d.d(paramString1, paramString3);
    AppMethodBeat.o(151305);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a uH(String paramString)
  {
    AppMethodBeat.i(151298);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(false);
    localb.DqO = new com.tencent.mm.openim.b.e(paramString);
    AppMethodBeat.o(151298);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a uI(String paramString)
  {
    AppMethodBeat.i(151301);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wp(false);
    localc.HWl = new j(paramString);
    AppMethodBeat.o(151301);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a
 * JD-Core Version:    0.7.0.1
 */