package com.tencent.mm.plugin.gallery.picker.view;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropReport;", "", "()V", "AFTER_GIF_DECODED", "", "AFTER_GIF_DECODED_NATIVE_PSS", "AFTER_GIF_DECODED_VM_PSS", "AFTER_LONG_PIC_DECODED", "AFTER_LONG_PIC_DECODED_NATIVE_PSS", "AFTER_LONG_PIC_DECODED_VM_PSS", "AFTER_NORMAL_PIC_DECODED", "AFTER_NORMAL_PIC_DECODED_NATIVE_PSS", "AFTER_NORMAL_PIC_DECODED_VM_PSS", "BAD_QUIT", "BEFORE_NATIVE_PSS", "BEFORE_VM_PSS", "ENTER_PAGE", "ID_KEY_ID", "", "LONG_PIC_MAX_MULTIPLE", "NORMAL_PIC", "NORMAL_QUIT", "SCENE_AVATAR", "SCENE_BACKGROUND", "SCENE_COVER", "SCENE_EMOJI", "START_DECODE", "SUPER_LONG_PIC", "TAG", "", "TOTAL_LONG_PIC", "report", "", "key", "value", "reportInc", "reportPss", "nativePssKey", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
{
  public static final a HKk;
  
  static
  {
    AppMethodBeat.i(289388);
    HKk = new a();
    AppMethodBeat.o(289388);
  }
  
  public static void WC(int paramInt)
  {
    AppMethodBeat.i(289378);
    Log.i("ImageCropReport", s.X("inc: ", Integer.valueOf(paramInt)));
    h.OAn.p(1361L, paramInt, 1L);
    AppMethodBeat.o(289378);
  }
  
  public static void WD(int paramInt)
  {
    AppMethodBeat.i(289382);
    Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.e.a.cm(MMApplicationContext.getContext());
    if (localMemoryInfo != null)
    {
      ik(paramInt, localMemoryInfo.nativePss);
      ik(paramInt + 1, localMemoryInfo.dalvikPss);
    }
    AppMethodBeat.o(289382);
  }
  
  public static void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(289370);
    h.OAn.p(1361L, paramInt1, paramInt2);
    AppMethodBeat.o(289370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.a
 * JD-Core Version:    0.7.0.1
 */