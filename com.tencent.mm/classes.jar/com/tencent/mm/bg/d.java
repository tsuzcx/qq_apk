package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class d
  implements com.tencent.mm.ak.g
{
  public static int chatType;
  private static final f<Integer, d.a> fAs;
  private static d hUh;
  public boolean fRX = false;
  private int hPz = 3;
  
  static
  {
    AppMethodBeat.i(148389);
    fAs = new h(5);
    chatType = 0;
    AppMethodBeat.o(148389);
  }
  
  public static int Dv(String paramString)
  {
    int i = 5;
    AppMethodBeat.i(148383);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(148383);
      return 5;
    }
    if ((!paramString.startsWith("single")) || (paramString.startsWith("chatroom"))) {
      i = 7;
    }
    if (paramString.startsWith("app")) {
      i = 8;
    }
    ac.d("upload", "type ".concat(String.valueOf(i)));
    AppMethodBeat.o(148383);
    return i;
  }
  
  public static d aIe()
  {
    AppMethodBeat.i(148384);
    if (hUh == null) {
      hUh = new d();
    }
    d locald = hUh;
    AppMethodBeat.o(148384);
    return locald;
  }
  
  public static void aIf()
  {
    AppMethodBeat.i(148387);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(16646145, Integer.valueOf(0));
    AppMethodBeat.o(148387);
  }
  
  public static void aIg()
  {
    AppMethodBeat.i(148388);
    com.tencent.mm.kernel.g.agS();
    Integer localInteger2 = Integer.valueOf(bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(16646145, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(148388);
  }
  
  public static String getPrefix()
  {
    switch (chatType)
    {
    default: 
      return "single_";
    case 0: 
      return "single_";
    case 1: 
      return "chatroom_";
    }
    return "app_";
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148386);
    if ((!(paramn instanceof p)) || (((p)paramn).aBJ() != 9))
    {
      ac.d("upload", "another scene");
      AppMethodBeat.o(148386);
      return;
    }
    if (paramn.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(81944, Long.valueOf(bs.aNx()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(148386);
      return;
      label91:
      paramInt1 = this.hPz - 1;
      this.hPz = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(81944, Long.valueOf((bs.eWj() - 86400000L + 3600000L) / 1000L));
        this.hPz = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148385);
    this.fRX = false;
    com.tencent.mm.kernel.g.agi().b(159, this);
    AppMethodBeat.o(148385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bg.d
 * JD-Core Version:    0.7.0.1
 */