package com.tencent.mm.plugin.finder.feed.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.jumper.h;
import com.tencent.mm.plugin.finder.feed.jumper.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "jumperUIC", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC;", "getJumperUIC", "()Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC;", "jumperUIC$delegate", "Lkotlin/Lazy;", "uiTypeToObserver", "", "", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$IGenerateObserver;", "getUiTypeToObserver", "()Ljava/util/Map;", "uiTypeToObserver$delegate", "viewPools", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "getCacheHandler", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperCacheHandler;", "businessType", "getViewEventHandler", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperViewEventHandler;", "onBindView", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "source", "", "onDeepEnjoyMedia", "itemView", "onVideoReplay", "registerJumperObserver", "removeAllViews", "removeAndRecycleView", "layout", "Landroid/view/ViewGroup;", "uiStyle", "Companion", "FeedJumperObserver", "IGenerateObserver", "JumperInfoExListObserver", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
  extends UIComponent
{
  public static final a Bce = new a((byte)0);
  private static final float Bci = MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_A);
  private static final float Bcj = MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_0_5_A);
  private final kotlin.j Bcf = kotlin.k.cm((kotlin.g.a.a)f.e.Bct);
  private final HashMap<Integer, LinkedList<View>> Bcg = new HashMap();
  private final kotlin.j Bch = kotlin.k.cm((kotlin.g.a.a)new f(this));
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public f(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  private final void ae(com.tencent.mm.view.recyclerview.j paramj)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramj.caK.findViewById(e.e.finder_feed_ad_common_layout);
    if (localLinearLayout != null) {
      l((ViewGroup)localLinearLayout, 2);
    }
    localLinearLayout = (LinearLayout)paramj.caK.findViewById(e.e.finder_feed_ad_hotspot_layout);
    if (localLinearLayout != null) {
      l((ViewGroup)localLinearLayout, 1);
    }
    paramj = (FrameLayout)paramj.caK.findViewById(e.e.finder_feed_ad_pos_layout);
    if (paramj != null) {
      l((ViewGroup)paramj, 3);
    }
  }
  
  private final i edk()
  {
    return (i)this.Bcf.getValue();
  }
  
  private final Map<Integer, c> edl()
  {
    return (Map)this.Bch.getValue();
  }
  
  private final void l(ViewGroup paramViewGroup, int paramInt)
  {
    int k = paramViewGroup.getChildCount();
    int i;
    int j;
    Object localObject;
    if (k > 0)
    {
      i = 0;
      j = i + 1;
      Map localMap = (Map)this.Bcg;
      Integer localInteger = Integer.valueOf(paramInt);
      localObject = localMap.get(localInteger);
      if (localObject != null) {
        break label102;
      }
      localObject = new LinkedList();
      localMap.put(localInteger, localObject);
    }
    label102:
    for (;;)
    {
      ((LinkedList)localObject).add(paramViewGroup.getChildAt(i));
      if (j >= k)
      {
        paramViewGroup.removeAllViews();
        return;
      }
      i = j;
      break;
    }
  }
  
  public abstract com.tencent.mm.plugin.finder.feed.jumper.s NM(int paramInt);
  
  public abstract com.tencent.mm.plugin.finder.feed.jumper.q NN(int paramInt);
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, String paramString)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramString, "source");
    Object localObject1 = paramBaseFinderFeed.feedObject.getFeedObject();
    Object localObject2 = paramj.caK;
    kotlin.g.b.s.s(localObject2, "holder.itemView");
    long l = paramBaseFinderFeed.bZA();
    localObject2 = ((View)localObject2).getContext();
    if (localObject2 == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
    }
    localObject2 = (MMActivity)localObject2;
    ae(paramj);
    if (((FinderObject)localObject1).adFlag > 0)
    {
      i locali = edk();
      int i = ((FinderObject)localObject1).adFlag;
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      com.tencent.mm.ae.d.a(locali.l(l, i, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).AJo), (androidx.lifecycle.q)localObject2, (y)new d(paramj, paramBaseFinderFeed, paramString));
    }
  }
  
  public final void b(BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramView, "itemView");
    if (paramBaseFinderFeed.feedObject.getFeedObject().adFlag == 0) {
      return;
    }
    Iterator localIterator = ((Iterable)edl().entrySet()).iterator();
    int i;
    label122:
    int k;
    int m;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramBaseFinderFeed = (Map.Entry)localIterator.next();
        i = ((Number)paramBaseFinderFeed.getKey()).intValue();
        localObject = (c)paramBaseFinderFeed.getValue();
        switch (i)
        {
        default: 
          paramBaseFinderFeed = null;
          k = ((c)localObject).edh();
        }
      } while (paramBaseFinderFeed == null);
      i = 0;
      m = paramBaseFinderFeed.getChildCount();
    } while (m <= 0);
    label148:
    int j = i + 1;
    Object localObject = paramBaseFinderFeed.getChildAt(i).getTag(k);
    if ((localObject instanceof b)) {}
    for (localObject = (b)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        com.tencent.mm.view.recyclerview.j localj = ((b)localObject).Bcl;
        View localView = ((b)localObject).view;
        com.tencent.mm.plugin.finder.feed.jumper.k localk = ((b)localObject).Bck;
        if ((localj != null) && (localView != null) && (localk != null))
        {
          String str = ((b)localObject).source;
          kotlin.g.b.s.u(localj, "holder");
          kotlin.g.b.s.u(localView, "jumpView");
          kotlin.g.b.s.u(localk, "infoEx");
          kotlin.g.b.s.u(str, "source");
          localObject = ((b)localObject).Bcm;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.feed.jumper.s)localObject).d(localj, localView, localk);
          }
        }
      }
      if (j >= m) {
        break;
      }
      i = j;
      break label148;
      paramBaseFinderFeed = (ViewGroup)paramView.findViewById(e.e.finder_feed_ad_common_layout);
      break label122;
      paramBaseFinderFeed = (ViewGroup)paramView.findViewById(e.e.finder_feed_ad_hotspot_layout);
      break label122;
      paramBaseFinderFeed = (ViewGroup)paramView.findViewById(e.e.finder_feed_ad_pos_layout);
      break label122;
    }
  }
  
  public final void c(BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramView, "itemView");
    if (paramBaseFinderFeed.feedObject.getFeedObject().adFlag == 0) {
      return;
    }
    Iterator localIterator = ((Iterable)edl().entrySet()).iterator();
    int i;
    label122:
    int k;
    int m;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramBaseFinderFeed = (Map.Entry)localIterator.next();
        i = ((Number)paramBaseFinderFeed.getKey()).intValue();
        localObject = (c)paramBaseFinderFeed.getValue();
        switch (i)
        {
        default: 
          paramBaseFinderFeed = null;
          k = ((c)localObject).edh();
        }
      } while (paramBaseFinderFeed == null);
      i = 0;
      m = paramBaseFinderFeed.getChildCount();
    } while (m <= 0);
    label148:
    int j = i + 1;
    Object localObject = paramBaseFinderFeed.getChildAt(i).getTag(k);
    if ((localObject instanceof b)) {}
    for (localObject = (b)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        com.tencent.mm.view.recyclerview.j localj = ((b)localObject).Bcl;
        View localView = ((b)localObject).view;
        com.tencent.mm.plugin.finder.feed.jumper.k localk = ((b)localObject).Bck;
        if ((localj != null) && (localView != null) && (localk != null))
        {
          String str = ((b)localObject).source;
          kotlin.g.b.s.u(localj, "holder");
          kotlin.g.b.s.u(localView, "jumpView");
          kotlin.g.b.s.u(localk, "infoEx");
          kotlin.g.b.s.u(str, "source");
          localObject = ((b)localObject).Bcm;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.feed.jumper.s)localObject).c(localj, localView, localk);
          }
        }
      }
      if (j >= m) {
        break;
      }
      i = j;
      break label148;
      paramBaseFinderFeed = (ViewGroup)paramView.findViewById(e.e.finder_feed_ad_common_layout);
      break label122;
      paramBaseFinderFeed = (ViewGroup)paramView.findViewById(e.e.finder_feed_ad_hotspot_layout);
      break label122;
      paramBaseFinderFeed = (ViewGroup)paramView.findViewById(e.e.finder_feed_ad_pos_layout);
      break label122;
    }
  }
  
  public abstract Map<Integer, c> edg();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$Companion;", "", "()V", "TAG", "", "_0_5A", "", "get_0_5A", "()F", "_1A", "get_1A", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$FeedJumperObserver;", "", "()V", "businessType", "", "getBusinessType", "()I", "setBusinessType", "(I)V", "cacheHandler", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperCacheHandler;", "getCacheHandler", "()Lcom/tencent/mm/plugin/finder/feed/jumper/JumperCacheHandler;", "setCacheHandler", "(Lcom/tencent/mm/plugin/finder/feed/jumper/JumperCacheHandler;)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "itemViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getItemViewHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setItemViewHolder", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "jumpInfo", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "getJumpInfo", "()Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "setJumpInfo", "(Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;)V", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "viewEventHandler", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperViewEventHandler;", "getViewEventHandler", "()Lcom/tencent/mm/plugin/finder/feed/jumper/JumperViewEventHandler;", "setViewEventHandler", "(Lcom/tencent/mm/plugin/finder/feed/jumper/JumperViewEventHandler;)V", "onBindView", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "jumpView", "infoEx", "onDeepEnjoyMedia", "onVideoReplay", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class b
  {
    com.tencent.mm.plugin.finder.feed.jumper.k Bck;
    com.tencent.mm.view.recyclerview.j Bcl;
    com.tencent.mm.plugin.finder.feed.jumper.s Bcm;
    com.tencent.mm.plugin.finder.feed.jumper.q Bcn;
    int businessType;
    long feedId;
    String source = "";
    View view;
    
    public abstract void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, View paramView, com.tencent.mm.plugin.finder.feed.jumper.k paramk, String paramString);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$IGenerateObserver;", "", "generate", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$FeedJumperObserver;", "layoutId", "", "tagId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract int edh();
    
    public abstract int edi();
    
    public abstract f.b edj();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$JumperInfoExListObserver;", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedAllJumpInfo;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "source", "", "(Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Ljava/lang/String;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getSource", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "onChanged", "", "set", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    implements y<Set<? extends h>>
  {
    final com.tencent.mm.view.recyclerview.j AIz;
    final BaseFinderFeed AUZ;
    private final Context context;
    final String source;
    
    public d(BaseFinderFeed paramBaseFinderFeed, String paramString)
    {
      AppMethodBeat.i(364032);
      this.AIz = paramBaseFinderFeed;
      this.AUZ = paramString;
      this.source = localObject;
      this.context = this.AIz.caK.getContext();
      AppMethodBeat.o(364032);
    }
    
    private static final void a(f.b paramb, d paramd, View paramView1, com.tencent.mm.plugin.finder.feed.jumper.k paramk, View paramView2)
    {
      AppMethodBeat.i(364040);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramb);
      localb.cH(paramd);
      localb.cH(paramView1);
      localb.cH(paramk);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$JumperInfoExListObserver", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "$observer");
      kotlin.g.b.s.u(paramd, "this$0");
      kotlin.g.b.s.u(paramk, "$infoEx");
      paramb = paramb.Bcm;
      if (paramb != null)
      {
        paramd = paramd.AIz;
        kotlin.g.b.s.s(paramView1, "view");
        paramb.b(paramd, paramView1, paramk);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$JumperInfoExListObserver", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364040);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(364077);
      if ((paramObject instanceof d))
      {
        boolean bool = kotlin.g.b.s.p(this.AIz.caK, ((d)paramObject).AIz.caK);
        AppMethodBeat.o(364077);
        return bool;
      }
      AppMethodBeat.o(364077);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(364055);
      int i = this.AIz.caK.hashCode();
      AppMethodBeat.o(364055);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(364066);
      String str = getClass().getSimpleName() + '#' + com.tencent.mm.ae.d.hF(this.AUZ.bZA());
      AppMethodBeat.o(364066);
      return str;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$JumperInfoExListObserver$onChanged$1$1$1$2", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends e.b
    {
      a(com.tencent.mm.plugin.finder.feed.jumper.k paramk, FinderJumpInfo paramFinderJumpInfo, String paramString, f.b paramb, f.d paramd) {}
      
      public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
      {
        AppMethodBeat.i(364001);
        kotlin.g.b.s.u(paramView, "view");
        if ((paramLong1 == -1L) && (paramLong2 == -1L))
        {
          AppMethodBeat.o(364001);
          return;
        }
        Object localObject = this.Bcp.Bea;
        if ((localObject != null) && (!((com.tencent.mm.plugin.finder.feed.jumper.j)localObject).edD()))
        {
          i = 1;
          if (i != 0) {
            break label151;
          }
          localObject = (CharSequence)this.Bcq.wording;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label145;
          }
        }
        label145:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label151;
          }
          Log.i("Finder.BaseAdFeedJumperUIC", "[onViewExposed] isExposed=" + paramBoolean + ", jumper info is invalid, feedId=" + this.AGw);
          AppMethodBeat.o(364001);
          return;
          i = 0;
          break;
        }
        label151:
        localObject = this.Bcr.Bcm;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.feed.jumper.s)localObject).a(paramBoolean, this.Bcs.AIz, paramView, this.Bcp);
        }
        AppMethodBeat.o(364001);
      }
      
      public final long fq(View paramView)
      {
        AppMethodBeat.i(364009);
        kotlin.g.b.s.u(paramView, "view");
        long l = this.Bcs.AUZ.bZA();
        AppMethodBeat.o(364009);
        return l;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      b(f.b paramb, FinderJumpInfo paramFinderJumpInfo, com.tencent.mm.plugin.finder.feed.jumper.k paramk, String paramString, f.d paramd, View paramView, kotlin.d.d<? super b> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(364016);
        paramObject = (kotlin.d.d)new b(this.Bcr, this.Bcq, this.Bcp, this.AGw, this.Bcs, this.$view, paramd);
        AppMethodBeat.o(364016);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        m localm = null;
        AppMethodBeat.i(364007);
        Object localObject1 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(364007);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.Bcr.Bcn;
          int i;
          if (paramObject != null)
          {
            paramObject = paramObject.a(this.Bcq);
            if (paramObject != null)
            {
              localObject2 = this.Bcq;
              com.tencent.mm.plugin.finder.feed.jumper.k localk = this.Bcp;
              CharSequence localCharSequence = paramObject.title;
              if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                break label471;
              }
              i = 1;
              if (i != 0)
              {
                localCharSequence = paramObject.BdX;
                if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                  break label476;
                }
                i = 1;
                if (i != 0)
                {
                  localCharSequence = (CharSequence)((FinderJumpInfo)localObject2).wording;
                  if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                    break label481;
                  }
                  i = 1;
                  if (i == 0) {
                    paramObject.title = ((CharSequence)((FinderJumpInfo)localObject2).wording);
                  }
                }
              }
              localCharSequence = (CharSequence)paramObject.iconUrl;
              if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                break label486;
              }
              i = 1;
              if (i != 0)
              {
                localCharSequence = (CharSequence)((FinderJumpInfo)localObject2).icon_url;
                if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                  break label491;
                }
                i = 1;
                if (i == 0) {
                  paramObject.iconUrl = ((FinderJumpInfo)localObject2).icon_url;
                }
              }
              localk.Bea = paramObject;
            }
          }
          if (this.Bcq.business_type != 16)
          {
            paramObject = this.Bcp.Bea;
            if ((paramObject != null) && (!paramObject.edD()))
            {
              i = 1;
              label306:
              if (i != 0) {
                break label530;
              }
              paramObject = (CharSequence)this.Bcq.wording;
              if ((paramObject != null) && (paramObject.length() != 0)) {
                break label501;
              }
              i = 1;
              label336:
              if (i == 0) {
                break label530;
              }
              localObject1 = new StringBuilder("invalid, feedId=").append(this.AGw).append(" cache.iconUrl=");
              paramObject = this.Bcp.Bea;
              if (paramObject != null) {
                break label506;
              }
              paramObject = null;
              label377:
              localObject1 = ((StringBuilder)localObject1).append(paramObject).append(" cache.title=");
              paramObject = this.Bcp.Bea;
              if (paramObject != null) {
                break label514;
              }
              paramObject = null;
              label404:
              localObject1 = ((StringBuilder)localObject1).append(paramObject).append("cache.desc=");
              paramObject = this.Bcp.Bea;
              if (paramObject != null) {
                break label522;
              }
            }
            label514:
            label522:
            for (paramObject = localm;; paramObject = paramObject.BdX)
            {
              Log.i("Finder.BaseAdFeedJumperUIC", paramObject + " info.wording=" + this.Bcq.wording);
              paramObject = ah.aiuX;
              AppMethodBeat.o(364007);
              return paramObject;
              label471:
              i = 0;
              break;
              label476:
              i = 0;
              break label150;
              label481:
              i = 0;
              break label181;
              label486:
              i = 0;
              break label223;
              label491:
              i = 0;
              break label254;
              i = 0;
              break label306;
              label501:
              i = 0;
              break label336;
              label506:
              paramObject = paramObject.iconUrl;
              break label377;
              paramObject = paramObject.title;
              break label404;
            }
          }
          label530:
          paramObject = (kotlin.d.f)bg.kCh();
          localm = (m)new f.d.b.1(this.Bcr, this.Bcs, this.$view, this.Bcp, null);
          Object localObject2 = (kotlin.d.d)this;
          this.label = 1;
          if (l.a(paramObject, localm, (kotlin.d.d)localObject2) == localObject1)
          {
            AppMethodBeat.o(364007);
            return localObject1;
          }
          break;
        case 1: 
          label150:
          label181:
          label223:
          label254:
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(364007);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$IGenerateObserver;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Map<Integer, ? extends f.c>>
  {
    f(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.f
 * JD-Core Version:    0.7.0.1
 */