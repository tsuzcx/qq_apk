package com.tencent.mm.kernel.mvvm;

import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/mvvm/PluginLifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "()V", "observerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/lifecycle/LifecycleObserver;", "getObserverMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setObserverMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "state", "Landroidx/lifecycle/Lifecycle$State;", "addObserver", "", "observer", "getCurrentState", "moveToCreateState", "moveToDestroyState", "removeObserver", "Companion", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
  extends j
{
  public static final f.a mFF;
  public ConcurrentHashMap<Integer, p> observerMap;
  public j.b state;
  
  static
  {
    AppMethodBeat.i(235269);
    mFF = new f.a((byte)0);
    AppMethodBeat.o(235269);
  }
  
  public f()
  {
    AppMethodBeat.i(235265);
    this.state = j.b.bHh;
    this.observerMap = new ConcurrentHashMap();
    AppMethodBeat.o(235265);
  }
  
  public void addObserver(p paramp)
  {
    AppMethodBeat.i(235273);
    s.u(paramp, "observer");
    ConcurrentHashMap localConcurrentHashMap = this.observerMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.put(Integer.valueOf(paramp.hashCode()), paramp);
    }
    AppMethodBeat.o(235273);
  }
  
  public j.b getCurrentState()
  {
    return this.state;
  }
  
  public void removeObserver(p paramp)
  {
    AppMethodBeat.i(235276);
    s.u(paramp, "observer");
    ConcurrentHashMap localConcurrentHashMap = this.observerMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(Integer.valueOf(paramp.hashCode()));
    }
    AppMethodBeat.o(235276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.mvvm.f
 * JD-Core Version:    0.7.0.1
 */