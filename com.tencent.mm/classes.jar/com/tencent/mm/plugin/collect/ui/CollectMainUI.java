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
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.f.a;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.g.a;
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
  implements com.tencent.mm.al.g, d.a, bh.a
{
  private static int nYU = -1;
  private static int nYV = -1;
  private static int nYW = -1;
  private static int nYX = -1;
  private static int nYq;
  private int dCy;
  private Vibrator lRO;
  private TextView lln;
  private com.tencent.mm.ui.base.preference.f lxI;
  private long mDF;
  protected String mTrueName;
  protected ScrollView nVT;
  private int nXJ;
  private int nXK;
  private com.tencent.mm.ui.widget.a.g nXL;
  private ImageView nXM;
  private TextView nXN;
  private WalletTextView nXO;
  private TextView nXP;
  private TextView nXQ;
  private TextView nXR;
  private RelativeLayout nXS;
  private View nXT;
  private Dialog nXU;
  private View nXV;
  private View nXW;
  private boolean nXX;
  private View nXY;
  private ImageView nXZ;
  private long nXu;
  private String nYA;
  private String nYB;
  protected CdnImageView nYC;
  protected TextView nYD;
  protected TextView nYE;
  protected ImageView nYF;
  protected ViewGroup nYG;
  protected View nYH;
  private boolean nYI;
  private int nYJ;
  private bpx nYK;
  private cds nYL;
  private cds nYM;
  private cds nYN;
  private LinearLayout nYO;
  private TextView nYP;
  private TextView nYQ;
  private TextView nYR;
  private com.tencent.mm.bx.b nYS;
  private u.a nYT;
  private TextView nYa;
  private TextView nYb;
  private TextView nYc;
  protected LinearLayout nYd;
  protected TextView nYe;
  private RelativeLayout nYf;
  private Bitmap nYg;
  protected String nYh;
  protected String nYi;
  private String nYj;
  private int nYk;
  private List<a> nYl;
  private double nYm;
  private String nYn;
  private String nYo;
  protected boolean nYp;
  private View nYr;
  private b nYs;
  private SpannableStringBuilder nYt;
  private SpannableStringBuilder nYu;
  private com.tencent.mm.plugin.collect.model.f nYv;
  private int nYw;
  private String nYx;
  private String nYy;
  private String nYz;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(64149);
    this.nXM = null;
    this.nXN = null;
    this.nXO = null;
    this.nXP = null;
    this.nXQ = null;
    this.nXR = null;
    this.nXS = null;
    this.nXT = null;
    this.lln = null;
    this.lxI = null;
    this.nXU = null;
    this.nXV = null;
    this.nXW = null;
    this.nVT = null;
    this.nXX = false;
    this.nXY = null;
    this.nYg = null;
    this.nYh = null;
    this.mTrueName = null;
    this.nYi = null;
    this.nYj = null;
    this.nYl = new LinkedList();
    this.nYn = null;
    this.nYo = null;
    this.nYp = false;
    this.nYs = new b((byte)0);
    this.nYw = 0;
    this.nYI = false;
    this.nYJ = 0;
    this.nYT = new u.a()
    {
      public final void l(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(64125);
        if ((paramAnonymousString == null) || (CollectMainUI.a(CollectMainUI.this) == null))
        {
          AppMethodBeat.o(64125);
          return;
        }
        if (paramAnonymousString.equals(CollectMainUI.a(CollectMainUI.this)))
        {
          ad.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(CollectMainUI.this), paramAnonymousString });
          CollectMainUI.this.bPo();
        }
        AppMethodBeat.o(64125);
      }
    };
    AppMethodBeat.o(64149);
  }
  
  private void a(bfi parambfi)
  {
    AppMethodBeat.i(187016);
    if ((parambfi == null) || ((this.nXL != null) && (this.nXL.isShowing())))
    {
      ad.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
      AppMethodBeat.o(187016);
      return;
    }
    ad.i("MicroMsg.CollectMainUI", "showHalfDialog");
    Object localObject1 = parambfi.DCB;
    Object localObject2 = parambfi.DCC;
    this.nXJ = 4;
    this.nXL = new com.tencent.mm.ui.widget.a.g(getContext(), 1);
    this.nXL.c(((cdt)localObject1).doh, ((cdt)localObject2).doh);
    this.nXL.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(187001);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.nZh);
        CollectMainUI.C(CollectMainUI.this).bfo();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(187001);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(187002);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.nZi);
        CollectMainUI.C(CollectMainUI.this).bfo();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(187002);
      }
    });
    if (parambfi.DCA.type == 2)
    {
      localObject1 = View.inflate(getContext(), 2131496149, null);
      ((ImageView)((View)localObject1).findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64126);
          CollectMainUI.C(CollectMainUI.this).bfo();
          CollectMainUI.D(CollectMainUI.this);
          AppMethodBeat.o(64126);
        }
      });
      localObject2 = (TextView)((View)localObject1).findViewById(2131307175);
      ((TextView)localObject2).setText(parambfi.DCA.EtH);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.nXL.setHeaderView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = View.inflate(getContext(), 2131496147, null);
      ((TextView)((View)localObject1).findViewById(2131300674)).setText(parambfi.doh);
      this.nXL.setCustomView((View)localObject1);
      this.nXL.csG();
      AppMethodBeat.o(187016);
      return;
      localObject1 = View.inflate(getContext(), 2131496148, null);
      localObject2 = (TextView)((View)localObject1).findViewById(2131300675);
      ((TextView)localObject2).setText(parambfi.DCA.EtH);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.nXL.setHeaderView((View)localObject1);
    }
  }
  
  private void a(cds paramcds)
  {
    AppMethodBeat.i(187015);
    if (paramcds == null)
    {
      ad.i("MicroMsg.CollectMainUI", "actionInfo is null");
      AppMethodBeat.o(187015);
      return;
    }
    ad.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", new Object[] { Integer.valueOf(paramcds.ntg) });
    switch (paramcds.ntg)
    {
    default: 
      ad.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
      AppMethodBeat.o(187015);
      return;
    case 0: 
      AppMethodBeat.o(187015);
      return;
    case 1: 
      a(paramcds.DZV);
      AppMethodBeat.o(187015);
      return;
    case 2: 
      a(paramcds.DZW);
      AppMethodBeat.o(187015);
      return;
    }
    a(paramcds.DZX);
    AppMethodBeat.o(187015);
  }
  
  private void a(final cds paramcds, final yq paramyq)
  {
    AppMethodBeat.i(187019);
    ad.i("MicroMsg.CollectMainUI", "doSaveQrCode");
    Object localObject;
    if ((this.nYg != null) && (!this.nYg.isRecycled()))
    {
      i = BackwardSupportUtil.b.g(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.nYh, com.tencent.mm.model.u.aqG(), this.nYw, this.nYz, i, this.nYT, false, this.nYk, 0.0F);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.nYp)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.nYm * 100.0D)) });
          if (this.nXX) {
            break label660;
          }
          this.nVT = ((ScrollView)((ViewStub)findViewById(2131298476)).inflate());
          bPn();
          this.nXX = true;
        }
      }
    }
    label660:
    for (int i = 250;; i = 0)
    {
      this.nVT.setVisibility(4);
      ((ImageView)this.nVT.findViewById(2131298470)).setImageBitmap(this.nYg);
      TextView localTextView1 = (TextView)this.nVT.findViewById(2131298472);
      TextView localTextView2 = (TextView)this.nVT.findViewById(2131298473);
      final LinearLayout localLinearLayout1 = (LinearLayout)this.nVT.findViewById(2131298488);
      LinearLayout localLinearLayout2 = (LinearLayout)this.nVT.findViewById(2131298469);
      TextView localTextView3 = (TextView)this.nVT.findViewById(2131298466);
      TextView localTextView4 = (TextView)this.nVT.findViewById(2131298467);
      TextView localTextView5 = (TextView)this.nVT.findViewById(2131298468);
      String str1 = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(com.tencent.mm.model.u.aqG()), 10);
      String str2 = getTrueName();
      localObject = str1;
      if (!bt.isNullOrNil(str2)) {
        localObject = str1 + getString(2131757475, new Object[] { str2 });
      }
      if (this.nYw == 1) {
        if (!bt.isNullOrNil(this.nYy))
        {
          localTextView1.setText(this.nYy);
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          label419:
          if (!this.nYp) {
            break label615;
          }
          if (bt.isNullOrNil(this.nYo)) {
            break label605;
          }
          localTextView4.setText(this.nYo);
          localTextView4.setVisibility(0);
          label451:
          localTextView3.setText(bPm());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.e.D(this.nYm));
          localLinearLayout2.setVisibility(0);
          label478:
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64117);
              ad.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(localLinearLayout1.getHeight()), Integer.valueOf(localLinearLayout1.getWidth()) });
              Bitmap localBitmap = Bitmap.createBitmap(localLinearLayout1.getWidth(), localLinearLayout1.getHeight(), Bitmap.Config.ARGB_8888);
              Object localObject = new Canvas(localBitmap);
              localLinearLayout1.draw((Canvas)localObject);
              try
              {
                localObject = com.tencent.mm.pluginsdk.ui.tools.q.eAS() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                com.tencent.mm.sdk.platformtools.f.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
                if (this.nZb)
                {
                  ad.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
                  CollectMainUI.a(CollectMainUI.this, CollectMainUI.this.getContext(), CollectMainUI.this.getContext().getResources().getString(2131760299), paramcds, paramyq);
                }
                com.tencent.mm.pluginsdk.ui.tools.q.k((String)localObject, CollectMainUI.this.getContext());
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
                }
              }
              CollectMainUI.this.nVT.setVisibility(8);
              AppMethodBeat.o(64117);
            }
          }, i);
          i = 1;
          label497:
          if (i == 0)
          {
            ad.w("MicroMsg.CollectMainUI", "save ftf pay qrcode fail");
            Toast.makeText(getContext(), getString(2131757489), 1).show();
          }
        }
      }
      for (;;)
      {
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(187019);
        return;
        com.tencent.mm.plugin.report.service.h.vKh.f(11343, new Object[] { Integer.valueOf(0) });
        break;
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label419;
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label419;
        label605:
        localTextView4.setVisibility(8);
        break label451;
        label615:
        localLinearLayout2.setVisibility(8);
        break label478;
        i = 0;
        break label497;
        ad.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
        Toast.makeText(getContext(), getString(2131757489), 1).show();
      }
    }
  }
  
  private void a(final od paramod)
  {
    AppMethodBeat.i(187018);
    if (paramod == null)
    {
      ad.i("MicroMsg.CollectMainUI", " bottomCell == null");
      AppMethodBeat.o(187018);
      return;
    }
    this.nXJ = 3;
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(getContext(), 1, true);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 56));
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(getResources().getColor(2131099734));
    localTextView.setText(paramod.CLG);
    locale.J(localTextView, false);
    locale.HFn = true;
    locale.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(187005);
        Iterator localIterator = paramod.CLH.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          cdt localcdt = (cdt)localIterator.next();
          if ((localcdt != null) && (localcdt.doh != null))
          {
            paramAnonymousl.c(i, localcdt.doh);
            i += 1;
          }
        }
        AppMethodBeat.o(187005);
      }
    };
    locale.HrY = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(187006);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        paramAnonymousMenuItem = (cdt)paramod.CLH.get(paramAnonymousInt);
        CollectMainUI.d(CollectMainUI.this, 2);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousMenuItem);
        AppMethodBeat.o(187006);
      }
    };
    locale.csG();
    AppMethodBeat.o(187018);
  }
  
  private void a(final yq paramyq)
  {
    AppMethodBeat.i(187017);
    if (paramyq == null)
    {
      ad.i("MicroMsg.CollectMainUI", " coverInfo == null");
      AppMethodBeat.o(187017);
      return;
    }
    ad.i("MicroMsg.CollectMainUI", "showCoverUI");
    this.nYO.setVisibility(0);
    this.nYO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64129);
        AppMethodBeat.o(64129);
      }
    });
    ViewGroup.LayoutParams localLayoutParams = this.nYO.getLayoutParams();
    localLayoutParams.height = this.nXV.getHeight();
    this.nYO.setLayoutParams(localLayoutParams);
    this.nYP.setText(paramyq.doh);
    this.nYQ.setText(paramyq.DaR.doh);
    this.nYQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187003);
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramyq.DaR);
        AppMethodBeat.o(187003);
      }
    });
    this.nYR.setText(paramyq.DaS.doh);
    this.nYR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187004);
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramyq.DaS);
        AppMethodBeat.o(187004);
      }
    });
    AppMethodBeat.o(187017);
  }
  
  private static bpq an(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64171);
    bpq localbpq = new bpq();
    localbpq.type = paramJSONObject.optInt("type", -1);
    localbpq.url = paramJSONObject.optString("url", "");
    localbpq.doh = paramJSONObject.optString("wording", "");
    localbpq.DOb = paramJSONObject.optString("waapp_username", "");
    localbpq.DOc = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(64171);
    return localbpq;
  }
  
  private void bPq()
  {
    AppMethodBeat.i(64157);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64115);
        int i = com.tencent.mm.cd.a.fromDPToPix(CollectMainUI.this.getContext(), 37);
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
  
  private void bPr()
  {
    AppMethodBeat.i(64158);
    double d;
    if ((this.nYl != null) && (this.nYl.size() > 0))
    {
      this.nXV.setBackgroundResource(2131231783);
      this.lxI.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.nYl.size())
      {
        a locala = (a)this.nYl.get(i);
        c localc;
        if (i == this.nYl.size() - 1)
        {
          localc = new c(this, (byte)0);
          label102:
          localc.setKey(String.valueOf(i));
          String str2 = locala.fyo;
          String str1 = str2;
          if (bt.isNullOrNil(str2))
          {
            str1 = str2;
            if (!bt.isNullOrNil(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.e.sh(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.flk = locala.username;
          if (locala.status != 0) {
            break label219;
          }
          localc.setSummary(2131757471);
        }
        for (;;)
        {
          this.lxI.b(localc);
          i += 1;
          break;
          localc = new c(this);
          break label102;
          label219:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.nUf;
              localc.setSummary(com.tencent.mm.wallet_core.ui.e.d(locala.nUf, locala.dem));
            }
            for (;;)
            {
              this.lxI.b(localc);
              break;
              localc.setSummary(2131757470);
            }
          }
          if (locala.status == 2) {
            localc.setSummary(2131757469);
          }
        }
      }
      this.lxI.notifyDataSetChanged();
      this.nXQ.setText(com.tencent.mm.wallet_core.ui.e.d(d, ((a)this.nYl.get(0)).dem));
      this.nXQ.setVisibility(0);
    }
    for (;;)
    {
      if ((this.nYl != null) && (this.nYl.size() > 0))
      {
        this.nYG.setBackgroundResource(2131231784);
        this.nXT.setVisibility(0);
        if ((d > 0.0D) && (this.nYl.size() > 0))
        {
          this.nYH.setVisibility(0);
          this.nXW.setVisibility(0);
          AppMethodBeat.o(64158);
        }
      }
      else
      {
        this.nXQ.setVisibility(8);
        this.nXT.setVisibility(8);
        this.nXW.setVisibility(8);
      }
      AppMethodBeat.o(64158);
      return;
      d = 0.0D;
    }
  }
  
  private void bPs()
  {
    AppMethodBeat.i(64166);
    az localaz = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    if (this.nYp) {}
    for (int i = 33;; i = 32)
    {
      if (localaz != null) {
        com.tencent.mm.plugin.report.service.h.vKh.f(13447, new Object[] { Integer.valueOf(i), localaz.Cvf, localaz.Cvg, this.nYh, Double.valueOf(this.nYm), Long.valueOf(bt.aGK()), Long.valueOf(localaz.Cve), localaz.Cvh, localaz.Cvi });
      }
      AppMethodBeat.o(64166);
      return;
    }
  }
  
  private void bPt()
  {
    AppMethodBeat.i(64167);
    if (!bt.isNullOrNil(this.nYA))
    {
      this.nYe.setText(this.nYA);
      this.nYe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186993);
          if (!bt.isNullOrNil(CollectMainUI.v(CollectMainUI.this))) {
            com.tencent.mm.wallet_core.ui.e.p(aj.getContext(), CollectMainUI.v(CollectMainUI.this), true);
          }
          AppMethodBeat.o(186993);
        }
      });
      this.nYd.setVisibility(0);
      AppMethodBeat.o(64167);
      return;
    }
    this.nYd.setVisibility(8);
    AppMethodBeat.o(64167);
  }
  
  private static bpq bPu()
  {
    AppMethodBeat.i(64169);
    try
    {
      com.tencent.mm.kernel.g.afC();
      bpq localbpq = an(new JSONObject((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqG, "")));
      AppMethodBeat.o(64169);
      return localbpq;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64169);
    }
    return null;
  }
  
  private static List<bpq> bPv()
  {
    AppMethodBeat.i(64170);
    localArrayList = new ArrayList();
    try
    {
      com.tencent.mm.kernel.g.afC();
      Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqI, "");
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(an(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64170);
    }
  }
  
  private int bPw()
  {
    AppMethodBeat.i(187010);
    if ((this.nXO.isShown()) && (!bt.ai(this.nXO.getText())))
    {
      int i = Integer.parseInt(com.tencent.mm.wallet_core.ui.e.b(this.nXO.getText(), "100", 0, RoundingMode.HALF_UP).toString());
      AppMethodBeat.o(187010);
      return i;
    }
    AppMethodBeat.o(187010);
    return 0;
  }
  
  private String bPx()
  {
    AppMethodBeat.i(187011);
    if ((this.nXN.isShown()) && (!bt.ai(this.nXN.getText())))
    {
      String str = this.nXN.getText().toString();
      AppMethodBeat.o(187011);
      return str;
    }
    AppMethodBeat.o(187011);
    return "";
  }
  
  private String bPy()
  {
    AppMethodBeat.i(187012);
    if (this.nYp)
    {
      if (bt.isNullOrNil(this.nYj))
      {
        ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(187012);
        return "";
      }
      str = this.nYj;
      AppMethodBeat.o(187012);
      return str;
    }
    if (bt.isNullOrNil(this.nYh))
    {
      ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
      AppMethodBeat.o(187012);
      return "";
    }
    String str = this.nYh;
    AppMethodBeat.o(187012);
    return str;
  }
  
  private Bitmap cD(String paramString, int paramInt)
  {
    AppMethodBeat.i(64159);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, com.tencent.mm.model.u.aqG(), this.nYw, this.nYz, this.nYT, paramInt);
    AppMethodBeat.o(64159);
    return paramString;
  }
  
  private void zJ(int paramInt)
  {
    AppMethodBeat.i(187013);
    int i = bPw();
    Object localObject = bPx();
    String str = bPy();
    ad.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str, this.nYS });
    localObject = new m(paramInt, i, (String)localObject, str, this.nYS);
    com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(187013);
  }
  
  public final void P(String paramString, long paramLong)
  {
    AppMethodBeat.i(187009);
    ad.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.h.vKh.f(13944, new Object[] { Integer.valueOf(9) });
    if (this.nYL != null) {
      com.tencent.mm.plugin.report.service.h.vKh.f(20032, new Object[] { "wxface2face", "ScreenShot", "", "", "", "", Integer.valueOf(1), Integer.valueOf(this.nYL.ntg), Integer.valueOf(0), bPy(), Integer.valueOf(bPw()), bPx() });
    }
    a(this.nYL);
    zJ(1);
    AppMethodBeat.o(187009);
  }
  
  public final void a(com.tencent.mm.plugin.collect.model.u paramu)
  {
    int k = 0;
    AppMethodBeat.i(64160);
    ad.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.dCy != 1) && (this.dCy != 0)) || ((paramu.msgType == 9) || ((this.dCy == 8) && (paramu.msgType == 26))))
    {
      if (this.lRO != null) {
        this.lRO.vibrate(50L);
      }
      if (paramu.nUh < this.mDF)
      {
        ad.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(64160);
        return;
      }
      i = 0;
      if (i >= this.nYl.size()) {
        break label510;
      }
      if ((paramu.status != 0) || (!bt.nullAsNil(paramu.username).equals(((a)this.nYl.get(i)).username)) || (((a)this.nYl.get(i)).status != 2)) {
        break label320;
      }
      this.nYl.remove(i);
      this.nYl.add(i, new a(paramu));
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
        if (i < this.nYl.size())
        {
          localObject = (com.tencent.mm.plugin.collect.model.u)this.nYl.get(i);
          if (paramu.nUh > ((com.tencent.mm.plugin.collect.model.u)localObject).nUh)
          {
            this.nYl.add(i, new a(paramu));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.nYl.add(new a(paramu));
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64116);
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.o(CollectMainUI.this).bPF();
              CollectMainUI.i(CollectMainUI.this);
              AppMethodBeat.o(64116);
            }
          });
          AppMethodBeat.o(64160);
          return;
          label320:
          if (paramu.dcF.equals(((a)this.nYl.get(i)).dcF))
          {
            ad.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramu.dcF);
            if (((a)this.nYl.get(i)).status == 0)
            {
              ((a)this.nYl.get(i)).status = paramu.status;
              ((a)this.nYl.get(i)).nUf = paramu.nUf;
              ((a)this.nYl.get(i)).dem = paramu.dem;
              if (paramu.status == 1)
              {
                localObject = this.nYs;
                a locala = (a)this.nYl.get(i);
                ((b)localObject).nZn.add(locala);
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
  
  protected void bPl()
  {
    AppMethodBeat.i(64168);
    if (com.tencent.mm.plugin.collect.model.f.nTd == null) {
      com.tencent.mm.plugin.collect.model.f.nTd = new com.tencent.mm.plugin.collect.model.f();
    }
    this.nYv = com.tencent.mm.plugin.collect.model.f.nTd;
    Object localObject = this.nYv;
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1588, (com.tencent.mm.al.g)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.nYv;
    f.a local7 = new f.a()
    {
      public final void I(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        AppMethodBeat.i(186995);
        ad.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt) });
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.this.nYh = paramAnonymousString1;
        CollectMainUI.a(CollectMainUI.this, paramAnonymousInt);
        CollectMainUI.this.mTrueName = paramAnonymousString2;
        paramAnonymousString1 = CollectMainUI.bPD();
        paramAnonymousString2 = CollectMainUI.bPE();
        CollectMainUI.a(CollectMainUI.this, paramAnonymousString1);
        CollectMainUI.this.cJ(paramAnonymousString2);
        if (CollectMainUI.x(CollectMainUI.this) == 1)
        {
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.afC();
          CollectMainUI.b(paramAnonymousString1, ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Frs, Integer.valueOf(-1))).intValue());
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.afC();
          CollectMainUI.a(paramAnonymousString1, (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Frt, ""));
        }
        AppMethodBeat.o(186995);
      }
      
      public final void a(boolean paramAnonymousBoolean, sh paramAnonymoussh)
      {
        AppMethodBeat.i(186996);
        Object localObject;
        if (paramAnonymoussh == null)
        {
          localObject = "null";
          ad.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), localObject });
          if (!paramAnonymousBoolean) {
            break label499;
          }
          if ((paramAnonymoussh == null) || (paramAnonymoussh.dcG != 416)) {
            break label189;
          }
          if (paramAnonymoussh.CTW != null) {
            break label184;
          }
        }
        label184:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ad.d("MicroMsg.CollectMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectMainUI.w(CollectMainUI.this).setVisibility(4);
          CollectMainUI.a(CollectMainUI.this, true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
          ((Bundle)localObject).putString("realname_verify_process_jump_plugin", "collect");
          CollectMainUI localCollectMainUI = CollectMainUI.this;
          int i = paramAnonymoussh.dcG;
          paramAnonymoussh = paramAnonymoussh.CTW;
          new CollectMainUI.7.1(this);
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localCollectMainUI, i, paramAnonymoussh, (Bundle)localObject, 1010);
          AppMethodBeat.o(186996);
          return;
          localObject = Integer.valueOf(paramAnonymoussh.dcG);
          break;
        }
        label189:
        CollectMainUI.this.bPp();
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.a(CollectMainUI.this, false);
        CollectMainUI.this.nYh = paramAnonymoussh.url;
        CollectMainUI.a(CollectMainUI.this, ag.abv(paramAnonymoussh.CTI));
        CollectMainUI.this.mTrueName = paramAnonymoussh.Aar;
        CollectMainUI.b(CollectMainUI.this, paramAnonymoussh.vBl);
        CollectMainUI.b(CollectMainUI.this, paramAnonymoussh.vBm);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussh.vBn);
        CollectMainUI.c(CollectMainUI.this, paramAnonymoussh.CTT);
        CollectMainUI.d(CollectMainUI.this, paramAnonymoussh.iau);
        CollectMainUI.e(CollectMainUI.this, paramAnonymoussh.iav);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussh.CTQ);
        CollectMainUI.this.cJ(paramAnonymoussh.CTP);
        CollectMainUI.c(CollectMainUI.this, paramAnonymoussh.CTU);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussh.CTV);
        ad.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.y(CollectMainUI.this)) });
        CollectMainUI.c(CollectMainUI.this, paramAnonymoussh.CUa);
        CollectMainUI.d(CollectMainUI.this, paramAnonymoussh.CUb);
        CollectMainUI.e(CollectMainUI.this, paramAnonymoussh.CUc);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussh.CUd);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frs, Integer.valueOf(CollectMainUI.z(CollectMainUI.this)));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frt, CollectMainUI.a(CollectMainUI.this));
        CollectMainUI.this.refreshView();
        label499:
        AppMethodBeat.o(186996);
      }
    };
    com.tencent.mm.kernel.g.afC();
    String str1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqD, "");
    com.tencent.mm.kernel.g.afC();
    String str2 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqE, "");
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqF, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (bt.isNullOrNil(str1))
    {
      ad.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = s.ecc().ecM();
    }
    local7.I((String)localObject, str2, i);
    localObject = new com.tencent.mm.plugin.collect.model.l();
    localf.mwx.put(localObject, local7);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(64168);
  }
  
  protected String bPm()
  {
    AppMethodBeat.i(64173);
    String str = com.tencent.mm.wallet_core.ui.e.aNc(this.nYn);
    AppMethodBeat.o(64173);
    return str;
  }
  
  protected void bPn() {}
  
  protected void bPo()
  {
    AppMethodBeat.i(64156);
    this.nXM.setImageBitmap(null);
    if (this.nYp)
    {
      if (bt.isNullOrNil(this.nYj))
      {
        ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.nYg = cD(this.nYj, this.nYk);
      if ((this.nYg == null) || (this.nYg.isRecycled())) {
        break label237;
      }
      this.nXM.setImageBitmap(this.nYg);
      label91:
      if (!this.nYp) {
        break label281;
      }
      this.nXO.setPrefix(bPm());
      this.nXO.setText(com.tencent.mm.wallet_core.ui.e.D(this.nYm));
      this.nXO.setVisibility(0);
      if (bt.isNullOrNil(this.nYo)) {
        break label269;
      }
      this.nXN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.nYo, this.nXN.getTextSize()));
      this.nXN.setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131298455).setVisibility(0);
      AppMethodBeat.o(64156);
      return;
      if (bt.isNullOrNil(this.nYh))
      {
        ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.nYg = cD(this.nYh, this.nYk);
      break;
      label237:
      ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bt.nullAsNil(this.nYj));
      break label91;
      label269:
      this.nXN.setVisibility(8);
    }
    label281:
    this.nXP.setVisibility(8);
    this.nXO.setVisibility(8);
    this.nXN.setVisibility(8);
    findViewById(2131298455).setVisibility(8);
    AppMethodBeat.o(64156);
  }
  
  protected final void bPp()
  {
    AppMethodBeat.i(187008);
    com.tencent.mm.kernel.g.afC();
    if (((String)com.tencent.mm.kernel.g.afB().afk().get(327731, "0")).equals("0"))
    {
      com.tencent.mm.ui.base.h.a(getContext(), ah.fkk(), 2131757461, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(327731, "1");
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().eKy();
    }
    AppMethodBeat.o(187008);
  }
  
  protected final void cJ(final List<bpq> paramList)
  {
    AppMethodBeat.i(64174);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        bpq localbpq = (bpq)localIterator.next();
        if (localbpq.type == 1) {
          com.tencent.mm.plugin.report.service.h.vKh.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localbpq.doh, "", "", "", Integer.valueOf(1) });
        } else if (localbpq.type == 2) {
          com.tencent.mm.plugin.report.service.h.vKh.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localbpq.doh, "", "", localbpq.url, Integer.valueOf(1) });
        } else if (localbpq.type == 3) {
          com.tencent.mm.plugin.report.service.h.vKh.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localbpq.doh, localbpq.DOb, localbpq.DOc, "", Integer.valueOf(1) });
        }
      }
    }
    this.nYf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187000);
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(CollectMainUI.this.getContext(), 1, false);
        paramAnonymousView.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(186998);
            com.tencent.mm.plugin.collect.a.a.bOn();
            if (com.tencent.mm.plugin.collect.a.a.bOp()) {
              paramAnonymous2l.add(0, 1, 0, 2131757457);
            }
            while (CollectMainUI.9.this.isg != null)
            {
              int i = 0;
              while (i < CollectMainUI.9.this.isg.size())
              {
                bpq localbpq = (bpq)CollectMainUI.9.this.isg.get(i);
                if (!bt.isNullOrNil(localbpq.doh)) {
                  paramAnonymous2l.add(0, i + 1 + 1, 0, localbpq.doh);
                }
                i += 1;
              }
              paramAnonymous2l.add(0, 1, 0, 2131757467);
            }
            AppMethodBeat.o(186998);
          }
        };
        paramAnonymousView.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(186999);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId() - 1 - 1;
              if (paramAnonymous2Int < 0)
              {
                ad.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                AppMethodBeat.o(186999);
                return;
              }
              break;
            case 1: 
              com.tencent.mm.plugin.collect.a.a.bOn();
              if (com.tencent.mm.plugin.collect.a.a.bOp())
              {
                CollectMainUI.A(CollectMainUI.this);
                Toast.makeText(CollectMainUI.this.getContext(), 2131757458, 1).show();
                com.tencent.mm.plugin.report.service.h.vKh.f(13944, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(186999);
                return;
              }
              CollectMainUI.B(CollectMainUI.this);
              Toast.makeText(CollectMainUI.this.getContext(), 2131757468, 1).show();
              com.tencent.mm.plugin.collect.model.voice.a.bOE().iX(false);
              com.tencent.mm.plugin.report.service.h.vKh.f(13944, new Object[] { Integer.valueOf(7) });
              AppMethodBeat.o(186999);
              return;
            }
            paramAnonymous2MenuItem = (bpq)CollectMainUI.9.this.isg.get(paramAnonymous2Int);
            if (paramAnonymous2MenuItem.type == 1)
            {
              ad.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramAnonymous2MenuItem.url });
              com.tencent.mm.plugin.report.service.h.vKh.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2MenuItem.doh, "", "", "", Integer.valueOf(2) });
              AppMethodBeat.o(186999);
              return;
            }
            if (paramAnonymous2MenuItem.type == 2)
            {
              if (!bt.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                com.tencent.mm.wallet_core.ui.e.p(CollectMainUI.this.getContext(), paramAnonymous2MenuItem.url, false);
                com.tencent.mm.plugin.report.service.h.vKh.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramAnonymous2MenuItem.doh, "", "", paramAnonymous2MenuItem.url, Integer.valueOf(2) });
                AppMethodBeat.o(186999);
              }
            }
            else if (paramAnonymous2MenuItem.type == 3)
            {
              uj localuj = new uj();
              localuj.dzH.userName = paramAnonymous2MenuItem.DOb;
              localuj.dzH.dzJ = bt.by(paramAnonymous2MenuItem.DOc, "");
              localuj.dzH.scene = 1072;
              localuj.dzH.dzK = 0;
              com.tencent.mm.sdk.b.a.ESL.l(localuj);
              com.tencent.mm.plugin.report.service.h.vKh.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramAnonymous2MenuItem.doh, paramAnonymous2MenuItem.DOb, paramAnonymous2MenuItem.DOc, "", Integer.valueOf(2) });
            }
            AppMethodBeat.o(186999);
          }
        };
        paramAnonymousView.csG();
        AppMethodBeat.o(187000);
      }
    });
    AppMethodBeat.o(64174);
  }
  
  public boolean e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
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
    if (bt.isNullOrNil(this.mTrueName))
    {
      this.mTrueName = s.ecc().getTrueName();
      this.mTrueName = com.tencent.mm.wallet_core.ui.e.aNf(this.mTrueName);
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
    this.lxI = getPreferenceScreen();
    this.nXS = ((RelativeLayout)findViewById(2131304239));
    this.nXT = findViewById(2131298462);
    this.nYH = findViewById(2131298463);
    this.nXO = ((WalletTextView)findViewById(2131298452));
    this.nXN = ((TextView)findViewById(2131298451));
    this.nXP = ((TextView)findViewById(2131298453));
    this.nXQ = ((TextView)findViewById(2131298461));
    this.nYd = ((LinearLayout)findViewById(2131302956));
    this.nYe = ((TextView)findViewById(2131297186));
    this.nXV = ((RelativeLayout)findViewById(2131298459));
    this.nXW = findViewById(2131298457);
    this.nYr = LayoutInflater.from(this).inflate(2131493561, null, false);
    this.nXR = ((TextView)findViewById(2131298471));
    Object localObject = new SpannableStringBuilder(getString(2131757476));
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dI(View paramAnonymousView)
      {
        AppMethodBeat.i(64132);
        CollectMainUI.a(CollectMainUI.this, CollectMainUI.b(CollectMainUI.this));
        CollectMainUI.c(CollectMainUI.this);
        if (CollectMainUI.b(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(20032, new Object[] { "wxface2face", "ClickQRCode", "", "", "", "", Integer.valueOf(2), Integer.valueOf(CollectMainUI.b(CollectMainUI.this).ntg), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(13944, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(64132);
      }
    }), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.nXR.setText((CharSequence)localObject);
    this.nXR.setClickable(true);
    this.nXR.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    getListView().addFooterView(this.nYr, null, false);
    getListView().setFooterDividersEnabled(false);
    this.nXM = ((ImageView)findViewById(2131298456));
    this.lln = ((TextView)findViewById(2131298477));
    this.nYc = ((TextView)findViewById(2131298490));
    this.nYc.setClickable(true);
    this.nYc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.nYt = new SpannableStringBuilder(getString(2131757464));
    this.nYu = new SpannableStringBuilder(getString(2131757465));
    localObject = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dI(View paramAnonymousView)
      {
        AppMethodBeat.i(64133);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeUI.class);
        paramAnonymousView.putExtra("key_currency_unit", CollectMainUI.this.nYi);
        CollectMainUI.this.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(64133);
      }
    });
    final com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dI(View paramAnonymousView)
      {
        AppMethodBeat.i(64134);
        CollectMainUI.this.nYp = false;
        CollectMainUI.this.bPo();
        CollectMainUI.h(CollectMainUI.this).setText(CollectMainUI.g(CollectMainUI.this));
        CollectMainUI.i(CollectMainUI.this);
        AppMethodBeat.o(64134);
      }
    });
    this.nYt.setSpan(localObject, 0, this.nYt.length(), 18);
    if (a.a.eSf().eSe()) {
      this.nYc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64135);
          if (CollectMainUI.h(CollectMainUI.this).getText().toString().equals(CollectMainUI.j(CollectMainUI.this)))
          {
            this.nZk.onClick(paramAnonymousView);
            AppMethodBeat.o(64135);
            return;
          }
          localq.onClick(paramAnonymousView);
          AppMethodBeat.o(64135);
        }
      });
    }
    this.nYu.setSpan(localq, 0, this.nYu.length(), 18);
    this.nYc.setText(this.nYt);
    this.nYf = ((RelativeLayout)findViewById(2131298479));
    this.nXM.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64140);
        CollectMainUI.b(CollectMainUI.this, CollectMainUI.k(CollectMainUI.this));
        if (CollectMainUI.k(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(20032, new Object[] { "wxface2face", "LongClick", "", "", "", "", Integer.valueOf(3), Integer.valueOf(CollectMainUI.k(CollectMainUI.this).ntg), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        AppMethodBeat.o(64140);
        return true;
      }
    });
    this.nXY = findViewById(2131298464);
    this.nXZ = ((ImageView)findViewById(2131298481));
    this.nYa = ((TextView)findViewById(2131298483));
    this.nYb = ((TextView)findViewById(2131298482));
    this.nYC = ((CdnImageView)findViewById(2131298421));
    this.nYD = ((TextView)findViewById(2131298424));
    this.nYE = ((TextView)findViewById(2131298425));
    this.nYF = ((ImageView)findViewById(2131298423));
    this.nYG = ((ViewGroup)findViewById(2131298422));
    this.nXV.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64141);
        int[] arrayOfInt = new int[2];
        CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
        CollectMainUI.zK(arrayOfInt[1]);
        AppMethodBeat.o(64141);
      }
    }, 300L);
    localObject = new xd();
    ((xd)localObject).dCC.scene = "8";
    ((xd)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64114);
        if (!bt.isNullOrNil(this.nYZ.dCD.dCE))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)CollectMainUI.this.findViewById(2131297186), this.nYZ.dCD.dCE, this.nYZ.dCD.content, this.nYZ.dCD.url);
          AppMethodBeat.o(64114);
          return;
        }
        ad.i("MicroMsg.CollectMainUI", "no bulletin data");
        AppMethodBeat.o(64114);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    this.nYO = ((LinearLayout)findViewById(2131307177));
    this.nYP = ((TextView)findViewById(2131307180));
    this.nYQ = ((Button)findViewById(2131307178));
    this.nYR = ((Button)findViewById(2131307179));
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
        this.nYj = paramIntent.getStringExtra("ftf_pay_url");
        this.nYk = paramIntent.getIntExtra("key_error_level", -1);
        this.nYm = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.nYn = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.nYo = paramIntent.getStringExtra("ftf_fixed_desc");
        this.nYi = paramIntent.getStringExtra("key_currency_unit");
        this.nYc.setText(this.nYu);
      }
      for (this.nYp = true;; this.nYp = false)
      {
        refreshView();
        bPq();
        AppMethodBeat.o(64161);
        return;
      }
      this.nXu = com.tencent.mm.model.u.aqL();
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
    com.tencent.mm.kernel.g.afC();
    this.dCy = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
    this.nXu = com.tencent.mm.model.u.aqL();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.h.vKh.f(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(2130772144, 2130772141);
    com.tencent.mm.plugin.collect.a.a.bOn();
    paramBundle = com.tencent.mm.plugin.collect.a.a.bOo();
    if (!paramBundle.nqa.contains(this)) {
      paramBundle.nqa.add(this);
    }
    initView();
    bPl();
    refreshView();
    this.lRO = ((Vibrator)getSystemService("vibrator"));
    this.mDF = bt.aGK();
    if (nYU < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      nYU = paramBundle.widthPixels / 2 - BackwardSupportUtil.b.g(getContext(), 20.0F);
      nYV = BackwardSupportUtil.b.g(getContext(), 60.0F);
      nYW = BackwardSupportUtil.b.g(getContext(), 40.0F);
      nYX = BackwardSupportUtil.b.g(getContext(), 70.0F);
    }
    bPq();
    com.tencent.mm.wallet_core.c.ab.jZ(16, 0);
    com.tencent.mm.kernel.g.aeS().a(3781, this);
    AppMethodBeat.o(64150);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64152);
    if (this.nXM != null) {
      this.nXM.setImageBitmap(null);
    }
    Object localObject = this.nYg;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ad.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.nXU != null) {
      this.nXU.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.bOn();
    com.tencent.mm.plugin.collect.a.a.bOo().nqa.remove(this);
    this.lRO.cancel();
    if (this.nYv != null)
    {
      localObject = this.nYv;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).mwx.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ad.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).mwx.clear();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(1588, (com.tencent.mm.al.g)localObject);
    }
    com.tencent.mm.platformtools.u.c(this.nYT);
    com.tencent.mm.kernel.g.aeS().b(3781, this);
    super.onDestroy();
    AppMethodBeat.o(64152);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64163);
    super.onPause();
    bh.a(this, null);
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
    bh.a(this, this);
    AppMethodBeat.o(64162);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(187014);
    ad.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m)) {
      ad.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
    }
    AppMethodBeat.o(187014);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(64155);
    if (bt.isNullOrNil(this.nYh))
    {
      ad.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(64155);
      return;
    }
    if (this.nYw == 1)
    {
      if (!bt.isNullOrNil(this.nYx)) {
        this.lln.setText(this.nYx);
      }
      if (!bt.isNullOrNil(this.nYy))
      {
        TextView localTextView = (TextView)findViewById(2131298458);
        localTextView.setText(this.nYy);
        localTextView.setVisibility(0);
      }
    }
    bPo();
    bPr();
    bPs();
    bPt();
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
      this.dcF = paramu.dcF;
      this.nUf = paramu.nUf;
      this.nUh = paramu.nUh;
      this.scene = paramu.scene;
      this.status = paramu.status;
      this.fyo = paramu.fyo;
    }
  }
  
  final class b
  {
    boolean nZm;
    LinkedList<CollectMainUI.a> nZn;
    
    private b()
    {
      AppMethodBeat.i(64145);
      this.nZn = new LinkedList();
      AppMethodBeat.o(64145);
    }
    
    private void a(final CollectMainUI.a parama)
    {
      AppMethodBeat.i(64148);
      this.nZm = true;
      CollectMainUI.n(CollectMainUI.this);
      CollectMainUI.q(CollectMainUI.this).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.l(CollectMainUI.this).getWidth(), CollectMainUI.l(CollectMainUI.this).getHeight()));
      if (CollectMainUI.this.nYp) {
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.bPB(), 0, 0);
      }
      final AnimationSet localAnimationSet;
      int j;
      for (;;)
      {
        CollectMainUI.r(CollectMainUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(CollectMainUI.this.getContext(), parama.fyo, CollectMainUI.r(CollectMainUI.this).getTextSize()));
        a.b.c(CollectMainUI.s(CollectMainUI.this), parama.username);
        CollectMainUI.t(CollectMainUI.this).setText(com.tencent.mm.wallet_core.ui.e.d(parama.nUf, parama.dem));
        CollectMainUI.q(CollectMainUI.this).setVisibility(0);
        localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
        j = 0;
        int i = 0;
        while (i < CollectMainUI.u(CollectMainUI.this).size())
        {
          if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dcF.equals(parama.dcF)) {
            j = i;
          }
          i += 1;
        }
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.bPC(), 0, 0);
      }
      localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.bPz(), 0.0F, zL(j)));
      localAnimationSet.setDuration(300L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64142);
          CollectMainUI.q(CollectMainUI.this).setVisibility(8);
          ad.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + parama.dcF);
          int i = 0;
          for (;;)
          {
            if (i < CollectMainUI.u(CollectMainUI.this).size())
            {
              if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dcF.equals(parama.dcF))
              {
                ((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).isAnimated = true;
                ad.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + parama.dcF);
              }
            }
            else
            {
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.b.this.nZm = false;
              CollectMainUI.b.this.bPF();
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
    
    private int zL(int paramInt)
    {
      AppMethodBeat.i(64146);
      float f2 = 0.0F + CollectMainUI.l(CollectMainUI.this).getHeight() / 2;
      float f1 = f2;
      if (CollectMainUI.p(CollectMainUI.this).getVisibility() == 0) {
        f1 = f2 + CollectMainUI.p(CollectMainUI.this).getHeight();
      }
      f2 = CollectMainUI.bPA() * paramInt + CollectMainUI.bPA() / 2;
      int[] arrayOfInt = new int[2];
      CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
      paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.bwt()));
      AppMethodBeat.o(64146);
      return paramInt;
    }
    
    public final void bPF()
    {
      AppMethodBeat.i(64147);
      if (!this.nZm)
      {
        if (!this.nZn.isEmpty())
        {
          a((CollectMainUI.a)this.nZn.poll());
          AppMethodBeat.o(64147);
        }
      }
      else {
        ad.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.nZn.size());
      }
      AppMethodBeat.o(64147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */