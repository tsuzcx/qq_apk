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
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    if (paramau.fFp == 0)
    {
      ac.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + paramau.fFp);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if (!paramau.type.equalsIgnoreCase(paramString))
    {
      ac.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + paramau.type + ", " + paramString);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(65786);
      return;
    }
    if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
    {
      paramString = new e();
      paramString.uwH = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Pic"))
    {
      paramString = new a();
      paramString.uwH = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
      AppMethodBeat.o(65786);
      return;
    }
    if (paramString.equalsIgnoreCase("Appid"))
    {
      paramString = new b();
      paramString.uwH = paramc;
      paramString.a(paramContext, paramViewGroup, paramau);
    }
    AppMethodBeat.o(65786);
  }
  
  static final class a
    implements h.d
  {
    h.c uwH;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65779);
      if (bs.isNullOrNil(paramau.name))
      {
        ac.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
        paramViewGroup.setVisibility(8);
        AppMethodBeat.o(65779);
        return;
      }
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      z.l(localImageView, paramau.name);
      if (!bs.isNullOrNil(paramau.content)) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65778);
            com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.uoi) });
            if (h.a.this.uwH != null) {
              com.tencent.mm.protocal.g.fS(h.a.this.uwH.uwN, 1);
            }
            e.o(paramContext, paramau.content, true);
            AppMethodBeat.o(65778);
          }
        });
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView(localImageView);
      paramViewGroup.setVisibility(0);
      com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.uoi) });
      if (this.uwH != null) {
        com.tencent.mm.protocal.g.fS(this.uwH.uwN, 0);
      }
      AppMethodBeat.o(65779);
    }
  }
  
  static final class b
    implements h.d
  {
    h.c uwH;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65782);
      if (bs.isNullOrNil(paramau.name))
      {
        AppMethodBeat.o(65782);
        return;
      }
      TextView localTextView = new TextView(paramContext);
      if ((this.uwH != null) && (this.uwH.textColor != -2147483648))
      {
        localTextView.setTextColor(this.uwH.textColor);
        if ((this.uwH == null) || (this.uwH.textSize == -2147483648)) {
          break label241;
        }
        localTextView.setTextSize(0, this.uwH.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(paramau.name);
        if (!bs.isNullOrNil(paramau.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65781);
              com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.uoi) });
              if (paramau.uoj != 1)
              {
                ((com.tencent.mm.pluginsdk.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.class)).a(paramContext, paramau.content, new v()
                {
                  public final void sj(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(65780);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(65780);
                      return;
                      e.af(h.b.1.this.val$context, h.b.1.this.uwI.content);
                    }
                  }
                }).show();
                AppMethodBeat.o(65781);
                return;
              }
              e.ad(paramContext, paramau.content);
              AppMethodBeat.o(65781);
            }
          });
        }
        paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.uoi) });
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
    public boolean uwM = false;
    public int uwN = 0;
    public bjm uwO;
  }
  
  static abstract interface d
  {
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, au paramau);
  }
  
  static final class e
    implements h.d
  {
    h.c uwH;
    
    public final void a(final Context paramContext, ViewGroup paramViewGroup, final au paramau)
    {
      AppMethodBeat.i(65784);
      if (bs.isNullOrNil(paramau.name))
      {
        AppMethodBeat.o(65784);
        return;
      }
      Object localObject = LayoutInflater.from(paramContext).inflate(2131494661, paramViewGroup, true);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131301947);
      localObject = (ImageView)((View)localObject).findViewById(2131301946);
      if (!bs.isNullOrNil(paramau.iconUrl))
      {
        z.l((ImageView)localObject, paramau.iconUrl);
        ((ImageView)localObject).setVisibility(0);
        if ((this.uwH != null) && (this.uwH.textColor != -2147483648)) {
          localTextView.setTextColor(this.uwH.textColor);
        }
        if ((this.uwH == null) || (this.uwH.textSize == -2147483648)) {
          break label287;
        }
        localTextView.setTextSize(0, this.uwH.textSize);
      }
      for (;;)
      {
        localTextView.setGravity(17);
        localTextView.setText(paramau.name);
        if (!bs.isNullOrNil(paramau.content)) {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65783);
              com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramau.uoi) });
              if (h.e.this.uwH != null) {
                com.tencent.mm.protocal.g.fS(h.e.this.uwH.uwN, 1);
              }
              if ((h.e.this.uwH != null) && (h.e.this.uwH.uwM)) {
                com.tencent.mm.plugin.report.service.h.wUl.f(13051, new Object[] { Integer.valueOf(h.e.this.uwH.uwN), Integer.valueOf(2), "", "", "", paramau.content, paramau.type, "", "", Integer.valueOf(h.e.this.uwH.resourceId) });
              }
              com.tencent.mm.plugin.report.service.h localh;
              String str;
              if (paramau.type.equals("Native"))
              {
                ac.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + paramau.content);
                if ("weixin://festival/gotoshake".equalsIgnoreCase(paramau.content)) {
                  ac.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                }
                localh = com.tencent.mm.plugin.report.service.h.wUl;
                str = paramau.content;
                if (h.e.this.uwH.uwO == null) {
                  break label390;
                }
              }
              label390:
              for (paramAnonymousView = h.e.this.uwH.uwO.EYC;; paramAnonymousView = "")
              {
                localh.f(16589, new Object[] { Integer.valueOf(2), str, paramAnonymousView, c.ufX, Integer.valueOf(0), c.openId });
                AppMethodBeat.o(65783);
                return;
                e.o(paramContext, paramau.content, true);
                break;
              }
            }
          });
        }
        paramViewGroup.setVisibility(0);
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramau.uoi) });
        if (this.uwH != null) {
          com.tencent.mm.protocal.g.fS(this.uwH.uwN, 0);
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