package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.a.c;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.bi;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.k;

public final class i
{
  public static void a(Context paramContext, ViewGroup paramViewGroup, bi parambi, c paramc)
  {
    AppMethodBeat.i(65785);
    if (parambi == null)
    {
      AppMethodBeat.o(65785);
      return;
    }
    a(paramContext, paramViewGroup, parambi, paramc, parambi.type);
    AppMethodBeat.o(65785);
  }
  
  public static void a(Context paramContext, ViewGroup paramViewGroup, bi parambi, c paramc, String paramString)
  {
    AppMethodBeat.i(65786);
    if ((paramViewGroup == null) || (parambi == null))
    {
      AppMethodBeat.o(65786);
      return;
    }
    if (parambi.lTH == 0)
    {
      Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + parambi.lTH);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if (!parambi.type.equalsIgnoreCase(paramString))
    {
      Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + parambi.type + ", " + paramString);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
    {
      paramString = new e();
      paramString.KFR = paramc;
      paramString.a(paramContext, paramViewGroup, parambi);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Pic"))
    {
      paramString = new a();
      paramString.KFR = paramc;
      paramString.a(paramContext, paramViewGroup, parambi);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Appid"))
    {
      paramString = new b();
      paramString.KFR = paramc;
      paramString.a(paramContext, paramViewGroup, parambi);
    }
    AppMethodBeat.o(65786);
  }
  
  static final class a
    implements i.d
  {
    i.c KFR;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bi parambi)
    {
      AppMethodBeat.i(65779);
      if (Util.isNullOrNil(parambi.name))
      {
        Log.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
        paramViewGroup.setVisibility(8);
        AppMethodBeat.o(65779);
        return;
      }
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ah.p(localImageView, parambi.name);
      if (!Util.isNullOrNil(parambi.content)) {
        localImageView.setOnClickListener(new k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(284294);
            com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambi.KuZ) });
            if (i.a.this.KFR != null) {
              g.ik(i.a.this.KFR.KFX, 1);
            }
            com.tencent.mm.wallet_core.ui.i.p(paramContext, parambi.content, true);
            AppMethodBeat.o(284294);
          }
        });
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView(localImageView);
      paramViewGroup.setVisibility(0);
      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambi.KuZ) });
      if (this.KFR != null) {
        g.ik(this.KFR.KFX, 0);
      }
      AppMethodBeat.o(65779);
    }
  }
  
  static final class b
    implements i.d
  {
    i.c KFR;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bi parambi)
    {
      AppMethodBeat.i(65782);
      if (Util.isNullOrNil(parambi.name))
      {
        AppMethodBeat.o(65782);
        return;
      }
      TextView localTextView = new TextView(paramContext);
      if ((this.KFR != null) && (this.KFR.textColor != -2147483648))
      {
        localTextView.setTextColor(this.KFR.textColor);
        if ((this.KFR == null) || (this.KFR.textSize == -2147483648)) {
          break label242;
        }
        localTextView.setTextSize(0, this.KFR.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(parambi.name);
        if (!Util.isNullOrNil(parambi.content)) {
          localTextView.setOnClickListener(new k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(284535);
              com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambi.KuZ) });
              if (parambi.Kva != 1)
              {
                ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.class)).a(paramContext, parambi.content, new v()
                {
                  public final void onAddContact(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(65780);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(65780);
                      return;
                      com.tencent.mm.wallet_core.ui.i.ap(i.b.1.this.val$context, i.b.1.this.KFS.content);
                    }
                  }
                }).show();
                AppMethodBeat.o(284535);
                return;
              }
              com.tencent.mm.wallet_core.ui.i.an(paramContext, parambi.content);
              AppMethodBeat.o(284535);
            }
          });
        }
        paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambi.KuZ) });
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
    public boolean KFW = false;
    public int KFX = 0;
    public czi KFY;
    public int resourceId = 0;
    public int textColor = -2147483648;
    public int textSize = -2147483648;
  }
  
  static abstract interface d
  {
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, bi parambi);
  }
  
  static final class e
    implements i.d
  {
    i.c KFR;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final bi parambi)
    {
      AppMethodBeat.i(65784);
      if (Util.isNullOrNil(parambi.name))
      {
        AppMethodBeat.o(65784);
        return;
      }
      Object localObject = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_text_oper_view, paramViewGroup, true);
      TextView localTextView = (TextView)((View)localObject).findViewById(a.f.lucky_money_text_oper_wording);
      localObject = (ImageView)((View)localObject).findViewById(a.f.lucky_money_text_oper_icon);
      if (!Util.isNullOrNil(parambi.iconUrl))
      {
        ah.p((ImageView)localObject, parambi.iconUrl);
        ((ImageView)localObject).setVisibility(0);
        if ((this.KFR == null) || (this.KFR.textSize == -2147483648)) {
          break label307;
        }
        localTextView.setTextSize(0, this.KFR.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(parambi.name);
        if (!Util.isNullOrNil(parambi.content))
        {
          localTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(a.c.link_color));
          localTextView.setOnClickListener(new k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(284090);
              com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(parambi.KuZ) });
              if (i.e.this.KFR != null) {
                g.ik(i.e.this.KFR.KFX, 1);
              }
              if ((i.e.this.KFR != null) && (i.e.this.KFR.KFW)) {
                com.tencent.mm.plugin.report.service.h.OAn.b(13051, new Object[] { Integer.valueOf(i.e.this.KFR.KFX), Integer.valueOf(2), "", "", "", parambi.content, parambi.type, "", "", Integer.valueOf(i.e.this.KFR.resourceId) });
              }
              com.tencent.mm.plugin.report.service.h localh;
              String str;
              if (parambi.type.equals("Native"))
              {
                Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + parambi.content);
                if ("weixin://festival/gotoshake".equalsIgnoreCase(parambi.content)) {
                  Log.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                }
                localh = com.tencent.mm.plugin.report.service.h.OAn;
                str = parambi.content;
                if (i.e.this.KFR.KFY == null) {
                  break label390;
                }
              }
              label390:
              for (paramAnonymousView = i.e.this.KFR.KFY.aaEp;; paramAnonymousView = "")
              {
                localh.b(16589, new Object[] { Integer.valueOf(2), str, paramAnonymousView, c.KlA, Integer.valueOf(0), c.openId });
                AppMethodBeat.o(284090);
                return;
                com.tencent.mm.wallet_core.ui.i.p(paramContext, parambi.content, true);
                break;
              }
            }
          });
        }
        if ((this.KFR != null) && (this.KFR.textColor != -2147483648)) {
          localTextView.setTextColor(this.KFR.textColor);
        }
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(parambi.KuZ) });
        if (this.KFR != null) {
          g.ik(this.KFR.KFX, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */