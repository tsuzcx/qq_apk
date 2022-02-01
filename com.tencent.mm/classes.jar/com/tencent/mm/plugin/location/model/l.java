package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class l
  implements b
{
  int h;
  HashMap<Long, WeakReference<ImageView>> sOW;
  HashMap<Long, bl.b> sOX;
  HashMap<Long, WeakReference<ProgressBar>> sOY;
  HashMap<Long, WeakReference<ImageView>> sOZ;
  HashMap<bl.b, bl> sPa;
  HashMap<Long, Integer> sPb;
  HashSet<Long> sPc;
  int w;
  
  public l()
  {
    AppMethodBeat.i(55708);
    this.sOW = new HashMap();
    this.sOX = new HashMap();
    this.sOY = new HashMap();
    this.sOZ = new HashMap();
    this.sPa = new HashMap();
    this.sPb = new HashMap();
    this.sPc = new HashSet();
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
    if (!this.sOX.containsKey(Long.valueOf(paramc.BNU)))
    {
      AppMethodBeat.o(55711);
      return;
    }
    paramc = (bl.b)this.sOX.get(Long.valueOf(paramc.BNU));
    paramc = (bl)this.sPa.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    this.sOW.get(Long.valueOf(paramc.field_msgId));
    if ((paramc != null) && ((paramc.eOZ < 0) || (paramc.eOZ > 5)))
    {
      paramc.kl(0);
      paramc.kl(paramc.eOZ + 1);
      if (com.tencent.mm.kernel.g.afw())
      {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(paramc.field_msgId, paramc);
        ad.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramc.eOZ) });
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
    if (!this.sOX.containsKey(Long.valueOf(paramc.BNU)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    paramc = (bl.b)this.sOX.get(Long.valueOf(paramc.BNU));
    paramc = (bl)this.sPa.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.sOW.get(Long.valueOf(paramc.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.sPb.containsKey(Long.valueOf(paramc.field_msgId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    int i = ((Integer)this.sPb.remove(Long.valueOf(paramc.field_msgId))).intValue();
    if (paramc.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(o.ayF().a(paramc.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.sOY.remove(Long.valueOf(paramc.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.sOZ.remove(Long.valueOf(paramc.field_msgId));
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
    n.cJo().a(this);
    AppMethodBeat.o(55709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */