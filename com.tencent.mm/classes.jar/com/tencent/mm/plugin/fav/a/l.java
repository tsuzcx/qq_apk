package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.aop;
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

public class l
{
  public HashMap<String, WeakReference<a>> bqq;
  private boolean dirty;
  public aoo wGL;
  private HashSet<Integer> wGM;
  private List<aom> wGN;
  
  public l()
  {
    AppMethodBeat.i(103413);
    this.wGL = new aoo();
    this.bqq = new HashMap();
    this.wGM = new HashSet();
    this.dirty = true;
    this.wGN = new LinkedList();
    byte[] arrayOfByte = Util.decodeHexString((String)h.aHG().aHp().b(225283, ""));
    try
    {
      this.wGL.parseFrom(arrayOfByte);
      Log.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.wGL.Crg });
      AppMethodBeat.o(103413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        Log.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.wGL = new aoo();
      }
    }
  }
  
  private void arg()
  {
    AppMethodBeat.i(103416);
    try
    {
      byte[] arrayOfByte = this.wGL.toByteArray();
      h.aHJ().postToWorker(new l.1(this, arrayOfByte));
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
  
  private void azX(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(103420);
    String str = com.tencent.mm.platformtools.f.ZJ(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.wGL.Crg.iterator();
      int j = 0;
      aon localaon;
      if (((Iterator)localObject).hasNext())
      {
        localaon = (aon)((Iterator)localObject).next();
        if (localaon.SAM != i) {}
      }
      for (;;)
      {
        label82:
        if (localaon == null)
        {
          localaon = new aon();
          localaon.SAM = i;
          this.wGL.Crg.add(localaon);
        }
        for (;;)
        {
          localObject = localaon.SAN.iterator();
          i = k;
          label128:
          if (((Iterator)localObject).hasNext())
          {
            aom localaom = (aom)((Iterator)localObject).next();
            j = localaom.SAL.compareTo(str);
            if (j != 0) {
              break label339;
            }
            j = localaom.LtE.compareTo(paramString);
          }
          label339:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(103420);
              return;
              if (localaon.SAM > i)
              {
                localaon = new aon();
                localaon.SAM = i;
                this.wGL.Crg.add(j, localaon);
                break label82;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new aom();
              ((aom)localObject).LtE = paramString;
              ((aom)localObject).SAL = str;
              localaon.SAN.add(i, localObject);
              arg();
              nJ(true);
              AppMethodBeat.o(103420);
              return;
            }
            i += 1;
            break label128;
            localObject = new aom();
            ((aom)localObject).LtE = paramString;
            ((aom)localObject).SAL = str;
            localaon.SAN.add(localObject);
            nJ(true);
            arg();
            AppMethodBeat.o(103420);
            return;
          }
        }
        localaon = null;
      }
    }
  }
  
  private void azY(String paramString)
  {
    AppMethodBeat.i(103424);
    String str = com.tencent.mm.platformtools.f.ZJ(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.wGL.Crg.iterator();
      int i = 0;
      aon localaon;
      if (localIterator.hasNext())
      {
        localaon = (aon)localIterator.next();
        if (localaon.SAM != j) {}
      }
      for (;;)
      {
        if (localaon == null)
        {
          AppMethodBeat.o(103424);
          return;
          if (localaon.SAM > j)
          {
            AppMethodBeat.o(103424);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localaon.SAN.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          aom localaom = (aom)localIterator.next();
          int m = localaom.SAL.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localaom.LtE.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((ag)h.ag(ag.class)).getFavSearchStorage().aAd(localaom.LtE))
            {
              localaon.SAN.remove(j);
              if (localaon.SAN.isEmpty()) {
                this.wGL.Crg.remove(i);
              }
              nJ(false);
              arg();
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
        localaon = null;
      }
    }
  }
  
  private void nJ(boolean paramBoolean)
  {
    AppMethodBeat.i(103415);
    Iterator localIterator = this.bqq.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((a)localWeakReference.get()).djM();
        } else {
          ((a)localWeakReference.get()).djN();
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
    this.wGM.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      Log.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103412);
          l.b(l.this, paramString);
          AppMethodBeat.o(103412);
        }
      });
      AppMethodBeat.o(103423);
      return;
    }
    Log.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    azY(paramString);
    AppMethodBeat.o(103423);
  }
  
  public final List<aom> LG(int paramInt)
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
      this.wGN.clear();
      localObject = this.wGL.Crg.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aon localaon = (aon)((Iterator)localObject).next();
        this.wGN.addAll(localaon.SAN);
      }
      this.dirty = false;
    }
    Log.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.wGN.size()) });
    Object localObject = this.wGN;
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
    this.bqq.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(103414);
  }
  
  public final void azW(final String paramString)
  {
    AppMethodBeat.i(103419);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103419);
      return;
    }
    if (this.wGM.contains(Integer.valueOf(paramString.hashCode())))
    {
      Log.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(103419);
      return;
    }
    this.wGM.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      Log.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103411);
          l.a(l.this, paramString);
          AppMethodBeat.o(103411);
        }
      });
      AppMethodBeat.o(103419);
      return;
    }
    Log.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    azX(paramString);
    AppMethodBeat.o(103419);
  }
  
  public final int djL()
  {
    AppMethodBeat.i(103418);
    Iterator localIterator = this.wGL.Crg.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((aon)localIterator.next()).SAN.size() + i) {}
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
    paramg = paramg.field_tagProto.SAP.iterator();
    while (paramg.hasNext()) {
      removeTag((String)paramg.next());
    }
    AppMethodBeat.o(103421);
  }
  
  public static abstract interface a
  {
    public abstract void djM();
    
    public abstract void djN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */