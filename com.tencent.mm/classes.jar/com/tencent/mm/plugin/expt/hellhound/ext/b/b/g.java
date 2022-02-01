package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a zHI;
  
  static
  {
    AppMethodBeat.i(300558);
    zHI = new a((byte)0);
    AppMethodBeat.o(300558);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao$Companion;", "", "()V", "MMKV_KEY", "", "getNoticeStartTime", "", "setNoticeStartTime", "", "value", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void LP(int paramInt)
    {
      AppMethodBeat.i(300578);
      Object localObject = String.valueOf(paramInt);
      Charset localCharset = d.UTF_8;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(300578);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).getBytes(localCharset);
      s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      b.u("hell_live_state_mkv_key", (byte[])localObject);
      AppMethodBeat.o(300578);
    }
    
    public static int dKQ()
    {
      AppMethodBeat.i(300583);
      byte[] arrayOfByte = b.ard("hell_live_state_mkv_key");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(300583);
        return 0;
      }
      try
      {
        i = Integer.parseInt(new String(arrayOfByte, d.UTF_8));
        AppMethodBeat.o(300583);
        return i;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(300583);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.g
 * JD-Core Version:    0.7.0.1
 */