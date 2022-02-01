package coil.size;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/size/DisplaySizeResolver;", "Lcoil/size/SizeResolver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "equals", "", "other", "", "hashCode", "", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f
{
  private final Context context;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(188190);
    this.context = paramContext;
    AppMethodBeat.o(188190);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188205);
    if ((this == paramObject) || (((paramObject instanceof a)) && (s.p(this.context, ((a)paramObject).context))))
    {
      AppMethodBeat.o(188205);
      return true;
    }
    AppMethodBeat.o(188205);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188218);
    int i = this.context.hashCode();
    AppMethodBeat.o(188218);
    return i;
  }
  
  public final Object o(d<? super Size> paramd)
  {
    AppMethodBeat.i(188198);
    paramd = this.context.getResources().getDisplayMetrics();
    paramd = new PixelSize(paramd.widthPixels, paramd.heightPixels);
    AppMethodBeat.o(188198);
    return paramd;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188227);
    String str = "DisplaySizeResolver(context=" + this.context + ')';
    AppMethodBeat.o(188227);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.size.a
 * JD-Core Version:    0.7.0.1
 */