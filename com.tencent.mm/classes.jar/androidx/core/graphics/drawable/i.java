package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
  extends Drawable.ConstantState
{
  Drawable.ConstantState Le;
  PorterDuff.Mode jF;
  int mChangingConfigurations;
  ColorStateList zb;
  
  i(i parami)
  {
    AppMethodBeat.i(251027);
    this.zb = null;
    this.jF = g.KQ;
    if (parami != null)
    {
      this.mChangingConfigurations = parami.mChangingConfigurations;
      this.Le = parami.Le;
      this.zb = parami.zb;
      this.jF = parami.jF;
    }
    AppMethodBeat.o(251027);
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(251033);
    int j = this.mChangingConfigurations;
    if (this.Le != null) {}
    for (int i = this.Le.getChangingConfigurations();; i = 0)
    {
      AppMethodBeat.o(251033);
      return i | j;
    }
  }
  
  public final Drawable newDrawable()
  {
    AppMethodBeat.i(251028);
    Drawable localDrawable = newDrawable(null);
    AppMethodBeat.o(251028);
    return localDrawable;
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    AppMethodBeat.i(251031);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = new h(this, paramResources);
      AppMethodBeat.o(251031);
      return paramResources;
    }
    paramResources = new g(this, paramResources);
    AppMethodBeat.o(251031);
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.drawable.i
 * JD-Core Version:    0.7.0.1
 */