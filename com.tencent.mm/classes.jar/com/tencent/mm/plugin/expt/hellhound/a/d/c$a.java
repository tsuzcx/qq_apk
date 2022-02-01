package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"})
public final class c$a
{
  public static ArrayList<cwa> aaJ(String paramString)
  {
    AppMethodBeat.i(122575);
    k.h(paramString, "sid");
    k.g(d.ckF(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject = d.ckG();
    if (localObject == null)
    {
      AppMethodBeat.o(122575);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((cvx)localObject).FGz.iterator();
    while (((Iterator)localObject).hasNext())
    {
      cwa localcwa = (cwa)((Iterator)localObject).next();
      if ((localcwa != null) && (localcwa.type == 1) && ((!(k.g(localcwa.qon, paramString) ^ true)) || (!(k.g(localcwa.qon, "-1") ^ true))) && (!localcwa.FGD.isEmpty())) {
        localArrayList.add(localcwa);
      }
    }
    ac.i("FuzzyMatchConfig", "HABBYGE-MALI, FuzzyMatchConfig, getConfig: " + localArrayList.size());
    AppMethodBeat.o(122575);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.c.a
 * JD-Core Version:    0.7.0.1
 */