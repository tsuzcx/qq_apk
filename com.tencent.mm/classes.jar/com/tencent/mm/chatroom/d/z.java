package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.model.w;

public final class z
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197038);
    int i = 1;
    if (w.xB(paramString1)) {
      i = 2;
    }
    dm localdm = new dm();
    localdm.lu(paramString1);
    localdm.dFt = i;
    localdm.dSe = paramInt1;
    localdm.dRP = paramInt2;
    localdm.dCS = paramInt3;
    localdm.dSh = paramInt4;
    localdm.lv(paramString2);
    localdm.lw(paramString3);
    localdm.aHZ();
    AppMethodBeat.o(197038);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197040);
    int i = 0;
    if (w.xB(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      dl localdl = new dl();
      localdl.lr(paramString1);
      localdl.dFt = i;
      localdl.dRP = paramInt1;
      localdl.dCS = paramInt2;
      localdl.dSe = paramInt3;
      localdl.ls(paramString2);
      localdl.lt(paramString3);
      localdl.aHZ();
      AppMethodBeat.o(197040);
      return;
      if (w.xA(paramString1)) {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197039);
    int i = 0;
    if (w.xB(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      dk localdk = new dk();
      localdk.lo(paramString1);
      localdk.dFt = i;
      localdk.dRP = paramInt1;
      localdk.dHR = paramInt2;
      localdk.Rc();
      localdk.lp(paramString2);
      localdk.lq(paramString3);
      localdk.aHZ();
      AppMethodBeat.o(197039);
      return;
      if (w.xA(paramString1)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.z
 * JD-Core Version:    0.7.0.1
 */