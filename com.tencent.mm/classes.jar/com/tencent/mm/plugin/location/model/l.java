package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.pluginsdk.location.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class l
  implements c
{
  HashMap<Long, WeakReference<ImageView>> KcA;
  HashMap<cc.c, cc> KcB;
  HashMap<Long, Integer> KcC;
  HashSet<Long> KcD;
  HashMap<Long, WeakReference<ImageView>> Kcx;
  HashMap<Long, cc.c> Kcy;
  HashMap<Long, WeakReference<ProgressBar>> Kcz;
  int h;
  int w;
  
  public l()
  {
    AppMethodBeat.i(55708);
    this.Kcx = new HashMap();
    this.Kcy = new HashMap();
    this.Kcz = new HashMap();
    this.KcA = new HashMap();
    this.KcB = new HashMap();
    this.KcC = new HashMap();
    this.KcD = new HashSet();
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
    if (!this.Kcy.containsKey(Long.valueOf(paramd.itemId)))
    {
      AppMethodBeat.o(55711);
      return;
    }
    paramd = (cc.c)this.Kcy.get(Long.valueOf(paramd.itemId));
    paramd = (cc)this.KcB.remove(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(55711);
      return;
    }
    this.Kcx.get(Long.valueOf(paramd.field_msgId));
    if ((paramd != null) && ((paramd.kLm < 0) || (paramd.kLm > 5)))
    {
      paramd.pZ(0);
      paramd.pZ(paramd.kLm + 1);
      if (h.baz())
      {
        ((n)h.ax(n.class)).gaZ().a(paramd.field_msgId, paramd);
        Log.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramd.kLm) });
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
    if (!this.Kcy.containsKey(Long.valueOf(paramd.itemId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    paramd = (cc.c)this.Kcy.get(Long.valueOf(paramd.itemId));
    paramd = (cc)this.KcB.remove(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(55710);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.Kcx.get(Long.valueOf(paramd.field_msgId));
    if ((localWeakReference == null) || (localWeakReference.get() == null))
    {
      AppMethodBeat.o(55710);
      return;
    }
    if (!this.KcC.containsKey(Long.valueOf(paramd.field_msgId)))
    {
      AppMethodBeat.o(55710);
      return;
    }
    int i = ((Integer)this.KcC.remove(Long.valueOf(paramd.field_msgId))).intValue();
    if (paramd.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(r.bKa().a(paramd.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.Kcz.remove(Long.valueOf(paramd.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.KcA.remove(Long.valueOf(paramd.field_msgId));
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
    SubCoreLocation.fUz().a(this);
    AppMethodBeat.o(55709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.l
 * JD-Core Version:    0.7.0.1
 */