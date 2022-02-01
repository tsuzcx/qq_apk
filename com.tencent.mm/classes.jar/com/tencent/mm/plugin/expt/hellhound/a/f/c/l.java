package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a sIL;
  
  static
  {
    AppMethodBeat.i(221126);
    sIL = new a((byte)0);
    AppMethodBeat.o(221126);
  }
  
  public static final void c(cyh paramcyh)
  {
    AppMethodBeat.i(221128);
    dvl localdvl2 = a.cQE();
    dvl localdvl1 = localdvl2;
    if (localdvl2 == null) {
      localdvl1 = new dvl();
    }
    if (localdvl1.MWx) {
      localdvl1.MWs = localdvl1.MWu;
    }
    for (;;)
    {
      localdvl1.MWw = localdvl1.MWx;
      localdvl1.MWx = false;
      localdvl1.MWv = paramcyh;
      a.a(localdvl1);
      AppMethodBeat.o(221128);
      return;
      localdvl1.MWt = localdvl1.MWv;
    }
  }
  
  public static final dvl cQD()
  {
    AppMethodBeat.i(221129);
    dvl localdvl = a.cQE();
    AppMethodBeat.o(221129);
    return localdvl;
  }
  
  public static final void o(cyl paramcyl)
  {
    AppMethodBeat.i(221127);
    if (paramcyl == null)
    {
      AppMethodBeat.o(221127);
      return;
    }
    int i = a.cNT();
    if ((i == 7) || (i == 8))
    {
      Log.i("HABBYGE-MALI.SessionPairDao", "setCurSession, activityMethod: ".concat(String.valueOf(i)));
      AppMethodBeat.o(221127);
      return;
    }
    dvl localdvl2 = a.cQE();
    dvl localdvl1 = localdvl2;
    if (localdvl2 == null) {
      localdvl1 = new dvl();
    }
    if (localdvl1.MWx) {
      localdvl1.MWs = localdvl1.MWu;
    }
    for (;;)
    {
      localdvl1.MWw = localdvl1.MWx;
      localdvl1.MWx = true;
      localdvl1.MWu = paramcyl;
      a.a(localdvl1);
      AppMethodBeat.o(221127);
      return;
      localdvl1.MWt = localdvl1.MWv;
    }
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(221130);
    b.o("mmkv_sionpairD_table_hell", new byte[0]);
    AppMethodBeat.o(221130);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionPair;", "_write", "", "pair", "get", "print", "sessionPair", "reset", "setCurSession", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "setCurUnKnown", "page", "Lcom/tencent/mm/protocal/protobuf/Page;", "plugin-expt_release"})
  public static final class a
  {
    static void a(dvl paramdvl)
    {
      AppMethodBeat.i(221124);
      if (paramdvl == null)
      {
        AppMethodBeat.o(221124);
        return;
      }
      try
      {
        paramdvl = paramdvl.toByteArray();
        if (paramdvl == null)
        {
          AppMethodBeat.o(221124);
          return;
        }
      }
      catch (IOException paramdvl)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)paramdvl, "SessionPair, _write: %s", new Object[] { paramdvl.getMessage() });
        AppMethodBeat.o(221124);
        return;
      }
      b.o("mmkv_sionpairD_table_hell", paramdvl);
      AppMethodBeat.o(221124);
    }
    
    static dvl cQE()
    {
      AppMethodBeat.i(221125);
      byte[] arrayOfByte = b.getBytes("mmkv_sionpairD_table_hell");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(221125);
        return null;
      }
      dvl localdvl = new dvl();
      try
      {
        localdvl.parseFrom(arrayOfByte);
        AppMethodBeat.o(221125);
        return localdvl;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", (Throwable)localIOException, "SessionPair, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(221125);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.l
 * JD-Core Version:    0.7.0.1
 */