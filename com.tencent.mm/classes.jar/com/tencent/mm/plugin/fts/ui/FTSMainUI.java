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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aas;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.b.a.kh;
import com.tencent.mm.g.b.a.nt;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.fts.ui.widget.i.b;
import com.tencent.mm.plugin.fts.ui.widget.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@com.tencent.mm.ui.base.a(3)
public class FTSMainUI
  extends FTSBaseVoiceSearchUI
  implements com.tencent.mm.modelgeo.b.a
{
  public int mve;
  Dialog rAV;
  int xaz;
  private FTSMainUIEducationLayout xbP;
  private com.tencent.mm.plugin.fts.ui.widget.b xbQ;
  private boolean xbR;
  private String xbS;
  private volatile boolean xbT;
  private com.tencent.mm.plugin.fts.ui.widget.h xbU;
  com.tencent.mm.plugin.fts.ui.widget.i xbV;
  private KeyboardLinearLayout xbW;
  public k xbX;
  private View xbY;
  View xbZ;
  private View xca;
  private TextView xcb;
  private View xcc;
  private View xcd;
  private com.tencent.mm.plugin.websearch.api.k xce;
  private View.OnClickListener xcf;
  private IListener<aas> xcg;
  int xch;
  
  public FTSMainUI()
  {
    AppMethodBeat.i(111977);
    this.xbR = false;
    this.xaz = -1;
    this.xce = new com.tencent.mm.plugin.websearch.api.k() {};
    this.xcf = new FTSMainUI.4(this);
    this.xcg = new IListener() {};
    this.xch = 1;
    AppMethodBeat.o(111977);
  }
  
  private void dPw()
  {
    AppMethodBeat.i(111989);
    this.xbP.setVisibility(0);
    this.xbP.updateView();
    AppMethodBeat.o(111989);
  }
  
  private void dPx()
  {
    AppMethodBeat.i(111990);
    this.xbP.setVisibility(8);
    AppMethodBeat.o(111990);
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(111997);
    super.SN(paramString);
    if ((this.xbT) && (!TextUtils.isEmpty(this.query)))
    {
      Object localObject = this.xbX;
      paramString = new ArrayList();
      localObject = ((k)localObject).xbB.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject).next()).dOH());
      }
      if ((paramString.size() != 0) || (!TextUtils.isEmpty(this.xcb.getText())) || (this.xbV.dDz)) {
        break label362;
      }
      this.xbV.dY(this.query, 17);
      paramString = new nt();
      paramString.fiw = 1L;
      paramString.ejW = 1L;
      paramString.AT(this.query).bfK();
      int i = this.mve;
      paramString = this.xbX.xbD;
      localObject = new kh();
      ((kh)localObject).eUg = i;
      ((kh)localObject).eUh = 29L;
      ((kh)localObject).eUj = 1L;
      ((kh)localObject).eUD = paramString.dPA();
      kh localkh = ((kh)localObject).xo("").xp("").xr(paramString.query).xq("").xs("").xt("").xu("").xv("").xw("").xx("").xy("").xz("").xA("").xB("").xC("");
      localkh.eUV = com.tencent.mm.plugin.fts.a.e.wVm;
      localkh.eUW = paramString.xej;
      localkh.xD("");
      ((kh)localObject).bfK();
      Log.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((kh)localObject).abW().replace("\r\n", " ") });
      this.xbV.Nz(8);
    }
    for (;;)
    {
      AppMethodBeat.o(111997);
      return false;
      label362:
      paramString = new nt();
      paramString.fiw = 1L;
      paramString.ejW = 2L;
      paramString.AT(this.query).bfK();
    }
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(112001);
    if ((this.xbQ == null) || (!this.xbQ.xfo)) {
      super.SO(paramString);
    }
    this.xbT = false;
    AppMethodBeat.o(112001);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111983);
    this.xbX = new k(parame, this.mve, this.xbV);
    this.xbX.Nr(2);
    parame = this.xbX;
    AppMethodBeat.o(111983);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111984);
    if (paramBoolean) {
      this.xbV.Nz(1);
    }
    AppMethodBeat.o(111984);
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(111988);
    Log.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.bca().c(this);
    AppMethodBeat.o(111988);
    return false;
  }
  
  public final void ay(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(112000);
    super.ay(paramInt, paramBoolean);
    if ((!paramBoolean) && (paramInt == 0) && (this.xbX.xbM)) {
      this.xcd.setVisibility(0);
    }
    while (!paramBoolean)
    {
      this.xbZ.setVisibility(8);
      this.xbV.f(paramInt, paramBoolean, false);
      AppMethodBeat.o(112000);
      return;
      this.xcd.setVisibility(8);
    }
    this.xbT = true;
    boolean bool2 = com.tencent.mm.plugin.fts.a.d.ays(this.query);
    boolean bool3 = com.tencent.mm.plugin.fts.a.d.ayt(this.query);
    Object localObject = this.xbV;
    boolean bool1;
    if ((bool2) || (bool3))
    {
      bool1 = true;
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).f(paramInt, paramBoolean, bool1);
      if (paramInt <= 0) {
        break label316;
      }
      if ((bool2) || (bool3)) {
        this.xca.setVisibility(0);
      }
      label158:
      if ((bool2) || (bool3))
      {
        this.xbZ.setVisibility(0);
        localObject = this.xbX.xbD;
        if (!bool2) {
          break label328;
        }
        paramInt = 1;
        label192:
        if (!bool3) {
          break label333;
        }
        label197:
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).xew = paramInt;
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).xex = i;
        if (!bool2) {
          break label338;
        }
        paramInt = 8;
      }
    }
    for (;;)
    {
      localObject = this.xbX.xbD;
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject).xeA + 1);
      localc.dUb = "SearchContactBar";
      localc.wVZ = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject).xaI);
      localc.dUm = paramInt;
      if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject).xeG.contains(localc)) {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).xeG.add(localc);
      }
      AppMethodBeat.o(112000);
      return;
      bool1 = false;
      break;
      label316:
      this.xca.setVisibility(8);
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
  
  protected final void dPc()
  {
    AppMethodBeat.i(112002);
    super.dPc();
    this.xca.setVisibility(8);
    this.xbZ.setVisibility(8);
    this.xch = 1;
    Object localObject1 = this.xbV;
    Object localObject2 = this.query;
    long l = com.tencent.mm.plugin.fts.a.e.wVn;
    if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xgD == i.b.xgR)
    {
      l.N(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xbf, 11);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).dOG();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).dQd();
      int i = ai.aft(5);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i) });
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).a(i.b.xgR);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).query = ((String)localObject2);
      Object localObject3 = new cze();
      ((cze)localObject3).KXA = ((String)localObject2);
      ((cze)localObject3).Mba = String.valueOf(l);
      ((cze)localObject3).SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm);
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
      com.tencent.mm.plugin.expt.b.b.a locala = com.tencent.mm.plugin.expt.b.b.a.sgV;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
      ((cze)localObject3).MEs = localb.a(locala, com.tencent.mm.util.c.hdd());
      ((cze)localObject3).MaY = i;
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xbf = l;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sgW, 500);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xgC = new u((cze)localObject3);
      com.tencent.mm.kernel.g.azz().a(1076, (com.tencent.mm.ak.i)localObject1);
      com.tencent.mm.kernel.g.azz().a(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xgC, 0);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xaI = System.currentTimeMillis();
      localObject3 = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xeO.obtainMessage(1, Long.valueOf(l));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xeO.sendMessageDelayed((Message)localObject3, i);
      localObject2 = com.tencent.mm.plugin.fts.a.f.a(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.getString(2131761035), "", com.tencent.mm.plugin.fts.a.a.e.c((CharSequence)localObject2, (String)localObject2)).wWu;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.l.e(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.getContext(), (CharSequence)localObject2, com.tencent.mm.cb.a.aG(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.getContext(), 2131165535));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xbb.setText((CharSequence)localObject2);
      l.N(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xbf, 1);
      localObject1 = this.xbU;
      localObject2 = this.query;
      localObject3 = String.valueOf(com.tencent.mm.plugin.fts.a.e.wVn);
      p.h(localObject2, "query");
      p.h(localObject3, "searchId");
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).reset();
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).xfQ = ((String)localObject2);
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).xfT = ((String)localObject3);
      localObject3 = new cge();
      ((cge)localObject3).Mba = ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).xfT;
      ((cge)localObject3).KXA = ((String)localObject2);
      ((cge)localObject3).MaY = ai.aft(0);
      ((cge)localObject3).Scene = 74;
      ((cge)localObject3).SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm);
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).xfS = new com.tencent.mm.plugin.fts.ui.c.c((cge)localObject3);
      com.tencent.mm.kernel.g.azz().a((q)((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).xfS, 0);
      localObject1 = null;
      if (!com.tencent.mm.plugin.fts.a.d.ays(this.query)) {
        break label634;
      }
      localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131760998), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).wWu;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.e(getContext(), (CharSequence)localObject1, com.tencent.mm.cb.a.aG(getContext(), 2131165535));
      this.xcb.setText((CharSequence)localObject1);
      AppMethodBeat.o(112002);
      return;
      if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xgD != i.b.xgT) {
        break;
      }
      l.N(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xbf, 8);
      break;
      label634:
      if (com.tencent.mm.plugin.fts.a.d.ayt(this.query)) {
        localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(2131760999), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).wWu;
      }
    }
  }
  
  protected final void dPh()
  {
    AppMethodBeat.i(111982);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.mve = 0;
    }
    for (;;)
    {
      this.xbV = new com.tencent.mm.plugin.fts.ui.widget.i(this);
      this.xbU = new com.tencent.mm.plugin.fts.ui.widget.h(this);
      AppMethodBeat.o(111982);
      return;
      this.mve = 1;
      continue;
      this.mve = 2;
      continue;
      this.mve = 3;
      continue;
      this.mve = 4;
    }
  }
  
  protected final void dPj()
  {
    AppMethodBeat.i(111994);
    super.dPj();
    dPx();
    this.xcd.setVisibility(8);
    if ((this.xbQ != null) && (!this.xbQ.xfo)) {
      this.xbQ.dPM();
    }
    AppMethodBeat.o(111994);
  }
  
  protected final void dPk()
  {
    AppMethodBeat.i(111993);
    super.dPk();
    dPx();
    this.xcd.setVisibility(8);
    this.xaK.setVisibility(0);
    if ((this.xbQ != null) && (!this.xbQ.xfo)) {
      this.xbQ.dPM();
    }
    AppMethodBeat.o(111993);
  }
  
  protected final void dPl()
  {
    AppMethodBeat.i(111992);
    super.dPl();
    dPx();
    this.xcd.setVisibility(8);
    if ((this.xbQ != null) && (!this.xbQ.xfo)) {
      this.xbQ.dPM();
    }
    AppMethodBeat.o(111992);
  }
  
  protected final void dPm()
  {
    AppMethodBeat.i(111991);
    super.dPm();
    dPw();
    this.xcd.setVisibility(8);
    if ((this.xbR) && (this.xbQ != null)) {
      this.xbQ.show();
    }
    AppMethodBeat.o(111991);
  }
  
  protected final void dPp()
  {
    AppMethodBeat.i(112004);
    super.dPp();
    com.tencent.mm.plugin.fts.ui.widget.i locali = this.xbV;
    if (!locali.xgE)
    {
      locali.xgE = true;
      if (locali.xgD == i.b.xgR)
      {
        Log.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
        l.N(locali.xbf, 10);
        locali.cHi();
      }
    }
    AppMethodBeat.o(112004);
  }
  
  public final List<View> dPq()
  {
    AppMethodBeat.i(111996);
    ArrayList localArrayList = new ArrayList();
    if (this.xbY == null)
    {
      this.xbY = getLayoutInflater().inflate(2131494773, null, false);
      this.xbZ = this.xbY.findViewById(2131307369);
      this.xbZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111974);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          paramAnonymousView = FTSMainUI.this;
          localObject1 = FTSMainUI.this.query;
          Object localObject2 = paramAnonymousView.xbX.xbD;
          int i = paramAnonymousView.xbX.getCount();
          int j = paramAnonymousView.mve;
          Object localObject3 = new kh();
          ((kh)localObject3).eUg = j;
          boolean bool2;
          if (com.tencent.mm.plugin.fts.a.d.ays((String)localObject1))
          {
            ((kh)localObject3).eUh = 8L;
            ((kh)localObject3).eUi = (i + 1);
            if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xaI > 0L) && (((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xaI < System.currentTimeMillis())) {
              ((kh)localObject3).ePF = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xeh);
            }
            if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xeC.equals(localObject1)) {
              ((kh)localObject3).eUG = 1L;
            }
            kh localkh = ((kh)localObject3).xo("").xp("");
            localkh.eUr = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xel;
            localkh.eUs = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xem;
            localkh.eUt = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xen;
            localkh.eUu = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xeo;
            localkh.eUv = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xep;
            localkh.eUw = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).favCount;
            localkh.eUy = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xeq;
            localkh.eUz = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xer;
            localkh = localkh.xq(String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm)).xr((String)localObject1);
            localkh.eUD = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).dPA();
            localkh = localkh.xs("").xt("").xu("");
            localkh.eUF = 1L;
            localkh.xv("").xw("").xx("").xy("").xz("").xA("").xB("").xC("").xD("");
            ((kh)localObject3).bfK();
            Log.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((kh)localObject3).abW().replace("\r\n", " ") });
            boolean bool1 = com.tencent.mm.plugin.fts.a.d.ays(paramAnonymousView.query);
            bool2 = com.tencent.mm.plugin.fts.a.d.ayt(paramAnonymousView.query);
            if (!bool1) {
              break label555;
            }
          }
          for (i = 8;; i = 9)
          {
            ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).Nv(i);
            localObject3 = paramAnonymousView.xbX;
            ((k)localObject3).xby = true;
            ((k)localObject3).xbE.Nz(1);
            paramAnonymousView.xbX.xby = true;
            if (!paramAnonymousView.xbX.xbo)
            {
              paramAnonymousView.xbX.xbo = true;
              l.a((String)localObject1, true, paramAnonymousView.xbX.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject2);
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
              ((kh)localObject3).eUh = 9L;
              break;
            } while (!bool2);
          }
          label566:
          if (Character.isDigit(((String)localObject1).charAt(0))) {}
          for (i = 15;; i = 3)
          {
            paramAnonymousView.xaz = i;
            localObject2 = new FTSMainUI.12(paramAnonymousView, (String)localObject1);
            com.tencent.mm.kernel.g.azz().a(106, (com.tencent.mm.ak.i)localObject2);
            localObject1 = new com.tencent.mm.plugin.messenger.a.f((String)localObject1, 3);
            com.tencent.mm.kernel.g.azz().a((q)localObject1, 0);
            paramAnonymousView.getString(2131755998);
            paramAnonymousView.rAV = com.tencent.mm.ui.base.h.a(paramAnonymousView, paramAnonymousView.getString(2131765051), true, new FTSMainUI.13(paramAnonymousView, (com.tencent.mm.plugin.messenger.a.f)localObject1, (com.tencent.mm.ak.i)localObject2));
            break;
          }
        }
      });
      this.xca = this.xbY.findViewById(2131307368);
      this.xcb = ((TextView)this.xbY.findViewById(2131307370));
    }
    localArrayList.add(this.xbY);
    if (this.xbV.dzK() != null) {
      localArrayList.add(this.xbV.dzK());
    }
    if (this.xcc == null)
    {
      this.xcc = getLayoutInflater().inflate(2131494761, null, false);
      this.xcd = this.xcc.findViewById(2131303706);
    }
    localArrayList.add(this.xcc);
    AppMethodBeat.o(111996);
    return localArrayList;
  }
  
  protected final void dPr()
  {
    AppMethodBeat.i(111998);
    this.xcd.setVisibility(0);
    AppMethodBeat.o(111998);
  }
  
  protected final void dPs()
  {
    AppMethodBeat.i(111999);
    this.xcd.setVisibility(8);
    AppMethodBeat.o(111999);
  }
  
  public final k dPv()
  {
    return this.xbX;
  }
  
  public void finish()
  {
    AppMethodBeat.i(111987);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111973);
        Log.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSMainUI.f(FTSMainUI.this);
        AppMethodBeat.o(111973);
      }
    }, i);
    AppMethodBeat.o(111987);
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(111995);
    Object localObject = this.xbV;
    if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY == null)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY = LayoutInflater.from(((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfV).inflate(2131494781, null, false);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).contentView = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131302286);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgc = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131307424);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgd = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131308755));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xge = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131308756));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgf = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131308757));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgg = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131307420);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgh = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131307038);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xeb = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299110);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).gvv = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131297134));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgi = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299154));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xec = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299030));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgj = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299155));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgk = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299723);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgl = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299722));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgm = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299725));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgn = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299721));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgo = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299720));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgp = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131299724));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgq = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131309777);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgr = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131309830));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgs = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131309756));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgt = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131309837));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgu = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131309728));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgv = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131305096);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgw = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131305093));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgx = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131305114));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgy = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131305116));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgz = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131305090));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgA = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131305085));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgB = new j((com.tencent.mm.plugin.fts.ui.widget.i)localObject, (FrameLayout)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY.findViewById(2131310399));
    }
    localObject = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xfY;
    AppMethodBeat.o(111995);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return 2131494764;
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
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296366), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.xbW = ((KeyboardLinearLayout)findViewById(2131307157));
    this.xbW.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void Ns(int paramAnonymousInt)
      {
        AppMethodBeat.i(111962);
        if (paramAnonymousInt == -3)
        {
          Log.i("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111960);
              FTSMainUI.a(FTSMainUI.this, true);
              if ((Util.isNullOrNil(FTSMainUI.this.xaQ.getSearchContent())) && (FTSMainUI.a(FTSMainUI.this) != null)) {
                FTSMainUI.a(FTSMainUI.this).show();
              }
              com.tencent.mm.plugin.fts.ui.widget.h localh = FTSMainUI.b(FTSMainUI.this);
              localh.xfU = true;
              Object localObject = localh.xfR;
              if (localObject != null)
              {
                localObject = ((cgf)localObject).MlS;
                if ((localObject != null) && (((efl)localObject).KKx != null))
                {
                  localh.ufR.setVisibility(0);
                  AppMethodBeat.o(111960);
                  return;
                }
              }
              AppMethodBeat.o(111960);
            }
          }, 0L);
          AppMethodBeat.o(111962);
          return;
        }
        if (paramAnonymousInt == -2)
        {
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111961);
              FTSMainUI.a(FTSMainUI.this, false);
              if (FTSMainUI.a(FTSMainUI.this) != null) {
                FTSMainUI.a(FTSMainUI.this).dPM();
              }
              com.tencent.mm.plugin.fts.ui.widget.h localh = FTSMainUI.b(FTSMainUI.this);
              localh.xfU = false;
              localh.ufR.setVisibility(8);
              AppMethodBeat.o(111961);
            }
          }, 0L);
          Log.i("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
        }
        AppMethodBeat.o(111962);
      }
    });
    this.xaQ.setHint(getString(2131755972));
    setActionbarColor(getContext().getResources().getColor(2131100898));
    hideActionbarLine();
    com.tencent.mm.plugin.fts.a.e.wVm = com.tencent.mm.plugin.fts.a.d.Ni(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.mve), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.wVm), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.wVm), Integer.valueOf(0), "", "" });
    Log.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(10991, paramBundle);
    this.xbP = ((FTSMainUIEducationLayout)findViewById(2131307382));
    this.xbP.setOnCellClickListener(this.xcf);
    this.xbP.setOnHotwordClickListener(new FTSMainUI.6(this));
    this.xbP.setNeedHotWord(false);
    com.tencent.f.h.RTc.b(new FTSMainUI.8(this), "FTSMainUI.GetLocation");
    if (((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(111978);
      return;
    }
    ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader().dOn();
    ak.bq(3, false);
    EventCenter.instance.add(this.xcg);
    AppMethodBeat.o(111978);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool3 = true;
    AppMethodBeat.i(111979);
    boolean bool4 = super.onCreateOptionsMenu(paramMenu);
    paramMenu = this.xaQ;
    Object localObject = this.xbV;
    if (paramMenu.Qwh != null) {
      paramMenu.Qwh.setFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
    if ((LocaleUtil.isChineseAppLang()) || (LocaleUtil.getApplicationLanguage().equals("en"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(111979);
      return bool4;
    }
    paramMenu = (FTSVoiceInputLayoutImpl)findViewById(2131301811);
    localObject = (TextView)findViewById(2131310011);
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131310009);
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
        Log.w("MicroMsg.FTS.FTSMainUI", "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
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
    this.xbQ = new com.tencent.mm.plugin.fts.ui.widget.b(this, paramMenu, (TextView)localObject, localProgressBar);
    this.xbQ.xfn = new com.tencent.mm.plugin.fts.ui.widget.b.a()
    {
      public final void ayO(String paramAnonymousString)
      {
        AppMethodBeat.i(111968);
        FTSMainUI.this.xaQ.setSearchContent(paramAnonymousString);
        AppMethodBeat.o(111968);
      }
      
      public final void ayP(String paramAnonymousString)
      {
        AppMethodBeat.i(111970);
        FTSMainUI.d(FTSMainUI.this).xbD.xeC = paramAnonymousString;
        FTSMainUI.this.xaQ.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        AppMethodBeat.o(111970);
      }
      
      public final void c(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString)
      {
        AppMethodBeat.i(111969);
        FTSMainUI.this.xaQ.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        if (!paramAnonymousBoolean1)
        {
          if (paramAnonymousBoolean2)
          {
            FTSMainUI.ayN(FTSMainUI.this.getString(2131761043));
            AppMethodBeat.o(111969);
            return;
          }
          FTSMainUI.ayN(FTSMainUI.this.getString(2131761044));
        }
        AppMethodBeat.o(111969);
      }
      
      public final void dPy()
      {
        AppMethodBeat.i(111967);
        FTSMainUI.this.xaQ.setCursorVisible(false);
        FTSMainUI.d(FTSMainUI.this).Nr(1);
        FTSMainUI.e(FTSMainUI.this);
        FTSMainUI.this.xaQ.setHint(FTSMainUI.this.getContext().getString(2131761041));
        AppMethodBeat.o(111967);
      }
    };
    AppMethodBeat.o(111979);
    return bool4;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111985);
    com.tencent.f.h.RTc.bqo("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.bca().c(this);
    if (((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader() != null) {
      ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader().dOo();
    }
    EventCenter.instance.removeListener(this.xcg);
    Object localObject;
    if (this.xbQ != null)
    {
      localObject = this.xbQ;
      if (((com.tencent.mm.plugin.fts.ui.widget.b)localObject).xfp != null)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).xfp.biE();
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).xfp;
        if (((VoiceInputLayout)localObject).ndA != null) {
          ((VoiceInputLayout)localObject).ndA.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).xhn != null) {
          ((VoiceInputLayout)localObject).xhn.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).jxC != null) {
          ((VoiceInputLayout)localObject).jxC.stopTimer();
        }
      }
    }
    if (this.xbV != null)
    {
      localObject = this.xbV;
      if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgB != null)
      {
        j localj = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).xgB;
        localj.xha.destroy();
        com.tencent.mm.kernel.g.azz().b(2975, localj);
        localj.xgX.removeJavascriptInterface("pardusJSApi");
        localj.xgX.destroy();
      }
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).Nz(3);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).dQc();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).dOG();
    }
    if (this.xbU != null)
    {
      localObject = this.xbU;
      com.tencent.mm.kernel.g.azz().b(4591, (com.tencent.mm.ak.i)localObject);
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
    yr localyr = new yr();
    localyr.eeW.gY = 0L;
    EventCenter.instance.publish(localyr);
    if (!Util.isNullOrNil(this.xbS))
    {
      this.query = this.xbS;
      this.xbS = null;
    }
    ai.fXY();
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
    this.xch = 1;
    com.tencent.mm.plugin.fts.ui.widget.i locali = this.xbV;
    locali.dQc();
    locali.dOG();
    locali.clearData();
    locali.dQd();
    this.xbU.reset();
    AppMethodBeat.o(112003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */