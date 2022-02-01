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
  private static final int[] izo = { 2131234544, 2131234545, 2131234546, 2131234547, 2131234524, 2131234525, 2131234526, 2131234527, 2131234528, 2131234529, 2131234530, 2131234531, 2131234532, 2131234533 };
  private static final int[] izp = { 2131234544, 2131234544, 2131234544, 2131234545, 2131234546, 2131234545, 2131234544, 2131234547, 2131234544, 2131234544 };
  private static final int[] izq = { 2131234534, 2131234543, 2131234543, 2131234543, 2131234534 };
  private int from;
  boolean isStart;
  private View ize;
  a izf;
  private WeImageButton izg;
  boolean izh;
  int izi;
  private VoiceSearchLayout.b izj;
  private View izk;
  private AnimationDrawable izl;
  f izm;
  private boolean izn;
  private int izr;
  private int izs;
  int izt;
  final av izu;
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148617);
    this.ize = null;
    this.izf = null;
    this.isStart = false;
    this.izh = false;
    this.izi = 0;
    this.izn = false;
    this.from = 0;
    this.izr = 0;
    this.izs = 0;
    this.izt = 0;
    this.izu = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aOa().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOa()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ad.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.ixX);
        int i = localf.ixX;
        localf.ixX = 0;
        if (i > f.diF) {
          f.diF = i;
        }
        ad.d("getMaxAmplitude", " map: " + i + " max:" + f.diF + " per:" + i * 100 / f.diF);
        i = i * 100 / f.diF;
        ad.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aOb().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOb()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aOc().length) {
            i = VoiceSearchLayout.aOc().length - 1;
          }
          ad.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOc()[k]);
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
    this.ize = null;
    this.izf = null;
    this.isStart = false;
    this.izh = false;
    this.izi = 0;
    this.izn = false;
    this.from = 0;
    this.izr = 0;
    this.izs = 0;
    this.izt = 0;
    this.izu = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aOa().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOa()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ad.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.ixX);
        int i = localf.ixX;
        localf.ixX = 0;
        if (i > f.diF) {
          f.diF = i;
        }
        ad.d("getMaxAmplitude", " map: " + i + " max:" + f.diF + " per:" + i * 100 / f.diF);
        i = i * 100 / f.diF;
        ad.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aOb().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOb()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aOc().length) {
            i = VoiceSearchLayout.aOc().length - 1;
          }
          ad.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOc()[k]);
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
    this.ize = null;
    this.izf = null;
    this.isStart = false;
    this.izh = false;
    this.izi = 0;
    this.izn = false;
    this.from = 0;
    this.izr = 0;
    this.izs = 0;
    this.izt = 0;
    this.izu = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148610);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          AppMethodBeat.o(148610);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.aOa().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOa()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          AppMethodBeat.o(148610);
          return true;
        }
        f localf = VoiceSearchLayout.a(VoiceSearchLayout.this);
        ad.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.ixX);
        int i = localf.ixX;
        localf.ixX = 0;
        if (i > f.diF) {
          f.diF = i;
        }
        ad.d("getMaxAmplitude", " map: " + i + " max:" + f.diF + " per:" + i * 100 / f.diF);
        i = i * 100 / f.diF;
        ad.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.aOb().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOb()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            AppMethodBeat.o(148610);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.aOc().length) {
            i = VoiceSearchLayout.aOc().length - 1;
          }
          ad.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.aOc()[k]);
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
  
  private static void aJD()
  {
    AppMethodBeat.i(148627);
    ad.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    a.aJD();
    AppMethodBeat.o(148627);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148618);
    this.ize = inflate(paramContext, 2131495870, this);
    this.izg = ((WeImageButton)this.ize.findViewById(2131306533));
    this.izk = this.ize.findViewById(2131306531);
    setSearchStartBtnView(false);
    reset();
    AppMethodBeat.o(148618);
  }
  
  private void setAmpImage(int paramInt)
  {
    AppMethodBeat.i(148625);
    if (this.izg != null) {
      this.izg.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(148625);
  }
  
  private void setSearchStartBtnView(boolean paramBoolean)
  {
    AppMethodBeat.i(148622);
    if (paramBoolean)
    {
      this.izg.setBackgroundResource(2131234499);
      this.izl = ((AnimationDrawable)this.izg.getBackground());
      if (this.izl != null)
      {
        this.izl.start();
        AppMethodBeat.o(148622);
      }
    }
    else
    {
      this.izg.setBackgroundResource(2131234522);
    }
    AppMethodBeat.o(148622);
  }
  
  public final void aNZ()
  {
    AppMethodBeat.i(148620);
    ad.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
    if (this.isStart)
    {
      this.isStart = false;
      if (this.izf != null) {
        this.izf.aOe();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.izj != null) {
        this.izj.fe(false);
      }
    }
    aJD();
    if (this.izm != null) {
      this.izm.cancel();
    }
    if (this.izu != null) {
      this.izu.stopTimer();
    }
    AppMethodBeat.o(148620);
  }
  
  final void fd(boolean paramBoolean)
  {
    AppMethodBeat.i(148626);
    k localk;
    if (paramBoolean)
    {
      ad.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      a.aJC();
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
      aJD();
      break;
      localk.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131690958"));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148619);
    if (!this.izh)
    {
      ad.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
      if (this.isStart)
      {
        aNZ();
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
    this.izh = false;
    this.izg.setBackgroundResource(2131234522);
    AppMethodBeat.o(148621);
  }
  
  public void setOnSearchListener(a parama)
  {
    this.izf = parama;
  }
  
  public void setOnVisibleChangeListener(VoiceSearchLayout.b paramb)
  {
    this.izj = paramb;
  }
  
  public void setTopMargin(int paramInt)
  {
    AppMethodBeat.i(148624);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.izk.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.izk.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(148624);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(148623);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.izn))
    {
      if (paramInt != 8) {
        break label80;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772048);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.izj != null)
      {
        localObject = this.izj;
        if (paramInt != 0) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (boolean bool = true;; bool = false)
    {
      ((VoiceSearchLayout.b)localObject).fe(bool);
      AppMethodBeat.o(148623);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772047);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void aOd();
    
    public abstract void aOe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout
 * JD-Core Version:    0.7.0.1
 */