package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.plugin.emoji.model.c;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private int Fb;
  private View Ww;
  private String ejr;
  private Dialog gKM;
  private boolean icT;
  private TextView kPB;
  private TextView kRB;
  private ImageView lNK;
  private c.a lhf;
  private String liJ;
  private EmojiInfo lkU;
  private View llk;
  private TextView nIU;
  private List<w> oja;
  private TextView ojg;
  private ListView ojo;
  private ImageView ojp;
  private TextView ojq;
  private ImageView ojr;
  private View ojs;
  private View ojt;
  AbsListView.OnScrollListener ojv;
  private SoundPool okt;
  private com.tencent.mm.particles.b olV;
  private int onK;
  private LuckyMoneyWishFooter orB;
  private View orD;
  private boolean orF;
  private int orG;
  private String orH;
  private String orI;
  private String orJ;
  private String orK;
  private Map<String, Integer> orM;
  private i orN;
  private String orO;
  private boolean orP;
  private TextView osA;
  private ViewGroup osB;
  private RelativeLayout osC;
  private int[] osD;
  private ViewGroup osE;
  private RelativeLayout osF;
  private BaseEmojiView osG;
  private TextView osH;
  private LinearLayout osI;
  private MMAnimateView osJ;
  private LinearLayout osK;
  private LinearLayout osL;
  private RelativeLayout osM;
  private LinearLayout osN;
  private BaseEmojiView osO;
  private RelativeLayout osP;
  private ImageView osQ;
  private a osR;
  private View osS;
  private ImageView osT;
  private FrameLayout osU;
  private boolean osV;
  private int osW;
  private ChatFooterPanel osX;
  private EmojiInfo osY;
  private ViewGroup osZ;
  private CdnImageView osp;
  private ImageView osq;
  private View osr;
  private ImageView oss;
  private TextView ost;
  private ViewGroup osu;
  private ViewGroup osv;
  private View osw;
  private View osx;
  private View osy;
  private TextView osz;
  public LuckyMoneyEmojiSwitch ota;
  private ac otb;
  private aa otc;
  private com.tencent.mm.g.b.a.ab otd;
  private int ote;
  private boolean otf;
  private Bitmap otg;
  private Bitmap oth;
  private Bitmap oti;
  private Bitmap otj;
  private Bitmap otk;
  private Bitmap otl;
  private Bitmap otm;
  private Bitmap otn;
  private boolean oto;
  private int otp;
  private View otq;
  private long otr;
  private View.OnClickListener ots;
  private int ott;
  private f otu;
  private int otv;
  private int otw;
  private final int otx;
  private final int oty;
  
  public LuckyMoneyDetailUI()
  {
    AppMethodBeat.i(42683);
    this.Fb = 0;
    this.orF = true;
    this.icT = false;
    this.onK = -1;
    this.oja = new LinkedList();
    this.orM = new HashMap();
    this.orO = "";
    this.osV = false;
    this.orP = false;
    this.ote = 0;
    this.otf = false;
    this.ojv = new LuckyMoneyDetailUI.1(this);
    this.olV = new LuckyMoneyDetailUI.12(this);
    this.oto = false;
    this.lhf = new LuckyMoneyDetailUI.22(this);
    this.otr = 0L;
    this.ots = new LuckyMoneyDetailUI.13(this);
    this.ott = 3;
    this.otu = new LuckyMoneyDetailUI.15(this);
    this.otv = 0;
    this.otw = 0;
    this.otx = 750;
    this.oty = 240;
    AppMethodBeat.o(42683);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(42697);
    this.otw = 3;
    this.osG.setEmojiInfo(paramEmojiInfo);
    this.otb = new ac();
    this.otb.cRI = 11L;
    this.otb.ake();
    AppMethodBeat.o(42697);
  }
  
  private void a(final com.tencent.mm.plugin.luckymoney.model.k paramk)
  {
    AppMethodBeat.i(42700);
    if (paramk == null)
    {
      AppMethodBeat.o(42700);
      return;
    }
    boolean bool = e(paramk);
    label68:
    label102:
    label113:
    int i;
    label164:
    int j;
    label197:
    label329:
    label467:
    label496:
    Object localObject2;
    label616:
    Object localObject3;
    if (f(paramk)) {
      if (bNW()) {
        if (bool)
        {
          yw(1);
          if (!bNW()) {
            break label1902;
          }
          this.osF.setVisibility(0);
          ja(true);
          if ((!bo.hl(this.ota.onT, 0)) && (e(paramk)) && (this.otf)) {
            break label1914;
          }
          yx(0);
          if (paramk.onC != 1) {
            break label2025;
          }
          bool = true;
          this.orF = bool;
          if (paramk != null)
          {
            if (((paramk.cMQ != 3) && (paramk.cMQ != 2)) || (paramk.onB != 1) || (this.orF) || (paramk.onE != 1)) {
              break label2031;
            }
            i = 1;
            if ((paramk.onF == null) || (paramk.onF.eoD != 1) || (bo.isNullOrNil(paramk.onF.ona))) {
              break label2036;
            }
            j = 1;
            this.osz = ((TextView)this.llk.findViewById(2131825602));
            if ((i == 0) && (j == 0)) {
              break label2041;
            }
            this.osz.setOnClickListener(new LuckyMoneyDetailUI.24(this, paramk));
            if (j != 0)
            {
              this.orK = paramk.onF.ona;
              this.osz.setText(paramk.onF.onb);
            }
            com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(yu(paramk.onK)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
            this.osz.setVisibility(0);
            this.onK = paramk.onK;
            this.osA = ((TextView)this.llk.findViewById(2131825603));
            this.osA.setVisibility(8);
            if (!this.orP)
            {
              this.ojo.addFooterView(this.llk);
              this.orP = true;
            }
          }
          if (this.Fb == 0)
          {
            this.orI = paramk.onz;
            localObject1 = this.orI;
            if ((paramk == null) || (paramk.cMP != 0) || (paramk.onL == null) || (paramk.onL.size() <= 0) || (!((w)paramk.onL.get(0)).onz.equals(localObject1)) || (paramk.onA == 1)) {
              break label2053;
            }
            i = 1;
            if (i == 0) {
              break label2058;
            }
            this.orN.ojc = false;
            this.osu.setVisibility(0);
            this.osv.setVisibility(8);
            this.orN.ojd = paramk.onK;
            if (paramk != null)
            {
              localObject1 = getContext();
              if (paramk.onK != 2) {
                break label2149;
              }
              this.ojp.setImageResource(2130839357);
              if (paramk.resourceId == 0) {
                break label2131;
              }
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramk.resourceId);
              localObject2 = new hr();
              ((hr)localObject2).cwO.cwQ = paramk.resourceId;
              ((hr)localObject2).callback = new LuckyMoneyDetailUI.20(this, (hr)localObject2, paramk);
              com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject2, Looper.myLooper());
              localObject2 = getString(2131301337, new Object[] { paramk.ons });
              i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
              j = BackwardSupportUtil.b.b(getContext(), 92.0F);
              this.ojq.setMaxWidth(i - j);
              x.a((Context)localObject1, this.ojq, (String)localObject2);
              x.a((Context)localObject1, this.nIU, paramk.oiG);
              if (paramk.cMP != 1) {
                break label2167;
              }
              this.ojr.setVisibility(0);
              this.ojr.setImageResource(2130839416);
              label726:
              if (!bo.isNullOrNil(paramk.onI))
              {
                x.m(this.osq, paramk.onI);
                this.osq.setScaleType(ImageView.ScaleType.FIT_XY);
              }
              if (bo.isNullOrNil(paramk.onJ)) {
                break label2245;
              }
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paramk.onJ });
              this.osC.setVisibility(4);
              x.i(this.lNK, paramk.onJ);
              al.p(new LuckyMoneyDetailUI.21(this), 500L);
              label820:
              if ((paramk.cMR != 2) || (this.orG == 3)) {
                break label2266;
              }
              this.ojg.setText(com.tencent.mm.wallet_core.ui.e.E(paramk.cNd / 100.0D));
              this.orN.ojc = false;
              this.ojs.setVisibility(0);
              label871:
              if (bo.isNullOrNil(paramk.okL)) {
                break label2319;
              }
              this.ojt.setVisibility(0);
              this.kRB.setText(paramk.okL);
              if (paramk.okJ != 1) {
                break label2290;
              }
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paramk.onP });
              if (bo.isNullOrNil(paramk.onP)) {
                break label2278;
              }
              this.osp.setUrl(paramk.onP);
              this.osp.setVisibility(0);
              label957:
              this.kRB.setOnClickListener(new LuckyMoneyDetailUI.23(this, paramk));
              label973:
              if (bo.isNullOrNil(paramk.onD)) {
                break label2340;
              }
              this.kPB.setText(paramk.onD);
              this.osv.setVisibility(0);
              if ((f(paramk)) && (!e(paramk)))
              {
                this.osw.setVisibility(8);
                this.osx.setVisibility(8);
                this.osy.setVisibility(8);
              }
            }
            label1044:
            if (paramk != null)
            {
              localObject1 = paramk.onG;
              if ((localObject1 != null) && (((List)localObject1).size() > 0))
              {
                localObject2 = this.Ww.findViewById(2131825620);
                localObject3 = this.Ww.findViewById(2131825623);
                View localView1 = this.Ww.findViewById(2131825626);
                ViewGroup localViewGroup1 = (ViewGroup)this.Ww.findViewById(2131825621);
                ViewGroup localViewGroup2 = (ViewGroup)this.Ww.findViewById(2131825624);
                ViewGroup localViewGroup3 = (ViewGroup)this.Ww.findViewById(2131825627);
                View localView2 = this.Ww.findViewById(2131825622);
                View localView3 = this.Ww.findViewById(2131825625);
                h.c localc = new h.c();
                localc.textColor = getResources().getColor(2131690240);
                if (((List)localObject1).size() > 0)
                {
                  h.a(this, localViewGroup1, (as)((List)localObject1).get(0), localc);
                  ((View)localObject2).setVisibility(0);
                }
                if (((List)localObject1).size() > 1)
                {
                  h.a(this, localViewGroup2, (as)((List)localObject1).get(1), localc);
                  ((View)localObject3).setVisibility(0);
                }
                if (((List)localObject1).size() > 2)
                {
                  h.a(this, localViewGroup3, (as)((List)localObject1).get(2), localc);
                  localView1.setVisibility(0);
                }
                if ((((View)localObject2).getVisibility() == 0) && ((((View)localObject3).getVisibility() == 0) || (localView1.getVisibility() == 0))) {
                  localView2.setVisibility(0);
                }
                if ((((View)localObject3).getVisibility() == 0) && (localView1.getVisibility() == 0)) {
                  localView3.setVisibility(0);
                }
                if ((((View)localObject2).getVisibility() == 0) || (((View)localObject3).getVisibility() == 0) || (localView1.getVisibility() == 0))
                {
                  this.orD.requestLayout();
                  this.orD.setVisibility(0);
                }
              }
              this.osB = ((ViewGroup)this.llk.findViewById(2131825604));
              localObject1 = new h.c();
              ((h.c)localObject1).textColor = getResources().getColor(2131690159);
              ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131427758);
              h.a(this, this.osB, paramk.onH, (h.c)localObject1);
              localObject2 = new h.c();
              ((h.c)localObject2).textColor = Color.parseColor("#0C4F8E");
              ((h.c)localObject2).textSize = getResources().getDimensionPixelSize(2131427758);
              if (paramk.onQ != null)
              {
                localObject1 = com.tencent.mm.plugin.luckymoney.model.at.Sv(paramk.onQ);
                if ((localObject1 != null) && (((com.tencent.mm.plugin.luckymoney.model.at)localObject1).opQ != null))
                {
                  ((h.c)localObject2).ovL = ((com.tencent.mm.plugin.luckymoney.model.at)localObject1).omW;
                  h.a(this, this.osB, ((com.tencent.mm.plugin.luckymoney.model.at)localObject1).opQ, (h.c)localObject2);
                  localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
                  localObject3 = ((com.tencent.mm.plugin.luckymoney.model.at)localObject1).opQ.content;
                  if (((com.tencent.mm.plugin.luckymoney.model.at)localObject1).omW == null) {
                    break label2360;
                  }
                }
              }
            }
          }
        }
      }
    }
    label2053:
    label2058:
    label2319:
    label2340:
    label2360:
    for (Object localObject1 = ((com.tencent.mm.plugin.luckymoney.model.at)localObject1).omW.xjL;; localObject1 = "")
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).e(16589, new Object[] { Integer.valueOf(1), localObject3, localObject1 });
      if (!this.oto)
      {
        this.oto = true;
        this.llk.post(new LuckyMoneyDetailUI.25(this));
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
      this.llk.post(new LuckyMoneyDetailUI.26(this));
      com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(yu(paramk.onK)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      localObject1 = paramk.onL;
      if (localObject1 == null) {
        break label2409;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (w)((List)localObject1).get(i);
        if (!this.orM.containsKey(((w)localObject2).onz))
        {
          this.oja.add(((List)localObject1).get(i));
          this.orM.put(((w)localObject2).onz, Integer.valueOf(1));
        }
        i += 1;
      }
      yw(3);
      break;
      if (bool)
      {
        yw(2);
        break;
      }
      yw(4);
      break;
      if (bool)
      {
        if (bNW())
        {
          yw(1);
          break;
        }
        yw(2);
        break;
      }
      if (bNW())
      {
        yw(3);
        break;
      }
      yw(4);
      break;
      label1902:
      this.osF.setVisibility(8);
      break label68;
      label1914:
      this.osL.setOnClickListener(this.ots);
      this.osL.setTag("nodelete");
      this.osQ.setOnClickListener(this.ots);
      this.osT.setOnClickListener(this.ots);
      this.osP.setOnClickListener(new LuckyMoneyDetailUI.10(this));
      this.osO.setOnClickListener(this.ots);
      localObject1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEN, "");
      yx(1);
      if (bo.isNullOrNil((String)localObject1)) {
        break label102;
      }
      aP(2, (String)localObject1);
      break label102;
      label2025:
      bool = false;
      break label113;
      label2031:
      i = 0;
      break label164;
      label2036:
      j = 0;
      break label197;
      label2041:
      this.osz.setVisibility(8);
      break label329;
      i = 0;
      break label467;
      this.osu.setVisibility(8);
      this.osv.setVisibility(0);
      if ((f(paramk)) && (!e(paramk)))
      {
        this.osw.setVisibility(8);
        this.osx.setVisibility(8);
        this.osy.setVisibility(8);
      }
      this.orN.ojb = this.orI;
      break label496;
      label2131:
      x.b(this.ojp, paramk.ont, paramk.onN);
      break label616;
      label2149:
      x.b(this.ojp, paramk.ont, paramk.onN);
      break label616;
      label2167:
      if (paramk.cMP == 2)
      {
        if (!com.tencent.mm.model.t.nT(paramk.onN))
        {
          localObject1 = new com.tencent.mm.ah.h();
          ((com.tencent.mm.ah.h)localObject1).username = paramk.onN;
          o.adg().b((com.tencent.mm.ah.h)localObject1);
        }
        this.ojr.setVisibility(0);
        this.ojr.setImageResource(2130839404);
        break label726;
      }
      this.ojr.setVisibility(8);
      break label726;
      label2245:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
      this.osC.setVisibility(8);
      break label820;
      label2266:
      this.ojs.setVisibility(8);
      break label871;
      label2278:
      this.osp.setVisibility(8);
      break label957;
      label2290:
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
      this.kRB.setTextColor(getResources().getColor(2131690238));
      break label973;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
      this.ojt.setVisibility(8);
      break label973;
      this.kPB.setText(null);
      this.osv.setVisibility(8);
      break label1044;
    }
    this.Fb += ((List)localObject1).size();
    this.icT = false;
    if (this.osu.getVisibility() != 0) {
      this.orN.ci(this.oja);
    }
    label2409:
    if ((paramk.cMP == 2) && (!bo.isNullOrNil(paramk.onr)))
    {
      this.okt = new SoundPool(2, 3, 0);
      this.osD = new int[2];
    }
    try
    {
      this.osD[0] = this.okt.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
      this.osD[1] = this.okt.load(getResources().getAssets().openFd("whistle.m4a"), 0);
      this.okt.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
      {
        public final void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(42666);
          if (paramAnonymousInt2 == 0)
          {
            if (paramAnonymousInt1 == LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this)[0])
            {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
              AppMethodBeat.o(42666);
              return;
            }
            if ((paramAnonymousInt1 == LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this)[1]) && (paramk.cNd >= 19000L)) {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
            }
          }
          AppMethodBeat.o(42666);
        }
      });
      this.Ww.postDelayed(new LuckyMoneyDetailUI.18(this), 300L);
      localObject1 = new ad();
      ((ad)localObject1).field_mNativeUrl = this.orJ;
      ((ad)localObject1).field_hbType = paramk.cMP;
      ((ad)localObject1).field_receiveAmount = paramk.cNd;
      ((ad)localObject1).field_receiveTime = System.currentTimeMillis();
      ((ad)localObject1).field_hbStatus = paramk.cMQ;
      ((ad)localObject1).field_receiveStatus = paramk.cMR;
      if (((ad)localObject1).field_receiveAmount > 0L) {
        com.tencent.mm.plugin.wallet_core.model.t.cTK().a((ad)localObject1);
      }
      if (paramk.onQ != null)
      {
        localObject2 = com.tencent.mm.plugin.luckymoney.model.at.Sv(paramk.onQ);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.luckymoney.model.at)localObject2).omW != null))
        {
          localObject1 = (ImageView)findViewById(2131825656);
          localObject3 = (ImageView)findViewById(2131825657);
          this.Ww.post(new LuckyMoneyDetailUI.19(this));
          ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.luckymoney.a.a.class)).b((ImageView)localObject1, ((com.tencent.mm.plugin.luckymoney.model.at)localObject2).omW);
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject3).setVisibility(0);
          if (!this.osV)
          {
            this.osV = true;
            if (((com.tencent.mm.plugin.luckymoney.model.at)localObject2).omW.xjM == null) {
              break label2864;
            }
            localObject1 = ((com.tencent.mm.plugin.luckymoney.model.at)localObject2).omW.xjM.xjX;
            paramk = paramk.onN;
            com.tencent.mm.plugin.report.service.h.qsU.e(16598, new Object[] { Integer.valueOf(3), ((com.tencent.mm.plugin.luckymoney.model.at)localObject2).omW.xjL, localObject1, paramk });
          }
        }
      }
      if ((this.gKM != null) && (this.gKM.isShowing())) {
        this.gKM.hide();
      }
      AppMethodBeat.o(42700);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + localIOException.getMessage());
        continue;
        label2864:
        String str = "";
      }
    }
  }
  
  private void aP(int paramInt, String paramString)
  {
    AppMethodBeat.i(42702);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42702);
      return;
      this.osK.setVisibility(8);
      AppMethodBeat.o(42702);
      return;
      this.osK.setVisibility(0);
      this.osL.setVisibility(0);
      this.osM.setVisibility(8);
      this.osN.setVisibility(8);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yEN, "");
      AppMethodBeat.o(42702);
      return;
      if (!bo.isNullOrNil(paramString))
      {
        paramString = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn.asP(paramString);
        if (paramString == null)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
          AppMethodBeat.o(42702);
          return;
        }
        this.osY = paramString;
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yEN, this.osY.Al());
        this.osO.setEmojiInfo(this.osY);
        this.osK.setVisibility(0);
        this.osL.setVisibility(8);
        this.osM.setVisibility(0);
        this.osN.setVisibility(8);
      }
    }
  }
  
  private void bNT()
  {
    AppMethodBeat.i(42703);
    if ((this.orB != null) && (this.orB.getVisibility() != 8)) {
      this.orB.setVisibility(8);
    }
    AppMethodBeat.o(42703);
  }
  
  private void bNV()
  {
    AppMethodBeat.i(42690);
    ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.i.class)).a(this, this.ejr, this.osY.Al(), getString(2131301311), new LuckyMoneyDetailUI.9(this));
    AppMethodBeat.o(42690);
  }
  
  private boolean bNW()
  {
    AppMethodBeat.i(42699);
    if ((!bo.isNullOrNil(this.liJ)) && ((bo.hl(this.ota.onR, 1)) || (bo.hl(this.ota.onS, 1))))
    {
      AppMethodBeat.o(42699);
      return true;
    }
    AppMethodBeat.o(42699);
    return false;
  }
  
  private boolean e(com.tencent.mm.plugin.luckymoney.model.k paramk)
  {
    return (paramk.cMR == 2) && (this.orG != 3);
  }
  
  private static boolean f(com.tencent.mm.plugin.luckymoney.model.k paramk)
  {
    return paramk.onB == 1;
  }
  
  private void ja(boolean paramBoolean)
  {
    AppMethodBeat.i(42696);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.osH.setVisibility(8);
    this.otw = 1;
    if (paramBoolean) {
      this.ott = 3;
    }
    do
    {
      this.lkU = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn.asP(this.liJ);
      if (this.lkU == null) {
        break;
      }
      if ((com.tencent.mm.vfs.e.avI(this.lkU.dQB()) <= 0L) && (!this.lkU.vY()) && (!this.lkU.dzq())) {
        break label218;
      }
      this.osG.setVisibility(0);
      A(this.lkU);
      AppMethodBeat.o(42696);
      return;
      this.ott -= 1;
    } while (this.ott != 0);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
    this.osI.setVisibility(8);
    this.osH.setVisibility(0);
    this.otw = 2;
    AppMethodBeat.o(42696);
    return;
    this.lkU = new EmojiInfo();
    this.lkU.field_md5 = this.liJ;
    this.lkU.field_type = this.osW;
    label218:
    if (paramBoolean)
    {
      this.osG.setVisibility(8);
      this.osI.setVisibility(0);
      this.osJ.setImageResource(2131231608);
      com.tencent.mm.plugin.emoji.model.i.blo().lhf = this.lhf;
    }
    com.tencent.mm.plugin.emoji.model.i.blo().t(this.lkU);
    com.tencent.mm.kernel.g.RK().eHt.a(697, this.otu);
    AppMethodBeat.o(42696);
  }
  
  private static int yu(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void yw(int paramInt)
  {
    AppMethodBeat.i(42698);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.osq.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.otv = localLayoutParams.topMargin;
      this.osq.setLayoutParams(localLayoutParams);
      this.osq.requestLayout();
      AppMethodBeat.o(42698);
      return;
      localLayoutParams.topMargin = (-BackwardSupportUtil.b.b(getContext(), 80.0F));
      continue;
      localLayoutParams.topMargin = (-BackwardSupportUtil.b.b(getContext(), 238.0F));
      continue;
      localLayoutParams.topMargin = (-BackwardSupportUtil.b.b(getContext(), 204.0F));
      continue;
      localLayoutParams.topMargin = (-BackwardSupportUtil.b.b(getContext(), 363.0F));
    }
  }
  
  private void yx(int paramInt)
  {
    AppMethodBeat.i(42701);
    aP(paramInt, "");
    AppMethodBeat.o(42701);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42692);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.orB != null) && (this.orB.getVisibility() == 0))
    {
      this.orB.setVisibility(8);
      AppMethodBeat.o(42692);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(42692);
    return bool;
  }
  
  public boolean enableActivityAnimation()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(42695);
    if (getIntent().hasExtra("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getIntent().getParcelableExtra("key_realname_guide_helper");
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
      localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
      boolean bool = localRealnameGuideHelper.b(this, localBundle, new LuckyMoneyDetailUI.14(this));
      getIntent().removeExtra("key_realname_guide_helper");
      if (!bool) {
        super.finish();
      }
    }
    for (;;)
    {
      overridePendingTransition(2131034262, 2131034267);
      AppMethodBeat.o(42695);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return 2130970024;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42688);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42678);
        LuckyMoneyDetailUI.this.finish();
        AppMethodBeat.o(42678);
        return true;
      }
    });
    this.ojo = ((ListView)findViewById(2131825658));
    this.orN = new i(getContext());
    this.Ww = LayoutInflater.from(this).inflate(2130970023, null);
    this.ojo.addHeaderView(this.Ww);
    this.ojo.setAdapter(this.orN);
    this.Ww.setOnClickListener(new LuckyMoneyDetailUI.29(this));
    this.ojo.setOnScrollListener(this.ojv);
    this.ojo.setOnItemClickListener(new LuckyMoneyDetailUI.30(this));
    this.llk = LayoutInflater.from(this).inflate(2130970021, null);
    this.ojp = ((ImageView)this.Ww.findViewById(2131825606));
    this.ojq = ((TextView)this.Ww.findViewById(2131825608));
    this.ojr = ((ImageView)this.Ww.findViewById(2131825609));
    this.nIU = ((TextView)this.Ww.findViewById(2131825610));
    this.osF = ((RelativeLayout)findViewById(2131825633));
    this.osG = ((BaseEmojiView)findViewById(2131825634));
    this.osH = ((TextView)findViewById(2131825635));
    this.osI = ((LinearLayout)findViewById(2131825636));
    this.osJ = ((MMAnimateView)findViewById(2131825637));
    this.ojs = this.Ww.findViewById(2131825611);
    this.ojg = ((TextView)this.Ww.findViewById(2131825612));
    this.ojt = this.Ww.findViewById(2131825614);
    this.kRB = ((TextView)this.Ww.findViewById(2131825616));
    this.osp = ((CdnImageView)this.Ww.findViewById(2131825615));
    this.kPB = ((TextView)this.Ww.findViewById(2131825628));
    this.osq = ((ImageView)this.Ww.findViewById(2131825605));
    this.orD = this.Ww.findViewById(2131825619);
    this.osr = this.Ww.findViewById(2131825617);
    this.oss = ((ImageView)this.Ww.findViewById(2131825618));
    this.osK = ((LinearLayout)findViewById(2131825639));
    this.osL = ((LinearLayout)findViewById(2131825640));
    this.osM = ((RelativeLayout)findViewById(2131825643));
    this.osN = ((LinearLayout)findViewById(2131825648));
    this.osO = ((BaseEmojiView)findViewById(2131825644));
    this.osP = ((RelativeLayout)findViewById(2131825647));
    this.osQ = ((ImageView)findViewById(2131825646));
    this.ost = ((TextView)this.Ww.findViewById(2131825630));
    this.osu = ((ViewGroup)this.Ww.findViewById(2131825653));
    this.osv = ((ViewGroup)this.Ww.findViewById(2131825649));
    this.osw = findViewById(2131825651);
    this.osx = findViewById(2131825650);
    this.osy = findViewById(2131825652);
    this.osC = ((RelativeLayout)this.Ww.findViewById(2131825617));
    this.lNK = ((ImageView)this.Ww.findViewById(2131825618));
    this.orB = ((LuckyMoneyWishFooter)findViewById(2131825659));
    this.otq = findViewById(2131825655);
    this.osE = ((ViewGroup)findViewById(2131825660));
    this.osT = ((ImageView)findViewById(2131825645));
    this.osU = ((FrameLayout)findViewById(2131825654));
    this.osH.setOnClickListener(new LuckyMoneyDetailUI.31(this));
    this.osR = new a(this);
    this.osS = getLayoutInflater().inflate(2130970026, null);
    this.osR.setContentView(this.osS, new ViewGroup.LayoutParams(-1, -1));
    this.osS.findViewById(2131825661).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42682);
        LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
        AppMethodBeat.o(42682);
      }
    });
    this.osR.oqT = new LuckyMoneyDetailUI.2(this);
    this.osZ = ((ViewGroup)this.osS.findViewById(2131825663));
    this.osX = com.tencent.mm.pluginsdk.ui.chat.e.vYI.dK(getContext());
    com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.osX);
    this.osp.setUseSdcardCache(true);
    this.orB.a(new LuckyMoneyDetailUI.3(this));
    this.orB.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void Sw(String paramAnonymousString)
      {
        AppMethodBeat.i(42649);
        if ((!bo.isNullOrNil(paramAnonymousString)) && (!bo.isNullOrNil(LuckyMoneyDetailUI.u(LuckyMoneyDetailUI.this))))
        {
          paramAnonymousString = new am(LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this), paramAnonymousString, LuckyMoneyDetailUI.u(LuckyMoneyDetailUI.this), "v1.0");
          LuckyMoneyDetailUI.this.doSceneProgress(paramAnonymousString, false);
          LuckyMoneyDetailUI.r(LuckyMoneyDetailUI.this);
        }
        AppMethodBeat.o(42649);
      }
    });
    this.orB.post(new LuckyMoneyDetailUI.5(this));
    this.orB.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void sJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(42651);
        if (paramAnonymousInt == -2)
        {
          if (LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this).oxo)
          {
            LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this).setModeClick(false);
            AppMethodBeat.o(42651);
            return;
          }
          LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this).setVisibility(8);
        }
        AppMethodBeat.o(42651);
      }
    });
    this.orN.owY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42652);
        LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this).setVisibility(0);
        AppMethodBeat.o(42652);
      }
    };
    this.orB.setMaxLength(25);
    this.ost.setOnClickListener(new LuckyMoneyDetailUI.8(this));
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LuckyMoneyDetailUI", "after initview");
    AppMethodBeat.o(42688);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42694);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(42694);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        if (!bo.isNullOrNil(str)) {
          if ((this.orK != null) && (this.orK.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          }
          else
          {
            doSceneProgress(new ar(str.replaceAll(",", "|"), this.orH, "v1.0"));
            continue;
            if (paramInt2 == -1)
            {
              str = "";
              if (paramIntent != null) {
                str = paramIntent.getStringExtra("gif_md5");
              }
              if (!bo.isNullOrNil(str))
              {
                aP(2, str);
                bNV();
              }
              else
              {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
              }
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42689);
    super.onBackPressed();
    AppMethodBeat.o(42689);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42684);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131690709);
    int i;
    if (getIntent().getBooleanExtra("key_anim_slide", false)) {
      i = 2131034266;
    }
    for (;;)
    {
      overridePendingTransition(i, 0);
      setActionbarColor(getResources().getColor(2131690253));
      hideActionbarLine();
      initView();
      this.otf = getIntent().getBooleanExtra("key_lucky_money_can_received", false);
      this.ejr = getIntent().getStringExtra("key_username");
      this.orH = getIntent().getStringExtra("key_sendid");
      this.orJ = getIntent().getStringExtra("key_native_url");
      this.orG = getIntent().getIntExtra("key_jump_from", 2);
      this.orO = getIntent().getStringExtra("key_process_content");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + bo.nullAsNil(this.orH) + ", nativeurl=" + bo.nullAsNil(this.orJ) + ", jumpFrom=" + this.orG);
      if ((bo.isNullOrNil(this.orH)) && (!bo.isNullOrNil(this.orJ))) {
        paramBundle = Uri.parse(this.orJ);
      }
      try
      {
        this.orH = paramBundle.getQueryParameter("sendid");
        for (;;)
        {
          try
          {
            label250:
            paramBundle = getIntent().getByteArrayExtra("key_detail_info");
            this.liJ = getIntent().getStringExtra("key_detail_emoji_md5");
            this.osW = getIntent().getIntExtra("key_detail_emoji_type", 0);
            if (!bo.isNullOrNil(this.liJ))
            {
              this.otb = new ac();
              this.otb.cRI = 10L;
              this.otb.ake();
            }
            this.ota = ((LuckyMoneyEmojiSwitch)getIntent().getParcelableExtra("key_emoji_switch"));
            if (this.ota == null) {
              this.ota = new LuckyMoneyEmojiSwitch();
            }
            if (paramBundle != null)
            {
              paramBundle = (com.tencent.mm.plugin.luckymoney.model.k)new com.tencent.mm.plugin.luckymoney.model.k().parseFrom(paramBundle);
              if (paramBundle == null) {
                continue;
              }
              a(paramBundle);
            }
          }
          catch (Exception paramBundle)
          {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
            finish();
            continue;
          }
          if (getIntent().getBooleanExtra("play_sound", false)) {
            k.a(this, k.a.oxx);
          }
          addTextOptionMenu(0, getString(2131301206), new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(42677);
              com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.yy(LuckyMoneyDetailUI.q(LuckyMoneyDetailUI.this))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.setClass(LuckyMoneyDetailUI.this.getContext(), LuckyMoneyMyRecordUI.class);
              paramAnonymousMenuItem.putExtra("key_type", 2);
              LuckyMoneyDetailUI.this.startActivity(paramAnonymousMenuItem);
              AppMethodBeat.o(42677);
              return true;
            }
          });
          setActionbarElementColor(getResources().getColor(2131690241));
          AppMethodBeat.o(42684);
          return;
          i = 2131034217;
          break;
          finish();
        }
      }
      catch (Exception paramBundle)
      {
        break label250;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(42685);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(2131820974);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(2131690237));
    }
    AppMethodBeat.o(42685);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42704);
    super.onDestroy();
    if ((this.otw == 1) || (this.otw == 2))
    {
      this.otb = new ac();
      this.otb.cRI = 12L;
      this.otb.ake();
    }
    if (this.orB != null) {
      this.orB.bOo();
    }
    if (this.okt != null)
    {
      this.okt.release();
      int i = 0;
      while (i < this.osD.length)
      {
        this.okt.unload(this.osD[i]);
        i += 1;
      }
    }
    if (this.osX != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
      this.osX.onPause();
      this.osX.Ay();
      this.osX.destroy();
    }
    com.tencent.mm.plugin.emoji.model.i.blo().lhf = null;
    com.tencent.mm.kernel.g.RK().eHt.b(697, this.otu);
    AppMethodBeat.o(42704);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(42691);
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    keyboardState();
    AppMethodBeat.o(42691);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(42687);
    super.onPause();
    com.tencent.mm.modelstat.d.o("LuckyMoneyDetailUI", this.otr, bo.aox());
    AppMethodBeat.o(42687);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42686);
    super.onResume();
    this.otr = bo.aox();
    AppMethodBeat.o(42686);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42693);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    if ((paramm instanceof af))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (af)paramm;
        paramm = paramString.ooO;
        this.orO = paramString.opa;
        this.liJ = paramString.opb;
        this.osW = paramString.opc;
        this.ota = paramString.opd;
        a(paramm);
        AppMethodBeat.o(42693);
        return true;
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(42693);
      return true;
    }
    if ((paramm instanceof am))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.orN.ojc = false;
        bNT();
        paramString = (am)paramm;
        if (this.oja != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.oja.size())
          {
            paramm = (w)this.oja.get(paramInt1);
            if (paramm.onz.equalsIgnoreCase(paramString.onz))
            {
              paramm.ooD = paramString.oiG;
              this.orN.notifyDataSetChanged();
            }
          }
          else
          {
            if (this.osu.getVisibility() == 0) {
              this.osu.setVisibility(8);
            }
            this.orN.ci(this.oja);
            AppMethodBeat.o(42693);
            return true;
          }
          paramInt1 += 1;
        }
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(42693);
      return true;
    }
    if ((paramm instanceof ar))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
        AppMethodBeat.o(42693);
        return true;
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(42693);
      return true;
    }
    AppMethodBeat.o(42693);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */