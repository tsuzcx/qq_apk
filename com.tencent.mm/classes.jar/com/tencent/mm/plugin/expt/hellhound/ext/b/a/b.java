package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowMonitor;", "", "()V", "TAG", "", "mDetailMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderDetailMonitor;", "mFavMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "mLbsMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "mLikedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLikeMonitor;", "mProfileMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderProfileMonitor;", "mRelMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "mSearchMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderSearchMonitor;", "mTimelineMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTimelineMonitor;", "mTopicMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderTopicMonitor;", "action", "", "actionId", "", "pageName", "doAction", "monitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "free", "activity", "Landroid/app/Activity;", "report", "startMonitor", "stopMonitor", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b zES;
  private static m zET;
  private static c zEU;
  private static n zEV;
  private static i zEW;
  private static k zEX;
  private static l zEY;
  private static e zEZ;
  private static d zFa;
  private static h zFb;
  
  static
  {
    AppMethodBeat.i(300434);
    zES = new b();
    AppMethodBeat.o(300434);
  }
  
  private static void a(int paramInt, o paramo)
  {
    AppMethodBeat.i(300428);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300428);
      return;
      if (paramo != null)
      {
        paramo.startMonitor();
        AppMethodBeat.o(300428);
        return;
        if (paramo != null)
        {
          paramo.stopMonitor();
          AppMethodBeat.o(300428);
          return;
          if (paramo != null)
          {
            paramo.report();
            AppMethodBeat.o(300428);
            return;
            if (paramo != null) {
              paramo.free();
            }
          }
        }
      }
    }
  }
  
  public static void aru(String paramString)
  {
    AppMethodBeat.i(300407);
    s.u(paramString, "pageName");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300407);
      return;
      if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
      {
        AppMethodBeat.o(300407);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
          break label369;
        }
        AppMethodBeat.o(300407);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
          break label413;
        }
        AppMethodBeat.o(300407);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
          break label435;
        }
        AppMethodBeat.o(300407);
        return;
        if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
        {
          AppMethodBeat.o(300407);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
            break label347;
          }
          AppMethodBeat.o(300407);
          return;
          if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
          {
            AppMethodBeat.o(300407);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
              break label391;
            }
            AppMethodBeat.o(300407);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
              break label457;
            }
            AppMethodBeat.o(300407);
            return;
            if (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
              AppMethodBeat.o(300407);
            }
          }
          else
          {
            m localm = zET;
            if (localm == null) {
              continue;
            }
            localm.a(3, paramString, null);
            AppMethodBeat.o(300407);
          }
        }
        else
        {
          paramString = zEX;
          if (paramString == null) {
            continue;
          }
          paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", null);
          AppMethodBeat.o(300407);
        }
      }
      else
      {
        paramString = zFa;
        if (paramString == null) {
          continue;
        }
        paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", null);
        AppMethodBeat.o(300407);
        return;
      }
      paramString = zEW;
      if (paramString != null)
      {
        paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", null);
        AppMethodBeat.o(300407);
        return;
        label347:
        paramString = zEZ;
        if (paramString != null)
        {
          paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
          AppMethodBeat.o(300407);
          return;
          label369:
          paramString = zEY;
          if (paramString != null)
          {
            paramString.a(3, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", null);
            AppMethodBeat.o(300407);
            return;
            label391:
            paramString = zEU;
            if (paramString != null)
            {
              paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", null);
              AppMethodBeat.o(300407);
              return;
              label413:
              paramString = zEU;
              if (paramString != null)
              {
                paramString.a(3, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", null);
                AppMethodBeat.o(300407);
                return;
                label435:
                paramString = zEV;
                if (paramString != null)
                {
                  paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", null);
                  AppMethodBeat.o(300407);
                  return;
                  label457:
                  paramString = zFb;
                  if (paramString != null) {
                    paramString.a(3, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void bn(int paramInt, String paramString)
  {
    AppMethodBeat.i(300421);
    s.u(paramString, "pageName");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300421);
      return;
      if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
      {
        AppMethodBeat.o(300421);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
          break label385;
        }
        AppMethodBeat.o(300421);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
          break label435;
        }
        AppMethodBeat.o(300421);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
          break label460;
        }
        AppMethodBeat.o(300421);
        return;
        if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
        {
          AppMethodBeat.o(300421);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
            break label360;
          }
          AppMethodBeat.o(300421);
          return;
          if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
          {
            AppMethodBeat.o(300421);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
              break label410;
            }
            AppMethodBeat.o(300421);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
              break label485;
            }
            AppMethodBeat.o(300421);
            return;
            if (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
              AppMethodBeat.o(300421);
            }
          }
          else
          {
            a(paramInt, (o)zET);
            if (paramInt != 2) {
              continue;
            }
            zET = null;
            AppMethodBeat.o(300421);
          }
        }
        else
        {
          a(paramInt, (o)zEX);
          if (paramInt != 2) {
            continue;
          }
          zEX = null;
          AppMethodBeat.o(300421);
        }
      }
      else
      {
        a(paramInt, (o)zFa);
        if (paramInt != 2) {
          continue;
        }
        zFa = null;
        AppMethodBeat.o(300421);
        return;
      }
      a(paramInt, (o)zEW);
      if (paramInt == 2)
      {
        zEW = null;
        AppMethodBeat.o(300421);
        return;
        label360:
        a(paramInt, (o)zEZ);
        if (paramInt == 2)
        {
          zEZ = null;
          AppMethodBeat.o(300421);
          return;
          label385:
          a(paramInt, (o)zEY);
          if (paramInt == 2)
          {
            zEY = null;
            AppMethodBeat.o(300421);
            return;
            label410:
            a(paramInt, (o)zEU);
            if (paramInt == 2)
            {
              zEU = null;
              AppMethodBeat.o(300421);
              return;
              label435:
              a(paramInt, (o)zEU);
              if (paramInt == 2)
              {
                zEU = null;
                AppMethodBeat.o(300421);
                return;
                label460:
                a(paramInt, (o)zEV);
                if (paramInt == 2)
                {
                  zEV = null;
                  AppMethodBeat.o(300421);
                  return;
                  label485:
                  a(paramInt, (o)zFb);
                  if (paramInt == 2) {
                    zFb = null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void c(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300377);
    s.u(paramString, "pageName");
    s.u(paramActivity, "activity");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300377);
      return;
      if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
      {
        AppMethodBeat.o(300377);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
          break label453;
        }
        AppMethodBeat.o(300377);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
          break label527;
        }
        AppMethodBeat.o(300377);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
          break label564;
        }
        AppMethodBeat.o(300377);
        return;
        if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
        {
          AppMethodBeat.o(300377);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
            break label416;
          }
          AppMethodBeat.o(300377);
          return;
          if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
          {
            AppMethodBeat.o(300377);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
              break label490;
            }
            AppMethodBeat.o(300377);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
              break label601;
            }
            AppMethodBeat.o(300377);
            return;
            if (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
              AppMethodBeat.o(300377);
            }
          }
          else
          {
            if (zET == null) {
              zET = new m();
            }
            localObject = zET;
            if (localObject == null) {
              continue;
            }
            ((m)localObject).a(0, paramString, paramActivity);
            AppMethodBeat.o(300377);
          }
        }
        else
        {
          if (zEX == null) {
            zEX = new k();
          }
          localObject = zEX;
          if (localObject == null) {
            continue;
          }
          ((k)localObject).a(0, paramString, paramActivity);
          AppMethodBeat.o(300377);
        }
      }
      else
      {
        if (zFa == null) {
          zFa = new d();
        }
        localObject = zFa;
        if (localObject == null) {
          continue;
        }
        ((d)localObject).a(0, paramString, paramActivity);
        AppMethodBeat.o(300377);
        return;
      }
      if (zEW == null) {
        zEW = new i();
      }
      Object localObject = zEW;
      if (localObject != null)
      {
        ((i)localObject).a(0, paramString, paramActivity);
        AppMethodBeat.o(300377);
        return;
        label416:
        if (zEZ == null) {
          zEZ = new e();
        }
        localObject = zEZ;
        if (localObject != null)
        {
          ((e)localObject).a(0, paramString, paramActivity);
          AppMethodBeat.o(300377);
          return;
          label453:
          if (zEY == null) {
            zEY = new l();
          }
          localObject = zEY;
          if (localObject != null)
          {
            ((l)localObject).a(0, paramString, paramActivity);
            AppMethodBeat.o(300377);
            return;
            label490:
            if (zEU == null) {
              zEU = new c();
            }
            localObject = zEU;
            if (localObject != null)
            {
              ((c)localObject).a(0, paramString, paramActivity);
              AppMethodBeat.o(300377);
              return;
              label527:
              if (zEU == null) {
                zEU = new c();
              }
              localObject = zEU;
              if (localObject != null)
              {
                ((c)localObject).a(0, paramString, paramActivity);
                AppMethodBeat.o(300377);
                return;
                label564:
                if (zEV == null) {
                  zEV = new n();
                }
                localObject = zEV;
                if (localObject != null)
                {
                  ((n)localObject).a(0, paramString, paramActivity);
                  AppMethodBeat.o(300377);
                  return;
                  label601:
                  if (zFb == null) {
                    zFb = new h();
                  }
                  localObject = zFb;
                  if (localObject != null) {
                    ((h)localObject).a(0, paramString, paramActivity);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void d(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300392);
    s.u(paramString, "pageName");
    s.u(paramActivity, "activity");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300392);
      return;
      if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
      {
        AppMethodBeat.o(300392);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
          break label378;
        }
        AppMethodBeat.o(300392);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
          break label422;
        }
        AppMethodBeat.o(300392);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
          break label444;
        }
        AppMethodBeat.o(300392);
        return;
        if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
        {
          AppMethodBeat.o(300392);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
            break label356;
          }
          AppMethodBeat.o(300392);
          return;
          if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
          {
            AppMethodBeat.o(300392);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
              break label400;
            }
            AppMethodBeat.o(300392);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
              break label466;
            }
            AppMethodBeat.o(300392);
            return;
            if (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
              AppMethodBeat.o(300392);
            }
          }
          else
          {
            paramString = zET;
            if (paramString == null) {
              continue;
            }
            paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI", paramActivity);
            AppMethodBeat.o(300392);
          }
        }
        else
        {
          paramString = zEX;
          if (paramString == null) {
            continue;
          }
          paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
          AppMethodBeat.o(300392);
        }
      }
      else
      {
        paramString = zFa;
        if (paramString == null) {
          continue;
        }
        paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
        AppMethodBeat.o(300392);
        return;
      }
      paramString = zEW;
      if (paramString != null)
      {
        paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
        AppMethodBeat.o(300392);
        return;
        label356:
        paramString = zEZ;
        if (paramString != null)
        {
          paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
          AppMethodBeat.o(300392);
          return;
          label378:
          paramString = zEY;
          if (paramString != null)
          {
            paramString.a(1, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
            AppMethodBeat.o(300392);
            return;
            label400:
            paramString = zEU;
            if (paramString != null)
            {
              paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
              AppMethodBeat.o(300392);
              return;
              label422:
              paramString = zEU;
              if (paramString != null)
              {
                paramString.a(1, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                AppMethodBeat.o(300392);
                return;
                label444:
                paramString = zEV;
                if (paramString != null)
                {
                  paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(300392);
                  return;
                  label466:
                  paramString = zFb;
                  if (paramString != null) {
                    paramString.a(1, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void e(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300400);
    s.u(paramString, "pageName");
    s.u(paramActivity, "activity");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300400);
      return;
      if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI"))
      {
        AppMethodBeat.o(300400);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI")) {
          break label377;
        }
        AppMethodBeat.o(300400);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI")) {
          break label421;
        }
        AppMethodBeat.o(300400);
        return;
        if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI")) {
          break label443;
        }
        AppMethodBeat.o(300400);
        return;
        if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI"))
        {
          AppMethodBeat.o(300400);
          return;
          if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI")) {
            break label355;
          }
          AppMethodBeat.o(300400);
          return;
          if (!paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI"))
          {
            AppMethodBeat.o(300400);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI")) {
              break label399;
            }
            AppMethodBeat.o(300400);
            return;
            if (paramString.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
              break label465;
            }
            AppMethodBeat.o(300400);
            return;
            if (!paramString.equals("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI")) {
              AppMethodBeat.o(300400);
            }
          }
          else
          {
            m localm = zET;
            if (localm == null) {
              continue;
            }
            localm.a(2, paramString, paramActivity);
            AppMethodBeat.o(300400);
          }
        }
        else
        {
          paramString = zEX;
          if (paramString == null) {
            continue;
          }
          paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", paramActivity);
          AppMethodBeat.o(300400);
        }
      }
      else
      {
        paramString = zFa;
        if (paramString == null) {
          continue;
        }
        paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", paramActivity);
        AppMethodBeat.o(300400);
        return;
      }
      paramString = zEW;
      if (paramString != null)
      {
        paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", paramActivity);
        AppMethodBeat.o(300400);
        return;
        label355:
        paramString = zEZ;
        if (paramString != null)
        {
          paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI", paramActivity);
          AppMethodBeat.o(300400);
          return;
          label377:
          paramString = zEY;
          if (paramString != null)
          {
            paramString.a(2, "com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", paramActivity);
            AppMethodBeat.o(300400);
            return;
            label399:
            paramString = zEU;
            if (paramString != null)
            {
              paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI", paramActivity);
              AppMethodBeat.o(300400);
              return;
              label421:
              paramString = zEU;
              if (paramString != null)
              {
                paramString.a(2, "com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI", paramActivity);
                AppMethodBeat.o(300400);
                return;
                label443:
                paramString = zEV;
                if (paramString != null)
                {
                  paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", paramActivity);
                  AppMethodBeat.o(300400);
                  return;
                  label465:
                  paramString = zFb;
                  if (paramString != null) {
                    paramString.a(2, "com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI", paramActivity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.b
 * JD-Core Version:    0.7.0.1
 */