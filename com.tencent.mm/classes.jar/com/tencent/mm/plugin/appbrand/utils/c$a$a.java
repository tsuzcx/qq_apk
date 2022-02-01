package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AnyProcessAvatarAttacher$AvatarBitmapDrawable$Companion;", "", "()V", "DEFAULT_AVATAR_PATH", "", "DEFAULT_AVATAR_ROUND_RATE", "", "PRESSED_COVER_ALPHA", "", "TAG", "defaultBitmap", "Landroid/graphics/Bitmap;", "toAvatarBitmap", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a$a
{
  static Bitmap ad(Bitmap paramBitmap)
  {
    AppMethodBeat.i(317314);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(317314);
      return null;
    }
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, true, 0.1F * paramBitmap.getWidth());
    AppMethodBeat.o(317314);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c.a.a
 * JD-Core Version:    0.7.0.1
 */