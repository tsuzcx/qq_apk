package com.tencent.mm.plugin.gallery.picker.view;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropReport;", "", "()V", "AFTER_GIF_DECODED", "", "AFTER_GIF_DECODED_NATIVE_PSS", "AFTER_GIF_DECODED_VM_PSS", "AFTER_LONG_PIC_DECODED", "AFTER_LONG_PIC_DECODED_NATIVE_PSS", "AFTER_LONG_PIC_DECODED_VM_PSS", "AFTER_NORMAL_PIC_DECODED", "AFTER_NORMAL_PIC_DECODED_NATIVE_PSS", "AFTER_NORMAL_PIC_DECODED_VM_PSS", "BAD_QUIT", "BEFORE_NATIVE_PSS", "BEFORE_VM_PSS", "ENTER_PAGE", "ID_KEY_ID", "", "LONG_PIC_MAX_MULTIPLE", "NORMAL_PIC", "NORMAL_QUIT", "SCENE_AVATAR", "SCENE_BACKGROUND", "SCENE_COVER", "SCENE_EMOJI", "START_DECODE", "SUPER_LONG_PIC", "TAG", "", "TOTAL_LONG_PIC", "report", "", "key", "value", "reportInc", "reportPss", "nativePssKey", "plugin-gallery_release"})
final class a
{
  public static final a rEa;
  
  static
  {
    AppMethodBeat.i(186743);
    rEa = new a();
    AppMethodBeat.o(186743);
  }
  
  public static void DY(int paramInt)
  {
    AppMethodBeat.i(186741);
    ad.i("ImageCropReport", "inc: ".concat(String.valueOf(paramInt)));
    h.vKh.m(1361L, paramInt, 1L);
    AppMethodBeat.o(186741);
  }
  
  public static void DZ(int paramInt)
  {
    AppMethodBeat.i(186742);
    Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aS(aj.getContext());
    if (localMemoryInfo != null)
    {
      fL(paramInt, localMemoryInfo.nativePss);
      fL(paramInt + 1, localMemoryInfo.dalvikPss);
      AppMethodBeat.o(186742);
      return;
    }
    AppMethodBeat.o(186742);
  }
  
  public static void fL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186740);
    h.vKh.m(1361L, paramInt1, paramInt2);
    AppMethodBeat.o(186740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.a
 * JD-Core Version:    0.7.0.1
 */