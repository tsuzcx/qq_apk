package com.tencent.mm.plugin.appbrand.page.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class f
  extends a
{
  public final LinkedList<a> mgc = new LinkedList()
  {
    public final boolean remove(Object paramAnonymousObject)
    {
      AppMethodBeat.i(135289);
      boolean bool = super.remove(paramAnonymousObject);
      f.a(f.this);
      AppMethodBeat.o(135289);
      return bool;
    }
  };
  
  public final c.a bvC()
  {
    a locala = new a();
    this.mgc.addFirst(locala);
    return locala;
  }
  
  public final void destroy()
  {
    this.mgc.clear();
  }
  
  protected final class a
    implements c.a
  {
    CharSequence LU = null;
    Drawable mDrawable = null;
    int mStatus = -2147483648;
    
    protected a() {}
    
    public final void dismiss()
    {
      AppMethodBeat.i(135301);
      f.this.M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135295);
          f.b(f.this).remove(f.a.this);
          AppMethodBeat.o(135295);
        }
      });
      AppMethodBeat.o(135301);
    }
    
    public final void setDescription(final CharSequence paramCharSequence)
    {
      AppMethodBeat.i(135298);
      f.this.M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135292);
          f.a.this.LU = paramCharSequence;
          if (f.a.a(f.a.this)) {
            f.this.A(paramCharSequence);
          }
          AppMethodBeat.o(135292);
        }
      });
      AppMethodBeat.o(135298);
    }
    
    public final void setLogo(final int paramInt)
    {
      AppMethodBeat.i(135297);
      f.this.M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135291);
          try
          {
            f.a.this.setLogo(b.l(f.this.getContext(), paramInt));
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
      f.this.M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135290);
          f.a.this.mDrawable = paramDrawable;
          if (f.a.a(f.a.this)) {
            f.this.x(f.a.this.mDrawable);
          }
          AppMethodBeat.o(135290);
        }
      });
      AppMethodBeat.o(135296);
    }
    
    public final void setStatus(final int paramInt)
    {
      AppMethodBeat.i(135300);
      f.this.M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135294);
          f.a.this.mStatus = paramInt;
          if (f.a.a(f.a.this)) {
            f.this.uK(paramInt);
          }
          AppMethodBeat.o(135294);
        }
      });
      AppMethodBeat.o(135300);
    }
    
    public final void uW(final int paramInt)
    {
      AppMethodBeat.i(135299);
      f.this.M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135293);
          try
          {
            f.a.this.setDescription(f.this.getContext().getResources().getString(paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f
 * JD-Core Version:    0.7.0.1
 */