package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.ai.a;
import com.tencent.mm.plugin.finder.feed.ai.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderRelatedFeedUI
  extends FinderBaseGridFeedUI<ai.b, ai.a>
{
  public static final a xRV;
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private String title = "";
  private avr xAX;
  private ai.a xRS;
  private ai.b xRT;
  private avs xRU;
  public BaseFinderFeedLoader xnX;
  
  static
  {
    AppMethodBeat.i(273786);
    xRV = new a((byte)0);
    AppMethodBeat.o(273786);
  }
  
  private ai.a dvV()
  {
    AppMethodBeat.i(273780);
    ai.a locala = this.xRS;
    if (locala == null) {
      p.bGy("presenter");
    }
    AppMethodBeat.o(273780);
    return locala;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(273789);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(273789);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(273788);
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
    AppMethodBeat.o(273788);
    return localView1;
  }
  
  public final int duR()
  {
    AppMethodBeat.i(273784);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if ((i == 2) || (i == 1))
    {
      AppMethodBeat.o(273784);
      return 3;
    }
    AppMethodBeat.o(273784);
    return 0;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(273783);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(273783);
      return 28;
    }
    if (i == 1)
    {
      AppMethodBeat.o(273783);
      return 30;
    }
    AppMethodBeat.o(273783);
    return 0;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_related_list_layout;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(273779);
    Object localObject1 = (a)new avr();
    Object localObject4 = getIntent().getByteArrayExtra("SECTION_REQ");
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject4);
      this.xAX = ((avr)localObject1);
      localObject1 = (a)new avs();
      localObject4 = getIntent().getByteArrayExtra("SECTION_FIRST_RSP");
    }
    catch (Exception localException1)
    {
      try
      {
        ((a)localObject1).parseFrom((byte[])localObject4);
        this.xRU = ((avs)localObject1);
        if ((this.xAX == null) || (this.xRU == null))
        {
          localObject1 = new StringBuilder("req is null? ");
          if (this.xAX == null)
          {
            bool1 = true;
            localObject1 = ((StringBuilder)localObject1).append(bool1).append(", rsp is null? ");
            if (this.xRU != null) {
              break label612;
            }
            bool1 = bool2;
            Log.i("Finder.FinderRelatedFeedUI", bool1 + ", finish");
            finish();
            this.xAX = new avr();
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
          localObject1 = this.xAX;
          if (localObject1 == null) {
            p.iCn();
          }
          int i = ((avr)localObject1).fEH;
          int j = getCommentScene();
          localObject1 = this.xAX;
          if (localObject1 == null) {
            p.iCn();
          }
          float f1 = ((avr)localObject1).longitude;
          localObject1 = this.xAX;
          if (localObject1 == null) {
            p.iCn();
          }
          float f2 = ((avr)localObject1).latitude;
          localObject1 = this.xAX;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject4 = ((avr)localObject1).xcZ;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = new biv();
          }
          localObject4 = g.Xox;
          localObject1 = new FinderRelatedLoader(i, j, f1, f2, (biv)localObject1, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
          localObject4 = getIntent();
          p.j(localObject4, "intent");
          ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject4);
          ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
          this.xnX = ((BaseFinderFeedLoader)localObject1);
          localObject1 = (MMActivity)this;
          getCommentScene();
          localObject4 = this.xnX;
          if (localObject4 == null) {
            p.bGy("feedLoader");
          }
          this.xRS = new ai.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject4);
          localObject1 = (MMActivity)this;
          i = this.scene;
          j = getCommentScene();
          localObject4 = this.xAX;
          if (localObject4 == null) {
            p.iCn();
          }
          this.xRT = new ai.b((MMActivity)localObject1, i, j, (avr)localObject4, this.title);
          localObject1 = this.xRT;
          if (localObject1 == null) {
            p.bGy("viewCallback");
          }
          localObject4 = this.xRS;
          if (localObject4 == null) {
            p.bGy("presenter");
          }
          ((ai.b)localObject1).a((c.a)localObject4);
          AppMethodBeat.o(273779);
          return;
          localException1 = localException1;
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException2 });
          Object localObject3 = null;
          continue;
          boolean bool1 = false;
          continue;
          label612:
          bool1 = false;
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273785);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      ai.a locala = dvV();
      p.k(paramIntent, "data");
      Object localObject = locala.xvU;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).xvJ.getRecyclerView();
        if (localObject != null)
        {
          com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.a(paramIntent, (RecyclerView)localObject, (BaseFeedLoader)locala.xnX);
          AppMethodBeat.o(273785);
          return;
        }
      }
      AppMethodBeat.o(273785);
      return;
    }
    AppMethodBeat.o(273785);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$initOnCreate$1$1"})
  static final class b
    extends q
    implements b<IResponse<bu>, x>
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