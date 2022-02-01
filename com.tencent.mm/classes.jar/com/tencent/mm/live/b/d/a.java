package com.tencent.mm.live.b.d;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class a
{
  private static final String TAG = "MicroMsg.LiveBitmapUtil";
  public static final a gxt;
  
  static
  {
    AppMethodBeat.i(189994);
    gxt = new a((byte)0);
    TAG = "MicroMsg.LiveBitmapUtil";
    AppMethodBeat.o(189994);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil$Companion;", "", "()V", "TAG", "", "addMaskLayer", "Landroid/graphics/Bitmap;", "src", "maskColor", "", "genBlurBitmapByUsername", "", "username", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "plugin-logic_release"})
  public static final class a
  {
    public static void a(String paramString, int paramInt, b<? super Bitmap, y> paramb)
    {
      AppMethodBeat.i(189993);
      h.JZN.aS((Runnable)new a.a.a(paramString, paramb, paramInt));
      AppMethodBeat.o(189993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.d.a
 * JD-Core Version:    0.7.0.1
 */