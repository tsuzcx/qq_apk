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
import com.tencent.mm.plugin.luckymoney.a.c;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

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
    if (paramau.fBI == 0)
    {
      ad.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + paramau.fBI);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if (!paramau.type.equalsIgnoreCase(paramString))
    {
      ad.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + paramau.type + ", " + paramString);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
    {
      paramString = new e();
      paramString.too = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Pic"))
    {
      paramString = new a();
      paramString.too = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Appid"))
    {
      paramString = new b();
      paramString.too = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
    }
    AppMethodBeat.o(65786);
  }
  
  static final class a
    implements h.d
  {
    h.c too;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65779);
      if (bt.isNullOrNil(paramau.name))
      {
        ad.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
        paramViewGroup.setVisibility(8);
        AppMethodBeat.o(65779);
        return;
      }
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      z.l(localImageView, paramau.name);
      if (!bt.isNullOrNil(paramau.content)) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65778);
            com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.tfT) });
            if (h.a.this.too != null) {
              com.tencent.mm.protocal.g.fL(h.a.this.too.tov, 1);
            }
            e.p(paramContext, paramau.content, true);
            AppMethodBeat.o(65778);
          }
        });
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView(localImageView);
      paramViewGroup.setVisibility(0);
      com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.tfT) });
      if (this.too != null) {
        com.tencent.mm.protocal.g.fL(this.too.tov, 0);
      }
      AppMethodBeat.o(65779);
    }
  }
  
  static final class b
    implements h.d
  {
    h.c too;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65782);
      if (bt.isNullOrNil(paramau.name))
      {
        AppMethodBeat.o(65782);
        return;
      }
      TextView localTextView = new TextView(paramContext);
      if ((this.too != null) && (this.too.textColor != -2147483648))
      {
        localTextView.setTextColor(this.too.textColor);
        if ((this.too == null) || (this.too.textSize == -2147483648)) {
          break label241;
        }
        localTextView.setTextSize(0, this.too.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(paramau.name);
        if (!bt.isNullOrNil(paramau.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65781);
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.tfT) });
              if (paramau.tfU != 1)
              {
                ((com.tencent.mm.pluginsdk.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.class)).a(paramContext, paramau.content, new v()
                {
                  public final void ru(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(65780);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(65780);
                      return;
                      e.ae(h.b.1.this.val$context, h.b.1.this.toq.content);
                    }
                  }
                }).show();
                AppMethodBeat.o(65781);
                return;
              }
              e.ac(paramContext, paramau.content);
              AppMethodBeat.o(65781);
            }
          });
        }
        paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.tfT) });
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
    public boolean tou = false;
    public int tov = 0;
    public bfu tow;
  }
  
  static abstract interface d
  {
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, au paramau);
  }
  
  static final class e
    implements h.d
  {
    h.c too;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65784);
      if (bt.isNullOrNil(paramau.name))
      {
        AppMethodBeat.o(65784);
        return;
      }
      Object localObject = LayoutInflater.from(paramContext).inflate(2131494661, paramViewGroup, true);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131301947);
      localObject = (ImageView)((View)localObject).findViewById(2131301946);
      if (!bt.isNullOrNil(paramau.iconUrl))
      {
        z.l((ImageView)localObject, paramau.iconUrl);
        ((ImageView)localObject).setVisibility(0);
        if ((this.too != null) && (this.too.textColor != -2147483648)) {
          localTextView.setTextColor(this.too.textColor);
        }
        if ((this.too == null) || (this.too.textSize == -2147483648)) {
          break label287;
        }
        localTextView.setTextSize(0, this.too.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(paramau.name);
        if (!bt.isNullOrNil(paramau.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65783);
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.tfT) });
              if (h.e.this.too != null) {
                com.tencent.mm.protocal.g.fL(h.e.this.too.tov, 1);
              }
              if ((h.e.this.too != null) && (h.e.this.too.tou)) {
                com.tencent.mm.plugin.report.service.h.vKh.f(13051, new Object[] { Integer.valueOf(h.e.this.too.tov), Integer.valueOf(2), "", "", "", paramau.content, paramau.type, "", "", Integer.valueOf(h.e.this.too.resourceId) });
              }
              com.tencent.mm.plugin.report.service.h localh;
              String str;
              if (paramau.type.equals("Native"))
              {
                ad.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + paramau.content);
                if ("weixin://festival/gotoshake".equalsIgnoreCase(paramau.content)) {
                  ad.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                }
                localh = com.tencent.mm.plugin.report.service.h.vKh;
                str = paramau.content;
                if (h.e.this.too.tow == null) {
                  break label390;
                }
              }
              label390:
              for (paramAnonymousView = h.e.this.too.tow.DDg;; paramAnonymousView = "")
              {
                localh.f(16589, new Object[] { Integer.valueOf(2), str, paramAnonymousView, c.sXK, Integer.valueOf(0), c.openId });
                AppMethodBeat.o(65783);
                return;
                e.p(paramContext, paramau.content, true);
                break;
              }
            }
          });
        }
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.tfT) });
        if (this.too != null) {
          com.tencent.mm.protocal.g.fL(this.too.tov, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h
 * JD-Core Version:    0.7.0.1
 */