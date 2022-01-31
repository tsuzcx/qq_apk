package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  implements com.tencent.mm.pluginsdk.k
{
  public static int a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(41430);
    int i = ((l)g.E(l.class)).a(paramd, paramBoolean);
    AppMethodBeat.o(41430);
    return i;
  }
  
  public static void a(ma paramma, int paramInt, String paramString)
  {
    AppMethodBeat.i(41435);
    ((l)g.E(l.class)).a(paramma, paramInt, paramString);
    AppMethodBeat.o(41435);
  }
  
  public static void abort()
  {
    AppMethodBeat.i(41432);
    ((l)g.E(l.class)).bzh();
    AppMethodBeat.o(41432);
  }
  
  public static boolean byX()
  {
    AppMethodBeat.i(41429);
    boolean bool = ((l)g.E(l.class)).bza();
    ab.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is ".concat(String.valueOf(bool)));
    AppMethodBeat.o(41429);
    return bool;
  }
  
  public static boolean byY()
  {
    AppMethodBeat.i(41434);
    boolean bool = ((l)g.E(l.class)).bzb();
    AppMethodBeat.o(41434);
    return bool;
  }
  
  public static com.tencent.mm.pluginsdk.wallet.k byZ()
  {
    AppMethodBeat.i(41436);
    com.tencent.mm.pluginsdk.wallet.k localk = ((l)g.E(l.class)).byZ();
    AppMethodBeat.o(41436);
    return localk;
  }
  
  public static void release()
  {
    AppMethodBeat.i(41431);
    ((l)g.E(l.class)).bzg();
    AppMethodBeat.o(41431);
  }
  
  public static void userCancel()
  {
    AppMethodBeat.i(41433);
    ((l)g.E(l.class)).userCancel();
    AppMethodBeat.o(41433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.c
 * JD-Core Version:    0.7.0.1
 */