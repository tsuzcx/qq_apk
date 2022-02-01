package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellResponseDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  public static final a rii;
  
  static
  {
    AppMethodBeat.i(196674);
    rii = new a((byte)0);
    AppMethodBeat.o(196674);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellResponseDao$Companion;", "", "()V", "FLAG_DEL", "", "MMKV_KEY", "", "TAG", "_doSetResp", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "getConfigIds", "", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "read", "reset", "setResp", "write", "plugin-expt_release"})
  public static final class a
  {
    public static bcx csv()
    {
      AppMethodBeat.i(196673);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_resp_mkv_key");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(196673);
        return null;
      }
      bcx localbcx = new bcx();
      try
      {
        localbcx.parseFrom(arrayOfByte);
        AppMethodBeat.o(196673);
        return localbcx;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)localException, "HellResponseDao, read: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(196673);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a.b
 * JD-Core Version:    0.7.0.1
 */