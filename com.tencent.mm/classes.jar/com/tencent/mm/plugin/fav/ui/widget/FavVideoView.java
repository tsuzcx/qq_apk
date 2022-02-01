package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public class FavVideoView
  extends RelativeLayout
  implements View.OnClickListener, i.a
{
  private ImageView AlJ;
  private boolean AlM;
  public LinearLayout Amf;
  private TextView ApV;
  private View ApW;
  private ImageView ApX;
  private VideoPlayerSeekBar ApY;
  private RelativeLayout ApZ;
  private boolean Aqa;
  private boolean Aqb;
  private int Aqc;
  private int Aqd;
  private boolean Aqe;
  private MMPinProgressBtn Aqf;
  private int Aqg;
  private FavVideoView.b Aqh;
  MTimerHandler Aqi;
  private com.tencent.mm.plugin.sight.decode.ui.b Aqj;
  private a Aqk;
  private String fullPath;
  private String hIQ;
  public boolean hS;
  private ProgressBar sIX;
  private MMHandler wAW;
  private i wCd;
  private MTimerHandler wCj;
  
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
    this.wAW = new MMHandler(Looper.getMainLooper());
    this.Aqa = false;
    this.Aqb = false;
    this.Aqc = 0;
    this.AlM = false;
    this.Aqd = 0;
    this.hS = false;
    this.Aqe = false;
    this.hIQ = "";
    this.Aqg = 0;
    this.wCj = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.Aqi = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107563);
        if (FavVideoView.c(FavVideoView.this)) {
          FavVideoView.this.dSU();
        }
        AppMethodBeat.o(107563);
        return false;
      }
    }, false);
    this.Aqj = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc()
      {
        AppMethodBeat.i(107564);
        FavVideoView.this.bck();
        FavVideoView.this.Aqi.stopTimer();
        AppMethodBeat.o(107564);
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(107565);
        if (!FavVideoView.this.isPlaying())
        {
          FavVideoView.d(FavVideoView.this).startTimer(500L);
          FavVideoView.this.setVideoStateIv(false);
        }
        FavVideoView.this.seek(paramAnonymousInt);
        FavVideoView.this.dSZ();
        AppMethodBeat.o(107565);
      }
      
      public final void tT(int paramAnonymousInt) {}
    };
    this.Aqk = new a((byte)0);
    Log.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(q.f.fav_video_view, this);
    this.AlJ = ((ImageView)findViewById(q.e.video_thumb));
    paramAttributeSet = (RelativeLayout)findViewById(q.e.image);
    ((TextView)findViewById(q.e.video_duration)).setVisibility(8);
    this.Aqf = ((MMPinProgressBtn)findViewById(q.e.video_progress));
    this.sIX = ((ProgressBar)findViewById(q.e.video_loading));
    this.Amf = ((LinearLayout)findViewById(q.e.fav_expired_btn));
    this.ApX = ((ImageView)findViewById(q.e.video_close_btn));
    this.ApZ = ((RelativeLayout)findViewById(q.e.cropimage_function_bar));
    this.ApW = findViewById(q.e.video_footer_root);
    this.ApY = ((VideoPlayerSeekBar)findViewById(q.e.video_player_seek_bar));
    this.ApV = ((TextView)findViewById(q.e.video_tips));
    if (com.tencent.mm.modelcontrol.e.bIv()) {
      this.Aqb = true;
    }
    for (this.wCd = new VideoPlayerTextureView(paramContext);; this.wCd = new VideoTextureView(paramContext))
    {
      this.wCd.setVideoCallback(this);
      dSU();
      setVideoStateIv(true);
      this.ApY.setIplaySeekCallback(this.Aqj);
      this.ApY.setPlayBtnOnClickListener(this);
      this.ApX.setOnClickListener(new FavVideoView.5(this));
      this.ApY.setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.wCd, paramContext);
      ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.Aqk);
      ((ah)h.az(ah.class)).getFavCdnStorage().a(this.Aqk);
      boolean bool = aw.bg(getContext());
      paramInt = aw.bk(getContext());
      Log.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if (bool)
      {
        paramContext = new RelativeLayout.LayoutParams(this.ApW.getLayoutParams());
        paramContext.addRule(12);
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramInt);
        this.ApZ.setLayoutParams(paramContext);
      }
      AppMethodBeat.o(107576);
      return;
      this.Aqb = false;
    }
  }
  
  private void dSY()
  {
    AppMethodBeat.i(107588);
    if ((!Util.isNullOrNil(this.fullPath)) && (y.ZC(this.fullPath)))
    {
      Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      auJ(this.fullPath);
      AppMethodBeat.o(107588);
      return;
    }
    Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    py(false);
    AppMethodBeat.o(107588);
  }
  
  private static boolean dTa()
  {
    AppMethodBeat.i(107593);
    boolean bool = h.baE().ban().getBoolean(at.a.acPO, false);
    AppMethodBeat.o(107593);
    return bool;
  }
  
  private void py(final boolean paramBoolean)
  {
    AppMethodBeat.i(107587);
    this.wAW.post(new Runnable()
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
    this.wAW.post(new Runnable()
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
  
  public final void Qz()
  {
    AppMethodBeat.i(107597);
    this.Aqc = 0;
    this.hS = true;
    py(true);
    this.AlM = this.wCd.start();
    int i = this.wCd.getDuration() / 1000;
    this.wCj.startTimer(500L);
    setVideoStateIv(false);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(107597);
  }
  
  public final void auJ(String paramString)
  {
    AppMethodBeat.i(107594);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(107594);
      return;
    }
    if (this.wCd != null)
    {
      if ((this.wCd instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.wCd).setNeedResetExtractor(dTa());
      }
      ((View)this.wCd).setVisibility(0);
      ((View)this.wCd).setAlpha(0.0F);
      this.AlJ.setVisibility(0);
      this.wCd.setVideoPath(paramString);
    }
    if (((Integer)h.baE().ban().get(at.a.acOt, Integer.valueOf(0))).intValue() == 1)
    {
      this.ApV.setText(com.tencent.mm.plugin.sight.base.f.aMu(paramString));
      this.ApV.setVisibility(0);
    }
    AppMethodBeat.o(107594);
  }
  
  public final void bck()
  {
    AppMethodBeat.i(107589);
    if (this.wCd.isPlaying())
    {
      Log.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      this.wCd.pause();
    }
    AppMethodBeat.o(107589);
  }
  
  public final void dST()
  {
    AppMethodBeat.i(107582);
    if (!this.hS)
    {
      Log.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
      AppMethodBeat.o(107582);
      return;
    }
    if (this.Aqe)
    {
      dSU();
      AppMethodBeat.o(107582);
      return;
    }
    dSV();
    AppMethodBeat.o(107582);
  }
  
  public final void dSU()
  {
    AppMethodBeat.i(107583);
    Log.i("MicroMsg.FavVideoView", "hide video tool bar");
    this.ApW.setVisibility(8);
    this.ApX.setVisibility(8);
    this.Aqe = false;
    AppMethodBeat.o(107583);
  }
  
  public final void dSV()
  {
    AppMethodBeat.i(107584);
    Log.i("MicroMsg.FavVideoView", "show video tool bar");
    this.ApW.setVisibility(0);
    this.ApX.setVisibility(0);
    this.Aqe = true;
    dSZ();
    AppMethodBeat.o(107584);
  }
  
  public final void dSW()
  {
    AppMethodBeat.i(107585);
    bck();
    this.wCj.stopTimer();
    setVideoStateIv(true);
    this.Aqi.stopTimer();
    AppMethodBeat.o(107585);
  }
  
  public final void dSX()
  {
    AppMethodBeat.i(107586);
    seek(this.ApY.getmPosition());
    this.wCj.startTimer(500L);
    setVideoStateIv(false);
    dSZ();
    AppMethodBeat.o(107586);
  }
  
  protected final void dSZ()
  {
    AppMethodBeat.i(107592);
    if (this.Aqe) {
      this.Aqi.startTimer(4000L);
    }
    AppMethodBeat.o(107592);
  }
  
  public final void e(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(107577);
    this.fullPath = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.hIQ = paramString2;
    }
    AppMethodBeat.o(107577);
  }
  
  public final void fG(int paramInt1, int paramInt2) {}
  
  public int getPalyPosition()
  {
    AppMethodBeat.i(107596);
    int i = this.wCd.getCurrentPosition();
    AppMethodBeat.o(107596);
    return i;
  }
  
  public final int gw(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107590);
    if (this.wCd == null)
    {
      AppMethodBeat.o(107590);
      return false;
    }
    boolean bool = this.wCd.isPlaying();
    AppMethodBeat.o(107590);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107581);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == q.e.play_btn)
    {
      Log.i("MicroMsg.FavVideoView", "toggle video");
      if (!isPlaying()) {
        break label91;
      }
      dSW();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(107581);
      return;
      label91:
      dSX();
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(107598);
    Log.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.rd(18)) || (!this.Aqb))
    {
      seek(0);
      AppMethodBeat.o(107598);
      return;
    }
    if (this.wCd != null) {
      this.wCd.stop();
    }
    AppMethodBeat.o(107598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107580);
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    this.wCj.stopTimer();
    this.Aqi.stopTimer();
    this.Aqi.stopTimer();
    try
    {
      ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.Aqk);
      ((ah)h.az(ah.class)).getFavCdnStorage().b(this.Aqk);
      this.wCd.stop();
      AppMethodBeat.o(107580);
      return;
    }
    finally
    {
      Log.e("MicroMsg.FavVideoView", "onDestroy() %s %s", new Object[] { localObject.getClass().getSimpleName(), localObject.getMessage() });
      AppMethodBeat.o(107580);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107599);
    Log.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.Aqb) });
    if (this.AlM)
    {
      onCompletion();
      AppMethodBeat.o(107599);
      return;
    }
    this.Aqc = paramInt2;
    final String str = this.wCd.getVideoPath();
    this.wCd.stop();
    this.Aqa = true;
    py(false);
    if (this.Aqc == -1)
    {
      this.Aqg += 1;
      if (this.Aqg <= 3)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107568);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.auJ(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107568);
          }
        });
        AppMethodBeat.o(107599);
        return;
      }
    }
    if ((!Util.isNullOrNil(str)) && (y.ZC(str)))
    {
      Log.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.wAW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107569);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          FileProviderHelper.setIntentDataAndType(FavVideoView.this.getContext(), (Intent)localObject, new u(str), "video/*", false);
          try
          {
            Context localContext = FavVideoView.this.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(107569);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
            k.s(FavVideoView.this.getContext(), q.i.favorite_no_match_msg, q.i.favorite_no_match_title);
            AppMethodBeat.o(107569);
          }
        }
      });
    }
    AppMethodBeat.o(107599);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107579);
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.Aqa) {
      dSY();
    }
    AppMethodBeat.o(107579);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(107595);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(paramInt) });
    this.wCd.H(paramInt * 1000);
    AppMethodBeat.o(107595);
  }
  
  public void setCallback(FavVideoView.b paramb)
  {
    this.Aqh = paramb;
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(107578);
    this.AlJ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F));
    AppMethodBeat.o(107578);
  }
  
  public void setVideoData(String paramString)
  {
    this.fullPath = paramString;
  }
  
  public void setVideoScaleType(i.e parame)
  {
    AppMethodBeat.i(274554);
    if (this.wCd != null)
    {
      if ((this.wCd instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.wCd).setScaleType(parame);
        AppMethodBeat.o(274554);
        return;
      }
      if ((this.wCd instanceof VideoTextureView)) {
        ((VideoTextureView)this.wCd).setScaleType(parame);
      }
    }
    AppMethodBeat.o(274554);
  }
  
  public void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(107591);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = this.ApY;
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
  
  final class a
    implements q, com.tencent.mm.plugin.record.a.d
  {
    private a() {}
    
    private void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(107575);
      Log.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (((paramInt1 == 3) || (paramInt1 == 2)) && (y.ZC(paramString)))
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
              FavVideoView.this.auJ(FavVideoView.h(FavVideoView.this));
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
    
    public final void a(int paramInt, j paramj)
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
      b(paramj.field_status, paramj.field_path, paramj.field_offset, paramj.field_totalLen);
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
      b(paramc.field_status, paramc.field_path, paramc.field_offset, paramc.field_totalLen);
      AppMethodBeat.o(107573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView
 * JD-Core Version:    0.7.0.1
 */