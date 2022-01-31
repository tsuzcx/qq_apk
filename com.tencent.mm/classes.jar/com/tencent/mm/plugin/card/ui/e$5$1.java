package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h.c;
import java.util.HashMap;

final class e$5$1
  implements h.c
{
  e$5$1(e.5 param5) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(88341);
    Object localObject1 = (String)this.ktY.ktX.ktQ.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(88341);
      return;
    }
    Object localObject2;
    Object localObject3;
    String str1;
    if (((String)localObject1).equals("menu_func_share_friend"))
    {
      localObject1 = this.ktY.ktX;
      com.tencent.mm.plugin.card.d.b.a(((e)localObject1).kts, 1, (MMActivity.a)localObject1);
      ((e)localObject1).kts.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      localObject1 = h.qsU;
      int i = this.ktY.ktX.klk.bbd().iFL;
      localObject2 = this.ktY.ktX.klk.bbi();
      localObject3 = this.ktY.ktX.klk.bbh();
      int j = this.ktY.ktX.ktU.kqC;
      str1 = this.ktY.ktX.ktU.ktc;
      if (this.ktY.ktX.klk.bbb()) {}
      for (paramInt = 1;; paramInt = 0)
      {
        ((h)localObject1).e(11324, new Object[] { "BrandContactView", Integer.valueOf(i), localObject2, localObject3, Integer.valueOf(0), Integer.valueOf(j), str1, Integer.valueOf(paramInt), "" });
        h.qsU.e(11582, new Object[] { "OperShareFriend", Integer.valueOf(1), Integer.valueOf(this.ktY.ktX.klk.bbd().iFL), this.ktY.ktX.klk.bbi(), this.ktY.ktX.klk.bbh(), this.ktY.ktX.ktO });
        AppMethodBeat.o(88341);
        return;
      }
    }
    if (((String)localObject1).equals("menu_func_gift"))
    {
      e.b(this.ktY.ktX);
      AppMethodBeat.o(88341);
      return;
    }
    if (((String)localObject1).equals("menu_func_delete"))
    {
      localObject1 = "";
      if (this.ktY.ktX.klk.baL()) {
        localObject1 = this.ktY.ktX.kts.getString(2131297895);
      }
      com.tencent.mm.plugin.card.d.d.a(this.ktY.ktX.kts, this.ktY.ktX.ktU.kkW, (String)localObject1, new e.5.1.1(this));
      h.qsU.e(11582, new Object[] { "OperDelete", Integer.valueOf(1), Integer.valueOf(this.ktY.ktX.klk.bbd().iFL), this.ktY.ktX.klk.bbi(), this.ktY.ktX.klk.bbh(), "" });
      AppMethodBeat.o(88341);
      return;
    }
    if (((String)localObject1).equals("menu_func_service"))
    {
      if (!TextUtils.isEmpty(this.ktY.ktX.klk.bbd().wFW))
      {
        com.tencent.mm.plugin.card.d.b.ae(this.ktY.ktX.kts, this.ktY.ktX.klk.bbd().wFW);
        am.bcj().w(this.ktY.ktX.klk.bbh(), this.ktY.ktX.klk.bbi(), 1);
      }
      h.qsU.e(11582, new Object[] { "OperService", Integer.valueOf(1), Integer.valueOf(this.ktY.ktX.klk.bbd().iFL), this.ktY.ktX.klk.bbi(), this.ktY.ktX.klk.bbh(), this.ktY.ktX.ktU.ktc });
      AppMethodBeat.o(88341);
      return;
    }
    if (((String)localObject1).equals("menu_func_report"))
    {
      if (!TextUtils.isEmpty(this.ktY.ktX.klk.bbe().wDX)) {
        com.tencent.mm.plugin.card.d.b.a(this.ktY.ktX.kts, this.ktY.ktX.klk.bbe().wDX, this.ktY.ktX.getString(2131298016));
      }
      h.qsU.e(11582, new Object[] { "OperReport", Integer.valueOf(1), Integer.valueOf(this.ktY.ktX.klk.bbd().iFL), this.ktY.ktX.klk.bbi(), this.ktY.ktX.klk.bbh(), "" });
      AppMethodBeat.o(88341);
      return;
    }
    if (((String)localObject1).equals("menu_func_share_timeline"))
    {
      x.a(new m(this.ktY.ktX.klk.bbd().kmm));
      localObject1 = this.ktY.ktX.kts;
      localObject3 = this.ktY.ktX.klk;
      str1 = this.ktY.ktX.ktU.kkW;
      String str2 = this.ktY.ktX.ktU.kte;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Ksnsupload_link", ((com.tencent.mm.plugin.card.base.b)localObject3).bbd().wGf);
      ((Intent)localObject2).putExtra("KContentObjDesc", ((com.tencent.mm.plugin.card.base.b)localObject3).bbd().knw);
      ((Intent)localObject2).putExtra("Ksnsupload_title", ((com.tencent.mm.plugin.card.base.b)localObject3).bbd().title);
      if (TextUtils.isEmpty(str2)) {
        ((Intent)localObject2).putExtra("KUploadProduct_UserData", str1 + "#");
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("Ksnsupload_imgurl", ((com.tencent.mm.plugin.card.base.b)localObject3).bbd().kmm);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject3).bbd().kmm)) {
          ((Intent)localObject2).putExtra("KsnsUpload_imgPath", new m(((com.tencent.mm.plugin.card.base.b)localObject3).bbd().kmm).aon());
        }
        ab.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + ((Intent)localObject2).getStringExtra("KsnsUpload_imgPath"));
        ((Intent)localObject2).putExtra("src_username", r.Zn());
        ((Intent)localObject2).putExtra("src_displayname", r.Zp());
        ((Intent)localObject2).putExtra("Ksnsupload_appid", ((com.tencent.mm.plugin.card.base.b)localObject3).bbd().cwc);
        ((Intent)localObject2).putExtra("Ksnsupload_appname", ((com.tencent.mm.plugin.card.base.b)localObject3).bbd().wFW);
        ((Intent)localObject2).putExtra("Ksnsupload_type", 7);
        localObject3 = v.oQ("card_package");
        v.aae().z((String)localObject3, true).i("prePublishId", "card_package");
        ((Intent)localObject2).putExtra("reportSessionId", (String)localObject3);
        com.tencent.mm.bq.d.c((Context)localObject1, "sns", ".ui.SnsUploadUI", (Intent)localObject2);
        h.qsU.e(11582, new Object[] { "OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(this.ktY.ktX.klk.bbd().iFL), this.ktY.ktX.klk.bbi(), this.ktY.ktX.klk.bbh(), this.ktY.ktX.ktU.ktc });
        AppMethodBeat.o(88341);
        return;
        ((Intent)localObject2).putExtra("KUploadProduct_UserData", str1 + "#" + str2);
      }
    }
    if (((String)localObject1).equals("menu_func_delete_share_card"))
    {
      com.tencent.mm.plugin.card.d.d.a(this.ktY.ktX.kts, this.ktY.ktX.ktU.kkW, "", new d.a()
      {
        public final void baI()
        {
          AppMethodBeat.i(88340);
          if (e.5.1.this.ktY.ktX.ktT != null) {
            e.5.1.this.ktY.ktX.ktT.bdt();
          }
          AppMethodBeat.o(88340);
        }
      });
      AppMethodBeat.o(88341);
      return;
    }
    localObject1 = (String)this.ktY.ktX.ktR.get(localObject1);
    if (!bo.isNullOrNil((String)localObject1)) {
      com.tencent.mm.plugin.card.d.b.a(this.ktY.ktX.kts, (String)localObject1, 0);
    }
    AppMethodBeat.o(88341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.5.1
 * JD-Core Version:    0.7.0.1
 */