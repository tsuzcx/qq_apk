package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectBillUI
  extends WalletBaseUI
{
  private boolean fon;
  private int fromScene;
  private String goF;
  private l igW;
  private long kNm;
  private boolean kQH;
  private a kQV;
  private LinearLayout kQW;
  private CollectBillHeaderView kQX;
  private ImageView kQY;
  private MMSwitchBtn kQZ;
  private ListView kQz;
  private ImageView kRa;
  private MMSwitchBtn kRb;
  private TextView kRc;
  private boolean kRd;
  private boolean kRe;
  private long kRf;
  private f kRg;
  private n.d kRh;
  private View kxj;
  private int limit;
  private int type;
  
  public CollectBillUI()
  {
    AppMethodBeat.i(41218);
    this.kRd = false;
    this.kQH = false;
    this.fon = false;
    this.kRe = true;
    this.limit = 20;
    this.kRg = new CollectBillUI.1(this);
    this.kRh = new CollectBillUI.7(this);
    AppMethodBeat.o(41218);
  }
  
  private void aEw()
  {
    AppMethodBeat.i(41226);
    this.kQz.setVisibility(8);
    this.kQW.setVisibility(0);
    findViewById(2131822886).setVisibility(0);
    AppMethodBeat.o(41226);
  }
  
  private void bij()
  {
    AppMethodBeat.i(41225);
    if (!this.fon)
    {
      doSceneForceProgress(new com.tencent.mm.plugin.collect.model.r(this.type, this.kNm, this.goF, this.limit));
      this.kQH = true;
    }
    AppMethodBeat.o(41225);
  }
  
  private void f(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(41224);
    if (this.kRe)
    {
      this.kQX.a(paramInt1, paramInt2, paramLong, this.type);
      this.kRe = false;
    }
    AppMethodBeat.o(41224);
  }
  
  public int getLayoutId()
  {
    return 2130969168;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41221);
    this.kQz = ((ListView)findViewById(2131822883));
    this.kQW = ((LinearLayout)findViewById(2131822884));
    this.kRc = ((TextView)findViewById(2131822882));
    this.kxj = w.hM(this).inflate(2130969175, this.kQz, false);
    this.kQX = new CollectBillHeaderView(this);
    this.kQz.addHeaderView(this.kQX, null, false);
    this.kQV = new a(this);
    this.kQz.setAdapter(this.kQV);
    this.kQz.setOnScrollListener(new CollectBillUI.2(this));
    this.igW = new l(this);
    this.kQz.setOnItemClickListener(new CollectBillUI.3(this));
    this.kQz.setOnItemLongClickListener(new CollectBillUI.4(this));
    if (this.fromScene != 2) {
      addTextOptionMenu(0, getString(2131298431), new CollectBillUI.5(this));
    }
    Object localObject;
    if (this.fromScene == 2)
    {
      localObject = this.kQX.findViewById(2131822892);
      View localView = this.kQW.findViewById(2131822885);
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
      AppMethodBeat.o(41221);
      return;
    }
    this.kQY = ((ImageView)this.kQX.findViewById(2131822959));
    this.kQZ = ((MMSwitchBtn)this.kQX.findViewById(2131822960));
    this.kRa = ((ImageView)this.kQW.findViewById(2131822959));
    this.kRb = ((MMSwitchBtn)this.kQW.findViewById(2131822960));
    com.tencent.mm.plugin.collect.a.a.bhw();
    if (com.tencent.mm.plugin.collect.a.a.bhy())
    {
      this.kQZ.setCheck(true);
      this.kRb.setCheck(true);
      this.kQY.setImageResource(2131231156);
      this.kRa.setImageResource(2131231156);
    }
    for (;;)
    {
      localObject = new CollectBillUI.6(this);
      this.kQZ.setSwitchListener((MMSwitchBtn.a)localObject);
      this.kRb.setSwitchListener((MMSwitchBtn.a)localObject);
      AppMethodBeat.o(41221);
      return;
      this.kQZ.setCheck(false);
      this.kRb.setCheck(false);
      this.kQY.setImageResource(2131231155);
      this.kRa.setImageResource(2131231155);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41219);
    super.onCreate(paramBundle);
    this.kRf = com.tencent.mm.model.r.Zs();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    this.type = getIntent().getIntExtra("key_type", 0);
    this.kNm = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000L);
    bij();
    initView();
    setMMTitle(2131298435);
    g.RM();
    g.RK().eHt.a(1256, this.kRg);
    paramBundle = new j();
    g.RM();
    g.RK().eHt.a(paramBundle, 0);
    AppMethodBeat.o(41219);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(41222);
    paramContextMenu.add(0, 0, 0, 2131298432);
    AppMethodBeat.o(41222);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41220);
    super.onDestroy();
    g.RM();
    g.RK().eHt.b(1256, this.kRg);
    AppMethodBeat.o(41220);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41223);
    Object localObject;
    if ((paramm instanceof com.tencent.mm.plugin.collect.model.r))
    {
      paramString = (com.tencent.mm.plugin.collect.model.r)paramm;
      if (this.kRd)
      {
        this.kQz.removeFooterView(this.kxj);
        this.kRd = false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.fon = paramString.fon;
        this.type = paramString.type;
        this.kNm = paramString.kNm;
        f(paramString.kNn, paramString.kNo, paramString.kNm);
        if (!paramString.kNQ.isEmpty())
        {
          if (bo.isNullOrNil(this.goF))
          {
            ab.d("MicroMsg.CollectBillUI", "first query, hide block view");
            this.kQz.setVisibility(0);
            this.kQW.setVisibility(8);
          }
          paramm = this.kQV;
          localObject = paramString.kNQ;
          paramm.kQw.addAll((Collection)localObject);
          paramm.notifyDataSetChanged();
          this.goF = ((com.tencent.mm.plugin.collect.model.a)paramString.kNQ.get(paramString.kNQ.size() - 1)).kMM;
        }
        for (;;)
        {
          this.kQH = false;
          AppMethodBeat.o(41223);
          return true;
          this.fon = true;
          if (bo.isNullOrNil(this.goF))
          {
            ab.i("MicroMsg.CollectBillUI", "no record, show empty view");
            aEw();
          }
        }
      }
      ab.i("MicroMsg.CollectBillUI", "net error!");
      this.kQH = false;
      Toast.makeText(this, 2131298428, 1).show();
      if (bo.isNullOrNil(this.goF)) {
        ab.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
      }
      AppMethodBeat.o(41223);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.collect.model.p))
    {
      paramm = (com.tencent.mm.plugin.collect.model.p)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.kQV;
        localObject = paramm.kMM;
        Iterator localIterator = paramString.kQw.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.collect.model.a locala = (com.tencent.mm.plugin.collect.model.a)localIterator.next();
          if (locala.kMM.equals(localObject))
          {
            paramString.kQw.remove(locala);
            paramString.notifyDataSetChanged();
          }
        }
        if (this.kQV.getCount() <= 0)
        {
          ab.i("MicroMsg.CollectBillUI", "delete all records");
          aEw();
        }
        for (;;)
        {
          AppMethodBeat.o(41223);
          return false;
          f(paramm.kNn, paramm.kNo, this.kNm);
        }
      }
      ab.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm.kMM });
      Toast.makeText(this, 2131298427, 1).show();
      AppMethodBeat.o(41223);
      return false;
    }
    AppMethodBeat.o(41223);
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