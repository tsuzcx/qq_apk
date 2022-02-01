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
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.collect.model.j;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.sj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
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
  private boolean hqq;
  private String iAL;
  private l kYv;
  private int limit;
  private a oAF;
  private LinearLayout oAG;
  private CollectBillHeaderView oAH;
  private ImageView oAI;
  private MMSwitchBtn oAJ;
  private ImageView oAK;
  private MMSwitchBtn oAL;
  private TextView oAM;
  private boolean oAN;
  private boolean oAO;
  private long oAP;
  private com.tencent.mm.ak.g oAQ;
  private n.d oAR;
  private ListView oAj;
  private boolean oAr;
  private View ofD;
  private long owV;
  private int type;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(64079);
    this.oAN = false;
    this.oAr = false;
    this.hqq = false;
    this.oAO = true;
    this.limit = 20;
    this.oAQ = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final n paramAnonymousn)
      {
        AppMethodBeat.i(64072);
        if ((paramAnonymousn instanceof j))
        {
          paramAnonymousString = (j)paramAnonymousn;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.oxa.Emp;
            if ((paramAnonymousString == null) || (paramAnonymousString.isEmpty()))
            {
              CollectBillUI.a(CollectBillUI.this).setVisibility(8);
              AppMethodBeat.o(64072);
              return;
            }
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousn = (du)paramAnonymousString.next();
              if ((paramAnonymousn.type == 1) && (!bs.isNullOrNil(paramAnonymousn.dlQ)))
              {
                ac.i("MicroMsg.CollectBillUI", "show notice");
                CollectBillUI.a(CollectBillUI.this).setText(paramAnonymousn.dlQ);
                CollectBillUI.a(CollectBillUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(64071);
                    if (!bs.isNullOrNil(paramAnonymousn.url)) {
                      com.tencent.mm.wallet_core.ui.e.o(CollectBillUI.this.getContext(), paramAnonymousn.url, true);
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
          ac.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramAnonymousString });
          CollectBillUI.a(CollectBillUI.this).setVisibility(8);
        }
        AppMethodBeat.o(64072);
      }
    };
    this.oAR = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64078);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = (AdapterView.AdapterContextMenuInfo)paramAnonymousMenuItem.getMenuInfo();
          paramAnonymousMenuItem = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousMenuItem.position);
          if (paramAnonymousMenuItem != null) {
            CollectBillUI.a(CollectBillUI.this, paramAnonymousMenuItem.ows, paramAnonymousMenuItem.timestamp);
          }
        }
        AppMethodBeat.o(64078);
      }
    };
    AppMethodBeat.o(64079);
  }
  
  private void bWw()
  {
    AppMethodBeat.i(64086);
    if (!this.hqq)
    {
      doSceneForceProgress(new s(this.type, this.owV, this.iAL, this.limit));
      this.oAr = true;
    }
    AppMethodBeat.o(64086);
  }
  
  private void biu()
  {
    AppMethodBeat.i(64087);
    this.oAj.setVisibility(8);
    this.oAG.setVisibility(0);
    findViewById(2131298430).setVisibility(0);
    AppMethodBeat.o(64087);
  }
  
  private void g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(64085);
    if (this.oAO)
    {
      this.oAH.b(paramInt1, paramInt2, paramLong, this.type);
      this.oAO = false;
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
    this.oAj = ((ListView)findViewById(2131298443));
    this.oAG = ((LinearLayout)findViewById(2131298429));
    this.oAM = ((TextView)findViewById(2131298426));
    this.ofD = z.jD(this).inflate(2131493557, this.oAj, false);
    this.oAH = new CollectBillHeaderView(this);
    this.oAj.addHeaderView(this.oAH, null, false);
    this.oAF = new a(this);
    this.oAj.setAdapter(this.oAF);
    this.oAj.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.kYv = new l(this);
    this.oAj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64074);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          ac.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
          AppMethodBeat.o(64074);
          return;
        }
        paramAnonymousAdapterView = (com.tencent.mm.plugin.collect.model.a)CollectBillUI.b(CollectBillUI.this).getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ac.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(64074);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("scene", 2);
        paramAnonymousView.putExtra("trans_id", paramAnonymousAdapterView.owt);
        paramAnonymousView.putExtra("bill_id", paramAnonymousAdapterView.ows);
        d.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramAnonymousView);
        AppMethodBeat.o(64074);
      }
    });
    this.oAj.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64075);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount()))
        {
          ac.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousAdapterView.getAdapter().getCount()) });
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(64076);
          return false;
        }
      });
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.oAH.findViewById(2131298487);
      View localView = this.oAG.findViewById(2131298486);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(64082);
      return;
    }
    this.oAI = ((ImageView)this.oAH.findViewById(2131298484));
    this.oAJ = ((MMSwitchBtn)this.oAH.findViewById(2131298485));
    this.oAK = ((ImageView)this.oAG.findViewById(2131298484));
    this.oAL = ((MMSwitchBtn)this.oAG.findViewById(2131298485));
    com.tencent.mm.plugin.collect.a.a.bVD();
    if (com.tencent.mm.plugin.collect.a.a.bVF())
    {
      this.oAJ.setCheck(true);
      this.oAL.setCheck(true);
      this.oAI.setImageResource(2131689960);
      this.oAK.setImageResource(2131689960);
    }
    for (;;)
    {
      localObject = new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64077);
          ac.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectBillUI.j(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          CollectBillUI.k(CollectBillUI.this).setCheck(paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) | 0x8000);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689960);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689960);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757468, 1).show();
            h.wUl.f(13944, new Object[] { Integer.valueOf(11) });
          }
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(147457, Long.valueOf(CollectBillUI.l(CollectBillUI.this)));
            bvp localbvp = new bvp();
            localbvp.wTE = i;
            ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new j.a(209, localbvp));
            if (i != 1) {
              break;
            }
            com.tencent.mm.plugin.collect.a.a.bVD().bVG();
            AppMethodBeat.o(64077);
            return;
            CollectBillUI.a(CollectBillUI.this, CollectBillUI.l(CollectBillUI.this) & 0xFFFF7FFF);
            CollectBillUI.m(CollectBillUI.this).setImageResource(2131689959);
            CollectBillUI.n(CollectBillUI.this).setImageResource(2131689959);
            Toast.makeText(CollectBillUI.this.getContext(), 2131757458, 1).show();
            h.wUl.f(13944, new Object[] { Integer.valueOf(12) });
          }
          com.tencent.mm.plugin.collect.a.a.bVD().bVH();
          AppMethodBeat.o(64077);
        }
      };
      this.oAJ.setSwitchListener((MMSwitchBtn.a)localObject);
      this.oAL.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(64082);
      return;
      this.oAJ.setCheck(false);
      this.oAL.setCheck(false);
      this.oAI.setImageResource(2131689959);
      this.oAK.setImageResource(2131689959);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64080);
    super.onCreate(paramBundle);
    this.oAP = u.axB();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.owV = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    bWw();
    initView();
    setMMTitle(2131757447);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1256, this.oAQ);
    paramBundle = new j();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1256, this.oAQ);
    AppMethodBeat.o(64081);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64084);
    Object localObject;
    if ((paramn instanceof s))
    {
      paramString = (s)paramn;
      if (this.oAN)
      {
        this.oAj.removeFooterView(this.ofD);
        this.oAN = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.hqq = paramString.hqq;
        this.type = paramString.type;
        this.owV = paramString.owV;
        g(paramString.owW, paramString.dgH, paramString.owV);
        if (!paramString.oxy.isEmpty())
        {
          if (bs.isNullOrNil(this.iAL))
          {
            ac.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.oAj.setVisibility(0);
            this.oAG.setVisibility(8);
          }
          paramn = this.oAF;
          localObject = paramString.oxy;
          paramn.oAg.addAll((Collection)localObject);
          paramn.notifyDataSetChanged();
          this.iAL = ((com.tencent.mm.plugin.collect.model.a)paramString.oxy.get(paramString.oxy.size() - 1)).ows;
        }
        for (;;)
        {
          this.oAr = false;
          AppMethodBeat.o(64084);
          return true;
          this.hqq = true;
          if (bs.isNullOrNil(this.iAL))
          {
            ac.i("MicroMsg.CollectBillUI", "no record, show empty view");
            biu();
          }
        }
      }
      ac.i("MicroMsg.CollectBillUI", "net error!");
      this.oAr = false;
      Toast.makeText(this, 2131757440, 1).show();
      if (bs.isNullOrNil(this.iAL)) {
        ac.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      AppMethodBeat.o(64084);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.collect.model.q))
    {
      paramn = (com.tencent.mm.plugin.collect.model.q)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.oAF;
        localObject = paramn.ows;
        Iterator localIterator = paramString.oAg.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.ows.equals(localObject))
          {
            paramString.oAg.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.oAF.getCount() <= 0)
        {
          ac.i("MicroMsg.CollectBillUI", "delete all records");
          biu();
        }
        for (;;)
        {
          AppMethodBeat.o(64084);
          return false;
          g(paramn.owW, paramn.dgH, this.owV);
        }
      }
      ac.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn.ows });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI
 * JD-Core Version:    0.7.0.1
 */