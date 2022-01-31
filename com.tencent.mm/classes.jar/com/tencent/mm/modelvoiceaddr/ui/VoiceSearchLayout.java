package com.tencent.mm.modelvoiceaddr.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.plugin.e.a.a;
import com.tencent.mm.plugin.e.a.b;
import com.tencent.mm.plugin.e.a.c;
import com.tencent.mm.plugin.e.a.d;
import com.tencent.mm.plugin.e.a.e;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] eMV = { a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check003, a.b.voicesearch_silence_check004, a.b.voicesearch_feedback005, a.b.voicesearch_feedback006, a.b.voicesearch_feedback007, a.b.voicesearch_feedback008, a.b.voicesearch_feedback009, a.b.voicesearch_feedback010, a.b.voicesearch_feedback011, a.b.voicesearch_feedback012, a.b.voicesearch_feedback013, a.b.voicesearch_feedback014 };
  private static final int[] eMW = { a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check003, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check004, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001 };
  private static final int[] eMX = { a.b.voicesearch_loading001, a.b.voicesearch_loading010, a.b.voicesearch_loading010, a.b.voicesearch_loading010, a.b.voicesearch_loading001 };
  boolean bSr = false;
  private View eML = null;
  VoiceSearchLayout.a eMM = null;
  private Button eMN;
  boolean eMO = false;
  int eMP = 0;
  private VoiceSearchLayout.b eMQ;
  private View eMR;
  private AnimationDrawable eMS;
  com.tencent.mm.modelvoiceaddr.f eMT;
  private boolean eMU = false;
  private int eMY = 0;
  private int eMZ = 0;
  int eNa = 0;
  final am eNb = new am(new VoiceSearchLayout.1(this), true);
  private int from = 0;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.eML = inflate(paramContext, a.d.voice_search_layout, this);
    this.eMN = ((Button)this.eML.findViewById(a.c.voice_search_start_btn));
    this.eMR = this.eML.findViewById(a.c.voice_search_field);
    setSearchStartBtnView(false);
    reset();
  }
  
  private void setAmpImage(int paramInt)
  {
    if (this.eMN != null) {
      this.eMN.setBackgroundResource(paramInt);
    }
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.eMN.setBackgroundResource(a.b.voice_search_start_anim);
      this.eMS = ((AnimationDrawable)this.eMN.getBackground());
      if (this.eMS != null) {
        this.eMS.start();
      }
      return;
    }
    this.eMN.setBackgroundResource(a.b.voicesearch_btn_normal);
  }
  
  private static void yv()
  {
    y.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    com.tencent.mm.compatible.b.f.yi().yv();
  }
  
  public final void TG()
  {
    y.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.bSr);
    if (this.bSr)
    {
      this.bSr = false;
      if (this.eMM != null) {
        this.eMM.TL();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.eMQ != null) {
        this.eMQ.cm(false);
      }
    }
    yv();
    if (this.eMT != null) {
      this.eMT.cancel();
    }
    if (this.eNb != null) {
      this.eNb.stopTimer();
    }
  }
  
  final void cl(boolean paramBoolean)
  {
    j localj;
    if (paramBoolean)
    {
      y.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      com.tencent.mm.compatible.b.f.yi().yu();
      localj = new j();
      if (!paramBoolean) {
        break label125;
      }
    }
    for (;;)
    {
      try
      {
        localj.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + a.e.on));
        localj.setAudioStreamType(5);
        localj.setOnCompletionListener(new VoiceSearchLayout.2(this));
        localj.setOnErrorListener(new VoiceSearchLayout.3(this));
        localj.prepare();
        localj.setLooping(false);
        localj.start();
        return;
      }
      catch (Exception localException)
      {
        label125:
        y.printErrStackTrace("MicroMsg.VoiceSearchLayout", localException, "", new Object[0]);
        localj.release();
      }
      yv();
      break;
      localj.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + a.e.off));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.eMO)
    {
      y.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.bSr);
      if (this.bSr)
      {
        TG();
        this.bSr = false;
      }
    }
    return true;
  }
  
  public final void reset()
  {
    setSearchStartBtnView(false);
    this.bSr = false;
    this.eMO = false;
    this.eMN.setBackgroundResource(a.b.voicesearch_btn_normal);
  }
  
  public void setOnSearchListener(VoiceSearchLayout.a parama)
  {
    this.eMM = parama;
  }
  
  public void setOnVisibleChangeListener(VoiceSearchLayout.b paramb)
  {
    this.eMQ = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.eMR.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.eMR.setLayoutParams(localLayoutParams);
  }
  
  public void setVisibility(int paramInt)
  {
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.eMU))
    {
      if (paramInt != 8) {
        break label68;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_out);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.eMQ != null)
      {
        localObject = this.eMQ;
        if (paramInt != 0) {
          break label82;
        }
      }
    }
    label68:
    label82:
    for (boolean bool = true;; bool = false)
    {
      ((VoiceSearchLayout.b)localObject).cm(bool);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */