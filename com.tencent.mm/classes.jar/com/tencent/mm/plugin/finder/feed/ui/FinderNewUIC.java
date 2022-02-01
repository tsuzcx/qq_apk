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
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.aa.a;
import com.tencent.mm.plugin.finder.feed.aa.b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderNewUIC;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "needFinishWhenResume", "", "getNeedFinishWhenResume", "()Z", "setNeedFinishWhenResume", "(Z)V", "presenter", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "onBackPressed", "isClickEmptyButton", "onResume", "plugin-finder_release"})
public final class FinderNewUIC
  extends FinderBaseGridFeedUI<aa.b, aa.a>
{
  private HashMap _$_findViewCache;
  private BaseFinderFeedLoader rTS;
  private aa.a sfr;
  private aa.b sfs;
  public boolean sft;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202793);
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
    AppMethodBeat.o(202793);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496465;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202786);
    Object localObject1 = getContext();
    p.g(localObject1, "context");
    setActionbarColor(((AppCompatActivity)localObject1).getResources().getColor(2131099726));
    hideTitleView();
    findViewById(2131296726).setOnClickListener((View.OnClickListener)new c(this));
    localObject1 = e.scL;
    Object localObject2 = u.aAu();
    p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    localObject1 = new FinderProfileFeedLoader((e)localObject1, (String)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
    ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((d.g.a.b)new a((FinderProfileFeedLoader)localObject1, this));
    this.rTS = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.rTS;
    if (localObject2 == null) {
      p.bcb("feedLoader");
    }
    this.sfr = new aa.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.sfs = new aa.b((MMActivity)this);
    localObject1 = this.sfs;
    if (localObject1 == null) {
      p.bcb("viewCallback");
    }
    localObject2 = this.sfr;
    if (localObject2 == null) {
      p.bcb("presenter");
    }
    ((aa.b)localObject1).a((b.a)localObject2);
    if (bt.isNullOrNil(u.aAu()))
    {
      localObject1 = this.sfs;
      if (localObject1 == null) {
        p.bcb("viewCallback");
      }
      localObject1 = ((aa.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).findViewById(2131308295);
        p.g(localObject2, "findViewById<View>(R.id.empty_layout)");
        ((View)localObject2).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(2131308297);
        p.g(localObject2, "findViewById<TextView>(R.id.empty_tips1)");
        ((TextView)localObject2).setText((CharSequence)((View)localObject1).getContext().getString(2131767041));
        localObject2 = ((View)localObject1).findViewById(2131308298);
        p.g(localObject2, "findViewById<TextView>(R.id.empty_tips2)");
        ((TextView)localObject2).setText((CharSequence)((View)localObject1).getContext().getString(2131767042));
        ((View)localObject1).findViewById(2131308293).setOnClickListener((View.OnClickListener)new b(this));
        localObject1 = findViewById(2131296728);
        p.g(localObject1, "this@FinderNewUIC.findVi….action_bar_middle_title)");
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(202786);
        return;
      }
    }
    AppMethodBeat.o(202786);
  }
  
  public final void lV(boolean paramBoolean)
  {
    AppMethodBeat.i(202790);
    boolean bool = bt.isNullOrNil(u.aAu());
    int i;
    int j;
    label34:
    Object localObject;
    String str;
    if (bool)
    {
      i = 2131767042;
      if (!paramBoolean) {
        break label134;
      }
      if (!bool) {
        break label128;
      }
      j = 5;
      localObject = m.spK;
      localObject = com.tencent.mm.ui.component.a.KiD;
      str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      str = getContext().getString(i);
      p.g(str, "context.getString(strId)");
      m.a((String)localObject, j, str, bool, false, 0L, 32);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(202790);
      return;
      i = 2131767044;
      break;
      label128:
      j = 7;
      break label34;
      label134:
      localObject = this.sfs;
      if (localObject == null) {
        p.bcb("viewCallback");
      }
      localObject = ((aa.b)localObject).getEmptyView();
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        if (bool) {}
        for (j = 6;; j = 8)
        {
          localObject = m.spK;
          localObject = com.tencent.mm.ui.component.a.KiD;
          str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).sessionId;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          str = getContext().getString(i);
          p.g(str, "context.getString(strId)");
          m.a((String)localObject, j, str, bool, false, 0L, 32);
          break;
        }
      }
      localObject = m.spK;
      localObject = com.tencent.mm.ui.component.a.KiD;
      str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      m.a((String)localObject, 4, null, false, false, 0L, 60);
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202791);
    lV(false);
    AppMethodBeat.o(202791);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202787);
    super.onResume();
    if (this.sft) {
      finish();
    }
    AppMethodBeat.o(202787);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$2$1"})
  static final class a
    extends q
    implements d.g.a.b<IResponse<al>, z>
  {
    a(FinderProfileFeedLoader paramFinderProfileFeedLoader, FinderNewUIC paramFinderNewUIC)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$3$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderNewUIC paramFinderNewUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202784);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sfu.lV(true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202784);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderNewUIC paramFinderNewUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202785);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sfu.lV(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC
 * JD-Core Version:    0.7.0.1
 */