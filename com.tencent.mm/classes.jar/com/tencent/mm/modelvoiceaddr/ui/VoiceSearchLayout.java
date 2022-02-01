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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] jxw = { 2131235506, 2131235507, 2131235508, 2131235509, 2131235486, 2131235487, 2131235488, 2131235489, 2131235490, 2131235491, 2131235492, 2131235493, 2131235494, 2131235495 };
  private static final int[] jxx = { 2131235506, 2131235506, 2131235506, 2131235507, 2131235508, 2131235507, 2131235506, 2131235509, 2131235506, 2131235506 };
  private static final int[] jxy = { 2131235496, 2131235505, 2131235505, 2131235505, 2131235496 };
  private int from;
  boolean isStart;
  private int jxA;
  int jxB;
  final MTimerHandler jxC;
  private View jxm;
  a jxn;
  private WeImageButton jxo;
  boolean jxp;
  int jxq;
  private VoiceSearchLayout.b jxr;
  private View jxs;
  private AnimationDrawable jxt;
  f jxu;
  private boolean jxv;
  private int jxz;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148617);
    this.jxm = null;
    this.jxn = null;
    this.isStart = false;
    this.jxp = false;
    this.jxq = 0;
    this.jxv = false;
    this.from = 0;
    this.jxz = 0;
    this.jxA = 0;
    this.jxB = 0;
    this.jxC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.biF().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biF()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.jwf);
        int i = localf.jwf;
        localf.jwf = 0;
        if (i > f.dAR) {
          f.dAR = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.dAR + " per:" + i * 100 / f.dAR);
        i = i * 100 / f.dAR;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.biG().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biG()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.biH().length) {
            i = VoiceSearchLayout.biH().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biH()[k]);
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
    this.jxm = null;
    this.jxn = null;
    this.isStart = false;
    this.jxp = false;
    this.jxq = 0;
    this.jxv = false;
    this.from = 0;
    this.jxz = 0;
    this.jxA = 0;
    this.jxB = 0;
    this.jxC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.biF().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biF()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.jwf);
        int i = localf.jwf;
        localf.jwf = 0;
        if (i > f.dAR) {
          f.dAR = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.dAR + " per:" + i * 100 / f.dAR);
        i = i * 100 / f.dAR;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.biG().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biG()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.biH().length) {
            i = VoiceSearchLayout.biH().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biH()[k]);
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
    this.jxm = null;
    this.jxn = null;
    this.isStart = false;
    this.jxp = false;
    this.jxq = 0;
    this.jxv = false;
    this.from = 0;
    this.jxz = 0;
    this.jxA = 0;
    this.jxB = 0;
    this.jxC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.biF().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biF()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.jwf);
        int i = localf.jwf;
        localf.jwf = 0;
        if (i > f.dAR) {
          f.dAR = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.dAR + " per:" + i * 100 / f.dAR);
        i = i * 100 / f.dAR;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.biG().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biG()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.biH().length) {
            i = VoiceSearchLayout.biH().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.biH()[k]);
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
  
  private static void bdZ()
  {
    AppMethodBeat.i(148627);
    Log.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.bdZ();
    AppMethodBeat.o(148627);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148618);
    this.jxm = inflate(paramContext, 2131496850, this);
    this.jxo = ((WeImageButton)this.jxm.findViewById(2131309993));
    this.jxs = this.jxm.findViewById(2131309991);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(148618);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(148625);
    if (this.jxo != null) {
      this.jxo.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(148625);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(148622);
    if (paramBoolean)
    {
      this.jxo.setBackgroundResource(2131235455);
      this.jxt = ((AnimationDrawable)this.jxo.getBackground());
      if (this.jxt != null)
      {
        this.jxt.start();
        AppMethodBeat.o(148622);
      }
    }
    else
    {
      this.jxo.setBackgroundResource(2131235484);
    }
    AppMethodBeat.o(148622);
  }
  
  public final void biE()
  {
    AppMethodBeat.i(148620);
    Log.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.jxn != null) {
        this.jxn.biJ();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.jxr != null) {
        this.jxr.fX(false);
      }
    }
    bdZ();
    if (this.jxu != null) {
      this.jxu.cancel();
    }
    if (this.jxC != null) {
      this.jxC.stopTimer();
    }
    AppMethodBeat.o(148620);
  }
  
  final void fW(boolean paramBoolean)
  {
    AppMethodBeat.i(148626);
    k localk;
    if (paramBoolean)
    {
      Log.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      com.tencent.mm.plugin.audio.c.a.bdY();
      localk = new k();
      if (!paramBoolean) {
        break label130;
      }
    }
    for (;;)
    {
      try
      {
        localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131691297"));
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
        label130:
        Log.printErrStackTrace("MicroMsg.VoiceSearchLayout", localException, "", new Object[0]);
        localk.release();
        AppMethodBeat.o(148626);
      }
      bdZ();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131691255"));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148619);
    if (!this.jxp)
    {
      Log.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        biE();
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
    this.jxp = false;
    this.jxo.setBackgroundResource(2131235484);
    AppMethodBeat.o(148621);
  }
  
  public void setOnSearchListener(a parama)
  {
    this.jxn = parama;
  }
  
  public void setOnVisibleChangeListener(VoiceSearchLayout.b paramb)
  {
    this.jxr = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(148624);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jxs.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.jxs.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(148624);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(148623);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.jxv))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772060);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.jxr != null)
      {
        localObject = this.jxr;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((VoiceSearchLayout.b)localObject).fX(bool);
      AppMethodBeat.o(148623);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772059);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void biI();
    
    public abstract void biJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */