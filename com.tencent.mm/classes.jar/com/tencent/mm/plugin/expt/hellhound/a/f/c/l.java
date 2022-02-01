package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a rhp;
  
  static
  {
    AppMethodBeat.i(196634);
    rhp = new a((byte)0);
    AppMethodBeat.o(196634);
  }
  
  public static final void c(cia paramcia)
  {
    AppMethodBeat.i(196636);
    dch localdch2 = a.crW();
    dch localdch1 = localdch2;
    if (localdch2 == null) {
      localdch1 = new dch();
    }
    if (localdch1.HKO) {
      localdch1.HKJ = localdch1.HKL;
    }
    for (;;)
    {
      localdch1.HKN = localdch1.HKO;
      localdch1.HKO = false;
      localdch1.HKM = paramcia;
      a.a(localdch1);
      AppMethodBeat.o(196636);
      return;
      localdch1.HKK = localdch1.HKM;
    }
  }
  
  public static final dch crV()
  {
    AppMethodBeat.i(196637);
    dch localdch = a.crW();
    AppMethodBeat.o(196637);
    return localdch;
  }
  
  public static final void o(cie paramcie)
  {
    AppMethodBeat.i(196635);
    if (paramcie == null)
    {
      AppMethodBeat.o(196635);
      return;
    }
    int i = a.cpA();
    if ((i == 7) || (i == 8))
    {
      ae.i("HABBYGE-MALI.SessionPairDao", "setCurSession, activityMethod: ".concat(String.valueOf(i)));
      AppMethodBeat.o(196635);
      return;
    }
    dch localdch2 = a.crW();
    dch localdch1 = localdch2;
    if (localdch2 == null) {
      localdch1 = new dch();
    }
    if (localdch1.HKO) {
      localdch1.HKJ = localdch1.HKL;
    }
    for (;;)
    {
      localdch1.HKN = localdch1.HKO;
      localdch1.HKO = true;
      localdch1.HKL = paramcie;
      a.a(localdch1);
      AppMethodBeat.o(196635);
      return;
      localdch1.HKK = localdch1.HKM;
    }
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(196638);
    b.p("mmkv_sionpairD_table_hell", new byte[0]);
    AppMethodBeat.o(196638);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionPair;", "_write", "", "pair", "get", "print", "sessionPair", "reset", "setCurSession", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "setCurUnKnown", "page", "Lcom/tencent/mm/protocal/protobuf/Page;", "plugin-expt_release"})
  public static final class a
  {
    static void a(dch paramdch)
    {
      AppMethodBeat.i(196632);
      if (paramdch == null)
      {
        AppMethodBeat.o(196632);
        return;
      }
      try
      {
        paramdch = paramdch.toByteArray();
        if (paramdch == null)
        {
          AppMethodBeat.o(196632);
          return;
        }
      }
      catch (IOException paramdch)
      {
        ae.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)paramdch, "SessionPair, _write: %s", new Object[] { paramdch.getMessage() });
        AppMethodBeat.o(196632);
        return;
      }
      b.p("mmkv_sionpairD_table_hell", paramdch);
      AppMethodBeat.o(196632);
    }
    
    static dch crW()
    {
      AppMethodBeat.i(196633);
      byte[] arrayOfByte = b.getBytes("mmkv_sionpairD_table_hell");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(196633);
        return null;
      }
      dch localdch = new dch();
      try
      {
        localdch.parseFrom(arrayOfByte);
        AppMethodBeat.o(196633);
        return localdch;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)localIOException, "SessionPair, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(196633);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.l
 * JD-Core Version:    0.7.0.1
 */