package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j$a
  implements i.a
{
  CharSequence LU = null;
  Drawable mDrawable = null;
  int mStatus = -2147483648;
  
  protected j$a(j paramj) {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(135301);
    this.mld.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135295);
        j.b(j.a.this.mld).remove(j.a.this);
        AppMethodBeat.o(135295);
      }
    });
    AppMethodBeat.o(135301);
  }
  
  public final void setDescription(final CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135298);
    this.mld.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135292);
        j.a.this.LU = paramCharSequence;
        if (j.a.a(j.a.this)) {
          j.a.this.mld.A(paramCharSequence);
        }
        AppMethodBeat.o(135292);
      }
    });
    AppMethodBeat.o(135298);
  }
  
  public final void setLogo(final int paramInt)
  {
    AppMethodBeat.i(135297);
    this.mld.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135291);
        try
        {
          j.a.this.setLogo(b.l(j.a.this.mld.getContext(), paramInt));
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
    this.mld.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135290);
        j.a.this.mDrawable = paramDrawable;
        if (j.a.a(j.a.this)) {
          j.a.this.mld.y(j.a.this.mDrawable);
        }
        AppMethodBeat.o(135290);
      }
    });
    AppMethodBeat.o(135296);
  }
  
  public final void setStatus(final int paramInt)
  {
    AppMethodBeat.i(135300);
    this.mld.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135294);
        j.a.this.mStatus = paramInt;
        if (j.a.a(j.a.this)) {
          j.a.this.mld.va(paramInt);
        }
        AppMethodBeat.o(135294);
      }
    });
    AppMethodBeat.o(135300);
  }
  
  public final void vb(final int paramInt)
  {
    AppMethodBeat.i(135299);
    this.mld.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135293);
        try
        {
          j.a.this.setDescription(j.a.this.mld.getContext().getResources().getString(paramInt));
          AppMethodBeat.o(135293);
          return;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          j.a.this.setDescription(null);
          AppMethodBeat.o(135293);
        }
      }
    });
    AppMethodBeat.o(135299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j.a
 * JD-Core Version:    0.7.0.1
 */