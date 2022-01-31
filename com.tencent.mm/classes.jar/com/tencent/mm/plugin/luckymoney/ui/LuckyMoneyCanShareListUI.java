package com.tencent.mm.plugin.luckymoney.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.b.z;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI
  extends LuckyMoneyBaseUI
{
  private int El = 0;
  private boolean gDQ = false;
  private List<i> lLG = new LinkedList();
  private String lUF = "";
  private boolean lUw = true;
  private MMLoadMoreListView lVd;
  private d lVe;
  
  private void bge()
  {
    this.gDQ = true;
    if (this.El == 0) {
      this.lUF = "";
    }
    l(new z(10, this.El, 3, "", "v1.0", this.lUF));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramm instanceof z))
    {
      bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          paramString = (z)paramm;
          paramm = paramString.lRv.lQn;
          this.lUF = paramString.lRl;
          if (paramm != null)
          {
            paramInt1 = 0;
            while (paramInt1 < paramm.size())
            {
              this.lLG.add(paramm.get(paramInt1));
              paramInt1 += 1;
            }
            this.El += paramm.size();
            this.lUw = paramString.bfN();
            this.gDQ = false;
            this.lVe.bM(this.lLG);
          }
          if (!this.lUw) {
            break label157;
          }
          this.lVd.cAO();
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label157:
      this.lVd.cAP();
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_my_record_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new LuckyMoneyCanShareListUI.1(this));
    this.lVd = ((MMLoadMoreListView)findViewById(a.f.lucky_money_my_record_list));
    setMMTitle(getString(a.i.lucky_money_has_can_share_list_title));
    this.lVe = new e(this.mController.uMN);
    this.lVd.setAdapter(this.lVe);
    this.lVd.setOnItemClickListener(new LuckyMoneyCanShareListUI.2(this));
    this.lVd.setOnLoadMoreListener(new LuckyMoneyCanShareListUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    bge();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI
 * JD-Core Version:    0.7.0.1
 */