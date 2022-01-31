package com.tencent.mm;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.api.p;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.a;
import com.tencent.mm.api.s.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.ArtistCacheManager.1;
import com.tencent.mm.cache.ArtistCacheManager.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Stack;

public final class a
  extends s
{
  private com.tencent.mm.view.a bUZ;
  private p bVa;
  
  public final void Aa()
  {
    AppMethodBeat.i(116134);
    ArtistCacheManager.Jb().Jc();
    AppMethodBeat.o(116134);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(116129);
    com.tencent.mm.bs.b localb = this.bUZ.getPresenter();
    if (!zZ().At()) {}
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramn, bool);
      AppMethodBeat.o(116129);
      return;
    }
  }
  
  public final void a(s.a parama)
  {
    AppMethodBeat.i(116131);
    super.a(parama);
    parama = ArtistCacheManager.Jb();
    String str = bo.bf(this.bWd.path, "MicroMsg.MMPhotoEditorImpl");
    parama.ecm = str;
    if (!ArtistCacheManager.eck.containsKey(str)) {
      ArtistCacheManager.eck.put(str, new ArtistCacheManager.a(parama));
    }
    parama = com.tencent.mm.cache.c.Jg();
    str = bo.bf(this.bWd.path, "MicroMsg.MMPhotoEditorImpl");
    if (parama.bSA.containsKey(str)) {
      parama.ecu = ((Stack)parama.bSA.get(str));
    }
    AppMethodBeat.o(116131);
  }
  
  public final com.tencent.mm.api.c aV(Context paramContext)
  {
    AppMethodBeat.i(116128);
    if (this.bUZ == null)
    {
      if (this.bWd.bWf != s.c.bWl) {
        break label53;
      }
      this.bUZ = new com.tencent.mm.view.d(paramContext, this.bWd);
    }
    for (;;)
    {
      paramContext = this.bUZ;
      AppMethodBeat.o(116128);
      return paramContext;
      label53:
      if (this.bWd.bWf == s.c.bWm) {
        this.bUZ = new com.tencent.mm.view.b(paramContext, this.bWd);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116132);
    if (!this.bWd.bWg)
    {
      ArtistCacheManager localArtistCacheManager = ArtistCacheManager.Jb();
      String str = bo.bf(this.bWd.path, "MicroMsg.MMPhotoEditorImpl");
      localArtistCacheManager.ecm = null;
      if (ArtistCacheManager.eck.containsKey(str))
      {
        ((ArtistCacheManager.a)ArtistCacheManager.eck.get(str)).clearAll();
        ArtistCacheManager.eck.remove(str);
      }
      com.tencent.mm.sdk.g.d.post(new ArtistCacheManager.1(localArtistCacheManager), "MicroMsg.ArtistCacheManager[clearAllCache]");
    }
    if (this.bUZ != null) {
      this.bUZ.getPresenter().onDestroy();
    }
    try
    {
      this.bUZ.getChatFooterPanel().destroy();
      AppMethodBeat.o(116132);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
      AppMethodBeat.o(116132);
    }
  }
  
  public final boolean zY()
  {
    AppMethodBeat.i(116130);
    boolean bool = this.bUZ.getPresenter().zY();
    AppMethodBeat.o(116130);
    return bool;
  }
  
  public final p zZ()
  {
    AppMethodBeat.i(116133);
    if (this.bVa == null) {
      this.bVa = new com.tencent.mm.bz.c(this.bUZ.getPresenter());
    }
    p localp = this.bVa;
    AppMethodBeat.o(116133);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.a
 * JD-Core Version:    0.7.0.1
 */