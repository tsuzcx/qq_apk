package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class c
{
  public static final a wnS;
  
  static
  {
    AppMethodBeat.i(122576);
    wnS = new a((byte)0);
    AppMethodBeat.o(122576);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"})
  public static final class a
  {
    public static ArrayList<efm> aye(String paramString)
    {
      AppMethodBeat.i(122575);
      p.k(paramString, "sid");
      p.j(d.deY(), "HellSessionPageCloudConfig.getInstance()");
      Object localObject = d.deZ();
      if (localObject == null)
      {
        AppMethodBeat.o(122575);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((efj)localObject).UiI.iterator();
      while (((Iterator)localObject).hasNext())
      {
        efm localefm = (efm)((Iterator)localObject).next();
        if ((localefm != null) && (localefm.type == 1) && ((!(p.h(localefm.wmA, paramString) ^ true)) || (!(p.h(localefm.wmA, "-1") ^ true))) && (!localefm.UiM.isEmpty())) {
          localArrayList.add(localefm);
        }
      }
      Log.i("HABBYGE-MALI.FuzzyMatchConfig", "FuzzyMatchConfig, getConfig: " + localArrayList.size());
      AppMethodBeat.o(122575);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.c
 * JD-Core Version:    0.7.0.1
 */