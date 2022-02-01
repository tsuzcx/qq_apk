package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
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
  public HashMap<String, WeakReference<a>> byu;
  private boolean dirty;
  public aha qah;
  private HashSet<Integer> qai;
  private List<agy> qaj;
  
  public l()
  {
    AppMethodBeat.i(103413);
    this.qah = new aha();
    this.byu = new HashMap();
    this.qai = new HashSet();
    this.dirty = true;
    this.qaj = new LinkedList();
    byte[] arrayOfByte = bt.aGd((String)com.tencent.mm.kernel.g.afB().afk().get(225283, ""));
    try
    {
      this.qah.parseFrom(arrayOfByte);
      ad.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.qah.rNO });
      AppMethodBeat.o(103413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ad.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.qah = new aha();
      }
    }
  }
  
  private void kx(boolean paramBoolean)
  {
    AppMethodBeat.i(103415);
    Iterator localIterator = this.byu.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((a)localWeakReference.get()).chP();
        } else {
          ((a)localWeakReference.get()).chQ();
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
    this.qai.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ad.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103412);
          l.this.Yh(paramString);
          AppMethodBeat.o(103412);
        }
      });
      AppMethodBeat.o(103423);
      return;
    }
    ad.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    Yh(paramString);
    AppMethodBeat.o(103423);
  }
  
  private void save()
  {
    AppMethodBeat.i(103416);
    try
    {
      byte[] arrayOfByte = this.qah.toByteArray();
      com.tencent.mm.kernel.g.afE().ax(new l.1(this, arrayOfByte));
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
  
  public final List<agy> Cl(int paramInt)
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
      this.qaj.clear();
      localObject = this.qah.rNO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        agz localagz = (agz)((Iterator)localObject).next();
        this.qaj.addAll(localagz.DiP);
      }
      this.dirty = false;
    }
    ad.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.qaj.size()) });
    Object localObject = this.qaj;
    AppMethodBeat.o(103417);
    return localObject;
  }
  
  public final void Yf(final String paramString)
  {
    AppMethodBeat.i(103419);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103419);
      return;
    }
    if (this.qai.contains(Integer.valueOf(paramString.hashCode())))
    {
      ad.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(103419);
      return;
    }
    this.qai.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ad.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103411);
          l.this.Yg(paramString);
          AppMethodBeat.o(103411);
        }
      });
      AppMethodBeat.o(103419);
      return;
    }
    ad.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    Yg(paramString);
    AppMethodBeat.o(103419);
  }
  
  final void Yg(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(103420);
    String str = f.Br(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.qah.rNO.iterator();
      int j = 0;
      agz localagz;
      if (((Iterator)localObject).hasNext())
      {
        localagz = (agz)((Iterator)localObject).next();
        if (localagz.DiO != i) {}
      }
      for (;;)
      {
        label83:
        if (localagz == null)
        {
          localagz = new agz();
          localagz.DiO = i;
          this.qah.rNO.add(localagz);
        }
        for (;;)
        {
          localObject = localagz.DiP.iterator();
          i = k;
          label129:
          if (((Iterator)localObject).hasNext())
          {
            agy localagy = (agy)((Iterator)localObject).next();
            j = localagy.DiN.compareTo(str);
            if (j != 0) {
              break label343;
            }
            j = localagy.xXR.compareTo(paramString);
          }
          label343:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(103420);
              return;
              if (localagz.DiO > i)
              {
                localagz = new agz();
                localagz.DiO = i;
                this.qah.rNO.add(j, localagz);
                break label83;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new agy();
              ((agy)localObject).xXR = paramString;
              ((agy)localObject).DiN = str;
              localagz.DiP.add(i, localObject);
              save();
              kx(true);
              AppMethodBeat.o(103420);
              return;
            }
            i += 1;
            break label129;
            localObject = new agy();
            ((agy)localObject).xXR = paramString;
            ((agy)localObject).DiN = str;
            localagz.DiP.add(localObject);
            kx(true);
            save();
            AppMethodBeat.o(103420);
            return;
          }
        }
        localagz = null;
      }
    }
  }
  
  final void Yh(String paramString)
  {
    AppMethodBeat.i(103424);
    String str = f.Br(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.qah.rNO.iterator();
      int i = 0;
      agz localagz;
      if (localIterator.hasNext())
      {
        localagz = (agz)localIterator.next();
        if (localagz.DiO != j) {}
      }
      for (;;)
      {
        if (localagz == null)
        {
          AppMethodBeat.o(103424);
          return;
          if (localagz.DiO > j)
          {
            AppMethodBeat.o(103424);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localagz.DiP.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          agy localagy = (agy)localIterator.next();
          int m = localagy.DiN.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localagy.xXR.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().Ym(localagy.xXR))
            {
              localagz.DiP.remove(j);
              if (localagz.DiP.isEmpty()) {
                this.qah.rNO.remove(i);
              }
              kx(false);
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
        localagz = null;
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103414);
    if (parama == null)
    {
      AppMethodBeat.o(103414);
      return;
    }
    this.byu.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(103414);
  }
  
  public final int chO()
  {
    AppMethodBeat.i(103418);
    Iterator localIterator = this.qah.rNO.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((agz)localIterator.next()).DiP.size() + i) {}
    AppMethodBeat.o(103418);
    return i;
  }
  
  public final void e(Set<String> paramSet)
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
    paramg = paramg.field_tagProto.DiR.iterator();
    while (paramg.hasNext()) {
      removeTag((String)paramg.next());
    }
    AppMethodBeat.o(103421);
  }
  
  public static abstract interface a
  {
    public abstract void chP();
    
    public abstract void chQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */