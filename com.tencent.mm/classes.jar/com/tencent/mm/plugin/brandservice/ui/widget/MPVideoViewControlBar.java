package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.o;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MPVideoViewControlBar
  extends VideoPlayerSeekBar
  implements e.a, h
{
  private int acQ;
  private TextView ayB;
  private aw lpR;
  private e.e lwA;
  private ImageView lwg;
  private LinearLayout lwi;
  private ImageView lwj;
  private FrameLayout lwk;
  private ImageView lwl;
  private ImageView lwm;
  private ImageView lwn;
  private LinearLayout lwo;
  private LinearLayout lwp;
  private e.i lwq;
  private aw lwr;
  private boolean lws;
  private boolean lwu;
  private boolean lwv;
  private boolean lww;
  private boolean lwx;
  private boolean lwy;
  private RelativeLayout oAJ;
  private LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> oAK;
  private LinearLayout oAL;
  private ImageView oAM;
  private TextView oAN;
  private TextView oAO;
  private View oAP;
  private LinearLayout oAQ;
  private TextView oAR;
  private View oAS;
  private LinearLayout oAT;
  private a oAU;
  private b oAV;
  private Animation oAW;
  private Animation oAX;
  private Animation oAY;
  private Animation oAZ;
  private LinkedList<fu> oBa;
  private fu oBb;
  private e.f oBc;
  
  public MPVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6285);
    this.oAK = null;
    this.oBa = new LinkedList();
    AppMethodBeat.o(6285);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6286);
    this.oAK = null;
    this.oBa = new LinkedList();
    AppMethodBeat.o(6286);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6287);
    this.oAK = null;
    this.oBa = new LinkedList();
    AppMethodBeat.o(6287);
  }
  
  private boolean bTV()
  {
    return (this.lws) && ((90 == this.acQ) || (-90 == this.acQ));
  }
  
  private void bTW()
  {
    AppMethodBeat.i(6322);
    if (bu.ht(this.oAK))
    {
      AppMethodBeat.o(6322);
      return;
    }
    Iterator localIterator = this.oAK.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localIterator.next();
      if (localc.owP <= this.mPosition)
      {
        if (localc.owN) {
          break label108;
        }
        i = 1;
      }
      else
      {
        if (!localc.owN) {
          break label108;
        }
        i = 1;
      }
    }
    label108:
    for (;;)
    {
      break;
      if (i != 0) {
        L(this.oAK);
      }
      AppMethodBeat.o(6322);
      return;
    }
  }
  
  private void bTX()
  {
    AppMethodBeat.i(6325);
    if ((!bTV()) || (bu.ht(this.oBa)) || (this.oBb == null))
    {
      bTY();
      this.oAP.setVisibility(8);
      AppMethodBeat.o(6325);
      return;
    }
    this.oAO.setText(this.oBb.FQA);
    this.oAP.setVisibility(0);
    this.oAP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6284);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0)
        {
          MPVideoViewControlBar.d(MPVideoViewControlBar.this);
          if (MPVideoViewControlBar.this.cgS()) {
            MPVideoViewControlBar.this.bnY();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6284);
          return;
          if (MPVideoViewControlBar.h(MPVideoViewControlBar.this) != null) {
            MPVideoViewControlBar.h(MPVideoViewControlBar.this).bSX();
          }
          MPVideoViewControlBar.i(MPVideoViewControlBar.this);
          MPVideoViewControlBar.j(MPVideoViewControlBar.this);
        }
      }
    });
    AppMethodBeat.o(6325);
  }
  
  private void bTY()
  {
    AppMethodBeat.i(6326);
    ae.d("MicroMsg.MPVideoViewControlBar", "hideResolutionContainer");
    if (this.oAQ.getVisibility() != 8)
    {
      this.oAQ.setVisibility(8);
      if (this.oAU != null) {
        this.oAU.bSY();
      }
    }
    AppMethodBeat.o(6326);
  }
  
  private void bTZ()
  {
    AppMethodBeat.i(179005);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBq, 1) == 0) {}
    for (int i = 1; (!bTV()) || (bu.ht(this.oBa)) || (this.oBb == null) || (i != 0); i = 0)
    {
      bUa();
      this.oAS.setVisibility(8);
      AppMethodBeat.o(179005);
      return;
    }
    Object localObject = c.oAe;
    if (c.bTL().oAl == 1.0F) {}
    for (localObject = getResources().getString(2131764684);; localObject = c.bTL().desc)
    {
      this.oAR.setText((CharSequence)localObject);
      this.oAS.setVisibility(0);
      this.oAS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          m.Am(42);
          if (MPVideoViewControlBar.k(MPVideoViewControlBar.this).getVisibility() == 0)
          {
            MPVideoViewControlBar.e(MPVideoViewControlBar.this);
            if (MPVideoViewControlBar.this.cgS()) {
              MPVideoViewControlBar.this.bnY();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179004);
            return;
            if (MPVideoViewControlBar.l(MPVideoViewControlBar.this) != null) {
              MPVideoViewControlBar.l(MPVideoViewControlBar.this).bTS();
            }
            MPVideoViewControlBar.m(MPVideoViewControlBar.this);
            MPVideoViewControlBar.n(MPVideoViewControlBar.this);
          }
        }
      });
      AppMethodBeat.o(179005);
      return;
      localObject = c.oAe;
    }
  }
  
  private void bUa()
  {
    AppMethodBeat.i(179006);
    ae.d("MicroMsg.MPVideoViewControlBar", "hideSpeedContainer");
    if (this.oAT.getVisibility() != 8)
    {
      this.oAT.setVisibility(8);
      if (this.oAV != null) {
        this.oAV.bTT();
      }
    }
    AppMethodBeat.o(179006);
  }
  
  private void bUb()
  {
    AppMethodBeat.i(179007);
    ImageView localImageView = this.lwl;
    if (this.lws) {}
    for (int i = 8;; i = 0)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(179007);
      return;
    }
  }
  
  private void bUc()
  {
    AppMethodBeat.i(179008);
    ViewGroup.LayoutParams localLayoutParams = this.lvU.getLayoutParams();
    int i = getResources().getDimensionPixelSize(2131166603);
    if (this.lws) {
      i = getResources().getDimensionPixelSize(2131166602);
    }
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.lvU.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(179008);
  }
  
  private void bpj()
  {
    AppMethodBeat.i(6298);
    if (this.lws)
    {
      this.lwo.setVisibility(0);
      this.oAL.setVisibility(0);
      AppMethodBeat.o(6298);
      return;
    }
    this.lwo.setVisibility(8);
    this.oAL.setVisibility(8);
    AppMethodBeat.o(6298);
  }
  
  private void bpk()
  {
    AppMethodBeat.i(6302);
    if (this.lwx)
    {
      if (this.lwy)
      {
        this.lvU.setVisibility(8);
        this.lwm.setVisibility(0);
        AppMethodBeat.o(6302);
        return;
      }
      this.lvU.setVisibility(0);
      this.lwm.setVisibility(8);
      AppMethodBeat.o(6302);
      return;
    }
    this.lvU.setVisibility(8);
    this.lwm.setVisibility(8);
    AppMethodBeat.o(6302);
  }
  
  private void bpm()
  {
    AppMethodBeat.i(6305);
    if (this.lwu)
    {
      this.lwg.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.lwg.getLayoutParams();
      getResources().getDimensionPixelSize(2131166603);
      if (this.lws) {
        this.lwg.setImageResource(2131233933);
      }
      for (int i = getResources().getDimensionPixelSize(2131166601);; i = getResources().getDimensionPixelSize(2131166603))
      {
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        this.lwg.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(6305);
        return;
        this.lwg.setImageResource(2131690861);
      }
    }
    this.lwg.setVisibility(8);
    AppMethodBeat.o(6305);
  }
  
  private void bpn()
  {
    AppMethodBeat.i(6315);
    bpq();
    bpm();
    bpj();
    bpp();
    bpo();
    L(this.oAK);
    bTX();
    bTZ();
    bUb();
    bUc();
    AppMethodBeat.o(6315);
  }
  
  private void bpo()
  {
    AppMethodBeat.i(6316);
    if (bTV()) {}
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166587))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.lvU != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lvU.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lvU.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lwp != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lwp.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lwp.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lwl != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lwl.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lwl.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lwg != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lwg.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lwg.setLayoutParams(localMarginLayoutParams);
      }
      if (this.oAP != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.oAP.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.oAP.setLayoutParams(localMarginLayoutParams);
      }
      if (this.oAS != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.oAP.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.oAS.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(6316);
      return;
    }
  }
  
  private void bpp()
  {
    AppMethodBeat.i(6317);
    if (bTV()) {}
    for (float f = getResources().getDimensionPixelSize(2131166600);; f = getResources().getDimensionPixelSize(2131166593))
    {
      this.lvV.setTextSize(0, f);
      this.lvW.setTextSize(0, f);
      AppMethodBeat.o(6317);
      return;
    }
  }
  
  private void bpq()
  {
    AppMethodBeat.i(6318);
    ViewGroup.LayoutParams localLayoutParams = this.lwi.getLayoutParams();
    int j;
    if (this.lws)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166598);
      this.lwi.setLayoutParams(localLayoutParams);
      if (!bTV()) {
        break label143;
      }
      j = getResources().getDimensionPixelSize(2131166599);
    }
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166590))
    {
      this.lwi.setPadding(0, 0, i, 0);
      if (this.lwo != null) {
        this.lwo.setPadding(j, 0, j, 0);
      }
      if (this.oAL != null) {
        this.oAL.setPadding(j, 0, j, 0);
      }
      AppMethodBeat.o(6318);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166589);
      break;
      label143:
      j = getResources().getDimensionPixelSize(2131166590);
    }
  }
  
  private boolean bpr()
  {
    AppMethodBeat.i(6321);
    if (this.lwq == null)
    {
      ae.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(6321);
      return false;
    }
    int k = this.lwq.bnD();
    int j = this.lwq.bnE();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(6321);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(6321);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lwj.getLayoutParams();
      localLayoutParams.width = i;
      this.lwj.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(6321);
      return true;
      d = k;
    }
  }
  
  private void bps()
  {
    int j = 0;
    AppMethodBeat.i(6333);
    boolean bool;
    Object localObject;
    if (this.lww)
    {
      bool = this.lwv;
      localObject = this.lwk;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.lvV;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.lvW;
      if (!bool) {
        break label98;
      }
    }
    label86:
    label92:
    label98:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      AppMethodBeat.o(6333);
      return;
      bool = false;
      break;
      i = 8;
      break label32;
      i = 8;
      break label50;
    }
  }
  
  private void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6334);
    if (this.lwA != null) {
      this.lwA.onProgressChanged(paramInt1, paramInt2);
    }
    bTW();
    AppMethodBeat.o(6334);
  }
  
  public final void L(final LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> paramLinkedList)
  {
    AppMethodBeat.i(6323);
    this.oAK = paramLinkedList;
    if ((this.oAJ == null) || (bu.ht(this.oAK)))
    {
      this.oAJ.removeAllViews();
      AppMethodBeat.o(6323);
      return;
    }
    ae.i("MicroMsg.MPVideoViewControlBar", "updateControlBarDotPos");
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208561);
        MPVideoViewControlBar.g(MPVideoViewControlBar.this).removeAllViews();
        Object localObject = paramLinkedList;
        if (!bu.ht((List)localObject))
        {
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)((Iterator)localObject).next();
            ImageView localImageView = new ImageView(MPVideoViewControlBar.this.getContext());
            MPVideoViewControlBar.g(MPVideoViewControlBar.this).addView(localImageView);
            if (!MPVideoViewControlBar.a(MPVideoViewControlBar.this, localImageView, localc)) {
              MPVideoViewControlBar.g(MPVideoViewControlBar.this).removeView(localImageView);
            }
          }
        }
        AppMethodBeat.o(208561);
      }
    }, 100L);
    AppMethodBeat.o(6323);
  }
  
  public final void O(String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(208562);
    com.tencent.mm.av.a.a locala = com.tencent.mm.av.a.a.aJh();
    ImageView localImageView = this.oAM;
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.hhW = true;
    locala1.igv = 2131231342;
    locala.a(paramString3, localImageView, locala1.aJu());
    this.oAN.setText(paramString1);
    this.oAL.setOnClickListener(null);
    this.oAL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208557);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramString2);
        paramAnonymousView.putExtra("Contact_Scene", 179);
        paramAnonymousView.putExtra("force_get_contact", true);
        paramAnonymousView.putExtra("key_use_new_contact_profile", true);
        d.b(MPVideoViewControlBar.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
        m.Am(45);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208557);
      }
    });
    o.gZ(this.oAL);
    AppMethodBeat.o(208562);
  }
  
  public final void a(e.f paramf)
  {
    this.oBc = paramf;
  }
  
  public final void a(LinkedList<fu> paramLinkedList, fu paramfu)
  {
    AppMethodBeat.i(6324);
    if ((paramLinkedList == null) || (paramfu == null))
    {
      AppMethodBeat.o(6324);
      return;
    }
    this.oBa.clear();
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      fu localfu = (fu)paramLinkedList.next();
      if ((!bu.isNullOrNil(localfu.FQA)) && (!localHashSet.contains(Integer.valueOf(localfu.FQz))))
      {
        this.oBa.add(localfu);
        localHashSet.add(Integer.valueOf(localfu.FQz));
      }
    }
    Collections.sort(this.oBa, new Comparator() {});
    this.oBb = paramfu;
    AppMethodBeat.o(6324);
  }
  
  public final void bTU()
  {
    AppMethodBeat.i(6308);
    if (this.lwr != null) {
      this.lwr.stopTimer();
    }
    AppMethodBeat.o(6308);
  }
  
  public final void blp()
  {
    AppMethodBeat.i(6314);
    this.lws = false;
    bpn();
    AppMethodBeat.o(6314);
  }
  
  public final boolean bnP()
  {
    return false;
  }
  
  public final void bnQ()
  {
    AppMethodBeat.i(6312);
    if (bnS())
    {
      hide();
      AppMethodBeat.o(6312);
      return;
    }
    bnR();
    AppMethodBeat.o(6312);
  }
  
  public final void bnR()
  {
    AppMethodBeat.i(6306);
    show();
    if (this.lwr == null) {
      this.lwr = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(208558);
          if ((MPVideoViewControlBar.a(MPVideoViewControlBar.this)) || (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0))
          {
            AppMethodBeat.o(208558);
            return true;
          }
          MPVideoViewControlBar.this.hide();
          MPVideoViewControlBar.c(MPVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(208558);
          return false;
        }
      }, false);
    }
    this.lwr.stopTimer();
    this.lwr.ay(4000L, 4000L);
    AppMethodBeat.o(6306);
  }
  
  public final boolean bnS()
  {
    AppMethodBeat.i(6311);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(6311);
      return true;
    }
    AppMethodBeat.o(6311);
    return false;
  }
  
  public final void bnT()
  {
    AppMethodBeat.i(6313);
    this.lws = true;
    bpn();
    AppMethodBeat.o(6313);
  }
  
  public final boolean bnU()
  {
    return this.lws;
  }
  
  public final boolean bnV()
  {
    return true;
  }
  
  public final void bnW()
  {
    AppMethodBeat.i(6319);
    if (this.lpR == null) {
      this.lpR = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(208560);
          if (!MPVideoViewControlBar.f(MPVideoViewControlBar.this))
          {
            AppMethodBeat.o(208560);
            return false;
          }
          AppMethodBeat.o(208560);
          return true;
        }
      }, true);
    }
    bpr();
    this.lpR.stopTimer();
    this.lpR.ay(500L, 500L);
    AppMethodBeat.o(6319);
  }
  
  public final void bnX()
  {
    AppMethodBeat.i(6320);
    if (this.lpR != null) {
      this.lpR.stopTimer();
    }
    AppMethodBeat.o(6320);
  }
  
  public final void bnY()
  {
    AppMethodBeat.i(6307);
    if (this.lwr != null)
    {
      this.lwr.stopTimer();
      this.lwr.ay(4000L, 4000L);
    }
    AppMethodBeat.o(6307);
  }
  
  public final void bnZ()
  {
    AppMethodBeat.i(6301);
    if ((this.lwx) && (this.lwy)) {
      this.lwm.setVisibility(0);
    }
    AppMethodBeat.o(6301);
  }
  
  public final void bnv()
  {
    AppMethodBeat.i(6300);
    if ((this.lwx) && (this.lwy)) {
      this.lwm.setVisibility(8);
    }
    AppMethodBeat.o(6300);
  }
  
  public final boolean boa()
  {
    AppMethodBeat.i(6332);
    if (this.lwk != null)
    {
      if ((getVisibility() == 0) && (this.lwk.getVisibility() == 0))
      {
        AppMethodBeat.o(6332);
        return true;
      }
      AppMethodBeat.o(6332);
      return false;
    }
    AppMethodBeat.o(6332);
    return false;
  }
  
  public final void bpi()
  {
    AppMethodBeat.i(6328);
    if (this.lvX == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.kWf)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.lvT == null)
    {
      AppMethodBeat.o(6328);
      return;
    }
    this.lvV.setText(tv(this.mPosition / 60) + ":" + tv(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lvT.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = ea(this.mPosition, i);
    this.lvT.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lvR.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lvX * i));
    this.lvR.setLayoutParams(localLayoutParams);
    requestLayout();
    dZ(this.mPosition, this.lvX);
    AppMethodBeat.o(6328);
  }
  
  public int getLayoutId()
  {
    return 2131494960;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(6309);
    if (this.oAX == null)
    {
      this.oAX = AnimationUtils.loadAnimation(getContext(), 2130772106);
      this.oAX.setDuration(300L);
    }
    this.lwi.clearAnimation();
    this.lwi.startAnimation(this.oAX);
    if (this.lws)
    {
      if (this.oAZ == null)
      {
        this.oAZ = AnimationUtils.loadAnimation(getContext(), 2130772109);
        this.oAZ.setDuration(300L);
      }
      this.lwo.clearAnimation();
      this.lwo.startAnimation(this.oAZ);
      this.oAL.clearAnimation();
      this.oAL.startAnimation(this.oAZ);
    }
    if (this.oAQ.getVisibility() == 0) {
      this.oAQ.startAnimation(this.oAX);
    }
    if (this.oAT.getVisibility() == 0) {
      this.oAT.startAnimation(this.oAX);
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208559);
        MPVideoViewControlBar.this.setVisibility(8);
        MPVideoViewControlBar.d(MPVideoViewControlBar.this);
        MPVideoViewControlBar.e(MPVideoViewControlBar.this);
        MPVideoViewControlBar.b(MPVideoViewControlBar.this).clearAnimation();
        AppMethodBeat.o(208559);
      }
    }, 200L);
    AppMethodBeat.o(6309);
  }
  
  public final void init()
  {
    AppMethodBeat.i(6290);
    super.init();
    this.lwg = ((ImageView)this.contentView.findViewById(2131300325));
    this.lwj = ((ImageView)this.contentView.findViewById(2131303303));
    this.lwk = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.lwi = ((LinearLayout)findViewById(2131304239));
    this.oAJ = ((RelativeLayout)findViewById(2131303295));
    this.oAQ = ((LinearLayout)findViewById(2131304134));
    this.oAO = ((TextView)findViewById(2131304136));
    this.oAP = findViewById(2131304135);
    this.oAT = ((LinearLayout)findViewById(2131305144));
    this.oAR = ((TextView)findViewById(2131305146));
    this.oAS = findViewById(2131305145);
    this.lwl = ((ImageView)findViewById(2131302621));
    this.lwm = ((ImageView)findViewById(2131297935));
    this.lwn = ((ImageView)findViewById(2131299599));
    this.ayB = ((TextView)findViewById(2131305902));
    this.lwo = ((LinearLayout)findViewById(2131300332));
    this.lwp = ((LinearLayout)findViewById(2131303300));
    this.oAL = ((LinearLayout)findViewById(2131302509));
    this.oAM = ((ImageView)findViewById(2131302499));
    this.oAN = ((TextView)findViewById(2131302500));
    this.lwi.setOnClickListener(new MPVideoViewControlBar.5(this));
    AppMethodBeat.o(6290);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6288);
    if (this.lpR != null) {
      this.lpR.stopTimer();
    }
    if (this.lwr != null) {
      this.lwr.stopTimer();
    }
    AppMethodBeat.o(6288);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(6327);
    super.seek(paramInt);
    dZ(this.mPosition, this.lvX);
    AppMethodBeat.o(6327);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public void setDirection(int paramInt)
  {
    this.acQ = paramInt;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6292);
    this.lwn.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6292);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6304);
    this.lwg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6304);
  }
  
  public void setIplaySeekCallback(final e.d paramd)
  {
    AppMethodBeat.i(6289);
    setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(6276);
        paramd.aqS();
        AppMethodBeat.o(6276);
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(6277);
        paramd.nP(paramAnonymousInt);
        AppMethodBeat.o(6277);
      }
    });
    AppMethodBeat.o(6289);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(6303);
    this.duq = paramBoolean;
    if (this.duq)
    {
      this.lvU.setImageDrawable(ao.k(getContext(), 2131690445, -1));
      this.lwm.setImageResource(2131690871);
      AppMethodBeat.o(6303);
      return;
    }
    this.lvU.setImageDrawable(ao.k(getContext(), 2131690459, -1));
    this.lwm.setImageResource(2131690872);
    AppMethodBeat.o(6303);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6291);
    this.lwl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6291);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(6296);
    if (paramBoolean)
    {
      this.lwl.setImageResource(2131690867);
      AppMethodBeat.o(6296);
      return;
    }
    this.lwl.setImageResource(2131690868);
    AppMethodBeat.o(6296);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6293);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.lwm.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6293);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.lwA = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(6299);
    this.lwy = paramBoolean;
    bpk();
    AppMethodBeat.o(6299);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6297);
    this.lww = paramBoolean;
    bps();
    AppMethodBeat.o(6297);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6329);
    this.lwu = paramBoolean;
    bpm();
    bpj();
    AppMethodBeat.o(6329);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6295);
    ImageView localImageView = this.lwl;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(6295);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6330);
    this.lwx = paramBoolean;
    bpk();
    AppMethodBeat.o(6330);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6331);
    this.lwv = paramBoolean;
    bps();
    AppMethodBeat.o(6331);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.lwq = parami;
  }
  
  public void setSwitchResolutionListener(a parama)
  {
    this.oAU = parama;
  }
  
  public void setSwitchSpeedListener(b paramb)
  {
    this.oAV = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(6294);
    if (!bu.isNullOrNil(paramString)) {
      this.ayB.setText(paramString);
    }
    AppMethodBeat.o(6294);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(6335);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.oBc != null)
      {
        this.oBc.onVisibilityChanged(true);
        AppMethodBeat.o(6335);
      }
    }
    else if (((paramInt == 8) || (paramInt == 4)) && (this.oBc != null)) {
      this.oBc.onVisibilityChanged(false);
    }
    AppMethodBeat.o(6335);
  }
  
  public final void show()
  {
    AppMethodBeat.i(6310);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(6310);
      return;
    }
    if (this.oAW == null)
    {
      this.oAW = AnimationUtils.loadAnimation(getContext(), 2130772108);
      this.oAW.setDuration(300L);
    }
    this.lwi.clearAnimation();
    this.lwi.startAnimation(this.oAW);
    if (this.lws)
    {
      if (this.oAY == null)
      {
        this.oAY = AnimationUtils.loadAnimation(getContext(), 2130772105);
        this.oAY.setDuration(300L);
      }
      this.lwo.clearAnimation();
      this.lwo.startAnimation(this.oAY);
      this.oAL.clearAnimation();
      this.oAL.startAnimation(this.oAY);
    }
    setVisibility(0);
    AppMethodBeat.o(6310);
  }
  
  public static abstract interface a
  {
    public abstract void a(fu paramfu, int paramInt1, int paramInt2);
    
    public abstract void bSX();
    
    public abstract void bSY();
  }
  
  public static abstract interface b
  {
    public abstract void a(fu paramfu, c.a parama1, c.a parama2);
    
    public abstract void bTS();
    
    public abstract void bTT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */