package androidx.fragment.app;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class q
{
  final HashMap<String, o> bDB;
  final ArrayList<Fragment> bDe;
  k mNonConfig;
  
  q()
  {
    AppMethodBeat.i(193693);
    this.bDe = new ArrayList();
    this.bDB = new HashMap();
    AppMethodBeat.o(193693);
  }
  
  final List<o> GA()
  {
    AppMethodBeat.i(193766);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.bDB.values().iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localArrayList.add(localo);
      }
    }
    AppMethodBeat.o(193766);
    return localArrayList;
  }
  
  final void Gq()
  {
    AppMethodBeat.i(193727);
    Iterator localIterator = this.bDe.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Fragment)localIterator.next();
      localObject = (o)this.bDB.get(((Fragment)localObject).mWho);
      if (localObject != null) {
        ((o)localObject).Gq();
      }
    }
    localIterator = this.bDB.values().iterator();
    label137:
    while (localIterator.hasNext())
    {
      localObject = (o)localIterator.next();
      if (localObject != null)
      {
        ((o)localObject).Gq();
        Fragment localFragment = ((o)localObject).bDv;
        if ((localFragment.mRemoving) && (!localFragment.isInBackStack())) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label137;
          }
          b((o)localObject);
          break;
        }
      }
    }
    AppMethodBeat.o(193727);
  }
  
  final void Gy()
  {
    AppMethodBeat.i(193751);
    this.bDB.values().removeAll(Collections.singleton(null));
    AppMethodBeat.o(193751);
  }
  
  final ArrayList<String> Gz()
  {
    AppMethodBeat.i(193761);
    synchronized (this.bDe)
    {
      if (this.bDe.isEmpty())
      {
        AppMethodBeat.o(193761);
        return null;
      }
      ArrayList localArrayList2 = new ArrayList(this.bDe.size());
      Iterator localIterator = this.bDe.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        localArrayList2.add(localFragment.mWho);
        if (FragmentManager.isLoggingEnabled(2)) {
          new StringBuilder("saveAllState: adding fragment (").append(localFragment.mWho).append("): ").append(localFragment);
        }
      }
    }
    AppMethodBeat.o(193761);
    return localArrayList;
  }
  
  final void X(List<String> paramList)
  {
    AppMethodBeat.i(193699);
    this.bDe.clear();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        Fragment localFragment = findActiveFragment(str);
        if (localFragment == null)
        {
          paramList = new IllegalStateException("No instantiated fragment for (" + str + ")");
          AppMethodBeat.o(193699);
          throw paramList;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
          new StringBuilder("restoreSaveState: added (").append(str).append("): ").append(localFragment);
        }
        p(localFragment);
      }
    }
    AppMethodBeat.o(193699);
  }
  
  final void a(o paramo)
  {
    AppMethodBeat.i(193711);
    Fragment localFragment = paramo.bDv;
    if (aG(localFragment.mWho))
    {
      AppMethodBeat.o(193711);
      return;
    }
    this.bDB.put(localFragment.mWho, paramo);
    if (localFragment.mRetainInstanceChangedWhileDetached)
    {
      if (!localFragment.mRetainInstance) {
        break label94;
      }
      this.mNonConfig.addRetainedFragment(localFragment);
    }
    for (;;)
    {
      localFragment.mRetainInstanceChangedWhileDetached = false;
      if (FragmentManager.isLoggingEnabled(2)) {
        new StringBuilder("Added fragment to active set ").append(localFragment);
      }
      AppMethodBeat.o(193711);
      return;
      label94:
      this.mNonConfig.removeRetainedFragment(localFragment);
    }
  }
  
  final boolean aG(String paramString)
  {
    AppMethodBeat.i(193789);
    if (this.bDB.get(paramString) != null)
    {
      AppMethodBeat.o(193789);
      return true;
    }
    AppMethodBeat.o(193789);
    return false;
  }
  
  final o aH(String paramString)
  {
    AppMethodBeat.i(193796);
    paramString = (o)this.bDB.get(paramString);
    AppMethodBeat.o(193796);
    return paramString;
  }
  
  final void b(o paramo)
  {
    AppMethodBeat.i(193743);
    paramo = paramo.bDv;
    if (paramo.mRetainInstance) {
      this.mNonConfig.removeRetainedFragment(paramo);
    }
    if ((o)this.bDB.put(paramo.mWho, null) == null)
    {
      AppMethodBeat.o(193743);
      return;
    }
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("Removed fragment from active set ").append(paramo);
    }
    AppMethodBeat.o(193743);
  }
  
  final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(193832);
    String str = paramString + "    ";
    if (!this.bDB.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Active Fragments:");
      Iterator localIterator = this.bDB.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (o)localIterator.next();
        paramPrintWriter.print(paramString);
        if (localObject != null)
        {
          localObject = ((o)localObject).bDv;
          paramPrintWriter.println(localObject);
          ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        else
        {
          paramPrintWriter.println("null");
        }
      }
    }
    int j = this.bDe.size();
    if (j > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      int i = 0;
      while (i < j)
      {
        paramFileDescriptor = (Fragment)this.bDe.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
    AppMethodBeat.o(193832);
  }
  
  final Fragment findActiveFragment(String paramString)
  {
    AppMethodBeat.i(193812);
    paramString = (o)this.bDB.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.bDv;
      AppMethodBeat.o(193812);
      return paramString;
    }
    AppMethodBeat.o(193812);
    return null;
  }
  
  final Fragment findFragmentByWho(String paramString)
  {
    AppMethodBeat.i(193804);
    Iterator localIterator = this.bDB.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if (localObject != null)
      {
        localObject = ((o)localObject).bDv.findFragmentByWho(paramString);
        if (localObject != null)
        {
          AppMethodBeat.o(193804);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(193804);
    return null;
  }
  
  final List<Fragment> getActiveFragments()
  {
    AppMethodBeat.i(193782);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.bDB.values().iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localArrayList.add(localo.bDv);
      } else {
        localArrayList.add(null);
      }
    }
    AppMethodBeat.o(193782);
    return localArrayList;
  }
  
  final List<Fragment> getFragments()
  {
    AppMethodBeat.i(193775);
    if (this.bDe.isEmpty())
    {
      ??? = Collections.emptyList();
      AppMethodBeat.o(193775);
      return ???;
    }
    synchronized (this.bDe)
    {
      ArrayList localArrayList = new ArrayList(this.bDe);
      AppMethodBeat.o(193775);
      return localArrayList;
    }
  }
  
  final void p(Fragment paramFragment)
  {
    AppMethodBeat.i(193717);
    if (this.bDe.contains(paramFragment))
    {
      paramFragment = new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
      AppMethodBeat.o(193717);
      throw paramFragment;
    }
    synchronized (this.bDe)
    {
      this.bDe.add(paramFragment);
      paramFragment.mAdded = true;
      AppMethodBeat.o(193717);
      return;
    }
  }
  
  final int q(Fragment paramFragment)
  {
    AppMethodBeat.i(193822);
    ViewGroup localViewGroup = paramFragment.mContainer;
    if (localViewGroup == null)
    {
      AppMethodBeat.o(193822);
      return -1;
    }
    int j = this.bDe.indexOf(paramFragment);
    int i = j - 1;
    while (i >= 0)
    {
      paramFragment = (Fragment)this.bDe.get(i);
      if ((paramFragment.mContainer == localViewGroup) && (paramFragment.mView != null))
      {
        i = localViewGroup.indexOfChild(paramFragment.mView);
        AppMethodBeat.o(193822);
        return i + 1;
      }
      i -= 1;
    }
    i = j + 1;
    while (i < this.bDe.size())
    {
      paramFragment = (Fragment)this.bDe.get(i);
      if ((paramFragment.mContainer == localViewGroup) && (paramFragment.mView != null))
      {
        i = localViewGroup.indexOfChild(paramFragment.mView);
        AppMethodBeat.o(193822);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(193822);
    return -1;
  }
  
  final void removeFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(193733);
    synchronized (this.bDe)
    {
      this.bDe.remove(paramFragment);
      paramFragment.mAdded = false;
      AppMethodBeat.o(193733);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.q
 * JD-Core Version:    0.7.0.1
 */