package com.tencent.mm.plugin.fts.ui;

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
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abp;
import com.tencent.mm.autogen.a.abv;
import com.tencent.mm.autogen.mmdata.rpt.qf;
import com.tencent.mm.autogen.mmdata.rpt.up;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.e.b;
import com.tencent.mm.plugin.fts.ui.widget.j;
import com.tencent.mm.plugin.fts.ui.widget.k.b;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.fkl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.widget.pulldown.f.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSBaseMainUI
  extends FTSBaseVoiceSearchUI
  implements b.a
{
  private com.tencent.mm.plugin.fts.ui.widget.c HxG;
  private boolean HxH;
  private String HxI;
  private volatile boolean HxJ;
  private j HxK;
  com.tencent.mm.plugin.fts.ui.widget.k HxL;
  private KeyboardLinearLayout HxM;
  private IListener<abp> HxN;
  private com.tencent.mm.plugin.fts.ui.widget.d HxO;
  public k HxP;
  private View HxQ;
  View HxR;
  private View HxS;
  private TextView HxT;
  private View HxU;
  private View HxV;
  com.tencent.mm.am.b.a HxW;
  private com.tencent.mm.plugin.websearch.api.k HxX;
  int HxY;
  int Hxu;
  public int syO;
  Dialog ysC;
  
  public FTSBaseMainUI()
  {
    AppMethodBeat.i(265552);
    this.HxH = false;
    this.HxN = new FTSBaseMainUI.1(this, com.tencent.mm.app.f.hfK);
    this.HxO = new com.tencent.mm.plugin.fts.ui.widget.d()
    {
      public final void aEH(String paramAnonymousString)
      {
        AppMethodBeat.i(265673);
        FTSBaseMainUI.this.Hyh.setSearchContent(paramAnonymousString);
        AppMethodBeat.o(265673);
      }
      
      public final void c(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString)
      {
        AppMethodBeat.i(265675);
        FTSBaseMainUI.this.Hyh.setSearchContent(paramAnonymousString);
        FTSBaseMainUI.a(FTSBaseMainUI.this, paramAnonymousString);
        if (!paramAnonymousBoolean1)
        {
          if (paramAnonymousBoolean2)
          {
            FTSBaseMainUI.aEG(FTSBaseMainUI.this.getString(p.g.fts_voice_input_net_error));
            AppMethodBeat.o(265675);
            return;
          }
          FTSBaseMainUI.aEG(FTSBaseMainUI.this.getString(p.g.fts_voice_input_other_error));
        }
        AppMethodBeat.o(265675);
      }
      
      public final TextView dcE()
      {
        AppMethodBeat.i(265663);
        TextView localTextView = (TextView)FTSBaseMainUI.this.findViewById(p.d.voicetext);
        AppMethodBeat.o(265663);
        return localTextView;
      }
      
      public final ProgressBar fyw()
      {
        AppMethodBeat.i(265657);
        ProgressBar localProgressBar = (ProgressBar)FTSBaseMainUI.this.findViewById(p.d.voiceloading);
        AppMethodBeat.o(265657);
        return localProgressBar;
      }
      
      public final void fyx()
      {
        AppMethodBeat.i(265668);
        FTSBaseMainUI.this.Hyh.setCursorVisible(false);
        FTSBaseMainUI.e(FTSBaseMainUI.this).Wn(1);
        if (!o.fyA()) {
          FTSBaseMainUI.f(FTSBaseMainUI.this);
        }
        FTSBaseMainUI.this.Hyh.setHint(FTSBaseMainUI.this.getContext().getString(p.g.fts_voice_input_hint));
        AppMethodBeat.o(265668);
      }
      
      public final void iE(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(265679);
        FTSBaseMainUI.e(FTSBaseMainUI.this).HyV.HCw = paramAnonymousString2;
        FTSBaseMainUI.this.Hyh.setSearchContent(paramAnonymousString2);
        FTSBaseMainUI.a(FTSBaseMainUI.this, paramAnonymousString2);
        AppMethodBeat.o(265679);
      }
    };
    this.Hxu = -1;
    this.HxW = null;
    this.HxX = new com.tencent.mm.plugin.websearch.api.k() {};
    this.HxY = 1;
    AppMethodBeat.o(265552);
  }
  
  private void fyl()
  {
    AppMethodBeat.i(265554);
    getStateCenter().dispatch(new com.tencent.mm.plugin.fts.ui.hotsearch.a.f(true));
    AppMethodBeat.o(265554);
  }
  
  private void fym()
  {
    AppMethodBeat.i(265558);
    getStateCenter().dispatch(new com.tencent.mm.plugin.fts.ui.hotsearch.a.f(false));
    AppMethodBeat.o(265558);
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(265702);
    super.SN(paramString);
    int i;
    if ((this.HxJ) && (!TextUtils.isEmpty(this.query)) && (!aj.aBu()))
    {
      Object localObject = this.HxP;
      paramString = new ArrayList();
      localObject = ((k)localObject).HyU.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject).next()).fxH());
      }
      if ((paramString.size() != 0) || (!TextUtils.isEmpty(this.HxT.getText()))) {
        break label459;
      }
      paramString = this.HxL;
      if ((!paramString.HEB) && (!paramString.HEC)) {
        break label454;
      }
      i = 1;
      if (i != 0) {
        break label459;
      }
      this.HxL.fk(this.query, 17);
      paramString = new up();
      paramString.jHH = 1L;
      paramString.ila = 1L;
      paramString.Au(this.query).bMH();
      i = this.syO;
      localObject = this.HxP.HyV;
      paramString = new qf();
      paramString.jqk = i;
      paramString.jql = 29L;
      paramString.jqn = 1L;
      paramString.jqH = ((com.tencent.mm.plugin.fts.ui.d.b)localObject).fyX();
      qf localqf = paramString.xk("").xl("").xn(((com.tencent.mm.plugin.fts.ui.d.b)localObject).query).xm("").xo("").xp("").xq("").xr("").xs("").xt("").xu("").xv("").xw("").xx("").xy("");
      localqf.jqZ = com.tencent.mm.plugin.fts.a.e.HrM;
      localqf.jra = ((com.tencent.mm.plugin.fts.ui.d.b)localObject).HBZ;
      localObject = localqf.xC(com.tencent.mm.plugin.fts.a.e.HrM).xD(((com.tencent.mm.plugin.fts.ui.d.b)localObject).HBZ).xE(com.tencent.mm.plugin.fts.a.e.fxu());
      ((qf)localObject).ivT = cn.bDv();
      ((qf)localObject).xz("");
      paramString.bMH();
      Log.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { paramString.aIF().replace("\r\n", " ") });
      this.HxL.Wu(8);
    }
    for (;;)
    {
      AppMethodBeat.o(265702);
      return false;
      label454:
      i = 0;
      break;
      label459:
      paramString = new up();
      paramString.jHH = 1L;
      paramString.ila = 2L;
      paramString.Au(this.query).bMH();
    }
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(265713);
    if ((this.HxG == null) || (!this.HxG.HDh)) {
      super.SO(paramString);
    }
    this.HxJ = false;
    AppMethodBeat.o(265713);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(265649);
    this.HxP = new k(parame, this.syO, this.HxL);
    this.HxP.Wn(2);
    parame = this.HxP;
    AppMethodBeat.o(265649);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(265654);
    if (paramBoolean) {
      this.HxL.Wu(1);
    }
    AppMethodBeat.o(265654);
  }
  
  public final void ba(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(265712);
    super.ba(paramInt, paramBoolean);
    if ((!paramBoolean) && (paramInt == 0) && (this.HxP.Hzd)) {
      this.HxV.setVisibility(0);
    }
    while (!paramBoolean)
    {
      this.HxR.setVisibility(8);
      this.HxL.bb(paramInt, false);
      AppMethodBeat.o(265712);
      return;
      this.HxV.setVisibility(8);
    }
    this.HxJ = true;
    boolean bool1 = com.tencent.mm.plugin.fts.a.d.aEk(this.query);
    boolean bool2 = com.tencent.mm.plugin.fts.a.d.aEl(this.query);
    Object localObject = this.HxL;
    if ((bool1) || (bool2))
    {
      paramBoolean = true;
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).bb(paramInt, paramBoolean);
      if (paramInt <= 0) {
        break label311;
      }
      if ((bool1) || (bool2)) {
        this.HxS.setVisibility(0);
      }
      label154:
      if ((bool1) || (bool2))
      {
        this.HxR.setVisibility(0);
        localObject = this.HxP.HyV;
        if (!bool1) {
          break label323;
        }
        paramInt = 1;
        label188:
        if (!bool2) {
          break label328;
        }
        label193:
        ((com.tencent.mm.plugin.fts.ui.d.b)localObject).HCq = paramInt;
        ((com.tencent.mm.plugin.fts.ui.d.b)localObject).HCr = i;
        if (!bool1) {
          break label333;
        }
        paramInt = 8;
      }
    }
    for (;;)
    {
      localObject = this.HxP.HyV;
      com.tencent.mm.plugin.fts.a.a.e locale = new com.tencent.mm.plugin.fts.a.a.e();
      locale.position = (((com.tencent.mm.plugin.fts.ui.d.b)localObject).HCu + 1);
      locale.hTs = "SearchContactBar";
      locale.HsB = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.d.b)localObject).HxE);
      locale.itemType = paramInt;
      if (!((com.tencent.mm.plugin.fts.ui.d.b)localObject).HCB.contains(locale)) {
        ((com.tencent.mm.plugin.fts.ui.d.b)localObject).HCB.add(locale);
      }
      AppMethodBeat.o(265712);
      return;
      paramBoolean = false;
      break;
      label311:
      this.HxS.setVisibility(8);
      break label154;
      label323:
      paramInt = 0;
      break label188;
      label328:
      i = 0;
      break label193;
      label333:
      paramInt = j;
      if (bool2) {
        paramInt = 9;
      }
    }
  }
  
  protected final void eui()
  {
    AppMethodBeat.i(265716);
    super.eui();
    this.HxY = 1;
    com.tencent.mm.plugin.fts.ui.widget.k localk = this.HxL;
    Log.i("MicroMsg.FTS.PardusSearchLogic", "stopSearch");
    localk.fzB();
    localk.fxG();
    localk.clearData();
    localk.fzC();
    this.HxK.reset();
    AppMethodBeat.o(265716);
  }
  
  public void finish()
  {
    AppMethodBeat.i(265664);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(265662);
        Log.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSBaseMainUI.g(FTSBaseMainUI.this);
        AppMethodBeat.o(265662);
      }
    }, i);
    AppMethodBeat.o(265664);
  }
  
  protected final void fye()
  {
    AppMethodBeat.i(265714);
    super.fye();
    this.HxS.setVisibility(8);
    this.HxR.setVisibility(8);
    this.HxY = 1;
    com.tencent.mm.plugin.fts.ui.widget.k localk = this.HxL;
    String str4 = this.query;
    long l = com.tencent.mm.plugin.fts.a.e.HrN;
    String str3;
    String str2;
    if (!aj.aBu())
    {
      if (localk.HEy != k.b.HES) {
        break label867;
      }
      l.ak(localk.Hyw, 11);
      localk.clearData();
      localk.fxG();
      localk.fzC();
      int i = aj.asY(5);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", new Object[] { str4, Long.valueOf(l), Integer.valueOf(i) });
      localk.a(k.b.HES);
      localk.query = str4;
      localObject1 = new eba();
      ((eba)localObject1).YWK = str4;
      ((eba)localObject1).aaye = String.valueOf(l);
      ((eba)localObject1).SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.HrM);
      ((eba)localObject1).abgy = 1;
      ((eba)localObject1).aayc = i;
      ((eba)localObject1).abgA = aj.asY(0);
      localk.Hyw = l;
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjE, 500);
      localk.HEx = new v((eba)localObject1);
      com.tencent.mm.kernel.h.aZW().a(1076, localk);
      com.tencent.mm.kernel.h.aZW().a(localk.HEx, 0);
      localk.HxE = cn.bDw();
      localObject1 = localk.HEE.obtainMessage(1, Long.valueOf(l));
      localk.HEE.sendMessageDelayed((Message)localObject1, i);
      str3 = localk.HDH.getString(p.g.fts_on_search_network);
      str2 = "";
      localObject4 = str2;
      localObject1 = str3;
    }
    try
    {
      JSONObject localJSONObject = al.bix("webSearchBar");
      localObject4 = str2;
      localObject1 = str3;
      String str6 = localJSONObject.optString("title_prefix");
      localObject4 = str2;
      localObject1 = str3;
      String str5 = localJSONObject.optString("title_suffix");
      str1 = str2;
      localObject3 = str3;
      localObject4 = str2;
      localObject1 = str3;
      if (!Util.isNullOrNil(localJSONObject.optString("icon")))
      {
        str1 = str2;
        localObject3 = str3;
        localObject4 = str2;
        localObject1 = str3;
        if (!Util.isNullOrNil(str6))
        {
          str1 = str2;
          localObject3 = str3;
          localObject4 = str2;
          localObject1 = str3;
          if (!Util.isNullOrNil(str5))
          {
            localObject4 = str2;
            localObject1 = str3;
            localObject3 = str6 + " ";
            localObject4 = str2;
            localObject1 = localObject3;
            str1 = " ".concat(String.valueOf(str5));
          }
        }
      }
      localObject4 = str1;
      localObject1 = localObject3;
      Log.i("MicroMsg.FTS.PardusSearchLogic", "set titlePrefix %s，titleSuffix %s， webSearchObj = %s.", new Object[] { localObject3, str1, localJSONObject });
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        Object localObject3;
        Object localObject2 = localObject4;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.fts.a.f.a((String)localObject1, "", com.tencent.mm.plugin.fts.a.a.g.c(str4, str4)).HsX;
    localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(localk.HDH.getContext(), (CharSequence)localObject1, com.tencent.mm.cd.a.br(localk.HDH.getContext(), p.b.NormalTextSize));
    localk.Hys.setText((CharSequence)localObject1);
    if ((localk.HEK != null) && (!TextUtils.isEmpty(str1)))
    {
      localk.HEK.setVisibility(0);
      localk.HEK.setText(str1);
    }
    l.ak(localk.Hyw, 1);
    localObject1 = this.HxK;
    str1 = this.query;
    localObject3 = String.valueOf(com.tencent.mm.plugin.fts.a.e.HrN);
    kotlin.g.b.s.u(str1, "query");
    kotlin.g.b.s.u(localObject3, "searchId");
    if (!aj.aBu())
    {
      ((j)localObject1).reset();
      ((j)localObject1).HDK = str1;
      ((j)localObject1).HDN = ((String)localObject3);
      localObject3 = new dfu();
      ((dfu)localObject3).aaye = ((j)localObject1).HDN;
      ((dfu)localObject3).YWK = str1;
      ((dfu)localObject3).aayc = aj.asY(0);
      ((dfu)localObject3).IJG = 74;
      ((dfu)localObject3).SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.HrM);
      ((j)localObject1).HDM = new com.tencent.mm.plugin.fts.ui.d.c((dfu)localObject3);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)((j)localObject1).HDM, 0);
    }
    localObject1 = null;
    if (com.tencent.mm.plugin.fts.a.d.aEk(this.query)) {
      localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(p.g.fts_find_phone_qq_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.g.c(this.query, this.query)).HsX;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(getContext(), (CharSequence)localObject1, com.tencent.mm.cd.a.br(getContext(), p.b.NormalTextSize));
      this.HxT.setText((CharSequence)localObject1);
      AppMethodBeat.o(265714);
      return;
      label867:
      if (localk.HEy != k.b.HEU) {
        break;
      }
      l.ak(localk.Hyw, 8);
      break;
      if (com.tencent.mm.plugin.fts.a.d.aEl(this.query)) {
        localObject1 = com.tencent.mm.plugin.fts.a.f.a(getString(p.g.fts_find_wxid_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.g.c(this.query, this.query)).HsX;
      }
    }
  }
  
  protected final void fyk()
  {
    AppMethodBeat.i(265644);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.syO = 0;
    }
    for (;;)
    {
      this.HxL = new com.tencent.mm.plugin.fts.ui.widget.k(this);
      this.HxK = new j(this);
      AppMethodBeat.o(265644);
      return;
      this.syO = 1;
      continue;
      this.syO = 2;
      continue;
      this.syO = 3;
      continue;
      this.syO = 4;
    }
  }
  
  protected final void fyn()
  {
    AppMethodBeat.i(265674);
    super.fyn();
    fyl();
    this.HxV.setVisibility(8);
    if ((this.HxH) && (this.HxG != null)) {
      this.HxG.show();
    }
    AppMethodBeat.o(265674);
  }
  
  protected final void fyo()
  {
    AppMethodBeat.i(265678);
    super.fyo();
    fym();
    this.HxV.setVisibility(8);
    if ((this.HxG != null) && (!this.HxG.HDh)) {
      this.HxG.fzk();
    }
    AppMethodBeat.o(265678);
  }
  
  protected final void fyp()
  {
    AppMethodBeat.i(265680);
    super.fyp();
    fym();
    this.HxV.setVisibility(8);
    fyy().setVisibility(0);
    if ((this.HxG != null) && (!this.HxG.HDh)) {
      this.HxG.fzk();
    }
    AppMethodBeat.o(265680);
  }
  
  protected final void fyq()
  {
    AppMethodBeat.i(265683);
    super.fyq();
    fym();
    this.HxV.setVisibility(8);
    if ((this.HxG != null) && (!this.HxG.HDh)) {
      this.HxG.fzk();
    }
    AppMethodBeat.o(265683);
  }
  
  public final List<View> fyr()
  {
    AppMethodBeat.i(265696);
    ArrayList localArrayList = new ArrayList();
    if (this.HxQ == null)
    {
      this.HxQ = getLayoutInflater().inflate(p.e.fts_search_contact_footer, null, false);
      this.HxR = this.HxQ.findViewById(p.d.search_contact_layout);
      this.HxR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(265703);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSBaseMainUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          paramAnonymousView = FTSBaseMainUI.this;
          localObject1 = FTSBaseMainUI.this.query;
          com.tencent.mm.plugin.fts.ui.d.b localb = paramAnonymousView.HxP.HyV;
          int i = paramAnonymousView.HxP.getCount();
          int j = paramAnonymousView.syO;
          Object localObject2 = new qf();
          ((qf)localObject2).jqk = j;
          boolean bool2;
          if (com.tencent.mm.plugin.fts.a.d.aEk((String)localObject1))
          {
            ((qf)localObject2).jql = 8L;
            ((qf)localObject2).jqm = (i + 1);
            if ((localb.HxE > 0L) && (localb.HxE < System.currentTimeMillis())) {
              ((qf)localObject2).jip = (System.currentTimeMillis() - localb.HBX);
            }
            if (!localb.HCw.equals(localObject1)) {
              ((qf)localObject2).jqK = 1L;
            }
            qf localqf = ((qf)localObject2).xk("").xl("");
            localqf.jqv = localb.HCb;
            localqf.jqw = localb.HCc;
            localqf.jqx = localb.HCd;
            localqf.jqy = localb.HCh;
            localqf.jqz = localb.HCi;
            localqf.jqA = localb.favCount;
            localqf.jqC = localb.HCj;
            localqf.jqD = localb.HCk;
            localqf = localqf.xm(String.valueOf(com.tencent.mm.plugin.fts.a.e.HrM)).xn((String)localObject1);
            localqf.jqH = localb.fyX();
            localqf = localqf.xo("").xp("").xq("");
            localqf.jqJ = 1L;
            localqf = localqf.xr("").xs("").xt("").xu("").xv("").xw("").xx("").xy("").xE(com.tencent.mm.plugin.fts.a.e.fxu());
            localqf.ivT = cn.bDv();
            localqf.xz("");
            ((qf)localObject2).bMH();
            Log.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { ((qf)localObject2).aIF().replace("\r\n", " ") });
            boolean bool1 = com.tencent.mm.plugin.fts.a.d.aEk(paramAnonymousView.query);
            bool2 = com.tencent.mm.plugin.fts.a.d.aEl(paramAnonymousView.query);
            if (!bool1) {
              break label575;
            }
          }
          for (i = 8;; i = 9)
          {
            localb.Wq(i);
            localObject2 = paramAnonymousView.HxP;
            ((k)localObject2).HyQ = true;
            ((k)localObject2).HyW.Wu(1);
            paramAnonymousView.HxP.HyQ = true;
            if (!paramAnonymousView.HxP.HyH)
            {
              paramAnonymousView.HxP.HyH = true;
              l.a((String)localObject1, true, paramAnonymousView.HxP.getCount(), 0, localb);
            }
            if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).trim().length() != 0)) {
              break label586;
            }
            label575:
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBaseMainUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(265703);
              return;
              ((qf)localObject2).jql = 9L;
              break;
            } while (!bool2);
          }
          label586:
          if (Character.isDigit(((String)localObject1).charAt(0))) {}
          for (i = 15;; i = 3)
          {
            paramAnonymousView.Hxu = i;
            if (paramAnonymousView.HxW == null)
            {
              paramAnonymousView.HxW = new FTSBaseMainUI.3(paramAnonymousView, (String)localObject1);
              com.tencent.mm.kernel.h.aZW().a(106, paramAnonymousView, paramAnonymousView.HxW);
            }
            localObject1 = new com.tencent.mm.plugin.messenger.a.f((String)localObject1, 3);
            com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
            paramAnonymousView.getString(p.g.app_tip);
            paramAnonymousView.ysC = com.tencent.mm.ui.base.k.a(paramAnonymousView, paramAnonymousView.getString(p.g.search_contact_doing), true, new FTSBaseMainUI.4(paramAnonymousView, (com.tencent.mm.plugin.messenger.a.f)localObject1));
            break;
          }
        }
      });
      this.HxS = this.HxQ.findViewById(p.d.search_contact_divider);
      this.HxT = ((TextView)this.HxQ.findViewById(p.d.search_contact_tv));
    }
    localArrayList.add(this.HxQ);
    if (this.HxL.fbq() != null) {
      localArrayList.add(this.HxL.fbq());
    }
    if (this.HxU == null)
    {
      this.HxU = getLayoutInflater().inflate(p.e.fts_loading_footer, null, false);
      this.HxV = this.HxU.findViewById(p.d.loading_layout);
    }
    localArrayList.add(this.HxU);
    AppMethodBeat.o(265696);
    return localArrayList;
  }
  
  protected final void fys()
  {
    AppMethodBeat.i(265706);
    this.HxV.setVisibility(0);
    AppMethodBeat.o(265706);
  }
  
  protected final void fyt()
  {
    AppMethodBeat.i(265710);
    this.HxV.setVisibility(8);
    AppMethodBeat.o(265710);
  }
  
  protected final void fyu()
  {
    AppMethodBeat.i(265718);
    super.fyu();
    com.tencent.mm.plugin.fts.ui.widget.k localk = this.HxL;
    if (!localk.HEz)
    {
      localk.HEz = true;
      if (localk.HEy == k.b.HES)
      {
        Log.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
        l.ak(localk.Hyw, 10);
        localk.dBz();
      }
    }
    AppMethodBeat.o(265718);
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(265691);
    Object localObject = this.HxL;
    if (((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR == null)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR = LayoutInflater.from(((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDH).inflate(p.e.fts_web_search_header, null, false);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).contentView = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.header_content_view);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDV = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.search_sug_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDW = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.sug1_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDX = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.sug2_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDY = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.sug3_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDZ = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.search_result_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEa = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.result_header_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEb = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.contact_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).lBC = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.avatar_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEc = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.contact_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEd = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.contact_desc_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEe = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.contact_type_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEf = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.doc_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEg = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.doc_icon_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEh = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.doc_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEi = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.doc_desc_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEj = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.doc_brand_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEk = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.doc_time_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEl = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.video_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEm = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.video_thumb_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEn = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.video_duration_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEo = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.video_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEp = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.video_brand_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEq = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.music_layout);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEr = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.music_icon_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEs = ((ImageView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.music_thumb_iv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEt = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.music_title_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEu = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.music_desc_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEv = ((TextView)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.music_brand_tv));
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEw = new com.tencent.mm.plugin.fts.ui.widget.l((com.tencent.mm.plugin.fts.ui.widget.k)localObject, (FrameLayout)((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR.findViewById(p.d.webview_result_container));
    }
    localObject = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HDR;
    AppMethodBeat.o(265691);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return p.e.fts_main_ui;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(265635);
    finish();
    AppMethodBeat.o(265635);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265621);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(p.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    getWindow().getDecorView().setBackgroundResource(p.a.fts_bg_color);
    this.HxM = ((KeyboardLinearLayout)findViewById(p.d.root));
    this.HxM.setOnkbdStateCopyListener(new KeyboardLinearLayout.a()
    {
      public final void onKeyBoardStateChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(265705);
        if (paramAnonymousInt == -3)
        {
          Log.i("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265543);
              FTSBaseMainUI.a(FTSBaseMainUI.this, true);
              if ((Util.isNullOrNil(FTSBaseMainUI.this.Hyh.getSearchContent())) && (FTSBaseMainUI.a(FTSBaseMainUI.this) != null)) {
                FTSBaseMainUI.a(FTSBaseMainUI.this).show();
              }
              j localj = FTSBaseMainUI.b(FTSBaseMainUI.this);
              localj.HDO = true;
              Object localObject = localj.HDL;
              if (localObject != null)
              {
                localObject = ((dfv)localObject).aaLt;
                if ((localObject != null) && (((fkl)localObject).YIB != null)) {
                  localj.AZd.setVisibility(0);
                }
              }
              AppMethodBeat.o(265543);
            }
          }, 0L);
          AppMethodBeat.o(265705);
          return;
        }
        if (paramAnonymousInt == -2) {
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265542);
              FTSBaseMainUI.a(FTSBaseMainUI.this, false);
              if (FTSBaseMainUI.a(FTSBaseMainUI.this) != null) {
                FTSBaseMainUI.a(FTSBaseMainUI.this).fzk();
              }
              j localj = FTSBaseMainUI.b(FTSBaseMainUI.this);
              localj.HDO = false;
              localj.AZd.setVisibility(8);
              AppMethodBeat.o(265542);
            }
          }, 0L);
        }
        AppMethodBeat.o(265705);
      }
    });
    paramBundle = getBounceView();
    if (paramBundle != null) {
      paramBundle.a(new f.a()
      {
        public final void Wm(int paramAnonymousInt)
        {
          AppMethodBeat.i(265707);
          if ((paramAnonymousInt != 0) && (FTSBaseMainUI.c(FTSBaseMainUI.this))) {
            FTSBaseMainUI.this.hideVKB();
          }
          AppMethodBeat.o(265707);
        }
      });
    }
    this.Hyh.setHint(getString(p.g.app_search));
    paramBundle = this.Hyh;
    if (paramBundle.afKy != null) {
      paramBundle.afKy.setImeScene(4);
    }
    setActionbarColor(getContext().getResources().getColor(p.a.normal_actionbar_color));
    hideActionbarLine();
    com.tencent.mm.plugin.fts.a.e.HrM = com.tencent.mm.plugin.fts.a.d.Wd(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.syO), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.HrM), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.HrM), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", Long.valueOf(System.currentTimeMillis()) });
    Log.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10991, paramBundle);
    com.tencent.threadpool.h.ahAA.g(new FTSBaseMainUI.12(this), "FTSMainUI.GetLocation");
    if (((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(265621);
      return;
    }
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader().fxg();
    al.cj(3, false);
    getStateCenter().observe(this, new IMvvmObserver() {});
    this.HxN.alive();
    AppMethodBeat.o(265621);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(265629);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    paramMenu = this.Hyh;
    com.tencent.mm.plugin.fts.ui.widget.k localk = this.HxL;
    if (paramMenu.afKy != null) {
      paramMenu.afKy.setFocusChangeListener(localk);
    }
    if ((LocaleUtil.isChineseAppLang()) || (LocaleUtil.getApplicationLanguage().equals("en"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(265629);
      return bool;
    }
    if (o.fyA()) {
      this.Hyh.HDE = new e.b()
      {
        public final void fyv()
        {
          AppMethodBeat.i(265658);
          FTSBaseMainUI.this.getStateCenter().dispatch(new com.tencent.mm.plugin.fts.ui.hotsearch.a.g(FTSBaseMainUI.d(FTSBaseMainUI.this)));
          AppMethodBeat.o(265658);
        }
      };
    }
    for (;;)
    {
      AppMethodBeat.o(265629);
      return bool;
      paramMenu = (FTSVoiceInputLayoutImpl)findViewById(p.d.fts_voice_panel);
      if ((paramMenu != null) && (this.HxO.dcE() != null) && (this.HxO.fyw() != null))
      {
        this.HxG = new com.tencent.mm.plugin.fts.ui.widget.c(this, paramMenu, this.HxO.dcE(), this.HxO.fyw());
        this.HxG.HDg = this.HxO;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(265655);
    com.tencent.threadpool.h.ahAA.bFQ("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.bJl().a(this);
    if (((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader() != null) {
      ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader().fxh();
    }
    if (this.HxG != null) {
      this.HxG.release();
    }
    Object localObject;
    if (this.HxL != null)
    {
      localObject = this.HxL;
      if (((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEw != null)
      {
        com.tencent.mm.plugin.fts.ui.widget.l locall = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).HEw;
        locall.HFa.destroy();
        com.tencent.mm.kernel.h.aZW().b(2975, locall);
        locall.HEX.removeJavascriptInterface("pardusJSApi");
        locall.HEX.destroy();
      }
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).Wu(3);
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).clearData();
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).fzB();
      ((com.tencent.mm.plugin.fts.ui.widget.k)localObject).fxG();
    }
    if (this.HxK != null)
    {
      localObject = this.HxK;
      com.tencent.mm.kernel.h.aZW().b(4591, (com.tencent.mm.am.h)localObject);
    }
    com.tencent.mm.plugin.fts.a.e.fxv();
    this.HxN.dead();
    super.onDestroy();
    AppMethodBeat.o(265655);
  }
  
  public boolean onGetLocation(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(265671);
    Log.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.bJl().a(this);
    AppMethodBeat.o(265671);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(265659);
    super.onResume();
    runOnUiThread(new FTSBaseMainUI.13(this));
    abv localabv = new abv();
    localabv.ifq.delay = 0L;
    localabv.publish();
    if (!Util.isNullOrNil(this.HxI))
    {
      this.query = this.HxI;
      this.HxI = null;
    }
    aj.ipT();
    AppMethodBeat.o(265659);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(265640);
    hideVKB();
    super.onStop();
    AppMethodBeat.o(265640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseMainUI
 * JD-Core Version:    0.7.0.1
 */