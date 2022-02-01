package coil.j;

import android.graphics.Bitmap.Config;
import androidx.lifecycle.j;
import coil.l.c;
import coil.size.e;
import coil.size.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.al;

@Metadata(d1={""}, d2={"Lcoil/request/DefinedRequestOptions;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPrecision", "()Lcoil/size/Precision;", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTransition", "()Lcoil/transition/Transition;", "copy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)Lcoil/request/DefinedRequestOptions;", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final al bRx;
  final Bitmap.Config bitmapConfig;
  public final e cmi;
  final b cnw;
  final b cnx;
  final b cny;
  public final c cpj;
  public final coil.size.b cpk;
  public final f cpp;
  final Boolean cpq;
  final Boolean cpr;
  final j lifecycle;
  
  public d(j paramj, f paramf, e parame, al paramal, c paramc, coil.size.b paramb, Bitmap.Config paramConfig, Boolean paramBoolean1, Boolean paramBoolean2, b paramb1, b paramb2, b paramb3)
  {
    this.lifecycle = paramj;
    this.cpp = paramf;
    this.cmi = parame;
    this.bRx = paramal;
    this.cpj = paramc;
    this.cpk = paramb;
    this.bitmapConfig = paramConfig;
    this.cpq = paramBoolean1;
    this.cpr = paramBoolean2;
    this.cnw = paramb1;
    this.cnx = paramb2;
    this.cny = paramb3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187914);
    if (this == paramObject)
    {
      AppMethodBeat.o(187914);
      return true;
    }
    if (((paramObject instanceof d)) && (s.p(this.lifecycle, ((d)paramObject).lifecycle)) && (s.p(this.cpp, ((d)paramObject).cpp)) && (this.cmi == ((d)paramObject).cmi) && (s.p(this.bRx, ((d)paramObject).bRx)) && (s.p(this.cpj, ((d)paramObject).cpj)) && (this.cpk == ((d)paramObject).cpk) && (this.bitmapConfig == ((d)paramObject).bitmapConfig) && (s.p(this.cpq, ((d)paramObject).cpq)) && (s.p(this.cpr, ((d)paramObject).cpr)) && (this.cnw == ((d)paramObject).cnw) && (this.cnx == ((d)paramObject).cnx) && (this.cny == ((d)paramObject).cny))
    {
      AppMethodBeat.o(187914);
      return true;
    }
    AppMethodBeat.o(187914);
    return false;
  }
  
  public final int hashCode()
  {
    int i7 = 0;
    AppMethodBeat.i(187926);
    Object localObject = this.lifecycle;
    int i;
    int j;
    label34:
    int k;
    label47:
    int m;
    label61:
    int n;
    label75:
    int i1;
    label89:
    int i2;
    label103:
    int i3;
    label117:
    int i4;
    label131:
    int i5;
    label145:
    int i6;
    if (localObject == null)
    {
      i = 0;
      localObject = this.cpp;
      if (localObject != null) {
        break label250;
      }
      j = 0;
      localObject = this.cmi;
      if (localObject != null) {
        break label259;
      }
      k = 0;
      localObject = this.bRx;
      if (localObject != null) {
        break label268;
      }
      m = 0;
      localObject = this.cpj;
      if (localObject != null) {
        break label278;
      }
      n = 0;
      localObject = this.cpk;
      if (localObject != null) {
        break label288;
      }
      i1 = 0;
      localObject = this.bitmapConfig;
      if (localObject != null) {
        break label298;
      }
      i2 = 0;
      localObject = this.cpq;
      if (localObject != null) {
        break label308;
      }
      i3 = 0;
      localObject = this.cpr;
      if (localObject != null) {
        break label318;
      }
      i4 = 0;
      localObject = this.cnw;
      if (localObject != null) {
        break label328;
      }
      i5 = 0;
      localObject = this.cnx;
      if (localObject != null) {
        break label338;
      }
      i6 = 0;
      label159:
      localObject = this.cny;
      if (localObject != null) {
        break label348;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(187926);
      return (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i7;
      i = ((j)localObject).hashCode();
      break;
      label250:
      j = localObject.hashCode();
      break label34;
      label259:
      k = ((e)localObject).hashCode();
      break label47;
      label268:
      m = ((al)localObject).hashCode();
      break label61;
      label278:
      n = localObject.hashCode();
      break label75;
      label288:
      i1 = ((coil.size.b)localObject).hashCode();
      break label89;
      label298:
      i2 = ((Bitmap.Config)localObject).hashCode();
      break label103;
      label308:
      i3 = localObject.hashCode();
      break label117;
      label318:
      i4 = localObject.hashCode();
      break label131;
      label328:
      i5 = ((b)localObject).hashCode();
      break label145;
      label338:
      i6 = ((b)localObject).hashCode();
      break label159;
      label348:
      i7 = ((b)localObject).hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187936);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DefinedRequestOptions(lifecycle=").append(this.lifecycle).append(", sizeResolver=").append(this.cpp).append(", scale=").append(this.cmi).append(", dispatcher=").append(this.bRx).append(", transition=").append(this.cpj).append(", precision=").append(this.cpk).append(", bitmapConfig=").append(this.bitmapConfig).append(", allowHardware=").append(this.cpq).append(", allowRgb565=").append(this.cpr).append(", memoryCachePolicy=").append(this.cnw).append(", diskCachePolicy=").append(this.cnx).append(", networkCachePolicy=");
    ((StringBuilder)localObject).append(this.cny).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(187936);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.j.d
 * JD-Core Version:    0.7.0.1
 */