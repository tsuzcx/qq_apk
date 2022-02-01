package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.af.a;
import com.tencent.mm.plugin.finder.feed.af.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "needFinishWhenResume", "", "getNeedFinishWhenResume", "()Z", "setNeedFinishWhenResume", "(Z)V", "presenter", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "onBackPressed", "isClickEmptyButton", "onResume", "plugin-finder_release"})
public final class FinderSnsGridFeedUI
  extends FinderBaseGridFeedUI<af.b, af.a>
{
  private HashMap _$_findViewCache;
  private BaseFinderFeedLoader tFM;
  private af.a ucU;
  private af.b ucV;
  public boolean ucW;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245549);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245549);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245548);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(245548);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494636;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245541);
    Object localObject1 = getContext();
    p.g(localObject1, "context");
    setActionbarColor(((AppCompatActivity)localObject1).getResources().getColor(2131099740));
    hideTitleView();
    findViewById(2131296365).setOnClickListener((View.OnClickListener)new c(this));
    localObject1 = e.tYq;
    Object localObject2 = z.aUg();
    p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderProfileFeedLoader((e)localObject1, (String)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
    ((FinderProfileFeedLoader)localObject1).setNeedToFilterLiveData(true);
    ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((kotlin.g.a.b)new a((FinderProfileFeedLoader)localObject1, this));
    this.tFM = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.tFM;
    if (localObject2 == null) {
      p.btv("feedLoader");
    }
    this.ucU = new af.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.ucV = new af.b((MMActivity)this);
    localObject1 = this.ucV;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = this.ucU;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((af.b)localObject1).a((c.a)localObject2);
    if (Util.isNullOrNil(z.aUg()))
    {
      localObject1 = this.ucV;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject1 = ((af.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).findViewById(2131300093);
        p.g(localObject2, "findViewById<View>(R.id.empty_layout)");
        ((View)localObject2).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(2131300106);
        p.g(localObject2, "findViewById<TextView>(R.id.empty_tips1)");
        ((TextView)localObject2).setText((CharSequence)((View)localObject1).getContext().getString(2131760593));
        localObject2 = ((View)localObject1).findViewById(2131300107);
        p.g(localObject2, "findViewById<TextView>(R.id.empty_tips2)");
        ((TextView)localObject2).setText((CharSequence)((View)localObject1).getContext().getString(2131760594));
        ((View)localObject1).findViewById(2131300082).setOnClickListener((View.OnClickListener)new b(this));
        localObject1 = findViewById(2131296368);
        p.g(localObject1, "this@FinderSnsGridFeedUI….action_bar_middle_title)");
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(245541);
        return;
      }
    }
    AppMethodBeat.o(245541);
  }
  
  public final void nd(boolean paramBoolean)
  {
    AppMethodBeat.i(245545);
    boolean bool = Util.isNullOrNil(z.aUg());
    int i;
    int j;
    label34:
    Object localObject;
    String str;
    if (bool)
    {
      i = 2131760594;
      if (!paramBoolean) {
        break label134;
      }
      if (!bool) {
        break label128;
      }
      j = 5;
      localObject = com.tencent.mm.plugin.finder.report.q.vgE;
      localObject = com.tencent.mm.ui.component.a.PRN;
      str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      str = getContext().getString(i);
      p.g(str, "context.getString(strId)");
      com.tencent.mm.plugin.finder.report.q.a((String)localObject, j, str, bool, false, 0L, 32);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(245545);
      return;
      i = 2131760596;
      break;
      label128:
      j = 7;
      break label34;
      label134:
      localObject = this.ucV;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      localObject = ((af.b)localObject).getEmptyView();
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        if (bool) {}
        for (j = 6;; j = 8)
        {
          localObject = com.tencent.mm.plugin.finder.report.q.vgE;
          localObject = com.tencent.mm.ui.component.a.PRN;
          str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).sessionId;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          str = getContext().getString(i);
          p.g(str, "context.getString(strId)");
          com.tencent.mm.plugin.finder.report.q.a((String)localObject, j, str, bool, false, 0L, 32);
          break;
        }
      }
      localObject = com.tencent.mm.plugin.finder.report.q.vgE;
      localObject = com.tencent.mm.ui.component.a.PRN;
      str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.q.a((String)localObject, 4, null, false, false, 0L, 60);
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(245546);
    nd(false);
    AppMethodBeat.o(245546);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245542);
    super.onResume();
    if (this.ucW) {
      finish();
    }
    AppMethodBeat.o(245542);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$2$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    a(FinderProfileFeedLoader paramFinderProfileFeedLoader, FinderSnsGridFeedUI paramFinderSnsGridFeedUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$3$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSnsGridFeedUI paramFinderSnsGridFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245539);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.ucY.nd(true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245539);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSnsGridFeedUI paramFinderSnsGridFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245540);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.ucY.nd(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI
 * JD-Core Version:    0.7.0.1
 */