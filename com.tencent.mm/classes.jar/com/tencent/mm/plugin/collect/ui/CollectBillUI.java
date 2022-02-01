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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  private boolean hII;
  private String iTV;
  private int limit;
  private com.tencent.mm.ui.tools.l lvx;
  private View oIW;
  private long paq;
  private ListView pdE;
  private boolean pdM;
  private a pea;
  private LinearLayout peb;
  private CollectBillHeaderView pec;
  private ImageView ped;
  private MMSwitchBtn pee;
  private ImageView pef;
  private MMSwitchBtn peg;
  private TextView peh;
  private boolean pei;
  private boolean pej;
  private long pek;
  private f pel;
  private n.e pem;
  private int type;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(64079);
    this.pei = false;
    this.pdM = false;
    this.hII = false;
    this.pej = true;
    this.limit = 20;
    this.pel = new CollectBillUI.1(this);
    this.pem = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64078);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = (AdapterView.AdapterContextMenuInfo)paramAnonymousMenuItem.getMenuInfo();
          paramAnonymousMenuItem = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousMenuItem.position);
          if (paramAnonymousMenuItem != null) {
            CollectBillUI.a(CollectBillUI.this, paramAnonymousMenuItem.oZN, paramAnonymousMenuItem.timestamp);
          }
        }
        AppMethodBeat.o(64078);
      }
    };
    AppMethodBeat.o(64079);
  }
  
  private void bmg()
  {
    AppMethodBeat.i(64087);
    this.pdE.setVisibility(8);
    this.peb.setVisibility(0);
    findViewById(2131298430).setVisibility(0);
    AppMethodBeat.o(64087);
  }
  
  private void caZ()
  {
    AppMethodBeat.i(64086);
    if (!this.hII)
    {
      doSceneForceProgress(new s(this.type, this.paq, this.iTV, this.limit));
      this.pdM = true;
    }
    AppMethodBeat.o(64086);
  }
  
  private void g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(64085);
    if (this.pej)
    {
      this.pec.b(paramInt1, paramInt2, paramLong, this.type);
      this.pej = false;
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
    this.pdE = ((ListView)findViewById(2131298443));
    this.peb = ((LinearLayout)findViewById(2131298429));
    this.peh = ((TextView)findViewById(2131298426));
    this.oIW = z.jO(this).inflate(2131493557, this.pdE, false);
    this.pec = new CollectBillHeaderView(this);
    this.pdE.addHeaderView(this.pec, null, false);
    this.pea = new a(this);
    this.pdE.setAdapter(this.pea);
    this.pdE.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.lvx = new com.tencent.mm.ui.tools.l(this);
    this.pdE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          ad.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64074);
          return;
        }
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null) {
          ad.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(64074);
          return;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("scene", 2);
          paramAnonymousView.putExtra("trans_id", paramAnonymousAdapterView.oZO);
          paramAnonymousView.putExtra("bill_id", paramAnonymousAdapterView.oZN);
          d.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramAnonymousView);
        }
      }
    });
    this.pdE.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64075);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          ad.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          AppMethodBeat.o(64075);
          return false;
        }
        CollectBillUI.i(CollectBillUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, CollectBillUI.this, CollectBillUI.h(CollectBillUI.this));
        AppMethodBeat.o(64075);
        return true;
      }
    });
    if (this.fromScene != 2) {
      addTextOptionMenu(0, getString(2131757443), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64076);
          Object localObject = new Intent(CollectBillUI.this.getContext(), CollectBillListUI.class);
          paramAnonymousMenuItem = CollectBillUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(64076);
          return false;
        }
      });
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.pec.findViewById(2131298487);
      View localView = this.peb.findViewById(2131298486);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(64082);
      return;
    }
    this.ped = ((ImageView)this.pec.findViewById(2131298484));
    this.pee = ((MMSwitchBtn)this.pec.findViewById(2131298485));
    this.pef = ((ImageView)this.peb.findViewById(2131298484));
    this.peg = ((MMSwitchBtn)this.peb.findViewById(2131298485));
    com.tencent.mm.plugin.collect.a.a.cag();
    if (com.tencent.mm.plugin.collect.a.a.cai())
    {
      this.pee.setCheck(true);
      this.peg.setCheck(true);
      this.ped.setImageResource(2131689960);
      this.pef.setImageResource(2131689960);
    }
    for (;;)
    {
      localObject = new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64077);
          ad.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectBillUI.j(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          CollectBillUI.k(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) | 0x8000);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689960);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689960);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757468, 1).show();
            com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(11) });
          }
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(147457, Long.valueOf(CollectBillUI.l(CollectBillUI.this)));
            caf localcaf = new caf();
            localcaf.yho = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(209, localcaf));
            if (i != 1) {
              break;
            }
            com.tencent.mm.plugin.collect.a.a.cag().caj();
            AppMethodBeat.o(64077);
            return;
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) & 0xFFFF7FFF);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689959);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689959);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757458, 1).show();
            com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(12) });
          }
          com.tencent.mm.plugin.collect.a.a.cag().cak();
          AppMethodBeat.o(64077);
        }
      };
      this.pee.setSwitchListener((MMSwitchBtn.a)localObject);
      this.peg.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(64082);
      return;
      this.pee.setCheck(false);
      this.peg.setCheck(false);
      this.ped.setImageResource(2131689959);
      this.pef.setImageResource(2131689959);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64080);
    super.onCreate(paramBundle);
    this.pek = u.aAr();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.paq = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    caZ();
    initView();
    setMMTitle(2131757447);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1256, this.pel);
    paramBundle = new com.tencent.mm.plugin.collect.model.j();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramBundle, 0);
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
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1256, this.pel);
    AppMethodBeat.o(64081);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64084);
    Object localObject;
    if ((paramn instanceof s))
    {
      paramString = (s)paramn;
      if (this.pei)
      {
        this.pdE.removeFooterView(this.oIW);
        this.pei = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.hII = paramString.hII;
        this.type = paramString.type;
        this.paq = paramString.paq;
        g(paramString.par, paramString.dsd, paramString.paq);
        if (!paramString.paT.isEmpty())
        {
          if (bt.isNullOrNil(this.iTV))
          {
            ad.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.pdE.setVisibility(0);
            this.peb.setVisibility(8);
          }
          paramn = this.pea;
          localObject = paramString.paT;
          paramn.pdB.addAll((Collection)localObject);
          paramn.notifyDataSetChanged();
          this.iTV = ((com.tencent.mm.plugin.collect.model.a)paramString.paT.get(paramString.paT.size() - 1)).oZN;
        }
        for (;;)
        {
          this.pdM = false;
          AppMethodBeat.o(64084);
          return true;
          this.hII = true;
          if (bt.isNullOrNil(this.iTV))
          {
            ad.i("MicroMsg.CollectBillUI", "no record, show empty view");
            bmg();
          }
        }
      }
      ad.i("MicroMsg.CollectBillUI", "net error!");
      this.pdM = false;
      Toast.makeText(this, 2131757440, 1).show();
      if (bt.isNullOrNil(this.iTV)) {
        ad.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      AppMethodBeat.o(64084);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.collect.model.q))
    {
      paramn = (com.tencent.mm.plugin.collect.model.q)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.pea;
        localObject = paramn.oZN;
        Iterator localIterator = paramString.pdB.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.oZN.equals(localObject))
          {
            paramString.pdB.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.pea.getCount() <= 0)
        {
          ad.i("MicroMsg.CollectBillUI", "delete all records");
          bmg();
        }
        for (;;)
        {
          AppMethodBeat.o(64084);
          return false;
          g(paramn.par, paramn.dsd, this.paq);
        }
      }
      ad.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn.oZN });
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