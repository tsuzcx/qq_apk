package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.plugin.fts.ui.webview.PardusWebView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.fts.ui.widget.d.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class FTSMainUI
  extends FTSBaseVoiceSearchUI
  implements com.tencent.mm.modelgeo.b.a
{
  public int kme;
  Dialog oWF;
  int rto;
  View ruA;
  private View ruB;
  private TextView ruC;
  private View ruD;
  private View ruE;
  private com.tencent.mm.plugin.websearch.api.k ruF;
  private View.OnClickListener ruG;
  private com.tencent.mm.sdk.b.c<ya> ruH;
  int ruI;
  private FTSMainUIEducationLayout rur;
  private com.tencent.mm.plugin.fts.ui.widget.b rus;
  private boolean rut;
  private String ruu;
  private volatile boolean ruv;
  com.tencent.mm.plugin.fts.ui.widget.d ruw;
  private KeyboardLinearLayout rux;
  public j ruy;
  private View ruz;
  
  public FTSMainUI()
  {
    AppMethodBeat.i(111977);
    this.rut = false;
    this.rto = -1;
    this.ruF = new com.tencent.mm.plugin.websearch.api.k() {};
    this.ruG = new FTSMainUI.4(this);
    this.ruH = new com.tencent.mm.sdk.b.c() {};
    this.ruI = 1;
    AppMethodBeat.o(111977);
  }
  
  private void cyb()
  {
    AppMethodBeat.i(111989);
    this.rur.setVisibility(0);
    this.rur.cE();
    AppMethodBeat.o(111989);
  }
  
  private void cyc()
  {
    AppMethodBeat.i(111990);
    this.rur.setVisibility(8);
    AppMethodBeat.o(111990);
  }
  
  public final boolean BX(String paramString)
  {
    AppMethodBeat.i(111997);
    super.BX(paramString);
    if ((this.ruv) && (!TextUtils.isEmpty(this.query)))
    {
      Object localObject = this.ruy;
      paramString = new ArrayList();
      localObject = ((j)localObject).ruc.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject).next()).cxs());
      }
      if ((paramString.size() != 0) || (!TextUtils.isEmpty(this.ruC.getText())) || (this.ruw.dcq)) {
        break label362;
      }
      this.ruw.dj(this.query, 17);
      paramString = new gw();
      paramString.eji = 1L;
      paramString.dFf = 1L;
      paramString.mB(this.query).aBj();
      int i = this.kme;
      paramString = this.ruy.rue;
      localObject = new ea();
      ((ea)localObject).dWE = i;
      ((ea)localObject).dWF = 29L;
      ((ea)localObject).dWH = 1L;
      ((ea)localObject).dXc = paramString.cyf();
      ea localea = ((ea)localObject).kc("").kd("").kf(paramString.query).ke("").kg("").kh("").ki("").kj("").kk("").kl("").km("").kn("").ko("").kp("").kq("");
      localea.dXv = com.tencent.mm.plugin.fts.a.e.rob;
      localea.dXw = paramString.rwG;
      localea.kr("");
      ((ea)localObject).aBj();
      ad.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((ea)localObject).PW().replace("\r\n", " ") });
      this.ruw.DR(8);
    }
    for (;;)
    {
      AppMethodBeat.o(111997);
      return false;
      label362:
      paramString = new gw();
      paramString.eji = 1L;
      paramString.dFf = 2L;
      paramString.mB(this.query).aBj();
    }
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(112001);
    if ((this.rus == null) || (!this.rus.rxN)) {
      super.BY(paramString);
    }
    this.ruv = false;
    AppMethodBeat.o(112001);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111983);
    this.ruy = new j(parame, this.kme, this.ruw);
    this.ruy.DJ(2);
    parame = this.ruy;
    AppMethodBeat.o(111983);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111984);
    if (paramBoolean) {
      this.ruw.DR(1);
    }
    AppMethodBeat.o(111984);
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(111988);
    ad.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.axT().c(this);
    AppMethodBeat.o(111988);
    return false;
  }
  
  public final void af(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(112000);
    super.af(paramInt, paramBoolean);
    if ((!paramBoolean) && (paramInt == 0) && (this.ruy.ruo)) {
      this.ruE.setVisibility(0);
    }
    while (!paramBoolean)
    {
      this.ruA.setVisibility(8);
      this.ruw.d(paramInt, paramBoolean, false);
      AppMethodBeat.o(112000);
      return;
      this.ruE.setVisibility(8);
    }
    this.ruv = true;
    boolean bool2 = com.tencent.mm.plugin.fts.a.d.aba(this.query);
    boolean bool3 = com.tencent.mm.plugin.fts.a.d.abb(this.query);
    Object localObject = this.ruw;
    boolean bool1;
    if ((bool2) || (bool3))
    {
      bool1 = true;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).d(paramInt, paramBoolean, bool1);
      if (paramInt <= 0) {
        break label316;
      }
      if ((bool2) || (bool3)) {
        this.ruB.setVisibility(0);
      }
      label158:
      if ((bool2) || (bool3))
      {
        this.ruA.setVisibility(0);
        localObject = this.ruy.rue;
        if (!bool2) {
          break label328;
        }
        paramInt = 1;
        label192:
        if (!bool3) {
          break label333;
        }
        label197:
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).rwT = paramInt;
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).rwU = i;
        if (!bool2) {
          break label338;
        }
        paramInt = 8;
      }
    }
    for (;;)
    {
      localObject = this.ruy.rue;
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject).rwX + 1);
      localc.drI = "SearchContactBar";
      localc.roO = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject).rty);
      localc.drT = paramInt;
      if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject).rxd.contains(localc)) {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).rxd.add(localc);
      }
      AppMethodBeat.o(112000);
      return;
      bool1 = false;
      break;
      label316:
      this.ruB.setVisibility(8);
      break label158;
      label328:
      paramInt = 0;
      break label192;
      label333:
      i = 0;
      break label197;
      label338:
      paramInt = j;
      if (bool3) {
        paramInt = 9;
      }
    }
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(112002);
    super.cxN();
    this.ruB.setVisibility(8);
    this.ruA.setVisibility(8);
    this.ruI = 1;
    Object localObject1 = this.ruw;
    Object localObject2 = this.query;
    long l = com.tencent.mm.plugin.fts.a.e.roc;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryR == d.b.rzm)
    {
      k.H(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rxi, 11);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cxr();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cyK();
      int i = aa.Sb(5);
      ad.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i) });
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).a(d.b.rzm);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).query = ((String)localObject2);
      Object localObject3 = new byj();
      ((byj)localObject3).CLI = ((String)localObject2);
      ((byj)localObject3).DVb = String.valueOf(l);
      ((byj)localObject3).CzY = String.valueOf(com.tencent.mm.plugin.fts.a.e.rob);
      ((byj)localObject3).DVc = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pua, com.tencent.mm.util.c.fgV());
      ((byj)localObject3).DLD = i;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rxi = l;
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pub, 500);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryQ = new p((byj)localObject3);
      com.tencent.mm.kernel.g.aeS().a(1076, (com.tencent.mm.al.g)localObject1);
      com.tencent.mm.kernel.g.aeS().a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryQ, 0);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rty = System.currentTimeMillis();
      localObject3 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rxl.obtainMessage(1, Long.valueOf(l));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rxl.sendMessageDelayed((Message)localObject3, i);
      localObject2 = com.tencent.mm.plugin.fts.a.f.a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.getString(2131759714), "", com.tencent.mm.plugin.fts.a.a.e.b((CharSequence)localObject2, (String)localObject2)).rpj;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.getContext(), (CharSequence)localObject2, com.tencent.mm.cd.a.ao(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.getContext(), 2131165517));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rzg.setText((CharSequence)localObject2);
      k.H(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rxi, 1);
      localObject1 = null;
      if (!com.tencent.mm.plugin.fts.a.d.aba(this.query)) {
        break label483;
      }
      localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759677), "", com.tencent.mm.plugin.fts.a.a.e.b(this.query, this.query)).rpj;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)localObject1, com.tencent.mm.cd.a.ao(getContext(), 2131165517));
      this.ruC.setText((CharSequence)localObject1);
      AppMethodBeat.o(112002);
      return;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryR != d.b.rzo) {
        break;
      }
      k.H(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rxi, 8);
      break;
      label483:
      if (com.tencent.mm.plugin.fts.a.d.abb(this.query)) {
        localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759678), "", com.tencent.mm.plugin.fts.a.a.e.b(this.query, this.query)).rpj;
      }
    }
  }
  
  protected final void cxR()
  {
    AppMethodBeat.i(111982);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.kme = 0;
    }
    for (;;)
    {
      this.ruw = new com.tencent.mm.plugin.fts.ui.widget.d(this);
      AppMethodBeat.o(111982);
      return;
      this.kme = 1;
      continue;
      this.kme = 2;
      continue;
      this.kme = 3;
      continue;
      this.kme = 4;
    }
  }
  
  protected final void cxS()
  {
    AppMethodBeat.i(111994);
    super.cxS();
    cyc();
    this.ruE.setVisibility(8);
    if ((this.rus != null) && (!this.rus.rxN)) {
      this.rus.cys();
    }
    AppMethodBeat.o(111994);
  }
  
  protected final void cxT()
  {
    AppMethodBeat.i(111993);
    super.cxT();
    cyc();
    this.ruE.setVisibility(8);
    this.rtA.setVisibility(0);
    if ((this.rus != null) && (!this.rus.rxN)) {
      this.rus.cys();
    }
    AppMethodBeat.o(111993);
  }
  
  protected final void cxU()
  {
    AppMethodBeat.i(111992);
    super.cxU();
    cyc();
    this.ruE.setVisibility(8);
    if ((this.rus != null) && (!this.rus.rxN)) {
      this.rus.cys();
    }
    AppMethodBeat.o(111992);
  }
  
  protected final void cxV()
  {
    AppMethodBeat.i(111991);
    super.cxV();
    cyb();
    this.ruE.setVisibility(8);
    if ((this.rut) && (this.rus != null)) {
      this.rus.show();
    }
    AppMethodBeat.o(111991);
  }
  
  protected final void cxW()
  {
    AppMethodBeat.i(112004);
    super.cxW();
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.ruw;
    if (!locald.ryS)
    {
      locald.ryS = true;
      if (locald.ryR == d.b.rzm)
      {
        ad.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
        k.H(locald.rxi, 10);
        locald.bWe();
      }
    }
    AppMethodBeat.o(112004);
  }
  
  public final List<View> cxX()
  {
    AppMethodBeat.i(111996);
    ArrayList localArrayList = new ArrayList();
    if (this.ruz == null)
    {
      this.ruz = getLayoutInflater().inflate(2131494218, null, false);
      this.ruA = this.ruz.findViewById(2131304404);
      this.ruA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111974);
          paramAnonymousView = FTSMainUI.this;
          Object localObject1 = FTSMainUI.this.query;
          Object localObject2 = paramAnonymousView.ruy.rue;
          int i = paramAnonymousView.ruy.getCount();
          int j = paramAnonymousView.kme;
          Object localObject3 = new ea();
          ((ea)localObject3).dWE = j;
          boolean bool2;
          if (com.tencent.mm.plugin.fts.a.d.aba((String)localObject1))
          {
            ((ea)localObject3).dWF = 8L;
            ((ea)localObject3).dWG = (i + 1);
            if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rty > 0L) && (((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rty < System.currentTimeMillis())) {
              ((ea)localObject3).dWP = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwE);
            }
            if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwZ.equals(localObject1)) {
              ((ea)localObject3).dXg = 1L;
            }
            ea localea = ((ea)localObject3).kc("").kd("");
            localea.dWQ = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwI;
            localea.dWR = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwJ;
            localea.dWS = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwK;
            localea.dWT = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwL;
            localea.dWU = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwM;
            localea.dWV = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).favCount;
            localea.dWX = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwN;
            localea.dWY = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rwO;
            localea = localea.ke(String.valueOf(com.tencent.mm.plugin.fts.a.e.rob)).kf((String)localObject1);
            localea.dXc = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).cyf();
            localea = localea.kg("").kh("").ki("");
            localea.dXf = 1L;
            localea.kj("").kk("").kl("").km("").kn("").ko("").kp("").kq("").kr("");
            ((ea)localObject3).aBj();
            ad.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((ea)localObject3).PW().replace("\r\n", " ") });
            boolean bool1 = com.tencent.mm.plugin.fts.a.d.aba(paramAnonymousView.query);
            bool2 = com.tencent.mm.plugin.fts.a.d.abb(paramAnonymousView.query);
            if (!bool1) {
              break label509;
            }
          }
          for (i = 8;; i = 9)
          {
            ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).DN(i);
            localObject3 = paramAnonymousView.ruy;
            ((j)localObject3).rtZ = true;
            ((j)localObject3).ruf.DR(1);
            paramAnonymousView.ruy.rtZ = true;
            if (!paramAnonymousView.ruy.rtQ)
            {
              paramAnonymousView.ruy.rtQ = true;
              k.a((String)localObject1, true, paramAnonymousView.ruy.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject2);
            }
            if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).trim().length() != 0)) {
              break label526;
            }
            AppMethodBeat.o(111974);
            return;
            ((ea)localObject3).dWF = 9L;
            break;
            label509:
            if (!bool2) {
              break label520;
            }
          }
          label520:
          AppMethodBeat.o(111974);
          return;
          label526:
          if (Character.isDigit(((String)localObject1).charAt(0))) {}
          for (i = 15;; i = 3)
          {
            paramAnonymousView.rto = i;
            localObject2 = new FTSMainUI.12(paramAnonymousView, (String)localObject1);
            com.tencent.mm.kernel.g.aeS().a(106, (com.tencent.mm.al.g)localObject2);
            localObject1 = new com.tencent.mm.plugin.messenger.a.g((String)localObject1, 3);
            com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
            paramAnonymousView.getString(2131755906);
            paramAnonymousView.oWF = com.tencent.mm.ui.base.h.b(paramAnonymousView, paramAnonymousView.getString(2131762915), true, new FTSMainUI.13(paramAnonymousView, (com.tencent.mm.plugin.messenger.a.g)localObject1, (com.tencent.mm.al.g)localObject2));
            AppMethodBeat.o(111974);
            return;
          }
        }
      });
      this.ruB = this.ruz.findViewById(2131304403);
      this.ruC = ((TextView)this.ruz.findViewById(2131304405));
    }
    localArrayList.add(this.ruz);
    if (this.ruw.crg() != null) {
      localArrayList.add(this.ruw.crg());
    }
    if (this.ruD == null)
    {
      this.ruD = getLayoutInflater().inflate(2131494206, null, false);
      this.ruE = this.ruD.findViewById(2131301503);
    }
    localArrayList.add(this.ruD);
    AppMethodBeat.o(111996);
    return localArrayList;
  }
  
  protected final void cxY()
  {
    AppMethodBeat.i(111998);
    this.ruE.setVisibility(0);
    AppMethodBeat.o(111998);
  }
  
  protected final void cxZ()
  {
    AppMethodBeat.i(111999);
    this.ruE.setVisibility(8);
    AppMethodBeat.o(111999);
  }
  
  public void finish()
  {
    AppMethodBeat.i(111987);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111973);
        ad.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSMainUI.e(FTSMainUI.this);
        AppMethodBeat.o(111973);
      }
    }, i);
    AppMethodBeat.o(111987);
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(111995);
    Object localObject = this.ruw;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl == null)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl = LayoutInflater.from(((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryk).inflate(2131494225, null, false);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).contentView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131300713);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryp = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131304448);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryq = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131305535));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryr = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131305536));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).rys = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131305537));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryt = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131304444);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryu = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131304142);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).rwy = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131298673);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).frr = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131297008));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryv = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131298716));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).rwz = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131298593));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryw = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131298717));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryx = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131299178);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryy = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131299177));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryz = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131299180));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryA = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131299176));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryB = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131299175));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryC = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131299179));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryD = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131306351);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryE = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131306399));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryF = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131306333));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryG = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131306406));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryH = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131306313));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryI = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131302604);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryJ = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131302602));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryK = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131302619));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryL = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131302620));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryM = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131302601));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryN = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131302600));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryO = new com.tencent.mm.plugin.fts.ui.widget.e((com.tencent.mm.plugin.fts.ui.widget.d)localObject, (FrameLayout)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl.findViewById(2131306926));
    }
    localObject = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryl;
    AppMethodBeat.o(111995);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return 2131494209;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(111980);
    finish();
    AppMethodBeat.o(111980);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111978);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.rux = ((KeyboardLinearLayout)findViewById(2131304239));
    this.rux.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void DK(int paramAnonymousInt)
      {
        AppMethodBeat.i(111962);
        if (paramAnonymousInt == -3)
        {
          ad.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
          new ap().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111960);
              FTSMainUI.a(FTSMainUI.this, true);
              if ((bt.isNullOrNil(FTSMainUI.this.rtG.getSearchContent())) && (FTSMainUI.a(FTSMainUI.this) != null)) {
                FTSMainUI.a(FTSMainUI.this).show();
              }
              AppMethodBeat.o(111960);
            }
          }, 0L);
          AppMethodBeat.o(111962);
          return;
        }
        if (paramAnonymousInt == -2)
        {
          new ap().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111961);
              FTSMainUI.a(FTSMainUI.this, false);
              if (FTSMainUI.a(FTSMainUI.this) != null) {
                FTSMainUI.a(FTSMainUI.this).cys();
              }
              AppMethodBeat.o(111961);
            }
          }, 0L);
          ad.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
        }
        AppMethodBeat.o(111962);
      }
    });
    this.rtG.setHint(getString(2131755882));
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.fts.a.e.rob = com.tencent.mm.plugin.fts.a.d.DB(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.kme), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Integer.valueOf(0), "", "" });
    ad.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(10991, paramBundle);
    this.rur = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.rur.setOnCellClickListener(this.ruG);
    this.rur.setOnHotwordClickListener(new FTSMainUI.6(this));
    this.rur.setNeedHotWord(false);
    com.tencent.e.h.Iye.f(new FTSMainUI.8(this), "FTSMainUI.GetLocation");
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(111978);
      return;
    }
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cwY();
    com.tencent.mm.plugin.websearch.api.ac.Sf(3);
    com.tencent.mm.sdk.b.a.ESL.b(this.ruH);
    AppMethodBeat.o(111978);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool3 = true;
    AppMethodBeat.i(111979);
    boolean bool4 = super.onCreateOptionsMenu(paramMenu);
    paramMenu = this.rtG;
    Object localObject = this.ruw;
    if (paramMenu.Hto != null) {
      paramMenu.Hto.setFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
    if ((com.tencent.mm.sdk.platformtools.ac.eFq()) || (com.tencent.mm.sdk.platformtools.ac.eFu().equals("en"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(111979);
      return bool4;
    }
    paramMenu = (FTSVoiceInputLayoutImpl)findViewById(2131300318);
    localObject = (TextView)findViewById(2131306551);
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131306549);
    if ((paramMenu == null) || (localObject == null) || (localProgressBar == null))
    {
      boolean bool1;
      boolean bool2;
      if (paramMenu == null)
      {
        bool1 = true;
        if (localObject != null) {
          break label201;
        }
        bool2 = true;
        label146:
        if (localProgressBar != null) {
          break label207;
        }
      }
      for (;;)
      {
        ad.w("MicroMsg.FTS.FTSMainUI", "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        AppMethodBeat.o(111979);
        return bool4;
        bool1 = false;
        break;
        label201:
        bool2 = false;
        break label146;
        label207:
        bool3 = false;
      }
    }
    this.rus = new com.tencent.mm.plugin.fts.ui.widget.b(this, paramMenu, (TextView)localObject, localProgressBar);
    this.rus.rxM = new com.tencent.mm.plugin.fts.ui.widget.b.a()
    {
      public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString)
      {
        AppMethodBeat.i(111969);
        FTSMainUI.this.rtG.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        if (!paramAnonymousBoolean1)
        {
          if (paramAnonymousBoolean2)
          {
            FTSMainUI.abv(FTSMainUI.this.getString(2131759722));
            AppMethodBeat.o(111969);
            return;
          }
          FTSMainUI.abv(FTSMainUI.this.getString(2131759723));
        }
        AppMethodBeat.o(111969);
      }
      
      public final void abw(String paramAnonymousString)
      {
        AppMethodBeat.i(111968);
        FTSMainUI.this.rtG.setSearchContent(paramAnonymousString);
        AppMethodBeat.o(111968);
      }
      
      public final void abx(String paramAnonymousString)
      {
        AppMethodBeat.i(111970);
        FTSMainUI.c(FTSMainUI.this).rue.rwZ = paramAnonymousString;
        FTSMainUI.this.rtG.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        AppMethodBeat.o(111970);
      }
      
      public final void cyd()
      {
        AppMethodBeat.i(111967);
        FTSMainUI.this.rtG.setCursorVisible(false);
        FTSMainUI.c(FTSMainUI.this).DJ(1);
        FTSMainUI.d(FTSMainUI.this);
        FTSMainUI.this.rtG.setHint(FTSMainUI.this.getContext().getString(2131759720));
        AppMethodBeat.o(111967);
      }
    };
    AppMethodBeat.o(111979);
    return bool4;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111985);
    com.tencent.e.h.Iye.aNW("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.axT().c(this);
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cwZ();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.ruH);
    Object localObject;
    if (this.rus != null)
    {
      localObject = this.rus;
      if (((com.tencent.mm.plugin.fts.ui.widget.b)localObject).rxO != null)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).rxO.aDZ();
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).rxO;
        if (((VoiceInputLayout)localObject).kQO != null) {
          ((VoiceInputLayout)localObject).kQO.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).rzG != null) {
          ((VoiceInputLayout)localObject).rzG.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).hFy != null) {
          ((VoiceInputLayout)localObject).hFy.stopTimer();
        }
      }
    }
    if (this.ruw != null)
    {
      localObject = this.ruw;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryO != null)
      {
        com.tencent.mm.plugin.fts.ui.widget.e locale = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).ryO;
        locale.rzs.removeJavascriptInterface("pardusJSApi");
        locale.rzs.destroy();
      }
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).DR(3);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cyJ();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cxr();
    }
    super.onDestroy();
    AppMethodBeat.o(111985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111986);
    super.onResume();
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111972);
        com.tencent.mm.compatible.util.i.v(FTSMainUI.this);
        AppMethodBeat.o(111972);
      }
    });
    wi localwi = new wi();
    localwi.dBP.ed = 0L;
    com.tencent.mm.sdk.b.a.ESL.l(localwi);
    if (!bt.isNullOrNil(this.ruu))
    {
      this.query = this.ruu;
      this.ruu = null;
    }
    aa.ehU();
    AppMethodBeat.o(111986);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111981);
    hideVKB();
    super.onStop();
    AppMethodBeat.o(111981);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(112003);
    super.stopSearch();
    this.ruI = 1;
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.ruw;
    locald.cyJ();
    locald.cxr();
    locald.clearData();
    locald.cyK();
    AppMethodBeat.o(112003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */