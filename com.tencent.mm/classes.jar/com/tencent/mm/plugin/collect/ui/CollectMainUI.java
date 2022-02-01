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
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.protocal.protobuf.ehz;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.f.c;
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

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(0)
public class CollectMainUI
  extends WalletPreferenceUI
  implements com.tencent.mm.ak.i, d.a, ScreenShotUtil.ScreenShotCallback
{
  private static int qBI = -1;
  private static int qBJ = -1;
  private static int qBK = -1;
  private static int qBL = -1;
  private static int qBc;
  private int efI;
  private long iOB;
  protected String mTrueName;
  private TextView nAB;
  private com.tencent.mm.ui.base.preference.f nRm;
  private com.tencent.mm.ui.widget.a.e oXS;
  private Vibrator ooM;
  private WalletTextView qAA;
  private TextView qAB;
  private TextView qAC;
  private TextView qAD;
  private RelativeLayout qAE;
  private View qAF;
  private Dialog qAG;
  private View qAH;
  private View qAI;
  private boolean qAJ;
  private View qAK;
  private ImageView qAL;
  private TextView qAM;
  private TextView qAN;
  private TextView qAO;
  protected LinearLayout qAP;
  protected TextView qAQ;
  private RelativeLayout qAR;
  private Bitmap qAS;
  protected String qAT;
  protected String qAU;
  private String qAV;
  private int qAW;
  private List<CollectMainUI.a> qAX;
  private double qAY;
  private String qAZ;
  private long qAb;
  private int qAv;
  private int qAw;
  private com.tencent.mm.ui.widget.a.g qAx;
  private ImageView qAy;
  private TextView qAz;
  private LinearLayout qBA;
  private TextView qBB;
  private TextView qBC;
  private TextView qBD;
  private com.tencent.mm.bw.b qBE;
  private com.tencent.mm.ui.widget.a.f.a qBF;
  private com.tencent.mm.ui.widget.a.e qBG;
  private u.a qBH;
  private String qBa;
  protected boolean qBb;
  private View qBd;
  private b qBe;
  private SpannableStringBuilder qBf;
  private SpannableStringBuilder qBg;
  private com.tencent.mm.plugin.collect.model.f qBh;
  private int qBi;
  private String qBj;
  private String qBk;
  private String qBl;
  private String qBm;
  private String qBn;
  protected CdnImageView qBo;
  protected TextView qBp;
  protected TextView qBq;
  protected ImageView qBr;
  protected ViewGroup qBs;
  protected View qBt;
  private boolean qBu;
  private int qBv;
  private coz qBw;
  private dgo qBx;
  private dgo qBy;
  private dgo qBz;
  protected ScrollView qyA;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(64149);
    this.qAy = null;
    this.qAz = null;
    this.qAA = null;
    this.qAB = null;
    this.qAC = null;
    this.qAD = null;
    this.qAE = null;
    this.qAF = null;
    this.nAB = null;
    this.nRm = null;
    this.qAG = null;
    this.qAH = null;
    this.qAI = null;
    this.qyA = null;
    this.qAJ = false;
    this.qAK = null;
    this.qAS = null;
    this.qAT = null;
    this.mTrueName = null;
    this.qAU = null;
    this.qAV = null;
    this.qAX = new LinkedList();
    this.qAZ = null;
    this.qBa = null;
    this.qBb = false;
    this.qBe = new b((byte)0);
    this.qBi = 0;
    this.qBu = false;
    this.qBv = 0;
    this.qBH = new u.a()
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
          Log.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(CollectMainUI.this), paramAnonymousString });
          CollectMainUI.this.cAq();
        }
        AppMethodBeat.o(64125);
      }
    };
    AppMethodBeat.o(64149);
  }
  
  private void Fe(int paramInt)
  {
    AppMethodBeat.i(213216);
    int i = cAy();
    Object localObject = cAz();
    String str = cAA();
    Log.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str, this.qBE });
    localObject = new com.tencent.mm.plugin.collect.model.m(paramInt, i, (String)localObject, str, this.qBE);
    com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject, 0);
    AppMethodBeat.o(213216);
  }
  
  private void a(final adw paramadw)
  {
    AppMethodBeat.i(213220);
    if (paramadw == null)
    {
      Log.i("MicroMsg.CollectMainUI", " coverInfo == null");
      AppMethodBeat.o(213220);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "showCoverUI");
    this.qBA.setVisibility(0);
    this.qBA.setOnClickListener(new CollectMainUI.14(this));
    ViewGroup.LayoutParams localLayoutParams = this.qBA.getLayoutParams();
    localLayoutParams.height = this.qAH.getHeight();
    this.qBA.setLayoutParams(localLayoutParams);
    this.qBB.setText(paramadw.dQx);
    this.qBC.setText(paramadw.Lpp.dQx);
    this.qBC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213206);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramadw.Lpp);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213206);
      }
    });
    this.qBD.setText(paramadw.Lpq.dQx);
    this.qBD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213207);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramadw.Lpq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213207);
      }
    });
    AppMethodBeat.o(213220);
  }
  
  private void a(cas paramcas)
  {
    AppMethodBeat.i(213219);
    if ((paramcas == null) || ((this.qAx != null) && (this.qAx.isShowing())))
    {
      Log.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
      AppMethodBeat.o(213219);
      return;
    }
    if ((this.oXS != null) && (this.oXS.isShowing()))
    {
      Log.i("MicroMsg.CollectMainUI", "mBottomSheet != null && mBottomSheet.isShowing()");
      AppMethodBeat.o(213219);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "showHalfDialog");
    Object localObject1 = paramcas.MfW;
    Object localObject2 = paramcas.MfX;
    this.qAv = 4;
    this.qAx = new com.tencent.mm.ui.widget.a.g(getContext(), 1, 3);
    this.qAx.b(((dgp)localObject1).dQx, ((dgp)localObject2).dQx);
    this.qAx.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(213204);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.qBV);
        CollectMainUI.D(CollectMainUI.this).bMo();
        CollectMainUI.E(CollectMainUI.this);
        AppMethodBeat.o(213204);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(213205);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.qBW);
        CollectMainUI.D(CollectMainUI.this).bMo();
        CollectMainUI.E(CollectMainUI.this);
        AppMethodBeat.o(213205);
      }
    });
    if (paramcas.MfV.type == 2)
    {
      localObject1 = View.inflate(getContext(), 2131493675, null);
      ((ImageView)((View)localObject1).findViewById(2131297165)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64126);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          CollectMainUI.D(CollectMainUI.this).bMo();
          CollectMainUI.E(CollectMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64126);
        }
      });
      localObject2 = (TextView)((View)localObject1).findViewById(2131298857);
      ((TextView)localObject2).setText(paramcas.MfV.Nhm);
      com.tencent.mm.ui.ao.a(((TextView)localObject2).getPaint(), 0.8F);
      this.qAx.setHeaderView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = View.inflate(getContext(), 2131493673, null);
      ((TextView)((View)localObject1).findViewById(2131302235)).setText(paramcas.dQx);
      this.qAx.setCustomView((View)localObject1);
      this.qAx.dGm();
      AppMethodBeat.o(213219);
      return;
      localObject1 = View.inflate(getContext(), 2131493674, null);
      localObject2 = (TextView)((View)localObject1).findViewById(2131302237);
      ((TextView)localObject2).setText(paramcas.MfV.Nhm);
      com.tencent.mm.ui.ao.a(((TextView)localObject2).getPaint(), 0.8F);
      this.qAx.setHeaderView((View)localObject1);
    }
  }
  
  private void a(dgo paramdgo)
  {
    AppMethodBeat.i(213218);
    if (paramdgo == null)
    {
      Log.i("MicroMsg.CollectMainUI", "actionInfo is null");
      AppMethodBeat.o(213218);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", new Object[] { Integer.valueOf(paramdgo.pTI) });
    switch (paramdgo.pTI)
    {
    default: 
      Log.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
      AppMethodBeat.o(213218);
      return;
    case 0: 
      AppMethodBeat.o(213218);
      return;
    case 1: 
      a(paramdgo.MLg);
      AppMethodBeat.o(213218);
      return;
    case 2: 
      a(paramdgo.MLh);
      AppMethodBeat.o(213218);
      return;
    }
    a(paramdgo.MLi);
    AppMethodBeat.o(213218);
  }
  
  private void a(final dgo paramdgo, final adw paramadw)
  {
    AppMethodBeat.i(213222);
    Log.i("MicroMsg.CollectMainUI", "doSaveQrCode");
    Object localObject;
    if ((this.qAS != null) && (!this.qAS.isRecycled()))
    {
      i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.qAT, z.aTY(), this.qBi, this.qBl, i, this.qBH, false, this.qAW, 0.0F, true);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.qBb)
        {
          h.CyF.a(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.qAY * 100.0D)) });
          if (this.qAJ) {
            break label661;
          }
          this.qyA = ((ScrollView)((ViewStub)findViewById(2131298890)).inflate());
          cAp();
          this.qAJ = true;
        }
      }
    }
    label661:
    for (int i = 250;; i = 0)
    {
      this.qyA.setVisibility(4);
      ((ImageView)this.qyA.findViewById(2131298884)).setImageBitmap(this.qAS);
      TextView localTextView1 = (TextView)this.qyA.findViewById(2131298886);
      TextView localTextView2 = (TextView)this.qyA.findViewById(2131298887);
      final LinearLayout localLinearLayout1 = (LinearLayout)this.qyA.findViewById(2131298907);
      LinearLayout localLinearLayout2 = (LinearLayout)this.qyA.findViewById(2131298883);
      TextView localTextView3 = (TextView)this.qyA.findViewById(2131298880);
      TextView localTextView4 = (TextView)this.qyA.findViewById(2131298881);
      TextView localTextView5 = (TextView)this.qyA.findViewById(2131298882);
      String str1 = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(z.aTY()), 10);
      String str2 = getTrueName();
      localObject = str1;
      if (!Util.isNullOrNil(str2)) {
        localObject = str1 + getString(2131757694, new Object[] { str2 });
      }
      if (this.qBi == 1) {
        if (!Util.isNullOrNil(this.qBk))
        {
          localTextView1.setText(this.qBk);
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          label420:
          if (!this.qBb) {
            break label616;
          }
          if (Util.isNullOrNil(this.qBa)) {
            break label606;
          }
          localTextView4.setText(this.qBa);
          localTextView4.setVisibility(0);
          label452:
          localTextView3.setText(cAo());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.qAY));
          localLinearLayout2.setVisibility(0);
          label479:
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64117);
              Log.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(localLinearLayout1.getHeight()), Integer.valueOf(localLinearLayout1.getWidth()) });
              Bitmap localBitmap = Bitmap.createBitmap(localLinearLayout1.getWidth(), localLinearLayout1.getHeight(), Bitmap.Config.ARGB_8888);
              Object localObject = new Canvas(localBitmap);
              localLinearLayout1.draw((Canvas)localObject);
              try
              {
                localObject = s.getSysCameraDirPath() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
                if (this.qBP)
                {
                  Log.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
                  CollectMainUI.a(CollectMainUI.this, CollectMainUI.this.getContext(), CollectMainUI.this.getContext().getResources().getString(2131757706), paramdgo, paramadw);
                }
                s.refreshMediaScanner((String)localObject, CollectMainUI.this.getContext());
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
                }
              }
              CollectMainUI.this.qyA.setVisibility(8);
              AppMethodBeat.o(64117);
            }
          }, i);
          i = 1;
          label498:
          if (i == 0)
          {
            Log.w("MicroMsg.CollectMainUI", "save ftf pay qrcode fail");
            Toast.makeText(getContext(), getString(2131757709), 1).show();
          }
        }
      }
      for (;;)
      {
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(213222);
        return;
        h.CyF.a(11343, new Object[] { Integer.valueOf(0) });
        break;
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label420;
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label420;
        label606:
        localTextView4.setVisibility(8);
        break label452;
        label616:
        localLinearLayout2.setVisibility(8);
        break label479;
        i = 0;
        break label498;
        Log.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
        Toast.makeText(getContext(), getString(2131757709), 1).show();
      }
    }
  }
  
  private void a(final qs paramqs)
  {
    AppMethodBeat.i(213221);
    if (paramqs == null)
    {
      Log.i("MicroMsg.CollectMainUI", " bottomCell == null");
      AppMethodBeat.o(213221);
      return;
    }
    this.qAv = 3;
    this.oXS = new com.tencent.mm.ui.widget.a.e(getContext(), 1, true);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 56));
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(getResources().getColor(2131099748));
    localTextView.setText(paramqs.KXy);
    this.oXS.V(localTextView, false);
    this.oXS.QOp = true;
    this.oXS.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(213208);
        Iterator localIterator = paramqs.KXz.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          dgp localdgp = (dgp)localIterator.next();
          if ((localdgp != null) && (localdgp.dQx != null))
          {
            paramAnonymousm.d(i, localdgp.dQx);
            i += 1;
          }
        }
        AppMethodBeat.o(213208);
      }
    };
    this.oXS.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(213209);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        paramAnonymousMenuItem = (dgp)paramqs.KXz.get(paramAnonymousInt);
        CollectMainUI.d(CollectMainUI.this, 2);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousMenuItem);
        AppMethodBeat.o(213209);
      }
    };
    this.oXS.dGm();
    AppMethodBeat.o(213221);
  }
  
  private static cor aJ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64171);
    cor localcor = new cor();
    localcor.type = paramJSONObject.optInt("type", -1);
    localcor.url = paramJSONObject.optString("url", "");
    localcor.dQx = paramJSONObject.optString("wording", "");
    localcor.MuQ = paramJSONObject.optString("waapp_username", "");
    localcor.MuR = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(64171);
    return localcor;
  }
  
  private String cAA()
  {
    AppMethodBeat.i(213215);
    if (this.qBb)
    {
      if (Util.isNullOrNil(this.qAV))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(213215);
        return "";
      }
      str = this.qAV;
      AppMethodBeat.o(213215);
      return str;
    }
    if (Util.isNullOrNil(this.qAT))
    {
      Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
      AppMethodBeat.o(213215);
      return "";
    }
    String str = this.qAT;
    AppMethodBeat.o(213215);
    return str;
  }
  
  private void cAs()
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
  
  private void cAt()
  {
    AppMethodBeat.i(64158);
    double d;
    if ((this.qAX != null) && (this.qAX.size() > 0))
    {
      this.qAH.setBackgroundResource(2131231862);
      this.nRm.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.qAX.size())
      {
        CollectMainUI.a locala = (CollectMainUI.a)this.qAX.get(i);
        c localc;
        if (i == this.qAX.size() - 1)
        {
          localc = new c(this, (byte)0);
          label102:
          localc.setKey(String.valueOf(i));
          String str2 = locala.gCv;
          String str1 = str2;
          if (Util.isNullOrNil(str2))
          {
            str1 = str2;
            if (!Util.isNullOrNil(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.f.getDisplayName(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.goe = locala.username;
          if (locala.status != 0) {
            break label219;
          }
          localc.setSummary(2131757690);
        }
        for (;;)
        {
          this.nRm.c(localc);
          i += 1;
          break;
          localc = new c(this);
          break label102;
          label219:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.qwJ;
              localc.setSummary(com.tencent.mm.wallet_core.ui.f.d(locala.qwJ, locala.dFv));
            }
            for (;;)
            {
              this.nRm.c(localc);
              break;
              localc.setSummary(2131757689);
            }
          }
          if (locala.status == 2) {
            localc.setSummary(2131757688);
          }
        }
      }
      this.nRm.notifyDataSetChanged();
      this.qAC.setText(com.tencent.mm.wallet_core.ui.f.d(d, ((CollectMainUI.a)this.qAX.get(0)).dFv));
      this.qAC.setVisibility(0);
    }
    for (;;)
    {
      if ((this.qAX != null) && (this.qAX.size() > 0))
      {
        this.qBs.setBackgroundResource(2131231863);
        this.qAF.setVisibility(0);
        if ((d > 0.0D) && (this.qAX.size() > 0))
        {
          this.qBt.setVisibility(0);
          this.qAI.setVisibility(0);
          AppMethodBeat.o(64158);
        }
      }
      else
      {
        this.qAC.setVisibility(8);
        this.qAF.setVisibility(8);
        this.qAI.setVisibility(8);
      }
      AppMethodBeat.o(64158);
      return;
      d = 0.0D;
    }
  }
  
  private void cAu()
  {
    AppMethodBeat.i(64166);
    bf localbf = k.fQy();
    if (this.qBb) {}
    for (int i = 33;; i = 32)
    {
      if (localbf != null) {
        h.CyF.a(13447, new Object[] { Integer.valueOf(i), localbf.KED, localbf.KEE, this.qAT, Double.valueOf(this.qAY), Long.valueOf(Util.nowSecond()), Long.valueOf(localbf.KEC), localbf.KEF, localbf.KEG });
      }
      AppMethodBeat.o(64166);
      return;
    }
  }
  
  private void cAv()
  {
    AppMethodBeat.i(64167);
    if (!Util.isNullOrNil(this.qBm))
    {
      this.qAQ.setText(this.qBm);
      this.qAQ.setOnClickListener(new CollectMainUI.6(this));
      this.qAP.setVisibility(0);
      AppMethodBeat.o(64167);
      return;
    }
    this.qAP.setVisibility(8);
    AppMethodBeat.o(64167);
  }
  
  private static cor cAw()
  {
    AppMethodBeat.i(64169);
    try
    {
      com.tencent.mm.kernel.g.aAi();
      cor localcor = aJ(new JSONObject((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdI, "")));
      AppMethodBeat.o(64169);
      return localcor;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64169);
    }
    return null;
  }
  
  private static List<cor> cAx()
  {
    AppMethodBeat.i(64170);
    localArrayList = new ArrayList();
    try
    {
      com.tencent.mm.kernel.g.aAi();
      Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdK, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(aJ(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64170);
    }
  }
  
  private int cAy()
  {
    AppMethodBeat.i(213213);
    if ((this.qAA.isShown()) && (!Util.isNullOrNil(this.qAA.getText())))
    {
      int i = Integer.parseInt(com.tencent.mm.wallet_core.ui.f.c(this.qAA.getText(), "100", 0, RoundingMode.HALF_UP).toString());
      AppMethodBeat.o(213213);
      return i;
    }
    AppMethodBeat.o(213213);
    return 0;
  }
  
  private String cAz()
  {
    AppMethodBeat.i(213214);
    if ((this.qAz.isShown()) && (!Util.isNullOrNil(this.qAz.getText())))
    {
      String str = this.qAz.getText().toString();
      AppMethodBeat.o(213214);
      return str;
    }
    AppMethodBeat.o(213214);
    return "";
  }
  
  private Bitmap cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(64159);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, z.aTY(), this.qBi, this.qBl, this.qBH, paramInt);
    AppMethodBeat.o(64159);
    return paramString;
  }
  
  public final void a(com.tencent.mm.plugin.collect.model.u paramu)
  {
    int k = 0;
    AppMethodBeat.i(64160);
    Log.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.efI != 1) && (this.efI != 0)) || ((paramu.msgType == 9) || ((this.efI == 8) && (paramu.msgType == 26))))
    {
      if (this.ooM != null) {
        this.ooM.vibrate(50L);
      }
      if (paramu.qwL < this.iOB)
      {
        Log.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(64160);
        return;
      }
      i = 0;
      if (i >= this.qAX.size()) {
        break label510;
      }
      if ((paramu.status != 0) || (!Util.nullAsNil(paramu.username).equals(((CollectMainUI.a)this.qAX.get(i)).username)) || (((CollectMainUI.a)this.qAX.get(i)).status != 2)) {
        break label320;
      }
      this.qAX.remove(i);
      this.qAX.add(i, new CollectMainUI.a(this, paramu));
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
        if (i < this.qAX.size())
        {
          localObject = (com.tencent.mm.plugin.collect.model.u)this.qAX.get(i);
          if (paramu.qwL > ((com.tencent.mm.plugin.collect.model.u)localObject).qwL)
          {
            this.qAX.add(i, new CollectMainUI.a(this, paramu));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.qAX.add(new CollectMainUI.a(this, paramu));
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64116);
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.o(CollectMainUI.this).cAF();
              CollectMainUI.i(CollectMainUI.this);
              AppMethodBeat.o(64116);
            }
          });
          AppMethodBeat.o(64160);
          return;
          label320:
          if (paramu.dDM.equals(((CollectMainUI.a)this.qAX.get(i)).dDM))
          {
            Log.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramu.dDM);
            if (((CollectMainUI.a)this.qAX.get(i)).status == 0)
            {
              ((CollectMainUI.a)this.qAX.get(i)).status = paramu.status;
              ((CollectMainUI.a)this.qAX.get(i)).qwJ = paramu.qwJ;
              ((CollectMainUI.a)this.qAX.get(i)).dFv = paramu.dFv;
              if (paramu.status == 1)
              {
                localObject = this.qBe;
                CollectMainUI.a locala = (CollectMainUI.a)this.qAX.get(i);
                ((b)localObject).qCb.add(locala);
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
  
  protected void cAn()
  {
    AppMethodBeat.i(64168);
    if (com.tencent.mm.plugin.collect.model.f.qvI == null) {
      com.tencent.mm.plugin.collect.model.f.qvI = new com.tencent.mm.plugin.collect.model.f();
    }
    this.qBh = com.tencent.mm.plugin.collect.model.f.qvI;
    Object localObject = this.qBh;
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1588, (com.tencent.mm.ak.i)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.qBh;
    com.tencent.mm.plugin.collect.model.f.a local7 = new com.tencent.mm.plugin.collect.model.f.a()
    {
      public final void J(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        AppMethodBeat.i(213198);
        Log.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt) });
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.this.qAT = paramAnonymousString1;
        CollectMainUI.a(CollectMainUI.this, paramAnonymousInt);
        CollectMainUI.this.mTrueName = paramAnonymousString2;
        paramAnonymousString1 = CollectMainUI.cAD();
        paramAnonymousString2 = CollectMainUI.cAE();
        CollectMainUI.a(CollectMainUI.this, paramAnonymousString1);
        CollectMainUI.this.de(paramAnonymousString2);
        if (CollectMainUI.x(CollectMainUI.this) == 1)
        {
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.aAi();
          CollectMainUI.b(paramAnonymousString1, ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oeu, Integer.valueOf(-1))).intValue());
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.aAi();
          CollectMainUI.a(paramAnonymousString1, (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oev, ""));
        }
        AppMethodBeat.o(213198);
      }
      
      public final void a(boolean paramAnonymousBoolean, vv paramAnonymousvv)
      {
        AppMethodBeat.i(213199);
        Object localObject;
        if (paramAnonymousvv == null)
        {
          localObject = "null";
          Log.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), localObject });
          if (!paramAnonymousBoolean) {
            break label499;
          }
          if ((paramAnonymousvv == null) || (paramAnonymousvv.dDN != 416)) {
            break label189;
          }
          if (paramAnonymousvv.LgT != null) {
            break label184;
          }
        }
        label184:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          Log.d("MicroMsg.CollectMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectMainUI.w(CollectMainUI.this).setVisibility(4);
          CollectMainUI.a(CollectMainUI.this, true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
          ((Bundle)localObject).putString("realname_verify_process_jump_plugin", "collect");
          CollectMainUI localCollectMainUI = CollectMainUI.this;
          int i = paramAnonymousvv.dDN;
          paramAnonymousvv = paramAnonymousvv.LgT;
          new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(213197);
              Log.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
              AppMethodBeat.o(213197);
            }
          };
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localCollectMainUI, i, paramAnonymousvv, (Bundle)localObject, 1010);
          AppMethodBeat.o(213199);
          return;
          localObject = Integer.valueOf(paramAnonymousvv.dDN);
          break;
        }
        label189:
        CollectMainUI.this.cAr();
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.a(CollectMainUI.this, false);
        CollectMainUI.this.qAT = paramAnonymousvv.url;
        CollectMainUI.a(CollectMainUI.this, ag.aqj(paramAnonymousvv.LgF));
        CollectMainUI.this.mTrueName = paramAnonymousvv.HTZ;
        CollectMainUI.b(CollectMainUI.this, paramAnonymousvv.CpF);
        CollectMainUI.b(CollectMainUI.this, paramAnonymousvv.CpG);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousvv.CpH);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousvv.LgQ);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousvv.jTx);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousvv.jTy);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousvv.LgN);
        CollectMainUI.this.de(paramAnonymousvv.LgM);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousvv.LgR);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousvv.LgS);
        Log.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.y(CollectMainUI.this)) });
        CollectMainUI.c(CollectMainUI.this, paramAnonymousvv.LgX);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousvv.LgY);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousvv.LgZ);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousvv.Lha);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oeu, Integer.valueOf(CollectMainUI.z(CollectMainUI.this)));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oev, CollectMainUI.a(CollectMainUI.this));
        CollectMainUI.this.refreshView();
        label499:
        AppMethodBeat.o(213199);
      }
    };
    com.tencent.mm.kernel.g.aAi();
    String str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdF, "");
    com.tencent.mm.kernel.g.aAi();
    String str2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdG, "");
    com.tencent.mm.kernel.g.aAi();
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdH, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRr();
    }
    local7.J((String)localObject, str2, i);
    localObject = new com.tencent.mm.plugin.collect.model.l();
    localf.oPn.put(localObject, local7);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
    AppMethodBeat.o(64168);
  }
  
  protected String cAo()
  {
    AppMethodBeat.i(64173);
    String str = com.tencent.mm.wallet_core.ui.f.bpp(this.qAZ);
    AppMethodBeat.o(64173);
    return str;
  }
  
  protected void cAp() {}
  
  protected void cAq()
  {
    AppMethodBeat.i(64156);
    this.qAy.setImageBitmap(null);
    if (this.qBb)
    {
      if (Util.isNullOrNil(this.qAV))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.qAS = cU(this.qAV, this.qAW);
      if ((this.qAS == null) || (this.qAS.isRecycled())) {
        break label237;
      }
      this.qAy.setImageBitmap(this.qAS);
      label91:
      if (!this.qBb) {
        break label281;
      }
      this.qAA.setPrefix(cAo());
      this.qAA.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.qAY));
      this.qAA.setVisibility(0);
      if (Util.isNullOrNil(this.qBa)) {
        break label269;
      }
      this.qAz.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.qBa, this.qAz.getTextSize()));
      this.qAz.setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131298868).setVisibility(0);
      AppMethodBeat.o(64156);
      return;
      if (Util.isNullOrNil(this.qAT))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.qAS = cU(this.qAT, this.qAW);
      break;
      label237:
      Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + Util.nullAsNil(this.qAV));
      break label91;
      label269:
      this.qAz.setVisibility(8);
    }
    label281:
    this.qAB.setVisibility(8);
    this.qAA.setVisibility(8);
    this.qAz.setVisibility(8);
    findViewById(2131298868).setVisibility(8);
    AppMethodBeat.o(64156);
  }
  
  protected final void cAr()
  {
    AppMethodBeat.i(213211);
    com.tencent.mm.kernel.g.aAi();
    if (((String)com.tencent.mm.kernel.g.aAh().azQ().get(327731, "0")).equals("0"))
    {
      this.qBF = new com.tencent.mm.ui.widget.a.f.a(getContext());
      this.qBF.aC(getResources().getString(2131757680));
      com.tencent.mm.ui.widget.a.f.a locala = this.qBF.bow(getResources().getString(ah.hhE())).Dq(true);
      locala.JnN = true;
      locala.apa(2131767407).b(new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(327731, "1");
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().gBI();
    }
    AppMethodBeat.o(213211);
  }
  
  protected final void de(final List<cor> paramList)
  {
    AppMethodBeat.i(64174);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        cor localcor = (cor)localIterator.next();
        if (localcor.type == 1) {
          h.CyF.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localcor.dQx, "", "", "", Integer.valueOf(1) });
        } else if (localcor.type == 2) {
          h.CyF.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localcor.dQx, "", "", localcor.url, Integer.valueOf(1) });
        } else if (localcor.type == 3) {
          h.CyF.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localcor.dQx, localcor.MuQ, localcor.MuR, "", Integer.valueOf(1) });
        }
      }
    }
    this.qAR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213203);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CollectMainUI.a(CollectMainUI.this, new com.tencent.mm.ui.widget.a.e(CollectMainUI.this.getContext(), 1, false));
        CollectMainUI.A(CollectMainUI.this).HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(213201);
            com.tencent.mm.plugin.collect.a.a.czp();
            if (com.tencent.mm.plugin.collect.a.a.czr()) {
              paramAnonymous2m.add(0, 1, 0, 2131757676);
            }
            while (CollectMainUI.9.this.kmw != null)
            {
              int i = 0;
              while (i < CollectMainUI.9.this.kmw.size())
              {
                cor localcor = (cor)CollectMainUI.9.this.kmw.get(i);
                if (!Util.isNullOrNil(localcor.dQx)) {
                  paramAnonymous2m.add(0, i + 1 + 1, 0, localcor.dQx);
                }
                i += 1;
              }
              paramAnonymous2m.add(0, 1, 0, 2131757686);
            }
            AppMethodBeat.o(213201);
          }
        };
        CollectMainUI.A(CollectMainUI.this).HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(213202);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId() - 1 - 1;
              if (paramAnonymous2Int < 0)
              {
                Log.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                AppMethodBeat.o(213202);
                return;
              }
              break;
            case 1: 
              com.tencent.mm.plugin.collect.a.a.czp();
              if (com.tencent.mm.plugin.collect.a.a.czr())
              {
                CollectMainUI.B(CollectMainUI.this);
                Toast.makeText(CollectMainUI.this.getContext(), 2131757677, 1).show();
                h.CyF.a(13944, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(213202);
                return;
              }
              CollectMainUI.C(CollectMainUI.this);
              Toast.makeText(CollectMainUI.this.getContext(), 2131757687, 1).show();
              com.tencent.mm.plugin.collect.model.voice.a.czG().kN(false);
              h.CyF.a(13944, new Object[] { Integer.valueOf(7) });
              AppMethodBeat.o(213202);
              return;
            }
            paramAnonymous2MenuItem = (cor)CollectMainUI.9.this.kmw.get(paramAnonymous2Int);
            if (paramAnonymous2MenuItem.type == 1)
            {
              Log.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramAnonymous2MenuItem.url });
              h.CyF.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2MenuItem.dQx, "", "", "", Integer.valueOf(2) });
              AppMethodBeat.o(213202);
              return;
            }
            if (paramAnonymous2MenuItem.type == 2)
            {
              if (!Util.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                com.tencent.mm.wallet_core.ui.f.p(CollectMainUI.this.getContext(), paramAnonymous2MenuItem.url, false);
                h.CyF.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramAnonymous2MenuItem.dQx, "", "", paramAnonymous2MenuItem.url, Integer.valueOf(2) });
                AppMethodBeat.o(213202);
              }
            }
            else if (paramAnonymous2MenuItem.type == 3)
            {
              wq localwq = new wq();
              localwq.ecI.userName = paramAnonymous2MenuItem.MuQ;
              localwq.ecI.ecK = Util.nullAs(paramAnonymous2MenuItem.MuR, "");
              localwq.ecI.scene = 1072;
              localwq.ecI.ecL = 0;
              EventCenter.instance.publish(localwq);
              h.CyF.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramAnonymous2MenuItem.dQx, paramAnonymous2MenuItem.MuQ, paramAnonymous2MenuItem.MuR, "", Integer.valueOf(2) });
            }
            AppMethodBeat.o(213202);
          }
        };
        CollectMainUI.A(CollectMainUI.this).dGm();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213203);
      }
    });
    AppMethodBeat.o(64174);
  }
  
  public boolean e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(64165);
    super.finish();
    overridePendingTransition(2130772165, 2130772170);
    AppMethodBeat.o(64165);
  }
  
  public int getHeaderResourceId()
  {
    return 2131493678;
  }
  
  public int getLayoutId()
  {
    return 2131493676;
  }
  
  public int getResourceId()
  {
    return 2132017171;
  }
  
  protected String getTrueName()
  {
    AppMethodBeat.i(64172);
    if (Util.isNullOrNil(this.mTrueName))
    {
      this.mTrueName = com.tencent.mm.plugin.wallet_core.model.t.fQI().getTrueName();
      this.mTrueName = com.tencent.mm.wallet_core.ui.f.bps(this.mTrueName);
    }
    String str = this.mTrueName;
    AppMethodBeat.o(64172);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64153);
    setMMTitle(2131763756);
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
    this.nRm = getPreferenceScreen();
    this.qAE = ((RelativeLayout)findViewById(2131307157));
    this.qAF = findViewById(2131298875);
    this.qBt = findViewById(2131298876);
    this.qAA = ((WalletTextView)findViewById(2131298865));
    this.qAz = ((TextView)findViewById(2131298864));
    this.qAB = ((TextView)findViewById(2131298866));
    this.qAC = ((TextView)findViewById(2131298874));
    this.qAP = ((LinearLayout)findViewById(2131305543));
    this.qAQ = ((TextView)findViewById(2131297330));
    this.qAH = ((RelativeLayout)findViewById(2131298872));
    this.qAI = findViewById(2131298870);
    this.qBd = LayoutInflater.from(this).inflate(2131493677, null, false);
    this.qAD = ((TextView)findViewById(2131298885));
    Object localObject = new SpannableStringBuilder(getString(2131757695));
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
    {
      public final void dF(View paramAnonymousView)
      {
        AppMethodBeat.i(64132);
        CollectMainUI.a(CollectMainUI.this, CollectMainUI.b(CollectMainUI.this));
        CollectMainUI.c(CollectMainUI.this);
        if (CollectMainUI.b(CollectMainUI.this) != null) {
          h.CyF.a(20032, new Object[] { "wxface2face", "ClickQRCode", "", "", "", "", Integer.valueOf(2), Integer.valueOf(CollectMainUI.b(CollectMainUI.this).pTI), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        h.CyF.a(13944, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(64132);
      }
    }, (byte)0), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.qAD.setText((CharSequence)localObject);
    this.qAD.setClickable(true);
    this.qAD.setOnTouchListener(new o(this));
    getListView().addFooterView(this.qBd, null, false);
    getListView().setFooterDividersEnabled(false);
    this.qAy = ((ImageView)findViewById(2131298869));
    this.nAB = ((TextView)findViewById(2131298891));
    this.qAO = ((TextView)findViewById(2131298909));
    this.qAO.setClickable(true);
    this.qAO.setOnTouchListener(new o(this));
    this.qBf = new SpannableStringBuilder(getString(2131757683));
    this.qBg = new SpannableStringBuilder(getString(2131757684));
    localObject = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
    {
      public final void dF(View paramAnonymousView)
      {
        AppMethodBeat.i(64133);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeNewUI.class);
        paramAnonymousView.putExtra("key_currency_unit", CollectMainUI.this.qAU);
        CollectMainUI.this.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(64133);
      }
    }, (byte)0);
    final com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
    {
      public final void dF(View paramAnonymousView)
      {
        AppMethodBeat.i(64134);
        CollectMainUI.this.qBb = false;
        CollectMainUI.this.cAq();
        CollectMainUI.h(CollectMainUI.this).setText(CollectMainUI.g(CollectMainUI.this));
        CollectMainUI.i(CollectMainUI.this);
        AppMethodBeat.o(64134);
      }
    }, (byte)0);
    this.qBf.setSpan(localObject, 0, this.qBf.length(), 18);
    if (a.a.gKe().gKc()) {
      this.qAO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64135);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (CollectMainUI.h(CollectMainUI.this).getText().toString().equals(CollectMainUI.j(CollectMainUI.this))) {
            this.qBY.onClick(paramAnonymousView);
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
    this.qBg.setSpan(localq, 0, this.qBg.length(), 18);
    this.qAO.setText(this.qBf);
    this.qAR = ((RelativeLayout)findViewById(2131298898));
    this.qAy.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64140);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        CollectMainUI.b(CollectMainUI.this, CollectMainUI.k(CollectMainUI.this));
        if (CollectMainUI.k(CollectMainUI.this) != null) {
          h.CyF.a(20032, new Object[] { "wxface2face", "LongClick", "", "", "", "", Integer.valueOf(3), Integer.valueOf(CollectMainUI.k(CollectMainUI.this).pTI), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(64140);
        return true;
      }
    });
    this.qAK = findViewById(2131298878);
    this.qAL = ((ImageView)findViewById(2131298900));
    this.qAM = ((TextView)findViewById(2131298902));
    this.qAN = ((TextView)findViewById(2131298901));
    this.qBo = ((CdnImageView)findViewById(2131298832));
    this.qBp = ((TextView)findViewById(2131298835));
    this.qBq = ((TextView)findViewById(2131298836));
    this.qBr = ((ImageView)findViewById(2131298834));
    this.qBs = ((ViewGroup)findViewById(2131298833));
    this.qAH.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64141);
        int[] arrayOfInt = new int[2];
        CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
        CollectMainUI.Ff(arrayOfInt[1]);
        AppMethodBeat.o(64141);
      }
    }, 300L);
    localObject = new zt();
    ((zt)localObject).efM.scene = "8";
    ((zt)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64114);
        if (!Util.isNullOrNil(this.qBN.efN.efO))
        {
          com.tencent.mm.wallet_core.ui.f.a((TextView)CollectMainUI.this.findViewById(2131297330), this.qBN.efN.efO, this.qBN.efN.content, this.qBN.efN.url);
          AppMethodBeat.o(64114);
          return;
        }
        Log.i("MicroMsg.CollectMainUI", "no bulletin data");
        AppMethodBeat.o(64114);
      }
    };
    EventCenter.instance.publish((IEvent)localObject);
    this.qBA = ((LinearLayout)findViewById(2131298894));
    this.qBB = ((TextView)findViewById(2131298897));
    this.qBC = ((Button)findViewById(2131298895));
    this.qBD = ((Button)findViewById(2131298896));
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
        this.qAV = paramIntent.getStringExtra("ftf_pay_url");
        this.qAW = paramIntent.getIntExtra("key_error_level", -1);
        this.qAY = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.qAZ = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.qBa = paramIntent.getStringExtra("ftf_fixed_desc");
        this.qAU = paramIntent.getStringExtra("key_currency_unit");
        this.qAO.setText(this.qBg);
      }
      for (this.qBb = true;; this.qBb = false)
      {
        refreshView();
        cAs();
        AppMethodBeat.o(64161);
        return;
      }
      this.qAb = z.aUd();
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
    com.tencent.mm.kernel.g.aAi();
    this.efI = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
    this.qAb = z.aUd();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    h.CyF.a(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(2130772169, 2130772166);
    com.tencent.mm.plugin.collect.a.a.czp();
    paramBundle = com.tencent.mm.plugin.collect.a.a.czq();
    if (!paramBundle.pQG.contains(this)) {
      paramBundle.pQG.add(this);
    }
    initView();
    cAn();
    refreshView();
    this.ooM = ((Vibrator)getSystemService("vibrator"));
    this.iOB = Util.nowSecond();
    if (qBI < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      qBI = paramBundle.widthPixels / 2 - BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0F);
      qBJ = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 60.0F);
      qBK = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 40.0F);
      qBL = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 70.0F);
    }
    cAs();
    ab.mg(16, 0);
    com.tencent.mm.kernel.g.azz().a(3781, this);
    AppMethodBeat.o(64150);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64152);
    if (this.qAy != null) {
      this.qAy.setImageBitmap(null);
    }
    Object localObject = this.qAS;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      Log.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.qAG != null) {
      this.qAG.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.czp();
    com.tencent.mm.plugin.collect.a.a.czq().pQG.remove(this);
    this.ooM.cancel();
    if (this.qBh != null)
    {
      localObject = this.qBh;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).oPn.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Log.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).oPn.clear();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(1588, (com.tencent.mm.ak.i)localObject);
    }
    com.tencent.mm.platformtools.u.c(this.qBH);
    com.tencent.mm.kernel.g.azz().b(3781, this);
    super.onDestroy();
    AppMethodBeat.o(64152);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64163);
    super.onPause();
    ScreenShotUtil.setScreenShotCallback(this, null);
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
    ScreenShotUtil.setScreenShotCallback(this, this);
    AppMethodBeat.o(64162);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(213217);
    Log.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof com.tencent.mm.plugin.collect.model.m)) {
      Log.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
    }
    AppMethodBeat.o(213217);
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(213212);
    Log.i("MicroMsg.CollectMainUI", "do screen shot");
    h.CyF.a(13944, new Object[] { Integer.valueOf(9) });
    if (this.qBx != null) {
      h.CyF.a(20032, new Object[] { "wxface2face", "ScreenShot", "", "", "", "", Integer.valueOf(1), Integer.valueOf(this.qBx.pTI), Integer.valueOf(0), cAA(), Integer.valueOf(cAy()), cAz() });
    }
    if (((this.qBG != null) && (this.qBG.isShowing())) || ((this.qBF != null) && (this.qBF.kdo != null) && (this.qBF.kdo.isShowing())))
    {
      Log.i("MicroMsg.CollectMainUI", "helper.isShowing() || isShowTips, do not showScreen Action");
      AppMethodBeat.o(213212);
      return;
    }
    a(this.qBx);
    Fe(1);
    AppMethodBeat.o(213212);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(64155);
    if (Util.isNullOrNil(this.qAT))
    {
      Log.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(64155);
      return;
    }
    if (this.qBi == 1)
    {
      if (!Util.isNullOrNil(this.qBj)) {
        this.nAB.setText(this.qBj);
      }
      if (!Util.isNullOrNil(this.qBk))
      {
        TextView localTextView = (TextView)findViewById(2131298871);
        localTextView.setText(this.qBk);
        localTextView.setVisibility(0);
      }
    }
    cAq();
    cAt();
    cAu();
    cAv();
    AppMethodBeat.o(64155);
  }
  
  public final void setStatusColor()
  {
    AppMethodBeat.i(64151);
    setActionbarColor(getResources().getColor(2131099843));
    AppMethodBeat.o(64151);
  }
  
  final class b
  {
    boolean qCa;
    LinkedList<CollectMainUI.a> qCb;
    
    private b()
    {
      AppMethodBeat.i(64145);
      this.qCb = new LinkedList();
      AppMethodBeat.o(64145);
    }
    
    private int Fg(int paramInt)
    {
      AppMethodBeat.i(64146);
      float f2 = 0.0F + CollectMainUI.l(CollectMainUI.this).getHeight() / 2;
      float f1 = f2;
      if (CollectMainUI.p(CollectMainUI.this).getVisibility() == 0) {
        f1 = f2 + CollectMainUI.p(CollectMainUI.this).getHeight();
      }
      f2 = CollectMainUI.cAC() * paramInt + CollectMainUI.cAC() / 2;
      int[] arrayOfInt = new int[2];
      CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
      paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.cfm()));
      AppMethodBeat.o(64146);
      return paramInt;
    }
    
    private void a(final CollectMainUI.a parama)
    {
      AppMethodBeat.i(64148);
      this.qCa = true;
      CollectMainUI.n(CollectMainUI.this);
      CollectMainUI.q(CollectMainUI.this).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.l(CollectMainUI.this).getWidth(), CollectMainUI.l(CollectMainUI.this).getHeight() + com.tencent.mm.cb.a.fromDPToPix(CollectMainUI.this.getContext(), 8)));
      CollectMainUI.r(CollectMainUI.this).setText(com.tencent.mm.pluginsdk.ui.span.l.b(CollectMainUI.this.getContext(), parama.gCv, CollectMainUI.r(CollectMainUI.this).getTextSize()));
      a.b.c(CollectMainUI.s(CollectMainUI.this), parama.username);
      CollectMainUI.t(CollectMainUI.this).setText(com.tencent.mm.wallet_core.ui.f.d(parama.qwJ, parama.dFv));
      CollectMainUI.q(CollectMainUI.this).setVisibility(0);
      final AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
      int j = 0;
      int i = 0;
      while (i < CollectMainUI.u(CollectMainUI.this).size())
      {
        if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dDM.equals(parama.dDM)) {
          j = i;
        }
        i += 1;
      }
      localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.cAB(), 0.0F, Fg(j)));
      localAnimationSet.setDuration(300L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64142);
          CollectMainUI.q(CollectMainUI.this).setVisibility(8);
          Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + parama.dDM);
          int i = 0;
          for (;;)
          {
            if (i < CollectMainUI.u(CollectMainUI.this).size())
            {
              if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dDM.equals(parama.dDM))
              {
                ((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).isAnimated = true;
                Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + parama.dDM);
              }
            }
            else
            {
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.b.this.qCa = false;
              CollectMainUI.b.this.cAF();
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
    
    public final void cAF()
    {
      AppMethodBeat.i(64147);
      if (!this.qCa)
      {
        if (!this.qCb.isEmpty())
        {
          a((CollectMainUI.a)this.qCb.poll());
          AppMethodBeat.o(64147);
        }
      }
      else {
        Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.qCb.size());
      }
      AppMethodBeat.o(64147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */