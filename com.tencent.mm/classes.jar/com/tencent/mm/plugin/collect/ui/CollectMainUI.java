package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
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
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.kernel.i;
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
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.h;
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
  implements com.tencent.mm.al.f, d.a, bh.a
{
  private static int pfK = -1;
  private static int pfL = -1;
  private static int pfM = -1;
  private static int pfN = -1;
  private static int pfg;
  private int dMx;
  protected String mTrueName;
  private Vibrator mUw;
  private TextView mkS;
  private com.tencent.mm.ui.base.preference.f mzx;
  private long nGh;
  private com.tencent.mm.ui.widget.a.e nHu;
  protected ScrollView pcJ;
  private int peA;
  private com.tencent.mm.ui.widget.a.g peB;
  private ImageView peC;
  private TextView peD;
  private WalletTextView peE;
  private TextView peF;
  private TextView peG;
  private TextView peH;
  private RelativeLayout peI;
  private View peJ;
  private Dialog peK;
  private View peL;
  private View peM;
  private boolean peN;
  private View peO;
  private ImageView peP;
  private TextView peQ;
  private TextView peR;
  private TextView peS;
  protected LinearLayout peT;
  protected TextView peU;
  private RelativeLayout peV;
  private Bitmap peW;
  protected String peX;
  protected String peY;
  private String peZ;
  private long pek;
  private int pez;
  private bzd pfA;
  private cnv pfB;
  private cnv pfC;
  private cnv pfD;
  private LinearLayout pfE;
  private TextView pfF;
  private TextView pfG;
  private TextView pfH;
  private com.tencent.mm.bx.b pfI;
  private u.a pfJ;
  private int pfa;
  private List<CollectMainUI.a> pfb;
  private double pfc;
  private String pfd;
  private String pfe;
  protected boolean pff;
  private View pfh;
  private b pfi;
  private SpannableStringBuilder pfj;
  private SpannableStringBuilder pfk;
  private com.tencent.mm.plugin.collect.model.f pfl;
  private int pfm;
  private String pfn;
  private String pfo;
  private String pfp;
  private String pfq;
  private String pfr;
  protected CdnImageView pfs;
  protected TextView pft;
  protected TextView pfu;
  protected ImageView pfv;
  protected ViewGroup pfw;
  protected View pfx;
  private boolean pfy;
  private int pfz;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(64149);
    this.peC = null;
    this.peD = null;
    this.peE = null;
    this.peF = null;
    this.peG = null;
    this.peH = null;
    this.peI = null;
    this.peJ = null;
    this.mkS = null;
    this.mzx = null;
    this.peK = null;
    this.peL = null;
    this.peM = null;
    this.pcJ = null;
    this.peN = false;
    this.peO = null;
    this.peW = null;
    this.peX = null;
    this.mTrueName = null;
    this.peY = null;
    this.peZ = null;
    this.pfb = new LinkedList();
    this.pfd = null;
    this.pfe = null;
    this.pff = false;
    this.pfi = new b((byte)0);
    this.pfm = 0;
    this.pfy = false;
    this.pfz = 0;
    this.pfJ = new u.a()
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
          ad.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(CollectMainUI.this), paramAnonymousString });
          CollectMainUI.this.cbh();
        }
        AppMethodBeat.o(64125);
      }
    };
    AppMethodBeat.o(64149);
  }
  
  private void Bk(int paramInt)
  {
    AppMethodBeat.i(198973);
    int i = cbp();
    Object localObject = cbq();
    String str = cbr();
    ad.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str, this.pfI });
    localObject = new m(paramInt, i, (String)localObject, str, this.pfI);
    com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(198973);
  }
  
  private void a(final abl paramabl)
  {
    AppMethodBeat.i(198977);
    if (paramabl == null)
    {
      ad.i("MicroMsg.CollectMainUI", " coverInfo == null");
      AppMethodBeat.o(198977);
      return;
    }
    ad.i("MicroMsg.CollectMainUI", "showCoverUI");
    this.pfE.setVisibility(0);
    this.pfE.setOnClickListener(new CollectMainUI.14(this));
    ViewGroup.LayoutParams localLayoutParams = this.pfE.getLayoutParams();
    localLayoutParams.height = this.peL.getHeight();
    this.pfE.setLayoutParams(localLayoutParams);
    this.pfF.setText(paramabl.dxD);
    this.pfG.setText(paramabl.Gbg.dxD);
    this.pfG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198963);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramabl.Gbg);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198963);
      }
    });
    this.pfH.setText(paramabl.Gbh.dxD);
    this.pfH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198964);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramabl.Gbh);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198964);
      }
    });
    AppMethodBeat.o(198977);
  }
  
  private void a(bni parambni)
  {
    AppMethodBeat.i(198976);
    if ((parambni == null) || ((this.peB != null) && (this.peB.isShowing())))
    {
      ad.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
      AppMethodBeat.o(198976);
      return;
    }
    if ((this.nHu != null) && (this.nHu.isShowing()))
    {
      ad.i("MicroMsg.CollectMainUI", "mBottomSheet != null && mBottomSheet.isShowing()");
      AppMethodBeat.o(198976);
      return;
    }
    ad.i("MicroMsg.CollectMainUI", "showHalfDialog");
    Object localObject1 = parambni.GHt;
    Object localObject2 = parambni.GHu;
    this.pez = 4;
    this.peB = new com.tencent.mm.ui.widget.a.g(getContext(), 1, 3);
    this.peB.c(((cnw)localObject1).dxD, ((cnw)localObject2).dxD);
    this.peB.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(198961);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.pfX);
        CollectMainUI.C(CollectMainUI.this).bpT();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(198961);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(198962);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.pfY);
        CollectMainUI.C(CollectMainUI.this).bpT();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(198962);
      }
    });
    if (parambni.GHs.type == 2)
    {
      localObject1 = View.inflate(getContext(), 2131496149, null);
      ((ImageView)((View)localObject1).findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64126);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          CollectMainUI.C(CollectMainUI.this).bpT();
          CollectMainUI.D(CollectMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64126);
        }
      });
      localObject2 = (TextView)((View)localObject1).findViewById(2131307175);
      ((TextView)localObject2).setText(parambni.GHs.HBp);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.peB.setHeaderView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = View.inflate(getContext(), 2131496147, null);
      ((TextView)((View)localObject1).findViewById(2131300674)).setText(parambni.dxD);
      this.peB.setCustomView((View)localObject1);
      this.peB.cMW();
      AppMethodBeat.o(198976);
      return;
      localObject1 = View.inflate(getContext(), 2131496148, null);
      localObject2 = (TextView)((View)localObject1).findViewById(2131300675);
      ((TextView)localObject2).setText(parambni.GHs.HBp);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      this.peB.setHeaderView((View)localObject1);
    }
  }
  
  private void a(cnv paramcnv)
  {
    AppMethodBeat.i(198975);
    if (paramcnv == null)
    {
      ad.i("MicroMsg.CollectMainUI", "actionInfo is null");
      AppMethodBeat.o(198975);
      return;
    }
    ad.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", new Object[] { Integer.valueOf(paramcnv.ozA) });
    switch (paramcnv.ozA)
    {
    default: 
      ad.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
      AppMethodBeat.o(198975);
      return;
    case 0: 
      AppMethodBeat.o(198975);
      return;
    case 1: 
      a(paramcnv.HgV);
      AppMethodBeat.o(198975);
      return;
    case 2: 
      a(paramcnv.HgW);
      AppMethodBeat.o(198975);
      return;
    }
    a(paramcnv.HgX);
    AppMethodBeat.o(198975);
  }
  
  private void a(cnv paramcnv, abl paramabl)
  {
    AppMethodBeat.i(198979);
    ad.i("MicroMsg.CollectMainUI", "doSaveQrCode");
    Object localObject;
    if ((this.peW != null) && (!this.peW.isRecycled()))
    {
      i = BackwardSupportUtil.b.g(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.peX, com.tencent.mm.model.u.aAm(), this.pfm, this.pfp, i, this.pfJ, false, this.pfa, 0.0F);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.pff)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.pfc * 100.0D)) });
          if (this.peN) {
            break label660;
          }
          this.pcJ = ((ScrollView)((ViewStub)findViewById(2131298476)).inflate());
          cbg();
          this.peN = true;
        }
      }
    }
    label660:
    for (int i = 250;; i = 0)
    {
      this.pcJ.setVisibility(4);
      ((ImageView)this.pcJ.findViewById(2131298470)).setImageBitmap(this.peW);
      TextView localTextView1 = (TextView)this.pcJ.findViewById(2131298472);
      TextView localTextView2 = (TextView)this.pcJ.findViewById(2131298473);
      LinearLayout localLinearLayout1 = (LinearLayout)this.pcJ.findViewById(2131298488);
      LinearLayout localLinearLayout2 = (LinearLayout)this.pcJ.findViewById(2131298469);
      TextView localTextView3 = (TextView)this.pcJ.findViewById(2131298466);
      TextView localTextView4 = (TextView)this.pcJ.findViewById(2131298467);
      TextView localTextView5 = (TextView)this.pcJ.findViewById(2131298468);
      String str1 = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(com.tencent.mm.model.u.aAm()), 10);
      String str2 = getTrueName();
      localObject = str1;
      if (!bt.isNullOrNil(str2)) {
        localObject = str1 + getString(2131757475, new Object[] { str2 });
      }
      if (this.pfm == 1) {
        if (!bt.isNullOrNil(this.pfo))
        {
          localTextView1.setText(this.pfo);
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          label419:
          if (!this.pff) {
            break label615;
          }
          if (bt.isNullOrNil(this.pfe)) {
            break label605;
          }
          localTextView4.setText(this.pfe);
          localTextView4.setVisibility(0);
          label451:
          localTextView3.setText(cbf());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.e.C(this.pfc));
          localLinearLayout2.setVisibility(0);
          label478:
          aq.o(new CollectMainUI.5(this, localLinearLayout1, paramcnv, paramabl), i);
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
        AppMethodBeat.o(198979);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.f(11343, new Object[] { Integer.valueOf(0) });
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
  
  private void a(final pp parampp)
  {
    AppMethodBeat.i(198978);
    if (parampp == null)
    {
      ad.i("MicroMsg.CollectMainUI", " bottomCell == null");
      AppMethodBeat.o(198978);
      return;
    }
    this.pez = 3;
    this.nHu = new com.tencent.mm.ui.widget.a.e(getContext(), 1, true);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 56));
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(getResources().getColor(2131099734));
    localTextView.setText(parampp.FKI);
    this.nHu.K(localTextView, false);
    this.nHu.KWY = true;
    this.nHu.KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(198965);
        Iterator localIterator = parampp.FKJ.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          cnw localcnw = (cnw)localIterator.next();
          if ((localcnw != null) && (localcnw.dxD != null))
          {
            paramAnonymousl.c(i, localcnw.dxD);
            i += 1;
          }
        }
        AppMethodBeat.o(198965);
      }
    };
    this.nHu.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(198966);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        paramAnonymousMenuItem = (cnw)parampp.FKJ.get(paramAnonymousInt);
        CollectMainUI.d(CollectMainUI.this, 2);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousMenuItem);
        AppMethodBeat.o(198966);
      }
    };
    this.nHu.cMW();
    AppMethodBeat.o(198978);
  }
  
  private static byw aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64171);
    byw localbyw = new byw();
    localbyw.type = paramJSONObject.optInt("type", -1);
    localbyw.url = paramJSONObject.optString("url", "");
    localbyw.dxD = paramJSONObject.optString("wording", "");
    localbyw.GUa = paramJSONObject.optString("waapp_username", "");
    localbyw.GUb = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(64171);
    return localbyw;
  }
  
  private Bitmap cL(String paramString, int paramInt)
  {
    AppMethodBeat.i(64159);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, com.tencent.mm.model.u.aAm(), this.pfm, this.pfp, this.pfJ, paramInt);
    AppMethodBeat.o(64159);
    return paramString;
  }
  
  private void cbj()
  {
    AppMethodBeat.i(64157);
    getWindow().getDecorView().post(new CollectMainUI.3(this));
    AppMethodBeat.o(64157);
  }
  
  private void cbk()
  {
    AppMethodBeat.i(64158);
    double d;
    if ((this.pfb != null) && (this.pfb.size() > 0))
    {
      this.peL.setBackgroundResource(2131231783);
      this.mzx.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.pfb.size())
      {
        CollectMainUI.a locala = (CollectMainUI.a)this.pfb.get(i);
        c localc;
        if (i == this.pfb.size() - 1)
        {
          localc = new c(this, (byte)0);
          label102:
          localc.setKey(String.valueOf(i));
          String str2 = locala.fVj;
          String str1 = str2;
          if (bt.isNullOrNil(str2))
          {
            str1 = str2;
            if (!bt.isNullOrNil(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.e.zf(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.fGM = locala.username;
          if (locala.status != 0) {
            break label219;
          }
          localc.setSummary(2131757471);
        }
        for (;;)
        {
          this.mzx.b(localc);
          i += 1;
          break;
          localc = new c(this);
          break label102;
          label219:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.paV;
              localc.setSummary(com.tencent.mm.wallet_core.ui.e.d(locala.paV, locala.dne));
            }
            for (;;)
            {
              this.mzx.b(localc);
              break;
              localc.setSummary(2131757470);
            }
          }
          if (locala.status == 2) {
            localc.setSummary(2131757469);
          }
        }
      }
      this.mzx.notifyDataSetChanged();
      this.peG.setText(com.tencent.mm.wallet_core.ui.e.d(d, ((CollectMainUI.a)this.pfb.get(0)).dne));
      this.peG.setVisibility(0);
    }
    for (;;)
    {
      if ((this.pfb != null) && (this.pfb.size() > 0))
      {
        this.pfw.setBackgroundResource(2131231784);
        this.peJ.setVisibility(0);
        if ((d > 0.0D) && (this.pfb.size() > 0))
        {
          this.pfx.setVisibility(0);
          this.peM.setVisibility(0);
          AppMethodBeat.o(64158);
        }
      }
      else
      {
        this.peG.setVisibility(8);
        this.peJ.setVisibility(8);
        this.peM.setVisibility(8);
      }
      AppMethodBeat.o(64158);
      return;
      d = 0.0D;
    }
  }
  
  private void cbl()
  {
    AppMethodBeat.i(64166);
    bb localbb = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    if (this.pff) {}
    for (int i = 33;; i = 32)
    {
      if (localbb != null) {
        com.tencent.mm.plugin.report.service.g.yhR.f(13447, new Object[] { Integer.valueOf(i), localbb.FsF, localbb.FsG, this.peX, Double.valueOf(this.pfc), Long.valueOf(bt.aQJ()), Long.valueOf(localbb.FsE), localbb.FsH, localbb.FsI });
      }
      AppMethodBeat.o(64166);
      return;
    }
  }
  
  private void cbm()
  {
    AppMethodBeat.i(64167);
    if (!bt.isNullOrNil(this.pfq))
    {
      this.peU.setText(this.pfq);
      this.peU.setOnClickListener(new CollectMainUI.6(this));
      this.peT.setVisibility(0);
      AppMethodBeat.o(64167);
      return;
    }
    this.peT.setVisibility(8);
    AppMethodBeat.o(64167);
  }
  
  private static byw cbn()
  {
    AppMethodBeat.i(64169);
    try
    {
      com.tencent.mm.kernel.g.ajD();
      byw localbyw = aq(new JSONObject((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAR, "")));
      AppMethodBeat.o(64169);
      return localbyw;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64169);
    }
    return null;
  }
  
  private static List<byw> cbo()
  {
    AppMethodBeat.i(64170);
    localArrayList = new ArrayList();
    try
    {
      com.tencent.mm.kernel.g.ajD();
      Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAT, "");
      if (!bt.isNullOrNil((String)localObject))
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
      ad.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64170);
    }
  }
  
  private int cbp()
  {
    AppMethodBeat.i(198970);
    if ((this.peE.isShown()) && (!bt.ai(this.peE.getText())))
    {
      int i = Integer.parseInt(com.tencent.mm.wallet_core.ui.e.c(this.peE.getText(), "100", 0, RoundingMode.HALF_UP).toString());
      AppMethodBeat.o(198970);
      return i;
    }
    AppMethodBeat.o(198970);
    return 0;
  }
  
  private String cbq()
  {
    AppMethodBeat.i(198971);
    if ((this.peD.isShown()) && (!bt.ai(this.peD.getText())))
    {
      String str = this.peD.getText().toString();
      AppMethodBeat.o(198971);
      return str;
    }
    AppMethodBeat.o(198971);
    return "";
  }
  
  private String cbr()
  {
    AppMethodBeat.i(198972);
    if (this.pff)
    {
      if (bt.isNullOrNil(this.peZ))
      {
        ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(198972);
        return "";
      }
      str = this.peZ;
      AppMethodBeat.o(198972);
      return str;
    }
    if (bt.isNullOrNil(this.peX))
    {
      ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
      AppMethodBeat.o(198972);
      return "";
    }
    String str = this.peX;
    AppMethodBeat.o(198972);
    return str;
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(198969);
    ad.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(9) });
    if (this.pfB != null) {
      com.tencent.mm.plugin.report.service.g.yhR.f(20032, new Object[] { "wxface2face", "ScreenShot", "", "", "", "", Integer.valueOf(1), Integer.valueOf(this.pfB.ozA), Integer.valueOf(0), cbr(), Integer.valueOf(cbp()), cbq() });
    }
    a(this.pfB);
    Bk(1);
    AppMethodBeat.o(198969);
  }
  
  public final void a(com.tencent.mm.plugin.collect.model.u paramu)
  {
    int k = 0;
    AppMethodBeat.i(64160);
    ad.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.dMx != 1) && (this.dMx != 0)) || ((paramu.msgType == 9) || ((this.dMx == 8) && (paramu.msgType == 26))))
    {
      if (this.mUw != null) {
        this.mUw.vibrate(50L);
      }
      if (paramu.paX < this.nGh)
      {
        ad.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(64160);
        return;
      }
      i = 0;
      if (i >= this.pfb.size()) {
        break label510;
      }
      if ((paramu.status != 0) || (!bt.nullAsNil(paramu.username).equals(((CollectMainUI.a)this.pfb.get(i)).username)) || (((CollectMainUI.a)this.pfb.get(i)).status != 2)) {
        break label320;
      }
      this.pfb.remove(i);
      this.pfb.add(i, new CollectMainUI.a(this, paramu));
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
        if (i < this.pfb.size())
        {
          localObject = (com.tencent.mm.plugin.collect.model.u)this.pfb.get(i);
          if (paramu.paX > ((com.tencent.mm.plugin.collect.model.u)localObject).paX)
          {
            this.pfb.add(i, new CollectMainUI.a(this, paramu));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.pfb.add(new CollectMainUI.a(this, paramu));
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64116);
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.o(CollectMainUI.this).cby();
              CollectMainUI.i(CollectMainUI.this);
              AppMethodBeat.o(64116);
            }
          });
          AppMethodBeat.o(64160);
          return;
          label320:
          if (paramu.dlv.equals(((CollectMainUI.a)this.pfb.get(i)).dlv))
          {
            ad.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramu.dlv);
            if (((CollectMainUI.a)this.pfb.get(i)).status == 0)
            {
              ((CollectMainUI.a)this.pfb.get(i)).status = paramu.status;
              ((CollectMainUI.a)this.pfb.get(i)).paV = paramu.paV;
              ((CollectMainUI.a)this.pfb.get(i)).dne = paramu.dne;
              if (paramu.status == 1)
              {
                localObject = this.pfi;
                CollectMainUI.a locala = (CollectMainUI.a)this.pfb.get(i);
                ((b)localObject).pgd.add(locala);
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
  
  protected final void cM(final List<byw> paramList)
  {
    AppMethodBeat.i(64174);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        byw localbyw = (byw)localIterator.next();
        if (localbyw.type == 1) {
          com.tencent.mm.plugin.report.service.g.yhR.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localbyw.dxD, "", "", "", Integer.valueOf(1) });
        } else if (localbyw.type == 2) {
          com.tencent.mm.plugin.report.service.g.yhR.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localbyw.dxD, "", "", localbyw.url, Integer.valueOf(1) });
        } else if (localbyw.type == 3) {
          com.tencent.mm.plugin.report.service.g.yhR.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localbyw.dxD, localbyw.GUa, localbyw.GUb, "", Integer.valueOf(1) });
        }
      }
    }
    this.peV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198960);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(CollectMainUI.this.getContext(), 1, false);
        paramAnonymousView.KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(198958);
            com.tencent.mm.plugin.collect.a.a.cag();
            if (com.tencent.mm.plugin.collect.a.a.cai()) {
              paramAnonymous2l.add(0, 1, 0, 2131757457);
            }
            while (CollectMainUI.9.this.jlt != null)
            {
              int i = 0;
              while (i < CollectMainUI.9.this.jlt.size())
              {
                byw localbyw = (byw)CollectMainUI.9.this.jlt.get(i);
                if (!bt.isNullOrNil(localbyw.dxD)) {
                  paramAnonymous2l.add(0, i + 1 + 1, 0, localbyw.dxD);
                }
                i += 1;
              }
              paramAnonymous2l.add(0, 1, 0, 2131757467);
            }
            AppMethodBeat.o(198958);
          }
        };
        paramAnonymousView.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(198959);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId() - 1 - 1;
              if (paramAnonymous2Int < 0)
              {
                ad.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                AppMethodBeat.o(198959);
                return;
              }
              break;
            case 1: 
              com.tencent.mm.plugin.collect.a.a.cag();
              if (com.tencent.mm.plugin.collect.a.a.cai())
              {
                CollectMainUI.A(CollectMainUI.this);
                Toast.makeText(CollectMainUI.this.getContext(), 2131757458, 1).show();
                com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(198959);
                return;
              }
              CollectMainUI.B(CollectMainUI.this);
              Toast.makeText(CollectMainUI.this.getContext(), 2131757468, 1).show();
              com.tencent.mm.plugin.collect.model.voice.a.cax().jL(false);
              com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(7) });
              AppMethodBeat.o(198959);
              return;
            }
            paramAnonymous2MenuItem = (byw)CollectMainUI.9.this.jlt.get(paramAnonymous2Int);
            if (paramAnonymous2MenuItem.type == 1)
            {
              ad.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramAnonymous2MenuItem.url });
              com.tencent.mm.plugin.report.service.g.yhR.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2MenuItem.dxD, "", "", "", Integer.valueOf(2) });
              AppMethodBeat.o(198959);
              return;
            }
            if (paramAnonymous2MenuItem.type == 2)
            {
              if (!bt.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                com.tencent.mm.wallet_core.ui.e.o(CollectMainUI.this.getContext(), paramAnonymous2MenuItem.url, false);
                com.tencent.mm.plugin.report.service.g.yhR.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramAnonymous2MenuItem.dxD, "", "", paramAnonymous2MenuItem.url, Integer.valueOf(2) });
                AppMethodBeat.o(198959);
              }
            }
            else if (paramAnonymous2MenuItem.type == 3)
            {
              vm localvm = new vm();
              localvm.dJF.userName = paramAnonymous2MenuItem.GUa;
              localvm.dJF.dJH = bt.bI(paramAnonymous2MenuItem.GUb, "");
              localvm.dJF.scene = 1072;
              localvm.dJF.dJI = 0;
              com.tencent.mm.sdk.b.a.IbL.l(localvm);
              com.tencent.mm.plugin.report.service.g.yhR.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramAnonymous2MenuItem.dxD, paramAnonymous2MenuItem.GUa, paramAnonymous2MenuItem.GUb, "", Integer.valueOf(2) });
            }
            AppMethodBeat.o(198959);
          }
        };
        paramAnonymousView.cMW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198960);
      }
    });
    AppMethodBeat.o(64174);
  }
  
  protected void cbe()
  {
    AppMethodBeat.i(64168);
    if (com.tencent.mm.plugin.collect.model.f.oZT == null) {
      com.tencent.mm.plugin.collect.model.f.oZT = new com.tencent.mm.plugin.collect.model.f();
    }
    this.pfl = com.tencent.mm.plugin.collect.model.f.oZT;
    Object localObject = this.pfl;
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1588, (com.tencent.mm.al.f)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.pfl;
    f.a local7 = new f.a()
    {
      public final void K(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        AppMethodBeat.i(198955);
        ad.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt) });
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.this.peX = paramAnonymousString1;
        CollectMainUI.a(CollectMainUI.this, paramAnonymousInt);
        CollectMainUI.this.mTrueName = paramAnonymousString2;
        paramAnonymousString1 = CollectMainUI.cbw();
        paramAnonymousString2 = CollectMainUI.cbx();
        CollectMainUI.a(CollectMainUI.this, paramAnonymousString1);
        CollectMainUI.this.cM(paramAnonymousString2);
        if (CollectMainUI.x(CollectMainUI.this) == 1)
        {
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.ajD();
          CollectMainUI.b(paramAnonymousString1, ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBD, Integer.valueOf(-1))).intValue());
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.g.ajD();
          CollectMainUI.a(paramAnonymousString1, (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBE, ""));
        }
        AppMethodBeat.o(198955);
      }
      
      public final void a(boolean paramAnonymousBoolean, um paramAnonymousum)
      {
        AppMethodBeat.i(198956);
        Object localObject;
        if (paramAnonymousum == null)
        {
          localObject = "null";
          ad.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), localObject });
          if (!paramAnonymousBoolean) {
            break label499;
          }
          if ((paramAnonymousum == null) || (paramAnonymousum.dlw != 416)) {
            break label189;
          }
          if (paramAnonymousum.FTQ != null) {
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
          int i = paramAnonymousum.dlw;
          paramAnonymousum = paramAnonymousum.FTQ;
          new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(198954);
              ad.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
              AppMethodBeat.o(198954);
            }
          };
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localCollectMainUI, i, paramAnonymousum, (Bundle)localObject, 1010);
          AppMethodBeat.o(198956);
          return;
          localObject = Integer.valueOf(paramAnonymousum.dlw);
          break;
        }
        label189:
        CollectMainUI.this.cbi();
        CollectMainUI.w(CollectMainUI.this).setVisibility(0);
        CollectMainUI.a(CollectMainUI.this, false);
        CollectMainUI.this.peX = paramAnonymousum.url;
        CollectMainUI.a(CollectMainUI.this, ag.ago(paramAnonymousum.FTC));
        CollectMainUI.this.mTrueName = paramAnonymousum.CTa;
        CollectMainUI.b(CollectMainUI.this, paramAnonymousum.xYX);
        CollectMainUI.b(CollectMainUI.this, paramAnonymousum.xYY);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousum.xYZ);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousum.FTN);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousum.iTH);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousum.iTI);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousum.FTK);
        CollectMainUI.this.cM(paramAnonymousum.FTJ);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousum.FTO);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousum.FTP);
        ad.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.y(CollectMainUI.this)) });
        CollectMainUI.c(CollectMainUI.this, paramAnonymousum.FTU);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousum.FTV);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousum.FTW);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousum.FTX);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBD, Integer.valueOf(CollectMainUI.z(CollectMainUI.this)));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBE, CollectMainUI.a(CollectMainUI.this));
        CollectMainUI.this.refreshView();
        label499:
        AppMethodBeat.o(198956);
      }
    };
    com.tencent.mm.kernel.g.ajD();
    String str1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAO, "");
    com.tencent.mm.kernel.g.ajD();
    String str2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAP, "");
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAQ, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (bt.isNullOrNil(str1))
    {
      ad.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = t.eFy().eGh();
    }
    local7.K((String)localObject, str2, i);
    localObject = new com.tencent.mm.plugin.collect.model.l();
    localf.nyV.put(localObject, local7);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(64168);
  }
  
  protected String cbf()
  {
    AppMethodBeat.i(64173);
    String str = com.tencent.mm.wallet_core.ui.e.aYE(this.pfd);
    AppMethodBeat.o(64173);
    return str;
  }
  
  protected void cbg() {}
  
  protected void cbh()
  {
    AppMethodBeat.i(64156);
    this.peC.setImageBitmap(null);
    if (this.pff)
    {
      if (bt.isNullOrNil(this.peZ))
      {
        ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.peW = cL(this.peZ, this.pfa);
      if ((this.peW == null) || (this.peW.isRecycled())) {
        break label237;
      }
      this.peC.setImageBitmap(this.peW);
      label91:
      if (!this.pff) {
        break label281;
      }
      this.peE.setPrefix(cbf());
      this.peE.setText(com.tencent.mm.wallet_core.ui.e.C(this.pfc));
      this.peE.setVisibility(0);
      if (bt.isNullOrNil(this.pfe)) {
        break label269;
      }
      this.peD.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.pfe, this.peD.getTextSize()));
      this.peD.setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131298455).setVisibility(0);
      AppMethodBeat.o(64156);
      return;
      if (bt.isNullOrNil(this.peX))
      {
        ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.peW = cL(this.peX, this.pfa);
      break;
      label237:
      ad.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bt.nullAsNil(this.peZ));
      break label91;
      label269:
      this.peD.setVisibility(8);
    }
    label281:
    this.peF.setVisibility(8);
    this.peE.setVisibility(8);
    this.peD.setVisibility(8);
    findViewById(2131298455).setVisibility(8);
    AppMethodBeat.o(64156);
  }
  
  protected final void cbi()
  {
    AppMethodBeat.i(198968);
    com.tencent.mm.kernel.g.ajD();
    if (((String)com.tencent.mm.kernel.g.ajC().ajl().get(327731, "0")).equals("0"))
    {
      h.a(getContext(), ah.fRK(), 2131757461, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(327731, "1");
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().fqc();
    }
    AppMethodBeat.o(198968);
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
      this.mTrueName = t.eFy().getTrueName();
      this.mTrueName = com.tencent.mm.wallet_core.ui.e.aYH(this.mTrueName);
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
    this.mzx = getPreferenceScreen();
    this.peI = ((RelativeLayout)findViewById(2131304239));
    this.peJ = findViewById(2131298462);
    this.pfx = findViewById(2131298463);
    this.peE = ((WalletTextView)findViewById(2131298452));
    this.peD = ((TextView)findViewById(2131298451));
    this.peF = ((TextView)findViewById(2131298453));
    this.peG = ((TextView)findViewById(2131298461));
    this.peT = ((LinearLayout)findViewById(2131302956));
    this.peU = ((TextView)findViewById(2131297186));
    this.peL = ((RelativeLayout)findViewById(2131298459));
    this.peM = findViewById(2131298457);
    this.pfh = LayoutInflater.from(this).inflate(2131493561, null, false);
    this.peH = ((TextView)findViewById(2131298471));
    Object localObject = new SpannableStringBuilder(getString(2131757476));
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(64132);
        CollectMainUI.a(CollectMainUI.this, CollectMainUI.b(CollectMainUI.this));
        CollectMainUI.c(CollectMainUI.this);
        if (CollectMainUI.b(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.g.yhR.f(20032, new Object[] { "wxface2face", "ClickQRCode", "", "", "", "", Integer.valueOf(2), Integer.valueOf(CollectMainUI.b(CollectMainUI.this).ozA), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(64132);
      }
    }), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.peH.setText((CharSequence)localObject);
    this.peH.setClickable(true);
    this.peH.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    getListView().addFooterView(this.pfh, null, false);
    getListView().setFooterDividersEnabled(false);
    this.peC = ((ImageView)findViewById(2131298456));
    this.mkS = ((TextView)findViewById(2131298477));
    this.peS = ((TextView)findViewById(2131298490));
    this.peS.setClickable(true);
    this.peS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.pfj = new SpannableStringBuilder(getString(2131757464));
    this.pfk = new SpannableStringBuilder(getString(2131757465));
    localObject = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(64133);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeUI.class);
        paramAnonymousView.putExtra("key_currency_unit", CollectMainUI.this.peY);
        CollectMainUI.this.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(64133);
      }
    });
    final com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q("#576B95", new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(64134);
        CollectMainUI.this.pff = false;
        CollectMainUI.this.cbh();
        CollectMainUI.h(CollectMainUI.this).setText(CollectMainUI.g(CollectMainUI.this));
        CollectMainUI.i(CollectMainUI.this);
        AppMethodBeat.o(64134);
      }
    });
    this.pfj.setSpan(localObject, 0, this.pfj.length(), 18);
    if (a.a.fyf().fye()) {
      this.peS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64135);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (CollectMainUI.h(CollectMainUI.this).getText().toString().equals(CollectMainUI.j(CollectMainUI.this))) {
            this.pga.onClick(paramAnonymousView);
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
    this.pfk.setSpan(localq, 0, this.pfk.length(), 18);
    this.peS.setText(this.pfj);
    this.peV = ((RelativeLayout)findViewById(2131298479));
    this.peC.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64140);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        CollectMainUI.b(CollectMainUI.this, CollectMainUI.k(CollectMainUI.this));
        if (CollectMainUI.k(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.g.yhR.f(20032, new Object[] { "wxface2face", "LongClick", "", "", "", "", Integer.valueOf(3), Integer.valueOf(CollectMainUI.k(CollectMainUI.this).ozA), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(64140);
        return true;
      }
    });
    this.peO = findViewById(2131298464);
    this.peP = ((ImageView)findViewById(2131298481));
    this.peQ = ((TextView)findViewById(2131298483));
    this.peR = ((TextView)findViewById(2131298482));
    this.pfs = ((CdnImageView)findViewById(2131298421));
    this.pft = ((TextView)findViewById(2131298424));
    this.pfu = ((TextView)findViewById(2131298425));
    this.pfv = ((ImageView)findViewById(2131298423));
    this.pfw = ((ViewGroup)findViewById(2131298422));
    this.peL.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64141);
        int[] arrayOfInt = new int[2];
        CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
        CollectMainUI.Bl(arrayOfInt[1]);
        AppMethodBeat.o(64141);
      }
    }, 300L);
    localObject = new yi();
    ((yi)localObject).dMB.scene = "8";
    ((yi)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64114);
        if (!bt.isNullOrNil(this.pfP.dMC.dMD))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)CollectMainUI.this.findViewById(2131297186), this.pfP.dMC.dMD, this.pfP.dMC.content, this.pfP.dMC.url);
          AppMethodBeat.o(64114);
          return;
        }
        ad.i("MicroMsg.CollectMainUI", "no bulletin data");
        AppMethodBeat.o(64114);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    this.pfE = ((LinearLayout)findViewById(2131307177));
    this.pfF = ((TextView)findViewById(2131307180));
    this.pfG = ((Button)findViewById(2131307178));
    this.pfH = ((Button)findViewById(2131307179));
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
        this.peZ = paramIntent.getStringExtra("ftf_pay_url");
        this.pfa = paramIntent.getIntExtra("key_error_level", -1);
        this.pfc = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.pfd = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.pfe = paramIntent.getStringExtra("ftf_fixed_desc");
        this.peY = paramIntent.getStringExtra("key_currency_unit");
        this.peS.setText(this.pfk);
      }
      for (this.pff = true;; this.pff = false)
      {
        refreshView();
        cbj();
        AppMethodBeat.o(64161);
        return;
      }
      this.pek = com.tencent.mm.model.u.aAr();
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
    com.tencent.mm.kernel.g.ajD();
    this.dMx = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
    this.pek = com.tencent.mm.model.u.aAr();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.g.yhR.f(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(2130772144, 2130772141);
    com.tencent.mm.plugin.collect.a.a.cag();
    paramBundle = com.tencent.mm.plugin.collect.a.a.cah();
    if (!paramBundle.owv.contains(this)) {
      paramBundle.owv.add(this);
    }
    initView();
    cbe();
    refreshView();
    this.mUw = ((Vibrator)getSystemService("vibrator"));
    this.nGh = bt.aQJ();
    if (pfK < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      pfK = paramBundle.widthPixels / 2 - BackwardSupportUtil.b.g(getContext(), 20.0F);
      pfL = BackwardSupportUtil.b.g(getContext(), 60.0F);
      pfM = BackwardSupportUtil.b.g(getContext(), 40.0F);
      pfN = BackwardSupportUtil.b.g(getContext(), 70.0F);
    }
    cbj();
    ab.kB(16, 0);
    com.tencent.mm.kernel.g.aiU().a(3781, this);
    AppMethodBeat.o(64150);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64152);
    if (this.peC != null) {
      this.peC.setImageBitmap(null);
    }
    Object localObject = this.peW;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ad.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.peK != null) {
      this.peK.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.cag();
    com.tencent.mm.plugin.collect.a.a.cah().owv.remove(this);
    this.mUw.cancel();
    if (this.pfl != null)
    {
      localObject = this.pfl;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).nyV.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ad.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).nyV.clear();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(1588, (com.tencent.mm.al.f)localObject);
    }
    com.tencent.mm.platformtools.u.c(this.pfJ);
    com.tencent.mm.kernel.g.aiU().b(3781, this);
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
    AppMethodBeat.i(198974);
    ad.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m)) {
      ad.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
    }
    AppMethodBeat.o(198974);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(64155);
    if (bt.isNullOrNil(this.peX))
    {
      ad.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(64155);
      return;
    }
    if (this.pfm == 1)
    {
      if (!bt.isNullOrNil(this.pfn)) {
        this.mkS.setText(this.pfn);
      }
      if (!bt.isNullOrNil(this.pfo))
      {
        TextView localTextView = (TextView)findViewById(2131298458);
        localTextView.setText(this.pfo);
        localTextView.setVisibility(0);
      }
    }
    cbh();
    cbk();
    cbl();
    cbm();
    AppMethodBeat.o(64155);
  }
  
  public final void setStatusColor()
  {
    AppMethodBeat.i(64151);
    setActionbarColor(getResources().getColor(2131099827));
    AppMethodBeat.o(64151);
  }
  
  final class b
  {
    boolean pgc;
    LinkedList<CollectMainUI.a> pgd;
    
    private b()
    {
      AppMethodBeat.i(64145);
      this.pgd = new LinkedList();
      AppMethodBeat.o(64145);
    }
    
    private int Bm(int paramInt)
    {
      AppMethodBeat.i(64146);
      float f2 = 0.0F + CollectMainUI.l(CollectMainUI.this).getHeight() / 2;
      float f1 = f2;
      if (CollectMainUI.p(CollectMainUI.this).getVisibility() == 0) {
        f1 = f2 + CollectMainUI.p(CollectMainUI.this).getHeight();
      }
      f2 = CollectMainUI.cbt() * paramInt + CollectMainUI.cbt() / 2;
      int[] arrayOfInt = new int[2];
      CollectMainUI.l(CollectMainUI.this).getLocationInWindow(arrayOfInt);
      paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.bHx()));
      AppMethodBeat.o(64146);
      return paramInt;
    }
    
    private void a(final CollectMainUI.a parama)
    {
      AppMethodBeat.i(64148);
      this.pgc = true;
      CollectMainUI.n(CollectMainUI.this);
      CollectMainUI.q(CollectMainUI.this).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.l(CollectMainUI.this).getWidth(), CollectMainUI.l(CollectMainUI.this).getHeight()));
      if (CollectMainUI.this.pff) {
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.cbu(), 0, 0);
      }
      final AnimationSet localAnimationSet;
      int j;
      for (;;)
      {
        CollectMainUI.r(CollectMainUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(CollectMainUI.this.getContext(), parama.fVj, CollectMainUI.r(CollectMainUI.this).getTextSize()));
        a.b.c(CollectMainUI.s(CollectMainUI.this), parama.username);
        CollectMainUI.t(CollectMainUI.this).setText(com.tencent.mm.wallet_core.ui.e.d(parama.paV, parama.dne));
        CollectMainUI.q(CollectMainUI.this).setVisibility(0);
        localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
        j = 0;
        int i = 0;
        while (i < CollectMainUI.u(CollectMainUI.this).size())
        {
          if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dlv.equals(parama.dlv)) {
            j = i;
          }
          i += 1;
        }
        CollectMainUI.q(CollectMainUI.this).setPadding(0, CollectMainUI.cbv(), 0, 0);
      }
      localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.cbs(), 0.0F, Bm(j)));
      localAnimationSet.setDuration(300L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64142);
          CollectMainUI.q(CollectMainUI.this).setVisibility(8);
          ad.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + parama.dlv);
          int i = 0;
          for (;;)
          {
            if (i < CollectMainUI.u(CollectMainUI.this).size())
            {
              if (((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).dlv.equals(parama.dlv))
              {
                ((CollectMainUI.a)CollectMainUI.u(CollectMainUI.this).get(i)).isAnimated = true;
                ad.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + parama.dlv);
              }
            }
            else
            {
              CollectMainUI.n(CollectMainUI.this);
              CollectMainUI.b.this.pgc = false;
              CollectMainUI.b.this.cby();
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
    
    public final void cby()
    {
      AppMethodBeat.i(64147);
      if (!this.pgc)
      {
        if (!this.pgd.isEmpty())
        {
          a((CollectMainUI.a)this.pgd.poll());
          AppMethodBeat.o(64147);
        }
      }
      else {
        ad.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.pgd.size());
      }
      AppMethodBeat.o(64147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */