package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.f.a;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
  implements com.tencent.mm.ak.f, d.a, bi.a
{
  private static int plM;
  private static int pmq = -1;
  private static int pmr = -1;
  private static int pms = -1;
  private static int pmt = -1;
  private int dNN;
  private com.tencent.mm.ui.base.preference.f mEx;
  protected String mTrueName;
  private Vibrator mZD;
  private TextView mpP;
  private long nLI;
  private com.tencent.mm.ui.widget.a.e nMW;
  protected ScrollView pjp;
  private long pkQ;
  protected TextView plA;
  private RelativeLayout plB;
  private Bitmap plC;
  protected String plD;
  protected String plE;
  private String plF;
  private int plG;
  private List<a> plH;
  private double plI;
  private String plJ;
  private String plK;
  protected boolean plL;
  private View plN;
  private b plO;
  private SpannableStringBuilder plP;
  private SpannableStringBuilder plQ;
  private com.tencent.mm.plugin.collect.model.f plR;
  private int plS;
  private String plT;
  private String plU;
  private String plV;
  private String plW;
  private String plX;
  protected CdnImageView plY;
  protected TextView plZ;
  private int plf;
  private int plg;
  private com.tencent.mm.ui.widget.a.g plh;
  private ImageView pli;
  private TextView plj;
  private WalletTextView plk;
  private TextView pll;
  private TextView plm;
  private TextView pln;
  private RelativeLayout plo;
  private View plp;
  private Dialog plq;
  private View plr;
  private View pls;
  private boolean plt;
  private View plu;
  private ImageView plv;
  private TextView plw;
  private TextView plx;
  private TextView ply;
  protected LinearLayout plz;
  protected TextView pma;
  protected ImageView pmb;
  protected ViewGroup pmc;
  protected View pmd;
  private boolean pme;
  private int pmf;
  private bzx pmg;
  private cop pmh;
  private cop pmi;
  private cop pmj;
  private LinearLayout pmk;
  private TextView pml;
  private TextView pmm;
  private TextView pmn;
  private com.tencent.mm.bw.b pmo;
  private u.a pmp;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(64149);
    this.pli = null;
    this.plj = null;
    this.plk = null;
    this.pll = null;
    this.plm = null;
    this.pln = null;
    this.plo = null;
    this.plp = null;
    this.mpP = null;
    this.mEx = null;
    this.plq = null;
    this.plr = null;
    this.pls = null;
    this.pjp = null;
    this.plt = false;
    this.plu = null;
    this.plC = null;
    this.plD = null;
    this.mTrueName = null;
    this.plE = null;
    this.plF = null;
    this.plH = new LinkedList();
    this.plJ = null;
    this.plK = null;
    this.plL = false;
    this.plO = new b((byte)0);
    this.plS = 0;
    this.pme = false;
    this.pmf = 0;
    this.pmp = new u.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(64125);
        if ((paramAnonymousString == null) || (CollectMainUI.a(CollectMainUI.this) == null))
        {
          AppMethodBeat.o(64125);
          return;
        }
        if (paramAnonymousString.equals(CollectMainUI.a(CollectMainUI.this)))
        {
          ae.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(CollectMainUI.this), paramAnonymousString });
          CollectMainUI.this.ccw();
        }
        AppMethodBeat.o(64125);
      }
    };
    AppMethodBeat.o(64149);
  }
  
  private void Bw(int paramInt)
  {
    AppMethodBeat.i(189807);
    int i = ccE();
    Object localObject = ccF();
    String str = ccG();
    ae.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str, this.pmo });
    localObject = new m(paramInt, i, (String)localObject, str, this.pmo);
    com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(189807);
  }
  
  private void a(final abu paramabu)
  {
    AppMethodBeat.i(189811);
    if (paramabu == null)
    {
      ae.i("MicroMsg.CollectMainUI", " coverInfo == null");
      AppMethodBeat.o(189811);
      return;
    }
    ae.i("MicroMsg.CollectMainUI", "showCoverUI");
    this.pmk.setVisibility(0);
    this.pmk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64129);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64129);
      }
    });
    ViewGroup.LayoutParams localLayoutParams = this.pmk.getLayoutParams();
    localLayoutParams.height = this.plr.getHeight();
    this.pmk.setLayoutParams(localLayoutParams);
    this.pml.setText(paramabu.dyI);
    this.pmm.setText(paramabu.GtN.dyI);
    this.pmm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(189797);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramabu.GtN);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189797);
      }
    });
    this.pmn.setText(paramabu.GtO.dyI);
    this.pmn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(189798);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramabu.GtO);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189798);
      }
    });
    AppMethodBeat.o(189811);
  }
  
  private void a(boa paramboa)
  {
    AppMethodBeat.i(189810);
    if ((paramboa == null) || ((this.plh != null) && (this.plh.isShowing())))
    {
      ae.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
      AppMethodBeat.o(189810);
      return;
    }
    if ((this.nMW != null) && (this.nMW.isShowing()))
    {
      ae.i("MicroMsg.CollectMainUI", "mBottomSheet != null && mBottomSheet.isShowing()");
      AppMethodBeat.o(189810);
      return;
    }
    ae.i("MicroMsg.CollectMainUI", "showHalfDialog");
    Object localObject1 = paramboa.HaV;
    Object localObject2 = paramboa.HaW;
    this.plf = 4;
    this.plh = new com.tencent.mm.ui.widget.a.g(getContext(), 1, 3);
    this.plh.c(((coq)localObject1).dyI, ((coq)localObject2).dyI);
    this.plh.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(189795);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.pmD);
        CollectMainUI.C(CollectMainUI.this).bqD();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(189795);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(189796);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.pmE);
        CollectMainUI.C(CollectMainUI.this).bqD();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(189796);
      }
    });
    if (paramboa.HaU.type == 2)
    {
      localObject1 = View.inflate(getContext(), 2131496149, null);
      ((ImageView)((View)localObject1).findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64126);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          CollectMainUI.C(CollectMainUI.this).bqD();
          CollectMainUI.D(CollectMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64126);
        }
      });
      localObject2 = (TextView)((View)localObject1).findViewById(2131307175);
      ((TextView)localObject2).setText(paramboa.HaU.HVc);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.plh.setHeaderView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = View.inflate(getContext(), 2131496147, null);
      ((TextView)((View)localObject1).findViewById(2131300674)).setText(paramboa.dyI);
      this.plh.setCustomView((View)localObject1);
      this.plh.cPF();
      AppMethodBeat.o(189810);
      return;
      localObject1 = View.inflate(getContext(), 2131496148, null);
      localObject2 = (TextView)((View)localObject1).findViewById(2131300675);
      ((TextView)localObject2).setText(paramboa.HaU.HVc);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.plh.setHeaderView((View)localObject1);
    }
  }
  
  private void a(cop paramcop)
  {
    AppMethodBeat.i(189809);
    if (paramcop == null)
    {
      ae.i("MicroMsg.CollectMainUI", "actionInfo is null");
      AppMethodBeat.o(189809);
      return;
    }
    ae.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", new Object[] { Integer.valueOf(paramcop.oGc) });
    switch (paramcop.oGc)
    {
    default: 
      ae.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
      AppMethodBeat.o(189809);
      return;
    case 0: 
      AppMethodBeat.o(189809);
      return;
    case 1: 
      a(paramcop.HAv);
      AppMethodBeat.o(189809);
      return;
    case 2: 
      a(paramcop.HAw);
      AppMethodBeat.o(189809);
      return;
    }
    a(paramcop.HAx);
    AppMethodBeat.o(189809);
  }
  
  private void a(final cop paramcop, final abu paramabu)
  {
    AppMethodBeat.i(189813);
    ae.i("MicroMsg.CollectMainUI", "doSaveQrCode");
    Object localObject;
    if ((this.plC != null) && (!this.plC.isRecycled()))
    {
      i = BackwardSupportUtil.b.h(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.plD, v.aAC(), this.plS, this.plV, i, this.pmp, false, this.plG, 0.0F, true);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.plL)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.plI * 100.0D)) });
          if (this.plt) {
            break label661;
          }
          this.pjp = ((ScrollView)((ViewStub)findViewById(2131298476)).inflate());
          ccv();
          this.plt = true;
        }
      }
    }
    label661:
    for (int i = 250;; i = 0)
    {
      this.pjp.setVisibility(4);
      ((ImageView)this.pjp.findViewById(2131298470)).setImageBitmap(this.plC);
      TextView localTextView1 = (TextView)this.pjp.findViewById(2131298472);
      TextView localTextView2 = (TextView)this.pjp.findViewById(2131298473);
      final LinearLayout localLinearLayout1 = (LinearLayout)this.pjp.findViewById(2131298488);
      LinearLayout localLinearLayout2 = (LinearLayout)this.pjp.findViewById(2131298469);
      TextView localTextView3 = (TextView)this.pjp.findViewById(2131298466);
      TextView localTextView4 = (TextView)this.pjp.findViewById(2131298467);
      TextView localTextView5 = (TextView)this.pjp.findViewById(2131298468);
      String str1 = com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(v.aAC()), 10);
      String str2 = getTrueName();
      localObject = str1;
      if (!bu.isNullOrNil(str2)) {
        localObject = str1 + getString(2131757475, new Object[] { str2 });
      }
      if (this.plS == 1) {
        if (!bu.isNullOrNil(this.plU))
        {
          localTextView1.setText(this.plU);
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          label420:
          if (!this.plL) {
            break label616;
          }
          if (bu.isNullOrNil(this.plK)) {
            break label606;
          }
          localTextView4.setText(this.plK);
          localTextView4.setVisibility(0);
          label452:
          localTextView3.setText(ccu());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.f.C(this.plI));
          localLinearLayout2.setVisibility(0);
          label479:
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64117);
              ae.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(localLinearLayout1.getHeight()), Integer.valueOf(localLinearLayout1.getWidth()) });
              Bitmap localBitmap = Bitmap.createBitmap(localLinearLayout1.getWidth(), localLinearLayout1.getHeight(), Bitmap.Config.ARGB_8888);
              Object localObject = new Canvas(localBitmap);
              localLinearLayout1.draw((Canvas)localObject);
              try
              {
                localObject = com.tencent.mm.pluginsdk.ui.tools.q.fje() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                com.tencent.mm.sdk.platformtools.h.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
                if (this.pmx)
                {
                  ae.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
                  CollectMainUI.a(CollectMainUI.this, CollectMainUI.this.getContext(), CollectMainUI.this.getContext().getResources().getString(2131760299), paramcop, paramabu);
                }
                com.tencent.mm.pluginsdk.ui.tools.q.k((String)localObject, CollectMainUI.this.getContext());
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ae.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
                }
              }
              CollectMainUI.this.pjp.setVisibility(8);
              AppMethodBeat.o(64117);
            }
          }, i);
          i = 1;
          label498:
          if (i == 0)
          {
            ae.w("MicroMsg.CollectMainUI", "save ftf pay qrcode fail");
            Toast.makeText(getContext(), getString(2131757489), 1).show();
          }
        }
      }
      for (;;)
      {
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(189813);
        return;
        com.tencent.mm.plugin.report.service.g.yxI.f(11343, new Object[] { Integer.valueOf(0) });
        break;
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label420;
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label420;
        label606:
        localTextView4.setVisibility(8);
        break label452;
        label616:
        localLinearLayout2.setVisibility(8);
        break label479;
        i = 0;
        break label498;
        ae.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
        Toast.makeText(getContext(), getString(2131757489), 1).show();
      }
    }
  }
  
  private void a(final pr parampr)
  {
    AppMethodBeat.i(189812);
    if (parampr == null)
    {
      ae.i("MicroMsg.CollectMainUI", " bottomCell == null");
      AppMethodBeat.o(189812);
      return;
    }
    this.plf = 3;
    this.nMW = new com.tencent.mm.ui.widget.a.e(getContext(), 1, true);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 56));
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(getResources().getColor(2131099734));
    localTextView.setText(parampr.Gdh);
    this.nMW.P(localTextView, false);
    this.nMW.Ltw = true;
    this.nMW.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(189799);
        Iterator localIterator = parampr.Gdi.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          coq localcoq = (coq)localIterator.next();
          if ((localcoq != null) && (localcoq.dyI != null))
          {
            paramAnonymousl.d(i, localcoq.dyI);
            i += 1;
          }
        }
        AppMethodBeat.o(189799);
      }
    };
    this.nMW.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(189800);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        paramAnonymousMenuItem = (coq)parampr.Gdi.get(paramAnonymousInt);
        CollectMainUI.d(CollectMainUI.this, 2);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousMenuItem);
        AppMethodBeat.o(189800);
      }
    };
    this.nMW.cPF();
    AppMethodBeat.o(189812);
  }
  
  private static bzq aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64171);
    bzq localbzq = new bzq();
    localbzq.type = paramJSONObject.optInt("type", -1);
    localbzq.url = paramJSONObject.optString("url", "");
    localbzq.dyI = paramJSONObject.optString("wording", "");
    localbzq.HnB = paramJSONObject.optString("waapp_username", "");
    localbzq.HnC = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(64171);
    return localbzq;
  }
  
  private Bitmap cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(64159);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, v.aAC(), this.plS, this.plV, this.pmp, paramInt);
    AppMethodBeat.o(64159);
    return paramString;
  }
  
  private void ccA()
  {
    AppMethodBeat.i(64166);
    bb localbb = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    if (this.plL) {}
    for (int i = 33;; i = 32)
    {
      if (localbb != null) {
        com.tencent.mm.plugin.report.service.g.yxI.f(13447, new Object[] { Integer.valueOf(i), localbb.FLd, localbb.FLe, this.plD, Double.valueOf(this.plI), Long.valueOf(bu.aRi()), Long.valueOf(localbb.FLc), localbb.FLf, localbb.FLg });
      }
      AppMethodBeat.o(64166);
      return;
    }
  }
  
  private void ccB()
  {
    AppMethodBeat.i(64167);
    if (!bu.isNullOrNil(this.plW))
    {
      this.plA.setText(this.plW);
      this.plA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189787);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!bu.isNullOrNil(CollectMainUI.v(CollectMainUI.this))) {
            com.tencent.mm.wallet_core.ui.f.p(ak.getContext(), CollectMainUI.v(CollectMainUI.this), true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189787);
        }
      });
      this.plz.setVisibility(0);
      AppMethodBeat.o(64167);
      return;
    }
    this.plz.setVisibility(8);
    AppMethodBeat.o(64167);
  }
  
  private static bzq ccC()
  {
    AppMethodBeat.i(64169);
    try
    {
      com.tencent.mm.kernel.g.ajS();
      bzq localbzq = aq(new JSONObject((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVq, "")));
      AppMethodBeat.o(64169);
      return localbzq;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64169);
    }
    return null;
  }
  
  private static List<bzq> ccD()
  {
    AppMethodBeat.i(64170);
    localArrayList = new ArrayList();
    try
    {
      com.tencent.mm.kernel.g.ajS();
      Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVs, "");
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(aq(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64170);
    }
  }
  
  private int ccE()
  {
    AppMethodBeat.i(189804);
    if ((this.plk.isShown()) && (!bu.ah(this.plk.getText())))
    {
      int i = Integer.parseInt(com.tencent.mm.wallet_core.ui.f.c(this.plk.getText(), "100", 0, RoundingMode.HALF_UP).toString());
      AppMethodBeat.o(189804);
      return i;
    }
    AppMethodBeat.o(189804);
    return 0;
  }
  
  private String ccF()
  {
    AppMethodBeat.i(189805);
    if ((this.plj.isShown()) && (!bu.ah(this.plj.getText())))
    {
      String str = this.plj.getText().toString();
      AppMethodBeat.o(189805);
      return str;
    }
    AppMethodBeat.o(189805);
    return "";
  }
  
  private String ccG()
  {
    AppMethodBeat.i(189806);
    if (this.plL)
    {
      if (bu.isNullOrNil(this.plF))
      {
        ae.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(189806);
        return "";
      }
      str = this.plF;
      AppMethodBeat.o(189806);
      return str;
    }
    if (bu.isNullOrNil(this.plD))
    {
      ae.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
      AppMethodBeat.o(189806);
      return "";
    }
    String str = this.plD;
    AppMethodBeat.o(189806);
    return str;
  }
  
  private void ccy()
  {
    AppMethodBeat.i(64157);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64115);
        int i = com.tencent.mm.cb.a.fromDPToPix(CollectMainUI.this.getContext(), 37);
        ViewGroup.LayoutParams localLayoutParams = CollectMainUI.m(CollectMainUI.this).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = i;
          CollectMainUI.m(CollectMainUI.this).setLayoutParams(localLayoutParams);
          CollectMainUI.m(CollectMainUI.this).requestLayout();
        }
        AppMethodBeat.o(64115);
      }
    });
    AppMethodBeat.o(64157);
  }
  
  private void ccz()
  {
    AppMethodBeat.i(64158);
    double d;
    if ((this.plH != null) && (this.plH.size() > 0))
    {
      this.plr.setBackgroundResource(2131231783);
      this.mEx.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.plH.size())
      {
        a locala = (a)this.plH.get(i);
        c localc;
        if (i == this.plH.size() - 1)
        {
          localc = new c(this, (byte)0);
          label102:
          localc.setKey(String.valueOf(i));
          String str2 = locala.fXp;
          String str1 = str2;
          if (bu.isNullOrNil(str2))
          {
            str1 = str2;
            if (!bu.isNullOrNil(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.f.zP(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.fIQ = locala.username;
          if (locala.status != 0) {
            break label219;
          }
          localc.setSummary(2131757471);
        }
        for (;;)
        {
          this.mEx.b(localc);
          i += 1;
          break;
          localc = new c(this);
          break label102;
          label219:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.phz;
              localc.setSummary(com.tencent.mm.wallet_core.ui.f.d(locala.phz, locala.dog));
            }
            for (;;)
            {
              this.mEx.b(localc);
              break;
              localc.setSummary(2131757470);
            }
          }
          if (locala.status == 2) {
            localc.setSummary(2131757469);
          }
        }
      }
      this.mEx.notifyDataSetChanged();
      this.plm.setText(com.tencent.mm.wallet_core.ui.f.d(d, ((a)this.plH.get(0)).dog));
      this.plm.setVisibility(0);
    }
    for (;;)
    {
      if ((this.plH != null) && (this.plH.size() > 0))
      {
        this.pmc.setBackgroundResource(2131231784);
        this.plp.setVisibility(0);
        if ((d > 0.0D) && (this.plH.size() > 0))
        {
          this.pmd.setVisibility(0);
          this.pls.setVisibility(0);
          AppMethodBeat.o(64158);
        }
      }
      else
      {
        this.plm.setVisibility(8);
        this.plp.setVisibility(8);
        this.pls.setVisibility(8);
      }
      AppMethodBeat.o(64158);
      return;
      d = 0.0D;
    }
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(189803);
    ae.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.g.yxI.f(13944, new Object[] { Integer.valueOf(9) });
    if (this.pmh != null) {
      com.tencent.mm.plugin.report.service.g.yxI.f(20032, new Object[] { "wxface2face", "ScreenShot", "", "", "", "", Integer.valueOf(1), Integer.valueOf(this.pmh.oGc), Integer.valueOf(0), ccG(), Integer.valueOf(ccE()), ccF() });
    }
    a(this.pmh);
    Bw(1);
    AppMethodBeat.o(189803);
  }
  
  public final void a(com.tencent.mm.plugin.collect.model.u paramu)
  {
    int k = 0;
    AppMethodBeat.i(64160);
    ae.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.dNN != 1) && (this.dNN != 0)) || ((paramu.msgType == 9) || ((this.dNN == 8) && (paramu.msgType == 26))))
    {
      if (this.mZD != null) {
        this.mZD.vibrate(50L);
      }
      if (paramu.phB < this.nLI)
      {
        ae.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(64160);
        return;
      }
      i = 0;
      if (i >= this.plH.size()) {
        break label510;
      }
      if ((paramu.status != 0) || (!bu.nullAsNil(paramu.username).equals(((a)this.plH.get(i)).username)) || (((a)this.plH.get(i)).status != 2)) {
        break label320;
      }
      this.plH.remove(i);
      this.plH.add(i, new a(paramu));
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
        if (i < this.plH.size())
        {
          localObject = (com.tencent.mm.plugin.collect.model.u)this.plH.get(i);
          if (paramu.phB > ((com.tencent.mm.plugin.collect.model.u)localObject).phB)
          {
            this.plH.add(i, new a(paramu));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.plH.add(new a(paramu));
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64116);
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.o(CollectMainUI.this).ccN();
              CollectMainUI.i(CollectMainUI.this);
              AppMethodBeat.o(64116);
            }
          });
          AppMethodBeat.o(64160);
          return;
          label320:
          if (paramu.dmx.equals(((a)this.plH.get(i)).dmx))
          {
            ae.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramu.dmx);
            if (((a)this.plH.get(i)).status == 0)
            {
              ((a)this.plH.get(i)).status = paramu.status;
              ((a)this.plH.get(i)).phz = paramu.phz;
              ((a)this.plH.get(i)).dog = paramu.dog;
              if (paramu.status == 1)
              {
                localObject = this.plO;
                a locala = (a)this.plH.get(i);
                ((b)localObject).pmJ.add(locala);
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
  
  protected final void cP(final List<bzq> paramList)
  {
    AppMethodBeat.i(64174);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        bzq localbzq = (bzq)localIterator.next();
        if (localbzq.type == 1) {
          com.tencent.mm.plugin.report.service.g.yxI.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localbzq.dyI, "", "", "", Integer.valueOf(1) });
        } else if (localbzq.type == 2) {
          com.tencent.mm.plugin.report.service.g.yxI.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localbzq.dyI, "", "", localbzq.url, Integer.valueOf(1) });
        } else if (localbzq.type == 3) {
          com.tencent.mm.plugin.report.service.g.yxI.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localbzq.dyI, localbzq.HnB, localbzq.HnC, "", Integer.valueOf(1) });
        }
      }
    }
    this.plB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(189794);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(CollectMainUI.this.getContext(), 1, false);
        paramAnonymousView.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(189792);
            com.tencent.mm.plugin.collect.a.a.cbv();
            if (com.tencent.mm.plugin.collect.a.a.cbx()) {
              paramAnonymous2l.add(0, 1, 0, 2131757457);
            }
            while (CollectMainUI.9.this.jon != null)
            {
              int i = 0;
              while (i < CollectMainUI.9.this.jon.size())
              {
                bzq localbzq = (bzq)CollectMainUI.9.this.jon.get(i);
                if (!bu.isNullOrNil(localbzq.dyI)) {
                  paramAnonymous2l.add(0, i + 1 + 1, 0, localbzq.dyI);
                }
                i += 1;
              }
              paramAnonymous2l.add(0, 1, 0, 2131757467);
            }
            AppMethodBeat.o(189792);
          }
        };
        paramAnonymousView.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(189793);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId() - 1 - 1;
              if (paramAnonymous2Int < 0)
              {
                ae.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                AppMethodBeat.o(189793);
                return;
              }
              break;
            case 1: 
              com.tencent.mm.plugin.collect.a.a.cbv();
              if (com.tencent.mm.plugin.collect.a.a.cbx())
              {
                CollectMainUI.A(CollectMainUI.this);
                Toast.makeText(CollectMainUI.this.getContext(), 2131757458, 1).show();
                com.tencent.mm.plugin.report.service.g.yxI.f(13944, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(189793);
                return;
              }
              CollectMainUI.B(CollectMainUI.this);
              Toast.makeText(CollectMainUI.this.getContext(), 2131757468, 1).show();
              com.tencent.mm.plugin.collect.model.voice.a.cbM().jK(false);
              com.tencent.mm.plugin.report.service.g.yxI.f(13944, new Object[] { Integer.valueOf(7) });
              AppMethodBeat.o(189793);
              return;
            }
            paramAnonymous2MenuItem = (bzq)CollectMainUI.9.this.jon.get(paramAnonymous2Int);
            if (paramAnonymous2MenuItem.type == 1)
            {
              ae.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramAnonymous2MenuItem.url });
              com.tencent.mm.plugin.report.service.g.yxI.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2MenuItem.dyI, "", "", "", Integer.valueOf(2) });
              AppMethodBeat.o(189793);
              return;
            }
            if (paramAnonymous2MenuItem.type == 2)
            {
              if (!bu.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                com.tencent.mm.wallet_core.ui.f.p(CollectMainUI.this.getContext(), paramAnonymous2MenuItem.url, false);
                com.tencent.mm.plugin.report.service.g.yxI.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramAnonymous2MenuItem.dyI, "", "", paramAnonymous2MenuItem.url, Integer.valueOf(2) });
                AppMethodBeat.o(189793);
              }
            }
            else if (paramAnonymous2MenuItem.type == 3)
            {
              vq localvq = new vq();
              localvq.dKT.userName = paramAnonymous2MenuItem.HnB;
              localvq.dKT.dKV = bu.bI(paramAnonymous2MenuItem.HnC, "");
              localvq.dKT.scene = 1072;
              localvq.dKT.dKW = 0;
              com.tencent.mm.sdk.b.a.IvT.l(localvq);
              com.tencent.mm.plugin.report.service.g.yxI.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramAnonymous2MenuItem.dyI, paramAnonymous2MenuItem.HnB, paramAnonymous2MenuItem.HnC, "", Integer.valueOf(2) });
            }
            AppMethodBeat.o(189793);
          }
        };
        paramAnonymousView.cPF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189794);
      }
    });
    AppMethodBeat.o(64174);
  }
  
  protected void cct()
  {
    AppMethodBeat.i(64168);
    if (com.tencent.mm.plugin.collect.model.f.pgx == null) {
      com.tencent.mm.plugin.collect.model.f.pgx = new com.tencent.mm.plugin.collect.model.f();
    }
    this.plR = com.tencent.mm.plugin.collect.model.f.pgx;
    Object localObject = this.plR;
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1588, (com.tencent.mm.ak.f)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.plR;
    f.a local7 = new f.a()
    {
      public final void K(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        AppMethodBeat.i(189789);
        ae.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt) });
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.this.plD = paramAnonymousString1;
        CollectMainUI.a(CollectMainUI.this, paramAnonymousInt);
        CollectMainUI.this.mTrueName = paramAnonymousString2;
        paramAnonymousString1 = CollectMainUI.ccL();
        paramAnonymousString2 = CollectMainUI.ccM();
        CollectMainUI.a(CollectMainUI.this, paramAnonymousString1);
        CollectMainUI.this.cP(paramAnonymousString2);
        if (CollectMainUI.x(CollectMainUI.this) == 1)
        {
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.ajS();
          CollectMainUI.b(paramAnonymousString1, ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWc, Integer.valueOf(-1))).intValue());
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.ajS();
          CollectMainUI.a(paramAnonymousString1, (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWd, ""));
        }
        AppMethodBeat.o(189789);
      }
      
      public final void a(boolean paramAnonymousBoolean, uo paramAnonymousuo)
      {
        AppMethodBeat.i(189790);
        Object localObject;
        if (paramAnonymousuo == null)
        {
          localObject = "null";
          ae.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), localObject });
          if (!paramAnonymousBoolean) {
            break label499;
          }
          if ((paramAnonymousuo == null) || (paramAnonymousuo.dmy != 416)) {
            break label189;
          }
          if (paramAnonymousuo.Gmp != null) {
            break label184;
          }
        }
        label184:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ae.d("MicroMsg.CollectMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectMainUI.w(CollectMainUI.this).setVisibility(4);
          CollectMainUI.a(CollectMainUI.this, true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
          ((Bundle)localObject).putString("realname_verify_process_jump_plugin", "collect");
          CollectMainUI localCollectMainUI = CollectMainUI.this;
          int i = paramAnonymousuo.dmy;
          paramAnonymousuo = paramAnonymousuo.Gmp;
          new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(189788);
              ae.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
              AppMethodBeat.o(189788);
            }
          };
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localCollectMainUI, i, paramAnonymousuo, (Bundle)localObject, 1010);
          AppMethodBeat.o(189790);
          return;
          localObject = Integer.valueOf(paramAnonymousuo.dmy);
          break;
        }
        label189:
        CollectMainUI.this.ccx();
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.a(CollectMainUI.this, false);
        CollectMainUI.this.plD = paramAnonymousuo.url;
        CollectMainUI.a(CollectMainUI.this, ag.agX(paramAnonymousuo.Gmb));
        CollectMainUI.this.mTrueName = paramAnonymousuo.DkG;
        CollectMainUI.b(CollectMainUI.this, paramAnonymousuo.yoP);
        CollectMainUI.b(CollectMainUI.this, paramAnonymousuo.yoQ);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousuo.yoR);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousuo.Gmm);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousuo.iWA);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousuo.iWB);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousuo.Gmj);
        CollectMainUI.this.cP(paramAnonymousuo.Gmi);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousuo.Gmn);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousuo.Gmo);
        ae.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.y(CollectMainUI.this)) });
        CollectMainUI.c(CollectMainUI.this, paramAnonymousuo.Gmt);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousuo.Gmu);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousuo.Gmv);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousuo.Gmw);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWc, Integer.valueOf(CollectMainUI.z(CollectMainUI.this)));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWd, CollectMainUI.a(CollectMainUI.this));
        CollectMainUI.this.refreshView();
        label499:
        AppMethodBeat.o(189790);
      }
    };
    com.tencent.mm.kernel.g.ajS();
    String str1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVn, "");
    com.tencent.mm.kernel.g.ajS();
    String str2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVo, "");
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVp, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (bu.isNullOrNil(str1))
    {
      ae.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = t.eJf().eJO();
    }
    local7.K((String)localObject, str2, i);
    localObject = new com.tencent.mm.plugin.collect.model.l();
    localf.nEq.put(localObject, local7);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(64168);
  }
  
  protected String ccu()
  {
    AppMethodBeat.i(64173);
    String str = com.tencent.mm.wallet_core.ui.f.bah(this.plJ);
    AppMethodBeat.o(64173);
    return str;
  }
  
  protected void ccv() {}
  
  protected void ccw()
  {
    AppMethodBeat.i(64156);
    this.pli.setImageBitmap(null);
    if (this.plL)
    {
      if (bu.isNullOrNil(this.plF))
      {
        ae.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.plC = cP(this.plF, this.plG);
      if ((this.plC == null) || (this.plC.isRecycled())) {
        break label237;
      }
      this.pli.setImageBitmap(this.plC);
      label91:
      if (!this.plL) {
        break label281;
      }
      this.plk.setPrefix(ccu());
      this.plk.setText(com.tencent.mm.wallet_core.ui.f.C(this.plI));
      this.plk.setVisibility(0);
      if (bu.isNullOrNil(this.plK)) {
        break label269;
      }
      this.plj.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.plK, this.plj.getTextSize()));
      this.plj.setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131298455).setVisibility(0);
      AppMethodBeat.o(64156);
      return;
      if (bu.isNullOrNil(this.plD))
      {
        ae.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.plC = cP(this.plD, this.plG);
      break;
      label237:
      ae.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bu.nullAsNil(this.plF));
      break label91;
      label269:
      this.plj.setVisibility(8);
    }
    label281:
    this.pll.setVisibility(8);
    this.plk.setVisibility(8);
    this.plj.setVisibility(8);
    findViewById(2131298455).setVisibility(8);
    AppMethodBeat.o(64156);
  }
  
  protected final void ccx()
  {
    AppMethodBeat.i(189802);
    com.tencent.mm.kernel.g.ajS();
    if (((String)com.tencent.mm.kernel.g.ajR().ajA().get(327731, "0")).equals("0"))
    {
      com.tencent.mm.ui.base.h.a(getContext(), ah.fWg(), 2131757461, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(327731, "1");
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().fuc();
    }
    AppMethodBeat.o(189802);
  }
  
  public boolean e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(64165);
    super.finish();
    overridePendingTransition(2130772140, 2130772145);
    AppMethodBeat.o(64165);
  }
  
  public int getHeaderResourceId()
  {
    return 2131493562;
  }
  
  public int getLayoutId()
  {
    return 2131493560;
  }
  
  public int getResourceId()
  {
    return 2131951634;
  }
  
  protected String getTrueName()
  {
    AppMethodBeat.i(64172);
    if (bu.isNullOrNil(this.mTrueName))
    {
      this.mTrueName = t.eJf().getTrueName();
      this.mTrueName = com.tencent.mm.wallet_core.ui.f.bak(this.mTrueName);
    }
    String str = this.mTrueName;
    AppMethodBeat.o(64172);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64153);
    setMMTitle(2131761785);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64130);
        CollectMainUI.this.finish();
        AppMethodBeat.o(64130);
        return true;
      }
    });
    this.mEx = getPreferenceScreen();
    this.plo = ((RelativeLayout)findViewById(2131304239));
    this.plp = findViewById(2131298462);
    this.pmd = findViewById(2131298463);
    this.plk = ((WalletTextView)findViewById(2131298452));
    this.plj = ((TextView)findViewById(2131298451));
    this.pll = ((TextView)findViewById(2131298453));
    this.plm = ((TextView)findViewById(2131298461));
    this.plz = ((LinearLayout)findViewById(2131302956));
    this.plA = ((TextView)findViewById(2131297186));
    this.plr = ((RelativeLayout)findViewById(2131298459));
    this.pls = findViewById(2131298457);
    this.plN = LayoutInflater.from(this).inflate(2131493561, null, false);
    this.pln = ((TextView)findViewById(2131298471));
    Object localObject = new SpannableStringBuilder(getString(2131757476));
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(64132);
        CollectMainUI.a(CollectMainUI.this, CollectMainUI.b(CollectMainUI.this));
        CollectMainUI.c(CollectMainUI.this);
        if (CollectMainUI.b(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.g.yxI.f(20032, new Object[] { "wxface2face", "ClickQRCode", "", "", "", "", Integer.valueOf(2), Integer.valueOf(CollectMainUI.b(CollectMainUI.this).oGc), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(13944, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(64132);
      }
    }), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.pln.setText((CharSequence)localObject);
    this.pln.setClickable(true);
    this.pln.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    getListView().addFooterView(this.plN, null, false);
    getListView().setFooterDividersEnabled(false);
    this.pli = ((ImageView)findViewById(2131298456));
    this.mpP = ((TextView)findViewById(2131298477));
    this.ply = ((TextView)findViewById(2131298490));
    this.ply.setClickable(true);
    this.ply.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.plP = new SpannableStringBuilder(getString(2131757464));
    this.plQ = new SpannableStringBuilder(getString(2131757465));
    localObject = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(64133);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeUI.class);
        paramAnonymousView.putExtra("key_currency_unit", CollectMainUI.this.plE);
        CollectMainUI.this.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(64133);
      }
    });
    final com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(64134);
        CollectMainUI.this.plL = false;
        CollectMainUI.this.ccw();
        CollectMainUI.h(CollectMainUI.this).setText(CollectMainUI.g(CollectMainUI.this));
        CollectMainUI.i(CollectMainUI.this);
        AppMethodBeat.o(64134);
      }
    });
    this.plP.setSpan(localObject, 0, this.plP.length(), 18);
    if (a.a.fCh().fCg()) {
      this.ply.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64135);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (CollectMainUI.h(CollectMainUI.this).getText().toString().equals(CollectMainUI.j(CollectMainUI.this))) {
            this.pmG.onClick(paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64135);
            return;
            localq.onClick(paramAnonymousView);
          }
        }
      });
    }
    this.plQ.setSpan(localq, 0, this.plQ.length(), 18);
    this.ply.setText(this.plP);
    this.plB = ((RelativeLayout)findViewById(2131298479));
    this.pli.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64140);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        CollectMainUI.b(CollectMainUI.this, CollectMainUI.k(CollectMainUI.this));
        if (CollectMainUI.k(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.g.yxI.f(20032, new Object[] { "wxface2face", "LongClick", "", "", "", "", Integer.valueOf(3), Integer.valueOf(CollectMainUI.k(CollectMainUI.this).oGc), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(64140);
        return true;
      }
    });
    this.plu = findViewById(2131298464);
    this.plv = ((ImageView)findViewById(2131298481));
    this.plw = ((TextView)findViewById(2131298483));
    this.plx = ((TextView)findViewById(2131298482));
    this.plY = ((CdnImageView)findViewById(2131298421));
    this.plZ = ((TextView)findViewById(2131298424));
    this.pma = ((TextView)findViewById(2131298425));
    this.pmb = ((ImageView)findViewById(2131298423));
    this.pmc = ((ViewGroup)findViewById(2131298422));
    this.plr.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64141);
        int[] arrayOfInt = new int[2];
        CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
        CollectMainUI.Bx(arrayOfInt[1]);
        AppMethodBeat.o(64141);
      }
    }, 300L);
    localObject = new yo();
    ((yo)localObject).dNR.scene = "8";
    ((yo)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64114);
        if (!bu.isNullOrNil(this.pmv.dNS.dNT))
        {
          com.tencent.mm.wallet_core.ui.f.a((TextView)CollectMainUI.this.findViewById(2131297186), this.pmv.dNS.dNT, this.pmv.dNS.content, this.pmv.dNS.url);
          AppMethodBeat.o(64114);
          return;
        }
        ae.i("MicroMsg.CollectMainUI", "no bulletin data");
        AppMethodBeat.o(64114);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    this.pmk = ((LinearLayout)findViewById(2131307177));
    this.pml = ((TextView)findViewById(2131307180));
    this.pmm = ((Button)findViewById(2131307178));
    this.pmn = ((Button)findViewById(2131307179));
    AppMethodBeat.o(64153);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64161);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(64161);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.plF = paramIntent.getStringExtra("ftf_pay_url");
        this.plG = paramIntent.getIntExtra("key_error_level", -1);
        this.plI = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.plJ = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.plK = paramIntent.getStringExtra("ftf_fixed_desc");
        this.plE = paramIntent.getStringExtra("key_currency_unit");
        this.ply.setText(this.plQ);
      }
      for (this.plL = true;; this.plL = false)
      {
        refreshView();
        ccy();
        AppMethodBeat.o(64161);
        return;
      }
      this.pkQ = v.aAH();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64150);
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
    com.tencent.mm.kernel.g.ajS();
    this.dNN = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
    this.pkQ = v.aAH();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.g.yxI.f(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(2130772144, 2130772141);
    com.tencent.mm.plugin.collect.a.a.cbv();
    paramBundle = com.tencent.mm.plugin.collect.a.a.cbw();
    if (!paramBundle.oCX.contains(this)) {
      paramBundle.oCX.add(this);
    }
    initView();
    cct();
    refreshView();
    this.mZD = ((Vibrator)getSystemService("vibrator"));
    this.nLI = bu.aRi();
    if (pmq < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      pmq = paramBundle.widthPixels / 2 - BackwardSupportUtil.b.h(getContext(), 20.0F);
      pmr = BackwardSupportUtil.b.h(getContext(), 60.0F);
      pms = BackwardSupportUtil.b.h(getContext(), 40.0F);
      pmt = BackwardSupportUtil.b.h(getContext(), 70.0F);
    }
    ccy();
    ab.kI(16, 0);
    com.tencent.mm.kernel.g.ajj().a(3781, this);
    AppMethodBeat.o(64150);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64152);
    if (this.pli != null) {
      this.pli.setImageBitmap(null);
    }
    Object localObject = this.plC;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ae.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.plq != null) {
      this.plq.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.cbv();
    com.tencent.mm.plugin.collect.a.a.cbw().oCX.remove(this);
    this.mZD.cancel();
    if (this.plR != null)
    {
      localObject = this.plR;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).nEq.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ae.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).nEq.clear();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(1588, (com.tencent.mm.ak.f)localObject);
    }
    com.tencent.mm.platformtools.u.c(this.pmp);
    com.tencent.mm.kernel.g.ajj().b(3781, this);
    super.onDestroy();
    AppMethodBeat.o(64152);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64163);
    super.onPause();
    bi.a(this, null);
    AppMethodBeat.o(64163);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64162);
    super.onResume();
    bi.a(this, this);
    AppMethodBeat.o(64162);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(189808);
    ae.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m)) {
      ae.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
    }
    AppMethodBeat.o(189808);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(64155);
    if (bu.isNullOrNil(this.plD))
    {
      ae.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(64155);
      return;
    }
    if (this.plS == 1)
    {
      if (!bu.isNullOrNil(this.plT)) {
        this.mpP.setText(this.plT);
      }
      if (!bu.isNullOrNil(this.plU))
      {
        TextView localTextView = (TextView)findViewById(2131298458);
        localTextView.setText(this.plU);
        localTextView.setVisibility(0);
      }
    }
    ccw();
    ccz();
    ccA();
    ccB();
    AppMethodBeat.o(64155);
  }
  
  public final void setStatusColor()
  {
    AppMethodBeat.i(64151);
    setActionbarColor(getResources().getColor(2131099827));
    AppMethodBeat.o(64151);
  }
  
  final class a
    extends com.tencent.mm.plugin.collect.model.u
  {
    public boolean isAnimated = false;
    
    public a(com.tencent.mm.plugin.collect.model.u paramu)
    {
      this.username = paramu.username;
      this.dmx = paramu.dmx;
      this.phz = paramu.phz;
      this.phB = paramu.phB;
      this.scene = paramu.scene;
      this.status = paramu.status;
      this.fXp = paramu.fXp;
    }
  }
  
  final class b
  {
    boolean pmI;
    LinkedList<CollectMainUI.a> pmJ;
    
    private b()
    {
      AppMethodBeat.i(64145);
      this.pmJ = new LinkedList();
      AppMethodBeat.o(64145);
    }
    
    private int By(int paramInt)
    {
      AppMethodBeat.i(64146);
      float f2 = 0.0F + CollectMainUI.l(CollectMainUI.this).getHeight() / 2;
      float f1 = f2;
      if (CollectMainUI.p(CollectMainUI.this).getVisibility() == 0) {
        f1 = f2 + CollectMainUI.p(CollectMainUI.this).getHeight();
      }
      f2 = CollectMainUI.ccI() * paramInt + CollectMainUI.ccI() / 2;
      int[] arrayOfInt = new int[2];
      CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
      paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.bIv()));
      AppMethodBeat.o(64146);
      return paramInt;
    }
    
    private void a(final CollectMainUI.a parama)
    {
      AppMethodBeat.i(64148);
      this.pmI = true;
      CollectMainUI.n(CollectMainUI.this);
      CollectMainUI.q(CollectMainUI.this).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.l(CollectMainUI.this).getWidth(), CollectMainUI.l(CollectMainUI.this).getHeight()));
      if (CollectMainUI.this.plL) {
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.ccJ(), 0, 0);
      }
      final AnimationSet localAnimationSet;
      int j;
      for (;;)
      {
        CollectMainUI.r(CollectMainUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(CollectMainUI.this.getContext(), parama.fXp, CollectMainUI.r(CollectMainUI.this).getTextSize()));
        a.b.c(CollectMainUI.s(CollectMainUI.this), parama.username);
        CollectMainUI.t(CollectMainUI.this).setText(com.tencent.mm.wallet_core.ui.f.d(parama.phz, parama.dog));
        CollectMainUI.q(CollectMainUI.this).setVisibility(0);
        localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
        j = 0;
        int i = 0;
        while (i < CollectMainUI.u(CollectMainUI.this).size())
        {
          if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dmx.equals(parama.dmx)) {
            j = i;
          }
          i += 1;
        }
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.ccK(), 0, 0);
      }
      localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.ccH(), 0.0F, By(j)));
      localAnimationSet.setDuration(300L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64142);
          CollectMainUI.q(CollectMainUI.this).setVisibility(8);
          ae.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + parama.dmx);
          int i = 0;
          for (;;)
          {
            if (i < CollectMainUI.u(CollectMainUI.this).size())
            {
              if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dmx.equals(parama.dmx))
              {
                ((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).isAnimated = true;
                ae.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + parama.dmx);
              }
            }
            else
            {
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.b.this.pmI = false;
              CollectMainUI.b.this.ccN();
              AppMethodBeat.o(64142);
              return;
            }
            i += 1;
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      parama = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      parama.setDuration(300L);
      parama.setInterpolator(new LinearInterpolator());
      parama.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64143);
          localAnimationSet.setStartOffset(1700L);
          CollectMainUI.q(CollectMainUI.this).startAnimation(localAnimationSet);
          AppMethodBeat.o(64143);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64144);
          CollectMainUI.q(CollectMainUI.this).setVisibility(0);
          AppMethodBeat.o(64144);
        }
      });
      CollectMainUI.q(CollectMainUI.this).startAnimation(parama);
      AppMethodBeat.o(64148);
    }
    
    public final void ccN()
    {
      AppMethodBeat.i(64147);
      if (!this.pmI)
      {
        if (!this.pmJ.isEmpty())
        {
          a((CollectMainUI.a)this.pmJ.poll());
          AppMethodBeat.o(64147);
        }
      }
      else {
        ae.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.pmJ.size());
      }
      AppMethodBeat.o(64147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */