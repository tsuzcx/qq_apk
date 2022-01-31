package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.LinkedList;

final class e$4
  implements View.OnClickListener
{
  e$4(e parame) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    int i = 0;
    AppMethodBeat.i(88338);
    if ((paramView.getId() == 2131821983) || (paramView.getId() == 2131821984))
    {
      if (this.ktX.klk.baJ())
      {
        if (this.ktX.ktT != null)
        {
          this.ktX.ktT.bdr();
          AppMethodBeat.o(88338);
        }
      }
      else if ((this.ktX.klk.baK()) && (this.ktX.ktT != null))
      {
        this.ktX.ktT.bdp();
        AppMethodBeat.o(88338);
      }
    }
    else
    {
      if ((paramView.getId() == 2131824305) || (paramView.getId() == 2131821989))
      {
        com.tencent.mm.plugin.card.d.b.ad(this.ktX.kts, this.ktX.ktU.ktc);
        AppMethodBeat.o(88338);
        return;
      }
      Object localObject;
      if ((paramView.getId() == 2131822018) || (paramView.getId() == 2131822011))
      {
        if (paramView.getId() == 2131822018)
        {
          this.ktX.ktM = false;
          if ((this.ktX.ktz instanceof q))
          {
            localObject = ((q)this.ktX.ktz).e(c.kCb);
            this.ktX.ktL.kxM = ((String)localObject);
          }
          localObject = this.ktX.ktL;
          bool = this.ktX.ktM;
          ((j)localObject).beo();
          ((j)localObject).ktM = bool;
          if ((((j)localObject).gMK != null) && (!((j)localObject).gMK.isShowing()))
          {
            ((j)localObject).gMK.showAtLocation(paramView.getRootView(), 17, 0, 0);
            ((j)localObject).gMK.setFocusable(true);
            ((j)localObject).gMK.setTouchable(true);
            ((j)localObject).gMK.setBackgroundDrawable(new ColorDrawable(16777215));
            ((j)localObject).gMK.setOutsideTouchable(true);
            if (!((j)localObject).ktM) {
              break label743;
            }
            ((j)localObject).kxI.setOnClickListener(((j)localObject).gMO);
            paramView = ((j)localObject).kxE;
            if (((j)localObject).kqq == null) {
              break label655;
            }
            ((j)localObject).kxE = l.H(((j)localObject).kqq);
            label393:
            ((j)localObject).kxI.setImageBitmap(((j)localObject).kxE);
            ((j)localObject).kxL.add(0, paramView);
            ((j)localObject).ber();
            ((j)localObject).gMM.setVisibility(8);
            ((j)localObject).kxH.setVisibility(0);
            paramView = ((j)localObject).klk.bbe().code;
            if ((((j)localObject).klk.bbd().wGE != null) && (((j)localObject).klk.bbd().wGE.wPY)) {
              break label697;
            }
            if (bo.isNullOrNil(((j)localObject).klk.bbe().wEg)) {
              break label664;
            }
            paramView = ((j)localObject).klk.bbe().wEg;
            label522:
            if ((TextUtils.isEmpty(paramView)) || (paramView.length() > 40)) {
              break label717;
            }
            ((j)localObject).kxJ.setText(m.II(paramView));
            if (!((j)localObject).klk.baT()) {
              break label704;
            }
            ((j)localObject).kxJ.setVisibility(0);
            label572:
            if (bo.isNullOrNil(((j)localObject).klk.bbd().kNG)) {
              break label730;
            }
            ((j)localObject).kxK.setText(((j)localObject).klk.bbd().kNG);
            ((j)localObject).kxK.setVisibility(0);
          }
        }
        for (;;)
        {
          ((j)localObject).gMK.update();
          AppMethodBeat.o(88338);
          return;
          if (paramView.getId() != 2131822011) {
            break;
          }
          this.ktX.ktM = true;
          break;
          label655:
          ((j)localObject).kxE = null;
          break label393;
          label664:
          if (!((j)localObject).klk.baY()) {
            break label522;
          }
          if (!bo.isNullOrNil(((j)localObject).kxM))
          {
            paramView = ((j)localObject).kxM;
            break label522;
          }
          label697:
          paramView = "";
          break label522;
          label704:
          ((j)localObject).kxJ.setVisibility(8);
          break label572;
          label717:
          ((j)localObject).kxJ.setVisibility(8);
          break label572;
          label730:
          ((j)localObject).kxK.setVisibility(8);
        }
        label743:
        ((j)localObject).gML.setOnClickListener(((j)localObject).gMO);
        ((j)localObject).gML.setImageBitmap(((j)localObject).gMJ);
        paramView = ((j)localObject).klk.bbe().code;
        if ((((j)localObject).klk.bbd().wGE == null) || (!((j)localObject).klk.bbd().wGE.wPY)) {
          if (!bo.isNullOrNil(((j)localObject).klk.bbe().wEg))
          {
            paramView = ((j)localObject).klk.bbe().wEg;
            label851:
            if ((TextUtils.isEmpty(paramView)) || (paramView.length() > 40)) {
              break label1025;
            }
            ((j)localObject).kxF.setText(m.II(paramView));
            if (!((j)localObject).klk.baT()) {
              break label1012;
            }
            ((j)localObject).kxF.setVisibility(0);
            label901:
            if (TextUtils.isEmpty(((j)localObject).klk.bbd().kNG)) {
              break label1038;
            }
            ((j)localObject).kxG.setText(((j)localObject).klk.bbd().kNG);
            ((j)localObject).kxG.setVisibility(0);
          }
        }
        for (;;)
        {
          ((j)localObject).gMM.setVisibility(0);
          ((j)localObject).kxH.setVisibility(8);
          break;
          if (!((j)localObject).klk.baY()) {
            break label851;
          }
          if (!bo.isNullOrNil(((j)localObject).kxM))
          {
            paramView = ((j)localObject).kxM;
            break label851;
          }
          paramView = "";
          break label851;
          label1012:
          ((j)localObject).kxF.setVisibility(8);
          break label901;
          label1025:
          ((j)localObject).kxF.setVisibility(8);
          break label901;
          label1038:
          ((j)localObject).kxG.setVisibility(8);
        }
      }
      int j;
      String str1;
      int k;
      String str2;
      if ((paramView.getId() == 2131822393) || (paramView.getId() == 2131822291) || (paramView.getId() == 2131822058) || (paramView.getId() == 2131822013) || (paramView.getId() == 2131822290))
      {
        if (paramView.getId() == 2131822393)
        {
          if (this.ktX.klk.baK())
          {
            paramView = h.qsU;
            j = this.ktX.klk.bbd().iFL;
            localObject = this.ktX.klk.bbi();
            str1 = this.ktX.klk.bbh();
            k = this.ktX.ktU.kqC;
            str2 = this.ktX.ktU.ktc;
            if (this.ktX.klk.bbb()) {}
            for (i = 1;; i = 0)
            {
              paramView.e(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
              if (this.ktX.ktT == null) {
                break;
              }
              this.ktX.ktT.ga(true);
              AppMethodBeat.o(88338);
              return;
            }
          }
          paramView = new j.b();
          this.ktX.a(true, paramView, false);
          AppMethodBeat.o(88338);
          return;
        }
        if ((paramView.getId() == 2131822013) && (this.ktX.klk.bbd().wGH))
        {
          AppMethodBeat.o(88338);
          return;
        }
        if (this.ktX.klk.baK())
        {
          if (this.ktX.ktT != null)
          {
            this.ktX.ktT.ga(false);
            AppMethodBeat.o(88338);
          }
        }
        else
        {
          paramView = new j.b();
          this.ktX.a(false, paramView, false);
          AppMethodBeat.o(88338);
        }
      }
      else if (paramView.getId() == 2131822094)
      {
        if (!TextUtils.isEmpty(this.ktX.klk.bbd().wGl))
        {
          com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, this.ktX.klk.bbd().wGl, 3);
          h.qsU.e(11941, new Object[] { Integer.valueOf(13), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", this.ktX.klk.bbd().wGk });
          AppMethodBeat.o(88338);
        }
      }
      else
      {
        if (paramView.getId() == 2131821987)
        {
          h.qsU.e(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(this.ktX.klk.bbd().iFL), this.ktX.klk.bbi(), this.ktX.klk.bbh(), this.ktX.ktU.ktc });
          paramView = new Intent();
          paramView.putExtra("KLabel_range_index", this.ktX.kre);
          paramView.putExtra("Klabel_name_list", this.ktX.krf);
          paramView.putExtra("Kother_user_name_list", this.ktX.krg);
          paramView.putExtra("k_sns_label_ui_title", this.ktX.kts.getString(2131298041));
          paramView.putExtra("k_sns_label_ui_style", 0);
          paramView.putExtra("KLabel_is_filter_private", true);
          d.b(this.ktX.kts, "sns", ".ui.SnsLabelUI", paramView, 2);
          this.ktX.kts.mmSetOnActivityResultCallback(this.ktX);
          AppMethodBeat.o(88338);
          return;
        }
        if (paramView.getId() == 2131822340)
        {
          if (this.ktX.klk.bbe().wDU != null)
          {
            localObject = this.ktX.klk.bbe().wDU;
            i = ((Integer)paramView.getTag()).intValue();
            paramView = (uo)((LinkedList)localObject).get(i);
            if (com.tencent.mm.plugin.card.d.b.a(this.ktX.klk.bbh(), paramView, this.ktX.ktU.kqC, this.ktX.ktU.kua))
            {
              h.qsU.e(11941, new Object[] { Integer.valueOf(19), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramView.title });
              AppMethodBeat.o(88338);
              return;
            }
            if ((paramView != null) && (!TextUtils.isEmpty(paramView.url)))
            {
              com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, paramView.url, 1);
              localObject = h.qsU;
              switch (i)
              {
              default: 
                i = 10;
              }
            }
            for (;;)
            {
              ((h)localObject).e(11941, new Object[] { Integer.valueOf(i), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramView.title });
              if (l.a(paramView, this.ktX.klk.bbh()))
              {
                l.IG(this.ktX.klk.bbh());
                com.tencent.mm.plugin.card.d.b.b(this.ktX.kts, this.ktX.klk.bbd().knw);
              }
              AppMethodBeat.o(88338);
              return;
              i = 10;
              continue;
              i = 11;
              continue;
              i = 12;
              continue;
              i = 16;
            }
          }
        }
        else if (paramView.getId() == 2131822343)
        {
          if (this.ktX.klk.bbe().wDU != null)
          {
            paramView = (uo)this.ktX.klk.bbe().wDU.get(0);
            if (com.tencent.mm.plugin.card.d.b.a(this.ktX.klk.bbh(), paramView, this.ktX.ktU.kqC, this.ktX.ktU.kua))
            {
              h.qsU.e(11941, new Object[] { Integer.valueOf(19), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramView.title });
              AppMethodBeat.o(88338);
              return;
            }
            if ((paramView != null) && (!TextUtils.isEmpty(paramView.url)))
            {
              com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, paramView.url, 1);
              h.qsU.e(11941, new Object[] { Integer.valueOf(10), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramView.title });
              if (l.a(paramView, this.ktX.klk.bbh()))
              {
                l.IG(this.ktX.klk.bbh());
                com.tencent.mm.plugin.card.d.b.b(this.ktX.kts, this.ktX.klk.bbd().knw);
              }
            }
            AppMethodBeat.o(88338);
          }
        }
        else if ((paramView.getId() == 2131822306) || (paramView.getId() == 2131822307))
        {
          if (this.ktX.klk.bbe().wEb != null) {
            if (this.ktX.klk.baW())
            {
              if (this.ktX.klk.baK())
              {
                if (this.ktX.ktT != null)
                {
                  this.ktX.ktT.ga(false);
                  AppMethodBeat.o(88338);
                }
              }
              else
              {
                paramView = new j.b();
                this.ktX.a(false, paramView, false);
                AppMethodBeat.o(88338);
              }
            }
            else
            {
              if (this.ktX.klk.baX())
              {
                paramView = new j.b();
                com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, paramView.kmb, paramView.kmc, false, this.ktX.klk);
                AppMethodBeat.o(88338);
                return;
              }
              paramView = this.ktX.klk.bbe().wEb;
              if (com.tencent.mm.plugin.card.d.b.a(this.ktX.klk.bbh(), paramView, this.ktX.ktU.kqC, this.ktX.ktU.kua))
              {
                h.qsU.e(11941, new Object[] { Integer.valueOf(20), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramView.title });
                AppMethodBeat.o(88338);
                return;
              }
              if ((paramView != null) && (!TextUtils.isEmpty(paramView.url)))
              {
                localObject = l.H(paramView.url, paramView.wGZ);
                com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, (String)localObject, 1);
                h.qsU.e(11941, new Object[] { Integer.valueOf(9), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramView.title });
                if (l.a(paramView, this.ktX.klk.bbh()))
                {
                  l.IG(this.ktX.klk.bbh());
                  com.tencent.mm.plugin.card.d.b.b(this.ktX.kts, this.ktX.klk.bbd().knw);
                }
              }
              AppMethodBeat.o(88338);
            }
          }
        }
        else
        {
          String str3;
          if ((paramView.getId() == 2131822085) || (paramView.getId() == 2131822078))
          {
            paramView = this.ktX.klk.bbd().wGr;
            localObject = h.qsU;
            j = this.ktX.klk.bbd().iFL;
            str1 = this.ktX.klk.bbi();
            str2 = this.ktX.klk.bbh();
            k = this.ktX.ktU.kqC;
            str3 = this.ktX.ktU.ktc;
            if (this.ktX.klk.bbb()) {
              i = 1;
            }
            ((h)localObject).e(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
            if ((paramView != null) && (!TextUtils.isEmpty(paramView.url)))
            {
              com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, paramView.url, 1);
              AppMethodBeat.o(88338);
              return;
            }
            paramView = new Intent();
            if ((this.ktX.klk instanceof CardInfo)) {
              paramView.putExtra("key_card_info_data", (CardInfo)this.ktX.klk);
            }
            for (;;)
            {
              paramView.setClass(this.ktX.kts, CardDetailPreference.class);
              this.ktX.kts.startActivity(paramView);
              AppMethodBeat.o(88338);
              return;
              if ((this.ktX.klk instanceof ShareCardInfo)) {
                paramView.putExtra("key_card_info_data", (ShareCardInfo)this.ktX.klk);
              }
            }
          }
          if (paramView.getId() == 2131822363)
          {
            if (com.tencent.mm.plugin.card.sharecard.a.b.HR(this.ktX.klk.bbi()) <= 1)
            {
              AppMethodBeat.o(88338);
              return;
            }
            paramView = this.ktX;
            if (!this.ktX.ktv) {}
            for (;;)
            {
              paramView.ktv = bool;
              this.ktX.bcI();
              AppMethodBeat.o(88338);
              return;
              bool = false;
            }
          }
          if (paramView.getId() == 2131822081)
          {
            if ((this.ktX.klk.bbd().wGn != null) && (!TextUtils.isEmpty(this.ktX.klk.bbd().wGn.url)))
            {
              com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, this.ktX.klk.bbd().wGn.url, 3);
              h.qsU.e(11941, new Object[] { Integer.valueOf(3), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", this.ktX.klk.bbd().wGn.text });
              AppMethodBeat.o(88338);
            }
          }
          else if (paramView.getId() == 2131821992)
          {
            if ((this.ktX.klk.bbd().wGu != null) && (!bo.isNullOrNil(this.ktX.klk.bbd().wGu.url)))
            {
              com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, this.ktX.klk.bbd().wGu.url, 1);
              h.qsU.e(11941, new Object[] { Integer.valueOf(14), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", this.ktX.klk.bbd().wGu.text });
              AppMethodBeat.o(88338);
            }
          }
          else if ((paramView.getId() == 2131822376) || (paramView.getId() == 2131822375))
          {
            if (this.ktX.klk.bbd().wGd > 0)
            {
              if ((this.ktX.klq == null) || (this.ktX.klq.size() == 0))
              {
                ab.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                AppMethodBeat.o(88338);
                return;
              }
              paramView = (oz)this.ktX.klq.get(0);
              com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, paramView.cyV, paramView.cAH, paramView.fBq);
              localObject = h.qsU;
              j = this.ktX.klk.bbd().iFL;
              str1 = this.ktX.klk.bbi();
              str2 = this.ktX.klk.bbh();
              k = this.ktX.ktU.kqC;
              str3 = this.ktX.ktU.ktc;
              if (this.ktX.klk.bbb()) {}
              for (i = 1;; i = 0)
              {
                ((h)localObject).e(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                h.qsU.e(11941, new Object[] { Integer.valueOf(5), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramView.name });
                AppMethodBeat.o(88338);
                return;
              }
            }
          }
          else
          {
            if (paramView.getId() == 2131822403)
            {
              if ((this.ktX.klq == null) || (this.ktX.klq.size() == 0))
              {
                ab.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                AppMethodBeat.o(88338);
                return;
              }
              localObject = (oz)this.ktX.klq.get(0);
              paramView = (String)paramView.getTag();
              if ((!TextUtils.isEmpty(paramView)) && (paramView.equals(this.ktX.kts.getString(2131297874))))
              {
                e.a(this.ktX);
                AppMethodBeat.o(88338);
                return;
              }
              if (!TextUtils.isEmpty(((oz)localObject).knV))
              {
                com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, ((oz)localObject).knV, 1);
                h.qsU.e(11941, new Object[] { Integer.valueOf(4), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", ((oz)localObject).name });
              }
              AppMethodBeat.o(88338);
              return;
            }
            if (paramView.getId() == 2131822407) {
              e.a(this.ktX);
            }
          }
        }
      }
    }
    AppMethodBeat.o(88338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.4
 * JD-Core Version:    0.7.0.1
 */