package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;

public final class b
{
  public static void e(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(183798);
    if ((paramImageView == null) || (bs.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(183798);
      return;
    }
    String str = paramString;
    if (aj.DT()) {
      str = paramString + "_dark";
    }
    paramImageView.setImageResource(paramImageView.getResources().getIdentifier(str, "raw", paramImageView.getContext().getPackageName()));
    AppMethodBeat.o(183798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b
 * JD-Core Version:    0.7.0.1
 */