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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI
  extends WalletBaseUI
{
  private int limit;
  private View qdm;
  private int qwC;
  private Dialog qzA;
  private boolean qzB;
  private boolean qzC;
  private boolean qzD;
  private boolean qzE;
  private boolean qzF;
  private boolean qzG;
  private boolean qzH;
  private boolean qzI;
  private boolean qzJ;
  private long qzK;
  private long qzL;
  private Calendar qzM;
  private List<com.tencent.mm.plugin.collect.model.h> qzN;
  private ListView qzv;
  private b qzw;
  private LinearLayout qzx;
  private CollectPullDownView qzy;
  private TextView qzz;
  private int retryCount;
  private Dialog tipDialog;
  private int type;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(64057);
    this.qzB = false;
    this.qzC = false;
    this.qzD = false;
    this.qzE = false;
    this.qzF = false;
    this.qzG = false;
    this.qzH = true;
    this.qzI = false;
    this.qzJ = false;
    this.type = 0;
    this.limit = 20;
    this.qwC = 0;
    this.retryCount = 0;
    this.qzK = 0L;
    this.qzL = 0L;
    this.qzN = new ArrayList();
    AppMethodBeat.o(64057);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(64066);
    Log.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    doSceneProgress(new r(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false);
    this.retryCount += 1;
    AppMethodBeat.o(64066);
  }
  
  private void akP(String paramString)
  {
    AppMethodBeat.i(64063);
    if (this.qzw.getCount() == 0)
    {
      Log.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!Util.isNullOrNil(paramString)) {
        this.qzz.setText(paramString);
      }
      for (;;)
      {
        bIo();
        AppMethodBeat.o(64063);
        return;
        if (this.qzG)
        {
          this.qzz.setText(getString(2131757660));
        }
        else
        {
          paramString = getString(2131757660) + getString(2131757661);
          this.qzz.setText(paramString);
        }
      }
    }
    if (!Util.isNullOrNil(paramString)) {
      Toast.makeText(getContext(), paramString, 1).show();
    }
    AppMethodBeat.o(64063);
  }
  
  private void bIo()
  {
    AppMethodBeat.i(64062);
    this.qzv.setVisibility(8);
    this.qzx.setVisibility(0);
    this.qzz.setVisibility(0);
    AppMethodBeat.o(64062);
  }
  
  private void cAh()
  {
    AppMethodBeat.i(64061);
    this.qzy.scrollTo(0, this.qzy.getTopHeight());
    AppMethodBeat.o(64061);
  }
  
  private void cAi()
  {
    AppMethodBeat.i(64065);
    int i = this.qzw.getCount();
    if (i > 0)
    {
      long l = this.qzw.Fd(i - 1).qwd;
      if (l < this.qzL)
      {
        Log.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.qzL) });
        this.qzL = l;
      }
    }
    Log.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.qzL) });
    doSceneProgress(new r(this.type, this.qzL, this.limit, 0), false);
    this.qzD = true;
    AppMethodBeat.o(64065);
  }
  
  private void kP(boolean paramBoolean)
  {
    AppMethodBeat.i(64064);
    CollectPullDownView localCollectPullDownView = this.qzy;
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
    return 2131493666;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64059);
    this.qzv = ((ListView)findViewById(2131298851));
    this.qzx = ((LinearLayout)findViewById(2131298849));
    this.qzz = ((TextView)findViewById(2131298850));
    this.qdm = aa.jQ(this).inflate(2131493668, this.qzv, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this, 5)));
    this.qzv.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this, 10)));
    this.qzv.addFooterView(localView, null, true);
    this.qzv.setOverScrollMode(2);
    this.qzw = new b(this);
    this.qzv.setAdapter(this.qzw);
    this.qzv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        Log.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
          Log.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView.putExtra("key_type", paramAnonymousAdapterView.type);
        paramAnonymousView.putExtra("key_timestamp", paramAnonymousAdapterView.qwd);
        paramAnonymousView.putExtra("key_from_scene", 2);
        paramAnonymousAdapterView = CollectBillListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.axQ(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.CyF.a(13944, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(64053);
      }
    });
    this.qzv.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.qzy = ((CollectPullDownView)findViewById(2131298853));
    this.qzy.setTopViewVisible(false);
    this.qzy.setIsTopShowAll(false);
    this.qzy.setBottomViewVisible(true);
    this.qzy.setIsBottomShowAll(false);
    this.qzy.setCanOverScrool(true);
    this.qzy.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean cAk()
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
    this.qzy.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean cAl()
      {
        AppMethodBeat.i(64055);
        if (CollectBillListUI.f(CollectBillListUI.this).getVisibility() == 0)
        {
          Log.d("MicroMsg.CollectBillListUI", "empty view");
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
    this.qzy.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean cAm()
      {
        AppMethodBeat.i(64056);
        Log.d("MicroMsg.CollectBillListUI", "top load");
        AppMethodBeat.o(64056);
        return true;
      }
    });
    this.qzy.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean cAj()
      {
        AppMethodBeat.i(64049);
        Log.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[] { Boolean.valueOf(CollectBillListUI.g(CollectBillListUI.this)), Boolean.valueOf(CollectBillListUI.h(CollectBillListUI.this)) });
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
    setMMTitle(2131757662);
    if (this.qzJ) {
      addIconOptionMenu(0, 2131689980, new MenuItem.OnMenuItemClickListener()
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
    cAi();
    com.tencent.mm.plugin.report.service.h.CyF.a(13944, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(64058);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64060);
    if ((paramq instanceof r))
    {
      paramq = (r)paramq;
      if (this.tipDialog.isShowing()) {
        this.tipDialog.dismiss();
      }
      this.qzy.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq.qwC == 0)
        {
          if (this.qzF)
          {
            Log.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(64060);
            return true;
          }
          if (paramq.qwD == 1)
          {
            this.qzH = paramq.iGD;
            if (!paramq.qwH.isEmpty())
            {
              paramString = this.qzw;
              List localList = paramq.qwH;
              paramString.qzs.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.qzK = ((com.tencent.mm.plugin.collect.model.h)paramq.qwH.get(0)).qwd;
              this.qzE = false;
              this.qzC = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.qzH = true;
            break;
            this.qzG = paramq.iGD;
            this.qzv.setVisibility(0);
            this.qzx.setVisibility(8);
            if (paramq.isRetry)
            {
              if (!paramq.qwH.isEmpty()) {
                this.qzN.addAll(paramq.qwH);
              }
              if ((paramq.qwE == 0) && (paramq.qwF > 0) && (paramq.qwH.isEmpty()))
              {
                Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramq.qwF, paramq.qwd, paramq.qwD, paramq.qwC);
                AppMethodBeat.o(64060);
                return true;
              }
              this.retryCount = 0;
              if (this.qzN.size() > 0) {
                this.qzw.dd(this.qzN);
              }
              for (;;)
              {
                this.qzD = false;
                this.qzL = paramq.qwd;
                cAh();
                kP(this.qzG);
                break;
                Log.i("MicroMsg.CollectBillListUI", "retry data is empty");
                akP(paramq.qwG);
              }
            }
            if (!paramq.qwH.isEmpty())
            {
              this.qzw.dd(paramq.qwH);
              this.qzL = ((com.tencent.mm.plugin.collect.model.h)paramq.qwH.get(paramq.qwH.size() - 1)).qwd;
              if (this.qzL > paramq.qwd)
              {
                Log.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.qzL = paramq.qwd;
              }
              for (;;)
              {
                this.qzD = false;
                cAh();
                kP(this.qzG);
                break;
                Log.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.qzL), Long.valueOf(paramq.qwd) });
              }
            }
            if ((paramq.qwE == 0) && (paramq.qwF > 0))
            {
              Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramq.qwF), Long.valueOf(paramq.qwd) });
              a(paramq.qwF, paramq.qwd, paramq.qwD, paramq.qwC);
              this.qzN.clear();
            }
            else
            {
              this.qzD = false;
              cAh();
              Log.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              akP(paramq.qwG);
              kP(this.qzG);
            }
          }
        }
        this.qzG = paramq.iGD;
        if (paramq.isRetry)
        {
          if (!paramq.qwH.isEmpty()) {
            this.qzN.addAll(paramq.qwH);
          }
          if ((paramq.qwE == 0) && (paramq.qwF > 0))
          {
            Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramq.qwF, paramq.qwd, paramq.qwD, paramq.qwC);
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.retryCount = 0;
            this.qzH = true;
            this.qzL = paramq.qwd;
            if (paramq.qwE == 0) {}
            for (this.qzG = false;; this.qzG = true)
            {
              if (this.qzN.size() <= 0) {
                break label861;
              }
              this.qzw.setData(this.qzN);
              break;
            }
            label861:
            Log.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            bIo();
            if (!Util.isNullOrNil(paramq.qwG))
            {
              this.qzz.setText(paramq.qwG);
              this.qzz.setVisibility(0);
            }
            paramString = this.qzw;
            paramString.qzs.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramq.qwH.isEmpty())
        {
          this.qzw.setData(paramq.qwH);
          this.qzK = ((com.tencent.mm.plugin.collect.model.h)paramq.qwH.get(0)).qwd;
          this.qzL = ((com.tencent.mm.plugin.collect.model.h)paramq.qwH.get(paramq.qwH.size() - 1)).qwd;
        }
        for (;;)
        {
          this.qzF = false;
          this.qzH = false;
          break;
          if ((paramq.qwE == 0) && (paramq.qwF > 0))
          {
            Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramq.qwF), Long.valueOf(paramq.qwd) });
            a(paramq.qwF, paramq.qwd, paramq.qwD, paramq.qwC);
            this.qzN.clear();
          }
          else
          {
            bIo();
          }
        }
      }
      Log.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.qwC), Integer.valueOf(paramq.qwD) });
      if (paramq.qwC == 0) {
        if (paramq.qwD == 0)
        {
          this.qzD = false;
          cAh();
        }
      }
      for (;;)
      {
        if (this.qzw.isEmpty()) {
          bIo();
        }
        Toast.makeText(this, 2131757659, 1).show();
        AppMethodBeat.o(64060);
        return true;
        this.qzE = false;
        continue;
        this.qzF = false;
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