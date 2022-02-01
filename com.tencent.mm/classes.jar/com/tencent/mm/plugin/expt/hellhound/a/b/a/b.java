package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowMonitor;", "", "()V", "TAG", "", "mDetailMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderDetailMonitor;", "mFavMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "mLbsMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "mLikedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLikeMonitor;", "mProfileMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderProfileMonitor;", "mRelMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "mSearchMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderSearchMonitor;", "mTimelineMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTimelineMonitor;", "mTopicMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTopicMonitor;", "action", "", "actionId", "", "pageName", "doAction", "monitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "free", "activity", "Landroid/app/Activity;", "report", "startMonitor", "stopMonitor", "plugin-expt_release"})
public final class b
{
  private static m sCV;
  private static c sCW;
  private static n sCX;
  private static i sCY;
  private static k sCZ;
  private static l sDa;
  private static e sDb;
  private static d sDc;
  private static h sDd;
  public static final b sDe;
  
  static
  {
    AppMethodBeat.i(220833);
    sDe = new b();
    AppMethodBeat.o(220833);
  }
  
  private static void a(int paramInt, o paramo)
  {
    AppMethodBeat.i(220832);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(220832);
      return;
      if (paramo != null)
      {
        paramo.startMonitor();
        AppMethodBeat.o(220832);
        return;
      }
      AppMethodBeat.o(220832);
      return;
      if (paramo != null)
      {
        paramo.stopMonitor();
        AppMethodBeat.o(220832);
        return;
      }
      AppMethodBeat.o(220832);
      return;
      if (paramo != null)
      {
        paramo.report();
        AppMethodBeat.o(220832);
        return;
      }
      AppMethodBeat.o(220832);
      return;
    } while (paramo == null);
    paramo.free();
    AppMethodBeat.o(220832);
  }
  
  public static void aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(220831);
    p.h(paramString, "pageName");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(220831);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
          {
            a(paramInt, (o)sDc);
            if (paramInt == 2)
            {
              sDc = null;
              AppMethodBeat.o(220831);
              return;
              if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"))
              {
                a(paramInt, (o)sDa);
                if (paramInt == 2)
                {
                  sDa = null;
                  AppMethodBeat.o(220831);
                  return;
                  if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"))
                  {
                    a(paramInt, (o)sCW);
                    if (paramInt == 2)
                    {
                      sCW = null;
                      AppMethodBeat.o(220831);
                      return;
                      if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"))
                      {
                        a(paramInt, (o)sCX);
                        if (paramInt == 2)
                        {
                          sCX = null;
                          AppMethodBeat.o(220831);
                          return;
                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
                          {
                            a(paramInt, (o)sCZ);
                            if (paramInt == 2)
                            {
                              sCZ = null;
                              AppMethodBeat.o(220831);
                              return;
                              if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"))
                              {
                                a(paramInt, (o)sDb);
                                if (paramInt == 2)
                                {
                                  sDb = null;
                                  AppMethodBeat.o(220831);
                                  return;
                                  if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
                                  {
                                    a(paramInt, (o)sCV);
                                    if (paramInt == 2)
                                    {
                                      sCV = null;
                                      AppMethodBeat.o(220831);
                                      return;
                                      if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"))
                                      {
                                        a(paramInt, (o)sCW);
                                        if (paramInt == 2)
                                        {
                                          sCW = null;
                                          AppMethodBeat.o(220831);
                                          return;
                                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"))
                                          {
                                            a(paramInt, (o)sDd);
                                            if (paramInt == 2) {
                                              sDd = null;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
      a(paramInt, (o)sCY);
    } while (paramInt != 2);
    sCY = null;
    AppMethodBeat.o(220831);
  }
  
  public static void apq(String paramString)
  {
    AppMethodBeat.i(220830);
    p.h(paramString, "pageName");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          AppMethodBeat.o(220830);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = sDc;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", null);
                        AppMethodBeat.o(220830);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = sDa;
                      if (paramString == null) {
                        break label449;
                      }
                      paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
                      AppMethodBeat.o(220830);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = sCW;
                    if (paramString == null) {
                      break label461;
                    }
                    paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", null);
                    AppMethodBeat.o(220830);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = sCX;
                  if (paramString == null) {
                    break label467;
                  }
                  paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", null);
                  AppMethodBeat.o(220830);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = sCZ;
                if (paramString == null) {
                  break;
                }
                paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", null);
                AppMethodBeat.o(220830);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = sDb;
              if (paramString == null) {
                break label443;
              }
              paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
              AppMethodBeat.o(220830);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = sCV;
            if (localm == null) {
              break;
            }
            localm.a(3, paramString, null);
            AppMethodBeat.o(220830);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = sCW;
          if (paramString == null) {
            break label455;
          }
          paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", null);
          AppMethodBeat.o(220830);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = sDd;
      } while (paramString == null);
      paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", null);
      AppMethodBeat.o(220830);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = sCY;
    if (paramString != null)
    {
      paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", null);
      AppMethodBeat.o(220830);
      return;
      AppMethodBeat.o(220830);
      return;
      AppMethodBeat.o(220830);
      return;
      AppMethodBeat.o(220830);
      return;
    }
    AppMethodBeat.o(220830);
    return;
    label443:
    AppMethodBeat.o(220830);
    return;
    label449:
    AppMethodBeat.o(220830);
    return;
    label455:
    AppMethodBeat.o(220830);
    return;
    label461:
    AppMethodBeat.o(220830);
    return;
    label467:
    AppMethodBeat.o(220830);
  }
  
  public static void c(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220827);
    p.h(paramString, "pageName");
    p.h(paramActivity, "activity");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          AppMethodBeat.o(220827);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        if (sDc == null) {
                          sDc = new d();
                        }
                        localObject = sDc;
                        if (localObject == null) {
                          break;
                        }
                        ((d)localObject).a(0, paramString, paramActivity);
                        AppMethodBeat.o(220827);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      if (sDa == null) {
                        sDa = new l();
                      }
                      localObject = sDa;
                      if (localObject == null) {
                        break label608;
                      }
                      ((l)localObject).a(0, paramString, paramActivity);
                      AppMethodBeat.o(220827);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    if (sCW == null) {
                      sCW = new c();
                    }
                    localObject = sCW;
                    if (localObject == null) {
                      break label620;
                    }
                    ((c)localObject).a(0, paramString, paramActivity);
                    AppMethodBeat.o(220827);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  if (sCX == null) {
                    sCX = new n();
                  }
                  localObject = sCX;
                  if (localObject == null) {
                    break label626;
                  }
                  ((n)localObject).a(0, paramString, paramActivity);
                  AppMethodBeat.o(220827);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                if (sCZ == null) {
                  sCZ = new k();
                }
                localObject = sCZ;
                if (localObject == null) {
                  break;
                }
                ((k)localObject).a(0, paramString, paramActivity);
                AppMethodBeat.o(220827);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              if (sDb == null) {
                sDb = new e();
              }
              localObject = sDb;
              if (localObject == null) {
                break label602;
              }
              ((e)localObject).a(0, paramString, paramActivity);
              AppMethodBeat.o(220827);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            if (sCV == null) {
              sCV = new m();
            }
            localObject = sCV;
            if (localObject == null) {
              break;
            }
            ((m)localObject).a(0, paramString, paramActivity);
            AppMethodBeat.o(220827);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          if (sCW == null) {
            sCW = new c();
          }
          localObject = sCW;
          if (localObject == null) {
            break label614;
          }
          ((c)localObject).a(0, paramString, paramActivity);
          AppMethodBeat.o(220827);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        if (sDd == null) {
          sDd = new h();
        }
        localObject = sDd;
      } while (localObject == null);
      ((h)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(220827);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    if (sCY == null) {
      sCY = new i();
    }
    Object localObject = sCY;
    if (localObject != null)
    {
      ((i)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(220827);
      return;
      AppMethodBeat.o(220827);
      return;
      AppMethodBeat.o(220827);
      return;
      AppMethodBeat.o(220827);
      return;
    }
    AppMethodBeat.o(220827);
    return;
    label602:
    AppMethodBeat.o(220827);
    return;
    label608:
    AppMethodBeat.o(220827);
    return;
    label614:
    AppMethodBeat.o(220827);
    return;
    label620:
    AppMethodBeat.o(220827);
    return;
    label626:
    AppMethodBeat.o(220827);
  }
  
  public static void d(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220828);
    p.h(paramString, "pageName");
    p.h(paramActivity, "activity");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          AppMethodBeat.o(220828);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = sDc;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(220828);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = sDa;
                      if (paramString == null) {
                        break label458;
                      }
                      paramString.a(1, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(220828);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = sCW;
                    if (paramString == null) {
                      break label470;
                    }
                    paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(220828);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = sCX;
                  if (paramString == null) {
                    break label476;
                  }
                  paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(220828);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = sCZ;
                if (paramString == null) {
                  break;
                }
                paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(220828);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = sDb;
              if (paramString == null) {
                break label452;
              }
              paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(220828);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            paramString = sCV;
            if (paramString == null) {
              break;
            }
            paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI", paramActivity);
            AppMethodBeat.o(220828);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = sCW;
          if (paramString == null) {
            break label464;
          }
          paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(220828);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = sDd;
      } while (paramString == null);
      paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(220828);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = sCY;
    if (paramString != null)
    {
      paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(220828);
      return;
      AppMethodBeat.o(220828);
      return;
      AppMethodBeat.o(220828);
      return;
      AppMethodBeat.o(220828);
      return;
    }
    AppMethodBeat.o(220828);
    return;
    label452:
    AppMethodBeat.o(220828);
    return;
    label458:
    AppMethodBeat.o(220828);
    return;
    label464:
    AppMethodBeat.o(220828);
    return;
    label470:
    AppMethodBeat.o(220828);
    return;
    label476:
    AppMethodBeat.o(220828);
  }
  
  public static void e(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220829);
    p.h(paramString, "pageName");
    p.h(paramActivity, "activity");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          AppMethodBeat.o(220829);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = sDc;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(220829);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = sDa;
                      if (paramString == null) {
                        break label457;
                      }
                      paramString.a(2, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(220829);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = sCW;
                    if (paramString == null) {
                      break label469;
                    }
                    paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(220829);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = sCX;
                  if (paramString == null) {
                    break label475;
                  }
                  paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(220829);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = sCZ;
                if (paramString == null) {
                  break;
                }
                paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(220829);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = sDb;
              if (paramString == null) {
                break label451;
              }
              paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(220829);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = sCV;
            if (localm == null) {
              break;
            }
            localm.a(2, paramString, paramActivity);
            AppMethodBeat.o(220829);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = sCW;
          if (paramString == null) {
            break label463;
          }
          paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(220829);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = sDd;
      } while (paramString == null);
      paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(220829);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = sCY;
    if (paramString != null)
    {
      paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(220829);
      return;
      AppMethodBeat.o(220829);
      return;
      AppMethodBeat.o(220829);
      return;
      AppMethodBeat.o(220829);
      return;
    }
    AppMethodBeat.o(220829);
    return;
    label451:
    AppMethodBeat.o(220829);
    return;
    label457:
    AppMethodBeat.o(220829);
    return;
    label463:
    AppMethodBeat.o(220829);
    return;
    label469:
    AppMethodBeat.o(220829);
    return;
    label475:
    AppMethodBeat.o(220829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */