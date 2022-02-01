package com.tencent.mm.live.model.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil;", "", "()V", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a.a nbX;
  
  static
  {
    AppMethodBeat.i(246747);
    nbX = new a.a((byte)0);
    TAG = "MicroMsg.LiveBitmapUtil";
    AppMethodBeat.o(246747);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a$a
    extends u
    implements b<Bitmap, ah>
  {
    a$a(int paramInt, b<? super Bitmap, ah> paramb)
    {
      super();
    }
    
    private static final void b(b paramb, Bitmap paramBitmap)
    {
      AppMethodBeat.i(246757);
      if (paramb != null) {
        paramb.invoke(paramBitmap);
      }
      AppMethodBeat.o(246757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.d.a
 * JD-Core Version:    0.7.0.1
 */