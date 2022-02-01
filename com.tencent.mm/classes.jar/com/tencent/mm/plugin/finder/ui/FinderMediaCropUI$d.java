package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMediaCropUI$d
{
  public static final a FRS;
  WxMediaCropLayout.b FRT;
  int FRU;
  
  static
  {
    AppMethodBeat.i(167348);
    FRS = new a((byte)0);
    AppMethodBeat.o(167348);
  }
  
  public FinderMediaCropUI$d()
  {
    AppMethodBeat.i(167347);
    this.FRT = new WxMediaCropLayout.b(0L, "");
    this.FRU = -1;
    AppMethodBeat.o(167347);
  }
  
  public final void a(WxMediaCropLayout.b paramb)
  {
    AppMethodBeat.i(167346);
    s.u(paramb, "<set-?>");
    this.FRT = paramb;
    AppMethodBeat.o(167346);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.d
 * JD-Core Version:    0.7.0.1
 */