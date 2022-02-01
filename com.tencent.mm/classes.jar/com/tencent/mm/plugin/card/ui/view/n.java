package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class n
  extends h
{
  public n(g paramg, MMActivity paramMMActivity)
  {
    super(paramg, paramMMActivity);
  }
  
  private void a(Button paramButton, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113698);
    paramb = paramb.bPi().hiu;
    if (!bs.isNullOrNil(paramb))
    {
      int i = com.tencent.mm.plugin.card.d.l.Vy(paramb);
      paramButton.setText(this.nTt.getResources().getString(2131756813));
      paramButton.setTextColor(i);
      paramb = new GradientDrawable();
      paramb.setColor(this.nTt.getResources().getColor(2131100088));
      paramb.setStroke(2, i);
      paramb.setCornerRadius(8.0F);
      paramButton.setBackground(paramb);
    }
    AppMethodBeat.o(113698);
  }
  
  public final void a(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113696);
    am.bQy().bPB();
    paramViewGroup.findViewById(2131298402).setVisibility(0);
    paramViewGroup.findViewById(2131298400).setVisibility(8);
    final yg localyg = paramb.bPj().Eit;
    if (localyg != null)
    {
      paramViewGroup.findViewById(2131298407).setVisibility(0);
      if (!bs.isNullOrNil(localyg.title))
      {
        Button localButton = (Button)paramViewGroup.findViewById(2131298386);
        localButton.setText(localyg.title);
        localButton.setVisibility(0);
        a(localButton, paramb);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113690);
            if ((!bs.isNullOrNil(localyg.Ekc)) && (!bs.isNullOrNil(localyg.Ekb)))
            {
              int i;
              if (n.this.nTt.getIntent() != null)
              {
                i = n.this.nTt.getIntent().getIntExtra("key_from_scene", 3);
                if (n.this.nTt.getIntent() == null) {
                  break label181;
                }
              }
              label181:
              for (int j = n.this.nTt.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
              {
                com.tencent.mm.plugin.card.d.b.a(paramb.bPm(), localyg, i, j);
                com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(20), paramb.bPm(), paramb.bPn(), "", localyg.title });
                AppMethodBeat.o(113690);
                return;
                i = 3;
                break;
              }
            }
            if (!bs.isNullOrNil(localyg.url))
            {
              paramAnonymousView = com.tencent.mm.plugin.card.d.l.S(localyg.url, localyg.Els);
              com.tencent.mm.plugin.card.d.b.a(n.this.nTt, paramAnonymousView, 1);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
              String str1 = paramb.bPm();
              String str2 = paramb.bPn();
              if (localyg.title != null) {}
              for (paramAnonymousView = localyg.title;; paramAnonymousView = "")
              {
                localh.f(11941, new Object[] { Integer.valueOf(9), str1, str2, "", paramAnonymousView });
                AppMethodBeat.o(113690);
                return;
              }
            }
            d.a(n.this.nTt, n.this.nTt.getString(2131757027), true);
            AppMethodBeat.o(113690);
          }
        });
        if (!bs.isNullOrNil(localyg.nUs)) {
          ((TextView)paramViewGroup.findViewById(2131298388)).setText(localyg.nUs);
        }
        paramViewGroup = (TextView)paramViewGroup.findViewById(2131298406);
        if (!bs.isNullOrNil(localyg.nUt))
        {
          paramViewGroup.setText(localyg.nUt);
          paramViewGroup.setVisibility(0);
          AppMethodBeat.o(113696);
          return;
        }
        paramViewGroup.setVisibility(8);
      }
    }
    AppMethodBeat.o(113696);
  }
  
  public final void b(final ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113697);
    ac.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
    final View localView1 = paramViewGroup.findViewById(2131298402);
    if (localView1.getVisibility() == 0)
    {
      ac.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
      AppMethodBeat.o(113697);
      return;
    }
    localView1.setVisibility(0);
    Object localObject = paramViewGroup.findViewById(2131298404);
    if (((View)localObject).getVisibility() == 0) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramViewGroup.findViewById(2131298400);
    ((ImageView)localObject).setVisibility(8);
    final View localView2 = paramViewGroup.findViewById(2131298407);
    localView2.setVisibility(0);
    ((TextView)paramViewGroup.findViewById(2131298388)).setText(this.nTt.getResources().getString(2131756812));
    final Button localButton = (Button)paramViewGroup.findViewById(2131298386);
    localButton.setVisibility(0);
    a(localButton, paramb);
    com.tencent.mm.plugin.card.b.g localg = am.bQy();
    if (paramb == null) {
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
    }
    for (;;)
    {
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113691);
          localView1.setVisibility(8);
          localView2.setVisibility(8);
          this.olv.setVisibility(0);
          localButton.setVisibility(8);
          n.this.old.d(c.olZ);
          n.this.d(paramViewGroup, paramb);
          AppMethodBeat.o(113691);
        }
      });
      AppMethodBeat.o(113697);
      return;
      localg.bPB();
      k localk = am.bQw().UJ(paramb.bPm());
      if (localk != null)
      {
        ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        if (am.bQw().eM(paramb.bPm(), localk.field_code_id)) {
          localg.a(paramb.bPm(), localk.field_code_id, c.olZ);
        } else {
          ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        }
      }
      else
      {
        ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
      }
    }
  }
  
  public final boolean bTN()
  {
    return false;
  }
  
  public final boolean bTO()
  {
    return true;
  }
  
  public final void c(ViewGroup paramViewGroup, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113694);
    super.c(paramViewGroup, paramb);
    d(paramViewGroup, paramb);
    AppMethodBeat.o(113694);
  }
  
  final void d(final ViewGroup paramViewGroup, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113695);
    paramb = paramb.bPi().EkU;
    View localView = paramViewGroup.findViewById(2131298404);
    if ((paramb != null) && (paramb.Ewd))
    {
      localView.setVisibility(0);
      if (!bs.isNullOrNil(paramb.Ewe))
      {
        ((TextView)paramViewGroup.findViewById(2131298405)).setText(paramb.Ewe);
        ((ImageView)paramViewGroup.findViewById(2131298403)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113689);
            paramAnonymousView = (Button)paramViewGroup.findViewById(2131298386);
            View localView = paramViewGroup.findViewById(2131298402);
            if ((paramAnonymousView.getVisibility() == 0) && (localView.getVisibility() == 0))
            {
              AppMethodBeat.o(113689);
              return;
            }
            if (localView.getVisibility() == 0)
            {
              if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(n.this.nTt.getContext()))
              {
                d.a(n.this.nTt, n.this.nTt.getString(2131756842), false);
                AppMethodBeat.o(113689);
                return;
              }
              localView.setVisibility(8);
              paramViewGroup.findViewById(2131298400).setVisibility(0);
            }
            n.this.old.d(c.oma);
            AppMethodBeat.o(113689);
          }
        });
        AppMethodBeat.o(113695);
      }
    }
    else
    {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(113695);
  }
  
  public final boolean g(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113692);
    if (!paramb.bPj().Eiu)
    {
      ac.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
      AppMethodBeat.o(113692);
      return false;
    }
    paramb = paramb.bPj().Eit;
    if ((paramb != null) && (!bs.isNullOrNil(paramb.title)))
    {
      ac.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
      AppMethodBeat.o(113692);
      return false;
    }
    AppMethodBeat.o(113692);
    return true;
  }
  
  public final int getLayoutId()
  {
    return 2131493258;
  }
  
  public final void n(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113693);
    paramViewGroup.findViewById(2131298402).setVisibility(8);
    paramViewGroup.findViewById(2131298400).setVisibility(0);
    AppMethodBeat.o(113693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n
 * JD-Core Version:    0.7.0.1
 */