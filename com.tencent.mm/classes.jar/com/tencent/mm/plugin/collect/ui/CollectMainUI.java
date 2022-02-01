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
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
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
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  implements com.tencent.mm.ak.g, d.a, bg.a
{
  private static int oBL;
  private static int oCp = -1;
  private static int oCq = -1;
  private static int oCr = -1;
  private static int oCs = -1;
  private int dAk;
  private TextView lLe;
  private com.tencent.mm.ui.base.preference.f lZC;
  protected String mTrueName;
  private Vibrator mtQ;
  private long nfL;
  private com.tencent.mm.ui.widget.a.e ngY;
  private long oAP;
  private RelativeLayout oBA;
  private Bitmap oBB;
  protected String oBC;
  protected String oBD;
  private String oBE;
  private int oBF;
  private List<a> oBG;
  private double oBH;
  private String oBI;
  private String oBJ;
  protected boolean oBK;
  private View oBM;
  private b oBN;
  private SpannableStringBuilder oBO;
  private SpannableStringBuilder oBP;
  private com.tencent.mm.plugin.collect.model.f oBQ;
  private int oBR;
  private String oBS;
  private String oBT;
  private String oBU;
  private String oBV;
  private String oBW;
  protected CdnImageView oBX;
  protected TextView oBY;
  protected TextView oBZ;
  private int oBe;
  private int oBf;
  private com.tencent.mm.ui.widget.a.g oBg;
  private ImageView oBh;
  private TextView oBi;
  private WalletTextView oBj;
  private TextView oBk;
  private TextView oBl;
  private TextView oBm;
  private RelativeLayout oBn;
  private View oBo;
  private Dialog oBp;
  private View oBq;
  private View oBr;
  private boolean oBs;
  private View oBt;
  private ImageView oBu;
  private TextView oBv;
  private TextView oBw;
  private TextView oBx;
  protected LinearLayout oBy;
  protected TextView oBz;
  protected ImageView oCa;
  protected ViewGroup oCb;
  protected View oCc;
  private boolean oCd;
  private int oCe;
  private buo oCf;
  private civ oCg;
  private civ oCh;
  private civ oCi;
  private LinearLayout oCj;
  private TextView oCk;
  private TextView oCl;
  private TextView oCm;
  private com.tencent.mm.bw.b oCn;
  private u.a oCo;
  protected ScrollView ozo;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(64149);
    this.oBh = null;
    this.oBi = null;
    this.oBj = null;
    this.oBk = null;
    this.oBl = null;
    this.oBm = null;
    this.oBn = null;
    this.oBo = null;
    this.lLe = null;
    this.lZC = null;
    this.oBp = null;
    this.oBq = null;
    this.oBr = null;
    this.ozo = null;
    this.oBs = false;
    this.oBt = null;
    this.oBB = null;
    this.oBC = null;
    this.mTrueName = null;
    this.oBD = null;
    this.oBE = null;
    this.oBG = new LinkedList();
    this.oBI = null;
    this.oBJ = null;
    this.oBK = false;
    this.oBN = new b((byte)0);
    this.oBR = 0;
    this.oCd = false;
    this.oCe = 0;
    this.oCo = new u.a()
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
          ac.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(CollectMainUI.this), paramAnonymousString });
          CollectMainUI.this.bWE();
        }
        AppMethodBeat.o(64125);
      }
    };
    AppMethodBeat.o(64149);
  }
  
  private void AB(int paramInt)
  {
    AppMethodBeat.i(207069);
    int i = bWM();
    Object localObject = bWN();
    String str = bWO();
    ac.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str, this.oCn });
    localObject = new m(paramInt, i, (String)localObject, str, this.oCn);
    com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(207069);
  }
  
  private void a(bja parambja)
  {
    AppMethodBeat.i(207072);
    if ((parambja == null) || ((this.oBg != null) && (this.oBg.isShowing())))
    {
      ac.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
      AppMethodBeat.o(207072);
      return;
    }
    if ((this.ngY != null) && (this.ngY.isShowing()))
    {
      ac.i("MicroMsg.CollectMainUI", "mBottomSheet != null && mBottomSheet.isShowing()");
      AppMethodBeat.o(207072);
      return;
    }
    ac.i("MicroMsg.CollectMainUI", "showHalfDialog");
    Object localObject1 = parambja.EXX;
    Object localObject2 = parambja.EXY;
    this.oBe = 4;
    this.oBg = new com.tencent.mm.ui.widget.a.g(getContext(), 1, 3);
    this.oBg.c(((ciw)localObject1).dlQ, ((ciw)localObject2).dlQ);
    this.oBg.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(207057);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.oCC);
        CollectMainUI.C(CollectMainUI.this).bmi();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(207057);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(207058);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.oCD);
        CollectMainUI.C(CollectMainUI.this).bmi();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(207058);
      }
    });
    if (parambja.EXW.type == 2)
    {
      localObject1 = View.inflate(getContext(), 2131496149, null);
      ((ImageView)((View)localObject1).findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64126);
          CollectMainUI.C(CollectMainUI.this).bmi();
          CollectMainUI.D(CollectMainUI.this);
          AppMethodBeat.o(64126);
        }
      });
      localObject2 = (TextView)((View)localObject1).findViewById(2131307175);
      ((TextView)localObject2).setText(parambja.EXW.FQJ);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.oBg.setHeaderView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = View.inflate(getContext(), 2131496147, null);
      ((TextView)((View)localObject1).findViewById(2131300674)).setText(parambja.dlQ);
      this.oBg.setCustomView((View)localObject1);
      this.oBg.cED();
      AppMethodBeat.o(207072);
      return;
      localObject1 = View.inflate(getContext(), 2131496148, null);
      localObject2 = (TextView)((View)localObject1).findViewById(2131300675);
      ((TextView)localObject2).setText(parambja.EXW.FQJ);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.oBg.setHeaderView((View)localObject1);
    }
  }
  
  private void a(civ paramciv)
  {
    AppMethodBeat.i(207071);
    if (paramciv == null)
    {
      ac.i("MicroMsg.CollectMainUI", "actionInfo is null");
      AppMethodBeat.o(207071);
      return;
    }
    ac.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", new Object[] { Integer.valueOf(paramciv.nWg) });
    switch (paramciv.nWg)
    {
    default: 
      ac.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
      AppMethodBeat.o(207071);
      return;
    case 0: 
      AppMethodBeat.o(207071);
      return;
    case 1: 
      a(paramciv.FwQ);
      AppMethodBeat.o(207071);
      return;
    case 2: 
      a(paramciv.FwR);
      AppMethodBeat.o(207071);
      return;
    }
    a(paramciv.FwS);
    AppMethodBeat.o(207071);
  }
  
  private void a(final civ paramciv, final zl paramzl)
  {
    AppMethodBeat.i(207075);
    ac.i("MicroMsg.CollectMainUI", "doSaveQrCode");
    Object localObject;
    if ((this.oBB != null) && (!this.oBB.isRecycled()))
    {
      i = BackwardSupportUtil.b.g(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.oBC, com.tencent.mm.model.u.axw(), this.oBR, this.oBU, i, this.oCo, false, this.oBF, 0.0F);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.oBK)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.oBH * 100.0D)) });
          if (this.oBs) {
            break label660;
          }
          this.ozo = ((ScrollView)((ViewStub)findViewById(2131298476)).inflate());
          bWD();
          this.oBs = true;
        }
      }
    }
    label660:
    for (int i = 250;; i = 0)
    {
      this.ozo.setVisibility(4);
      ((ImageView)this.ozo.findViewById(2131298470)).setImageBitmap(this.oBB);
      TextView localTextView1 = (TextView)this.ozo.findViewById(2131298472);
      TextView localTextView2 = (TextView)this.ozo.findViewById(2131298473);
      final LinearLayout localLinearLayout1 = (LinearLayout)this.ozo.findViewById(2131298488);
      LinearLayout localLinearLayout2 = (LinearLayout)this.ozo.findViewById(2131298469);
      TextView localTextView3 = (TextView)this.ozo.findViewById(2131298466);
      TextView localTextView4 = (TextView)this.ozo.findViewById(2131298467);
      TextView localTextView5 = (TextView)this.ozo.findViewById(2131298468);
      String str1 = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(com.tencent.mm.model.u.axw()), 10);
      String str2 = getTrueName();
      localObject = str1;
      if (!bs.isNullOrNil(str2)) {
        localObject = str1 + getString(2131757475, new Object[] { str2 });
      }
      if (this.oBR == 1) {
        if (!bs.isNullOrNil(this.oBT))
        {
          localTextView1.setText(this.oBT);
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          label419:
          if (!this.oBK) {
            break label615;
          }
          if (bs.isNullOrNil(this.oBJ)) {
            break label605;
          }
          localTextView4.setText(this.oBJ);
          localTextView4.setVisibility(0);
          label451:
          localTextView3.setText(bWC());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.e.C(this.oBH));
          localLinearLayout2.setVisibility(0);
          label478:
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64117);
              ac.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(localLinearLayout1.getHeight()), Integer.valueOf(localLinearLayout1.getWidth()) });
              Bitmap localBitmap = Bitmap.createBitmap(localLinearLayout1.getWidth(), localLinearLayout1.getHeight(), Bitmap.Config.ARGB_8888);
              Object localObject = new Canvas(localBitmap);
              localLinearLayout1.draw((Canvas)localObject);
              try
              {
                localObject = com.tencent.mm.pluginsdk.ui.tools.q.eQm() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                com.tencent.mm.sdk.platformtools.f.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
                if (this.oCw)
                {
                  ac.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
                  CollectMainUI.a(CollectMainUI.this, CollectMainUI.this.getContext(), CollectMainUI.this.getContext().getResources().getString(2131760299), paramciv, paramzl);
                }
                com.tencent.mm.pluginsdk.ui.tools.q.k((String)localObject, CollectMainUI.this.getContext());
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ac.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
                }
              }
              CollectMainUI.this.ozo.setVisibility(8);
              AppMethodBeat.o(64117);
            }
          }, i);
          i = 1;
          label497:
          if (i == 0)
          {
            ac.w("MicroMsg.CollectMainUI", "save ftf pay qrcode fail");
            Toast.makeText(getContext(), getString(2131757489), 1).show();
          }
        }
      }
      for (;;)
      {
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(207075);
        return;
        com.tencent.mm.plugin.report.service.h.wUl.f(11343, new Object[] { Integer.valueOf(0) });
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
        ac.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
        Toast.makeText(getContext(), getString(2131757489), 1).show();
      }
    }
  }
  
  private void a(final ok paramok)
  {
    AppMethodBeat.i(207074);
    if (paramok == null)
    {
      ac.i("MicroMsg.CollectMainUI", " bottomCell == null");
      AppMethodBeat.o(207074);
      return;
    }
    this.oBe = 3;
    this.ngY = new com.tencent.mm.ui.widget.a.e(getContext(), 1, true);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 56));
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(getResources().getColor(2131099734));
    localTextView.setText(paramok.Eej);
    this.ngY.J(localTextView, false);
    this.ngY.JfK = true;
    this.ngY.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(207061);
        Iterator localIterator = paramok.Eek.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          ciw localciw = (ciw)localIterator.next();
          if ((localciw != null) && (localciw.dlQ != null))
          {
            paramAnonymousl.c(i, localciw.dlQ);
            i += 1;
          }
        }
        AppMethodBeat.o(207061);
      }
    };
    this.ngY.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(207062);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        paramAnonymousMenuItem = (ciw)paramok.Eek.get(paramAnonymousInt);
        CollectMainUI.d(CollectMainUI.this, 2);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousMenuItem);
        AppMethodBeat.o(207062);
      }
    };
    this.ngY.cED();
    AppMethodBeat.o(207074);
  }
  
  private void a(final zl paramzl)
  {
    AppMethodBeat.i(207073);
    if (paramzl == null)
    {
      ac.i("MicroMsg.CollectMainUI", " coverInfo == null");
      AppMethodBeat.o(207073);
      return;
    }
    ac.i("MicroMsg.CollectMainUI", "showCoverUI");
    this.oCj.setVisibility(0);
    this.oCj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64129);
        AppMethodBeat.o(64129);
      }
    });
    ViewGroup.LayoutParams localLayoutParams = this.oCj.getLayoutParams();
    localLayoutParams.height = this.oBq.getHeight();
    this.oCj.setLayoutParams(localLayoutParams);
    this.oCk.setText(paramzl.dlQ);
    this.oCl.setText(paramzl.EtO.dlQ);
    this.oCl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207059);
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramzl.EtO);
        AppMethodBeat.o(207059);
      }
    });
    this.oCm.setText(paramzl.EtP.dlQ);
    this.oCm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207060);
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramzl.EtP);
        AppMethodBeat.o(207060);
      }
    });
    AppMethodBeat.o(207073);
  }
  
  private static buh an(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64171);
    buh localbuh = new buh();
    localbuh.type = paramJSONObject.optInt("type", -1);
    localbuh.url = paramJSONObject.optString("url", "");
    localbuh.dlQ = paramJSONObject.optString("wording", "");
    localbuh.Fks = paramJSONObject.optString("waapp_username", "");
    localbuh.Fkt = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(64171);
    return localbuh;
  }
  
  private void bWG()
  {
    AppMethodBeat.i(64157);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64115);
        int i = com.tencent.mm.cc.a.fromDPToPix(CollectMainUI.this.getContext(), 37);
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
  
  private void bWH()
  {
    AppMethodBeat.i(64158);
    double d;
    if ((this.oBG != null) && (this.oBG.size() > 0))
    {
      this.oBq.setBackgroundResource(2131231783);
      this.lZC.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.oBG.size())
      {
        a locala = (a)this.oBG.get(i);
        c localc;
        if (i == this.oBG.size() - 1)
        {
          localc = new c(this, (byte)0);
          label102:
          localc.setKey(String.valueOf(i));
          String str2 = locala.fBV;
          String str1 = str2;
          if (bs.isNullOrNil(str2))
          {
            str1 = str2;
            if (!bs.isNullOrNil(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.e.wk(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.foE = locala.username;
          if (locala.status != 0) {
            break label219;
          }
          localc.setSummary(2131757471);
        }
        for (;;)
        {
          this.lZC.b(localc);
          i += 1;
          break;
          localc = new c(this);
          break label102;
          label219:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.oxA;
              localc.setSummary(com.tencent.mm.wallet_core.ui.e.d(locala.oxA, locala.dbI));
            }
            for (;;)
            {
              this.lZC.b(localc);
              break;
              localc.setSummary(2131757470);
            }
          }
          if (locala.status == 2) {
            localc.setSummary(2131757469);
          }
        }
      }
      this.lZC.notifyDataSetChanged();
      this.oBl.setText(com.tencent.mm.wallet_core.ui.e.d(d, ((a)this.oBG.get(0)).dbI));
      this.oBl.setVisibility(0);
    }
    for (;;)
    {
      if ((this.oBG != null) && (this.oBG.size() > 0))
      {
        this.oCb.setBackgroundResource(2131231784);
        this.oBo.setVisibility(0);
        if ((d > 0.0D) && (this.oBG.size() > 0))
        {
          this.oCc.setVisibility(0);
          this.oBr.setVisibility(0);
          AppMethodBeat.o(64158);
        }
      }
      else
      {
        this.oBl.setVisibility(8);
        this.oBo.setVisibility(8);
        this.oBr.setVisibility(8);
      }
      AppMethodBeat.o(64158);
      return;
      d = 0.0D;
    }
  }
  
  private void bWI()
  {
    AppMethodBeat.i(64166);
    bb localbb = com.tencent.mm.plugin.wallet_core.model.k.ero();
    if (this.oBK) {}
    for (int i = 33;; i = 32)
    {
      if (localbb != null) {
        com.tencent.mm.plugin.report.service.h.wUl.f(13447, new Object[] { Integer.valueOf(i), localbb.DNA, localbb.DNB, this.oBC, Double.valueOf(this.oBH), Long.valueOf(bs.aNx()), Long.valueOf(localbb.DNz), localbb.DNC, localbb.DND });
      }
      AppMethodBeat.o(64166);
      return;
    }
  }
  
  private void bWJ()
  {
    AppMethodBeat.i(64167);
    if (!bs.isNullOrNil(this.oBV))
    {
      this.oBz.setText(this.oBV);
      this.oBz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207049);
          if (!bs.isNullOrNil(CollectMainUI.v(CollectMainUI.this))) {
            com.tencent.mm.wallet_core.ui.e.o(ai.getContext(), CollectMainUI.v(CollectMainUI.this), true);
          }
          AppMethodBeat.o(207049);
        }
      });
      this.oBy.setVisibility(0);
      AppMethodBeat.o(64167);
      return;
    }
    this.oBy.setVisibility(8);
    AppMethodBeat.o(64167);
  }
  
  private static buh bWK()
  {
    AppMethodBeat.i(64169);
    try
    {
      com.tencent.mm.kernel.g.agS();
      buh localbuh = an(new JSONObject((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOw, "")));
      AppMethodBeat.o(64169);
      return localbuh;
    }
    catch (JSONException localJSONException)
    {
      ac.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64169);
    }
    return null;
  }
  
  private static List<buh> bWL()
  {
    AppMethodBeat.i(64170);
    localArrayList = new ArrayList();
    try
    {
      com.tencent.mm.kernel.g.agS();
      Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOy, "");
      if (!bs.isNullOrNil((String)localObject))
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
      ac.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64170);
    }
  }
  
  private int bWM()
  {
    AppMethodBeat.i(207066);
    if ((this.oBj.isShown()) && (!bs.aj(this.oBj.getText())))
    {
      int i = Integer.parseInt(com.tencent.mm.wallet_core.ui.e.b(this.oBj.getText(), "100", 0, RoundingMode.HALF_UP).toString());
      AppMethodBeat.o(207066);
      return i;
    }
    AppMethodBeat.o(207066);
    return 0;
  }
  
  private String bWN()
  {
    AppMethodBeat.i(207067);
    if ((this.oBi.isShown()) && (!bs.aj(this.oBi.getText())))
    {
      String str = this.oBi.getText().toString();
      AppMethodBeat.o(207067);
      return str;
    }
    AppMethodBeat.o(207067);
    return "";
  }
  
  private String bWO()
  {
    AppMethodBeat.i(207068);
    if (this.oBK)
    {
      if (bs.isNullOrNil(this.oBE))
      {
        ac.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(207068);
        return "";
      }
      str = this.oBE;
      AppMethodBeat.o(207068);
      return str;
    }
    if (bs.isNullOrNil(this.oBC))
    {
      ac.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
      AppMethodBeat.o(207068);
      return "";
    }
    String str = this.oBC;
    AppMethodBeat.o(207068);
    return str;
  }
  
  private Bitmap cI(String paramString, int paramInt)
  {
    AppMethodBeat.i(64159);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, com.tencent.mm.model.u.axw(), this.oBR, this.oBU, this.oCo, paramInt);
    AppMethodBeat.o(64159);
    return paramString;
  }
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(207065);
    ac.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.h.wUl.f(13944, new Object[] { Integer.valueOf(9) });
    if (this.oCg != null) {
      com.tencent.mm.plugin.report.service.h.wUl.f(20032, new Object[] { "wxface2face", "ScreenShot", "", "", "", "", Integer.valueOf(1), Integer.valueOf(this.oCg.nWg), Integer.valueOf(0), bWO(), Integer.valueOf(bWM()), bWN() });
    }
    a(this.oCg);
    AB(1);
    AppMethodBeat.o(207065);
  }
  
  public final void a(com.tencent.mm.plugin.collect.model.u paramu)
  {
    int k = 0;
    AppMethodBeat.i(64160);
    ac.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.dAk != 1) && (this.dAk != 0)) || ((paramu.msgType == 9) || ((this.dAk == 8) && (paramu.msgType == 26))))
    {
      if (this.mtQ != null) {
        this.mtQ.vibrate(50L);
      }
      if (paramu.oxC < this.nfL)
      {
        ac.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(64160);
        return;
      }
      i = 0;
      if (i >= this.oBG.size()) {
        break label510;
      }
      if ((paramu.status != 0) || (!bs.nullAsNil(paramu.username).equals(((a)this.oBG.get(i)).username)) || (((a)this.oBG.get(i)).status != 2)) {
        break label320;
      }
      this.oBG.remove(i);
      this.oBG.add(i, new a(paramu));
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
        if (i < this.oBG.size())
        {
          localObject = (com.tencent.mm.plugin.collect.model.u)this.oBG.get(i);
          if (paramu.oxC > ((com.tencent.mm.plugin.collect.model.u)localObject).oxC)
          {
            this.oBG.add(i, new a(paramu));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.oBG.add(new a(paramu));
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64116);
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.o(CollectMainUI.this).bWV();
              CollectMainUI.i(CollectMainUI.this);
              AppMethodBeat.o(64116);
            }
          });
          AppMethodBeat.o(64160);
          return;
          label320:
          if (paramu.dad.equals(((a)this.oBG.get(i)).dad))
          {
            ac.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramu.dad);
            if (((a)this.oBG.get(i)).status == 0)
            {
              ((a)this.oBG.get(i)).status = paramu.status;
              ((a)this.oBG.get(i)).oxA = paramu.oxA;
              ((a)this.oBG.get(i)).dbI = paramu.dbI;
              if (paramu.status == 1)
              {
                localObject = this.oBN;
                a locala = (a)this.oBG.get(i);
                ((b)localObject).oCI.add(locala);
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
  
  protected void bWB()
  {
    AppMethodBeat.i(64168);
    if (com.tencent.mm.plugin.collect.model.f.owy == null) {
      com.tencent.mm.plugin.collect.model.f.owy = new com.tencent.mm.plugin.collect.model.f();
    }
    this.oBQ = com.tencent.mm.plugin.collect.model.f.owy;
    Object localObject = this.oBQ;
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1588, (com.tencent.mm.ak.g)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.oBQ;
    f.a local7 = new f.a()
    {
      public final void J(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        AppMethodBeat.i(207051);
        ac.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt) });
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.this.oBC = paramAnonymousString1;
        CollectMainUI.a(CollectMainUI.this, paramAnonymousInt);
        CollectMainUI.this.mTrueName = paramAnonymousString2;
        paramAnonymousString1 = CollectMainUI.bWT();
        paramAnonymousString2 = CollectMainUI.bWU();
        CollectMainUI.a(CollectMainUI.this, paramAnonymousString1);
        CollectMainUI.this.cL(paramAnonymousString2);
        if (CollectMainUI.x(CollectMainUI.this) == 1)
        {
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.agS();
          CollectMainUI.b(paramAnonymousString1, ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPi, Integer.valueOf(-1))).intValue());
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.agS();
          CollectMainUI.a(paramAnonymousString1, (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPj, ""));
        }
        AppMethodBeat.o(207051);
      }
      
      public final void a(boolean paramAnonymousBoolean, sr paramAnonymoussr)
      {
        AppMethodBeat.i(207052);
        Object localObject;
        if (paramAnonymoussr == null)
        {
          localObject = "null";
          ac.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), localObject });
          if (!paramAnonymousBoolean) {
            break label499;
          }
          if ((paramAnonymoussr == null) || (paramAnonymoussr.dae != 416)) {
            break label189;
          }
          if (paramAnonymoussr.EmH != null) {
            break label184;
          }
        }
        label184:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ac.d("MicroMsg.CollectMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectMainUI.w(CollectMainUI.this).setVisibility(4);
          CollectMainUI.a(CollectMainUI.this, true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
          ((Bundle)localObject).putString("realname_verify_process_jump_plugin", "collect");
          CollectMainUI localCollectMainUI = CollectMainUI.this;
          int i = paramAnonymoussr.dae;
          paramAnonymoussr = paramAnonymoussr.EmH;
          new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(207050);
              ac.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
              AppMethodBeat.o(207050);
            }
          };
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localCollectMainUI, i, paramAnonymoussr, (Bundle)localObject, 1010);
          AppMethodBeat.o(207052);
          return;
          localObject = Integer.valueOf(paramAnonymoussr.dae);
          break;
        }
        label189:
        CollectMainUI.this.bWF();
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.a(CollectMainUI.this, false);
        CollectMainUI.this.oBC = paramAnonymoussr.url;
        CollectMainUI.a(CollectMainUI.this, ag.adO(paramAnonymoussr.Emt));
        CollectMainUI.this.mTrueName = paramAnonymoussr.BsL;
        CollectMainUI.b(CollectMainUI.this, paramAnonymoussr.wLq);
        CollectMainUI.b(CollectMainUI.this, paramAnonymoussr.wLr);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussr.wLs);
        CollectMainUI.c(CollectMainUI.this, paramAnonymoussr.EmE);
        CollectMainUI.d(CollectMainUI.this, paramAnonymoussr.iAx);
        CollectMainUI.e(CollectMainUI.this, paramAnonymoussr.iAy);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussr.EmB);
        CollectMainUI.this.cL(paramAnonymoussr.EmA);
        CollectMainUI.c(CollectMainUI.this, paramAnonymoussr.EmF);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussr.EmG);
        ac.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.y(CollectMainUI.this)) });
        CollectMainUI.c(CollectMainUI.this, paramAnonymoussr.EmL);
        CollectMainUI.d(CollectMainUI.this, paramAnonymoussr.EmM);
        CollectMainUI.e(CollectMainUI.this, paramAnonymoussr.EmN);
        CollectMainUI.a(CollectMainUI.this, paramAnonymoussr.EmO);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPi, Integer.valueOf(CollectMainUI.z(CollectMainUI.this)));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPj, CollectMainUI.a(CollectMainUI.this));
        CollectMainUI.this.refreshView();
        label499:
        AppMethodBeat.o(207052);
      }
    };
    com.tencent.mm.kernel.g.agS();
    String str1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOt, "");
    com.tencent.mm.kernel.g.agS();
    String str2 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOu, "");
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOv, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (bs.isNullOrNil(str1))
    {
      ac.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = s.ery().esh();
    }
    local7.J((String)localObject, str2, i);
    localObject = new com.tencent.mm.plugin.collect.model.l();
    localf.mYy.put(localObject, local7);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(64168);
  }
  
  protected String bWC()
  {
    AppMethodBeat.i(64173);
    String str = com.tencent.mm.wallet_core.ui.e.aSF(this.oBI);
    AppMethodBeat.o(64173);
    return str;
  }
  
  protected void bWD() {}
  
  protected void bWE()
  {
    AppMethodBeat.i(64156);
    this.oBh.setImageBitmap(null);
    if (this.oBK)
    {
      if (bs.isNullOrNil(this.oBE))
      {
        ac.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.oBB = cI(this.oBE, this.oBF);
      if ((this.oBB == null) || (this.oBB.isRecycled())) {
        break label237;
      }
      this.oBh.setImageBitmap(this.oBB);
      label91:
      if (!this.oBK) {
        break label281;
      }
      this.oBj.setPrefix(bWC());
      this.oBj.setText(com.tencent.mm.wallet_core.ui.e.C(this.oBH));
      this.oBj.setVisibility(0);
      if (bs.isNullOrNil(this.oBJ)) {
        break label269;
      }
      this.oBi.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.oBJ, this.oBi.getTextSize()));
      this.oBi.setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131298455).setVisibility(0);
      AppMethodBeat.o(64156);
      return;
      if (bs.isNullOrNil(this.oBC))
      {
        ac.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.oBB = cI(this.oBC, this.oBF);
      break;
      label237:
      ac.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bs.nullAsNil(this.oBE));
      break label91;
      label269:
      this.oBi.setVisibility(8);
    }
    label281:
    this.oBk.setVisibility(8);
    this.oBj.setVisibility(8);
    this.oBi.setVisibility(8);
    findViewById(2131298455).setVisibility(8);
    AppMethodBeat.o(64156);
  }
  
  protected final void bWF()
  {
    AppMethodBeat.i(207064);
    com.tencent.mm.kernel.g.agS();
    if (((String)com.tencent.mm.kernel.g.agR().agA().get(327731, "0")).equals("0"))
    {
      com.tencent.mm.ui.base.h.a(getContext(), ah.fAA(), 2131757461, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(327731, "1");
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().faa();
    }
    AppMethodBeat.o(207064);
  }
  
  protected final void cL(final List<buh> paramList)
  {
    AppMethodBeat.i(64174);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        buh localbuh = (buh)localIterator.next();
        if (localbuh.type == 1) {
          com.tencent.mm.plugin.report.service.h.wUl.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localbuh.dlQ, "", "", "", Integer.valueOf(1) });
        } else if (localbuh.type == 2) {
          com.tencent.mm.plugin.report.service.h.wUl.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localbuh.dlQ, "", "", localbuh.url, Integer.valueOf(1) });
        } else if (localbuh.type == 3) {
          com.tencent.mm.plugin.report.service.h.wUl.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localbuh.dlQ, localbuh.Fks, localbuh.Fkt, "", Integer.valueOf(1) });
        }
      }
    }
    this.oBA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207056);
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(CollectMainUI.this.getContext(), 1, false);
        paramAnonymousView.ISu = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(207054);
            com.tencent.mm.plugin.collect.a.a.bVD();
            if (com.tencent.mm.plugin.collect.a.a.bVF()) {
              paramAnonymous2l.add(0, 1, 0, 2131757457);
            }
            while (CollectMainUI.9.this.iSl != null)
            {
              int i = 0;
              while (i < CollectMainUI.9.this.iSl.size())
              {
                buh localbuh = (buh)CollectMainUI.9.this.iSl.get(i);
                if (!bs.isNullOrNil(localbuh.dlQ)) {
                  paramAnonymous2l.add(0, i + 1 + 1, 0, localbuh.dlQ);
                }
                i += 1;
              }
              paramAnonymous2l.add(0, 1, 0, 2131757467);
            }
            AppMethodBeat.o(207054);
          }
        };
        paramAnonymousView.ISv = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(207055);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId() - 1 - 1;
              if (paramAnonymous2Int < 0)
              {
                ac.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                AppMethodBeat.o(207055);
                return;
              }
              break;
            case 1: 
              com.tencent.mm.plugin.collect.a.a.bVD();
              if (com.tencent.mm.plugin.collect.a.a.bVF())
              {
                CollectMainUI.A(CollectMainUI.this);
                Toast.makeText(CollectMainUI.this.getContext(), 2131757458, 1).show();
                com.tencent.mm.plugin.report.service.h.wUl.f(13944, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(207055);
                return;
              }
              CollectMainUI.B(CollectMainUI.this);
              Toast.makeText(CollectMainUI.this.getContext(), 2131757468, 1).show();
              com.tencent.mm.plugin.collect.model.voice.a.bVU().jA(false);
              com.tencent.mm.plugin.report.service.h.wUl.f(13944, new Object[] { Integer.valueOf(7) });
              AppMethodBeat.o(207055);
              return;
            }
            paramAnonymous2MenuItem = (buh)CollectMainUI.9.this.iSl.get(paramAnonymous2Int);
            if (paramAnonymous2MenuItem.type == 1)
            {
              ac.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramAnonymous2MenuItem.url });
              com.tencent.mm.plugin.report.service.h.wUl.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2MenuItem.dlQ, "", "", "", Integer.valueOf(2) });
              AppMethodBeat.o(207055);
              return;
            }
            if (paramAnonymous2MenuItem.type == 2)
            {
              if (!bs.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                com.tencent.mm.wallet_core.ui.e.o(CollectMainUI.this.getContext(), paramAnonymous2MenuItem.url, false);
                com.tencent.mm.plugin.report.service.h.wUl.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramAnonymous2MenuItem.dlQ, "", "", paramAnonymous2MenuItem.url, Integer.valueOf(2) });
                AppMethodBeat.o(207055);
              }
            }
            else if (paramAnonymous2MenuItem.type == 3)
            {
              ut localut = new ut();
              localut.dxt.userName = paramAnonymous2MenuItem.Fks;
              localut.dxt.dxv = bs.bG(paramAnonymous2MenuItem.Fkt, "");
              localut.dxt.scene = 1072;
              localut.dxt.dxw = 0;
              com.tencent.mm.sdk.b.a.GpY.l(localut);
              com.tencent.mm.plugin.report.service.h.wUl.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramAnonymous2MenuItem.dlQ, paramAnonymous2MenuItem.Fks, paramAnonymous2MenuItem.Fkt, "", Integer.valueOf(2) });
            }
            AppMethodBeat.o(207055);
          }
        };
        paramAnonymousView.cED();
        AppMethodBeat.o(207056);
      }
    });
    AppMethodBeat.o(64174);
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
    if (bs.isNullOrNil(this.mTrueName))
    {
      this.mTrueName = s.ery().getTrueName();
      this.mTrueName = com.tencent.mm.wallet_core.ui.e.aSI(this.mTrueName);
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
    this.lZC = getPreferenceScreen();
    this.oBn = ((RelativeLayout)findViewById(2131304239));
    this.oBo = findViewById(2131298462);
    this.oCc = findViewById(2131298463);
    this.oBj = ((WalletTextView)findViewById(2131298452));
    this.oBi = ((TextView)findViewById(2131298451));
    this.oBk = ((TextView)findViewById(2131298453));
    this.oBl = ((TextView)findViewById(2131298461));
    this.oBy = ((LinearLayout)findViewById(2131302956));
    this.oBz = ((TextView)findViewById(2131297186));
    this.oBq = ((RelativeLayout)findViewById(2131298459));
    this.oBr = findViewById(2131298457);
    this.oBM = LayoutInflater.from(this).inflate(2131493561, null, false);
    this.oBm = ((TextView)findViewById(2131298471));
    Object localObject = new SpannableStringBuilder(getString(2131757476));
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dK(View paramAnonymousView)
      {
        AppMethodBeat.i(64132);
        CollectMainUI.a(CollectMainUI.this, CollectMainUI.b(CollectMainUI.this));
        CollectMainUI.c(CollectMainUI.this);
        if (CollectMainUI.b(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(20032, new Object[] { "wxface2face", "ClickQRCode", "", "", "", "", Integer.valueOf(2), Integer.valueOf(CollectMainUI.b(CollectMainUI.this).nWg), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(13944, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(64132);
      }
    }), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.oBm.setText((CharSequence)localObject);
    this.oBm.setClickable(true);
    this.oBm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    getListView().addFooterView(this.oBM, null, false);
    getListView().setFooterDividersEnabled(false);
    this.oBh = ((ImageView)findViewById(2131298456));
    this.lLe = ((TextView)findViewById(2131298477));
    this.oBx = ((TextView)findViewById(2131298490));
    this.oBx.setClickable(true);
    this.oBx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.oBO = new SpannableStringBuilder(getString(2131757464));
    this.oBP = new SpannableStringBuilder(getString(2131757465));
    localObject = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dK(View paramAnonymousView)
      {
        AppMethodBeat.i(64133);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeUI.class);
        paramAnonymousView.putExtra("key_currency_unit", CollectMainUI.this.oBD);
        CollectMainUI.this.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(64133);
      }
    });
    final com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dK(View paramAnonymousView)
      {
        AppMethodBeat.i(64134);
        CollectMainUI.this.oBK = false;
        CollectMainUI.this.bWE();
        CollectMainUI.h(CollectMainUI.this).setText(CollectMainUI.g(CollectMainUI.this));
        CollectMainUI.i(CollectMainUI.this);
        AppMethodBeat.o(64134);
      }
    });
    this.oBO.setSpan(localObject, 0, this.oBO.length(), 18);
    if (a.a.fhP().fhO()) {
      this.oBx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64135);
          if (CollectMainUI.h(CollectMainUI.this).getText().toString().equals(CollectMainUI.j(CollectMainUI.this)))
          {
            this.oCF.onClick(paramAnonymousView);
            AppMethodBeat.o(64135);
            return;
          }
          localq.onClick(paramAnonymousView);
          AppMethodBeat.o(64135);
        }
      });
    }
    this.oBP.setSpan(localq, 0, this.oBP.length(), 18);
    this.oBx.setText(this.oBO);
    this.oBA = ((RelativeLayout)findViewById(2131298479));
    this.oBh.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64140);
        CollectMainUI.b(CollectMainUI.this, CollectMainUI.k(CollectMainUI.this));
        if (CollectMainUI.k(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(20032, new Object[] { "wxface2face", "LongClick", "", "", "", "", Integer.valueOf(3), Integer.valueOf(CollectMainUI.k(CollectMainUI.this).nWg), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        AppMethodBeat.o(64140);
        return true;
      }
    });
    this.oBt = findViewById(2131298464);
    this.oBu = ((ImageView)findViewById(2131298481));
    this.oBv = ((TextView)findViewById(2131298483));
    this.oBw = ((TextView)findViewById(2131298482));
    this.oBX = ((CdnImageView)findViewById(2131298421));
    this.oBY = ((TextView)findViewById(2131298424));
    this.oBZ = ((TextView)findViewById(2131298425));
    this.oCa = ((ImageView)findViewById(2131298423));
    this.oCb = ((ViewGroup)findViewById(2131298422));
    this.oBq.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64141);
        int[] arrayOfInt = new int[2];
        CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
        CollectMainUI.AC(arrayOfInt[1]);
        AppMethodBeat.o(64141);
      }
    }, 300L);
    localObject = new xo();
    ((xo)localObject).dAo.scene = "8";
    ((xo)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64114);
        if (!bs.isNullOrNil(this.oCu.dAp.dAq))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)CollectMainUI.this.findViewById(2131297186), this.oCu.dAp.dAq, this.oCu.dAp.content, this.oCu.dAp.url);
          AppMethodBeat.o(64114);
          return;
        }
        ac.i("MicroMsg.CollectMainUI", "no bulletin data");
        AppMethodBeat.o(64114);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    this.oCj = ((LinearLayout)findViewById(2131307177));
    this.oCk = ((TextView)findViewById(2131307180));
    this.oCl = ((Button)findViewById(2131307178));
    this.oCm = ((Button)findViewById(2131307179));
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
        this.oBE = paramIntent.getStringExtra("ftf_pay_url");
        this.oBF = paramIntent.getIntExtra("key_error_level", -1);
        this.oBH = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.oBI = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.oBJ = paramIntent.getStringExtra("ftf_fixed_desc");
        this.oBD = paramIntent.getStringExtra("key_currency_unit");
        this.oBx.setText(this.oBP);
      }
      for (this.oBK = true;; this.oBK = false)
      {
        refreshView();
        bWG();
        AppMethodBeat.o(64161);
        return;
      }
      this.oAP = com.tencent.mm.model.u.axB();
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
    com.tencent.mm.kernel.g.agS();
    this.dAk = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
    this.oAP = com.tencent.mm.model.u.axB();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.h.wUl.f(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(2130772144, 2130772141);
    com.tencent.mm.plugin.collect.a.a.bVD();
    paramBundle = com.tencent.mm.plugin.collect.a.a.bVE();
    if (!paramBundle.nTa.contains(this)) {
      paramBundle.nTa.add(this);
    }
    initView();
    bWB();
    refreshView();
    this.mtQ = ((Vibrator)getSystemService("vibrator"));
    this.nfL = bs.aNx();
    if (oCp < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      oCp = paramBundle.widthPixels / 2 - BackwardSupportUtil.b.g(getContext(), 20.0F);
      oCq = BackwardSupportUtil.b.g(getContext(), 60.0F);
      oCr = BackwardSupportUtil.b.g(getContext(), 40.0F);
      oCs = BackwardSupportUtil.b.g(getContext(), 70.0F);
    }
    bWG();
    ab.km(16, 0);
    com.tencent.mm.kernel.g.agi().a(3781, this);
    AppMethodBeat.o(64150);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64152);
    if (this.oBh != null) {
      this.oBh.setImageBitmap(null);
    }
    Object localObject = this.oBB;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ac.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.oBp != null) {
      this.oBp.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.bVD();
    com.tencent.mm.plugin.collect.a.a.bVE().nTa.remove(this);
    this.mtQ.cancel();
    if (this.oBQ != null)
    {
      localObject = this.oBQ;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).mYy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ac.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).mYy.clear();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(1588, (com.tencent.mm.ak.g)localObject);
    }
    com.tencent.mm.platformtools.u.c(this.oCo);
    com.tencent.mm.kernel.g.agi().b(3781, this);
    super.onDestroy();
    AppMethodBeat.o(64152);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64163);
    super.onPause();
    bg.a(this, null);
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
    bg.a(this, this);
    AppMethodBeat.o(64162);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(207070);
    ac.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m)) {
      ac.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
    }
    AppMethodBeat.o(207070);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(64155);
    if (bs.isNullOrNil(this.oBC))
    {
      ac.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(64155);
      return;
    }
    if (this.oBR == 1)
    {
      if (!bs.isNullOrNil(this.oBS)) {
        this.lLe.setText(this.oBS);
      }
      if (!bs.isNullOrNil(this.oBT))
      {
        TextView localTextView = (TextView)findViewById(2131298458);
        localTextView.setText(this.oBT);
        localTextView.setVisibility(0);
      }
    }
    bWE();
    bWH();
    bWI();
    bWJ();
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
      this.dad = paramu.dad;
      this.oxA = paramu.oxA;
      this.oxC = paramu.oxC;
      this.scene = paramu.scene;
      this.status = paramu.status;
      this.fBV = paramu.fBV;
    }
  }
  
  final class b
  {
    boolean oCH;
    LinkedList<CollectMainUI.a> oCI;
    
    private b()
    {
      AppMethodBeat.i(64145);
      this.oCI = new LinkedList();
      AppMethodBeat.o(64145);
    }
    
    private int AD(int paramInt)
    {
      AppMethodBeat.i(64146);
      float f2 = 0.0F + CollectMainUI.l(CollectMainUI.this).getHeight() / 2;
      float f1 = f2;
      if (CollectMainUI.p(CollectMainUI.this).getVisibility() == 0) {
        f1 = f2 + CollectMainUI.p(CollectMainUI.this).getHeight();
      }
      f2 = CollectMainUI.bWQ() * paramInt + CollectMainUI.bWQ() / 2;
      int[] arrayOfInt = new int[2];
      CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
      paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.bDp()));
      AppMethodBeat.o(64146);
      return paramInt;
    }
    
    private void a(final CollectMainUI.a parama)
    {
      AppMethodBeat.i(64148);
      this.oCH = true;
      CollectMainUI.n(CollectMainUI.this);
      CollectMainUI.q(CollectMainUI.this).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.l(CollectMainUI.this).getWidth(), CollectMainUI.l(CollectMainUI.this).getHeight()));
      if (CollectMainUI.this.oBK) {
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.bWR(), 0, 0);
      }
      final AnimationSet localAnimationSet;
      int j;
      for (;;)
      {
        CollectMainUI.r(CollectMainUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(CollectMainUI.this.getContext(), parama.fBV, CollectMainUI.r(CollectMainUI.this).getTextSize()));
        a.b.c(CollectMainUI.s(CollectMainUI.this), parama.username);
        CollectMainUI.t(CollectMainUI.this).setText(com.tencent.mm.wallet_core.ui.e.d(parama.oxA, parama.dbI));
        CollectMainUI.q(CollectMainUI.this).setVisibility(0);
        localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
        j = 0;
        int i = 0;
        while (i < CollectMainUI.u(CollectMainUI.this).size())
        {
          if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dad.equals(parama.dad)) {
            j = i;
          }
          i += 1;
        }
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.bWS(), 0, 0);
      }
      localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.bWP(), 0.0F, AD(j)));
      localAnimationSet.setDuration(300L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64142);
          CollectMainUI.q(CollectMainUI.this).setVisibility(8);
          ac.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + parama.dad);
          int i = 0;
          for (;;)
          {
            if (i < CollectMainUI.u(CollectMainUI.this).size())
            {
              if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dad.equals(parama.dad))
              {
                ((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).isAnimated = true;
                ac.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + parama.dad);
              }
            }
            else
            {
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.b.this.oCH = false;
              CollectMainUI.b.this.bWV();
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
    
    public final void bWV()
    {
      AppMethodBeat.i(64147);
      if (!this.oCH)
      {
        if (!this.oCI.isEmpty())
        {
          a((CollectMainUI.a)this.oCI.poll());
          AppMethodBeat.o(64147);
        }
      }
      else {
        ac.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.oCI.size());
      }
      AppMethodBeat.o(64147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */