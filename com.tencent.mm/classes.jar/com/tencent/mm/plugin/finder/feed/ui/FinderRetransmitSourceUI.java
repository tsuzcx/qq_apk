package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.a;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.c;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRetransmitSourceUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "()V", "feedLoader", "presenter", "refObjectId", "", "refObjectNonceId", "", "targetNickname", "targetUsername", "viewCallback", "getLayoutId", "", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRetransmitSourceUI
  extends FinderLoaderFeedUI<FinderRetransmitSourceContract.Loader, FinderRetransmitSourceContract.c, FinderRetransmitSourceContract.a>
{
  private HashMap _$_findViewCache;
  private long refObjectId;
  private String refObjectNonceId = "";
  private String tvp;
  private String uaD;
  private FinderRetransmitSourceContract.a ucM;
  private FinderRetransmitSourceContract.c ucN;
  private FinderRetransmitSourceContract.Loader ucO;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245517);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245517);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245516);
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
    AppMethodBeat.o(245516);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494608;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(166232);
    Object localObject1 = getIntent().getStringExtra("KEY_TARGET_USERNAME");
    p.g(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_USERNAME)");
    this.tvp = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("KEY_TARGET_NICKNAME");
    p.g(localObject1, "intent.getStringExtra(Co…ceUI.KEY_TARGET_NICKNAME)");
    this.uaD = ((String)localObject1);
    this.refObjectId = getIntent().getLongExtra("KEY_REF_OBJ_ID", 0L);
    localObject1 = getIntent().getStringExtra("KEY_REF_OBJ_NONCE_ID");
    p.g(localObject1, "intent.getStringExtra(Co…eUI.KEY_REF_OBJ_NONCE_ID)");
    this.refObjectNonceId = ((String)localObject1);
    localObject1 = this.tvp;
    if (localObject1 == null) {
      p.btv("targetUsername");
    }
    if ((Util.isNullOrNil((String)localObject1)) || (this.refObjectId == 0L)) {
      finish();
    }
    this.ucM = new FinderRetransmitSourceContract.a((MMActivity)this);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.ucM;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    this.ucN = new FinderRetransmitSourceContract.c((MMActivity)localObject1, (FinderRetransmitSourceContract.a)localObject2);
    localObject1 = this.tvp;
    if (localObject1 == null) {
      p.btv("targetUsername");
    }
    long l = this.refObjectId;
    localObject2 = this.refObjectNonceId;
    e locale = e.tYt;
    a locala = a.PRN;
    this.ucO = new FinderRetransmitSourceContract.Loader((String)localObject1, l, (String)localObject2, locale, ((FinderReporterUIC)a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
    localObject1 = (Context)getContext();
    localObject2 = this.uaD;
    if (localObject2 == null) {
      p.btv("targetNickname");
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