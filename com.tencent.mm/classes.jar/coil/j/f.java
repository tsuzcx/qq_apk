package coil.j;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/request/ErrorResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "throwable", "", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Ljava/lang/Throwable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getRequest", "()Lcoil/request/ImageRequest;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends i
{
  public final h cmE;
  public final Drawable drawable;
  public final Throwable throwable;
  
  public f(Drawable paramDrawable, h paramh, Throwable paramThrowable)
  {
    super((byte)0);
    AppMethodBeat.i(187896);
    this.drawable = paramDrawable;
    this.cmE = paramh;
    this.throwable = paramThrowable;
    AppMethodBeat.o(187896);
  }
  
  public final h MR()
  {
    return this.cmE;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187944);
    if (this == paramObject)
    {
      AppMethodBeat.o(187944);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(187944);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.drawable, paramObject.drawable))
    {
      AppMethodBeat.o(187944);
      return false;
    }
    if (!s.p(this.cmE, paramObject.cmE))
    {
      AppMethodBeat.o(187944);
      return false;
    }
    if (!s.p(this.throwable, paramObject.throwable))
    {
      AppMethodBeat.o(187944);
      return false;
    }
    AppMethodBeat.o(187944);
    return true;
  }
  
  public final Drawable getDrawable()
  {
    return this.drawable;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(187933);
    if (this.drawable == null) {}
    for (int i = 0;; i = this.drawable.hashCode())
    {
      int j = this.cmE.hashCode();
      int k = this.throwable.hashCode();
      AppMethodBeat.o(187933);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187921);
    String str = "ErrorResult(drawable=" + this.drawable + ", request=" + this.cmE + ", throwable=" + this.throwable + ')';
    AppMethodBeat.o(187921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.j.f
 * JD-Core Version:    0.7.0.1
 */