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
  ColorStateList Rq;
  Drawable.ConstantState brn;
  PorterDuff.Mode kA;
  int mChangingConfigurations;
  
  i(i parami)
  {
    AppMethodBeat.i(196160);
    this.Rq = null;
    this.kA = g.bqY;
    if (parami != null)
    {
      this.mChangingConfigurations = parami.mChangingConfigurations;
      this.brn = parami.brn;
      this.Rq = parami.Rq;
      this.kA = parami.kA;
    }
    AppMethodBeat.o(196160);
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(196187);
    int j = this.mChangingConfigurations;
    if (this.brn != null) {}
    for (int i = this.brn.getChangingConfigurations();; i = 0)
    {
      AppMethodBeat.o(196187);
      return i | j;
    }
  }
  
  public final Drawable newDrawable()
  {
    AppMethodBeat.i(196168);
    Drawable localDrawable = newDrawable(null);
    AppMethodBeat.o(196168);
    return localDrawable;
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    AppMethodBeat.i(196177);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = new h(this, paramResources);
      AppMethodBeat.o(196177);
      return paramResources;
    }
    paramResources = new g(this, paramResources);
    AppMethodBeat.o(196177);
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.graphics.drawable.i
 * JD-Core Version:    0.7.0.1
 */