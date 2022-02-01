package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI
  extends WalletBaseUI
{
  private int limit;
  private View nCC;
  private int nTZ;
  private ListView nWO;
  private b nWP;
  private LinearLayout nWQ;
  private CollectPullDownView nWR;
  private TextView nWS;
  private Dialog nWT;
  private boolean nWU;
  private boolean nWV;
  private boolean nWW;
  private boolean nWX;
  private boolean nWY;
  private boolean nWZ;
  private boolean nXa;
  private boolean nXb;
  private boolean nXc;
  private long nXd;
  private long nXe;
  private Calendar nXf;
  private List<com.tencent.mm.plugin.collect.model.h> nXg;
  private int retryCount;
  private Dialog tipDialog;
  private int type;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(64057);
    this.nWU = false;
    this.nWV = false;
    this.nWW = false;
    this.nWX = false;
    this.nWY = false;
    this.nWZ = false;
    this.nXa = true;
    this.nXb = false;
    this.nXc = false;
    this.type = 0;
    this.limit = 20;
    this.nTZ = 0;
    this.retryCount = 0;
    this.nXd = 0L;
    this.nXe = 0L;
    this.nXg = new ArrayList();
    AppMethodBeat.o(64057);
  }
  
  private void RZ(String paramString)
  {
    AppMethodBeat.i(64063);
    if (this.nWP.getCount() == 0)
    {
      ad.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!bt.isNullOrNil(paramString)) {
        this.nWS.setText(paramString);
      }
      for (;;)
      {
        bbB();
        AppMethodBeat.o(64063);
        return;
        if (this.nWZ)
        {
          this.nWS.setText(getString(2131757441));
        }
        else
        {
          paramString = getString(2131757441) + getString(2131757442);
          this.nWS.setText(paramString);
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
  
  private void bPf()
  {
    AppMethodBeat.i(64061);
    this.nWR.scrollTo(0, this.nWR.getTopHeight());
    AppMethodBeat.o(64061);
  }
  
  private void bPg()
  {
    AppMethodBeat.i(64065);
    int i = this.nWP.getCount();
    if (i > 0)
    {
      long l = this.nWP.zI(i - 1).nTA;
      if (l < this.nXe)
      {
        ad.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.nXe) });
        this.nXe = l;
      }
    }
    ad.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.nXe) });
    doSceneProgress(new r(this.type, this.nXe, this.limit, 0), false);
    this.nWW = true;
    AppMethodBeat.o(64065);
  }
  
  private void bbB()
  {
    AppMethodBeat.i(64062);
    this.nWO.setVisibility(8);
    this.nWQ.setVisibility(0);
    this.nWS.setVisibility(0);
    AppMethodBeat.o(64062);
  }
  
  private void iZ(boolean paramBoolean)
  {
    AppMethodBeat.i(64064);
    CollectPullDownView localCollectPullDownView = this.nWR;
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
    this.nWO = ((ListView)findViewById(2131298440));
    this.nWQ = ((LinearLayout)findViewById(2131298438));
    this.nWS = ((TextView)findViewById(2131298439));
    this.nCC = y.js(this).inflate(2131493556, this.nWO, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(this, 5)));
    this.nWO.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(this, 10)));
    this.nWO.addFooterView(localView, null, true);
    this.nWO.setOverScrollMode(2);
    this.nWP = new b(this);
    this.nWO.setAdapter(this.nWP);
    this.nWO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64053);
        ad.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView = new Intent(CollectBillListUI.this.getContext(), CollectBillUI.class);
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.h)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView.putExtra("key_type", paramAnonymousAdapterView.type);
        paramAnonymousView.putExtra("key_timestamp", paramAnonymousAdapterView.nTA);
        paramAnonymousView.putExtra("key_from_scene", 2);
        paramAnonymousAdapterView = CollectBillListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.vKh.f(13944, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(64053);
      }
    });
    this.nWO.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.nWR = ((CollectPullDownView)findViewById(2131298442));
    this.nWR.setTopViewVisible(false);
    this.nWR.setIsTopShowAll(false);
    this.nWR.setBottomViewVisible(true);
    this.nWR.setIsBottomShowAll(false);
    this.nWR.setCanOverScrool(true);
    this.nWR.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean bPi()
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
    this.nWR.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean bPj()
      {
        AppMethodBeat.i(64055);
        if (CollectBillListUI.f(CollectBillListUI.this).getVisibility() == 0)
        {
          ad.d("MicroMsg.CollectBillListUI", "empty view");
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
    this.nWR.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean bPk()
      {
        AppMethodBeat.i(64056);
        ad.d("MicroMsg.CollectBillListUI", "top load");
        AppMethodBeat.o(64056);
        return true;
      }
    });
    this.nWR.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean bPh()
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
    if (this.nXc) {
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
    this.tipDialog = g.a(this, false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    bPg();
    com.tencent.mm.plugin.report.service.h.vKh.f(13944, new Object[] { Integer.valueOf(4) });
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
      this.nWR.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.nTZ == 0)
        {
          if (this.nWY)
          {
            ad.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(64060);
            return true;
          }
          if (paramn.nUa == 1)
          {
            this.nXa = paramn.gPQ;
            if (!paramn.nUd.isEmpty())
            {
              paramString = this.nWP;
              List localList = paramn.nUd;
              paramString.nWL.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.nXd = ((com.tencent.mm.plugin.collect.model.h)paramn.nUd.get(0)).nTA;
              this.nWX = false;
              this.nWV = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.nXa = true;
            break;
            this.nWZ = paramn.gPQ;
            this.nWO.setVisibility(0);
            this.nWQ.setVisibility(8);
            if (paramn.isRetry)
            {
              if (!paramn.nUd.isEmpty()) {
                this.nXg.addAll(paramn.nUd);
              }
              if ((paramn.nUb == 0) && (paramn.nUc > 0) && (paramn.nUd.isEmpty()))
              {
                ad.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramn.nUc, paramn.nTA, paramn.nUa, paramn.nTZ);
                AppMethodBeat.o(64060);
                return true;
              }
              this.retryCount = 0;
              if (this.nXg.size() > 0) {
                this.nWP.cI(this.nXg);
              }
              for (;;)
              {
                this.nWW = false;
                this.nXe = paramn.nTA;
                bPf();
                iZ(this.nWZ);
                break;
                ad.i("MicroMsg.CollectBillListUI", "retry data is empty");
                RZ(paramn.jwH);
              }
            }
            if (!paramn.nUd.isEmpty())
            {
              this.nWP.cI(paramn.nUd);
              this.nXe = ((com.tencent.mm.plugin.collect.model.h)paramn.nUd.get(paramn.nUd.size() - 1)).nTA;
              if (this.nXe > paramn.nTA)
              {
                ad.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.nXe = paramn.nTA;
              }
              for (;;)
              {
                this.nWW = false;
                bPf();
                iZ(this.nWZ);
                break;
                ad.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.nXe), Long.valueOf(paramn.nTA) });
              }
            }
            if ((paramn.nUb == 0) && (paramn.nUc > 0))
            {
              ad.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.nUc), Long.valueOf(paramn.nTA) });
              a(paramn.nUc, paramn.nTA, paramn.nUa, paramn.nTZ);
              this.nXg.clear();
            }
            else
            {
              this.nWW = false;
              bPf();
              ad.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              RZ(paramn.jwH);
              iZ(this.nWZ);
            }
          }
        }
        this.nWZ = paramn.gPQ;
        if (paramn.isRetry)
        {
          if (!paramn.nUd.isEmpty()) {
            this.nXg.addAll(paramn.nUd);
          }
          if ((paramn.nUb == 0) && (paramn.nUc > 0))
          {
            ad.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramn.nUc, paramn.nTA, paramn.nUa, paramn.nTZ);
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.retryCount = 0;
            this.nXa = true;
            this.nXe = paramn.nTA;
            if (paramn.nUb == 0) {}
            for (this.nWZ = false;; this.nWZ = true)
            {
              if (this.nXg.size() <= 0) {
                break label861;
              }
              this.nWP.setData(this.nXg);
              break;
            }
            label861:
            ad.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            bbB();
            if (!bt.isNullOrNil(paramn.jwH))
            {
              this.nWS.setText(paramn.jwH);
              this.nWS.setVisibility(0);
            }
            paramString = this.nWP;
            paramString.nWL.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramn.nUd.isEmpty())
        {
          this.nWP.setData(paramn.nUd);
          this.nXd = ((com.tencent.mm.plugin.collect.model.h)paramn.nUd.get(0)).nTA;
          this.nXe = ((com.tencent.mm.plugin.collect.model.h)paramn.nUd.get(paramn.nUd.size() - 1)).nTA;
        }
        for (;;)
        {
          this.nWY = false;
          this.nXa = false;
          break;
          if ((paramn.nUb == 0) && (paramn.nUc > 0))
          {
            ad.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.nUc), Long.valueOf(paramn.nTA) });
            a(paramn.nUc, paramn.nTA, paramn.nUa, paramn.nTZ);
            this.nXg.clear();
          }
          else
          {
            bbB();
          }
        }
      }
      ad.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.nTZ), Integer.valueOf(paramn.nUa) });
      if (paramn.nTZ == 0) {
        if (paramn.nUa == 0)
        {
          this.nWW = false;
          bPf();
        }
      }
      for (;;)
      {
        if (this.nWP.isEmpty()) {
          bbB();
        }
        Toast.makeText(this, 2131757440, 1).show();
        AppMethodBeat.o(64060);
        return true;
        this.nWX = false;
        continue;
        this.nWY = false;
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