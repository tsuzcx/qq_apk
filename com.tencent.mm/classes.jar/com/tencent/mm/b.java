package com.tencent.mm;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.e;
import com.tencent.mm.api.u;
import com.tencent.mm.api.x;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.a;
import com.tencent.mm.view.l;
import com.tencent.mm.view.m;
import com.tencent.mm.view.o;

public final class b
  extends ab
{
  private a dgg;
  private x dgh;
  
  public final boolean Ul()
  {
    AppMethodBeat.i(9100);
    boolean bool = this.dgg.getPresenter().Ul();
    AppMethodBeat.o(9100);
    return bool;
  }
  
  public final x Um()
  {
    AppMethodBeat.i(9103);
    if (this.dgh == null) {
      this.dgh = new com.tencent.mm.bz.c(this.dgg.getPresenter());
    }
    x localx = this.dgh;
    AppMethodBeat.o(9103);
    return localx;
  }
  
  public final void Un()
  {
    AppMethodBeat.i(9104);
    ArtistCacheManager.alA().alB();
    AppMethodBeat.o(9104);
  }
  
  public final void a(ab.a parama)
  {
    AppMethodBeat.i(9101);
    super.a(parama);
    ArtistCacheManager.alA().Dn(Util.nullAs(this.diP.path, "MicroMsg.MMPhotoEditorImpl"));
    com.tencent.mm.cache.c.alF().Dp(Util.nullAs(this.diP.path, "MicroMsg.MMPhotoEditorImpl"));
    AppMethodBeat.o(9101);
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(9099);
    com.tencent.mm.bt.b localb = this.dgg.getPresenter();
    if (!Um().VE()) {}
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramu, bool);
      AppMethodBeat.o(9099);
      return;
    }
  }
  
  public final e bB(Context paramContext)
  {
    AppMethodBeat.i(9098);
    if (this.dgg == null)
    {
      Log.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
      if (this.diP.diR == ab.c.diY) {
        this.dgg = new o(paramContext);
      }
    }
    for (;;)
    {
      this.dgg.setup(this.diP);
      paramContext = this.dgg;
      AppMethodBeat.o(9098);
      return paramContext;
      if (this.diP.diR == ab.c.diZ)
      {
        this.dgg = new m(paramContext);
      }
      else if (this.diP.diR == ab.c.dja)
      {
        this.dgg = new l(paramContext);
        continue;
        Log.d("MicroMsg.MMPhotoEditorImpl", "recycled");
        if (this.dgg.getParent() != null) {
          ((ViewGroup)this.dgg.getParent()).removeView(this.dgg);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9102);
    if ((this.diP != null) && (!this.diP.diS)) {
      ArtistCacheManager.alA().Do(Util.nullAs(this.diP.path, "MicroMsg.MMPhotoEditorImpl"));
    }
    if (this.dgg != null) {
      this.dgg.getPresenter().onDestroy();
    }
    try
    {
      this.dgg.getChatFooterPanel().destroy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.b
 * JD-Core Version:    0.7.0.1
 */