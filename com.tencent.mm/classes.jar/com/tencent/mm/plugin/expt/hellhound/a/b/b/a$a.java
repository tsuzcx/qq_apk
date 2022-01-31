package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/HellKSessionDao$Companion;", "", "()V", "MMKV_KEY_HELL_SESSIONS", "", "TAG", "addSession", "", "session", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "addUnknownPage", "page", "Lcom/tencent/mm/protocal/protobuf/Page;", "clearCurSession", "getCurSeq", "", "getCurSession", "getCurUnknownPage", "getHellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "isIndicatorLegal", "", "hellSession", "isUnknownPageIndicatorLegal", "read", "reset", "resetCurSeq", "setHellSession", "updateCurSession", "newSession", "updateCurUnknownPage", "newPage", "updateSessionOnClose", "curSession", "writeBack", "plugin-expt_release"})
public final class a$a
{
  static ava bsm()
  {
    AppMethodBeat.i(152522);
    byte[] arrayOfByte = b.getBytes("mmkv_key_hell_sessions");
    if (arrayOfByte != null) {
      if (arrayOfByte.length != 0) {
        break label40;
      }
    }
    label40:
    for (int i = 1; i != 0; i = 0)
    {
      ab.e("HellSessionDao", "habbyge-mali, HellSession read(): NULL");
      AppMethodBeat.o(152522);
      return null;
    }
    ava localava = new ava();
    try
    {
      localava.parseFrom(arrayOfByte);
      AppMethodBeat.o(152522);
      return localava;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("HellSessionDao", (Throwable)localException, "habbyge-mali, HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(152522);
    }
    return null;
  }
  
  static void c(ava paramava)
  {
    AppMethodBeat.i(152521);
    if (paramava == null) {}
    try
    {
      AppMethodBeat.o(152521);
      return;
    }
    catch (Exception paramava)
    {
      ab.printErrStackTrace("HellSessionDao", (Throwable)paramava, "habbyge-mali, HellSessionDao._writeBack", new Object[0]);
      AppMethodBeat.o(152521);
    }
    b.v("mmkv_key_hell_sessions", paramava.toByteArray());
    AppMethodBeat.o(152521);
    return;
  }
  
  static boolean d(ava paramava)
  {
    AppMethodBeat.i(152523);
    if (paramava == null)
    {
      AppMethodBeat.o(152523);
      return false;
    }
    if ((paramava.xkl >= 0) && (paramava.xkl < paramava.xkk.size()))
    {
      AppMethodBeat.o(152523);
      return true;
    }
    AppMethodBeat.o(152523);
    return false;
  }
  
  static boolean e(ava paramava)
  {
    AppMethodBeat.i(152524);
    if (paramava == null)
    {
      AppMethodBeat.o(152524);
      return false;
    }
    if ((paramava.xkn >= 0) && (paramava.xkn < paramava.xkm.size()))
    {
      AppMethodBeat.o(152524);
      return true;
    }
    AppMethodBeat.o(152524);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.a.a
 * JD-Core Version:    0.7.0.1
 */