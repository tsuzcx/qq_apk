package coil.e;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import android.os.Build.VERSION;
import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import coil.j.b;
import coil.j.l;
import coil.size.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import okhttp3.q;

@Metadata(d1={""}, d2={"Lcoil/decode/Options;", "", "context", "Landroid/content/Context;", "config", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "allowRgb565", "headers", "Lokhttp3/Headers;", "parameters", "Lcoil/request/Parameters;", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Scale;ZZLokhttp3/Headers;Lcoil/request/Parameters;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "premultipliedAlpha", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Scale;ZZZLokhttp3/Headers;Lcoil/request/Parameters;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowInexactSize", "()Z", "getAllowRgb565", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "getContext", "()Landroid/content/Context;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getHeaders", "()Lokhttp3/Headers;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "copy", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public final Bitmap.Config clE;
  public final e cmi;
  public final ColorSpace cnq;
  public final boolean cnr;
  public final boolean cns;
  public final boolean cnt;
  public final q cnu;
  private final l cnv;
  private final b cnw;
  public final b cnx;
  public final b cny;
  public final Context context;
  
  public i(Context paramContext, Bitmap.Config paramConfig, ColorSpace paramColorSpace, e parame, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, q paramq, l paraml, b paramb1, b paramb2, b paramb3)
  {
    AppMethodBeat.i(187837);
    this.context = paramContext;
    this.clE = paramConfig;
    this.cnq = paramColorSpace;
    this.cmi = parame;
    this.cnr = paramBoolean1;
    this.cns = paramBoolean2;
    this.cnt = paramBoolean3;
    this.cnu = paramq;
    this.cnv = paraml;
    this.cnw = paramb1;
    this.cnx = paramb2;
    this.cny = paramb3;
    AppMethodBeat.o(187837);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187853);
    if (this == paramObject)
    {
      AppMethodBeat.o(187853);
      return true;
    }
    if (((paramObject instanceof i)) && (s.p(this.context, ((i)paramObject).context)) && (this.clE == ((i)paramObject).clE) && ((Build.VERSION.SDK_INT < 26) || (s.p(this.cnq, ((i)paramObject).cnq))) && (this.cmi == ((i)paramObject).cmi) && (this.cnr == ((i)paramObject).cnr) && (this.cns == ((i)paramObject).cns) && (this.cnt == ((i)paramObject).cnt) && (s.p(this.cnu, ((i)paramObject).cnu)) && (s.p(this.cnv, ((i)paramObject).cnv)) && (this.cnw == ((i)paramObject).cnw) && (this.cnx == ((i)paramObject).cnx) && (this.cny == ((i)paramObject).cny))
    {
      AppMethodBeat.o(187853);
      return true;
    }
    AppMethodBeat.o(187853);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(187863);
    int j = this.context.hashCode();
    int k = this.clE.hashCode();
    ColorSpace localColorSpace = this.cnq;
    if (localColorSpace == null) {}
    for (int i = 0;; i = localColorSpace.hashCode())
    {
      int m = this.cmi.hashCode();
      int n = e..ExternalSyntheticBackport0.m(this.cnr);
      int i1 = e..ExternalSyntheticBackport0.m(this.cns);
      int i2 = e..ExternalSyntheticBackport0.m(this.cnt);
      int i3 = this.cnu.hashCode();
      int i4 = this.cnv.hashCode();
      int i5 = this.cnw.hashCode();
      int i6 = this.cnx.hashCode();
      int i7 = this.cny.hashCode();
      AppMethodBeat.o(187863);
      return (((((((((i + (j * 31 + k) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187879);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Options(context=").append(this.context).append(", config=").append(this.clE).append(", colorSpace=").append(this.cnq).append(", scale=").append(this.cmi).append(", allowInexactSize=").append(this.cnr).append(", allowRgb565=").append(this.cns).append(", premultipliedAlpha=").append(this.cnt).append(", headers=").append(this.cnu).append(", parameters=").append(this.cnv).append(", memoryCachePolicy=").append(this.cnw).append(", diskCachePolicy=").append(this.cnx).append(", networkCachePolicy=");
    ((StringBuilder)localObject).append(this.cny).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(187879);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.e.i
 * JD-Core Version:    0.7.0.1
 */