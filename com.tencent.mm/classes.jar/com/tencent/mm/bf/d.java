package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.h;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class d
  implements com.tencent.mm.ai.f
{
  public static int chatType;
  private static final com.tencent.mm.a.f<Integer, d.a> eka;
  private static d fQY;
  private int fMl = 3;
  public boolean fpN = false;
  
  static
  {
    AppMethodBeat.i(116553);
    eka = new h(5);
    chatType = 0;
    AppMethodBeat.o(116553);
  }
  
  public static d akj()
  {
    AppMethodBeat.i(116548);
    if (fQY == null) {
      fQY = new d();
    }
    d locald = fQY;
    AppMethodBeat.o(116548);
    return locald;
  }
  
  public static void akk()
  {
    AppMethodBeat.i(116551);
    g.RM();
    g.RL().Ru().set(16646145, Integer.valueOf(0));
    AppMethodBeat.o(116551);
  }
  
  public static void akl()
  {
    AppMethodBeat.i(116552);
    g.RM();
    Integer localInteger2 = Integer.valueOf(bo.g((Integer)g.RL().Ru().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    g.RM();
    g.RL().Ru().set(16646145, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(116552);
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
  
  public static int uD(String paramString)
  {
    int i = 5;
    AppMethodBeat.i(116547);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(116547);
      return 5;
    }
    if ((!paramString.startsWith("single")) || (paramString.startsWith("chatroom"))) {
      i = 7;
    }
    if (paramString.startsWith("app")) {
      i = 8;
    }
    ab.d("upload", "type ".concat(String.valueOf(i)));
    AppMethodBeat.o(116547);
    return i;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(116550);
    if ((!(paramm instanceof o)) || (((o)paramm).ads() != 9))
    {
      ab.d("upload", "another scene");
      AppMethodBeat.o(116550);
      return;
    }
    if (paramm.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      g.RM();
      g.RL().Ru().set(81944, Long.valueOf(bo.aox()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(116550);
      return;
      label91:
      paramInt1 = this.fMl - 1;
      this.fMl = paramInt1;
      if (paramInt1 < 0)
      {
        g.RM();
        g.RL().Ru().set(81944, Long.valueOf((bo.aoy() - 86400000L + 3600000L) / 1000L));
        this.fMl = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(116549);
    this.fpN = false;
    g.Rc().b(159, this);
    AppMethodBeat.o(116549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bf.d
 * JD-Core Version:    0.7.0.1
 */