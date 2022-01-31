package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.collect.b.q;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI
  extends WalletBaseUI
{
  private Dialog ftk;
  private int iHJ = 0;
  private ListView iJU;
  private b iJV;
  private LinearLayout iJW;
  private CollectPullDownView iJX;
  private TextView iJY;
  private Dialog iJZ;
  private boolean iKa = false;
  private boolean iKb = false;
  private boolean iKc = false;
  private boolean iKd = false;
  private boolean iKe = false;
  private boolean iKf = false;
  private boolean iKg = true;
  private boolean iKh = false;
  private boolean iKi = false;
  private long iKj = 0L;
  private long iKk = 0L;
  private Calendar iKl;
  private List<com.tencent.mm.plugin.collect.b.h> iKm = new ArrayList();
  private View iwf;
  private int limit = 20;
  private int retryCount = 0;
  private int type = 0;
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a(new q(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false, false);
    this.retryCount += 1;
  }
  
  private void aES()
  {
    this.iJX.scrollTo(0, this.iJX.getTopHeight());
  }
  
  private void aET()
  {
    int i = this.iJV.getCount();
    if (i > 0)
    {
      long l = this.iJV.pz(i - 1).iHh;
      if (l < this.iKk)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.iKk) });
        this.iKk = l;
      }
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.iKk) });
    a(new q(this.type, this.iKk, this.limit, 0), false, false);
    this.iKc = true;
  }
  
  private void ajT()
  {
    this.iJU.setVisibility(8);
    this.iJW.setVisibility(0);
    this.iJY.setVisibility(0);
  }
  
  private void eL(boolean paramBoolean)
  {
    CollectPullDownView localCollectPullDownView = this.iJX;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localCollectPullDownView.setBottomViewVisible(paramBoolean);
      return;
    }
  }
  
  private void zy(String paramString)
  {
    if (this.iJV.getCount() == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!bk.bl(paramString))
      {
        this.iJY.setText(paramString);
        ajT();
      }
    }
    while (bk.bl(paramString)) {
      for (;;)
      {
        return;
        if (this.iKf)
        {
          this.iJY.setText(getString(a.i.collect_bill_list_empty_text1));
        }
        else
        {
          paramString = getString(a.i.collect_bill_list_empty_text1) + getString(a.i.collect_bill_list_empty_text2);
          this.iJY.setText(paramString);
        }
      }
    }
    Toast.makeText(this.mController.uMN, paramString, 1).show();
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof q))
    {
      paramm = (q)paramm;
      if (this.ftk.isShowing()) {
        this.ftk.dismiss();
      }
      this.iJX.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramm.iHJ == 0)
        {
          if (this.iKe)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            return true;
          }
          if (paramm.iHK == 1)
          {
            this.iKg = paramm.dYj;
            if (!paramm.iHN.isEmpty())
            {
              paramString = this.iJV;
              List localList = paramm.iHN;
              paramString.iJQ.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.iKj = ((com.tencent.mm.plugin.collect.b.h)paramm.iHN.get(0)).iHh;
              this.iKd = false;
              this.iKb = false;
            }
          }
          for (;;)
          {
            return true;
            this.iKg = true;
            break;
            this.iKf = paramm.dYj;
            this.iJU.setVisibility(0);
            this.iJW.setVisibility(8);
            if (paramm.iHI)
            {
              if (!paramm.iHN.isEmpty()) {
                this.iKm.addAll(paramm.iHN);
              }
              if ((paramm.iHL == 0) && (paramm.iHM > 0) && (paramm.iHN.isEmpty()))
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramm.iHM, paramm.iHh, paramm.iHK, paramm.iHJ);
                return true;
              }
              this.retryCount = 0;
              if (this.iKm.size() > 0) {
                this.iJV.aX(this.iKm);
              }
              for (;;)
              {
                this.iKc = false;
                this.iKk = paramm.iHh;
                aES();
                eL(this.iKf);
                break;
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "retry data is empty");
                zy(paramm.gfH);
              }
            }
            if (!paramm.iHN.isEmpty())
            {
              this.iJV.aX(paramm.iHN);
              this.iKk = ((com.tencent.mm.plugin.collect.b.h)paramm.iHN.get(paramm.iHN.size() - 1)).iHh;
              if (this.iKk > paramm.iHh)
              {
                com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.iKk = paramm.iHh;
              }
              for (;;)
              {
                this.iKc = false;
                aES();
                eL(this.iKf);
                break;
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.iKk), Long.valueOf(paramm.iHh) });
              }
            }
            if ((paramm.iHL == 0) && (paramm.iHM > 0))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramm.iHM), Long.valueOf(paramm.iHh) });
              a(paramm.iHM, paramm.iHh, paramm.iHK, paramm.iHJ);
              this.iKm.clear();
            }
            else
            {
              this.iKc = false;
              aES();
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              zy(paramm.gfH);
              eL(this.iKf);
            }
          }
        }
        this.iKf = paramm.dYj;
        if (paramm.iHI)
        {
          if (!paramm.iHN.isEmpty()) {
            this.iKm.addAll(paramm.iHN);
          }
          if ((paramm.iHL == 0) && (paramm.iHM > 0))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramm.iHM, paramm.iHh, paramm.iHK, paramm.iHJ);
          }
          for (;;)
          {
            return true;
            this.retryCount = 0;
            this.iKg = true;
            this.iKk = paramm.iHh;
            if (paramm.iHL == 0) {}
            for (this.iKf = false;; this.iKf = true)
            {
              if (this.iKm.size() <= 0) {
                break label831;
              }
              this.iJV.setData(this.iKm);
              break;
            }
            label831:
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            ajT();
            if (!bk.bl(paramm.gfH))
            {
              this.iJY.setText(paramm.gfH);
              this.iJY.setVisibility(0);
            }
            paramString = this.iJV;
            paramString.iJQ.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramm.iHN.isEmpty())
        {
          this.iJV.setData(paramm.iHN);
          this.iKj = ((com.tencent.mm.plugin.collect.b.h)paramm.iHN.get(0)).iHh;
          this.iKk = ((com.tencent.mm.plugin.collect.b.h)paramm.iHN.get(paramm.iHN.size() - 1)).iHh;
        }
        for (;;)
        {
          this.iKe = false;
          this.iKg = false;
          break;
          if ((paramm.iHL == 0) && (paramm.iHM > 0))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramm.iHM), Long.valueOf(paramm.iHh) });
            a(paramm.iHM, paramm.iHh, paramm.iHK, paramm.iHJ);
            this.iKm.clear();
          }
          else
          {
            ajT();
          }
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.iHJ), Integer.valueOf(paramm.iHK) });
      if (paramm.iHJ == 0) {
        if (paramm.iHK == 0)
        {
          this.iKc = false;
          aES();
        }
      }
      for (;;)
      {
        if (this.iJV.isEmpty()) {
          ajT();
        }
        Toast.makeText(this, a.i.collect_bill_item_load_fail_text, 1).show();
        return true;
        this.iKd = false;
        continue;
        this.iKe = false;
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.collect_bill_list;
  }
  
  protected final void initView()
  {
    this.iJU = ((ListView)findViewById(a.f.collect_bill_list_lv));
    this.iJW = ((LinearLayout)findViewById(a.f.collect_bill_list_empty_ll));
    this.iJY = ((TextView)findViewById(a.f.collect_bill_list_empty_tv));
    this.iwf = com.tencent.mm.ui.y.gt(this).inflate(a.g.collect_bill_list_loading_view, this.iJU, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, a.fromDPToPix(this, 5)));
    this.iJU.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, a.fromDPToPix(this, 10)));
    this.iJU.addFooterView(localView, null, true);
    this.iJU.setOverScrollMode(2);
    this.iJV = new b(this);
    this.iJU.setAdapter(this.iJV);
    this.iJU.setOnItemClickListener(new CollectBillListUI.7(this));
    this.iJU.setOnScrollListener(new CollectBillListUI.8(this));
    this.iJX = ((CollectPullDownView)findViewById(a.f.collect_bill_list_pull_down_view));
    this.iJX.setTopViewVisible(false);
    this.iJX.setIsTopShowAll(false);
    this.iJX.setBottomViewVisible(true);
    this.iJX.setIsBottomShowAll(false);
    this.iJX.setCanOverScrool(true);
    this.iJX.setAtTopCallBack(new CollectBillListUI.9(this));
    this.iJX.setAtBottomCallBack(new CollectBillListUI.10(this));
    this.iJX.setOnTopLoadDataListener(new CollectBillListUI.11(this));
    this.iJX.setOnBottomLoadDataListener(new MMPullDownView.e()
    {
      public final boolean aEU()
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[] { Boolean.valueOf(CollectBillListUI.g(CollectBillListUI.this)), Boolean.valueOf(CollectBillListUI.h(CollectBillListUI.this)) });
        if ((!CollectBillListUI.g(CollectBillListUI.this)) && (!CollectBillListUI.h(CollectBillListUI.this)))
        {
          CollectBillListUI.i(CollectBillListUI.this);
          CollectBillListUI.j(CollectBillListUI.this);
          return false;
        }
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    setMMTitle(a.i.collect_bill_list_title);
    if (this.iKi) {
      addIconOptionMenu(0, a.h.collect_bill_filter_icon, new CollectBillListUI.1(this));
    }
    this.ftk = g.a(this, false, new CollectBillListUI.3(this));
    aET();
    com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI
 * JD-Core Version:    0.7.0.1
 */