package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.collect.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI
  extends WalletBaseUI
{
  private Dialog gKM;
  private int kNM;
  private b kQA;
  private LinearLayout kQB;
  private CollectPullDownView kQC;
  private TextView kQD;
  private Dialog kQE;
  private boolean kQF;
  private boolean kQG;
  private boolean kQH;
  private boolean kQI;
  private boolean kQJ;
  private boolean kQK;
  private boolean kQL;
  private boolean kQM;
  private boolean kQN;
  private long kQO;
  private long kQP;
  private Calendar kQQ;
  private List<com.tencent.mm.plugin.collect.model.h> kQR;
  private ListView kQz;
  private View kxj;
  private int limit;
  private int retryCount;
  private int type;
  
  public CollectBillListUI()
  {
    AppMethodBeat.i(41195);
    this.kQF = false;
    this.kQG = false;
    this.kQH = false;
    this.kQI = false;
    this.kQJ = false;
    this.kQK = false;
    this.kQL = true;
    this.kQM = false;
    this.kQN = false;
    this.type = 0;
    this.limit = 20;
    this.kNM = 0;
    this.retryCount = 0;
    this.kQO = 0L;
    this.kQP = 0L;
    this.kQR = new ArrayList();
    AppMethodBeat.o(41195);
  }
  
  private void Jt(String paramString)
  {
    AppMethodBeat.i(41201);
    if (this.kQA.getCount() == 0)
    {
      ab.i("MicroMsg.CollectBillListUI", "show empty view");
      if (!bo.isNullOrNil(paramString)) {
        this.kQD.setText(paramString);
      }
      for (;;)
      {
        aEw();
        AppMethodBeat.o(41201);
        return;
        if (this.kQK)
        {
          this.kQD.setText(getString(2131298429));
        }
        else
        {
          paramString = getString(2131298429) + getString(2131298430);
          this.kQD.setText(paramString);
        }
      }
    }
    if (!bo.isNullOrNil(paramString)) {
      Toast.makeText(getContext(), paramString, 1).show();
    }
    AppMethodBeat.o(41201);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(41204);
    ab.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[] { Integer.valueOf(this.type), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    doSceneProgress(new q(this.type, paramLong, paramInt2, this.limit, paramInt3, paramInt1), false);
    this.retryCount += 1;
    AppMethodBeat.o(41204);
  }
  
  private void aEw()
  {
    AppMethodBeat.i(41200);
    this.kQz.setVisibility(8);
    this.kQB.setVisibility(0);
    this.kQD.setVisibility(0);
    AppMethodBeat.o(41200);
  }
  
  private void bii()
  {
    AppMethodBeat.i(41199);
    this.kQC.scrollTo(0, this.kQC.getTopHeight());
    AppMethodBeat.o(41199);
  }
  
  private void bij()
  {
    AppMethodBeat.i(41203);
    int i = this.kQA.getCount();
    if (i > 0)
    {
      long l = this.kQA.tP(i - 1).kNm;
      if (l < this.kQP)
      {
        ab.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[] { Long.valueOf(l), Long.valueOf(this.kQP) });
        this.kQP = l;
      }
    }
    ab.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.kQP) });
    doSceneProgress(new q(this.type, this.kQP, this.limit, 0), false);
    this.kQH = true;
    AppMethodBeat.o(41203);
  }
  
  private void gn(boolean paramBoolean)
  {
    AppMethodBeat.i(41202);
    CollectPullDownView localCollectPullDownView = this.kQC;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localCollectPullDownView.setBottomViewVisible(paramBoolean);
      AppMethodBeat.o(41202);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130969172;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41197);
    this.kQz = ((ListView)findViewById(2131822901));
    this.kQB = ((LinearLayout)findViewById(2131822902));
    this.kQD = ((TextView)findViewById(2131822903));
    this.kxj = w.hM(this).inflate(2130969174, this.kQz, false);
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, a.fromDPToPix(this, 5)));
    this.kQz.addHeaderView(localView, null, true);
    new View(this).setLayoutParams(new AbsListView.LayoutParams(-1, a.fromDPToPix(this, 10)));
    this.kQz.addFooterView(localView, null, true);
    this.kQz.setOverScrollMode(2);
    this.kQA = new b(this);
    this.kQz.setAdapter(this.kQA);
    this.kQz.setOnItemClickListener(new CollectBillListUI.7(this));
    this.kQz.setOnScrollListener(new CollectBillListUI.8(this));
    this.kQC = ((CollectPullDownView)findViewById(2131822900));
    this.kQC.setTopViewVisible(false);
    this.kQC.setIsTopShowAll(false);
    this.kQC.setBottomViewVisible(true);
    this.kQC.setIsBottomShowAll(false);
    this.kQC.setCanOverScrool(true);
    this.kQC.setAtTopCallBack(new CollectBillListUI.9(this));
    this.kQC.setAtBottomCallBack(new CollectBillListUI.10(this));
    this.kQC.setOnTopLoadDataListener(new CollectBillListUI.11(this));
    this.kQC.setOnBottomLoadDataListener(new CollectBillListUI.2(this));
    AppMethodBeat.o(41197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41196);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131298431);
    if (this.kQN) {
      addIconOptionMenu(0, 2131231152, new CollectBillListUI.1(this));
    }
    this.gKM = g.a(this, false, new CollectBillListUI.3(this));
    bij();
    com.tencent.mm.plugin.report.service.h.qsU.e(13944, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(41196);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41198);
    if ((paramm instanceof q))
    {
      paramm = (q)paramm;
      if (this.gKM.isShowing()) {
        this.gKM.dismiss();
      }
      this.kQC.setLoadDataEnd(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramm.kNM == 0)
        {
          if (this.kQJ)
          {
            ab.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
            AppMethodBeat.o(41198);
            return true;
          }
          if (paramm.kNN == 1)
          {
            this.kQL = paramm.fon;
            if (!paramm.kNQ.isEmpty())
            {
              paramString = this.kQA;
              List localList = paramm.kNQ;
              paramString.kQw.addAll(0, localList);
              paramString.notifyDataSetChanged();
              this.kQO = ((com.tencent.mm.plugin.collect.model.h)paramm.kNQ.get(0)).kNm;
              this.kQI = false;
              this.kQG = false;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(41198);
            return true;
            this.kQL = true;
            break;
            this.kQK = paramm.fon;
            this.kQz.setVisibility(0);
            this.kQB.setVisibility(8);
            if (paramm.isRetry)
            {
              if (!paramm.kNQ.isEmpty()) {
                this.kQR.addAll(paramm.kNQ);
              }
              if ((paramm.kNO == 0) && (paramm.kNP > 0) && (paramm.kNQ.isEmpty()))
              {
                ab.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
                a(paramm.kNP, paramm.kNm, paramm.kNN, paramm.kNM);
                AppMethodBeat.o(41198);
                return true;
              }
              this.retryCount = 0;
              if (this.kQR.size() > 0) {
                this.kQA.bm(this.kQR);
              }
              for (;;)
              {
                this.kQH = false;
                this.kQP = paramm.kNm;
                bii();
                gn(this.kQK);
                break;
                ab.i("MicroMsg.CollectBillListUI", "retry data is empty");
                Jt(paramm.hxt);
              }
            }
            if (!paramm.kNQ.isEmpty())
            {
              this.kQA.bm(paramm.kNQ);
              this.kQP = ((com.tencent.mm.plugin.collect.model.h)paramm.kNQ.get(paramm.kNQ.size() - 1)).kNm;
              if (this.kQP > paramm.kNm)
              {
                ab.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                this.kQP = paramm.kNm;
              }
              for (;;)
              {
                this.kQH = false;
                bii();
                gn(this.kQK);
                break;
                ab.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[] { Long.valueOf(this.kQP), Long.valueOf(paramm.kNm) });
              }
            }
            if ((paramm.kNO == 0) && (paramm.kNP > 0))
            {
              ab.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramm.kNP), Long.valueOf(paramm.kNm) });
              a(paramm.kNP, paramm.kNm, paramm.kNN, paramm.kNM);
              this.kQR.clear();
            }
            else
            {
              this.kQH = false;
              bii();
              ab.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
              Jt(paramm.hxt);
              gn(this.kQK);
            }
          }
        }
        this.kQK = paramm.fon;
        if (paramm.isRetry)
        {
          if (!paramm.kNQ.isEmpty()) {
            this.kQR.addAll(paramm.kNQ);
          }
          if ((paramm.kNO == 0) && (paramm.kNP > 0))
          {
            ab.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[] { Integer.valueOf(this.retryCount) });
            a(paramm.kNP, paramm.kNm, paramm.kNN, paramm.kNM);
          }
          for (;;)
          {
            AppMethodBeat.o(41198);
            return true;
            this.retryCount = 0;
            this.kQL = true;
            this.kQP = paramm.kNm;
            if (paramm.kNO == 0) {}
            for (this.kQK = false;; this.kQK = true)
            {
              if (this.kQR.size() <= 0) {
                break label861;
              }
              this.kQA.setData(this.kQR);
              break;
            }
            label861:
            ab.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
            aEw();
            if (!bo.isNullOrNil(paramm.hxt))
            {
              this.kQD.setText(paramm.hxt);
              this.kQD.setVisibility(0);
            }
            paramString = this.kQA;
            paramString.kQw.clear();
            paramString.notifyDataSetChanged();
          }
        }
        if (!paramm.kNQ.isEmpty())
        {
          this.kQA.setData(paramm.kNQ);
          this.kQO = ((com.tencent.mm.plugin.collect.model.h)paramm.kNQ.get(0)).kNm;
          this.kQP = ((com.tencent.mm.plugin.collect.model.h)paramm.kNQ.get(paramm.kNQ.size() - 1)).kNm;
        }
        for (;;)
        {
          this.kQJ = false;
          this.kQL = false;
          break;
          if ((paramm.kNO == 0) && (paramm.kNP > 0))
          {
            ab.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[] { Integer.valueOf(paramm.kNP), Long.valueOf(paramm.kNm) });
            a(paramm.kNP, paramm.kNm, paramm.kNN, paramm.kNM);
            this.kQR.clear();
          }
          else
          {
            aEw();
          }
        }
      }
      ab.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.kNM), Integer.valueOf(paramm.kNN) });
      if (paramm.kNM == 0) {
        if (paramm.kNN == 0)
        {
          this.kQH = false;
          bii();
        }
      }
      for (;;)
      {
        if (this.kQA.isEmpty()) {
          aEw();
        }
        Toast.makeText(this, 2131298428, 1).show();
        AppMethodBeat.o(41198);
        return true;
        this.kQI = false;
        continue;
        this.kQJ = false;
      }
    }
    AppMethodBeat.o(41198);
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