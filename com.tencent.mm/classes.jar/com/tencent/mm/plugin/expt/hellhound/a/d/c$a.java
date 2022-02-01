package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"})
public final class c$a
{
  public static ArrayList<dbm> aex(String paramString)
  {
    AppMethodBeat.i(122575);
    p.h(paramString, "sid");
    p.g(d.cpU(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject = d.cpV();
    if (localObject == null)
    {
      AppMethodBeat.o(122575);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((dbj)localObject).Hrc.iterator();
    while (((Iterator)localObject).hasNext())
    {
      dbm localdbm = (dbm)((Iterator)localObject).next();
      if ((localdbm != null) && (localdbm.type == 1) && ((!(p.i(localdbm.qXk, paramString) ^ true)) || (!(p.i(localdbm.qXk, "-1") ^ true))) && (!localdbm.Hrg.isEmpty())) {
        localArrayList.add(localdbm);
      }
    }
    ad.i("HABBYGE-MALI.FuzzyMatchConfig", "FuzzyMatchConfig, getConfig: " + localArrayList.size());
    AppMethodBeat.o(122575);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.c.a
 * JD-Core Version:    0.7.0.1
 */