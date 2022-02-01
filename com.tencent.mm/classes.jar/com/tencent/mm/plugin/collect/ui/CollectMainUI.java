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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.plugin.collect.model.v;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.esb;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.ab;
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

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(0)
public class CollectMainUI
  extends WalletPreferenceUI
  implements i, d.a, ScreenShotUtil.ScreenShotCallback
{
  private static int uaI = -1;
  private static int uaJ = -1;
  private static int uaK = -1;
  private static int uaL = -1;
  private static int uac;
  private int fZX;
  private long lER;
  protected String mTrueName;
  private com.tencent.mm.ui.base.preference.f mrf;
  private TextView qCM;
  private e rZT;
  private Vibrator rqy;
  protected ScrollView tXA;
  private WalletTextView tZA;
  private TextView tZB;
  private TextView tZC;
  private TextView tZD;
  private RelativeLayout tZE;
  private View tZF;
  private Dialog tZG;
  private View tZH;
  private View tZI;
  private boolean tZJ;
  private View tZK;
  private ImageView tZL;
  private TextView tZM;
  private TextView tZN;
  private TextView tZO;
  protected LinearLayout tZP;
  protected TextView tZQ;
  private RelativeLayout tZR;
  private Bitmap tZS;
  protected String tZT;
  protected String tZU;
  private String tZV;
  private int tZW;
  private List<a> tZX;
  private double tZY;
  private String tZZ;
  private long tZb;
  private int tZv;
  private int tZw;
  private com.tencent.mm.ui.widget.a.g tZx;
  private ImageView tZy;
  private TextView tZz;
  private LinearLayout uaA;
  private TextView uaB;
  private TextView uaC;
  private TextView uaD;
  private com.tencent.mm.cd.b uaE;
  private com.tencent.mm.ui.widget.a.f.a uaF;
  private e uaG;
  private u.a uaH;
  private String uaa;
  protected boolean uab;
  private View uad;
  private b uae;
  private SpannableStringBuilder uaf;
  private SpannableStringBuilder uag;
  private com.tencent.mm.plugin.collect.model.f uah;
  private int uai;
  private String uaj;
  private String uak;
  private String ual;
  private String uam;
  private String uan;
  protected CdnImageView uao;
  protected TextView uap;
  protected TextView uaq;
  protected ImageView uar;
  protected ViewGroup uas;
  protected View uat;
  private boolean uau;
  private int uav;
  private cxo uaw;
  private dqi uax;
  private dqi uay;
  private dqi uaz;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(64149);
    this.tZy = null;
    this.tZz = null;
    this.tZA = null;
    this.tZB = null;
    this.tZC = null;
    this.tZD = null;
    this.tZE = null;
    this.tZF = null;
    this.qCM = null;
    this.mrf = null;
    this.tZG = null;
    this.tZH = null;
    this.tZI = null;
    this.tXA = null;
    this.tZJ = false;
    this.tZK = null;
    this.tZS = null;
    this.tZT = null;
    this.mTrueName = null;
    this.tZU = null;
    this.tZV = null;
    this.tZX = new LinkedList();
    this.tZZ = null;
    this.uaa = null;
    this.uab = false;
    this.uae = new b((byte)0);
    this.uai = 0;
    this.uau = false;
    this.uav = 0;
    this.uaH = new CollectMainUI.12(this);
    AppMethodBeat.o(64149);
  }
  
  private void IM(int paramInt)
  {
    AppMethodBeat.i(272913);
    int i = cOY();
    Object localObject = cOZ();
    String str = cPa();
    Log.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str, this.uaE });
    localObject = new m(paramInt, i, (String)localObject, str, this.uaE);
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    AppMethodBeat.o(272913);
  }
  
  private void a(aed paramaed)
  {
    AppMethodBeat.i(272919);
    if (paramaed == null)
    {
      Log.i("MicroMsg.CollectMainUI", " coverInfo == null");
      AppMethodBeat.o(272919);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "showCoverUI");
    this.uaA.setVisibility(0);
    this.uaA.setOnClickListener(new CollectMainUI.14(this));
    ViewGroup.LayoutParams localLayoutParams = this.uaA.getLayoutParams();
    localLayoutParams.height = this.tZH.getHeight();
    this.uaA.setLayoutParams(localLayoutParams);
    this.uaB.setText(paramaed.wording);
    this.uaC.setText(paramaed.SqL.wording);
    this.uaC.setOnClickListener(new CollectMainUI.15(this, paramaed));
    this.uaD.setText(paramaed.SqM.wording);
    this.uaD.setOnClickListener(new CollectMainUI.16(this, paramaed));
    AppMethodBeat.o(272919);
  }
  
  private void a(cit paramcit)
  {
    AppMethodBeat.i(272918);
    if ((paramcit == null) || ((this.tZx != null) && (this.tZx.isShowing())))
    {
      Log.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
      AppMethodBeat.o(272918);
      return;
    }
    if ((this.rZT != null) && (this.rZT.isShowing()))
    {
      Log.i("MicroMsg.CollectMainUI", "mBottomSheet != null && mBottomSheet.isShowing()");
      AppMethodBeat.o(272918);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "showHalfDialog");
    Object localObject1 = paramcit.TpI;
    Object localObject2 = paramcit.TpJ;
    this.tZv = 4;
    this.tZx = new com.tencent.mm.ui.widget.a.g(getContext(), 1, 3);
    this.tZx.d(((dqj)localObject1).wording, ((dqj)localObject2).wording);
    this.tZx.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(272958);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.uaV);
        CollectMainUI.D(CollectMainUI.this).bYF();
        CollectMainUI.E(CollectMainUI.this);
        AppMethodBeat.o(272958);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(268472);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.uaW);
        CollectMainUI.D(CollectMainUI.this).bYF();
        CollectMainUI.E(CollectMainUI.this);
        AppMethodBeat.o(268472);
      }
    });
    if (paramcit.TpH.type == 2)
    {
      localObject1 = View.inflate(getContext(), a.g.collect_half_dialog_head_x, null);
      ((ImageView)((View)localObject1).findViewById(a.f.back_cion)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64126);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          CollectMainUI.D(CollectMainUI.this).bYF();
          CollectMainUI.E(CollectMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64126);
        }
      });
      localObject2 = (TextView)((View)localObject1).findViewById(a.f.collect_dialog_title);
      ((TextView)localObject2).setText(paramcit.TpH.UtS);
      ar.a(((TextView)localObject2).getPaint(), 0.8F);
      this.tZx.setHeaderView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = View.inflate(getContext(), a.g.collect_half_dialog_content, null);
      ((TextView)((View)localObject1).findViewById(a.f.half_dialog_content)).setText(paramcit.wording);
      this.tZx.setCustomView((View)localObject1);
      this.tZx.eik();
      AppMethodBeat.o(272918);
      return;
      localObject1 = View.inflate(getContext(), a.g.collect_half_dialog_head_normal, null);
      localObject2 = (TextView)((View)localObject1).findViewById(a.f.half_dialog_title);
      ((TextView)localObject2).setText(paramcit.TpH.UtS);
      ar.a(((TextView)localObject2).getPaint(), 0.8F);
      this.tZx.setHeaderView((View)localObject1);
    }
  }
  
  private void a(dqi paramdqi)
  {
    AppMethodBeat.i(272917);
    if (paramdqi == null)
    {
      Log.i("MicroMsg.CollectMainUI", "actionInfo is null");
      AppMethodBeat.o(272917);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", new Object[] { Integer.valueOf(paramdqi.tpK) });
    switch (paramdqi.tpK)
    {
    default: 
      Log.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
      AppMethodBeat.o(272917);
      return;
    case 0: 
      AppMethodBeat.o(272917);
      return;
    case 1: 
      a(paramdqi.TXb);
      AppMethodBeat.o(272917);
      return;
    case 2: 
      a(paramdqi.TXc);
      AppMethodBeat.o(272917);
      return;
    }
    a(paramdqi.TXd);
    AppMethodBeat.o(272917);
  }
  
  private void a(dqi paramdqi, aed paramaed)
  {
    AppMethodBeat.i(272921);
    Log.i("MicroMsg.CollectMainUI", "doSaveQrCode");
    Object localObject;
    if ((this.tZS != null) && (!this.tZS.isRecycled()))
    {
      i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.tZT, z.bcZ(), this.uai, this.ual, i, this.uaH, false, this.tZW, 0.0F, true);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.uab)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.tZY * 100.0D)) });
          if (this.tZJ) {
            break label661;
          }
          this.tXA = ((ScrollView)((ViewStub)findViewById(a.f.collect_main_save_view_stub)).inflate());
          cOP();
          this.tZJ = true;
        }
      }
    }
    label661:
    for (int i = 250;; i = 0)
    {
      this.tXA.setVisibility(4);
      ((ImageView)this.tXA.findViewById(a.f.collect_main_save_ftf_pay_qrcode)).setImageBitmap(this.tZS);
      TextView localTextView1 = (TextView)this.tXA.findViewById(a.f.collect_main_save_receiver_1);
      TextView localTextView2 = (TextView)this.tXA.findViewById(a.f.collect_main_save_receiver_2);
      LinearLayout localLinearLayout1 = (LinearLayout)this.tXA.findViewById(a.f.collect_save_root_layout);
      LinearLayout localLinearLayout2 = (LinearLayout)this.tXA.findViewById(a.f.collect_main_save_fixed_ll);
      TextView localTextView3 = (TextView)this.tXA.findViewById(a.f.collect_main_save_fixed_currency);
      TextView localTextView4 = (TextView)this.tXA.findViewById(a.f.collect_main_save_fixed_desc);
      TextView localTextView5 = (TextView)this.tXA.findViewById(a.f.collect_main_save_fixed_fee);
      String str1 = com.tencent.mm.wallet_core.ui.g.ic(com.tencent.mm.wallet_core.ui.g.PJ(z.bcZ()), 10);
      String str2 = getTrueName();
      localObject = str1;
      if (!Util.isNullOrNil(str2)) {
        localObject = str1 + getString(a.i.collect_main_save_bottom_tips2, new Object[] { str2 });
      }
      if (this.uai == 1) {
        if (!Util.isNullOrNil(this.uak))
        {
          localTextView1.setText(this.uak);
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          label420:
          if (!this.uab) {
            break label616;
          }
          if (Util.isNullOrNil(this.uaa)) {
            break label606;
          }
          localTextView4.setText(this.uaa);
          localTextView4.setVisibility(0);
          label452:
          localTextView3.setText(cOO());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(this.tZY));
          localLinearLayout2.setVisibility(0);
          label479:
          MMHandlerThread.postToMainThreadDelayed(new CollectMainUI.5(this, localLinearLayout1, paramdqi, paramaed), i);
          i = 1;
          label498:
          if (i == 0)
          {
            Log.w("MicroMsg.CollectMainUI", "save ftf pay qrcode fail");
            Toast.makeText(getContext(), getString(a.i.collect_qrcode_save_failed), 1).show();
          }
        }
      }
      for (;;)
      {
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(272921);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.a(11343, new Object[] { Integer.valueOf(0) });
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
        Toast.makeText(getContext(), getString(a.i.collect_qrcode_save_failed), 1).show();
      }
    }
  }
  
  private void a(ql paramql)
  {
    AppMethodBeat.i(272920);
    if (paramql == null)
    {
      Log.i("MicroMsg.CollectMainUI", " bottomCell == null");
      AppMethodBeat.o(272920);
      return;
    }
    this.tZv = 3;
    this.rZT = new e(getContext(), 1, true);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.ci.a.fromDPToPix(getContext(), 56));
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(getResources().getColor(a.c.FG_1));
    localTextView.setText(paramql.RYH);
    this.rZT.Z(localTextView, false);
    this.rZT.Ynb = true;
    this.rZT.ODT = new CollectMainUI.17(this, paramql);
    this.rZT.ODU = new CollectMainUI.18(this, paramql);
    this.rZT.eik();
    AppMethodBeat.o(272920);
  }
  
  private static cxf aN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64171);
    cxf localcxf = new cxf();
    localcxf.type = paramJSONObject.optInt("type", -1);
    localcxf.url = paramJSONObject.optString("url", "");
    localcxf.wording = paramJSONObject.optString("wording", "");
    localcxf.TFL = paramJSONObject.optString("waapp_username", "");
    localcxf.TFM = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(64171);
    return localcxf;
  }
  
  private void cOS()
  {
    AppMethodBeat.i(64157);
    getWindow().getDecorView().post(new CollectMainUI.3(this));
    AppMethodBeat.o(64157);
  }
  
  private void cOT()
  {
    AppMethodBeat.i(64158);
    double d;
    if ((this.tZX != null) && (this.tZX.size() > 0))
    {
      this.tZH.setBackgroundResource(a.e.collect_header_top_corner);
      this.mrf.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.tZX.size())
      {
        a locala = (a)this.tZX.get(i);
        c localc;
        if (i == this.tZX.size() - 1)
        {
          localc = new c(this, a.g.collect_pay_info_bottom_corner_preference);
          label104:
          localc.setKey(String.valueOf(i));
          String str2 = locala.jmB;
          String str1 = str2;
          if (Util.isNullOrNil(str2))
          {
            str1 = str2;
            if (!Util.isNullOrNil(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.g.PJ(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.iSn = locala.username;
          if (locala.status != 0) {
            break label221;
          }
          localc.auI(a.i.collect_main_paying);
        }
        for (;;)
        {
          this.mrf.b(localc);
          i += 1;
          break;
          localc = new c(this);
          break label104;
          label221:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.tVK;
              localc.aF(com.tencent.mm.wallet_core.ui.g.d(locala.tVK, locala.fyc));
            }
            for (;;)
            {
              this.mrf.b(localc);
              break;
              localc.auI(a.i.collect_main_pay_suc);
            }
          }
          if (locala.status == 2) {
            localc.auI(a.i.collect_main_pay_cancel);
          }
        }
      }
      this.mrf.notifyDataSetChanged();
      this.tZC.setText(com.tencent.mm.wallet_core.ui.g.d(d, ((a)this.tZX.get(0)).fyc));
      this.tZC.setVisibility(0);
    }
    for (;;)
    {
      if ((this.tZX != null) && (this.tZX.size() > 0))
      {
        this.uas.setBackgroundResource(a.e.collect_main_assist_bg);
        this.tZF.setVisibility(0);
        if ((d > 0.0D) && (this.tZX.size() > 0))
        {
          this.uat.setVisibility(0);
          this.tZI.setVisibility(0);
          AppMethodBeat.o(64158);
        }
      }
      else
      {
        this.tZC.setVisibility(8);
        this.tZF.setVisibility(8);
        this.tZI.setVisibility(8);
      }
      AppMethodBeat.o(64158);
      return;
      d = 0.0D;
    }
  }
  
  private void cOU()
  {
    AppMethodBeat.i(64166);
    bd localbd = com.tencent.mm.plugin.wallet_core.model.k.gJe();
    if (this.uab) {}
    for (int i = 33;; i = 32)
    {
      if (localbd != null) {
        com.tencent.mm.plugin.report.service.h.IzE.a(13447, new Object[] { Integer.valueOf(i), localbd.RFV, localbd.RFW, this.tZT, Double.valueOf(this.tZY), Long.valueOf(Util.nowSecond()), Long.valueOf(localbd.RFU), localbd.RFX, localbd.RFY });
      }
      AppMethodBeat.o(64166);
      return;
    }
  }
  
  private void cOV()
  {
    AppMethodBeat.i(64167);
    if (!Util.isNullOrNil(this.uam))
    {
      this.tZQ.setText(this.uam);
      this.tZQ.setOnClickListener(new CollectMainUI.6(this));
      this.tZP.setVisibility(0);
      AppMethodBeat.o(64167);
      return;
    }
    this.tZP.setVisibility(8);
    AppMethodBeat.o(64167);
  }
  
  private static cxf cOW()
  {
    AppMethodBeat.i(64169);
    try
    {
      com.tencent.mm.kernel.h.aHH();
      cxf localcxf = aN(new JSONObject((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrT, "")));
      AppMethodBeat.o(64169);
      return localcxf;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64169);
    }
    return null;
  }
  
  private static List<cxf> cOX()
  {
    AppMethodBeat.i(64170);
    localArrayList = new ArrayList();
    try
    {
      com.tencent.mm.kernel.h.aHH();
      Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrV, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(aN(((JSONArray)localObject).getJSONObject(i)));
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
  
  private int cOY()
  {
    AppMethodBeat.i(272910);
    if ((this.tZA.isShown()) && (!Util.isNullOrNil(this.tZA.getText())))
    {
      int i = Integer.parseInt(com.tencent.mm.wallet_core.ui.g.c(this.tZA.getText(), "100", 0, RoundingMode.HALF_UP).toString());
      AppMethodBeat.o(272910);
      return i;
    }
    AppMethodBeat.o(272910);
    return 0;
  }
  
  private String cOZ()
  {
    AppMethodBeat.i(272911);
    if ((this.tZz.isShown()) && (!Util.isNullOrNil(this.tZz.getText())))
    {
      String str = this.tZz.getText().toString();
      AppMethodBeat.o(272911);
      return str;
    }
    AppMethodBeat.o(272911);
    return "";
  }
  
  private String cPa()
  {
    AppMethodBeat.i(272912);
    if (this.uab)
    {
      if (Util.isNullOrNil(this.tZV))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(272912);
        return "";
      }
      str = this.tZV;
      AppMethodBeat.o(272912);
      return str;
    }
    if (Util.isNullOrNil(this.tZT))
    {
      Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
      AppMethodBeat.o(272912);
      return "";
    }
    String str = this.tZT;
    AppMethodBeat.o(272912);
    return str;
  }
  
  private Bitmap jdMethod_do(String paramString, int paramInt)
  {
    AppMethodBeat.i(64159);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, z.bcZ(), this.uai, this.ual, this.uaH, paramInt);
    AppMethodBeat.o(64159);
    return paramString;
  }
  
  public final void a(v paramv)
  {
    int k = 0;
    AppMethodBeat.i(64160);
    Log.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.fZX != 1) && (this.fZX != 0)) || ((paramv.msgType == 9) || ((this.fZX == 8) && (paramv.msgType == 26))))
    {
      if (this.rqy != null) {
        this.rqy.vibrate(50L);
      }
      if (paramv.dXr < this.lER)
      {
        Log.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(64160);
        return;
      }
      i = 0;
      if (i >= this.tZX.size()) {
        break label510;
      }
      if ((paramv.status != 0) || (!Util.nullAsNil(paramv.username).equals(((a)this.tZX.get(i)).username)) || (((a)this.tZX.get(i)).status != 2)) {
        break label320;
      }
      this.tZX.remove(i);
      this.tZX.add(i, new a(paramv));
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
        if (i < this.tZX.size())
        {
          localObject = (v)this.tZX.get(i);
          if (paramv.dXr > ((v)localObject).dXr)
          {
            this.tZX.add(i, new a(paramv));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.tZX.add(new a(paramv));
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64116);
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.o(CollectMainUI.this).cPf();
              CollectMainUI.i(CollectMainUI.this);
              AppMethodBeat.o(64116);
            }
          });
          AppMethodBeat.o(64160);
          return;
          label320:
          if (paramv.fww.equals(((a)this.tZX.get(i)).fww))
          {
            Log.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramv.fww);
            if (((a)this.tZX.get(i)).status == 0)
            {
              ((a)this.tZX.get(i)).status = paramv.status;
              ((a)this.tZX.get(i)).tVK = paramv.tVK;
              ((a)this.tZX.get(i)).fyc = paramv.fyc;
              if (paramv.status == 1)
              {
                localObject = this.uae;
                a locala = (a)this.tZX.get(i);
                ((b)localObject).ubb.add(locala);
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
  
  protected void cON()
  {
    AppMethodBeat.i(64168);
    if (com.tencent.mm.plugin.collect.model.f.tUH == null) {
      com.tencent.mm.plugin.collect.model.f.tUH = new com.tencent.mm.plugin.collect.model.f();
    }
    this.uah = com.tencent.mm.plugin.collect.model.f.tUH;
    Object localObject = this.uah;
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1588, (i)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.uah;
    CollectMainUI.7 local7 = new CollectMainUI.7(this);
    com.tencent.mm.kernel.h.aHH();
    String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrQ, "");
    com.tencent.mm.kernel.h.aHH();
    String str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrR, "");
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrS, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = com.tencent.mm.plugin.wallet_core.model.u.gJo().gJX();
    }
    local7.N((String)localObject, str2, i);
    localObject = new com.tencent.mm.plugin.collect.model.l();
    localf.rRk.put(localObject, local7);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
    AppMethodBeat.o(64168);
  }
  
  protected String cOO()
  {
    AppMethodBeat.i(64173);
    String str = com.tencent.mm.wallet_core.ui.g.bCm(this.tZZ);
    AppMethodBeat.o(64173);
    return str;
  }
  
  protected void cOP() {}
  
  protected void cOQ()
  {
    AppMethodBeat.i(64156);
    this.tZy.setImageBitmap(null);
    if (this.uab)
    {
      if (Util.isNullOrNil(this.tZV))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.tZS = jdMethod_do(this.tZV, this.tZW);
      if ((this.tZS == null) || (this.tZS.isRecycled())) {
        break label237;
      }
      this.tZy.setImageBitmap(this.tZS);
      label91:
      if (!this.uab) {
        break label281;
      }
      this.tZA.setPrefix(cOO());
      this.tZA.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(this.tZY));
      this.tZA.setVisibility(0);
      if (Util.isNullOrNil(this.uaa)) {
        break label269;
      }
      this.tZz.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.uaa, this.tZz.getTextSize()));
      this.tZz.setVisibility(0);
    }
    for (;;)
    {
      findViewById(a.f.collect_main_fixed_layout).setVisibility(0);
      AppMethodBeat.o(64156);
      return;
      if (Util.isNullOrNil(this.tZT))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.tZS = jdMethod_do(this.tZT, this.tZW);
      break;
      label237:
      Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + Util.nullAsNil(this.tZV));
      break label91;
      label269:
      this.tZz.setVisibility(8);
    }
    label281:
    this.tZB.setVisibility(8);
    this.tZA.setVisibility(8);
    this.tZz.setVisibility(8);
    findViewById(a.f.collect_main_fixed_layout).setVisibility(8);
    AppMethodBeat.o(64156);
  }
  
  protected final void cOR()
  {
    AppMethodBeat.i(272892);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.ui.widget.a.f.a locala;
    Resources localResources;
    if (((String)com.tencent.mm.kernel.h.aHG().aHp().b(327731, "0")).equals("0"))
    {
      this.uaF = new com.tencent.mm.ui.widget.a.f.a(getContext());
      this.uaF.aR(getResources().getString(a.i.collect_main_first_enter_tips_title));
      locala = this.uaF;
      localResources = getResources();
      if (!z.bdq()) {
        break label169;
      }
    }
    label169:
    for (int i = a.i.collect_main_first_enter_tips_payu;; i = a.i.collect_main_first_enter_tips)
    {
      locala = locala.bBl(localResources.getString(i)).HL(true);
      locala.Qlf = true;
      locala.ayp(a.i.wallet_alert_btn_string).b(new CollectMainUI.1(this)).show();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(327731, "1");
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().hxT();
      AppMethodBeat.o(272892);
      return;
    }
  }
  
  protected final void dd(final List<cxf> paramList)
  {
    AppMethodBeat.i(64174);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        cxf localcxf = (cxf)localIterator.next();
        if (localcxf.type == 1) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localcxf.wording, "", "", "", Integer.valueOf(1) });
        } else if (localcxf.type == 2) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localcxf.wording, "", "", localcxf.url, Integer.valueOf(1) });
        } else if (localcxf.type == 3) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localcxf.wording, localcxf.TFL, localcxf.TFM, "", Integer.valueOf(1) });
        }
      }
    }
    this.tZR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264582);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CollectMainUI.a(CollectMainUI.this, new e(CollectMainUI.this.getContext(), 1, false));
        CollectMainUI.A(CollectMainUI.this).ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(277732);
            com.tencent.mm.plugin.collect.a.a.cNP();
            if (com.tencent.mm.plugin.collect.a.a.cNR()) {
              paramAnonymous2o.add(0, 1, 0, a.i.collect_main_close_ring_tone);
            }
            while (CollectMainUI.9.this.nen != null)
            {
              int i = 0;
              while (i < CollectMainUI.9.this.nen.size())
              {
                cxf localcxf = (cxf)CollectMainUI.9.this.nen.get(i);
                if (!Util.isNullOrNil(localcxf.wording)) {
                  paramAnonymous2o.add(0, i + 1 + 1, 0, localcxf.wording);
                }
                i += 1;
              }
              paramAnonymous2o.add(0, 1, 0, a.i.collect_main_open_ring_tone);
            }
            AppMethodBeat.o(277732);
          }
        };
        CollectMainUI.A(CollectMainUI.this).ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(264544);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId() - 1 - 1;
              if (paramAnonymous2Int < 0)
              {
                Log.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                AppMethodBeat.o(264544);
                return;
              }
              break;
            case 1: 
              com.tencent.mm.plugin.collect.a.a.cNP();
              if (com.tencent.mm.plugin.collect.a.a.cNR())
              {
                CollectMainUI.B(CollectMainUI.this);
                Toast.makeText(CollectMainUI.this.getContext(), a.i.collect_main_close_ring_tone_tips, 1).show();
                com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(264544);
                return;
              }
              CollectMainUI.C(CollectMainUI.this);
              Toast.makeText(CollectMainUI.this.getContext(), a.i.collect_main_open_ring_tone_tips, 1).show();
              com.tencent.mm.plugin.collect.model.voice.a.cOg().lZ(false);
              com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(7) });
              AppMethodBeat.o(264544);
              return;
            }
            paramAnonymous2MenuItem = (cxf)CollectMainUI.9.this.nen.get(paramAnonymous2Int);
            if (paramAnonymous2MenuItem.type == 1)
            {
              Log.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramAnonymous2MenuItem.url });
              com.tencent.mm.plugin.report.service.h.IzE.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2MenuItem.wording, "", "", "", Integer.valueOf(2) });
              AppMethodBeat.o(264544);
              return;
            }
            if (paramAnonymous2MenuItem.type == 2)
            {
              if (!Util.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                com.tencent.mm.wallet_core.ui.g.p(CollectMainUI.this.getContext(), paramAnonymous2MenuItem.url, false);
                com.tencent.mm.plugin.report.service.h.IzE.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramAnonymous2MenuItem.wording, "", "", paramAnonymous2MenuItem.url, Integer.valueOf(2) });
                AppMethodBeat.o(264544);
              }
            }
            else if (paramAnonymous2MenuItem.type == 3)
            {
              xw localxw = new xw();
              localxw.fWN.userName = paramAnonymous2MenuItem.TFL;
              localxw.fWN.fWP = Util.nullAs(paramAnonymous2MenuItem.TFM, "");
              localxw.fWN.scene = 1072;
              localxw.fWN.fWQ = 0;
              EventCenter.instance.publish(localxw);
              com.tencent.mm.plugin.report.service.h.IzE.a(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramAnonymous2MenuItem.wording, paramAnonymous2MenuItem.TFL, paramAnonymous2MenuItem.TFM, "", Integer.valueOf(2) });
            }
            AppMethodBeat.o(264544);
          }
        };
        CollectMainUI.A(CollectMainUI.this).eik();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264582);
      }
    });
    AppMethodBeat.o(64174);
  }
  
  public boolean f(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(64165);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.slide_left_in, com.tencent.mm.plugin.wxpay.a.a.slide_right_out);
    AppMethodBeat.o(64165);
  }
  
  public int getHeaderResourceId()
  {
    return a.g.collect_main_header;
  }
  
  public int getLayoutId()
  {
    return a.g.collect_main;
  }
  
  public int getResourceId()
  {
    return a.m.collect_main_preference;
  }
  
  protected String getTrueName()
  {
    AppMethodBeat.i(64172);
    if (Util.isNullOrNil(this.mTrueName))
    {
      this.mTrueName = com.tencent.mm.plugin.wallet_core.model.u.gJo().getTrueName();
      this.mTrueName = com.tencent.mm.wallet_core.ui.g.bCp(this.mTrueName);
    }
    String str = this.mTrueName;
    AppMethodBeat.o(64172);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64153);
    setMMTitle(a.i.offline_collect_btn_text);
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
    this.mrf = getPreferenceScreen();
    this.tZE = ((RelativeLayout)findViewById(a.f.root));
    this.tZF = findViewById(a.f.collect_main_receive_area);
    this.uat = findViewById(a.f.collect_main_receive_area_1);
    this.tZA = ((WalletTextView)findViewById(a.f.collect_main_fixed_fee));
    this.tZz = ((TextView)findViewById(a.f.collect_main_fixed_desc));
    this.tZB = ((TextView)findViewById(a.f.collect_main_fixed_fee_currency));
    this.tZC = ((TextView)findViewById(a.f.collect_main_receice_amount));
    this.tZP = ((LinearLayout)findViewById(a.f.notice_ui));
    this.tZQ = ((TextView)findViewById(a.f.banner_tips));
    this.tZH = ((RelativeLayout)findViewById(a.f.collect_main_qrcode_area));
    this.tZI = findViewById(a.f.collect_main_header_divider);
    this.uad = LayoutInflater.from(this).inflate(a.g.collect_main_footer, null, false);
    this.tZD = ((TextView)findViewById(a.f.collect_main_save_qrcode));
    Object localObject = new SpannableStringBuilder(getString(a.i.collect_main_save_qrcode));
    ((SpannableStringBuilder)localObject).setSpan(new r(new r.a()
    {
      public final void ed(View paramAnonymousView)
      {
        AppMethodBeat.i(64132);
        CollectMainUI.a(CollectMainUI.this, CollectMainUI.b(CollectMainUI.this));
        CollectMainUI.c(CollectMainUI.this);
        if (CollectMainUI.b(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(20032, new Object[] { "wxface2face", "ClickQRCode", "", "", "", "", Integer.valueOf(2), Integer.valueOf(CollectMainUI.b(CollectMainUI.this).tpK), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(64132);
      }
    }, (byte)0), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.tZD.setText((CharSequence)localObject);
    this.tZD.setClickable(true);
    this.tZD.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
    getListView().addFooterView(this.uad, null, false);
    getListView().setFooterDividersEnabled(false);
    this.tZy = ((ImageView)findViewById(a.f.collect_main_ftf_pay_qrcode));
    this.qCM = ((TextView)findViewById(a.f.collect_main_tips));
    this.tZO = ((TextView)findViewById(a.f.collect_set_money_tv));
    this.tZO.setClickable(true);
    this.tZO.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
    this.uaf = new SpannableStringBuilder(getString(a.i.collect_main_fixed));
    this.uag = new SpannableStringBuilder(getString(a.i.collect_main_fixed_cancel));
    localObject = new r(new r.a()
    {
      public final void ed(View paramAnonymousView)
      {
        AppMethodBeat.i(64133);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeNewUI.class);
        paramAnonymousView.putExtra("key_currency_unit", CollectMainUI.this.tZU);
        CollectMainUI.this.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(64133);
      }
    }, (byte)0);
    final r localr = new r(new r.a()
    {
      public final void ed(View paramAnonymousView)
      {
        AppMethodBeat.i(64134);
        CollectMainUI.this.uab = false;
        CollectMainUI.this.cOQ();
        CollectMainUI.h(CollectMainUI.this).setText(CollectMainUI.g(CollectMainUI.this));
        CollectMainUI.i(CollectMainUI.this);
        AppMethodBeat.o(64134);
      }
    }, (byte)0);
    this.uaf.setSpan(localObject, 0, this.uaf.length(), 18);
    if (com.tencent.mm.ui.a.a.a.hJg().hJd()) {
      this.tZO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64135);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (CollectMainUI.h(CollectMainUI.this).getText().toString().equals(CollectMainUI.j(CollectMainUI.this))) {
            this.uaY.onClick(paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64135);
            return;
            localr.onClick(paramAnonymousView);
          }
        }
      });
    }
    this.uag.setSpan(localr, 0, this.uag.length(), 18);
    this.tZO.setText(this.uaf);
    this.tZR = ((RelativeLayout)findViewById(a.f.collect_menu_more_btn_layout));
    this.tZy.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64140);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        CollectMainUI.b(CollectMainUI.this, CollectMainUI.k(CollectMainUI.this));
        if (CollectMainUI.k(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(20032, new Object[] { "wxface2face", "LongClick", "", "", "", "", Integer.valueOf(3), Integer.valueOf(CollectMainUI.k(CollectMainUI.this).tpK), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(64140);
        return true;
      }
    });
    this.tZK = findViewById(a.f.collect_main_receive_toast);
    this.tZL = ((ImageView)findViewById(a.f.collect_receive_toast_avatar));
    this.tZM = ((TextView)findViewById(a.f.collect_receive_toast_name));
    this.tZN = ((TextView)findViewById(a.f.collect_receive_toast_fee));
    this.uao = ((CdnImageView)findViewById(a.f.collect_assist_icon));
    this.uap = ((TextView)findViewById(a.f.collect_assist_title));
    this.uaq = ((TextView)findViewById(a.f.collect_assist_wording));
    this.uar = ((ImageView)findViewById(a.f.collect_assist_red_dot));
    this.uas = ((ViewGroup)findViewById(a.f.collect_assist_layout));
    this.tZH.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64141);
        int[] arrayOfInt = new int[2];
        CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
        CollectMainUI.IN(arrayOfInt[1]);
        AppMethodBeat.o(64141);
      }
    }, 300L);
    localObject = new aba();
    ((aba)localObject).gac.scene = "8";
    ((aba)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64114);
        if (!Util.isNullOrNil(this.uaN.gad.gae))
        {
          com.tencent.mm.wallet_core.ui.g.a((TextView)CollectMainUI.this.findViewById(a.f.banner_tips), this.uaN.gad.gae, this.uaN.gad.content, this.uaN.gad.url);
          AppMethodBeat.o(64114);
          return;
        }
        Log.i("MicroMsg.CollectMainUI", "no bulletin data");
        AppMethodBeat.o(64114);
      }
    };
    EventCenter.instance.publish((IEvent)localObject);
    this.uaA = ((LinearLayout)findViewById(a.f.collect_mask_cover_layout));
    this.uaB = ((TextView)findViewById(a.f.collect_mask_title));
    this.uaC = ((Button)findViewById(a.f.collect_mask_first_button));
    this.uaD = ((Button)findViewById(a.f.collect_mask_second_button));
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
        this.tZV = paramIntent.getStringExtra("ftf_pay_url");
        this.tZW = paramIntent.getIntExtra("key_error_level", -1);
        this.tZY = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.tZZ = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.uaa = paramIntent.getStringExtra("ftf_fixed_desc");
        this.tZU = paramIntent.getStringExtra("key_currency_unit");
        this.tZO.setText(this.uag);
      }
      for (this.uab = true;; this.uab = false)
      {
        refreshView();
        cOS();
        AppMethodBeat.o(64161);
        return;
      }
      this.tZb = z.bde();
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
    setNavigationbarColor(getResources().getColor(a.c.UN_Yellow_BG_100));
    hideActionbarLine();
    com.tencent.mm.kernel.h.aHH();
    this.fZX = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
    this.tZb = z.bde();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.h.IzE.a(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.slide_right_in, com.tencent.mm.plugin.wxpay.a.a.slide_left_out);
    com.tencent.mm.plugin.collect.a.a.cNP();
    paramBundle = com.tencent.mm.plugin.collect.a.a.cNQ();
    if (!paramBundle.cSF.contains(this)) {
      paramBundle.cSF.add(this);
    }
    initView();
    cON();
    refreshView();
    this.rqy = ((Vibrator)getSystemService("vibrator"));
    this.lER = Util.nowSecond();
    if (uaI < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      uaI = paramBundle.widthPixels / 2 - BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0F);
      uaJ = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 60.0F);
      uaK = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 40.0F);
      uaL = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 70.0F);
    }
    cOS();
    ab.ny(16, 0);
    com.tencent.mm.kernel.h.aGY().a(3781, this);
    AppMethodBeat.o(64150);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64152);
    if (this.tZy != null) {
      this.tZy.setImageBitmap(null);
    }
    Object localObject = this.tZS;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      Log.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.tZG != null) {
      this.tZG.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.cNP();
    com.tencent.mm.plugin.collect.a.a.cNQ().cSF.remove(this);
    this.rqy.cancel();
    if (this.uah != null)
    {
      localObject = this.uah;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).rRk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Log.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a((q)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).rRk.clear();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(1588, (i)localObject);
    }
    com.tencent.mm.platformtools.u.c(this.uaH);
    com.tencent.mm.kernel.h.aGY().b(3781, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(272916);
    Log.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof m)) {
      Log.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
    }
    AppMethodBeat.o(272916);
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(272902);
    Log.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.h.IzE.a(13944, new Object[] { Integer.valueOf(9) });
    if (this.uax != null) {
      com.tencent.mm.plugin.report.service.h.IzE.a(20032, new Object[] { "wxface2face", "ScreenShot", "", "", "", "", Integer.valueOf(1), Integer.valueOf(this.uax.tpK), Integer.valueOf(0), cPa(), Integer.valueOf(cOY()), cOZ() });
    }
    if (((this.uaG != null) && (this.uaG.isShowing())) || ((this.uaF != null) && (this.uaF.mUO != null) && (this.uaF.mUO.isShowing())))
    {
      Log.i("MicroMsg.CollectMainUI", "helper.isShowing() || isShowTips, do not showScreen Action");
      AppMethodBeat.o(272902);
      return;
    }
    a(this.uax);
    IM(1);
    AppMethodBeat.o(272902);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(64155);
    if (Util.isNullOrNil(this.tZT))
    {
      Log.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(64155);
      return;
    }
    if (this.uai == 1)
    {
      if (!Util.isNullOrNil(this.uaj)) {
        this.qCM.setText(this.uaj);
      }
      if (!Util.isNullOrNil(this.uak))
      {
        TextView localTextView = (TextView)findViewById(a.f.collect_main_hk_tips);
        localTextView.setText(this.uak);
        localTextView.setVisibility(0);
      }
    }
    cOQ();
    cOT();
    cOU();
    cOV();
    AppMethodBeat.o(64155);
  }
  
  public final void setStatusColor()
  {
    AppMethodBeat.i(64151);
    setActionbarColor(getResources().getColor(a.c.UN_Yellow_BG_100));
    AppMethodBeat.o(64151);
  }
  
  final class a
    extends v
  {
    public boolean isAnimated = false;
    
    public a(v paramv)
    {
      this.username = paramv.username;
      this.fww = paramv.fww;
      this.tVK = paramv.tVK;
      this.dXr = paramv.dXr;
      this.scene = paramv.scene;
      this.status = paramv.status;
      this.jmB = paramv.jmB;
    }
  }
  
  final class b
  {
    boolean uba;
    LinkedList<CollectMainUI.a> ubb;
    
    private b()
    {
      AppMethodBeat.i(64145);
      this.ubb = new LinkedList();
      AppMethodBeat.o(64145);
    }
    
    private int IO(int paramInt)
    {
      AppMethodBeat.i(64146);
      float f2 = 0.0F + CollectMainUI.l(CollectMainUI.this).getHeight() / 2;
      float f1 = f2;
      if (CollectMainUI.p(CollectMainUI.this).getVisibility() == 0) {
        f1 = f2 + CollectMainUI.p(CollectMainUI.this).getHeight();
      }
      f2 = CollectMainUI.cPb() * paramInt + CollectMainUI.cPb() / 2;
      int[] arrayOfInt = new int[2];
      CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
      paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.cPc()));
      AppMethodBeat.o(64146);
      return paramInt;
    }
    
    private void a(final CollectMainUI.a parama)
    {
      AppMethodBeat.i(64148);
      this.uba = true;
      CollectMainUI.n(CollectMainUI.this);
      CollectMainUI.q(CollectMainUI.this).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.l(CollectMainUI.this).getWidth(), CollectMainUI.l(CollectMainUI.this).getHeight() + com.tencent.mm.ci.a.fromDPToPix(CollectMainUI.this.getContext(), 8)));
      CollectMainUI.r(CollectMainUI.this).setText(com.tencent.mm.pluginsdk.ui.span.l.b(CollectMainUI.this.getContext(), parama.jmB, CollectMainUI.r(CollectMainUI.this).getTextSize()));
      a.b.c(CollectMainUI.s(CollectMainUI.this), parama.username);
      CollectMainUI.t(CollectMainUI.this).setText(com.tencent.mm.wallet_core.ui.g.d(parama.tVK, parama.fyc));
      CollectMainUI.q(CollectMainUI.this).setVisibility(0);
      final AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
      int j = 0;
      int i = 0;
      while (i < CollectMainUI.u(CollectMainUI.this).size())
      {
        if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).fww.equals(parama.fww)) {
          j = i;
        }
        i += 1;
      }
      localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.csA(), 0.0F, IO(j)));
      localAnimationSet.setDuration(300L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64142);
          CollectMainUI.q(CollectMainUI.this).setVisibility(8);
          Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + parama.fww);
          int i = 0;
          for (;;)
          {
            if (i < CollectMainUI.u(CollectMainUI.this).size())
            {
              if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).fww.equals(parama.fww))
              {
                ((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).isAnimated = true;
                Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + parama.fww);
              }
            }
            else
            {
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.b.this.uba = false;
              CollectMainUI.b.this.cPf();
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
    
    public final void cPf()
    {
      AppMethodBeat.i(64147);
      if (!this.uba)
      {
        if (!this.ubb.isEmpty())
        {
          a((CollectMainUI.a)this.ubb.poll());
          AppMethodBeat.o(64147);
        }
      }
      else {
        Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.ubb.size());
      }
      AppMethodBeat.o(64147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */