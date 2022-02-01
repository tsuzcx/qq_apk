package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.c.j;
import com.tencent.mm.openim.c.m;
import com.tencent.mm.openim.model.d;
import com.tencent.mm.openim.model.p;
import com.tencent.mm.openim.room.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.roomsdk.model.factory.b;
import com.tencent.mm.roomsdk.model.factory.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.model.a.a
{
  public final com.tencent.mm.roomsdk.model.factory.a CP(String paramString)
  {
    AppMethodBeat.i(151298);
    b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    localb.maU = new com.tencent.mm.openim.model.g(paramString);
    AppMethodBeat.o(151298);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a CQ(String paramString)
  {
    AppMethodBeat.i(151301);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(false);
    localc.acmB = new m(paramString);
    AppMethodBeat.o(151301);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(151295);
    b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    localb.maU = new com.tencent.mm.openim.model.e(paramString, b.a.cp(paramList));
    AppMethodBeat.o(151295);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(236135);
    paramObject = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    paramObject.maU = new com.tencent.mm.openim.model.n(paramString, b.a.cp(paramList));
    AppMethodBeat.o(236135);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString1, List<String> paramList, String paramString2, cc paramcc)
  {
    AppMethodBeat.i(151297);
    paramString2 = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    paramString2.maU = new com.tencent.mm.openim.model.n(paramString1, b.a.cp(paramList));
    AppMethodBeat.o(151297);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(236128);
    paramObject = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    paramObject.maU = new com.tencent.mm.openim.model.a(paramString1, b.a.cp(paramList), paramString2);
    AppMethodBeat.o(236128);
    return paramObject;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(236124);
    paramString1 = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    paramString1.maU = new d(b.a.cp(paramList));
    AppMethodBeat.o(236124);
    return paramString1;
  }
  
  public final void a(au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(151307);
    if (paramBoolean)
    {
      paramau.aRK();
      if (ab.q(paramau))
      {
        paramau.pp(43);
        paramau.AY(com.tencent.mm.platformtools.f.Sa(paramau.aSU()));
        paramau.AZ(com.tencent.mm.platformtools.f.RZ(paramau.aSU()));
        paramau.Bb(com.tencent.mm.platformtools.f.RZ(paramau.aSV()));
        paramau.Bc(paramau.aSV());
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d(paramau.field_username, paramau);
      ((u)com.tencent.mm.kernel.h.ax(u.class)).Eh(paramau.field_username);
      AppMethodBeat.o(151307);
      return;
    }
    ((u)com.tencent.mm.kernel.h.ax(u.class)).Ei(paramau.field_username);
    AppMethodBeat.o(151307);
  }
  
  public final com.tencent.mm.roomsdk.model.factory.e aLS()
  {
    AppMethodBeat.i(151292);
    com.tencent.mm.roomsdk.model.factory.e locale = com.tencent.mm.roomsdk.model.factory.e.iRU();
    AppMethodBeat.o(151292);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(151299);
    b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    localb.maU = new com.tencent.mm.openim.model.h(paramString, paramInt);
    AppMethodBeat.o(151299);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151300);
    b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    localb.maU = new p(paramString2, paramString1);
    AppMethodBeat.o(151300);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(151302);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(false);
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localc.acmB = new com.tencent.mm.openim.c.f(paramString, paramInt);
      AppMethodBeat.o(151302);
      return localc;
    }
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a aj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151303);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(false);
    localc.acmB = new j(paramString1, paramString2);
    AppMethodBeat.o(151303);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a ak(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a al(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151304);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(false);
    localc.acmB = new com.tencent.mm.openim.c.e(paramString1, paramString2);
    AppMethodBeat.o(151304);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(151306);
    paramString2 = com.tencent.mm.roomsdk.model.factory.a.Kq(false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString2.acmB = new com.tencent.mm.openim.c.h(paramString1, i);
      AppMethodBeat.o(151306);
      return paramString2;
    }
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(151293);
    paramString = com.tencent.mm.roomsdk.model.factory.a.Kp(false);
    paramString.maU = new d(b.a.cp(paramList));
    AppMethodBeat.o(151293);
    return paramString;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a l(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151305);
    paramString2 = com.tencent.mm.roomsdk.model.factory.a.Kq(false);
    paramString2.acmB = new com.tencent.mm.openim.c.g(paramString1, paramString3);
    AppMethodBeat.o(151305);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a
 * JD-Core Version:    0.7.0.1
 */