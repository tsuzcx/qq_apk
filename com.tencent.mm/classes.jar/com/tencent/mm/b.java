package com.tencent.mm;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a;
import com.tencent.mm.api.ab.b;
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
  private a djs;
  private x djt;
  
  public final boolean YD()
  {
    AppMethodBeat.i(9100);
    boolean bool = this.djs.getPresenter().YD();
    AppMethodBeat.o(9100);
    return bool;
  }
  
  public final x YE()
  {
    AppMethodBeat.i(9103);
    if (this.djt == null) {
      this.djt = new com.tencent.mm.cg.c(this.djs.getPresenter());
    }
    x localx = this.djt;
    AppMethodBeat.o(9103);
    return localx;
  }
  
  public final void YF()
  {
    AppMethodBeat.i(9104);
    ArtistCacheManager.arz().arA();
    AppMethodBeat.o(9104);
  }
  
  public final void a(ab.a parama)
  {
    AppMethodBeat.i(9101);
    super.a(parama);
    ArtistCacheManager.arz().Ke(Util.nullAs(this.faw.path, "MicroMsg.MMPhotoEditorImpl"));
    com.tencent.mm.cache.c.arE().Kg(Util.nullAs(this.faw.path, "MicroMsg.MMPhotoEditorImpl"));
    AppMethodBeat.o(9101);
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(9099);
    com.tencent.mm.ca.b localb = this.djs.getPresenter();
    if (!YE().ZZ()) {}
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramu, bool);
      AppMethodBeat.o(9099);
      return;
    }
  }
  
  public final e bA(Context paramContext)
  {
    AppMethodBeat.i(9098);
    if (this.djs == null)
    {
      Log.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
      if (this.faw.fay == ab.c.faF) {
        this.djs = new o(paramContext);
      }
    }
    for (;;)
    {
      this.djs.setup(this.faw);
      paramContext = this.djs;
      AppMethodBeat.o(9098);
      return paramContext;
      if (this.faw.fay == ab.c.faG)
      {
        this.djs = new m(paramContext);
      }
      else if (this.faw.fay == ab.c.faH)
      {
        this.djs = new l(paramContext);
        continue;
        Log.d("MicroMsg.MMPhotoEditorImpl", "recycled");
        if (this.djs.getParent() != null) {
          ((ViewGroup)this.djs.getParent()).removeView(this.djs);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9102);
    if ((this.faw != null) && (!this.faw.faz)) {
      ArtistCacheManager.arz().Kf(Util.nullAs(this.faw.path, "MicroMsg.MMPhotoEditorImpl"));
    }
    if (this.djs != null) {
      this.djs.getPresenter().onDestroy();
    }
    try
    {
      this.djs.getChatFooterPanel().destroy();
      AppMethodBeat.o(9102);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
      AppMethodBeat.o(9102);
    }
  }
  
  public static final class a
    implements ab.b
  {
    public final ab YG()
    {
      AppMethodBeat.i(9097);
      b localb = new b();
      AppMethodBeat.o(9097);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.b
 * JD-Core Version:    0.7.0.1
 */