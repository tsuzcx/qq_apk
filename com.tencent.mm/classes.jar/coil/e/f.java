package coil.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.b.b;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Size;
import coil.size.e;
import coil.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/decode/DrawableDecoderService;", "", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "(Lcoil/bitmap/BitmapPool;)V", "convert", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Landroid/graphics/Bitmap$Config;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "isConfigValid", "bitmap", "isSizeValid", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a cnk;
  private final b clr;
  
  static
  {
    AppMethodBeat.i(187833);
    cnk = new f.a((byte)0);
    AppMethodBeat.o(187833);
  }
  
  public f(b paramb)
  {
    AppMethodBeat.i(187825);
    this.clr = paramb;
    AppMethodBeat.o(187825);
  }
  
  public final Bitmap a(Drawable paramDrawable, Bitmap.Config paramConfig, Size paramSize, e parame, boolean paramBoolean)
  {
    int j = 512;
    int k = 1;
    AppMethodBeat.i(187851);
    s.u(paramDrawable, "drawable");
    s.u(paramConfig, "config");
    s.u(paramSize, "size");
    s.u(parame, "scale");
    if ((paramDrawable instanceof BitmapDrawable))
    {
      Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      s.s(localBitmap, "bitmap");
      if (localBitmap.getConfig() == a.c(paramConfig))
      {
        i = 1;
        if (i == 0) {
          break label153;
        }
        i = k;
        if (!paramBoolean)
        {
          i = k;
          if (!(paramSize instanceof OriginalSize)) {
            if (!s.p(paramSize, d.a(localBitmap.getWidth(), localBitmap.getHeight(), paramSize, parame))) {
              break label147;
            }
          }
        }
      }
      label147:
      for (i = k;; i = 0)
      {
        if (i == 0) {
          break label153;
        }
        AppMethodBeat.o(187851);
        return localBitmap;
        i = 0;
        break;
      }
    }
    label153:
    paramDrawable = paramDrawable.mutate();
    s.s(paramDrawable, "drawable.mutate()");
    int i = coil.util.d.D(paramDrawable);
    if (i > 0) {}
    for (;;)
    {
      k = coil.util.d.E(paramDrawable);
      if (k > 0) {
        j = k;
      }
      paramSize = d.a(i, j, paramSize, parame);
      i = paramSize.width;
      j = paramSize.height;
      paramConfig = this.clr.b(i, j, a.c(paramConfig));
      paramSize = paramDrawable.getBounds();
      s.s(paramSize, "bounds");
      k = paramSize.left;
      int m = paramSize.top;
      int n = paramSize.right;
      int i1 = paramSize.bottom;
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(new Canvas(paramConfig));
      paramDrawable.setBounds(k, m, n, i1);
      AppMethodBeat.o(187851);
      return paramConfig;
      i = 512;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.e.f
 * JD-Core Version:    0.7.0.1
 */