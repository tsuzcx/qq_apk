package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.report.ag.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator2;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.h.a;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isPlayingWhenDown", "adjustIndicator", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "convertMedia", "item", "position", "type", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaDoubleClick", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "onPostFinished", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "Companion", "plugin-finder_release"})
public final class q
  extends o<com.tencent.mm.plugin.finder.model.u>
{
  public static final a tCx;
  private final i tAi;
  private boolean tCw;
  
  static
  {
    AppMethodBeat.i(242975);
    tCx = new a((byte)0);
    AppMethodBeat.o(242975);
  }
  
  public q(i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(242973);
    this.tAi = parami;
    AppMethodBeat.o(242973);
  }
  
  private void a(com.tencent.mm.view.recyclerview.h paramh, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(242969);
    p.h(paramh, "holder");
    p.h(paramu, "item");
    super.a(paramh, (BaseFinderFeed)paramu, paramInt1, paramInt2, paramBoolean, paramList);
    if (paramu.isPreview)
    {
      paramInt1 = com.tencent.mm.cb.a.n(paramh.getContext(), 2131100410);
      paramu = paramh.Mn(2131297134);
      p.g(paramu, "holder.getView<View>(R.id.avatar_iv)");
      paramu.setEnabled(false);
      paramu = paramh.Mn(2131305436);
      p.g(paramu, "holder.getView<View>(R.id.nickname)");
      paramu.setEnabled(false);
      paramu = paramh.Mn(2131301674);
      if (paramu != null)
      {
        ((TextView)paramu.findViewById(2131307800)).setTextColor(paramInt1);
        ((WeImageView)paramu.findViewById(2131302494)).setIconColor(paramInt1);
        paramList = paramu.findViewById(2131307809);
        p.g(paramList, "opLayout.findViewById<Vi….id.share_icon_container)");
        paramList.setEnabled(false);
        ((TextView)paramu.findViewById(2131303177)).setTextColor(paramInt1);
        paramList = ar.m(paramh.getContext(), 2131690243, paramInt1);
        ((ImageView)paramu.findViewById(2131302492)).setImageDrawable(paramList);
        paramList = paramu.findViewById(2131297154);
        p.g(paramList, "opLayout.findViewById<Vi…d.awesome_icon_container)");
        paramList.setEnabled(false);
        ((TextView)paramu.findViewById(2131298937)).setTextColor(paramInt1);
        ((WeImageView)paramu.findViewById(2131302490)).setIconColor(paramInt1);
        paramu = paramu.findViewById(2131298948);
        p.g(paramu, "opLayout.findViewById<Vi…d.comment_icon_container)");
        paramu.setEnabled(false);
        paramu = paramh.Mn(2131297153);
        p.g(paramu, "holder.getView<View>(R.id.awesome_ground_layout)");
        paramu.setVisibility(4);
        paramh = paramh.Mn(2131308992);
        p.g(paramh, "collapseTextLayout");
        paramh.setEnabled(false);
        AppMethodBeat.o(242969);
        return;
      }
    }
    AppMethodBeat.o(242969);
  }
  
  private static void i(final com.tencent.mm.view.recyclerview.h paramh)
  {
    AppMethodBeat.i(242967);
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    final View localView1 = paramh.Mn(2131300827);
    View localView2 = paramh.Mn(2131302536);
    if (localView2 != null)
    {
      localView2.post((Runnable)new b(localView2, paramh, localFinderMediaBanner, localView1));
      AppMethodBeat.o(242967);
      return;
    }
    AppMethodBeat.o(242967);
  }
  
  public final void a(final RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(242964);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.tAi.dcf());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    View localView = paramh.Mn(2131302536);
    FinderMediaGestureIndicator2 localFinderMediaGestureIndicator2 = (FinderMediaGestureIndicator2)localView;
    localFinderMediaGestureIndicator2.setOnSelectedPageListener((h.a)new f(this, localFinderMediaBanner, paramRecyclerView));
    localFinderMediaGestureIndicator2.setOnTouchListener((View.OnTouchListener)new g(this, localFinderMediaBanner, paramRecyclerView));
    p.g(localView, "holder.getView<FinderMed…e\n            }\n        }");
    localFinderMediaBanner.setIndicator((com.tencent.mm.view.h)localView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new h(paramh));
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(true);
    AppMethodBeat.o(242964);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(242972);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    p.h(paramMotionEvent, "e");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramh.hgv();
    Rect localRect = new Rect();
    paramh.Mn(2131302536).getGlobalVisibleRect(localRect);
    if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
    {
      AppMethodBeat.o(242972);
      return;
    }
    if (!localBaseFinderFeed.feedObject.isPostFinish())
    {
      AppMethodBeat.o(242972);
      return;
    }
    if (localBaseFinderFeed.isPreview)
    {
      AppMethodBeat.o(242972);
      return;
    }
    paramh = j.vUw;
    if (!((Boolean)j.dBt().m(localBaseFinderFeed.feedObject.getFeedObject()).first).booleanValue()) {
      com.tencent.mm.ui.base.u.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getString(2131759735), 0).show();
    }
    AppMethodBeat.o(242972);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    AppMethodBeat.i(242968);
    p.h(paramh, "holder");
    super.a(paramh, paramFinderItem, paramBoolean);
    i(paramh);
    AppMethodBeat.o(242968);
  }
  
  public final int getLayoutId()
  {
    return 2131492878;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$adjustIndicator$1$1"})
  static final class b
    implements Runnable
  {
    b(View paramView1, com.tencent.mm.view.recyclerview.h paramh, FinderMediaBanner paramFinderMediaBanner, View paramView2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242957);
      Object localObject2 = new int[2];
      Object localObject1 = new int[2];
      int[] arrayOfInt = new int[2];
      paramh.aus.getLocationInWindow((int[])localObject2);
      localFinderMediaBanner.getLocationInWindow((int[])localObject1);
      localObject1[0] -= localObject2[0];
      localObject1[1] -= localObject2[1];
      localView1.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] -= localObject2[0];
      arrayOfInt[1] -= localObject2[1];
      int i = arrayOfInt[1];
      localObject2 = localView1;
      p.g(localObject2, "view");
      arrayOfInt[1] = (i + ((View)localObject2).getPaddingTop());
      localObject2 = this.tCy.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(242957);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      i = ((FrameLayout.LayoutParams)localObject2).topMargin;
      Object localObject3 = paramh.getContext();
      p.g(localObject3, "holder.context");
      ((Context)localObject3).getResources().getDimension(2131165314);
      int j = localObject1[1];
      localObject3 = localFinderMediaBanner;
      p.g(localObject3, "banner");
      if (j + ((FinderMediaBanner)localObject3).getHeight() + this.tCy.getHeight() >= arrayOfInt[1]) {}
      for (((FrameLayout.LayoutParams)localObject2).topMargin = (arrayOfInt[1] - this.tCy.getHeight());; ((FrameLayout.LayoutParams)localObject2).topMargin = (j + ((FinderMediaBanner)localObject1).getHeight()))
      {
        if (((FrameLayout.LayoutParams)localObject2).topMargin != i) {
          this.tCy.requestLayout();
        }
        AppMethodBeat.o(242957);
        return;
        j = localObject1[1];
        localObject1 = localFinderMediaBanner;
        p.g(localObject1, "banner");
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$5$1"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    c(FinderMediaBanner paramFinderMediaBanner, FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$5$2"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    d(FinderMediaBanner paramFinderMediaBanner, FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", "index", "", "plugin-finder_release"})
  public static final class e
    implements h.a
  {
    e(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void Ir(int paramInt)
    {
      AppMethodBeat.i(242960);
      MediaBanner.a(this.tCA, paramInt);
      AppMethodBeat.o(242960);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$1$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", "index", "", "plugin-finder_release"})
  public static final class f
    implements h.a
  {
    f(q paramq, FinderMediaBanner paramFinderMediaBanner, RecyclerView paramRecyclerView) {}
    
    public final void Ir(int paramInt)
    {
      AppMethodBeat.i(242961);
      MediaBanner.a(localFinderMediaBanner, paramInt);
      AppMethodBeat.o(242961);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$1$2"})
  static final class g
    implements View.OnTouchListener
  {
    g(q paramq, FinderMediaBanner paramFinderMediaBanner, RecyclerView paramRecyclerView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class h
    implements MediaBanner.c
  {
    h(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(242963);
      com.tencent.mm.plugin.finder.model.u localu = (com.tencent.mm.plugin.finder.model.u)this.qhp.hgv();
      if (paramInt < localu.feedObject.getMediaList().size())
      {
        Object localObject1 = localu.feedObject.getMediaList().get(paramInt);
        p.g(localObject1, "feed.feedObject.mediaList[position]");
        localObject1 = (cjl)localObject1;
        Object localObject2 = FinderReporterUIC.wzC;
        localObject2 = this.qhp.getContext();
        p.g(localObject2, "holder.context");
        localObject2 = FinderReporterUIC.a.fH((Context)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new ag(FinderReporterUIC.a((FinderReporterUIC)localObject2)).doV();
          long l = localu.feedObject.getId();
          String str = localu.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localu.feedObject.getMediaList());
          p.g(localu, "feed");
          ((ag.a)localObject2).a(l, (cjl)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localu, paramBoolean2);
          AppMethodBeat.o(242963);
          return;
        }
      }
      AppMethodBeat.o(242963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.q
 * JD-Core Version:    0.7.0.1
 */