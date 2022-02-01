package com.tencent.kinda.framework.widget.base;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.kinda.gen.KQRCodeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaQRCodeViewImpl
  extends BaseKindaCodeView
  implements KQRCodeView
{
  protected Bitmap getNewBitmap(String paramString)
  {
    AppMethodBeat.i(18937);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("base_MMKView", "kinda getBitmap mQRcode == null");
      AppMethodBeat.o(18937);
      return null;
    }
    paramString = a.a(this.mContext, paramString, 12, 3, 0.0D);
    AppMethodBeat.o(18937);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaQRCodeViewImpl
 * JD-Core Version:    0.7.0.1
 */