package com.tencent.mm.plugin.gallery.picker.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-gallery_release"})
public final class MMMediaCropLayout$c
{
  public static final a sNX;
  private int rIG;
  private MMMediaCropLayout.b sNW;
  
  static
  {
    AppMethodBeat.i(164929);
    sNX = new a((byte)0);
    AppMethodBeat.o(164929);
  }
  
  public MMMediaCropLayout$c()
  {
    AppMethodBeat.i(164928);
    this.sNW = new MMMediaCropLayout.b(0L);
    this.rIG = -1;
    AppMethodBeat.o(164928);
  }
  
  public final void a(MMMediaCropLayout.b paramb)
  {
    AppMethodBeat.i(164927);
    k.h(paramb, "<set-?>");
    this.sNW = paramb;
    AppMethodBeat.o(164927);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-gallery_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout.c
 * JD-Core Version:    0.7.0.1
 */