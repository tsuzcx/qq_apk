package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.h.a;
import com.tencent.mm.plugin.finder.feed.h.b;
import com.tencent.mm.plugin.finder.feed.h.g;
import com.tencent.mm.plugin.finder.feed.model.internal.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRetransmitSourceUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "()V", "feedLoader", "presenter", "refObjectId", "", "refObjectNonceId", "", "targetNickname", "targetUsername", "viewCallback", "getLayoutId", "", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRetransmitSourceUI
  extends FinderLoaderFeedUI<h.a, h.g, h.b>
{
  private HashMap _$_findViewCache;
  private h.b qBl;
  private h.g qBm;
  private h.a qBn;
  private String qBo;
  private String qwI;
  private long refObjectId;
  private String refObjectNonceId = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198556);
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
    AppMethodBeat.o(198556);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494101;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(166232);
    Object localObject1 = getIntent().getStringExtra("KEY_TARGET_USERNAME");
    d.g.b.k.g(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_USERNAME)");
    this.qwI = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("KEY_TARGET_NICKNAME");
    d.g.b.k.g(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_NICKNAME)");
    this.qBo = ((String)localObject1);
    this.refObjectId = getIntent().getLongExtra("KEY_REF_OBJ_ID", 0L);
    localObject1 = getIntent().getStringExtra("KEY_REF_OBJ_NONCE_ID");
    d.g.b.k.g(localObject1, "intent.getStringExtra(Co…eUI.KEY_REF_OBJ_NONCE_ID)");
    this.refObjectNonceId = ((String)localObject1);
    localObject1 = this.qwI;
    if (localObject1 == null) {
      d.g.b.k.aPZ("targetUsername");
    }
    if ((bt.isNullOrNil((String)localObject1)) || (this.refObjectId == 0L)) {
      finish();
    }
    this.qBl = new h.b((MMActivity)this);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.qBl;
    if (localObject2 == null) {
      d.g.b.k.aPZ("presenter");
    }
    this.qBm = new h.g((MMActivity)localObject1, (h.b)localObject2);
    localObject1 = this.qwI;
    if (localObject1 == null) {
      d.g.b.k.aPZ("targetUsername");
    }
    long l = this.refObjectId;
    localObject2 = this.refObjectNonceId;
    b localb = b.KQH;
    a locala = a.LCX;
    this.qBn = new h.a((String)localObject1, l, (String)localObject2, localb, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
    localObject1 = (Context)getContext();
    localObject2 = this.qBo;
    if (localObject2 == null) {
      d.g.b.k.aPZ("targetNickname");
    }
    setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject1, (CharSequence)localObject2));
    AppMethodBeat.o(166232);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI
 * JD-Core Version:    0.7.0.1
 */