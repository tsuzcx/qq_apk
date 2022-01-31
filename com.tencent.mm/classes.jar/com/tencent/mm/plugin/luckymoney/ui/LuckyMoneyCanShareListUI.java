package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI
  extends LuckyMoneyBaseUI
{
  private int Fb;
  private boolean icT;
  private List<r> oja;
  private boolean orF;
  private String orO;
  private MMLoadMoreListView osm;
  private e osn;
  
  public LuckyMoneyCanShareListUI()
  {
    AppMethodBeat.i(42639);
    this.Fb = 0;
    this.oja = new LinkedList();
    this.orF = true;
    this.icT = false;
    this.orO = "";
    AppMethodBeat.o(42639);
  }
  
  private void bNR()
  {
    AppMethodBeat.i(42643);
    this.icT = true;
    if (this.Fb == 0) {
      this.orO = "";
    }
    doSceneProgress(new ai(10, this.Fb, 3, "", "v1.0", this.orO));
    AppMethodBeat.o(42643);
  }
  
  public int getLayoutId()
  {
    return 2130970035;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42641);
    setBackBtn(new LuckyMoneyCanShareListUI.1(this));
    this.osm = ((MMLoadMoreListView)findViewById(2131825718));
    setMMTitle(getString(2131301244));
    this.osn = new f(getContext());
    this.osm.setAdapter(this.osn);
    this.osm.setOnItemClickListener(new LuckyMoneyCanShareListUI.2(this));
    this.osm.setOnLoadMoreListener(new LuckyMoneyCanShareListUI.3(this));
    AppMethodBeat.o(42641);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42640);
    super.onCreate(paramBundle);
    initView();
    bNR();
    AppMethodBeat.o(42640);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42642);
    if (((paramm instanceof ai)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ai)paramm;
      paramm = paramString.opr.onL;
      this.orO = paramString.opa;
      if (paramm != null)
      {
        paramInt1 = 0;
        while (paramInt1 < paramm.size())
        {
          this.oja.add(paramm.get(paramInt1));
          paramInt1 += 1;
        }
        this.Fb += paramm.size();
        this.orF = paramString.bNr();
        this.icT = false;
        this.osn.ci(this.oja);
      }
      if (this.orF) {
        this.osm.dDY();
      }
      for (;;)
      {
        AppMethodBeat.o(42642);
        return true;
        this.osm.dDZ();
      }
    }
    AppMethodBeat.o(42642);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI
 * JD-Core Version:    0.7.0.1
 */