package coil.j;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import coil.memory.MemoryCache.Key;
import coil.size.OriginalSize;
import coil.size.Size;
import coil.size.f;
import coil.size.f.a;
import coil.size.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.al;
import okhttp3.q;
import okhttp3.q.a;

@Metadata(d1={""}, d2={"Lcoil/request/ImageRequest;", "", "context", "Landroid/content/Context;", "data", "target", "Lcoil/target/Target;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "placeholderMemoryCacheKey", "colorSpace", "Landroid/graphics/ColorSpace;", "fetcher", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "decoder", "Lcoil/decode/Decoder;", "transformations", "", "Lcoil/transform/Transformation;", "headers", "Lokhttp3/Headers;", "parameters", "Lcoil/request/Parameters;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowConversionToBitmap", "", "allowHardware", "allowRgb565", "premultipliedAlpha", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderResId", "", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "defined", "Lcoil/request/DefinedRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "(Landroid/content/Context;Ljava/lang/Object;Lcoil/target/Target;Lcoil/request/ImageRequest$Listener;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$Key;Landroid/graphics/ColorSpace;Lkotlin/Pair;Lcoil/decode/Decoder;Ljava/util/List;Lokhttp3/Headers;Lcoil/request/Parameters;Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/DefinedRequestOptions;Lcoil/request/DefaultRequestOptions;)V", "getAllowConversionToBitmap", "()Z", "getAllowHardware", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getDecoder", "()Lcoil/decode/Decoder;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getDefined", "()Lcoil/request/DefinedRequestOptions;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "error", "getError", "()Landroid/graphics/drawable/Drawable;", "Ljava/lang/Integer;", "fallback", "getFallback", "getFetcher", "()Lkotlin/Pair;", "getHeaders", "()Lokhttp3/Headers;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getListener", "()Lcoil/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "placeholder", "getPlaceholder", "getPlaceholderMemoryCacheKey", "getPrecision", "()Lcoil/size/Precision;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTarget", "()Lcoil/target/Target;", "getTransformations", "()Ljava/util/List;", "getTransition", "()Lcoil/transition/Transition;", "equals", "other", "hashCode", "newBuilder", "Lcoil/request/ImageRequest$Builder;", "toString", "", "Builder", "Listener", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public final al bRx;
  public final Bitmap.Config bitmapConfig;
  public final c cld;
  public final coil.size.e cmi;
  public final ColorSpace cnq;
  public final boolean cns;
  public final boolean cnt;
  public final q cnu;
  public final l cnv;
  public final b cnw;
  public final b cnx;
  public final b cny;
  public final boolean col;
  public final coil.target.b com;
  public final Context context;
  public final List<coil.k.a> cot;
  final Integer cpA;
  final Drawable cpB;
  public final Integer cpC;
  public final Drawable cpD;
  public final Integer cpE;
  public final Drawable cpF;
  public final d cpG;
  public final coil.l.c cpj;
  public final coil.size.b cpk;
  public final f cpp;
  public final Object cpt;
  public final b cpu;
  public final MemoryCache.Key cpv;
  public final MemoryCache.Key cpw;
  public final r<coil.g.g<?>, Class<?>> cpx;
  public final coil.e.e cpy;
  public final boolean cpz;
  public final androidx.lifecycle.j lifecycle;
  
  private h(Context paramContext, Object paramObject, coil.target.b paramb, b paramb1, MemoryCache.Key paramKey1, MemoryCache.Key paramKey2, ColorSpace paramColorSpace, r<? extends coil.g.g<?>, ? extends Class<?>> paramr, coil.e.e parame, List<? extends coil.k.a> paramList, q paramq, l paraml, androidx.lifecycle.j paramj, f paramf, coil.size.e parame1, al paramal, coil.l.c paramc, coil.size.b paramb2, Bitmap.Config paramConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, b paramb3, b paramb4, b paramb5, Integer paramInteger1, Drawable paramDrawable1, Integer paramInteger2, Drawable paramDrawable2, Integer paramInteger3, Drawable paramDrawable3, d paramd, c paramc1)
  {
    this.context = paramContext;
    this.cpt = paramObject;
    this.com = paramb;
    this.cpu = paramb1;
    this.cpv = paramKey1;
    this.cpw = paramKey2;
    this.cnq = paramColorSpace;
    this.cpx = paramr;
    this.cpy = parame;
    this.cot = paramList;
    this.cnu = paramq;
    this.cnv = paraml;
    this.lifecycle = paramj;
    this.cpp = paramf;
    this.cmi = parame1;
    this.bRx = paramal;
    this.cpj = paramc;
    this.cpk = paramb2;
    this.bitmapConfig = paramConfig;
    this.cpz = paramBoolean1;
    this.col = paramBoolean2;
    this.cns = paramBoolean3;
    this.cnt = paramBoolean4;
    this.cnw = paramb3;
    this.cnx = paramb4;
    this.cny = paramb5;
    this.cpA = paramInteger1;
    this.cpB = paramDrawable1;
    this.cpC = paramInteger2;
    this.cpD = paramDrawable2;
    this.cpE = paramInteger3;
    this.cpF = paramDrawable3;
    this.cpG = paramd;
    this.cld = paramc1;
  }
  
  private a az(Context paramContext)
  {
    AppMethodBeat.i(187912);
    s.u(paramContext, "context");
    paramContext = new a(this, paramContext);
    AppMethodBeat.o(187912);
    return paramContext;
  }
  
  public final Drawable MZ()
  {
    AppMethodBeat.i(187943);
    Drawable localDrawable = coil.util.g.a(this, this.cpB, this.cpA, this.cld.cpl);
    AppMethodBeat.o(187943);
    return localDrawable;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187954);
    if (this == paramObject)
    {
      AppMethodBeat.o(187954);
      return true;
    }
    if (((paramObject instanceof h)) && (s.p(this.context, ((h)paramObject).context)) && (s.p(this.cpt, ((h)paramObject).cpt)) && (s.p(this.com, ((h)paramObject).com)) && (s.p(this.cpu, ((h)paramObject).cpu)) && (s.p(this.cpv, ((h)paramObject).cpv)) && (s.p(this.cpw, ((h)paramObject).cpw)) && ((Build.VERSION.SDK_INT < 26) || (s.p(this.cnq, ((h)paramObject).cnq))) && (s.p(this.cpx, ((h)paramObject).cpx)) && (s.p(this.cpy, ((h)paramObject).cpy)) && (s.p(this.cot, ((h)paramObject).cot)) && (s.p(this.cnu, ((h)paramObject).cnu)) && (s.p(this.cnv, ((h)paramObject).cnv)) && (s.p(this.lifecycle, ((h)paramObject).lifecycle)) && (s.p(this.cpp, ((h)paramObject).cpp)) && (this.cmi == ((h)paramObject).cmi) && (s.p(this.bRx, ((h)paramObject).bRx)) && (s.p(this.cpj, ((h)paramObject).cpj)) && (this.cpk == ((h)paramObject).cpk) && (this.bitmapConfig == ((h)paramObject).bitmapConfig) && (this.cpz == ((h)paramObject).cpz) && (this.col == ((h)paramObject).col) && (this.cns == ((h)paramObject).cns) && (this.cnt == ((h)paramObject).cnt) && (this.cnw == ((h)paramObject).cnw) && (this.cnx == ((h)paramObject).cnx) && (this.cny == ((h)paramObject).cny) && (s.p(this.cpA, ((h)paramObject).cpA)) && (s.p(this.cpB, ((h)paramObject).cpB)) && (s.p(this.cpC, ((h)paramObject).cpC)) && (s.p(this.cpD, ((h)paramObject).cpD)) && (s.p(this.cpE, ((h)paramObject).cpE)) && (s.p(this.cpF, ((h)paramObject).cpF)) && (s.p(this.cpG, ((h)paramObject).cpG)) && (s.p(this.cld, ((h)paramObject).cld)))
    {
      AppMethodBeat.o(187954);
      return true;
    }
    AppMethodBeat.o(187954);
    return false;
  }
  
  public final int hashCode()
  {
    int i8 = 0;
    AppMethodBeat.i(187970);
    int i9 = this.context.hashCode();
    int i10 = this.cpt.hashCode();
    Object localObject = this.com;
    int i;
    int j;
    label53:
    int k;
    label66:
    int m;
    label80:
    int n;
    label94:
    int i1;
    label108:
    int i2;
    label122:
    int i11;
    int i12;
    int i13;
    int i14;
    int i15;
    int i16;
    int i17;
    int i18;
    int i19;
    int i20;
    int i21;
    int i22;
    int i23;
    int i24;
    int i25;
    int i26;
    int i27;
    int i3;
    label289:
    int i4;
    label303:
    int i5;
    label317:
    int i6;
    label331:
    int i7;
    if (localObject == null)
    {
      i = 0;
      localObject = this.cpu;
      if (localObject != null) {
        break label587;
      }
      j = 0;
      localObject = this.cpv;
      if (localObject != null) {
        break label596;
      }
      k = 0;
      localObject = this.cpw;
      if (localObject != null) {
        break label605;
      }
      m = 0;
      localObject = this.cnq;
      if (localObject != null) {
        break label615;
      }
      n = 0;
      localObject = this.cpx;
      if (localObject != null) {
        break label625;
      }
      i1 = 0;
      localObject = this.cpy;
      if (localObject != null) {
        break label635;
      }
      i2 = 0;
      i11 = this.cot.hashCode();
      i12 = this.cnu.hashCode();
      i13 = this.cnv.hashCode();
      i14 = this.lifecycle.hashCode();
      i15 = this.cpp.hashCode();
      i16 = this.cmi.hashCode();
      i17 = this.bRx.hashCode();
      i18 = this.cpj.hashCode();
      i19 = this.cpk.hashCode();
      i20 = this.bitmapConfig.hashCode();
      i21 = e..ExternalSyntheticBackport0.m(this.cpz);
      i22 = e..ExternalSyntheticBackport0.m(this.col);
      i23 = e..ExternalSyntheticBackport0.m(this.cns);
      i24 = e..ExternalSyntheticBackport0.m(this.cnt);
      i25 = this.cnw.hashCode();
      i26 = this.cnx.hashCode();
      i27 = this.cny.hashCode();
      localObject = this.cpA;
      if (localObject != null) {
        break label645;
      }
      i3 = 0;
      localObject = this.cpB;
      if (localObject != null) {
        break label655;
      }
      i4 = 0;
      localObject = this.cpC;
      if (localObject != null) {
        break label665;
      }
      i5 = 0;
      localObject = this.cpD;
      if (localObject != null) {
        break label675;
      }
      i6 = 0;
      localObject = this.cpE;
      if (localObject != null) {
        break label685;
      }
      i7 = 0;
      label345:
      localObject = this.cpF;
      if (localObject != null) {
        break label695;
      }
    }
    for (;;)
    {
      int i28 = this.cpG.hashCode();
      int i29 = this.cld.hashCode();
      AppMethodBeat.o(187970);
      return (((i7 + (i6 + (i5 + (i4 + (i3 + ((((((((((((((((((i2 + (i1 + (n + (m + (k + (j + (i + (i9 * 31 + i10) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31) * 31) * 31) * 31) * 31) * 31 + i8) * 31 + i28) * 31 + i29;
      i = localObject.hashCode();
      break;
      label587:
      j = localObject.hashCode();
      break label53;
      label596:
      k = ((MemoryCache.Key)localObject).hashCode();
      break label66;
      label605:
      m = ((MemoryCache.Key)localObject).hashCode();
      break label80;
      label615:
      n = ((ColorSpace)localObject).hashCode();
      break label94;
      label625:
      i1 = ((r)localObject).hashCode();
      break label108;
      label635:
      i2 = localObject.hashCode();
      break label122;
      label645:
      i3 = ((Integer)localObject).intValue();
      break label289;
      label655:
      i4 = ((Drawable)localObject).hashCode();
      break label303;
      label665:
      i5 = ((Integer)localObject).intValue();
      break label317;
      label675:
      i6 = ((Drawable)localObject).hashCode();
      break label331;
      label685:
      i7 = ((Integer)localObject).intValue();
      break label345;
      label695:
      i8 = ((Drawable)localObject).hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187987);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ImageRequest(context=").append(this.context).append(", data=").append(this.cpt).append(", target=").append(this.com).append(", listener=").append(this.cpu).append(", memoryCacheKey=").append(this.cpv).append(", placeholderMemoryCacheKey=").append(this.cpw).append(", colorSpace=").append(this.cnq).append(", fetcher=").append(this.cpx).append(", decoder=").append(this.cpy).append(", transformations=").append(this.cot).append(", headers=").append(this.cnu).append(", parameters=");
    ((StringBuilder)localObject).append(this.cnv).append(", lifecycle=").append(this.lifecycle).append(", sizeResolver=").append(this.cpp).append(", scale=").append(this.cmi).append(", dispatcher=").append(this.bRx).append(", transition=").append(this.cpj).append(", precision=").append(this.cpk).append(", bitmapConfig=").append(this.bitmapConfig).append(", allowConversionToBitmap=").append(this.cpz).append(", allowHardware=").append(this.col).append(", allowRgb565=").append(this.cns).append(", premultipliedAlpha=").append(this.cnt);
    ((StringBuilder)localObject).append(", memoryCachePolicy=").append(this.cnw).append(", diskCachePolicy=").append(this.cnx).append(", networkCachePolicy=").append(this.cny).append(", placeholderResId=").append(this.cpA).append(", placeholderDrawable=").append(this.cpB).append(", errorResId=").append(this.cpC).append(", errorDrawable=").append(this.cpD).append(", fallbackResId=").append(this.cpE).append(", fallbackDrawable=").append(this.cpF).append(", defined=").append(this.cpG).append(", defaults=").append(this.cld).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(187987);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcoil/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "request", "Lcoil/request/ImageRequest;", "(Lcoil/request/ImageRequest;Landroid/content/Context;)V", "allowConversionToBitmap", "", "allowHardware", "Ljava/lang/Boolean;", "allowRgb565", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "data", "decoder", "Lcoil/decode/Decoder;", "defaults", "Lcoil/request/DefaultRequestOptions;", "diskCachePolicy", "Lcoil/request/CachePolicy;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "", "Ljava/lang/Integer;", "fallbackDrawable", "fallbackResId", "fetcher", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "headers", "Lokhttp3/Headers$Builder;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "memoryCachePolicy", "networkCachePolicy", "parameters", "Lcoil/request/Parameters$Builder;", "placeholderDrawable", "placeholderMemoryCacheKey", "placeholderResId", "precision", "Lcoil/size/Precision;", "premultipliedAlpha", "resolvedLifecycle", "resolvedScale", "Lcoil/size/Scale;", "resolvedSizeResolver", "Lcoil/size/SizeResolver;", "scale", "sizeResolver", "target", "Lcoil/target/Target;", "transformations", "", "Lcoil/transform/Transformation;", "transition", "Lcoil/transition/Transition;", "addHeader", "name", "", "value", "enable", "config", "build", "crossfade", "durationMillis", "policy", "error", "drawable", "drawableResId", "fallback", "T", "type", "Lokhttp3/Headers;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "onCancel", "onError", "Lkotlin/Function2;", "", "throwable", "onSuccess", "Lcoil/request/ImageResult$Metadata;", "metadata", "key", "Lcoil/request/Parameters;", "placeholder", "removeHeader", "removeParameter", "resetResolvedScale", "resetResolvedValues", "resolveLifecycle", "resolveScale", "resolveSizeResolver", "setHeader", "setParameter", "cacheKey", "size", "Lcoil/size/Size;", "resolver", "width", "height", "result", "imageView", "Landroid/widget/ImageView;", "", "([Lcoil/transform/Transformation;)Lcoil/request/ImageRequest$Builder;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private al bRx;
    private Bitmap.Config bitmapConfig;
    public c cld;
    private coil.size.e cmi;
    private ColorSpace cnq;
    private boolean cnt;
    private b cnw;
    private b cnx;
    private b cny;
    public coil.target.b com;
    private final Context context;
    private List<? extends coil.k.a> cot;
    private Integer cpA;
    private Drawable cpB;
    private Integer cpC;
    private Drawable cpD;
    private Integer cpE;
    private Drawable cpF;
    private q.a cpH;
    private l.a cpI;
    private androidx.lifecycle.j cpJ;
    private f cpK;
    public coil.size.e cpL;
    private coil.l.c cpj;
    public coil.size.b cpk;
    private f cpp;
    private Boolean cpq;
    private Boolean cpr;
    private Object cpt;
    private h.b cpu;
    private MemoryCache.Key cpv;
    private MemoryCache.Key cpw;
    private r<? extends coil.g.g<?>, ? extends Class<?>> cpx;
    private coil.e.e cpy;
    private boolean cpz;
    private androidx.lifecycle.j lifecycle;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(187951);
      this.context = paramContext;
      this.cld = c.cpo;
      this.cpt = null;
      this.com = null;
      this.cpu = null;
      this.cpv = null;
      this.cpw = null;
      if (Build.VERSION.SDK_INT >= 26) {
        this.cnq = null;
      }
      this.cpx = null;
      this.cpy = null;
      this.cot = ((List)ab.aivy);
      this.cpH = null;
      this.cpI = null;
      this.lifecycle = null;
      this.cpp = null;
      this.cmi = null;
      this.bRx = null;
      this.cpj = null;
      this.cpk = null;
      this.bitmapConfig = null;
      this.cpq = null;
      this.cpr = null;
      this.cnt = true;
      this.cpz = true;
      this.cnw = null;
      this.cnx = null;
      this.cny = null;
      this.cpA = null;
      this.cpB = null;
      this.cpC = null;
      this.cpD = null;
      this.cpE = null;
      this.cpF = null;
      this.cpJ = null;
      this.cpK = null;
      this.cpL = null;
      AppMethodBeat.o(187951);
    }
    
    public a(h paramh, Context paramContext)
    {
      AppMethodBeat.i(187983);
      this.context = paramContext;
      this.cld = paramh.cld;
      this.cpt = paramh.cpt;
      this.com = paramh.com;
      this.cpu = paramh.cpu;
      this.cpv = paramh.cpv;
      this.cpw = paramh.cpw;
      if (Build.VERSION.SDK_INT >= 26) {
        this.cnq = paramh.cnq;
      }
      this.cpx = paramh.cpx;
      this.cpy = paramh.cpy;
      this.cot = paramh.cot;
      this.cpH = paramh.cnu.kGL();
      this.cpI = new l.a(paramh.cnv);
      this.lifecycle = paramh.cpG.lifecycle;
      this.cpp = paramh.cpG.cpp;
      this.cmi = paramh.cpG.cmi;
      this.bRx = paramh.cpG.bRx;
      this.cpj = paramh.cpG.cpj;
      this.cpk = paramh.cpG.cpk;
      this.bitmapConfig = paramh.cpG.bitmapConfig;
      this.cpq = paramh.cpG.cpq;
      this.cpr = paramh.cpG.cpr;
      this.cnt = paramh.cnt;
      this.cpz = paramh.cpz;
      this.cnw = paramh.cpG.cnw;
      this.cnx = paramh.cpG.cnx;
      this.cny = paramh.cpG.cny;
      this.cpA = paramh.cpA;
      this.cpB = paramh.cpB;
      this.cpC = paramh.cpC;
      this.cpD = paramh.cpD;
      this.cpE = paramh.cpE;
      this.cpF = paramh.cpF;
      if (paramh.context == paramContext)
      {
        this.cpJ = paramh.lifecycle;
        this.cpK = paramh.cpp;
        this.cpL = paramh.cmi;
        AppMethodBeat.o(187983);
        return;
      }
      this.cpJ = null;
      this.cpK = null;
      this.cpL = null;
      AppMethodBeat.o(187983);
    }
    
    private final androidx.lifecycle.j Nc()
    {
      AppMethodBeat.i(187998);
      Object localObject = this.com;
      if ((localObject instanceof coil.target.c)) {}
      for (localObject = ((coil.target.c)localObject).getView().getContext();; localObject = this.context)
      {
        localObject = coil.util.c.aA((Context)localObject);
        if (localObject != null) {
          break;
        }
        localObject = (androidx.lifecycle.j)g.cps;
        AppMethodBeat.o(187998);
        return localObject;
      }
      AppMethodBeat.o(187998);
      return localObject;
    }
    
    private final f Nd()
    {
      AppMethodBeat.i(188010);
      Object localObject1 = this.com;
      if ((localObject1 instanceof coil.target.c))
      {
        localObject1 = ((coil.target.c)localObject1).getView();
        if ((localObject1 instanceof ImageView))
        {
          localObject2 = ((ImageView)localObject1).getScaleType();
          if ((localObject2 == ImageView.ScaleType.CENTER) || (localObject2 == ImageView.ScaleType.MATRIX)) {}
          for (int i = 1; i != 0; i = 0)
          {
            localObject1 = f.cqb;
            localObject1 = f.a.b((Size)OriginalSize.cpS);
            AppMethodBeat.o(188010);
            return localObject1;
          }
        }
        Object localObject2 = coil.size.g.cqd;
        localObject1 = (f)g.a.cl((View)localObject1);
        AppMethodBeat.o(188010);
        return localObject1;
      }
      localObject1 = (f)new coil.size.a(this.context);
      AppMethodBeat.o(188010);
      return localObject1;
    }
    
    private final coil.size.e Ne()
    {
      AppMethodBeat.i(188022);
      Object localObject = this.cpp;
      if ((localObject instanceof coil.size.g))
      {
        localObject = ((coil.size.g)localObject).getView();
        if ((localObject instanceof ImageView))
        {
          localObject = coil.util.d.c((ImageView)localObject);
          AppMethodBeat.o(188022);
          return localObject;
        }
      }
      localObject = this.com;
      if ((localObject instanceof coil.target.c))
      {
        localObject = ((coil.target.c)localObject).getView();
        if ((localObject instanceof ImageView))
        {
          localObject = coil.util.d.c((ImageView)localObject);
          AppMethodBeat.o(188022);
          return localObject;
        }
      }
      localObject = coil.size.e.cpY;
      AppMethodBeat.o(188022);
      return localObject;
    }
    
    private a a(f paramf)
    {
      AppMethodBeat.i(187991);
      s.u(paramf, "resolver");
      a locala = (a)this;
      locala.cpp = paramf;
      locala.Nb();
      paramf = (a)this;
      AppMethodBeat.o(187991);
      return paramf;
    }
    
    public final h Na()
    {
      AppMethodBeat.i(188068);
      Context localContext = this.context;
      Object localObject4 = this.cpt;
      coil.target.b localb;
      h.b localb1;
      MemoryCache.Key localKey1;
      MemoryCache.Key localKey2;
      ColorSpace localColorSpace;
      r localr;
      coil.e.e locale;
      List localList;
      Object localObject1;
      label90:
      q localq;
      label111:
      l locall;
      Object localObject2;
      Object localObject3;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      boolean bool3;
      boolean bool1;
      if (localObject4 == null)
      {
        localObject4 = j.cpN;
        localb = this.com;
        localb1 = this.cpu;
        localKey1 = this.cpv;
        localKey2 = this.cpw;
        localColorSpace = this.cnq;
        localr = this.cpx;
        locale = this.cpy;
        localList = this.cot;
        localObject1 = this.cpH;
        if (localObject1 != null) {
          break label637;
        }
        localObject1 = null;
        localq = coil.util.d.a((q)localObject1);
        localObject1 = this.cpI;
        if (localObject1 != null) {
          break label647;
        }
        localObject1 = null;
        locall = coil.util.d.b((l)localObject1);
        localObject2 = this.lifecycle;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.cpJ;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Nc();
          }
        }
        localObject3 = this.cpp;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject3 = this.cpK;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = Nd();
          }
        }
        localObject5 = this.cmi;
        localObject3 = localObject5;
        if (localObject5 == null)
        {
          localObject5 = this.cpL;
          localObject3 = localObject5;
          if (localObject5 == null) {
            localObject3 = Ne();
          }
        }
        localObject6 = this.bRx;
        localObject5 = localObject6;
        if (localObject6 == null) {
          localObject5 = this.cld.bRx;
        }
        localObject7 = this.cpj;
        localObject6 = localObject7;
        if (localObject7 == null) {
          localObject6 = this.cld.cpj;
        }
        localObject8 = this.cpk;
        localObject7 = localObject8;
        if (localObject8 == null) {
          localObject7 = this.cld.cpk;
        }
        localObject9 = this.bitmapConfig;
        localObject8 = localObject9;
        if (localObject9 == null) {
          localObject8 = this.cld.bitmapConfig;
        }
        bool3 = this.cpz;
        localObject9 = this.cpq;
        if (localObject9 != null) {
          break label657;
        }
        bool1 = this.cld.col;
        label346:
        localObject9 = this.cpr;
        if (localObject9 != null) {
          break label666;
        }
      }
      label647:
      label657:
      label666:
      for (boolean bool2 = this.cld.cns;; bool2 = ((Boolean)localObject9).booleanValue())
      {
        boolean bool4 = this.cnt;
        Object localObject10 = this.cnw;
        localObject9 = localObject10;
        if (localObject10 == null) {
          localObject9 = this.cld.cnw;
        }
        Object localObject11 = this.cnx;
        localObject10 = localObject11;
        if (localObject11 == null) {
          localObject10 = this.cld.cnx;
        }
        Object localObject12 = this.cny;
        localObject11 = localObject12;
        if (localObject12 == null) {
          localObject11 = this.cld.cny;
        }
        localObject12 = new d(this.lifecycle, this.cpp, this.cmi, this.bRx, this.cpj, this.cpk, this.bitmapConfig, this.cpq, this.cpr, this.cnw, this.cnx, this.cny);
        c localc = this.cld;
        Integer localInteger1 = this.cpA;
        Drawable localDrawable1 = this.cpB;
        Integer localInteger2 = this.cpC;
        Drawable localDrawable2 = this.cpD;
        Integer localInteger3 = this.cpE;
        Drawable localDrawable3 = this.cpF;
        s.s(localq, "orEmpty()");
        localObject1 = new h(localContext, localObject4, localb, localb1, localKey1, localKey2, localColorSpace, localr, locale, localList, localq, locall, (androidx.lifecycle.j)localObject1, (f)localObject2, (coil.size.e)localObject3, (al)localObject5, (coil.l.c)localObject6, (coil.size.b)localObject7, (Bitmap.Config)localObject8, bool3, bool1, bool2, bool4, (b)localObject9, (b)localObject10, (b)localObject11, localInteger1, localDrawable1, localInteger2, localDrawable2, localInteger3, localDrawable3, (d)localObject12, localc, (byte)0);
        AppMethodBeat.o(188068);
        return localObject1;
        break;
        label637:
        localObject1 = ((q.a)localObject1).kGM();
        break label90;
        localObject1 = ((l.a)localObject1).Ng();
        break label111;
        bool1 = ((Boolean)localObject9).booleanValue();
        break label346;
      }
    }
    
    public final void Nb()
    {
      this.cpJ = null;
      this.cpK = null;
      this.cpL = null;
    }
    
    public final a a(Size paramSize)
    {
      AppMethodBeat.i(188038);
      s.u(paramSize, "size");
      f.a locala = f.cqb;
      paramSize = a(f.a.b(paramSize));
      AppMethodBeat.o(188038);
      return paramSize;
    }
    
    public final a a(coil.size.e parame)
    {
      AppMethodBeat.i(188050);
      s.u(parame, "scale");
      ((a)this).cmi = parame;
      parame = (a)this;
      AppMethodBeat.o(188050);
      return parame;
    }
    
    public final a aZ(Object paramObject)
    {
      ((a)this).cpt = paramObject;
      return (a)this;
    }
    
    public final a gS(int paramInt)
    {
      AppMethodBeat.i(188057);
      if (paramInt > 0) {}
      for (Object localObject = (coil.l.c)new coil.l.a(paramInt, 2);; localObject = coil.l.c.cqo)
      {
        s.u(localObject, "transition");
        ((a)this).cpj = ((coil.l.c)localObject);
        localObject = (a)this;
        AppMethodBeat.o(188057);
        return localObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcoil/request/ImageRequest$Listener;", "", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(h paramh);
    
    public abstract void a(h paramh, i.a parama);
    
    public abstract void a(h paramh, Throwable paramThrowable);
    
    public abstract void e(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.j.h
 * JD-Core Version:    0.7.0.1
 */