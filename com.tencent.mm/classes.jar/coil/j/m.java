package coil.j;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/request/SuccessResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "metadata", "Lcoil/request/ImageResult$Metadata;", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Lcoil/request/ImageResult$Metadata;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getMetadata", "()Lcoil/request/ImageResult$Metadata;", "getRequest", "()Lcoil/request/ImageRequest;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends i
{
  public final h cmE;
  public final i.a coM;
  public final Drawable drawable;
  
  public m(Drawable paramDrawable, h paramh, i.a parama)
  {
    super((byte)0);
    AppMethodBeat.i(187883);
    this.drawable = paramDrawable;
    this.cmE = paramh;
    this.coM = parama;
    AppMethodBeat.o(187883);
  }
  
  public final h MR()
  {
    return this.cmE;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187924);
    if (this == paramObject)
    {
      AppMethodBeat.o(187924);
      return true;
    }
    if (!(paramObject instanceof m))
    {
      AppMethodBeat.o(187924);
      return false;
    }
    paramObject = (m)paramObject;
    if (!s.p(this.drawable, paramObject.drawable))
    {
      AppMethodBeat.o(187924);
      return false;
    }
    if (!s.p(this.cmE, paramObject.cmE))
    {
      AppMethodBeat.o(187924);
      return false;
    }
    if (!s.p(this.coM, paramObject.coM))
    {
      AppMethodBeat.o(187924);
      return false;
    }
    AppMethodBeat.o(187924);
    return true;
  }
  
  public final Drawable getDrawable()
  {
    return this.drawable;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(187913);
    int i = this.drawable.hashCode();
    int j = this.cmE.hashCode();
    int k = this.coM.hashCode();
    AppMethodBeat.o(187913);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187904);
    String str = "SuccessResult(drawable=" + this.drawable + ", request=" + this.cmE + ", metadata=" + this.coM + ')';
    AppMethodBeat.o(187904);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.j.m
 * JD-Core Version:    0.7.0.1
 */