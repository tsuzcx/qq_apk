package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder_release"})
public final class FinderMediaCropUI$d
{
  public static final a rIH;
  WxMediaCropLayout.b rIF;
  int rIG;
  
  static
  {
    AppMethodBeat.i(167348);
    rIH = new a((byte)0);
    AppMethodBeat.o(167348);
  }
  
  public FinderMediaCropUI$d()
  {
    AppMethodBeat.i(167347);
    this.rIF = new WxMediaCropLayout.b(0L, "");
    this.rIG = -1;
    AppMethodBeat.o(167347);
  }
  
  public final void a(WxMediaCropLayout.b paramb)
  {
    AppMethodBeat.i(167346);
    k.h(paramb, "<set-?>");
    this.rIF = paramb;
    AppMethodBeat.o(167346);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.d
 * JD-Core Version:    0.7.0.1
 */