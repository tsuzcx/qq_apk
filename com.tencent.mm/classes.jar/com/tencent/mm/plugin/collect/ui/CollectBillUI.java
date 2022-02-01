package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectBillUI
  extends WalletBaseUI
{
  private int fromScene;
  private int limit;
  private boolean lwF;
  private String mKX;
  private m pGE;
  private long tVc;
  private boolean tYD;
  private a tYR;
  private LinearLayout tYS;
  private CollectBillHeaderView tYT;
  private ImageView tYU;
  private MMSwitchBtn tYV;
  private ImageView tYW;
  private MMSwitchBtn tYX;
  private TextView tYY;
  private boolean tYZ;
  private ListView tYv;
  private boolean tZa;
  private long tZb;
  private i tZc;
  private q.g tZd;
  private int type;
  private View tzj;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(64079);
    this.tYZ = false;
    this.tYD = false;
    this.lwF = false;
    this.tZa = true;
    this.limit = 20;
    this.tZc = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final q paramAnonymousq)
      {
        AppMethodBeat.i(64072);
        if ((paramAnonymousq instanceof com.tencent.mm.plugin.collect.model.j))
        {
          paramAnonymousString = (com.tencent.mm.plugin.collect.model.j)paramAnonymousq;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.tVh.ShP;
            if ((paramAnonymousString == null) || (paramAnonymousString.isEmpty()))
            {
              CollectBillUI.a(CollectBillUI.this).setVisibility(8);
              AppMethodBeat.o(64072);
              return;
            }
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousq = (eg)paramAnonymousString.next();
              if ((paramAnonymousq.type == 1) && (!Util.isNullOrNil(paramAnonymousq.wording)))
              {
                Log.i("MicroMsg.CollectBillUI", "show notice");
                CollectBillUI.a(CollectBillUI.this).setText(paramAnonymousq.wording);
                CollectBillUI.a(CollectBillUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(64071);
                    b localb = new b();
                    localb.bn(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    if (!Util.isNullOrNil(paramAnonymousq.url)) {
                      g.p(CollectBillUI.this.getContext(), paramAnonymousq.url, true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64071);
                  }
                });
                CollectBillUI.a(CollectBillUI.this).setVisibility(0);
                AppMethodBeat.o(64072);
                return;
              }
            }
            CollectBillUI.a(CollectBillUI.this).setVisibility(8);
            AppMethodBeat.o(64072);
            return;
          }
          Log.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramAnonymousString });
          CollectBillUI.a(CollectBillUI.this).setVisibility(8);
        }
        AppMethodBeat.o(64072);
      }
    };
    this.tZd = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64078);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = (AdapterView.AdapterContextMenuInfo)paramAnonymousMenuItem.getMenuInfo();
          paramAnonymousMenuItem = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousMenuItem.position);
          if (paramAnonymousMenuItem != null) {
            CollectBillUI.a(CollectBillUI.this, paramAnonymousMenuItem.tUB, paramAnonymousMenuItem.timestamp);
          }
        }
        AppMethodBeat.o(64078);
      }
    };
    AppMethodBeat.o(64079);
  }
  
  private void bTY()
  {
    AppMethodBeat.i(64087);
    this.tYv.setVisibility(8);
    this.tYS.setVisibility(0);
    findViewById(a.f.collect_bill_empty_tv).setVisibility(0);
    AppMethodBeat.o(64087);
  }
  
  private void cOI()
  {
    AppMethodBeat.i(64086);
    if (!this.lwF)
    {
      doSceneForceProgress(new com.tencent.mm.plugin.collect.model.t(this.type, this.tVc, this.mKX, this.limit));
      this.tYD = true;
    }
    AppMethodBeat.o(64086);
  }
  
  private void i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(64085);
    if (this.tZa)
    {
      this.tYT.b(paramInt1, paramInt2, paramLong, this.type);
      this.tZa = false;
    }
    AppMethodBeat.o(64085);
  }
  
  public int getLayoutId()
  {
    return a.g.collect_bill;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64082);
    this.tYv = ((ListView)findViewById(a.f.collect_bill_lv));
    this.tYS = ((LinearLayout)findViewById(a.f.collect_bill_empty_ll));
    this.tYY = ((TextView)findViewById(a.f.collect_banner_tips));
    this.tzj = ad.kS(this).inflate(a.g.collect_bill_loading_view, this.tYv, false);
    this.tYT = new CollectBillHeaderView(this);
    this.tYv.addHeaderView(this.tYT, null, false);
    this.tYR = new a(this);
    this.tYv.setAdapter(this.tYR);
    this.tYv.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(64073);
        if ((CollectBillUI.b(CollectBillUI.this).getLastVisiblePosition() == CollectBillUI.c(CollectBillUI.this).getCount()) && (CollectBillUI.c(CollectBillUI.this).getCount() > 0) && (!CollectBillUI.d(CollectBillUI.this)) && (!CollectBillUI.e(CollectBillUI.this)))
        {
          CollectBillUI.f(CollectBillUI.this);
          CollectBillUI.g(CollectBillUI.this);
        }
        AppMethodBeat.o(64073);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.pGE = new m(this);
    this.tYv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64074);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          Log.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64074);
          return;
        }
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null) {
          Log.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64074);
          return;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("scene", 2);
          paramAnonymousView.putExtra("trans_id", paramAnonymousAdapterView.tUC);
          paramAnonymousView.putExtra("bill_id", paramAnonymousAdapterView.tUB);
          com.tencent.mm.by.c.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramAnonymousView);
        }
      }
    });
    this.tYv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64075);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          Log.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          AppMethodBeat.o(64075);
          return false;
        }
        CollectBillUI.i(CollectBillUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, CollectBillUI.this, CollectBillUI.h(CollectBillUI.this));
        AppMethodBeat.o(64075);
        return true;
      }
    });
    if (this.fromScene != 2) {
      addTextOptionMenu(0, getString(a.i.collect_bill_list_title), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64076);
          Object localObject = new Intent(CollectBillUI.this.getContext(), CollectBillListUI.class);
          paramAnonymousMenuItem = CollectBillUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(64076);
          return false;
        }
      });
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.tYT.findViewById(a.f.collect_rint_switch_layout);
      View localView = this.tYS.findViewById(a.f.collect_ring_switch_empty_layout);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(64082);
      return;
    }
    this.tYU = ((ImageView)this.tYT.findViewById(a.f.collect_ring_icon_iv));
    this.tYV = ((MMSwitchBtn)this.tYT.findViewById(a.f.collect_ring_switch_btn));
    this.tYW = ((ImageView)this.tYS.findViewById(a.f.collect_ring_icon_iv));
    this.tYX = ((MMSwitchBtn)this.tYS.findViewById(a.f.collect_ring_switch_btn));
    com.tencent.mm.plugin.collect.a.a.cNP();
    if (com.tencent.mm.plugin.collect.a.a.cNR())
    {
      this.tYV.setCheck(true);
      this.tYX.setCheck(true);
      this.tYU.setImageResource(a.h.collect_sound_on);
      this.tYW.setImageResource(a.h.collect_sound_on);
    }
    for (;;)
    {
      localObject = new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64077);
          Log.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectBillUI.j(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          CollectBillUI.k(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) | 0x8000);
            CollectBillUI.m(CollectBillUI.this).setImageResource(a.h.collect_sound_on);
            CollectBillUI.n(CollectBillUI.this).setImageResource(a.h.collect_sound_on);
            Toast.makeText(CollectBillUI.this.getContext(), a.i.collect_main_open_ring_tone_tips, 1).show();
            com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(11) });
          }
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().i(147457, Long.valueOf(CollectBillUI.l(CollectBillUI.this)));
            cys localcys = new cys();
            localcys.Iza = i;
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(209, localcys));
            if (i != 1) {
              break;
            }
            com.tencent.mm.plugin.collect.a.a.cNP().cNS();
            AppMethodBeat.o(64077);
            return;
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) & 0xFFFF7FFF);
            CollectBillUI.m(CollectBillUI.this).setImageResource(a.h.collect_sound_off);
            CollectBillUI.n(CollectBillUI.this).setImageResource(a.h.collect_sound_off);
            Toast.makeText(CollectBillUI.this.getContext(), a.i.collect_main_close_ring_tone_tips, 1).show();
            com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(12) });
          }
          com.tencent.mm.plugin.collect.a.a.cNP().cNT();
          AppMethodBeat.o(64077);
        }
      };
      this.tYV.setSwitchListener((MMSwitchBtn.a)localObject);
      this.tYX.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(64082);
      return;
      this.tYV.setCheck(false);
      this.tYX.setCheck(false);
      this.tYU.setImageResource(a.h.collect_sound_off);
      this.tYW.setImageResource(a.h.collect_sound_off);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64080);
    super.onCreate(paramBundle);
    this.tZb = z.bde();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.tVc = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    cOI();
    initView();
    setMMTitle(a.i.collect_bill_title);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1256, this.tZc);
    paramBundle = new com.tencent.mm.plugin.collect.model.j();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramBundle, 0);
    AppMethodBeat.o(64080);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(64083);
    paramContextMenu.add(0, 0, 0, a.i.collect_bill_menu_item_del_text);
    AppMethodBeat.o(64083);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64081);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1256, this.tZc);
    AppMethodBeat.o(64081);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64084);
    Object localObject;
    if ((paramq instanceof com.tencent.mm.plugin.collect.model.t))
    {
      paramString = (com.tencent.mm.plugin.collect.model.t)paramq;
      if (this.tYZ)
      {
        this.tYv.removeFooterView(this.tzj);
        this.tYZ = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.lwF = paramString.lwF;
        this.type = paramString.type;
        this.tVc = paramString.tVc;
        i(paramString.tVd, paramString.fDi, paramString.tVc);
        if (!paramString.tVI.isEmpty())
        {
          if (Util.isNullOrNil(this.mKX))
          {
            Log.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.tYv.setVisibility(0);
            this.tYS.setVisibility(8);
          }
          paramq = this.tYR;
          localObject = paramString.tVI;
          paramq.tYs.addAll((Collection)localObject);
          paramq.notifyDataSetChanged();
          this.mKX = ((com.tencent.mm.plugin.collect.model.a)paramString.tVI.get(paramString.tVI.size() - 1)).tUB;
        }
        for (;;)
        {
          this.tYD = false;
          AppMethodBeat.o(64084);
          return true;
          this.lwF = true;
          if (Util.isNullOrNil(this.mKX))
          {
            Log.i("MicroMsg.CollectBillUI", "no record, show empty view");
            bTY();
          }
        }
      }
      Log.i("MicroMsg.CollectBillUI", "net error!");
      this.tYD = false;
      Toast.makeText(this, a.i.collect_bill_item_load_fail_text, 1).show();
      if (Util.isNullOrNil(this.mKX)) {
        Log.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      AppMethodBeat.o(64084);
      return true;
    }
    if ((paramq instanceof r))
    {
      paramq = (r)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tYR;
        localObject = paramq.tUB;
        Iterator localIterator = paramString.tYs.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.tUB.equals(localObject))
          {
            paramString.tYs.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.tYR.getCount() <= 0)
        {
          Log.i("MicroMsg.CollectBillUI", "delete all records");
          bTY();
        }
        for (;;)
        {
          AppMethodBeat.o(64084);
          return false;
          i(paramq.tVd, paramq.fDi, this.tVc);
        }
      }
      Log.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq.tUB });
      Toast.makeText(this, a.i.collect_bill_item_del_fail_text, 1).show();
      AppMethodBeat.o(64084);
      return false;
    }
    AppMethodBeat.o(64084);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI
 * JD-Core Version:    0.7.0.1
 */