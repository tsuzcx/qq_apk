package com.tencent.mm;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s;
import com.tencent.mm.api.u;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.a;
import com.tencent.mm.api.y.b;
import com.tencent.mm.api.y.c;
import com.tencent.mm.bu.b;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.a;
import com.tencent.mm.view.g;

public final class c
  extends y
{
  private a cGO;
  private u cGP;
  
  public final boolean IL()
  {
    AppMethodBeat.i(9100);
    boolean bool = this.cGO.getPresenter().IL();
    AppMethodBeat.o(9100);
    return bool;
  }
  
  public final u IM()
  {
    AppMethodBeat.i(9103);
    if (this.cGP == null) {
      this.cGP = new com.tencent.mm.cb.c(this.cGO.getPresenter());
    }
    u localu = this.cGP;
    AppMethodBeat.o(9103);
    return localu;
  }
  
  public final void IN()
  {
    AppMethodBeat.i(9104);
    ArtistCacheManager.Ur().Us();
    AppMethodBeat.o(9104);
  }
  
  public final void a(s params)
  {
    AppMethodBeat.i(9099);
    b localb = this.cGO.getPresenter();
    if (!IM().Ka()) {}
    for (boolean bool = true;; bool = false)
    {
      localb.a(params, bool);
      AppMethodBeat.o(9099);
      return;
    }
  }
  
  public final void a(y.a parama)
  {
    AppMethodBeat.i(9101);
    super.a(parama);
    ArtistCacheManager.Ur().aTR(bt.by(this.cJA.path, "MicroMsg.MMPhotoEditorImpl"));
    com.tencent.mm.cache.c.Uw().aTT(bt.by(this.cJA.path, "MicroMsg.MMPhotoEditorImpl"));
    AppMethodBeat.o(9101);
  }
  
  public final com.tencent.mm.api.e bf(Context paramContext)
  {
    AppMethodBeat.i(9098);
    if (this.cGO == null)
    {
      ad.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
      if (this.cJA.cJC == y.c.cJI) {
        this.cGO = new g(paramContext);
      }
    }
    for (;;)
    {
      this.cGO.setup(this.cJA);
      paramContext = this.cGO;
      AppMethodBeat.o(9098);
      return paramContext;
      if (this.cJA.cJC == y.c.cJJ)
      {
        this.cGO = new com.tencent.mm.view.e(paramContext);
        continue;
        ad.d("MicroMsg.MMPhotoEditorImpl", "recycled");
        if (this.cGO.getParent() != null) {
          ((ViewGroup)this.cGO.getParent()).removeView(this.cGO);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9102);
    if ((this.cJA != null) && (!this.cJA.cJD)) {
      ArtistCacheManager.Ur().aTS(bt.by(this.cJA.path, "MicroMsg.MMPhotoEditorImpl"));
    }
    if (this.cGO != null) {
      this.cGO.getPresenter().onDestroy();
    }
    try
    {
      this.cGO.getChatFooterPanel().destroy();
      AppMethodBeat.o(9102);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
      AppMethodBeat.o(9102);
    }
  }
  
  public static final class a
    implements y.b
  {
    public final y IO()
    {
      AppMethodBeat.i(9097);
      c localc = new c();
      AppMethodBeat.o(9097);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.c
 * JD-Core Version:    0.7.0.1
 */