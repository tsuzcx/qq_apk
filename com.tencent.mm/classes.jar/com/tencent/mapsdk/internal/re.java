package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class re
  extends ImageView
{
  public re(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(223313);
    setClickable(true);
    AppMethodBeat.o(223313);
  }
  
  private void a()
  {
    AppMethodBeat.i(223334);
    setClickable(false);
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    setBackgroundDrawable(null);
    AppMethodBeat.o(223334);
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(223325);
    Object localObject = paramBitmap1.getNinePatchChunk();
    paramBitmap1 = new NinePatchDrawable(getResources(), paramBitmap1, (byte[])localObject, new Rect(), null);
    localObject = paramBitmap2.getNinePatchChunk();
    paramBitmap2 = new NinePatchDrawable(getResources(), paramBitmap2, (byte[])localObject, new Rect(), null);
    localObject = new StateListDrawable();
    ((StateListDrawable)localObject).addState(View.PRESSED_ENABLED_STATE_SET, paramBitmap2);
    ((StateListDrawable)localObject).addState(View.ENABLED_STATE_SET, paramBitmap1);
    setBackgroundDrawable((Drawable)localObject);
    AppMethodBeat.o(223325);
  }
  
  public final void a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(223342);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    paramBitmap1 = new BitmapDrawable(paramContext.getResources(), paramBitmap1);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramBitmap2);
    localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, paramContext);
    localStateListDrawable.addState(View.ENABLED_STATE_SET, paramBitmap1);
    setBackgroundDrawable(localStateListDrawable);
    AppMethodBeat.o(223342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mapsdk.internal.re
 * JD-Core Version:    0.7.0.1
 */