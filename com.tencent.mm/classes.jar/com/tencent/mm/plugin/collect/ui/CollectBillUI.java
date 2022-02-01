package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.g;
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
  private boolean iGD;
  private String jTK;
  private int limit;
  private com.tencent.mm.ui.tools.l mHj;
  private boolean qAa;
  private long qAb;
  private i qAc;
  private o.g qAd;
  private View qdm;
  private long qwd;
  private boolean qzD;
  private a qzR;
  private LinearLayout qzS;
  private CollectBillHeaderView qzT;
  private ImageView qzU;
  private MMSwitchBtn qzV;
  private ImageView qzW;
  private MMSwitchBtn qzX;
  private TextView qzY;
  private boolean qzZ;
  private ListView qzv;
  private int type;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(64079);
    this.qzZ = false;
    this.qzD = false;
    this.iGD = false;
    this.qAa = true;
    this.limit = 20;
    this.qAc = new CollectBillUI.1(this);
    this.qAd = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64078);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = (AdapterView.AdapterContextMenuInfo)paramAnonymousMenuItem.getMenuInfo();
          paramAnonymousMenuItem = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousMenuItem.position);
          if (paramAnonymousMenuItem != null) {
            CollectBillUI.a(CollectBillUI.this, paramAnonymousMenuItem.qvC, paramAnonymousMenuItem.timestamp);
          }
        }
        AppMethodBeat.o(64078);
      }
    };
    AppMethodBeat.o(64079);
  }
  
  private void bIo()
  {
    AppMethodBeat.i(64087);
    this.qzv.setVisibility(8);
    this.qzS.setVisibility(0);
    findViewById(2131298841).setVisibility(0);
    AppMethodBeat.o(64087);
  }
  
  private void cAi()
  {
    AppMethodBeat.i(64086);
    if (!this.iGD)
    {
      doSceneForceProgress(new s(this.type, this.qwd, this.jTK, this.limit));
      this.qzD = true;
    }
    AppMethodBeat.o(64086);
  }
  
  private void h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(64085);
    if (this.qAa)
    {
      this.qzT.b(paramInt1, paramInt2, paramLong, this.type);
      this.qAa = false;
    }
    AppMethodBeat.o(64085);
  }
  
  public int getLayoutId()
  {
    return 2131493662;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64082);
    this.qzv = ((ListView)findViewById(2131298854));
    this.qzS = ((LinearLayout)findViewById(2131298840));
    this.qzY = ((TextView)findViewById(2131298837));
    this.qdm = aa.jQ(this).inflate(2131493669, this.qzv, false);
    this.qzT = new CollectBillHeaderView(this);
    this.qzv.addHeaderView(this.qzT, null, false);
    this.qzR = new a(this);
    this.qzv.setAdapter(this.qzR);
    this.qzv.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.mHj = new com.tencent.mm.ui.tools.l(this);
    this.qzv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
          paramAnonymousView.putExtra("trans_id", paramAnonymousAdapterView.qvD);
          paramAnonymousView.putExtra("bill_id", paramAnonymousAdapterView.qvC);
          c.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramAnonymousView);
        }
      }
    });
    this.qzv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
      addTextOptionMenu(0, getString(2131757662), new CollectBillUI.5(this));
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.qzT.findViewById(2131298906);
      View localView = this.qzS.findViewById(2131298905);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(64082);
      return;
    }
    this.qzU = ((ImageView)this.qzT.findViewById(2131298903));
    this.qzV = ((MMSwitchBtn)this.qzT.findViewById(2131298904));
    this.qzW = ((ImageView)this.qzS.findViewById(2131298903));
    this.qzX = ((MMSwitchBtn)this.qzS.findViewById(2131298904));
    com.tencent.mm.plugin.collect.a.a.czp();
    if (com.tencent.mm.plugin.collect.a.a.czr())
    {
      this.qzV.setCheck(true);
      this.qzX.setCheck(true);
      this.qzU.setImageResource(2131689984);
      this.qzW.setImageResource(2131689984);
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
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689984);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689984);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757687, 1).show();
            h.CyF.a(13944, new Object[] { Integer.valueOf(11) });
          }
          for (int i = 1;; i = 2)
          {
            g.aAi();
            g.aAh().azQ().set(147457, Long.valueOf(CollectBillUI.l(CollectBillUI.this)));
            cqb localcqb = new cqb();
            localcqb.Cyb = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(209, localcqb));
            if (i != 1) {
              break;
            }
            com.tencent.mm.plugin.collect.a.a.czp().czs();
            AppMethodBeat.o(64077);
            return;
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) & 0xFFFF7FFF);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689983);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689983);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757677, 1).show();
            h.CyF.a(13944, new Object[] { Integer.valueOf(12) });
          }
          com.tencent.mm.plugin.collect.a.a.czp().czt();
          AppMethodBeat.o(64077);
        }
      };
      this.qzV.setSwitchListener((MMSwitchBtn.a)localObject);
      this.qzX.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(64082);
      return;
      this.qzV.setCheck(false);
      this.qzX.setCheck(false);
      this.qzU.setImageResource(2131689983);
      this.qzW.setImageResource(2131689983);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64080);
    super.onCreate(paramBundle);
    this.qAb = z.aUd();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.qwd = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    cAi();
    initView();
    setMMTitle(2131757666);
    g.aAi();
    g.aAg().hqi.a(1256, this.qAc);
    paramBundle = new com.tencent.mm.plugin.collect.model.j();
    g.aAi();
    g.aAg().hqi.a(paramBundle, 0);
    AppMethodBeat.o(64080);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(64083);
    paramContextMenu.add(0, 0, 0, 2131757663);
    AppMethodBeat.o(64083);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64081);
    super.onDestroy();
    g.aAi();
    g.aAg().hqi.b(1256, this.qAc);
    AppMethodBeat.o(64081);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(64084);
    Object localObject;
    if ((paramq instanceof s))
    {
      paramString = (s)paramq;
      if (this.qzZ)
      {
        this.qzv.removeFooterView(this.qdm);
        this.qzZ = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.iGD = paramString.iGD;
        this.type = paramString.type;
        this.qwd = paramString.qwd;
        h(paramString.qwe, paramString.dKt, paramString.qwd);
        if (!paramString.qwH.isEmpty())
        {
          if (Util.isNullOrNil(this.jTK))
          {
            Log.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.qzv.setVisibility(0);
            this.qzS.setVisibility(8);
          }
          paramq = this.qzR;
          localObject = paramString.qwH;
          paramq.qzs.addAll((Collection)localObject);
          paramq.notifyDataSetChanged();
          this.jTK = ((com.tencent.mm.plugin.collect.model.a)paramString.qwH.get(paramString.qwH.size() - 1)).qvC;
        }
        for (;;)
        {
          this.qzD = false;
          AppMethodBeat.o(64084);
          return true;
          this.iGD = true;
          if (Util.isNullOrNil(this.jTK))
          {
            Log.i("MicroMsg.CollectBillUI", "no record, show empty view");
            bIo();
          }
        }
      }
      Log.i("MicroMsg.CollectBillUI", "net error!");
      this.qzD = false;
      Toast.makeText(this, 2131757659, 1).show();
      if (Util.isNullOrNil(this.jTK)) {
        Log.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      AppMethodBeat.o(64084);
      return true;
    }
    if ((paramq instanceof com.tencent.mm.plugin.collect.model.q))
    {
      paramq = (com.tencent.mm.plugin.collect.model.q)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.qzR;
        localObject = paramq.qvC;
        Iterator localIterator = paramString.qzs.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.qvC.equals(localObject))
          {
            paramString.qzs.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.qzR.getCount() <= 0)
        {
          Log.i("MicroMsg.CollectBillUI", "delete all records");
          bIo();
        }
        for (;;)
        {
          AppMethodBeat.o(64084);
          return false;
          h(paramq.qwe, paramq.dKt, this.qwd);
        }
      }
      Log.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq.qvC });
      Toast.makeText(this, 2131757658, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI
 * JD-Core Version:    0.7.0.1
 */