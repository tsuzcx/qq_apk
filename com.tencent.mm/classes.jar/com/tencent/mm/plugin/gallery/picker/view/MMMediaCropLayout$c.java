package com.tencent.mm.plugin.gallery.picker.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMMediaCropLayout$c
{
  public static final a HLb;
  private int FRU;
  private MMMediaCropLayout.b HLc;
  
  static
  {
    AppMethodBeat.i(164929);
    HLb = new a((byte)0);
    AppMethodBeat.o(164929);
  }
  
  public MMMediaCropLayout$c()
  {
    AppMethodBeat.i(164928);
    this.HLc = new MMMediaCropLayout.b(0L);
    this.FRU = -1;
    AppMethodBeat.o(164928);
  }
  
  public final void a(MMMediaCropLayout.b paramb)
  {
    AppMethodBeat.i(164927);
    s.u(paramb, "<set-?>");
    this.HLc = paramb;
    AppMethodBeat.o(164927);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout.c
 * JD-Core Version:    0.7.0.1
 */