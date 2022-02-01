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
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

public final class i
{
  public static void a(Context paramContext, ViewGroup paramViewGroup, bg parambg, c paramc)
  {
    AppMethodBeat.i(65785);
    if (parambg == null)
    {
      AppMethodBeat.o(65785);
      return;
    }
    a(paramContext, paramViewGroup, parambg, paramc, parambg.type);
    AppMethodBeat.o(65785);
  }
  
  public static void a(Context paramContext, ViewGroup paramViewGroup, bg parambg, c paramc, String paramString)
  {
    AppMethodBeat.i(65786);
    if ((paramViewGroup == null) || (parambg == null))
    {
      AppMethodBeat.o(65786);
      return;
    }
    if (parambg.gGn == 0)
    {
      Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + parambg.gGn);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if (!parambg.type.equalsIgnoreCase(paramString))
    {
      Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + parambg.type + ", " + paramString);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
    {
      paramString = new e();
      paramString.zgs = paramc;
      paramString.a(paramContext, paramViewGroup, parambg);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Pic"))
    {
      paramString = new a();
      paramString.zgs = paramc;
      paramString.a(paramContext, paramViewGroup, parambg);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Appid"))
    {
      paramString = new b();
      paramString.zgs = paramc;
      paramString.a(paramContext, paramViewGroup, parambg);
    }
    AppMethodBeat.o(65786);
  }
  
  static final class a
    implements i.d
  {
    i.c zgs;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bg parambg)
    {
      AppMethodBeat.i(65779);
      if (Util.isNullOrNil(parambg.name))
      {
        Log.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
        paramViewGroup.setVisibility(8);
        AppMethodBeat.o(65779);
        return;
      }
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      af.o(localImageView, parambg.name);
      if (!Util.isNullOrNil(parambg.content)) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65778);
            b localb = new b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            h.CyF.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambg.yXT) });
            if (i.a.this.zgs != null) {
              com.tencent.mm.protocal.g.gH(i.a.this.zgs.zgy, 1);
            }
            f.p(paramContext, parambg.content, true);
            a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65778);
          }
        });
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView(localImageView);
      paramViewGroup.setVisibility(0);
      h.CyF.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambg.yXT) });
      if (this.zgs != null) {
        com.tencent.mm.protocal.g.gH(this.zgs.zgy, 0);
      }
      AppMethodBeat.o(65779);
    }
  }
  
  static final class b
    implements i.d
  {
    i.c zgs;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bg parambg)
    {
      AppMethodBeat.i(65782);
      if (Util.isNullOrNil(parambg.name))
      {
        AppMethodBeat.o(65782);
        return;
      }
      TextView localTextView = new TextView(paramContext);
      if ((this.zgs != null) && (this.zgs.textColor != -2147483648))
      {
        localTextView.setTextColor(this.zgs.textColor);
        if ((this.zgs == null) || (this.zgs.textSize == -2147483648)) {
          break label241;
        }
        localTextView.setTextSize(0, this.zgs.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(parambg.name);
        if (!Util.isNullOrNil(parambg.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65781);
              b localb = new b();
              localb.bm(paramAnonymousView);
              a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              h.CyF.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambg.yXT) });
              if (parambg.yXU != 1) {
                ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.i.class)).a(paramContext, parambg.content, new v()
                {
                  public final void wK(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(65780);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(65780);
                      return;
                      f.ao(i.b.1.this.val$context, i.b.1.this.zgt.content);
                    }
                  }
                }).show();
              }
              for (;;)
              {
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65781);
                return;
                f.am(paramContext, parambg.content);
              }
            }
          });
        }
        paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        paramViewGroup.setVisibility(0);
        h.CyF.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambg.yXT) });
        AppMethodBeat.o(65782);
        return;
        localTextView.setTextColor(paramContext.getResources().getColor(2131101357));
        break;
        label241:
        localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165482));
      }
    }
  }
  
  public static final class c
  {
    public int resourceId = 0;
    public int textColor = -2147483648;
    public int textSize = -2147483648;
    public boolean zgx = false;
    public int zgy = 0;
    public cbe zgz;
  }
  
  static abstract interface d
  {
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, bg parambg);
  }
  
  static final class e
    implements i.d
  {
    i.c zgs;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bg parambg)
    {
      AppMethodBeat.i(65784);
      if (Util.isNullOrNil(parambg.name))
      {
        AppMethodBeat.o(65784);
        return;
      }
      Object localObject = LayoutInflater.from(paramContext).inflate(2131495386, paramViewGroup, true);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131304272);
      localObject = (ImageView)((View)localObject).findViewById(2131304271);
      if (!Util.isNullOrNil(parambg.iconUrl))
      {
        af.o((ImageView)localObject, parambg.iconUrl);
        ((ImageView)localObject).setVisibility(0);
        if ((this.zgs == null) || (this.zgs.textSize == -2147483648)) {
          break label303;
        }
        localTextView.setTextSize(0, this.zgs.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(parambg.name);
        if (!Util.isNullOrNil(parambg.content))
        {
          localTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(2131100685));
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65783);
              Object localObject = new b();
              ((b)localObject).bm(paramAnonymousView);
              a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
              h.CyF.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambg.yXT) });
              if (i.e.this.zgs != null) {
                com.tencent.mm.protocal.g.gH(i.e.this.zgs.zgy, 1);
              }
              if ((i.e.this.zgs != null) && (i.e.this.zgs.zgx)) {
                h.CyF.a(13051, new Object[] { Integer.valueOf(i.e.this.zgs.zgy), Integer.valueOf(2), "", "", "", parambg.content, parambg.type, "", "", Integer.valueOf(i.e.this.zgs.resourceId) });
              }
              String str;
              if (parambg.type.equals("Native"))
              {
                Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + parambg.content);
                if ("weixin://festival/gotoshake".equalsIgnoreCase(parambg.content)) {
                  Log.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                }
                localObject = h.CyF;
                str = parambg.content;
                if (i.e.this.zgs.zgz == null) {
                  break label431;
                }
              }
              label431:
              for (paramAnonymousView = i.e.this.zgs.zgz.MgB;; paramAnonymousView = "")
              {
                ((h)localObject).a(16589, new Object[] { Integer.valueOf(2), str, paramAnonymousView, c.yOW, Integer.valueOf(0), c.openId });
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65783);
                return;
                f.p(paramContext, parambg.content, true);
                break;
              }
            }
          });
        }
        if ((this.zgs != null) && (this.zgs.textColor != -2147483648)) {
          localTextView.setTextColor(this.zgs.textColor);
        }
        paramViewGroup.setVisibility(0);
        h.CyF.a(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambg.yXT) });
        if (this.zgs != null) {
          com.tencent.mm.protocal.g.gH(this.zgs.zgy, 0);
        }
        AppMethodBeat.o(65784);
        return;
        ((ImageView)localObject).setVisibility(8);
        break;
        label303:
        localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165482));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */