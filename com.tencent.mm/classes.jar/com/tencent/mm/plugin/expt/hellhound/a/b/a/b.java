package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowMonitor;", "", "()V", "TAG", "", "mDetailMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderDetailMonitor;", "mFavMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "mLbsMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "mLikedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLikeMonitor;", "mProfileMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderProfileMonitor;", "mRelMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "mSearchMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderSearchMonitor;", "mTimelineMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTimelineMonitor;", "mTopicMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTopicMonitor;", "action", "", "actionId", "", "pageName", "doAction", "monitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "free", "activity", "Landroid/app/Activity;", "report", "startMonitor", "stopMonitor", "plugin-expt_release"})
public final class b
{
  private static d qlA;
  private static h qlB;
  public static final b qlC;
  private static m qlt;
  private static c qlu;
  private static n qlv;
  private static i qlw;
  private static k qlx;
  private static l qly;
  private static e qlz;
  
  static
  {
    AppMethodBeat.i(195354);
    qlC = new b();
    AppMethodBeat.o(195354);
  }
  
  private static void a(int paramInt, o paramo)
  {
    AppMethodBeat.i(195353);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(195353);
      return;
      if (paramo != null)
      {
        paramo.cjz();
        AppMethodBeat.o(195353);
        return;
      }
      AppMethodBeat.o(195353);
      return;
      if (paramo != null)
      {
        paramo.cjq();
        AppMethodBeat.o(195353);
        return;
      }
      AppMethodBeat.o(195353);
      return;
      if (paramo != null)
      {
        paramo.report();
        AppMethodBeat.o(195353);
        return;
      }
      AppMethodBeat.o(195353);
      return;
    } while (paramo == null);
    paramo.free();
    AppMethodBeat.o(195353);
  }
  
  public static void aN(int paramInt, String paramString)
  {
    AppMethodBeat.i(195352);
    d.g.b.k.h(paramString, "pageName");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(195352);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
          {
            a(paramInt, (o)qlA);
            if (paramInt == 2)
            {
              qlA = null;
              AppMethodBeat.o(195352);
              return;
              if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"))
              {
                a(paramInt, (o)qly);
                if (paramInt == 2)
                {
                  qly = null;
                  AppMethodBeat.o(195352);
                  return;
                  if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"))
                  {
                    a(paramInt, (o)qlu);
                    if (paramInt == 2)
                    {
                      qlu = null;
                      AppMethodBeat.o(195352);
                      return;
                      if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"))
                      {
                        a(paramInt, (o)qlv);
                        if (paramInt == 2)
                        {
                          qlv = null;
                          AppMethodBeat.o(195352);
                          return;
                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
                          {
                            a(paramInt, (o)qlx);
                            if (paramInt == 2)
                            {
                              qlx = null;
                              AppMethodBeat.o(195352);
                              return;
                              if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"))
                              {
                                a(paramInt, (o)qlz);
                                if (paramInt == 2)
                                {
                                  qlz = null;
                                  AppMethodBeat.o(195352);
                                  return;
                                  if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
                                  {
                                    a(paramInt, (o)qlt);
                                    if (paramInt == 2)
                                    {
                                      qlt = null;
                                      AppMethodBeat.o(195352);
                                      return;
                                      if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"))
                                      {
                                        a(paramInt, (o)qlu);
                                        if (paramInt == 2)
                                        {
                                          qlu = null;
                                          AppMethodBeat.o(195352);
                                          return;
                                          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"))
                                          {
                                            a(paramInt, (o)qlB);
                                            if (paramInt == 2) {
                                              qlB = null;
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
      a(paramInt, (o)qlw);
    } while (paramInt != 2);
    qlw = null;
    AppMethodBeat.o(195352);
  }
  
  public static void aas(String paramString)
  {
    AppMethodBeat.i(195351);
    d.g.b.k.h(paramString, "pageName");
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
                          AppMethodBeat.o(195351);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = qlA;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", null);
                        AppMethodBeat.o(195351);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = qly;
                      if (paramString == null) {
                        break label449;
                      }
                      paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
                      AppMethodBeat.o(195351);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = qlu;
                    if (paramString == null) {
                      break label461;
                    }
                    paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", null);
                    AppMethodBeat.o(195351);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = qlv;
                  if (paramString == null) {
                    break label467;
                  }
                  paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", null);
                  AppMethodBeat.o(195351);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = qlx;
                if (paramString == null) {
                  break;
                }
                paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", null);
                AppMethodBeat.o(195351);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = qlz;
              if (paramString == null) {
                break label443;
              }
              paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
              AppMethodBeat.o(195351);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = qlt;
            if (localm == null) {
              break;
            }
            localm.a(3, paramString, null);
            AppMethodBeat.o(195351);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = qlu;
          if (paramString == null) {
            break label455;
          }
          paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", null);
          AppMethodBeat.o(195351);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = qlB;
      } while (paramString == null);
      paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", null);
      AppMethodBeat.o(195351);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = qlw;
    if (paramString != null)
    {
      paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", null);
      AppMethodBeat.o(195351);
      return;
      AppMethodBeat.o(195351);
      return;
      AppMethodBeat.o(195351);
      return;
      AppMethodBeat.o(195351);
      return;
    }
    AppMethodBeat.o(195351);
    return;
    label443:
    AppMethodBeat.o(195351);
    return;
    label449:
    AppMethodBeat.o(195351);
    return;
    label455:
    AppMethodBeat.o(195351);
    return;
    label461:
    AppMethodBeat.o(195351);
    return;
    label467:
    AppMethodBeat.o(195351);
  }
  
  public static void b(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195348);
    d.g.b.k.h(paramString, "pageName");
    d.g.b.k.h(paramActivity, "activity");
    ac.d("HABBYGE-MALI.FeedFlowMonitor", "startMonitor: page=" + paramString + ", activity=" + paramActivity.getClass().getName());
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
                          AppMethodBeat.o(195348);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        if (qlA == null) {
                          qlA = new d();
                        }
                        localObject = qlA;
                        if (localObject == null) {
                          break;
                        }
                        ((d)localObject).a(0, paramString, paramActivity);
                        AppMethodBeat.o(195348);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      if (qly == null) {
                        qly = new l();
                      }
                      localObject = qly;
                      if (localObject == null) {
                        break label644;
                      }
                      ((l)localObject).a(0, paramString, paramActivity);
                      AppMethodBeat.o(195348);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    if (qlu == null) {
                      qlu = new c();
                    }
                    localObject = qlu;
                    if (localObject == null) {
                      break label656;
                    }
                    ((c)localObject).a(0, paramString, paramActivity);
                    AppMethodBeat.o(195348);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  if (qlv == null) {
                    qlv = new n();
                  }
                  localObject = qlv;
                  if (localObject == null) {
                    break label662;
                  }
                  ((n)localObject).a(0, paramString, paramActivity);
                  AppMethodBeat.o(195348);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                if (qlx == null) {
                  qlx = new k();
                }
                localObject = qlx;
                if (localObject == null) {
                  break;
                }
                ((k)localObject).a(0, paramString, paramActivity);
                AppMethodBeat.o(195348);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              if (qlz == null) {
                qlz = new e();
              }
              localObject = qlz;
              if (localObject == null) {
                break label638;
              }
              ((e)localObject).a(0, paramString, paramActivity);
              AppMethodBeat.o(195348);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            if (qlt == null) {
              qlt = new m();
            }
            localObject = qlt;
            if (localObject == null) {
              break;
            }
            ((m)localObject).a(0, paramString, paramActivity);
            AppMethodBeat.o(195348);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          if (qlu == null) {
            qlu = new c();
          }
          localObject = qlu;
          if (localObject == null) {
            break label650;
          }
          ((c)localObject).a(0, paramString, paramActivity);
          AppMethodBeat.o(195348);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        if (qlB == null) {
          qlB = new h();
        }
        localObject = qlB;
      } while (localObject == null);
      ((h)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(195348);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    if (qlw == null) {
      qlw = new i();
    }
    Object localObject = qlw;
    if (localObject != null)
    {
      ((i)localObject).a(0, paramString, paramActivity);
      AppMethodBeat.o(195348);
      return;
      AppMethodBeat.o(195348);
      return;
      AppMethodBeat.o(195348);
      return;
      AppMethodBeat.o(195348);
      return;
    }
    AppMethodBeat.o(195348);
    return;
    label638:
    AppMethodBeat.o(195348);
    return;
    label644:
    AppMethodBeat.o(195348);
    return;
    label650:
    AppMethodBeat.o(195348);
    return;
    label656:
    AppMethodBeat.o(195348);
    return;
    label662:
    AppMethodBeat.o(195348);
  }
  
  public static void c(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195349);
    d.g.b.k.h(paramString, "pageName");
    d.g.b.k.h(paramActivity, "activity");
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
                          AppMethodBeat.o(195349);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = qlA;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(195349);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = qly;
                      if (paramString == null) {
                        break label458;
                      }
                      paramString.a(1, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(195349);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = qlu;
                    if (paramString == null) {
                      break label470;
                    }
                    paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(195349);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = qlv;
                  if (paramString == null) {
                    break label476;
                  }
                  paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(195349);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = qlx;
                if (paramString == null) {
                  break;
                }
                paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(195349);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = qlz;
              if (paramString == null) {
                break label452;
              }
              paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(195349);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            paramString = qlt;
            if (paramString == null) {
              break;
            }
            paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI", paramActivity);
            AppMethodBeat.o(195349);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = qlu;
          if (paramString == null) {
            break label464;
          }
          paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(195349);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = qlB;
      } while (paramString == null);
      paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(195349);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = qlw;
    if (paramString != null)
    {
      paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(195349);
      return;
      AppMethodBeat.o(195349);
      return;
      AppMethodBeat.o(195349);
      return;
      AppMethodBeat.o(195349);
      return;
    }
    AppMethodBeat.o(195349);
    return;
    label452:
    AppMethodBeat.o(195349);
    return;
    label458:
    AppMethodBeat.o(195349);
    return;
    label464:
    AppMethodBeat.o(195349);
    return;
    label470:
    AppMethodBeat.o(195349);
    return;
    label476:
    AppMethodBeat.o(195349);
  }
  
  public static void d(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195350);
    d.g.b.k.h(paramString, "pageName");
    d.g.b.k.h(paramActivity, "activity");
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
                          AppMethodBeat.o(195350);
                          return;
                        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"));
                        paramString = qlA;
                        if (paramString == null) {
                          break;
                        }
                        paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
                        AppMethodBeat.o(195350);
                        return;
                      } while (!paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI"));
                      paramString = qly;
                      if (paramString == null) {
                        break label457;
                      }
                      paramString.a(2, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
                      AppMethodBeat.o(195350);
                      return;
                    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI"));
                    paramString = qlu;
                    if (paramString == null) {
                      break label469;
                    }
                    paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                    AppMethodBeat.o(195350);
                    return;
                  } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI"));
                  paramString = qlv;
                  if (paramString == null) {
                    break label475;
                  }
                  paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(195350);
                  return;
                } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"));
                paramString = qlx;
                if (paramString == null) {
                  break;
                }
                paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
                AppMethodBeat.o(195350);
                return;
              } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI"));
              paramString = qlz;
              if (paramString == null) {
                break label451;
              }
              paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
              AppMethodBeat.o(195350);
              return;
            } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"));
            m localm = qlt;
            if (localm == null) {
              break;
            }
            localm.a(2, paramString, paramActivity);
            AppMethodBeat.o(195350);
            return;
          } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI"));
          paramString = qlu;
          if (paramString == null) {
            break label463;
          }
          paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
          AppMethodBeat.o(195350);
          return;
        } while (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        paramString = qlB;
      } while (paramString == null);
      paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
      AppMethodBeat.o(195350);
      return;
    } while (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI"));
    paramString = qlw;
    if (paramString != null)
    {
      paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
      AppMethodBeat.o(195350);
      return;
      AppMethodBeat.o(195350);
      return;
      AppMethodBeat.o(195350);
      return;
      AppMethodBeat.o(195350);
      return;
    }
    AppMethodBeat.o(195350);
    return;
    label451:
    AppMethodBeat.o(195350);
    return;
    label457:
    AppMethodBeat.o(195350);
    return;
    label463:
    AppMethodBeat.o(195350);
    return;
    label469:
    AppMethodBeat.o(195350);
    return;
    label475:
    AppMethodBeat.o(195350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */