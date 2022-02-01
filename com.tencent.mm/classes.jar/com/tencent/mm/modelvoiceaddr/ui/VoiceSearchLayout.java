package com.tencent.mm.modelvoiceaddr.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.b;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] ifU = { 2131234544, 2131234545, 2131234546, 2131234547, 2131234524, 2131234525, 2131234526, 2131234527, 2131234528, 2131234529, 2131234530, 2131234531, 2131234532, 2131234533 };
  private static final int[] ifV = { 2131234544, 2131234544, 2131234544, 2131234545, 2131234546, 2131234545, 2131234544, 2131234547, 2131234544, 2131234544 };
  private static final int[] ifW = { 2131234534, 2131234543, 2131234543, 2131234543, 2131234534 };
  private int from;
  private View ifK;
  a ifL;
  private WeImageButton ifM;
  boolean ifN;
  int ifO;
  private VoiceSearchLayout.b ifP;
  private View ifQ;
  private AnimationDrawable ifR;
  f ifS;
  private boolean ifT;
  private int ifX;
  private int ifY;
  int ifZ;
  final au iga;
  boolean isStart;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148617);
    this.ifK = null;
    this.ifL = null;
    this.isStart = false;
    this.ifN = false;
    this.ifO = 0;
    this.ifT = false;
    this.from = 0;
    this.ifX = 0;
    this.ifY = 0;
    this.ifZ = 0;
    this.iga = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aKR().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKR()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ac.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.ieD);
        int i = localf.ieD;
        localf.ieD = 0;
        if (i > f.cXn) {
          f.cXn = i;
        }
        ac.d("getMaxAmplitude", " map: " + i + " max:" + f.cXn + " per:" + i * 100 / f.cXn);
        i = i * 100 / f.cXn;
        ac.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aKS().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKS()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aKT().length) {
            i = VoiceSearchLayout.aKT().length - 1;
          }
          ac.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKT()[k]);
          AppMethodBeat.o(148610);
          return true;
          if (VoiceSearchLayout.d(VoiceSearchLayout.this) > VoiceSearchLayout.e(VoiceSearchLayout.this)) {
            VoiceSearchLayout.i(VoiceSearchLayout.this);
          } else {
            VoiceSearchLayout.j(VoiceSearchLayout.this);
          }
        }
      }
    }, true);
    init(paramContext);
    AppMethodBeat.o(148617);
  }
  
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(148616);
    this.ifK = null;
    this.ifL = null;
    this.isStart = false;
    this.ifN = false;
    this.ifO = 0;
    this.ifT = false;
    this.from = 0;
    this.ifX = 0;
    this.ifY = 0;
    this.ifZ = 0;
    this.iga = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aKR().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKR()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ac.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.ieD);
        int i = localf.ieD;
        localf.ieD = 0;
        if (i > f.cXn) {
          f.cXn = i;
        }
        ac.d("getMaxAmplitude", " map: " + i + " max:" + f.cXn + " per:" + i * 100 / f.cXn);
        i = i * 100 / f.cXn;
        ac.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aKS().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKS()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aKT().length) {
            i = VoiceSearchLayout.aKT().length - 1;
          }
          ac.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKT()[k]);
          AppMethodBeat.o(148610);
          return true;
          if (VoiceSearchLayout.d(VoiceSearchLayout.this) > VoiceSearchLayout.e(VoiceSearchLayout.this)) {
            VoiceSearchLayout.i(VoiceSearchLayout.this);
          } else {
            VoiceSearchLayout.j(VoiceSearchLayout.this);
          }
        }
      }
    }, true);
    init(paramContext);
    AppMethodBeat.o(148616);
  }
  
  @TargetApi(11)
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(148615);
    this.ifK = null;
    this.ifL = null;
    this.isStart = false;
    this.ifN = false;
    this.ifO = 0;
    this.ifT = false;
    this.from = 0;
    this.ifX = 0;
    this.ifY = 0;
    this.ifZ = 0;
    this.iga = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aKR().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKR()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ac.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.ieD);
        int i = localf.ieD;
        localf.ieD = 0;
        if (i > f.cXn) {
          f.cXn = i;
        }
        ac.d("getMaxAmplitude", " map: " + i + " max:" + f.cXn + " per:" + i * 100 / f.cXn);
        i = i * 100 / f.cXn;
        ac.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aKS().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKS()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aKT().length) {
            i = VoiceSearchLayout.aKT().length - 1;
          }
          ac.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aKT()[k]);
          AppMethodBeat.o(148610);
          return true;
          if (VoiceSearchLayout.d(VoiceSearchLayout.this) > VoiceSearchLayout.e(VoiceSearchLayout.this)) {
            VoiceSearchLayout.i(VoiceSearchLayout.this);
          } else {
            VoiceSearchLayout.j(VoiceSearchLayout.this);
          }
        }
      }
    }, true);
    init(paramContext);
    AppMethodBeat.o(148615);
  }
  
  private static void aGs()
  {
    AppMethodBeat.i(148627);
    ac.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    a.aGs();
    AppMethodBeat.o(148627);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148618);
    this.ifK = inflate(paramContext, 2131495870, this);
    this.ifM = ((WeImageButton)this.ifK.findViewById(2131306533));
    this.ifQ = this.ifK.findViewById(2131306531);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(148618);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(148625);
    if (this.ifM != null) {
      this.ifM.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(148625);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(148622);
    if (paramBoolean)
    {
      this.ifM.setBackgroundResource(2131234499);
      this.ifR = ((AnimationDrawable)this.ifM.getBackground());
      if (this.ifR != null)
      {
        this.ifR.start();
        AppMethodBeat.o(148622);
      }
    }
    else
    {
      this.ifM.setBackgroundResource(2131234522);
    }
    AppMethodBeat.o(148622);
  }
  
  public final void aKQ()
  {
    AppMethodBeat.i(148620);
    ac.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.ifL != null) {
        this.ifL.aKV();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.ifP != null) {
        this.ifP.fc(false);
      }
    }
    aGs();
    if (this.ifS != null) {
      this.ifS.cancel();
    }
    if (this.iga != null) {
      this.iga.stopTimer();
    }
    AppMethodBeat.o(148620);
  }
  
  final void fb(boolean paramBoolean)
  {
    AppMethodBeat.i(148626);
    k localk;
    if (paramBoolean)
    {
      ac.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      a.aGr();
      localk = new k();
      if (!paramBoolean) {
        break label128;
      }
    }
    for (;;)
    {
      try
      {
        localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131690999"));
        localk.setAudioStreamType(5);
        localk.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(148611);
            paramAnonymousMediaPlayer.release();
            AppMethodBeat.o(148611);
          }
        });
        localk.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            return false;
          }
        });
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        AppMethodBeat.o(148626);
        return;
      }
      catch (Exception localException)
      {
        label128:
        ac.printErrStackTrace("MicroMsg.VoiceSearchLayout", localException, "", new Object[0]);
        localk.release();
        AppMethodBeat.o(148626);
      }
      aGs();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131690958"));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148619);
    if (!this.ifN)
    {
      ac.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        aKQ();
        this.isStart = false;
      }
    }
    AppMethodBeat.o(148619);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(148621);
    setSearchStartBtnView(false);
    this.isStart = false;
    this.ifN = false;
    this.ifM.setBackgroundResource(2131234522);
    AppMethodBeat.o(148621);
  }
  
  public void setOnSearchListener(a parama)
  {
    this.ifL = parama;
  }
  
  public void setOnVisibleChangeListener(VoiceSearchLayout.b paramb)
  {
    this.ifP = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(148624);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ifQ.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.ifQ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(148624);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(148623);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.ifT))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772048);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.ifP != null)
      {
        localObject = this.ifP;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((VoiceSearchLayout.b)localObject).fc(bool);
      AppMethodBeat.o(148623);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772047);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void aKU();
    
    public abstract void aKV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */