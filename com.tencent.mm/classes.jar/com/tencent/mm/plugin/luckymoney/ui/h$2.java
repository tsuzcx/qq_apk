package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.luckymoney.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;

final class h$2
  implements h.c
{
  h$2(h paramh) {}
  
  public final void gl(int paramInt)
  {
    String str;
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "shareImgToFriend");
      str = h.b(this.lXu);
      localObject1 = h.c(this.lXu);
      if (bk.bl(str)) {
        y.w("MicroMsg.LuckyMoneyApplication", "share image to friend fail, imgPath is null");
      }
      while (h.d(this.lXu) == 1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13079, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        return;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Retr_File_Name", str);
        ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
        ((Intent)localObject2).putExtra("Retr_Msg_Type", 0);
        a.eUR.l((Intent)localObject2, (Context)localObject1);
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13079, new Object[] { Integer.valueOf(8), Integer.valueOf(2) });
      return;
    case 1: 
      y.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "saveImg");
      str = h.b(this.lXu);
      localObject1 = h.c(this.lXu).getString(a.i.lucky_money_save_fail);
      localObject2 = h.c(this.lXu);
      if (bk.bl(str)) {
        y.w("MicroMsg.LuckyMoneyApplication", "save image fail, path is null");
      }
      while (h.d(this.lXu) == 1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13079, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
        return;
        if (!q.a(str, (Context)localObject2, a.i.wallet_cropimage_saved)) {
          Toast.makeText((Context)localObject2, (CharSequence)localObject1, 1).show();
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13079, new Object[] { Integer.valueOf(9), Integer.valueOf(2) });
      return;
    }
    y.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "doFav");
    h.e(this.lXu);
    if (h.d(this.lXu) == 1)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13079, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(13079, new Object[] { Integer.valueOf(10), Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h.2
 * JD-Core Version:    0.7.0.1
 */