package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.w.a;
import com.tencent.mm.plugin.finder.feed.w.b;
import com.tencent.mm.plugin.finder.feed.w.g;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRetransmitSourceUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "()V", "feedLoader", "presenter", "refObjectId", "", "refObjectNonceId", "", "targetNickname", "targetUsername", "viewCallback", "getLayoutId", "", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRetransmitSourceUI
  extends FinderLoaderFeedUI<w.a, w.g, w.b>
{
  private HashMap _$_findViewCache;
  private String qYd;
  private long refObjectId;
  private String refObjectNonceId = "";
  private String rpN;
  private w.b rsg;
  private w.g rsh;
  private w.a rsi;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202477);
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
    AppMethodBeat.o(202477);
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
    this.qYd = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("KEY_TARGET_NICKNAME");
    d.g.b.k.g(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_NICKNAME)");
    this.rpN = ((String)localObject1);
    this.refObjectId = getIntent().getLongExtra("KEY_REF_OBJ_ID", 0L);
    localObject1 = getIntent().getStringExtra("KEY_REF_OBJ_NONCE_ID");
    d.g.b.k.g(localObject1, "intent.getStringExtra(Co…eUI.KEY_REF_OBJ_NONCE_ID)");
    this.refObjectNonceId = ((String)localObject1);
    localObject1 = this.qYd;
    if (localObject1 == null) {
      d.g.b.k.aVY("targetUsername");
    }
    if ((bs.isNullOrNil((String)localObject1)) || (this.refObjectId == 0L)) {
      finish();
    }
    this.rsg = new w.b((MMActivity)this);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.rsg;
    if (localObject2 == null) {
      d.g.b.k.aVY("presenter");
    }
    this.rsh = new w.g((MMActivity)localObject1, (w.b)localObject2);
    localObject1 = this.qYd;
    if (localObject1 == null) {
      d.g.b.k.aVY("targetUsername");
    }
    long l = this.refObjectId;
    localObject2 = this.refObjectNonceId;
    c localc = c.rog;
    a locala = a.IrY;
    this.rsi = new w.a((String)localObject1, l, (String)localObject2, localc, ((FinderReporterUIC)a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
    localObject1 = (Context)getContext();
    localObject2 = this.rpN;
    if (localObject2 == null) {
      d.g.b.k.aVY("targetNickname");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI
 * JD-Core Version:    0.7.0.1
 */