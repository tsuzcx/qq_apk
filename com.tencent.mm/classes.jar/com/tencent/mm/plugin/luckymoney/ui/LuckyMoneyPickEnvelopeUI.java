package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.f;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.q.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyPickEnvelopeUI
  extends MMActivity
{
  private Dialog gKM;
  private boolean isLoading;
  private int ojB;
  private View opY;
  private LuckyMoneyEnvelopeTouchRecyclerView ovN;
  private LuckyMoneyPickEnvelopeUI.a ovO;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.c ovP;
  private List<LuckyMoneyPickEnvelopeUI.b> ovQ;
  private int ovR;
  private boolean ovS;
  private String ovT;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a ovU;
  private TextView ovV;
  private View xy;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(42928);
    this.ovQ = new ArrayList();
    this.ovR = -1;
    this.ovS = false;
    this.isLoading = false;
    this.ojB = 0;
    AppMethodBeat.o(42928);
  }
  
  private void a(aqa paramaqa)
  {
    AppMethodBeat.i(42933);
    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (bo.isNullOrNil(paramaqa.omZ))
    {
      AppMethodBeat.o(42933);
      return;
    }
    ArrayList localArrayList = new ArrayList(bo.ih((String)g.RL().Ru().get(ac.a.yJn, ""), ","));
    Iterator localIterator = paramaqa.xfA.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localArrayList.contains(str)) {
        break label188;
      }
      localArrayList.add(str);
      ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", new Object[] { str });
      i = 1;
    }
    label188:
    for (;;)
    {
      break;
      if (i != 0)
      {
        g.RL().Ru().set(ac.a.yJn, bo.d(localArrayList, ","));
        com.tencent.mm.ui.base.h.a(this, paramaqa.omZ, "", getString(2131296977), false, new LuckyMoneyPickEnvelopeUI.12(this));
      }
      AppMethodBeat.o(42933);
      return;
    }
  }
  
  private void b(aqa paramaqa)
  {
    AppMethodBeat.i(42934);
    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    if (paramaqa.xfB == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.ovS = bool;
      a(paramaqa);
      if (paramaqa.xfx != null)
      {
        if (!paramaqa.xfx.isEmpty()) {
          break;
        }
        this.xy.setVisibility(0);
        this.ovN.setVisibility(8);
      }
      this.ovO.ajb.notifyChanged();
      paramaqa = new LuckyMoneyPickEnvelopeUI.13(this);
      this.ovN.post(paramaqa);
      AppMethodBeat.o(42934);
      return;
    }
    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(paramaqa.xfx.size()) });
    paramaqa = paramaqa.xfx.iterator();
    int i = 0;
    label143:
    LuckyMoneyPickEnvelopeUI.b localb;
    if (paramaqa.hasNext())
    {
      aus localaus = (aus)paramaqa.next();
      localb = new LuckyMoneyPickEnvelopeUI.b((byte)0);
      localb.opR = localaus;
      if ((localaus.xjP != 1) || (localaus.xjO == 1)) {
        break label238;
      }
    }
    label238:
    for (bool = true;; bool = false)
    {
      localb.kql = bool;
      this.ovQ.add(localb);
      if (localb.kql) {
        this.ovR = i;
      }
      i += 1;
      break label143;
      break;
    }
  }
  
  private void bOj()
  {
    AppMethodBeat.i(42932);
    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s", new Object[] { this.ovT });
    this.gKM = com.tencent.mm.ui.base.h.a(getContext(), 3, 2131493306, getString(2131301086), false, new LuckyMoneyPickEnvelopeUI.10(this));
    this.isLoading = true;
    f localf = f.bNf();
    localf.b(new com.tencent.mm.plugin.luckymoney.model.c(this.ovT));
    localf.a(new LuckyMoneyPickEnvelopeUI.11(this));
    AppMethodBeat.o(42932);
  }
  
  public int getLayoutId()
  {
    return 2130970041;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42930);
    this.ovN = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(2131825779));
    this.xy = findViewById(2131825781);
    this.ovV = ((TextView)findViewById(2131825780));
    this.ovO = new LuckyMoneyPickEnvelopeUI.a(this, (byte)0);
    this.ovO.jv();
    this.ovN.setAdapter(this.ovO);
    this.ovN.setItemAnimator(null);
    this.ovN.setItemViewCacheSize(-1);
    this.ovP = new LuckyMoneyPickEnvelopeUI.7(this, this);
    com.tencent.mm.plugin.luckymoney.scaledLayout.c localc = this.ovP;
    localc.S(null);
    if (localc.arK != 0.8F)
    {
      localc.arK = 0.8F;
      localc.removeAllViews();
    }
    this.ovN.setLayoutManager(this.ovP);
    this.ovU = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.ovU.context = this;
    this.ovU.i(this.ovN);
    this.ovN.otE = new LuckyMoneyPickEnvelopeUI.8(this);
    this.ovN.a(new LuckyMoneyPickEnvelopeUI.9(this));
    AppMethodBeat.o(42930);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42929);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setActionbarColor(Color.parseColor("#f1f1f1"));
    initView();
    setMMTitle(2131301290);
    paramBundle = getIntent().getByteArrayExtra(e.e.yVd);
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        paramBundle = (aqa)new aqa().parseFrom(paramBundle);
        if (paramBundle.cnK == 0)
        {
          this.ovT = paramBundle.xfy;
          this.ojB = paramBundle.xfz;
          b(paramBundle);
          setBackBtn(new LuckyMoneyPickEnvelopeUI.1(this));
          addTextOptionMenu(1, getString(2131301287), new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(42906);
              ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
              if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymousMenuItem = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                if ((!paramAnonymousMenuItem.kql) || (paramAnonymousMenuItem.opR == null)) {}
              }
              for (paramAnonymousMenuItem = paramAnonymousMenuItem.opR.materialId;; paramAnonymousMenuItem = "0")
              {
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymousMenuItem);
                com.tencent.mm.plugin.report.service.h.qsU.e(16822, new Object[] { Integer.valueOf(3) });
                AppMethodBeat.o(42906);
                return false;
              }
            }
          }, null, q.b.zbz);
          enableOptionMenu(1, false);
          AppMethodBeat.o(42929);
          return;
        }
        bOj();
        continue;
        bOj();
      }
      catch (IOException paramBundle)
      {
        ab.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42931);
    super.onDestroy();
    AppMethodBeat.o(42931);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */