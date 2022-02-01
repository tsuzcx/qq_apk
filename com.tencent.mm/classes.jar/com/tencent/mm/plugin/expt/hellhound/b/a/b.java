package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellResponseDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  public static final a wpK;
  
  static
  {
    AppMethodBeat.i(251917);
    wpK = new a((byte)0);
    AppMethodBeat.o(251917);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellResponseDao$Companion;", "", "()V", "FLAG_DEL", "", "MMKV_KEY", "", "TAG", "_doSetResp", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "getConfigIds", "", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "read", "reset", "setResp", "write", "plugin-expt_release"})
  public static final class a
  {
    public static bvy dfZ()
    {
      AppMethodBeat.i(253400);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("hell_resp_mkv_key");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(253400);
        return null;
      }
      bvy localbvy = new bvy();
      try
      {
        localbvy.parseFrom(arrayOfByte);
        AppMethodBeat.o(253400);
        return localbvy;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)localException, "HellResponseDao, read: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(253400);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a.b
 * JD-Core Version:    0.7.0.1
 */