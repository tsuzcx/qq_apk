package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hm;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.g.b.a.ho;
import com.tencent.mm.model.ab;

public final class z
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194037);
    int i = 1;
    if (ab.JO(paramString1)) {
      i = 2;
    }
    ho localho = new ho();
    localho.vp(paramString1);
    localho.enM = i;
    localho.eMc = paramInt1;
    localho.eLz = paramInt2;
    localho.ejW = paramInt3;
    localho.eMf = paramInt4;
    localho.vq(paramString2);
    localho.vr(paramString3);
    localho.bfK();
    AppMethodBeat.o(194037);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194039);
    int i = 0;
    if (ab.JO(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      hn localhn = new hn();
      localhn.vm(paramString1);
      localhn.enM = i;
      localhn.eLz = paramInt1;
      localhn.ejW = paramInt2;
      localhn.eMc = paramInt3;
      localhn.vn(paramString2);
      localhn.vo(paramString3);
      localhn.bfK();
      AppMethodBeat.o(194039);
      return;
      if (ab.JN(paramString1)) {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194038);
    int i = 0;
    if (ab.JO(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      hm localhm = new hm();
      localhm.vj(paramString1);
      localhm.enM = i;
      localhm.eLz = paramInt1;
      localhm.erw = paramInt2;
      localhm.aha();
      localhm.vk(paramString2);
      localhm.vl(paramString3);
      localhm.bfK();
      AppMethodBeat.o(194038);
      return;
      if (ab.JN(paramString1)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.z
 * JD-Core Version:    0.7.0.1
 */