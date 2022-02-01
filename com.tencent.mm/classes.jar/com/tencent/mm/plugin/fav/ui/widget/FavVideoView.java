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
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.s;

public class FavVideoView
  extends RelativeLayout
  implements View.OnClickListener, j.a
{
  public boolean ZA;
  private String dLl;
  private String fullPath;
  private ProgressBar mEz;
  private MMHandler qaC;
  private com.tencent.mm.pluginsdk.ui.tools.j qbJ;
  private MTimerHandler qbP;
  private ImageView tiQ;
  private boolean tiT;
  public LinearLayout tjm;
  private TextView tmU;
  private View tmV;
  private ImageView tmW;
  private VideoPlayerSeekBar tmX;
  private RelativeLayout tmY;
  private boolean tmZ;
  private boolean tna;
  private int tnb;
  private int tnc;
  private boolean tnd;
  private MMPinProgressBtn tne;
  private int tnf;
  private b tng;
  MTimerHandler tnh;
  private com.tencent.mm.plugin.sight.decode.ui.b tni;
  private a tnj;
  
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
    this.qaC = new MMHandler(Looper.getMainLooper());
    this.tmZ = false;
    this.tna = false;
    this.tnb = 0;
    this.tiT = false;
    this.tnc = 0;
    this.ZA = false;
    this.tnd = false;
    this.dLl = "";
    this.tnf = 0;
    this.qbP = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.tnh = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107563);
        if (FavVideoView.c(FavVideoView.this)) {
          FavVideoView.this.cWV();
        }
        AppMethodBeat.o(107563);
        return false;
      }
    }, false);
    this.tni = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(107564);
        FavVideoView.this.cXa();
        FavVideoView.this.tnh.stopTimer();
        AppMethodBeat.o(107564);
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(107565);
        if (!FavVideoView.this.isPlaying())
        {
          FavVideoView.d(FavVideoView.this).startTimer(500L);
          FavVideoView.this.setVideoStateIv(false);
        }
        FavVideoView.this.seek(paramAnonymousInt);
        FavVideoView.this.cXb();
        AppMethodBeat.o(107565);
      }
    };
    this.tnj = new a((byte)0);
    Log.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131494155, this);
    this.tiQ = ((ImageView)findViewById(2131309829));
    paramAttributeSet = (RelativeLayout)findViewById(2131302526);
    ((TextView)findViewById(2131309754)).setVisibility(8);
    this.tne = ((MMPinProgressBtn)findViewById(2131309808));
    this.mEz = ((ProgressBar)findViewById(2131309778));
    this.tjm = ((LinearLayout)findViewById(2131300461));
    this.tmW = ((ImageView)findViewById(2131309735));
    this.tmY = ((RelativeLayout)findViewById(2131299350));
    this.tmV = findViewById(2131309767);
    this.tmX = ((VideoPlayerSeekBar)findViewById(2131309804));
    this.tmU = ((TextView)findViewById(2131309834));
    if (com.tencent.mm.modelcontrol.e.bbm()) {
      this.tna = true;
    }
    for (this.qbJ = new VideoPlayerTextureView(paramContext);; this.qbJ = new VideoTextureView(paramContext))
    {
      this.qbJ.setVideoCallback(this);
      cWV();
      setVideoStateIv(true);
      this.tmX.setIplaySeekCallback(this.tni);
      this.tmX.setPlayBtnOnClickListener(this);
      this.tmW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (FavVideoView.e(FavVideoView.this) != null) {
            FavVideoView.e(FavVideoView.this).finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107566);
        }
      });
      this.tmX.setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.qbJ, paramContext);
      ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.tnj);
      ((af)g.ah(af.class)).getFavCdnStorage().a(this.tnj);
      boolean bool = com.tencent.mm.ui.ao.aA(getContext());
      paramInt = com.tencent.mm.ui.ao.aD(getContext());
      Log.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if (bool)
      {
        paramContext = new RelativeLayout.LayoutParams(this.tmV.getLayoutParams());
        paramContext.addRule(12);
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramInt);
        this.tmY.setLayoutParams(paramContext);
      }
      AppMethodBeat.o(107576);
      return;
      this.tna = false;
    }
  }
  
  private void cWZ()
  {
    AppMethodBeat.i(107588);
    if ((!Util.isNullOrNil(this.fullPath)) && (s.YS(this.fullPath)))
    {
      Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      asy(this.fullPath);
      AppMethodBeat.o(107588);
      return;
    }
    Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    mK(false);
    AppMethodBeat.o(107588);
  }
  
  private static boolean cXc()
  {
    AppMethodBeat.i(107593);
    boolean bool = g.aAh().azQ().getBoolean(ar.a.Oaq, false);
    AppMethodBeat.o(107593);
    return bool;
  }
  
  private void mK(final boolean paramBoolean)
  {
    AppMethodBeat.i(107587);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107567);
        Log.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[] { Boolean.valueOf(paramBoolean) });
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
    this.qaC.post(new Runnable()
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
  
  public final void asy(String paramString)
  {
    AppMethodBeat.i(107594);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(107594);
      return;
    }
    if (this.qbJ != null)
    {
      if ((this.qbJ instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.qbJ).setNeedResetExtractor(cXc());
      }
      ((View)this.qbJ).setVisibility(0);
      ((View)this.qbJ).setAlpha(0.0F);
      this.tiQ.setVisibility(0);
      this.qbJ.setVideoPath(paramString);
    }
    if (((Integer)g.aAh().azQ().get(ar.a.NYY, Integer.valueOf(0))).intValue() == 1)
    {
      this.tmU.setText(com.tencent.mm.plugin.sight.base.e.aFm(paramString));
      this.tmU.setVisibility(0);
    }
    AppMethodBeat.o(107594);
  }
  
  public final void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(107577);
    this.fullPath = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.dLl = paramString2;
    }
    AppMethodBeat.o(107577);
  }
  
  public final void cWU()
  {
    AppMethodBeat.i(107582);
    if (!this.ZA)
    {
      Log.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
      AppMethodBeat.o(107582);
      return;
    }
    if (this.tnd)
    {
      cWV();
      AppMethodBeat.o(107582);
      return;
    }
    cWW();
    AppMethodBeat.o(107582);
  }
  
  public final void cWV()
  {
    AppMethodBeat.i(107583);
    Log.i("MicroMsg.FavVideoView", "hide video tool bar");
    this.tmV.setVisibility(8);
    this.tmW.setVisibility(8);
    this.tnd = false;
    AppMethodBeat.o(107583);
  }
  
  public final void cWW()
  {
    AppMethodBeat.i(107584);
    Log.i("MicroMsg.FavVideoView", "show video tool bar");
    this.tmV.setVisibility(0);
    this.tmW.setVisibility(0);
    this.tnd = true;
    cXb();
    AppMethodBeat.o(107584);
  }
  
  public final void cWX()
  {
    AppMethodBeat.i(107585);
    cXa();
    this.qbP.stopTimer();
    setVideoStateIv(true);
    this.tnh.stopTimer();
    AppMethodBeat.o(107585);
  }
  
  public final void cWY()
  {
    AppMethodBeat.i(107586);
    seek(this.tmX.getmPosition());
    this.qbP.startTimer(500L);
    setVideoStateIv(false);
    cXb();
    AppMethodBeat.o(107586);
  }
  
  public final void cXa()
  {
    AppMethodBeat.i(107589);
    if (this.qbJ.isPlaying())
    {
      Log.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      this.qbJ.pause();
    }
    AppMethodBeat.o(107589);
  }
  
  protected final void cXb()
  {
    AppMethodBeat.i(107592);
    if (this.tnd) {
      this.tnh.startTimer(4000L);
    }
    AppMethodBeat.o(107592);
  }
  
  public final void eo(int paramInt1, int paramInt2) {}
  
  public final int fh(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getPalyPosition()
  {
    AppMethodBeat.i(107596);
    int i = this.qbJ.getCurrentPosition();
    AppMethodBeat.o(107596);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107590);
    if (this.qbJ == null)
    {
      AppMethodBeat.o(107590);
      return false;
    }
    boolean bool = this.qbJ.isPlaying();
    AppMethodBeat.o(107590);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107581);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131305954)
    {
      Log.i("MicroMsg.FavVideoView", "toggle video");
      if (!isPlaying()) {
        break label91;
      }
      cWX();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(107581);
      return;
      label91:
      cWY();
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(107598);
    Log.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.oF(18)) || (!this.tna))
    {
      seek(0);
      AppMethodBeat.o(107598);
      return;
    }
    if (this.qbJ != null) {
      this.qbJ.stop();
    }
    AppMethodBeat.o(107598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107580);
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    this.qbP.stopTimer();
    this.tnh.stopTimer();
    this.tnh.stopTimer();
    try
    {
      ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.tnj);
      ((af)g.ah(af.class)).getFavCdnStorage().b(this.tnj);
      this.qbJ.stop();
      AppMethodBeat.o(107580);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.FavVideoView", "onDestroy() %s %s", new Object[] { localThrowable.getClass().getSimpleName(), localThrowable.getMessage() });
      AppMethodBeat.o(107580);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107599);
    Log.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.tna) });
    if (this.tiT)
    {
      onCompletion();
      AppMethodBeat.o(107599);
      return;
    }
    this.tnb = paramInt2;
    String str = this.qbJ.getVideoPath();
    this.qbJ.stop();
    this.tmZ = true;
    mK(false);
    if (this.tnb == -1)
    {
      this.tnf += 1;
      if (this.tnf <= 3)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107568);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.asy(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107568);
          }
        });
        AppMethodBeat.o(107599);
        return;
      }
    }
    if ((!Util.isNullOrNil(str)) && (s.YS(str)))
    {
      Log.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.qaC.post(new FavVideoView.8(this, str));
    }
    AppMethodBeat.o(107599);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107579);
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.tmZ) {
      cWZ();
    }
    AppMethodBeat.o(107579);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(107595);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(paramInt) });
    this.qbJ.q(paramInt * 1000);
    AppMethodBeat.o(107595);
  }
  
  public void setCallback(b paramb)
  {
    this.tng = paramb;
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(107578);
    this.tiQ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F));
    AppMethodBeat.o(107578);
  }
  
  public void setVideoData(String paramString)
  {
    this.fullPath = paramString;
  }
  
  public void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(107591);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = this.tmX;
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
      Log.e("MicroMsg.FavVideoView", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(107591);
    }
  }
  
  public final void tf()
  {
    AppMethodBeat.i(107597);
    this.tnb = 0;
    this.ZA = true;
    mK(true);
    this.tiT = this.qbJ.start();
    int i = this.qbJ.getDuration() / 1000;
    this.qbP.startTimer(500L);
    setVideoStateIv(false);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(107597);
  }
  
  final class a
    implements p, com.tencent.mm.plugin.record.a.d
  {
    private a() {}
    
    private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(107575);
      Log.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (((paramInt1 == 3) || (paramInt1 == 2)) && (s.YS(paramString)))
      {
        FavVideoView.f(FavVideoView.this).stop();
        FavVideoView.l(FavVideoView.this);
        FavVideoView.a(FavVideoView.this, paramString);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107572);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.asy(FavVideoView.h(FavVideoView.this));
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
    
    public final void a(int paramInt, com.tencent.mm.plugin.record.a.j paramj)
    {
      AppMethodBeat.i(107574);
      if (paramj == null)
      {
        AppMethodBeat.o(107574);
        return;
      }
      if (!paramj.field_dataId.equals(FavVideoView.k(FavVideoView.this)))
      {
        AppMethodBeat.o(107574);
        return;
      }
      a(paramj.field_status, paramj.field_path, paramj.field_offset, paramj.field_totalLen);
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
      if ((Util.isNullOrNil(paramc.field_dataId)) || (!paramc.field_dataId.equals(FavVideoView.k(FavVideoView.this))))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView
 * JD-Core Version:    0.7.0.1
 */