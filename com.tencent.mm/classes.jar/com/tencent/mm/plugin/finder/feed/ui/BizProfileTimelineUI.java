package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.biz.FinderBizProfileLoader;
import com.tencent.mm.plugin.finder.biz.b.a;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/BizProfileTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader;", "Lcom/tencent/mm/plugin/finder/biz/FinderBizTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/biz/FinderBizTimelineContract$Presenter;", "()V", "feedLoader", "presenter", "timestampOnCreate", "", "timestampOnResume", "viewCallback", "finish", "", "getCommentScene", "", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "loadJumpInfoOnInit", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onPause", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileTimelineUI
  extends FinderLoaderFeedUI<FinderBizProfileLoader, com.tencent.mm.plugin.finder.biz.b.b, b.a>
{
  private FinderBizProfileLoader AxI;
  private b.a BkR;
  private com.tencent.mm.plugin.finder.biz.b.b BkS;
  private long BkT;
  private long BkU;
  
  private static final Map a(BizProfileTimelineUI paramBizProfileTimelineUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(364800);
    s.u(paramBizProfileTimelineUI, "this$0");
    paramString = paramBizProfileTimelineUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!i.hm(paramString)) {
        break label208;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label208:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr1 = v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr2 = v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = v.Y("finder_tab_context_id", localObject1);
      paramString = v.Y("extra_info", paramString);
      paramBizProfileTimelineUI = paramBizProfileTimelineUI.getIntent();
      if (paramBizProfileTimelineUI == null) {}
      for (paramBizProfileTimelineUI = localObject2;; paramBizProfileTimelineUI = paramBizProfileTimelineUI.getStringExtra("key_enter_source_info"))
      {
        paramBizProfileTimelineUI = ak.e(new r[] { localr1, localr2, localObject1, paramString, v.Y("enter_source_info", String.valueOf(paramBizProfileTimelineUI)) });
        AppMethodBeat.o(364800);
        return paramBizProfileTimelineUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(364854);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    String str1 = c.dLD().dHN();
    String str2 = getClass().getSimpleName();
    long l1 = System.currentTimeMillis();
    long l2 = this.BkT;
    long l3 = this.BkT;
    long l4 = System.currentTimeMillis();
    Object localObject2 = this.AxI;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedLoader");
      localObject1 = null;
    }
    localObject1 = ((FinderBizProfileLoader)localObject1).getContextObj();
    String str3;
    int i;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      str3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      i = c.b.zHc.value;
      localObject3 = this.AxI;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedLoader");
        localObject2 = null;
      }
      localObject2 = ((FinderBizProfileLoader)localObject2).getContextObj();
      if (localObject2 != null) {
        break label216;
      }
      localObject2 = "";
    }
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str1, str2, l1 - l2, l3, l4, (String)localObject1, str3, i, com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW(), (String)localObject2, 1280));
      super.finish();
      AppMethodBeat.o(364854);
      return;
      localObject2 = ((bui)localObject1).zIB;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label216:
      localObject3 = ((bui)localObject2).zIO;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  public final int getCommentScene()
  {
    return 120;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_biz_profile_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(364843);
    this.BkR = new b.a((MMActivity)this);
    MMActivity localMMActivity = (MMActivity)this;
    Object localObject2 = this.BkR;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("presenter");
      localObject1 = null;
    }
    this.BkS = new com.tencent.mm.plugin.finder.biz.b.b(localMMActivity, (b.a)localObject1);
    localObject1 = getIntent().getStringExtra("KEY_BIZ_USERNAME");
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject2 = k.aeZF;
      localObject1 = new FinderBizProfileLoader((String)localObject1, ((as)k.d((AppCompatActivity)this).q(as.class)).fou(), true);
      localObject2 = getIntent();
      s.s(localObject2, "intent");
      ((FinderBizProfileLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderBizProfileLoader)localObject1).setInitDone((j)new a(this, (FinderBizProfileLoader)localObject1));
      ((FinderBizProfileLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
      localObject2 = ah.aiuX;
      this.AxI = ((FinderBizProfileLoader)localObject1);
      this.BkT = System.currentTimeMillis();
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgu);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new BizProfileTimelineUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(364843);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364870);
    super.onPause();
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    String str1 = c.dLD().dHN();
    String str2 = getClass().getSimpleName();
    long l1 = System.currentTimeMillis();
    long l2 = this.BkU;
    long l3 = this.BkU;
    long l4 = System.currentTimeMillis();
    Object localObject2 = this.AxI;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedLoader");
      localObject1 = null;
    }
    localObject1 = ((FinderBizProfileLoader)localObject1).getContextObj();
    String str3;
    int i;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      str3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      i = c.b.zHb.value;
      localObject3 = this.AxI;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedLoader");
        localObject2 = null;
      }
      localObject2 = ((FinderBizProfileLoader)localObject2).getContextObj();
      if (localObject2 != null) {
        break label216;
      }
      localObject2 = "";
    }
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str1, str2, l1 - l2, l3, l4, (String)localObject1, str3, i, com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW(), (String)localObject2, 1280));
      AppMethodBeat.o(364870);
      return;
      localObject2 = ((bui)localObject1).zIB;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label216:
      localObject3 = ((bui)localObject2).zIO;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364860);
    super.onResume();
    this.BkU = System.currentTimeMillis();
    AppMethodBeat.o(364860);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/BizProfileTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(BizProfileTimelineUI paramBizProfileTimelineUI, FinderBizProfileLoader paramFinderBizProfileLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(364897);
      Object localObject2 = BizProfileTimelineUI.a(this.BkV);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.feed.b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.BkW;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderBizProfileLoader)localObject2).getInitPos(), 0);
      }
      BizProfileTimelineUI.gg((List)this.BkW.getDataList());
      AppMethodBeat.o(364897);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    b(BizProfileTimelineUI paramBizProfileTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.BizProfileTimelineUI
 * JD-Core Version:    0.7.0.1
 */