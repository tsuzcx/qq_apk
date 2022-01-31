package com.tencent.mm.plugin.luckymoney.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.ak.b;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyNewYearSendUI$1
  implements View.OnClickListener
{
  LuckyMoneyNewYearSendUI$1(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.f.lucky_money_new_year_send_btn)
    {
      h.nFQ.f(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      if ((LuckyMoneyNewYearSendUI.a(this.lWH) == 1) && (LuckyMoneyNewYearSendUI.b(this.lWH)) && (!TextUtils.isEmpty(LuckyMoneyNewYearSendUI.c(this.lWH))) && (!TextUtils.isEmpty(LuckyMoneyNewYearSendUI.d(this.lWH))) && (!TextUtils.isEmpty(LuckyMoneyNewYearSendUI.e(this.lWH))) && (LuckyMoneyNewYearSendUI.f(this.lWH) > 0))
      {
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with last post image data!");
        LuckyMoneyNewYearSendUI.g(this.lWH);
      }
    }
    do
    {
      Object localObject;
      com.tencent.mm.j.f localf;
      do
      {
        return;
        if ((LuckyMoneyNewYearSendUI.a(this.lWH) != 1) || (!LuckyMoneyNewYearSendUI.b(this.lWH)) || (TextUtils.isEmpty(LuckyMoneyNewYearSendUI.c(this.lWH)))) {
          break;
        }
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with new image data!");
        LuckyMoneyNewYearSendUI.h(this.lWH);
        if (LuckyMoneyNewYearSendUI.i(this.lWH) == null) {
          LuckyMoneyNewYearSendUI.a(this.lWH, new k());
        }
        paramView = LuckyMoneyNewYearSendUI.i(this.lWH);
        String str = LuckyMoneyNewYearSendUI.c(this.lWH);
        localObject = new LuckyMoneyNewYearSendUI.1.1(this);
        paramView.jxH = k.bfK();
        paramView.lQG = ((k.a)localObject);
        paramView.lQH = str;
        localObject = paramView.jxH;
        y.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: sendImg. imageId:%s", new Object[] { localObject });
        localf = new com.tencent.mm.j.f();
        localf.ceg = true;
        localf.dlP = paramView;
        localf.field_mediaId = ((String)localObject);
        localf.field_fullpath = str;
        localf.field_thumbpath = "";
        localf.field_fileType = a.MediaType_FILE;
        localf.field_talker = "";
        localf.field_priority = a.dlk;
        localf.field_needStorage = false;
        localf.field_isStreamMedia = false;
        localf.field_appType = 0;
        localf.field_bzScene = 0;
      } while (com.tencent.mm.ak.f.Nd().c(localf));
      y.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. clientid:%s", new Object[] { localObject });
      return;
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with not image data!");
      LuckyMoneyNewYearSendUI.c(this.lWH, "");
      LuckyMoneyNewYearSendUI.a(this.lWH, "");
      LuckyMoneyNewYearSendUI.b(this.lWH, "");
      LuckyMoneyNewYearSendUI.a(this.lWH, 0);
      LuckyMoneyNewYearSendUI.g(this.lWH);
      return;
      if (paramView.getId() == a.f.lucky_money_new_year_close_btn)
      {
        this.lWH.finish();
        h.nFQ.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
        return;
      }
      if ((paramView.getId() == a.f.lucky_money_new_year_camera_btn) || (paramView.getId() == a.f.lucky_money_new_year_camera_tips))
      {
        LuckyMoneyNewYearSendUI.l(this.lWH);
        h.nFQ.f(13079, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        return;
      }
      if (paramView.getId() == a.f.lucky_money_new_year_picture_del_btn)
      {
        LuckyMoneyNewYearSendUI.a(this.lWH, "");
        LuckyMoneyNewYearSendUI.b(this.lWH, "");
        LuckyMoneyNewYearSendUI.a(this.lWH, 0);
        LuckyMoneyNewYearSendUI.m(this.lWH);
        h.nFQ.f(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
        return;
      }
      if (paramView.getId() == a.f.lucky_money_new_year_refresh_layout)
      {
        paramView = LuckyMoneyNewYearSendUI.n(this.lWH);
        paramView.lUn = false;
        paramView.lUe.setVisibility(0);
        paramView.lUf.setVisibility(0);
        paramView.lUg.setVisibility(0);
        paramView.lUh.setVisibility(4);
        paramView.lUi.setVisibility(4);
        paramView.lUj.setVisibility(4);
        LuckyMoneyNewYearSendUI.o(this.lWH);
        h.nFQ.f(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        return;
      }
    } while (paramView.getId() != a.f.lucky_money_new_year_picture_img);
    LuckyMoneyNewYearSendUI.p(this.lWH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.1
 * JD-Core Version:    0.7.0.1
 */