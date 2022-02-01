package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class c
{
  public static final a pGP;
  
  static
  {
    AppMethodBeat.i(122576);
    pGP = new a((byte)0);
    AppMethodBeat.o(122576);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"})
  public static final class a
  {
    public static ArrayList<cqt> Wm(String paramString)
    {
      AppMethodBeat.i(122575);
      k.h(paramString, "sid");
      k.g(d.ccX(), "HellSessionPageCloudConfig.getInstance()");
      Object localObject = d.ccY();
      if (localObject == null)
      {
        AppMethodBeat.o(122575);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((cqq)localObject).EjB.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cqt localcqt = (cqt)((Iterator)localObject).next();
        if ((localcqt != null) && (localcqt.type == 1) && ((!(k.g(localcqt.pZX, paramString) ^ true)) || (!(k.g(localcqt.pZX, "-1") ^ true))) && (!localcqt.EjF.isEmpty())) {
          localArrayList.add(localcqt);
        }
      }
      ad.i("FuzzyMatchConfig", "HABBYGE-MALI, FuzzyMatchConfig, getConfig: " + localArrayList.size());
      AppMethodBeat.o(122575);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.c
 * JD-Core Version:    0.7.0.1
 */