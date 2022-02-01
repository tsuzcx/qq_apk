package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  public HashMap<String, WeakReference<a>> bGq;
  private boolean dirty;
  public akp rsO;
  private HashSet<Integer> rsP;
  private List<akn> rsQ;
  
  public l()
  {
    AppMethodBeat.i(103413);
    this.rsO = new akp();
    this.bGq = new HashMap();
    this.rsP = new HashSet();
    this.dirty = true;
    this.rsQ = new LinkedList();
    byte[] arrayOfByte = bt.aRa((String)com.tencent.mm.kernel.g.ajC().ajl().get(225283, ""));
    try
    {
      this.rsO.parseFrom(arrayOfByte);
      ad.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.rsO.tSj });
      AppMethodBeat.o(103413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ad.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.rsO = new akp();
      }
    }
  }
  
  private void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(103415);
    Iterator localIterator = this.bGq.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((a)localWeakReference.get()).cvb();
        } else {
          ((a)localWeakReference.get()).cvc();
        }
      }
    }
    AppMethodBeat.o(103415);
  }
  
  private void removeTag(final String paramString)
  {
    AppMethodBeat.i(103423);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103423);
      return;
    }
    this.rsP.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ad.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103412);
          l.this.ags(paramString);
          AppMethodBeat.o(103412);
        }
      });
      AppMethodBeat.o(103423);
      return;
    }
    ad.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    ags(paramString);
    AppMethodBeat.o(103423);
  }
  
  private void save()
  {
    AppMethodBeat.i(103416);
    try
    {
      byte[] arrayOfByte = this.rsO.toByteArray();
      com.tencent.mm.kernel.g.ajF().ay(new l.1(this, arrayOfByte));
      this.dirty = true;
      AppMethodBeat.o(103416);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ad.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[] { localException.getMessage() });
        Object localObject = null;
      }
    }
  }
  
  public final List<akn> DY(int paramInt)
  {
    AppMethodBeat.i(103417);
    if ((paramInt < 0) || (paramInt > 1))
    {
      AppMethodBeat.o(103417);
      return null;
    }
    if (this.dirty)
    {
      ad.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
      this.rsQ.clear();
      localObject = this.rsO.tSj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ako localako = (ako)((Iterator)localObject).next();
        this.rsQ.addAll(localako.GjH);
      }
      this.dirty = false;
    }
    ad.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.rsQ.size()) });
    Object localObject = this.rsQ;
    AppMethodBeat.o(103417);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103414);
    if (parama == null)
    {
      AppMethodBeat.o(103414);
      return;
    }
    this.bGq.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(103414);
  }
  
  public final void agq(final String paramString)
  {
    AppMethodBeat.i(103419);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103419);
      return;
    }
    if (this.rsP.contains(Integer.valueOf(paramString.hashCode())))
    {
      ad.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(103419);
      return;
    }
    this.rsP.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ad.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103411);
          l.this.agr(paramString);
          AppMethodBeat.o(103411);
        }
      });
      AppMethodBeat.o(103419);
      return;
    }
    ad.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    agr(paramString);
    AppMethodBeat.o(103419);
  }
  
  final void agr(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(103420);
    String str = f.IL(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.rsO.tSj.iterator();
      int j = 0;
      ako localako;
      if (((Iterator)localObject).hasNext())
      {
        localako = (ako)((Iterator)localObject).next();
        if (localako.GjG != i) {}
      }
      for (;;)
      {
        label83:
        if (localako == null)
        {
          localako = new ako();
          localako.GjG = i;
          this.rsO.tSj.add(localako);
        }
        for (;;)
        {
          localObject = localako.GjH.iterator();
          i = k;
          label129:
          if (((Iterator)localObject).hasNext())
          {
            akn localakn = (akn)((Iterator)localObject).next();
            j = localakn.GjF.compareTo(str);
            if (j != 0) {
              break label343;
            }
            j = localakn.ACS.compareTo(paramString);
          }
          label343:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(103420);
              return;
              if (localako.GjG > i)
              {
                localako = new ako();
                localako.GjG = i;
                this.rsO.tSj.add(j, localako);
                break label83;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new akn();
              ((akn)localObject).ACS = paramString;
              ((akn)localObject).GjF = str;
              localako.GjH.add(i, localObject);
              save();
              lu(true);
              AppMethodBeat.o(103420);
              return;
            }
            i += 1;
            break label129;
            localObject = new akn();
            ((akn)localObject).ACS = paramString;
            ((akn)localObject).GjF = str;
            localako.GjH.add(localObject);
            lu(true);
            save();
            AppMethodBeat.o(103420);
            return;
          }
        }
        localako = null;
      }
    }
  }
  
  final void ags(String paramString)
  {
    AppMethodBeat.i(103424);
    String str = f.IL(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.rsO.tSj.iterator();
      int i = 0;
      ako localako;
      if (localIterator.hasNext())
      {
        localako = (ako)localIterator.next();
        if (localako.GjG != j) {}
      }
      for (;;)
      {
        if (localako == null)
        {
          AppMethodBeat.o(103424);
          return;
          if (localako.GjG > j)
          {
            AppMethodBeat.o(103424);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localako.GjH.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          akn localakn = (akn)localIterator.next();
          int m = localakn.GjF.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localakn.ACS.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().agx(localakn.ACS))
            {
              localako.GjH.remove(j);
              if (localako.GjH.isEmpty()) {
                this.rsO.tSj.remove(i);
              }
              lu(false);
              save();
            }
            AppMethodBeat.o(103424);
            return;
          }
          if (k > 0)
          {
            AppMethodBeat.o(103424);
            return;
          }
          j += 1;
        }
        AppMethodBeat.o(103424);
        return;
        localako = null;
      }
    }
  }
  
  public final int cva()
  {
    AppMethodBeat.i(103418);
    Iterator localIterator = this.rsO.tSj.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((ako)localIterator.next()).GjH.size() + i) {}
    AppMethodBeat.o(103418);
    return i;
  }
  
  public final void j(Set<String> paramSet)
  {
    AppMethodBeat.i(103422);
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      AppMethodBeat.o(103422);
      return;
    }
    ad.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[] { paramSet });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      removeTag((String)paramSet.next());
    }
    AppMethodBeat.o(103422);
  }
  
  public final void w(g paramg)
  {
    AppMethodBeat.i(103421);
    if (paramg == null)
    {
      AppMethodBeat.o(103421);
      return;
    }
    paramg = paramg.field_tagProto.GjJ.iterator();
    while (paramg.hasNext()) {
      removeTag((String)paramg.next());
    }
    AppMethodBeat.o(103421);
  }
  
  public static abstract interface a
  {
    public abstract void cvb();
    
    public abstract void cvc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */