package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.luckymoney.model.d;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.wallet_core.c.a.a;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyHistoryEnvelopeUI
  extends MMActivity
{
  private final float EEc;
  private boolean EGI;
  private WxRecyclerAdapter EIs;
  private int EJc;
  private int EJd;
  private int EJe;
  private int EJf;
  private FrameLayout EJg;
  private RecyclerView EJh;
  private ArrayList<com.tencent.mm.view.recyclerview.a> EJi;
  private List<String> EJj;
  private String EJk;
  private String EJl;
  private RefreshLoadMoreLayout tCU;
  private int uAu;
  
  public LuckyMoneyHistoryEnvelopeUI()
  {
    AppMethodBeat.i(222326);
    this.EEc = 1.656F;
    this.EJi = new ArrayList();
    this.EJj = new ArrayList();
    this.EGI = true;
    this.EJl = "";
    AppMethodBeat.o(222326);
  }
  
  private void tP(boolean paramBoolean)
  {
    AppMethodBeat.i(222365);
    Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "do get show source: %s", new Object[] { Boolean.valueOf(this.EGI) });
    if (!this.EGI)
    {
      this.tCU.azs(0);
      AppMethodBeat.o(222365);
      return;
    }
    final k localk = k.eOu();
    final s locals = null;
    if (!paramBoolean) {
      locals = com.tencent.mm.ui.base.h.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(208794);
          localk.cancel();
          AppMethodBeat.o(208794);
        }
      });
    }
    localk.d(new d(this.EJl, 2));
    localk.a(new a.a() {}, 0L);
    AppMethodBeat.o(222365);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_history_envelope_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(222353);
    this.EJg = ((FrameLayout)findViewById(a.f.lucky_money_history_rootview));
    this.tCU = ((RefreshLoadMoreLayout)findViewById(a.f.lmhu_refresh_layout));
    this.EJh = ((RecyclerView)findViewById(a.f.lmhu_rv));
    this.tCU.setEnableRefresh(false);
    this.tCU.setActionCallback(new LuckyMoneyHistoryEnvelopeUI.8(this));
    getContext();
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(2);
    localGridLayoutManager.ahK = new LuckyMoneyHistoryEnvelopeUI.9(this, localGridLayoutManager);
    this.EJh.setLayoutManager(localGridLayoutManager);
    this.EIs = new WxRecyclerAdapter(new f()
    {
      public final e<?> yx(int paramAnonymousInt)
      {
        AppMethodBeat.i(274217);
        if (paramAnonymousInt == 1)
        {
          localObject = new LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this);
          AppMethodBeat.o(274217);
          return localObject;
        }
        Object localObject = new LuckyMoneyHistoryEnvelopeUI.d(LuckyMoneyHistoryEnvelopeUI.this);
        AppMethodBeat.o(274217);
        return localObject;
      }
    }, this.EJi, false);
    this.EIs.YSn = new h.c()
    {
      public final void a(RecyclerView.a paramAnonymousa, View paramAnonymousView, int paramAnonymousInt, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(186685);
        Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "click envelope: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousa = (com.tencent.mm.view.recyclerview.a)((i)paramAnonymousv).YSz;
        if ((paramAnonymousa instanceof LuckyMoneyHistoryEnvelopeUI.a)) {
          LuckyMoneyHistoryEnvelopeUI.a(LuckyMoneyHistoryEnvelopeUI.this, ((LuckyMoneyHistoryEnvelopeUI.a)paramAnonymousa).ECc);
        }
        AppMethodBeat.o(186685);
      }
    };
    this.EIs.YSm = new h.d()
    {
      public final boolean b(RecyclerView.a paramAnonymousa, View paramAnonymousView, int paramAnonymousInt, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(273684);
        Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "long click envelope: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousa = (com.tencent.mm.view.recyclerview.a)((i)paramAnonymousv).YSz;
        if ((paramAnonymousa instanceof LuckyMoneyHistoryEnvelopeUI.a)) {
          LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this, ((LuckyMoneyHistoryEnvelopeUI.a)paramAnonymousa).ECc);
        }
        AppMethodBeat.o(273684);
        return false;
      }
    };
    this.EJh.setAdapter(this.EIs);
    this.EJh.a(new RecyclerView.h()
    {
      private final int EJs;
      
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(271113);
        int i = (int)Math.ceil(LuckyMoneyHistoryEnvelopeUI.e(LuckyMoneyHistoryEnvelopeUI.this).size() / 2.0F);
        int j = RecyclerView.bh(paramAnonymousView);
        int k = (int)Math.ceil((j + 1) / 2.0F);
        if (k == 0)
        {
          paramAnonymousRect.top = (this.EJs * 2);
          paramAnonymousRect.bottom = (this.EJs * 2);
        }
        while (j % 2 == 0)
        {
          paramAnonymousRect.left = (this.EJs * 2);
          paramAnonymousRect.right = this.EJs;
          AppMethodBeat.o(271113);
          return;
          if (k == i)
          {
            paramAnonymousRect.top = this.EJs;
            paramAnonymousRect.bottom = (this.EJs * 2);
          }
          else
          {
            paramAnonymousRect.top = this.EJs;
            paramAnonymousRect.bottom = this.EJs;
          }
        }
        paramAnonymousRect.left = this.EJs;
        paramAnonymousRect.right = (this.EJs * 2);
        AppMethodBeat.o(271113);
      }
    });
    AppMethodBeat.o(222353);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(222336);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.BW_97));
    hideActionbarLine();
    setMMTitle(getString(a.i.lucky_money_envelope_history_entrance_text));
    setBackBtn(new LuckyMoneyHistoryEnvelopeUI.1(this));
    this.EJk = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    this.uAu = ((com.tencent.mm.ci.a.kr(getContext()) - com.tencent.mm.wallet_core.ui.noscale.a.azO(8) * 3) / 2);
    this.EJc = (this.uAu - com.tencent.mm.wallet_core.ui.noscale.a.azO(8) * 2);
    this.EJd = ((int)(this.EJc * 1.656F));
    this.EJe = ((int)(this.EJc * 1.38F));
    this.EJf = ((int)(this.EJc / 2.9F));
    initView();
    tP(false);
    AppMethodBeat.o(222336);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(222355);
    super.onDestroy();
    AppMethodBeat.o(222355);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public cjf ECc;
    
    a() {}
    
    public final int bAQ()
    {
      return 1;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(275964);
      long l = this.ECc.SpP.hashCode();
      AppMethodBeat.o(275964);
      return l;
    }
  }
  
  final class b
    extends e<LuckyMoneyHistoryEnvelopeUI.a>
  {
    b() {}
    
    public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
    {
      AppMethodBeat.i(269336);
      paramRecyclerView = parami.amk.getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.g(LuckyMoneyHistoryEnvelopeUI.this);
      parami.amk.setLayoutParams(paramRecyclerView);
      paramInt = com.tencent.mm.wallet_core.ui.noscale.a.azO(8);
      parami.amk.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramRecyclerView = parami.RD(a.f.lmpi_envelope_red_bg).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.i(LuckyMoneyHistoryEnvelopeUI.this);
      parami.RD(a.f.lmpi_envelope_red_bg).setLayoutParams(paramRecyclerView);
      paramRecyclerView = parami.RD(a.f.lmpi_envelope_iv).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.i(LuckyMoneyHistoryEnvelopeUI.this);
      parami.RD(a.f.lmpi_envelope_iv).setLayoutParams(paramRecyclerView);
      paramRecyclerView = parami.RD(a.f.lmpi_envelope_top_cap_iv).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.h(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.j(LuckyMoneyHistoryEnvelopeUI.this);
      parami.RD(a.f.lmpi_envelope_top_cap_iv).setLayoutParams(paramRecyclerView);
      paramRecyclerView = parami.RD(a.f.lmpi_envelope_open_btn).getLayoutParams();
      paramRecyclerView.width = LuckyMoneyHistoryEnvelopeUI.k(LuckyMoneyHistoryEnvelopeUI.this);
      paramRecyclerView.height = LuckyMoneyHistoryEnvelopeUI.k(LuckyMoneyHistoryEnvelopeUI.this);
      parami.RD(a.f.lmpi_envelope_open_btn).setLayoutParams(paramRecyclerView);
      AppMethodBeat.o(269336);
    }
    
    final void a(i parami, cjf paramcjf, boolean paramBoolean)
    {
      AppMethodBeat.i(269337);
      if (paramBoolean)
      {
        parami.RD(a.f.lmpi_loading_iv).setVisibility(8);
        parami.RD(a.f.lmpi_anim_pb).setVisibility(0);
        parami.RD(a.f.lmpi_retry_tv).setVisibility(8);
      }
      for (;;)
      {
        ((ImageView)parami.RD(a.f.lmpi_envelope_iv)).setImageBitmap(null);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a((ImageView)parami.RD(a.f.lmpi_envelope_iv), paramcjf, new LuckyMoneyHistoryEnvelopeUI.b.2(this, parami));
        AppMethodBeat.o(269337);
        return;
        parami.RD(a.f.lmpi_inline_cover_loading_pb).setVisibility(0);
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
    public String EJw;
    
    c() {}
    
    public final int bAQ()
    {
      return 2;
    }
    
    public final long mf()
    {
      return 0L;
    }
  }
  
  final class d
    extends e<LuckyMoneyHistoryEnvelopeUI.c>
  {
    d() {}
    
    public final void a(RecyclerView paramRecyclerView, i parami, int paramInt) {}
    
    public final int getLayoutId()
    {
      return a.g.lucky_money_history_footer_item;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */