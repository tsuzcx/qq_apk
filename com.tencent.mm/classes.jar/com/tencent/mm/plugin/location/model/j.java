package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class j
  implements a
{
  int h = 300;
  HashMap<Long, WeakReference<ImageView>> lDj = new HashMap();
  HashMap<Long, bi.b> lDk = new HashMap();
  HashMap<Long, WeakReference<ProgressBar>> lDl = new HashMap();
  HashMap<Long, WeakReference<ImageView>> lDm = new HashMap();
  HashMap<bi.b, bi> lDn = new HashMap();
  HashMap<Long, Integer> lDo = new HashMap();
  HashSet<Long> lDp = new HashSet();
  int w = 300;
  
  public j()
  {
    start();
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {}
    label4:
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (!this.lDk.containsKey(Long.valueOf(paramb.itemId)));
          paramb = (bi.b)this.lDk.get(Long.valueOf(paramb.itemId));
          paramb = (bi)this.lDn.remove(paramb);
        } while (paramb == null);
        this.lDj.get(Long.valueOf(paramb.field_msgId));
      } while ((paramb == null) || ((paramb.cQL >= 0) && (paramb.cQL <= 5)));
      paramb.fM(0);
      paramb.fM(paramb.cQL + 1);
    } while (!com.tencent.mm.kernel.g.DK());
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(paramb.field_msgId, paramb);
    y.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[] { Integer.valueOf(paramb.cQL) });
  }
  
  public final void a(String paramString, b paramb)
  {
    if (paramb == null) {}
    label4:
    WeakReference localWeakReference;
    do
    {
      do
      {
        break label4;
        do
        {
          return;
        } while (!this.lDk.containsKey(Long.valueOf(paramb.itemId)));
        paramb = (bi.b)this.lDk.get(Long.valueOf(paramb.itemId));
        paramb = (bi)this.lDn.remove(paramb);
      } while (paramb == null);
      localWeakReference = (WeakReference)this.lDj.get(Long.valueOf(paramb.field_msgId));
    } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!this.lDo.containsKey(Long.valueOf(paramb.field_msgId))));
    int i = ((Integer)this.lDo.remove(Long.valueOf(paramb.field_msgId))).intValue();
    if (paramb.field_isSend == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localWeakReference.get()).setImageBitmap(o.OJ().a(paramb.field_msgId, paramString, i, this.w, this.h, bool));
      paramString = (WeakReference)this.lDl.remove(Long.valueOf(paramb.field_msgId));
      if ((paramString != null) && (paramString.get() != null)) {
        ((ProgressBar)paramString.get()).setVisibility(8);
      }
      paramString = (WeakReference)this.lDm.remove(Long.valueOf(paramb.field_msgId));
      if ((paramString == null) || (paramString.get() == null)) {
        break;
      }
      ((ImageView)paramString.get()).setVisibility(0);
      return;
    }
  }
  
  public final void start()
  {
    k localk = l.bdV();
    if (this != null)
    {
      Iterator localIterator = localk.dhm.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!equals((a)localIterator.next()));
    }
    do
    {
      return;
      localk.dhm.add(this);
      y.i("MicroMsg.StaticMapServer", "addMapCallBack " + localk.dhm.size());
    } while (localk.dhm.size() != 1);
    localk.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.j
 * JD-Core Version:    0.7.0.1
 */