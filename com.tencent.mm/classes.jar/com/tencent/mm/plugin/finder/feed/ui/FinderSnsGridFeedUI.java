package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.am.a;
import com.tencent.mm.plugin.finder.feed.am.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.u;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "needFinishWhenResume", "", "getNeedFinishWhenResume", "()Z", "setNeedFinishWhenResume", "(Z)V", "presenter", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "onBackPressed", "isClickEmptyButton", "onResume", "plugin-finder_release"})
public final class FinderSnsGridFeedUI
  extends FinderBaseGridFeedUI<am.b, am.a>
{
  private HashMap _$_findViewCache;
  public boolean xSA;
  private am.a xSy;
  private am.b xSz;
  private BaseFinderFeedLoader xnX;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(270200);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(270200);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(270199);
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
    AppMethodBeat.o(270199);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_sns_post_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(270185);
    Object localObject1 = getContext();
    p.j(localObject1, "context");
    setActionbarColor(((AppCompatActivity)localObject1).getResources().getColor(b.c.Dark_0));
    hideTitleView();
    findViewById(b.f.action_bar_back_button).setOnClickListener((View.OnClickListener)new c(this));
    localObject1 = com.tencent.mm.plugin.finder.feed.model.internal.g.xKu;
    Object localObject2 = z.bdh();
    p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    localObject1 = new FinderProfileFeedLoader((com.tencent.mm.plugin.finder.feed.model.internal.g)localObject1, (String)localObject2, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).ekY());
    ((FinderProfileFeedLoader)localObject1).setNeedToFilterLiveData(true);
    ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((kotlin.g.a.b)new a((FinderProfileFeedLoader)localObject1, this));
    this.xnX = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.xnX;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    this.xSy = new am.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.xSz = new am.b((MMActivity)this);
    localObject1 = this.xSz;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = this.xSy;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((am.b)localObject1).a((c.a)localObject2);
    if (Util.isNullOrNil(z.bdh()))
    {
      localObject1 = this.xSz;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      localObject1 = ((am.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).findViewById(b.f.empty_layout);
        p.j(localObject2, "findViewById<View>(R.id.empty_layout)");
        ((View)localObject2).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(b.f.empty_tips1);
        p.j(localObject2, "findViewById<TextView>(R.id.empty_tips1)");
        ((TextView)localObject2).setText((CharSequence)((View)localObject1).getContext().getString(b.j.finder_sns_post_ui_empty_no_account_tips1));
        localObject2 = ((View)localObject1).findViewById(b.f.empty_tips2);
        p.j(localObject2, "findViewById<TextView>(R.id.empty_tips2)");
        ((TextView)localObject2).setText((CharSequence)((View)localObject1).getContext().getString(b.j.finder_sns_post_ui_empty_no_account_tips2));
        ((View)localObject1).findViewById(b.f.empty_button).setOnClickListener((View.OnClickListener)new b(this));
        localObject1 = findViewById(b.f.action_bar_middle_title);
        p.j(localObject1, "this@FinderSnsGridFeedUI….action_bar_middle_title)");
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(270185);
        return;
      }
    }
    AppMethodBeat.o(270185);
  }
  
  public final void oC(boolean paramBoolean)
  {
    AppMethodBeat.i(270193);
    boolean bool = Util.isNullOrNil(z.bdh());
    int i;
    int j;
    label34:
    Object localObject;
    String str;
    if (bool)
    {
      i = b.j.finder_sns_post_ui_empty_no_account_tips2;
      if (!paramBoolean) {
        break label134;
      }
      if (!bool) {
        break label128;
      }
      j = 5;
      localObject = u.zXM;
      localObject = com.tencent.mm.ui.component.g.Xox;
      str = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      str = getContext().getString(i);
      p.j(str, "context.getString(strId)");
      u.a((String)localObject, j, str, bool, false, 0L, 32);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(270193);
      return;
      i = b.j.finder_sns_post_ui_empty_no_content_tips2;
      break;
      label128:
      j = 7;
      break label34;
      label134:
      localObject = this.xSz;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      localObject = ((am.b)localObject).getEmptyView();
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        if (bool) {}
        for (j = 6;; j = 8)
        {
          localObject = u.zXM;
          localObject = com.tencent.mm.ui.component.g.Xox;
          str = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).sessionId;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          str = getContext().getString(i);
          p.j(str, "context.getString(strId)");
          u.a((String)localObject, j, str, bool, false, 0L, 32);
          break;
        }
      }
      localObject = u.zXM;
      localObject = com.tencent.mm.ui.component.g.Xox;
      str = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).sessionId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      u.a((String)localObject, 4, null, false, false, 0L, 60);
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(270195);
    oC(false);
    AppMethodBeat.o(270195);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(270187);
    super.onResume();
    if (this.xSA) {
      finish();
    }
    AppMethodBeat.o(270187);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$2$1"})
  static final class a
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    a(FinderProfileFeedLoader paramFinderProfileFeedLoader, FinderSnsGridFeedUI paramFinderSnsGridFeedUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$3$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSnsGridFeedUI paramFinderSnsGridFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277966);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xSC.oC(true);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277966);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSnsGridFeedUI paramFinderSnsGridFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230620);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xSC.oC(false);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI
 * JD-Core Version:    0.7.0.1
 */