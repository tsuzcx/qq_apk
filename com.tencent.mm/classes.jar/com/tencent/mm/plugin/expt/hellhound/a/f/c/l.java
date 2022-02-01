package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a woI;
  
  static
  {
    AppMethodBeat.i(251487);
    woI = new a((byte)0);
    AppMethodBeat.o(251487);
  }
  
  public static final void c(dht paramdht)
  {
    AppMethodBeat.i(251489);
    efn localefn2 = a.dfy();
    efn localefn1 = localefn2;
    if (localefn2 == null) {
      localefn1 = new efn();
    }
    if (localefn1.UiS) {
      localefn1.UiN = localefn1.UiP;
    }
    for (;;)
    {
      localefn1.UiR = localefn1.UiS;
      localefn1.UiS = false;
      localefn1.UiQ = paramdht;
      a.a(localefn1);
      AppMethodBeat.o(251489);
      return;
      localefn1.UiO = localefn1.UiQ;
    }
  }
  
  public static final efn dfx()
  {
    AppMethodBeat.i(251490);
    efn localefn = a.dfy();
    AppMethodBeat.o(251490);
    return localefn;
  }
  
  public static final void o(dhx paramdhx)
  {
    AppMethodBeat.i(251488);
    if (paramdhx == null)
    {
      AppMethodBeat.o(251488);
      return;
    }
    int i = a.dcL();
    if ((i == 7) || (i == 8))
    {
      Log.i("HABBYGE-MALI.SessionPairDao", "setCurSession, activityMethod: ".concat(String.valueOf(i)));
      AppMethodBeat.o(251488);
      return;
    }
    efn localefn2 = a.dfy();
    efn localefn1 = localefn2;
    if (localefn2 == null) {
      localefn1 = new efn();
    }
    if (localefn1.UiS) {
      localefn1.UiN = localefn1.UiP;
    }
    for (;;)
    {
      localefn1.UiR = localefn1.UiS;
      localefn1.UiS = true;
      localefn1.UiP = paramdhx;
      a.a(localefn1);
      AppMethodBeat.o(251488);
      return;
      localefn1.UiO = localefn1.UiQ;
    }
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(251492);
    b.r("mmkv_sionpairD_table_hell", new byte[0]);
    AppMethodBeat.o(251492);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionPair;", "_write", "", "pair", "get", "print", "sessionPair", "reset", "setCurSession", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "setCurUnKnown", "page", "Lcom/tencent/mm/protocal/protobuf/Page;", "plugin-expt_release"})
  public static final class a
  {
    static void a(efn paramefn)
    {
      AppMethodBeat.i(251600);
      if (paramefn == null)
      {
        AppMethodBeat.o(251600);
        return;
      }
      try
      {
        paramefn = paramefn.toByteArray();
        if (paramefn == null)
        {
          AppMethodBeat.o(251600);
          return;
        }
      }
      catch (IOException paramefn)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)paramefn, "SessionPair, _write: %s", new Object[] { paramefn.getMessage() });
        AppMethodBeat.o(251600);
        return;
      }
      b.r("mmkv_sionpairD_table_hell", paramefn);
      AppMethodBeat.o(251600);
    }
    
    static efn dfy()
    {
      AppMethodBeat.i(251602);
      byte[] arrayOfByte = b.awZ("mmkv_sionpairD_table_hell");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(251602);
        return null;
      }
      efn localefn = new efn();
      try
      {
        localefn.parseFrom(arrayOfByte);
        AppMethodBeat.o(251602);
        return localefn;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)localIOException, "SessionPair, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(251602);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.l
 * JD-Core Version:    0.7.0.1
 */