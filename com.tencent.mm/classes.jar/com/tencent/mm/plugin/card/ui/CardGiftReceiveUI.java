package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends DrawStatusBarActivity
  implements View.OnClickListener, f
{
  private int dRO;
  private String dRP;
  private ScrollView itI;
  private LinearLayout itJ;
  private ImageView itK;
  private TextView itL;
  private TextView itM;
  private ImageView itN;
  private ImageView itO;
  private LinearLayout itP;
  private RelativeLayout itQ;
  private RelativeLayout itR;
  private TextView itS;
  private ImageView itT;
  private TextView itU;
  private TextView itV;
  private TextView itW;
  private ImageView itX;
  private ImageView itY;
  private View itZ;
  private CardGiftInfo its;
  private ProgressBar itw;
  private ah itx = new ah(Looper.getMainLooper());
  private TextView iua;
  private LinearLayout iub;
  private ListView iuc;
  private RelativeLayout iud;
  private LinearLayout iue;
  private ImageView iuf;
  private TextView iug;
  private LinearLayout iuh;
  private TextView iui;
  private RelativeLayout iuj;
  private RelativeLayout iuk;
  private ImageView iul;
  private ImageView ium;
  private TextView iun;
  private TextView iuo;
  private ListView iup;
  private RelativeLayout iuq;
  private TextView iur;
  private TextView ius;
  private View iut;
  com.tencent.mm.plugin.card.d.a.a iuu = new CardGiftReceiveUI.4(this);
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void L(LinkedList<CardGiftInfo.AcceptedCardItem> paramLinkedList)
  {
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)paramLinkedList.next();
      View localView = View.inflate(this, a.e.card_gift_accepter_card_item, null);
      TextView localTextView1 = (TextView)localView.findViewById(a.d.tv_card_title);
      TextView localTextView2 = (TextView)localView.findViewById(a.d.tv_card_price);
      localTextView1.setText(localAcceptedCardItem.imo);
      localTextView2.setText(localAcceptedCardItem.imp + this.mController.uMN.getString(a.g.card_gift_price_rmb_uint));
      this.iub.addView(localView);
    }
  }
  
  private int M(int paramInt)
  {
    return com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, paramInt);
  }
  
  private void aAW()
  {
    if (this.its == null)
    {
      y.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      return;
    }
    y.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.its.ilX) });
    Object localObject;
    if ((this.its.ilX != 1) && (this.its.ilX == 2))
    {
      this.itP.setVisibility(8);
      this.itJ.setVisibility(0);
      this.itL.setText(this.its.ilV);
      this.itM.setText(this.its.ilO + "     " + this.its.ilP + this.mController.uMN.getString(a.g.card_gift_price_rmb_uint));
      if (!bk.bl(this.its.ilW))
      {
        this.itK.setVisibility(0);
        localObject = new c.a();
        ((c.a)localObject).eri = e.bkH;
        com.tencent.mm.as.o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.its.ilW);
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erd = true;
        localObject = ((c.a)localObject).OV();
        com.tencent.mm.as.o.ON().a(this.its.ilW, this.itK, (c)localObject);
        if (bk.bl(this.its.ilZ)) {
          break label769;
        }
        this.itL.setTextColor(bk.bq(this.its.ilZ, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
        label287:
        if (bk.bl(this.its.ima)) {
          break label781;
        }
        this.itM.setTextColor(bk.bq(this.its.ima, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
        label327:
        if (bk.bl(this.its.ilN)) {
          break label793;
        }
        localObject = new c.a();
        ((c.a)localObject).eri = e.bkH;
        com.tencent.mm.as.o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.its.ilN);
        ((c.a)localObject).erD = true;
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erd = true;
        ((c.a)localObject).erv = new ColorDrawable(l.yR("#CCCCCC"));
        localObject = ((c.a)localObject).OV();
        com.tencent.mm.as.o.ON().a(this.its.ilN, this.itO, (c)localObject);
        label433:
        if (bk.bl(this.its.ilM)) {
          break label805;
        }
        localObject = new c.a();
        ((c.a)localObject).eri = e.bkH;
        com.tencent.mm.as.o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.its.ilM);
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erd = true;
        ((c.a)localObject).erv = new ColorDrawable(l.yR("#CCCCCC"));
        ((c.a)localObject).erD = true;
        ((c.a)localObject).erE = com.tencent.mm.cb.a.fromDPToPix(this, 8);
        localObject = ((c.a)localObject).OV();
        com.tencent.mm.as.o.ON().a(this.its.ilM, this.itN, (c)localObject);
        label550:
        if (this.its.iml != 1) {
          break label1570;
        }
        this.iue.setVisibility(0);
        this.iuh.setVisibility(8);
        this.iud.setVisibility(8);
        this.iug.setText(j.a(this, this.its.bXl, this.iug.getTextSize()));
        d(this.iuf);
        label620:
        aBh();
        if (this.its.imj.size() <= 0) {
          break label1870;
        }
        this.iuq.setVisibility(0);
        this.iup.setVisibility(0);
        localObject = new CardGiftReceiveUI.a(this);
        this.iup.setAdapter((ListAdapter)localObject);
        b(this.iup);
        if (!bk.bl(this.its.imk))
        {
          this.iuo.setVisibility(0);
          this.iuo.setText(this.its.imk);
        }
      }
    }
    for (;;)
    {
      if ((bk.bl(this.its.imd)) && (bk.bl(this.its.ilQ))) {
        break label1932;
      }
      this.itI.getViewTreeObserver().addOnGlobalLayoutListener(new CardGiftReceiveUI.1(this));
      return;
      this.itK.setVisibility(8);
      break;
      label769:
      y.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label287;
      label781:
      y.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label327;
      label793:
      y.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
      break label433;
      label805:
      y.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
      break label550;
      this.itJ.setVisibility(8);
      this.itP.setVisibility(0);
      this.itU.setText(this.its.ilO);
      if (this.its.iml == 1)
      {
        this.itX.setAlpha(0.5F);
        this.itV.setVisibility(8);
        this.itW.setVisibility(8);
        this.itR.setVisibility(8);
        this.itQ.setVisibility(8);
        label905:
        if (bk.bl(this.its.ilW)) {
          break label1480;
        }
        this.itT.setVisibility(0);
        localObject = new c.a();
        ((c.a)localObject).eri = e.bkH;
        com.tencent.mm.as.o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.its.ilW);
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erd = true;
        localObject = ((c.a)localObject).OV();
        com.tencent.mm.as.o.ON().a(this.its.ilW, this.itT, (c)localObject);
        label997:
        if (bk.bl(this.its.ilV)) {
          break label1513;
        }
        this.itS.setVisibility(0);
        this.itS.setText(this.its.ilV);
        if (bk.bl(this.its.ilZ)) {
          break label1501;
        }
        this.itS.setTextColor(bk.bq(this.its.ilZ, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
        label1072:
        if (bk.bl(this.its.ima)) {
          break label1534;
        }
        this.itU.setTextColor(bk.bq(this.its.ima, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
        label1112:
        if (bk.bl(this.its.ilN)) {
          break label1546;
        }
        localObject = new c.a();
        ((c.a)localObject).eri = e.bkH;
        com.tencent.mm.as.o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.its.ilN);
        ((c.a)localObject).erD = true;
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erd = true;
        ((c.a)localObject).erv = new ColorDrawable(l.yR("#CCCCCC"));
        localObject = ((c.a)localObject).OV();
        com.tencent.mm.as.o.ON().a(this.its.ilN, this.itY, (c)localObject);
      }
      for (;;)
      {
        if (bk.bl(this.its.ilM)) {
          break label1558;
        }
        localObject = new c.a();
        ((c.a)localObject).eri = e.bkH;
        com.tencent.mm.as.o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.its.ilM);
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erd = true;
        ((c.a)localObject).erv = new ColorDrawable(l.yR("#CCCCCC"));
        ((c.a)localObject).erD = true;
        ((c.a)localObject).erE = com.tencent.mm.cb.a.fromDPToPix(this, 8);
        localObject = ((c.a)localObject).OV();
        com.tencent.mm.as.o.ON().a(this.its.ilM, this.itX, (c)localObject);
        break;
        this.itV.setVisibility(0);
        this.itW.setVisibility(0);
        this.itR.setVisibility(0);
        this.itQ.setVisibility(0);
        this.itV.setText(this.its.ilP);
        this.itW.setText(a.g.card_gift_price_rmb_uint);
        if (bk.bl(this.its.ilP))
        {
          this.itV.setVisibility(8);
          this.itW.setVisibility(8);
        }
        if (!bk.bl(this.its.imb))
        {
          this.itV.setTextColor(bk.bq(this.its.imb, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
          break label905;
        }
        y.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
        break label905;
        label1480:
        this.itT.setVisibility(8);
        y.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        break label997;
        label1501:
        y.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
        break label1072;
        label1513:
        this.itS.setVisibility(8);
        y.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        break label1072;
        label1534:
        y.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
        break label1112;
        label1546:
        y.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
      }
      label1558:
      y.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
      break label550;
      label1570:
      this.iue.setVisibility(8);
      this.iuh.setVisibility(0);
      this.iud.setVisibility(0);
      d(this.ium);
      this.iun.setText(j.a(this, this.its.bXl, this.iun.getTextSize()));
      if (((!bk.bl(this.its.ilG)) && (!"undefined".equals(this.its.ilG))) || ((!bk.bl(this.its.ilH)) && (!"undefined".equals(this.its.ilH))))
      {
        this.iuj.setVisibility(0);
        label1694:
        if ((this.its == null) || (bk.bl(this.its.ilG))) {
          break label1846;
        }
        com.tencent.mm.plugin.card.d.a.g(this.its.ilG, this.its.ilJ, this.its.ilS, 2);
        label1739:
        if ((this.its == null) || (bk.bl(this.its.ilI))) {
          break label1858;
        }
        com.tencent.mm.plugin.card.d.a.g(this.its.ilI, this.its.ilL, this.its.ilU, 2);
      }
      for (;;)
      {
        if (bk.bl(this.its.ilF)) {
          break label1868;
        }
        this.iui.setText(j.a(this, this.its.ilF, this.iui.getTextSize()));
        break;
        this.iuj.setVisibility(8);
        y.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
        break label1694;
        label1846:
        y.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
        break label1739;
        label1858:
        y.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
      }
      label1868:
      break label620;
      label1870:
      this.iuq.setVisibility(0);
      this.iup.setVisibility(0);
      this.iuo.setVisibility(0);
      if (!bk.bl(this.its.imk))
      {
        this.iuo.setVisibility(0);
        this.iuo.setText(this.its.imk);
      }
    }
    label1932:
    this.itI.setFillViewport(true);
  }
  
  private void aBh()
  {
    int i = 0;
    if (this.its.imi.size() > 0)
    {
      this.itZ.setVisibility(0);
      this.iuc.setVisibility(8);
      if (this.its.imi.size() <= 2)
      {
        this.iua.setVisibility(8);
        L(this.its.imi);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.its.imi.get(0));
      ((LinkedList)localObject).add(this.its.imi.get(1));
      L((LinkedList)localObject);
      this.iua.setVisibility(0);
      this.iua.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.its.imi.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.its.imi.get(i));
        }
        i += 1;
      }
      localObject = new CardGiftReceiveUI.c(this, (LinkedList)localObject);
      this.iuc.setAdapter((ListAdapter)localObject);
      b(this.iuc);
      return;
    }
    this.itZ.setVisibility(8);
    this.iua.setVisibility(8);
    this.iuc.setVisibility(8);
  }
  
  private static void b(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int k = localListAdapter.getCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localObject = localListAdapter.getView(i, null, paramListView);
      ((View)localObject).measure(0, 0);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void d(ImageView paramImageView)
  {
    if (!bk.bl(this.its.ilE))
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).eri = e.bkH;
      com.tencent.mm.as.o.OO();
      ((c.a)localObject).erB = null;
      ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.its.ilE);
      ((c.a)localObject).erf = true;
      ((c.a)localObject).erD = true;
      ((c.a)localObject).erE = 3.0F;
      ((c.a)localObject).erd = true;
      ((c.a)localObject).erm = i;
      ((c.a)localObject).erl = i;
      ((c.a)localObject).erv = new ColorDrawable(l.yR("#CCCCCC"));
      localObject = ((c.a)localObject).OV();
      com.tencent.mm.as.o.ON().a(this.its.ilE, paramImageView, (c)localObject);
      return;
    }
    y.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_gift_receive_ui_new;
  }
  
  protected final void initView()
  {
    this.itI = ((ScrollView)findViewById(a.d.card_git_receive_root));
    this.itJ = ((LinearLayout)findViewById(a.d.card_title_sender_layout));
    this.itK = ((ImageView)findViewById(a.d.iv_sender_icon));
    this.itL = ((TextView)findViewById(a.d.tv_sender_title));
    this.itM = ((TextView)findViewById(a.d.tv_sender_price));
    this.itN = ((ImageView)findViewById(a.d.iv_sender_gift_card));
    this.itO = ((ImageView)findViewById(a.d.iv_sender_gift_logo));
    this.itN.setOnClickListener(this);
    this.itP = ((LinearLayout)findViewById(a.d.card_title_layout_2));
    this.itQ = ((RelativeLayout)findViewById(a.d.bg_left_layout));
    this.itR = ((RelativeLayout)findViewById(a.d.bg_right_layout));
    this.itS = ((TextView)findViewById(a.d.tv_desc_title));
    this.itU = ((TextView)findViewById(a.d.tv_second_title));
    this.itT = ((ImageView)findViewById(a.d.iv_second_icon));
    this.itV = ((TextView)findViewById(a.d.tv_third_title));
    this.itW = ((TextView)findViewById(a.d.tv_third_title_unit));
    this.itX = ((ImageView)findViewById(a.d.iv_gift_card));
    this.itY = ((ImageView)findViewById(a.d.iv_gift_card_logo));
    this.itX.setOnClickListener(this);
    this.itZ = findViewById(a.d.card_list_separate_line);
    this.iua = ((TextView)findViewById(a.d.tv_show_all));
    this.iub = ((LinearLayout)findViewById(a.d.card_list_layout));
    this.iuc = ((ListView)findViewById(a.d.card_list_view));
    this.iud = ((RelativeLayout)findViewById(a.d.card_gift_content_bg_layout));
    this.iue = ((LinearLayout)findViewById(a.d.give_small_layout));
    this.iuf = ((ImageView)findViewById(a.d.iv_give_avatar_small));
    this.iug = ((TextView)findViewById(a.d.tv_give_name_small));
    this.iuh = ((LinearLayout)findViewById(a.d.give_layout));
    this.ium = ((ImageView)findViewById(a.d.iv_give_avatar));
    this.iun = ((TextView)findViewById(a.d.tv_give_name));
    this.iui = ((TextView)findViewById(a.d.tv_give_content));
    this.iuj = ((RelativeLayout)findViewById(a.d.card_img_layout));
    this.iuk = ((RelativeLayout)findViewById(a.d.img_video));
    this.iul = ((ImageView)findViewById(a.d.tv_img));
    this.iuj.setOnClickListener(this);
    this.iuk.setOnClickListener(this);
    this.iuo = ((TextView)findViewById(a.d.tv_accepter_list_title));
    this.iup = ((ListView)findViewById(a.d.accepter_list_view));
    this.iuq = ((RelativeLayout)findViewById(a.d.card_gift_accpeter_layout));
    this.itw = ((ProgressBar)findViewById(a.d.image_loading));
    com.tencent.mm.plugin.card.d.m.c(this);
    com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
    setMMTitle("");
    setBackBtn(new CardGiftReceiveUI.2(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == a.d.img_video) {
      if (!bk.bl(this.its.ilH))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.its);
        paramView.putExtra("key_is_mute", false);
        startActivity(paramView);
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(3), this.dRP, com.tencent.mm.a.o.getString(this.dRO) });
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramView.getId() != a.d.card_img_layout) {
              break;
            }
          } while ((this.itw.getVisibility() == 0) || (bk.bl(this.its.ilG)));
          paramView = new Intent(this, CardGiftImageUI.class);
          paramView.putExtra("key_gift_into", this.its);
          startActivity(paramView);
          overridePendingTransition(0, 0);
          com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(4), this.dRP, com.tencent.mm.a.o.getString(this.dRO) });
          return;
          if (paramView.getId() != a.d.tv_gift_card_footer) {
            break;
          }
        } while ((this.its == null) || (!this.its.ilR));
        com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(7), this.dRP, com.tencent.mm.a.o.getString(this.dRO) });
        paramView = new Intent(this, CardHomePageUI.class);
        paramView.putExtra("key_home_page_from_scene", 2);
        startActivity(paramView);
        y.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
        finish();
        overridePendingTransition(0, 0);
        return;
        if (paramView.getId() != a.d.tv_gift_card_operate) {
          break;
        }
        if ((!TextUtils.isEmpty(this.its.imm)) && (!TextUtils.isEmpty(this.its.imn)))
        {
          int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
          com.tencent.mm.plugin.card.d.b.d(this.its.imc, this.its.imm, this.its.imn, 1062, i);
          com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(8), this.dRP, com.tencent.mm.a.o.getString(this.dRO) });
          return;
        }
      } while (bk.bl(this.its.ime));
      com.tencent.mm.plugin.card.d.b.a(this, this.its.ime, 0);
      com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(8), this.dRP, com.tencent.mm.a.o.getString(this.dRO) });
      return;
      if ((paramView.getId() == a.d.iv_gift_card) || (paramView.getId() == a.d.iv_sender_gift_card))
      {
        if ((!bk.bl(this.its.imf)) && (!bk.bl(this.its.imh)))
        {
          paramView = new LinkedList();
          Object localObject = new mh();
          ((mh)localObject).iln = this.its.imf;
          ((mh)localObject).code = this.its.imh;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          bvk localbvk = new bvk();
          localbvk.tMg = ((String)localObject);
          y.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new t(paramView, localbvk, 27);
          g.DO().dJT.a(paramView, 0);
          com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(9), this.dRP, com.tencent.mm.a.o.getString(this.dRO) });
          return;
        }
        y.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        return;
      }
    } while (paramView.getId() != a.d.tv_show_all);
    if (this.iuc.getVisibility() == 0)
    {
      this.iuc.setVisibility(8);
      this.iua.setText("查看全部");
      return;
    }
    this.iuc.setVisibility(0);
    this.iua.setText("收起");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dRP = getIntent().getStringExtra("key_order_id");
    this.dRO = getIntent().getIntExtra("key_biz_uin", -1);
    this.its = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    y.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.dRP, Integer.valueOf(this.dRO) });
    initView();
    g.DO().dJT.a(1165, this);
    g.DO().dJT.a(699, this);
    com.tencent.mm.plugin.card.d.a.a(this.iuu);
    if (this.its == null)
    {
      y.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.dRO == -1) {
        y.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
      }
      do
      {
        return;
        if (this.dRP == null) {
          y.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
        }
        y.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
        paramBundle = new z(this.dRO, this.dRP);
        g.DO().dJT.a(paramBundle, 0);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(a.g.loading_tips), true, new CardGiftReceiveUI.3(this));
      } while (this.tipDialog == null);
      this.tipDialog.show();
      return;
    }
    aAW();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g.DO().dJT.b(1165, this);
    g.DO().dJT.b(699, this);
    com.tencent.mm.plugin.card.d.a.b(this.iuu);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof z))
      {
        y.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
        this.its = ((z)paramm).inq;
        aAW();
      }
    }
    do
    {
      do
      {
        return;
      } while (!(paramm instanceof t));
      paramString = new Intent(this, CardDetailUI.class);
      Object localObject = ((t)paramm).inv;
      if ((localObject == null) || (((LinkedList)localObject).size() == 0))
      {
        y.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
        return;
      }
      paramm = (com.tencent.mm.plugin.card.base.b)((LinkedList)localObject).get(0);
      if ((paramm == null) || (!(paramm instanceof CardInfo)))
      {
        y.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((CardInfo)((Iterator)localObject).next());
      }
      paramString.putExtra("key_card_info", (CardInfo)paramm);
      paramString.putExtra("key_previous_scene", 27);
      paramString.putExtra("key_from_scene", 27);
      paramString.putExtra("key_from_appbrand_type", paramString.getIntExtra("key_from_appbrand_type", 0));
      paramString.putExtra("key_card_git_info", this.its);
      startActivity(paramString);
      return;
      if ((paramm instanceof z))
      {
        y.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        return;
      }
    } while (!(paramm instanceof t));
    y.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */