package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class g
{
  public static final a sFI;
  
  static
  {
    AppMethodBeat.i(220957);
    sFI = new a((byte)0);
    AppMethodBeat.o(220957);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao$Companion;", "", "()V", "MMKV_KEY", "", "getNoticeStartTime", "", "setNoticeStartTime", "", "value", "plugin-expt_release"})
  public static final class a
  {
    public static void Hg(int paramInt)
    {
      AppMethodBeat.i(220955);
      Object localObject = String.valueOf(paramInt);
      Charset localCharset = d.UTF_8;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(220955);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      b.o("hell_live_state_mkv_key", (byte[])localObject);
      AppMethodBeat.o(220955);
    }
    
    public static int cPm()
    {
      AppMethodBeat.i(220956);
      byte[] arrayOfByte = b.getBytes("hell_live_state_mkv_key");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(220956);
        return 0;
      }
      try
      {
        i = Integer.parseInt(new String(arrayOfByte, d.UTF_8));
        AppMethodBeat.o(220956);
        return i;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(220956);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.g
 * JD-Core Version:    0.7.0.1
 */