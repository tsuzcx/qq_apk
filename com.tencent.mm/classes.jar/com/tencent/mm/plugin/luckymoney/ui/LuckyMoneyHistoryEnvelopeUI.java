package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.luckymoney.model.e;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyHistoryEnvelopeUI
  extends MMActivity
{
  private WxRecyclerAdapter KBO;
  private final float KCB;
  private final float KCC;
  private int KCD;
  private int KCE;
  private int KCF;
  private int KCG;
  private int KCH;
  private int KCI;
  private int KCJ;
  private int KCK;
  private int KCL;
  private int KCM;
  private FrameLayout KCN;
  private RecyclerView KCO;
  private ArrayList<com.tencent.mm.view.recyclerview.a> KCP;
  private List<String> KCQ;
  private String KCR;
  private String KCS;
  private final float Kxg;
  private boolean KzR;
  private int uAa;
  private RefreshLoadMoreLayout wGX;
  private int xGX;
  
  public LuckyMoneyHistoryEnvelopeUI()
  {
    AppMethodBeat.i(284139);
    this.KCB = 1.9844F;
    this.KCC = 1.72F;
    this.Kxg = 1.656F;
    this.KCP = new ArrayList();
    this.KCQ = new ArrayList();
    this.KzR = true;
    this.KCS = "";
    AppMethodBeat.o(284139);
  }
  
  private void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(284141);
    Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "do get show source: %s", new Object[] { Boolean.valueOf(this.KzR) });
    if (!this.KzR)
    {
      this.wGX.aFW(0);
      AppMethodBeat.o(284141);
      return;
    }
    final l locall = l.fWR();
    final w localw = null;
    if (!paramBoolean) {
      localw = k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(284521);
          locall.cancel();
          AppMethodBeat.o(284521);
        }
      });
    }
    locall.d(new e(this.KCS, 2));
    locall.a(new com.tencent.mm.wallet_core.model.a.a() {}, 0L);
    AppMethodBeat.o(284141);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_history_envelope_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(284248);
    this.KCN = ((FrameLayout)findViewById(a.f.lucky_money_history_rootview));
    this.wGX = ((RefreshLoadMoreLayout)findViewById(a.f.lmhu_refresh_layout));
    this.KCO = ((RecyclerView)findViewById(a.f.lmhu_rv));
    this.wGX.setEnableRefresh(false);
    this.wGX.setActionCallback(new RefreshLoadMoreLayout.b()
    {
      public final void a(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(284489);
        if (!LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this)) {
          LuckyMoneyHistoryEnvelopeUI.c(LuckyMoneyHistoryEnvelopeUI.this).m(null);
        }
        AppMethodBeat.o(284489);
      }
      
      public final void qI(int paramAnonymousInt)
      {
        AppMethodBeat.i(284485);
        Log.d("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "trigger load more");
        super.qI(paramAnonymousInt);
        LuckyMoneyHistoryEnvelopeUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(284195);
            LuckyMoneyHistoryEnvelopeUI.a(LuckyMoneyHistoryEnvelopeUI.this);
            AppMethodBeat.o(284195);
          }
        });
        AppMethodBeat.o(284485);
      }
    });
    getContext();
    final GridLayoutManager localGridLayoutManager = new GridLayoutManager(2);
    localGridLayoutManager.bWq = new GridLayoutManager.b()
    {
      public final int fJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(284200);
        if (LuckyMoneyHistoryEnvelopeUI.d(LuckyMoneyHistoryEnvelopeUI.this).getItemViewType(paramAnonymousInt) == 2)
        {
          paramAnonymousInt = localGridLayoutManager.bWl;
          AppMethodBeat.o(284200);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(284200);
        return 1;
      }
    };
    this.KCO.setLayoutManager(localGridLayoutManager);
    this.KBO = new WxRecyclerAdapter(new g()
    {
      public final f<?> yF(int paramAnonymousInt)
      {
        AppMethodBeat.i(284197);
        if (paramAnonymousInt == 1)
        {
          localObject = new LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this);
          AppMethodBeat.o(284197);
          return localObject;
        }
        Object localObject = new LuckyMoneyHistoryEnvelopeUI.d(LuckyMoneyHistoryEnvelopeUI.this);
        AppMethodBeat.o(284197);
        return localObject;
      }
    }, this.KCP, false);
    this.KBO.agOe = new i.c()
    {
      public final void a(RecyclerView.a paramAnonymousa, View paramAnonymousView, int paramAnonymousInt, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(284208);
        Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "click envelope: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousa = (com.tencent.mm.view.recyclerview.a)((j)paramAnonymousv).CSA;
        if ((paramAnonymousa instanceof LuckyMoneyHistoryEnvelopeUI.a)) {
          LuckyMoneyHistoryEnvelopeUI.a(LuckyMoneyHistoryEnvelopeUI.this, ((LuckyMoneyHistoryEnvelopeUI.a)paramAnonymousa).Kvd);
        }
        AppMethodBeat.o(284208);
      }
    };
    this.KBO.agOd = new i.d()
    {
      public final boolean b(RecyclerView.a paramAnonymousa, View paramAnonymousView, int paramAnonymousInt, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(284210);
        Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "long click envelope: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousa = (com.tencent.mm.view.recyclerview.a)((j)paramAnonymousv).CSA;
        if ((paramAnonymousa instanceof LuckyMoneyHistoryEnvelopeUI.a)) {
          LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this, ((LuckyMoneyHistoryEnvelopeUI.a)paramAnonymousa).Kvd);
        }
        AppMethodBeat.o(284210);
        return false;
      }
    };
    this.KCO.setAdapter(this.KBO);
    this.KCO.a(new RecyclerView.h()
    {
      private final int agq;
      
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(284220);
        int i = (int)Math.ceil(LuckyMoneyHistoryEnvelopeUI.e(LuckyMoneyHistoryEnvelopeUI.this).size() / 2.0F);
        int j = RecyclerView.bA(paramAnonymousView);
        int k = (int)Math.ceil((j + 1) / 2.0F);
        if (k == 0)
        {
          paramAnonymousRect.top = (this.agq * 2);
          paramAnonymousRect.bottom = (this.agq * 2);
        }
        while (j % 2 == 0)
        {
          paramAnonymousRect.left = (this.agq * 2);
          paramAnonymousRect.right = this.agq;
          AppMethodBeat.o(284220);
          return;
          if (k == i)
          {
            paramAnonymousRect.top = this.agq;
            paramAnonymousRect.bottom = (this.agq * 2);
          }
          else
          {
            paramAnonymousRect.top = this.agq;
            paramAnonymousRect.bottom = this.agq;
          }
        }
        paramAnonymousRect.left = this.agq;
        paramAnonymousRect.right = (this.agq * 2);
        AppMethodBeat.o(284220);
      }
    });
    AppMethodBeat.o(284248);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284240);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.BW_97));
    hideActionbarLine();
    setMMTitle(getString(a.i.lucky_money_envelope_history_entrance_text));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(284460);
        LuckyMoneyHistoryEnvelopeUI.this.finish();
        AppMethodBeat.o(284460);
        return false;
      }
    });
    this.KCR = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284493);
        Rect localRect = new Rect();
        LuckyMoneyHistoryEnvelopeUI.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        LuckyMoneyHistoryEnvelopeUI.a(LuckyMoneyHistoryEnvelopeUI.this, (localRect.width() - com.tencent.mm.wallet_core.ui.noscale.a.aGE(8) * 3) / 2);
        LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.g(LuckyMoneyHistoryEnvelopeUI.this) * 1.9844F));
        LuckyMoneyHistoryEnvelopeUI.c(LuckyMoneyHistoryEnvelopeUI.this, LuckyMoneyHistoryEnvelopeUI.g(LuckyMoneyHistoryEnvelopeUI.this) - com.tencent.mm.wallet_core.ui.noscale.a.aGE(8) * 2);
        LuckyMoneyHistoryEnvelopeUI.d(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this) * 1.656F));
        LuckyMoneyHistoryEnvelopeUI.e(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this) * 1.38F));
        LuckyMoneyHistoryEnvelopeUI.f(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this) / 2.9F));
        LuckyMoneyHistoryEnvelopeUI.g(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this) / 1.1F));
        LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.i(LuckyMoneyHistoryEnvelopeUI.this) * 1.656F));
        LuckyMoneyHistoryEnvelopeUI.i(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.i(LuckyMoneyHistoryEnvelopeUI.this) * 1.38F));
        LuckyMoneyHistoryEnvelopeUI.j(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.i(LuckyMoneyHistoryEnvelopeUI.this) / 2.9F));
        LuckyMoneyHistoryEnvelopeUI.k(LuckyMoneyHistoryEnvelopeUI.this, LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this));
        LuckyMoneyHistoryEnvelopeUI.l(LuckyMoneyHistoryEnvelopeUI.this, (int)(LuckyMoneyHistoryEnvelopeUI.j(LuckyMoneyHistoryEnvelopeUI.this) * 1.72F));
        AppMethodBeat.o(284493);
      }
    });
    initView();
    yd(false);
    AppMethodBeat.o(284240);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(284253);
    super.onDestroy();
    AppMethodBeat.o(284253);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public czi Kvd;
    
    a() {}
    
    public final long bZA()
    {
      AppMethodBeat.i(284340);
      long l = this.Kvd.ZoK.hashCode();
      AppMethodBeat.o(284340);
      return l;
    }
    
    public final int bZB()
    {
      return 1;
    }
  }
  
  final class b
    extends f<LuckyMoneyHistoryEnvelopeUI.a>
  {
    b() {}
    
    private static boolean a(j paramj, czj paramczj)
    {
      AppMethodBeat.i(284338);
      if ((paramj.UH(a.f.lmpi_envelope_widget_iv) != null) && (!Util.isNullOrNil(paramczj.aaEP)) && (!Util.isNullOrNil(paramczj.aaEQ)))
      {
        AppMethodBeat.o(284338);
        return true;
      }
      AppMethodBeat.o(284338);
      return false;
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(284348);
      paramRecyclerView = paramj.caK.getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.g(LuckyMoneyHistoryEnvelopeUI.this);
      paramj.caK.setMinimumHeight(LuckyMoneyHistoryEnvelopeUI.k(LuckyMoneyHistoryEnvelopeUI.this));
      paramj.caK.setLayoutParams(paramRecyclerView);
      paramInt = com.tencent.mm.wallet_core.ui.noscale.a.aGE(8);
      paramj.caK.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramRecyclerView = paramj.UH(a.f.lmpi_envelope_red_bg).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.l(LuckyMoneyHistoryEnvelopeUI.this);
      paramj.UH(a.f.lmpi_envelope_red_bg).setLayoutParams(paramRecyclerView);
      paramRecyclerView = paramj.UH(a.f.lmpi_envelope_iv).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.l(LuckyMoneyHistoryEnvelopeUI.this);
      paramj.UH(a.f.lmpi_envelope_iv).setLayoutParams(paramRecyclerView);
      paramRecyclerView = paramj.UH(a.f.lmpi_envelope_top_cap_iv).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.m(LuckyMoneyHistoryEnvelopeUI.this);
      paramj.UH(a.f.lmpi_envelope_top_cap_iv).setLayoutParams(paramRecyclerView);
      paramRecyclerView = paramj.UH(a.f.lmpi_envelope_open_btn).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.n(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.n(LuckyMoneyHistoryEnvelopeUI.this);
      paramj.UH(a.f.lmpi_envelope_open_btn).setLayoutParams(paramRecyclerView);
      AppMethodBeat.o(284348);
    }
    
    final void a(final j paramj, czi paramczi, boolean paramBoolean)
    {
      AppMethodBeat.i(284350);
      if (paramBoolean)
      {
        paramj.UH(a.f.lmpi_loading_iv).setVisibility(8);
        paramj.UH(a.f.lmpi_anim_pb).setVisibility(0);
        paramj.UH(a.f.lmpi_retry_tv).setVisibility(8);
      }
      for (;;)
      {
        ((ImageView)paramj.UH(a.f.lmpi_envelope_iv)).setImageBitmap(null);
        ((com.tencent.mm.plugin.luckymoney.a.a)h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a((ImageView)paramj.UH(a.f.lmpi_envelope_iv), paramczi, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void onComplete(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(284418);
            Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(284194);
                LuckyMoneyHistoryEnvelopeUI.b.2.this.KxL.UH(a.f.lmpi_inline_cover_loading_pb).setVisibility(8);
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyHistoryEnvelopeUI.b.2.this.KxL.UH(a.f.lmpi_white_cover_view).setVisibility(0);
                  LuckyMoneyHistoryEnvelopeUI.b.2.this.KxL.UH(a.f.lmpi_loading_iv).setVisibility(0);
                  LuckyMoneyHistoryEnvelopeUI.b.2.this.KxL.UH(a.f.lmpi_anim_pb).setVisibility(8);
                  LuckyMoneyHistoryEnvelopeUI.b.2.this.KxL.UH(a.f.lmpi_retry_tv).setVisibility(0);
                  AppMethodBeat.o(284194);
                  return;
                }
                LuckyMoneyHistoryEnvelopeUI.b.2.this.KxL.UH(a.f.lmpi_white_cover_view).setVisibility(8);
                AppMethodBeat.o(284194);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(284418);
              return;
            }
            paramj.UH(a.f.lmpi_white_cover_view).post(local1);
            AppMethodBeat.o(284418);
          }
        });
        if (a(paramj, paramczi.aaEq))
        {
          paramj = (ImageView)paramj.UH(a.f.lmpi_envelope_widget_iv);
          ((com.tencent.mm.plugin.luckymoney.a.a)h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).b(paramj, paramczi, new com.tencent.mm.plugin.luckymoney.a.a.a()
          {
            public final void onComplete(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(284425);
              Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              AppMethodBeat.o(284425);
            }
          });
        }
        AppMethodBeat.o(284350);
        return;
        paramj.UH(a.f.lmpi_inline_cover_loading_pb).setVisibility(0);
      }
    }
    
    public final int getLayoutId()
    {
      return a.g.lucky_money_history_envelope_item;
    }
  }
  
  final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    public String KDc;
    
    c() {}
    
    public final long bZA()
    {
      return 0L;
    }
    
    public final int bZB()
    {
      return 2;
    }
  }
  
  final class d
    extends f<LuckyMoneyHistoryEnvelopeUI.c>
  {
    d() {}
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt) {}
    
    public final int getLayoutId()
    {
      return a.g.lucky_money_history_footer_item;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */