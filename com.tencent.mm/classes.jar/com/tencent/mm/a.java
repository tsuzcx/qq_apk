package com.tencent.mm;

import android.content.Context;
import com.tencent.mm.api.m;
import com.tencent.mm.api.n;
import com.tencent.mm.api.q;
import com.tencent.mm.api.q.a;
import com.tencent.mm.api.q.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.ArtistCacheManager.1;
import com.tencent.mm.cache.ArtistCacheManager.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.view.c;
import java.util.HashMap;

public final class a
  extends q
{
  private com.tencent.mm.view.a btP;
  private n btQ;
  
  public final void a(m paramm)
  {
    com.tencent.mm.bt.b localb = this.btP.getPresenter();
    if (!rH().sg()) {}
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramm, bool);
      return;
    }
  }
  
  public final void a(q.a parama)
  {
    super.a(parama);
    parama = ArtistCacheManager.wL();
    String str = bk.aM(this.buT.path, "MicroMsg.MMPhotoEditorImpl");
    parama.dkS = str;
    if (!ArtistCacheManager.dkQ.containsKey(str)) {
      ArtistCacheManager.dkQ.put(str, new ArtistCacheManager.a(parama));
    }
  }
  
  public final com.tencent.mm.api.b ax(Context paramContext)
  {
    if (this.btP == null)
    {
      if (this.buT.buV != q.c.bva) {
        break label41;
      }
      this.btP = new c(paramContext, this.buT);
    }
    for (;;)
    {
      return this.btP;
      label41:
      if (this.buT.buV == q.c.bvb) {
        this.btP = new com.tencent.mm.view.b(paramContext, this.buT);
      }
    }
  }
  
  public final void onDestroy()
  {
    if (!this.buT.buW)
    {
      ArtistCacheManager localArtistCacheManager = ArtistCacheManager.wL();
      String str = bk.aM(this.buT.path, "MicroMsg.MMPhotoEditorImpl");
      localArtistCacheManager.dkS = null;
      if (ArtistCacheManager.dkQ.containsKey(str))
      {
        ((ArtistCacheManager.a)ArtistCacheManager.dkQ.get(str)).clearAll();
        ArtistCacheManager.dkQ.remove(str);
      }
      e.csu();
      e.post(new ArtistCacheManager.1(localArtistCacheManager), "MicroMsg.ArtistCacheManager[clearAllCache]");
    }
    if (this.btP != null) {
      this.btP.getPresenter().onDestroy();
    }
    try
    {
      this.btP.getChatFooterPanel().destroy();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
    }
  }
  
  public final boolean rG()
  {
    return this.btP.getPresenter().rG();
  }
  
  public final n rH()
  {
    if (this.btQ == null) {
      this.btQ = new com.tencent.mm.bz.a(this.btP.getPresenter());
    }
    return this.btQ;
  }
  
  public final void rI()
  {
    ArtistCacheManager.wL().wM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.a
 * JD-Core Version:    0.7.0.1
 */