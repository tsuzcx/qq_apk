package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowMonitor;", "", "()V", "TAG", "", "mDetailMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderDetailMonitor;", "mFavMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "mLbsMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "mLikedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLikeMonitor;", "mProfileMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderProfileMonitor;", "mRelMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "mSearchMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderSearchMonitor;", "mTimelineMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTimelineMonitor;", "mTopicMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTopicMonitor;", "action", "", "actionId", "", "pageName", "doAction", "monitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "free", "activity", "Landroid/app/Activity;", "report", "startMonitor", "stopMonitor", "plugin-expt_release"})
public final class b
{
  private static m qUq;
  private static c qUr;
  private static n qUs;
  private static i qUt;
  private static k qUu;
  private static l qUv;
  private static e qUw;
  private static d qUx;
  private static h qUy;
  public static final b qUz;
  
  static
  {
    AppMethodBeat.i(210701);
    qUz = new b();
    AppMethodBeat.o(210701);
  }
  
  private static void a(int paramInt, o paramo)
  {
    AppMethodBeat.i(210700);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(210700);
      return;
      if (paramo != null)
      {
        paramo.coL();
        AppMethodBeat.o(210700);
        return;
      }
      AppMethodBeat.o(210700);
      return;
      if (paramo != null)
      {
        paramo.coC();
        AppMethodBeat.o(210700);
        return;
      }
      AppMethodBeat.o(210700);
      return;
      if (paramo != null)
      {
        paramo.report();
        AppMethodBeat.o(210700);
        return;
      }
      AppMethodBeat.o(210700);
      return;
    } while (paramo == null);
    paramo.free();
    AppMethodBeat.o(210700);
  }
  
  public static void aQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(210699);
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
          AppMethodBeat.o(210699);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
          {
            a(paramInt, (o)qUx);
            if (paramInt == 2)
            {
              qUx = null;
              AppMethodBeat.o(210699);
              return;
              if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"))
              {
                a(paramInt, (o)qUv);
                if (paramInt == 2)
                {
                  qUv = null;
                  AppMethodBeat.o(210699);
                  return;
                  if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"))
                  {
                    a(paramInt, (o)qUr);
                    if (paramInt == 2)
                    {
                      qUr = null;
                      AppMethodBeat.o(210699);
                      return;
                      if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"))
                      {
                        a(paramInt, (o)qUs);
                        if (paramInt == 2)
                        {
                          qUs = null;
                          AppMethodBeat.o(210699);
                          return;
                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
                          {
                            a(paramInt, (o)qUu);
                            if (paramInt == 2)
                            {
                              qUu = null;
                              AppMethodBeat.o(210699);
                              return;
                              if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"))
                              {
                                a(paramInt, (o)qUw);
                                if (paramInt == 2)
                                {
                                  qUw = null;
                                  AppMethodBeat.o(210699);
                                  return;
                                  if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
                                  {
                                    a(paramInt, (o)qUq);
                                    if (paramInt == 2)
                                    {
                                      qUq = null;
                                      AppMethodBeat.o(210699);
                                      return;
                                      if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"))
                                      {
                                        a(paramInt, (o)qUr);
                                        if (paramInt == 2)
                                        {
                                          qUr = null;
                                          AppMethodBeat.o(210699);
                                          return;
                                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"))
                                          {
                                            a(paramInt, (o)qUy);
                                            if (paramInt == 2) {
                                              qUy = null;
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
      a(paramInt, (o)qUt);
    } while (paramInt != 2);
    qUt = null;
    AppMethodBeat.o(210699);
  }
  
  public static void aeg(String paramString)
  {
    AppMethodBeat.i(210698);
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
                          AppMethodBeat.o(210698);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = qUx;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", null);
                        AppMethodBeat.o(210698);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = qUv;
                      if (paramString == null) {
                        break label449;
                      }
                      paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
                      AppMethodBeat.o(210698);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = qUr;
                    if (paramString == null) {
                      break label461;
                    }
                    paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", null);
                    AppMethodBeat.o(210698);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = qUs;
                  if (paramString == null) {
                    break label467;
                  }
                  paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", null);
                  AppMethodBeat.o(210698);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = qUu;
                if (paramString == null) {
                  break;
                }
                paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", null);
                AppMethodBeat.o(210698);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = qUw;
              if (paramString == null) {
                break label443;
              }
              paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
              AppMethodBeat.o(210698);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = qUq;
            if (localm == null) {
              break;
            }
            localm.a(3, paramString, null);
            AppMethodBeat.o(210698);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = qUr;
          if (paramString == null) {
            break label455;
          }
          paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", null);
          AppMethodBeat.o(210698);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = qUy;
      } while (paramString == null);
      paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", null);
      AppMethodBeat.o(210698);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = qUt;
    if (paramString != null)
    {
      paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", null);
      AppMethodBeat.o(210698);
      return;
      AppMethodBeat.o(210698);
      return;
      AppMethodBeat.o(210698);
      return;
      AppMethodBeat.o(210698);
      return;
    }
    AppMethodBeat.o(210698);
    return;
    label443:
    AppMethodBeat.o(210698);
    return;
    label449:
    AppMethodBeat.o(210698);
    return;
    label455:
    AppMethodBeat.o(210698);
    return;
    label461:
    AppMethodBeat.o(210698);
    return;
    label467:
    AppMethodBeat.o(210698);
  }
  
  public static void c(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210695);
    p.h(paramString, "pageName");
    p.h(paramActivity, "activity");
    ad.d("HABBYGE-MALI.FeedFlowMonitor", "startMonitor: page=" + paramString + ", activity=" + paramActivity.getClass().getName());
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
                          AppMethodBeat.o(210695);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        if (qUx == null) {
                          qUx = new d();
                        }
                        localObject = qUx;
                        if (localObject == null) {
                          break;
                        }
                        ((d)localObject).a(0, paramString, paramActivity);
                        AppMethodBeat.o(210695);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      if (qUv == null) {
                        qUv = new l();
                      }
                      localObject = qUv;
                      if (localObject == null) {
                        break label644;
                      }
                      ((l)localObject).a(0, paramString, paramActivity);
                      AppMethodBeat.o(210695);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    if (qUr == null) {
                      qUr = new c();
                    }
                    localObject = qUr;
                    if (localObject == null) {
                      break label656;
                    }
                    ((c)localObject).a(0, paramString, paramActivity);
                    AppMethodBeat.o(210695);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  if (qUs == null) {
                    qUs = new n();
                  }
                  localObject = qUs;
                  if (localObject == null) {
                    break label662;
                  }
                  ((n)localObject).a(0, paramString, paramActivity);
                  AppMethodBeat.o(210695);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                if (qUu == null) {
                  qUu = new k();
                }
                localObject = qUu;
                if (localObject == null) {
                  break;
                }
                ((k)localObject).a(0, paramString, paramActivity);
                AppMethodBeat.o(210695);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              if (qUw == null) {
                qUw = new e();
              }
              localObject = qUw;
              if (localObject == null) {
                break label638;
              }
              ((e)localObject).a(0, paramString, paramActivity);
              AppMethodBeat.o(210695);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            if (qUq == null) {
              qUq = new m();
            }
            localObject = qUq;
            if (localObject == null) {
              break;
            }
            ((m)localObject).a(0, paramString, paramActivity);
            AppMethodBeat.o(210695);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          if (qUr == null) {
            qUr = new c();
          }
          localObject = qUr;
          if (localObject == null) {
            break label650;
          }
          ((c)localObject).a(0, paramString, paramActivity);
          AppMethodBeat.o(210695);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        if (qUy == null) {
          qUy = new h();
        }
        localObject = qUy;
      } while (localObject == null);
      ((h)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(210695);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    if (qUt == null) {
      qUt = new i();
    }
    Object localObject = qUt;
    if (localObject != null)
    {
      ((i)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(210695);
      return;
      AppMethodBeat.o(210695);
      return;
      AppMethodBeat.o(210695);
      return;
      AppMethodBeat.o(210695);
      return;
    }
    AppMethodBeat.o(210695);
    return;
    label638:
    AppMethodBeat.o(210695);
    return;
    label644:
    AppMethodBeat.o(210695);
    return;
    label650:
    AppMethodBeat.o(210695);
    return;
    label656:
    AppMethodBeat.o(210695);
    return;
    label662:
    AppMethodBeat.o(210695);
  }
  
  public static void d(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210696);
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
                          AppMethodBeat.o(210696);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = qUx;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(210696);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = qUv;
                      if (paramString == null) {
                        break label458;
                      }
                      paramString.a(1, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(210696);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = qUr;
                    if (paramString == null) {
                      break label470;
                    }
                    paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(210696);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = qUs;
                  if (paramString == null) {
                    break label476;
                  }
                  paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(210696);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = qUu;
                if (paramString == null) {
                  break;
                }
                paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(210696);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = qUw;
              if (paramString == null) {
                break label452;
              }
              paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(210696);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            paramString = qUq;
            if (paramString == null) {
              break;
            }
            paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI", paramActivity);
            AppMethodBeat.o(210696);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = qUr;
          if (paramString == null) {
            break label464;
          }
          paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(210696);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = qUy;
      } while (paramString == null);
      paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(210696);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = qUt;
    if (paramString != null)
    {
      paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(210696);
      return;
      AppMethodBeat.o(210696);
      return;
      AppMethodBeat.o(210696);
      return;
      AppMethodBeat.o(210696);
      return;
    }
    AppMethodBeat.o(210696);
    return;
    label452:
    AppMethodBeat.o(210696);
    return;
    label458:
    AppMethodBeat.o(210696);
    return;
    label464:
    AppMethodBeat.o(210696);
    return;
    label470:
    AppMethodBeat.o(210696);
    return;
    label476:
    AppMethodBeat.o(210696);
  }
  
  public static void e(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210697);
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
                          AppMethodBeat.o(210697);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = qUx;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(210697);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = qUv;
                      if (paramString == null) {
                        break label457;
                      }
                      paramString.a(2, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(210697);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = qUr;
                    if (paramString == null) {
                      break label469;
                    }
                    paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(210697);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = qUs;
                  if (paramString == null) {
                    break label475;
                  }
                  paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(210697);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = qUu;
                if (paramString == null) {
                  break;
                }
                paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(210697);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = qUw;
              if (paramString == null) {
                break label451;
              }
              paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(210697);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = qUq;
            if (localm == null) {
              break;
            }
            localm.a(2, paramString, paramActivity);
            AppMethodBeat.o(210697);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = qUr;
          if (paramString == null) {
            break label463;
          }
          paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(210697);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = qUy;
      } while (paramString == null);
      paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(210697);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = qUt;
    if (paramString != null)
    {
      paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(210697);
      return;
      AppMethodBeat.o(210697);
      return;
      AppMethodBeat.o(210697);
      return;
      AppMethodBeat.o(210697);
      return;
    }
    AppMethodBeat.o(210697);
    return;
    label451:
    AppMethodBeat.o(210697);
    return;
    label457:
    AppMethodBeat.o(210697);
    return;
    label463:
    AppMethodBeat.o(210697);
    return;
    label469:
    AppMethodBeat.o(210697);
    return;
    label475:
    AppMethodBeat.o(210697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */