package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
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
  public HashMap<String, WeakReference<a>> bGH;
  private boolean dirty;
  public ann taG;
  private HashSet<Integer> taH;
  private List<anl> taI;
  
  public l()
  {
    AppMethodBeat.i(103413);
    this.taG = new ann();
    this.bGH = new HashMap();
    this.taH = new HashSet();
    this.dirty = true;
    this.taI = new LinkedList();
    byte[] arrayOfByte = Util.decodeHexString((String)com.tencent.mm.kernel.g.aAh().azQ().get(225283, ""));
    try
    {
      this.taG.parseFrom(arrayOfByte);
      Log.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.taG.xuO });
      AppMethodBeat.o(103413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        Log.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.taG = new ann();
      }
    }
  }
  
  private void mw(boolean paramBoolean)
  {
    AppMethodBeat.i(103415);
    Iterator localIterator = this.bGH.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((a)localWeakReference.get()).cUG();
        } else {
          ((a)localWeakReference.get()).cUH();
        }
      }
    }
    AppMethodBeat.o(103415);
  }
  
  private void removeTag(final String paramString)
  {
    AppMethodBeat.i(103423);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103423);
      return;
    }
    this.taH.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      Log.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103412);
          l.this.arX(paramString);
          AppMethodBeat.o(103412);
        }
      });
      AppMethodBeat.o(103423);
      return;
    }
    Log.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    arX(paramString);
    AppMethodBeat.o(103423);
  }
  
  private void save()
  {
    AppMethodBeat.i(103416);
    try
    {
      byte[] arrayOfByte = this.taG.toByteArray();
      com.tencent.mm.kernel.g.aAk().postToWorker(new l.1(this, arrayOfByte));
      this.dirty = true;
      AppMethodBeat.o(103416);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        Log.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[] { localException.getMessage() });
        Object localObject = null;
      }
    }
  }
  
  public final List<anl> HW(int paramInt)
  {
    AppMethodBeat.i(103417);
    if ((paramInt < 0) || (paramInt > 1))
    {
      AppMethodBeat.o(103417);
      return null;
    }
    if (this.dirty)
    {
      Log.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
      this.taI.clear();
      localObject = this.taG.xuO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        anm localanm = (anm)((Iterator)localObject).next();
        this.taI.addAll(localanm.Lym);
      }
      this.dirty = false;
    }
    Log.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.taI.size()) });
    Object localObject = this.taI;
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
    this.bGH.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(103414);
  }
  
  public final void arV(final String paramString)
  {
    AppMethodBeat.i(103419);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103419);
      return;
    }
    if (this.taH.contains(Integer.valueOf(paramString.hashCode())))
    {
      Log.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(103419);
      return;
    }
    this.taH.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      Log.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103411);
          l.this.arW(paramString);
          AppMethodBeat.o(103411);
        }
      });
      AppMethodBeat.o(103419);
      return;
    }
    Log.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    arW(paramString);
    AppMethodBeat.o(103419);
  }
  
  final void arW(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(103420);
    String str = f.Sh(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.taG.xuO.iterator();
      int j = 0;
      anm localanm;
      if (((Iterator)localObject).hasNext())
      {
        localanm = (anm)((Iterator)localObject).next();
        if (localanm.Lyl != i) {}
      }
      for (;;)
      {
        label83:
        if (localanm == null)
        {
          localanm = new anm();
          localanm.Lyl = i;
          this.taG.xuO.add(localanm);
        }
        for (;;)
        {
          localObject = localanm.Lym.iterator();
          i = k;
          label129:
          if (((Iterator)localObject).hasNext())
          {
            anl localanl = (anl)((Iterator)localObject).next();
            j = localanl.Lyk.compareTo(str);
            if (j != 0) {
              break label343;
            }
            j = localanl.FeZ.compareTo(paramString);
          }
          label343:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(103420);
              return;
              if (localanm.Lyl > i)
              {
                localanm = new anm();
                localanm.Lyl = i;
                this.taG.xuO.add(j, localanm);
                break label83;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new anl();
              ((anl)localObject).FeZ = paramString;
              ((anl)localObject).Lyk = str;
              localanm.Lym.add(i, localObject);
              save();
              mw(true);
              AppMethodBeat.o(103420);
              return;
            }
            i += 1;
            break label129;
            localObject = new anl();
            ((anl)localObject).FeZ = paramString;
            ((anl)localObject).Lyk = str;
            localanm.Lym.add(localObject);
            mw(true);
            save();
            AppMethodBeat.o(103420);
            return;
          }
        }
        localanm = null;
      }
    }
  }
  
  final void arX(String paramString)
  {
    AppMethodBeat.i(103424);
    String str = f.Sh(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.taG.xuO.iterator();
      int i = 0;
      anm localanm;
      if (localIterator.hasNext())
      {
        localanm = (anm)localIterator.next();
        if (localanm.Lyl != j) {}
      }
      for (;;)
      {
        if (localanm == null)
        {
          AppMethodBeat.o(103424);
          return;
          if (localanm.Lyl > j)
          {
            AppMethodBeat.o(103424);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localanm.Lym.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          anl localanl = (anl)localIterator.next();
          int m = localanl.Lyk.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localanl.FeZ.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().asc(localanl.FeZ))
            {
              localanm.Lym.remove(j);
              if (localanm.Lym.isEmpty()) {
                this.taG.xuO.remove(i);
              }
              mw(false);
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
        localanm = null;
      }
    }
  }
  
  public final int cUF()
  {
    AppMethodBeat.i(103418);
    Iterator localIterator = this.taG.xuO.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((anm)localIterator.next()).Lym.size() + i) {}
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
    Log.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[] { paramSet });
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
    paramg = paramg.field_tagProto.Lyo.iterator();
    while (paramg.hasNext()) {
      removeTag((String)paramg.next());
    }
    AppMethodBeat.o(103421);
  }
  
  public static abstract interface a
  {
    public abstract void cUG();
    
    public abstract void cUH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */