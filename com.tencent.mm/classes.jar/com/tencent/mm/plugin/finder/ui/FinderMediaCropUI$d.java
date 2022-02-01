package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder_release"})
public final class FinderMediaCropUI$d
{
  public static final a sDE;
  WxMediaCropLayout.b sDC;
  int sDD;
  
  static
  {
    AppMethodBeat.i(167348);
    sDE = new a((byte)0);
    AppMethodBeat.o(167348);
  }
  
  public FinderMediaCropUI$d()
  {
    AppMethodBeat.i(167347);
    this.sDC = new WxMediaCropLayout.b(0L, "");
    this.sDD = -1;
    AppMethodBeat.o(167347);
  }
  
  public final void a(WxMediaCropLayout.b paramb)
  {
    AppMethodBeat.i(167346);
    p.h(paramb, "<set-?>");
    this.sDC = paramb;
    AppMethodBeat.o(167346);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.d
 * JD-Core Version:    0.7.0.1
 */