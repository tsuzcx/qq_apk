package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class c
{
  public static final a rgB;
  
  static
  {
    AppMethodBeat.i(122576);
    rgB = new a((byte)0);
    AppMethodBeat.o(122576);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"})
  public static final class a
  {
    public static ArrayList<dcg> aft(String paramString)
    {
      AppMethodBeat.i(122575);
      p.h(paramString, "sid");
      p.g(d.crw(), "HellSessionPageCloudConfig.getInstance()");
      Object localObject = d.crx();
      if (localObject == null)
      {
        AppMethodBeat.o(122575);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((dcd)localObject).HKE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dcg localdcg = (dcg)((Iterator)localObject).next();
        if ((localdcg != null) && (localdcg.type == 1) && ((!(p.i(localdcg.rfp, paramString) ^ true)) || (!(p.i(localdcg.rfp, "-1") ^ true))) && (!localdcg.HKI.isEmpty())) {
          localArrayList.add(localdcg);
        }
      }
      ae.i("HABBYGE-MALI.FuzzyMatchConfig", "FuzzyMatchConfig, getConfig: " + localArrayList.size());
      AppMethodBeat.o(122575);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.c
 * JD-Core Version:    0.7.0.1
 */