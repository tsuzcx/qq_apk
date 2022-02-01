package com.tencent.mm.plugin.gallery.picker.b;

import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/PhotoExifUtil;", "", "()V", "TAG", "", "keepPhotoExifInfo", "", "source", "dst", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c HJQ;
  
  static
  {
    AppMethodBeat.i(289314);
    HJQ = new c();
    AppMethodBeat.o(289314);
  }
  
  public static void iN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(289312);
    s.u(paramString1, "source");
    s.u(paramString2, "dst");
    paramString1 = y.n(paramString1, false);
    s.checkNotNull(paramString1);
    Object localObject = new ExifInterface(paramString1);
    paramString1 = ((ExifInterface)localObject).getAttribute("GPSLongitude");
    String str1 = ((ExifInterface)localObject).getAttribute("GPSLatitude");
    String str2 = ((ExifInterface)localObject).getAttribute("GPSLongitudeRef");
    String str3 = ((ExifInterface)localObject).getAttribute("GPSLatitudeRef");
    String str4 = ((ExifInterface)localObject).getAttribute("GPSDestLongitude");
    localObject = ((ExifInterface)localObject).getAttribute("GPSDestLongitudeRef");
    paramString2 = y.n(paramString2, false);
    s.checkNotNull(paramString2);
    paramString2 = new ExifInterface(paramString2);
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
      AppMethodBeat.o(289312);
      return;
    }
    catch (IOException paramString1)
    {
      Log.printErrStackTrace("MicroMsg.PhotoExifUtil", (Throwable)paramString1, "saveAttributes error!", new Object[0]);
      AppMethodBeat.o(289312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.c
 * JD-Core Version:    0.7.0.1
 */