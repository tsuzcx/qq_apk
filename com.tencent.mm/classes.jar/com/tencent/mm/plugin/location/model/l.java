package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
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
  HashMap<Long, WeakReference<ImageView>> EjO;
  HashMap<Long, ca.b> EjP;
  HashMap<Long, WeakReference<ProgressBar>> EjQ;
  HashMap<Long, WeakReference<ImageView>> EjR;
  HashMap<ca.b, ca> EjS;
  HashMap<Long, Integer> EjT;
  HashSet<Long> EjU;
  int h;
  int w;
  
  public l()
  {
    AppMethodBeat.i(55708);
    this.EjO = new HashMap();
    this.EjP = new HashMap();
    this.EjQ = new HashMap();
    this.EjR = new HashMap();
    this.EjS = new HashMap();
    this.EjT = new HashMap();
    this.EjU = new HashSet();
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
    if (!this.EjP.containsKey(Long.valueOf(paramd.QSA)))
    {
      AppMethodBeat.o(55711);
      return;
    }
    paramd = (ca.b)this.EjP.get(Long.valueOf(paramd.QSA));
    paramd = (ca)this.EjS.remove(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    this.EjO.get(Long.valueOf(paramd.field_msgId));
    if ((paramd != null) && ((paramd.iln < 0) || (paramd.iln > 5)))
    {
      paramd.pZ(0);
      paramd.pZ(paramd.iln + 1);
      if (h.aHB())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(paramd.field_msgId, paramd);
        Log.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramd.iln) });
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
    if (!this.EjP.containsKey(Long.valueOf(paramd.QSA)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    paramd = (ca.b)this.EjP.get(Long.valueOf(paramd.QSA));
    paramd = (ca)this.EjS.remove(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.EjO.get(Long.valueOf(paramd.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.EjT.containsKey(Long.valueOf(paramd.field_msgId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    int i = ((Integer)this.EjT.remove(Long.valueOf(paramd.field_msgId))).intValue();
    if (paramd.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(q.bmh().a(paramd.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.EjQ.remove(Long.valueOf(paramd.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.EjR.remove(Long.valueOf(paramd.field_msgId));
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
    n.eMh().a(this);
    AppMethodBeat.o(55709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */