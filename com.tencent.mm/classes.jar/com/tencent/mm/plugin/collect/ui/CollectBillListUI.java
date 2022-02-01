package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.collect.model.h;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI
  extends WalletBaseUI
{
  private int limit;
  private View oIW;
  private int paP;
  private ListView pdE;
  private b pdF;
  private LinearLayout pdG;
  private CollectPullDownView pdH;
  private TextView pdI;
  private Dialog pdJ;
  private boolean pdK;
  private boolean pdL;
  private boolean pdM;
  private boolean pdN;
  private boolean pdO;
  private boolean pdP;
  private boolean pdQ;
  private boolean pdR;
  private boolean pdS;
  private long pdT;
  private long pdU;
  private Calendar pdV;
  private List<h> pdW;
  private int retryCount;
  private Dialog tipDialog;
  private int type;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(64057);
    this.pdK = false;
    this.pdL = false;
    this.pdM = false;
    this.pdN = false;
    this.pdO = false;
    this.pdP = false;
    this.pdQ = true;
    this.pdR = false;
    this.pdS = false;
    this.type = 0;
    this.limit = 20;
    this.paP = 0;
    this.retryCount = 0;
    this.pdT = 0L;
    this.pdU = 0L;
    this.pdW = new ArrayList();
    AppMethodBeat.o(64057);
  }
  
  private void ZS(String paramString)
  {
    AppMethodBeat.i(64063);
    if (this.pdF.getCount() == 0)
    {
      ad.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!bt.isNullOrNil(paramString)) {
        this.pdI.setText(paramString);
      }
      for (;;)
      {
        bmg();
        AppMethodBeat.o(64063);
        return;
        if (this.pdP)
        {
          this.pdI.setText(getString(2131757441));
        }
        else
        {
          paramString = getString(2131757441) + getString(2131757442);
          this.pdI.setText(paramString);
        }
      }
    }
    if (!bt.isNullOrNil(paramString)) {
      Toast.makeText(getContext(), paramString, 1).show();
    }
    AppMethodBeat.o(64063);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(64066);
    ad.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    doSceneProgress(new r(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false);
    this.retryCount += 1;
    AppMethodBeat.o(64066);
  }
  
  private void bmg()
  {
    AppMethodBeat.i(64062);
    this.pdE.setVisibility(8);
    this.pdG.setVisibility(0);
    this.pdI.setVisibility(0);
    AppMethodBeat.o(64062);
  }
  
  private void caY()
  {
    AppMethodBeat.i(64061);
    this.pdH.scrollTo(0, this.pdH.getTopHeight());
    AppMethodBeat.o(64061);
  }
  
  private void caZ()
  {
    AppMethodBeat.i(64065);
    int i = this.pdF.getCount();
    if (i > 0)
    {
      long l = this.pdF.Bj(i - 1).paq;
      if (l < this.pdU)
      {
        ad.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.pdU) });
        this.pdU = l;
      }
    }
    ad.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.pdU) });
    doSceneProgress(new r(this.type, this.pdU, this.limit, 0), false);
    this.pdM = true;
    AppMethodBeat.o(64065);
  }
  
  private void jN(boolean paramBoolean)
  {
    AppMethodBeat.i(64064);
    CollectPullDownView localCollectPullDownView = this.pdH;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localCollectPullDownView.setBottomViewVisible(paramBoolean);
      AppMethodBeat.o(64064);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493554;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64059);
    this.pdE = ((ListView)findViewById(2131298440));
    this.pdG = ((LinearLayout)findViewById(2131298438));
    this.pdI = ((TextView)findViewById(2131298439));
    this.oIW = z.jO(this).inflate(2131493556, this.pdE, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(this, 5)));
    this.pdE.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(this, 10)));
    this.pdE.addFooterView(localView, null, true);
    this.pdE.setOverScrollMode(2);
    this.pdF = new b(this);
    this.pdE.setAdapter(this.pdF);
    this.pdE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        ad.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView = new Intent(CollectBillListUI.this.getContext(), CollectBillUI.class);
        paramAnonymousAdapterView = (h)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView.putExtra("key_type", paramAnonymousAdapterView.type);
        paramAnonymousView.putExtra("key_timestamp", paramAnonymousAdapterView.paq);
        paramAnonymousView.putExtra("key_from_scene", 2);
        paramAnonymousAdapterView = CollectBillListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(64053);
      }
    });
    this.pdE.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.pdH = ((CollectPullDownView)findViewById(2131298442));
    this.pdH.setTopViewVisible(false);
    this.pdH.setIsTopShowAll(false);
    this.pdH.setBottomViewVisible(true);
    this.pdH.setIsBottomShowAll(false);
    this.pdH.setCanOverScrool(true);
    this.pdH.setAtTopCallBack(new CollectBillListUI.9(this));
    this.pdH.setAtBottomCallBack(new CollectBillListUI.10(this));
    this.pdH.setOnTopLoadDataListener(new CollectBillListUI.11(this));
    this.pdH.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean cba()
      {
        AppMethodBeat.i(64049);
        ad.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[] { Boolean.valueOf(CollectBillListUI.g(CollectBillListUI.this)), Boolean.valueOf(CollectBillListUI.h(CollectBillListUI.this)) });
        if ((!CollectBillListUI.g(CollectBillListUI.this)) && (!CollectBillListUI.h(CollectBillListUI.this)))
        {
          CollectBillListUI.i(CollectBillListUI.this);
          CollectBillListUI.j(CollectBillListUI.this);
          AppMethodBeat.o(64049);
          return false;
        }
        AppMethodBeat.o(64049);
        return true;
      }
    });
    AppMethodBeat.o(64059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64058);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131757443);
    if (this.pdS) {
      addIconOptionMenu(0, 2131689956, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64048);
          CollectBillListUI.a(CollectBillListUI.this);
          AppMethodBeat.o(64048);
          return false;
        }
      });
    }
    this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(this, false, new CollectBillListUI.3(this));
    caZ();
    com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(64058);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64060);
    if ((paramn instanceof r))
    {
      paramn = (r)paramn;
      if (this.tipDialog.isShowing()) {
        this.tipDialog.dismiss();
      }
      this.pdH.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.paP == 0)
        {
          if (this.pdO)
          {
            ad.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(64060);
            return true;
          }
          if (paramn.paQ == 1)
          {
            this.pdQ = paramn.hII;
            if (!paramn.paT.isEmpty())
            {
              paramString = this.pdF;
              List localList = paramn.paT;
              paramString.pdB.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.pdT = ((h)paramn.paT.get(0)).paq;
              this.pdN = false;
              this.pdL = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.pdQ = true;
            break;
            this.pdP = paramn.hII;
            this.pdE.setVisibility(0);
            this.pdG.setVisibility(8);
            if (paramn.isRetry)
            {
              if (!paramn.paT.isEmpty()) {
                this.pdW.addAll(paramn.paT);
              }
              if ((paramn.paR == 0) && (paramn.paS > 0) && (paramn.paT.isEmpty()))
              {
                ad.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramn.paS, paramn.paq, paramn.paQ, paramn.paP);
                AppMethodBeat.o(64060);
                return true;
              }
              this.retryCount = 0;
              if (this.pdW.size() > 0) {
                this.pdF.cL(this.pdW);
              }
              for (;;)
              {
                this.pdM = false;
                this.pdU = paramn.paq;
                caY();
                jN(this.pdP);
                break;
                ad.i("MicroMsg.CollectBillListUI", "retry data is empty");
                ZS(paramn.krz);
              }
            }
            if (!paramn.paT.isEmpty())
            {
              this.pdF.cL(paramn.paT);
              this.pdU = ((h)paramn.paT.get(paramn.paT.size() - 1)).paq;
              if (this.pdU > paramn.paq)
              {
                ad.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.pdU = paramn.paq;
              }
              for (;;)
              {
                this.pdM = false;
                caY();
                jN(this.pdP);
                break;
                ad.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.pdU), Long.valueOf(paramn.paq) });
              }
            }
            if ((paramn.paR == 0) && (paramn.paS > 0))
            {
              ad.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.paS), Long.valueOf(paramn.paq) });
              a(paramn.paS, paramn.paq, paramn.paQ, paramn.paP);
              this.pdW.clear();
            }
            else
            {
              this.pdM = false;
              caY();
              ad.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              ZS(paramn.krz);
              jN(this.pdP);
            }
          }
        }
        this.pdP = paramn.hII;
        if (paramn.isRetry)
        {
          if (!paramn.paT.isEmpty()) {
            this.pdW.addAll(paramn.paT);
          }
          if ((paramn.paR == 0) && (paramn.paS > 0))
          {
            ad.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramn.paS, paramn.paq, paramn.paQ, paramn.paP);
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.retryCount = 0;
            this.pdQ = true;
            this.pdU = paramn.paq;
            if (paramn.paR == 0) {}
            for (this.pdP = false;; this.pdP = true)
            {
              if (this.pdW.size() <= 0) {
                break label861;
              }
              this.pdF.setData(this.pdW);
              break;
            }
            label861:
            ad.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            bmg();
            if (!bt.isNullOrNil(paramn.krz))
            {
              this.pdI.setText(paramn.krz);
              this.pdI.setVisibility(0);
            }
            paramString = this.pdF;
            paramString.pdB.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramn.paT.isEmpty())
        {
          this.pdF.setData(paramn.paT);
          this.pdT = ((h)paramn.paT.get(0)).paq;
          this.pdU = ((h)paramn.paT.get(paramn.paT.size() - 1)).paq;
        }
        for (;;)
        {
          this.pdO = false;
          this.pdQ = false;
          break;
          if ((paramn.paR == 0) && (paramn.paS > 0))
          {
            ad.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.paS), Long.valueOf(paramn.paq) });
            a(paramn.paS, paramn.paq, paramn.paQ, paramn.paP);
            this.pdW.clear();
          }
          else
          {
            bmg();
          }
        }
      }
      ad.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.paP), Integer.valueOf(paramn.paQ) });
      if (paramn.paP == 0) {
        if (paramn.paQ == 0)
        {
          this.pdM = false;
          caY();
        }
      }
      for (;;)
      {
        if (this.pdF.isEmpty()) {
          bmg();
        }
        Toast.makeText(this, 2131757440, 1).show();
        AppMethodBeat.o(64060);
        return true;
        this.pdN = false;
        continue;
        this.pdO = false;
      }
    }
    AppMethodBeat.o(64060);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI
 * JD-Core Version:    0.7.0.1
 */