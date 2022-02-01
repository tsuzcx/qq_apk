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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] iCh = { 2131234544, 2131234545, 2131234546, 2131234547, 2131234524, 2131234525, 2131234526, 2131234527, 2131234528, 2131234529, 2131234530, 2131234531, 2131234532, 2131234533 };
  private static final int[] iCi = { 2131234544, 2131234544, 2131234544, 2131234545, 2131234546, 2131234545, 2131234544, 2131234547, 2131234544, 2131234544 };
  private static final int[] iCj = { 2131234534, 2131234543, 2131234543, 2131234543, 2131234534 };
  private int from;
  private View iBX;
  a iBY;
  private WeImageButton iBZ;
  boolean iCa;
  int iCb;
  private b iCc;
  private View iCd;
  private AnimationDrawable iCe;
  f iCf;
  private boolean iCg;
  private int iCk;
  private int iCl;
  int iCm;
  final aw iCn;
  boolean isStart;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148617);
    this.iBX = null;
    this.iBY = null;
    this.isStart = false;
    this.iCa = false;
    this.iCb = 0;
    this.iCg = false;
    this.from = 0;
    this.iCk = 0;
    this.iCl = 0;
    this.iCm = 0;
    this.iCn = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aOy().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOy()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ae.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.iAQ);
        int i = localf.iAQ;
        localf.iAQ = 0;
        if (i > f.djH) {
          f.djH = i;
        }
        ae.d("getMaxAmplitude", " map: " + i + " max:" + f.djH + " per:" + i * 100 / f.djH);
        i = i * 100 / f.djH;
        ae.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aOz().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOz()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aOA().length) {
            i = VoiceSearchLayout.aOA().length - 1;
          }
          ae.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOA()[k]);
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
    this.iBX = null;
    this.iBY = null;
    this.isStart = false;
    this.iCa = false;
    this.iCb = 0;
    this.iCg = false;
    this.from = 0;
    this.iCk = 0;
    this.iCl = 0;
    this.iCm = 0;
    this.iCn = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aOy().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOy()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ae.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.iAQ);
        int i = localf.iAQ;
        localf.iAQ = 0;
        if (i > f.djH) {
          f.djH = i;
        }
        ae.d("getMaxAmplitude", " map: " + i + " max:" + f.djH + " per:" + i * 100 / f.djH);
        i = i * 100 / f.djH;
        ae.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aOz().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOz()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aOA().length) {
            i = VoiceSearchLayout.aOA().length - 1;
          }
          ae.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOA()[k]);
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
    this.iBX = null;
    this.iBY = null;
    this.isStart = false;
    this.iCa = false;
    this.iCb = 0;
    this.iCg = false;
    this.from = 0;
    this.iCk = 0;
    this.iCl = 0;
    this.iCm = 0;
    this.iCn = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aOy().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOy()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ae.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.iAQ);
        int i = localf.iAQ;
        localf.iAQ = 0;
        if (i > f.djH) {
          f.djH = i;
        }
        ae.d("getMaxAmplitude", " map: " + i + " max:" + f.djH + " per:" + i * 100 / f.djH);
        i = i * 100 / f.djH;
        ae.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aOz().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOz()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aOA().length) {
            i = VoiceSearchLayout.aOA().length - 1;
          }
          ae.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOA()[k]);
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
  
  private static void aJW()
  {
    AppMethodBeat.i(148627);
    ae.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    a.aJW();
    AppMethodBeat.o(148627);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148618);
    this.iBX = inflate(paramContext, 2131495870, this);
    this.iBZ = ((WeImageButton)this.iBX.findViewById(2131306533));
    this.iCd = this.iBX.findViewById(2131306531);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(148618);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(148625);
    if (this.iBZ != null) {
      this.iBZ.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(148625);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(148622);
    if (paramBoolean)
    {
      this.iBZ.setBackgroundResource(2131234499);
      this.iCe = ((AnimationDrawable)this.iBZ.getBackground());
      if (this.iCe != null)
      {
        this.iCe.start();
        AppMethodBeat.o(148622);
      }
    }
    else
    {
      this.iBZ.setBackgroundResource(2131234522);
    }
    AppMethodBeat.o(148622);
  }
  
  public final void aOx()
  {
    AppMethodBeat.i(148620);
    ae.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.iBY != null) {
        this.iBY.aOC();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.iCc != null) {
        this.iCc.fh(false);
      }
    }
    aJW();
    if (this.iCf != null) {
      this.iCf.cancel();
    }
    if (this.iCn != null) {
      this.iCn.stopTimer();
    }
    AppMethodBeat.o(148620);
  }
  
  final void fg(boolean paramBoolean)
  {
    AppMethodBeat.i(148626);
    k localk;
    if (paramBoolean)
    {
      ae.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      a.aJV();
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
        ae.printErrStackTrace("MicroMsg.VoiceSearchLayout", localException, "", new Object[0]);
        localk.release();
        AppMethodBeat.o(148626);
      }
      aJW();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131690958"));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148619);
    if (!this.iCa)
    {
      ae.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        aOx();
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
    this.iCa = false;
    this.iBZ.setBackgroundResource(2131234522);
    AppMethodBeat.o(148621);
  }
  
  public void setOnSearchListener(a parama)
  {
    this.iBY = parama;
  }
  
  public void setOnVisibleChangeListener(b paramb)
  {
    this.iCc = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(148624);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.iCd.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.iCd.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(148624);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(148623);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.iCg))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772048);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.iCc != null)
      {
        localObject = this.iCc;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((b)localObject).fh(bool);
      AppMethodBeat.o(148623);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772047);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void aOB();
    
    public abstract void aOC();
  }
  
  public static abstract interface b
  {
    public abstract void fh(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */