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
import com.tencent.mm.plugin.card.c.c;
import com.tencent.mm.plugin.card.c.d;
import com.tencent.mm.plugin.card.mgr.f;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
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
    paramb = paramb.djK().nRQ;
    if (!Util.isNullOrNil(paramb))
    {
      int i = com.tencent.mm.plugin.card.c.l.alv(paramb);
      paramButton.setText(this.wry.getResources().getString(a.g.woo));
      paramButton.setTextColor(i);
      paramb = new GradientDrawable();
      paramb.setColor(this.wry.getResources().getColor(a.a.wdE));
      paramb.setStroke(2, i);
      paramb.setCornerRadius(8.0F);
      paramButton.setBackground(paramb);
    }
    AppMethodBeat.o(113698);
  }
  
  public final void a(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113696);
    am.dkZ().dkc();
    paramViewGroup.findViewById(a.d.wjA).setVisibility(0);
    paramViewGroup.findViewById(a.d.wjz).setVisibility(8);
    final aek localaek = paramb.djL().ZbM;
    if (localaek != null)
    {
      paramViewGroup.findViewById(a.d.wjF).setVisibility(0);
      if (!Util.isNullOrNil(localaek.title))
      {
        Button localButton = (Button)paramViewGroup.findViewById(a.d.wjr);
        localButton.setText(localaek.title);
        localButton.setVisibility(0);
        a(localButton, paramb);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113690);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            int i;
            int j;
            if ((!Util.isNullOrNil(localaek.Zdx)) && (!Util.isNullOrNil(localaek.Zdw))) {
              if (n.this.wry.getIntent() != null)
              {
                i = n.this.wry.getIntent().getIntExtra("key_from_scene", 3);
                if (n.this.wry.getIntent() == null) {
                  break label225;
                }
                j = n.this.wry.getIntent().getIntExtra("key_from_appbrand_type", 0);
                label123:
                com.tencent.mm.plugin.card.c.b.a(paramb.djO(), localaek, i, j);
                com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(20), paramb.djO(), paramb.djP(), "", localaek.title });
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
              if (!Util.isNullOrNil(localaek.url))
              {
                paramAnonymousView = com.tencent.mm.plugin.card.c.l.ad(localaek.url, localaek.ZeU);
                com.tencent.mm.plugin.card.c.b.a(n.this.wry, paramAnonymousView, 1);
                localObject = com.tencent.mm.plugin.report.service.h.OAn;
                String str1 = paramb.djO();
                String str2 = paramb.djP();
                if (localaek.title != null) {}
                for (paramAnonymousView = localaek.title;; paramAnonymousView = "")
                {
                  ((com.tencent.mm.plugin.report.service.h)localObject).b(11941, new Object[] { Integer.valueOf(9), str1, str2, "", paramAnonymousView });
                  break;
                }
              }
              d.a(n.this.wry, n.this.wry.getString(a.g.wqJ), true);
            }
          }
        });
        if (!Util.isNullOrNil(localaek.wsz)) {
          ((TextView)paramViewGroup.findViewById(a.d.wjt)).setText(localaek.wsz);
        }
        paramViewGroup = (TextView)paramViewGroup.findViewById(a.d.wjE);
        if (!Util.isNullOrNil(localaek.wsA))
        {
          paramViewGroup.setText(localaek.wsA);
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
    final View localView1 = paramViewGroup.findViewById(a.d.wjA);
    if (localView1.getVisibility() == 0)
    {
      Log.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
      AppMethodBeat.o(113697);
      return;
    }
    localView1.setVisibility(0);
    Object localObject = paramViewGroup.findViewById(a.d.wjC);
    if (((View)localObject).getVisibility() == 0) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramViewGroup.findViewById(a.d.wjz);
    ((ImageView)localObject).setVisibility(8);
    final View localView2 = paramViewGroup.findViewById(a.d.wjF);
    localView2.setVisibility(0);
    ((TextView)paramViewGroup.findViewById(a.d.wjt)).setText(this.wry.getResources().getString(a.g.won));
    final Button localButton = (Button)paramViewGroup.findViewById(a.d.wjr);
    localButton.setVisibility(0);
    a(localButton, paramb);
    f localf = am.dkZ();
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
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          localView1.setVisibility(8);
          localView2.setVisibility(8);
          this.wJH.setVisibility(0);
          localButton.setVisibility(8);
          n.this.wJp.d(c.wKl);
          n.this.d(paramViewGroup, paramb);
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113691);
        }
      });
      AppMethodBeat.o(113697);
      return;
      localf.dkc();
      k localk = am.dkX().akG(paramb.djO());
      if (localk != null)
      {
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        if (am.dkX().ge(paramb.djO(), localk.field_code_id)) {
          localf.a(paramb.djO(), localk.field_code_id, c.wKl);
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
  
  final void d(final ViewGroup paramViewGroup, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113695);
    paramb = paramb.djK().Zeo;
    View localView = paramViewGroup.findViewById(a.d.wjC);
    if ((paramb != null) && (paramb.Zsx))
    {
      localView.setVisibility(0);
      if (!Util.isNullOrNil(paramb.Zsy))
      {
        ((TextView)paramViewGroup.findViewById(a.d.wjD)).setText(paramb.Zsy);
        ((ImageView)paramViewGroup.findViewById(a.d.wjB)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113689);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = (Button)paramViewGroup.findViewById(a.d.wjr);
            localObject = paramViewGroup.findViewById(a.d.wjA);
            if ((paramAnonymousView.getVisibility() == 0) && (((View)localObject).getVisibility() == 0))
            {
              a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(113689);
              return;
            }
            if (((View)localObject).getVisibility() == 0)
            {
              n.this.wry.getContext();
              if (!com.tencent.mm.plugin.card.c.l.doN())
              {
                d.a(n.this.wry, n.this.wry.getString(a.g.woD), false);
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113689);
                return;
              }
              ((View)localObject).setVisibility(8);
              paramViewGroup.findViewById(a.d.wjz).setVisibility(0);
            }
            n.this.wJp.d(c.wKm);
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
  
  public final boolean doF()
  {
    return false;
  }
  
  public final boolean doG()
  {
    return true;
  }
  
  public final boolean g(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113692);
    if (!paramb.djL().ZbN)
    {
      Log.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
      AppMethodBeat.o(113692);
      return false;
    }
    paramb = paramb.djL().ZbM;
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
    return a.e.wmm;
  }
  
  public final void s(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113693);
    paramViewGroup.findViewById(a.d.wjA).setVisibility(8);
    paramViewGroup.findViewById(a.d.wjz).setVisibility(0);
    AppMethodBeat.o(113693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n
 * JD-Core Version:    0.7.0.1
 */