package coil.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.e;
import androidx.lifecycle.q;
import coil.l.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/target/ImageViewTarget;", "Lcoil/target/PoolableViewTarget;", "Landroid/widget/ImageView;", "Lcoil/transition/TransitionTarget;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "view", "(Landroid/widget/ImageView;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "isStarted", "", "getView", "()Landroid/widget/ImageView;", "equals", "other", "", "hashCode", "", "onClear", "", "onError", "error", "onStart", "placeholder", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onSuccess", "result", "setDrawable", "toString", "", "updateAnimation", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ImageViewTarget
  implements e, d, a<ImageView>
{
  private final ImageView cqj;
  private boolean isStarted;
  
  private void Ni()
  {
    AppMethodBeat.i(187960);
    Object localObject = this.cqj.getDrawable();
    if ((localObject instanceof Animatable)) {}
    for (localObject = (Animatable)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(187960);
      return;
    }
    if (this.isStarted)
    {
      ((Animatable)localObject).start();
      AppMethodBeat.o(187960);
      return;
    }
    ((Animatable)localObject).stop();
    AppMethodBeat.o(187960);
  }
  
  private void w(Drawable paramDrawable)
  {
    AppMethodBeat.i(187953);
    Object localObject = this.cqj.getDrawable();
    if ((localObject instanceof Animatable)) {}
    for (localObject = (Animatable)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Animatable)localObject).stop();
      }
      this.cqj.setImageDrawable(paramDrawable);
      Ni();
      AppMethodBeat.o(187953);
      return;
    }
  }
  
  public final void A(Drawable paramDrawable)
  {
    AppMethodBeat.i(187978);
    w(paramDrawable);
    AppMethodBeat.o(187978);
  }
  
  public final void B(Drawable paramDrawable)
  {
    AppMethodBeat.i(187990);
    s.u(paramDrawable, "result");
    w(paramDrawable);
    AppMethodBeat.o(187990);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188028);
    if ((this == paramObject) || (((paramObject instanceof ImageViewTarget)) && (s.p(this.cqj, ((ImageViewTarget)paramObject).cqj))))
    {
      AppMethodBeat.o(188028);
      return true;
    }
    AppMethodBeat.o(188028);
    return false;
  }
  
  public final Drawable getDrawable()
  {
    AppMethodBeat.i(187966);
    Drawable localDrawable = this.cqj.getDrawable();
    AppMethodBeat.o(187966);
    return localDrawable;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(188035);
    int i = this.cqj.hashCode();
    AppMethodBeat.o(188035);
    return i;
  }
  
  public final void nP()
  {
    AppMethodBeat.i(187995);
    w(null);
    AppMethodBeat.o(187995);
  }
  
  public final void onStart(q paramq)
  {
    AppMethodBeat.i(188003);
    s.u(paramq, "owner");
    this.isStarted = true;
    Ni();
    AppMethodBeat.o(188003);
  }
  
  public final void onStop(q paramq)
  {
    AppMethodBeat.i(188014);
    s.u(paramq, "owner");
    this.isStarted = false;
    Ni();
    AppMethodBeat.o(188014);
  }
  
  public String toString()
  {
    AppMethodBeat.i(188042);
    String str = "ImageViewTarget(view=" + this.cqj + ')';
    AppMethodBeat.o(188042);
    return str;
  }
  
  public final void z(Drawable paramDrawable)
  {
    AppMethodBeat.i(187972);
    w(paramDrawable);
    AppMethodBeat.o(187972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.target.ImageViewTarget
 * JD-Core Version:    0.7.0.1
 */