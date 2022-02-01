package com.tencent.mm.plugin.gallery.picker.view;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropReport;", "", "()V", "AFTER_GIF_DECODED", "", "AFTER_GIF_DECODED_NATIVE_PSS", "AFTER_GIF_DECODED_VM_PSS", "AFTER_LONG_PIC_DECODED", "AFTER_LONG_PIC_DECODED_NATIVE_PSS", "AFTER_LONG_PIC_DECODED_VM_PSS", "AFTER_NORMAL_PIC_DECODED", "AFTER_NORMAL_PIC_DECODED_NATIVE_PSS", "AFTER_NORMAL_PIC_DECODED_VM_PSS", "BAD_QUIT", "BEFORE_NATIVE_PSS", "BEFORE_VM_PSS", "ENTER_PAGE", "ID_KEY_ID", "", "LONG_PIC_MAX_MULTIPLE", "NORMAL_PIC", "NORMAL_QUIT", "SCENE_AVATAR", "SCENE_BACKGROUND", "SCENE_COVER", "SCENE_EMOJI", "START_DECODE", "SUPER_LONG_PIC", "TAG", "", "TOTAL_LONG_PIC", "report", "", "key", "value", "reportInc", "reportPss", "nativePssKey", "plugin-gallery_release"})
final class a
{
  public static final a BXX;
  
  static
  {
    AppMethodBeat.i(241041);
    BXX = new a();
    AppMethodBeat.o(241041);
  }
  
  public static void SV(int paramInt)
  {
    AppMethodBeat.i(241036);
    Log.i("ImageCropReport", "inc: ".concat(String.valueOf(paramInt)));
    h.IzE.p(1361L, paramInt, 1L);
    AppMethodBeat.o(241036);
  }
  
  public static void SW(int paramInt)
  {
    AppMethodBeat.i(241038);
    Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.e.a.bz(MMApplicationContext.getContext());
    if (localMemoryInfo != null)
    {
      gU(paramInt, localMemoryInfo.nativePss);
      gU(paramInt + 1, localMemoryInfo.dalvikPss);
      AppMethodBeat.o(241038);
      return;
    }
    AppMethodBeat.o(241038);
  }
  
  public static void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241034);
    h.IzE.p(1361L, paramInt1, paramInt2);
    AppMethodBeat.o(241034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.a
 * JD-Core Version:    0.7.0.1
 */