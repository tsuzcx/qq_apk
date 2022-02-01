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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.a;
import com.tencent.mm.view.g;

public final class c
  extends y
{
  private a cDW;
  private u cDX;
  
  public final boolean Iu()
  {
    AppMethodBeat.i(9100);
    boolean bool = this.cDW.getPresenter().Iu();
    AppMethodBeat.o(9100);
    return bool;
  }
  
  public final u Iv()
  {
    AppMethodBeat.i(9103);
    if (this.cDX == null) {
      this.cDX = new com.tencent.mm.ca.c(this.cDW.getPresenter());
    }
    u localu = this.cDX;
    AppMethodBeat.o(9103);
    return localu;
  }
  
  public final void Iw()
  {
    AppMethodBeat.i(9104);
    ArtistCacheManager.Vm().Vn();
    AppMethodBeat.o(9104);
  }
  
  public final void a(s params)
  {
    AppMethodBeat.i(9099);
    b localb = this.cDW.getPresenter();
    if (!Iv().JK()) {}
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
    ArtistCacheManager.Vm().rP(bs.bG(this.cGH.path, "MicroMsg.MMPhotoEditorImpl"));
    com.tencent.mm.cache.c.Vr().rR(bs.bG(this.cGH.path, "MicroMsg.MMPhotoEditorImpl"));
    AppMethodBeat.o(9101);
  }
  
  public final com.tencent.mm.api.e bg(Context paramContext)
  {
    AppMethodBeat.i(9098);
    if (this.cDW == null)
    {
      ac.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
      if (this.cGH.cGJ == y.c.cGP) {
        this.cDW = new g(paramContext);
      }
    }
    for (;;)
    {
      this.cDW.setup(this.cGH);
      paramContext = this.cDW;
      AppMethodBeat.o(9098);
      return paramContext;
      if (this.cGH.cGJ == y.c.cGQ)
      {
        this.cDW = new com.tencent.mm.view.e(paramContext);
        continue;
        ac.d("MicroMsg.MMPhotoEditorImpl", "recycled");
        if (this.cDW.getParent() != null) {
          ((ViewGroup)this.cDW.getParent()).removeView(this.cDW);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9102);
    if ((this.cGH != null) && (!this.cGH.cGK)) {
      ArtistCacheManager.Vm().rQ(bs.bG(this.cGH.path, "MicroMsg.MMPhotoEditorImpl"));
    }
    if (this.cDW != null) {
      this.cDW.getPresenter().onDestroy();
    }
    try
    {
      this.cDW.getChatFooterPanel().destroy();
      AppMethodBeat.o(9102);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
      AppMethodBeat.o(9102);
    }
  }
  
  public static final class a
    implements y.b
  {
    public final y Ix()
    {
      AppMethodBeat.i(9097);
      c localc = new c();
      AppMethodBeat.o(9097);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.c
 * JD-Core Version:    0.7.0.1
 */