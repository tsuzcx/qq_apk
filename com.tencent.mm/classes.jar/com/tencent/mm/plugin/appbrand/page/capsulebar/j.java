package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class j
  extends f
{
  private final LinkedList<a> nvA = new LinkedList()
  {
    public final boolean remove(Object paramAnonymousObject)
    {
      AppMethodBeat.i(135289);
      boolean bool = super.remove(paramAnonymousObject);
      j.a(j.this);
      AppMethodBeat.o(135289);
      return bool;
    }
  };
  
  public final i.a bSB()
  {
    a locala = new a();
    this.nvA.addFirst(locala);
    return locala;
  }
  
  protected final class a
    implements i.a
  {
    CharSequence Me = null;
    Drawable mDrawable = null;
    int mStatus = -2147483648;
    
    protected a() {}
    
    public final void dismiss()
    {
      AppMethodBeat.i(135301);
      j.this.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135295);
          j.b(j.this).remove(j.a.this);
          AppMethodBeat.o(135295);
        }
      });
      AppMethodBeat.o(135301);
    }
    
    public final void setDescription(final CharSequence paramCharSequence)
    {
      AppMethodBeat.i(135298);
      j.this.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135292);
          j.a.this.Me = paramCharSequence;
          if (j.a.a(j.a.this)) {
            j.this.E(paramCharSequence);
          }
          AppMethodBeat.o(135292);
        }
      });
      AppMethodBeat.o(135298);
    }
    
    public final void setLogo(final int paramInt)
    {
      AppMethodBeat.i(135297);
      j.this.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135291);
          try
          {
            j.a.this.setLogo(b.l(j.this.getContext(), paramInt));
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
      j.this.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135290);
          j.a.this.mDrawable = paramDrawable;
          if (j.a.a(j.a.this)) {
            j.this.y(j.a.this.mDrawable);
          }
          AppMethodBeat.o(135290);
        }
      });
      AppMethodBeat.o(135296);
    }
    
    public final void setStatus(final int paramInt)
    {
      AppMethodBeat.i(135300);
      j.this.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135294);
          j.a.this.mStatus = paramInt;
          if (j.a.a(j.a.this)) {
            j.this.yS(paramInt);
          }
          AppMethodBeat.o(135294);
        }
      });
      AppMethodBeat.o(135300);
    }
    
    public final void yT(final int paramInt)
    {
      AppMethodBeat.i(135299);
      j.this.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135293);
          try
          {
            j.a.this.setDescription(j.this.getContext().getResources().getString(paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j
 * JD-Core Version:    0.7.0.1
 */