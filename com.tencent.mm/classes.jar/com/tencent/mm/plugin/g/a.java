package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.al;

public final class a
  extends q
  implements com.tencent.mm.plugin.auth.a.a
{
  private static a kDr;
  
  private a()
  {
    super(f.class);
  }
  
  public static a bfN()
  {
    try
    {
      AppMethodBeat.i(79085);
      if (kDr == null) {
        kDr = new a();
      }
      a locala = kDr;
      AppMethodBeat.o(79085);
      return locala;
    }
    finally {}
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void a(v.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(79086);
    if (paramb.wiP.lGw != 0) {
      al.d(new a.1(paramb.wiP.wwy, paramb.wiP.wwz, paramb.wiP.wwA));
    }
    AppMethodBeat.o(79086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a
 * JD-Core Version:    0.7.0.1
 */