package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h.c;
import java.util.HashMap;

final class e$5$1
  implements h.c
{
  e$5$1(e.5 param5) {}
  
  public final void gl(int paramInt)
  {
    Object localObject1 = (String)this.isR.isQ.isJ.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      return;
      Object localObject2;
      Object localObject3;
      String str1;
      if (((String)localObject1).equals("menu_func_share_friend"))
      {
        localObject1 = this.isR.isQ;
        com.tencent.mm.plugin.card.d.b.a(((e)localObject1).isl, 1, (MMActivity.a)localObject1);
        ((e)localObject1).isl.gJb = ((MMActivity.a)localObject1);
        localObject1 = h.nFQ;
        int i = this.isR.isQ.ikk.azx().ilo;
        localObject2 = this.isR.isQ.ikk.azC();
        localObject3 = this.isR.isQ.ikk.azB();
        int j = this.isR.isQ.isN.ipv;
        str1 = this.isR.isQ.isN.irV;
        if (this.isR.isQ.ikk.azv()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          ((h)localObject1).f(11324, new Object[] { "BrandContactView", Integer.valueOf(i), localObject2, localObject3, Integer.valueOf(0), Integer.valueOf(j), str1, Integer.valueOf(paramInt), "" });
          h.nFQ.f(11582, new Object[] { "OperShareFriend", Integer.valueOf(1), Integer.valueOf(this.isR.isQ.ikk.azx().ilo), this.isR.isQ.ikk.azC(), this.isR.isQ.ikk.azB(), this.isR.isQ.isH });
          return;
        }
      }
      if (((String)localObject1).equals("menu_func_gift"))
      {
        e.b(this.isR.isQ);
        return;
      }
      if (((String)localObject1).equals("menu_func_delete"))
      {
        localObject1 = "";
        if (this.isR.isQ.ikk.azf()) {
          localObject1 = this.isR.isQ.isl.getString(a.g.card_delete_membership_tips);
        }
        com.tencent.mm.plugin.card.d.d.a(this.isR.isQ.isl, this.isR.isQ.isN.ijW, (String)localObject1, new e.5.1.1(this));
        h.nFQ.f(11582, new Object[] { "OperDelete", Integer.valueOf(1), Integer.valueOf(this.isR.isQ.ikk.azx().ilo), this.isR.isQ.ikk.azC(), this.isR.isQ.ikk.azB(), "" });
        return;
      }
      if (((String)localObject1).equals("menu_func_service"))
      {
        if (!TextUtils.isEmpty(this.isR.isQ.ikk.azx().sIn))
        {
          com.tencent.mm.plugin.card.d.b.ab(this.isR.isQ.isl, this.isR.isQ.ikk.azx().sIn);
          am.aAy().r(this.isR.isQ.ikk.azB(), this.isR.isQ.ikk.azC(), 1);
        }
        h.nFQ.f(11582, new Object[] { "OperService", Integer.valueOf(1), Integer.valueOf(this.isR.isQ.ikk.azx().ilo), this.isR.isQ.ikk.azC(), this.isR.isQ.ikk.azB(), this.isR.isQ.isN.irV });
        return;
      }
      if (((String)localObject1).equals("menu_func_report"))
      {
        if (!TextUtils.isEmpty(this.isR.isQ.ikk.azy().sHB)) {
          com.tencent.mm.plugin.card.d.b.a(this.isR.isQ.isl, this.isR.isQ.ikk.azy().sHB, this.isR.isQ.getString(a.g.card_report_title));
        }
        h.nFQ.f(11582, new Object[] { "OperReport", Integer.valueOf(1), Integer.valueOf(this.isR.isQ.ikk.azx().ilo), this.isR.isQ.ikk.azC(), this.isR.isQ.ikk.azB(), "" });
        return;
      }
      if (((String)localObject1).equals("menu_func_share_timeline"))
      {
        x.a(new m(this.isR.isQ.ikk.azx().ilp));
        localObject1 = this.isR.isQ.isl;
        localObject3 = this.isR.isQ.ikk;
        str1 = this.isR.isQ.isN.ijW;
        String str2 = this.isR.isQ.isN.irX;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Ksnsupload_link", ((com.tencent.mm.plugin.card.base.b)localObject3).azx().sIw);
        ((Intent)localObject2).putExtra("KContentObjDesc", ((com.tencent.mm.plugin.card.base.b)localObject3).azx().imA);
        ((Intent)localObject2).putExtra("Ksnsupload_title", ((com.tencent.mm.plugin.card.base.b)localObject3).azx().title);
        if (TextUtils.isEmpty(str2)) {
          ((Intent)localObject2).putExtra("KUploadProduct_UserData", str1 + "#");
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("Ksnsupload_imgurl", ((com.tencent.mm.plugin.card.base.b)localObject3).azx().ilp);
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject3).azx().ilp)) {
            ((Intent)localObject2).putExtra("KsnsUpload_imgPath", new m(((com.tencent.mm.plugin.card.base.b)localObject3).azx().ilp).UO());
          }
          y.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + ((Intent)localObject2).getStringExtra("KsnsUpload_imgPath"));
          ((Intent)localObject2).putExtra("src_username", q.Gj());
          ((Intent)localObject2).putExtra("src_displayname", q.Gl());
          ((Intent)localObject2).putExtra("Ksnsupload_appid", ((com.tencent.mm.plugin.card.base.b)localObject3).azx().bOL);
          ((Intent)localObject2).putExtra("Ksnsupload_appname", ((com.tencent.mm.plugin.card.base.b)localObject3).azx().sIn);
          ((Intent)localObject2).putExtra("Ksnsupload_type", 7);
          localObject3 = u.ij("card_package");
          u.Hc().v((String)localObject3, true).h("prePublishId", "card_package");
          ((Intent)localObject2).putExtra("reportSessionId", (String)localObject3);
          com.tencent.mm.br.d.c((Context)localObject1, "sns", ".ui.SnsUploadUI", (Intent)localObject2);
          h.nFQ.f(11582, new Object[] { "OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(this.isR.isQ.ikk.azx().ilo), this.isR.isQ.ikk.azC(), this.isR.isQ.ikk.azB(), this.isR.isQ.isN.irV });
          return;
          ((Intent)localObject2).putExtra("KUploadProduct_UserData", str1 + "#" + str2);
        }
      }
      if (((String)localObject1).equals("menu_func_delete_share_card"))
      {
        com.tencent.mm.plugin.card.d.d.a(this.isR.isQ.isl, this.isR.isQ.isN.ijW, "", new e.5.1.2(this));
        return;
      }
      localObject1 = (String)this.isR.isQ.isK.get(localObject1);
    } while (bk.bl((String)localObject1));
    com.tencent.mm.plugin.card.d.b.a(this.isR.isQ.isl, (String)localObject1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.5.1
 * JD-Core Version:    0.7.0.1
 */