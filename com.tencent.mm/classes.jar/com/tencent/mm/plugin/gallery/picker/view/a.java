package com.tencent.mm.plugin.gallery.picker.view;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropReport;", "", "()V", "AFTER_GIF_DECODED", "", "AFTER_GIF_DECODED_NATIVE_PSS", "AFTER_GIF_DECODED_VM_PSS", "AFTER_LONG_PIC_DECODED", "AFTER_LONG_PIC_DECODED_NATIVE_PSS", "AFTER_LONG_PIC_DECODED_VM_PSS", "AFTER_NORMAL_PIC_DECODED", "AFTER_NORMAL_PIC_DECODED_NATIVE_PSS", "AFTER_NORMAL_PIC_DECODED_VM_PSS", "BAD_QUIT", "BEFORE_NATIVE_PSS", "BEFORE_VM_PSS", "ENTER_PAGE", "ID_KEY_ID", "", "LONG_PIC_MAX_MULTIPLE", "NORMAL_PIC", "NORMAL_QUIT", "SCENE_AVATAR", "SCENE_BACKGROUND", "SCENE_COVER", "SCENE_EMOJI", "START_DECODE", "SUPER_LONG_PIC", "TAG", "", "TOTAL_LONG_PIC", "report", "", "key", "value", "reportInc", "reportPss", "nativePssKey", "plugin-gallery_release"})
final class a
{
  public static final a tJA;
  
  static
  {
    AppMethodBeat.i(198805);
    tJA = new a();
    AppMethodBeat.o(198805);
  }
  
  public static void Hj(int paramInt)
  {
    AppMethodBeat.i(198803);
    ad.i("ImageCropReport", "inc: ".concat(String.valueOf(paramInt)));
    g.yhR.n(1361L, paramInt, 1L);
    AppMethodBeat.o(198803);
  }
  
  public static void Hk(int paramInt)
  {
    AppMethodBeat.i(198804);
    Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aT(aj.getContext());
    if (localMemoryInfo != null)
    {
      gi(paramInt, localMemoryInfo.nativePss);
      gi(paramInt + 1, localMemoryInfo.dalvikPss);
      AppMethodBeat.o(198804);
      return;
    }
    AppMethodBeat.o(198804);
  }
  
  public static void gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198802);
    g.yhR.n(1361L, paramInt1, paramInt2);
    AppMethodBeat.o(198802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.a
 * JD-Core Version:    0.7.0.1
 */