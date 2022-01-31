package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.game.report.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements f, q.b
{
  private static final Pattern nDn;
  private q eiV;
  private View ejC;
  private int fromScene;
  private TextView mWM;
  private AdapterView.OnItemClickListener nDA;
  private ViewGroup nDo;
  private ListView nDp;
  private ListView nDq;
  private r nDr;
  private s nDs;
  private String nDt;
  private String nDu;
  private LinkedList<String> nDv;
  private String nDw;
  private LinkedList<m> nDx;
  private boolean nDy;
  private AdapterView.OnItemClickListener nDz;
  private ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(112212);
    nDn = Pattern.compile("\\s+");
    AppMethodBeat.o(112212);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(112194);
    this.nDx = new LinkedList();
    this.nDy = false;
    this.nDz = new GameSearchUI.5(this);
    this.nDA = new GameSearchUI.6(this);
    AppMethodBeat.o(112194);
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112201);
    while (!this.nDx.isEmpty())
    {
      g.RM();
      g.RK().eHt.a((m)this.nDx.pop());
    }
    if (paramBoolean) {
      this.nDr.reset();
    }
    this.nDv = paramLinkedList;
    ak localak = new ak(aa.dsG(), paramLinkedList, e.bFS(), this.nDr.nor);
    g.Rc().a(localak, 0);
    this.nDx.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.nDt = ""; paramLinkedList.hasNext(); this.nDt = (this.nDt + " " + (String)paramLinkedList.next())) {}
    this.nDt = this.nDt.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.nDy = true;
      this.eiV.setSearchContent(this.nDt);
    }
    AppMethodBeat.o(112201);
  }
  
  private void ad(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112200);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(112200);
  }
  
  private void rl(int paramInt)
  {
    AppMethodBeat.i(112199);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112199);
      return;
      this.nDo.setVisibility(8);
      this.mWM.setVisibility(8);
      this.nDp.setVisibility(8);
      this.nDq.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(112199);
      return;
      hideVKB();
      this.nDp.smoothScrollToPosition(0);
      this.eiV.clearFocus();
      this.nDo.setVisibility(8);
      this.mWM.setVisibility(8);
      this.nDp.setVisibility(8);
      this.nDq.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(112199);
      return;
      this.nDp.smoothScrollToPosition(0);
      this.nDo.setVisibility(8);
      this.mWM.setVisibility(8);
      this.nDp.setVisibility(8);
      this.nDq.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(112199);
      return;
      this.nDo.setVisibility(8);
      if (this.nDr.getCount() > 0)
      {
        this.mWM.setVisibility(8);
        this.nDp.setVisibility(0);
      }
      for (;;)
      {
        this.nDq.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(112199);
        return;
        this.mWM.setVisibility(0);
        this.nDp.setVisibility(8);
      }
      this.nDo.setVisibility(0);
      this.mWM.setVisibility(8);
      this.nDp.setVisibility(8);
      this.nDq.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(112199);
      return;
      this.nDo.setVisibility(8);
      this.mWM.setVisibility(0);
      this.nDp.setVisibility(8);
      this.nDq.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(112199);
      return;
      this.nDo.setVisibility(8);
      this.mWM.setVisibility(8);
      this.nDp.setVisibility(8);
      this.nDq.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  public final void apN()
  {
    AppMethodBeat.i(112206);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(112206);
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public int getLayoutId()
  {
    return 2130969813;
  }
  
  public void initView()
  {
    AppMethodBeat.i(112196);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(112188);
        GameSearchUI.this.onBackPressed();
        AppMethodBeat.o(112188);
        return true;
      }
    });
    this.eiV = new q();
    this.eiV.ru(true);
    this.eiV.Axg = this;
    this.nDo = ((ViewGroup)findViewById(2131822421));
    this.progressBar = ((ProgressBar)findViewById(2131823450));
    this.mWM = ((TextView)findViewById(2131821961));
    this.nDp = ((ListView)findViewById(2131823449));
    this.nDr = new r(this);
    this.nDp.setAdapter(this.nDr);
    this.nDp.setOnItemClickListener(this.nDz);
    this.nDp.setOnTouchListener(new GameSearchUI.2(this));
    this.nDp.setOnScrollListener(new GameSearchUI.3(this));
    this.ejC = getLayoutInflater().inflate(2130969779, this.nDp, false);
    this.ejC.setVisibility(8);
    this.nDp.addFooterView(this.ejC);
    this.nDq = ((ListView)findViewById(2131824752));
    this.nDs = new s(this);
    this.nDq.setAdapter(this.nDs);
    this.nDq.setOnItemClickListener(this.nDA);
    this.nDq.setOnTouchListener(new GameSearchUI.4(this));
    AppMethodBeat.o(112196);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(112204);
    super.onBackPressed();
    AppMethodBeat.o(112204);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112195);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    if (!g.RG())
    {
      ab.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(112195);
      return;
    }
    g.Rc().a(1328, this);
    g.Rc().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    c.a(this, 14, 1401, 0, 2, this.fromScene, null);
    ab.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(112195);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(112197);
    this.eiV.a(this, paramMenu);
    this.eiV.setHint(e.bGf());
    AppMethodBeat.o(112197);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112205);
    ab.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    g.Rc().b(1328, this);
    g.Rc().b(1329, this);
    AppMethodBeat.o(112205);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(112203);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      AppMethodBeat.o(112203);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(112203);
    return bool;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(112198);
    this.eiV.a(this, paramMenu);
    AppMethodBeat.o(112198);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(112202);
    if (paramm.isCanceled())
    {
      AppMethodBeat.o(112202);
      return;
    }
    if (this.nDx.contains(paramm)) {
      this.nDx.remove(paramm);
    }
    this.ejC.setVisibility(8);
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112202);
      return;
      paramString = (aeq)((ak)paramm).lFp.fsV.fta;
      ab.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.wXA, Integer.valueOf(paramString.wXB) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aer)((ak)paramm).lFp.fsW.fta;
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.wXC;
          if (bo.es(paramString)) {
            break label1767;
          }
          this.nDu = this.nDt;
          if (this.nDr.nor != 0)
          {
            paramm = this.nDr;
            localObject1 = this.nDu;
            paramString = paramString.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!paramString.hasNext()) {
              break label1767;
            }
            localObject2 = (aes)paramString.next();
            if ((((aes)localObject2).type == 3) && (!bo.es(((aes)localObject2).wXE)))
            {
              paramm.nor = ((aes)localObject2).wXI;
              paramm.nCH = ((aes)localObject2).wXJ;
              localObject2 = ((aes)localObject2).wXE.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((aeu)((Iterator)localObject2).next());
                ((r.b)localObject3).cnv = ((String)localObject1);
                ((r.b)localObject3).nDd.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).nDd.nCZ = ((r.b)localObject3).nCZ;
                ((r.b)localObject3).nDd.nDa = ((r.b)localObject3).nDa;
                ((r.b)localObject3).nDd.nDf = "2";
                localObject4 = ((r.b)localObject3).nDd;
                paramInt1 = paramm.nCE;
                paramm.nCE = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).nDd;
                if (!paramm.cnz) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).cFj = paramInt1;
                paramm.kGB.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramm.nCH = false;
          }
        }
        paramm = this.nDr;
        localObject1 = this.nDu;
        if (paramm.kGB == null) {
          paramm.kGB = new ArrayList();
        }
        paramm.nAi = 0;
        paramm.nCC = 0;
        paramm.nCD = 0;
        paramm.nCE = 0;
        paramm.nCF = 0;
        paramm.cnz = false;
        paramm.nCB = false;
        paramm.nCH = false;
        paramm.nor = 0;
        paramm.kGB.clear();
        paramm.nCI = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (aes)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.wXD == null) || (paramString.wXD.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.wXE != null) && (paramString.wXE.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.wXH != null) && (paramString.wXH.size() != 0)) {
              break label730;
            }
            i = 1;
            label640:
            if ((paramInt1 == 0) || (paramInt2 == 0) || (i == 0)) {
              break label736;
            }
            paramInt1 = 1;
            label655:
            if (paramInt1 == 0) {
              break label756;
            }
            if (paramString.type != 1) {
              continue;
            }
            if (bo.isNullOrNil((String)localObject1)) {
              break label741;
            }
          }
          label725:
          label730:
          label736:
          label741:
          for (paramString = paramm.context.getString(2131300452, new Object[] { localObject1 });; paramString = paramm.context.getString(2131300451))
          {
            paramm.kGB.add(r.b.aM(6, paramString));
            paramm.nCI = true;
            break;
            paramInt1 = 0;
            break label601;
            paramInt2 = 0;
            break label620;
            i = 0;
            break label640;
            paramInt1 = 0;
            break label655;
          }
          label756:
          paramm.kGB.add(r.b.aM(0, paramString.Title));
          if (!paramm.nCI)
          {
            ((r.b)paramm.kGB.get(paramm.kGB.size() - 1)).nDb = true;
            paramm.nCI = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.wXH != null))
          {
            localObject3 = paramString.wXH.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (aet)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((aet)localObject5).wXK.fKw;
              ((r.b)localObject4).name = ((aet)localObject5).wXK.Name;
              ((r.b)localObject4).hKa = ((aet)localObject5).wXK.wNM;
              ((r.b)localObject4).iconUrl = ((aet)localObject5).wXK.IconUrl;
              ((r.b)localObject4).nCV = ((aet)localObject5).wXK.nqb;
              ((r.b)localObject4).nCW = ((aet)localObject5).wXK.wXr;
              ((r.b)localObject4).actionType = ((aet)localObject5).wXK.wzE;
              ((r.b)localObject4).nCX = ((aet)localObject5).wXK.wXs;
              ((r.b)localObject4).nCY = ((aet)localObject5).wXL;
              ((r.b)localObject4).nDd = new r.c(((aet)localObject5).wXK.wzE, 4, ((aet)localObject5).wXK.fKw, ((aet)localObject5).wXK.wXs);
              ((r.b)localObject4).cnv = ((String)localObject1);
              ((r.b)localObject4).nDd.nDf = "3";
              localObject5 = ((r.b)localObject4).nDd;
              paramInt1 = paramm.nCD;
              paramm.nCD = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramm.kGB.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.wXD != null))
          {
            localObject3 = paramString.wXD.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (aem)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((aem)localObject5).fKw;
              ((r.b)localObject4).name = ((aem)localObject5).Name;
              ((r.b)localObject4).hKa = ((aem)localObject5).wNM;
              ((r.b)localObject4).iconUrl = ((aem)localObject5).IconUrl;
              ((r.b)localObject4).nCV = ((aem)localObject5).nqb;
              ((r.b)localObject4).nCW = ((aem)localObject5).wXr;
              ((r.b)localObject4).actionType = ((aem)localObject5).wzE;
              ((r.b)localObject4).nCX = ((aem)localObject5).wXs;
              ((r.b)localObject4).nDd = new r.c(((aem)localObject5).wzE, 1, ((aem)localObject5).fKw, ((aem)localObject5).wXs);
              ((r.b)localObject4).cnv = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramm.cnz = true;
                localObject5 = ((r.b)localObject4).nDd;
                paramInt1 = paramm.nAi;
                paramm.nAi = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).nDd.nDf = "1";
                paramm.kGB.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramm.nCB = true;
                  localObject5 = ((r.b)localObject4).nDd;
                  paramInt1 = paramm.nCC;
                  paramm.nCC = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.wXE != null))
          {
            paramm.nor = paramString.wXI;
            paramm.nCH = paramString.wXJ;
            localObject3 = paramString.wXE.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((aeu)((Iterator)localObject3).next());
              ((r.b)localObject4).cnv = ((String)localObject1);
              ((r.b)localObject4).nDd.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).nDd.nCZ = ((r.b)localObject4).nCZ;
              ((r.b)localObject4).nDd.nDa = ((r.b)localObject4).nDa;
              ((r.b)localObject4).nDd.nDf = "2";
              localObject5 = ((r.b)localObject4).nDd;
              paramInt1 = paramm.nCE;
              paramm.nCE = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramm.kGB.add(localObject4);
            }
          }
          if ((!bo.isNullOrNil(paramString.wXF)) && (!bo.isNullOrNil(paramString.wXG)) && (paramString.type == 1))
          {
            localObject3 = paramString.wXF;
            paramString = paramString.wXG;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).nDd = new r.c(paramString);
            ((r.b)localObject4).nDd.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).nDd.nDf = "1";
            ((r.b)localObject4).nDd.position = 300;
            paramm.kGB.add(localObject4);
          }
        }
        paramString = paramm.kGB.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramm.cnz) {
            ((r.b)localObject1).nDd.cFj = 1403;
          } else if (paramm.nCB) {
            ((r.b)localObject1).nDd.cFj = 1404;
          } else {
            ((r.b)localObject1).nDd.cFj = 1405;
          }
        }
        paramm.notifyDataSetChanged();
      }
      label1767:
      rl(2);
      AppMethodBeat.o(112202);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(112202);
        return;
      }
      paramString = ((al)paramm).cnv;
      Object localObject1 = ((aeo)((al)paramm).lFp.fsW.fta).Title;
      paramm = ((aeo)((al)paramm).lFp.fsW.fta).wXy;
      this.nDs.b(paramString, (String)localObject1, paramm);
      rl(5);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(112208);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(112208);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = nDn.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    ad(localLinkedList);
    rl(1);
    AppMethodBeat.o(112208);
    return true;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(112207);
    if (this.nDy)
    {
      this.nDy = false;
      AppMethodBeat.o(112207);
      return;
    }
    if ((this.nDw != null) && (this.nDw.equals(bo.nullAsNil(paramString))))
    {
      ab.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(112207);
      return;
    }
    this.nDw = paramString;
    if (bo.isNullOrNil(paramString))
    {
      while (!this.nDx.isEmpty())
      {
        g.RM();
        g.RK().eHt.a((m)this.nDx.pop());
      }
      paramString = new al(aa.dsG(), paramString, e.bFS());
      g.Rc().a(paramString, 0);
      this.nDx.add(paramString);
      AppMethodBeat.o(112207);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = nDn.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    ad(localLinkedList);
    rl(6);
    AppMethodBeat.o(112207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI
 * JD-Core Version:    0.7.0.1
 */