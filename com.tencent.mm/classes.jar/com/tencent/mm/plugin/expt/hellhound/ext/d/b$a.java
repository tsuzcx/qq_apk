package com.tencent.mm.plugin.expt.hellhound.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.d;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  public static ArrayList<ezf> asj(String paramString)
  {
    AppMethodBeat.i(122575);
    s.u(paramString, "sid");
    d.dLN();
    Object localObject = d.dLO();
    if (localObject == null)
    {
      AppMethodBeat.o(122575);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ezc)localObject).abAh.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ezf localezf = (ezf)((Iterator)localObject).next();
      if ((localezf != null) && (localezf.type == 1) && ((s.p(localezf.zIC, paramString)) || (s.p(localezf.zIC, "-1"))) && (!localezf.abAl.isEmpty())) {
        localArrayList.add(localezf);
      }
    }
    Log.i("HABBYGE-MALI.FuzzyMatchConfig", s.X("FuzzyMatchConfig, getConfig: ", Integer.valueOf(localArrayList.size())));
    AppMethodBeat.o(122575);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.d.b.a
 * JD-Core Version:    0.7.0.1
 */