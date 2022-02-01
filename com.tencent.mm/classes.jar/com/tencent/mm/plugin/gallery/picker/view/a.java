package com.tencent.mm.plugin.gallery.picker.view;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropReport;", "", "()V", "AFTER_GIF_DECODED", "", "AFTER_GIF_DECODED_NATIVE_PSS", "AFTER_GIF_DECODED_VM_PSS", "AFTER_LONG_PIC_DECODED", "AFTER_LONG_PIC_DECODED_NATIVE_PSS", "AFTER_LONG_PIC_DECODED_VM_PSS", "AFTER_NORMAL_PIC_DECODED", "AFTER_NORMAL_PIC_DECODED_NATIVE_PSS", "AFTER_NORMAL_PIC_DECODED_VM_PSS", "BAD_QUIT", "BEFORE_NATIVE_PSS", "BEFORE_VM_PSS", "ENTER_PAGE", "ID_KEY_ID", "", "LONG_PIC_MAX_MULTIPLE", "NORMAL_PIC", "NORMAL_QUIT", "SCENE_AVATAR", "SCENE_BACKGROUND", "SCENE_COVER", "SCENE_EMOJI", "START_DECODE", "SUPER_LONG_PIC", "TAG", "", "TOTAL_LONG_PIC", "report", "", "key", "value", "reportInc", "reportPss", "nativePssKey", "plugin-gallery_release"})
final class a
{
  public static final a xlD;
  
  static
  {
    AppMethodBeat.i(257781);
    xlD = new a();
    AppMethodBeat.o(257781);
  }
  
  public static void NH(int paramInt)
  {
    AppMethodBeat.i(257779);
    Log.i("ImageCropReport", "inc: ".concat(String.valueOf(paramInt)));
    h.CyF.n(1361L, paramInt, 1L);
    AppMethodBeat.o(257779);
  }
  
  public static void NI(int paramInt)
  {
    AppMethodBeat.i(257780);
    Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.bo(MMApplicationContext.getContext());
    if (localMemoryInfo != null)
    {
      gH(paramInt, localMemoryInfo.nativePss);
      gH(paramInt + 1, localMemoryInfo.dalvikPss);
      AppMethodBeat.o(257780);
      return;
    }
    AppMethodBeat.o(257780);
  }
  
  public static void gH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257778);
    h.CyF.n(1361L, paramInt1, paramInt2);
    AppMethodBeat.o(257778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.a
 * JD-Core Version:    0.7.0.1
 */