package com.tencent.mm.plugin.brandservice.ui.widget;

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
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public class MPVideoViewControlBar
  extends VideoPlayerSeekBar
  implements d.a
{
  private TextView aop;
  private ImageView icZ;
  private ImageView icw;
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
  private boolean ido;
  private boolean idp;
  private boolean idq;
  private boolean idr;
  private boolean ids;
  private d.d idt;
  private d.e kjU;
  
  public MPVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aFA()
  {
    int j = 0;
    AppMethodBeat.i(14627);
    boolean bool;
    Object localObject;
    if (this.idq)
    {
      bool = this.idp;
      localObject = this.idd;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.qTG;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.qTH;
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
      AppMethodBeat.o(14627);
      return;
      bool = false;
      break;
      i = 8;
      break label32;
      i = 8;
      break label50;
    }
  }
  
  private void aFg()
  {
    AppMethodBeat.i(14599);
    if (this.idm)
    {
      this.idh.setVisibility(0);
      AppMethodBeat.o(14599);
      return;
    }
    this.idh.setVisibility(8);
    AppMethodBeat.o(14599);
  }
  
  private void aFi()
  {
    AppMethodBeat.i(14603);
    if (this.idr)
    {
      if (this.ids)
      {
        this.qTF.setVisibility(8);
        this.idf.setVisibility(0);
        AppMethodBeat.o(14603);
        return;
      }
      this.qTF.setVisibility(0);
      this.idf.setVisibility(8);
      AppMethodBeat.o(14603);
      return;
    }
    this.qTF.setVisibility(8);
    this.idf.setVisibility(8);
    AppMethodBeat.o(14603);
  }
  
  private void aFl()
  {
    AppMethodBeat.i(14606);
    if (this.ido)
    {
      this.icZ.setVisibility(0);
      if (this.idm)
      {
        this.icZ.setImageResource(2131231701);
        AppMethodBeat.o(14606);
        return;
      }
      this.icZ.setImageResource(2131231700);
      AppMethodBeat.o(14606);
      return;
    }
    this.icZ.setVisibility(8);
    AppMethodBeat.o(14606);
  }
  
  private void aFr()
  {
    AppMethodBeat.i(14614);
    aFu();
    aFl();
    aFg();
    aFt();
    aFs();
    AppMethodBeat.o(14614);
  }
  
  private void aFs()
  {
    AppMethodBeat.i(14615);
    if (this.idm) {}
    for (int i = getResources().getDimensionPixelSize(2131428597);; i = getResources().getDimensionPixelSize(2131428587))
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
      AppMethodBeat.o(14615);
      return;
    }
  }
  
  private void aFt()
  {
    AppMethodBeat.i(14616);
    if (this.idm) {}
    for (float f = getResources().getDimensionPixelSize(2131428600);; f = getResources().getDimensionPixelSize(2131428593))
    {
      this.qTG.setTextSize(0, f);
      this.qTH.setTextSize(0, f);
      AppMethodBeat.o(14616);
      return;
    }
  }
  
  private void aFu()
  {
    AppMethodBeat.i(14617);
    ViewGroup.LayoutParams localLayoutParams = this.idb.getLayoutParams();
    if (this.idm)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131428598);
      this.idb.setLayoutParams(localLayoutParams);
      if (!this.idm) {
        break label111;
      }
    }
    label111:
    for (int i = getResources().getDimensionPixelSize(2131428599);; i = getResources().getDimensionPixelSize(2131428590))
    {
      this.idb.setPadding(0, 0, i, 0);
      if (this.idh != null) {
        this.idh.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(14617);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131428589);
      break;
    }
  }
  
  private boolean aFx()
  {
    AppMethodBeat.i(14620);
    if (this.idj == null)
    {
      ab.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(14620);
      return false;
    }
    int k = this.idj.aEV();
    int j = this.idj.aEW();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(14620);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(14620);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.idc.getLayoutParams();
      localLayoutParams.width = i;
      this.idc.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(14620);
      return true;
      d = k;
    }
  }
  
  private void dk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14628);
    if (this.idt != null) {
      this.idt.dj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(14628);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(14610);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(14610);
      return true;
    }
    AppMethodBeat.o(14610);
    return false;
  }
  
  public final void a(d.e parame)
  {
    this.kjU = parame;
  }
  
  public final void aDh()
  {
    AppMethodBeat.i(14613);
    this.idm = false;
    aFr();
    AppMethodBeat.o(14613);
  }
  
  public final void aEO()
  {
    AppMethodBeat.i(14601);
    if ((this.idr) && (this.ids)) {
      this.idf.setVisibility(8);
    }
    AppMethodBeat.o(14601);
  }
  
  public final void aFh()
  {
    AppMethodBeat.i(14602);
    if ((this.idr) && (this.ids)) {
      this.idf.setVisibility(0);
    }
    AppMethodBeat.o(14602);
  }
  
  public final boolean aFj()
  {
    return false;
  }
  
  public final void aFm()
  {
    AppMethodBeat.i(14607);
    setVisibility(0);
    if (this.idk == null) {
      this.idk = new ap(new MPVideoViewControlBar.2(this), false);
    }
    this.idk.stopTimer();
    this.idk.ag(3000L, 3000L);
    AppMethodBeat.o(14607);
  }
  
  public final void aFn()
  {
    AppMethodBeat.i(14608);
    if (this.idk != null)
    {
      this.idk.stopTimer();
      this.idk.ag(3000L, 3000L);
    }
    AppMethodBeat.o(14608);
  }
  
  public final void aFo()
  {
    AppMethodBeat.i(14611);
    if (Pk())
    {
      setVisibility(8);
      AppMethodBeat.o(14611);
      return;
    }
    aFm();
    AppMethodBeat.o(14611);
  }
  
  public final void aFp()
  {
    AppMethodBeat.i(14612);
    this.idm = true;
    aFr();
    AppMethodBeat.o(14612);
  }
  
  public final boolean aFq()
  {
    return this.idm;
  }
  
  public final void aFv()
  {
    AppMethodBeat.i(14618);
    if (this.idl == null) {
      this.idl = new ap(new MPVideoViewControlBar.3(this), true);
    }
    aFx();
    this.idl.stopTimer();
    this.idl.ag(500L, 500L);
    AppMethodBeat.o(14618);
  }
  
  public final void aFw()
  {
    AppMethodBeat.i(14619);
    if (this.idl != null) {
      this.idl.stopTimer();
    }
    AppMethodBeat.o(14619);
  }
  
  public final void aFy()
  {
    AppMethodBeat.i(14622);
    if (this.qTI == 0)
    {
      AppMethodBeat.o(14622);
      return;
    }
    if (this.hPP)
    {
      AppMethodBeat.o(14622);
      return;
    }
    if (this.qTE == null)
    {
      AppMethodBeat.o(14622);
      return;
    }
    this.qTG.setText(ol(this.mPosition / 60) + ":" + ol(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(14622);
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
    AppMethodBeat.o(14622);
  }
  
  public final boolean aFz()
  {
    AppMethodBeat.i(14626);
    if (this.idd != null)
    {
      if ((getVisibility() == 0) && (this.idd.getVisibility() == 0))
      {
        AppMethodBeat.o(14626);
        return true;
      }
      AppMethodBeat.o(14626);
      return false;
    }
    AppMethodBeat.o(14626);
    return false;
  }
  
  public final void baj()
  {
    AppMethodBeat.i(152665);
    if (this.idk != null) {
      this.idk.stopTimer();
    }
    AppMethodBeat.o(152665);
  }
  
  public ImageView getCoverIv()
  {
    return this.icw;
  }
  
  public int getLayoutId()
  {
    return 2130970314;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(138511);
    setVisibility(8);
    AppMethodBeat.o(138511);
  }
  
  public final void init()
  {
    AppMethodBeat.i(14591);
    super.init();
    this.icZ = ((ImageView)this.contentView.findViewById(2131821468));
    this.idc = ((ImageView)this.contentView.findViewById(2131821462));
    this.idd = ((FrameLayout)this.contentView.findViewById(2131821460));
    this.idb = ((LinearLayout)findViewById(2131821003));
    this.ide = ((ImageView)findViewById(2131821467));
    this.idf = ((ImageView)findViewById(2131821457));
    this.idg = ((ImageView)findViewById(2131821456));
    this.aop = ((TextView)findViewById(2131820680));
    this.idh = ((LinearLayout)findViewById(2131821455));
    this.idi = ((LinearLayout)findViewById(2131821458));
    this.icw = ((ImageView)findViewById(2131826397));
    AppMethodBeat.o(14591);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(14589);
    if (this.idl != null) {
      this.idl.stopTimer();
    }
    if (this.idk != null) {
      this.idk.stopTimer();
    }
    AppMethodBeat.o(14589);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(14621);
    super.seek(paramInt);
    dk(this.mPosition, this.qTI);
    AppMethodBeat.o(14621);
  }
  
  public void setDanmakuBtnOnClickListener(d.f paramf) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(14593);
    this.idg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(14593);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(14605);
    this.icZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(14605);
  }
  
  public void setIplaySeekCallback(d.c paramc)
  {
    AppMethodBeat.i(14590);
    setIplaySeekCallback(new MPVideoViewControlBar.1(this, paramc));
    AppMethodBeat.o(14590);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(14604);
    this.cvm = paramBoolean;
    if (this.cvm)
    {
      this.qTF.setImageResource(2131231709);
      this.idf.setImageResource(2131231709);
      AppMethodBeat.o(14604);
      return;
    }
    this.qTF.setImageResource(2131231710);
    this.idf.setImageResource(2131231710);
    AppMethodBeat.o(14604);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(14592);
    this.ide.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(14592);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(14597);
    if (paramBoolean)
    {
      this.ide.setImageResource(2131231705);
      AppMethodBeat.o(14597);
      return;
    }
    this.ide.setImageResource(2131231706);
    AppMethodBeat.o(14597);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(14594);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.idf.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(14594);
  }
  
  public void setOnUpdateProgressLenListener(d.d paramd)
  {
    this.idt = paramd;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(14600);
    this.ids = paramBoolean;
    aFi();
    AppMethodBeat.o(14600);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(14598);
    this.idq = paramBoolean;
    aFA();
    AppMethodBeat.o(14598);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(14623);
    this.ido = paramBoolean;
    aFl();
    aFg();
    AppMethodBeat.o(14623);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(14596);
    ImageView localImageView = this.ide;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(14596);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(14624);
    this.idr = paramBoolean;
    aFi();
    AppMethodBeat.o(14624);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(14625);
    this.idp = paramBoolean;
    aFA();
    AppMethodBeat.o(14625);
  }
  
  public void setStatePorter(d.h paramh)
  {
    this.idj = paramh;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(14595);
    if (!bo.isNullOrNil(paramString)) {
      this.aop.setText(paramString);
    }
    AppMethodBeat.o(14595);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(14629);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.kjU != null)
      {
        this.kjU.onVisibilityChanged(true);
        AppMethodBeat.o(14629);
      }
    }
    else if (((paramInt == 8) || (paramInt == 4)) && (this.kjU != null)) {
      this.kjU.onVisibilityChanged(false);
    }
    AppMethodBeat.o(14629);
  }
  
  public final void show()
  {
    AppMethodBeat.i(152666);
    setVisibility(0);
    AppMethodBeat.o(152666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */