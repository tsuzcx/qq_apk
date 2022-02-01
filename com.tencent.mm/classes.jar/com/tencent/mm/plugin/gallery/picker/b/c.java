package com.tencent.mm.plugin.gallery.picker.b;

import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/generator/PhotoExifUtil;", "", "()V", "TAG", "", "keepPhotoExifInfo", "", "source", "dst", "plugin-gallery_release"})
public final class c
{
  public static final c Uqd;
  
  static
  {
    AppMethodBeat.i(258741);
    Uqd = new c();
    AppMethodBeat.o(258741);
  }
  
  public static void lm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(258740);
    p.h(paramString1, "source");
    p.h(paramString2, "dst");
    Object localObject = new ExifInterface(s.k(paramString1, false));
    paramString1 = ((ExifInterface)localObject).getAttribute("GPSLongitude");
    String str1 = ((ExifInterface)localObject).getAttribute("GPSLatitude");
    String str2 = ((ExifInterface)localObject).getAttribute("GPSLongitudeRef");
    String str3 = ((ExifInterface)localObject).getAttribute("GPSLatitudeRef");
    String str4 = ((ExifInterface)localObject).getAttribute("GPSDestLongitude");
    localObject = ((ExifInterface)localObject).getAttribute("GPSDestLongitudeRef");
    paramString2 = new ExifInterface(s.k(paramString2, false));
    if (paramString1 != null) {
      paramString2.setAttribute("GPSLongitude", paramString1);
    }
    if (str1 != null) {
      paramString2.setAttribute("GPSLatitude", str1);
    }
    if (str2 != null) {
      paramString2.setAttribute("GPSLongitudeRef", str2);
    }
    if (str3 != null) {
      paramString2.setAttribute("GPSLatitudeRef", str3);
    }
    if (str4 != null) {
      paramString2.setAttribute("GPSDestLongitude", str4);
    }
    if (localObject != null) {
      paramString2.setAttribute("GPSDestLongitudeRef", (String)localObject);
    }
    try
    {
      paramString2.saveAttributes();
      AppMethodBeat.o(258740);
      return;
    }
    catch (IOException paramString1)
    {
      Log.printErrStackTrace("MicroMsg.PhotoExifUtil", (Throwable)paramString1, "saveAttributes error!", new Object[0]);
      AppMethodBeat.o(258740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.c
 * JD-Core Version:    0.7.0.1
 */