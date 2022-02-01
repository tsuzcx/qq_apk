package com.tencent.mm.plugin.gallery.picker.view;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropReport;", "", "()V", "AFTER_GIF_DECODED", "", "AFTER_GIF_DECODED_NATIVE_PSS", "AFTER_GIF_DECODED_VM_PSS", "AFTER_LONG_PIC_DECODED", "AFTER_LONG_PIC_DECODED_NATIVE_PSS", "AFTER_LONG_PIC_DECODED_VM_PSS", "AFTER_NORMAL_PIC_DECODED", "AFTER_NORMAL_PIC_DECODED_NATIVE_PSS", "AFTER_NORMAL_PIC_DECODED_VM_PSS", "BAD_QUIT", "BEFORE_NATIVE_PSS", "BEFORE_VM_PSS", "ENTER_PAGE", "ID_KEY_ID", "", "LONG_PIC_MAX_MULTIPLE", "NORMAL_PIC", "NORMAL_QUIT", "SCENE_AVATAR", "SCENE_BACKGROUND", "SCENE_COVER", "SCENE_EMOJI", "START_DECODE", "SUPER_LONG_PIC", "TAG", "", "TOTAL_LONG_PIC", "report", "", "key", "value", "reportInc", "reportPss", "nativePssKey", "plugin-gallery_release"})
final class a
{
  public static final a tUr;
  
  static
  {
    AppMethodBeat.i(186215);
    tUr = new a();
    AppMethodBeat.o(186215);
  }
  
  public static void HG(int paramInt)
  {
    AppMethodBeat.i(186213);
    ae.i("ImageCropReport", "inc: ".concat(String.valueOf(paramInt)));
    g.yxI.n(1361L, paramInt, 1L);
    AppMethodBeat.o(186213);
  }
  
  public static void HH(int paramInt)
  {
    AppMethodBeat.i(186214);
    Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aU(ak.getContext());
    if (localMemoryInfo != null)
    {
      gi(paramInt, localMemoryInfo.nativePss);
      gi(paramInt + 1, localMemoryInfo.dalvikPss);
      AppMethodBeat.o(186214);
      return;
    }
    AppMethodBeat.o(186214);
  }
  
  public static void gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186212);
    g.yxI.n(1361L, paramInt1, paramInt2);
    AppMethodBeat.o(186212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.a
 * JD-Core Version:    0.7.0.1
 */