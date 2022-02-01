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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectBillUI
  extends WalletBaseUI
{
  private int fromScene;
  private boolean hLB;
  private String iWO;
  private int limit;
  private com.tencent.mm.ui.tools.l lzV;
  private View oPy;
  private long pgU;
  private a pkG;
  private LinearLayout pkH;
  private CollectBillHeaderView pkI;
  private ImageView pkJ;
  private MMSwitchBtn pkK;
  private ImageView pkL;
  private MMSwitchBtn pkM;
  private TextView pkN;
  private boolean pkO;
  private boolean pkP;
  private long pkQ;
  private f pkR;
  private n.e pkS;
  private ListView pkk;
  private boolean pks;
  private int type;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(64079);
    this.pkO = false;
    this.pks = false;
    this.hLB = false;
    this.pkP = true;
    this.limit = 20;
    this.pkR = new CollectBillUI.1(this);
    this.pkS = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64078);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = (AdapterView.AdapterContextMenuInfo)paramAnonymousMenuItem.getMenuInfo();
          paramAnonymousMenuItem = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousMenuItem.position);
          if (paramAnonymousMenuItem != null) {
            CollectBillUI.a(CollectBillUI.this, paramAnonymousMenuItem.pgr, paramAnonymousMenuItem.timestamp);
          }
        }
        AppMethodBeat.o(64078);
      }
    };
    AppMethodBeat.o(64079);
  }
  
  private void bmP()
  {
    AppMethodBeat.i(64087);
    this.pkk.setVisibility(8);
    this.pkH.setVisibility(0);
    findViewById(2131298430).setVisibility(0);
    AppMethodBeat.o(64087);
  }
  
  private void cco()
  {
    AppMethodBeat.i(64086);
    if (!this.hLB)
    {
      doSceneForceProgress(new s(this.type, this.pgU, this.iWO, this.limit));
      this.pks = true;
    }
    AppMethodBeat.o(64086);
  }
  
  private void g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(64085);
    if (this.pkP)
    {
      this.pkI.b(paramInt1, paramInt2, paramLong, this.type);
      this.pkP = false;
    }
    AppMethodBeat.o(64085);
  }
  
  public int getLayoutId()
  {
    return 2131493550;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64082);
    this.pkk = ((ListView)findViewById(2131298443));
    this.pkH = ((LinearLayout)findViewById(2131298429));
    this.pkN = ((TextView)findViewById(2131298426));
    this.oPy = z.jV(this).inflate(2131493557, this.pkk, false);
    this.pkI = new CollectBillHeaderView(this);
    this.pkk.addHeaderView(this.pkI, null, false);
    this.pkG = new a(this);
    this.pkk.setAdapter(this.pkG);
    this.pkk.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.lzV = new com.tencent.mm.ui.tools.l(this);
    this.pkk.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          ae.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64074);
          return;
        }
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null) {
          ae.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64074);
          return;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("scene", 2);
          paramAnonymousView.putExtra("trans_id", paramAnonymousAdapterView.pgs);
          paramAnonymousView.putExtra("bill_id", paramAnonymousAdapterView.pgr);
          d.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramAnonymousView);
        }
      }
    });
    this.pkk.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64075);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          ae.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          AppMethodBeat.o(64075);
          return false;
        }
        CollectBillUI.i(CollectBillUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, CollectBillUI.this, CollectBillUI.h(CollectBillUI.this));
        AppMethodBeat.o(64075);
        return true;
      }
    });
    if (this.fromScene != 2) {
      addTextOptionMenu(0, getString(2131757443), new CollectBillUI.5(this));
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.pkI.findViewById(2131298487);
      View localView = this.pkH.findViewById(2131298486);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(64082);
      return;
    }
    this.pkJ = ((ImageView)this.pkI.findViewById(2131298484));
    this.pkK = ((MMSwitchBtn)this.pkI.findViewById(2131298485));
    this.pkL = ((ImageView)this.pkH.findViewById(2131298484));
    this.pkM = ((MMSwitchBtn)this.pkH.findViewById(2131298485));
    com.tencent.mm.plugin.collect.a.a.cbv();
    if (com.tencent.mm.plugin.collect.a.a.cbx())
    {
      this.pkK.setCheck(true);
      this.pkM.setCheck(true);
      this.pkJ.setImageResource(2131689960);
      this.pkL.setImageResource(2131689960);
    }
    for (;;)
    {
      localObject = new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64077);
          ae.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectBillUI.j(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          CollectBillUI.k(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) | 0x8000);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689960);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689960);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757468, 1).show();
            com.tencent.mm.plugin.report.service.g.yxI.f(13944, new Object[] { Integer.valueOf(11) });
          }
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(147457, Long.valueOf(CollectBillUI.l(CollectBillUI.this)));
            caz localcaz = new caz();
            localcaz.yxf = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(209, localcaz));
            if (i != 1) {
              break;
            }
            com.tencent.mm.plugin.collect.a.a.cbv().cby();
            AppMethodBeat.o(64077);
            return;
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) & 0xFFFF7FFF);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689959);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689959);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757458, 1).show();
            com.tencent.mm.plugin.report.service.g.yxI.f(13944, new Object[] { Integer.valueOf(12) });
          }
          com.tencent.mm.plugin.collect.a.a.cbv().cbz();
          AppMethodBeat.o(64077);
        }
      };
      this.pkK.setSwitchListener((MMSwitchBtn.a)localObject);
      this.pkM.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(64082);
      return;
      this.pkK.setCheck(false);
      this.pkM.setCheck(false);
      this.pkJ.setImageResource(2131689959);
      this.pkL.setImageResource(2131689959);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64080);
    super.onCreate(paramBundle);
    this.pkQ = v.aAH();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.pgU = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    cco();
    initView();
    setMMTitle(2131757447);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1256, this.pkR);
    paramBundle = new com.tencent.mm.plugin.collect.model.j();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
    AppMethodBeat.o(64080);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(64083);
    paramContextMenu.add(0, 0, 0, 2131757444);
    AppMethodBeat.o(64083);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64081);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1256, this.pkR);
    AppMethodBeat.o(64081);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64084);
    Object localObject;
    if ((paramn instanceof s))
    {
      paramString = (s)paramn;
      if (this.pkO)
      {
        this.pkk.removeFooterView(this.oPy);
        this.pkO = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.hLB = paramString.hLB;
        this.type = paramString.type;
        this.pgU = paramString.pgU;
        g(paramString.pgV, paramString.dtj, paramString.pgU);
        if (!paramString.phx.isEmpty())
        {
          if (bu.isNullOrNil(this.iWO))
          {
            ae.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.pkk.setVisibility(0);
            this.pkH.setVisibility(8);
          }
          paramn = this.pkG;
          localObject = paramString.phx;
          paramn.pkh.addAll((Collection)localObject);
          paramn.notifyDataSetChanged();
          this.iWO = ((com.tencent.mm.plugin.collect.model.a)paramString.phx.get(paramString.phx.size() - 1)).pgr;
        }
        for (;;)
        {
          this.pks = false;
          AppMethodBeat.o(64084);
          return true;
          this.hLB = true;
          if (bu.isNullOrNil(this.iWO))
          {
            ae.i("MicroMsg.CollectBillUI", "no record, show empty view");
            bmP();
          }
        }
      }
      ae.i("MicroMsg.CollectBillUI", "net error!");
      this.pks = false;
      Toast.makeText(this, 2131757440, 1).show();
      if (bu.isNullOrNil(this.iWO)) {
        ae.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      AppMethodBeat.o(64084);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.collect.model.q))
    {
      paramn = (com.tencent.mm.plugin.collect.model.q)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.pkG;
        localObject = paramn.pgr;
        Iterator localIterator = paramString.pkh.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.pgr.equals(localObject))
          {
            paramString.pkh.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.pkG.getCount() <= 0)
        {
          ae.i("MicroMsg.CollectBillUI", "delete all records");
          bmP();
        }
        for (;;)
        {
          AppMethodBeat.o(64084);
          return false;
          g(paramn.pgV, paramn.dtj, this.pgU);
        }
      }
      ae.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn.pgr });
      Toast.makeText(this, 2131757439, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI
 * JD-Core Version:    0.7.0.1
 */