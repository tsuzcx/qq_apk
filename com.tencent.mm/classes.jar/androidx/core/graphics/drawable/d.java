package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.core.g.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static b a(Resources paramResources, Bitmap paramBitmap)
  {
    AppMethodBeat.i(196157);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = new c(paramResources, paramBitmap);
      AppMethodBeat.o(196157);
      return paramResources;
    }
    paramResources = new a(paramResources, paramBitmap);
    AppMethodBeat.o(196157);
    return paramResources;
  }
  
  static final class a
    extends b
  {
    a(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    final void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
    {
      AppMethodBeat.i(196212);
      e.a(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
      AppMethodBeat.o(196212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.drawable.d
 * JD-Core Version:    0.7.0.1
 */