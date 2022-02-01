package com.tencent.mm.plugin.appbrand.ui;

import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.RelievedBuySetting;
import com.tencent.mm.sdk.platformtools.Log;

public final class au
{
  public static void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(322132);
    Log.i("MicroMsg.WxaRelievedBuyIconApply", "applyGreenIcon");
    String str = AppBrandGlobalSystemConfig.ckD().qXt.qXM;
    int i = AppBrandGlobalSystemConfig.ckD().qXt.qXN;
    int j = AppBrandGlobalSystemConfig.ckD().qXt.qXO;
    if ((!TextUtils.isEmpty(str)) && (i > 0) && (j > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.width = ((int)(i * localLayoutParams.height / j));
      paramImageView.setLayoutParams(localLayoutParams);
      b.bEY().a(paramImageView, str, paramInt, null);
      AppMethodBeat.o(322132);
      return;
    }
    paramImageView.setImageResource(paramInt);
    AppMethodBeat.o(322132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.au
 * JD-Core Version:    0.7.0.1
 */