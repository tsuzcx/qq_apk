package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a qZj;
  
  static
  {
    AppMethodBeat.i(210963);
    qZj = new a((byte)0);
    AppMethodBeat.o(210963);
  }
  
  public static final void c(chg paramchg)
  {
    AppMethodBeat.i(210965);
    dbn localdbn2 = a.cqu();
    dbn localdbn1 = localdbn2;
    if (localdbn2 == null) {
      localdbn1 = new dbn();
    }
    if (localdbn1.Hrm) {
      localdbn1.Hrh = localdbn1.Hrj;
    }
    for (;;)
    {
      localdbn1.Hrl = localdbn1.Hrm;
      localdbn1.Hrm = false;
      localdbn1.Hrk = paramchg;
      a.a(localdbn1);
      AppMethodBeat.o(210965);
      return;
      localdbn1.Hri = localdbn1.Hrk;
    }
  }
  
  public static final dbn cqt()
  {
    AppMethodBeat.i(210966);
    dbn localdbn = a.cqu();
    AppMethodBeat.o(210966);
    return localdbn;
  }
  
  public static final void k(chk paramchk)
  {
    AppMethodBeat.i(210964);
    if (paramchk == null)
    {
      AppMethodBeat.o(210964);
      return;
    }
    int i = a.cnY();
    if ((i == 7) || (i == 8))
    {
      ad.i("HABBYGE-MALI.SessionPairDao", "setCurSession, activityMethod: ".concat(String.valueOf(i)));
      AppMethodBeat.o(210964);
      return;
    }
    dbn localdbn2 = a.cqu();
    dbn localdbn1 = localdbn2;
    if (localdbn2 == null) {
      localdbn1 = new dbn();
    }
    if (localdbn1.Hrm) {
      localdbn1.Hrh = localdbn1.Hrj;
    }
    for (;;)
    {
      localdbn1.Hrl = localdbn1.Hrm;
      localdbn1.Hrm = true;
      localdbn1.Hrj = paramchk;
      a.a(localdbn1);
      AppMethodBeat.o(210964);
      return;
      localdbn1.Hri = localdbn1.Hrk;
    }
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(210967);
    b.p("mmkv_sionpairD_table_hell", new byte[0]);
    AppMethodBeat.o(210967);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionPair;", "_write", "", "pair", "get", "print", "sessionPair", "reset", "setCurSession", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "setCurUnKnown", "page", "Lcom/tencent/mm/protocal/protobuf/Page;", "plugin-expt_release"})
  public static final class a
  {
    static void a(dbn paramdbn)
    {
      AppMethodBeat.i(210961);
      if (paramdbn == null)
      {
        AppMethodBeat.o(210961);
        return;
      }
      try
      {
        paramdbn = paramdbn.toByteArray();
        if (paramdbn == null)
        {
          AppMethodBeat.o(210961);
          return;
        }
      }
      catch (IOException paramdbn)
      {
        ad.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)paramdbn, "SessionPair, _write: %s", new Object[] { paramdbn.getMessage() });
        AppMethodBeat.o(210961);
        return;
      }
      b.p("mmkv_sionpairD_table_hell", paramdbn);
      AppMethodBeat.o(210961);
    }
    
    static dbn cqu()
    {
      AppMethodBeat.i(210962);
      byte[] arrayOfByte = b.getBytes("mmkv_sionpairD_table_hell");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(210962);
        return null;
      }
      dbn localdbn = new dbn();
      try
      {
        localdbn.parseFrom(arrayOfByte);
        AppMethodBeat.o(210962);
        return localdbn;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)localIOException, "SessionPair, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(210962);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.l
 * JD-Core Version:    0.7.0.1
 */