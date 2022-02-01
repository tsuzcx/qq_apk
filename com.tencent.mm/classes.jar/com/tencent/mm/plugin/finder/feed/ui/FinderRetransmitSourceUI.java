package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.a;
import com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.c;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRetransmitSourceUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "()V", "feedLoader", "presenter", "refObjectId", "", "refObjectNonceId", "", "targetNickname", "targetUsername", "viewCallback", "getLayoutId", "", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRetransmitSourceUI
  extends FinderLoaderFeedUI<FinderRetransmitSourceContract.Loader, FinderRetransmitSourceContract.c, FinderRetransmitSourceContract.a>
{
  private String ACm;
  private String Bnf;
  private FinderRetransmitSourceContract.Loader BrA;
  private FinderRetransmitSourceContract.a Bry;
  private FinderRetransmitSourceContract.c Brz;
  private long refObjectId;
  private String refObjectNonceId = "";
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_retransmitsource_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(166232);
    Object localObject1 = getIntent().getStringExtra("KEY_TARGET_USERNAME");
    s.checkNotNull(localObject1);
    s.s(localObject1, "intent.getStringExtra(Co…UI.KEY_TARGET_USERNAME)!!");
    this.ACm = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("KEY_TARGET_NICKNAME");
    s.checkNotNull(localObject1);
    s.s(localObject1, "intent.getStringExtra(Co…UI.KEY_TARGET_NICKNAME)!!");
    this.Bnf = ((String)localObject1);
    this.refObjectId = getIntent().getLongExtra("KEY_REF_OBJ_ID", 0L);
    localObject1 = getIntent().getStringExtra("KEY_REF_OBJ_NONCE_ID");
    s.checkNotNull(localObject1);
    s.s(localObject1, "intent.getStringExtra(Co…I.KEY_REF_OBJ_NONCE_ID)!!");
    this.refObjectNonceId = ((String)localObject1);
    Object localObject2 = this.ACm;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("targetUsername");
      localObject1 = null;
    }
    if ((Util.isNullOrNil((String)localObject1)) || (this.refObjectId == 0L)) {
      finish();
    }
    this.Bry = new FinderRetransmitSourceContract.a((MMActivity)this);
    Object localObject3 = (MMActivity)this;
    localObject2 = this.Bry;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("presenter");
      localObject1 = null;
    }
    this.Brz = new FinderRetransmitSourceContract.c((MMActivity)localObject3, (FinderRetransmitSourceContract.a)localObject1);
    localObject2 = this.ACm;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("targetUsername");
      localObject1 = null;
    }
    long l = this.refObjectId;
    localObject2 = this.refObjectNonceId;
    localObject3 = g.Bkm;
    k localk = k.aeZF;
    this.BrA = new FinderRetransmitSourceContract.Loader((String)localObject1, l, (String)localObject2, (g)localObject3, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
    localObject3 = (Context)getContext();
    localObject2 = this.Bnf;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("targetNickname");
      localObject1 = null;
    }
    setMMTitle((CharSequence)p.b((Context)localObject3, (CharSequence)localObject1));
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