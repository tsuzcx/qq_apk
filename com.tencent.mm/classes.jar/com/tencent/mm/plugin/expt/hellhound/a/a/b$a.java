package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellResponseDao$Companion;", "", "()V", "FLAG_DEL", "", "MMKV_KEY", "", "TAG", "_doSetResp", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "getConfigIds", "", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "read", "reset", "setResp", "write", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  public static ckz dMJ()
  {
    AppMethodBeat.i(299908);
    byte[] arrayOfByte = b.ard("hell_resp_mkv_key");
    if (arrayOfByte != null) {
      if (arrayOfByte.length != 0) {
        break label33;
      }
    }
    label33:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(299908);
      return null;
    }
    ckz localckz = new ckz();
    try
    {
      localckz.parseFrom(arrayOfByte);
      AppMethodBeat.o(299908);
      return localckz;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)localException, s.X("HellResponseDao, read: ", localException.getMessage()), new Object[0]);
      AppMethodBeat.o(299908);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */