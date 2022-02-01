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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    paramb = paramb.bTN().hAD;
    if (!bt.isNullOrNil(paramb))
    {
      int i = com.tencent.mm.plugin.card.d.l.Zh(paramb);
      paramButton.setText(this.owO.getResources().getString(2131756813));
      paramButton.setTextColor(i);
      paramb = new GradientDrawable();
      paramb.setColor(this.owO.getResources().getColor(2131100088));
      paramb.setStroke(2, i);
      paramb.setCornerRadius(8.0F);
      paramButton.setBackground(paramb);
    }
    AppMethodBeat.o(113698);
  }
  
  public final void a(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113696);
    am.bVd().bUg();
    paramViewGroup.findViewById(2131298402).setVisibility(0);
    paramViewGroup.findViewById(2131298400).setVisibility(8);
    final aaf localaaf = paramb.bTO().FPD;
    if (localaaf != null)
    {
      paramViewGroup.findViewById(2131298407).setVisibility(0);
      if (!bt.isNullOrNil(localaaf.title))
      {
        Button localButton = (Button)paramViewGroup.findViewById(2131298386);
        localButton.setText(localaaf.title);
        localButton.setVisibility(0);
        a(localButton, paramb);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113690);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            int i;
            int j;
            if ((!bt.isNullOrNil(localaaf.FRl)) && (!bt.isNullOrNil(localaaf.FRk))) {
              if (n.this.owO.getIntent() != null)
              {
                i = n.this.owO.getIntent().getIntExtra("key_from_scene", 3);
                if (n.this.owO.getIntent() == null) {
                  break label225;
                }
                j = n.this.owO.getIntent().getIntExtra("key_from_appbrand_type", 0);
                label123:
                com.tencent.mm.plugin.card.d.b.a(paramb.bTR(), localaaf, i, j);
                com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(20), paramb.bTR(), paramb.bTS(), "", localaaf.title });
              }
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(113690);
              return;
              i = 3;
              break;
              label225:
              j = 0;
              break label123;
              if (!bt.isNullOrNil(localaaf.url))
              {
                paramAnonymousView = com.tencent.mm.plugin.card.d.l.Z(localaaf.url, localaaf.FSA);
                com.tencent.mm.plugin.card.d.b.a(n.this.owO, paramAnonymousView, 1);
                localObject = com.tencent.mm.plugin.report.service.g.yhR;
                String str1 = paramb.bTR();
                String str2 = paramb.bTS();
                if (localaaf.title != null) {}
                for (paramAnonymousView = localaaf.title;; paramAnonymousView = "")
                {
                  ((com.tencent.mm.plugin.report.service.g)localObject).f(11941, new Object[] { Integer.valueOf(9), str1, str2, "", paramAnonymousView });
                  break;
                }
              }
              d.a(n.this.owO, n.this.owO.getString(2131757027), true);
            }
          }
        });
        if (!bt.isNullOrNil(localaaf.oxN)) {
          ((TextView)paramViewGroup.findViewById(2131298388)).setText(localaaf.oxN);
        }
        paramViewGroup = (TextView)paramViewGroup.findViewById(2131298406);
        if (!bt.isNullOrNil(localaaf.oxO))
        {
          paramViewGroup.setText(localaaf.oxO);
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
    ad.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
    final View localView1 = paramViewGroup.findViewById(2131298402);
    if (localView1.getVisibility() == 0)
    {
      ad.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
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
    ((TextView)paramViewGroup.findViewById(2131298388)).setText(this.owO.getResources().getString(2131756812));
    final Button localButton = (Button)paramViewGroup.findViewById(2131298386);
    localButton.setVisibility(0);
    a(localButton, paramb);
    com.tencent.mm.plugin.card.b.g localg = am.bVd();
    if (paramb == null) {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
    }
    for (;;)
    {
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          localView1.setVisibility(8);
          localView2.setVisibility(8);
          this.oOQ.setVisibility(0);
          localButton.setVisibility(8);
          n.this.oOy.d(c.oPu);
          n.this.d(paramViewGroup, paramb);
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113691);
        }
      });
      AppMethodBeat.o(113697);
      return;
      localg.bUg();
      k localk = am.bVb().Ys(paramb.bTR());
      if (localk != null)
      {
        ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        if (am.bVb().eW(paramb.bTR(), localk.field_code_id)) {
          localg.a(paramb.bTR(), localk.field_code_id, c.oPu);
        } else {
          ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        }
      }
      else
      {
        ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
      }
    }
  }
  
  public final boolean bYs()
  {
    return false;
  }
  
  public final boolean bYt()
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
    paramb = paramb.bTN().FSd;
    View localView = paramViewGroup.findViewById(2131298404);
    if ((paramb != null) && (paramb.Gdz))
    {
      localView.setVisibility(0);
      if (!bt.isNullOrNil(paramb.GdA))
      {
        ((TextView)paramViewGroup.findViewById(2131298405)).setText(paramb.GdA);
        ((ImageView)paramViewGroup.findViewById(2131298403)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113689);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = (Button)paramViewGroup.findViewById(2131298386);
            localObject = paramViewGroup.findViewById(2131298402);
            if ((paramAnonymousView.getVisibility() == 0) && (((View)localObject).getVisibility() == 0))
            {
              a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(113689);
              return;
            }
            if (((View)localObject).getVisibility() == 0)
            {
              if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(n.this.owO.getContext()))
              {
                d.a(n.this.owO, n.this.owO.getString(2131756842), false);
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113689);
                return;
              }
              ((View)localObject).setVisibility(8);
              paramViewGroup.findViewById(2131298400).setVisibility(0);
            }
            n.this.oOy.d(c.oPv);
            a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    if (!paramb.bTO().FPE)
    {
      ad.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
      AppMethodBeat.o(113692);
      return false;
    }
    paramb = paramb.bTO().FPD;
    if ((paramb != null) && (!bt.isNullOrNil(paramb.title)))
    {
      ad.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n
 * JD-Core Version:    0.7.0.1
 */