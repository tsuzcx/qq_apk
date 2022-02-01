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
  private a cPb;
  private u cPc;
  
  public final boolean JU()
  {
    AppMethodBeat.i(9100);
    boolean bool = this.cPb.getPresenter().JU();
    AppMethodBeat.o(9100);
    return bool;
  }
  
  public final u JV()
  {
    AppMethodBeat.i(9103);
    if (this.cPc == null) {
      this.cPc = new com.tencent.mm.ca.c(this.cPb.getPresenter());
    }
    u localu = this.cPc;
    AppMethodBeat.o(9103);
    return localu;
  }
  
  public final void JW()
  {
    AppMethodBeat.i(9104);
    ArtistCacheManager.XD().XE();
    AppMethodBeat.o(9104);
  }
  
  public final void a(s params)
  {
    AppMethodBeat.i(9099);
    b localb = this.cPb.getPresenter();
    if (!JV().Lj()) {}
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
    ArtistCacheManager.XD().uC(bt.bI(this.cRL.path, "MicroMsg.MMPhotoEditorImpl"));
    com.tencent.mm.cache.c.XI().uE(bt.bI(this.cRL.path, "MicroMsg.MMPhotoEditorImpl"));
    AppMethodBeat.o(9101);
  }
  
  public final com.tencent.mm.api.e bg(Context paramContext)
  {
    AppMethodBeat.i(9098);
    if (this.cPb == null)
    {
      ad.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
      if (this.cRL.cRN == y.c.cRT) {
        this.cPb = new g(paramContext);
      }
    }
    for (;;)
    {
      this.cPb.setup(this.cRL);
      paramContext = this.cPb;
      AppMethodBeat.o(9098);
      return paramContext;
      if (this.cRL.cRN == y.c.cRU)
      {
        this.cPb = new com.tencent.mm.view.e(paramContext);
        continue;
        ad.d("MicroMsg.MMPhotoEditorImpl", "recycled");
        if (this.cPb.getParent() != null) {
          ((ViewGroup)this.cPb.getParent()).removeView(this.cPb);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9102);
    if ((this.cRL != null) && (!this.cRL.cRO)) {
      ArtistCacheManager.XD().uD(bt.bI(this.cRL.path, "MicroMsg.MMPhotoEditorImpl"));
    }
    if (this.cPb != null) {
      this.cPb.getPresenter().onDestroy();
    }
    try
    {
      this.cPb.getChatFooterPanel().destroy();
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
    public final y JX()
    {
      AppMethodBeat.i(9097);
      c localc = new c();
      AppMethodBeat.o(9097);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.c
 * JD-Core Version:    0.7.0.1
 */