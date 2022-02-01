package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
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
  public ash AcU;
  private HashSet<Integer> AcV;
  private List<asf> AcW;
  private boolean dirty;
  public HashMap<String, WeakReference<a>> djU;
  
  public l()
  {
    AppMethodBeat.i(103413);
    this.AcU = new ash();
    this.djU = new HashMap();
    this.AcV = new HashSet();
    this.dirty = true;
    this.AcW = new LinkedList();
    byte[] arrayOfByte = Util.decodeHexString((String)h.baE().ban().d(225283, ""));
    try
    {
      this.AcU.parseFrom(arrayOfByte);
      Log.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.AcU.Idn });
      AppMethodBeat.o(103413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        Log.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.AcU = new ash();
      }
    }
  }
  
  private void aud(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(103420);
    String str = com.tencent.mm.platformtools.f.RZ(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.AcU.Idn.iterator();
      int j = 0;
      asg localasg;
      if (((Iterator)localObject).hasNext())
      {
        localasg = (asg)((Iterator)localObject).next();
        if (localasg.ZBE != i) {}
      }
      for (;;)
      {
        label82:
        if (localasg == null)
        {
          localasg = new asg();
          localasg.ZBE = i;
          this.AcU.Idn.add(localasg);
        }
        for (;;)
        {
          localObject = localasg.ZBF.iterator();
          i = k;
          label128:
          if (((Iterator)localObject).hasNext())
          {
            asf localasf = (asf)((Iterator)localObject).next();
            j = localasf.ZBD.compareTo(str);
            if (j != 0) {
              break label339;
            }
            j = localasf.RWX.compareTo(paramString);
          }
          label339:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(103420);
              return;
              if (localasg.ZBE > i)
              {
                localasg = new asg();
                localasg.ZBE = i;
                this.AcU.Idn.add(j, localasg);
                break label82;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new asf();
              ((asf)localObject).RWX = paramString;
              ((asf)localObject).ZBD = str;
              localasg.ZBF.add(i, localObject);
              sz();
              pj(true);
              AppMethodBeat.o(103420);
              return;
            }
            i += 1;
            break label128;
            localObject = new asf();
            ((asf)localObject).RWX = paramString;
            ((asf)localObject).ZBD = str;
            localasg.ZBF.add(localObject);
            pj(true);
            sz();
            AppMethodBeat.o(103420);
            return;
          }
        }
        localasg = null;
      }
    }
  }
  
  private void aue(final String paramString)
  {
    AppMethodBeat.i(103423);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103423);
      return;
    }
    this.AcV.remove(Integer.valueOf(paramString.hashCode()));
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
    auf(paramString);
    AppMethodBeat.o(103423);
  }
  
  private void auf(String paramString)
  {
    AppMethodBeat.i(103424);
    String str = com.tencent.mm.platformtools.f.RZ(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.AcU.Idn.iterator();
      int i = 0;
      asg localasg;
      if (localIterator.hasNext())
      {
        localasg = (asg)localIterator.next();
        if (localasg.ZBE != j) {}
      }
      for (;;)
      {
        if (localasg == null)
        {
          AppMethodBeat.o(103424);
          return;
          if (localasg.ZBE > j)
          {
            AppMethodBeat.o(103424);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localasg.ZBF.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          asf localasf = (asf)localIterator.next();
          int m = localasf.ZBD.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localasf.RWX.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((ah)h.az(ah.class)).getFavSearchStorage().auk(localasf.RWX))
            {
              localasg.ZBF.remove(j);
              if (localasg.ZBF.isEmpty()) {
                this.AcU.Idn.remove(i);
              }
              pj(false);
              sz();
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
        localasg = null;
      }
    }
  }
  
  public static int dQw()
  {
    return 1;
  }
  
  private void pj(boolean paramBoolean)
  {
    AppMethodBeat.i(103415);
    Iterator localIterator = this.djU.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((a)localWeakReference.get()).dQy();
        } else {
          ((a)localWeakReference.get()).dQz();
        }
      }
    }
    AppMethodBeat.o(103415);
  }
  
  private void sz()
  {
    AppMethodBeat.i(103416);
    try
    {
      byte[] arrayOfByte = this.AcU.toByteArray();
      h.baH().postToWorker(new l.1(this, arrayOfByte));
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
  
  public final List<asf> MD(int paramInt)
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
      this.AcW.clear();
      localObject = this.AcU.Idn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        asg localasg = (asg)((Iterator)localObject).next();
        this.AcW.addAll(localasg.ZBF);
      }
      this.dirty = false;
    }
    Log.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.AcW.size()) });
    Object localObject = this.AcW;
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
    this.djU.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(103414);
  }
  
  public final void auc(final String paramString)
  {
    AppMethodBeat.i(103419);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103419);
      return;
    }
    if (this.AcV.contains(Integer.valueOf(paramString.hashCode())))
    {
      Log.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(103419);
      return;
    }
    this.AcV.add(Integer.valueOf(paramString.hashCode()));
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
    aud(paramString);
    AppMethodBeat.o(103419);
  }
  
  public final int dQx()
  {
    AppMethodBeat.i(103418);
    Iterator localIterator = this.AcU.Idn.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((asg)localIterator.next()).ZBF.size() + i) {}
    AppMethodBeat.o(103418);
    return i;
  }
  
  public final void q(Set<String> paramSet)
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
      aue((String)paramSet.next());
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
    paramg = paramg.field_tagProto.ZBH.iterator();
    while (paramg.hasNext()) {
      aue((String)paramg.next());
    }
    AppMethodBeat.o(103421);
  }
  
  public static abstract interface a
  {
    public abstract void dQy();
    
    public abstract void dQz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */