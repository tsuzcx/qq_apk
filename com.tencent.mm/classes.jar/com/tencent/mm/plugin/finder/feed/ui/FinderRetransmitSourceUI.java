package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.a;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.c;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRetransmitSourceUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "()V", "feedLoader", "presenter", "refObjectId", "", "refObjectNonceId", "", "targetNickname", "targetUsername", "viewCallback", "getLayoutId", "", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRetransmitSourceUI
  extends FinderLoaderFeedUI<FinderRetransmitSourceContract.Loader, FinderRetransmitSourceContract.c, FinderRetransmitSourceContract.a>
{
  private HashMap _$_findViewCache;
  private long refObjectId;
  private String refObjectNonceId = "";
  private String xNf;
  private FinderRetransmitSourceContract.a xSc;
  private FinderRetransmitSourceContract.c xSd;
  private FinderRetransmitSourceContract.Loader xSe;
  private String xcW;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(271661);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(271661);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(271660);
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
    AppMethodBeat.o(271660);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_retransmitsource_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(166232);
    Object localObject1 = getIntent().getStringExtra("KEY_TARGET_USERNAME");
    p.j(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_USERNAME)");
    this.xcW = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("KEY_TARGET_NICKNAME");
    p.j(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_NICKNAME)");
    this.xNf = ((String)localObject1);
    this.refObjectId = getIntent().getLongExtra("KEY_REF_OBJ_ID", 0L);
    localObject1 = getIntent().getStringExtra("KEY_REF_OBJ_NONCE_ID");
    p.j(localObject1, "intent.getStringExtra(Co…eUI.KEY_REF_OBJ_NONCE_ID)");
    this.refObjectNonceId = ((String)localObject1);
    localObject1 = this.xcW;
    if (localObject1 == null) {
      p.bGy("targetUsername");
    }
    if ((Util.isNullOrNil((String)localObject1)) || (this.refObjectId == 0L)) {
      finish();
    }
    this.xSc = new FinderRetransmitSourceContract.a((MMActivity)this);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.xSc;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    this.xSd = new FinderRetransmitSourceContract.c((MMActivity)localObject1, (FinderRetransmitSourceContract.a)localObject2);
    localObject1 = this.xcW;
    if (localObject1 == null) {
      p.bGy("targetUsername");
    }
    long l = this.refObjectId;
    localObject2 = this.refObjectNonceId;
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = com.tencent.mm.plugin.finder.feed.model.internal.g.xKx;
    com.tencent.mm.ui.component.g localg1 = com.tencent.mm.ui.component.g.Xox;
    this.xSe = new FinderRetransmitSourceContract.Loader((String)localObject1, l, (String)localObject2, localg, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).ekY());
    localObject1 = (Context)getContext();
    localObject2 = this.xNf;
    if (localObject2 == null) {
      p.bGy("targetNickname");
    }
    setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)localObject2));
    AppMethodBeat.o(166232);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI
 * JD-Core Version:    0.7.0.1
 */