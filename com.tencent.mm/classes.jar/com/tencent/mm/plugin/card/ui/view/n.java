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
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
    paramb = paramb.cGs().lmL;
    if (!Util.isNullOrNil(paramb))
    {
      int i = com.tencent.mm.plugin.card.d.l.arR(paramb);
      paramButton.setText(this.tmY.getResources().getString(a.g.tjR));
      paramButton.setTextColor(i);
      paramb = new GradientDrawable();
      paramb.setColor(this.tmY.getResources().getColor(a.a.sZv));
      paramb.setStroke(2, i);
      paramb.setCornerRadius(8.0F);
      paramButton.setBackground(paramb);
    }
    AppMethodBeat.o(113698);
  }
  
  public final void a(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113696);
    am.cHI().cGL();
    paramViewGroup.findViewById(a.d.tfj).setVisibility(0);
    paramViewGroup.findViewById(a.d.tfi).setVisibility(8);
    final acg localacg = paramb.cGt().SdS;
    if (localacg != null)
    {
      paramViewGroup.findViewById(a.d.tfo).setVisibility(0);
      if (!Util.isNullOrNil(localacg.title))
      {
        Button localButton = (Button)paramViewGroup.findViewById(a.d.tfa);
        localButton.setText(localacg.title);
        localButton.setVisibility(0);
        a(localButton, paramb);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113690);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            int i;
            int j;
            if ((!Util.isNullOrNil(localacg.SfC)) && (!Util.isNullOrNil(localacg.SfB))) {
              if (n.this.tmY.getIntent() != null)
              {
                i = n.this.tmY.getIntent().getIntExtra("key_from_scene", 3);
                if (n.this.tmY.getIntent() == null) {
                  break label225;
                }
                j = n.this.tmY.getIntent().getIntExtra("key_from_appbrand_type", 0);
                label123:
                com.tencent.mm.plugin.card.d.b.a(paramb.cGw(), localacg, i, j);
                com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(20), paramb.cGw(), paramb.cGx(), "", localacg.title });
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
              if (!Util.isNullOrNil(localacg.url))
              {
                paramAnonymousView = com.tencent.mm.plugin.card.d.l.Z(localacg.url, localacg.SgR);
                com.tencent.mm.plugin.card.d.b.a(n.this.tmY, paramAnonymousView, 1);
                localObject = com.tencent.mm.plugin.report.service.h.IzE;
                String str1 = paramb.cGw();
                String str2 = paramb.cGx();
                if (localacg.title != null) {}
                for (paramAnonymousView = localacg.title;; paramAnonymousView = "")
                {
                  ((com.tencent.mm.plugin.report.service.h)localObject).a(11941, new Object[] { Integer.valueOf(9), str1, str2, "", paramAnonymousView });
                  break;
                }
              }
              d.a(n.this.tmY, n.this.tmY.getString(a.g.tmj), true);
            }
          }
        });
        if (!Util.isNullOrNil(localacg.tnY)) {
          ((TextView)paramViewGroup.findViewById(a.d.tfc)).setText(localacg.tnY);
        }
        paramViewGroup = (TextView)paramViewGroup.findViewById(a.d.tfn);
        if (!Util.isNullOrNil(localacg.tnZ))
        {
          paramViewGroup.setText(localacg.tnZ);
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
    Log.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
    final View localView1 = paramViewGroup.findViewById(a.d.tfj);
    if (localView1.getVisibility() == 0)
    {
      Log.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
      AppMethodBeat.o(113697);
      return;
    }
    localView1.setVisibility(0);
    Object localObject = paramViewGroup.findViewById(a.d.tfl);
    if (((View)localObject).getVisibility() == 0) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramViewGroup.findViewById(a.d.tfi);
    ((ImageView)localObject).setVisibility(8);
    final View localView2 = paramViewGroup.findViewById(a.d.tfo);
    localView2.setVisibility(0);
    ((TextView)paramViewGroup.findViewById(a.d.tfc)).setText(this.tmY.getResources().getString(a.g.tjQ));
    final Button localButton = (Button)paramViewGroup.findViewById(a.d.tfa);
    localButton.setVisibility(0);
    a(localButton, paramb);
    com.tencent.mm.plugin.card.b.g localg = am.cHI();
    if (paramb == null) {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
    }
    for (;;)
    {
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          localView1.setVisibility(8);
          localView2.setVisibility(8);
          this.tGi.setVisibility(0);
          localButton.setVisibility(8);
          n.this.tFQ.d(c.tGM);
          n.this.d(paramViewGroup, paramb);
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113691);
        }
      });
      AppMethodBeat.o(113697);
      return;
      localg.cGL();
      k localk = am.cHG().arb(paramb.cGw());
      if (localk != null)
      {
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        if (am.cHG().fF(paramb.cGw(), localk.field_code_id)) {
          localg.a(paramb.cGw(), localk.field_code_id, c.tGM);
        } else {
          Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        }
      }
      else
      {
        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
      }
    }
  }
  
  public final void c(ViewGroup paramViewGroup, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113694);
    super.c(paramViewGroup, paramb);
    d(paramViewGroup, paramb);
    AppMethodBeat.o(113694);
  }
  
  public final boolean cKZ()
  {
    return false;
  }
  
  public final boolean cLa()
  {
    return true;
  }
  
  final void d(final ViewGroup paramViewGroup, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113695);
    paramb = paramb.cGs().Sgt;
    View localView = paramViewGroup.findViewById(a.d.tfl);
    if ((paramb != null) && (paramb.Stj))
    {
      localView.setVisibility(0);
      if (!Util.isNullOrNil(paramb.Stk))
      {
        ((TextView)paramViewGroup.findViewById(a.d.tfm)).setText(paramb.Stk);
        ((ImageView)paramViewGroup.findViewById(a.d.tfk)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113689);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = (Button)paramViewGroup.findViewById(a.d.tfa);
            localObject = paramViewGroup.findViewById(a.d.tfj);
            if ((paramAnonymousView.getVisibility() == 0) && (((View)localObject).getVisibility() == 0))
            {
              a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(113689);
              return;
            }
            if (((View)localObject).getVisibility() == 0)
            {
              if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(n.this.tmY.getContext()))
              {
                d.a(n.this.tmY, n.this.tmY.getString(a.g.tkf), false);
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113689);
                return;
              }
              ((View)localObject).setVisibility(8);
              paramViewGroup.findViewById(a.d.tfi).setVisibility(0);
            }
            n.this.tFQ.d(c.tGN);
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
    if (!paramb.cGt().SdT)
    {
      Log.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
      AppMethodBeat.o(113692);
      return false;
    }
    paramb = paramb.cGt().SdS;
    if ((paramb != null) && (!Util.isNullOrNil(paramb.title)))
    {
      Log.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
      AppMethodBeat.o(113692);
      return false;
    }
    AppMethodBeat.o(113692);
    return true;
  }
  
  public final int getLayoutId()
  {
    return a.e.thN;
  }
  
  public final void o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113693);
    paramViewGroup.findViewById(a.d.tfj).setVisibility(8);
    paramViewGroup.findViewById(a.d.tfi).setVisibility(0);
    AppMethodBeat.o(113693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n
 * JD-Core Version:    0.7.0.1
 */