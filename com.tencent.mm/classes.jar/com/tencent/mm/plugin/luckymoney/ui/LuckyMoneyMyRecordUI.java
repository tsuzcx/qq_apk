package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.aa;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.z;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI
  extends LuckyMoneyBaseUI
{
  private int El = 0;
  private View fhl;
  private boolean gDQ = false;
  private ImageView iIS;
  private TextView iJY;
  private List<i> lLG = new LinkedList();
  private TextView lLM;
  public String lRy = "";
  private Map<String, Integer> lUD = new HashMap();
  public String lUF = "";
  private boolean lUw = true;
  private TextView lVM;
  private TextView lVN;
  private TextView lVO;
  private TextView lVP;
  private TextView lVQ;
  private TextView lVR;
  private TextView lVS;
  private String lVT;
  private int lVU = -1;
  public List<String> lVV = new ArrayList();
  private MMLoadMoreListView lVd;
  private d lVe;
  private int mType;
  
  private void bge()
  {
    this.gDQ = true;
    if (this.El == 0) {
      this.lUF = "";
    }
    l(new z(11, this.El, this.mType, this.lVT, "v1.0", this.lUF));
  }
  
  private void bgl()
  {
    this.lVS.setVisibility(8);
    this.fhl.findViewById(a.f.lucky_money_my_detail_receive_desc).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(a.i.lucky_money_my_send));
      str = getString(a.i.lucky_money_send_amount_title, new Object[] { q.Gl() });
      o.a(this.mController.uMN, this.lVM, str);
      this.lVO.setText(a.i.lucky_money_send_num_title);
      this.lVe = new e(this.mController.uMN);
      this.lVS.setVisibility(0);
    }
    for (;;)
    {
      this.lVd.setAdapter(this.lVe);
      a.b.a(this.iIS, q.Gj(), 0.0F, false);
      this.lVR.setText(getString(a.i.lucky_money_record_year_title, new Object[] { bk.pm(this.lVT) }));
      return;
      setMMTitle(getString(a.i.lucky_money_my_receive));
      str = getString(a.i.lucky_money_receive_amount_title, new Object[] { q.Gl() });
      o.a(this.mController.uMN, this.lVM, str);
      this.lVO.setText(a.i.lucky_money_receive_num_title);
      this.lVe = new c(this.mController.uMN);
      this.fhl.findViewById(a.f.lucky_money_my_detail_receive_desc).setVisibility(0);
    }
  }
  
  private int bgm()
  {
    if (this.mType == 1) {
      return 8;
    }
    return 9;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    label384:
    label538:
    boolean bool1;
    if ((paramm instanceof z)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (z)paramm;
        paramm = paramString.lRv.lQn;
        this.lUF = paramString.lRl;
        this.lRy = paramString.lRy;
        Object localObject2;
        if (this.El == 0)
        {
          this.lVV = paramString.lRw;
          this.lVT = paramString.lRx;
          localObject1 = findViewById(a.f.lucky_money_my_detail_year_select);
          localObject2 = (ImageView)findViewById(a.f.lucky_money_my_detail_year_icon);
          if (this.lVV.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new LuckyMoneyMyRecordUI.7(this));
          }
          this.lVR.setText(getString(a.i.lucky_money_record_year_title, new Object[] { this.lVT }));
        }
        Object localObject1 = paramString.lRv;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label384;
          }
          this.lLM.setText(com.tencent.mm.wallet_core.ui.e.A(((com.tencent.mm.plugin.luckymoney.b.h)localObject1).lQw / 100.0D));
          localObject1 = ((com.tencent.mm.plugin.luckymoney.b.h)localObject1).lQv;
          Object localObject3 = getString(a.i.lucky_money_send_num_desc, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.lVS.setText((CharSequence)localObject3);
        }
        while (paramm != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramm.size())
            {
              localObject1 = (i)paramm.get(paramInt1);
              if (!this.lUD.containsKey(((i)localObject1).lMg))
              {
                this.lLG.add(paramm.get(paramInt1));
                this.lUD.put(((i)localObject1).lMg, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              this.lLM.setText(com.tencent.mm.wallet_core.ui.e.A(((com.tencent.mm.plugin.luckymoney.b.h)localObject1).lQu / 100.0D));
              this.lVN.setText(((com.tencent.mm.plugin.luckymoney.b.h)localObject1).lQt);
              this.lVP.setText(((com.tencent.mm.plugin.luckymoney.b.h)localObject1).kEe);
              break;
            }
          }
          this.El += paramm.size();
          this.lUw = paramString.bfN();
          this.gDQ = false;
          this.lVe.bM(this.lLG);
        }
        if ((this.lLG == null) || (this.lLG.size() == 0))
        {
          this.iJY.setVisibility(0);
          if (!this.lUw) {
            break label556;
          }
          this.lVd.cAO();
          bool1 = true;
        }
      }
    }
    label556:
    int i;
    do
    {
      do
      {
        do
        {
          return bool1;
          this.iJY.setVisibility(8);
          break;
          this.lVd.cAP();
          break label538;
          this.lRy = null;
          return false;
          bool1 = bool2;
        } while (!(paramm instanceof aa));
        i = this.lVU;
        this.lVU = -1;
        bool1 = bool2;
      } while (paramInt1 != 0);
      bool1 = bool2;
    } while (paramInt2 != 0);
    paramString = this.lVe.tt(i);
    if (paramString != null)
    {
      Toast.makeText(this, a.i.lucky_money_list_delete_record_succ, 0).show();
      this.lVe.a(paramString);
      this.lVe.notifyDataSetChanged();
    }
    for (;;)
    {
      return true;
      y.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_my_record_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new LuckyMoneyMyRecordUI.1(this));
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new LuckyMoneyMyRecordUI.2(this));
    this.iJY = ((TextView)findViewById(a.f.lucky_money_my_record_empty_tips));
    this.lVd = ((MMLoadMoreListView)findViewById(a.f.lucky_money_my_record_list));
    this.fhl = LayoutInflater.from(this).inflate(a.g.lucky_money_my_detail_header, null);
    this.lVd.addHeaderView(this.fhl);
    this.iIS = ((ImageView)this.fhl.findViewById(a.f.lucky_money_my_detail_avatar));
    this.lVM = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_nickname));
    this.lLM = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_amount));
    this.lVN = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_num));
    this.lVO = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_num_title));
    this.lVP = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_lucky_best_num));
    this.lVQ = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_lucky_best_num_title));
    this.lVR = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_year));
    this.lVS = ((TextView)this.fhl.findViewById(a.f.lucky_money_my_detail_send_desc));
    this.lVd.setOnItemClickListener(new LuckyMoneyMyRecordUI.3(this));
    this.lVd.setOnItemLongClickListener(new LuckyMoneyMyRecordUI.4(this));
    this.lVd.setOnLoadMoreListener(new LuckyMoneyMyRecordUI.5(this));
    this.iIS.setOnClickListener(new LuckyMoneyMyRecordUI.6(this));
    bgl();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("key_type", 2);
    initView();
    bge();
    com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(bgm()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI
 * JD-Core Version:    0.7.0.1
 */