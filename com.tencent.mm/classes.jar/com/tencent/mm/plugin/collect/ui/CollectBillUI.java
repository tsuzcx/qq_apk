package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.collect.b.r;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectBillUI
  extends WalletBaseUI
{
  private boolean dYj = false;
  private String eWH;
  private int fromScene;
  private com.tencent.mm.ui.tools.j gGp;
  private long iHh;
  private ListView iJU;
  private long iKA;
  private f iKB = new CollectBillUI.1(this);
  private n.d iKC = new CollectBillUI.7(this);
  private boolean iKc = false;
  private a iKq;
  private LinearLayout iKr;
  private CollectBillHeaderView iKs;
  private ImageView iKt;
  private MMSwitchBtn iKu;
  private ImageView iKv;
  private MMSwitchBtn iKw;
  private TextView iKx;
  private boolean iKy = false;
  private boolean iKz = true;
  private View iwf;
  private int limit = 20;
  private int type;
  
  private void aET()
  {
    if (!this.dYj)
    {
      a(new r(this.type, this.iHh, this.eWH, this.limit), true, false);
      this.iKc = true;
    }
  }
  
  private void ajT()
  {
    this.iJU.setVisibility(8);
    this.iKr.setVisibility(0);
    findViewById(a.f.collect_bill_empty_tv).setVisibility(0);
  }
  
  private void e(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.iKz)
    {
      CollectBillHeaderView localCollectBillHeaderView = this.iKs;
      int i = this.type;
      localCollectBillHeaderView.iJR.setText(e.a(localCollectBillHeaderView.getContext(), paramLong, i));
      localCollectBillHeaderView.iJS.setText(e.pw(paramInt2));
      localCollectBillHeaderView.iIV.setText(localCollectBillHeaderView.getContext().getString(a.i.collect_bill_total_num_text, new Object[] { Integer.valueOf(paramInt1) }));
      this.iKz = false;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject;
    if ((paramm instanceof r))
    {
      paramString = (r)paramm;
      if (this.iKy)
      {
        this.iJU.removeFooterView(this.iwf);
        this.iKy = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.dYj = paramString.dYj;
        this.type = paramString.type;
        this.iHh = paramString.iHh;
        e(paramString.iHi, paramString.iHj, paramString.iHh);
        if (!paramString.iHN.isEmpty())
        {
          if (bk.bl(this.eWH))
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.iJU.setVisibility(0);
            this.iKr.setVisibility(8);
          }
          paramm = this.iKq;
          localObject = paramString.iHN;
          paramm.iJQ.addAll((Collection)localObject);
          paramm.notifyDataSetChanged();
          this.eWH = ((com.tencent.mm.plugin.collect.b.a)paramString.iHN.get(paramString.iHN.size() - 1)).iGJ;
        }
        for (;;)
        {
          this.iKc = false;
          return true;
          this.dYj = true;
          if (bk.bl(this.eWH))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillUI", "no record, show empty view");
            ajT();
          }
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillUI", "net error!");
      this.iKc = false;
      Toast.makeText(this, a.i.collect_bill_item_load_fail_text, 1).show();
      if (bk.bl(this.eWH)) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.collect.b.p))
    {
      paramm = (com.tencent.mm.plugin.collect.b.p)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.iKq;
        localObject = paramm.iGJ;
        Iterator localIterator = paramString.iJQ.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.b.a locala = (com.tencent.mm.plugin.collect.b.a)localIterator.next();
          if (locala.iGJ.equals(localObject))
          {
            paramString.iJQ.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.iKq.getCount() <= 0)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillUI", "delete all records");
          ajT();
        }
        for (;;)
        {
          return false;
          e(paramm.iHi, paramm.iHj, this.iHh);
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm.iGJ });
      Toast.makeText(this, a.i.collect_bill_item_del_fail_text, 1).show();
      return false;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.collect_bill;
  }
  
  protected final void initView()
  {
    this.iJU = ((ListView)findViewById(a.f.collect_bill_lv));
    this.iKr = ((LinearLayout)findViewById(a.f.collect_bill_empty_ll));
    this.iKx = ((TextView)findViewById(a.f.collect_banner_tips));
    this.iwf = com.tencent.mm.ui.y.gt(this).inflate(a.g.collect_bill_loading_view, this.iJU, false);
    this.iKs = new CollectBillHeaderView(this);
    this.iJU.addHeaderView(this.iKs, null, false);
    this.iKq = new a(this);
    this.iJU.setAdapter(this.iKq);
    this.iJU.setOnScrollListener(new CollectBillUI.2(this));
    this.gGp = new com.tencent.mm.ui.tools.j(this);
    this.iJU.setOnItemClickListener(new CollectBillUI.3(this));
    this.iJU.setOnItemLongClickListener(new CollectBillUI.4(this));
    if (this.fromScene != 2) {
      addTextOptionMenu(0, getString(a.i.collect_bill_list_title), new CollectBillUI.5(this));
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.iKs.findViewById(a.f.collect_rint_switch_layout);
      View localView = this.iKr.findViewById(a.f.collect_ring_switch_empty_layout);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      return;
    }
    this.iKt = ((ImageView)this.iKs.findViewById(a.f.collect_ring_icon_iv));
    this.iKu = ((MMSwitchBtn)this.iKs.findViewById(a.f.collect_ring_switch_btn));
    this.iKv = ((ImageView)this.iKr.findViewById(a.f.collect_ring_icon_iv));
    this.iKw = ((MMSwitchBtn)this.iKr.findViewById(a.f.collect_ring_switch_btn));
    com.tencent.mm.plugin.collect.a.a.aEp();
    if (com.tencent.mm.plugin.collect.a.a.aEr())
    {
      this.iKu.setCheck(true);
      this.iKw.setCheck(true);
      this.iKt.setImageResource(a.h.collect_sound_on);
      this.iKv.setImageResource(a.h.collect_sound_on);
    }
    for (;;)
    {
      localObject = new CollectBillUI.6(this);
      this.iKu.setSwitchListener((MMSwitchBtn.a)localObject);
      this.iKw.setSwitchListener((MMSwitchBtn.a)localObject);
      return;
      this.iKu.setCheck(false);
      this.iKw.setCheck(false);
      this.iKt.setImageResource(a.h.collect_sound_off);
      this.iKv.setImageResource(a.h.collect_sound_off);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iKA = q.Go();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.iHh = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    aET();
    initView();
    setMMTitle(a.i.collect_bill_title);
    g.DQ();
    g.DO().dJT.a(1256, this.iKB);
    paramBundle = new com.tencent.mm.plugin.collect.b.j();
    g.DQ();
    g.DO().dJT.a(paramBundle, 0);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, a.i.collect_bill_menu_item_del_text);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g.DQ();
    g.DO().dJT.b(1256, this.iKB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI
 * JD-Core Version:    0.7.0.1
 */