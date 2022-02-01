package com.tencent.mm;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.f;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.a;
import com.tencent.mm.view.l;
import com.tencent.mm.view.m;
import com.tencent.mm.view.n;

public final class b
  extends ac
{
  private a fjn;
  private y fjo;
  
  public final void a(ac.a parama)
  {
    AppMethodBeat.i(9101);
    super.a(parama);
    ArtistCacheManager.aLv().CK(Util.nullAs(this.hdX.path, "MicroMsg.MMPhotoEditorImpl"));
    com.tencent.mm.cache.c.aLA().CM(Util.nullAs(this.hdX.path, "MicroMsg.MMPhotoEditorImpl"));
    AppMethodBeat.o(9101);
  }
  
  public final void a(w paramw)
  {
    AppMethodBeat.i(9099);
    com.tencent.mm.bt.b localb = this.fjn.getPresenter();
    if (!aAy().aBF()) {}
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramw, bool);
      AppMethodBeat.o(9099);
      return;
    }
  }
  
  public final boolean aAx()
  {
    AppMethodBeat.i(9100);
    boolean bool = this.fjn.getPresenter().aAx();
    AppMethodBeat.o(9100);
    return bool;
  }
  
  public final y aAy()
  {
    AppMethodBeat.i(9103);
    if (this.fjo == null) {
      this.fjo = new com.tencent.mm.cb.c(this.fjn.getPresenter());
    }
    y localy = this.fjo;
    AppMethodBeat.o(9103);
    return localy;
  }
  
  public final void aAz()
  {
    AppMethodBeat.i(9104);
    ArtistCacheManager.aLv().aLw();
    AppMethodBeat.o(9104);
  }
  
  public final f cn(Context paramContext)
  {
    AppMethodBeat.i(9098);
    if (this.fjn == null)
    {
      Log.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
      if (this.hdX.hdZ == ac.c.hef) {
        this.fjn = new n(paramContext);
      }
    }
    for (;;)
    {
      this.fjn.setup(this.hdX);
      paramContext = this.fjn;
      AppMethodBeat.o(9098);
      return paramContext;
      if (this.hdX.hdZ == ac.c.heg)
      {
        this.fjn = new m(paramContext);
      }
      else if (this.hdX.hdZ == ac.c.heh)
      {
        this.fjn = new l(paramContext);
        continue;
        Log.d("MicroMsg.MMPhotoEditorImpl", "recycled");
        if (this.fjn.getParent() != null) {
          ((ViewGroup)this.fjn.getParent()).removeView(this.fjn);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9102);
    if ((this.hdX != null) && (!this.hdX.hea)) {
      ArtistCacheManager.aLv().CL(Util.nullAs(this.hdX.path, "MicroMsg.MMPhotoEditorImpl"));
    }
    if (this.fjn != null) {
      this.fjn.getPresenter().onDestroy();
    }
    try
    {
      this.fjn.getChatFooterPanel().destroy();
      AppMethodBeat.o(9102);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
      AppMethodBeat.o(9102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.b
 * JD-Core Version:    0.7.0.1
 */