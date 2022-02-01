package coil.size;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "Lcoil/size/SizeResolver;", "subtractPadding", "", "getSubtractPadding", "()Z", "view", "getView", "()Landroid/view/View;", "getDimension", "", "paramSize", "viewSize", "paddingSize", "isWidth", "getHeight", "getSize", "Lcoil/size/PixelSize;", "getWidth", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removePreDrawListenerSafe", "", "Landroid/view/ViewTreeObserver;", "victim", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g<T extends View>
  extends f
{
  public static final a cqd = a.cqe;
  
  public abstract boolean Nh();
  
  public abstract T getView();
  
  @Metadata(d1={""}, d2={"Lcoil/size/ViewSizeResolver$Companion;", "", "()V", "invoke", "Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "view", "subtractPadding", "", "create", "(Landroid/view/View;Z)Lcoil/size/ViewSizeResolver;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(188239);
      cqe = new a();
      AppMethodBeat.o(188239);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static <T extends View> int a(g<T> paramg, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      AppMethodBeat.i(188243);
      int i = paramInt1 - paramInt3;
      if (i > 0)
      {
        AppMethodBeat.o(188243);
        return i;
      }
      paramInt2 -= paramInt3;
      if (paramInt2 > 0)
      {
        AppMethodBeat.o(188243);
        return paramInt2;
      }
      if (paramInt1 == -2)
      {
        paramg = paramg.getView().getContext().getResources().getDisplayMetrics();
        if (paramBoolean)
        {
          paramInt1 = paramg.widthPixels;
          AppMethodBeat.o(188243);
          return paramInt1;
        }
        paramInt1 = paramg.heightPixels;
        AppMethodBeat.o(188243);
        return paramInt1;
      }
      AppMethodBeat.o(188243);
      return -1;
    }
    
    static <T extends View> PixelSize a(g<T> paramg)
    {
      AppMethodBeat.i(188211);
      int i = b(paramg);
      if (i <= 0)
      {
        AppMethodBeat.o(188211);
        return null;
      }
      int j = c(paramg);
      if (j <= 0)
      {
        AppMethodBeat.o(188211);
        return null;
      }
      paramg = new PixelSize(i, j);
      AppMethodBeat.o(188211);
      return paramg;
    }
    
    private static <T extends View> int b(g<T> paramg)
    {
      AppMethodBeat.i(188222);
      ViewGroup.LayoutParams localLayoutParams = paramg.getView().getLayoutParams();
      int i;
      int k;
      if (localLayoutParams == null)
      {
        i = -1;
        k = paramg.getView().getWidth();
        if (!paramg.Nh()) {
          break label87;
        }
      }
      label87:
      for (int j = paramg.getView().getPaddingLeft() + paramg.getView().getPaddingRight();; j = 0)
      {
        i = a(paramg, i, k, j, true);
        AppMethodBeat.o(188222);
        return i;
        i = localLayoutParams.width;
        break;
      }
    }
    
    private static <T extends View> int c(g<T> paramg)
    {
      AppMethodBeat.i(188233);
      ViewGroup.LayoutParams localLayoutParams = paramg.getView().getLayoutParams();
      int i;
      int k;
      if (localLayoutParams == null)
      {
        i = -1;
        k = paramg.getView().getHeight();
        if (!paramg.Nh()) {
          break label87;
        }
      }
      label87:
      for (int j = paramg.getView().getPaddingTop() + paramg.getView().getPaddingBottom();; j = 0)
      {
        i = a(paramg, i, k, j, false);
        AppMethodBeat.o(188233);
        return i;
        i = localLayoutParams.height;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Landroid/view/View;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<Throwable, ah>
    {
      a(g<T> paramg, ViewTreeObserver paramViewTreeObserver, g.b.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"coil/size/ViewSizeResolver$size$3$preDrawListener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "isResumed", "", "onPreDraw", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements ViewTreeObserver.OnPreDrawListener
    {
      private boolean cqi;
      
      b(g<T> paramg, ViewTreeObserver paramViewTreeObserver, p<? super Size> paramp) {}
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(188245);
        PixelSize localPixelSize = g.b.a(this.cqf);
        if (localPixelSize != null)
        {
          Object localObject1 = this.cqf;
          Object localObject2 = this.cqg;
          s.s(localObject2, "viewTreeObserver");
          g.b.a((g)localObject1, (ViewTreeObserver)localObject2, (ViewTreeObserver.OnPreDrawListener)this);
          if (!this.cqi)
          {
            this.cqi = true;
            localObject1 = (d)this.bPv;
            localObject2 = Result.Companion;
            ((d)localObject1).resumeWith(Result.constructor-impl(localPixelSize));
          }
        }
        AppMethodBeat.o(188245);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.size.g
 * JD-Core Version:    0.7.0.1
 */