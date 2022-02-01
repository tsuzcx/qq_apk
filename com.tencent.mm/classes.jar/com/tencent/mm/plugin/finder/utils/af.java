package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderPriorityManager;", "", "()V", "PRIORITY_AD_HOT", "", "PRIORITY_CREATION_BY_SAME_TEMPLATE", "PRIORITY_HOT_SEARCH", "PRIORITY_JUMPER", "PRIORITY_LIVE_NOTICE", "PRIORITY_LIVE_OPEN", "PRIORITY_NONE", "PRIORITY_OLY", "TAG", "", "flagMap", "Ljava/util/concurrent/ConcurrentHashMap;", "isPriorityOk", "", "key", "priority", "onViewRecycled", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setPriorityFlag", "visibility", "updatePriority", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final af Ghj;
  private static final ConcurrentHashMap<Integer, Integer> Ghk;
  
  static
  {
    AppMethodBeat.i(333567);
    Ghj = new af();
    Ghk = new ConcurrentHashMap();
    AppMethodBeat.o(333567);
  }
  
  public static void a(j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333541);
    s.u(paramj, "holder");
    if (paramInt1 == 0)
    {
      int i = paramj.hashCode();
      Object localObject2 = (Integer)Ghk.get(Integer.valueOf(i));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Integer.valueOf(0);
      }
      int j = ((Number)localObject1).intValue();
      Log.i("FinderPriorityManager", "[setPriorityFlag] visibility:" + paramInt1 + " priorityFlag:" + j + " priority:" + paramInt2 + " holder:" + paramj.hashCode());
      ((Map)Ghk).put(Integer.valueOf(i), Integer.valueOf(paramInt2));
      localObject2 = (Integer)Ghk.get(Integer.valueOf(paramj.hashCode()));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Integer.valueOf(0);
      }
      paramInt1 = ((Number)localObject1).intValue();
      Log.i("FinderPriorityManager", "[updatePriority] priorityFlag:" + paramInt1 + " holder:" + paramj.hashCode());
      localObject1 = paramj.UH(e.e.finder_feed_living_status);
      localObject2 = (FinderFeedLiveNoticeView)paramj.UH(e.e.finder_feed_live_notice_view);
      LinearLayout localLinearLayout = (LinearLayout)paramj.UH(e.e.finder_feed_ad_hotspot_layout);
      View localView = paramj.UH(e.e.finder_feed_item_of_hot_search);
      paramj = paramj.UH(e.e.finder_feed_creation_by_same_template);
      if (1 == (paramInt1 & 0x1))
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (localObject2 != null) {
          ((FinderFeedLiveNoticeView)localObject2).setVisibility(8);
        }
        if (localLinearLayout != null) {
          localLinearLayout.setVisibility(0);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
        if (paramj != null)
        {
          paramj.setVisibility(8);
          AppMethodBeat.o(333541);
        }
      }
      else if (2 == (paramInt1 & 0x2))
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (localObject2 != null) {
          ((FinderFeedLiveNoticeView)localObject2).setVisibility(8);
        }
        if (localLinearLayout != null) {
          localLinearLayout.setVisibility(0);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
        if (paramj != null)
        {
          paramj.setVisibility(8);
          AppMethodBeat.o(333541);
        }
      }
      else if (4 == (paramInt1 & 0x4))
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        if (localObject2 != null) {
          ((FinderFeedLiveNoticeView)localObject2).setVisibility(8);
        }
        if (localLinearLayout != null) {
          localLinearLayout.setVisibility(8);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
        if (paramj != null)
        {
          paramj.setVisibility(8);
          AppMethodBeat.o(333541);
        }
      }
      else if (8 == (paramInt1 & 0x8))
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (localObject2 != null) {
          ((FinderFeedLiveNoticeView)localObject2).setVisibility(0);
        }
        if (localLinearLayout != null) {
          localLinearLayout.setVisibility(8);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
        if (paramj != null)
        {
          paramj.setVisibility(8);
          AppMethodBeat.o(333541);
        }
      }
      else if (16 == (paramInt1 & 0x10))
      {
        if (localView != null) {
          localView.setVisibility(8);
        }
        if (paramj != null) {
          paramj.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(333541);
  }
  
  public static boolean iq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333551);
    Integer localInteger2 = (Integer)Ghk.get(Integer.valueOf(paramInt1));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    int i = ((Number)localInteger1).intValue();
    boolean bool;
    if (i == 0) {
      bool = true;
    }
    for (;;)
    {
      Log.i("FinderPriorityManager", "[isPriorityOk] isOk:" + bool + " priorityFlag:" + i + " priority:" + paramInt2 + " holder:" + paramInt1);
      AppMethodBeat.o(333551);
      return bool;
      if (paramInt2 <= i) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static void m(j paramj)
  {
    AppMethodBeat.i(333561);
    s.u(paramj, "holder");
    ((Map)Ghk).put(Integer.valueOf(paramj.hashCode()), Integer.valueOf(0));
    AppMethodBeat.o(333561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.af
 * JD-Core Version:    0.7.0.1
 */