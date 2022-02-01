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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abz;
import com.tencent.mm.f.a.zy;
import com.tencent.mm.f.b.a.mz;
import com.tencent.mm.f.b.a.qu;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.fts.ui.widget.i.3;
import com.tencent.mm.plugin.fts.ui.widget.i.b;
import com.tencent.mm.plugin.fts.ui.widget.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSMainUI
  extends FTSBaseVoiceSearchUI
  implements com.tencent.mm.modelgeo.b.a
{
  int BMy;
  private FTSMainUIEducationLayout BNP;
  private com.tencent.mm.plugin.fts.ui.widget.b BNQ;
  private boolean BNR;
  private String BNS;
  private volatile boolean BNT;
  private com.tencent.mm.plugin.fts.ui.widget.h BNU;
  com.tencent.mm.plugin.fts.ui.widget.i BNV;
  private KeyboardLinearLayout BNW;
  public k BNX;
  private View BNY;
  View BNZ;
  private View BOa;
  private TextView BOb;
  private View BOc;
  private View BOd;
  private com.tencent.mm.plugin.websearch.api.k BOe;
  private View.OnClickListener BOf;
  private IListener<abz> BOg;
  int BOh;
  public int ptD;
  Dialog vgC;
  
  public FTSMainUI()
  {
    AppMethodBeat.i(111977);
    this.BNR = false;
    this.BMy = -1;
    this.BOe = new com.tencent.mm.plugin.websearch.api.k() {};
    this.BOf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool2 = false;
        AppMethodBeat.i(189790);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSMainUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        for (;;)
        {
          try
          {
            if (paramAnonymousView.getTag() == null) {
              break label610;
            }
            i = ((JSONObject)paramAnonymousView.getTag()).optInt("businessType");
            j = i;
          }
          catch (Exception localException1)
          {
            int j = 0;
            continue;
            if (!((String)localObject2).equals(FTSMainUI.this.getString(o.g.search_education_timeline))) {
              continue;
            }
            i = 8;
            continue;
            i = j;
            if (!((String)localObject2).equals(FTSMainUI.this.getString(o.g.search_education_biz_contact))) {
              continue;
            }
            i = 1;
            continue;
            if ((i != 1) || (WeChatBrands.Business.Entries.HomeServiceMp.checkAvailable(paramAnonymousView.getContext()))) {
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189790);
            return;
            if ((i != 512) || (WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext()))) {
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189790);
            return;
            if (((i != 64) && (i != 262208)) || (WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(paramAnonymousView.getContext()))) {
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189790);
            return;
            paramAnonymousView = com.tencent.mm.plugin.fts.ui.b.l.BQo;
            l = i;
            Log.i(com.tencent.mm.plugin.fts.ui.b.l.TAG, "click reddot ".concat(String.valueOf(l)));
            if (!com.tencent.mm.plugin.fts.ui.b.l.NH(l)) {
              continue;
            }
            paramAnonymousView = com.tencent.mm.kernel.h.aHG();
            p.j(paramAnonymousView, "MMKernel.storage()");
            paramAnonymousView.aHp().set(ar.a.VrD, "");
            com.tencent.mm.plugin.fts.ui.b.l.BQm = null;
            paramAnonymousView = String.valueOf(l);
            if (!com.tencent.mm.plugin.fts.ui.b.l.BQk.containsKey(paramAnonymousView)) {
              continue;
            }
            if (ae.e((Map)com.tencent.mm.plugin.fts.ui.b.l.BQk, paramAnonymousView) == null) {
              break label583;
            }
            com.tencent.mm.plugin.fts.ui.b.l.BQl.put(paramAnonymousView, ae.e((Map)com.tencent.mm.plugin.fts.ui.b.l.BQk, paramAnonymousView));
            paramAnonymousView = FTSMainUI.d(FTSMainUI.this);
            ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.i.class)).a(paramAnonymousView.BSg, new i.3(paramAnonymousView, i, localException1, bool1));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189790);
            return;
          }
          boolean bool1 = bool2;
          try
          {
            if (paramAnonymousView.getTag() != null)
            {
              i = ((JSONObject)paramAnonymousView.getTag()).optInt("needHideKeyBoard");
              bool1 = bool2;
              if (i == 1) {
                bool1 = true;
              }
            }
          }
          catch (Exception localException2)
          {
            Object localObject2;
            long l;
            label583:
            bool1 = bool2;
            continue;
            String str = "";
            continue;
          }
          localObject2 = paramAnonymousView.getTag(o.d.red_dot);
          if (((localObject2 instanceof View)) && (((View)localObject2).getVisibility() == 0))
          {
            localObject1 = com.tencent.mm.plugin.fts.ui.b.l.BQo;
            localObject1 = com.tencent.mm.plugin.fts.ui.b.l.erY();
            FTSMainUI.k(FTSMainUI.this).a(String.valueOf(j), new WeakReference((View)localObject2));
            i = j;
            if (j == 0)
            {
              localObject2 = ((TextView)paramAnonymousView.getTag(o.d.tv_content)).getText().toString();
              if (((String)localObject2).equals(FTSMainUI.this.getString(o.g.search_education_article))) {
                i = 2;
              }
            }
            else
            {
              if (i == 0) {
                continue;
              }
              if ((i != 2) || (WeChatBrands.Business.Entries.HomeServiceMp.checkAvailable(paramAnonymousView.getContext()))) {
                continue;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189790);
              return;
            }
            com.tencent.mm.plugin.fts.ui.b.l.BQk.remove(paramAnonymousView);
            continue;
          }
          label610:
          int i = 0;
        }
      }
    };
    this.BOg = new IListener() {};
    this.BOh = 1;
    AppMethodBeat.o(111977);
  }
  
  private void erS()
  {
    AppMethodBeat.i(111989);
    this.BNP.setVisibility(0);
    this.BNP.updateView();
    AppMethodBeat.o(111989);
  }
  
  private void erT()
  {
    AppMethodBeat.i(111990);
    this.BNP.setVisibility(8);
    AppMethodBeat.o(111990);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111983);
    this.BNX = new k(parame, this.ptD, this.BNV);
    this.BNX.SF(2);
    parame = this.BNX;
    AppMethodBeat.o(111983);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111984);
    if (paramBoolean) {
      this.BNV.SN(1);
    }
    AppMethodBeat.o(111984);
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(111988);
    Log.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.blq().b(this);
    AppMethodBeat.o(111988);
    return false;
  }
  
  public final void aC(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(112000);
    super.aC(paramInt, paramBoolean);
    if ((!paramBoolean) && (paramInt == 0) && (this.BNX.BNM)) {
      this.BOd.setVisibility(0);
    }
    while (!paramBoolean)
    {
      this.BNZ.setVisibility(8);
      this.BNV.h(paramInt, paramBoolean, false);
      AppMethodBeat.o(112000);
      return;
      this.BOd.setVisibility(8);
    }
    this.BNT = true;
    boolean bool2 = com.tencent.mm.plugin.fts.a.d.aHM(this.query);
    boolean bool3 = com.tencent.mm.plugin.fts.a.d.aHN(this.query);
    Object localObject = this.BNV;
    boolean bool1;
    if ((bool2) || (bool3))
    {
      bool1 = true;
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).h(paramInt, paramBoolean, bool1);
      if (paramInt <= 0) {
        break label316;
      }
      if ((bool2) || (bool3)) {
        this.BOa.setVisibility(0);
      }
      label158:
      if ((bool2) || (bool3))
      {
        this.BNZ.setVisibility(0);
        localObject = this.BNX.BND;
        if (!bool2) {
          break label328;
        }
        paramInt = 1;
        label192:
        if (!bool3) {
          break label333;
        }
        label197:
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).BQF = paramInt;
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).BQG = i;
        if (!bool2) {
          break label338;
        }
        paramInt = 8;
      }
    }
    for (;;)
    {
      localObject = this.BNX.BND;
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject).BQJ + 1);
      localc.fND = "SearchContactBar";
      localc.BHU = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject).BMI);
      localc.fNO = paramInt;
      if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject).BQP.contains(localc)) {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).BQP.add(localc);
      }
      AppMethodBeat.o(112000);
      return;
      bool1 = false;
      break;
      label316:
      this.BOa.setVisibility(8);
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
  
  public final boolean aat(String paramString)
  {
    AppMethodBeat.i(111997);
    super.aat(paramString);
    if ((this.BNT) && (!TextUtils.isEmpty(this.query)))
    {
      Object localObject = this.BNX;
      paramString = new ArrayList();
      localObject = ((k)localObject).BNB.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject).next()).era());
      }
      if ((paramString.size() != 0) || (!TextUtils.isEmpty(this.BOb.getText())) || (this.BNV.fwi)) {
        break label364;
      }
      this.BNV.ev(this.query, 17);
      paramString = new qu();
      paramString.hlG = 1L;
      paramString.geB = 1L;
      paramString.HM(this.query).bpa();
      int i = this.ptD;
      paramString = this.BNX.BND;
      localObject = new mz();
      ((mz)localObject).gWA = i;
      ((mz)localObject).gWB = 29L;
      ((mz)localObject).gWD = 1L;
      ((mz)localObject).gWX = paramString.erZ();
      mz localmz = ((mz)localObject).DA("").DB("").DD(paramString.query).DC("").DE("").DF("").DG("").DH("").DI("").DJ("").DK("").DL("").DM("").DN("").DO("");
      localmz.gXp = com.tencent.mm.plugin.fts.a.e.BHi;
      localmz.gXq = paramString.BQs;
      localmz.DP("");
      ((mz)localObject).bpa();
      Log.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((mz)localObject).agI().replace("\r\n", " ") });
      this.BNV.SN(8);
    }
    for (;;)
    {
      AppMethodBeat.o(111997);
      return false;
      label364:
      paramString = new qu();
      paramString.hlG = 1L;
      paramString.geB = 2L;
      paramString.HM(this.query).bpa();
    }
  }
  
  public final void aau(String paramString)
  {
    AppMethodBeat.i(112001);
    if ((this.BNQ == null) || (!this.BNQ.BRz)) {
      super.aau(paramString);
    }
    this.BNT = false;
    AppMethodBeat.o(112001);
  }
  
  protected final void erD()
  {
    AppMethodBeat.i(111982);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.ptD = 0;
    }
    for (;;)
    {
      this.BNV = new com.tencent.mm.plugin.fts.ui.widget.i(this);
      this.BNU = new com.tencent.mm.plugin.fts.ui.widget.h(this);
      AppMethodBeat.o(111982);
      return;
      this.ptD = 1;
      continue;
      this.ptD = 2;
      continue;
      this.ptD = 3;
      continue;
      this.ptD = 4;
    }
  }
  
  protected final void erF()
  {
    AppMethodBeat.i(111994);
    super.erF();
    erT();
    this.BOd.setVisibility(8);
    if ((this.BNQ != null) && (!this.BNQ.BRz)) {
      this.BNQ.esl();
    }
    AppMethodBeat.o(111994);
  }
  
  protected final void erG()
  {
    AppMethodBeat.i(111993);
    super.erG();
    erT();
    this.BOd.setVisibility(8);
    erE().setVisibility(0);
    if ((this.BNQ != null) && (!this.BNQ.BRz)) {
      this.BNQ.esl();
    }
    AppMethodBeat.o(111993);
  }
  
  protected final void erH()
  {
    AppMethodBeat.i(111992);
    super.erH();
    erT();
    this.BOd.setVisibility(8);
    if ((this.BNQ != null) && (!this.BNQ.BRz)) {
      this.BNQ.esl();
    }
    AppMethodBeat.o(111992);
  }
  
  protected final void erI()
  {
    AppMethodBeat.i(111991);
    super.erI();
    erS();
    this.BOd.setVisibility(8);
    if ((this.BNR) && (this.BNQ != null)) {
      this.BNQ.show();
    }
    AppMethodBeat.o(111991);
  }
  
  protected final void erL()
  {
    AppMethodBeat.i(112004);
    super.erL();
    com.tencent.mm.plugin.fts.ui.widget.i locali = this.BNV;
    if (!locali.BSP)
    {
      locali.BSP = true;
      if (locali.BSO == i.b.BTe)
      {
        Log.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
        l.U(locali.BNf, 10);
        locali.cVU();
      }
    }
    AppMethodBeat.o(112004);
  }
  
  public final List<View> erM()
  {
    AppMethodBeat.i(111996);
    ArrayList localArrayList = new ArrayList();
    if (this.BNY == null)
    {
      this.BNY = getLayoutInflater().inflate(o.e.fts_search_contact_footer, null, false);
      this.BNZ = this.BNY.findViewById(o.d.search_contact_layout);
      this.BNZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(191052);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSMainUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          paramAnonymousView = FTSMainUI.this;
          localObject1 = FTSMainUI.this.query;
          Object localObject2 = paramAnonymousView.BNX.BND;
          int i = paramAnonymousView.BNX.getCount();
          int j = paramAnonymousView.ptD;
          Object localObject3 = new mz();
          ((mz)localObject3).gWA = j;
          boolean bool2;
          if (com.tencent.mm.plugin.fts.a.d.aHM((String)localObject1))
          {
            ((mz)localObject3).gWB = 8L;
            ((mz)localObject3).gWC = (i + 1);
            if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BMI > 0L) && (((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BMI < System.currentTimeMillis())) {
              ((mz)localObject3).gQb = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQq);
            }
            if (!((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQL.equals(localObject1)) {
              ((mz)localObject3).gXa = 1L;
            }
            mz localmz = ((mz)localObject3).DA("").DB("");
            localmz.gWL = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQu;
            localmz.gWM = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQv;
            localmz.gWN = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQw;
            localmz.gWO = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQx;
            localmz.gWP = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQy;
            localmz.gWQ = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).favCount;
            localmz.gWS = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQz;
            localmz.gWT = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQA;
            localmz = localmz.DC(String.valueOf(com.tencent.mm.plugin.fts.a.e.BHi)).DD((String)localObject1);
            localmz.gWX = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).erZ();
            localmz = localmz.DE("").DF("").DG("");
            localmz.gWZ = 1L;
            localmz.DH("").DI("").DJ("").DK("").DL("").DM("").DN("").DO("").DP("");
            ((mz)localObject3).bpa();
            Log.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((mz)localObject3).agI().replace("\r\n", " ") });
            boolean bool1 = com.tencent.mm.plugin.fts.a.d.aHM(paramAnonymousView.query);
            bool2 = com.tencent.mm.plugin.fts.a.d.aHN(paramAnonymousView.query);
            if (!bool1) {
              break label555;
            }
          }
          for (i = 8;; i = 9)
          {
            ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).SJ(i);
            localObject3 = paramAnonymousView.BNX;
            ((k)localObject3).BNy = true;
            ((k)localObject3).BNE.SN(1);
            paramAnonymousView.BNX.BNy = true;
            if (!paramAnonymousView.BNX.BNo)
            {
              paramAnonymousView.BNX.BNo = true;
              l.a((String)localObject1, true, paramAnonymousView.BNX.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject2);
            }
            if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).trim().length() != 0)) {
              break label566;
            }
            label555:
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(191052);
              return;
              ((mz)localObject3).gWB = 9L;
              break;
            } while (!bool2);
          }
          label566:
          if (Character.isDigit(((String)localObject1).charAt(0))) {}
          for (i = 15;; i = 3)
          {
            paramAnonymousView.BMy = i;
            localObject2 = new FTSMainUI.14(paramAnonymousView, (String)localObject1);
            com.tencent.mm.kernel.h.aGY().a(106, (com.tencent.mm.an.i)localObject2);
            localObject1 = new com.tencent.mm.plugin.messenger.a.f((String)localObject1, 3);
            com.tencent.mm.kernel.h.aGY().a((q)localObject1, 0);
            paramAnonymousView.getString(o.g.app_tip);
            paramAnonymousView.vgC = com.tencent.mm.ui.base.h.a(paramAnonymousView, paramAnonymousView.getString(o.g.search_contact_doing), true, new FTSMainUI.2(paramAnonymousView, (com.tencent.mm.plugin.messenger.a.f)localObject1, (com.tencent.mm.an.i)localObject2));
            break;
          }
        }
      });
      this.BOa = this.BNY.findViewById(o.d.search_contact_divider);
      this.BOb = ((TextView)this.BNY.findViewById(o.d.search_contact_tv));
    }
    localArrayList.add(this.BNY);
    if (this.BNV.eaA() != null) {
      localArrayList.add(this.BNV.eaA());
    }
    if (this.BOc == null)
    {
      this.BOc = getLayoutInflater().inflate(o.e.fts_loading_footer, null, false);
      this.BOd = this.BOc.findViewById(o.d.loading_layout);
    }
    localArrayList.add(this.BOc);
    AppMethodBeat.o(111996);
    return localArrayList;
  }
  
  protected final void erN()
  {
    AppMethodBeat.i(111998);
    this.BOd.setVisibility(0);
    AppMethodBeat.o(111998);
  }
  
  protected final void erO()
  {
    AppMethodBeat.i(111999);
    this.BOd.setVisibility(8);
    AppMethodBeat.o(111999);
  }
  
  public final k erR()
  {
    return this.BNX;
  }
  
  protected final void erw()
  {
    AppMethodBeat.i(112002);
    super.erw();
    this.BOa.setVisibility(8);
    this.BNZ.setVisibility(8);
    this.BOh = 1;
    Object localObject1 = this.BNV;
    Object localObject2 = this.query;
    long l = com.tencent.mm.plugin.fts.a.e.BHj;
    if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSO == i.b.BTe)
    {
      l.U(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNf, 11);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).eqZ();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).esD();
      int i = ai.anh(5);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i) });
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).a(i.b.BTe);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).query = ((String)localObject2);
      Object localObject3 = new diq();
      ((diq)localObject3).RYJ = ((String)localObject2);
      ((diq)localObject3).Tkx = String.valueOf(l);
      ((diq)localObject3).SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.BHi);
      ((diq)localObject3).TQb = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vQV, 0);
      ((diq)localObject3).Tkv = i;
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNf = l;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vQW, 500);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSN = new u((diq)localObject3);
      com.tencent.mm.kernel.h.aGY().a(1076, (com.tencent.mm.an.i)localObject1);
      com.tencent.mm.kernel.h.aGY().a(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSN, 0);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BMI = System.currentTimeMillis();
      localObject3 = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BQX.obtainMessage(1, Long.valueOf(l));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BQX.sendMessageDelayed((Message)localObject3, i);
      localObject2 = com.tencent.mm.plugin.fts.a.f.a(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.getString(o.g.fts_on_search_network), "", com.tencent.mm.plugin.fts.a.a.e.c((CharSequence)localObject2, (String)localObject2)).BIp;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.l.d(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.getContext(), (CharSequence)localObject2, com.tencent.mm.ci.a.aY(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.getContext(), o.b.NormalTextSize));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNb.setText((CharSequence)localObject2);
      l.U(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNf, 1);
      localObject1 = this.BNU;
      localObject2 = this.query;
      localObject3 = String.valueOf(com.tencent.mm.plugin.fts.a.e.BHj);
      p.k(localObject2, "query");
      p.k(localObject3, "searchId");
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).reset();
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).BSb = ((String)localObject2);
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).BSe = ((String)localObject3);
      localObject3 = new cpa();
      ((cpa)localObject3).Tkx = ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).BSe;
      ((cpa)localObject3).RYJ = ((String)localObject2);
      ((cpa)localObject3).Tkv = ai.anh(0);
      ((cpa)localObject3).CPw = 74;
      ((cpa)localObject3).SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.BHi);
      ((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).BSd = new com.tencent.mm.plugin.fts.ui.c.c((cpa)localObject3);
      com.tencent.mm.kernel.h.aGY().a((q)((com.tencent.mm.plugin.fts.ui.widget.h)localObject1).BSd, 0);
      localObject1 = null;
      if (!com.tencent.mm.plugin.fts.a.d.aHM(this.query)) {
        break label619;
      }
      localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(o.g.fts_find_phone_qq_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).BIp;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.d(getContext(), (CharSequence)localObject1, com.tencent.mm.ci.a.aY(getContext(), o.b.NormalTextSize));
      this.BOb.setText((CharSequence)localObject1);
      AppMethodBeat.o(112002);
      return;
      if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSO != i.b.BTg) {
        break;
      }
      l.U(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNf, 8);
      break;
      label619:
      if (com.tencent.mm.plugin.fts.a.d.aHN(this.query)) {
        localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(o.g.fts_find_wxid_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).BIp;
      }
    }
  }
  
  protected final void erx()
  {
    AppMethodBeat.i(112003);
    super.erx();
    this.BOh = 1;
    com.tencent.mm.plugin.fts.ui.widget.i locali = this.BNV;
    locali.esC();
    locali.eqZ();
    locali.clearData();
    locali.esD();
    this.BNU.reset();
    AppMethodBeat.o(112003);
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
        AppMethodBeat.i(192150);
        Log.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSMainUI.g(FTSMainUI.this);
        AppMethodBeat.o(192150);
      }
    }, i);
    AppMethodBeat.o(111987);
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(111995);
    Object localObject = this.BNV;
    if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj == null)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj = LayoutInflater.from(((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSg).inflate(o.e.fts_web_search_header, null, false);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).contentView = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.header_content_view);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSn = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.search_sug_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSo = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.sug1_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSp = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.sug2_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSq = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.sug3_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSr = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.search_result_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSs = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.result_header_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BPZ = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.contact_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).iZG = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.avatar_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSt = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.contact_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BQa = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.contact_desc_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSu = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.contact_type_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSv = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.doc_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSw = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.doc_icon_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSx = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.doc_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSy = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.doc_desc_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSz = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.doc_brand_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSA = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.doc_time_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSB = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.video_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSC = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.video_thumb_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSD = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.video_duration_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSE = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.video_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSF = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.video_brand_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSG = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.music_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSH = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.music_icon_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSI = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.music_thumb_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSJ = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.music_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSK = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.music_desc_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSL = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.music_brand_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSM = new j((com.tencent.mm.plugin.fts.ui.widget.i)localObject, (FrameLayout)((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj.findViewById(o.d.webview_result_container));
    }
    localObject = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSj;
    AppMethodBeat.o(111995);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return o.e.fts_main_ui;
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
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(o.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    getWindow().getDecorView().setBackgroundResource(o.a.fts_bg_color);
    this.BNW = ((KeyboardLinearLayout)findViewById(o.d.root));
    this.BNW.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void SG(int paramAnonymousInt)
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
              if ((Util.isNullOrNil(FTSMainUI.this.BMQ.getSearchContent())) && (FTSMainUI.a(FTSMainUI.this) != null)) {
                FTSMainUI.a(FTSMainUI.this).show();
              }
              com.tencent.mm.plugin.fts.ui.widget.h localh = FTSMainUI.b(FTSMainUI.this);
              localh.BSf = true;
              Object localObject = localh.BSc;
              if (localObject != null)
              {
                localObject = ((cpb)localObject).TwM;
                if ((localObject != null) && (((epm)localObject).RLp != null))
                {
                  localh.xUj.setVisibility(0);
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
        if (paramAnonymousInt == -2) {
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111961);
              FTSMainUI.a(FTSMainUI.this, false);
              if (FTSMainUI.a(FTSMainUI.this) != null) {
                FTSMainUI.a(FTSMainUI.this).esl();
              }
              com.tencent.mm.plugin.fts.ui.widget.h localh = FTSMainUI.b(FTSMainUI.this);
              localh.BSf = false;
              localh.xUj.setVisibility(8);
              AppMethodBeat.o(111961);
            }
          }, 0L);
        }
        AppMethodBeat.o(111962);
      }
    });
    paramBundle = getBounceView();
    if (paramBundle != null) {
      paramBundle.a(new FTSMainUI.7(this));
    }
    this.BMQ.setHint(getString(o.g.app_search));
    paramBundle = this.BMQ;
    if (paramBundle.XUk != null) {
      paramBundle.XUk.setImeScene(4);
    }
    setActionbarColor(getContext().getResources().getColor(o.a.normal_actionbar_color));
    hideActionbarLine();
    com.tencent.mm.plugin.fts.a.e.BHi = com.tencent.mm.plugin.fts.a.d.Sw(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.ptD), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.BHi), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.BHi), Integer.valueOf(0), "", "" });
    Log.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10991, paramBundle);
    this.BNP = ((FTSMainUIEducationLayout)findViewById(o.d.search_education_layout));
    this.BNP.setOnCellClickListener(this.BOf);
    this.BNP.setOnHotwordClickListener(new FTSMainUI.8(this));
    this.BNP.setNeedHotWord(false);
    com.tencent.e.h.ZvG.d(new FTSMainUI.10(this), "FTSMainUI.GetLocation");
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(111978);
      return;
    }
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().eqB();
    ak.bB(3, false);
    EventCenter.instance.add(this.BOg);
    AppMethodBeat.o(111978);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool3 = true;
    AppMethodBeat.i(111979);
    boolean bool4 = super.onCreateOptionsMenu(paramMenu);
    paramMenu = this.BMQ;
    Object localObject = this.BNV;
    if (paramMenu.XUk != null) {
      paramMenu.XUk.setFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
    if ((LocaleUtil.isChineseAppLang()) || (LocaleUtil.getApplicationLanguage().equals("en"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(111979);
      return bool4;
    }
    paramMenu = (FTSVoiceInputLayoutImpl)findViewById(o.d.fts_voice_panel);
    localObject = (TextView)findViewById(o.d.voicetext);
    ProgressBar localProgressBar = (ProgressBar)findViewById(o.d.voiceloading);
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
    this.BNQ = new com.tencent.mm.plugin.fts.ui.widget.b(this, paramMenu, (TextView)localObject, localProgressBar);
    this.BNQ.BRy = new com.tencent.mm.plugin.fts.ui.widget.b.a()
    {
      public final void aIk(String paramAnonymousString)
      {
        AppMethodBeat.i(189452);
        FTSMainUI.this.BMQ.setSearchContent(paramAnonymousString);
        AppMethodBeat.o(189452);
      }
      
      public final void aIl(String paramAnonymousString)
      {
        AppMethodBeat.i(189458);
        FTSMainUI.e(FTSMainUI.this).BND.BQL = paramAnonymousString;
        FTSMainUI.this.BMQ.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        AppMethodBeat.o(189458);
      }
      
      public final void b(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString)
      {
        AppMethodBeat.i(189455);
        FTSMainUI.this.BMQ.setSearchContent(paramAnonymousString);
        FTSMainUI.a(FTSMainUI.this, paramAnonymousString);
        if (!paramAnonymousBoolean1)
        {
          if (paramAnonymousBoolean2)
          {
            FTSMainUI.aIj(FTSMainUI.this.getString(o.g.fts_voice_input_net_error));
            AppMethodBeat.o(189455);
            return;
          }
          FTSMainUI.aIj(FTSMainUI.this.getString(o.g.fts_voice_input_other_error));
        }
        AppMethodBeat.o(189455);
      }
      
      public final void erU()
      {
        AppMethodBeat.i(189450);
        FTSMainUI.this.BMQ.setCursorVisible(false);
        FTSMainUI.e(FTSMainUI.this).SF(1);
        FTSMainUI.f(FTSMainUI.this);
        FTSMainUI.this.BMQ.setHint(FTSMainUI.this.getContext().getString(o.g.fts_voice_input_hint));
        AppMethodBeat.o(189450);
      }
    };
    AppMethodBeat.o(111979);
    return bool4;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111985);
    com.tencent.e.h.ZvG.bDh("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.blq().b(this);
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().eqC();
    }
    EventCenter.instance.removeListener(this.BOg);
    Object localObject;
    if (this.BNQ != null)
    {
      localObject = this.BNQ;
      if (((com.tencent.mm.plugin.fts.ui.widget.b)localObject).BRA != null)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).BRA.bsc();
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.b)localObject).BRA;
        if (((VoiceInputLayout)localObject).qdR != null) {
          ((VoiceInputLayout)localObject).qdR.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).BTA != null) {
          ((VoiceInputLayout)localObject).BTA.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).mnf != null) {
          ((VoiceInputLayout)localObject).mnf.stopTimer();
        }
      }
    }
    if (this.BNV != null)
    {
      localObject = this.BNV;
      if (((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSM != null)
      {
        j localj = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).BSM;
        localj.BTn.destroy();
        com.tencent.mm.kernel.h.aGY().b(2975, localj);
        localj.BTk.removeJavascriptInterface("pardusJSApi");
        localj.BTk.destroy();
      }
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).SN(3);
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).esC();
      ((com.tencent.mm.plugin.fts.ui.widget.i)localObject).eqZ();
    }
    if (this.BNU != null)
    {
      localObject = this.BNU;
      com.tencent.mm.kernel.h.aGY().b(4591, (com.tencent.mm.an.i)localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(111985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111986);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.fts.ui.b.l.BQo;
    com.tencent.mm.plugin.fts.ui.b.l.a(this.BNP);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111973);
        com.tencent.mm.compatible.util.i.u(FTSMainUI.this);
        AppMethodBeat.o(111973);
      }
    });
    localObject = new zy();
    ((zy)localObject).fZl.delay = 0L;
    EventCenter.instance.publish((IEvent)localObject);
    if (!Util.isNullOrNil(this.BNS))
    {
      this.query = this.BNS;
      this.BNS = null;
    }
    ai.gQJ();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */