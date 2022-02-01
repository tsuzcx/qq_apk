package com.tencent.mm.plugin.gallery.picker.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-gallery_release"})
public final class MMMediaCropLayout$c
{
  public static final a tVw;
  private int sOC;
  private MMMediaCropLayout.b tVv;
  
  static
  {
    AppMethodBeat.i(164929);
    tVw = new a((byte)0);
    AppMethodBeat.o(164929);
  }
  
  public MMMediaCropLayout$c()
  {
    AppMethodBeat.i(164928);
    this.tVv = new MMMediaCropLayout.b(0L);
    this.sOC = -1;
    AppMethodBeat.o(164928);
  }
  
  public final void a(MMMediaCropLayout.b paramb)
  {
    AppMethodBeat.i(164927);
    p.h(paramb, "<set-?>");
    this.tVv = paramb;
    AppMethodBeat.o(164927);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-gallery_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout.c
 * JD-Core Version:    0.7.0.1
 */