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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
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
    paramb = paramb.csQ().ixw;
    if (!Util.isNullOrNil(paramb))
    {
      int i = com.tencent.mm.plugin.card.d.l.ake(paramb);
      paramButton.setText(this.pQZ.getResources().getString(2131756978));
      paramButton.setTextColor(i);
      paramb = new GradientDrawable();
      paramb.setColor(this.pQZ.getResources().getColor(2131100119));
      paramb.setStroke(2, i);
      paramb.setCornerRadius(8.0F);
      paramButton.setBackground(paramb);
    }
    AppMethodBeat.o(113698);
  }
  
  public final void a(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113696);
    am.cug().ctj();
    paramViewGroup.findViewById(2131298811).setVisibility(0);
    paramViewGroup.findViewById(2131298809).setVisibility(8);
    final abz localabz = paramb.csR().LcF;
    if (localabz != null)
    {
      paramViewGroup.findViewById(2131298816).setVisibility(0);
      if (!Util.isNullOrNil(localabz.title))
      {
        Button localButton = (Button)paramViewGroup.findViewById(2131298795);
        localButton.setText(localabz.title);
        localButton.setVisibility(0);
        a(localButton, paramb);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113690);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            int i;
            int j;
            if ((!Util.isNullOrNil(localabz.Lep)) && (!Util.isNullOrNil(localabz.Leo))) {
              if (n.this.pQZ.getIntent() != null)
              {
                i = n.this.pQZ.getIntent().getIntExtra("key_from_scene", 3);
                if (n.this.pQZ.getIntent() == null) {
                  break label225;
                }
                j = n.this.pQZ.getIntent().getIntExtra("key_from_appbrand_type", 0);
                label123:
                com.tencent.mm.plugin.card.d.b.a(paramb.csU(), localabz, i, j);
                com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(20), paramb.csU(), paramb.csV(), "", localabz.title });
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
              if (!Util.isNullOrNil(localabz.url))
              {
                paramAnonymousView = com.tencent.mm.plugin.card.d.l.Y(localabz.url, localabz.LfD);
                com.tencent.mm.plugin.card.d.b.a(n.this.pQZ, paramAnonymousView, 1);
                localObject = com.tencent.mm.plugin.report.service.h.CyF;
                String str1 = paramb.csU();
                String str2 = paramb.csV();
                if (localabz.title != null) {}
                for (paramAnonymousView = localabz.title;; paramAnonymousView = "")
                {
                  ((com.tencent.mm.plugin.report.service.h)localObject).a(11941, new Object[] { Integer.valueOf(9), str1, str2, "", paramAnonymousView });
                  break;
                }
              }
              d.a(n.this.pQZ, n.this.pQZ.getString(2131757197), true);
            }
          }
        });
        if (!Util.isNullOrNil(localabz.pRY)) {
          ((TextView)paramViewGroup.findViewById(2131298797)).setText(localabz.pRY);
        }
        paramViewGroup = (TextView)paramViewGroup.findViewById(2131298815);
        if (!Util.isNullOrNil(localabz.pRZ))
        {
          paramViewGroup.setText(localabz.pRZ);
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
    final View localView1 = paramViewGroup.findViewById(2131298811);
    if (localView1.getVisibility() == 0)
    {
      Log.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
      AppMethodBeat.o(113697);
      return;
    }
    localView1.setVisibility(0);
    Object localObject = paramViewGroup.findViewById(2131298813);
    if (((View)localObject).getVisibility() == 0) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramViewGroup.findViewById(2131298809);
    ((ImageView)localObject).setVisibility(8);
    final View localView2 = paramViewGroup.findViewById(2131298816);
    localView2.setVisibility(0);
    ((TextView)paramViewGroup.findViewById(2131298797)).setText(this.pQZ.getResources().getString(2131756977));
    final Button localButton = (Button)paramViewGroup.findViewById(2131298795);
    localButton.setVisibility(0);
    a(localButton, paramb);
    com.tencent.mm.plugin.card.b.g localg = am.cug();
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
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          localView1.setVisibility(8);
          localView2.setVisibility(8);
          this.qkm.setVisibility(0);
          localButton.setVisibility(8);
          n.this.qjU.d(c.qkQ);
          n.this.d(paramViewGroup, paramb);
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113691);
        }
      });
      AppMethodBeat.o(113697);
      return;
      localg.ctj();
      k localk = am.cue().ajo(paramb.csU());
      if (localk != null)
      {
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        if (am.cue().fr(paramb.csU(), localk.field_code_id)) {
          localg.a(paramb.csU(), localk.field_code_id, c.qkQ);
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
  
  public final boolean cxx()
  {
    return false;
  }
  
  public final boolean cxy()
  {
    return true;
  }
  
  final void d(final ViewGroup paramViewGroup, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113695);
    paramb = paramb.csQ().Lff;
    View localView = paramViewGroup.findViewById(2131298813);
    if ((paramb != null) && (paramb.LrM))
    {
      localView.setVisibility(0);
      if (!Util.isNullOrNil(paramb.LrN))
      {
        ((TextView)paramViewGroup.findViewById(2131298814)).setText(paramb.LrN);
        ((ImageView)paramViewGroup.findViewById(2131298812)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113689);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            paramAnonymousView = (Button)paramViewGroup.findViewById(2131298795);
            localObject = paramViewGroup.findViewById(2131298811);
            if ((paramAnonymousView.getVisibility() == 0) && (((View)localObject).getVisibility() == 0))
            {
              a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(113689);
              return;
            }
            if (((View)localObject).getVisibility() == 0)
            {
              if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(n.this.pQZ.getContext()))
              {
                d.a(n.this.pQZ, n.this.pQZ.getString(2131757007), false);
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113689);
                return;
              }
              ((View)localObject).setVisibility(8);
              paramViewGroup.findViewById(2131298809).setVisibility(0);
            }
            n.this.qjU.d(c.qkR);
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
    if (!paramb.csR().LcG)
    {
      Log.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
      AppMethodBeat.o(113692);
      return false;
    }
    paramb = paramb.csR().LcF;
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
    return 2131493345;
  }
  
  public final void n(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113693);
    paramViewGroup.findViewById(2131298811).setVisibility(8);
    paramViewGroup.findViewById(2131298809).setVisibility(0);
    AppMethodBeat.o(113693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n
 * JD-Core Version:    0.7.0.1
 */