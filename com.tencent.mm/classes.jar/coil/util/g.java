package coil.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import coil.j.d;
import coil.j.h;
import coil.size.a;
import coil.size.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"allowInexactSize", "", "Lcoil/request/ImageRequest;", "getAllowInexactSize", "(Lcoil/request/ImageRequest;)Z", "fetcher", "Lcoil/fetch/Fetcher;", "T", "", "data", "(Lcoil/request/ImageRequest;Ljava/lang/Object;)Lcoil/fetch/Fetcher;", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "drawable", "resId", "", "default", "(Lcoil/request/ImageRequest;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "coil-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final Drawable a(h paramh, Drawable paramDrawable1, Integer paramInteger, Drawable paramDrawable2)
  {
    AppMethodBeat.i(188121);
    s.u(paramh, "<this>");
    if (paramDrawable1 != null)
    {
      AppMethodBeat.o(188121);
      return paramDrawable1;
    }
    if (paramInteger != null)
    {
      if (paramInteger.intValue() == 0)
      {
        AppMethodBeat.o(188121);
        return null;
      }
      paramh = c.z(paramh.context, paramInteger.intValue());
      AppMethodBeat.o(188121);
      return paramh;
    }
    AppMethodBeat.o(188121);
    return paramDrawable2;
  }
  
  public static final boolean i(h paramh)
  {
    AppMethodBeat.i(188134);
    s.u(paramh, "<this>");
    b localb = paramh.cpk;
    switch (g.a.$EnumSwitchMapping$0[localb.ordinal()])
    {
    default: 
      paramh = new p();
      AppMethodBeat.o(188134);
      throw paramh;
    case 1: 
      AppMethodBeat.o(188134);
      return false;
    case 2: 
      AppMethodBeat.o(188134);
      return true;
    }
    if (((paramh.com instanceof coil.target.c)) && ((((coil.target.c)paramh.com).getView() instanceof ImageView)) && ((paramh.cpp instanceof coil.size.g)) && (((coil.size.g)paramh.cpp).getView() == ((coil.target.c)paramh.com).getView()))
    {
      AppMethodBeat.o(188134);
      return true;
    }
    if ((paramh.cpG.cpp == null) && ((paramh.cpp instanceof a)))
    {
      AppMethodBeat.o(188134);
      return true;
    }
    AppMethodBeat.o(188134);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.util.g
 * JD-Core Version:    0.7.0.1
 */