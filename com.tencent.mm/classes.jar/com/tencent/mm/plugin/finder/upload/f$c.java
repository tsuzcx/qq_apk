package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/FinderPostFileManager$postingFileClaimers$1$2", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "listOwnFiles", "", "", "name", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$c
  implements f.a
{
  public final List<String> fdV()
  {
    AppMethodBeat.i(342831);
    Object localObject1 = new ArrayList();
    Object localObject2 = h.baE().ban().get(at.a.adcL, "").toString();
    Object localObject3 = f.GbE;
    f.j((String)localObject2, (ArrayList)localObject1);
    localObject2 = j.FKc;
    localObject2 = ((Iterable)j.eYR()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (i)((Iterator)localObject2).next();
      if ((!Util.isNullOrNil(((i)localObject3).field_postIntent)) && ((((i)localObject3).field_objectType == 1) || (((i)localObject3).field_objectType == 0)))
      {
        localObject4 = f.GbE;
        localObject4 = ((i)localObject3).field_postIntent;
        s.s(localObject4, "it.field_postIntent");
        f.j((String)localObject4, (ArrayList)localObject1);
      }
      Object localObject4 = f.GbE;
      f.a(((i)localObject3).eYK(), (ArrayList)localObject1);
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(342831);
    return localObject1;
  }
  
  public final String name()
  {
    return "draftFileClaimer";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f.c
 * JD-Core Version:    0.7.0.1
 */