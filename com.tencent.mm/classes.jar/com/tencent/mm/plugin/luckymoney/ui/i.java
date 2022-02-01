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
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
{
  public static void a(Context paramContext, ViewGroup paramViewGroup, bh parambh, c paramc)
  {
    AppMethodBeat.i(65785);
    if (parambh == null)
    {
      AppMethodBeat.o(65785);
      return;
    }
    a(paramContext, paramViewGroup, parambh, paramc, parambh.type);
    AppMethodBeat.o(65785);
  }
  
  public static void a(Context paramContext, ViewGroup paramViewGroup, bh parambh, c paramc, String paramString)
  {
    AppMethodBeat.i(65786);
    if ((paramViewGroup == null) || (parambh == null))
    {
      AppMethodBeat.o(65786);
      return;
    }
    if (parambh.jqz == 0)
    {
      Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + parambh.jqz);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if (!parambh.type.equalsIgnoreCase(paramString))
    {
      Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + parambh.type + ", " + paramString);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
    {
      paramString = new e();
      paramString.ELz = paramc;
      paramString.a(paramContext, paramViewGroup, parambh);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Pic"))
    {
      paramString = new a();
      paramString.ELz = paramc;
      paramString.a(paramContext, paramViewGroup, parambh);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Appid"))
    {
      paramString = new b();
      paramString.ELz = paramc;
      paramString.a(paramContext, paramViewGroup, parambh);
    }
    AppMethodBeat.o(65786);
  }
  
  static final class a
    implements i.d
  {
    i.c ELz;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bh parambh)
    {
      AppMethodBeat.i(65779);
      if (Util.isNullOrNil(parambh.name))
      {
        Log.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
        paramViewGroup.setVisibility(8);
        AppMethodBeat.o(65779);
        return;
      }
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ag.o(localImageView, parambh.name);
      if (!Util.isNullOrNil(parambh.content)) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65778);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambh.EBY) });
            if (i.a.this.ELz != null) {
              com.tencent.mm.protocal.g.gU(i.a.this.ELz.ELF, 1);
            }
            com.tencent.mm.wallet_core.ui.g.p(paramContext, parambh.content, true);
            a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65778);
          }
        });
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView(localImageView);
      paramViewGroup.setVisibility(0);
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambh.EBY) });
      if (this.ELz != null) {
        com.tencent.mm.protocal.g.gU(this.ELz.ELF, 0);
      }
      AppMethodBeat.o(65779);
    }
  }
  
  static final class b
    implements i.d
  {
    i.c ELz;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bh parambh)
    {
      AppMethodBeat.i(65782);
      if (Util.isNullOrNil(parambh.name))
      {
        AppMethodBeat.o(65782);
        return;
      }
      TextView localTextView = new TextView(paramContext);
      if ((this.ELz != null) && (this.ELz.textColor != -2147483648))
      {
        localTextView.setTextColor(this.ELz.textColor);
        if ((this.ELz == null) || (this.ELz.textSize == -2147483648)) {
          break label242;
        }
        localTextView.setTextSize(0, this.ELz.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(parambh.name);
        if (!Util.isNullOrNil(parambh.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65781);
              b localb = new b();
              localb.bn(paramAnonymousView);
              a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambh.EBY) });
              if (parambh.EBZ != 1) {
                ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.i.class)).a(paramContext, parambh.content, new v()
                {
                  public final void zZ(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(65780);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(65780);
                      return;
                      com.tencent.mm.wallet_core.ui.g.ao(i.b.1.this.val$context, i.b.1.this.ELA.content);
                    }
                  }
                }).show();
              }
              for (;;)
              {
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65781);
                return;
                com.tencent.mm.wallet_core.ui.g.am(paramContext, parambh.content);
              }
            }
          });
        }
        paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambh.EBY) });
        AppMethodBeat.o(65782);
        return;
        localTextView.setTextColor(paramContext.getResources().getColor(a.c.wallet_link_color));
        break;
        label242:
        localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.HintTextSize));
      }
    }
  }
  
  public static final class c
  {
    public boolean ELE = false;
    public int ELF = 0;
    public cjf ELG;
    public int Ezt = 0;
    public int textColor = -2147483648;
    public int textSize = -2147483648;
  }
  
  static abstract interface d
  {
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, bh parambh);
  }
  
  static final class e
    implements i.d
  {
    i.c ELz;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bh parambh)
    {
      AppMethodBeat.i(65784);
      if (Util.isNullOrNil(parambh.name))
      {
        AppMethodBeat.o(65784);
        return;
      }
      Object localObject = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_text_oper_view, paramViewGroup, true);
      TextView localTextView = (TextView)((View)localObject).findViewById(a.f.lucky_money_text_oper_wording);
      localObject = (ImageView)((View)localObject).findViewById(a.f.lucky_money_text_oper_icon);
      if (!Util.isNullOrNil(parambh.iconUrl))
      {
        ag.o((ImageView)localObject, parambh.iconUrl);
        ((ImageView)localObject).setVisibility(0);
        if ((this.ELz == null) || (this.ELz.textSize == -2147483648)) {
          break label307;
        }
        localTextView.setTextSize(0, this.ELz.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(parambh.name);
        if (!Util.isNullOrNil(parambh.content))
        {
          localTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(a.c.link_color));
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65783);
              Object localObject = new b();
              ((b)localObject).bn(paramAnonymousView);
              a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambh.EBY) });
              if (i.e.this.ELz != null) {
                com.tencent.mm.protocal.g.gU(i.e.this.ELz.ELF, 1);
              }
              if ((i.e.this.ELz != null) && (i.e.this.ELz.ELE)) {
                com.tencent.mm.plugin.report.service.h.IzE.a(13051, new Object[] { Integer.valueOf(i.e.this.ELz.ELF), Integer.valueOf(2), "", "", "", parambh.content, parambh.type, "", "", Integer.valueOf(i.e.this.ELz.Ezt) });
              }
              String str;
              if (parambh.type.equals("Native"))
              {
                Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + parambh.content);
                if ("weixin://festival/gotoshake".equalsIgnoreCase(parambh.content)) {
                  Log.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                }
                localObject = com.tencent.mm.plugin.report.service.h.IzE;
                str = parambh.content;
                if (i.e.this.ELz.ELG == null) {
                  break label431;
                }
              }
              label431:
              for (paramAnonymousView = i.e.this.ELz.ELG.Tqn;; paramAnonymousView = "")
              {
                ((com.tencent.mm.plugin.report.service.h)localObject).a(16589, new Object[] { Integer.valueOf(2), str, paramAnonymousView, c.EsU, Integer.valueOf(0), c.openId });
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65783);
                return;
                com.tencent.mm.wallet_core.ui.g.p(paramContext, parambh.content, true);
                break;
              }
            }
          });
        }
        if ((this.ELz != null) && (this.ELz.textColor != -2147483648)) {
          localTextView.setTextColor(this.ELz.textColor);
        }
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambh.EBY) });
        if (this.ELz != null) {
          com.tencent.mm.protocal.g.gU(this.ELz.ELF, 0);
        }
        AppMethodBeat.o(65784);
        return;
        ((ImageView)localObject).setVisibility(8);
        break;
        label307:
        localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.HintTextSize));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */