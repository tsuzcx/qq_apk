package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.js;
import com.tencent.mm.f.b.a.jt;
import com.tencent.mm.f.b.a.ju;
import com.tencent.mm.model.ab;

public final class z
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188597);
    int i = 1;
    if (ab.Rh(paramString1)) {
      i = 2;
    }
    ju localju = new ju();
    localju.AO(paramString1);
    localju.giO = i;
    localju.gLR = paramInt1;
    localju.gzn = paramInt2;
    localju.geB = paramInt3;
    localju.gLU = paramInt4;
    localju.AP(paramString2);
    localju.AQ(paramString3);
    localju.bpa();
    AppMethodBeat.o(188597);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188599);
    int i = 0;
    if (ab.Rh(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      jt localjt = new jt();
      localjt.AL(paramString1);
      localjt.giO = i;
      localjt.gzn = paramInt1;
      localjt.geB = paramInt2;
      localjt.gLR = paramInt3;
      localjt.AM(paramString2);
      localjt.AN(paramString3);
      localjt.bpa();
      AppMethodBeat.o(188599);
      return;
      if (ab.Rg(paramString1)) {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188598);
    int i = 0;
    if (ab.Rh(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      js localjs = new js();
      localjs.AI(paramString1);
      localjs.giO = i;
      localjs.gzn = paramInt1;
      localjs.gmT = paramInt2;
      localjs.amg();
      localjs.AJ(paramString2);
      localjs.AK(paramString3);
      localjs.bpa();
      AppMethodBeat.o(188598);
      return;
      if (ab.Rg(paramString1)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.z
 * JD-Core Version:    0.7.0.1
 */