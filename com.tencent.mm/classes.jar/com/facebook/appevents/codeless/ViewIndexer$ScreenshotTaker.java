package com.facebook.appevents.codeless;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

class ViewIndexer$ScreenshotTaker
  implements Callable<String>
{
  private WeakReference<View> rootView;
  
  public ViewIndexer$ScreenshotTaker(View paramView)
  {
    AppMethodBeat.i(72079);
    this.rootView = new WeakReference(paramView);
    AppMethodBeat.o(72079);
  }
  
  public String call()
  {
    AppMethodBeat.i(72080);
    Object localObject2 = (View)this.rootView.get();
    if ((localObject2 == null) || (((View)localObject2).getWidth() == 0) || (((View)localObject2).getHeight() == 0))
    {
      AppMethodBeat.o(72080);
      return "";
    }
    Object localObject1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.RGB_565);
    ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
    localObject2 = new ByteArrayOutputStream();
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 10, (OutputStream)localObject2);
    localObject1 = Base64.encodeToString(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
    AppMethodBeat.o(72080);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.codeless.ViewIndexer.ScreenshotTaker
 * JD-Core Version:    0.7.0.1
 */