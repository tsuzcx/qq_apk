package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    if ((paramView.getId() == a.d.card_accept_layout) || (paramView.getId() == a.d.card_accept_btn)) {
      if (this.isQ.ikk.azd()) {
        if (this.isQ.isM != null) {
          this.isQ.isM.aBA();
        }
      }
    }
    label62:
    label380:
    label509:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          break label62;
                                          do
                                          {
                                            return;
                                          } while ((!this.isQ.ikk.aze()) || (this.isQ.isM == null));
                                          this.isQ.isM.aBy();
                                          return;
                                          if ((paramView.getId() == a.d.from_username_avatar) || (paramView.getId() == a.d.accept_header_from_username_avatar))
                                          {
                                            com.tencent.mm.plugin.card.d.b.aa(this.isQ.isl, this.isQ.isN.irV);
                                            return;
                                          }
                                          if ((paramView.getId() != a.d.code_qr_area) && (paramView.getId() != a.d.code_bar_area)) {
                                            break label1034;
                                          }
                                          if (paramView.getId() != a.d.code_qr_area) {
                                            break;
                                          }
                                          this.isQ.isF = false;
                                          if ((this.isQ.iss instanceof q))
                                          {
                                            localObject = ((q)this.isQ.iss).e(c.iyU);
                                            this.isQ.isE.iwI = ((String)localObject);
                                          }
                                          localObject = this.isQ.isE;
                                          bool = this.isQ.isF;
                                          ((j)localObject).aCe();
                                          ((j)localObject).isF = bool;
                                        } while ((((j)localObject).fvf == null) || (((j)localObject).fvf.isShowing()));
                                        ((j)localObject).fvf.showAtLocation(paramView.getRootView(), 17, 0, 0);
                                        ((j)localObject).fvf.setFocusable(true);
                                        ((j)localObject).fvf.setTouchable(true);
                                        ((j)localObject).fvf.setBackgroundDrawable(new ColorDrawable(16777215));
                                        ((j)localObject).fvf.setOutsideTouchable(true);
                                        if (((j)localObject).isF)
                                        {
                                          ((j)localObject).iwE.setOnClickListener(((j)localObject).fvj);
                                          paramView = ((j)localObject).iwA;
                                          if (((j)localObject).ipj != null)
                                          {
                                            ((j)localObject).iwA = l.v(((j)localObject).ipj);
                                            ((j)localObject).iwE.setImageBitmap(((j)localObject).iwA);
                                            ((j)localObject).iwH.add(0, paramView);
                                            ((j)localObject).aCg();
                                            ((j)localObject).fvh.setVisibility(8);
                                            ((j)localObject).iwD.setVisibility(0);
                                            paramView = ((j)localObject).ikk.azy().code;
                                            if ((((j)localObject).ikk.azx().sIV != null) && (((j)localObject).ikk.azx().sIV.sRk)) {
                                              break label680;
                                            }
                                            if (bk.bl(((j)localObject).ikk.azy().sHK)) {
                                              break label647;
                                            }
                                            paramView = ((j)localObject).ikk.azy().sHK;
                                            if ((TextUtils.isEmpty(paramView)) || (paramView.length() > 40)) {
                                              break label700;
                                            }
                                            ((j)localObject).iwF.setText(m.yZ(paramView));
                                            if (!((j)localObject).ikk.azn()) {
                                              break label687;
                                            }
                                            ((j)localObject).iwF.setVisibility(0);
                                            if (bk.bl(((j)localObject).ikk.azx().iHC)) {
                                              break label713;
                                            }
                                            ((j)localObject).iwG.setText(((j)localObject).ikk.azx().iHC);
                                            ((j)localObject).iwG.setVisibility(0);
                                          }
                                          for (;;)
                                          {
                                            ((j)localObject).fvf.update();
                                            return;
                                            if (paramView.getId() != a.d.code_bar_area) {
                                              break;
                                            }
                                            this.isQ.isF = true;
                                            break;
                                            ((j)localObject).iwA = null;
                                            break label380;
                                            if (!((j)localObject).ikk.azs()) {
                                              break label509;
                                            }
                                            if (!bk.bl(((j)localObject).iwI))
                                            {
                                              paramView = ((j)localObject).iwI;
                                              break label509;
                                            }
                                            paramView = "";
                                            break label509;
                                            ((j)localObject).iwF.setVisibility(8);
                                            break label559;
                                            ((j)localObject).iwF.setVisibility(8);
                                            break label559;
                                            ((j)localObject).iwG.setVisibility(8);
                                          }
                                        }
                                        ((j)localObject).fvg.setOnClickListener(((j)localObject).fvj);
                                        ((j)localObject).fvg.setImageBitmap(((j)localObject).fve);
                                        paramView = ((j)localObject).ikk.azy().code;
                                        if ((((j)localObject).ikk.azx().sIV == null) || (!((j)localObject).ikk.azx().sIV.sRk)) {
                                          if (!bk.bl(((j)localObject).ikk.azy().sHK))
                                          {
                                            paramView = ((j)localObject).ikk.azy().sHK;
                                            if ((TextUtils.isEmpty(paramView)) || (paramView.length() > 40)) {
                                              break label1008;
                                            }
                                            ((j)localObject).iwB.setText(m.yZ(paramView));
                                            if (!((j)localObject).ikk.azn()) {
                                              break label995;
                                            }
                                            ((j)localObject).iwB.setVisibility(0);
                                            if (TextUtils.isEmpty(((j)localObject).ikk.azx().iHC)) {
                                              break label1021;
                                            }
                                            ((j)localObject).iwC.setText(((j)localObject).ikk.azx().iHC);
                                            ((j)localObject).iwC.setVisibility(0);
                                          }
                                        }
                                        for (;;)
                                        {
                                          ((j)localObject).fvh.setVisibility(0);
                                          ((j)localObject).iwD.setVisibility(8);
                                          break;
                                          if (!((j)localObject).ikk.azs()) {
                                            break label834;
                                          }
                                          if (!bk.bl(((j)localObject).iwI))
                                          {
                                            paramView = ((j)localObject).iwI;
                                            break label834;
                                          }
                                          paramView = "";
                                          break label834;
                                          ((j)localObject).iwB.setVisibility(8);
                                          break label884;
                                          ((j)localObject).iwB.setVisibility(8);
                                          break label884;
                                          ((j)localObject).iwC.setVisibility(8);
                                        }
                                        if ((paramView.getId() != a.d.card_consume_btn) && (paramView.getId() != a.d.card_code_layout) && (paramView.getId() != a.d.card_code_img) && (paramView.getId() != a.d.code_text) && (paramView.getId() != a.d.card_code_click_view)) {
                                          break;
                                        }
                                        if (paramView.getId() == a.d.card_consume_btn)
                                        {
                                          if (this.isQ.ikk.aze())
                                          {
                                            paramView = h.nFQ;
                                            j = this.isQ.ikk.azx().ilo;
                                            localObject = this.isQ.ikk.azC();
                                            str1 = this.isQ.ikk.azB();
                                            k = this.isQ.isN.ipv;
                                            str2 = this.isQ.isN.irV;
                                            if (this.isQ.ikk.azv()) {}
                                            for (i = 1;; i = 0)
                                            {
                                              paramView.f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                                              if (this.isQ.isM == null) {
                                                break;
                                              }
                                              this.isQ.isM.eB(true);
                                              return;
                                            }
                                          }
                                          paramView = new j.b();
                                          this.isQ.a(true, paramView, false);
                                          return;
                                        }
                                      } while ((paramView.getId() == a.d.code_text) && (this.isQ.ikk.azx().sIY));
                                      if (!this.isQ.ikk.aze()) {
                                        break;
                                      }
                                    } while (this.isQ.isM == null);
                                    this.isQ.isM.eB(false);
                                    return;
                                    paramView = new j.b();
                                    this.isQ.a(false, paramView, false);
                                    return;
                                    if (paramView.getId() != a.d.advertise_text) {
                                      break;
                                    }
                                  } while (TextUtils.isEmpty(this.isQ.ikk.azx().sIC));
                                  com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().sIC, 3);
                                  h.nFQ.f(11941, new Object[] { Integer.valueOf(13), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", this.isQ.ikk.azx().sIB });
                                  return;
                                  if (paramView.getId() == a.d.card_private_setting_btn)
                                  {
                                    h.nFQ.f(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(this.isQ.ikk.azx().ilo), this.isQ.ikk.azC(), this.isQ.ikk.azB(), this.isQ.isN.irV });
                                    paramView = new Intent();
                                    paramView.putExtra("KLabel_range_index", this.isQ.ipW);
                                    paramView.putExtra("Klabel_name_list", this.isQ.ipX);
                                    paramView.putExtra("Kother_user_name_list", this.isQ.ipY);
                                    paramView.putExtra("k_sns_label_ui_title", this.isQ.isl.getString(a.g.card_share_card_private_setting_title));
                                    paramView.putExtra("k_sns_label_ui_style", 0);
                                    paramView.putExtra("KLabel_is_filter_private", true);
                                    d.b(this.isQ.isl, "sns", ".ui.SnsLabelUI", paramView, 2);
                                    this.isQ.isl.gJb = this.isQ;
                                    return;
                                  }
                                  if (paramView.getId() != a.d.card_secondary_field_view) {
                                    break;
                                  }
                                } while (this.isQ.ikk.azy().sHy == null);
                                localObject = this.isQ.ikk.azy().sHy;
                                i = ((Integer)paramView.getTag()).intValue();
                                paramView = (ra)((LinkedList)localObject).get(i);
                                if (com.tencent.mm.plugin.card.d.b.a(this.isQ.ikk.azB(), paramView, this.isQ.isN.ipv, this.isQ.isN.isT))
                                {
                                  h.nFQ.f(11941, new Object[] { Integer.valueOf(19), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramView.title });
                                  return;
                                }
                              } while ((paramView == null) || (TextUtils.isEmpty(paramView.url)));
                              com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, paramView.url, 1);
                              localObject = h.nFQ;
                              switch (i)
                              {
                              default: 
                                i = 10;
                              }
                              for (;;)
                              {
                                ((h)localObject).f(11941, new Object[] { Integer.valueOf(i), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramView.title });
                                if (!l.a(paramView, this.isQ.ikk.azB())) {
                                  break;
                                }
                                localObject = this.isQ.ikk.azB();
                                paramView = paramView.title;
                                l.yX((String)localObject);
                                com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().imA);
                                return;
                                i = 10;
                                continue;
                                i = 11;
                                continue;
                                i = 12;
                                continue;
                                i = 16;
                              }
                              if (paramView.getId() != a.d.card_secondary_field_view_1) {
                                break;
                              }
                            } while (this.isQ.ikk.azy().sHy == null);
                            localObject = (ra)this.isQ.ikk.azy().sHy.get(0);
                            if (com.tencent.mm.plugin.card.d.b.a(this.isQ.ikk.azB(), (ra)localObject, this.isQ.isN.ipv, this.isQ.isN.isT))
                            {
                              h.nFQ.f(11941, new Object[] { Integer.valueOf(19), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", ((ra)localObject).title });
                              return;
                            }
                          } while ((localObject == null) || (TextUtils.isEmpty(((ra)localObject).url)));
                          com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, ((ra)localObject).url, 1);
                          h.nFQ.f(11941, new Object[] { Integer.valueOf(10), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", ((ra)localObject).title });
                        } while (!l.a((ra)localObject, this.isQ.ikk.azB()));
                        paramView = this.isQ.ikk.azB();
                        localObject = ((ra)localObject).title;
                        l.yX(paramView);
                        com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().imA);
                        return;
                        if ((paramView.getId() != a.d.card_widget_operate_field_layout) && (paramView.getId() != a.d.card_operate_field_title_tv)) {
                          break;
                        }
                      } while (this.isQ.ikk.azy().sHF == null);
                      if (!this.isQ.ikk.azq()) {
                        break label2590;
                      }
                      if (!this.isQ.ikk.aze()) {
                        break;
                      }
                    } while (this.isQ.isM == null);
                    this.isQ.isM.eB(false);
                    return;
                    paramView = new j.b();
                    this.isQ.a(false, paramView, false);
                    return;
                    if (this.isQ.ikk.azr())
                    {
                      paramView = new j.b();
                      com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, paramView.ild, paramView.ile, false, this.isQ.ikk);
                      return;
                    }
                    paramView = this.isQ.ikk.azy().sHF;
                    if (com.tencent.mm.plugin.card.d.b.a(this.isQ.ikk.azB(), paramView, this.isQ.isN.ipv, this.isQ.isN.isT))
                    {
                      h.nFQ.f(11941, new Object[] { Integer.valueOf(20), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramView.title });
                      return;
                    }
                  } while ((paramView == null) || (TextUtils.isEmpty(paramView.url)));
                  localObject = l.y(paramView.url, paramView.sJq);
                  com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, (String)localObject, 1);
                  h.nFQ.f(11941, new Object[] { Integer.valueOf(9), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramView.title });
                } while (!l.a(paramView, this.isQ.ikk.azB()));
                localObject = this.isQ.ikk.azB();
                paramView = paramView.title;
                l.yX((String)localObject);
                com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().imA);
                return;
                if ((paramView.getId() == a.d.card_detail_field_stub) || (paramView.getId() == a.d.card_ad_title_layout))
                {
                  paramView = this.isQ.ikk.azx().sII;
                  localObject = h.nFQ;
                  j = this.isQ.ikk.azx().ilo;
                  str1 = this.isQ.ikk.azC();
                  str2 = this.isQ.ikk.azB();
                  k = this.isQ.isN.ipv;
                  str3 = this.isQ.isN.irV;
                  if (this.isQ.ikk.azv()) {
                    i = 1;
                  }
                  ((h)localObject).f(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                  if ((paramView != null) && (!TextUtils.isEmpty(paramView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, paramView.url, 1);
                    return;
                  }
                  paramView = new Intent();
                  if ((this.isQ.ikk instanceof CardInfo)) {
                    paramView.putExtra("key_card_info_data", (CardInfo)this.isQ.ikk);
                  }
                  for (;;)
                  {
                    paramView.setClass(this.isQ.isl, CardDetailPreference.class);
                    this.isQ.isl.startActivity(paramView);
                    return;
                    if ((this.isQ.ikk instanceof ShareCardInfo)) {
                      paramView.putExtra("key_card_info_data", (ShareCardInfo)this.isQ.ikk);
                    }
                  }
                }
                if (paramView.getId() != a.d.share_users_top_layout) {
                  break;
                }
              } while (com.tencent.mm.plugin.card.sharecard.a.b.yq(this.isQ.ikk.azC()) <= 1);
              paramView = this.isQ;
              if (!this.isQ.iso) {}
              for (;;)
              {
                paramView.iso = bool;
                this.isQ.aAW();
                return;
                bool = false;
              }
              if (paramView.getId() != a.d.card_annoucement_layout_stub) {
                break;
              }
            } while ((this.isQ.ikk.azx().sIE == null) || (TextUtils.isEmpty(this.isQ.ikk.azx().sIE.url)));
            com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().sIE.url, 3);
            h.nFQ.f(11941, new Object[] { Integer.valueOf(3), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", this.isQ.ikk.azx().sIE.text });
            return;
            if (paramView.getId() != a.d.card_accept_guidance_tv) {
              break;
            }
          } while ((this.isQ.ikk.azx().sIL == null) || (bk.bl(this.isQ.ikk.azx().sIL.url)));
          com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().sIL.url, 1);
          h.nFQ.f(11941, new Object[] { Integer.valueOf(14), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", this.isQ.ikk.azx().sIL.text });
          return;
          if ((paramView.getId() != a.d.shop_poi) && (paramView.getId() != a.d.shop_poi_layout)) {
            break;
          }
        } while (this.isQ.ikk.azx().sIu <= 0);
        if ((this.isQ.ikq == null) || (this.isQ.ikq.size() == 0))
        {
          y.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
          return;
        }
        paramView = (mb)this.isQ.ikq.get(0);
        com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, paramView.bRt, paramView.bTc, paramView.ekZ);
        localObject = h.nFQ;
        int j = this.isQ.ikk.azx().ilo;
        String str1 = this.isQ.ikk.azC();
        String str2 = this.isQ.ikk.azB();
        int k = this.isQ.isN.ipv;
        String str3 = this.isQ.isN.irV;
        if (this.isQ.ikk.azv()) {}
        for (i = 1;; i = 0)
        {
          ((h)localObject).f(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
          h.nFQ.f(11941, new Object[] { Integer.valueOf(5), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramView.name });
          return;
        }
        if (paramView.getId() != a.d.ticket_shop_layout) {
          break;
        }
        if ((this.isQ.ikq == null) || (this.isQ.ikq.size() == 0))
        {
          y.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
          return;
        }
        localObject = (mb)this.isQ.ikq.get(0);
        paramView = (String)paramView.getTag();
        if ((!TextUtils.isEmpty(paramView)) && (paramView.equals(this.isQ.isl.getString(a.g.card_check_all_adapted_stores))))
        {
          e.a(this.isQ);
          return;
        }
      } while (TextUtils.isEmpty(((mb)localObject).ina));
      com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, ((mb)localObject).ina, 1);
      h.nFQ.f(11941, new Object[] { Integer.valueOf(4), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", ((mb)localObject).name });
      return;
    } while (paramView.getId() != a.d.ticket_check_more_adapted_stores);
    label559:
    label700:
    label713:
    label884:
    label1021:
    e.a(this.isQ);
    label647:
    label680:
    label687:
    label834:
    label995:
    label1008:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.4
 * JD-Core Version:    0.7.0.1
 */