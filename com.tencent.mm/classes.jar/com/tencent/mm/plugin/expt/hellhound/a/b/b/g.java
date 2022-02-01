package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class g
{
  public static final a wlD;
  
  static
  {
    AppMethodBeat.i(251670);
    wlD = new a((byte)0);
    AppMethodBeat.o(251670);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao$Companion;", "", "()V", "MMKV_KEY", "", "getNoticeStartTime", "", "setNoticeStartTime", "", "value", "plugin-expt_release"})
  public static final class a
  {
    public static void KQ(int paramInt)
    {
      AppMethodBeat.i(252047);
      Object localObject = String.valueOf(paramInt);
      Charset localCharset = d.UTF_8;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(252047);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      b.r("hell_live_state_mkv_key", (byte[])localObject);
      AppMethodBeat.o(252047);
    }
    
    public static int deg()
    {
      AppMethodBeat.i(252048);
      byte[] arrayOfByte = b.awZ("hell_live_state_mkv_key");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(252048);
        return 0;
      }
      try
      {
        i = Integer.parseInt(new String(arrayOfByte, d.UTF_8));
        AppMethodBeat.o(252048);
        return i;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(252048);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.g
 * JD-Core Version:    0.7.0.1
 */