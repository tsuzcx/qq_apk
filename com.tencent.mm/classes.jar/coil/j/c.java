package coil.j;

import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.al;

@Metadata(d1={""}, d2={"Lcoil/request/DefaultRequestOptions;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "placeholder", "Landroid/graphics/drawable/Drawable;", "error", "fallback", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Z", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getError", "()Landroid/graphics/drawable/Drawable;", "getFallback", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPlaceholder", "getPrecision", "()Lcoil/size/Precision;", "getTransition", "()Lcoil/transition/Transition;", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a cpi;
  public static final c cpo;
  final al bRx;
  final Bitmap.Config bitmapConfig;
  final boolean cns;
  final b cnw;
  final b cnx;
  final b cny;
  final boolean col;
  public final coil.l.c cpj;
  final coil.size.b cpk;
  final Drawable cpl;
  public final Drawable cpm;
  public final Drawable cpn;
  
  static
  {
    AppMethodBeat.i(187930);
    cpi = new c.a((byte)0);
    cpo = new c();
    AppMethodBeat.o(187930);
  }
  
  private c(al paramal, coil.l.c paramc, coil.size.b paramb, Bitmap.Config paramConfig, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, b paramb1, b paramb2, b paramb3)
  {
    AppMethodBeat.i(187901);
    this.bRx = paramal;
    this.cpj = paramc;
    this.cpk = paramb;
    this.bitmapConfig = paramConfig;
    this.col = paramBoolean1;
    this.cns = paramBoolean2;
    this.cpl = paramDrawable1;
    this.cpm = paramDrawable2;
    this.cpn = paramDrawable3;
    this.cnw = paramb1;
    this.cnx = paramb2;
    this.cny = paramb3;
    AppMethodBeat.o(187901);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187939);
    if (this == paramObject)
    {
      AppMethodBeat.o(187939);
      return true;
    }
    if (((paramObject instanceof c)) && (s.p(this.bRx, ((c)paramObject).bRx)) && (s.p(this.cpj, ((c)paramObject).cpj)) && (this.cpk == ((c)paramObject).cpk) && (this.bitmapConfig == ((c)paramObject).bitmapConfig) && (this.col == ((c)paramObject).col) && (this.cns == ((c)paramObject).cns) && (s.p(this.cpl, ((c)paramObject).cpl)) && (s.p(this.cpm, ((c)paramObject).cpm)) && (s.p(this.cpn, ((c)paramObject).cpn)) && (this.cnw == ((c)paramObject).cnw) && (this.cnx == ((c)paramObject).cnx) && (this.cny == ((c)paramObject).cny))
    {
      AppMethodBeat.o(187939);
      return true;
    }
    AppMethodBeat.o(187939);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(187949);
    int m = this.bRx.hashCode();
    int n = this.cpj.hashCode();
    int i1 = this.cpk.hashCode();
    int i2 = this.bitmapConfig.hashCode();
    int i3 = e..ExternalSyntheticBackport0.m(this.col);
    int i4 = e..ExternalSyntheticBackport0.m(this.cns);
    Drawable localDrawable = this.cpl;
    int i;
    int j;
    if (localDrawable == null)
    {
      i = 0;
      localDrawable = this.cpm;
      if (localDrawable != null) {
        break label205;
      }
      j = 0;
      label87:
      localDrawable = this.cpn;
      if (localDrawable != null) {
        break label214;
      }
    }
    for (;;)
    {
      int i5 = this.cnw.hashCode();
      int i6 = this.cnx.hashCode();
      int i7 = this.cny.hashCode();
      AppMethodBeat.o(187949);
      return ((((j + (i + (((((m * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31) * 31 + k) * 31 + i5) * 31 + i6) * 31 + i7;
      i = localDrawable.hashCode();
      break;
      label205:
      j = localDrawable.hashCode();
      break label87;
      label214:
      k = localDrawable.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187955);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DefaultRequestOptions(dispatcher=").append(this.bRx).append(", transition=").append(this.cpj).append(", precision=").append(this.cpk).append(", bitmapConfig=").append(this.bitmapConfig).append(", allowHardware=").append(this.col).append(", allowRgb565=").append(this.cns).append(", placeholder=").append(this.cpl).append(", error=").append(this.cpm).append(", fallback=").append(this.cpn).append(", memoryCachePolicy=").append(this.cnw).append(", diskCachePolicy=").append(this.cnx).append(", networkCachePolicy=");
    ((StringBuilder)localObject).append(this.cny).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(187955);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.j.c
 * JD-Core Version:    0.7.0.1
 */