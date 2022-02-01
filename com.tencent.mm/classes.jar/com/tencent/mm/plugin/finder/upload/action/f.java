package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FinderFeedCleaner;", "", "()V", "TAG", "", "TYPE_FOLLOW", "", "TYPE_NO_SEE_AUTHOR", "TYPE_NO_SEE_FRIEND", "finderUserName", "followRecorder", "Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "noSeeAuthorRecorder", "noSeeFriend", "recorderStore", "Lcom/tencent/mm/plugin/finder/upload/action/FinderFeedCleaner$RecorderStore;", "recorderStoreMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "cleanFeed", "", "tabType", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "cleanTimeline", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "cleanTimelinePage", "getRecorder", "type", "isAllRecordEmpty", "", "isNeedClean", "onAccountInit", "onAccountRelease", "printRecord", "recordClean", "isClean", "release", "RecorderStore", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f GcR;
  public static g GcS;
  public static g GcT;
  public static g GcU;
  public static f.a GcV;
  public static final HashMap<String, f.a> GcW;
  public static String zDJ;
  
  static
  {
    AppMethodBeat.i(343399);
    GcR = new f();
    zDJ = "";
    GcW = new HashMap();
    AppMethodBeat.o(343399);
  }
  
  public static boolean TN(int paramInt)
  {
    Object localObject = null;
    g localg1 = null;
    AppMethodBeat.i(343374);
    boolean bool1;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(343374);
      return false;
    case 3: 
      g localg2 = GcS;
      localObject = localg2;
      if (localg2 == null)
      {
        s.bIx("followRecorder");
        localObject = null;
      }
      bool1 = ((g)localObject).qn();
      localObject = GcT;
      if (localObject == null)
      {
        s.bIx("noSeeAuthorRecorder");
        localObject = localg1;
      }
      for (;;)
      {
        boolean bool2 = ((g)localObject).qn();
        AppMethodBeat.o(343374);
        return bool2 | bool1;
      }
    }
    localg1 = GcT;
    if (localg1 == null) {
      s.bIx("noSeeAuthorRecorder");
    }
    for (;;)
    {
      bool1 = ((g)localObject).qn();
      AppMethodBeat.o(343374);
      return bool1;
      localObject = localg1;
    }
  }
  
  public static void e(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(343356);
    s.u(paramString, "finderUserName");
    Log.i("Finder.FeedCleaner", "recordClean type:" + paramInt + "  finderUserName: " + paramString + " isClean:" + paramBoolean);
    switch (paramInt)
    {
    }
    Object localObject;
    for (;;)
    {
      localObject = null;
      g localg;
      do
      {
        do
        {
          do
          {
            if (localObject == null) {
              break label183;
            }
            s.u(paramString, "finderUserName");
            if (!paramBoolean) {
              break;
            }
            localObject.Gda.add(paramString);
            AppMethodBeat.o(343356);
            return;
            localg = GcS;
            localObject = localg;
          } while (localg != null);
          s.bIx("followRecorder");
          break;
          localg = GcT;
          localObject = localg;
        } while (localg != null);
        s.bIx("noSeeAuthorRecorder");
        break;
        localg = GcU;
        localObject = localg;
      } while (localg != null);
      s.bIx("noSeeFriend");
    }
    localObject.Gda.remove(paramString);
    label183:
    AppMethodBeat.o(343356);
  }
  
  public static void fef()
  {
    Object localObject2 = null;
    AppMethodBeat.i(343366);
    g localg = GcS;
    Object localObject1 = localg;
    if (localg == null)
    {
      s.bIx("followRecorder");
      localObject1 = null;
    }
    Log.i("Finder.FeedCleaner", s.X("printRecord followRecorder:", localObject1));
    localg = GcT;
    localObject1 = localg;
    if (localg == null)
    {
      s.bIx("noSeeAuthorRecorder");
      localObject1 = null;
    }
    Log.i("Finder.FeedCleaner", s.X("printRecord noSeeAuthorRecorder:", localObject1));
    localObject1 = GcU;
    if (localObject1 == null)
    {
      s.bIx("noSeeFriend");
      localObject1 = localObject2;
    }
    for (;;)
    {
      Log.i("Finder.FeedCleaner", s.X("printRecord noSeeFriend:", localObject1));
      AppMethodBeat.o(343366);
      return;
    }
  }
  
  public static boolean feg()
  {
    Object localObject2 = null;
    AppMethodBeat.i(343384);
    g localg = GcS;
    Object localObject1 = localg;
    if (localg == null)
    {
      s.bIx("followRecorder");
      localObject1 = null;
    }
    if (((g)localObject1).isEmpty())
    {
      localg = GcT;
      localObject1 = localg;
      if (localg == null)
      {
        s.bIx("noSeeAuthorRecorder");
        localObject1 = null;
      }
      if (((g)localObject1).isEmpty())
      {
        localObject1 = GcU;
        if (localObject1 == null)
        {
          s.bIx("noSeeFriend");
          localObject1 = localObject2;
        }
        while (((g)localObject1).isEmpty())
        {
          AppMethodBeat.o(343384);
          return true;
        }
      }
    }
    AppMethodBeat.o(343384);
    return false;
  }
  
  public static void onAccountRelease()
  {
    AppMethodBeat.i(343340);
    Log.i("Finder.FeedCleaner", "onAccountRelease");
    AppMethodBeat.o(343340);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements b<cc, Boolean>
  {
    public static final b GcY;
    
    static
    {
      AppMethodBeat.i(343303);
      GcY = new b();
      AppMethodBeat.o(343303);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements b<cc, Boolean>
  {
    public static final c GcZ;
    
    static
    {
      AppMethodBeat.i(343302);
      GcZ = new c();
      AppMethodBeat.o(343302);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.f
 * JD-Core Version:    0.7.0.1
 */