package com.tencent.mm.plugin.gallery.picker.view;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropReport;", "", "()V", "AFTER_GIF_DECODED", "", "AFTER_GIF_DECODED_NATIVE_PSS", "AFTER_GIF_DECODED_VM_PSS", "AFTER_LONG_PIC_DECODED", "AFTER_LONG_PIC_DECODED_NATIVE_PSS", "AFTER_LONG_PIC_DECODED_VM_PSS", "AFTER_NORMAL_PIC_DECODED", "AFTER_NORMAL_PIC_DECODED_NATIVE_PSS", "AFTER_NORMAL_PIC_DECODED_VM_PSS", "BAD_QUIT", "BEFORE_NATIVE_PSS", "BEFORE_VM_PSS", "ENTER_PAGE", "ID_KEY_ID", "", "LONG_PIC_MAX_MULTIPLE", "NORMAL_PIC", "NORMAL_QUIT", "SCENE_AVATAR", "SCENE_BACKGROUND", "SCENE_COVER", "SCENE_EMOJI", "START_DECODE", "SUPER_LONG_PIC", "TAG", "", "TOTAL_LONG_PIC", "report", "", "key", "value", "reportInc", "reportPss", "nativePssKey", "plugin-gallery_release"})
final class a
{
  public static final a sMS;
  
  static
  {
    AppMethodBeat.i(198444);
    sMS = new a();
    AppMethodBeat.o(198444);
  }
  
  public static void FU(int paramInt)
  {
    AppMethodBeat.i(198442);
    ac.i("ImageCropReport", "inc: ".concat(String.valueOf(paramInt)));
    h.wUl.n(1361L, paramInt, 1L);
    AppMethodBeat.o(198442);
  }
  
  public static void FV(int paramInt)
  {
    AppMethodBeat.i(198443);
    Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aT(ai.getContext());
    if (localMemoryInfo != null)
    {
      fS(paramInt, localMemoryInfo.nativePss);
      fS(paramInt + 1, localMemoryInfo.dalvikPss);
      AppMethodBeat.o(198443);
      return;
    }
    AppMethodBeat.o(198443);
  }
  
  public static void fS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198441);
    h.wUl.n(1361L, paramInt1, paramInt2);
    AppMethodBeat.o(198441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.a
 * JD-Core Version:    0.7.0.1
 */