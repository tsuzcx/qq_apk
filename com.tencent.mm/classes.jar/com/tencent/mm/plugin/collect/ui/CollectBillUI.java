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
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.collect.model.j;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectBillUI
  extends WalletBaseUI
{
  private int fromScene;
  private boolean gPQ;
  private String iaI;
  private l kxh;
  private int limit;
  private View nCC;
  private long nTA;
  private ListView nWO;
  private boolean nWW;
  private a nXk;
  private LinearLayout nXl;
  private CollectBillHeaderView nXm;
  private ImageView nXn;
  private MMSwitchBtn nXo;
  private ImageView nXp;
  private MMSwitchBtn nXq;
  private TextView nXr;
  private boolean nXs;
  private boolean nXt;
  private long nXu;
  private com.tencent.mm.al.g nXv;
  private n.d nXw;
  private int type;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(64079);
    this.nXs = false;
    this.nWW = false;
    this.gPQ = false;
    this.nXt = true;
    this.limit = 20;
    this.nXv = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final n paramAnonymousn)
      {
        AppMethodBeat.i(64072);
        if ((paramAnonymousn instanceof j))
        {
          paramAnonymousString = (j)paramAnonymousn;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.nTF.CTE;
            if ((paramAnonymousString == null) || (paramAnonymousString.isEmpty()))
            {
              CollectBillUI.a(CollectBillUI.this).setVisibility(8);
              AppMethodBeat.o(64072);
              return;
            }
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousn = (ds)paramAnonymousString.next();
              if ((paramAnonymousn.type == 1) && (!bt.isNullOrNil(paramAnonymousn.doh)))
              {
                ad.i("MicroMsg.CollectBillUI", "show notice");
                CollectBillUI.a(CollectBillUI.this).setText(paramAnonymousn.doh);
                CollectBillUI.a(CollectBillUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(64071);
                    if (!bt.isNullOrNil(paramAnonymousn.url)) {
                      com.tencent.mm.wallet_core.ui.e.p(CollectBillUI.this.getContext(), paramAnonymousn.url, true);
                    }
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
          ad.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramAnonymousString });
          CollectBillUI.a(CollectBillUI.this).setVisibility(8);
        }
        AppMethodBeat.o(64072);
      }
    };
    this.nXw = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64078);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = (AdapterView.AdapterContextMenuInfo)paramAnonymousMenuItem.getMenuInfo();
          paramAnonymousMenuItem = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousMenuItem.position);
          if (paramAnonymousMenuItem != null) {
            CollectBillUI.a(CollectBillUI.this, paramAnonymousMenuItem.nSX, paramAnonymousMenuItem.timestamp);
          }
        }
        AppMethodBeat.o(64078);
      }
    };
    AppMethodBeat.o(64079);
  }
  
  private void bPg()
  {
    AppMethodBeat.i(64086);
    if (!this.gPQ)
    {
      doSceneForceProgress(new s(this.type, this.nTA, this.iaI, this.limit));
      this.nWW = true;
    }
    AppMethodBeat.o(64086);
  }
  
  private void bbB()
  {
    AppMethodBeat.i(64087);
    this.nWO.setVisibility(8);
    this.nXl.setVisibility(0);
    findViewById(2131298430).setVisibility(0);
    AppMethodBeat.o(64087);
  }
  
  private void g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(64085);
    if (this.nXt)
    {
      this.nXm.b(paramInt1, paramInt2, paramLong, this.type);
      this.nXt = false;
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
    this.nWO = ((ListView)findViewById(2131298443));
    this.nXl = ((LinearLayout)findViewById(2131298429));
    this.nXr = ((TextView)findViewById(2131298426));
    this.nCC = y.js(this).inflate(2131493557, this.nWO, false);
    this.nXm = new CollectBillHeaderView(this);
    this.nWO.addHeaderView(this.nXm, null, false);
    this.nXk = new a(this);
    this.nWO.setAdapter(this.nXk);
    this.nWO.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.kxh = new l(this);
    this.nWO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64074);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          ad.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          AppMethodBeat.o(64074);
          return;
        }
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(64074);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("scene", 2);
        paramAnonymousView.putExtra("trans_id", paramAnonymousAdapterView.nSY);
        paramAnonymousView.putExtra("bill_id", paramAnonymousAdapterView.nSX);
        d.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramAnonymousView);
        AppMethodBeat.o(64074);
      }
    });
    this.nWO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(64076);
          return false;
        }
      });
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.nXm.findViewById(2131298487);
      View localView = this.nXl.findViewById(2131298486);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(64082);
      return;
    }
    this.nXn = ((ImageView)this.nXm.findViewById(2131298484));
    this.nXo = ((MMSwitchBtn)this.nXm.findViewById(2131298485));
    this.nXp = ((ImageView)this.nXl.findViewById(2131298484));
    this.nXq = ((MMSwitchBtn)this.nXl.findViewById(2131298485));
    com.tencent.mm.plugin.collect.a.a.bOn();
    if (com.tencent.mm.plugin.collect.a.a.bOp())
    {
      this.nXo.setCheck(true);
      this.nXq.setCheck(true);
      this.nXn.setImageResource(2131689960);
      this.nXp.setImageResource(2131689960);
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
            h.vKh.f(13944, new Object[] { Integer.valueOf(11) });
          }
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(147457, Long.valueOf(CollectBillUI.l(CollectBillUI.this)));
            bqy localbqy = new bqy();
            localbqy.vJA = i;
            ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(new j.a(209, localbqy));
            if (i != 1) {
              break;
            }
            com.tencent.mm.plugin.collect.a.a.bOn().bOq();
            AppMethodBeat.o(64077);
            return;
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) & 0xFFFF7FFF);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689959);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689959);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757458, 1).show();
            h.vKh.f(13944, new Object[] { Integer.valueOf(12) });
          }
          com.tencent.mm.plugin.collect.a.a.bOn().bOr();
          AppMethodBeat.o(64077);
        }
      };
      this.nXo.setSwitchListener((MMSwitchBtn.a)localObject);
      this.nXq.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(64082);
      return;
      this.nXo.setCheck(false);
      this.nXq.setCheck(false);
      this.nXn.setImageResource(2131689959);
      this.nXp.setImageResource(2131689959);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64080);
    super.onCreate(paramBundle);
    this.nXu = u.aqL();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.nTA = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    bPg();
    initView();
    setMMTitle(2131757447);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1256, this.nXv);
    paramBundle = new j();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1256, this.nXv);
    AppMethodBeat.o(64081);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64084);
    Object localObject;
    if ((paramn instanceof s))
    {
      paramString = (s)paramn;
      if (this.nXs)
      {
        this.nWO.removeFooterView(this.nCC);
        this.nXs = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gPQ = paramString.gPQ;
        this.type = paramString.type;
        this.nTA = paramString.nTA;
        g(paramString.nTB, paramString.djm, paramString.nTA);
        if (!paramString.nUd.isEmpty())
        {
          if (bt.isNullOrNil(this.iaI))
          {
            ad.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.nWO.setVisibility(0);
            this.nXl.setVisibility(8);
          }
          paramn = this.nXk;
          localObject = paramString.nUd;
          paramn.nWL.addAll((Collection)localObject);
          paramn.notifyDataSetChanged();
          this.iaI = ((com.tencent.mm.plugin.collect.model.a)paramString.nUd.get(paramString.nUd.size() - 1)).nSX;
        }
        for (;;)
        {
          this.nWW = false;
          AppMethodBeat.o(64084);
          return true;
          this.gPQ = true;
          if (bt.isNullOrNil(this.iaI))
          {
            ad.i("MicroMsg.CollectBillUI", "no record, show empty view");
            bbB();
          }
        }
      }
      ad.i("MicroMsg.CollectBillUI", "net error!");
      this.nWW = false;
      Toast.makeText(this, 2131757440, 1).show();
      if (bt.isNullOrNil(this.iaI)) {
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
        paramString = this.nXk;
        localObject = paramn.nSX;
        Iterator localIterator = paramString.nWL.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.nSX.equals(localObject))
          {
            paramString.nWL.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.nXk.getCount() <= 0)
        {
          ad.i("MicroMsg.CollectBillUI", "delete all records");
          bbB();
        }
        for (;;)
        {
          AppMethodBeat.o(64084);
          return false;
          g(paramn.nTB, paramn.djm, this.nTA);
        }
      }
      ad.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn.nSX });
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