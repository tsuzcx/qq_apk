package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  public HashMap<String, WeakReference<l.a>> bat;
  private boolean dirty;
  public adc mtt;
  private HashSet<Integer> mtu;
  private List<ada> mtv;
  
  public l()
  {
    AppMethodBeat.i(102673);
    this.mtt = new adc();
    this.bat = new HashMap();
    this.mtu = new HashSet();
    this.dirty = true;
    this.mtv = new LinkedList();
    byte[] arrayOfByte = bo.apQ((String)com.tencent.mm.kernel.g.RL().Ru().get(225283, ""));
    try
    {
      this.mtt.parseFrom(arrayOfByte);
      ab.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.mtt.wVo });
      AppMethodBeat.o(102673);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ab.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.mtt = new adc();
      }
    }
  }
  
  private void hu(boolean paramBoolean)
  {
    AppMethodBeat.i(102675);
    Iterator localIterator = this.bat.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((l.a)localWeakReference.get()).bwx();
        } else {
          ((l.a)localWeakReference.get()).bwy();
        }
      }
    }
    AppMethodBeat.o(102675);
  }
  
  private void removeTag(String paramString)
  {
    AppMethodBeat.i(102683);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102683);
      return;
    }
    this.mtu.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ab.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      al.d(new l.3(this, paramString));
      AppMethodBeat.o(102683);
      return;
    }
    ab.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    NM(paramString);
    AppMethodBeat.o(102683);
  }
  
  private void save()
  {
    AppMethodBeat.i(102676);
    try
    {
      byte[] arrayOfByte = this.mtt.toByteArray();
      com.tencent.mm.kernel.g.RO().ac(new l.1(this, arrayOfByte));
      this.dirty = true;
      AppMethodBeat.o(102676);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ab.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[] { localException.getMessage() });
        Object localObject = null;
      }
    }
  }
  
  public final void NK(String paramString)
  {
    AppMethodBeat.i(102679);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102679);
      return;
    }
    if (this.mtu.contains(Integer.valueOf(paramString.hashCode())))
    {
      ab.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(102679);
      return;
    }
    this.mtu.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ab.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      al.d(new l.2(this, paramString));
      AppMethodBeat.o(102679);
      return;
    }
    ab.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    NL(paramString);
    AppMethodBeat.o(102679);
  }
  
  final void NL(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(102680);
    String str = com.tencent.mm.platformtools.g.wq(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.mtt.wVo.iterator();
      int j = 0;
      adb localadb;
      if (((Iterator)localObject).hasNext())
      {
        localadb = (adb)((Iterator)localObject).next();
        if (localadb.wVm != i) {}
      }
      for (;;)
      {
        label82:
        if (localadb == null)
        {
          localadb = new adb();
          localadb.wVm = i;
          this.mtt.wVo.add(localadb);
        }
        for (;;)
        {
          localObject = localadb.wVn.iterator();
          i = k;
          label128:
          if (((Iterator)localObject).hasNext())
          {
            ada localada = (ada)((Iterator)localObject).next();
            j = localada.wVl.compareTo(str);
            if (j != 0) {
              break label339;
            }
            j = localada.smP.compareTo(paramString);
          }
          label339:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(102680);
              return;
              if (localadb.wVm > i)
              {
                localadb = new adb();
                localadb.wVm = i;
                this.mtt.wVo.add(j, localadb);
                break label82;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new ada();
              ((ada)localObject).smP = paramString;
              ((ada)localObject).wVl = str;
              localadb.wVn.add(i, localObject);
              save();
              hu(true);
              AppMethodBeat.o(102680);
              return;
            }
            i += 1;
            break label128;
            localObject = new ada();
            ((ada)localObject).smP = paramString;
            ((ada)localObject).wVl = str;
            localadb.wVn.add(localObject);
            hu(true);
            save();
            AppMethodBeat.o(102680);
            return;
          }
        }
        localadb = null;
      }
    }
  }
  
  final void NM(String paramString)
  {
    AppMethodBeat.i(102684);
    String str = com.tencent.mm.platformtools.g.wq(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.mtt.wVo.iterator();
      int i = 0;
      adb localadb;
      if (localIterator.hasNext())
      {
        localadb = (adb)localIterator.next();
        if (localadb.wVm != j) {}
      }
      for (;;)
      {
        if (localadb == null)
        {
          AppMethodBeat.o(102684);
          return;
          if (localadb.wVm > j)
          {
            AppMethodBeat.o(102684);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localadb.wVn.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          ada localada = (ada)localIterator.next();
          int m = localada.wVl.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localada.smP.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().NR(localada.smP))
            {
              localadb.wVn.remove(j);
              if (localadb.wVn.isEmpty()) {
                this.mtt.wVo.remove(i);
              }
              hu(false);
              save();
            }
            AppMethodBeat.o(102684);
            return;
          }
          if (k > 0)
          {
            AppMethodBeat.o(102684);
            return;
          }
          j += 1;
        }
        AppMethodBeat.o(102684);
        return;
        localadb = null;
      }
    }
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(102674);
    if (parama == null)
    {
      AppMethodBeat.o(102674);
      return;
    }
    this.bat.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(102674);
  }
  
  public final int bww()
  {
    AppMethodBeat.i(102678);
    Iterator localIterator = this.mtt.wVo.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((adb)localIterator.next()).wVn.size() + i) {}
    AppMethodBeat.o(102678);
    return i;
  }
  
  public final void d(Set<String> paramSet)
  {
    AppMethodBeat.i(102682);
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      AppMethodBeat.o(102682);
      return;
    }
    ab.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[] { paramSet });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      removeTag((String)paramSet.next());
    }
    AppMethodBeat.o(102682);
  }
  
  public final void v(g paramg)
  {
    AppMethodBeat.i(102681);
    if (paramg == null)
    {
      AppMethodBeat.o(102681);
      return;
    }
    paramg = paramg.field_tagProto.wVq.iterator();
    while (paramg.hasNext()) {
      removeTag((String)paramg.next());
    }
    AppMethodBeat.o(102681);
  }
  
  public final List<ada> vT(int paramInt)
  {
    AppMethodBeat.i(102677);
    if ((paramInt < 0) || (paramInt > 1))
    {
      AppMethodBeat.o(102677);
      return null;
    }
    if (this.dirty)
    {
      ab.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
      this.mtv.clear();
      localObject = this.mtt.wVo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        adb localadb = (adb)((Iterator)localObject).next();
        this.mtv.addAll(localadb.wVn);
      }
      this.dirty = false;
    }
    ab.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.mtv.size()) });
    Object localObject = this.mtv;
    AppMethodBeat.o(102677);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */