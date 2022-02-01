package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j$a
  implements i.a
{
  CharSequence dc = null;
  Drawable mDrawable = null;
  int mStatus = -2147483648;
  
  protected j$a(j paramj) {}
  
  public final void Cy(final int paramInt)
  {
    AppMethodBeat.i(135299);
    this.qxC.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135293);
        try
        {
          j.a.this.M(j.a.this.qxC.getContext().getResources().getString(paramInt));
          AppMethodBeat.o(135293);
          return;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          j.a.this.M(null);
          AppMethodBeat.o(135293);
        }
      }
    });
    AppMethodBeat.o(135299);
  }
  
  public final void M(final CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135298);
    this.qxC.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135292);
        j.a.this.dc = paramCharSequence;
        if (j.a.a(j.a.this)) {
          j.a.this.qxC.L(paramCharSequence);
        }
        AppMethodBeat.o(135292);
      }
    });
    AppMethodBeat.o(135298);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(135301);
    this.qxC.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135295);
        j.b(j.a.this.qxC).remove(j.a.this);
        AppMethodBeat.o(135295);
      }
    });
    AppMethodBeat.o(135301);
  }
  
  public final void setLogo(final int paramInt)
  {
    AppMethodBeat.i(135297);
    this.qxC.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135291);
        try
        {
          j.a.this.setLogo(a.m(j.a.this.qxC.getContext(), paramInt));
          AppMethodBeat.o(135291);
          return;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          j.a.this.setLogo(null);
          AppMethodBeat.o(135291);
        }
      }
    });
    AppMethodBeat.o(135297);
  }
  
  public final void setLogo(final Drawable paramDrawable)
  {
    AppMethodBeat.i(135296);
    this.qxC.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135290);
        j.a.this.mDrawable = paramDrawable;
        if (j.a.a(j.a.this)) {
          j.a.this.qxC.D(j.a.this.mDrawable);
        }
        AppMethodBeat.o(135290);
      }
    });
    AppMethodBeat.o(135296);
  }
  
  public final void setStatus(final int paramInt)
  {
    AppMethodBeat.i(135300);
    this.qxC.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135294);
        j.a.this.mStatus = paramInt;
        if (j.a.a(j.a.this)) {
          j.a.this.qxC.Cw(paramInt);
        }
        AppMethodBeat.o(135294);
      }
    });
    AppMethodBeat.o(135300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j.a
 * JD-Core Version:    0.7.0.1
 */