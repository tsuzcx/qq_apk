package com.tencent.mm.plugin.finder.nearby.person;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ui.applet.b.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "userName", "", "getHeadImg"})
final class NearbyPersonV1UIC$a$a
  implements b.a
{
  public static final a uSB;
  
  static
  {
    AppMethodBeat.i(249266);
    uSB = new a();
    AppMethodBeat.o(249266);
  }
  
  public final Bitmap Ta(String paramString)
  {
    AppMethodBeat.i(249265);
    paramString = c.Mc(paramString);
    AppMethodBeat.o(249265);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.a.a
 * JD-Core Version:    0.7.0.1
 */