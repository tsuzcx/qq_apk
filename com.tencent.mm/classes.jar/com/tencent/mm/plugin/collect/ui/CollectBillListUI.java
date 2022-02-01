package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@c(0)
public class CollectBillListUI
  extends WalletBaseUI
{
  private int limit;
  private int retryCount;
  private int tVD;
  private Dialog tYA;
  private boolean tYB;
  private boolean tYC;
  private boolean tYD;
  private boolean tYE;
  private boolean tYF;
  private boolean tYG;
  private boolean tYH;
  private boolean tYI;
  private boolean tYJ;
  private long tYK;
  private long tYL;
  private Calendar tYM;
  private List<com.tencent.mm.plugin.collect.model.h> tYN;
  private ListView tYv;
  private b tYw;
  private LinearLayout tYx;
  private CollectPullDownView tYy;
  private TextView tYz;
  private Dialog tipDialog;
  private int type;
  private View tzj;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(64057);
    this.tYB = false;
    this.tYC = false;
    this.tYD = false;
    this.tYE = false;
    this.tYF = false;
    this.tYG = false;
    this.tYH = true;
    this.tYI = false;
    this.tYJ = false;
    this.type = 0;
    this.limit = 20;
    this.tVD = 0;
    this.retryCount = 0;
    this.tYK = 0L;
    this.tYL = 0L;
    this.tYN = new ArrayList();
    AppMethodBeat.o(64057);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(64066);
    Log.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    doSceneProgress(new s(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false);
    this.retryCount += 1;
    AppMethodBeat.o(64066);
  }
  
  private void asF(String paramString)
  {
    AppMethodBeat.i(64063);
    if (this.tYw.getCount() == 0)
    {
      Log.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!Util.isNullOrNil(paramString)) {
        this.tYz.setText(paramString);
      }
      for (;;)
      {
        bTY();
        AppMethodBeat.o(64063);
        return;
        if (this.tYG)
        {
          this.tYz.setText(getString(a.i.collect_bill_list_empty_text1));
        }
        else
        {
          paramString = getString(a.i.collect_bill_list_empty_text1) + getString(a.i.collect_bill_list_empty_text2);
          this.tYz.setText(paramString);
        }
      }
    }
    if (!Util.isNullOrNil(paramString)) {
      Toast.makeText(getContext(), paramString, 1).show();
    }
    AppMethodBeat.o(64063);
  }
  
  private void bTY()
  {
    AppMethodBeat.i(64062);
    this.tYv.setVisibility(8);
    this.tYx.setVisibility(0);
    this.tYz.setVisibility(0);
    AppMethodBeat.o(64062);
  }
  
  private void cOH()
  {
    AppMethodBeat.i(64061);
    this.tYy.scrollTo(0, this.tYy.getTopHeight());
    AppMethodBeat.o(64061);
  }
  
  private void cOI()
  {
    AppMethodBeat.i(64065);
    int i = this.tYw.getCount();
    if (i > 0)
    {
      long l = this.tYw.IL(i - 1).tVc;
      if (l < this.tYL)
      {
        Log.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.tYL) });
        this.tYL = l;
      }
    }
    Log.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.tYL) });
    doSceneProgress(new s(this.type, this.tYL, this.limit, 0), false);
    this.tYD = true;
    AppMethodBeat.o(64065);
  }
  
  private void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(64064);
    CollectPullDownView localCollectPullDownView = this.tYy;
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
    return a.g.collect_bill_list;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64059);
    this.tYv = ((ListView)findViewById(a.f.collect_bill_list_lv));
    this.tYx = ((LinearLayout)findViewById(a.f.collect_bill_list_empty_ll));
    this.tYz = ((TextView)findViewById(a.f.collect_bill_list_empty_tv));
    this.tzj = ad.kS(this).inflate(a.g.collect_bill_list_loading_view, this.tYv, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(this, 5)));
    this.tYv.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(this, 10)));
    this.tYv.addFooterView(localView, null, true);
    this.tYv.setOverScrollMode(2);
    this.tYw = new b(this);
    this.tYv.setAdapter(this.tYw);
    this.tYv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
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
        paramAnonymousView.putExtra("key_timestamp", paramAnonymousAdapterView.tVc);
        paramAnonymousView.putExtra("key_from_scene", 2);
        paramAnonymousAdapterView = CollectBillListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(64053);
      }
    });
    this.tYv.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.tYy = ((CollectPullDownView)findViewById(a.f.collect_bill_list_pull_down_view));
    this.tYy.setTopViewVisible(false);
    this.tYy.setIsTopShowAll(false);
    this.tYy.setBottomViewVisible(true);
    this.tYy.setIsBottomShowAll(false);
    this.tYy.setCanOverScrool(true);
    this.tYy.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean cOK()
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
    this.tYy.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean cOL()
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
    this.tYy.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean cOM()
      {
        AppMethodBeat.i(64056);
        Log.d("MicroMsg.CollectBillListUI", "top load");
        AppMethodBeat.o(64056);
        return true;
      }
    });
    this.tYy.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean cOJ()
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
    setMMTitle(a.i.collect_bill_list_title);
    if (this.tYJ) {
      addIconOptionMenu(0, a.h.collect_bill_filter_icon, new MenuItem.OnMenuItemClickListener()
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
    this.tipDialog = i.a(this, false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    cOI();
    com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(64058);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64060);
    if ((paramq instanceof s))
    {
      paramq = (s)paramq;
      if (this.tipDialog.isShowing()) {
        this.tipDialog.dismiss();
      }
      this.tYy.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq.tVD == 0)
        {
          if (this.tYF)
          {
            Log.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(64060);
            return true;
          }
          if (paramq.tVE == 1)
          {
            this.tYH = paramq.lwF;
            if (!paramq.tVI.isEmpty())
            {
              paramString = this.tYw;
              List localList = paramq.tVI;
              paramString.tYs.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.tYK = ((com.tencent.mm.plugin.collect.model.h)paramq.tVI.get(0)).tVc;
              this.tYE = false;
              this.tYC = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.tYH = true;
            break;
            this.tYG = paramq.lwF;
            this.tYv.setVisibility(0);
            this.tYx.setVisibility(8);
            if (paramq.isRetry)
            {
              if (!paramq.tVI.isEmpty()) {
                this.tYN.addAll(paramq.tVI);
              }
              if ((paramq.tVF == 0) && (paramq.tVG > 0) && (paramq.tVI.isEmpty()))
              {
                Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramq.tVG, paramq.tVc, paramq.tVE, paramq.tVD);
                AppMethodBeat.o(64060);
                return true;
              }
              this.retryCount = 0;
              if (this.tYN.size() > 0) {
                this.tYw.dc(this.tYN);
              }
              for (;;)
              {
                this.tYD = false;
                this.tYL = paramq.tVc;
                cOH();
                mb(this.tYG);
                break;
                Log.i("MicroMsg.CollectBillListUI", "retry data is empty");
                asF(paramq.tVH);
              }
            }
            if (!paramq.tVI.isEmpty())
            {
              this.tYw.dc(paramq.tVI);
              this.tYL = ((com.tencent.mm.plugin.collect.model.h)paramq.tVI.get(paramq.tVI.size() - 1)).tVc;
              if (this.tYL > paramq.tVc)
              {
                Log.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.tYL = paramq.tVc;
              }
              for (;;)
              {
                this.tYD = false;
                cOH();
                mb(this.tYG);
                break;
                Log.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.tYL), Long.valueOf(paramq.tVc) });
              }
            }
            if ((paramq.tVF == 0) && (paramq.tVG > 0))
            {
              Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramq.tVG), Long.valueOf(paramq.tVc) });
              a(paramq.tVG, paramq.tVc, paramq.tVE, paramq.tVD);
              this.tYN.clear();
            }
            else
            {
              this.tYD = false;
              cOH();
              Log.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              asF(paramq.tVH);
              mb(this.tYG);
            }
          }
        }
        this.tYG = paramq.lwF;
        if (paramq.isRetry)
        {
          if (!paramq.tVI.isEmpty()) {
            this.tYN.addAll(paramq.tVI);
          }
          if ((paramq.tVF == 0) && (paramq.tVG > 0))
          {
            Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramq.tVG, paramq.tVc, paramq.tVE, paramq.tVD);
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.retryCount = 0;
            this.tYH = true;
            this.tYL = paramq.tVc;
            if (paramq.tVF == 0) {}
            for (this.tYG = false;; this.tYG = true)
            {
              if (this.tYN.size() <= 0) {
                break label861;
              }
              this.tYw.setData(this.tYN);
              break;
            }
            label861:
            Log.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            bTY();
            if (!Util.isNullOrNil(paramq.tVH))
            {
              this.tYz.setText(paramq.tVH);
              this.tYz.setVisibility(0);
            }
            paramString = this.tYw;
            paramString.tYs.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramq.tVI.isEmpty())
        {
          this.tYw.setData(paramq.tVI);
          this.tYK = ((com.tencent.mm.plugin.collect.model.h)paramq.tVI.get(0)).tVc;
          this.tYL = ((com.tencent.mm.plugin.collect.model.h)paramq.tVI.get(paramq.tVI.size() - 1)).tVc;
        }
        for (;;)
        {
          this.tYF = false;
          this.tYH = false;
          break;
          if ((paramq.tVF == 0) && (paramq.tVG > 0))
          {
            Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramq.tVG), Long.valueOf(paramq.tVc) });
            a(paramq.tVG, paramq.tVc, paramq.tVE, paramq.tVD);
            this.tYN.clear();
          }
          else
          {
            bTY();
          }
        }
      }
      Log.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.tVD), Integer.valueOf(paramq.tVE) });
      if (paramq.tVD == 0) {
        if (paramq.tVE == 0)
        {
          this.tYD = false;
          cOH();
        }
      }
      for (;;)
      {
        if (this.tYw.isEmpty()) {
          bTY();
        }
        Toast.makeText(this, a.i.collect_bill_item_load_fail_text, 1).show();
        AppMethodBeat.o(64060);
        return true;
        this.tYE = false;
        continue;
        this.tYF = false;
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