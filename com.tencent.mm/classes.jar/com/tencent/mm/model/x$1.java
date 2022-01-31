package com.tencent.mm.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.at.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class x$1
  extends ak
{
  x$1(x paramx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(77800);
    for (;;)
    {
      try
      {
        Bitmap localBitmap;
        if (this.flx.flw != null)
        {
          paramMessage = (x.c)paramMessage.obj;
          if ((paramMessage.flB) && (q.ahJ()))
          {
            String str = q.tw(paramMessage.url);
            ab.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", new Object[] { str, paramMessage.filename, paramMessage.url });
            localBitmap = d.aoV(paramMessage.filename);
            if (localBitmap == null) {
              break label224;
            }
            if (!bo.isNullOrNil(str))
            {
              if (!str.toLowerCase().contains("png")) {
                continue;
              }
              ab.d("MicroMsg.GetPicService", "convert webp to png");
              d.a(localBitmap, 100, Bitmap.CompressFormat.PNG, paramMessage.filename, true);
            }
          }
          int i = e.cM(paramMessage.filename);
          if ((i > 0) && (g.RG())) {
            ao.a.flJ.cq(i, 0);
          }
          al.d(new x.1.1(this, paramMessage));
        }
        else
        {
          AppMethodBeat.o(77800);
          return;
        }
        ab.d("MicroMsg.GetPicService", "convert webp to jpg");
        d.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, paramMessage.filename, true);
        continue;
        ab.d("MicroMsg.GetPicService", "decode webp picture failed");
      }
      catch (Exception paramMessage)
      {
        ab.e("MicroMsg.GetPicService", "exception:%s", new Object[] { bo.l(paramMessage) });
        AppMethodBeat.o(77800);
        return;
      }
      label224:
      x.a(this.flx, 14L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.x.1
 * JD-Core Version:    0.7.0.1
 */