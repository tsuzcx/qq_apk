package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic;", "", "()V", "Companion", "FinderAdContactCache", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a AwT;
  private static int AwU;
  private static a.b AwV;
  private static long vCl;
  
  static
  {
    AppMethodBeat.i(329960);
    AwT = new a((byte)0);
    AwV = new a.b();
    AppMethodBeat.o(329960);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$Companion;", "", "()V", "TAG", "", "adCacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$FinderAdContactCache;", "lastRequestTime", "", "nextRetryInterval", "", "checkAdContactCacheAvailable", "", "username", "getAdContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "isInterceptRequest", "recordLastRequest", "", "setNextRetryInterval", "interval", "updateAdContact", "contact", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static m auQ(String paramString)
    {
      AppMethodBeat.i(329935);
      int i;
      if (Util.isNullOrNil(paramString)) {
        i = 0;
      }
      while (i != 0)
      {
        Object localObject1 = d.AwY;
        localObject1 = d.a.auT(paramString);
        Object localObject2 = a.dTW();
        s.checkNotNull(paramString);
        localObject2 = ((a.b)localObject2).auR(paramString);
        if (localObject2 == null)
        {
          AppMethodBeat.o(329935);
          return null;
          localObject1 = a.dTW();
          s.checkNotNull(paramString);
          localObject1 = ((a.b)localObject1).auR(paramString);
          if (localObject1 != null)
          {
            localObject1 = (CharSequence)((m)localObject1).field_username;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label102;
            }
          }
          label102:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label107;
            }
            i = 0;
            break;
          }
          label107:
          i = 1;
        }
        else
        {
          if (localObject1 != null)
          {
            i = ((m)localObject1).field_follow_Flag;
            Log.i("Finder.FinderAdContactLogic", s.X("update cache field_follow_Flag ", Integer.valueOf(i)));
            ((m)localObject2).field_follow_Flag = i;
          }
          i = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Sq(paramString);
          if (i > 0) {
            ((m)localObject2).field_friendFollowCount = i;
          }
          AppMethodBeat.o(329935);
          return localObject2;
        }
      }
      AppMethodBeat.o(329935);
      return null;
    }
    
    public static boolean dTZ()
    {
      AppMethodBeat.i(329941);
      if ((a.dTX() != 0L) && (a.dTY() > 0) && (cn.bDw() - a.dTX() < a.dTY()))
      {
        Log.i("Finder.FinderAdContactLogic", "interceptRequest");
        AppMethodBeat.o(329941);
        return true;
      }
      Log.i("Finder.FinderAdContactLogic", "not interceptRequest");
      a.mR(cn.bDw());
      AppMethodBeat.o(329941);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$FinderAdContactCache$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b$a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.a
 * JD-Core Version:    0.7.0.1
 */