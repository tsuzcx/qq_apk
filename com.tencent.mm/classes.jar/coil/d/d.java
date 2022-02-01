package coil.d;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.an;
import androidx.compose.runtime.az;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.c.c;
import coil.j.h.a;
import coil.j.i;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f.c;
import kotlin.g.a.q;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.p;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.v;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "parentScope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcoil/request/ImageRequest;", "imageLoader", "Lcoil/ImageLoader;", "(Lkotlinx/coroutines/CoroutineScope;Lcoil/request/ImageRequest;Lcoil/ImageLoader;)V", "<set-?>", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/ui/geometry/Size;", "drawSize", "getDrawSize-NH-jbRc", "()J", "setDrawSize-uvyYCjk", "(J)V", "drawSize$delegate", "getImageLoader", "()Lcoil/ImageLoader;", "setImageLoader$coil_compose_base_release", "(Lcoil/ImageLoader;)V", "imageLoader$delegate", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "isPreview", "", "isPreview$coil_compose_base_release", "()Z", "setPreview$coil_compose_base_release", "(Z)V", "onExecute", "Lcoil/compose/ImagePainter$ExecuteCallback;", "getOnExecute$coil_compose_base_release", "()Lcoil/compose/ImagePainter$ExecuteCallback;", "setOnExecute$coil_compose_base_release", "(Lcoil/compose/ImagePainter$ExecuteCallback;)V", "painter", "getPainter$coil_compose_base_release", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter$coil_compose_base_release", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "rememberScope", "getRequest", "()Lcoil/request/ImageRequest;", "setRequest$coil_compose_base_release", "(Lcoil/request/ImageRequest;)V", "request$delegate", "requestJob", "Lkotlinx/coroutines/Job;", "Lcoil/compose/ImagePainter$State;", "state", "getState", "()Lcoil/compose/ImagePainter$State;", "setState", "(Lcoil/compose/ImagePainter$State;)V", "state$delegate", "applyAlpha", "applyColorFilter", "onAbandoned", "", "onForgotten", "onRemembered", "updateRequest", "size", "updateRequest-d16Qtg0", "(Lcoil/request/ImageRequest;J)Lcoil/request/ImageRequest;", "execute", "previous", "Lcoil/compose/ImagePainter$Snapshot;", "current", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ExecuteCallback", "Snapshot", "State", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c
  implements az
{
  private final an cmn;
  private final aq cmp;
  private aq cmq;
  cb cmr;
  final an cms;
  private final an cmt;
  private final an cmu;
  a cmv;
  private final an cmw;
  final an cmx;
  final an cmy;
  boolean isPreview;
  
  public d(aq paramaq, coil.j.h paramh, coil.d paramd)
  {
    AppMethodBeat.i(188027);
    this.cmp = paramaq;
    paramaq = androidx.compose.ui.d.k.avA;
    this.cms = bj.T(androidx.compose.ui.d.k.U(androidx.compose.ui.d.k.su()));
    this.cmt = bj.T(Float.valueOf(1.0F));
    this.cmn = bj.T(null);
    this.cmu = bj.T(null);
    this.cmv = a.cmA;
    this.cmw = bj.T(d.c.a.cmF);
    this.cmx = bj.T(paramh);
    this.cmy = bj.T(paramd);
    AppMethodBeat.o(188027);
  }
  
  private c ML()
  {
    AppMethodBeat.i(188034);
    c localc = (c)((bm)this.cmu).getValue();
    AppMethodBeat.o(188034);
    return localc;
  }
  
  public final c MM()
  {
    AppMethodBeat.i(188055);
    c localc = (c)((bm)this.cmw).getValue();
    AppMethodBeat.o(188055);
    return localc;
  }
  
  public final boolean S(float paramFloat)
  {
    AppMethodBeat.i(188078);
    this.cmt.setValue(Float.valueOf(paramFloat));
    AppMethodBeat.o(188078);
    return true;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(188049);
    this.cmu.setValue(paramc);
    AppMethodBeat.o(188049);
  }
  
  public final void b(androidx.compose.ui.e.b.e parame)
  {
    AppMethodBeat.i(188070);
    s.u(parame, "<this>");
    long l = parame.sf();
    this.cms.setValue(androidx.compose.ui.d.k.U(l));
    c localc = ML();
    if (localc != null) {
      localc.a(parame, parame.sf(), ((Number)((bm)this.cmt).getValue()).floatValue(), (aa)((bm)this.cmn).getValue());
    }
    AppMethodBeat.o(188070);
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(188086);
    this.cmn.setValue(paramaa);
    AppMethodBeat.o(188086);
    return true;
  }
  
  public final void mJ()
  {
    AppMethodBeat.i(188091);
    if (this.isPreview)
    {
      AppMethodBeat.o(188091);
      return;
    }
    Object localObject = this.cmq;
    if (localObject != null) {
      ar.a((aq)localObject, null);
    }
    localObject = this.cmp.getCoroutineContext();
    localObject = ar.d(((kotlin.d.f)localObject).plus((kotlin.d.f)cx.g((cb)((kotlin.d.f)localObject).get((f.c)cb.ajws))));
    this.cmq = ((aq)localObject);
    j.a((aq)localObject, null, null, (kotlin.g.a.m)new e(this, null), 3);
    AppMethodBeat.o(188091);
  }
  
  public final void mK()
  {
    AppMethodBeat.i(188099);
    Object localObject = this.cmq;
    if (localObject != null) {
      ar.a((aq)localObject, null);
    }
    this.cmq = null;
    localObject = this.cmr;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    this.cmr = null;
    AppMethodBeat.o(188099);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(188107);
    mK();
    AppMethodBeat.o(188107);
  }
  
  public final long uM()
  {
    AppMethodBeat.i(188062);
    Object localObject = ML();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = androidx.compose.ui.d.k.U(((c)localObject).uM()))
    {
      localObject = androidx.compose.ui.d.k.avA;
      l = androidx.compose.ui.d.k.sw();
      AppMethodBeat.o(188062);
      return l;
    }
    long l = ((androidx.compose.ui.d.k)localObject).avp;
    AppMethodBeat.o(188062);
    return l;
  }
  
  @Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter$ExecuteCallback;", "", "invoke", "", "previous", "Lcoil/compose/ImagePainter$Snapshot;", "current", "Companion", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public static final a cmA = (a)b.cmC;
    public static final d.a.a cmz = d.a.a.cmB;
    
    public abstract boolean a(d.b paramb1, d.b paramb2);
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "previous", "Lcoil/compose/ImagePainter$Snapshot;", "current"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      implements d.a
    {
      public static final b cmC;
      
      static
      {
        AppMethodBeat.i(187999);
        cmC = new b();
        AppMethodBeat.o(187999);
      }
      
      public final boolean a(d.b paramb1, d.b paramb2)
      {
        AppMethodBeat.i(188009);
        s.u(paramb2, "current");
        if (!s.p(paramb2.cmD, d.c.a.cmF)) {
          if (paramb1 != null) {
            break label48;
          }
        }
        label48:
        for (paramb1 = null; !s.p(paramb1, paramb2.cmE); paramb1 = paramb1.cmE)
        {
          AppMethodBeat.o(188009);
          return true;
        }
        AppMethodBeat.o(188009);
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter$Snapshot;", "", "state", "Lcoil/compose/ImagePainter$State;", "request", "Lcoil/request/ImageRequest;", "size", "Landroidx/compose/ui/geometry/Size;", "(Lcoil/compose/ImagePainter$State;Lcoil/request/ImageRequest;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRequest", "()Lcoil/request/ImageRequest;", "getSize-NH-jbRc", "()J", "J", "getState", "()Lcoil/compose/ImagePainter$State;", "component1", "component2", "component3", "component3-NH-jbRc", "copy", "copy-cSwnlzA", "(Lcoil/compose/ImagePainter$State;Lcoil/request/ImageRequest;J)Lcoil/compose/ImagePainter$Snapshot;", "equals", "", "other", "hashCode", "", "toString", "", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final int Ue = 8;
    final d.c cmD;
    final coil.j.h cmE;
    final long size;
    
    private b(d.c paramc, coil.j.h paramh, long paramLong)
    {
      this.cmD = paramc;
      this.cmE = paramh;
      this.size = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(187992);
      if (this == paramObject)
      {
        AppMethodBeat.o(187992);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(187992);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.cmD, paramObject.cmD))
      {
        AppMethodBeat.o(187992);
        return false;
      }
      if (!s.p(this.cmE, paramObject.cmE))
      {
        AppMethodBeat.o(187992);
        return false;
      }
      if (!androidx.compose.ui.d.k.e(this.size, paramObject.size))
      {
        AppMethodBeat.o(187992);
        return false;
      }
      AppMethodBeat.o(187992);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(187984);
      int i = this.cmD.hashCode();
      int j = this.cmE.hashCode();
      int k = androidx.compose.ui.d.k.I(this.size);
      AppMethodBeat.o(187984);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(187974);
      String str = "Snapshot(state=" + this.cmD + ", request=" + this.cmE + ", size=" + androidx.compose.ui.d.k.H(this.size) + ')';
      AppMethodBeat.o(187974);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter$State;", "", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Error", "Loading", "Success", "Lcoil/compose/ImagePainter$State$Empty;", "Lcoil/compose/ImagePainter$State$Loading;", "Lcoil/compose/ImagePainter$State$Success;", "Lcoil/compose/ImagePainter$State$Error;", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class c
  {
    public abstract c MN();
    
    @Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter$State$Empty;", "Lcoil/compose/ImagePainter$State;", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends d.c
    {
      public static final a cmF;
      
      static
      {
        AppMethodBeat.i(187989);
        cmF = new a();
        AppMethodBeat.o(187989);
      }
      
      private a()
      {
        super();
      }
      
      public final c MN()
      {
        return null;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter$State$Error;", "Lcoil/compose/ImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/ErrorResult;", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/ErrorResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/ErrorResult;", "throwable", "", "getThrowable$annotations", "()V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends d.c
    {
      public static final int Ue = 8;
      private final c auw;
      private final coil.j.f cmG;
      
      public b(c paramc, coil.j.f paramf)
      {
        super();
        AppMethodBeat.i(187979);
        this.auw = paramc;
        this.cmG = paramf;
        AppMethodBeat.o(187979);
      }
      
      public final c MN()
      {
        return this.auw;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(188031);
        if (this == paramObject)
        {
          AppMethodBeat.o(188031);
          return true;
        }
        if (!(paramObject instanceof b))
        {
          AppMethodBeat.o(188031);
          return false;
        }
        paramObject = (b)paramObject;
        if (!s.p(this.auw, paramObject.auw))
        {
          AppMethodBeat.o(188031);
          return false;
        }
        if (!s.p(this.cmG, paramObject.cmG))
        {
          AppMethodBeat.o(188031);
          return false;
        }
        AppMethodBeat.o(188031);
        return true;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(188021);
        if (this.auw == null) {}
        for (int i = 0;; i = this.auw.hashCode())
        {
          int j = this.cmG.hashCode();
          AppMethodBeat.o(188021);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(188007);
        String str = "Error(painter=" + this.auw + ", result=" + this.cmG + ')';
        AppMethodBeat.o(188007);
        return str;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter$State$Loading;", "Lcoil/compose/ImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      extends d.c
    {
      public static final int Ue = 8;
      private final c auw;
      
      public c(c paramc)
      {
        super();
        this.auw = paramc;
      }
      
      public final c MN()
      {
        return this.auw;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(188016);
        if (this == paramObject)
        {
          AppMethodBeat.o(188016);
          return true;
        }
        if (!(paramObject instanceof c))
        {
          AppMethodBeat.o(188016);
          return false;
        }
        paramObject = (c)paramObject;
        if (!s.p(this.auw, paramObject.auw))
        {
          AppMethodBeat.o(188016);
          return false;
        }
        AppMethodBeat.o(188016);
        return true;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(188005);
        if (this.auw == null)
        {
          AppMethodBeat.o(188005);
          return 0;
        }
        int i = this.auw.hashCode();
        AppMethodBeat.o(188005);
        return i;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(187997);
        String str = "Loading(painter=" + this.auw + ')';
        AppMethodBeat.o(187997);
        return str;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcoil/compose/ImagePainter$State$Success;", "Lcoil/compose/ImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/SuccessResult;", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/SuccessResult;)V", "metadata", "Lcoil/request/ImageResult$Metadata;", "getMetadata$annotations", "()V", "getMetadata", "()Lcoil/request/ImageResult$Metadata;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/SuccessResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      extends d.c
    {
      public static final int Ue = 8;
      private final c auw;
      final coil.j.m cmH;
      
      public d(c paramc, coil.j.m paramm)
      {
        super();
        AppMethodBeat.i(187988);
        this.auw = paramc;
        this.cmH = paramm;
        AppMethodBeat.o(187988);
      }
      
      public final c MN()
      {
        return this.auw;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(188029);
        if (this == paramObject)
        {
          AppMethodBeat.o(188029);
          return true;
        }
        if (!(paramObject instanceof d))
        {
          AppMethodBeat.o(188029);
          return false;
        }
        paramObject = (d)paramObject;
        if (!s.p(this.auw, paramObject.auw))
        {
          AppMethodBeat.o(188029);
          return false;
        }
        if (!s.p(this.cmH, paramObject.cmH))
        {
          AppMethodBeat.o(188029);
          return false;
        }
        AppMethodBeat.o(188029);
        return true;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(188017);
        int i = this.auw.hashCode();
        int j = this.cmH.hashCode();
        AppMethodBeat.o(188017);
        return i * 31 + j;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(188006);
        String str = "Success(painter=" + this.auw + ", result=" + this.cmH + ')';
        AppMethodBeat.o(188006);
        return str;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    d(d paramd, d.b paramb, kotlin.d.d<? super d> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(187994);
      paramObject = (kotlin.d.d)new d(this.cmI, this.cmJ, paramd);
      AppMethodBeat.o(187994);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(187985);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(187985);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.cmI;
        localObject1 = (coil.d)((bm)this.cmI.cmy).getValue();
        Object localObject5 = this.cmI;
        Object localObject3 = this.cmJ.cmE;
        long l = this.cmJ.size;
        Object localObject4 = coil.j.h.h((coil.j.h)localObject3);
        localObject5 = (coil.target.b)new d.f((d)localObject5);
        h.a locala = (h.a)localObject4;
        locala.com = ((coil.target.b)localObject5);
        locala.Nb();
        localObject4 = (h.a)localObject4;
        int i;
        if (((coil.j.h)localObject3).cpG.cpp == null)
        {
          localObject5 = androidx.compose.ui.d.k.avA;
          if (l == androidx.compose.ui.d.k.sw()) {
            break label319;
          }
          i = 1;
          if (i == 0) {
            break label324;
          }
          ((h.a)localObject4).a((Size)new PixelSize(kotlin.h.a.eH(androidx.compose.ui.d.k.Q(l)), kotlin.h.a.eH(androidx.compose.ui.d.k.R(l))));
        }
        for (;;)
        {
          if (((coil.j.h)localObject3).cpG.cmi == null) {
            ((h.a)localObject4).a(coil.size.e.cpY);
          }
          if (((coil.j.h)localObject3).cpG.cpk != coil.size.b.cpT)
          {
            localObject3 = coil.size.b.cpU;
            s.u(localObject3, "precision");
            ((h.a)localObject4).cpk = ((coil.size.b)localObject3);
          }
          localObject3 = ((h.a)localObject4).Na();
          localObject4 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 1;
          localObject1 = ((coil.d)localObject1).a((coil.j.h)localObject3, (kotlin.d.d)localObject4);
          if (localObject1 != localObject2) {
            break label488;
          }
          AppMethodBeat.o(187985);
          return localObject2;
          label319:
          i = 0;
          break;
          label324:
          ((h.a)localObject4).a((Size)OriginalSize.cpS);
        }
      }
      localObject2 = (d)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      Object localObject1 = paramObject;
      paramObject = localObject2;
      label488:
      for (;;)
      {
        localObject2 = (i)localObject1;
        if ((localObject2 instanceof coil.j.m))
        {
          localObject1 = (d.c)new d.c.d(e.C(((coil.j.m)localObject2).drawable), (coil.j.m)localObject2);
          d.a(paramObject, (d.c)localObject1);
          paramObject = ah.aiuX;
          AppMethodBeat.o(187985);
          return paramObject;
        }
        if ((localObject2 instanceof coil.j.f))
        {
          localObject1 = ((i)localObject2).getDrawable();
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = e.C((Drawable)localObject1))
          {
            localObject1 = (d.c)new d.c.b((c)localObject1, (coil.j.f)localObject2);
            break;
          }
        }
        paramObject = new p();
        AppMethodBeat.o(187985);
        throw paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(d paramd, kotlin.d.d<? super e> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(187976);
      paramd = new e(this.cmI, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(187976);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(187969);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(187969);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject1 = (aq)this.L$0;
        Object localObject2 = new ah.f();
        paramObject = v.a(bj.g((kotlin.g.a.a)new u(this.cmI) {}), bj.g((kotlin.g.a.a)new u(this.cmI) {}), (q)3.cmK);
        localObject1 = (kotlinx.coroutines.b.h)new a((ah.f)localObject2, this.cmI, (aq)localObject1);
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a((kotlinx.coroutines.b.h)localObject1, (kotlin.d.d)localObject2) == locala)
        {
          AppMethodBeat.o(187969);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(187969);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<r<? extends coil.j.h, ? extends androidx.compose.ui.d.k>>
    {
      public a(ah.f paramf, d paramd, aq paramaq) {}
      
      public final Object a(r<? extends coil.j.h, ? extends androidx.compose.ui.d.k> paramr, kotlin.d.d<? super ah> paramd)
      {
        int i = 0;
        AppMethodBeat.i(187975);
        paramr = (r)paramr;
        Object localObject = (coil.j.h)paramr.bsC;
        long l = ((androidx.compose.ui.d.k)paramr.bsD).avp;
        paramd = (d.b)this.cmL.aqH;
        paramr = new d.b(this.cmI.MM(), (coil.j.h)localObject, l, (byte)0);
        this.cmL.aqH = paramr;
        if (((coil.j.h)localObject).cpG.cpp == null)
        {
          localObject = androidx.compose.ui.d.k.avA;
          if (l != androidx.compose.ui.d.k.sw()) {
            i = 1;
          }
          if ((i != 0) && ((androidx.compose.ui.d.k.Q(l) <= 0.5F) || (androidx.compose.ui.d.k.R(l) <= 0.5F))) {
            d.a(this.cmI, (d.c)d.c.a.cmF);
          }
        }
        for (;;)
        {
          paramr = ah.aiuX;
          AppMethodBeat.o(187975);
          return paramr;
          localObject = this.cmI;
          aq localaq = this.cmM;
          if (((d)localObject).cmv.a(paramd, paramr))
          {
            paramd = ((d)localObject).cmr;
            if (paramd != null) {
              paramd.a(null);
            }
            ((d)localObject).cmr = j.a(localaq, null, null, (kotlin.g.a.m)new d.d((d)localObject, paramr, null), 3);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"coil/request/ImageRequest$Builder$target$4", "Lcoil/target/Target;", "onError", "", "error", "Landroid/graphics/drawable/Drawable;", "onStart", "placeholder", "onSuccess", "result", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements coil.target.b
  {
    public f(d paramd) {}
    
    public final void A(Drawable paramDrawable) {}
    
    public final void B(Drawable paramDrawable)
    {
      AppMethodBeat.i(187967);
      s.u(paramDrawable, "result");
      AppMethodBeat.o(187967);
    }
    
    public final void z(Drawable paramDrawable)
    {
      AppMethodBeat.i(187959);
      d locald = this.cmI;
      if (paramDrawable == null) {}
      for (paramDrawable = null;; paramDrawable = e.C(paramDrawable))
      {
        d.a(locald, (d.c)new d.c.c(paramDrawable));
        AppMethodBeat.o(187959);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.d.d
 * JD-Core Version:    0.7.0.1
 */