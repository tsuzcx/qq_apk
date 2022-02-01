package androidx.fragment.app;

import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class k
  extends af
{
  private static final ah.b bDl;
  final HashMap<String, Fragment> bDm;
  final HashMap<String, k> bDn;
  final HashMap<String, aj> bDo;
  final boolean bDp;
  boolean bDq;
  private boolean bDr;
  boolean bDs;
  
  static
  {
    AppMethodBeat.i(193752);
    bDl = new ah.b()
    {
      public final <T extends af> T create(Class<T> paramAnonymousClass)
      {
        AppMethodBeat.i(193471);
        paramAnonymousClass = new k(true);
        AppMethodBeat.o(193471);
        return paramAnonymousClass;
      }
    };
    AppMethodBeat.o(193752);
  }
  
  k(boolean paramBoolean)
  {
    AppMethodBeat.i(193745);
    this.bDm = new HashMap();
    this.bDn = new HashMap();
    this.bDo = new HashMap();
    this.bDq = false;
    this.bDr = false;
    this.bDs = false;
    this.bDp = paramBoolean;
    AppMethodBeat.o(193745);
  }
  
  static k a(aj paramaj)
  {
    AppMethodBeat.i(193735);
    paramaj = (k)new ah(paramaj, bDl).q(k.class);
    AppMethodBeat.o(193735);
    return paramaj;
  }
  
  @Deprecated
  final j Go()
  {
    AppMethodBeat.i(193798);
    if ((this.bDm.isEmpty()) && (this.bDn.isEmpty()) && (this.bDo.isEmpty()))
    {
      AppMethodBeat.o(193798);
      return null;
    }
    Object localObject = new HashMap();
    Iterator localIterator = this.bDn.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      j localj = ((k)localEntry.getValue()).Go();
      if (localj != null) {
        ((HashMap)localObject).put(localEntry.getKey(), localj);
      }
    }
    this.bDr = true;
    if ((this.bDm.isEmpty()) && (((HashMap)localObject).isEmpty()) && (this.bDo.isEmpty()))
    {
      AppMethodBeat.o(193798);
      return null;
    }
    localObject = new j(new ArrayList(this.bDm.values()), (Map)localObject, new HashMap(this.bDo));
    AppMethodBeat.o(193798);
    return localObject;
  }
  
  @Deprecated
  final void a(j paramj)
  {
    AppMethodBeat.i(193787);
    this.bDm.clear();
    this.bDn.clear();
    this.bDo.clear();
    if (paramj != null)
    {
      Object localObject1 = paramj.bDa;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Fragment)((Iterator)localObject1).next();
          if (localObject2 != null) {
            this.bDm.put(((Fragment)localObject2).mWho, localObject2);
          }
        }
      }
      localObject1 = paramj.bDb;
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          k localk = new k(this.bDp);
          localk.a((j)((Map.Entry)localObject2).getValue());
          this.bDn.put(((Map.Entry)localObject2).getKey(), localk);
        }
      }
      paramj = paramj.bDc;
      if (paramj != null) {
        this.bDo.putAll(paramj);
      }
    }
    this.bDr = false;
    AppMethodBeat.o(193787);
  }
  
  final void addRetainedFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(193764);
    if (this.bDs)
    {
      FragmentManager.isLoggingEnabled(2);
      AppMethodBeat.o(193764);
      return;
    }
    if (this.bDm.containsKey(paramFragment.mWho))
    {
      AppMethodBeat.o(193764);
      return;
    }
    this.bDm.put(paramFragment.mWho, paramFragment);
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("Updating retained Fragments: Added ").append(paramFragment);
    }
    AppMethodBeat.o(193764);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193806);
    if (this == paramObject)
    {
      AppMethodBeat.o(193806);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(193806);
      return false;
    }
    paramObject = (k)paramObject;
    if ((this.bDm.equals(paramObject.bDm)) && (this.bDn.equals(paramObject.bDn)) && (this.bDo.equals(paramObject.bDo)))
    {
      AppMethodBeat.o(193806);
      return true;
    }
    AppMethodBeat.o(193806);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193813);
    int i = this.bDm.hashCode();
    int j = this.bDn.hashCode();
    int k = this.bDo.hashCode();
    AppMethodBeat.o(193813);
    return (i * 31 + j) * 31 + k;
  }
  
  final boolean o(Fragment paramFragment)
  {
    AppMethodBeat.i(193771);
    if (!this.bDm.containsKey(paramFragment.mWho))
    {
      AppMethodBeat.o(193771);
      return true;
    }
    if (this.bDp)
    {
      boolean bool = this.bDq;
      AppMethodBeat.o(193771);
      return bool;
    }
    if (!this.bDr)
    {
      AppMethodBeat.o(193771);
      return true;
    }
    AppMethodBeat.o(193771);
    return false;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(193759);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("onCleared called for ").append(this);
    }
    this.bDq = true;
    AppMethodBeat.o(193759);
  }
  
  final void removeRetainedFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(193777);
    if (this.bDs)
    {
      FragmentManager.isLoggingEnabled(2);
      AppMethodBeat.o(193777);
      return;
    }
    if (this.bDm.remove(paramFragment.mWho) != null) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (FragmentManager.isLoggingEnabled(2))) {
        new StringBuilder("Updating retained Fragments: Removed ").append(paramFragment);
      }
      AppMethodBeat.o(193777);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193823);
    Object localObject = new StringBuilder("FragmentManagerViewModel{");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append("} Fragments (");
    Iterator localIterator = this.bDm.values().iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append(localIterator.next());
      if (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(", ");
      }
    }
    ((StringBuilder)localObject).append(") Child Non Config (");
    localIterator = this.bDn.keySet().iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append((String)localIterator.next());
      if (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(", ");
      }
    }
    ((StringBuilder)localObject).append(") ViewModelStores (");
    localIterator = this.bDo.keySet().iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append((String)localIterator.next());
      if (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(", ");
      }
    }
    ((StringBuilder)localObject).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(193823);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.k
 * JD-Core Version:    0.7.0.1
 */