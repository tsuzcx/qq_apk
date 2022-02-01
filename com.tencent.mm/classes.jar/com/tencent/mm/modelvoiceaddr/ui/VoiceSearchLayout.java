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
import com.tencent.mm.plugin.e.a.a;
import com.tencent.mm.plugin.e.a.b;
import com.tencent.mm.plugin.e.a.c;
import com.tencent.mm.plugin.e.a.d;
import com.tencent.mm.plugin.e.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] mmY = { a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check003, a.b.voicesearch_silence_check004, a.b.voicesearch_feedback005, a.b.voicesearch_feedback006, a.b.voicesearch_feedback007, a.b.voicesearch_feedback008, a.b.voicesearch_feedback009, a.b.voicesearch_feedback010, a.b.voicesearch_feedback011, a.b.voicesearch_feedback012, a.b.voicesearch_feedback013, a.b.voicesearch_feedback014 };
  private static final int[] mmZ = { a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check003, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check004, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001 };
  private static final int[] mna = { a.b.voicesearch_loading001, a.b.voicesearch_loading010, a.b.voicesearch_loading010, a.b.voicesearch_loading010, a.b.voicesearch_loading001 };
  private int from;
  private View fyN;
  boolean isStart;
  a mmP;
  private WeImageButton mmQ;
  boolean mmR;
  int mmS;
  private b mmT;
  private View mmU;
  private AnimationDrawable mmV;
  f mmW;
  private boolean mmX;
  private int mnb;
  private int mnd;
  int mne;
  final MTimerHandler mnf;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148617);
    this.fyN = null;
    this.mmP = null;
    this.isStart = false;
    this.mmR = false;
    this.mmS = 0;
    this.mmX = false;
    this.from = 0;
    this.mnb = 0;
    this.mnd = 0;
    this.mne = 0;
    this.mnf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bsd().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bsd()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.mlI);
        int i = localf.mlI;
        localf.mlI = 0;
        if (i > f.ftG) {
          f.ftG = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.ftG + " per:" + i * 100 / f.ftG);
        i = i * 100 / f.ftG;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bse().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bse()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bsf().length) {
            i = VoiceSearchLayout.bsf().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bsf()[k]);
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
    this.fyN = null;
    this.mmP = null;
    this.isStart = false;
    this.mmR = false;
    this.mmS = 0;
    this.mmX = false;
    this.from = 0;
    this.mnb = 0;
    this.mnd = 0;
    this.mne = 0;
    this.mnf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bsd().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bsd()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.mlI);
        int i = localf.mlI;
        localf.mlI = 0;
        if (i > f.ftG) {
          f.ftG = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.ftG + " per:" + i * 100 / f.ftG);
        i = i * 100 / f.ftG;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bse().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bse()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bsf().length) {
            i = VoiceSearchLayout.bsf().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bsf()[k]);
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
    this.fyN = null;
    this.mmP = null;
    this.isStart = false;
    this.mmR = false;
    this.mmS = 0;
    this.mmX = false;
    this.from = 0;
    this.mnb = 0;
    this.mnd = 0;
    this.mne = 0;
    this.mnf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bsd().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bsd()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.mlI);
        int i = localf.mlI;
        localf.mlI = 0;
        if (i > f.ftG) {
          f.ftG = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.ftG + " per:" + i * 100 / f.ftG);
        i = i * 100 / f.ftG;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bse().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bse()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bsf().length) {
            i = VoiceSearchLayout.bsf().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bsf()[k]);
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
  
  private static void bnu()
  {
    AppMethodBeat.i(148627);
    Log.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.bnu();
    AppMethodBeat.o(148627);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148618);
    this.fyN = inflate(paramContext, a.d.voice_search_layout, this);
    this.mmQ = ((WeImageButton)this.fyN.findViewById(a.c.voice_search_start_btn));
    this.mmU = this.fyN.findViewById(a.c.voice_search_field);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(148618);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(148625);
    if (this.mmQ != null) {
      this.mmQ.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(148625);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(148622);
    if (paramBoolean)
    {
      this.mmQ.setBackgroundResource(a.b.voice_search_start_anim);
      this.mmV = ((AnimationDrawable)this.mmQ.getBackground());
      if (this.mmV != null)
      {
        this.mmV.start();
        AppMethodBeat.o(148622);
      }
    }
    else
    {
      this.mmQ.setBackgroundResource(a.b.voicesearch_btn_normal);
    }
    AppMethodBeat.o(148622);
  }
  
  public final void bsc()
  {
    AppMethodBeat.i(148620);
    Log.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.mmP != null) {
        this.mmP.bsh();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.mmT != null) {
        this.mmT.gJ(false);
      }
    }
    bnu();
    if (this.mmW != null) {
      this.mmW.cancel();
    }
    if (this.mnf != null) {
      this.mnf.stopTimer();
    }
    AppMethodBeat.o(148620);
  }
  
  final void gI(boolean paramBoolean)
  {
    AppMethodBeat.i(148626);
    k localk;
    if (paramBoolean)
    {
      Log.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      com.tencent.mm.plugin.audio.c.a.bnt();
      localk = new k();
      if (!paramBoolean) {
        break label136;
      }
    }
    for (;;)
    {
      try
      {
        localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + a.e.on));
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
        label136:
        Log.printErrStackTrace("MicroMsg.VoiceSearchLayout", localException, "", new Object[0]);
        localk.release();
        AppMethodBeat.o(148626);
      }
      bnu();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + a.e.off));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148619);
    if (!this.mmR)
    {
      Log.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        bsc();
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
    this.mmR = false;
    this.mmQ.setBackgroundResource(a.b.voicesearch_btn_normal);
    AppMethodBeat.o(148621);
  }
  
  public void setOnSearchListener(a parama)
  {
    this.mmP = parama;
  }
  
  public void setOnVisibleChangeListener(b paramb)
  {
    this.mmT = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(148624);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mmU.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.mmU.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(148624);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(148623);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.mmX))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_out);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.mmT != null)
      {
        localObject = this.mmT;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((b)localObject).gJ(bool);
      AppMethodBeat.o(148623);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void bsg();
    
    public abstract void bsh();
  }
  
  public static abstract interface b
  {
    public abstract void gJ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */