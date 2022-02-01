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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI
  extends WalletBaseUI
{
  private int limit;
  private Calendar oAA;
  private List<com.tencent.mm.plugin.collect.model.h> oAB;
  private ListView oAj;
  private b oAk;
  private LinearLayout oAl;
  private CollectPullDownView oAm;
  private TextView oAn;
  private Dialog oAo;
  private boolean oAp;
  private boolean oAq;
  private boolean oAr;
  private boolean oAs;
  private boolean oAt;
  private boolean oAu;
  private boolean oAv;
  private boolean oAw;
  private boolean oAx;
  private long oAy;
  private long oAz;
  private View ofD;
  private int oxu;
  private int retryCount;
  private Dialog tipDialog;
  private int type;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(64057);
    this.oAp = false;
    this.oAq = false;
    this.oAr = false;
    this.oAs = false;
    this.oAt = false;
    this.oAu = false;
    this.oAv = true;
    this.oAw = false;
    this.oAx = false;
    this.type = 0;
    this.limit = 20;
    this.oxu = 0;
    this.retryCount = 0;
    this.oAy = 0L;
    this.oAz = 0L;
    this.oAB = new ArrayList();
    AppMethodBeat.o(64057);
  }
  
  private void Wl(String paramString)
  {
    AppMethodBeat.i(64063);
    if (this.oAk.getCount() == 0)
    {
      ac.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!bs.isNullOrNil(paramString)) {
        this.oAn.setText(paramString);
      }
      for (;;)
      {
        biu();
        AppMethodBeat.o(64063);
        return;
        if (this.oAu)
        {
          this.oAn.setText(getString(2131757441));
        }
        else
        {
          paramString = getString(2131757441) + getString(2131757442);
          this.oAn.setText(paramString);
        }
      }
    }
    if (!bs.isNullOrNil(paramString)) {
      Toast.makeText(getContext(), paramString, 1).show();
    }
    AppMethodBeat.o(64063);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(64066);
    ac.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    doSceneProgress(new r(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false);
    this.retryCount += 1;
    AppMethodBeat.o(64066);
  }
  
  private void bWv()
  {
    AppMethodBeat.i(64061);
    this.oAm.scrollTo(0, this.oAm.getTopHeight());
    AppMethodBeat.o(64061);
  }
  
  private void bWw()
  {
    AppMethodBeat.i(64065);
    int i = this.oAk.getCount();
    if (i > 0)
    {
      long l = this.oAk.AA(i - 1).owV;
      if (l < this.oAz)
      {
        ac.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.oAz) });
        this.oAz = l;
      }
    }
    ac.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.oAz) });
    doSceneProgress(new r(this.type, this.oAz, this.limit, 0), false);
    this.oAr = true;
    AppMethodBeat.o(64065);
  }
  
  private void biu()
  {
    AppMethodBeat.i(64062);
    this.oAj.setVisibility(8);
    this.oAl.setVisibility(0);
    this.oAn.setVisibility(0);
    AppMethodBeat.o(64062);
  }
  
  private void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(64064);
    CollectPullDownView localCollectPullDownView = this.oAm;
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
    this.oAj = ((ListView)findViewById(2131298440));
    this.oAl = ((LinearLayout)findViewById(2131298438));
    this.oAn = ((TextView)findViewById(2131298439));
    this.ofD = z.jD(this).inflate(2131493556, this.oAj, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(this, 5)));
    this.oAj.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(this, 10)));
    this.oAj.addFooterView(localView, null, true);
    this.oAj.setOverScrollMode(2);
    this.oAk = new b(this);
    this.oAj.setAdapter(this.oAk);
    this.oAj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64053);
        ac.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView = new Intent(CollectBillListUI.this.getContext(), CollectBillUI.class);
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.h)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ac.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView.putExtra("key_type", paramAnonymousAdapterView.type);
        paramAnonymousView.putExtra("key_timestamp", paramAnonymousAdapterView.owV);
        paramAnonymousView.putExtra("key_from_scene", 2);
        paramAnonymousAdapterView = CollectBillListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.wUl.f(13944, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(64053);
      }
    });
    this.oAj.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.oAm = ((CollectPullDownView)findViewById(2131298442));
    this.oAm.setTopViewVisible(false);
    this.oAm.setIsTopShowAll(false);
    this.oAm.setBottomViewVisible(true);
    this.oAm.setIsBottomShowAll(false);
    this.oAm.setCanOverScrool(true);
    this.oAm.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean bWy()
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
    this.oAm.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean bWz()
      {
        AppMethodBeat.i(64055);
        if (CollectBillListUI.f(CollectBillListUI.this).getVisibility() == 0)
        {
          ac.d("MicroMsg.CollectBillListUI", "empty view");
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
    this.oAm.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean bWA()
      {
        AppMethodBeat.i(64056);
        ac.d("MicroMsg.CollectBillListUI", "top load");
        AppMethodBeat.o(64056);
        return true;
      }
    });
    this.oAm.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean bWx()
      {
        AppMethodBeat.i(64049);
        ac.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[] { Boolean.valueOf(CollectBillListUI.g(CollectBillListUI.this)), Boolean.valueOf(CollectBillListUI.h(CollectBillListUI.this)) });
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
    if (this.oAx) {
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
    bWw();
    com.tencent.mm.plugin.report.service.h.wUl.f(13944, new Object[] { Integer.valueOf(4) });
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
      this.oAm.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.oxu == 0)
        {
          if (this.oAt)
          {
            ac.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(64060);
            return true;
          }
          if (paramn.oxv == 1)
          {
            this.oAv = paramn.hqq;
            if (!paramn.oxy.isEmpty())
            {
              paramString = this.oAk;
              List localList = paramn.oxy;
              paramString.oAg.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.oAy = ((com.tencent.mm.plugin.collect.model.h)paramn.oxy.get(0)).owV;
              this.oAs = false;
              this.oAq = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.oAv = true;
            break;
            this.oAu = paramn.hqq;
            this.oAj.setVisibility(0);
            this.oAl.setVisibility(8);
            if (paramn.isRetry)
            {
              if (!paramn.oxy.isEmpty()) {
                this.oAB.addAll(paramn.oxy);
              }
              if ((paramn.oxw == 0) && (paramn.oxx > 0) && (paramn.oxy.isEmpty()))
              {
                ac.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramn.oxx, paramn.owV, paramn.oxv, paramn.oxu);
                AppMethodBeat.o(64060);
                return true;
              }
              this.retryCount = 0;
              if (this.oAB.size() > 0) {
                this.oAk.cK(this.oAB);
              }
              for (;;)
              {
                this.oAr = false;
                this.oAz = paramn.owV;
                bWv();
                jC(this.oAu);
                break;
                ac.i("MicroMsg.CollectBillListUI", "retry data is empty");
                Wl(paramn.jXd);
              }
            }
            if (!paramn.oxy.isEmpty())
            {
              this.oAk.cK(paramn.oxy);
              this.oAz = ((com.tencent.mm.plugin.collect.model.h)paramn.oxy.get(paramn.oxy.size() - 1)).owV;
              if (this.oAz > paramn.owV)
              {
                ac.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.oAz = paramn.owV;
              }
              for (;;)
              {
                this.oAr = false;
                bWv();
                jC(this.oAu);
                break;
                ac.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.oAz), Long.valueOf(paramn.owV) });
              }
            }
            if ((paramn.oxw == 0) && (paramn.oxx > 0))
            {
              ac.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.oxx), Long.valueOf(paramn.owV) });
              a(paramn.oxx, paramn.owV, paramn.oxv, paramn.oxu);
              this.oAB.clear();
            }
            else
            {
              this.oAr = false;
              bWv();
              ac.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              Wl(paramn.jXd);
              jC(this.oAu);
            }
          }
        }
        this.oAu = paramn.hqq;
        if (paramn.isRetry)
        {
          if (!paramn.oxy.isEmpty()) {
            this.oAB.addAll(paramn.oxy);
          }
          if ((paramn.oxw == 0) && (paramn.oxx > 0))
          {
            ac.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramn.oxx, paramn.owV, paramn.oxv, paramn.oxu);
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.retryCount = 0;
            this.oAv = true;
            this.oAz = paramn.owV;
            if (paramn.oxw == 0) {}
            for (this.oAu = false;; this.oAu = true)
            {
              if (this.oAB.size() <= 0) {
                break label861;
              }
              this.oAk.setData(this.oAB);
              break;
            }
            label861:
            ac.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            biu();
            if (!bs.isNullOrNil(paramn.jXd))
            {
              this.oAn.setText(paramn.jXd);
              this.oAn.setVisibility(0);
            }
            paramString = this.oAk;
            paramString.oAg.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramn.oxy.isEmpty())
        {
          this.oAk.setData(paramn.oxy);
          this.oAy = ((com.tencent.mm.plugin.collect.model.h)paramn.oxy.get(0)).owV;
          this.oAz = ((com.tencent.mm.plugin.collect.model.h)paramn.oxy.get(paramn.oxy.size() - 1)).owV;
        }
        for (;;)
        {
          this.oAt = false;
          this.oAv = false;
          break;
          if ((paramn.oxw == 0) && (paramn.oxx > 0))
          {
            ac.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramn.oxx), Long.valueOf(paramn.owV) });
            a(paramn.oxx, paramn.owV, paramn.oxv, paramn.oxu);
            this.oAB.clear();
          }
          else
          {
            biu();
          }
        }
      }
      ac.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.oxu), Integer.valueOf(paramn.oxv) });
      if (paramn.oxu == 0) {
        if (paramn.oxv == 0)
        {
          this.oAr = false;
          bWv();
        }
      }
      for (;;)
      {
        if (this.oAk.isEmpty()) {
          biu();
        }
        Toast.makeText(this, 2131757440, 1).show();
        AppMethodBeat.o(64060);
        return true;
        this.oAs = false;
        continue;
        this.oAt = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI
 * JD-Core Version:    0.7.0.1
 */