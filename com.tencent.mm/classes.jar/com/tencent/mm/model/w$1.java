package com.tencent.mm.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.as.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class w$1
  extends ah
{
  w$1(w paramw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        if (this.dVo.dVn == null) {
          break;
        }
        paramMessage = (w.c)paramMessage.obj;
        Bitmap localBitmap;
        if ((paramMessage.dVs) && (q.OQ()))
        {
          String str = q.mq(paramMessage.url);
          y.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", new Object[] { str, paramMessage.filename, paramMessage.url });
          localBitmap = c.YW(paramMessage.filename);
          if (localBitmap == null) {
            break label209;
          }
          if (!bk.bl(str))
          {
            if (!str.toLowerCase().contains("png")) {
              continue;
            }
            y.d("MicroMsg.GetPicService", "convert webp to png");
            c.a(localBitmap, 100, Bitmap.CompressFormat.PNG, paramMessage.filename, true);
          }
        }
        int i = e.bJ(paramMessage.filename);
        if ((i > 0) && (g.DK())) {
          am.a.dVz.bg(i, 0);
        }
        ai.d(new w.1.1(this, paramMessage));
        return;
        y.d("MicroMsg.GetPicService", "convert webp to jpg");
        c.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, paramMessage.filename, true);
        continue;
        y.d("MicroMsg.GetPicService", "decode webp picture failed");
      }
      catch (Exception paramMessage)
      {
        y.e("MicroMsg.GetPicService", "exception:%s", new Object[] { bk.j(paramMessage) });
        return;
      }
      label209:
      w.a(this.dVo, 14L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.w.1
 * JD-Core Version:    0.7.0.1
 */