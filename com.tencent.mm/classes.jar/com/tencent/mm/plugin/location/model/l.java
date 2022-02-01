package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class l
  implements b
{
  int h;
  HashMap<Long, WeakReference<ImageView>> vmd;
  HashMap<Long, bv.b> vme;
  HashMap<Long, WeakReference<ProgressBar>> vmf;
  HashMap<Long, WeakReference<ImageView>> vmg;
  HashMap<bv.b, bv> vmh;
  HashMap<Long, Integer> vmi;
  HashSet<Long> vmj;
  int w;
  
  public l()
  {
    AppMethodBeat.i(55708);
    this.vmd = new HashMap();
    this.vme = new HashMap();
    this.vmf = new HashMap();
    this.vmg = new HashMap();
    this.vmh = new HashMap();
    this.vmi = new HashMap();
    this.vmj = new HashSet();
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
    if (!this.vme.containsKey(Long.valueOf(paramc.FcC)))
    {
      AppMethodBeat.o(55711);
      return;
    }
    paramc = (bv.b)this.vme.get(Long.valueOf(paramc.FcC));
    paramc = (bv)this.vmh.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    this.vmd.get(Long.valueOf(paramc.field_msgId));
    if ((paramc != null) && ((paramc.fmt < 0) || (paramc.fmt > 5)))
    {
      paramc.kH(0);
      paramc.kH(paramc.fmt + 1);
      if (g.ajM())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramc.field_msgId, paramc);
        ae.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramc.fmt) });
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
    if (!this.vme.containsKey(Long.valueOf(paramc.FcC)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    paramc = (bv.b)this.vme.get(Long.valueOf(paramc.FcC));
    paramc = (bv)this.vmh.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.vmd.get(Long.valueOf(paramc.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.vmi.containsKey(Long.valueOf(paramc.field_msgId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    int i = ((Integer)this.vmi.remove(Long.valueOf(paramc.field_msgId))).intValue();
    if (paramc.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(q.aIX().a(paramc.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.vmf.remove(Long.valueOf(paramc.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.vmg.remove(Long.valueOf(paramc.field_msgId));
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
    n.dje().a(this);
    AppMethodBeat.o(55709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */