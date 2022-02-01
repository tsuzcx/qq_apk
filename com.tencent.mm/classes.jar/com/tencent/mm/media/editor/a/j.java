package com.tencent.mm.media.editor.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmx;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/LyricsEditorInfo;", "", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "bitmap", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getItemInfo", "()Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "plugin-mediaeditor_release"})
public final class j
{
  final Bitmap bitmap;
  final bmx goR;
  
  public j(bmx parambmx, Bitmap paramBitmap)
  {
    AppMethodBeat.i(93578);
    this.goR = parambmx;
    this.bitmap = paramBitmap;
    AppMethodBeat.o(93578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.j
 * JD-Core Version:    0.7.0.1
 */