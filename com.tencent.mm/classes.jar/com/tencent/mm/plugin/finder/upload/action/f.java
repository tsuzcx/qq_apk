package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FinderFeedCleaner;", "", "()V", "TAG", "", "TYPE_FOLLOW", "", "TYPE_NO_SEE_AUTHOR", "TYPE_NO_SEE_FRIEND", "finderUserName", "followRecorder", "Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "noSeeAuthorRecorder", "noSeeFriend", "recorderStore", "Lcom/tencent/mm/plugin/finder/upload/action/FinderFeedCleaner$RecorderStore;", "recorderStoreMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "cleanFeed", "", "tabType", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "cleanTimeline", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "cleanTimelinePage", "getRecorder", "type", "isAllRecordEmpty", "", "isNeedClean", "onAccountInit", "onAccountRelease", "printRecord", "recordClean", "isClean", "release", "RecorderStore", "plugin-finder_release"})
public final class f
{
  public static g ABN;
  public static g ABO;
  public static g ABP;
  public static a ABQ;
  public static final HashMap<String, a> ABR;
  public static final f ABS;
  public static String whH;
  
  static
  {
    AppMethodBeat.i(274577);
    ABS = new f();
    whH = "";
    ABR = new HashMap();
    AppMethodBeat.o(274577);
  }
  
  public static boolean QE(int paramInt)
  {
    AppMethodBeat.i(274574);
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(274574);
      return false;
    case 3: 
      localg = ABN;
      if (localg == null) {
        p.bGy("followRecorder");
      }
      bool1 = localg.ecD();
      localg = ABO;
      if (localg == null) {
        p.bGy("noSeeAuthorRecorder");
      }
      boolean bool2 = localg.ecD();
      AppMethodBeat.o(274574);
      return bool1 | bool2;
    }
    g localg = ABO;
    if (localg == null) {
      p.bGy("noSeeAuthorRecorder");
    }
    boolean bool1 = localg.ecD();
    AppMethodBeat.o(274574);
    return bool1;
  }
  
  public static void e(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(274572);
    p.k(paramString, "finderUserName");
    Log.i("Finder.FeedCleaner", "recordClean type:" + paramInt + "  finderUserName: " + paramString + " isClean:" + paramBoolean);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    while (localObject != null)
    {
      p.k(paramString, "finderUserName");
      if (paramBoolean)
      {
        localObject.ABW.add(paramString);
        AppMethodBeat.o(274572);
        return;
        g localg = ABN;
        localObject = localg;
        if (localg == null)
        {
          p.bGy("followRecorder");
          localObject = localg;
          continue;
          localg = ABO;
          localObject = localg;
          if (localg == null)
          {
            p.bGy("noSeeAuthorRecorder");
            localObject = localg;
            continue;
            localg = ABP;
            localObject = localg;
            if (localg == null)
            {
              p.bGy("noSeeFriend");
              localObject = localg;
            }
          }
        }
      }
      else
      {
        localObject.ABW.remove(paramString);
        AppMethodBeat.o(274572);
        return;
      }
    }
    AppMethodBeat.o(274572);
  }
  
  public static boolean ecA()
  {
    AppMethodBeat.i(274575);
    g localg = ABN;
    if (localg == null) {
      p.bGy("followRecorder");
    }
    if (localg.isEmpty())
    {
      localg = ABO;
      if (localg == null) {
        p.bGy("noSeeAuthorRecorder");
      }
      if (localg.isEmpty())
      {
        localg = ABP;
        if (localg == null) {
          p.bGy("noSeeFriend");
        }
        if (localg.isEmpty())
        {
          AppMethodBeat.o(274575);
          return true;
        }
      }
    }
    AppMethodBeat.o(274575);
    return false;
  }
  
  public static void ecz()
  {
    AppMethodBeat.i(274573);
    StringBuilder localStringBuilder = new StringBuilder("printRecord followRecorder:");
    g localg = ABN;
    if (localg == null) {
      p.bGy("followRecorder");
    }
    Log.i("Finder.FeedCleaner", localg);
    localStringBuilder = new StringBuilder("printRecord noSeeAuthorRecorder:");
    localg = ABO;
    if (localg == null) {
      p.bGy("noSeeAuthorRecorder");
    }
    Log.i("Finder.FeedCleaner", localg);
    localStringBuilder = new StringBuilder("printRecord noSeeFriend:");
    localg = ABP;
    if (localg == null) {
      p.bGy("noSeeFriend");
    }
    Log.i("Finder.FeedCleaner", localg);
    AppMethodBeat.o(274573);
  }
  
  public static void onAccountRelease()
  {
    AppMethodBeat.i(274571);
    Log.i("Finder.FeedCleaner", "onAccountRelease");
    AppMethodBeat.o(274571);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FinderFeedCleaner$RecorderStore;", "", "username", "", "followRecorder", "Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "noSeeAuthorRecorder", "noSeeFriendRecorder", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;)V", "getFollowRecorder", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "getNoSeeAuthorRecorder", "getNoSeeFriendRecorder", "getUsername", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class a
  {
    public final g ABN;
    public final g ABO;
    public final g ABT;
    private final String username;
    
    public a(String paramString, g paramg1, g paramg2, g paramg3)
    {
      AppMethodBeat.i(280997);
      this.username = paramString;
      this.ABN = paramg1;
      this.ABO = paramg2;
      this.ABT = paramg3;
      AppMethodBeat.o(280997);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(281003);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.username, paramObject.username)) || (!p.h(this.ABN, paramObject.ABN)) || (!p.h(this.ABO, paramObject.ABO)) || (!p.h(this.ABT, paramObject.ABT))) {}
        }
      }
      else
      {
        AppMethodBeat.o(281003);
        return true;
      }
      AppMethodBeat.o(281003);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(281001);
      Object localObject = this.username;
      int i;
      int j;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.ABN;
        if (localObject == null) {
          break label105;
        }
        j = localObject.hashCode();
        label42:
        localObject = this.ABO;
        if (localObject == null) {
          break label110;
        }
      }
      label105:
      label110:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.ABT;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(281001);
        return (k + (j + i * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label42;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(280999);
      String str = "RecorderStore(username=" + this.username + ", followRecorder=" + this.ABN + ", noSeeAuthorRecorder=" + this.ABO + ", noSeeFriendRecorder=" + this.ABT + ")";
      AppMethodBeat.o(280999);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  public static final class b
    extends q
    implements b<bu, Boolean>
  {
    public static final b ABU;
    
    static
    {
      AppMethodBeat.i(285501);
      ABU = new b();
      AppMethodBeat.o(285501);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  public static final class c
    extends q
    implements b<bu, Boolean>
  {
    public static final c ABV;
    
    static
    {
      AppMethodBeat.i(278364);
      ABV = new c();
      AppMethodBeat.o(278364);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.f
 * JD-Core Version:    0.7.0.1
 */