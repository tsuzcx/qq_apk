package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class l
  implements b
{
  int h;
  HashMap<Long, WeakReference<ImageView>> tXj;
  HashMap<Long, bo.b> tXk;
  HashMap<Long, WeakReference<ProgressBar>> tXl;
  HashMap<Long, WeakReference<ImageView>> tXm;
  HashMap<bo.b, bo> tXn;
  HashMap<Long, Integer> tXo;
  HashSet<Long> tXp;
  int w;
  
  public l()
  {
    AppMethodBeat.i(55708);
    this.tXj = new HashMap();
    this.tXk = new HashMap();
    this.tXl = new HashMap();
    this.tXm = new HashMap();
    this.tXn = new HashMap();
    this.tXo = new HashMap();
    this.tXp = new HashSet();
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
    if (!this.tXk.containsKey(Long.valueOf(paramc.Dgi)))
    {
      AppMethodBeat.o(55711);
      return;
    }
    paramc = (bo.b)this.tXk.get(Long.valueOf(paramc.Dgi));
    paramc = (bo)this.tXn.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    this.tXj.get(Long.valueOf(paramc.field_msgId));
    if ((paramc != null) && ((paramc.eSh < 0) || (paramc.eSh > 5)))
    {
      paramc.ki(0);
      paramc.ki(paramc.eSh + 1);
      if (com.tencent.mm.kernel.g.agM())
      {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(paramc.field_msgId, paramc);
        ac.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramc.eSh) });
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
    if (!this.tXk.containsKey(Long.valueOf(paramc.Dgi)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    paramc = (bo.b)this.tXk.get(Long.valueOf(paramc.Dgi));
    paramc = (bo)this.tXn.remove(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.tXj.get(Long.valueOf(paramc.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.tXo.containsKey(Long.valueOf(paramc.field_msgId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    int i = ((Integer)this.tXo.remove(Long.valueOf(paramc.field_msgId))).intValue();
    if (paramc.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(o.aFx().a(paramc.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.tXl.remove(Long.valueOf(paramc.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.tXm.remove(Long.valueOf(paramc.field_msgId));
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
    n.cWT().a(this);
    AppMethodBeat.o(55709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */