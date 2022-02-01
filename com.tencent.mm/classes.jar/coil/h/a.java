package coil.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.j.i.a;
import coil.memory.MemoryCache.Key;
import coil.memory.MemoryCache.Key.Complex;
import coil.memory.n.a;
import coil.memory.q;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.d.d<-Lcoil.j.i;>;
import kotlin.g.b.s;
import kotlin.p;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cg;

@Metadata(d1={""}, d2={"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "registry", "Lcoil/ComponentRegistry;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "requestService", "Lcoil/memory/RequestService;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ComponentRegistry;Lcoil/bitmap/BitmapPool;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/memory/StrongMemoryCache;Lcoil/memory/MemoryCacheService;Lcoil/memory/RequestService;Lcoil/util/SystemCallbacks;Lcoil/decode/DrawableDecoderService;Lcoil/util/Logger;)V", "applyTransformations", "Lcoil/fetch/DrawableResult;", "result", "request", "Lcoil/request/ImageRequest;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "eventListener", "Lcoil/EventListener;", "applyTransformations$coil_base_release", "(Lcoil/fetch/DrawableResult;Lcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/decode/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeMemoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "data", "", "fetcher", "Lcoil/fetch/Fetcher;", "computeMemoryCacheKey$coil_base_release", "execute", "type", "", "(Ljava/lang/Object;Lcoil/fetch/Fetcher;Lcoil/request/ImageRequest;ILcoil/size/Size;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateData", "", "isCachedValueValid", "", "cacheKey", "cacheValue", "Lcoil/memory/RealMemoryCache$Value;", "isCachedValueValid$coil_base_release", "isSizeValid", "validateDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "writeToMemoryCache", "key", "isSampled", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public static final a.a cnP;
  private final coil.util.k cli;
  private final coil.b.b clr;
  private final coil.memory.l clt;
  private final q clu;
  private final coil.e.f clv;
  private final coil.util.l clw;
  private final coil.b clx;
  private final coil.b.d cnQ;
  private final coil.memory.r cnR;
  
  static
  {
    AppMethodBeat.i(188219);
    cnP = new a.a((byte)0);
    AppMethodBeat.o(188219);
  }
  
  public a(coil.b paramb, coil.b.b paramb1, coil.b.d paramd, coil.memory.r paramr, coil.memory.l paraml, q paramq, coil.util.l paraml1, coil.e.f paramf, coil.util.k paramk)
  {
    AppMethodBeat.i(188092);
    this.clx = paramb;
    this.clr = paramb1;
    this.cnQ = paramd;
    this.cnR = paramr;
    this.clt = paraml;
    this.clu = paramq;
    this.clw = paraml1;
    this.clv = paramf;
    this.cli = paramk;
    AppMethodBeat.o(188092);
  }
  
  private static MemoryCache.Key a(coil.j.h paramh, Object paramObject, coil.g.g<Object> paramg, Size paramSize)
  {
    AppMethodBeat.i(188105);
    s.u(paramh, "request");
    s.u(paramObject, "data");
    s.u(paramg, "fetcher");
    s.u(paramSize, "size");
    paramObject = paramg.aW(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(188105);
      return null;
    }
    if (paramh.cot.isEmpty())
    {
      paramg = MemoryCache.Key.cos;
      paramh = paramh.cnv;
      paramh = (MemoryCache.Key)new MemoryCache.Key.Complex(paramObject, (List)ab.aivy, null, paramh.Nf());
      AppMethodBeat.o(188105);
      return paramh;
    }
    paramg = MemoryCache.Key.cos;
    paramg = paramh.cot;
    paramh = paramh.cnv;
    ArrayList localArrayList = new ArrayList(paramg.size());
    int k = paramg.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((Collection)localArrayList).add(((coil.k.a)paramg.get(i)).key());
      if (j > k)
      {
        paramh = (MemoryCache.Key)new MemoryCache.Key.Complex(paramObject, (List)localArrayList, paramSize, paramh.Nf());
        AppMethodBeat.o(188105);
        return paramh;
      }
    }
  }
  
  public final Object a(final b.a parama, kotlin.d.d<? super coil.j.i> paramd)
  {
    AppMethodBeat.i(188236);
    Object localObject1;
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      paramd = ((b)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((b)localObject1).label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188236);
        throw parama;
        localObject1 = new b(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    paramd = parama;
    try
    {
      if ((parama instanceof c)) {
        break label179;
      }
      paramd = parama;
      localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
      paramd = parama;
      AppMethodBeat.o(188236);
      paramd = parama;
      throw ((Throwable)localObject1);
    }
    finally {}
    label179:
    final coil.j.h localh;
    Object localObject3;
    final Size localSize;
    final coil.c localc;
    final Object localObject7;
    Object localObject4;
    Object localObject5;
    label381:
    Object localObject6;
    label489:
    int i;
    boolean bool2;
    if ((parama instanceof CancellationException))
    {
      AppMethodBeat.o(188236);
      throw parama;
      paramd = parama;
      localh = parama.MR();
      paramd = parama;
      Context localContext = localh.context;
      paramd = parama;
      localObject3 = localh.cpt;
      paramd = parama;
      localSize = parama.MS();
      paramd = parama;
      localc = ((c)parama).cod;
      paramd = parama;
      localc.a(localh, localObject3);
      paramd = parama;
      localObject7 = coil.util.b.a(this.clx, localObject3);
      paramd = parama;
      localc.b(localh, localObject7);
      paramd = parama;
      s.u(localh, "<this>");
      paramd = parama;
      s.u(localObject7, "data");
      paramd = parama;
      localObject4 = localh.cpx;
      if (localObject4 == null)
      {
        paramd = null;
        localObject4 = paramd;
        if (paramd == null)
        {
          paramd = parama;
          localObject4 = coil.util.b.b(this.clx, localObject7);
        }
        paramd = parama;
        localObject5 = localh.cpv;
        localObject3 = localObject5;
        if (localObject5 == null)
        {
          paramd = parama;
          localObject3 = a(localh, localObject7, (coil.g.g)localObject4, localSize);
        }
        paramd = parama;
        if (!localh.cnw.cpb) {
          break label1552;
        }
        paramd = parama;
        localObject5 = this.clt.a((MemoryCache.Key)localObject3);
        if (localObject5 == null) {
          break label1375;
        }
        paramd = parama;
        s.u(localObject5, "cacheValue");
        paramd = parama;
        s.u(localh, "request");
        paramd = parama;
        s.u(localSize, "size");
        paramd = parama;
        if (!(localSize instanceof OriginalSize)) {
          break label722;
        }
        paramd = parama;
        if (!((n.a)localObject5).MU()) {
          break label1628;
        }
        paramd = parama;
        localObject6 = this.cli;
        if (localObject6 == null) {
          break label1532;
        }
        paramd = parama;
        if (((coil.util.k)localObject6).getLevel() > 3) {
          break label1532;
        }
        paramd = parama;
        new StringBuilder().append(localh.cpt).append(": Requested original size, but cached image is sampled.");
        break label1532;
        if (i == 0) {
          break label1375;
        }
        paramd = parama;
        localObject1 = ((n.a)localObject5).getBitmap();
        paramd = parama;
        localObject4 = localContext.getResources();
        paramd = parama;
        s.s(localObject4, "context.resources");
        paramd = parama;
        localObject1 = (Drawable)new BitmapDrawable((Resources)localObject4, (Bitmap)localObject1);
        paramd = parama;
        bool2 = ((n.a)localObject5).MU();
        paramd = parama;
        localObject4 = coil.e.b.cmU;
        paramd = parama;
        if (((c)parama).coc == null) {
          break label1646;
        }
      }
    }
    label722:
    label985:
    label1375:
    label1632:
    label1634:
    label1640:
    label1646:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramd = parama;
      localObject1 = new coil.j.m((Drawable)localObject1, localh, new i.a((MemoryCache.Key)localObject3, bool2, (coil.e.b)localObject4, bool1));
      paramd = parama;
      AppMethodBeat.o(188236);
      return localObject1;
      paramd = parama;
      localObject3 = (coil.g.g)((kotlin.r)localObject4).bsC;
      paramd = parama;
      double d1;
      int k;
      if (!((Class)((kotlin.r)localObject4).bsD).isAssignableFrom(localObject7.getClass()))
      {
        paramd = parama;
        localObject1 = (Throwable)new IllegalStateException((localObject3.getClass().getName() + " cannot handle data with type " + localObject7.getClass().getName() + '.').toString());
        paramd = parama;
        AppMethodBeat.o(188236);
        paramd = parama;
        throw ((Throwable)localObject1);
        paramd = parama;
        if (!(localSize instanceof PixelSize)) {
          break label1628;
        }
        paramd = parama;
        if (!(localObject3 instanceof MemoryCache.Key.Complex)) {
          break label1575;
        }
        paramd = parama;
        localObject6 = (MemoryCache.Key.Complex)localObject3;
        break label1558;
        paramd = parama;
        int j;
        if ((localObject6 instanceof PixelSize))
        {
          paramd = parama;
          j = ((PixelSize)localObject6).width;
          paramd = parama;
        }
        for (i = ((PixelSize)localObject6).height;; i = ((Bitmap)localObject6).getHeight())
        {
          paramd = parama;
          d1 = coil.e.d.b(j, i, ((PixelSize)localSize).width, ((PixelSize)localSize).height, localh.cmi);
          paramd = parama;
          bool1 = coil.util.g.i(localh);
          if (!bool1) {
            break label985;
          }
          paramd = parama;
          double d2 = kotlin.k.k.aj(d1);
          paramd = parama;
          if (Math.abs(((PixelSize)localSize).width - j * d2) <= 1.0D) {
            break label1569;
          }
          paramd = parama;
          if (Math.abs(((PixelSize)localSize).height - d2 * i) > 1.0D) {
            break label1598;
          }
          break label1569;
          paramd = parama;
          localObject6 = ((MemoryCache.Key.Complex)localObject6).cob;
          break;
          paramd = parama;
          if (!s.p(localObject6, OriginalSize.cpS)) {
            break label1581;
          }
          i = 1;
          if (i == 0) {
            break label961;
          }
          paramd = parama;
          localObject6 = ((n.a)localObject5).getBitmap();
          paramd = parama;
          j = ((Bitmap)localObject6).getWidth();
          paramd = parama;
        }
        paramd = parama;
        localObject1 = new p();
        paramd = parama;
        AppMethodBeat.o(188236);
        paramd = parama;
        throw ((Throwable)localObject1);
        paramd = parama;
        if (Math.abs(((PixelSize)localSize).width - j) > 1) {
          break label1598;
        }
        paramd = parama;
        if (Math.abs(((PixelSize)localSize).height - i) <= 1) {
          break label1628;
        }
        break label1598;
        if ((k == 0) && (!bool1))
        {
          paramd = parama;
          localObject6 = this.cli;
          if (localObject6 == null) {
            break label1610;
          }
          paramd = parama;
          if (((coil.util.k)localObject6).getLevel() > 3) {
            break label1610;
          }
          paramd = parama;
          new StringBuilder().append(localh.cpt).append(": Cached image's request size (").append(j).append(", ").append(i).append(") does not exactly match the requested size (").append(((PixelSize)localSize).width).append(", ").append(((PixelSize)localSize).height).append(", ").append(localh.cmi).append(").");
          break label1610;
        }
        if (d1 <= 1.0D) {
          break label1628;
        }
        paramd = parama;
        if (!((n.a)localObject5).MU()) {
          break label1628;
        }
        paramd = parama;
        localObject6 = this.cli;
        if (localObject6 == null) {
          break label1622;
        }
        paramd = parama;
        if (((coil.util.k)localObject6).getLevel() > 3) {
          break label1622;
        }
        paramd = parama;
        new StringBuilder().append(localh.cpt).append(": Cached image's request size (").append(j).append(", ").append(i).append(") is smaller than the requested size (").append(((PixelSize)localSize).width).append(", ").append(((PixelSize)localSize).height).append(", ").append(localh.cmi).append(").");
        break label1622;
      }
      for (;;)
      {
        paramd = parama;
        if (q.a(localh, coil.util.a.u(((n.a)localObject5).getBitmap()))) {
          break label1640;
        }
        paramd = parama;
        localObject6 = this.cli;
        if (localObject6 == null) {
          break label1634;
        }
        paramd = parama;
        if (((coil.util.k)localObject6).getLevel() > 3) {
          break label1634;
        }
        paramd = parama;
        new StringBuilder().append(localh.cpt).append(": Cached bitmap is hardware-backed, which is incompatible with the request.");
        break label1634;
        paramd = parama;
        localObject6 = (kotlin.d.f)localh.bRx;
        paramd = parama;
        localObject3 = (kotlin.g.a.m)new c(this, localh, (n.a)localObject5, localObject7, (coil.g.g)localObject4, parama, localSize, localc, (MemoryCache.Key)localObject3, null);
        paramd = parama;
        ((b)localObject1).L$0 = this;
        paramd = parama;
        ((b)localObject1).Uf = parama;
        paramd = parama;
        ((b)localObject1).label = 1;
        paramd = parama;
        localObject1 = kotlinx.coroutines.l.a((kotlin.d.f)localObject6, (kotlin.g.a.m)localObject3, (kotlin.d.d)localObject1);
        paramd = (kotlin.d.d<? super coil.j.i>)localObject1;
        localObject1 = paramd;
        if (paramd == locala)
        {
          AppMethodBeat.o(188236);
          return locala;
          parama = (b.a)((b)localObject1).Uf;
        }
        try
        {
          ResultKt.throwOnFailure(paramd);
          localObject1 = paramd;
          paramd = parama;
          AppMethodBeat.o(188236);
          return localObject1;
        }
        finally
        {
          paramd = parama;
          parama = localObject2;
        }
        parama = q.b(paramd.MR(), parama);
        AppMethodBeat.o(188236);
        return parama;
        break;
        label1532:
        i = 0;
        for (;;)
        {
          label1535:
          if (i != 0) {
            break label1632;
          }
          i = 0;
          break label489;
          paramd = (kotlin.d.d<? super coil.j.i>)localObject3;
          break;
          localObject5 = null;
          break label381;
          for (;;)
          {
            if (localObject6 != null) {
              break label1579;
            }
            localObject6 = null;
            break;
            i = 1;
            break label1535;
            localObject6 = null;
          }
          break label896;
          if (localObject6 == null)
          {
            i = 1;
            break label924;
          }
          i = 0;
          break label924;
          if (d1 == 1.0D)
          {
            k = 1;
            break label1028;
            i = 0;
            continue;
          }
          k = 0;
          break label1028;
          i = 0;
          continue;
          i = 1;
        }
      }
      i = 0;
      break label489;
      i = 1;
      break label489;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    b(a parama, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188072);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.cnS.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(188072);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super coil.j.m>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    int aai;
    Object aqc;
    int asI;
    Object bNS;
    int label;
    
    c(a parama, coil.j.h paramh, n.a parama1, Object paramObject, coil.g.g<Object> paramg, b.a parama2, Size paramSize, coil.c paramc, MemoryCache.Key paramKey, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(188135);
      paramObject = (kotlin.d.d)new c(this.cnS, localh, this.cnT, localObject7, this.cnV, parama, localSize, localc, this.cnZ, paramd);
      AppMethodBeat.o(188135);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188123);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject5;
      Object localObject8;
      Object localObject7;
      Object localObject2;
      int j;
      Object localObject6;
      Object localObject3;
      boolean bool1;
      int i;
      label230:
      label240:
      Object localObject1;
      label252:
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188123);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        a.a(this.cnS, localh.cpt);
        if (this.cnT != null) {
          a.a(this.cnS).q(this.cnT.getBitmap());
        }
        localObject5 = this.cnS;
        localObject8 = localObject7;
        localObject7 = this.cnV;
        localObject2 = localh;
        j = ((c)parama).requestType;
        localObject6 = localSize;
        localObject3 = localc;
        paramObject = a.b((a)localObject5);
        bool1 = a.c((a)localObject5).cqy;
        s.u(localObject2, "request");
        s.u(localObject6, "size");
        if (q.g((coil.j.h)localObject2)) {
          if ((q.a((coil.j.h)localObject2, ((coil.j.h)localObject2).bitmapConfig)) && (paramObject.coE.a((Size)localObject6, paramObject.cli)))
          {
            i = 1;
            if (i == 0) {
              break label448;
            }
            i = 1;
            if (i == 0) {
              break label453;
            }
            paramObject = ((coil.j.h)localObject2).bitmapConfig;
            if (!bool1) {
              break label460;
            }
            localObject1 = ((coil.j.h)localObject2).cny;
            if ((!((coil.j.h)localObject2).cns) || (!((coil.j.h)localObject2).cot.isEmpty()) || (paramObject == Bitmap.Config.ALPHA_8)) {
              break label468;
            }
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          localObject4 = new coil.e.i(((coil.j.h)localObject2).context, paramObject, ((coil.j.h)localObject2).cnq, ((coil.j.h)localObject2).cmi, coil.util.g.i((coil.j.h)localObject2), bool1, ((coil.j.h)localObject2).cnt, ((coil.j.h)localObject2).cnu, ((coil.j.h)localObject2).cnv, ((coil.j.h)localObject2).cnw, ((coil.j.h)localObject2).cnx, (coil.j.b)localObject1);
          ((coil.c)localObject3).a((coil.j.h)localObject2, (coil.g.g)localObject7, (coil.e.i)localObject4);
          a.d((a)localObject5);
          paramObject = (kotlin.d.d)this;
          this.L$0 = localObject5;
          this.Uf = localObject7;
          this.VC = localObject2;
          this.VD = localObject6;
          this.Ze = localObject3;
          this.aqc = localObject4;
          this.aai = j;
          this.label = 1;
          localObject1 = ((coil.g.g)localObject7).a(localObject8, (Size)localObject6, (coil.e.i)localObject4, paramObject);
          if (localObject1 != locala) {
            break label2118;
          }
          AppMethodBeat.o(188123);
          return locala;
          i = 0;
          break;
          i = 0;
          break label230;
          paramObject = Bitmap.Config.ARGB_8888;
          break label240;
          localObject1 = coil.j.b.cpg;
          break label252;
        }
      case 1: 
        label448:
        label453:
        label460:
        label468:
        i = this.aai;
        localObject4 = (coil.e.i)this.aqc;
        localObject3 = (coil.c)this.Ze;
        localObject5 = (Size)this.VD;
        localObject2 = (coil.j.h)this.VC;
        localObject7 = (coil.g.g)this.Uf;
        localObject1 = (a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject6 = paramObject;
        paramObject = localObject5;
      }
      for (;;)
      {
        localObject6 = (coil.g.f)localObject6;
        ((coil.c)localObject3).a((coil.j.h)localObject2, (coil.g.g)localObject7, (coil.e.i)localObject4, (coil.g.f)localObject6);
        if ((localObject6 instanceof coil.g.m)) {}
        label2068:
        for (;;)
        {
          int k;
          try
          {
            cg.g(getContext());
            if ((i == 0) && (((coil.j.h)localObject2).com == null) && (!((coil.j.h)localObject2).cnw.cpc))
            {
              i = 1;
              if (i != 0)
              {
                localObject5 = (coil.e.e)coil.e.g.cnl;
                ((coil.c)localObject3).a((coil.j.h)localObject2, (coil.e.e)localObject5, (coil.e.i)localObject4);
                localObject7 = a.d((a)localObject1);
                localObject8 = ((coil.g.m)localObject6).cnO;
                localObject9 = (kotlin.d.d)this;
                this.L$0 = localObject1;
                this.Uf = localObject2;
                this.VC = paramObject;
                this.VD = localObject3;
                this.Ze = localObject4;
                this.aqc = localObject6;
                this.bNS = localObject5;
                this.label = 2;
                localObject8 = ((coil.e.e)localObject5).a((coil.b.b)localObject7, (j.h)localObject8, paramObject, (coil.e.i)localObject4, (kotlin.d.d)localObject9);
                if (localObject8 != locala) {
                  break label2102;
                }
                AppMethodBeat.o(188123);
                return locala;
              }
            }
            else
            {
              i = 0;
              continue;
            }
            localObject7 = ((coil.j.h)localObject2).cpy;
            localObject5 = localObject7;
            if (localObject7 != null) {
              continue;
            }
            localObject5 = a.e((a)localObject1);
            localObject8 = ((coil.j.h)localObject2).cpt;
            localObject7 = ((coil.g.m)localObject6).cnO;
            s.u(localObject5, "<this>");
            s.u(localObject8, "data");
            s.u(localObject7, "source");
            Object localObject9 = ((coil.b)localObject5).ckV;
            i = 0;
            k = ((List)localObject9).size() - 1;
            if (k < 0) {
              break label930;
            }
            j = i + 1;
            localObject5 = ((List)localObject9).get(i);
            if (!((coil.e.e)localObject5).a((j.h)localObject7)) {
              break label924;
            }
            localObject7 = (coil.e.e)localObject5;
            localObject5 = localObject7;
            if (localObject7 != null) {
              continue;
            }
            paramObject = (Throwable)new IllegalStateException(s.X("Unable to decode data. No decoder supports: ", localObject8).toString());
            AppMethodBeat.o(188123);
            throw paramObject;
          }
          finally {}
          coil.util.d.closeQuietly((Closeable)((coil.g.m)localObject6).cnO);
          AppMethodBeat.o(188123);
          throw paramObject;
          label924:
          if (j > k)
          {
            label930:
            localObject5 = null;
            continue;
            localObject7 = (coil.e.e)this.bNS;
            localObject6 = (coil.g.f)this.aqc;
            localObject5 = (coil.e.i)this.Ze;
            localObject3 = (coil.c)this.VD;
            localObject8 = (Size)this.VC;
            localObject2 = (coil.j.h)this.Uf;
            localObject1 = (a)this.L$0;
            localObject4 = localObject6;
            for (;;)
            {
              try
              {
                ResultKt.throwOnFailure(paramObject);
                localObject4 = paramObject;
                paramObject = localObject8;
                localObject8 = localObject4;
                localObject4 = localObject6;
                localObject8 = (coil.e.c)localObject8;
                localObject4 = localObject6;
                ((coil.c)localObject3).a((coil.j.h)localObject2, (coil.e.e)localObject7, (coil.e.i)localObject5, (coil.e.c)localObject8);
                localObject7 = new coil.g.e(((coil.e.c)localObject8).drawable, ((coil.e.c)localObject8).cmZ, ((coil.g.m)localObject6).cnH);
                localObject6 = localObject5;
                localObject4 = paramObject;
                localObject5 = localObject1;
                paramObject = localObject7;
                cg.g(getContext());
                localObject7 = ((coil.j.h)localObject2).cot;
                if (((List)localObject7).isEmpty())
                {
                  localObject1 = paramObject;
                  paramObject = ((coil.g.e)localObject1).drawable;
                  if ((paramObject instanceof BitmapDrawable))
                  {
                    paramObject = (BitmapDrawable)paramObject;
                    if (paramObject != null)
                    {
                      paramObject = paramObject.getBitmap();
                      if (paramObject != null)
                      {
                        paramObject.prepareToDraw();
                        paramObject = ah.aiuX;
                      }
                    }
                    localObject2 = ((coil.g.e)localObject1).drawable;
                    bool2 = ((coil.g.e)localObject1).cmZ;
                    localObject1 = ((coil.g.e)localObject1).cnH;
                    a.a(this.cnS, (Drawable)localObject2);
                    paramObject = this.cnS;
                    localObject3 = localh;
                    localObject4 = this.cnZ;
                    if (!bool2) {
                      continue;
                    }
                    bool1 = true;
                    bool1 = a.a(paramObject, (coil.j.h)localObject3, (MemoryCache.Key)localObject4, (Drawable)localObject2, bool1);
                    localObject3 = localh;
                    paramObject = this.cnZ;
                    if (!bool1) {
                      continue;
                    }
                    i = 1;
                    if (i == 0) {
                      continue;
                    }
                    if (((c)parama).coc == null) {
                      continue;
                    }
                    i = 1;
                    if (!bool2) {
                      continue;
                    }
                    bool1 = true;
                    if (i == 0) {
                      continue;
                    }
                    bool2 = true;
                    paramObject = new coil.j.m((Drawable)localObject2, (coil.j.h)localObject3, new i.a(paramObject, bool1, (coil.e.b)localObject1, bool2));
                    AppMethodBeat.o(188123);
                    return paramObject;
                    if ((localObject6 instanceof coil.g.e))
                    {
                      localObject5 = (coil.g.e)localObject6;
                      localObject6 = localObject4;
                      localObject4 = paramObject;
                      paramObject = localObject5;
                      localObject5 = localObject1;
                      continue;
                    }
                    paramObject = new p();
                    AppMethodBeat.o(188123);
                    throw paramObject;
                  }
                }
                else
                {
                  if ((paramObject.drawable instanceof BitmapDrawable))
                  {
                    localObject1 = ((BitmapDrawable)paramObject.drawable).getBitmap();
                    localObject8 = q.coF;
                    s.s(localObject1, "resultBitmap");
                    if (kotlin.a.k.contains((Object[])localObject8, coil.util.a.u((Bitmap)localObject1)))
                    {
                      s.s(localObject1, "input");
                      ((coil.c)localObject3).a((coil.j.h)localObject2, (Bitmap)localObject1);
                      j = 0;
                      i = ((List)localObject7).size() - 1;
                      if (i < 0) {
                        break label2099;
                      }
                      localObject6 = localObject7;
                      localObject7 = localObject1;
                      localObject1 = localObject3;
                      k = j + 1;
                      localObject3 = (coil.k.a)((List)localObject6).get(j);
                      a.d((a)localObject5);
                      s.s(localObject7, "bitmap");
                      this.L$0 = localObject2;
                      this.Uf = localObject4;
                      this.VC = localObject1;
                      this.VD = localObject5;
                      this.Ze = paramObject;
                      this.aqc = localObject6;
                      this.bNS = null;
                      this.aai = k;
                      this.asI = i;
                      this.label = 3;
                      localObject7 = ((coil.k.a)localObject3).Nj();
                      if (localObject7 != locala) {
                        break label2083;
                      }
                      AppMethodBeat.o(188123);
                      return locala;
                    }
                    localObject8 = a.f((a)localObject5);
                    if (localObject8 != null)
                    {
                      if (((coil.util.k)localObject8).getLevel() <= 4) {
                        new StringBuilder("Converting bitmap with config ").append(coil.util.a.u((Bitmap)localObject1)).append(" to apply transformations: ").append(localObject7);
                      }
                      localObject1 = ah.aiuX;
                    }
                    localObject1 = a.g((a)localObject5).a(paramObject.drawable, ((coil.e.i)localObject6).clE, (Size)localObject4, ((coil.e.i)localObject6).cmi, ((coil.e.i)localObject6).cnr);
                    continue;
                  }
                  if (((coil.j.h)localObject2).cpz)
                  {
                    localObject1 = a.f((a)localObject5);
                    if (localObject1 != null)
                    {
                      if (((coil.util.k)localObject1).getLevel() <= 4) {
                        new StringBuilder("Converting drawable of type ").append(paramObject.drawable.getClass().getCanonicalName()).append(" to apply transformations: ").append(localObject7);
                      }
                      localObject1 = ah.aiuX;
                    }
                    localObject1 = a.g((a)localObject5).a(paramObject.drawable, ((coil.e.i)localObject6).clE, (Size)localObject4, ((coil.e.i)localObject6).cmi, ((coil.e.i)localObject6).cnr);
                    continue;
                  }
                  localObject2 = a.f((a)localObject5);
                  localObject1 = paramObject;
                  if (localObject2 == null) {
                    continue;
                  }
                  if (((coil.util.k)localObject2).getLevel() <= 4) {
                    s.X("allowConversionToBitmap=false, skipping transformations for type ", paramObject.drawable.getClass().getCanonicalName());
                  }
                  localObject1 = ah.aiuX;
                  localObject1 = paramObject;
                  continue;
                  j = this.asI;
                  i = this.aai;
                  localObject6 = (List)this.aqc;
                  localObject4 = (coil.g.e)this.Ze;
                  localObject5 = (a)this.VD;
                  localObject1 = (coil.c)this.VC;
                  localObject7 = (Size)this.Uf;
                  localObject2 = (coil.j.h)this.L$0;
                  ResultKt.throwOnFailure(paramObject);
                  localObject3 = paramObject;
                  paramObject = localObject4;
                  localObject4 = localObject3;
                  localObject3 = localObject7;
                  cg.g(getContext());
                  localObject7 = (Bitmap)localObject4;
                  if (i <= j) {
                    break label2068;
                  }
                  localObject3 = localObject1;
                  localObject1 = localObject7;
                  s.s(localObject1, "output");
                  ((coil.c)localObject3).b((coil.j.h)localObject2, (Bitmap)localObject1);
                  localObject2 = ((coil.j.h)localObject2).context.getResources();
                  s.s(localObject2, "context.resources");
                  localObject1 = (Drawable)new BitmapDrawable((Resources)localObject2, (Bitmap)localObject1);
                  bool1 = paramObject.cmZ;
                  paramObject = paramObject.cnH;
                  s.u(localObject1, "drawable");
                  s.u(paramObject, "dataSource");
                  localObject1 = new coil.g.e((Drawable)localObject1, bool1, paramObject);
                  continue;
                }
                paramObject = null;
                continue;
                bool1 = false;
                continue;
                i = 0;
                continue;
                paramObject = null;
                continue;
                i = 0;
                continue;
                bool1 = false;
                continue;
                boolean bool2 = false;
                continue;
                break;
              }
              finally
              {
                localObject6 = localObject4;
              }
              k = i;
              i = j;
              j = k;
              localObject4 = localObject3;
              continue;
              label2083:
              localObject3 = localObject4;
              localObject4 = localObject7;
              j = i;
              i = k;
              continue;
              label2099:
              continue;
              label2102:
              localObject7 = localObject5;
              localObject5 = localObject4;
            }
          }
          else
          {
            i = j;
          }
        }
        label2118:
        paramObject = localObject6;
        i = j;
        localObject6 = localObject1;
        localObject1 = localObject5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.h.a
 * JD-Core Version:    0.7.0.1
 */