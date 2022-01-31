package com.tencent.mm.plugin.appbrand.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.u.p;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import java.lang.ref.WeakReference;

final class a$2
  implements b.h
{
  a$2(a parama, WeakReference paramWeakReference1, WeakReference paramWeakReference2, SpannableString paramSpannableString) {}
  
  public final void JG() {}
  
  public final void JH() {}
  
  public final void p(Bitmap paramBitmap)
  {
    TextView localTextView = (TextView)this.gPJ.get();
    Object localObject = (Context)this.gPK.get();
    if ((localObject != null) && (localTextView != null))
    {
      paramBitmap = new BitmapDrawable(((Context)localObject).getResources(), paramBitmap);
      paramBitmap.setBounds(0, 0, p.aqq(), p.aqq());
      paramBitmap = new b(paramBitmap);
      localObject = new SpannableString("@ ");
      ((SpannableString)localObject).setSpan(paramBitmap, 0, 1, 33);
      localTextView.setText(TextUtils.concat(new CharSequence[] { localObject, this.gPL }));
      localTextView.invalidate();
    }
  }
  
  public final String pU()
  {
    return a.class.getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.a.2
 * JD-Core Version:    0.7.0.1
 */