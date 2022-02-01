package com.tencent.mm.modelvoiceaddr.ui;

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
  private static final int[] pgL = { a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check003, a.b.voicesearch_silence_check004, a.b.voicesearch_feedback005, a.b.voicesearch_feedback006, a.b.voicesearch_feedback007, a.b.voicesearch_feedback008, a.b.voicesearch_feedback009, a.b.voicesearch_feedback010, a.b.voicesearch_feedback011, a.b.voicesearch_feedback012, a.b.voicesearch_feedback013, a.b.voicesearch_feedback014 };
  private static final int[] pgM = { a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check003, a.b.voicesearch_silence_check002, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check004, a.b.voicesearch_silence_check001, a.b.voicesearch_silence_check001 };
  private static final int[] pgN = { a.b.voicesearch_loading001, a.b.voicesearch_loading010, a.b.voicesearch_loading010, a.b.voicesearch_loading010, a.b.voicesearch_loading001 };
  private int from;
  private View hDw;
  boolean isStart;
  a pgC;
  private WeImageButton pgD;
  boolean pgE;
  int pgF;
  private VoiceSearchLayout.b pgG;
  private View pgH;
  private AnimationDrawable pgI;
  f pgJ;
  private boolean pgK;
  private int pgO;
  private int pgP;
  int pgQ;
  final MTimerHandler pgR;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148617);
    this.hDw = null;
    this.pgC = null;
    this.isStart = false;
    this.pgE = false;
    this.pgF = 0;
    this.pgK = false;
    this.from = 0;
    this.pgO = 0;
    this.pgP = 0;
    this.pgQ = 0;
    this.pgR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bPJ().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPJ()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.pfu);
        int i = localf.pfu;
        localf.pfu = 0;
        if (i > f.hxV) {
          f.hxV = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.hxV + " per:" + i * 100 / f.hxV);
        i = i * 100 / f.hxV;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bPK().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPK()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bPL().length) {
            i = VoiceSearchLayout.bPL().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPL()[k]);
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
    this.hDw = null;
    this.pgC = null;
    this.isStart = false;
    this.pgE = false;
    this.pgF = 0;
    this.pgK = false;
    this.from = 0;
    this.pgO = 0;
    this.pgP = 0;
    this.pgQ = 0;
    this.pgR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bPJ().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPJ()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.pfu);
        int i = localf.pfu;
        localf.pfu = 0;
        if (i > f.hxV) {
          f.hxV = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.hxV + " per:" + i * 100 / f.hxV);
        i = i * 100 / f.hxV;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bPK().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPK()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bPL().length) {
            i = VoiceSearchLayout.bPL().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPL()[k]);
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
  
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(148615);
    this.hDw = null;
    this.pgC = null;
    this.isStart = false;
    this.pgE = false;
    this.pgF = 0;
    this.pgK = false;
    this.from = 0;
    this.pgO = 0;
    this.pgP = 0;
    this.pgQ = 0;
    this.pgR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bPJ().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPJ()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.pfu);
        int i = localf.pfu;
        localf.pfu = 0;
        if (i > f.hxV) {
          f.hxV = i;
        }
        Log.d("getMaxAmplitude", " map: " + i + " max:" + f.hxV + " per:" + i * 100 / f.hxV);
        i = i * 100 / f.hxV;
        Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bPK().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPK()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bPL().length) {
            i = VoiceSearchLayout.bPL().length - 1;
          }
          Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bPL()[k]);
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
  
  private static void bLh()
  {
    AppMethodBeat.i(148627);
    Log.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.bLh();
    AppMethodBeat.o(148627);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148618);
    this.hDw = inflate(paramContext, a.d.voice_search_layout, this);
    this.pgD = ((WeImageButton)this.hDw.findViewById(a.c.voice_search_start_btn));
    this.pgH = this.hDw.findViewById(a.c.voice_search_field);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(148618);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(148625);
    if (this.pgD != null) {
      this.pgD.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(148625);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(148622);
    if (paramBoolean)
    {
      this.pgD.setBackgroundResource(a.b.voice_search_start_anim);
      this.pgI = ((AnimationDrawable)this.pgD.getBackground());
      if (this.pgI != null)
      {
        this.pgI.start();
        AppMethodBeat.o(148622);
      }
    }
    else
    {
      this.pgD.setBackgroundResource(a.b.voicesearch_btn_normal);
    }
    AppMethodBeat.o(148622);
  }
  
  public final void bPI()
  {
    AppMethodBeat.i(148620);
    Log.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.pgC != null) {
        this.pgC.bPN();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.pgG != null) {
        this.pgG.hx(false);
      }
    }
    bLh();
    if (this.pgJ != null) {
      this.pgJ.cancel();
    }
    if (this.pgR != null) {
      this.pgR.stopTimer();
    }
    AppMethodBeat.o(148620);
  }
  
  final void hw(boolean paramBoolean)
  {
    AppMethodBeat.i(148626);
    k localk;
    if (paramBoolean)
    {
      Log.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      com.tencent.mm.plugin.audio.c.a.bLg();
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
      bLh();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + a.e.off));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148619);
    if (!this.pgE)
    {
      Log.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        bPI();
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
    this.pgE = false;
    this.pgD.setBackgroundResource(a.b.voicesearch_btn_normal);
    AppMethodBeat.o(148621);
  }
  
  public void setOnSearchListener(a parama)
  {
    this.pgC = parama;
  }
  
  public void setOnVisibleChangeListener(VoiceSearchLayout.b paramb)
  {
    this.pgG = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(148624);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.pgH.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.pgH.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(148624);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(148623);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.pgK))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_out);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.pgG != null)
      {
        localObject = this.pgG;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((VoiceSearchLayout.b)localObject).hx(bool);
      AppMethodBeat.o(148623);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void bPM();
    
    public abstract void bPN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */