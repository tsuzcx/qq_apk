package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.collect.model.g;
import com.tencent.mm.plugin.collect.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.k;
import com.tencent.mm.wallet_core.ui.l;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@c(0)
public class CollectBillListUI
  extends WalletBaseUI
{
  private int limit;
  private int retryCount;
  private Dialog tipDialog;
  private int type;
  private View wDF;
  private int wYX;
  private ListView xbN;
  private b xbO;
  private LinearLayout xbP;
  private CollectPullDownView xbQ;
  private TextView xbR;
  private Dialog xbS;
  private boolean xbT;
  private boolean xbU;
  private boolean xbV;
  private boolean xbW;
  private boolean xbX;
  private boolean xbY;
  private boolean xbZ;
  private boolean xca;
  private boolean xcb;
  private long xcc;
  private long xcd;
  private Calendar xce;
  private List<g> xcf;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(64057);
    this.xbT = false;
    this.xbU = false;
    this.xbV = false;
    this.xbW = false;
    this.xbX = false;
    this.xbY = false;
    this.xbZ = true;
    this.xca = false;
    this.xcb = false;
    this.type = 0;
    this.limit = 20;
    this.wYX = 0;
    this.retryCount = 0;
    this.xcc = 0L;
    this.xcd = 0L;
    this.xcf = new ArrayList();
    AppMethodBeat.o(64057);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(64066);
    Log.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    doSceneProgress(new q(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false);
    this.retryCount += 1;
    AppMethodBeat.o(64066);
  }
  
  private void amk(String paramString)
  {
    AppMethodBeat.i(64063);
    if (this.xbO.getCount() == 0)
    {
      Log.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!Util.isNullOrNil(paramString)) {
        this.xbR.setText(paramString);
      }
      for (;;)
      {
        cul();
        AppMethodBeat.o(64063);
        return;
        if (this.xbY)
        {
          this.xbR.setText(getString(a.i.collect_bill_list_empty_text1));
        }
        else
        {
          paramString = getString(a.i.collect_bill_list_empty_text1) + getString(a.i.collect_bill_list_empty_text2);
          this.xbR.setText(paramString);
        }
      }
    }
    if (!Util.isNullOrNil(paramString)) {
      Toast.makeText(getContext(), paramString, 1).show();
    }
    AppMethodBeat.o(64063);
  }
  
  private void cul()
  {
    AppMethodBeat.i(64062);
    this.xbN.setVisibility(8);
    this.xbP.setVisibility(0);
    this.xbR.setVisibility(0);
    AppMethodBeat.o(64062);
  }
  
  private void dsm()
  {
    AppMethodBeat.i(64061);
    this.xbQ.scrollTo(0, this.xbQ.getTopHeight());
    AppMethodBeat.o(64061);
  }
  
  private void dsn()
  {
    AppMethodBeat.i(64065);
    int i = this.xbO.getCount();
    if (i > 0)
    {
      long l = this.xbO.Jo(i - 1).wYy;
      if (l < this.xcd)
      {
        Log.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.xcd) });
        this.xcd = l;
      }
    }
    Log.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.xcd) });
    doSceneProgress(new q(this.type, this.xcd, this.limit, 0), false);
    this.xbV = true;
    AppMethodBeat.o(64065);
  }
  
  private void nw(boolean paramBoolean)
  {
    AppMethodBeat.i(64064);
    CollectPullDownView localCollectPullDownView = this.xbQ;
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
    this.xbN = ((ListView)findViewById(a.f.collect_bill_list_lv));
    this.xbP = ((LinearLayout)findViewById(a.f.collect_bill_list_empty_ll));
    this.xbR = ((TextView)findViewById(a.f.collect_bill_list_empty_tv));
    this.wDF = af.mU(this).inflate(a.g.collect_bill_list_loading_view, this.xbN, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(this, 5)));
    this.xbN.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(this, 10)));
    this.xbN.addFooterView(localView, null, true);
    this.xbN.setOverScrollMode(2);
    this.xbO = new b(this);
    this.xbN.setAdapter(this.xbO);
    this.xbN.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        Log.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView = new Intent(CollectBillListUI.this.getContext(), CollectBillUI.class);
        paramAnonymousAdapterView = (g)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          Log.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64053);
          return;
        }
        paramAnonymousView.putExtra("key_type", paramAnonymousAdapterView.type);
        paramAnonymousView.putExtra("key_timestamp", paramAnonymousAdapterView.wYy);
        paramAnonymousView.putExtra("key_from_scene", 2);
        paramAnonymousAdapterView = CollectBillListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.OAn.b(13944, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(64053);
      }
    });
    this.xbN.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.xbQ = ((CollectPullDownView)findViewById(a.f.collect_bill_list_pull_down_view));
    this.xbQ.setTopViewVisible(false);
    this.xbQ.setIsTopShowAll(false);
    this.xbQ.setBottomViewVisible(true);
    this.xbQ.setIsBottomShowAll(false);
    this.xbQ.setCanOverScrool(true);
    this.xbQ.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean dsp()
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
    this.xbQ.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean dsq()
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
    this.xbQ.setOnTopLoadDataListener(new CollectBillListUI.11(this));
    this.xbQ.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean dso()
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
    if (this.xcb) {
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
    this.tipDialog = l.a(this, false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    dsn();
    h.OAn.b(13944, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(64058);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(64060);
    if ((paramp instanceof q))
    {
      paramp = (q)paramp;
      if (this.tipDialog.isShowing()) {
        this.tipDialog.dismiss();
      }
      this.xbQ.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp.wYX == 0)
        {
          if (this.xbX)
          {
            Log.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(64060);
            return true;
          }
          if (paramp.wYY == 1)
          {
            this.xbZ = paramp.ooe;
            if (!paramp.wZc.isEmpty())
            {
              paramString = this.xbO;
              List localList = paramp.wZc;
              paramString.bMf.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.xcc = ((g)paramp.wZc.get(0)).wYy;
              this.xbW = false;
              this.xbU = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.xbZ = true;
            break;
            this.xbY = paramp.ooe;
            this.xbN.setVisibility(0);
            this.xbP.setVisibility(8);
            if (paramp.vBn)
            {
              if (!paramp.wZc.isEmpty()) {
                this.xcf.addAll(paramp.wZc);
              }
              if ((paramp.wYZ == 0) && (paramp.wZa > 0) && (paramp.wZc.isEmpty()))
              {
                Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramp.wZa, paramp.wYy, paramp.wYY, paramp.wYX);
                AppMethodBeat.o(64060);
                return true;
              }
              this.retryCount = 0;
              if (this.xcf.size() > 0) {
                this.xbO.eX(this.xcf);
              }
              for (;;)
              {
                this.xbV = false;
                this.xcd = paramp.wYy;
                dsm();
                nw(this.xbY);
                break;
                Log.i("MicroMsg.CollectBillListUI", "retry data is empty");
                amk(paramp.wZb);
              }
            }
            if (!paramp.wZc.isEmpty())
            {
              this.xbO.eX(paramp.wZc);
              this.xcd = ((g)paramp.wZc.get(paramp.wZc.size() - 1)).wYy;
              if (this.xcd > paramp.wYy)
              {
                Log.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.xcd = paramp.wYy;
              }
              for (;;)
              {
                this.xbV = false;
                dsm();
                nw(this.xbY);
                break;
                Log.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.xcd), Long.valueOf(paramp.wYy) });
              }
            }
            if ((paramp.wYZ == 0) && (paramp.wZa > 0))
            {
              Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramp.wZa), Long.valueOf(paramp.wYy) });
              a(paramp.wZa, paramp.wYy, paramp.wYY, paramp.wYX);
              this.xcf.clear();
            }
            else
            {
              this.xbV = false;
              dsm();
              Log.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              amk(paramp.wZb);
              nw(this.xbY);
            }
          }
        }
        this.xbY = paramp.ooe;
        if (paramp.vBn)
        {
          if (!paramp.wZc.isEmpty()) {
            this.xcf.addAll(paramp.wZc);
          }
          if ((paramp.wYZ == 0) && (paramp.wZa > 0))
          {
            Log.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramp.wZa, paramp.wYy, paramp.wYY, paramp.wYX);
          }
          for (;;)
          {
            AppMethodBeat.o(64060);
            return true;
            this.retryCount = 0;
            this.xbZ = true;
            this.xcd = paramp.wYy;
            if (paramp.wYZ == 0) {}
            for (this.xbY = false;; this.xbY = true)
            {
              if (this.xcf.size() <= 0) {
                break label861;
              }
              this.xbO.setData(this.xcf);
              break;
            }
            label861:
            Log.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            cul();
            if (!Util.isNullOrNil(paramp.wZb))
            {
              this.xbR.setText(paramp.wZb);
              this.xbR.setVisibility(0);
            }
            paramString = this.xbO;
            paramString.bMf.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramp.wZc.isEmpty())
        {
          this.xbO.setData(paramp.wZc);
          this.xcc = ((g)paramp.wZc.get(0)).wYy;
          this.xcd = ((g)paramp.wZc.get(paramp.wZc.size() - 1)).wYy;
        }
        for (;;)
        {
          this.xbX = false;
          this.xbZ = false;
          break;
          if ((paramp.wYZ == 0) && (paramp.wZa > 0))
          {
            Log.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramp.wZa), Long.valueOf(paramp.wYy) });
            a(paramp.wZa, paramp.wYy, paramp.wYY, paramp.wYX);
            this.xcf.clear();
          }
          else
          {
            cul();
          }
        }
      }
      Log.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.wYX), Integer.valueOf(paramp.wYY) });
      if (paramp.wYX == 0) {
        if (paramp.wYY == 0)
        {
          this.xbV = false;
          dsm();
        }
      }
      for (;;)
      {
        if (this.xbO.isEmpty()) {
          cul();
        }
        Toast.makeText(this, a.i.collect_bill_item_load_fail_text, 1).show();
        AppMethodBeat.o(64060);
        return true;
        this.xbW = false;
        continue;
        this.xbX = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI
 * JD-Core Version:    0.7.0.1
 */