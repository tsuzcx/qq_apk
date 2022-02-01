package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o$a
  implements m.a
{
  CharSequence dc = null;
  Drawable kD = null;
  int mStatus = -2147483648;
  boolean tCG;
  String tag = "";
  
  public o$a(o paramo, boolean paramBoolean)
  {
    this.tCG = paramBoolean;
  }
  
  public final void CP(final int paramInt)
  {
    AppMethodBeat.i(135299);
    this.tCF.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135293);
        try
        {
          o.a.this.Q(o.a.this.tCF.getContext().getResources().getString(paramInt));
          AppMethodBeat.o(135293);
          return;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          o.a.this.Q(null);
          AppMethodBeat.o(135293);
        }
      }
    });
    AppMethodBeat.o(135299);
  }
  
  public final void Q(final CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135298);
    this.tCF.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135292);
        o.a.this.dc = paramCharSequence;
        if (o.a.a(o.a.this)) {
          o.a.this.tCF.P(paramCharSequence);
        }
        AppMethodBeat.o(135292);
      }
    });
    AppMethodBeat.o(135298);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(135301);
    this.tCF.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135295);
        o.b(o.a.this.tCF).remove(o.a.this);
        AppMethodBeat.o(135295);
      }
    });
    AppMethodBeat.o(135301);
  }
  
  public final void setLogo(final int paramInt)
  {
    AppMethodBeat.i(135297);
    this.tCF.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135291);
        try
        {
          o.a.this.setLogo(a.m(o.a.this.tCF.getContext(), paramInt));
          AppMethodBeat.o(135291);
          return;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          o.a.this.setLogo(null);
          AppMethodBeat.o(135291);
        }
      }
    });
    AppMethodBeat.o(135297);
  }
  
  public final void setLogo(final Drawable paramDrawable)
  {
    AppMethodBeat.i(135296);
    this.tCF.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135290);
        o.a.this.kD = paramDrawable;
        if (o.a.a(o.a.this)) {
          o.a.this.tCF.M(o.a.this.kD);
        }
        AppMethodBeat.o(135290);
      }
    });
    AppMethodBeat.o(135296);
  }
  
  public final void setStatus(final int paramInt)
  {
    AppMethodBeat.i(135300);
    this.tCF.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135294);
        o.a.this.mStatus = paramInt;
        if (o.a.a(o.a.this)) {
          o.a.this.tCF.CM(paramInt);
        }
        AppMethodBeat.o(135294);
      }
    });
    AppMethodBeat.o(135300);
  }
  
  public final void setTag(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.o.a
 * JD-Core Version:    0.7.0.1
 */