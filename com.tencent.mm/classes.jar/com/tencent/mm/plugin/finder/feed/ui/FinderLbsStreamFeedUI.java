package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.w.a;
import com.tencent.mm.plugin.finder.feed.w.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLbsStreamFeedUI
  extends FinderBaseGridFeedUI<w.b, w.a>
{
  public BaseFinderFeedLoader ALH;
  private w.a Boq;
  private w.b Bor;
  private final String TAG = "Finder.LbsStreamFeedUI";
  private final int scene = 2;
  private String title = "";
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final BaseFinderFeedLoader efc()
  {
    AppMethodBeat.i(364356);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null)
    {
      AppMethodBeat.o(364356);
      return localBaseFinderFeedLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(364356);
    return null;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(364381);
    d locald = d.FAy;
    if (((Number)d.eTC().bmg()).intValue() != 0)
    {
      AppMethodBeat.o(364381);
      return 43;
    }
    AppMethodBeat.o(364381);
    return 16;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_lbs_stream_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(364374);
    Object localObject2 = getIntent().getStringExtra("KEY_UI_TITLE");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = z.bAW();
    s.s(localObject1, "getMyFinderUsername()");
    localObject2 = k.aeZF;
    localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
    localObject2 = getIntent();
    s.s(localObject2, "intent");
    ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new a(this));
    localObject2 = ah.aiuX;
    localObject1 = (BaseFinderFeedLoader)localObject1;
    s.u(localObject1, "<set-?>");
    this.ALH = ((BaseFinderFeedLoader)localObject1);
    this.Boq = new w.a((MMActivity)this, getCommentScene(), efc());
    this.Bor = new w.b((MMActivity)this, this.scene, getCommentScene(), this.title);
    localObject1 = this.Bor;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    for (;;)
    {
      w.a locala = this.Boq;
      localObject2 = locala;
      if (locala == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((w.b)localObject1).a((c.a)localObject2);
      AppMethodBeat.o(364374);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    a(FinderLbsStreamFeedUI paramFinderLbsStreamFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamFeedUI
 * JD-Core Version:    0.7.0.1
 */