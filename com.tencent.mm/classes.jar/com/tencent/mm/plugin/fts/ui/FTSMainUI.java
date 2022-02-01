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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.g.b.a.io;
import com.tencent.mm.plugin.fts.ui.webview.PardusWebView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.fts.ui.widget.d.b;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class FTSMainUI
  extends FTSBaseVoiceSearchUI
  implements com.tencent.mm.modelgeo.b.a
{
  public int kNw;
  Dialog pzQ;
  int sCi;
  int sDA;
  private FTSMainUIEducationLayout sDj;
  private com.tencent.mm.plugin.fts.ui.widget.b sDk;
  private boolean sDl;
  private String sDm;
  private volatile boolean sDn;
  com.tencent.mm.plugin.fts.ui.widget.d sDo;
  private KeyboardLinearLayout sDp;
  public j sDq;
  private View sDr;
  View sDs;
  private View sDt;
  private TextView sDu;
  private View sDv;
  private View sDw;
  private com.tencent.mm.plugin.websearch.api.j sDx;
  private View.OnClickListener sDy;
  private com.tencent.mm.sdk.b.c<yl> sDz;
  
  public FTSMainUI()
  {
    AppMethodBeat.i(111977);
    this.sDl = false;
    this.sCi = -1;
    this.sDx = new com.tencent.mm.plugin.websearch.api.j() {};
    this.sDy = new FTSMainUI.4(this);
    this.sDz = new FTSMainUI.5(this);
    this.sDA = 1;
    AppMethodBeat.o(111977);
  }
  
  private void cLn()
  {
    AppMethodBeat.i(111989);
    this.sDj.setVisibility(0);
    this.sDj.cL();
    AppMethodBeat.o(111989);
  }
  
  private void cLo()
  {
    AppMethodBeat.i(111990);
    this.sDj.setVisibility(8);
    AppMethodBeat.o(111990);
  }
  
  public final boolean Ga(String paramString)
  {
    AppMethodBeat.i(111997);
    super.Ga(paramString);
    if ((this.sDn) && (!TextUtils.isEmpty(this.query)))
    {
      Object localObject = this.sDq;
      paramString = new ArrayList();
      localObject = ((j)localObject).sCV.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject).next()).cKE());
      }
      if ((paramString.size() != 0) || (!TextUtils.isEmpty(this.sDu.getText())) || (this.sDo.cZP)) {
        break label362;
      }
      this.sDo.dp(this.query, 17);
      paramString = new io();
      paramString.elm = 1L;
      paramString.dCS = 1L;
      paramString.pH(this.query).aHZ();
      int i = this.kNw;
      paramString = this.sDq.sCX;
      localObject = new fq();
      ((fq)localObject).dYy = i;
      ((fq)localObject).dYz = 29L;
      ((fq)localObject).dYB = 1L;
      ((fq)localObject).dYW = paramString.cLr();
      fq localfq = ((fq)localObject).mU("").mV("").mX(paramString.query).mW("").mY("").mZ("").na("").nb("").nc("").nd("").ne("").nf("").ng("").nh("").ni("");
      localfq.dZo = com.tencent.mm.plugin.fts.a.e.swV;
      localfq.dZp = paramString.sFy;
      localfq.nj("");
      ((fq)localObject).aHZ();
      ac.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((fq)localObject).PS().replace("\r\n", " ") });
      this.sDo.FN(8);
    }
    for (;;)
    {
      AppMethodBeat.o(111997);
      return false;
      label362:
      paramString = new io();
      paramString.elm = 1L;
      paramString.dCS = 2L;
      paramString.pH(this.query).aHZ();
    }
  }
  
  public final void Gb(String paramString)
  {
    AppMethodBeat.i(112001);
    if ((this.sDk == null) || (!this.sDk.sGF)) {
      super.Gb(paramString);
    }
    this.sDn = false;
    AppMethodBeat.o(112001);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111983);
    this.sDq = new j(parame, this.kNw, this.sDo);
    this.sDq.FF(2);
    parame = this.sDq;
    AppMethodBeat.o(111983);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111984);
    if (paramBoolean) {
      this.sDo.FN(1);
    }
    AppMethodBeat.o(111984);
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(111988);
    ac.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.aEL().c(this);
    AppMethodBeat.o(111988);
    return false;
  }
  
  public final void ai(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(112000);
    super.ai(paramInt, paramBoolean);
    if ((!paramBoolean) && (paramInt == 0) && (this.sDq.sDg)) {
      this.sDw.setVisibility(0);
    }
    while (!paramBoolean)
    {
      this.sDs.setVisibility(8);
      this.sDo.d(paramInt, paramBoolean, false);
      AppMethodBeat.o(112000);
      return;
      this.sDw.setVisibility(8);
    }
    this.sDn = true;
    boolean bool2 = com.tencent.mm.plugin.fts.a.d.afS(this.query);
    boolean bool3 = com.tencent.mm.plugin.fts.a.d.afT(this.query);
    Object localObject = this.sDo;
    boolean bool1;
    if ((bool2) || (bool3))
    {
      bool1 = true;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).d(paramInt, paramBoolean, bool1);
      if (paramInt <= 0) {
        break label316;
      }
      if ((bool2) || (bool3)) {
        this.sDt.setVisibility(0);
      }
      label158:
      if ((bool2) || (bool3))
      {
        this.sDs.setVisibility(0);
        localObject = this.sDq.sCX;
        if (!bool2) {
          break label328;
        }
        paramInt = 1;
        label192:
        if (!bool3) {
          break label333;
        }
        label197:
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).sFL = paramInt;
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).sFM = i;
        if (!bool2) {
          break label338;
        }
        paramInt = 8;
      }
    }
    for (;;)
    {
      localObject = this.sDq.sCX;
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject).sFP + 1);
      localc.dpt = "SearchContactBar";
      localc.sxI = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject).sCr);
      localc.dpE = paramInt;
      if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject).sFV.contains(localc)) {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).sFV.add(localc);
      }
      AppMethodBeat.o(112000);
      return;
      bool1 = false;
      break;
      label316:
      this.sDt.setVisibility(8);
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
  
  protected final void cKZ()
  {
    AppMethodBeat.i(112002);
    super.cKZ();
    this.sDt.setVisibility(8);
    this.sDs.setVisibility(8);
    this.sDA = 1;
    Object localObject1 = this.sDo;
    Object localObject2 = this.query;
    long l = com.tencent.mm.plugin.fts.a.e.swW;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHJ == d.b.sIe)
    {
      k.K(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sGa, 11);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cKD();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cLW();
      int i = z.Ul(5);
      ac.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i) });
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).a(d.b.sIe);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).query = ((String)localObject2);
      Object localObject3 = new cdf();
      ((cdf)localObject3).Eel = ((String)localObject2);
      ((cdf)localObject3).FrP = String.valueOf(l);
      ((cdf)localObject3).DSu = String.valueOf(com.tencent.mm.plugin.fts.a.e.swV);
      ((cdf)localObject3).FrQ = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pYo, com.tencent.mm.util.c.fwV());
      ((cdf)localObject3).FhS = i;
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sGa = l;
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pYp, 500);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHI = new o((cdf)localObject3);
      com.tencent.mm.kernel.g.agi().a(1076, (com.tencent.mm.ak.g)localObject1);
      com.tencent.mm.kernel.g.agi().a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHI, 0);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sCr = System.currentTimeMillis();
      localObject3 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sGd.obtainMessage(1, Long.valueOf(l));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sGd.sendMessageDelayed((Message)localObject3, i);
      localObject2 = com.tencent.mm.plugin.fts.a.f.a(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.getString(2131759714), "", com.tencent.mm.plugin.fts.a.a.e.c((CharSequence)localObject2, (String)localObject2)).syd;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.getContext(), (CharSequence)localObject2, com.tencent.mm.cc.a.au(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.getContext(), 2131165517));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHY.setText((CharSequence)localObject2);
      k.K(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sGa, 1);
      localObject1 = null;
      if (!com.tencent.mm.plugin.fts.a.d.afS(this.query)) {
        break label483;
      }
      localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759677), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).syd;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)localObject1, com.tencent.mm.cc.a.au(getContext(), 2131165517));
      this.sDu.setText((CharSequence)localObject1);
      AppMethodBeat.o(112002);
      return;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHJ != d.b.sIg) {
        break;
      }
      k.K(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sGa, 8);
      break;
      label483:
      if (com.tencent.mm.plugin.fts.a.d.afT(this.query)) {
        localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131759678), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).syd;
      }
    }
  }
  
  protected final void cLd()
  {
    AppMethodBeat.i(111982);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.kNw = 0;
    }
    for (;;)
    {
      this.sDo = new com.tencent.mm.plugin.fts.ui.widget.d(this);
      AppMethodBeat.o(111982);
      return;
      this.kNw = 1;
      continue;
      this.kNw = 2;
      continue;
      this.kNw = 3;
      continue;
      this.kNw = 4;
    }
  }
  
  protected final void cLe()
  {
    AppMethodBeat.i(111994);
    super.cLe();
    cLo();
    this.sDw.setVisibility(8);
    if ((this.sDk != null) && (!this.sDk.sGF)) {
      this.sDk.cLE();
    }
    AppMethodBeat.o(111994);
  }
  
  protected final void cLf()
  {
    AppMethodBeat.i(111993);
    super.cLf();
    cLo();
    this.sDw.setVisibility(8);
    this.sCt.setVisibility(0);
    if ((this.sDk != null) && (!this.sDk.sGF)) {
      this.sDk.cLE();
    }
    AppMethodBeat.o(111993);
  }
  
  protected final void cLg()
  {
    AppMethodBeat.i(111992);
    super.cLg();
    cLo();
    this.sDw.setVisibility(8);
    if ((this.sDk != null) && (!this.sDk.sGF)) {
      this.sDk.cLE();
    }
    AppMethodBeat.o(111992);
  }
  
  protected final void cLh()
  {
    AppMethodBeat.i(111991);
    super.cLh();
    cLn();
    this.sDw.setVisibility(8);
    if ((this.sDl) && (this.sDk != null)) {
      this.sDk.show();
    }
    AppMethodBeat.o(111991);
  }
  
  protected final void cLi()
  {
    AppMethodBeat.i(112004);
    super.cLi();
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.sDo;
    if (!locald.sHK)
    {
      locald.sHK = true;
      if (locald.sHJ == d.b.sIe)
      {
        ac.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
        k.K(locald.sGa, 10);
        locald.cdr();
      }
    }
    AppMethodBeat.o(112004);
  }
  
  public final List<View> cLj()
  {
    AppMethodBeat.i(111996);
    ArrayList localArrayList = new ArrayList();
    if (this.sDr == null)
    {
      this.sDr = getLayoutInflater().inflate(2131494218, null, false);
      this.sDs = this.sDr.findViewById(2131304404);
      this.sDs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111974);
          paramAnonymousView = FTSMainUI.this;
          Object localObject1 = FTSMainUI.this.query;
          Object localObject2 = paramAnonymousView.sDq.sCX;
          int i = paramAnonymousView.sDq.getCount();
          int j = paramAnonymousView.kNw;
          Object localObject3 = new fq();
          ((fq)localObject3).dYy = j;
          boolean bool2;
          if (com.tencent.mm.plugin.fts.a.d.afS((String)localObject1))
          {
            ((fq)localObject3).dYz = 8L;
            ((fq)localObject3).dYA = (i + 1);
            if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sCr > 0L) && (((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sCr < System.currentTimeMillis())) {
              ((fq)localObject3).dYJ = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFw);
            }
            if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFR.equals(localObject1)) {
              ((fq)localObject3).dYZ = 1L;
            }
            fq localfq = ((fq)localObject3).mU("").mV("");
            localfq.dYK = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFA;
            localfq.dYL = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFB;
            localfq.dYM = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFC;
            localfq.dYN = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFD;
            localfq.dYO = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFE;
            localfq.dYP = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).favCount;
            localfq.dYR = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFF;
            localfq.dYS = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFG;
            localfq = localfq.mW(String.valueOf(com.tencent.mm.plugin.fts.a.e.swV)).mX((String)localObject1);
            localfq.dYW = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).cLr();
            localfq = localfq.mY("").mZ("").na("");
            localfq.dYY = 1L;
            localfq.nb("").nc("").nd("").ne("").nf("").ng("").nh("").ni("").nj("");
            ((fq)localObject3).aHZ();
            ac.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((fq)localObject3).PS().replace("\r\n", " ") });
            boolean bool1 = com.tencent.mm.plugin.fts.a.d.afS(paramAnonymousView.query);
            bool2 = com.tencent.mm.plugin.fts.a.d.afT(paramAnonymousView.query);
            if (!bool1) {
              break label509;
            }
          }
          for (i = 8;; i = 9)
          {
            ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).FJ(i);
            localObject3 = paramAnonymousView.sDq;
            ((j)localObject3).sCS = true;
            ((j)localObject3).sCY.FN(1);
            paramAnonymousView.sDq.sCS = true;
            if (!paramAnonymousView.sDq.sCJ)
            {
              paramAnonymousView.sDq.sCJ = true;
              k.a((String)localObject1, true, paramAnonymousView.sDq.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject2);
            }
            if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).trim().length() != 0)) {
              break label526;
            }
            AppMethodBeat.o(111974);
            return;
            ((fq)localObject3).dYz = 9L;
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
            paramAnonymousView.sCi = i;
            localObject2 = new FTSMainUI.12(paramAnonymousView, (String)localObject1);
            com.tencent.mm.kernel.g.agi().a(106, (com.tencent.mm.ak.g)localObject2);
            localObject1 = new com.tencent.mm.plugin.messenger.a.g((String)localObject1, 3);
            com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
            paramAnonymousView.getString(2131755906);
            paramAnonymousView.pzQ = com.tencent.mm.ui.base.h.b(paramAnonymousView, paramAnonymousView.getString(2131762915), true, new FTSMainUI.13(paramAnonymousView, (com.tencent.mm.plugin.messenger.a.g)localObject1, (com.tencent.mm.ak.g)localObject2));
            AppMethodBeat.o(111974);
            return;
          }
        }
      });
      this.sDt = this.sDr.findViewById(2131304403);
      this.sDu = ((TextView)this.sDr.findViewById(2131304405));
    }
    localArrayList.add(this.sDr);
    if (this.sDo.cBS() != null) {
      localArrayList.add(this.sDo.cBS());
    }
    if (this.sDv == null)
    {
      this.sDv = getLayoutInflater().inflate(2131494206, null, false);
      this.sDw = this.sDv.findViewById(2131301503);
    }
    localArrayList.add(this.sDv);
    AppMethodBeat.o(111996);
    return localArrayList;
  }
  
  protected final void cLk()
  {
    AppMethodBeat.i(111998);
    this.sDw.setVisibility(0);
    AppMethodBeat.o(111998);
  }
  
  protected final void cLl()
  {
    AppMethodBeat.i(111999);
    this.sDw.setVisibility(8);
    AppMethodBeat.o(111999);
  }
  
  public void finish()
  {
    AppMethodBeat.i(111987);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111973);
        ac.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSMainUI.e(FTSMainUI.this);
        AppMethodBeat.o(111973);
      }
    }, i);
    AppMethodBeat.o(111987);
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(111995);
    Object localObject = this.sDo;
    if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd == null)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd = LayoutInflater.from(((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHc).inflate(2131494225, null, false);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).contentView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131300713);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHh = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131304448);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHi = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131305535));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHj = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131305536));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHk = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131305537));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHl = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131304444);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHm = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131304142);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sFq = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131298673);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).fuY = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131297008));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHn = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131298716));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sFr = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131298593));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHo = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131298717));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHp = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131299178);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHq = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131299177));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHr = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131299180));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHs = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131299176));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHt = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131299175));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHu = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131299179));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHv = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131306351);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHw = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131306399));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHx = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131306333));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHy = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131306406));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHz = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131306313));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHA = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131302604);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHB = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131302602));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHC = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131302619));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHD = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131302620));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHE = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131302601));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHF = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131302600));
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHG = new com.tencent.mm.plugin.fts.ui.widget.e((com.tencent.mm.plugin.fts.ui.widget.d)localObject, (FrameLayout)((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd.findViewById(2131306926));
    }
    localObject = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHd;
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
    this.sDp = ((KeyboardLinearLayout)findViewById(2131304239));
    this.sDp.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void FG(int paramAnonymousInt)
      {
        AppMethodBeat.i(111962);
        if (paramAnonymousInt == -3)
        {
          ac.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
          new ao().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111960);
              FTSMainUI.a(FTSMainUI.this, true);
              if ((bs.isNullOrNil(FTSMainUI.this.sCz.getSearchContent())) && (FTSMainUI.a(FTSMainUI.this) != null)) {
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
          new ao().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111961);
              FTSMainUI.a(FTSMainUI.this, false);
              if (FTSMainUI.a(FTSMainUI.this) != null) {
                FTSMainUI.a(FTSMainUI.this).cLE();
              }
              AppMethodBeat.o(111961);
            }
          }, 0L);
          ac.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
        }
        AppMethodBeat.o(111962);
      }
    });
    this.sCz.setHint(getString(2131755882));
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.fts.a.e.swV = com.tencent.mm.plugin.fts.a.d.Fx(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.kNw), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.swV), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.swV), Integer.valueOf(0), "", "" });
    ac.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(10991, paramBundle);
    this.sDj = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.sDj.setOnCellClickListener(this.sDy);
    this.sDj.setOnHotwordClickListener(new FTSMainUI.6(this));
    this.sDj.setNeedHotWord(false);
    com.tencent.e.h.JZN.f(new FTSMainUI.8(this), "FTSMainUI.GetLocation");
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(111978);
      return;
    }
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cKk();
    com.tencent.mm.plugin.websearch.api.ab.Up(3);
    com.tencent.mm.sdk.b.a.GpY.b(this.sDz);
    AppMethodBeat.o(111978);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool3 = true;
    AppMethodBeat.i(111979);
    boolean bool4 = super.onCreateOptionsMenu(paramMenu);
    paramMenu = this.sCz;
    Object localObject = this.sDo;
    if (paramMenu.ITL != null) {
      paramMenu.ITL.setFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
    if ((com.tencent.mm.sdk.platformtools.ab.eUK()) || (com.tencent.mm.sdk.platformtools.ab.eUO().equals("en"))) {}
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
        ac.w("MicroMsg.FTS.FTSMainUI", "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
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
    this.sDk = new com.tencent.mm.plugin.fts.ui.widget.b(this, paramMenu, (TextView)localObject, localProgressBar);
    this.sDk.sGE = new com.tencent.mm.plugin.fts.ui.widget.b.a()
    {
      public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString)
      {
        AppMethodBeat.i(111969);
        FTSMainUI.this.sCz.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        if (!paramAnonymousBoolean1)
        {
          if (paramAnonymousBoolean2)
          {
            FTSMainUI.agn(FTSMainUI.this.getString(2131759722));
            AppMethodBeat.o(111969);
            return;
          }
          FTSMainUI.agn(FTSMainUI.this.getString(2131759723));
        }
        AppMethodBeat.o(111969);
      }
      
      public final void ago(String paramAnonymousString)
      {
        AppMethodBeat.i(111968);
        FTSMainUI.this.sCz.setSearchContent(paramAnonymousString);
        AppMethodBeat.o(111968);
      }
      
      public final void agp(String paramAnonymousString)
      {
        AppMethodBeat.i(111970);
        FTSMainUI.c(FTSMainUI.this).sCX.sFR = paramAnonymousString;
        FTSMainUI.this.sCz.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        AppMethodBeat.o(111970);
      }
      
      public final void cLp()
      {
        AppMethodBeat.i(111967);
        FTSMainUI.this.sCz.setCursorVisible(false);
        FTSMainUI.c(FTSMainUI.this).FF(1);
        FTSMainUI.d(FTSMainUI.this);
        FTSMainUI.this.sCz.setHint(FTSMainUI.this.getContext().getString(2131759720));
        AppMethodBeat.o(111967);
      }
    };
    AppMethodBeat.o(111979);
    return bool4;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111985);
    com.tencent.e.h.JZN.aTz("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.aEL().c(this);
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cKl();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.sDz);
    Object localObject;
    if (this.sDk != null)
    {
      localObject = this.sDk;
      if (((com.tencent.mm.plugin.fts.ui.widget.b)localObject).sGG != null)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).sGG.aKQ();
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).sGG;
        if (((VoiceInputLayout)localObject).lso != null) {
          ((VoiceInputLayout)localObject).lso.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).sIy != null) {
          ((VoiceInputLayout)localObject).sIy.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).iga != null) {
          ((VoiceInputLayout)localObject).iga.stopTimer();
        }
      }
    }
    if (this.sDo != null)
    {
      localObject = this.sDo;
      if (((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHG != null)
      {
        com.tencent.mm.plugin.fts.ui.widget.e locale = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).sHG;
        locale.sIk.removeJavascriptInterface("pardusJSApi");
        locale.sIk.destroy();
      }
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).FN(3);
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cLV();
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject).cKD();
    }
    super.onDestroy();
    AppMethodBeat.o(111985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111986);
    super.onResume();
    runOnUiThread(new FTSMainUI.9(this));
    wt localwt = new wt();
    localwt.dzD.fe = 0L;
    com.tencent.mm.sdk.b.a.GpY.l(localwt);
    if (!bs.isNullOrNil(this.sDm))
    {
      this.query = this.sDm;
      this.sDm = null;
    }
    z.exn();
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
    this.sDA = 1;
    com.tencent.mm.plugin.fts.ui.widget.d locald = this.sDo;
    locald.cLV();
    locald.cKD();
    locald.clearData();
    locald.cLW();
    AppMethodBeat.o(112003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */