package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.plugin.appbrand.widget.h.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class a$2
  implements b.i
{
  a$2(a parama, WeakReference paramWeakReference1, WeakReference paramWeakReference2, SpannableString paramSpannableString) {}
  
  public final void acG() {}
  
  public final void acH() {}
  
  public final String tX()
  {
    AppMethodBeat.i(132267);
    String str = a.class.getSimpleName();
    AppMethodBeat.o(132267);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(132266);
    NeatTextView localNeatTextView = (NeatTextView)this.irw.get();
    Object localObject = (Context)this.irx.get();
    if ((localObject != null) && (localNeatTextView != null))
    {
      paramBitmap = new BitmapDrawable(((Context)localObject).getResources(), paramBitmap);
      paramBitmap.setBounds(0, 0, o.aNT(), o.aNT());
      paramBitmap = new b(paramBitmap);
      localObject = new SpannableString("@ ");
      ((SpannableString)localObject).setSpan(paramBitmap, 0, 1, 33);
      localNeatTextView.af(TextUtils.concat(new CharSequence[] { localObject, this.iry }));
      localNeatTextView.invalidate();
    }
    AppMethodBeat.o(132266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a.2
 * JD-Core Version:    0.7.0.1
 */