package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.d;
import com.tencent.mm.as.d.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import java.util.HashMap;

public final class b
  implements d.a
{
  int ift;
  public HashMap<Long, Integer> ifu = new HashMap();
  private i ifv;
  
  public b(i parami)
  {
    this.ifv = parami;
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (this.ift != 0) {}
    for (final int i = b.c.biz_time_line_bottom_round_mask_bg;; i = 0)
    {
      com.tencent.mm.as.a.a locala = o.ON();
      c.a locala1 = new c.a();
      locala1.erA = ("biz_nor_img" + i);
      locala1.ery = b.a.chatting_item_biz_default_bg;
      locala1.erk = 1;
      locala.a(paramString, paramImageView, locala1.OV(), new com.tencent.mm.as.a.c.g()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.as.a.d.b paramAnonymousb)
        {
          if (i == 0) {
            return null;
          }
          if ((paramAnonymousb == null) || (paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            y.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap bitmap is null");
            return null;
          }
          if (bk.bl(paramAnonymousString))
          {
            y.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap url is null");
            return null;
          }
          try
          {
            int j = com.tencent.mm.cb.a.fj(paramAnonymousView.getContext()) - (int)(com.tencent.mm.cb.a.getDensity(paramAnonymousView.getContext()) * 16.0F);
            if (b.this.ift != 0) {}
            for (int i = b.this.ift;; i = (int)(j / 2.35D))
            {
              paramAnonymousView = c.a(paramAnonymousb.bitmap, j, i, true);
              paramAnonymousString = Bitmap.createScaledBitmap(paramAnonymousView, j, i, true);
              if ((paramAnonymousString != paramAnonymousView) && (paramAnonymousView != null) && (!paramAnonymousView.isRecycled())) {
                paramAnonymousView.recycle();
              }
              paramAnonymousView = c.e(paramAnonymousString, i);
              if ((paramAnonymousString != null) && (!paramAnonymousString.isRecycled())) {
                paramAnonymousString.recycle();
              }
              return paramAnonymousView;
            }
            return null;
          }
          catch (OutOfMemoryError paramAnonymousString)
          {
            y.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramAnonymousString.getMessage() });
          }
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.as.a.d.b paramAnonymousb) {}
        
        public final void mv(String paramAnonymousString) {}
      });
      return;
    }
  }
  
  private static com.tencent.mm.as.e b(q paramq)
  {
    com.tencent.mm.as.e locale1 = null;
    if (paramq.field_msgId > 0L) {
      locale1 = o.OJ().bY(paramq.field_msgId);
    }
    com.tencent.mm.as.e locale2;
    if (locale1 != null)
    {
      locale2 = locale1;
      if (locale1.enp > 0L) {}
    }
    else
    {
      locale2 = locale1;
      if (paramq.field_msgSvrId > 0L) {
        locale2 = o.OJ().bX(paramq.field_msgSvrId);
      }
    }
    return locale2;
  }
  
  private int cO(long paramLong)
  {
    if (this.ifu.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.ifu.get(Long.valueOf(paramLong))).intValue();
    }
    return 0;
  }
  
  private static String f(com.tencent.mm.as.e parame)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (parame == null) {
      parame = (com.tencent.mm.as.e)localObject1;
    }
    String str;
    do
    {
      return parame;
      str = parame.enq;
      localObject1 = localObject2;
      if (parame.Or())
      {
        parame = o.OJ().d(parame);
        localObject1 = localObject2;
        if (parame != null)
        {
          parame = o.OJ().o(parame, "", "");
          localObject1 = localObject2;
          if (com.tencent.mm.vfs.e.bK(parame))
          {
            y.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
            localObject1 = parame;
          }
        }
      }
      parame = (com.tencent.mm.as.e)localObject1;
    } while (localObject1 != null);
    return o.OJ().o(str, "", "");
  }
  
  private void i(long paramLong, int paramInt)
  {
    this.ifu.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      y.i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      if (paramInt4 == -5103059)
      {
        i(paramLong2, 2);
        return;
      }
      i(paramLong2, 3);
      return;
    }
    i(paramLong2, 1);
    this.ifv.axW();
  }
  
  public final void a(q paramq, int paramInt1, ImageView paramImageView, int paramInt2)
  {
    this.ift = paramInt2;
    if ((cO(paramq.field_msgId) == 2) || (cO(paramq.field_msgId) == 3)) {}
    do
    {
      com.tencent.mm.as.e locale;
      do
      {
        return;
        locale = b(paramq);
        if (locale == null) {
          break;
        }
        String str = f(locale);
        if (com.tencent.mm.vfs.e.bK(str))
        {
          a(str, paramImageView);
          i(paramq.field_msgId, 1);
          return;
        }
      } while (o.OK().a(locale.enp, paramq.field_msgId, 0, Integer.valueOf(paramInt1), b.c.chat_img_template, this, 0) != -2);
      y.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
      paramq = b(paramq);
      if (paramq == null)
      {
        y.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
        return;
      }
      paramq = f(paramq);
    } while (!com.tencent.mm.vfs.e.bK(paramq));
    a(paramq, paramImageView);
    return;
    y.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", new Object[] { Long.valueOf(paramq.field_msgId), Long.valueOf(paramq.field_msgSvrId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b
 * JD-Core Version:    0.7.0.1
 */