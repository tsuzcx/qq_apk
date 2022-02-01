package com.tencent.kinda.framework.widget.base;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.kinda.gen.KBarCodeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaBarCodeViewImpl
  extends BaseKindaCodeView
  implements KBarCodeView
{
  protected Bitmap getNewBitmap(String paramString)
  {
    AppMethodBeat.i(18855);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("base_MMKView", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(18855);
      return null;
    }
    paramString = a.a(this.mContext, paramString, 5, 0, 0.0D);
    AppMethodBeat.o(18855);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaBarCodeViewImpl
 * JD-Core Version:    0.7.0.1
 */