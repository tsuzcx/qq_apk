package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class j
  implements a
{
  int h;
  HashMap<Long, Integer> oaA;
  HashSet<Long> oaB;
  HashMap<Long, WeakReference<ImageView>> oav;
  HashMap<Long, bi.b> oaw;
  HashMap<Long, WeakReference<ProgressBar>> oax;
  HashMap<Long, WeakReference<ImageView>> oay;
  HashMap<bi.b, bi> oaz;
  int w;
  
  public j()
  {
    AppMethodBeat.i(113326);
    this.oav = new HashMap();
    this.oaw = new HashMap();
    this.oax = new HashMap();
    this.oay = new HashMap();
    this.oaz = new HashMap();
    this.oaA = new HashMap();
    this.oaB = new HashSet();
    this.w = 300;
    this.h = 300;
    start();
    AppMethodBeat.o(113326);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(113329);
    if (paramb == null)
    {
      AppMethodBeat.o(113329);
      return;
    }
    if (!this.oaw.containsKey(Long.valueOf(paramb.itemId)))
    {
      AppMethodBeat.o(113329);
      return;
    }
    paramb = (bi.b)this.oaw.get(Long.valueOf(paramb.itemId));
    paramb = (bi)this.oaz.remove(paramb);
    if (paramb == null)
    {
      AppMethodBeat.o(113329);
      return;
    }
    this.oav.get(Long.valueOf(paramb.field_msgId));
    if ((paramb != null) && ((paramb.dGX < 0) || (paramb.dGX > 5)))
    {
      paramb.ia(0);
      paramb.ia(paramb.dGX + 1);
      if (com.tencent.mm.kernel.g.RG())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(paramb.field_msgId, paramb);
        ab.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramb.dGX) });
      }
    }
    AppMethodBeat.o(113329);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(113328);
    if (paramb == null)
    {
      AppMethodBeat.o(113328);
      return;
    }
    if (!this.oaw.containsKey(Long.valueOf(paramb.itemId)))
    {
      AppMethodBeat.o(113328);
      return;
    }
    paramb = (bi.b)this.oaw.get(Long.valueOf(paramb.itemId));
    paramb = (bi)this.oaz.remove(paramb);
    if (paramb == null)
    {
      AppMethodBeat.o(113328);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.oav.get(Long.valueOf(paramb.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(113328);
      return;
    }
    if (!this.oaA.containsKey(Long.valueOf(paramb.field_msgId)))
    {
      AppMethodBeat.o(113328);
      return;
    }
    int i = ((Integer)this.oaA.remove(Long.valueOf(paramb.field_msgId))).intValue();
    if (paramb.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(o.ahC().a(paramb.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.oax.remove(Long.valueOf(paramb.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.oay.remove(Long.valueOf(paramb.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ImageView)paramString.get()).setVisibility(0);
      }
      AppMethodBeat.o(113328);
      return;
    }
  }
  
  final void start()
  {
    AppMethodBeat.i(113327);
    l.bLp().a(this);
    AppMethodBeat.o(113327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.j
 * JD-Core Version:    0.7.0.1
 */