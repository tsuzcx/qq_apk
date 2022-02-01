package coil.size;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.a.a;
import kotlin.g.b.s;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcoil/size/RealViewSizeResolver;", "T", "Landroid/view/View;", "Lcoil/size/ViewSizeResolver;", "view", "subtractPadding", "", "(Landroid/view/View;Z)V", "getSubtractPadding", "()Z", "getView", "()Landroid/view/View;", "Landroid/view/View;", "equals", "other", "", "hashCode", "", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T extends View>
  implements g<T>
{
  private final boolean cpX;
  private final T view;
  
  public d(T paramT)
  {
    AppMethodBeat.i(188187);
    this.view = paramT;
    this.cpX = true;
    AppMethodBeat.o(188187);
  }
  
  public final boolean Nh()
  {
    return this.cpX;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188216);
    if (this == paramObject)
    {
      AppMethodBeat.o(188216);
      return true;
    }
    if (((paramObject instanceof d)) && (s.p(this.view, ((d)paramObject).view)) && (this.cpX == ((d)paramObject).cpX))
    {
      AppMethodBeat.o(188216);
      return true;
    }
    AppMethodBeat.o(188216);
    return false;
  }
  
  public final T getView()
  {
    return this.view;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188225);
    int i = this.view.hashCode();
    int j = e..ExternalSyntheticBackport0.m(this.cpX);
    AppMethodBeat.o(188225);
    return i * 31 + j;
  }
  
  public final Object o(kotlin.d.d<? super Size> paramd)
  {
    AppMethodBeat.i(188246);
    Object localObject = g.b.a(this);
    if (localObject != null)
    {
      AppMethodBeat.o(188246);
      return localObject;
    }
    localObject = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject).kBA();
    p localp = (p)localObject;
    ViewTreeObserver localViewTreeObserver = getView().getViewTreeObserver();
    g.b.b localb = new g.b.b(this, localViewTreeObserver, localp);
    localViewTreeObserver.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)localb);
    localp.bg((kotlin.g.a.b)new g.b.a(this, localViewTreeObserver, localb));
    localObject = ((q)localObject).getResult();
    if (localObject == a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(188246);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188234);
    String str = "RealViewSizeResolver(view=" + this.view + ", subtractPadding=" + this.cpX + ')';
    AppMethodBeat.o(188234);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.size.d
 * JD-Core Version:    0.7.0.1
 */