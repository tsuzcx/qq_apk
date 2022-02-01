package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class c
{
  public static final a sHX;
  
  static
  {
    AppMethodBeat.i(122576);
    sHX = new a((byte)0);
    AppMethodBeat.o(122576);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"})
  public static final class a
  {
    public static ArrayList<dvk> aqe(String paramString)
    {
      AppMethodBeat.i(122575);
      p.h(paramString, "sid");
      p.g(d.cQe(), "HellSessionPageCloudConfig.getInstance()");
      Object localObject = d.cQf();
      if (localObject == null)
      {
        AppMethodBeat.o(122575);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((dvh)localObject).MWn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dvk localdvk = (dvk)((Iterator)localObject).next();
        if ((localdvk != null) && (localdvk.type == 1) && ((!(p.j(localdvk.sGF, paramString) ^ true)) || (!(p.j(localdvk.sGF, "-1") ^ true))) && (!localdvk.MWr.isEmpty())) {
          localArrayList.add(localdvk);
        }
      }
      Log.i("HABBYGE-MALI.FuzzyMatchConfig", "FuzzyMatchConfig, getConfig: " + localArrayList.size());
      AppMethodBeat.o(122575);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.c
 * JD-Core Version:    0.7.0.1
 */