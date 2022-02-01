package com.tencent.mm.plugin.appbrand.page.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f$a
  implements c.a
{
  CharSequence Jj = null;
  Drawable mDrawable = null;
  int mStatus = -2147483648;
  
  protected f$a(f paramf) {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(135301);
    this.lgG.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135295);
        f.b(f.a.this.lgG).remove(f.a.this);
        AppMethodBeat.o(135295);
      }
    });
    AppMethodBeat.o(135301);
  }
  
  public final void setDescription(final CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135298);
    this.lgG.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135292);
        f.a.this.Jj = paramCharSequence;
        if (f.a.a(f.a.this)) {
          f.a.this.lgG.A(paramCharSequence);
        }
        AppMethodBeat.o(135292);
      }
    });
    AppMethodBeat.o(135298);
  }
  
  public final void setLogo(final int paramInt)
  {
    AppMethodBeat.i(135297);
    this.lgG.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135291);
        try
        {
          f.a.this.setLogo(b.l(f.a.this.lgG.getContext(), paramInt));
          AppMethodBeat.o(135291);
          return;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          f.a.this.setLogo(null);
          AppMethodBeat.o(135291);
        }
      }
    });
    AppMethodBeat.o(135297);
  }
  
  public final void setLogo(final Drawable paramDrawable)
  {
    AppMethodBeat.i(135296);
    this.lgG.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135290);
        f.a.this.mDrawable = paramDrawable;
        if (f.a.a(f.a.this)) {
          f.a.this.lgG.x(f.a.this.mDrawable);
        }
        AppMethodBeat.o(135290);
      }
    });
    AppMethodBeat.o(135296);
  }
  
  public final void setStatus(final int paramInt)
  {
    AppMethodBeat.i(135300);
    this.lgG.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135294);
        f.a.this.mStatus = paramInt;
        if (f.a.a(f.a.this)) {
          f.a.this.lgG.tp(paramInt);
        }
        AppMethodBeat.o(135294);
      }
    });
    AppMethodBeat.o(135300);
  }
  
  public final void tC(final int paramInt)
  {
    AppMethodBeat.i(135299);
    this.lgG.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135293);
        try
        {
          f.a.this.setDescription(f.a.this.lgG.getContext().getResources().getString(paramInt));
          AppMethodBeat.o(135293);
          return;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          f.a.this.setDescription(null);
          AppMethodBeat.o(135293);
        }
      }
    });
    AppMethodBeat.o(135299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f.a
 * JD-Core Version:    0.7.0.1
 */