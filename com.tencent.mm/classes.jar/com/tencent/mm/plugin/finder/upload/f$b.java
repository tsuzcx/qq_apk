package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/FinderPostFileManager$postingFileClaimers$1$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "listOwnFiles", "", "", "name", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$b
  implements f.a
{
  public final List<String> fdV()
  {
    AppMethodBeat.i(342825);
    Object localObject = new ArrayList();
    Iterator localIterator = ((Iterable)((PluginFinder)h.az(PluginFinder.class)).getFeedStorage().eZj()).iterator();
    while (localIterator.hasNext())
    {
      FinderItem localFinderItem = (FinderItem)localIterator.next();
      f localf = f.GbE;
      f.a(localFinderItem, (ArrayList)localObject);
    }
    localObject = (List)localObject;
    AppMethodBeat.o(342825);
    return localObject;
  }
  
  public final String name()
  {
    return "unsentFileClaimer";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f.b
 * JD-Core Version:    0.7.0.1
 */