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
import com.tencent.mm.bt.b;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.view.a;
import com.tencent.mm.view.g;

public final class c
  extends y
{
  private a cPL;
  private u cPM;
  
  public final boolean Kc()
  {
    AppMethodBeat.i(9100);
    boolean bool = this.cPL.getPresenter().Kc();
    AppMethodBeat.o(9100);
    return bool;
  }
  
  public final u Kd()
  {
    AppMethodBeat.i(9103);
    if (this.cPM == null) {
      this.cPM = new com.tencent.mm.bz.c(this.cPL.getPresenter());
    }
    u localu = this.cPM;
    AppMethodBeat.o(9103);
    return localu;
  }
  
  public final void Ke()
  {
    AppMethodBeat.i(9104);
    ArtistCacheManager.XN().XO();
    AppMethodBeat.o(9104);
  }
  
  public final void a(s params)
  {
    AppMethodBeat.i(9099);
    b localb = this.cPL.getPresenter();
    if (!Kd().Lr()) {}
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
    ArtistCacheManager.XN().uX(bu.bI(this.cSv.path, "MicroMsg.MMPhotoEditorImpl"));
    com.tencent.mm.cache.c.XS().uZ(bu.bI(this.cSv.path, "MicroMsg.MMPhotoEditorImpl"));
    AppMethodBeat.o(9101);
  }
  
  public final com.tencent.mm.api.e bh(Context paramContext)
  {
    AppMethodBeat.i(9098);
    if (this.cPL == null)
    {
      ae.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
      if (this.cSv.cSx == y.c.cSD) {
        this.cPL = new g(paramContext);
      }
    }
    for (;;)
    {
      this.cPL.setup(this.cSv);
      paramContext = this.cPL;
      AppMethodBeat.o(9098);
      return paramContext;
      if (this.cSv.cSx == y.c.cSE)
      {
        this.cPL = new com.tencent.mm.view.e(paramContext);
        continue;
        ae.d("MicroMsg.MMPhotoEditorImpl", "recycled");
        if (this.cPL.getParent() != null) {
          ((ViewGroup)this.cPL.getParent()).removeView(this.cPL);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9102);
    if ((this.cSv != null) && (!this.cSv.cSy)) {
      ArtistCacheManager.XN().uY(bu.bI(this.cSv.path, "MicroMsg.MMPhotoEditorImpl"));
    }
    if (this.cPL != null) {
      this.cPL.getPresenter().onDestroy();
    }
    try
    {
      this.cPL.getChatFooterPanel().destroy();
      AppMethodBeat.o(9102);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
      AppMethodBeat.o(9102);
    }
  }
  
  public static final class a
    implements y.b
  {
    public final y Kf()
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