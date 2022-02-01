package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.a.zf;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.g.b.a.jt;
import com.tencent.mm.plugin.fts.ui.webview.PardusWebView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.fts.ui.widget.d.b;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class FTSMainUI
  extends FTSBaseVoiceSearchUI
  implements com.tencent.mm.modelgeo.b.a
{
  public int ljZ;
  Dialog qdv;
  private boolean tAa;
  private String tAb;
  private volatile boolean tAc;
  com.tencent.mm.plugin.fts.ui.widget.d tAd;
  private KeyboardLinearLayout tAe;
  public k tAf;
  private View tAg;
  View tAh;
  private View tAi;
  private TextView tAj;
  private View tAk;
  private View tAl;
  private com.tencent.mm.plugin.websearch.api.k tAm;
  private View.OnClickListener tAn;
  private com.tencent.mm.sdk.b.c<zf> tAo;
  int tAp;
  int tyJ;
  private FTSMainUIEducationLayout tzY;
  private com.tencent.mm.plugin.fts.ui.widget.b tzZ;
  
  public FTSMainUI()
  {
    AppMethodBeat.i(111977);
    this.tAa = false;
    this.tyJ = -1;
    this.tAm = new com.tencent.mm.plugin.websearch.api.k() {};
    this.tAn = new FTSMainUI.4(this);
    this.tAo = new com.tencent.mm.sdk.b.c() {};
    this.tAp = 1;
    AppMethodBeat.o(111977);
  }
  
  private void cTG()
  {
    AppMethodBeat.i(111989);
    this.tzY.setVisibility(0);
    this.tzY.updateView();
    AppMethodBeat.o(111989);
  }
  
  private void cTH()
  {
    AppMethodBeat.i(111990);
    this.tzY.setVisibility(8);
    AppMethodBeat.o(111990);
  }
  
  public final boolean Jp(String paramString)
  {
    AppMethodBeat.i(111997);
    super.Jp(paramString);
    if ((this.tAc) && (!TextUtils.isEmpty(this.query)))
    {
      Object localObject = this.tAf;
      paramString = new ArrayList();
      localObject = ((k)localObject).tzK.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject).next()).cST());
      }
      if ((paramString.size() != 0) || (!TextUtils.isEmpty(this.tAj.getText())) || (this.tAd.dlh)) {
        break label362;
      }
      this.tAd.dF(this.query, 17);
      paramString = new jt();
      paramString.eCo = 1L;
      paramString.dPH = 1L;
      paramString.sn(this.query).aLk();
      int i = this.ljZ;
      paramString = this.tAf.tzM;
      localObject = new gr();
      ((gr)localObject).eoX = i;
      ((gr)localObject).eoY = 29L;
      ((gr)localObject).epa = 1L;
      ((gr)localObject).epv = paramString.cTK();
      gr localgr = ((gr)localObject).pk("").pl("").pn(paramString.query).pm("").po("").pp("").pq("").pr("").pt("").pu("").pv("").pw("").px("").py("").pz("");
      localgr.epN = com.tencent.mm.plugin.fts.a.e.ttw;
      localgr.epO = paramString.tCs;
      localgr.pA("");
      ((gr)localObject).aLk();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((gr)localObject).RE().replace("\r\n", " ") });
      this.tAd.Hc(8);
    }
    for (;;)
    {
      AppMethodBeat.o(111997);
      return false;
      label362:
      paramString = new jt();
      paramString.eCo = 1L;
      paramString.dPH = 2L;
      paramString.sn(this.query).aLk();
    }
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(112001);
    if ((this.tzZ == null) || (!this.tzZ.tDy)) {
      super.Jq(paramString);
    }
    this.tAc = false;
    AppMethodBeat.o(112001);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111983);
    this.tAf = new k(parame, this.ljZ, this.tAd);
    this.tAf.GU(2);
    parame = this.tAf;
    AppMethodBeat.o(111983);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111984);
    if (paramBoolean) {
      this.tAd.Hc(1);
    }
    AppMethodBeat.o(111984);
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(111988);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.aHQ().c(this);
    AppMethodBeat.o(111988);
    return false;
  }
  
  public final void am(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(112000);
    super.am(paramInt, paramBoolean);
    if ((!paramBoolean) && (paramInt == 0) && (this.tAf.tzV)) {
      this.tAl.setVisibility(0);
    }
    while (!paramBoolean)
    {
      this.tAh.setVisibility(8);
      this.tAd.e(paramInt, paramBoolean, false);
      AppMethodBeat.o(112000);
      return;
      this.tAl.setVisibility(8);
    }
    this.tAc = true;
    boolean bool2 = com.tencent.mm.plugin.fts.a.d.akq(this.query);
    boolean bool3 = com.tencent.mm.plugin.fts.a.d.akr(this.query);
    Object localObject = this.tAd;
    boolean bool1;
    if ((bool2) || (bool3))
    {
      bool1 = true;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).e(paramInt, paramBoolean, bool1);
      if (paramInt <= 0) {
        break label316;
      }
      if ((bool2) || (bool3)) {
        this.tAi.setVisibility(0);
      }
      label158:
      if ((bool2) || (bool3))
      {
        this.tAh.setVisibility(0);
        localObject = this.tAf.tzM;
        if (!bool2) {
          break label328;
        }
        paramInt = 1;
        label192:
        if (!bool3) {
          break label333;
        }
        label197:
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tCF = paramInt;
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tCG = i;
        if (!bool2) {
          break label338;
        }
        paramInt = 8;
      }
    }
    for (;;)
    {
      localObject = this.tAf.tzM;
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject).tCJ + 1);
      localc.dBg = "SearchContactBar";
      localc.tuj = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tyS);
      localc.dBr = paramInt;
      if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject).tCP.contains(localc)) {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tCP.add(localc);
      }
      AppMethodBeat.o(112000);
      return;
      bool1 = false;
      break;
      label316:
      this.tAi.setVisibility(8);
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
  
  protected final void cTB()
  {
    AppMethodBeat.i(112004);
    super.cTB();
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.tAd;
    if (!locald.tEC)
    {
      locald.tEC = true;
      if (locald.tEB == d.b.tEP)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
        l.O(locald.tzp, 10);
        locald.chU();
      }
    }
    AppMethodBeat.o(112004);
  }
  
  public final List<View> cTC()
  {
    AppMethodBeat.i(111996);
    ArrayList localArrayList = new ArrayList();
    if (this.tAg == null)
    {
      this.tAg = getLayoutInflater().inflate(2131494218, null, false);
      this.tAh = this.tAg.findViewById(2131304404);
      this.tAh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111974);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
          paramAnonymousView = FTSMainUI.this;
          localObject1 = FTSMainUI.this.query;
          Object localObject2 = paramAnonymousView.tAf.tzM;
          int i = paramAnonymousView.tAf.getCount();
          int j = paramAnonymousView.ljZ;
          Object localObject3 = new gr();
          ((gr)localObject3).eoX = j;
          boolean bool2;
          if (com.tencent.mm.plugin.fts.a.d.akq((String)localObject1))
          {
            ((gr)localObject3).eoY = 8L;
            ((gr)localObject3).eoZ = (i + 1);
            if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tyS > 0L) && (((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tyS < System.currentTimeMillis())) {
              ((gr)localObject3).epi = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCq);
            }
            if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCL.equals(localObject1)) {
              ((gr)localObject3).epy = 1L;
            }
            gr localgr = ((gr)localObject3).pk("").pl("");
            localgr.epj = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCu;
            localgr.epk = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCv;
            localgr.epl = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCw;
            localgr.epm = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCx;
            localgr.epn = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCy;
            localgr.epo = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).favCount;
            localgr.epq = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCz;
            localgr.epr = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCA;
            localgr = localgr.pm(String.valueOf(com.tencent.mm.plugin.fts.a.e.ttw)).pn((String)localObject1);
            localgr.epv = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).cTK();
            localgr = localgr.po("").pp("").pq("");
            localgr.epx = 1L;
            localgr.pr("").pt("").pu("").pv("").pw("").px("").py("").pz("").pA("");
            ((gr)localObject3).aLk();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((gr)localObject3).RE().replace("\r\n", " ") });
            boolean bool1 = com.tencent.mm.plugin.fts.a.d.akq(paramAnonymousView.query);
            bool2 = com.tencent.mm.plugin.fts.a.d.akr(paramAnonymousView.query);
            if (!bool1) {
              break label555;
            }
          }
          for (i = 8;; i = 9)
          {
            ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).GY(i);
            localObject3 = paramAnonymousView.tAf;
            ((k)localObject3).tzH = true;
            ((k)localObject3).tzN.Hc(1);
            paramAnonymousView.tAf.tzH = true;
            if (!paramAnonymousView.tAf.tzy)
            {
              paramAnonymousView.tAf.tzy = true;
              l.a((String)localObject1, true, paramAnonymousView.tAf.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject2);
            }
            if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).trim().length() != 0)) {
              break label566;
            }
            label555:
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111974);
              return;
              ((gr)localObject3).eoY = 9L;
              break;
            } while (!bool2);
          }
          label566:
          if (Character.isDigit(((String)localObject1).charAt(0))) {}
          for (i = 15;; i = 3)
          {
            paramAnonymousView.tyJ = i;
            localObject2 = new FTSMainUI.12(paramAnonymousView, (String)localObject1);
            com.tencent.mm.kernel.g.aiU().a(106, (com.tencent.mm.al.f)localObject2);
            localObject1 = new com.tencent.mm.plugin.messenger.a.f((String)localObject1, 3);
            com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
            paramAnonymousView.getString(2131755906);
            paramAnonymousView.qdv = com.tencent.mm.ui.base.h.b(paramAnonymousView, paramAnonymousView.getString(2131762915), true, new FTSMainUI.13(paramAnonymousView, (com.tencent.mm.plugin.messenger.a.f)localObject1, (com.tencent.mm.al.f)localObject2));
            break;
          }
        }
      });
      this.tAi = this.tAg.findViewById(2131304403);
      this.tAj = ((TextView)this.tAg.findViewById(2131304405));
    }
    localArrayList.add(this.tAg);
    if (this.tAd.cJS() != null) {
      localArrayList.add(this.tAd.cJS());
    }
    if (this.tAk == null)
    {
      this.tAk = getLayoutInflater().inflate(2131494206, null, false);
      this.tAl = this.tAk.findViewById(2131301503);
    }
    localArrayList.add(this.tAk);
    AppMethodBeat.o(111996);
    return localArrayList;
  }
  
  protected final void cTD()
  {
    AppMethodBeat.i(111998);
    this.tAl.setVisibility(0);
    AppMethodBeat.o(111998);
  }
  
  protected final void cTE()
  {
    AppMethodBeat.i(111999);
    this.tAl.setVisibility(8);
    AppMethodBeat.o(111999);
  }
  
  protected final void cTo()
  {
    AppMethodBeat.i(112002);
    super.cTo();
    this.tAi.setVisibility(8);
    this.tAh.setVisibility(8);
    this.tAp = 1;
    Object localObject1 = this.tAd;
    Object localObject2 = this.query;
    long l = com.tencent.mm.plugin.fts.a.e.ttx;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tEB == d.b.tEP)
    {
      l.O(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzp, 11);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cSS();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cUp();
      int i = com.tencent.mm.plugin.websearch.api.ad.We(5);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i) });
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).a(d.b.tEP);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).query = ((String)localObject2);
      Object localObject3 = new cid();
      ((cid)localObject3).FKK = ((String)localObject2);
      ((cid)localObject3).HbT = String.valueOf(l);
      ((cid)localObject3).FxN = String.valueOf(com.tencent.mm.plugin.fts.a.e.ttw);
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
      com.tencent.mm.plugin.expt.b.b.a locala = com.tencent.mm.plugin.expt.b.b.a.qDu;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
      ((cid)localObject3).HbU = localb.a(locala, com.tencent.mm.util.c.fNJ());
      ((cid)localObject3).GDa = i;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzp = l;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDv, 500);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tEA = new com.tencent.mm.plugin.websearch.api.r((cid)localObject3);
      com.tencent.mm.kernel.g.aiU().a(1076, (com.tencent.mm.al.f)localObject1);
      com.tencent.mm.kernel.g.aiU().a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tEA, 0);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tyS = System.currentTimeMillis();
      localObject3 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tCW.obtainMessage(1, Long.valueOf(l));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tCW.sendMessageDelayed((Message)localObject3, i);
      localObject2 = com.tencent.mm.plugin.fts.a.f.a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.getString(2131759714), "", com.tencent.mm.plugin.fts.a.a.e.c((CharSequence)localObject2, (String)localObject2)).tuE;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.getContext(), (CharSequence)localObject2, com.tencent.mm.cc.a.ax(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.getContext(), 2131165517));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzl.setText((CharSequence)localObject2);
      l.O(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzp, 1);
      localObject1 = null;
      if (!com.tencent.mm.plugin.fts.a.d.akq(this.query)) {
        break label496;
      }
      localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759677), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).tuE;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)localObject1, com.tencent.mm.cc.a.ax(getContext(), 2131165517));
      this.tAj.setText((CharSequence)localObject1);
      AppMethodBeat.o(112002);
      return;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tEB != d.b.tER) {
        break;
      }
      l.O(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzp, 8);
      break;
      label496:
      if (com.tencent.mm.plugin.fts.a.d.akr(this.query)) {
        localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759678), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).tuE;
      }
    }
  }
  
  protected final void cTt()
  {
    AppMethodBeat.i(111982);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.ljZ = 0;
    }
    for (;;)
    {
      this.tAd = new com.tencent.mm.plugin.fts.ui.widget.d(this);
      AppMethodBeat.o(111982);
      return;
      this.ljZ = 1;
      continue;
      this.ljZ = 2;
      continue;
      this.ljZ = 3;
      continue;
      this.ljZ = 4;
    }
  }
  
  protected final void cTv()
  {
    AppMethodBeat.i(111994);
    super.cTv();
    cTH();
    this.tAl.setVisibility(8);
    if ((this.tzZ != null) && (!this.tzZ.tDy)) {
      this.tzZ.cTX();
    }
    AppMethodBeat.o(111994);
  }
  
  protected final void cTw()
  {
    AppMethodBeat.i(111993);
    super.cTw();
    cTH();
    this.tAl.setVisibility(8);
    this.tyU.setVisibility(0);
    if ((this.tzZ != null) && (!this.tzZ.tDy)) {
      this.tzZ.cTX();
    }
    AppMethodBeat.o(111993);
  }
  
  protected final void cTx()
  {
    AppMethodBeat.i(111992);
    super.cTx();
    cTH();
    this.tAl.setVisibility(8);
    if ((this.tzZ != null) && (!this.tzZ.tDy)) {
      this.tzZ.cTX();
    }
    AppMethodBeat.o(111992);
  }
  
  protected final void cTy()
  {
    AppMethodBeat.i(111991);
    super.cTy();
    cTG();
    this.tAl.setVisibility(8);
    if ((this.tAa) && (this.tzZ != null)) {
      this.tzZ.show();
    }
    AppMethodBeat.o(111991);
  }
  
  public void finish()
  {
    AppMethodBeat.i(111987);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111973);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSMainUI.e(FTSMainUI.this);
        AppMethodBeat.o(111973);
      }
    }, i);
    AppMethodBeat.o(111987);
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(111995);
    Object localObject = this.tAd;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW == null)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW = LayoutInflater.from(((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDV).inflate(2131494225, null, false);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).contentView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131300713);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEa = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131304448);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEb = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131305535));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEc = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131305536));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEd = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131305537));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEe = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131304444);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEf = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131304142);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tCk = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131298673);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).fOf = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131297008));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEg = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131298716));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tCl = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131298593));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEh = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131298717));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEi = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131299178);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEj = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131299177));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEk = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131299180));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEl = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131299176));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEm = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131299175));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEn = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131299179));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEo = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131306351);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEp = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131306399));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEq = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131306333));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEr = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131306406));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEs = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131306313));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEt = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131302604);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEu = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131302602));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEv = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131302619));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEw = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131302620));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEx = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131302601));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEy = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131302600));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEz = new com.tencent.mm.plugin.fts.ui.widget.e((com.tencent.mm.plugin.fts.ui.widget.d)localObject, (FrameLayout)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW.findViewById(2131306926));
    }
    localObject = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tDW;
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
    this.tAe = ((KeyboardLinearLayout)findViewById(2131304239));
    this.tAe.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void GV(int paramAnonymousInt)
      {
        AppMethodBeat.i(111962);
        if (paramAnonymousInt == -3)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
          new ap().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111960);
              FTSMainUI.a(FTSMainUI.this, true);
              if ((bt.isNullOrNil(FTSMainUI.this.tza.getSearchContent())) && (FTSMainUI.a(FTSMainUI.this) != null)) {
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
                FTSMainUI.a(FTSMainUI.this).cTX();
              }
              AppMethodBeat.o(111961);
            }
          }, 0L);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
        }
        AppMethodBeat.o(111962);
      }
    });
    this.tza.setHint(getString(2131755882));
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.fts.a.e.ttw = com.tencent.mm.plugin.fts.a.d.GM(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.ljZ), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.ttw), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.ttw), Integer.valueOf(0), "", "" });
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(10991, paramBundle);
    this.tzY = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.tzY.setOnCellClickListener(this.tAn);
    this.tzY.setOnHotwordClickListener(new FTSMainUI.6(this));
    this.tzY.setNeedHotWord(false);
    com.tencent.e.h.LTJ.f(new FTSMainUI.8(this), "FTSMainUI.GetLocation");
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(111978);
      return;
    }
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cSz();
    af.Wi(3);
    com.tencent.mm.sdk.b.a.IbL.b(this.tAo);
    AppMethodBeat.o(111978);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool3 = true;
    AppMethodBeat.i(111979);
    boolean bool4 = super.onCreateOptionsMenu(paramMenu);
    paramMenu = this.tza;
    Object localObject = this.tAd;
    if (paramMenu.KKP != null) {
      paramMenu.KKP.setFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
    if ((ac.fko()) || (ac.fks().equals("en"))) {}
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
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.FTS.FTSMainUI", "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
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
    this.tzZ = new com.tencent.mm.plugin.fts.ui.widget.b(this, paramMenu, (TextView)localObject, localProgressBar);
    this.tzZ.tDx = new com.tencent.mm.plugin.fts.ui.widget.b.a()
    {
      public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString)
      {
        AppMethodBeat.i(111969);
        FTSMainUI.this.tza.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        if (!paramAnonymousBoolean1)
        {
          if (paramAnonymousBoolean2)
          {
            FTSMainUI.akL(FTSMainUI.this.getString(2131759722));
            AppMethodBeat.o(111969);
            return;
          }
          FTSMainUI.akL(FTSMainUI.this.getString(2131759723));
        }
        AppMethodBeat.o(111969);
      }
      
      public final void akM(String paramAnonymousString)
      {
        AppMethodBeat.i(111968);
        FTSMainUI.this.tza.setSearchContent(paramAnonymousString);
        AppMethodBeat.o(111968);
      }
      
      public final void akN(String paramAnonymousString)
      {
        AppMethodBeat.i(111970);
        FTSMainUI.c(FTSMainUI.this).tzM.tCL = paramAnonymousString;
        FTSMainUI.this.tza.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        AppMethodBeat.o(111970);
      }
      
      public final void cTI()
      {
        AppMethodBeat.i(111967);
        FTSMainUI.this.tza.setCursorVisible(false);
        FTSMainUI.c(FTSMainUI.this).GU(1);
        FTSMainUI.d(FTSMainUI.this);
        FTSMainUI.this.tza.setHint(FTSMainUI.this.getContext().getString(2131759720));
        AppMethodBeat.o(111967);
      }
    };
    AppMethodBeat.o(111979);
    return bool4;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111985);
    com.tencent.e.h.LTJ.aZz("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.aHQ().c(this);
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cSA();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.tAo);
    Object localObject;
    if (this.tzZ != null)
    {
      localObject = this.tzZ;
      if (((com.tencent.mm.plugin.fts.ui.widget.b)localObject).tDz != null)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).tDz.aNZ();
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).tDz;
        if (((VoiceInputLayout)localObject).lRx != null) {
          ((VoiceInputLayout)localObject).lRx.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).tFj != null) {
          ((VoiceInputLayout)localObject).tFj.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).izu != null) {
          ((VoiceInputLayout)localObject).izu.stopTimer();
        }
      }
    }
    if (this.tAd != null)
    {
      localObject = this.tAd;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEz != null)
      {
        com.tencent.mm.plugin.fts.ui.widget.e locale = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tEz;
        locale.tEV.removeJavascriptInterface("pardusJSApi");
        locale.tEV.destroy();
      }
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).Hc(3);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cUo();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cSS();
    }
    super.onDestroy();
    AppMethodBeat.o(111985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111986);
    super.onResume();
    runOnUiThread(new FTSMainUI.9(this));
    xm localxm = new xm();
    localxm.dLP.gW = 0L;
    com.tencent.mm.sdk.b.a.IbL.l(localxm);
    if (!bt.isNullOrNil(this.tAb))
    {
      this.query = this.tAb;
      this.tAb = null;
    }
    com.tencent.mm.plugin.websearch.api.ad.eMe();
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
    this.tAp = 1;
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.tAd;
    locald.cUo();
    locald.cSS();
    locald.clearData();
    locald.cUp();
    AppMethodBeat.o(112003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */