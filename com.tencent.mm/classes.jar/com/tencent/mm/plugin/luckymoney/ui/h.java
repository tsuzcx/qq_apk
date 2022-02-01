package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.a.c;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

public final class h
{
  public static void a(Context paramContext, ViewGroup paramViewGroup, au paramau, c paramc)
  {
    AppMethodBeat.i(65785);
    if (paramau == null)
    {
      AppMethodBeat.o(65785);
      return;
    }
    a(paramContext, paramViewGroup, paramau, paramc, paramau.type);
    AppMethodBeat.o(65785);
  }
  
  public static void a(Context paramContext, ViewGroup paramViewGroup, au paramau, c paramc, String paramString)
  {
    AppMethodBeat.i(65786);
    if ((paramViewGroup == null) || (paramau == null))
    {
      AppMethodBeat.o(65786);
      return;
    }
    if (paramau.gaV == 0)
    {
      ae.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + paramau.gaV);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if (!paramau.type.equalsIgnoreCase(paramString))
    {
      ae.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + paramau.type + ", " + paramString);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
    {
      paramString = new e();
      paramString.vLo = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Pic"))
    {
      paramString = new a();
      paramString.vLo = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Appid"))
    {
      paramString = new b();
      paramString.vLo = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
    }
    AppMethodBeat.o(65786);
  }
  
  static final class a
    implements h.d
  {
    h.c vLo;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65779);
      if (bu.isNullOrNil(paramau.name))
      {
        ae.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
        paramViewGroup.setVisibility(8);
        AppMethodBeat.o(65779);
        return;
      }
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      z.l(localImageView, paramau.name);
      if (!bu.isNullOrNil(paramau.content)) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65778);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.vCR) });
            if (h.a.this.vLo != null) {
              com.tencent.mm.protocal.g.gi(h.a.this.vLo.vLu, 1);
            }
            f.p(paramContext, paramau.content, true);
            a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65778);
          }
        });
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView(localImageView);
      paramViewGroup.setVisibility(0);
      com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.vCR) });
      if (this.vLo != null) {
        com.tencent.mm.protocal.g.gi(this.vLo.vLu, 0);
      }
      AppMethodBeat.o(65779);
    }
  }
  
  static final class b
    implements h.d
  {
    h.c vLo;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65782);
      if (bu.isNullOrNil(paramau.name))
      {
        AppMethodBeat.o(65782);
        return;
      }
      TextView localTextView = new TextView(paramContext);
      if ((this.vLo != null) && (this.vLo.textColor != -2147483648))
      {
        localTextView.setTextColor(this.vLo.textColor);
        if ((this.vLo == null) || (this.vLo.textSize == -2147483648)) {
          break label241;
        }
        localTextView.setTextSize(0, this.vLo.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(paramau.name);
        if (!bu.isNullOrNil(paramau.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65781);
              b localb = new b();
              localb.bd(paramAnonymousView);
              a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.vCR) });
              if (paramau.vCS != 1) {
                ((i)com.tencent.mm.kernel.g.ab(i.class)).a(paramContext, paramau.content, new v()
                {
                  public final void sO(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(65780);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(65780);
                      return;
                      f.ag(h.b.1.this.val$context, h.b.1.this.vLp.content);
                    }
                  }
                }).show();
              }
              for (;;)
              {
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65781);
                return;
                f.ae(paramContext, paramau.content);
              }
            }
          });
        }
        paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.vCR) });
        AppMethodBeat.o(65782);
        return;
        localTextView.setTextColor(paramContext.getResources().getColor(2131101114));
        break;
        label241:
        localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165466));
      }
    }
  }
  
  public static final class c
  {
    public int resourceId = 0;
    public int textColor = -2147483648;
    public int textSize = -2147483648;
    public boolean vLt = false;
    public int vLu = 0;
    public bom vLv;
  }
  
  static abstract interface d
  {
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, au paramau);
  }
  
  static final class e
    implements h.d
  {
    h.c vLo;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65784);
      if (bu.isNullOrNil(paramau.name))
      {
        AppMethodBeat.o(65784);
        return;
      }
      Object localObject = LayoutInflater.from(paramContext).inflate(2131494661, paramViewGroup, true);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131301947);
      localObject = (ImageView)((View)localObject).findViewById(2131301946);
      if (!bu.isNullOrNil(paramau.iconUrl))
      {
        z.l((ImageView)localObject, paramau.iconUrl);
        ((ImageView)localObject).setVisibility(0);
        if ((this.vLo != null) && (this.vLo.textColor != -2147483648)) {
          localTextView.setTextColor(this.vLo.textColor);
        }
        if ((this.vLo == null) || (this.vLo.textSize == -2147483648)) {
          break label287;
        }
        localTextView.setTextSize(0, this.vLo.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(paramau.name);
        if (!bu.isNullOrNil(paramau.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65783);
              Object localObject = new b();
              ((b)localObject).bd(paramAnonymousView);
              a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.vCR) });
              if (h.e.this.vLo != null) {
                com.tencent.mm.protocal.g.gi(h.e.this.vLo.vLu, 1);
              }
              if ((h.e.this.vLo != null) && (h.e.this.vLo.vLt)) {
                com.tencent.mm.plugin.report.service.g.yxI.f(13051, new Object[] { Integer.valueOf(h.e.this.vLo.vLu), Integer.valueOf(2), "", "", "", paramau.content, paramau.type, "", "", Integer.valueOf(h.e.this.vLo.resourceId) });
              }
              String str;
              if (paramau.type.equals("Native"))
              {
                ae.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + paramau.content);
                if ("weixin://festival/gotoshake".equalsIgnoreCase(paramau.content)) {
                  ae.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                }
                localObject = com.tencent.mm.plugin.report.service.g.yxI;
                str = paramau.content;
                if (h.e.this.vLo.vLv == null) {
                  break label431;
                }
              }
              label431:
              for (paramAnonymousView = h.e.this.vLo.vLv.HbA;; paramAnonymousView = "")
              {
                ((com.tencent.mm.plugin.report.service.g)localObject).f(16589, new Object[] { Integer.valueOf(2), str, paramAnonymousView, c.vuM, Integer.valueOf(0), c.openId });
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65783);
                return;
                f.p(paramContext, paramau.content, true);
                break;
              }
            }
          });
        }
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.vCR) });
        if (this.vLo != null) {
          com.tencent.mm.protocal.g.gi(this.vLo.vLu, 0);
        }
        AppMethodBeat.o(65784);
        return;
        ((ImageView)localObject).setVisibility(8);
        break;
        label287:
        localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165466));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h
 * JD-Core Version:    0.7.0.1
 */