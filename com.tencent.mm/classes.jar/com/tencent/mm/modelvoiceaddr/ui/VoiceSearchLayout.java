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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] hFs = { 2131234544, 2131234545, 2131234546, 2131234547, 2131234524, 2131234525, 2131234526, 2131234527, 2131234528, 2131234529, 2131234530, 2131234531, 2131234532, 2131234533 };
  private static final int[] hFt = { 2131234544, 2131234544, 2131234544, 2131234545, 2131234546, 2131234545, 2131234544, 2131234547, 2131234544, 2131234544 };
  private static final int[] hFu = { 2131234534, 2131234543, 2131234543, 2131234543, 2131234534 };
  private int from;
  private View hFi;
  a hFj;
  private WeImageButton hFk;
  boolean hFl;
  int hFm;
  private VoiceSearchLayout.b hFn;
  private View hFo;
  private AnimationDrawable hFp;
  f hFq;
  private boolean hFr;
  private int hFv;
  private int hFw;
  int hFx;
  final av hFy;
  boolean isStart;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148617);
    this.hFi = null;
    this.hFj = null;
    this.isStart = false;
    this.hFl = false;
    this.hFm = 0;
    this.hFr = false;
    this.from = 0;
    this.hFv = 0;
    this.hFw = 0;
    this.hFx = 0;
    this.hFy = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aEa().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEa()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ad.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.hEb);
        int i = localf.hEb;
        localf.hEb = 0;
        if (i > f.cZR) {
          f.cZR = i;
        }
        ad.d("getMaxAmplitude", " map: " + i + " max:" + f.cZR + " per:" + i * 100 / f.cZR);
        i = i * 100 / f.cZR;
        ad.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aEb().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEb()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aEc().length) {
            i = VoiceSearchLayout.aEc().length - 1;
          }
          ad.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEc()[k]);
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
    this.hFi = null;
    this.hFj = null;
    this.isStart = false;
    this.hFl = false;
    this.hFm = 0;
    this.hFr = false;
    this.from = 0;
    this.hFv = 0;
    this.hFw = 0;
    this.hFx = 0;
    this.hFy = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aEa().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEa()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ad.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.hEb);
        int i = localf.hEb;
        localf.hEb = 0;
        if (i > f.cZR) {
          f.cZR = i;
        }
        ad.d("getMaxAmplitude", " map: " + i + " max:" + f.cZR + " per:" + i * 100 / f.cZR);
        i = i * 100 / f.cZR;
        ad.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aEb().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEb()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aEc().length) {
            i = VoiceSearchLayout.aEc().length - 1;
          }
          ad.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEc()[k]);
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
    this.hFi = null;
    this.hFj = null;
    this.isStart = false;
    this.hFl = false;
    this.hFm = 0;
    this.hFr = false;
    this.from = 0;
    this.hFv = 0;
    this.hFw = 0;
    this.hFx = 0;
    this.hFy = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aEa().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEa()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ad.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.hEb);
        int i = localf.hEb;
        localf.hEb = 0;
        if (i > f.cZR) {
          f.cZR = i;
        }
        ad.d("getMaxAmplitude", " map: " + i + " max:" + f.cZR + " per:" + i * 100 / f.cZR);
        i = i * 100 / f.cZR;
        ad.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aEb().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEb()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aEc().length) {
            i = VoiceSearchLayout.aEc().length - 1;
          }
          ad.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aEc()[k]);
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
  
  private static void azC()
  {
    AppMethodBeat.i(148627);
    ad.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    a.azC();
    AppMethodBeat.o(148627);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148618);
    this.hFi = inflate(paramContext, 2131495870, this);
    this.hFk = ((WeImageButton)this.hFi.findViewById(2131306533));
    this.hFo = this.hFi.findViewById(2131306531);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(148618);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(148625);
    if (this.hFk != null) {
      this.hFk.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(148625);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(148622);
    if (paramBoolean)
    {
      this.hFk.setBackgroundResource(2131234499);
      this.hFp = ((AnimationDrawable)this.hFk.getBackground());
      if (this.hFp != null)
      {
        this.hFp.start();
        AppMethodBeat.o(148622);
      }
    }
    else
    {
      this.hFk.setBackgroundResource(2131234522);
    }
    AppMethodBeat.o(148622);
  }
  
  public final void aDZ()
  {
    AppMethodBeat.i(148620);
    ad.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.hFj != null) {
        this.hFj.aEe();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.hFn != null) {
        this.hFn.eI(false);
      }
    }
    azC();
    if (this.hFq != null) {
      this.hFq.cancel();
    }
    if (this.hFy != null) {
      this.hFy.stopTimer();
    }
    AppMethodBeat.o(148620);
  }
  
  final void eH(boolean paramBoolean)
  {
    AppMethodBeat.i(148626);
    k localk;
    if (paramBoolean)
    {
      ad.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      a.azB();
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
        ad.printErrStackTrace("MicroMsg.VoiceSearchLayout", localException, "", new Object[0]);
        localk.release();
        AppMethodBeat.o(148626);
      }
      azC();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131690958"));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148619);
    if (!this.hFl)
    {
      ad.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        aDZ();
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
    this.hFl = false;
    this.hFk.setBackgroundResource(2131234522);
    AppMethodBeat.o(148621);
  }
  
  public void setOnSearchListener(a parama)
  {
    this.hFj = parama;
  }
  
  public void setOnVisibleChangeListener(VoiceSearchLayout.b paramb)
  {
    this.hFn = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(148624);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.hFo.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.hFo.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(148624);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(148623);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.hFr))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772048);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.hFn != null)
      {
        localObject = this.hFn;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((VoiceSearchLayout.b)localObject).eI(bool);
      AppMethodBeat.o(148623);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772047);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void aEd();
    
    public abstract void aEe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */