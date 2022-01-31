package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandVideoViewControlBar
  extends VideoPlayerSeekBar
  implements d.a
{
  private TextView aop;
  private ImageView icZ;
  private ImageView ida;
  private LinearLayout idb;
  private ImageView idc;
  private FrameLayout idd;
  private ImageView ide;
  private ImageView idf;
  private ImageView idg;
  private LinearLayout idh;
  private LinearLayout idi;
  private d.h idj;
  private ap idk;
  private ap idl;
  private boolean idm;
  private boolean idn;
  private boolean ido;
  private boolean idp;
  private boolean idq;
  private boolean idr;
  private boolean ids;
  private d.d idt;
  private ConcurrentLinkedQueue<d.e> idu;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143436);
    this.idu = new ConcurrentLinkedQueue();
    AppMethodBeat.o(143436);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143437);
    this.idu = new ConcurrentLinkedQueue();
    AppMethodBeat.o(143437);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143438);
    this.idu = new ConcurrentLinkedQueue();
    AppMethodBeat.o(143438);
  }
  
  private void aFA()
  {
    int j = 0;
    AppMethodBeat.i(131580);
    boolean bool;
    Object localObject;
    if (this.idq)
    {
      bool = this.idp;
      localObject = this.idd;
      if (!bool) {
        break label84;
      }
      i = 0;
      label31:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.qTG;
      if (!bool) {
        break label90;
      }
      i = 0;
      label49:
      ((TextView)localObject).setVisibility(i);
      localObject = this.qTH;
      if (!bool) {
        break label96;
      }
    }
    label84:
    label90:
    label96:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      AppMethodBeat.o(131580);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
      i = 8;
      break label49;
    }
  }
  
  private void aFg()
  {
    AppMethodBeat.i(131548);
    if (this.idm)
    {
      this.idh.setVisibility(0);
      AppMethodBeat.o(131548);
      return;
    }
    this.idh.setVisibility(8);
    AppMethodBeat.o(131548);
  }
  
  private void aFi()
  {
    AppMethodBeat.i(131552);
    if (this.idr)
    {
      if (this.ids)
      {
        this.qTF.setVisibility(8);
        this.idf.setVisibility(0);
        AppMethodBeat.o(131552);
        return;
      }
      this.qTF.setVisibility(0);
      this.idf.setVisibility(8);
      AppMethodBeat.o(131552);
      return;
    }
    this.qTF.setVisibility(8);
    this.idf.setVisibility(8);
    AppMethodBeat.o(131552);
  }
  
  private void aFk()
  {
    AppMethodBeat.i(131557);
    if (this.idn)
    {
      this.ida.setImageResource(2131230896);
      AppMethodBeat.o(131557);
      return;
    }
    this.ida.setImageResource(2131230895);
    AppMethodBeat.o(131557);
  }
  
  private void aFl()
  {
    AppMethodBeat.i(131558);
    if (this.ido)
    {
      this.icZ.setVisibility(0);
      if (this.idm)
      {
        this.icZ.setImageResource(2131230901);
        AppMethodBeat.o(131558);
        return;
      }
      this.icZ.setImageResource(2131230898);
      AppMethodBeat.o(131558);
      return;
    }
    this.icZ.setVisibility(8);
    AppMethodBeat.o(131558);
  }
  
  private void aFr()
  {
    AppMethodBeat.i(131567);
    aFu();
    aFl();
    aFg();
    aFt();
    aFs();
    AppMethodBeat.o(131567);
  }
  
  private void aFs()
  {
    AppMethodBeat.i(131568);
    if (this.idm) {}
    for (int i = getResources().getDimensionPixelSize(2131428099);; i = getResources().getDimensionPixelSize(2131428089))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.qTF != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.qTF.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.qTF.setLayoutParams(localMarginLayoutParams);
      }
      if (this.idi != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.idi.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.idi.setLayoutParams(localMarginLayoutParams);
      }
      if (this.ida != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ida.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.ida.setLayoutParams(localMarginLayoutParams);
      }
      if (this.ide != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ide.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.ide.setLayoutParams(localMarginLayoutParams);
      }
      if (this.icZ != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.icZ.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.icZ.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(131568);
      return;
    }
  }
  
  private void aFt()
  {
    AppMethodBeat.i(131569);
    if (this.idm) {}
    for (float f = getResources().getDimensionPixelSize(2131428102);; f = getResources().getDimensionPixelSize(2131428095))
    {
      this.qTG.setTextSize(0, f);
      this.qTH.setTextSize(0, f);
      AppMethodBeat.o(131569);
      return;
    }
  }
  
  private void aFu()
  {
    AppMethodBeat.i(131570);
    ViewGroup.LayoutParams localLayoutParams = this.idb.getLayoutParams();
    if (this.idm)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131428100);
      this.idb.setLayoutParams(localLayoutParams);
      if (!this.idm) {
        break label109;
      }
    }
    label109:
    for (int i = getResources().getDimensionPixelSize(2131428101);; i = getResources().getDimensionPixelSize(2131428092))
    {
      this.idb.setPadding(0, 0, i, 0);
      if (this.idh != null) {
        this.idh.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(131570);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131428091);
      break;
    }
  }
  
  private boolean aFx()
  {
    AppMethodBeat.i(131573);
    if (this.idj == null)
    {
      ab.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(131573);
      return false;
    }
    int k = this.idj.aEV();
    int j = this.idj.aEW();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(131573);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(131573);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.idc.getLayoutParams();
      localLayoutParams.width = i;
      this.idc.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(131573);
      return true;
      d = k;
    }
  }
  
  private void dk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131581);
    if (this.idt != null) {
      this.idt.dj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(131581);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(131563);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(131563);
      return true;
    }
    AppMethodBeat.o(131563);
    return false;
  }
  
  public final void a(d.e parame)
  {
    AppMethodBeat.i(143439);
    this.idu.add(parame);
    AppMethodBeat.o(143439);
  }
  
  public final void aDh()
  {
    AppMethodBeat.i(131566);
    this.idm = false;
    aFr();
    AppMethodBeat.o(131566);
  }
  
  public final void aEO()
  {
    AppMethodBeat.i(131550);
    if ((this.idr) && (this.ids)) {
      this.idf.setVisibility(8);
    }
    AppMethodBeat.o(131550);
  }
  
  public final void aFh()
  {
    AppMethodBeat.i(131551);
    if ((this.idr) && (this.ids)) {
      this.idf.setVisibility(0);
    }
    AppMethodBeat.o(131551);
  }
  
  public final boolean aFj()
  {
    return this.idn;
  }
  
  public final void aFm()
  {
    AppMethodBeat.i(131560);
    setVisibility(0);
    if (this.idk == null) {
      this.idk = new ap(new AppBrandVideoViewControlBar.3(this), false);
    }
    this.idk.stopTimer();
    this.idk.ag(7000L, 7000L);
    AppMethodBeat.o(131560);
  }
  
  public final void aFn()
  {
    AppMethodBeat.i(131561);
    if (this.idk != null)
    {
      this.idk.stopTimer();
      this.idk.ag(7000L, 7000L);
    }
    AppMethodBeat.o(131561);
  }
  
  public final void aFo()
  {
    AppMethodBeat.i(131564);
    if (Pk())
    {
      setVisibility(8);
      AppMethodBeat.o(131564);
      return;
    }
    aFm();
    AppMethodBeat.o(131564);
  }
  
  public final void aFp()
  {
    AppMethodBeat.i(131565);
    this.idm = true;
    aFr();
    AppMethodBeat.o(131565);
  }
  
  public final boolean aFq()
  {
    return this.idm;
  }
  
  public final void aFv()
  {
    AppMethodBeat.i(131571);
    if (this.idl == null) {
      this.idl = new ap(new AppBrandVideoViewControlBar.4(this), true);
    }
    aFx();
    this.idl.stopTimer();
    this.idl.ag(500L, 500L);
    AppMethodBeat.o(131571);
  }
  
  public final void aFw()
  {
    AppMethodBeat.i(131572);
    if (this.idl != null) {
      this.idl.stopTimer();
    }
    AppMethodBeat.o(131572);
  }
  
  public final void aFy()
  {
    AppMethodBeat.i(131575);
    if (this.qTI == 0)
    {
      AppMethodBeat.o(131575);
      return;
    }
    if (this.hPP)
    {
      AppMethodBeat.o(131575);
      return;
    }
    if (this.qTE == null)
    {
      AppMethodBeat.o(131575);
      return;
    }
    this.qTG.setText(ol(this.mPosition / 60) + ":" + ol(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(131575);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTE.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = hg(this.mPosition, i);
    this.qTE.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.qTC.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.qTI * i));
    this.qTC.setLayoutParams(localLayoutParams);
    requestLayout();
    dk(this.mPosition, this.qTI);
    AppMethodBeat.o(131575);
  }
  
  public final boolean aFz()
  {
    AppMethodBeat.i(131579);
    if (this.idd != null)
    {
      if ((getVisibility() == 0) && (this.idd.getVisibility() == 0))
      {
        AppMethodBeat.o(131579);
        return true;
      }
      AppMethodBeat.o(131579);
      return false;
    }
    AppMethodBeat.o(131579);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130968750;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(131562);
    setVisibility(8);
    AppMethodBeat.o(131562);
  }
  
  public final void init()
  {
    AppMethodBeat.i(131540);
    super.init();
    this.icZ = ((ImageView)this.contentView.findViewById(2131821468));
    this.ida = ((ImageView)this.contentView.findViewById(2131821466));
    this.idc = ((ImageView)this.contentView.findViewById(2131821462));
    this.idd = ((FrameLayout)this.contentView.findViewById(2131821460));
    this.idb = ((LinearLayout)findViewById(2131821003));
    this.ide = ((ImageView)findViewById(2131821467));
    this.idf = ((ImageView)findViewById(2131821457));
    this.idg = ((ImageView)findViewById(2131821456));
    this.aop = ((TextView)findViewById(2131820680));
    this.idh = ((LinearLayout)findViewById(2131821455));
    this.idi = ((LinearLayout)findViewById(2131821458));
    AppMethodBeat.o(131540);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(131538);
    if (this.idl != null) {
      this.idl.stopTimer();
    }
    if (this.idk != null) {
      this.idk.stopTimer();
    }
    AppMethodBeat.o(131538);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(131574);
    super.seek(paramInt);
    dk(this.mPosition, this.qTI);
    AppMethodBeat.o(131574);
  }
  
  public void setDanmakuBtnOnClickListener(d.f paramf)
  {
    AppMethodBeat.i(131555);
    this.ida.setOnClickListener(new AppBrandVideoViewControlBar.2(this, paramf));
    AppMethodBeat.o(131555);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(131556);
    this.idn = paramBoolean;
    aFk();
    AppMethodBeat.o(131556);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(131542);
    this.idg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(131542);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(131554);
    this.icZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(131554);
  }
  
  public void setIplaySeekCallback(d.c paramc)
  {
    AppMethodBeat.i(131539);
    setIplaySeekCallback(new AppBrandVideoViewControlBar.1(this, paramc));
    AppMethodBeat.o(131539);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(131553);
    this.cvm = paramBoolean;
    if (this.cvm)
    {
      this.qTF.setImageResource(2131230909);
      this.idf.setImageResource(2131230909);
      AppMethodBeat.o(131553);
      return;
    }
    this.qTF.setImageResource(2131230910);
    this.idf.setImageResource(2131230910);
    AppMethodBeat.o(131553);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(131541);
    this.ide.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(131541);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(131546);
    if (paramBoolean)
    {
      this.ide.setImageResource(2131230905);
      AppMethodBeat.o(131546);
      return;
    }
    this.ide.setImageResource(2131230906);
    AppMethodBeat.o(131546);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(131543);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.idf.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(131543);
  }
  
  public void setOnUpdateProgressLenListener(d.d paramd)
  {
    this.idt = paramd;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(131549);
    this.ids = paramBoolean;
    aFi();
    AppMethodBeat.o(131549);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(131547);
    this.idq = paramBoolean;
    aFA();
    AppMethodBeat.o(131547);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(131559);
    if (paramBoolean)
    {
      this.ida.setVisibility(0);
      AppMethodBeat.o(131559);
      return;
    }
    this.ida.setVisibility(8);
    AppMethodBeat.o(131559);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(131576);
    this.ido = paramBoolean;
    aFl();
    aFg();
    AppMethodBeat.o(131576);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(131545);
    ImageView localImageView = this.ide;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(131545);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(131577);
    this.idr = paramBoolean;
    aFi();
    AppMethodBeat.o(131577);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(131578);
    this.idp = paramBoolean;
    aFA();
    AppMethodBeat.o(131578);
  }
  
  public void setStatePorter(d.h paramh)
  {
    this.idj = paramh;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(131544);
    if (!bo.isNullOrNil(paramString)) {
      this.aop.setText(paramString);
    }
    AppMethodBeat.o(131544);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131582);
    super.setVisibility(paramInt);
    Iterator localIterator;
    d.e locale;
    if (paramInt == 0)
    {
      localIterator = this.idu.iterator();
      while (localIterator.hasNext())
      {
        locale = (d.e)localIterator.next();
        if (locale != null) {
          locale.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(131582);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.idu.iterator();
      while (localIterator.hasNext())
      {
        locale = (d.e)localIterator.next();
        if (locale != null) {
          locale.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(131582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */