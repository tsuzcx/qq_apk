package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowMonitor;", "", "()V", "TAG", "", "mDetailMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderDetailMonitor;", "mFavMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "mLbsMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "mLikedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLikeMonitor;", "mProfileMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderProfileMonitor;", "mRelMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "mSearchMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderSearchMonitor;", "mTimelineMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTimelineMonitor;", "mTopicMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTopicMonitor;", "action", "", "actionId", "", "pageName", "doAction", "monitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "free", "activity", "Landroid/app/Activity;", "report", "startMonitor", "stopMonitor", "plugin-expt_release"})
public final class b
{
  private static m rco;
  private static c rcp;
  private static n rcq;
  private static i rcr;
  private static k rcs;
  private static l rct;
  private static e rcu;
  private static d rcv;
  private static h rcw;
  public static final b rcx;
  
  static
  {
    AppMethodBeat.i(196368);
    rcx = new b();
    AppMethodBeat.o(196368);
  }
  
  private static void a(int paramInt, o paramo)
  {
    AppMethodBeat.i(196367);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(196367);
      return;
      if (paramo != null)
      {
        paramo.cqn();
        AppMethodBeat.o(196367);
        return;
      }
      AppMethodBeat.o(196367);
      return;
      if (paramo != null)
      {
        paramo.cqe();
        AppMethodBeat.o(196367);
        return;
      }
      AppMethodBeat.o(196367);
      return;
      if (paramo != null)
      {
        paramo.report();
        AppMethodBeat.o(196367);
        return;
      }
      AppMethodBeat.o(196367);
      return;
    } while (paramo == null);
    paramo.free();
    AppMethodBeat.o(196367);
  }
  
  public static void aP(int paramInt, String paramString)
  {
    AppMethodBeat.i(196366);
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
          AppMethodBeat.o(196366);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
          {
            a(paramInt, (o)rcv);
            if (paramInt == 2)
            {
              rcv = null;
              AppMethodBeat.o(196366);
              return;
              if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"))
              {
                a(paramInt, (o)rct);
                if (paramInt == 2)
                {
                  rct = null;
                  AppMethodBeat.o(196366);
                  return;
                  if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"))
                  {
                    a(paramInt, (o)rcp);
                    if (paramInt == 2)
                    {
                      rcp = null;
                      AppMethodBeat.o(196366);
                      return;
                      if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"))
                      {
                        a(paramInt, (o)rcq);
                        if (paramInt == 2)
                        {
                          rcq = null;
                          AppMethodBeat.o(196366);
                          return;
                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
                          {
                            a(paramInt, (o)rcs);
                            if (paramInt == 2)
                            {
                              rcs = null;
                              AppMethodBeat.o(196366);
                              return;
                              if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"))
                              {
                                a(paramInt, (o)rcu);
                                if (paramInt == 2)
                                {
                                  rcu = null;
                                  AppMethodBeat.o(196366);
                                  return;
                                  if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
                                  {
                                    a(paramInt, (o)rco);
                                    if (paramInt == 2)
                                    {
                                      rco = null;
                                      AppMethodBeat.o(196366);
                                      return;
                                      if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"))
                                      {
                                        a(paramInt, (o)rcp);
                                        if (paramInt == 2)
                                        {
                                          rcp = null;
                                          AppMethodBeat.o(196366);
                                          return;
                                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"))
                                          {
                                            a(paramInt, (o)rcw);
                                            if (paramInt == 2) {
                                              rcw = null;
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
      a(paramInt, (o)rcr);
    } while (paramInt != 2);
    rcr = null;
    AppMethodBeat.o(196366);
  }
  
  public static void afa(String paramString)
  {
    AppMethodBeat.i(196365);
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
                          AppMethodBeat.o(196365);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = rcv;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", null);
                        AppMethodBeat.o(196365);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = rct;
                      if (paramString == null) {
                        break label449;
                      }
                      paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
                      AppMethodBeat.o(196365);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = rcp;
                    if (paramString == null) {
                      break label461;
                    }
                    paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", null);
                    AppMethodBeat.o(196365);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = rcq;
                  if (paramString == null) {
                    break label467;
                  }
                  paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", null);
                  AppMethodBeat.o(196365);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = rcs;
                if (paramString == null) {
                  break;
                }
                paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", null);
                AppMethodBeat.o(196365);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = rcu;
              if (paramString == null) {
                break label443;
              }
              paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
              AppMethodBeat.o(196365);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = rco;
            if (localm == null) {
              break;
            }
            localm.a(3, paramString, null);
            AppMethodBeat.o(196365);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = rcp;
          if (paramString == null) {
            break label455;
          }
          paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", null);
          AppMethodBeat.o(196365);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = rcw;
      } while (paramString == null);
      paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", null);
      AppMethodBeat.o(196365);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = rcr;
    if (paramString != null)
    {
      paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", null);
      AppMethodBeat.o(196365);
      return;
      AppMethodBeat.o(196365);
      return;
      AppMethodBeat.o(196365);
      return;
      AppMethodBeat.o(196365);
      return;
    }
    AppMethodBeat.o(196365);
    return;
    label443:
    AppMethodBeat.o(196365);
    return;
    label449:
    AppMethodBeat.o(196365);
    return;
    label455:
    AppMethodBeat.o(196365);
    return;
    label461:
    AppMethodBeat.o(196365);
    return;
    label467:
    AppMethodBeat.o(196365);
  }
  
  public static void c(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196362);
    p.h(paramString, "pageName");
    p.h(paramActivity, "activity");
    ae.d("HABBYGE-MALI.FeedFlowMonitor", "startMonitor: page=" + paramString + ", activity=" + paramActivity.getClass().getName());
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
                          AppMethodBeat.o(196362);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        if (rcv == null) {
                          rcv = new d();
                        }
                        localObject = rcv;
                        if (localObject == null) {
                          break;
                        }
                        ((d)localObject).a(0, paramString, paramActivity);
                        AppMethodBeat.o(196362);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      if (rct == null) {
                        rct = new l();
                      }
                      localObject = rct;
                      if (localObject == null) {
                        break label644;
                      }
                      ((l)localObject).a(0, paramString, paramActivity);
                      AppMethodBeat.o(196362);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    if (rcp == null) {
                      rcp = new c();
                    }
                    localObject = rcp;
                    if (localObject == null) {
                      break label656;
                    }
                    ((c)localObject).a(0, paramString, paramActivity);
                    AppMethodBeat.o(196362);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  if (rcq == null) {
                    rcq = new n();
                  }
                  localObject = rcq;
                  if (localObject == null) {
                    break label662;
                  }
                  ((n)localObject).a(0, paramString, paramActivity);
                  AppMethodBeat.o(196362);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                if (rcs == null) {
                  rcs = new k();
                }
                localObject = rcs;
                if (localObject == null) {
                  break;
                }
                ((k)localObject).a(0, paramString, paramActivity);
                AppMethodBeat.o(196362);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              if (rcu == null) {
                rcu = new e();
              }
              localObject = rcu;
              if (localObject == null) {
                break label638;
              }
              ((e)localObject).a(0, paramString, paramActivity);
              AppMethodBeat.o(196362);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            if (rco == null) {
              rco = new m();
            }
            localObject = rco;
            if (localObject == null) {
              break;
            }
            ((m)localObject).a(0, paramString, paramActivity);
            AppMethodBeat.o(196362);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          if (rcp == null) {
            rcp = new c();
          }
          localObject = rcp;
          if (localObject == null) {
            break label650;
          }
          ((c)localObject).a(0, paramString, paramActivity);
          AppMethodBeat.o(196362);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        if (rcw == null) {
          rcw = new h();
        }
        localObject = rcw;
      } while (localObject == null);
      ((h)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(196362);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    if (rcr == null) {
      rcr = new i();
    }
    Object localObject = rcr;
    if (localObject != null)
    {
      ((i)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(196362);
      return;
      AppMethodBeat.o(196362);
      return;
      AppMethodBeat.o(196362);
      return;
      AppMethodBeat.o(196362);
      return;
    }
    AppMethodBeat.o(196362);
    return;
    label638:
    AppMethodBeat.o(196362);
    return;
    label644:
    AppMethodBeat.o(196362);
    return;
    label650:
    AppMethodBeat.o(196362);
    return;
    label656:
    AppMethodBeat.o(196362);
    return;
    label662:
    AppMethodBeat.o(196362);
  }
  
  public static void d(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196363);
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
                          AppMethodBeat.o(196363);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = rcv;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(196363);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = rct;
                      if (paramString == null) {
                        break label458;
                      }
                      paramString.a(1, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(196363);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = rcp;
                    if (paramString == null) {
                      break label470;
                    }
                    paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(196363);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = rcq;
                  if (paramString == null) {
                    break label476;
                  }
                  paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(196363);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = rcs;
                if (paramString == null) {
                  break;
                }
                paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(196363);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = rcu;
              if (paramString == null) {
                break label452;
              }
              paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(196363);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            paramString = rco;
            if (paramString == null) {
              break;
            }
            paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI", paramActivity);
            AppMethodBeat.o(196363);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = rcp;
          if (paramString == null) {
            break label464;
          }
          paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(196363);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = rcw;
      } while (paramString == null);
      paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(196363);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = rcr;
    if (paramString != null)
    {
      paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(196363);
      return;
      AppMethodBeat.o(196363);
      return;
      AppMethodBeat.o(196363);
      return;
      AppMethodBeat.o(196363);
      return;
    }
    AppMethodBeat.o(196363);
    return;
    label452:
    AppMethodBeat.o(196363);
    return;
    label458:
    AppMethodBeat.o(196363);
    return;
    label464:
    AppMethodBeat.o(196363);
    return;
    label470:
    AppMethodBeat.o(196363);
    return;
    label476:
    AppMethodBeat.o(196363);
  }
  
  public static void e(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196364);
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
                          AppMethodBeat.o(196364);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = rcv;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(196364);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = rct;
                      if (paramString == null) {
                        break label457;
                      }
                      paramString.a(2, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(196364);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = rcp;
                    if (paramString == null) {
                      break label469;
                    }
                    paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(196364);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = rcq;
                  if (paramString == null) {
                    break label475;
                  }
                  paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(196364);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = rcs;
                if (paramString == null) {
                  break;
                }
                paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(196364);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = rcu;
              if (paramString == null) {
                break label451;
              }
              paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(196364);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = rco;
            if (localm == null) {
              break;
            }
            localm.a(2, paramString, paramActivity);
            AppMethodBeat.o(196364);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = rcp;
          if (paramString == null) {
            break label463;
          }
          paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(196364);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = rcw;
      } while (paramString == null);
      paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(196364);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = rcr;
    if (paramString != null)
    {
      paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(196364);
      return;
      AppMethodBeat.o(196364);
      return;
      AppMethodBeat.o(196364);
      return;
      AppMethodBeat.o(196364);
      return;
    }
    AppMethodBeat.o(196364);
    return;
    label451:
    AppMethodBeat.o(196364);
    return;
    label457:
    AppMethodBeat.o(196364);
    return;
    label463:
    AppMethodBeat.o(196364);
    return;
    label469:
    AppMethodBeat.o(196364);
    return;
    label475:
    AppMethodBeat.o(196364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */