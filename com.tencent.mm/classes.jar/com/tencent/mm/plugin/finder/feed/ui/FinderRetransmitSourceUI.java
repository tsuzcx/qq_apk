package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.a;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.c;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRetransmitSourceUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "()V", "feedLoader", "presenter", "refObjectId", "", "refObjectNonceId", "", "targetNickname", "targetUsername", "viewCallback", "getLayoutId", "", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRetransmitSourceUI
  extends FinderLoaderFeedUI<FinderRetransmitSourceContract.Loader, FinderRetransmitSourceContract.c, FinderRetransmitSourceContract.a>
{
  private HashMap _$_findViewCache;
  private String rJp;
  private long refObjectId;
  private String refObjectNonceId = "";
  private String seC;
  private FinderRetransmitSourceContract.a sho;
  private FinderRetransmitSourceContract.c shp;
  private FinderRetransmitSourceContract.Loader shq;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202858);
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
    AppMethodBeat.o(202858);
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
    p.g(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_USERNAME)");
    this.rJp = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("KEY_TARGET_NICKNAME");
    p.g(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_NICKNAME)");
    this.seC = ((String)localObject1);
    this.refObjectId = getIntent().getLongExtra("KEY_REF_OBJ_ID", 0L);
    localObject1 = getIntent().getStringExtra("KEY_REF_OBJ_NONCE_ID");
    p.g(localObject1, "intent.getStringExtra(Co…eUI.KEY_REF_OBJ_NONCE_ID)");
    this.refObjectNonceId = ((String)localObject1);
    localObject1 = this.rJp;
    if (localObject1 == null) {
      p.bcb("targetUsername");
    }
    if ((bt.isNullOrNil((String)localObject1)) || (this.refObjectId == 0L)) {
      finish();
    }
    this.sho = new FinderRetransmitSourceContract.a((MMActivity)this);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.sho;
    if (localObject2 == null) {
      p.bcb("presenter");
    }
    this.shp = new FinderRetransmitSourceContract.c((MMActivity)localObject1, (FinderRetransmitSourceContract.a)localObject2);
    localObject1 = this.rJp;
    if (localObject1 == null) {
      p.bcb("targetUsername");
    }
    long l = this.refObjectId;
    localObject2 = this.refObjectNonceId;
    e locale = e.scO;
    a locala = a.KiD;
    this.shq = new FinderRetransmitSourceContract.Loader((String)localObject1, l, (String)localObject2, locale, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
    localObject1 = (Context)getContext();
    localObject2 = this.seC;
    if (localObject2 == null) {
      p.bcb("targetNickname");
    }
    setMMTitle((CharSequence)k.c((Context)localObject1, (CharSequence)localObject2));
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