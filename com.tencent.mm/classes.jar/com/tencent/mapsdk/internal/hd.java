package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;

public abstract class hd
  implements Animation
{
  public hu a = null;
  protected a b;
  
  public AnimationListener getAnimationListener()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return null;
  }
  
  public long getDuration()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return 0L;
  }
  
  public Interpolator getInterpolator()
  {
    if (this.a != null) {
      return this.a.f;
    }
    return null;
  }
  
  public void setAnimationListener(AnimationListener paramAnimationListener)
  {
    this.b = new a(paramAnimationListener);
    if (this.a != null) {
      this.a.a(this.b);
    }
  }
  
  static final class a
    implements hu.a
  {
    AnimationListener a;
    
    public a(AnimationListener paramAnimationListener)
    {
      this.a = paramAnimationListener;
    }
    
    public final void a()
    {
      AppMethodBeat.i(226078);
      if (this.a != null) {
        jw.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(223744);
            hd.a.this.a.onAnimationStart();
            AppMethodBeat.o(223744);
          }
        });
      }
      AppMethodBeat.o(226078);
    }
    
    public final void b()
    {
      AppMethodBeat.i(226081);
      if (this.a != null) {
        jw.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(223795);
            hd.a.this.a.onAnimationEnd();
            AppMethodBeat.o(223795);
          }
        });
      }
      AppMethodBeat.o(226081);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hd
 * JD-Core Version:    0.7.0.1
 */