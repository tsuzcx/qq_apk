package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowMonitor;", "", "()V", "TAG", "", "mDetailMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderDetailMonitor;", "mFavMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "mLbsMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "mLikedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLikeMonitor;", "mProfileMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderProfileMonitor;", "mRelMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "mSearchMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderSearchMonitor;", "mTimelineMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTimelineMonitor;", "mTopicMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTopicMonitor;", "action", "", "actionId", "", "pageName", "doAction", "monitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "free", "activity", "Landroid/app/Activity;", "report", "startMonitor", "stopMonitor", "plugin-expt_release"})
public final class b
{
  private static m wiP;
  private static c wiQ;
  private static n wiR;
  private static i wiS;
  private static k wiT;
  private static l wiU;
  private static e wiV;
  private static d wiW;
  private static h wiX;
  public static final b wiY;
  
  static
  {
    AppMethodBeat.i(255431);
    wiY = new b();
    AppMethodBeat.o(255431);
  }
  
  private static void a(int paramInt, o paramo)
  {
    AppMethodBeat.i(255429);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(255429);
      return;
      if (paramo != null)
      {
        paramo.startMonitor();
        AppMethodBeat.o(255429);
        return;
      }
      AppMethodBeat.o(255429);
      return;
      if (paramo != null)
      {
        paramo.stopMonitor();
        AppMethodBeat.o(255429);
        return;
      }
      AppMethodBeat.o(255429);
      return;
      if (paramo != null)
      {
        paramo.report();
        AppMethodBeat.o(255429);
        return;
      }
      AppMethodBeat.o(255429);
      return;
    } while (paramo == null);
    paramo.free();
    AppMethodBeat.o(255429);
  }
  
  public static void aT(int paramInt, String paramString)
  {
    AppMethodBeat.i(255426);
    p.k(paramString, "pageName");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(255426);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
          {
            a(paramInt, (o)wiW);
            if (paramInt == 2)
            {
              wiW = null;
              AppMethodBeat.o(255426);
              return;
              if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"))
              {
                a(paramInt, (o)wiU);
                if (paramInt == 2)
                {
                  wiU = null;
                  AppMethodBeat.o(255426);
                  return;
                  if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"))
                  {
                    a(paramInt, (o)wiQ);
                    if (paramInt == 2)
                    {
                      wiQ = null;
                      AppMethodBeat.o(255426);
                      return;
                      if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"))
                      {
                        a(paramInt, (o)wiR);
                        if (paramInt == 2)
                        {
                          wiR = null;
                          AppMethodBeat.o(255426);
                          return;
                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
                          {
                            a(paramInt, (o)wiT);
                            if (paramInt == 2)
                            {
                              wiT = null;
                              AppMethodBeat.o(255426);
                              return;
                              if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"))
                              {
                                a(paramInt, (o)wiV);
                                if (paramInt == 2)
                                {
                                  wiV = null;
                                  AppMethodBeat.o(255426);
                                  return;
                                  if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
                                  {
                                    a(paramInt, (o)wiP);
                                    if (paramInt == 2)
                                    {
                                      wiP = null;
                                      AppMethodBeat.o(255426);
                                      return;
                                      if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"))
                                      {
                                        a(paramInt, (o)wiQ);
                                        if (paramInt == 2)
                                        {
                                          wiQ = null;
                                          AppMethodBeat.o(255426);
                                          return;
                                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"))
                                          {
                                            a(paramInt, (o)wiX);
                                            if (paramInt == 2) {
                                              wiX = null;
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
      a(paramInt, (o)wiS);
    } while (paramInt != 2);
    wiS = null;
    AppMethodBeat.o(255426);
  }
  
  public static void axq(String paramString)
  {
    AppMethodBeat.i(255424);
    p.k(paramString, "pageName");
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
                          AppMethodBeat.o(255424);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = wiW;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", null);
                        AppMethodBeat.o(255424);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = wiU;
                      if (paramString == null) {
                        break label449;
                      }
                      paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
                      AppMethodBeat.o(255424);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = wiQ;
                    if (paramString == null) {
                      break label461;
                    }
                    paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", null);
                    AppMethodBeat.o(255424);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = wiR;
                  if (paramString == null) {
                    break label467;
                  }
                  paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", null);
                  AppMethodBeat.o(255424);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = wiT;
                if (paramString == null) {
                  break;
                }
                paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", null);
                AppMethodBeat.o(255424);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = wiV;
              if (paramString == null) {
                break label443;
              }
              paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
              AppMethodBeat.o(255424);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = wiP;
            if (localm == null) {
              break;
            }
            localm.a(3, paramString, null);
            AppMethodBeat.o(255424);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = wiQ;
          if (paramString == null) {
            break label455;
          }
          paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", null);
          AppMethodBeat.o(255424);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = wiX;
      } while (paramString == null);
      paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", null);
      AppMethodBeat.o(255424);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = wiS;
    if (paramString != null)
    {
      paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", null);
      AppMethodBeat.o(255424);
      return;
      AppMethodBeat.o(255424);
      return;
      AppMethodBeat.o(255424);
      return;
      AppMethodBeat.o(255424);
      return;
    }
    AppMethodBeat.o(255424);
    return;
    label443:
    AppMethodBeat.o(255424);
    return;
    label449:
    AppMethodBeat.o(255424);
    return;
    label455:
    AppMethodBeat.o(255424);
    return;
    label461:
    AppMethodBeat.o(255424);
    return;
    label467:
    AppMethodBeat.o(255424);
  }
  
  public static void c(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(255415);
    p.k(paramString, "pageName");
    p.k(paramActivity, "activity");
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
                          AppMethodBeat.o(255415);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        if (wiW == null) {
                          wiW = new d();
                        }
                        localObject = wiW;
                        if (localObject == null) {
                          break;
                        }
                        ((d)localObject).a(0, paramString, paramActivity);
                        AppMethodBeat.o(255415);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      if (wiU == null) {
                        wiU = new l();
                      }
                      localObject = wiU;
                      if (localObject == null) {
                        break label608;
                      }
                      ((l)localObject).a(0, paramString, paramActivity);
                      AppMethodBeat.o(255415);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    if (wiQ == null) {
                      wiQ = new c();
                    }
                    localObject = wiQ;
                    if (localObject == null) {
                      break label620;
                    }
                    ((c)localObject).a(0, paramString, paramActivity);
                    AppMethodBeat.o(255415);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  if (wiR == null) {
                    wiR = new n();
                  }
                  localObject = wiR;
                  if (localObject == null) {
                    break label626;
                  }
                  ((n)localObject).a(0, paramString, paramActivity);
                  AppMethodBeat.o(255415);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                if (wiT == null) {
                  wiT = new k();
                }
                localObject = wiT;
                if (localObject == null) {
                  break;
                }
                ((k)localObject).a(0, paramString, paramActivity);
                AppMethodBeat.o(255415);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              if (wiV == null) {
                wiV = new e();
              }
              localObject = wiV;
              if (localObject == null) {
                break label602;
              }
              ((e)localObject).a(0, paramString, paramActivity);
              AppMethodBeat.o(255415);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            if (wiP == null) {
              wiP = new m();
            }
            localObject = wiP;
            if (localObject == null) {
              break;
            }
            ((m)localObject).a(0, paramString, paramActivity);
            AppMethodBeat.o(255415);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          if (wiQ == null) {
            wiQ = new c();
          }
          localObject = wiQ;
          if (localObject == null) {
            break label614;
          }
          ((c)localObject).a(0, paramString, paramActivity);
          AppMethodBeat.o(255415);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        if (wiX == null) {
          wiX = new h();
        }
        localObject = wiX;
      } while (localObject == null);
      ((h)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(255415);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    if (wiS == null) {
      wiS = new i();
    }
    Object localObject = wiS;
    if (localObject != null)
    {
      ((i)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(255415);
      return;
      AppMethodBeat.o(255415);
      return;
      AppMethodBeat.o(255415);
      return;
      AppMethodBeat.o(255415);
      return;
    }
    AppMethodBeat.o(255415);
    return;
    label602:
    AppMethodBeat.o(255415);
    return;
    label608:
    AppMethodBeat.o(255415);
    return;
    label614:
    AppMethodBeat.o(255415);
    return;
    label620:
    AppMethodBeat.o(255415);
    return;
    label626:
    AppMethodBeat.o(255415);
  }
  
  public static void d(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(255418);
    p.k(paramString, "pageName");
    p.k(paramActivity, "activity");
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
                          AppMethodBeat.o(255418);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = wiW;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(255418);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = wiU;
                      if (paramString == null) {
                        break label458;
                      }
                      paramString.a(1, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(255418);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = wiQ;
                    if (paramString == null) {
                      break label470;
                    }
                    paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(255418);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = wiR;
                  if (paramString == null) {
                    break label476;
                  }
                  paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(255418);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = wiT;
                if (paramString == null) {
                  break;
                }
                paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(255418);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = wiV;
              if (paramString == null) {
                break label452;
              }
              paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(255418);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            paramString = wiP;
            if (paramString == null) {
              break;
            }
            paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI", paramActivity);
            AppMethodBeat.o(255418);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = wiQ;
          if (paramString == null) {
            break label464;
          }
          paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(255418);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = wiX;
      } while (paramString == null);
      paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(255418);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = wiS;
    if (paramString != null)
    {
      paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(255418);
      return;
      AppMethodBeat.o(255418);
      return;
      AppMethodBeat.o(255418);
      return;
      AppMethodBeat.o(255418);
      return;
    }
    AppMethodBeat.o(255418);
    return;
    label452:
    AppMethodBeat.o(255418);
    return;
    label458:
    AppMethodBeat.o(255418);
    return;
    label464:
    AppMethodBeat.o(255418);
    return;
    label470:
    AppMethodBeat.o(255418);
    return;
    label476:
    AppMethodBeat.o(255418);
  }
  
  public static void e(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(255420);
    p.k(paramString, "pageName");
    p.k(paramActivity, "activity");
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
                          AppMethodBeat.o(255420);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = wiW;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(255420);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = wiU;
                      if (paramString == null) {
                        break label457;
                      }
                      paramString.a(2, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(255420);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = wiQ;
                    if (paramString == null) {
                      break label469;
                    }
                    paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(255420);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = wiR;
                  if (paramString == null) {
                    break label475;
                  }
                  paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(255420);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = wiT;
                if (paramString == null) {
                  break;
                }
                paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(255420);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = wiV;
              if (paramString == null) {
                break label451;
              }
              paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(255420);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = wiP;
            if (localm == null) {
              break;
            }
            localm.a(2, paramString, paramActivity);
            AppMethodBeat.o(255420);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = wiQ;
          if (paramString == null) {
            break label463;
          }
          paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(255420);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = wiX;
      } while (paramString == null);
      paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(255420);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = wiS;
    if (paramString != null)
    {
      paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(255420);
      return;
      AppMethodBeat.o(255420);
      return;
      AppMethodBeat.o(255420);
      return;
      AppMethodBeat.o(255420);
      return;
    }
    AppMethodBeat.o(255420);
    return;
    label451:
    AppMethodBeat.o(255420);
    return;
    label457:
    AppMethodBeat.o(255420);
    return;
    label463:
    AppMethodBeat.o(255420);
    return;
    label469:
    AppMethodBeat.o(255420);
    return;
    label475:
    AppMethodBeat.o(255420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */