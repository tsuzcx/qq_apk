package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class l
  implements b
{
  int h;
  HashMap<Long, WeakReference<ImageView>> uZS;
  HashMap<Long, bu.b> uZT;
  HashMap<Long, WeakReference<ProgressBar>> uZU;
  HashMap<Long, WeakReference<ImageView>> uZV;
  HashMap<bu.b, bu> uZW;
  HashMap<Long, Integer> uZX;
  HashSet<Long> uZY;
  int w;
  
  public l()
  {
    AppMethodBeat.i(55708);
    this.uZS = new HashMap();
    this.uZT = new HashMap();
    this.uZU = new HashMap();
    this.uZV = new HashMap();
    this.uZW = new HashMap();
    this.uZX = new HashMap();
    this.uZY = new HashSet();
    this.w = 300;
    this.h = 300;
    start();
    AppMethodBeat.o(55708);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(55711);
    if (paramc == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    if (!this.uZT.containsKey(Long.valueOf(paramc.EKe)))
    {
      AppMethodBeat.o(55711);
      return;
    }
    paramc = (bu.b)this.uZT.get(Long.valueOf(paramc.EKe));
    paramc = (bu)this.uZW.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    this.uZS.get(Long.valueOf(paramc.field_msgId));
    if ((paramc != null) && ((paramc.fkw < 0) || (paramc.fkw > 5)))
    {
      paramc.kF(0);
      paramc.kF(paramc.fkw + 1);
      if (g.ajx())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramc.field_msgId, paramc);
        ad.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramc.fkw) });
      }
    }
    AppMethodBeat.o(55711);
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(55710);
    if (paramc == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.uZT.containsKey(Long.valueOf(paramc.EKe)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    paramc = (bu.b)this.uZT.get(Long.valueOf(paramc.EKe));
    paramc = (bu)this.uZW.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.uZS.get(Long.valueOf(paramc.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.uZX.containsKey(Long.valueOf(paramc.field_msgId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    int i = ((Integer)this.uZX.remove(Long.valueOf(paramc.field_msgId))).intValue();
    if (paramc.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(q.aIF().a(paramc.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.uZU.remove(Long.valueOf(paramc.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.uZV.remove(Long.valueOf(paramc.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ImageView)paramString.get()).setVisibility(0);
      }
      AppMethodBeat.o(55710);
      return;
    }
  }
  
  final void start()
  {
    AppMethodBeat.i(55709);
    n.dgf().a(this);
    AppMethodBeat.o(55709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */