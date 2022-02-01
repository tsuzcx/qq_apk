package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder_release"})
public final class FinderMediaCropUI$d
{
  public static final a sOD;
  WxMediaCropLayout.b sOB;
  int sOC;
  
  static
  {
    AppMethodBeat.i(167348);
    sOD = new a((byte)0);
    AppMethodBeat.o(167348);
  }
  
  public FinderMediaCropUI$d()
  {
    AppMethodBeat.i(167347);
    this.sOB = new WxMediaCropLayout.b(0L, "");
    this.sOC = -1;
    AppMethodBeat.o(167347);
  }
  
  public final void a(WxMediaCropLayout.b paramb)
  {
    AppMethodBeat.i(167346);
    p.h(paramb, "<set-?>");
    this.sOB = paramb;
    AppMethodBeat.o(167346);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.d
 * JD-Core Version:    0.7.0.1
 */