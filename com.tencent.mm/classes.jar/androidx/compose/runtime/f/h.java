package androidx.compose.runtime.f;

import androidx.compose.runtime.bk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/Snapshot;", "", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "disposed", "", "getDisposed$runtime_release", "()Z", "setDisposed$runtime_release", "(Z)V", "<set-?>", "getId", "()I", "setId$runtime_release", "(I)V", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "modified", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime_release", "()Ljava/util/Set;", "readObserver", "Lkotlin/Function1;", "", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "writeObserver", "getWriteObserver$runtime_release", "close", "close$runtime_release", "dispose", "enter", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasPendingChanges", "makeCurrent", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "restoreCurrent", "takeNestedSnapshot", "validateNotDisposed", "validateNotDisposed$runtime_release", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h
{
  public static final int Ue = 8;
  public static final a asx = new a((byte)0);
  private boolean anC;
  private j asy;
  private int id;
  
  private h(int paramInt, j paramj)
  {
    this.asy = paramj;
    this.id = paramInt;
  }
  
  public static void c(h paramh)
  {
    l.rB().set(paramh);
  }
  
  public abstract void a(aa paramaa);
  
  public abstract void a(h paramh);
  
  public abstract void b(h paramh);
  
  public void cq(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void dispose()
  {
    this.anC = true;
  }
  
  public void e(j paramj)
  {
    s.u(paramj, "<set-?>");
    this.asy = paramj;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public abstract h h(b<Object, ah> paramb);
  
  public abstract void rf();
  
  public abstract b<Object, ah> rh();
  
  public abstract b<Object, ah> ri();
  
  public abstract boolean rj();
  
  public void rk()
  {
    synchronized ()
    {
      l.l(l.rG().ct(getId()));
      ah localah = ah.aiuX;
      return;
    }
  }
  
  public j rq()
  {
    return this.asy;
  }
  
  public final h rr()
  {
    h localh = (h)l.rB().get();
    l.rB().set(this);
    return localh;
  }
  
  public final boolean rs()
  {
    return this.anC;
  }
  
  public final void rt()
  {
    this.anC = true;
  }
  
  public final void ru()
  {
    if (!this.anC) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Cannot use a disposed snapshot".toString()));
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "()V", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "global", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "notifyObjectsInitialized", "", "observe", "readObserver", "Lkotlin/Function1;", "writeObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshotCount", "", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "observer", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "removeCurrent", "restoreCurrent", "previous", "sendApplyNotifications", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeSnapshot", "withMutableSnapshot", "R", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T> T a(b<Object, ah> paramb, kotlin.g.a.a<? extends T> parama)
    {
      AppMethodBeat.i(202687);
      s.u(parama, "block");
      Object localObject;
      if (paramb != null)
      {
        localObject = (h)l.rB().get();
        if ((localObject == null) || ((localObject instanceof c))) {
          if ((localObject instanceof c)) {
            localObject = (c)localObject;
          }
        }
        for (paramb = (h)new ad((c)localObject, paramb);; paramb = ((h)localObject).h(paramb))
        {
          try
          {
            localObject = paramb.rr();
            try
            {
              parama = parama.invoke();
              h.c((h)localObject);
              return parama;
            }
            finally
            {
              h.c((h)localObject);
            }
            localObject = null;
            break;
          }
          finally
          {
            AppMethodBeat.o(202687);
          }
          if (paramb == null)
          {
            paramb = parama.invoke();
            AppMethodBeat.o(202687);
            return paramb;
          }
        }
      }
      paramb = parama.invoke();
      AppMethodBeat.o(202687);
      return paramb;
    }
    
    public static f c(m<? super Set<? extends Object>, ? super h, ah> paramm)
    {
      AppMethodBeat.i(202696);
      s.u(paramm, "observer");
      l.k(l.rC());
      synchronized (l.ry())
      {
        l.rD().add(paramm);
        paramm = (f)new a(paramm);
        AppMethodBeat.o(202696);
        return paramm;
      }
    }
    
    public static c d(b<Object, ah> paramb1, b<Object, ah> paramb2)
    {
      AppMethodBeat.i(202676);
      Object localObject = l.rx();
      if ((localObject instanceof c)) {}
      for (localObject = (c)localObject; localObject == null; localObject = null)
      {
        paramb1 = (Throwable)new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
        AppMethodBeat.o(202676);
        throw paramb1;
      }
      paramb1 = ((c)localObject).c(paramb1, paramb2);
      AppMethodBeat.o(202676);
      return paramb1;
    }
    
    public static f i(b<Object, ah> paramb)
    {
      AppMethodBeat.i(202702);
      s.u(paramb, "observer");
      synchronized (l.ry())
      {
        l.rF().add(paramb);
        l.rE();
        paramb = (f)new b(paramb);
        AppMethodBeat.o(202702);
        return paramb;
      }
    }
    
    public static void rv()
    {
      AppMethodBeat.i(202707);
      synchronized (l.ry())
      {
        Set localSet = ((a)l.rH().get()).rn();
        if (localSet != null)
        {
          boolean bool = ((Collection)localSet).isEmpty();
          if (!bool) {}
          for (i = 1; i == 1; i = 0)
          {
            i = 1;
            if (i != 0) {
              l.rE();
            }
            AppMethodBeat.o(202707);
            return;
          }
        }
        int i = 0;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements f
    {
      a(m<? super Set<? extends Object>, ? super h, ah> paramm) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(202689);
        Object localObject2 = this.asz;
        synchronized (l.ry())
        {
          l.rD().remove(localObject2);
          localObject2 = ah.aiuX;
          AppMethodBeat.o(202689);
          return;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      implements f
    {
      b(b<Object, ah> paramb) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(202694);
        b localb = this.asA;
        synchronized (l.ry())
        {
          l.rF().remove(localb);
          l.rE();
          AppMethodBeat.o(202694);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.h
 * JD-Core Version:    0.7.0.1
 */