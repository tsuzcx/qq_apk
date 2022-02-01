package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavVideoView
  extends RelativeLayout
  implements View.OnClickListener, h.a
{
  public boolean WD;
  private String dkb;
  private String gjt;
  private ProgressBar kuP;
  private h nAZ;
  private av nBf;
  private ap nzT;
  public LinearLayout qiO;
  private ImageView qir;
  private boolean qiu;
  private TextView qmi;
  private View qmj;
  private ImageView qmk;
  private VideoPlayerSeekBar qml;
  private RelativeLayout qmm;
  private boolean qmn;
  private boolean qmo;
  private int qmp;
  private int qmq;
  private boolean qmr;
  private MMPinProgressBtn qms;
  private int qmt;
  private b qmu;
  av qmv;
  private b qmw;
  private a qmx;
  
  public FavVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FavVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FavVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107576);
    this.nzT = new ap(Looper.getMainLooper());
    this.qmn = false;
    this.qmo = false;
    this.qmp = 0;
    this.qiu = false;
    this.qmq = 0;
    this.WD = false;
    this.qmr = false;
    this.dkb = "";
    this.qmt = 0;
    this.nBf = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107561);
        FavVideoView.a(FavVideoView.this, FavVideoView.this.getPalyPosition());
        int i = Math.max(0, FavVideoView.a(FavVideoView.this) / 1000);
        FavVideoView.b(FavVideoView.this).seek(i);
        AppMethodBeat.o(107561);
        return true;
      }
    }, true);
    this.qmv = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107563);
        if (FavVideoView.c(FavVideoView.this)) {
          FavVideoView.this.cjY();
        }
        AppMethodBeat.o(107563);
        return false;
      }
    }, false);
    this.qmw = new b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(107564);
        FavVideoView.this.ckd();
        FavVideoView.this.qmv.stopTimer();
        AppMethodBeat.o(107564);
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(107565);
        if (!FavVideoView.this.isPlaying())
        {
          FavVideoView.d(FavVideoView.this).av(500L, 500L);
          FavVideoView.this.setVideoStateIv(false);
        }
        FavVideoView.this.seek(paramAnonymousInt);
        FavVideoView.this.cke();
        AppMethodBeat.o(107565);
      }
    };
    this.qmx = new a((byte)0);
    ad.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131493985, this);
    this.qir = ((ImageView)findViewById(2131306398));
    paramAttributeSet = (RelativeLayout)findViewById(2131300914);
    ((TextView)findViewById(2131306332)).setVisibility(8);
    this.qms = ((MMPinProgressBtn)findViewById(2131306379));
    this.kuP = ((ProgressBar)findViewById(2131306352));
    this.qiO = ((LinearLayout)findViewById(2131299788));
    this.qmk = ((ImageView)findViewById(2131306316));
    this.qmm = ((RelativeLayout)findViewById(2131298875));
    this.qmj = findViewById(2131306342);
    this.qml = ((VideoPlayerSeekBar)findViewById(2131306375));
    this.qmi = ((TextView)findViewById(2131306403));
    if (com.tencent.mm.modelcontrol.d.axf()) {
      this.qmo = true;
    }
    for (this.nAZ = new VideoPlayerTextureView(paramContext);; this.nAZ = new VideoTextureView(paramContext))
    {
      this.nAZ.setVideoCallback(this);
      cjY();
      setVideoStateIv(true);
      this.qml.setIplaySeekCallback(this.qmw);
      this.qml.setPlayBtnOnClickListener(this);
      this.qmk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107566);
          if (FavVideoView.e(FavVideoView.this) != null) {
            FavVideoView.e(FavVideoView.this).finish();
          }
          AppMethodBeat.o(107566);
        }
      });
      this.qml.setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.nAZ, paramContext);
      ((a)g.ad(a.class)).getRecordMsgCDNStorage().a(this.qmx);
      ((af)g.ad(af.class)).getFavCdnStorage().a(this.qmx);
      boolean bool = ai.ju(getContext());
      paramInt = ai.eb(getContext());
      ad.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if (bool)
      {
        paramContext = new RelativeLayout.LayoutParams(this.qmj.getLayoutParams());
        paramContext.addRule(12);
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramInt);
        this.qmm.setLayoutParams(paramContext);
      }
      AppMethodBeat.o(107576);
      return;
      this.qmo = false;
    }
  }
  
  private void ckc()
  {
    AppMethodBeat.i(107588);
    if ((!bt.isNullOrNil(this.gjt)) && (com.tencent.mm.vfs.i.eK(this.gjt)))
    {
      ad.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      YI(this.gjt);
      AppMethodBeat.o(107588);
      return;
    }
    ad.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    kL(false);
    AppMethodBeat.o(107588);
  }
  
  private static boolean ckf()
  {
    AppMethodBeat.i(107593);
    boolean bool = g.afB().afk().getBoolean(ae.a.FnJ, false);
    AppMethodBeat.o(107593);
    return bool;
  }
  
  private void kL(final boolean paramBoolean)
  {
    AppMethodBeat.i(107587);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107567);
        ad.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[] { Boolean.valueOf(paramBoolean) });
        View localView = (View)FavVideoView.f(FavVideoView.this);
        if (paramBoolean)
        {
          localView.setAlpha(1.0F);
          localView.setVisibility(0);
          FavVideoView.g(FavVideoView.this).setVisibility(8);
          FavVideoView.b(FavVideoView.this).setVideoTotalTime(FavVideoView.f(FavVideoView.this).getDuration() / 1000);
          AppMethodBeat.o(107567);
          return;
        }
        localView.setVisibility(8);
        FavVideoView.g(FavVideoView.this).setVisibility(0);
        AppMethodBeat.o(107567);
      }
    });
    AppMethodBeat.o(107587);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(107600);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107571);
        if ((FavVideoView.i(FavVideoView.this) != null) && (FavVideoView.i(FavVideoView.this).getVisibility() != 0)) {
          FavVideoView.i(FavVideoView.this).setVisibility(0);
        }
        if ((FavVideoView.j(FavVideoView.this) != null) && (FavVideoView.j(FavVideoView.this).getVisibility() != 8)) {
          FavVideoView.j(FavVideoView.this).setVisibility(8);
        }
        AppMethodBeat.o(107571);
      }
    });
    AppMethodBeat.o(107600);
  }
  
  public final void YI(String paramString)
  {
    AppMethodBeat.i(107594);
    ad.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(107594);
      return;
    }
    if (this.nAZ != null)
    {
      if ((this.nAZ instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.nAZ).setNeedResetExtractor(ckf());
      }
      ((View)this.nAZ).setVisibility(0);
      ((View)this.nAZ).setAlpha(0.0F);
      this.qir.setVisibility(0);
      this.nAZ.setVideoPath(paramString);
    }
    if (((Integer)g.afB().afk().get(ae.a.Fmr, Integer.valueOf(0))).intValue() == 1)
    {
      this.qmi.setText(com.tencent.mm.plugin.sight.base.e.ahc(paramString));
      this.qmi.setVisibility(0);
    }
    AppMethodBeat.o(107594);
  }
  
  public final void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(107577);
    this.gjt = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.dkb = paramString2;
    }
    AppMethodBeat.o(107577);
  }
  
  public final void cjX()
  {
    AppMethodBeat.i(107582);
    if (!this.WD)
    {
      ad.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
      AppMethodBeat.o(107582);
      return;
    }
    if (this.qmr)
    {
      cjY();
      AppMethodBeat.o(107582);
      return;
    }
    cjZ();
    AppMethodBeat.o(107582);
  }
  
  public final void cjY()
  {
    AppMethodBeat.i(107583);
    ad.i("MicroMsg.FavVideoView", "hide video tool bar");
    this.qmj.setVisibility(8);
    this.qmk.setVisibility(8);
    this.qmr = false;
    AppMethodBeat.o(107583);
  }
  
  public final void cjZ()
  {
    AppMethodBeat.i(107584);
    ad.i("MicroMsg.FavVideoView", "show video tool bar");
    this.qmj.setVisibility(0);
    this.qmk.setVisibility(0);
    this.qmr = true;
    cke();
    AppMethodBeat.o(107584);
  }
  
  public final void cka()
  {
    AppMethodBeat.i(107585);
    ckd();
    this.nBf.stopTimer();
    setVideoStateIv(true);
    this.qmv.stopTimer();
    AppMethodBeat.o(107585);
  }
  
  public final void ckb()
  {
    AppMethodBeat.i(107586);
    seek(this.qml.getmPosition());
    this.nBf.av(500L, 500L);
    setVideoStateIv(false);
    cke();
    AppMethodBeat.o(107586);
  }
  
  public final void ckd()
  {
    AppMethodBeat.i(107589);
    if (this.nAZ.isPlaying())
    {
      ad.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      this.nAZ.pause();
    }
    AppMethodBeat.o(107589);
  }
  
  protected final void cke()
  {
    AppMethodBeat.i(107592);
    if (this.qmr) {
      this.qmv.av(4000L, 4000L);
    }
    AppMethodBeat.o(107592);
  }
  
  public final void dY(int paramInt1, int paramInt2) {}
  
  public final int eM(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getPalyPosition()
  {
    AppMethodBeat.i(107596);
    int i = this.nAZ.getCurrentPosition();
    AppMethodBeat.o(107596);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107590);
    if (this.nAZ == null)
    {
      AppMethodBeat.o(107590);
      return false;
    }
    boolean bool = this.nAZ.isPlaying();
    AppMethodBeat.o(107590);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107581);
    if (paramView.getId() == 2131303281)
    {
      ad.i("MicroMsg.FavVideoView", "toggle video");
      if (isPlaying())
      {
        cka();
        AppMethodBeat.o(107581);
        return;
      }
      ckb();
    }
    AppMethodBeat.o(107581);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(107598);
    ad.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.lh(18)) || (!this.qmo))
    {
      seek(0);
      AppMethodBeat.o(107598);
      return;
    }
    if (this.nAZ != null) {
      this.nAZ.stop();
    }
    AppMethodBeat.o(107598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107580);
    ad.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    this.nBf.stopTimer();
    this.qmv.stopTimer();
    this.qmv.stopTimer();
    try
    {
      ((a)g.ad(a.class)).getRecordMsgCDNStorage().b(this.qmx);
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.qmx);
      this.nAZ.stop();
      AppMethodBeat.o(107580);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.FavVideoView", "onDestroy() %s %s", new Object[] { localThrowable.getClass().getSimpleName(), localThrowable.getMessage() });
      AppMethodBeat.o(107580);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107599);
    ad.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.qmo) });
    if (this.qiu)
    {
      onCompletion();
      AppMethodBeat.o(107599);
      return;
    }
    this.qmp = paramInt2;
    String str = this.nAZ.getVideoPath();
    this.nAZ.stop();
    this.qmn = true;
    kL(false);
    if (this.qmp == -1)
    {
      this.qmt += 1;
      if (this.qmt <= 3)
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107568);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.YI(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107568);
          }
        });
        AppMethodBeat.o(107599);
        return;
      }
    }
    if ((!bt.isNullOrNil(str)) && (com.tencent.mm.vfs.i.eK(str)))
    {
      ad.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.nzT.post(new FavVideoView.8(this, str));
    }
    AppMethodBeat.o(107599);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107579);
    ad.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.qmn) {
      ckc();
    }
    AppMethodBeat.o(107579);
  }
  
  public final void rq()
  {
    AppMethodBeat.i(107597);
    this.qmp = 0;
    this.WD = true;
    kL(true);
    this.qiu = this.nAZ.start();
    int i = this.nAZ.getDuration() / 1000;
    this.nBf.av(500L, 500L);
    setVideoStateIv(false);
    ad.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(107597);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(107595);
    ad.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(paramInt) });
    this.nAZ.q(paramInt * 1000);
    AppMethodBeat.o(107595);
  }
  
  public void setCallback(b paramb)
  {
    this.qmu = paramb;
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(107578);
    this.qir.setImageBitmap(BackwardSupportUtil.b.n(paramString, 1.0F));
    AppMethodBeat.o(107578);
  }
  
  public void setVideoData(String paramString)
  {
    this.gjt = paramString;
  }
  
  public void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(107591);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = this.qml;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localVideoPlayerSeekBar.setIsPlay(paramBoolean);
        AppMethodBeat.o(107591);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FavVideoView", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(107591);
    }
  }
  
  final class a
    implements p, com.tencent.mm.plugin.record.a.d
  {
    private a() {}
    
    private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(107575);
      ad.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (((paramInt1 == 3) || (paramInt1 == 2)) && (com.tencent.mm.vfs.i.eK(paramString)))
      {
        FavVideoView.f(FavVideoView.this).stop();
        FavVideoView.l(FavVideoView.this);
        FavVideoView.a(FavVideoView.this, paramString);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107572);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.YI(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107572);
          }
        });
        AppMethodBeat.o(107575);
        return;
      }
      FavVideoView.a(FavVideoView.this, paramInt2, paramInt3);
      AppMethodBeat.o(107575);
    }
    
    public final void a(int paramInt, com.tencent.mm.plugin.record.a.i parami)
    {
      AppMethodBeat.i(107574);
      if (parami == null)
      {
        AppMethodBeat.o(107574);
        return;
      }
      if (!parami.field_dataId.equals(FavVideoView.k(FavVideoView.this)))
      {
        AppMethodBeat.o(107574);
        return;
      }
      a(parami.field_status, parami.field_path, parami.field_offset, parami.field_totalLen);
      AppMethodBeat.o(107574);
    }
    
    public final void e(c paramc)
    {
      AppMethodBeat.i(107573);
      if (paramc == null)
      {
        AppMethodBeat.o(107573);
        return;
      }
      if ((bt.isNullOrNil(paramc.field_dataId)) || (!paramc.field_dataId.equals(FavVideoView.k(FavVideoView.this))))
      {
        AppMethodBeat.o(107573);
        return;
      }
      a(paramc.field_status, paramc.field_path, paramc.field_offset, paramc.field_totalLen);
      AppMethodBeat.o(107573);
    }
  }
  
  public static abstract interface b
  {
    public abstract void finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView
 * JD-Core Version:    0.7.0.1
 */