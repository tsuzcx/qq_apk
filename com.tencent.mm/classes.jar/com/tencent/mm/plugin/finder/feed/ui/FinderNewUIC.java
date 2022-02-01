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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.feed.aa.a;
import com.tencent.mm.plugin.finder.feed.aa.b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderNewUIC;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "needFinishWhenResume", "", "getNeedFinishWhenResume", "()Z", "setNeedFinishWhenResume", "(Z)V", "presenter", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "onBackPressed", "isClickEmptyButton", "onResume", "plugin-finder_release"})
public final class FinderNewUIC
  extends FinderBaseGridFeedUI<aa.b, aa.a>
{
  private HashMap _$_findViewCache;
  private BaseFinderFeedLoader scw;
  private aa.a sok;
  private aa.b sol;
  public boolean som;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203272);
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
    AppMethodBeat.o(203272);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496465;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(203265);
    Object localObject1 = getContext();
    p.g(localObject1, "context");
    setActionbarColor(((AppCompatActivity)localObject1).getResources().getColor(2131099726));
    hideTitleView();
    findViewById(2131296726).setOnClickListener((View.OnClickListener)new c(this));
    localObject1 = e.slC;
    Object localObject2 = v.aAK();
    p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    localObject1 = new FinderProfileFeedLoader((e)localObject1, (String)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
    ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((d.g.a.b)new a((FinderProfileFeedLoader)localObject1, this));
    this.scw = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.scw;
    if (localObject2 == null) {
      p.bdF("feedLoader");
    }
    this.sok = new aa.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.sol = new aa.b((MMActivity)this);
    localObject1 = this.sol;
    if (localObject1 == null) {
      p.bdF("viewCallback");
    }
    localObject2 = this.sok;
    if (localObject2 == null) {
      p.bdF("presenter");
    }
    ((aa.b)localObject1).a((b.a)localObject2);
    if (bu.isNullOrNil(v.aAK()))
    {
      localObject1 = this.sol;
      if (localObject1 == null) {
        p.bdF("viewCallback");
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
        AppMethodBeat.o(203265);
        return;
      }
    }
    AppMethodBeat.o(203265);
  }
  
  public final void lV(boolean paramBoolean)
  {
    AppMethodBeat.i(203269);
    boolean bool = bu.isNullOrNil(v.aAK());
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
      localObject = n.szV;
      localObject = com.tencent.mm.ui.component.a.KEX;
      str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      str = getContext().getString(i);
      p.g(str, "context.getString(strId)");
      n.a((String)localObject, j, str, bool, false, 0L, 32);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(203269);
      return;
      i = 2131767044;
      break;
      label128:
      j = 7;
      break label34;
      label134:
      localObject = this.sol;
      if (localObject == null) {
        p.bdF("viewCallback");
      }
      localObject = ((aa.b)localObject).getEmptyView();
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        if (bool) {}
        for (j = 6;; j = 8)
        {
          localObject = n.szV;
          localObject = com.tencent.mm.ui.component.a.KEX;
          str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).sessionId;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          str = getContext().getString(i);
          p.g(str, "context.getString(strId)");
          n.a((String)localObject, j, str, bool, false, 0L, 32);
          break;
        }
      }
      localObject = n.szV;
      localObject = com.tencent.mm.ui.component.a.KEX;
      str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      n.a((String)localObject, 4, null, false, false, 0L, 60);
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(203270);
    lV(false);
    AppMethodBeat.o(203270);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203266);
    super.onResume();
    if (this.som) {
      finish();
    }
    AppMethodBeat.o(203266);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$2$1"})
  static final class a
    extends q
    implements d.g.a.b<IResponse<am>, z>
  {
    a(FinderProfileFeedLoader paramFinderProfileFeedLoader, FinderNewUIC paramFinderNewUIC)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$3$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderNewUIC paramFinderNewUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203263);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.son.lV(true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203263);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderNewUIC paramFinderNewUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203264);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.son.lV(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIC$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203264);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC
 * JD-Core Version:    0.7.0.1
 */