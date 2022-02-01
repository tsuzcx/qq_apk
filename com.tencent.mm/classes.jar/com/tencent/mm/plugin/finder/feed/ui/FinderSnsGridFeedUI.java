package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.at.a;
import com.tencent.mm.plugin.finder.feed.at.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "needFinishWhenResume", "", "getNeedFinishWhenResume", "()Z", "setNeedFinishWhenResume", "(Z)V", "presenter", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "onBackPressed", "isClickEmptyButton", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSnsGridFeedUI
  extends FinderBaseGridFeedUI<at.b, at.a>
{
  private BaseFinderFeedLoader ALH;
  private at.a BrZ;
  private at.b Bsa;
  public boolean Bsb;
  
  private static final void a(FinderSnsGridFeedUI paramFinderSnsGridFeedUI, View paramView)
  {
    AppMethodBeat.i(364225);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSnsGridFeedUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderSnsGridFeedUI, "this$0");
    paramFinderSnsGridFeedUI.qf(false);
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364225);
  }
  
  private static final void b(FinderSnsGridFeedUI paramFinderSnsGridFeedUI, View paramView)
  {
    AppMethodBeat.i(364233);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSnsGridFeedUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderSnsGridFeedUI, "this$0");
    paramFinderSnsGridFeedUI.qf(true);
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderSnsGridFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364233);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_sns_post_list_layout;
  }
  
  public final void initOnCreate()
  {
    Object localObject3 = null;
    AppMethodBeat.i(364279);
    setActionbarColor(getContext().getResources().getColor(e.b.Dark_0));
    hideTitleView();
    findViewById(e.e.action_bar_back_button).setOnClickListener(new FinderSnsGridFeedUI..ExternalSyntheticLambda0(this));
    Object localObject1 = g.Bkj;
    Object localObject2 = z.bAW();
    s.s(localObject2, "getMyFinderUsername()");
    Object localObject4 = k.aeZF;
    localObject1 = new FinderProfileFeedLoader((g)localObject1, (String)localObject2, ((as)k.d((AppCompatActivity)this).q(as.class)).fou(), false, 8, null);
    ((FinderProfileFeedLoader)localObject1).setNeedToFilterLiveData(true);
    ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((kotlin.g.a.b)new a((FinderProfileFeedLoader)localObject1, this));
    localObject2 = ah.aiuX;
    this.ALH = ((BaseFinderFeedLoader)localObject1);
    localObject4 = (MMActivity)this;
    localObject2 = this.ALH;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedLoader");
      localObject1 = null;
    }
    this.BrZ = new at.a((MMActivity)localObject4, (BaseFinderFeedLoader)localObject1);
    this.Bsa = new at.b((MMActivity)this);
    localObject1 = this.Bsa;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
      localObject4 = this.BrZ;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((at.b)localObject1).a((c.a)localObject2);
      if (Util.isNullOrNil(z.bAW()))
      {
        localObject1 = this.Bsa;
        if (localObject1 != null) {
          break label365;
        }
        s.bIx("viewCallback");
        localObject1 = localObject3;
      }
    }
    label365:
    for (;;)
    {
      localObject1 = ((at.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        ((View)localObject1).findViewById(e.e.empty_layout).setVisibility(0);
        ((TextView)((View)localObject1).findViewById(e.e.empty_tips1)).setText((CharSequence)((View)localObject1).getContext().getString(e.h.finder_sns_post_ui_empty_no_account_tips1));
        ((TextView)((View)localObject1).findViewById(e.e.empty_tips2)).setText((CharSequence)((View)localObject1).getContext().getString(e.h.finder_sns_post_ui_empty_no_account_tips2));
        ((View)localObject1).findViewById(e.e.empty_button).setOnClickListener(new FinderSnsGridFeedUI..ExternalSyntheticLambda1(this));
        findViewById(e.e.action_bar_middle_title).setVisibility(8);
      }
      AppMethodBeat.o(364279);
      return;
      break;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(364307);
    qf(false);
    AppMethodBeat.o(364307);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364287);
    super.onResume();
    if (this.Bsb) {
      finish();
    }
    AppMethodBeat.o(364287);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qf(boolean paramBoolean)
  {
    AppMethodBeat.i(364300);
    boolean bool = Util.isNullOrNil(z.bAW());
    int i;
    int j;
    label34:
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      i = e.h.finder_sns_post_ui_empty_no_account_tips2;
      if (!paramBoolean) {
        break label134;
      }
      if (!bool) {
        break label128;
      }
      j = 5;
      localObject1 = ag.Ftp;
      localObject1 = k.aeZF;
      localObject2 = ((as)k.d((AppCompatActivity)this).q(as.class)).sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = getContext().getString(i);
      s.s(localObject2, "context.getString(strId)");
      ag.a((String)localObject1, j, (String)localObject2, bool, false, 0L, 32);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(364300);
      return;
      i = e.h.finder_sns_post_ui_empty_no_content_tips2;
      break;
      label128:
      j = 7;
      break label34;
      label134:
      localObject2 = this.Bsa;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((at.b)localObject1).getEmptyView();
      if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
      {
        j = 1;
        label179:
        if (j == 0) {
          break label281;
        }
        if (!bool) {
          break label275;
        }
      }
      label275:
      for (j = 6;; j = 8)
      {
        localObject1 = ag.Ftp;
        localObject1 = k.aeZF;
        localObject2 = ((as)k.d((AppCompatActivity)this).q(as.class)).sessionId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = getContext().getString(i);
        s.s(localObject2, "context.getString(strId)");
        ag.a((String)localObject1, j, (String)localObject2, bool, false, 0L, 32);
        break;
        j = 0;
        break label179;
      }
      label281:
      localObject1 = ag.Ftp;
      localObject1 = k.aeZF;
      localObject2 = ((as)k.d((AppCompatActivity)this).q(as.class)).sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ag.a((String)localObject1, 4, null, false, false, 0L, 60);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    a(FinderProfileFeedLoader paramFinderProfileFeedLoader, FinderSnsGridFeedUI paramFinderSnsGridFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI
 * JD-Core Version:    0.7.0.1
 */