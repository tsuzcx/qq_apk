package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
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
  private View oPy;
  private int pht;
  private long pkA;
  private Calendar pkB;
  private List<com.tencent.mm.plugin.collect.model.h> pkC;
  private ListView pkk;
  private b pkl;
  private LinearLayout pkm;
  private CollectPullDownView pkn;
  private TextView pko;
  private Dialog pkp;
  private boolean pkq;
  private boolean pkr;
  private boolean pks;
  private boolean pkt;
  private boolean pku;
  private boolean pkv;
  private boolean pkw;
  private boolean pkx;
  private boolean pky;
  private long pkz;
  private int retryCount;
  private Dialog tipDialog;
  private int type;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(64057);
    this.pkq = false;
    this.pkr = false;
    this.pks = false;
    this.pkt = false;
    this.pku = false;
    this.pkv = false;
    this.pkw = true;
    this.pkx = false;
    this.pky = false;
    this.type = 0;
    this.limit = 20;
    this.pht = 0;
    this.retryCount = 0;
    this.pkz = 0L;
    this.pkA = 0L;
    this.pkC = new ArrayList();
    AppMethodBeat.o(64057);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(64066);
    ae.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    doSceneProgress(new r(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false);
    this.retryCount += 1;
    AppMethodBeat.o(64066);
  }
  
  private void aaJ(String paramString)
  {
    AppMethodBeat.i(64063);
    if (this.pkl.getCount() == 0)
    {
      ae.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!bu.isNullOrNil(paramString)) {
        this.pko.setText(paramString);
      }
      for (;;)
      {
        bmP();
        AppMethodBeat.o(64063);
        return;
        if (this.pkv)
        {
          this.pko.setText(getString(2131757441));
        }
        else
        {
          paramString = getString(2131757441) + getString(2131757442);
          this.pko.setText(paramString);
        }
      }
    }
    if (!bu.isNullOrNil(paramString)) {
      Toast.makeText(getContext(), paramString, 1).show();
    }
    AppMethodBeat.o(64063);
  }
  
  private void bmP()
  {
    AppMethodBeat.i(64062);
    this.pkk.setVisibility(8);
    this.pkm.setVisibility(0);
    this.pko.setVisibility(0);
    AppMethodBeat.o(64062);
  }
  
  private void ccn()
  {
    AppMethodBeat.i(64061);
    this.pkn.scrollTo(0, this.pkn.getTopHeight());
    AppMethodBeat.o(64061);
  }
  
  private void cco()
  {
    AppMethodBeat.i(64065);
    int i = this.pkl.getCount();
    if (i > 0)
    {
      long l = this.pkl.Bv(i - 1).pgU;
      if (l < this.pkA)
      {
        ae.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.pkA) });
        this.pkA = l;
      }
    }
    ae.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.pkA) });
    doSceneProgress(new r(this.type, this.pkA, this.limit, 0), false);
    this.pks = true;
    AppMethodBeat.o(64065);
  }
  
  private void jM(boolean paramBoolean)
  {
    AppMethodBeat.i(64064);
    CollectPullDownView localCollectPullDownView = this.pkn;
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
    this.pkk = ((ListView)findViewById(2131298440));
    this.pkm = ((LinearLayout)findViewById(2131298438));
    this.pko = ((TextView)findViewById(2131298439));
    this.oPy = z.jV(this).inflate(2131493556, this.pkk, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this, 5)));
    this.pkk.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this, 10)));
    this.pkk.addFooterView(localView, null, true);
    this.pkk.setOverScrollMode(2);
    this.pkl = new b(this);
    this.pkk.setAdapter(this.pkl);
    this.pkk.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        ae.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView = new Intent(CollectBillListUI.this.getContext(), CollectBillUI.class);
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.h)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ae.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView.putExtra("key_type", paramAnonymousAdapterView.type);
        paramAnonymousView.putExtra("key_timestamp", paramAnonymousAdapterView.pgU);
        paramAnonymousView.putExtra("key_from_scene", 2);
        paramAnonymousAdapterView = CollectBillListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahE(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        g.yxI.f(13944, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(64053);
      }
    });
    this.pkk.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.pkn = ((CollectPullDownView)findViewById(2131298442));
    this.pkn.setTopViewVisible(false);
    this.pkn.setIsTopShowAll(false);
    this.pkn.setBottomViewVisible(true);
    this.pkn.setIsBottomShowAll(false);
    this.pkn.setCanOverScrool(true);
    this.pkn.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean ccq()
      {
        AppMethodBeat.i(64054);
        int i = CollectBillListUI.e(CollectBillListUI.this).getFirstVisiblePosition();
        if (i == 0)
        {
          View localView = CollectBillListUI.e(CollectBillListUI.this).getChildAt(i);
          if ((localView != null) && (localView.getX() == 0.0F))
          {
            AppMethodBeat.o(64054);
            return true;
          }
        }
        AppMethodBeat.o(64054);
        return false;
      }
    });
    this.pkn.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean ccr()
      {
        AppMethodBeat.i(64055);
        if (CollectBillListUI.f(CollectBillListUI.this).getVisibility() == 0)
        {
          ae.d("MicroMsg.CollectBillListUI", "empty view");
          AppMethodBeat.o(64055);
          return true;
        }
        View localView = CollectBillListUI.e(CollectBillListUI.this).getChildAt(CollectBillListUI.e(CollectBillListUI.this).getChildCount() - 1);
        if ((localView != null) && (localView.getBottom() <= CollectBillListUI.e(CollectBillListUI.this).getHeight()) && (CollectBillListUI.e(CollectBillListUI.this).getLastVisiblePosition() == CollectBillListUI.e(CollectBillListUI.this).getAdapter().getCount() - 1))
        {
          AppMethodBeat.o(64055);
          return true;
        }
        AppMethodBeat.o(64055);
        return false;
      }
    });
    this.pkn.setOnTopLoadDataListener(new CollectBillListUI.11(this));
    this.pkn.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean ccp()
      {
        AppMethodBeat.i(64049);
        ae.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[] { Boolean.valueOf(CollectBillListUI.g(CollectBillListUI.this)), Boolean.valueOf(CollectBillListUI.h(CollectBillListUI.this)) });
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
    if (this.pky) {
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
    this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(this, false, new CollectBillListUI.3(this));
    cco();
    g.yxI.f(13944, new Object[] { Integer.valueOf(4) });
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
      this.pkn.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.pht == 0)
        {
          if (this.pku)
          {
            ae.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(64060);
            return true;
          }
          if (paramn.phu == 1)
          {
            this.pkw = paramn.hLB;
            if (!paramn.phx.isEmpty())
            {
              paramString = this.pkl;
              List localList = paramn.phx;
              paramString.pkh.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.pkz = ((com.tencent.mm.plugin.collect.model.h)paramn.phx.get(0)).pgU;
              this.pkt = false;
              this.pkr = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.pkw = true;
            break;
            this.pkv = paramn.hLB;
            this.pkk.setVisibility(0);
            this.pkm.setVisibility(8);
            if (paramn.isRetry)
            {
              if (!paramn.phx.isEmpty()) {
                this.pkC.addAll(paramn.phx);
              }
              if ((paramn.phv == 0) && (paramn.phw > 0) && (paramn.phx.isEmpty()))
              {
                ae.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramn.phw, paramn.pgU, paramn.phu, paramn.pht);
                AppMethodBeat.o(64060);
                return true;
              }
              this.retryCount = 0;
              if (this.pkC.size() > 0) {
                this.pkl.cO(this.pkC);
              }
              for (;;)
              {
                this.pks = false;
                this.pkA = paramn.pgU;
                ccn();
                jM(this.pkv);
                break;
                ae.i("MicroMsg.CollectBillListUI", "retry data is empty");
                aaJ(paramn.kuP);
              }
            }
            if (!paramn.phx.isEmpty())
            {
              this.pkl.cO(paramn.phx);
              this.pkA = ((com.tencent.mm.plugin.collect.model.h)paramn.phx.get(paramn.phx.size() - 1)).pgU;
              if (this.pkA > paramn.pgU)
              {
                ae.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.pkA = paramn.pgU;
              }
              for (;;)
              {
                this.pks = false;
                ccn();
                jM(this.pkv);
                break;
                ae.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.pkA), Long.valueOf(paramn.pgU) });
              }
            }
            if ((paramn.phv == 0) && (paramn.phw > 0))
            {
              ae.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.phw), Long.valueOf(paramn.pgU) });
              a(paramn.phw, paramn.pgU, paramn.phu, paramn.pht);
              this.pkC.clear();
            }
            else
            {
              this.pks = false;
              ccn();
              ae.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              aaJ(paramn.kuP);
              jM(this.pkv);
            }
          }
        }
        this.pkv = paramn.hLB;
        if (paramn.isRetry)
        {
          if (!paramn.phx.isEmpty()) {
            this.pkC.addAll(paramn.phx);
          }
          if ((paramn.phv == 0) && (paramn.phw > 0))
          {
            ae.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramn.phw, paramn.pgU, paramn.phu, paramn.pht);
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.retryCount = 0;
            this.pkw = true;
            this.pkA = paramn.pgU;
            if (paramn.phv == 0) {}
            for (this.pkv = false;; this.pkv = true)
            {
              if (this.pkC.size() <= 0) {
                break label861;
              }
              this.pkl.setData(this.pkC);
              break;
            }
            label861:
            ae.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            bmP();
            if (!bu.isNullOrNil(paramn.kuP))
            {
              this.pko.setText(paramn.kuP);
              this.pko.setVisibility(0);
            }
            paramString = this.pkl;
            paramString.pkh.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramn.phx.isEmpty())
        {
          this.pkl.setData(paramn.phx);
          this.pkz = ((com.tencent.mm.plugin.collect.model.h)paramn.phx.get(0)).pgU;
          this.pkA = ((com.tencent.mm.plugin.collect.model.h)paramn.phx.get(paramn.phx.size() - 1)).pgU;
        }
        for (;;)
        {
          this.pku = false;
          this.pkw = false;
          break;
          if ((paramn.phv == 0) && (paramn.phw > 0))
          {
            ae.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.phw), Long.valueOf(paramn.pgU) });
            a(paramn.phw, paramn.pgU, paramn.phu, paramn.pht);
            this.pkC.clear();
          }
          else
          {
            bmP();
          }
        }
      }
      ae.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.pht), Integer.valueOf(paramn.phu) });
      if (paramn.pht == 0) {
        if (paramn.phu == 0)
        {
          this.pks = false;
          ccn();
        }
      }
      for (;;)
      {
        if (this.pkl.isEmpty()) {
          bmP();
        }
        Toast.makeText(this, 2131757440, 1).show();
        AppMethodBeat.o(64060);
        return true;
        this.pkt = false;
        continue;
        this.pku = false;
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