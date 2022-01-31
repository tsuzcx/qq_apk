package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class l
{
  private boolean dirty = true;
  public HashMap<String, WeakReference<l.a>> elp = new HashMap();
  public yv jZb = new yv();
  private HashSet<Integer> jZc = new HashSet();
  private List<yt> jZd = new LinkedList();
  
  public l()
  {
    byte[] arrayOfByte = bk.ZM((String)com.tencent.mm.kernel.g.DP().Dz().get(225283, ""));
    try
    {
      this.jZb.aH(arrayOfByte);
      y.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.jZb.sXo });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        y.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.jZb = new yv();
      }
    }
  }
  
  private void fR(boolean paramBoolean)
  {
    Iterator localIterator = this.elp.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((l.a)localWeakReference.get()).aQi();
        } else {
          ((l.a)localWeakReference.get()).aQj();
        }
      }
    }
  }
  
  private void removeTag(final String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.jZc.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      y.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      ai.d(new Runnable()
      {
        public final void run()
        {
          l.this.CK(paramString);
        }
      });
      return;
    }
    y.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    CK(paramString);
  }
  
  private void save()
  {
    try
    {
      byte[] arrayOfByte = this.jZb.toByteArray();
      com.tencent.mm.kernel.g.DS().O(new l.1(this, arrayOfByte));
      this.dirty = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        y.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[] { localException.getMessage() });
        Object localObject = null;
      }
    }
  }
  
  public final void CI(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    if (this.jZc.contains(Integer.valueOf(paramString.hashCode())))
    {
      y.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      return;
    }
    this.jZc.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      y.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      ai.d(new l.2(this, paramString));
      return;
    }
    y.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    CJ(paramString);
  }
  
  final void CJ(String paramString)
  {
    int k = 0;
    String str = com.tencent.mm.platformtools.g.oY(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.jZb.sXo.iterator();
      int j = 0;
      yu localyu;
      if (((Iterator)localObject).hasNext())
      {
        localyu = (yu)((Iterator)localObject).next();
        if (localyu.sXm != i) {}
      }
      for (;;)
      {
        label77:
        if (localyu == null)
        {
          localyu = new yu();
          localyu.sXm = i;
          this.jZb.sXo.add(localyu);
        }
        for (;;)
        {
          localObject = localyu.sXn.iterator();
          i = k;
          label123:
          if (((Iterator)localObject).hasNext())
          {
            yt localyt = (yt)((Iterator)localObject).next();
            j = localyt.sXl.compareTo(str);
            if (j != 0) {
              break label319;
            }
            j = localyt.rtH.compareTo(paramString);
          }
          label319:
          for (;;)
          {
            if (j == 0)
            {
              return;
              if (localyu.sXm > i)
              {
                localyu = new yu();
                localyu.sXm = i;
                this.jZb.sXo.add(j, localyu);
                break label77;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new yt();
              ((yt)localObject).rtH = paramString;
              ((yt)localObject).sXl = str;
              localyu.sXn.add(i, localObject);
              save();
              fR(true);
              return;
            }
            i += 1;
            break label123;
            localObject = new yt();
            ((yt)localObject).rtH = paramString;
            ((yt)localObject).sXl = str;
            localyu.sXn.add(localObject);
            fR(true);
            save();
            return;
          }
        }
        localyu = null;
      }
    }
  }
  
  final void CK(String paramString)
  {
    String str = com.tencent.mm.platformtools.g.oY(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.jZb.sXo.iterator();
      int i = 0;
      yu localyu;
      if (localIterator.hasNext())
      {
        localyu = (yu)localIterator.next();
        if (localyu.sXm != j) {}
      }
      for (;;)
      {
        if (localyu == null) {
          break label79;
        }
        for (;;)
        {
          label79:
          return;
          label247:
          if (localyu.sXm <= j)
          {
            i += 1;
            break;
            localIterator = localyu.sXn.iterator();
            j = 0;
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label247;
              }
              yt localyt = (yt)localIterator.next();
              int m = localyt.sXl.compareTo(str);
              int k = m;
              if (m == 0) {
                k = localyt.rtH.compareTo(paramString);
              }
              if (k == 0)
              {
                if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().CP(localyt.rtH)) {
                  break;
                }
                localyu.sXn.remove(j);
                if (localyu.sXn.isEmpty()) {
                  this.jZb.sXo.remove(i);
                }
                fR(false);
                save();
                return;
              }
              if (k > 0) {
                break;
              }
              j += 1;
            }
          }
        }
        localyu = null;
      }
    }
  }
  
  public final void a(l.a parama)
  {
    if (parama == null) {
      return;
    }
    this.elp.put(parama.toString(), new WeakReference(parama));
  }
  
  public final int aQh()
  {
    Iterator localIterator = this.jZb.sXo.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((yu)localIterator.next()).sXn.size() + i) {}
    return i;
  }
  
  public final void e(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    for (;;)
    {
      return;
      y.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[] { paramSet });
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        removeTag((String)paramSet.next());
      }
    }
  }
  
  public final List<yt> qY(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      return null;
    }
    if (this.dirty)
    {
      y.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
      this.jZd.clear();
      Iterator localIterator = this.jZb.sXo.iterator();
      while (localIterator.hasNext())
      {
        yu localyu = (yu)localIterator.next();
        this.jZd.addAll(localyu.sXn);
      }
      this.dirty = false;
    }
    y.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.jZd.size()) });
    return this.jZd;
  }
  
  public final void v(g paramg)
  {
    if (paramg == null) {}
    for (;;)
    {
      return;
      paramg = paramg.field_tagProto.sXq.iterator();
      while (paramg.hasNext()) {
        removeTag((String)paramg.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */