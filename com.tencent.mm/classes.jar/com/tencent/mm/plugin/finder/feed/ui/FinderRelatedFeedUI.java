package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.ap.a;
import com.tencent.mm.plugin.finder.feed.ap.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRelatedFeedUI
  extends FinderBaseGridFeedUI<ap.b, ap.a>
{
  public static final a Bro;
  public BaseFinderFeedLoader ALH;
  private bav AYw;
  private ap.a Brp;
  private ap.b Brq;
  private baw Brr;
  private final int scene = 2;
  private String title = "";
  
  static
  {
    AppMethodBeat.i(365132);
    Bro = new a((byte)0);
    AppMethodBeat.o(365132);
  }
  
  private ap.a efR()
  {
    AppMethodBeat.i(365117);
    ap.a locala = this.Brp;
    if (locala == null)
    {
      s.bIx("presenter");
      AppMethodBeat.o(365117);
      return null;
    }
    AppMethodBeat.o(365117);
    return locala;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    AppMethodBeat.i(365167);
    switch (getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0))
    {
    default: 
      AppMethodBeat.o(365167);
      return 0;
    }
    AppMethodBeat.o(365167);
    return 3;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(365159);
    switch (getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0))
    {
    default: 
      AppMethodBeat.o(365159);
      return 0;
    case 2: 
      AppMethodBeat.o(365159);
      return 28;
    }
    AppMethodBeat.o(365159);
    return 30;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_related_list_layout;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(365156);
    Object localObject1 = (a)new bav();
    Object localObject4 = getIntent().getByteArrayExtra("SECTION_REQ");
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject4);
      this.AYw = ((bav)localObject1);
      localObject1 = (a)new baw();
      localObject4 = getIntent().getByteArrayExtra("SECTION_FIRST_RSP");
    }
    catch (Exception localException1)
    {
      try
      {
        ((a)localObject1).parseFrom((byte[])localObject4);
        this.Brr = ((baw)localObject1);
        if ((this.AYw == null) || (this.Brr == null))
        {
          localObject1 = new StringBuilder("req is null? ");
          if (this.AYw == null)
          {
            bool1 = true;
            localObject1 = ((StringBuilder)localObject1).append(bool1).append(", rsp is null? ");
            if (this.Brr != null) {
              break label618;
            }
            bool1 = bool2;
            Log.i("Finder.FinderRelatedFeedUI", bool1 + ", finish");
            finish();
            this.AYw = new bav();
          }
        }
        else
        {
          localObject4 = getIntent().getStringExtra("UI_TITLE");
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = "";
          }
          this.title = ((String)localObject1);
          setMMTitle(this.title);
          localObject1 = this.AYw;
          s.checkNotNull(localObject1);
          int i = ((bav)localObject1).hJx;
          int j = getCommentScene();
          localObject1 = this.AYw;
          s.checkNotNull(localObject1);
          float f1 = ((bav)localObject1).longitude;
          localObject1 = this.AYw;
          s.checkNotNull(localObject1);
          float f2 = ((bav)localObject1).latitude;
          localObject1 = this.AYw;
          s.checkNotNull(localObject1);
          localObject4 = ((bav)localObject1).ACr;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = new bve();
          }
          localObject4 = k.aeZF;
          localObject1 = new FinderRelatedLoader(i, j, f1, f2, (bve)localObject1, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
          localObject4 = getIntent();
          s.s(localObject4, "intent");
          ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject4);
          ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
          localObject4 = ah.aiuX;
          localObject1 = (BaseFinderFeedLoader)localObject1;
          s.u(localObject1, "<set-?>");
          this.ALH = ((BaseFinderFeedLoader)localObject1);
          localObject4 = (MMActivity)this;
          i = getCommentScene();
          localObject1 = this.ALH;
          if (localObject1 == null) {
            break label624;
          }
          this.Brp = new ap.a((MMActivity)localObject4, i, (BaseFinderFeedLoader)localObject1);
          localObject1 = (MMActivity)this;
          i = this.scene;
          j = getCommentScene();
          localObject4 = this.AYw;
          s.checkNotNull(localObject4);
          this.Brq = new ap.b((MMActivity)localObject1, i, j, (bav)localObject4, this.title);
          localObject1 = this.Brq;
          if (localObject1 != null) {
            break label636;
          }
          s.bIx("viewCallback");
          localObject1 = null;
          ap.a locala = this.Brp;
          localObject4 = locala;
          if (locala == null)
          {
            s.bIx("presenter");
            localObject4 = null;
          }
          ((ap.b)localObject1).a((c.a)localObject4);
          AppMethodBeat.o(365156);
          return;
          localException1 = localException1;
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
      }
      catch (Exception localException2)
      {
        label618:
        label624:
        label636:
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException2 });
          Object localObject3 = null;
          continue;
          boolean bool1 = false;
          continue;
          bool1 = false;
          continue;
          s.bIx("feedLoader");
          localObject3 = null;
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(365173);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      ap.a locala = efR();
      s.u(paramIntent, "data");
      Object localObject = locala.ATE;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).ATx.getRecyclerView();
        if (localObject != null)
        {
          av localav = av.GiL;
          av.a(paramIntent, (RecyclerView)localObject, (BaseFeedLoader)locala.ALH);
        }
      }
    }
    AppMethodBeat.o(365173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<IResponse<cc>, ah>
  {
    b(FinderRelatedFeedUI paramFinderRelatedFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI
 * JD-Core Version:    0.7.0.1
 */