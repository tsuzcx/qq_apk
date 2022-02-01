package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.cm;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "listView", "Landroid/widget/ListView;", "liveId", "", "doGetFansScene", "", "getLayoutId", "", "initIntent", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateTitle", "FinderLiveFansAdapter", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFansListUI
  extends MMFinderUI
  implements com.tencent.mm.am.h
{
  private b AyB;
  private final ArrayList<axc> BmO;
  private final FinderLiveFansListUI.a Bpd;
  private final String TAG;
  private boolean hasMore;
  private long liveId;
  private TextView njh;
  private ListView qgc;
  
  public FinderLiveFansListUI()
  {
    AppMethodBeat.i(364431);
    this.TAG = "Finder.LiveFansListUI";
    this.Bpd = new FinderLiveFansListUI.a();
    this.BmO = new ArrayList();
    AppMethodBeat.o(364431);
  }
  
  private static final boolean a(FinderLiveFansListUI paramFinderLiveFansListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364459);
    kotlin.g.b.s.u(paramFinderLiveFansListUI, "this$0");
    paramFinderLiveFansListUI.finish();
    AppMethodBeat.o(364459);
    return true;
  }
  
  private final void aMl()
  {
    Object localObject = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(364441);
    int i = this.BmO.size();
    Log.i(this.TAG, "update title fans count %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(p.h.ChD, new Object[] { Integer.valueOf(this.BmO.size()) }));
    if (i == 0)
    {
      TextView localTextView2 = this.njh;
      localObject = localTextView2;
      if (localTextView2 == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = null;
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.njh;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = localTextView1;
      }
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)getString(p.h.ChE));
        AppMethodBeat.o(364441);
        return;
      }
    }
    localTextView1 = this.njh;
    if (localTextView1 == null) {
      kotlin.g.b.s.bIx("emptyTip");
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(364441);
      return;
      localObject = localTextView1;
    }
  }
  
  private final void efj()
  {
    AppMethodBeat.i(364452);
    com.tencent.mm.plugin.findersdk.b.h localh = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(this.AyB, this.liveId);
    com.tencent.mm.kernel.h.aZW().a((p)localh, 0);
    AppMethodBeat.o(364452);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.finder_contact_sort_list_ui;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364520);
    Object localObject1 = findViewById(p.e.contact_list);
    kotlin.g.b.s.s(localObject1, "findViewById<ListView>(R.id.contact_list)");
    this.qgc = ((ListView)localObject1);
    localObject1 = findViewById(p.e.empty_tip);
    kotlin.g.b.s.s(localObject1, "findViewById<TextView>(R.id.empty_tip)");
    this.njh = ((TextView)localObject1);
    aMl();
    setBackBtn(new FinderLiveFansListUI..ExternalSyntheticLambda0(this));
    localObject1 = this.qgc;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      ((ListView)localObject1).setAdapter((ListAdapter)this.Bpd);
      localObject1 = this.qgc;
      if (localObject1 != null) {
        break label138;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = localObject2;
    }
    label138:
    for (;;)
    {
      ((ListView)localObject1).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
      AppMethodBeat.o(364520);
      return;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364505);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3531, (com.tencent.mm.am.h)this);
    this.liveId = getIntent().getLongExtra("PARAM_FINDER_LIVE_ID", 0L);
    Log.i(this.TAG, kotlin.g.b.s.X("init intent liveId:", Long.valueOf(this.liveId)));
    initView();
    efj();
    AppMethodBeat.o(364505);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364528);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3531, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(364528);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(364549);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.findersdk.api.INetSceneFinderGetFansList");
        AppMethodBeat.o(364549);
        throw paramString;
      }
      paramString = ((cm)paramp).dVL();
      if (!kotlin.g.b.s.p(this.AyB, paramString))
      {
        Log.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(364549);
        return;
      }
      this.hasMore = ((cm)paramp).dVN();
      this.AyB = ((cm)paramp).dVJ();
      d.uiThread((a)new c(this, paramp));
    }
    AppMethodBeat.o(364549);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements AbsListView.OnScrollListener
  {
    b(FinderLiveFansListUI paramFinderLiveFansListUI) {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(364359);
      if ((paramInt == 0) && (paramAbsListView != null))
      {
        FinderLiveFansListUI localFinderLiveFansListUI = this.Bpf;
        if (!paramAbsListView.canScrollVertically(1))
        {
          if (FinderLiveFansListUI.a(localFinderLiveFansListUI))
          {
            FinderLiveFansListUI.b(localFinderLiveFansListUI);
            AppMethodBeat.o(364359);
            return;
          }
          ListView localListView = FinderLiveFansListUI.c(localFinderLiveFansListUI);
          paramAbsListView = localListView;
          if (localListView == null)
          {
            kotlin.g.b.s.bIx("listView");
            paramAbsListView = null;
          }
          if (paramAbsListView.getFooterViewsCount() == 0)
          {
            localListView = FinderLiveFansListUI.c(localFinderLiveFansListUI);
            paramAbsListView = localListView;
            if (localListView == null)
            {
              kotlin.g.b.s.bIx("listView");
              paramAbsListView = null;
            }
            paramAbsListView.addFooterView(View.inflate((Context)localFinderLiveFansListUI, p.f.finder_load_no_more_footer, null));
          }
        }
      }
      AppMethodBeat.o(364359);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(FinderLiveFansListUI paramFinderLiveFansListUI, p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI
 * JD-Core Version:    0.7.0.1
 */