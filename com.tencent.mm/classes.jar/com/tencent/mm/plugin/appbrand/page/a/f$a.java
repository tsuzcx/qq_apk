package com.tencent.mm.plugin.appbrand.page.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;

public final class f$a
  implements c.a
{
  CharSequence Cx = null;
  Drawable mDrawable = null;
  
  protected f$a(f paramf) {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(87362);
    m.runOnUiThread(new f.a.5(this));
    AppMethodBeat.o(87362);
  }
  
  public final void pp(int paramInt)
  {
    AppMethodBeat.i(87361);
    m.runOnUiThread(new f.a.4(this, paramInt));
    AppMethodBeat.o(87361);
  }
  
  public final void setDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(87360);
    m.runOnUiThread(new f.a.3(this, paramCharSequence));
    AppMethodBeat.o(87360);
  }
  
  public final void setLogo(int paramInt)
  {
    AppMethodBeat.i(87359);
    m.runOnUiThread(new f.a.2(this, paramInt));
    AppMethodBeat.o(87359);
  }
  
  public final void setLogo(final Drawable paramDrawable)
  {
    AppMethodBeat.i(87358);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(87353);
        f.a.this.mDrawable = paramDrawable;
        if (f.a.a(f.a.this)) {
          f.a.this.iAr.p(f.a.this.mDrawable);
        }
        AppMethodBeat.o(87353);
      }
    });
    AppMethodBeat.o(87358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f.a
 * JD-Core Version:    0.7.0.1
 */