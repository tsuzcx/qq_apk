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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] gcA = { 2130840730, 2130840731, 2130840732, 2130840733, 2130840710, 2130840711, 2130840712, 2130840713, 2130840714, 2130840715, 2130840716, 2130840717, 2130840718, 2130840719 };
  private static final int[] gcB = { 2130840730, 2130840730, 2130840730, 2130840731, 2130840732, 2130840731, 2130840730, 2130840733, 2130840730, 2130840730 };
  private static final int[] gcC = { 2130840720, 2130840729, 2130840729, 2130840729, 2130840720 };
  private int from;
  private int gcD;
  private int gcE;
  int gcF;
  final ap gcG;
  private View gcq;
  VoiceSearchLayout.a gcr;
  private Button gcs;
  boolean gct;
  int gcu;
  private VoiceSearchLayout.b gcv;
  private View gcw;
  private AnimationDrawable gcx;
  f gcy;
  private boolean gcz;
  boolean isStart;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116771);
    this.gcq = null;
    this.gcr = null;
    this.isStart = false;
    this.gct = false;
    this.gcu = 0;
    this.gcz = false;
    this.from = 0;
    this.gcD = 0;
    this.gcE = 0;
    this.gcF = 0;
    this.gcG = new ap(new VoiceSearchLayout.1(this), true);
    init(paramContext);
    AppMethodBeat.o(116771);
  }
  
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116770);
    this.gcq = null;
    this.gcr = null;
    this.isStart = false;
    this.gct = false;
    this.gcu = 0;
    this.gcz = false;
    this.from = 0;
    this.gcD = 0;
    this.gcE = 0;
    this.gcF = 0;
    this.gcG = new ap(new VoiceSearchLayout.1(this), true);
    init(paramContext);
    AppMethodBeat.o(116770);
  }
  
  @TargetApi(11)
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116769);
    this.gcq = null;
    this.gcr = null;
    this.isStart = false;
    this.gct = false;
    this.gcu = 0;
    this.gcz = false;
    this.from = 0;
    this.gcD = 0;
    this.gcE = 0;
    this.gcF = 0;
    this.gcG = new ap(new VoiceSearchLayout.1(this), true);
    init(paramContext);
    AppMethodBeat.o(116769);
  }
  
  private static void KQ()
  {
    AppMethodBeat.i(116781);
    ab.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    g.KC().KQ();
    AppMethodBeat.o(116781);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(116772);
    this.gcq = inflate(paramContext, 2130971100, this);
    this.gcs = ((Button)this.gcq.findViewById(2131824403));
    this.gcw = this.gcq.findViewById(2131828798);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(116772);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(116779);
    if (this.gcs != null) {
      this.gcs.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(116779);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(116776);
    if (paramBoolean)
    {
      this.gcs.setBackgroundResource(2130840686);
      this.gcx = ((AnimationDrawable)this.gcs.getBackground());
      if (this.gcx != null)
      {
        this.gcx.start();
        AppMethodBeat.o(116776);
      }
    }
    else
    {
      this.gcs.setBackgroundResource(2130840708);
    }
    AppMethodBeat.o(116776);
  }
  
  public final void amT()
  {
    AppMethodBeat.i(116774);
    ab.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.gcr != null) {
        this.gcr.amY();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.gcv != null) {
        this.gcv.dp(false);
      }
    }
    KQ();
    if (this.gcy != null) {
      this.gcy.cancel();
    }
    if (this.gcG != null) {
      this.gcG.stopTimer();
    }
    AppMethodBeat.o(116774);
  }
  
  final void jdMethod_do(boolean paramBoolean)
  {
    AppMethodBeat.i(116780);
    k localk;
    if (paramBoolean)
    {
      ab.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      g.KC().KP();
      localk = new k();
      if (!paramBoolean) {
        break label131;
      }
    }
    for (;;)
    {
      try
      {
        localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131231830"));
        localk.setAudioStreamType(5);
        localk.setOnCompletionListener(new VoiceSearchLayout.2(this));
        localk.setOnErrorListener(new VoiceSearchLayout.3(this));
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        AppMethodBeat.o(116780);
        return;
      }
      catch (Exception localException)
      {
        label131:
        ab.printErrStackTrace("MicroMsg.VoiceSearchLayout", localException, "", new Object[0]);
        localk.release();
        AppMethodBeat.o(116780);
      }
      KQ();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131231788"));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116773);
    if (!this.gct)
    {
      ab.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        amT();
        this.isStart = false;
      }
    }
    AppMethodBeat.o(116773);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(116775);
    setSearchStartBtnView(false);
    this.isStart = false;
    this.gct = false;
    this.gcs.setBackgroundResource(2130840708);
    AppMethodBeat.o(116775);
  }
  
  public void setOnSearchListener(VoiceSearchLayout.a parama)
  {
    this.gcr = parama;
  }
  
  public void setOnVisibleChangeListener(VoiceSearchLayout.b paramb)
  {
    this.gcv = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(116778);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.gcw.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.gcw.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(116778);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(116777);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.gcz))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), 2131034182);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.gcv != null)
      {
        localObject = this.gcv;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((VoiceSearchLayout.b)localObject).dp(bool);
      AppMethodBeat.o(116777);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), 2131034181);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */