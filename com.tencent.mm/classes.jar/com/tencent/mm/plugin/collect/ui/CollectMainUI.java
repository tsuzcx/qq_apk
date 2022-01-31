package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.f.a;
import com.tencent.mm.plugin.collect.model.l;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@i
@com.tencent.mm.ui.base.a(0)
public class CollectMainUI
  extends WalletPreferenceUI
  implements d.a, bc.a
{
  private static int kRZ;
  private static int kSv = -1;
  private static int kSw = -1;
  private static int kSx = -1;
  private static int kSy = -1;
  private int cLB;
  private com.tencent.mm.ui.base.preference.f iLA;
  private Vibrator jbU;
  protected ScrollView kPF;
  private View kRA;
  private TextView kRB;
  private Dialog kRC;
  private View kRD;
  private View kRE;
  private boolean kRF;
  private View kRG;
  private ImageView kRH;
  private TextView kRI;
  private TextView kRJ;
  private TextView kRK;
  protected LinearLayout kRL;
  protected TextView kRM;
  private RelativeLayout kRN;
  private Bitmap kRO;
  protected String kRP;
  protected String kRQ;
  private String kRR;
  private int kRS;
  private List<CollectMainUI.a> kRT;
  private double kRU;
  private String kRV;
  private String kRW;
  protected boolean kRX;
  private long kRY;
  private long kRf;
  private ImageView kRt;
  private TextView kRu;
  private WalletTextView kRv;
  private TextView kRw;
  private TextView kRx;
  private TextView kRy;
  private RelativeLayout kRz;
  private View kSa;
  private CollectMainUI.b kSb;
  private SpannableStringBuilder kSc;
  private SpannableStringBuilder kSd;
  private com.tencent.mm.plugin.collect.model.f kSe;
  private int kSf;
  private String kSg;
  private String kSh;
  private String kSi;
  private String kSj;
  private String kSk;
  protected CdnImageView kSl;
  protected TextView kSm;
  protected TextView kSn;
  protected ImageView kSo;
  protected ViewGroup kSp;
  protected View kSq;
  private boolean kSr;
  private int kSs;
  private bdh kSt;
  private x.a kSu;
  protected String mTrueName;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(41287);
    this.kRt = null;
    this.kRu = null;
    this.kRv = null;
    this.kRw = null;
    this.kRx = null;
    this.kRy = null;
    this.kRz = null;
    this.kRA = null;
    this.kRB = null;
    this.iLA = null;
    this.kRC = null;
    this.kRD = null;
    this.kRE = null;
    this.kPF = null;
    this.kRF = false;
    this.kRG = null;
    this.kRO = null;
    this.kRP = null;
    this.mTrueName = null;
    this.kRQ = null;
    this.kRR = null;
    this.kRT = new LinkedList();
    this.kRV = null;
    this.kRW = null;
    this.kRX = false;
    this.kSb = new CollectMainUI.b(this, (byte)0);
    this.kSf = 0;
    this.kSr = false;
    this.kSs = 0;
    this.kSu = new CollectMainUI.12(this);
    AppMethodBeat.o(41287);
  }
  
  private static bda X(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(41308);
    bda localbda = new bda();
    localbda.type = paramJSONObject.optInt("type", -1);
    localbda.url = paramJSONObject.optString("url", "");
    localbda.cyA = paramJSONObject.optString("wording", "");
    localbda.xtb = paramJSONObject.optString("waapp_username", "");
    localbda.xtc = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(41308);
    return localbda;
  }
  
  private Bitmap bU(String paramString, int paramInt)
  {
    AppMethodBeat.i(142007);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, r.Zn(), this.kSf, this.kSi, this.kSu, paramInt);
    AppMethodBeat.o(142007);
    return paramString;
  }
  
  private void bis()
  {
    AppMethodBeat.i(41295);
    getWindow().getDecorView().post(new CollectMainUI.3(this));
    AppMethodBeat.o(41295);
  }
  
  private void bit()
  {
    AppMethodBeat.i(41296);
    double d;
    if ((this.kRT != null) && (this.kRT.size() > 0))
    {
      this.kRD.setBackgroundResource(2130838410);
      this.iLA.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.kRT.size())
      {
        CollectMainUI.a locala = (CollectMainUI.a)this.kRT.get(i);
        c localc;
        if (i == this.kRT.size() - 1)
        {
          localc = new c(this, (byte)0);
          label102:
          localc.setKey(String.valueOf(i));
          String str2 = locala.elx;
          String str1 = str2;
          if (bo.isNullOrNil(str2))
          {
            str1 = str2;
            if (!bo.isNullOrNil(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.e.nE(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.eaX = locala.username;
          if (locala.status != 0) {
            break label219;
          }
          localc.setSummary(2131298459);
        }
        for (;;)
        {
          this.iLA.b(localc);
          i += 1;
          break;
          localc = new c(this);
          break label102;
          label219:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.kNS;
              localc.setSummary(com.tencent.mm.wallet_core.ui.e.e(locala.kNS, locala.cpp));
            }
            for (;;)
            {
              this.iLA.b(localc);
              break;
              localc.setSummary(2131298458);
            }
          }
          if (locala.status == 2) {
            localc.setSummary(2131298457);
          }
        }
      }
      this.iLA.notifyDataSetChanged();
      this.kRx.setText(com.tencent.mm.wallet_core.ui.e.e(d, ((CollectMainUI.a)this.kRT.get(0)).cpp));
      this.kRx.setVisibility(0);
    }
    for (;;)
    {
      if ((this.kRT != null) && (this.kRT.size() > 0))
      {
        this.kSp.setBackgroundResource(2130838411);
        this.kRA.setVisibility(0);
        if ((d > 0.0D) && (this.kRT.size() > 0))
        {
          this.kSq.setVisibility(0);
          this.kRE.setVisibility(0);
          AppMethodBeat.o(41296);
        }
      }
      else
      {
        this.kRx.setVisibility(8);
        this.kRA.setVisibility(8);
        this.kRE.setVisibility(8);
      }
      AppMethodBeat.o(41296);
      return;
      d = 0.0D;
    }
  }
  
  private void biu()
  {
    AppMethodBeat.i(41304);
    aw localaw = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    if (this.kRX) {}
    for (int i = 33;; i = 32)
    {
      if (localaw != null) {
        com.tencent.mm.plugin.report.service.h.qsU.e(13447, new Object[] { Integer.valueOf(i), localaw.wmQ, localaw.wmR, this.kRP, Double.valueOf(this.kRU), Long.valueOf(bo.aox()), Long.valueOf(localaw.wmP), localaw.wmS, localaw.wmT });
      }
      AppMethodBeat.o(41304);
      return;
    }
  }
  
  private void biv()
  {
    AppMethodBeat.i(142008);
    if (!bo.isNullOrNil(this.kSj))
    {
      this.kRM.setText(this.kSj);
      this.kRM.setOnClickListener(new CollectMainUI.10(this));
      this.kRL.setVisibility(0);
      AppMethodBeat.o(142008);
      return;
    }
    this.kRL.setVisibility(8);
    AppMethodBeat.o(142008);
  }
  
  private static bda biw()
  {
    AppMethodBeat.i(41306);
    try
    {
      g.RM();
      bda localbda = X(new JSONObject((String)g.RL().Ru().get(ac.a.yHN, "")));
      AppMethodBeat.o(41306);
      return localbda;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(41306);
    }
    return null;
  }
  
  private static List<bda> bix()
  {
    AppMethodBeat.i(41307);
    localArrayList = new ArrayList();
    try
    {
      g.RM();
      Object localObject = (String)g.RL().Ru().get(ac.a.yHP, "");
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(X(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(41307);
    }
  }
  
  private void go(boolean paramBoolean)
  {
    AppMethodBeat.i(41292);
    Object localObject;
    if ((this.kRO != null) && (!this.kRO.isRecycled()))
    {
      i = BackwardSupportUtil.b.b(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.kRP, r.Zn(), this.kSf, this.kSi, i, this.kSu, false, this.kRS);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.kRX)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.kRU * 100.0D)) });
          if (this.kRF) {
            break label632;
          }
          this.kPF = ((ScrollView)((ViewStub)findViewById(2131822915)).inflate());
          biq();
          this.kRF = true;
        }
      }
    }
    label403:
    label435:
    label462:
    label480:
    label632:
    for (int i = 250;; i = 0)
    {
      this.kPF.setVisibility(4);
      ((ImageView)this.kPF.findViewById(2131822954)).setImageBitmap(this.kRO);
      TextView localTextView1 = (TextView)this.kPF.findViewById(2131822955);
      TextView localTextView2 = (TextView)this.kPF.findViewById(2131822956);
      LinearLayout localLinearLayout1 = (LinearLayout)this.kPF.findViewById(2131822948);
      LinearLayout localLinearLayout2 = (LinearLayout)this.kPF.findViewById(2131822950);
      TextView localTextView3 = (TextView)this.kPF.findViewById(2131822952);
      TextView localTextView4 = (TextView)this.kPF.findViewById(2131822953);
      TextView localTextView5 = (TextView)this.kPF.findViewById(2131822951);
      String str1 = com.tencent.mm.wallet_core.ui.e.eZ(com.tencent.mm.wallet_core.ui.e.nE(r.Zn()), 10);
      String str2 = getTrueName();
      localObject = str1;
      if (!bo.isNullOrNil(str2)) {
        localObject = str1 + getString(2131298463, new Object[] { str2 });
      }
      if (this.kSf == 1) {
        if (!bo.isNullOrNil(this.kSh))
        {
          localTextView1.setText(this.kSh);
          localTextView2.setText(j.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          if (!this.kRX) {
            break label587;
          }
          if (bo.isNullOrNil(this.kRW)) {
            break label577;
          }
          localTextView4.setText(this.kRW);
          localTextView4.setVisibility(0);
          localTextView3.setText(bip());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.e.E(this.kRU));
          localLinearLayout2.setVisibility(0);
          al.p(new CollectMainUI.5(this, localLinearLayout1, paramBoolean), i);
          i = 1;
          if (i == 0) {
            Toast.makeText(getContext(), getString(2131298477), 1).show();
          }
        }
      }
      for (;;)
      {
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(41292);
        return;
        com.tencent.mm.plugin.report.service.h.qsU.e(11343, new Object[] { Integer.valueOf(0) });
        break;
        localTextView1.setText(j.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label403;
        localTextView1.setText(j.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label403;
        localTextView4.setVisibility(8);
        break label435;
        localLinearLayout2.setVisibility(8);
        break label462;
        i = 0;
        break label480;
        ab.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
        Toast.makeText(getContext(), getString(2131298477), 1).show();
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.collect.model.t paramt)
  {
    int k = 0;
    AppMethodBeat.i(41298);
    ab.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.cLB != 1) && (this.cLB != 0)) || ((paramt.msgType == 9) || ((this.cLB == 8) && (paramt.msgType == 26))))
    {
      if (this.jbU != null) {
        this.jbU.vibrate(50L);
      }
      if (paramt.timestamp < this.kRY)
      {
        ab.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(41298);
        return;
      }
      i = 0;
      if (i >= this.kRT.size()) {
        break label510;
      }
      if ((paramt.status != 0) || (!bo.nullAsNil(paramt.username).equals(((CollectMainUI.a)this.kRT.get(i)).username)) || (((CollectMainUI.a)this.kRT.get(i)).status != 2)) {
        break label320;
      }
      this.kRT.remove(i);
      this.kRT.add(i, new CollectMainUI.a(this, paramt));
      i = 1;
    }
    for (;;)
    {
      label209:
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        int j = k;
        Object localObject;
        if (i < this.kRT.size())
        {
          localObject = (com.tencent.mm.plugin.collect.model.t)this.kRT.get(i);
          if (paramt.timestamp > ((com.tencent.mm.plugin.collect.model.t)localObject).timestamp)
          {
            this.kRT.add(i, new CollectMainUI.a(this, paramt));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.kRT.add(new CollectMainUI.a(this, paramt));
          }
          al.d(new CollectMainUI.4(this));
          AppMethodBeat.o(41298);
          return;
          label320:
          if (paramt.cnJ.equals(((CollectMainUI.a)this.kRT.get(i)).cnJ))
          {
            ab.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramt.cnJ);
            if (((CollectMainUI.a)this.kRT.get(i)).status == 0)
            {
              ((CollectMainUI.a)this.kRT.get(i)).status = paramt.status;
              ((CollectMainUI.a)this.kRT.get(i)).kNS = paramt.kNS;
              ((CollectMainUI.a)this.kRT.get(i)).cpp = paramt.cpp;
              if (paramt.status == 1)
              {
                localObject = this.kSb;
                CollectMainUI.a locala = (CollectMainUI.a)this.kRT.get(i);
                ((CollectMainUI.b)localObject).kSL.add(locala);
              }
            }
            i = 1;
            break label209;
          }
          i += 1;
          break;
        }
        i += 1;
      }
      label510:
      i = 0;
    }
  }
  
  public final void aNW()
  {
    AppMethodBeat.i(41302);
    ab.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.h.qsU.e(13944, new Object[] { Integer.valueOf(9) });
    if (!this.kSr)
    {
      if (this.kSs == 1)
      {
        e.a locala1 = new e.a(getContext());
        e.a locala2 = locala1.avu(getString(2131298475));
        locala2.vTt.AGP.AFF = true;
        locala2.AHu = true;
        locala2.AHt = getString(2131298471);
        locala2.AHs = getString(2131298474);
        locala2.Rn(getResources().getColor(2131690322)).rI(true).a(new CollectMainUI.6(this), new CollectMainUI.7(this));
        locala1.show();
        AppMethodBeat.o(41302);
        return;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131298468), "", getString(2131298467), getString(2131296888), false, new CollectMainUI.8(this), new CollectMainUI.9(this));
      AppMethodBeat.o(41302);
      return;
    }
    ab.i("MicroMsg.CollectMainUI", "onScreenShot() realNameVerifying == true ");
    AppMethodBeat.o(41302);
  }
  
  protected void bio()
  {
    AppMethodBeat.i(41305);
    if (com.tencent.mm.plugin.collect.model.f.kMS == null) {
      com.tencent.mm.plugin.collect.model.f.kMS = new com.tencent.mm.plugin.collect.model.f();
    }
    this.kSe = com.tencent.mm.plugin.collect.model.f.kMS;
    Object localObject = this.kSe;
    g.RM();
    g.RK().eHt.a(1588, (com.tencent.mm.ai.f)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.kSe;
    CollectMainUI.11 local11 = new CollectMainUI.11(this);
    g.RM();
    String str1 = (String)g.RL().Ru().get(ac.a.yHK, "");
    g.RM();
    String str2 = (String)g.RL().Ru().get(ac.a.yHL, "");
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yHM, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (bo.isNullOrNil(str1))
    {
      ab.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = com.tencent.mm.plugin.wallet_core.model.t.cTN().cUs();
    }
    local11.y((String)localObject, str2, i);
    localObject = new l();
    localf.jFd.put(localObject, local11);
    g.RM();
    g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
    AppMethodBeat.o(41305);
  }
  
  protected String bip()
  {
    AppMethodBeat.i(41310);
    String str = com.tencent.mm.wallet_core.ui.e.avZ(this.kRV);
    AppMethodBeat.o(41310);
    return str;
  }
  
  protected void biq() {}
  
  protected void bir()
  {
    AppMethodBeat.i(41294);
    this.kRt.setImageBitmap(null);
    if (this.kRX)
    {
      if (bo.isNullOrNil(this.kRR))
      {
        ab.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(41294);
        return;
      }
      this.kRO = bU(this.kRR, this.kRS);
      if ((this.kRO == null) || (this.kRO.isRecycled())) {
        break label237;
      }
      this.kRt.setImageBitmap(this.kRO);
      label91:
      if (!this.kRX) {
        break label281;
      }
      this.kRv.setPrefix(bip());
      this.kRv.setText(com.tencent.mm.wallet_core.ui.e.E(this.kRU));
      this.kRv.setVisibility(0);
      if (bo.isNullOrNil(this.kRW)) {
        break label269;
      }
      this.kRu.setText(j.b(getContext(), this.kRW, this.kRu.getTextSize()));
      this.kRu.setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131822927).setVisibility(0);
      AppMethodBeat.o(41294);
      return;
      if (bo.isNullOrNil(this.kRP))
      {
        ab.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(41294);
        return;
      }
      this.kRO = bU(this.kRP, this.kRS);
      break;
      label237:
      ab.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bo.nullAsNil(this.kRR));
      break label91;
      label269:
      this.kRu.setVisibility(8);
    }
    label281:
    this.kRw.setVisibility(8);
    this.kRv.setVisibility(8);
    this.kRu.setVisibility(8);
    findViewById(2131822927).setVisibility(8);
    AppMethodBeat.o(41294);
  }
  
  protected final void bn(List<bda> paramList)
  {
    AppMethodBeat.i(41311);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        bda localbda = (bda)localIterator.next();
        if (localbda.type == 1) {
          com.tencent.mm.plugin.report.service.h.qsU.e(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localbda.cyA, "", "", "", Integer.valueOf(1) });
        } else if (localbda.type == 2) {
          com.tencent.mm.plugin.report.service.h.qsU.e(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localbda.cyA, "", "", localbda.url, Integer.valueOf(1) });
        } else if (localbda.type == 3) {
          com.tencent.mm.plugin.report.service.h.qsU.e(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localbda.cyA, localbda.xtb, localbda.xtc, "", Integer.valueOf(1) });
        }
      }
    }
    this.kRN.setOnClickListener(new CollectMainUI.14(this, paramList));
    AppMethodBeat.o(41311);
  }
  
  public boolean e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(41303);
    super.finish();
    overridePendingTransition(2131034262, 2131034267);
    AppMethodBeat.o(41303);
  }
  
  public int getHeaderResourceId()
  {
    return 2130969180;
  }
  
  public int getLayoutId()
  {
    return 2130969178;
  }
  
  public int getResourceId()
  {
    return 2131165200;
  }
  
  protected String getTrueName()
  {
    AppMethodBeat.i(41309);
    if (bo.isNullOrNil(this.mTrueName))
    {
      this.mTrueName = com.tencent.mm.plugin.wallet_core.model.t.cTN().getTrueName();
      this.mTrueName = com.tencent.mm.wallet_core.ui.e.awc(this.mTrueName);
    }
    String str = this.mTrueName;
    AppMethodBeat.o(41309);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41291);
    setMMTitle(2131302001);
    setBackBtn(new CollectMainUI.15(this));
    this.iLA = getPreferenceScreen();
    this.kRz = ((RelativeLayout)findViewById(2131821003));
    this.kRA = findViewById(2131822943);
    this.kSq = findViewById(2131822944);
    this.kRv = ((WalletTextView)findViewById(2131822930));
    this.kRu = ((TextView)findViewById(2131822931));
    this.kRw = ((TextView)findViewById(2131822929));
    this.kRx = ((TextView)findViewById(2131822945));
    this.kRL = ((LinearLayout)findViewById(2131822916));
    this.kRM = ((TextView)findViewById(2131821672));
    this.kRD = ((RelativeLayout)findViewById(2131822922));
    this.kRE = findViewById(2131822946);
    this.kSa = LayoutInflater.from(this).inflate(2130969179, null, false);
    this.kRy = ((TextView)findViewById(2131822936));
    Object localObject = new SpannableStringBuilder(getString(2131298464));
    ((SpannableStringBuilder)localObject).setSpan(new o(new CollectMainUI.16(this)), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.kRy.setText((CharSequence)localObject);
    this.kRy.setClickable(true);
    this.kRy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    getListView().addFooterView(this.kSa, null, false);
    getListView().setFooterDividersEnabled(false);
    this.kRt = ((ImageView)findViewById(2131822933));
    this.kRB = ((TextView)findViewById(2131822925));
    this.kRK = ((TextView)findViewById(2131822935));
    this.kRK.setClickable(true);
    this.kRK.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.kSc = new SpannableStringBuilder(getString(2131298452));
    this.kSd = new SpannableStringBuilder(getString(2131298453));
    localObject = new o(new CollectMainUI.17(this));
    o localo = new o(new CollectMainUI.18(this));
    this.kSc.setSpan(localObject, 0, this.kSc.length(), 18);
    if (a.a.dDt().dDs()) {
      this.kRK.setOnClickListener(new CollectMainUI.19(this, (o)localObject, localo));
    }
    this.kSd.setSpan(localo, 0, this.kSd.length(), 18);
    this.kRK.setText(this.kSc);
    this.kRN = ((RelativeLayout)findViewById(2131822924));
    this.kRt.setOnLongClickListener(new CollectMainUI.20(this));
    this.kRG = findViewById(2131822917);
    this.kRH = ((ImageView)findViewById(2131822918));
    this.kRI = ((TextView)findViewById(2131822919));
    this.kRJ = ((TextView)findViewById(2131822920));
    this.kSl = ((CdnImageView)findViewById(2131822939));
    this.kSm = ((TextView)findViewById(2131822940));
    this.kSn = ((TextView)findViewById(2131822941));
    this.kSo = ((ImageView)findViewById(2131822942));
    this.kSp = ((ViewGroup)findViewById(2131822938));
    this.kRD.postDelayed(new CollectMainUI.21(this), 300L);
    localObject = new vd();
    ((vd)localObject).cLE.bSd = "8";
    ((vd)localObject).callback = new CollectMainUI.2(this, (vd)localObject);
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(41291);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41299);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41299);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.kRR = paramIntent.getStringExtra("ftf_pay_url");
        this.kRS = paramIntent.getIntExtra("key_error_level", -1);
        this.kRU = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.kRV = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.kRW = paramIntent.getStringExtra("ftf_fixed_desc");
        this.kRQ = paramIntent.getStringExtra("key_currency_unit");
        this.kRK.setText(this.kSd);
      }
      for (this.kRX = true;; this.kRX = false)
      {
        refreshView();
        bis();
        AppMethodBeat.o(41299);
        return;
      }
      this.kRf = r.Zs();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41288);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    if (paramBundle.screenBrightness < 0.85F)
    {
      paramBundle.screenBrightness = 0.85F;
      getWindow().setAttributes(paramBundle);
    }
    setIsDarkActionbarBg(true);
    hideActionbarLine();
    g.RM();
    this.cLB = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
    this.kRf = r.Zs();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.h.qsU.e(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(2131034266, 2131034263);
    com.tencent.mm.plugin.collect.a.a.bhw();
    paramBundle = com.tencent.mm.plugin.collect.a.a.bhx();
    if (!paramBundle.kkV.contains(this)) {
      paramBundle.kkV.add(this);
    }
    initView();
    bio();
    refreshView();
    this.jbU = ((Vibrator)getSystemService("vibrator"));
    this.kRY = bo.aox();
    if (kSv < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      kSv = paramBundle.widthPixels / 2 - BackwardSupportUtil.b.b(getContext(), 20.0F);
      kSw = BackwardSupportUtil.b.b(getContext(), 60.0F);
      kSx = BackwardSupportUtil.b.b(getContext(), 40.0F);
      kSy = BackwardSupportUtil.b.b(getContext(), 70.0F);
    }
    bis();
    com.tencent.mm.wallet_core.c.z.id(16, 0);
    AppMethodBeat.o(41288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41290);
    if (this.kRt != null) {
      this.kRt.setImageBitmap(null);
    }
    Object localObject = this.kRO;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ab.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.kRC != null) {
      this.kRC.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.bhw();
    com.tencent.mm.plugin.collect.a.a.bhx().kkV.remove(this);
    this.jbU.cancel();
    if (this.kSe != null)
    {
      localObject = this.kSe;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).jFd.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ab.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        g.RM();
        g.RK().eHt.a((com.tencent.mm.ai.m)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).jFd.clear();
      g.RM();
      g.RK().eHt.b(1588, (com.tencent.mm.ai.f)localObject);
    }
    x.c(this.kSu);
    super.onDestroy();
    AppMethodBeat.o(41290);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41301);
    super.onPause();
    bc.a(this, null);
    AppMethodBeat.o(41301);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41300);
    super.onResume();
    bc.a(this, this);
    AppMethodBeat.o(41300);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(41293);
    if (bo.isNullOrNil(this.kRP))
    {
      ab.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(41293);
      return;
    }
    if (this.kSf == 1)
    {
      if (!bo.isNullOrNil(this.kSg)) {
        this.kRB.setText(this.kSg);
      }
      if (!bo.isNullOrNil(this.kSh))
      {
        TextView localTextView = (TextView)findViewById(2131822926);
        localTextView.setText(this.kSh);
        localTextView.setVisibility(0);
      }
    }
    bir();
    bit();
    biu();
    biv();
    AppMethodBeat.o(41293);
  }
  
  public final void setStatusColor()
  {
    AppMethodBeat.i(41289);
    setActionbarColor(getResources().getColor(2131689533));
    AppMethodBeat.o(41289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */