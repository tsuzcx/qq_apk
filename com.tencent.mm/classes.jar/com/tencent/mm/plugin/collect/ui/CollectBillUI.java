package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.i;
import com.tencent.mm.plugin.collect.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectBillUI
  extends WalletBaseUI
{
  private int fromScene;
  private int limit;
  private boolean ooe;
  private String pHE;
  private l sLE;
  private int type;
  private View wDF;
  private long wYy;
  private ListView xbN;
  private boolean xbV;
  private a xcj;
  private LinearLayout xck;
  private CollectBillHeaderView xcl;
  private ImageView xcm;
  private MMSwitchBtn xcn;
  private ImageView xco;
  private MMSwitchBtn xcp;
  private TextView xcq;
  private boolean xcr;
  private boolean xcs;
  private long xct;
  private com.tencent.mm.am.h xcu;
  private u.i xcv;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(64079);
    this.xcr = false;
    this.xbV = false;
    this.ooe = false;
    this.xcs = true;
    this.limit = 20;
    this.xcu = new CollectBillUI.1(this);
    this.xcv = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64078);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = (AdapterView.AdapterContextMenuInfo)paramAnonymousMenuItem.getMenuInfo();
          paramAnonymousMenuItem = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousMenuItem.position);
          if (paramAnonymousMenuItem != null) {
            CollectBillUI.a(CollectBillUI.this, paramAnonymousMenuItem.wXX, paramAnonymousMenuItem.timestamp);
          }
        }
        AppMethodBeat.o(64078);
      }
    };
    AppMethodBeat.o(64079);
  }
  
  private void cul()
  {
    AppMethodBeat.i(64087);
    this.xbN.setVisibility(8);
    this.xck.setVisibility(0);
    findViewById(a.f.collect_bill_empty_tv).setVisibility(0);
    AppMethodBeat.o(64087);
  }
  
  private void dsn()
  {
    AppMethodBeat.i(64086);
    if (!this.ooe)
    {
      doSceneForceProgress(new r(this.type, this.wYy, this.pHE, this.limit));
      this.xbV = true;
    }
    AppMethodBeat.o(64086);
  }
  
  private void j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(64085);
    if (this.xcs)
    {
      this.xcl.b(paramInt1, paramInt2, paramLong, this.type);
      this.xcs = false;
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
    this.xbN = ((ListView)findViewById(a.f.collect_bill_lv));
    this.xck = ((LinearLayout)findViewById(a.f.collect_bill_empty_ll));
    this.xcq = ((TextView)findViewById(a.f.collect_banner_tips));
    this.wDF = af.mU(this).inflate(a.g.collect_bill_loading_view, this.xbN, false);
    this.xcl = new CollectBillHeaderView(this);
    this.xbN.addHeaderView(this.xcl, null, false);
    this.xcj = new a(this);
    this.xbN.setAdapter(this.xcj);
    this.xbN.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.sLE = new l(this);
    this.xbN.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64074);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
          paramAnonymousView.putExtra("trans_id", paramAnonymousAdapterView.wXY);
          paramAnonymousView.putExtra("bill_id", paramAnonymousAdapterView.wXX);
          com.tencent.mm.br.c.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramAnonymousView);
        }
      }
    });
    this.xbN.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
      addTextOptionMenu(0, getString(a.i.collect_bill_list_title), new CollectBillUI.5(this));
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.xcl.findViewById(a.f.collect_rint_switch_layout);
      View localView = this.xck.findViewById(a.f.collect_ring_switch_empty_layout);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(64082);
      return;
    }
    this.xcm = ((ImageView)this.xcl.findViewById(a.f.collect_ring_icon_iv));
    this.xcn = ((MMSwitchBtn)this.xcl.findViewById(a.f.collect_ring_switch_btn));
    this.xco = ((ImageView)this.xck.findViewById(a.f.collect_ring_icon_iv));
    this.xcp = ((MMSwitchBtn)this.xck.findViewById(a.f.collect_ring_switch_btn));
    com.tencent.mm.plugin.collect.app.a.dru();
    if (com.tencent.mm.plugin.collect.app.a.drw())
    {
      this.xcn.setCheck(true);
      this.xcp.setCheck(true);
      this.xcm.setImageResource(a.h.collect_sound_on);
      this.xco.setImageResource(a.h.collect_sound_on);
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
            CollectBillUI.l(CollectBillUI.this);
            CollectBillUI.m(CollectBillUI.this).setImageResource(a.h.collect_sound_on);
            CollectBillUI.n(CollectBillUI.this).setImageResource(a.h.collect_sound_on);
            Toast.makeText(CollectBillUI.this.getContext(), a.i.collect_main_open_ring_tone_tips, 1).show();
            com.tencent.mm.plugin.report.service.h.OAn.b(13944, new Object[] { Integer.valueOf(11) });
          }
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(CollectBillUI.p(CollectBillUI.this)));
            dpy localdpy = new dpy();
            localdpy.OzH = i;
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(209, localdpy));
            if (i != 1) {
              break;
            }
            com.tencent.mm.plugin.collect.app.a.dru().drx();
            AppMethodBeat.o(64077);
            return;
            CollectBillUI.o(CollectBillUI.this);
            CollectBillUI.m(CollectBillUI.this).setImageResource(a.h.collect_sound_off);
            CollectBillUI.n(CollectBillUI.this).setImageResource(a.h.collect_sound_off);
            Toast.makeText(CollectBillUI.this.getContext(), a.i.collect_main_close_ring_tone_tips, 1).show();
            com.tencent.mm.plugin.report.service.h.OAn.b(13944, new Object[] { Integer.valueOf(12) });
          }
          com.tencent.mm.plugin.collect.app.a.dru().dry();
          AppMethodBeat.o(64077);
        }
      };
      this.xcn.setSwitchListener((MMSwitchBtn.a)localObject);
      this.xcp.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(64082);
      return;
      this.xcn.setCheck(false);
      this.xcp.setCheck(false);
      this.xcm.setImageResource(a.h.collect_sound_off);
      this.xco.setImageResource(a.h.collect_sound_off);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64080);
    super.onCreate(paramBundle);
    this.xct = z.bAR();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.wYy = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    dsn();
    initView();
    setMMTitle(a.i.collect_bill_title);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1256, this.xcu);
    paramBundle = new i();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramBundle, 0);
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1256, this.xcu);
    AppMethodBeat.o(64081);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(64084);
    Object localObject;
    if ((paramp instanceof r))
    {
      paramString = (r)paramp;
      if (this.xcr)
      {
        this.xbN.removeFooterView(this.wDF);
        this.xcr = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.ooe = paramString.ooe;
        this.type = paramString.type;
        this.wYy = paramString.wYy;
        j(paramString.wYz, paramString.hHX, paramString.wYy);
        if (!paramString.wZc.isEmpty())
        {
          if (Util.isNullOrNil(this.pHE))
          {
            Log.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.xbN.setVisibility(0);
            this.xck.setVisibility(8);
          }
          paramp = this.xcj;
          localObject = paramString.wZc;
          paramp.bMf.addAll((Collection)localObject);
          paramp.notifyDataSetChanged();
          this.pHE = ((com.tencent.mm.plugin.collect.model.a)paramString.wZc.get(paramString.wZc.size() - 1)).wXX;
        }
        for (;;)
        {
          this.xbV = false;
          AppMethodBeat.o(64084);
          return true;
          this.ooe = true;
          if (Util.isNullOrNil(this.pHE))
          {
            Log.i("MicroMsg.CollectBillUI", "no record, show empty view");
            cul();
          }
        }
      }
      Log.i("MicroMsg.CollectBillUI", "net error!");
      this.xbV = false;
      Toast.makeText(this, a.i.collect_bill_item_load_fail_text, 1).show();
      if (Util.isNullOrNil(this.pHE)) {
        Log.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      AppMethodBeat.o(64084);
      return true;
    }
    if ((paramp instanceof com.tencent.mm.plugin.collect.model.p))
    {
      paramp = (com.tencent.mm.plugin.collect.model.p)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.xcj;
        localObject = paramp.wXX;
        Iterator localIterator = paramString.bMf.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.wXX.equals(localObject))
          {
            paramString.bMf.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.xcj.getCount() <= 0)
        {
          Log.i("MicroMsg.CollectBillUI", "delete all records");
          cul();
        }
        for (;;)
        {
          AppMethodBeat.o(64084);
          return false;
          j(paramp.wYz, paramp.hHX, this.wYy);
        }
      }
      Log.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp.wXX });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI
 * JD-Core Version:    0.7.0.1
 */