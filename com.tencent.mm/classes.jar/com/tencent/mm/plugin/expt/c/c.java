package com.tencent.mm.plugin.expt.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/biz/TelePmMonitor;", "", "()V", "Companion", "plugin-expt_release"})
public final class c
{
  private static final HashMap<String, List<Pair<String, String>>> sxo;
  private static final c.b sxp;
  public static final c.a sxq;
  
  static
  {
    AppMethodBeat.i(220736);
    sxq = new c.a((byte)0);
    sxo = new HashMap();
    sxp = new c.b();
    AppMethodBeat.o(220736);
  }
  
  public static final void cMH()
  {
    AppMethodBeat.i(220737);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("listen", "(Landroid/telephony/PhoneStateListener;I)V"));
    ((Map)sxo).put("android/telephony/TelephonyManager", localArrayList);
    a.axP();
    a.a((Map)sxo, (b)sxp);
    AppMethodBeat.o(220737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.c
 * JD-Core Version:    0.7.0.1
 */