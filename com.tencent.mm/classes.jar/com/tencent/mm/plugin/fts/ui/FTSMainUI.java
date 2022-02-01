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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.zl;
import com.tencent.mm.g.b.a.gt;
import com.tencent.mm.g.b.a.jv;
import com.tencent.mm.plugin.fts.ui.webview.PardusWebView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.fts.ui.widget.d.b;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
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
  public int lox;
  Dialog qka;
  int tJA;
  private FTSMainUIEducationLayout tKP;
  private com.tencent.mm.plugin.fts.ui.widget.b tKQ;
  private boolean tKR;
  private String tKS;
  private volatile boolean tKT;
  com.tencent.mm.plugin.fts.ui.widget.d tKU;
  private KeyboardLinearLayout tKV;
  public k tKW;
  private View tKX;
  View tKY;
  private View tKZ;
  private TextView tLa;
  private View tLb;
  private View tLc;
  private com.tencent.mm.plugin.websearch.api.k tLd;
  private View.OnClickListener tLe;
  private com.tencent.mm.sdk.b.c<zl> tLf;
  int tLg;
  
  public FTSMainUI()
  {
    AppMethodBeat.i(111977);
    this.tKR = false;
    this.tJA = -1;
    this.tLd = new com.tencent.mm.plugin.websearch.api.k() {};
    this.tLe = new FTSMainUI.4(this);
    this.tLf = new com.tencent.mm.sdk.b.c() {};
    this.tLg = 1;
    AppMethodBeat.o(111977);
  }
  
  private void cWl()
  {
    AppMethodBeat.i(111989);
    this.tKP.setVisibility(0);
    this.tKP.updateView();
    AppMethodBeat.o(111989);
  }
  
  private void cWm()
  {
    AppMethodBeat.i(111990);
    this.tKP.setVisibility(8);
    AppMethodBeat.o(111990);
  }
  
  public final boolean JO(String paramString)
  {
    AppMethodBeat.i(111997);
    super.JO(paramString);
    if ((this.tKT) && (!TextUtils.isEmpty(this.query)))
    {
      Object localObject = this.tKW;
      paramString = new ArrayList();
      localObject = ((k)localObject).tKB.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject).next()).cVy());
      }
      if ((paramString.size() != 0) || (!TextUtils.isEmpty(this.tLa.getText())) || (this.tKU.dmj)) {
        break label362;
      }
      this.tKU.dJ(this.query, 17);
      paramString = new jv();
      paramString.eDX = 1L;
      paramString.dQX = 1L;
      paramString.sI(this.query).aLH();
      int i = this.lox;
      paramString = this.tKW.tKD;
      localObject = new gt();
      ((gt)localObject).eqE = i;
      ((gt)localObject).eqF = 29L;
      ((gt)localObject).eqH = 1L;
      ((gt)localObject).erc = paramString.cWp();
      gt localgt = ((gt)localObject).pG("").pH("").pJ(paramString.query).pI("").pK("").pL("").pM("").pN("").pO("").pP("").pQ("").pR("").pS("").pT("").pU("");
      localgt.eru = com.tencent.mm.plugin.fts.a.e.tEn;
      localgt.erv = paramString.tNj;
      localgt.pV("");
      ((gt)localObject).aLH();
      ae.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((gt)localObject).RD().replace("\r\n", " ") });
      this.tKU.Hz(8);
    }
    for (;;)
    {
      AppMethodBeat.o(111997);
      return false;
      label362:
      paramString = new jv();
      paramString.eDX = 1L;
      paramString.dQX = 2L;
      paramString.sI(this.query).aLH();
    }
  }
  
  public final void JP(String paramString)
  {
    AppMethodBeat.i(112001);
    if ((this.tKQ == null) || (!this.tKQ.tOp)) {
      super.JP(paramString);
    }
    this.tKT = false;
    AppMethodBeat.o(112001);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111983);
    this.tKW = new k(parame, this.lox, this.tKU);
    this.tKW.Hr(2);
    parame = this.tKW;
    AppMethodBeat.o(111983);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111984);
    if (paramBoolean) {
      this.tKU.Hz(1);
    }
    AppMethodBeat.o(111984);
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(111988);
    ae.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.aIh().c(this);
    AppMethodBeat.o(111988);
    return false;
  }
  
  public final void ap(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(112000);
    super.ap(paramInt, paramBoolean);
    if ((!paramBoolean) && (paramInt == 0) && (this.tKW.tKM)) {
      this.tLc.setVisibility(0);
    }
    while (!paramBoolean)
    {
      this.tKY.setVisibility(8);
      this.tKU.e(paramInt, paramBoolean, false);
      AppMethodBeat.o(112000);
      return;
      this.tLc.setVisibility(8);
    }
    this.tKT = true;
    boolean bool2 = com.tencent.mm.plugin.fts.a.d.alo(this.query);
    boolean bool3 = com.tencent.mm.plugin.fts.a.d.alp(this.query);
    Object localObject = this.tKU;
    boolean bool1;
    if ((bool2) || (bool3))
    {
      bool1 = true;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).e(paramInt, paramBoolean, bool1);
      if (paramInt <= 0) {
        break label316;
      }
      if ((bool2) || (bool3)) {
        this.tKZ.setVisibility(0);
      }
      label158:
      if ((bool2) || (bool3))
      {
        this.tKY.setVisibility(0);
        localObject = this.tKW.tKD;
        if (!bool2) {
          break label328;
        }
        paramInt = 1;
        label192:
        if (!bool3) {
          break label333;
        }
        label197:
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tNw = paramInt;
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tNx = i;
        if (!bool2) {
          break label338;
        }
        paramInt = 8;
      }
    }
    for (;;)
    {
      localObject = this.tKW.tKD;
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject).tNA + 1);
      localc.dCl = "SearchContactBar";
      localc.tFa = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tJJ);
      localc.dCw = paramInt;
      if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject).tNG.contains(localc)) {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).tNG.add(localc);
      }
      AppMethodBeat.o(112000);
      return;
      bool1 = false;
      break;
      label316:
      this.tKZ.setVisibility(8);
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
  
  protected final void cVT()
  {
    AppMethodBeat.i(112002);
    super.cVT();
    this.tKZ.setVisibility(8);
    this.tKY.setVisibility(8);
    this.tLg = 1;
    Object localObject1 = this.tKU;
    Object localObject2 = this.query;
    long l = com.tencent.mm.plugin.fts.a.e.tEo;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tPs == d.b.tPG)
    {
      l.O(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKg, 11);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cVx();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cWU();
      int i = com.tencent.mm.plugin.websearch.api.ad.WL(5);
      ae.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i) });
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).a(d.b.tPG);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).query = ((String)localObject2);
      Object localObject3 = new cix();
      ((cix)localObject3).Gdj = ((String)localObject2);
      ((cix)localObject3).Hvt = String.valueOf(l);
      ((cix)localObject3).FQl = String.valueOf(com.tencent.mm.plugin.fts.a.e.tEn);
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
      com.tencent.mm.plugin.expt.b.b.a locala = com.tencent.mm.plugin.expt.b.b.a.qKW;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
      ((cix)localObject3).Hvu = localb.a(locala, com.tencent.mm.util.c.fSe());
      ((cix)localObject3).GWA = i;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKg = l;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qKX, 500);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tPr = new com.tencent.mm.plugin.websearch.api.r((cix)localObject3);
      com.tencent.mm.kernel.g.ajj().a(1076, (com.tencent.mm.ak.f)localObject1);
      com.tencent.mm.kernel.g.ajj().a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tPr, 0);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tJJ = System.currentTimeMillis();
      localObject3 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tNN.obtainMessage(1, Long.valueOf(l));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tNN.sendMessageDelayed((Message)localObject3, i);
      localObject2 = com.tencent.mm.plugin.fts.a.f.a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.getString(2131759714), "", com.tencent.mm.plugin.fts.a.a.e.c((CharSequence)localObject2, (String)localObject2)).tFv;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.getContext(), (CharSequence)localObject2, com.tencent.mm.cb.a.ax(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.getContext(), 2131165517));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKc.setText((CharSequence)localObject2);
      l.O(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKg, 1);
      localObject1 = null;
      if (!com.tencent.mm.plugin.fts.a.d.alo(this.query)) {
        break label496;
      }
      localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759677), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).tFv;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)localObject1, com.tencent.mm.cb.a.ax(getContext(), 2131165517));
      this.tLa.setText((CharSequence)localObject1);
      AppMethodBeat.o(112002);
      return;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tPs != d.b.tPI) {
        break;
      }
      l.O(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKg, 8);
      break;
      label496:
      if (com.tencent.mm.plugin.fts.a.d.alp(this.query)) {
        localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759678), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).tFv;
      }
    }
  }
  
  protected final void cVY()
  {
    AppMethodBeat.i(111982);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.lox = 0;
    }
    for (;;)
    {
      this.tKU = new com.tencent.mm.plugin.fts.ui.widget.d(this);
      AppMethodBeat.o(111982);
      return;
      this.lox = 1;
      continue;
      this.lox = 2;
      continue;
      this.lox = 3;
      continue;
      this.lox = 4;
    }
  }
  
  protected final void cWa()
  {
    AppMethodBeat.i(111994);
    super.cWa();
    cWm();
    this.tLc.setVisibility(8);
    if ((this.tKQ != null) && (!this.tKQ.tOp)) {
      this.tKQ.cWC();
    }
    AppMethodBeat.o(111994);
  }
  
  protected final void cWb()
  {
    AppMethodBeat.i(111993);
    super.cWb();
    cWm();
    this.tLc.setVisibility(8);
    this.tJL.setVisibility(0);
    if ((this.tKQ != null) && (!this.tKQ.tOp)) {
      this.tKQ.cWC();
    }
    AppMethodBeat.o(111993);
  }
  
  protected final void cWc()
  {
    AppMethodBeat.i(111992);
    super.cWc();
    cWm();
    this.tLc.setVisibility(8);
    if ((this.tKQ != null) && (!this.tKQ.tOp)) {
      this.tKQ.cWC();
    }
    AppMethodBeat.o(111992);
  }
  
  protected final void cWd()
  {
    AppMethodBeat.i(111991);
    super.cWd();
    cWl();
    this.tLc.setVisibility(8);
    if ((this.tKR) && (this.tKQ != null)) {
      this.tKQ.show();
    }
    AppMethodBeat.o(111991);
  }
  
  protected final void cWg()
  {
    AppMethodBeat.i(112004);
    super.cWg();
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.tKU;
    if (!locald.tPt)
    {
      locald.tPt = true;
      if (locald.tPs == d.b.tPG)
      {
        ae.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
        l.O(locald.tKg, 10);
        locald.cjk();
      }
    }
    AppMethodBeat.o(112004);
  }
  
  public final List<View> cWh()
  {
    AppMethodBeat.i(111996);
    ArrayList localArrayList = new ArrayList();
    if (this.tKX == null)
    {
      this.tKX = getLayoutInflater().inflate(2131494218, null, false);
      this.tKY = this.tKX.findViewById(2131304404);
      this.tKY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111974);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
          paramAnonymousView = FTSMainUI.this;
          localObject1 = FTSMainUI.this.query;
          Object localObject2 = paramAnonymousView.tKW.tKD;
          int i = paramAnonymousView.tKW.getCount();
          int j = paramAnonymousView.lox;
          Object localObject3 = new gt();
          ((gt)localObject3).eqE = j;
          boolean bool2;
          if (com.tencent.mm.plugin.fts.a.d.alo((String)localObject1))
          {
            ((gt)localObject3).eqF = 8L;
            ((gt)localObject3).eqG = (i + 1);
            if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tJJ > 0L) && (((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tJJ < System.currentTimeMillis())) {
              ((gt)localObject3).eqP = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNh);
            }
            if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNC.equals(localObject1)) {
              ((gt)localObject3).erf = 1L;
            }
            gt localgt = ((gt)localObject3).pG("").pH("");
            localgt.eqQ = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNl;
            localgt.eqR = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNm;
            localgt.eqS = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNn;
            localgt.eqT = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNo;
            localgt.eqU = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNp;
            localgt.eqV = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).favCount;
            localgt.eqX = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNq;
            localgt.eqY = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNr;
            localgt = localgt.pI(String.valueOf(com.tencent.mm.plugin.fts.a.e.tEn)).pJ((String)localObject1);
            localgt.erc = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).cWp();
            localgt = localgt.pK("").pL("").pM("");
            localgt.ere = 1L;
            localgt.pN("").pO("").pP("").pQ("").pR("").pS("").pT("").pU("").pV("");
            ((gt)localObject3).aLH();
            ae.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((gt)localObject3).RD().replace("\r\n", " ") });
            boolean bool1 = com.tencent.mm.plugin.fts.a.d.alo(paramAnonymousView.query);
            bool2 = com.tencent.mm.plugin.fts.a.d.alp(paramAnonymousView.query);
            if (!bool1) {
              break label555;
            }
          }
          for (i = 8;; i = 9)
          {
            ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).Hv(i);
            localObject3 = paramAnonymousView.tKW;
            ((k)localObject3).tKy = true;
            ((k)localObject3).tKE.Hz(1);
            paramAnonymousView.tKW.tKy = true;
            if (!paramAnonymousView.tKW.tKp)
            {
              paramAnonymousView.tKW.tKp = true;
              l.a((String)localObject1, true, paramAnonymousView.tKW.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject2);
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
              ((gt)localObject3).eqF = 9L;
              break;
            } while (!bool2);
          }
          label566:
          if (Character.isDigit(((String)localObject1).charAt(0))) {}
          for (i = 15;; i = 3)
          {
            paramAnonymousView.tJA = i;
            localObject2 = new FTSMainUI.12(paramAnonymousView, (String)localObject1);
            com.tencent.mm.kernel.g.ajj().a(106, (com.tencent.mm.ak.f)localObject2);
            localObject1 = new com.tencent.mm.plugin.messenger.a.f((String)localObject1, 3);
            com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
            paramAnonymousView.getString(2131755906);
            paramAnonymousView.qka = com.tencent.mm.ui.base.h.b(paramAnonymousView, paramAnonymousView.getString(2131762915), true, new FTSMainUI.13(paramAnonymousView, (com.tencent.mm.plugin.messenger.a.f)localObject1, (com.tencent.mm.ak.f)localObject2));
            break;
          }
        }
      });
      this.tKZ = this.tKX.findViewById(2131304403);
      this.tLa = ((TextView)this.tKX.findViewById(2131304405));
    }
    localArrayList.add(this.tKX);
    if (this.tKU.cMv() != null) {
      localArrayList.add(this.tKU.cMv());
    }
    if (this.tLb == null)
    {
      this.tLb = getLayoutInflater().inflate(2131494206, null, false);
      this.tLc = this.tLb.findViewById(2131301503);
    }
    localArrayList.add(this.tLb);
    AppMethodBeat.o(111996);
    return localArrayList;
  }
  
  protected final void cWi()
  {
    AppMethodBeat.i(111998);
    this.tLc.setVisibility(0);
    AppMethodBeat.o(111998);
  }
  
  protected final void cWj()
  {
    AppMethodBeat.i(111999);
    this.tLc.setVisibility(8);
    AppMethodBeat.o(111999);
  }
  
  public void finish()
  {
    AppMethodBeat.i(111987);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111973);
        ae.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSMainUI.e(FTSMainUI.this);
        AppMethodBeat.o(111973);
      }
    }, i);
    AppMethodBeat.o(111987);
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(111995);
    Object localObject = this.tKU;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON == null)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON = LayoutInflater.from(((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOM).inflate(2131494225, null, false);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).contentView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131300713);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOR = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131304448);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOS = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131305535));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOT = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131305536));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOU = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131305537));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOV = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131304444);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOW = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131304142);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tNb = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131298673);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).fQl = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131297008));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOX = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131298716));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tNc = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131298593));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOY = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131298717));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tOZ = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131299178);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPa = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131299177));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPb = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131299180));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPc = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131299176));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPd = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131299175));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPe = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131299179));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPf = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131306351);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPg = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131306399));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPh = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131306333));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPi = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131306406));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPj = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131306313));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPk = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131302604);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPl = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131302602));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPm = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131302619));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPn = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131302620));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPo = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131302601));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPp = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131302600));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPq = new com.tencent.mm.plugin.fts.ui.widget.e((com.tencent.mm.plugin.fts.ui.widget.d)localObject, (FrameLayout)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON.findViewById(2131306926));
    }
    localObject = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tON;
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
    this.tKV = ((KeyboardLinearLayout)findViewById(2131304239));
    this.tKV.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void Hs(int paramAnonymousInt)
      {
        AppMethodBeat.i(111962);
        if (paramAnonymousInt == -3)
        {
          ae.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
          new aq().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111960);
              FTSMainUI.a(FTSMainUI.this, true);
              if ((bu.isNullOrNil(FTSMainUI.this.tJR.getSearchContent())) && (FTSMainUI.a(FTSMainUI.this) != null)) {
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
          new aq().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111961);
              FTSMainUI.a(FTSMainUI.this, false);
              if (FTSMainUI.a(FTSMainUI.this) != null) {
                FTSMainUI.a(FTSMainUI.this).cWC();
              }
              AppMethodBeat.o(111961);
            }
          }, 0L);
          ae.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
        }
        AppMethodBeat.o(111962);
      }
    });
    this.tJR.setHint(getString(2131755882));
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.fts.a.e.tEn = com.tencent.mm.plugin.fts.a.d.Hj(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.lox), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.tEn), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.tEn), Integer.valueOf(0), "", "" });
    ae.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10991, paramBundle);
    this.tKP = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.tKP.setOnCellClickListener(this.tLe);
    this.tKP.setOnHotwordClickListener(new FTSMainUI.6(this));
    this.tKP.setNeedHotWord(false);
    com.tencent.e.h.MqF.f(new FTSMainUI.8(this), "FTSMainUI.GetLocation");
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(111978);
      return;
    }
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cVe();
    af.WP(3);
    com.tencent.mm.sdk.b.a.IvT.b(this.tLf);
    AppMethodBeat.o(111978);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool3 = true;
    AppMethodBeat.i(111979);
    boolean bool4 = super.onCreateOptionsMenu(paramMenu);
    paramMenu = this.tJR;
    Object localObject = this.tKU;
    if (paramMenu.Lhj != null) {
      paramMenu.Lhj.setFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
    if ((com.tencent.mm.sdk.platformtools.ad.foi()) || (com.tencent.mm.sdk.platformtools.ad.fom().equals("en"))) {}
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
        ae.w("MicroMsg.FTS.FTSMainUI", "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
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
    this.tKQ = new com.tencent.mm.plugin.fts.ui.widget.b(this, paramMenu, (TextView)localObject, localProgressBar);
    this.tKQ.tOo = new com.tencent.mm.plugin.fts.ui.widget.b.a()
    {
      public final void alK(String paramAnonymousString)
      {
        AppMethodBeat.i(111968);
        FTSMainUI.this.tJR.setSearchContent(paramAnonymousString);
        AppMethodBeat.o(111968);
      }
      
      public final void alL(String paramAnonymousString)
      {
        AppMethodBeat.i(111970);
        FTSMainUI.c(FTSMainUI.this).tKD.tNC = paramAnonymousString;
        FTSMainUI.this.tJR.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        AppMethodBeat.o(111970);
      }
      
      public final void b(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString)
      {
        AppMethodBeat.i(111969);
        FTSMainUI.this.tJR.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        if (!paramAnonymousBoolean1)
        {
          if (paramAnonymousBoolean2)
          {
            FTSMainUI.alJ(FTSMainUI.this.getString(2131759722));
            AppMethodBeat.o(111969);
            return;
          }
          FTSMainUI.alJ(FTSMainUI.this.getString(2131759723));
        }
        AppMethodBeat.o(111969);
      }
      
      public final void cWn()
      {
        AppMethodBeat.i(111967);
        FTSMainUI.this.tJR.setCursorVisible(false);
        FTSMainUI.c(FTSMainUI.this).Hr(1);
        FTSMainUI.d(FTSMainUI.this);
        FTSMainUI.this.tJR.setHint(FTSMainUI.this.getContext().getString(2131759720));
        AppMethodBeat.o(111967);
      }
    };
    AppMethodBeat.o(111979);
    return bool4;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111985);
    com.tencent.e.h.MqF.bbc("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.aIh().c(this);
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cVf();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.tLf);
    Object localObject;
    if (this.tKQ != null)
    {
      localObject = this.tKQ;
      if (((com.tencent.mm.plugin.fts.ui.widget.b)localObject).tOq != null)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).tOq.aOx();
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).tOq;
        if (((VoiceInputLayout)localObject).lVY != null) {
          ((VoiceInputLayout)localObject).lVY.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).tQa != null) {
          ((VoiceInputLayout)localObject).tQa.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).iCn != null) {
          ((VoiceInputLayout)localObject).iCn.stopTimer();
        }
      }
    }
    if (this.tKU != null)
    {
      localObject = this.tKU;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPq != null)
      {
        com.tencent.mm.plugin.fts.ui.widget.e locale = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).tPq;
        locale.tPM.removeJavascriptInterface("pardusJSApi");
        locale.tPM.destroy();
      }
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).Hz(3);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cWT();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cVx();
    }
    super.onDestroy();
    AppMethodBeat.o(111985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111986);
    super.onResume();
    runOnUiThread(new FTSMainUI.9(this));
    xq localxq = new xq();
    localxq.dNe.gW = 0L;
    com.tencent.mm.sdk.b.a.IvT.l(localxq);
    if (!bu.isNullOrNil(this.tKS))
    {
      this.query = this.tKS;
      this.tKS = null;
    }
    com.tencent.mm.plugin.websearch.api.ad.ePN();
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
    this.tLg = 1;
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.tKU;
    locald.cWT();
    locald.cVx();
    locald.clearData();
    locald.cWU();
    AppMethodBeat.o(112003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */