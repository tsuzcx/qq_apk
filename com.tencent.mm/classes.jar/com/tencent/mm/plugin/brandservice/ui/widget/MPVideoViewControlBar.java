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
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
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
  private int add;
  private TextView ayz;
  private ImageView mDc;
  private LinearLayout mDe;
  private ImageView mDf;
  private FrameLayout mDg;
  private ImageView mDh;
  private ImageView mDi;
  private ImageView mDj;
  private LinearLayout mDk;
  private LinearLayout mDl;
  private e.i mDm;
  private MTimerHandler mDn;
  private boolean mDo;
  private boolean mDq;
  private boolean mDr;
  private boolean mDs;
  private boolean mDt;
  private boolean mDu;
  private e.e mDw;
  private MTimerHandler mww;
  private View pOA;
  private LinearLayout pOB;
  private TextView pOC;
  private View pOD;
  private LinearLayout pOE;
  private a pOF;
  private b pOG;
  private Animation pOH;
  private Animation pOI;
  private Animation pOJ;
  private Animation pOK;
  private LinkedList<gh> pOL;
  private gh pOM;
  private e.f pON;
  private RelativeLayout pOu;
  private LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> pOv;
  private LinearLayout pOw;
  private ImageView pOx;
  private TextView pOy;
  private TextView pOz;
  
  public MPVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6285);
    this.pOv = null;
    this.pOL = new LinkedList();
    AppMethodBeat.o(6285);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6286);
    this.pOv = null;
    this.pOL = new LinkedList();
    AppMethodBeat.o(6286);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6287);
    this.pOv = null;
    this.pOL = new LinkedList();
    AppMethodBeat.o(6287);
  }
  
  private void bKP()
  {
    AppMethodBeat.i(6298);
    if (this.mDo)
    {
      this.mDk.setVisibility(0);
      this.pOw.setVisibility(0);
      AppMethodBeat.o(6298);
      return;
    }
    this.mDk.setVisibility(8);
    this.pOw.setVisibility(8);
    AppMethodBeat.o(6298);
  }
  
  private void bKQ()
  {
    AppMethodBeat.i(6302);
    if (this.mDt)
    {
      if (this.mDu)
      {
        this.mCP.setVisibility(8);
        this.mDi.setVisibility(0);
        AppMethodBeat.o(6302);
        return;
      }
      this.mCP.setVisibility(0);
      this.mDi.setVisibility(8);
      AppMethodBeat.o(6302);
      return;
    }
    this.mCP.setVisibility(8);
    this.mDi.setVisibility(8);
    AppMethodBeat.o(6302);
  }
  
  private void bKS()
  {
    AppMethodBeat.i(6305);
    if (this.mDq)
    {
      this.mDc.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.mDc.getLayoutParams();
      getResources().getDimensionPixelSize(2131166719);
      if (this.mDo) {
        this.mDc.setImageResource(2131234769);
      }
      for (int i = getResources().getDimensionPixelSize(2131166717);; i = getResources().getDimensionPixelSize(2131166719))
      {
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        this.mDc.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(6305);
        return;
        this.mDc.setImageResource(2131691148);
      }
    }
    this.mDc.setVisibility(8);
    AppMethodBeat.o(6305);
  }
  
  private void bKT()
  {
    AppMethodBeat.i(6315);
    bKW();
    bKS();
    bKP();
    bKV();
    bKU();
    N(this.pOv);
    crK();
    crM();
    crO();
    crP();
    AppMethodBeat.o(6315);
  }
  
  private void bKU()
  {
    AppMethodBeat.i(6316);
    if (crI()) {}
    for (int i = getResources().getDimensionPixelSize(2131166713);; i = getResources().getDimensionPixelSize(2131166703))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.mCP != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mCP.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mCP.setLayoutParams(localMarginLayoutParams);
      }
      if (this.mDl != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mDl.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mDl.setLayoutParams(localMarginLayoutParams);
      }
      if (this.mDh != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mDh.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mDh.setLayoutParams(localMarginLayoutParams);
      }
      if (this.mDc != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mDc.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mDc.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pOA != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pOA.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pOA.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pOD != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pOA.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pOD.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(6316);
      return;
    }
  }
  
  private void bKV()
  {
    AppMethodBeat.i(6317);
    if (crI()) {}
    for (float f = getResources().getDimensionPixelSize(2131166716);; f = getResources().getDimensionPixelSize(2131166709))
    {
      this.mCQ.setTextSize(0, f);
      this.mCR.setTextSize(0, f);
      AppMethodBeat.o(6317);
      return;
    }
  }
  
  private void bKW()
  {
    AppMethodBeat.i(6318);
    ViewGroup.LayoutParams localLayoutParams = this.mDe.getLayoutParams();
    int j;
    if (this.mDo)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166714);
      this.mDe.setLayoutParams(localLayoutParams);
      if (!crI()) {
        break label143;
      }
      j = getResources().getDimensionPixelSize(2131166715);
    }
    for (int i = getResources().getDimensionPixelSize(2131166713);; i = getResources().getDimensionPixelSize(2131166706))
    {
      this.mDe.setPadding(0, 0, i, 0);
      if (this.mDk != null) {
        this.mDk.setPadding(j, 0, j, 0);
      }
      if (this.pOw != null) {
        this.pOw.setPadding(j, 0, j, 0);
      }
      AppMethodBeat.o(6318);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166705);
      break;
      label143:
      j = getResources().getDimensionPixelSize(2131166706);
    }
  }
  
  private boolean bKX()
  {
    AppMethodBeat.i(6321);
    if (this.mDm == null)
    {
      Log.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(6321);
      return false;
    }
    int k = this.mDm.bJh();
    int j = this.mDm.bJi();
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mDf.getLayoutParams();
      localLayoutParams.width = i;
      this.mDf.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(6321);
      return true;
      d = k;
    }
  }
  
  private void bKY()
  {
    int j = 0;
    AppMethodBeat.i(6333);
    boolean bool;
    Object localObject;
    if (this.mDs)
    {
      bool = this.mDr;
      localObject = this.mDg;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.mCQ;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.mCR;
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
  
  private boolean crI()
  {
    return (this.mDo) && ((90 == this.add) || (-90 == this.add));
  }
  
  private void crJ()
  {
    AppMethodBeat.i(6322);
    if (Util.isNullOrNil(this.pOv))
    {
      AppMethodBeat.o(6322);
      return;
    }
    Iterator localIterator = this.pOv.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localIterator.next();
      if (localc.pKt <= this.mPosition)
      {
        if (localc.pKr) {
          break label108;
        }
        i = 1;
      }
      else
      {
        if (!localc.pKr) {
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
        N(this.pOv);
      }
      AppMethodBeat.o(6322);
      return;
    }
  }
  
  private void crK()
  {
    AppMethodBeat.i(6325);
    if ((!crI()) || (Util.isNullOrNil(this.pOL)) || (this.pOM == null))
    {
      crL();
      this.pOA.setVisibility(8);
      AppMethodBeat.o(6325);
      return;
    }
    this.pOz.setText(this.pOM.KKh);
    this.pOA.setVisibility(0);
    this.pOA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6284);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0)
        {
          MPVideoViewControlBar.d(MPVideoViewControlBar.this);
          if (MPVideoViewControlBar.this.cEF()) {
            MPVideoViewControlBar.this.bJB();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6284);
          return;
          if (MPVideoViewControlBar.h(MPVideoViewControlBar.this) != null) {
            MPVideoViewControlBar.h(MPVideoViewControlBar.this).cqH();
          }
          MPVideoViewControlBar.i(MPVideoViewControlBar.this);
          MPVideoViewControlBar.j(MPVideoViewControlBar.this);
        }
      }
    });
    AppMethodBeat.o(6325);
  }
  
  private void crL()
  {
    AppMethodBeat.i(6326);
    Log.d("MicroMsg.MPVideoViewControlBar", "hideResolutionContainer");
    if (this.pOB.getVisibility() != 8)
    {
      this.pOB.setVisibility(8);
      if (this.pOF != null) {
        this.pOF.cqI();
      }
    }
    AppMethodBeat.o(6326);
  }
  
  private void crM()
  {
    AppMethodBeat.i(179005);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTZ, 1) == 0) {}
    for (int i = 1; (!crI()) || (Util.isNullOrNil(this.pOL)) || (this.pOM == null) || (i != 0); i = 0)
    {
      crN();
      this.pOD.setVisibility(8);
      AppMethodBeat.o(179005);
      return;
    }
    Object localObject = c.pNP;
    if (c.cry().pNW == 1.0F) {}
    for (localObject = getResources().getString(2131767091);; localObject = c.cry().desc)
    {
      this.pOC.setText((CharSequence)localObject);
      this.pOD.setVisibility(0);
      this.pOD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          m.DR(42);
          if (MPVideoViewControlBar.k(MPVideoViewControlBar.this).getVisibility() == 0)
          {
            MPVideoViewControlBar.e(MPVideoViewControlBar.this);
            if (MPVideoViewControlBar.this.cEF()) {
              MPVideoViewControlBar.this.bJB();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179004);
            return;
            if (MPVideoViewControlBar.l(MPVideoViewControlBar.this) != null) {
              MPVideoViewControlBar.l(MPVideoViewControlBar.this).crF();
            }
            MPVideoViewControlBar.m(MPVideoViewControlBar.this);
            MPVideoViewControlBar.n(MPVideoViewControlBar.this);
          }
        }
      });
      AppMethodBeat.o(179005);
      return;
      localObject = c.pNP;
    }
  }
  
  private void crN()
  {
    AppMethodBeat.i(179006);
    Log.d("MicroMsg.MPVideoViewControlBar", "hideSpeedContainer");
    if (this.pOE.getVisibility() != 8)
    {
      this.pOE.setVisibility(8);
      if (this.pOG != null) {
        this.pOG.crG();
      }
    }
    AppMethodBeat.o(179006);
  }
  
  private void crO()
  {
    AppMethodBeat.i(179007);
    ImageView localImageView = this.mDh;
    if (this.mDo) {}
    for (int i = 8;; i = 0)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(179007);
      return;
    }
  }
  
  private void crP()
  {
    AppMethodBeat.i(179008);
    ViewGroup.LayoutParams localLayoutParams = this.mCP.getLayoutParams();
    int i = getResources().getDimensionPixelSize(2131166719);
    if (this.mDo) {
      i = getResources().getDimensionPixelSize(2131166718);
    }
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.mCP.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(179008);
  }
  
  private void em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6334);
    if (this.mDw != null) {
      this.mDw.onProgressChanged(paramInt1, paramInt2);
    }
    crJ();
    AppMethodBeat.o(6334);
  }
  
  public final void KD()
  {
    AppMethodBeat.i(6313);
    this.mDo = true;
    bKT();
    AppMethodBeat.o(6313);
  }
  
  public final void N(final LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> paramLinkedList)
  {
    AppMethodBeat.i(6323);
    this.pOv = paramLinkedList;
    if ((this.pOu == null) || (Util.isNullOrNil(this.pOv)))
    {
      this.pOu.removeAllViews();
      AppMethodBeat.o(6323);
      return;
    }
    Log.i("MicroMsg.MPVideoViewControlBar", "updateControlBarDotPos");
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195072);
        MPVideoViewControlBar.g(MPVideoViewControlBar.this).removeAllViews();
        Object localObject = paramLinkedList;
        if (!Util.isNullOrNil((List)localObject))
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
        AppMethodBeat.o(195072);
      }
    }, 100L);
    AppMethodBeat.o(6323);
  }
  
  public final void T(String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(195073);
    com.tencent.mm.av.a.a locala = com.tencent.mm.av.a.a.bdb();
    ImageView localImageView = this.pOx;
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.iaT = true;
    locala1.jbq = 2131231405;
    locala.a(paramString3, localImageView, locala1.bdv());
    this.pOy.setText(paramString1);
    this.pOw.setOnClickListener(null);
    this.pOw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195068);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramString2);
        paramAnonymousView.putExtra("Contact_Scene", 179);
        paramAnonymousView.putExtra("force_get_contact", true);
        paramAnonymousView.putExtra("key_use_new_contact_profile", true);
        com.tencent.mm.br.c.b(MPVideoViewControlBar.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
        m.DR(45);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195068);
      }
    });
    o.hq(this.pOw);
    AppMethodBeat.o(195073);
  }
  
  public final void a(e.f paramf)
  {
    this.pON = paramf;
  }
  
  public final void a(LinkedList<gh> paramLinkedList, gh paramgh)
  {
    AppMethodBeat.i(6324);
    if ((paramLinkedList == null) || (paramgh == null))
    {
      AppMethodBeat.o(6324);
      return;
    }
    this.pOL.clear();
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      gh localgh = (gh)paramLinkedList.next();
      if ((!Util.isNullOrNil(localgh.KKh)) && (!localHashSet.contains(Integer.valueOf(localgh.KKg))))
      {
        this.pOL.add(localgh);
        localHashSet.add(Integer.valueOf(localgh.KKg));
      }
    }
    Collections.sort(this.pOL, new Comparator() {});
    this.pOM = paramgh;
    AppMethodBeat.o(6324);
  }
  
  public final void bGL()
  {
    AppMethodBeat.i(6314);
    this.mDo = false;
    bKT();
    AppMethodBeat.o(6314);
  }
  
  public final void bIZ()
  {
    AppMethodBeat.i(6300);
    if ((this.mDt) && (this.mDu)) {
      this.mDi.setVisibility(8);
    }
    AppMethodBeat.o(6300);
  }
  
  public final void bJA()
  {
    AppMethodBeat.i(6320);
    if (this.mww != null) {
      this.mww.stopTimer();
    }
    AppMethodBeat.o(6320);
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(6307);
    if (this.mDn != null)
    {
      this.mDn.stopTimer();
      this.mDn.startTimer(4000L);
    }
    AppMethodBeat.o(6307);
  }
  
  public final void bJC()
  {
    AppMethodBeat.i(6301);
    if ((this.mDt) && (this.mDu)) {
      this.mDi.setVisibility(0);
    }
    AppMethodBeat.o(6301);
  }
  
  public final boolean bJD()
  {
    AppMethodBeat.i(6332);
    if (this.mDg != null)
    {
      if ((getVisibility() == 0) && (this.mDg.getVisibility() == 0))
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
  
  public final boolean bJt()
  {
    return false;
  }
  
  public final void bJu()
  {
    AppMethodBeat.i(6312);
    if (bJw())
    {
      hide();
      AppMethodBeat.o(6312);
      return;
    }
    bJv();
    AppMethodBeat.o(6312);
  }
  
  public final void bJv()
  {
    AppMethodBeat.i(6306);
    show();
    if (this.mDn == null) {
      this.mDn = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(195069);
          if ((MPVideoViewControlBar.a(MPVideoViewControlBar.this)) || (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0))
          {
            AppMethodBeat.o(195069);
            return true;
          }
          MPVideoViewControlBar.this.hide();
          MPVideoViewControlBar.c(MPVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(195069);
          return false;
        }
      }, false);
    }
    this.mDn.stopTimer();
    this.mDn.startTimer(4000L);
    AppMethodBeat.o(6306);
  }
  
  public final boolean bJw()
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
  
  public final boolean bJx()
  {
    return this.mDo;
  }
  
  public final boolean bJy()
  {
    return true;
  }
  
  public final void bJz()
  {
    AppMethodBeat.i(6319);
    if (this.mww == null) {
      this.mww = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(195071);
          if (!MPVideoViewControlBar.f(MPVideoViewControlBar.this))
          {
            AppMethodBeat.o(195071);
            return false;
          }
          AppMethodBeat.o(195071);
          return true;
        }
      }, true);
    }
    bKX();
    this.mww.stopTimer();
    this.mww.startTimer(500L);
    AppMethodBeat.o(6319);
  }
  
  public final void bKO()
  {
    AppMethodBeat.i(6328);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.mCO == null)
    {
      AppMethodBeat.o(6328);
      return;
    }
    this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = en(this.mPosition, i);
    this.mCO.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.mCS * i));
    this.mCM.setLayoutParams(localLayoutParams);
    requestLayout();
    em(this.mPosition, this.mCS);
    AppMethodBeat.o(6328);
  }
  
  public final void crH()
  {
    AppMethodBeat.i(6308);
    if (this.mDn != null) {
      this.mDn.stopTimer();
    }
    AppMethodBeat.o(6308);
  }
  
  public int getLayoutId()
  {
    return 2131495703;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(6309);
    if (this.pOI == null)
    {
      this.pOI = AnimationUtils.loadAnimation(getContext(), 2130772130);
      this.pOI.setDuration(300L);
    }
    this.mDe.clearAnimation();
    this.mDe.startAnimation(this.pOI);
    if (this.mDo)
    {
      if (this.pOK == null)
      {
        this.pOK = AnimationUtils.loadAnimation(getContext(), 2130772133);
        this.pOK.setDuration(300L);
      }
      this.mDk.clearAnimation();
      this.mDk.startAnimation(this.pOK);
      this.pOw.clearAnimation();
      this.pOw.startAnimation(this.pOK);
    }
    if (this.pOB.getVisibility() == 0) {
      this.pOB.startAnimation(this.pOI);
    }
    if (this.pOE.getVisibility() == 0) {
      this.pOE.startAnimation(this.pOI);
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195070);
        MPVideoViewControlBar.this.setVisibility(8);
        MPVideoViewControlBar.d(MPVideoViewControlBar.this);
        MPVideoViewControlBar.e(MPVideoViewControlBar.this);
        MPVideoViewControlBar.b(MPVideoViewControlBar.this).clearAnimation();
        AppMethodBeat.o(195070);
      }
    }, 200L);
    AppMethodBeat.o(6309);
  }
  
  public final void init()
  {
    AppMethodBeat.i(6290);
    super.init();
    this.mDc = ((ImageView)this.contentView.findViewById(2131301826));
    this.mDf = ((ImageView)this.contentView.findViewById(2131305976));
    this.mDg = ((FrameLayout)this.contentView.findViewById(2131305979));
    this.mDe = ((LinearLayout)findViewById(2131307157));
    this.pOu = ((RelativeLayout)findViewById(2131305968));
    this.pOB = ((LinearLayout)findViewById(2131307030));
    this.pOz = ((TextView)findViewById(2131307032));
    this.pOA = findViewById(2131307031);
    this.pOE = ((LinearLayout)findViewById(2131308326));
    this.pOC = ((TextView)findViewById(2131308328));
    this.pOD = findViewById(2131308327);
    this.mDh = ((ImageView)findViewById(2131305118));
    this.mDi = ((ImageView)findViewById(2131298258));
    this.mDj = ((ImageView)findViewById(2131300227));
    this.ayz = ((TextView)findViewById(2131309195));
    this.mDk = ((LinearLayout)findViewById(2131301848));
    this.mDl = ((LinearLayout)findViewById(2131305973));
    this.pOw = ((LinearLayout)findViewById(2131304937));
    this.pOx = ((ImageView)findViewById(2131304927));
    this.pOy = ((TextView)findViewById(2131304928));
    this.mDe.setOnClickListener(new MPVideoViewControlBar.5(this));
    AppMethodBeat.o(6290);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6288);
    if (this.mww != null) {
      this.mww.stopTimer();
    }
    if (this.mDn != null) {
      this.mDn.stopTimer();
    }
    AppMethodBeat.o(6288);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(6327);
    super.seek(paramInt);
    em(this.mPosition, this.mCS);
    AppMethodBeat.o(6327);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public void setDirection(int paramInt)
  {
    this.add = paramInt;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6292);
    this.mDj.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6292);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6304);
    this.mDc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6304);
  }
  
  public void setIplaySeekCallback(final e.d paramd)
  {
    AppMethodBeat.i(6289);
    setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(6276);
        paramd.aJq();
        AppMethodBeat.o(6276);
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(6277);
        paramd.rk(paramAnonymousInt);
        AppMethodBeat.o(6277);
      }
    });
    AppMethodBeat.o(6289);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(6303);
    this.dLB = paramBoolean;
    if (this.dLB)
    {
      this.mCP.setImageDrawable(ar.m(getContext(), 2131690631, -1));
      this.mDi.setImageResource(2131691158);
      AppMethodBeat.o(6303);
      return;
    }
    this.mCP.setImageDrawable(ar.m(getContext(), 2131690647, -1));
    this.mDi.setImageResource(2131691159);
    AppMethodBeat.o(6303);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6291);
    this.mDh.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6291);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(6296);
    if (paramBoolean)
    {
      this.mDh.setImageResource(2131691154);
      AppMethodBeat.o(6296);
      return;
    }
    this.mDh.setImageResource(2131691155);
    AppMethodBeat.o(6296);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6293);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.mDi.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6293);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.mDw = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(6299);
    this.mDu = paramBoolean;
    bKQ();
    AppMethodBeat.o(6299);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6297);
    this.mDs = paramBoolean;
    bKY();
    AppMethodBeat.o(6297);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6329);
    this.mDq = paramBoolean;
    bKS();
    bKP();
    AppMethodBeat.o(6329);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6295);
    ImageView localImageView = this.mDh;
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
    this.mDt = paramBoolean;
    bKQ();
    AppMethodBeat.o(6330);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6331);
    this.mDr = paramBoolean;
    bKY();
    AppMethodBeat.o(6331);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.mDm = parami;
  }
  
  public void setSwitchResolutionListener(a parama)
  {
    this.pOF = parama;
  }
  
  public void setSwitchSpeedListener(b paramb)
  {
    this.pOG = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(6294);
    if (!Util.isNullOrNil(paramString)) {
      this.ayz.setText(paramString);
    }
    AppMethodBeat.o(6294);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(6335);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.pON != null)
      {
        this.pON.onVisibilityChanged(true);
        AppMethodBeat.o(6335);
      }
    }
    else if (((paramInt == 8) || (paramInt == 4)) && (this.pON != null)) {
      this.pON.onVisibilityChanged(false);
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
    if (this.pOH == null)
    {
      this.pOH = AnimationUtils.loadAnimation(getContext(), 2130772132);
      this.pOH.setDuration(300L);
    }
    this.mDe.clearAnimation();
    this.mDe.startAnimation(this.pOH);
    if (this.mDo)
    {
      if (this.pOJ == null)
      {
        this.pOJ = AnimationUtils.loadAnimation(getContext(), 2130772129);
        this.pOJ.setDuration(300L);
      }
      this.mDk.clearAnimation();
      this.mDk.startAnimation(this.pOJ);
      this.pOw.clearAnimation();
      this.pOw.startAnimation(this.pOJ);
    }
    setVisibility(0);
    AppMethodBeat.o(6310);
  }
  
  public static abstract interface a
  {
    public abstract void a(gh paramgh, int paramInt1, int paramInt2);
    
    public abstract void cqH();
    
    public abstract void cqI();
  }
  
  public static abstract interface b
  {
    public abstract void a(gh paramgh, c.a parama1, c.a parama2);
    
    public abstract void crF();
    
    public abstract void crG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */