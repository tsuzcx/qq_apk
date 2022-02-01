package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.pluginsdk.location.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class l
  implements c
{
  int h;
  int w;
  HashMap<Long, WeakReference<ImageView>> yFV;
  HashMap<Long, ca.b> yFW;
  HashMap<Long, WeakReference<ProgressBar>> yFX;
  HashMap<Long, WeakReference<ImageView>> yFY;
  HashMap<ca.b, ca> yFZ;
  HashMap<Long, Integer> yGa;
  HashSet<Long> yGb;
  
  public l()
  {
    AppMethodBeat.i(55708);
    this.yFV = new HashMap();
    this.yFW = new HashMap();
    this.yFX = new HashMap();
    this.yFY = new HashMap();
    this.yFZ = new HashMap();
    this.yGa = new HashMap();
    this.yGb = new HashSet();
    this.w = 300;
    this.h = 300;
    start();
    AppMethodBeat.o(55708);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(55711);
    if (paramd == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    if (!this.yFW.containsKey(Long.valueOf(paramd.JTu)))
    {
      AppMethodBeat.o(55711);
      return;
    }
    paramd = (ca.b)this.yFW.get(Long.valueOf(paramd.JTu));
    paramd = (ca)this.yFZ.remove(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    this.yFV.get(Long.valueOf(paramd.field_msgId));
    if ((paramd != null) && ((paramd.fQX < 0) || (paramd.fQX > 5)))
    {
      paramd.nK(0);
      paramd.nK(paramd.fQX + 1);
      if (g.aAc())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramd.field_msgId, paramd);
        Log.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramd.fQX) });
      }
    }
    AppMethodBeat.o(55711);
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(55710);
    if (paramd == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.yFW.containsKey(Long.valueOf(paramd.JTu)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    paramd = (ca.b)this.yFW.get(Long.valueOf(paramd.JTu));
    paramd = (ca)this.yFZ.remove(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.yFV.get(Long.valueOf(paramd.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.yGa.containsKey(Long.valueOf(paramd.field_msgId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    int i = ((Integer)this.yGa.remove(Long.valueOf(paramd.field_msgId))).intValue();
    if (paramd.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(q.bcR().a(paramd.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.yFX.remove(Long.valueOf(paramd.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.yFY.remove(Long.valueOf(paramd.field_msgId));
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
    n.ecP().a(this);
    AppMethodBeat.o(55709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */