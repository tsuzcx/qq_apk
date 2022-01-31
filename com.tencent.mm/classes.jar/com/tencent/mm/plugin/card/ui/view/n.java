package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class n
  extends h
{
  public n(g paramg, MMActivity paramMMActivity)
  {
    super(paramg, paramMMActivity);
  }
  
  private void a(Button paramButton, b paramb)
  {
    paramb = paramb.azx().color;
    if (!bk.bl(paramb))
    {
      int i = com.tencent.mm.plugin.card.d.l.yR(paramb);
      paramButton.setText(this.hxN.getResources().getString(a.g.card_code_hint_agree));
      paramButton.setTextColor(i);
      paramb = new GradientDrawable();
      paramb.setColor(this.hxN.getResources().getColor(a.a.card_code_default_color));
      paramb.setStroke(2, i);
      paramb.setCornerRadius(8.0F);
      paramButton.setBackground(paramb);
    }
  }
  
  public final void a(ViewGroup paramViewGroup, b paramb)
  {
    am.aAI().azO();
    paramViewGroup.findViewById(a.d.code_qr_disable_layout).setVisibility(0);
    paramViewGroup.findViewById(a.d.code_qr_area).setVisibility(8);
    ra localra = paramb.azy().sHL;
    if (localra != null)
    {
      paramViewGroup.findViewById(a.d.code_shade_layout).setVisibility(0);
      if (!bk.bl(localra.title))
      {
        Button localButton = (Button)paramViewGroup.findViewById(a.d.code_button);
        localButton.setText(localra.title);
        localButton.setVisibility(0);
        a(localButton, paramb);
        localButton.setOnClickListener(new n.2(this, localra, paramb));
        if (!bk.bl(localra.ilq)) {
          ((TextView)paramViewGroup.findViewById(a.d.code_first_title)).setText(localra.ilq);
        }
        paramViewGroup = (TextView)paramViewGroup.findViewById(a.d.code_second_title);
        if (bk.bl(localra.ilr)) {
          break label175;
        }
        paramViewGroup.setText(localra.ilr);
        paramViewGroup.setVisibility(0);
      }
    }
    return;
    label175:
    paramViewGroup.setVisibility(8);
  }
  
  public final boolean aCV()
  {
    return false;
  }
  
  public final boolean aCW()
  {
    return true;
  }
  
  public final void b(ViewGroup paramViewGroup, b paramb)
  {
    y.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
    View localView1 = paramViewGroup.findViewById(a.d.code_qr_disable_layout);
    if (localView1.getVisibility() == 0)
    {
      y.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
      return;
    }
    localView1.setVisibility(0);
    Object localObject = paramViewGroup.findViewById(a.d.code_refresh_layout);
    if (((View)localObject).getVisibility() == 0) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramViewGroup.findViewById(a.d.code_qr_area);
    ((ImageView)localObject).setVisibility(8);
    View localView2 = paramViewGroup.findViewById(a.d.code_shade_layout);
    localView2.setVisibility(0);
    ((TextView)paramViewGroup.findViewById(a.d.code_first_title)).setText(this.hxN.getResources().getString(a.g.card_code_hint));
    Button localButton = (Button)paramViewGroup.findViewById(a.d.code_button);
    localButton.setVisibility(0);
    a(localButton, paramb);
    com.tencent.mm.plugin.card.b.g localg = am.aAI();
    if (paramb == null) {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
    }
    for (;;)
    {
      localButton.setOnClickListener(new n.3(this, localView1, localView2, (ImageView)localObject, localButton, paramViewGroup, paramb));
      return;
      localg.azO();
      k localk = am.aAG().ym(paramb.azB());
      if (localk != null)
      {
        y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        if (am.aAG().cs(paramb.azB(), localk.field_code_id)) {
          localg.a(paramb.azB(), localk.field_code_id, c.iyT);
        } else {
          y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        }
      }
      else
      {
        y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
      }
    }
  }
  
  public final void c(ViewGroup paramViewGroup, b paramb)
  {
    super.c(paramViewGroup, paramb);
    d(paramViewGroup, paramb);
  }
  
  final void d(ViewGroup paramViewGroup, b paramb)
  {
    paramb = paramb.azx().sIV;
    View localView = paramViewGroup.findViewById(a.d.code_refresh_layout);
    if ((paramb != null) && (paramb.sRl))
    {
      localView.setVisibility(0);
      if (!bk.bl(paramb.sRm))
      {
        ((TextView)paramViewGroup.findViewById(a.d.code_refresh_tv)).setText(paramb.sRm);
        ((ImageView)paramViewGroup.findViewById(a.d.code_refresh_icon)).setOnClickListener(new n.1(this, paramViewGroup));
      }
      return;
    }
    localView.setVisibility(8);
  }
  
  public final boolean g(b paramb)
  {
    if (!paramb.azy().sHM)
    {
      y.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
      return false;
    }
    paramb = paramb.azy().sHL;
    if ((paramb != null) && (!bk.bl(paramb.title)))
    {
      y.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
      return false;
    }
    return true;
  }
  
  public final int getLayoutId()
  {
    return a.e.card_code_dynamic_qrcode;
  }
  
  public final void k(ViewGroup paramViewGroup)
  {
    paramViewGroup.findViewById(a.d.code_qr_disable_layout).setVisibility(8);
    paramViewGroup.findViewById(a.d.code_qr_area).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n
 * JD-Core Version:    0.7.0.1
 */