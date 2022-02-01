package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezg;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final a zKN;
  
  static
  {
    AppMethodBeat.i(300180);
    zKN = new a((byte)0);
    AppMethodBeat.o(300180);
  }
  
  public static final void c(ead paramead)
  {
    AppMethodBeat.i(300173);
    ezg localezg2 = a.dMm();
    ezg localezg1 = localezg2;
    if (localezg2 == null) {
      localezg1 = new ezg();
    }
    if (localezg1.abAr) {
      localezg1.abAm = localezg1.abAo;
    }
    for (;;)
    {
      localezg1.abAq = localezg1.abAr;
      localezg1.abAr = false;
      localezg1.abAp = paramead;
      a.a(localezg1);
      AppMethodBeat.o(300173);
      return;
      localezg1.abAn = localezg1.abAp;
    }
  }
  
  public static final ezg dMl()
  {
    AppMethodBeat.i(300174);
    ezg localezg = a.dMm();
    AppMethodBeat.o(300174);
    return localezg;
  }
  
  public static final void m(eah parameah)
  {
    AppMethodBeat.i(300171);
    int i;
    ezg localezg1;
    if (parameah != null)
    {
      i = a.dJn();
      switch (i)
      {
      default: 
        ezg localezg2 = a.dMm();
        localezg1 = localezg2;
        if (localezg2 == null) {
          localezg1 = new ezg();
        }
        if (localezg1.abAr) {
          localezg1.abAm = localezg1.abAo;
        }
        break;
      }
    }
    for (;;)
    {
      localezg1.abAq = localezg1.abAr;
      localezg1.abAr = true;
      localezg1.abAo = parameah;
      a.a(localezg1);
      AppMethodBeat.o(300171);
      return;
      Log.i("HABBYGE-MALI.SessionPairDao", s.X("setCurSession, activityMethod: ", Integer.valueOf(i)));
      AppMethodBeat.o(300171);
      return;
      localezg1.abAn = localezg1.abAp;
    }
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(300176);
    b.u("mmkv_sionpairD_table_hell", new byte[0]);
    AppMethodBeat.o(300176);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionPair;", "_write", "", "pair", "get", "print", "sessionPair", "reset", "setCurSession", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "setCurUnKnown", "page", "Lcom/tencent/mm/protocal/protobuf/Page;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void a(ezg paramezg)
    {
      AppMethodBeat.i(300179);
      if (paramezg == null)
      {
        AppMethodBeat.o(300179);
        return;
      }
      try
      {
        paramezg = paramezg.toByteArray();
        if (paramezg == null)
        {
          AppMethodBeat.o(300179);
          return;
        }
      }
      catch (IOException paramezg)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)paramezg, "SessionPair, _write: %s", new Object[] { paramezg.getMessage() });
        AppMethodBeat.o(300179);
        return;
      }
      b.u("mmkv_sionpairD_table_hell", paramezg);
      AppMethodBeat.o(300179);
    }
    
    static ezg dMm()
    {
      AppMethodBeat.i(300184);
      byte[] arrayOfByte = b.ard("mmkv_sionpairD_table_hell");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(300184);
        return null;
      }
      ezg localezg = new ezg();
      try
      {
        localezg.parseFrom(arrayOfByte);
        AppMethodBeat.o(300184);
        return localezg;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)localIOException, "SessionPair, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(300184);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.l
 * JD-Core Version:    0.7.0.1
 */