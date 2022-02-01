package androidx.compose.ui.platform;

import androidx.compose.runtime.f.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/GlobalSnapshotManager;", "", "()V", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ensureStarted", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  public static final z aUi;
  private static final AtomicBoolean aUj;
  
  static
  {
    AppMethodBeat.i(206786);
    aUi = new z();
    aUj = new AtomicBoolean(false);
    AppMethodBeat.o(206786);
  }
  
  public static void zf()
  {
    AppMethodBeat.i(206781);
    if (aUj.compareAndSet(false, true))
    {
      kotlinx.coroutines.a.h localh = kotlinx.coroutines.a.k.a(-1, null, 6);
      Object localObject = m.aTa;
      kotlinx.coroutines.j.a(ar.d(m.a.yP()), null, null, (kotlin.g.a.m)new a(localh, null), 3);
      localObject = androidx.compose.runtime.f.h.asx;
      h.a.i((b)new b(localh));
    }
    AppMethodBeat.o(206781);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(kotlinx.coroutines.a.h<ah> paramh, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(206548);
      paramObject = (d)new a(this.aaM, paramd);
      AppMethodBeat.o(206548);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(206536);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(206536);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (x)this.aaM;
      }
      for (;;)
      {
        try
        {
          kotlinx.coroutines.a.j localj = paramObject.kCW();
          localObject1 = paramObject;
          try
          {
            this.L$0 = paramObject;
            localObject1 = paramObject;
            this.Uf = localj;
            localObject1 = paramObject;
            this.label = 1;
            localObject1 = paramObject;
            Object localObject6 = localj.aC(this);
            localObject1 = localObject6;
            Object localObject7 = localObject1;
            if (localObject1 == locala)
            {
              AppMethodBeat.o(206536);
              return locala;
              localj = (kotlinx.coroutines.a.j)this.Uf;
              localObject6 = (x)this.L$0;
              localObject1 = localObject6;
              ResultKt.throwOnFailure(paramObject);
              localObject7 = paramObject;
              paramObject = localObject6;
            }
            localObject1 = paramObject;
            if (!((Boolean)localObject7).booleanValue()) {
              continue;
            }
            localObject1 = paramObject;
            localj.next();
            localObject1 = paramObject;
            localObject6 = androidx.compose.runtime.f.h.asx;
            localObject1 = paramObject;
            h.a.rv();
            continue;
          }
          finally {}
        }
        finally
        {
          Object localObject1;
          Object localObject5 = paramObject;
          paramObject = localObject2;
          Object localObject3 = localObject5;
          continue;
        }
        try
        {
          AppMethodBeat.o(206536);
          throw paramObject;
        }
        finally
        {
          kotlinx.coroutines.a.m.a(localObject1, paramObject);
          AppMethodBeat.o(206536);
        }
      }
      localObject1 = paramObject;
      localObject5 = ah.aiuX;
      kotlinx.coroutines.a.m.a(paramObject, null);
      paramObject = ah.aiuX;
      AppMethodBeat.o(206536);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Object, ah>
  {
    b(kotlinx.coroutines.a.h<ah> paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.z
 * JD-Core Version:    0.7.0.1
 */