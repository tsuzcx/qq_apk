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
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;

public class FavVideoView
  extends RelativeLayout
  implements View.OnClickListener, k.a
{
  private String fEa;
  private String fullPath;
  public boolean gX;
  private ProgressBar pDL;
  private MMHandler twz;
  private k txH;
  private MTimerHandler txN;
  public LinearLayout wPD;
  private ImageView wPh;
  private boolean wPk;
  private int wTA;
  private boolean wTB;
  private MMPinProgressBtn wTC;
  private int wTD;
  private b wTE;
  MTimerHandler wTF;
  private com.tencent.mm.plugin.sight.decode.ui.b wTG;
  private a wTH;
  private TextView wTs;
  private View wTt;
  private ImageView wTu;
  private VideoPlayerSeekBar wTv;
  private RelativeLayout wTw;
  private boolean wTx;
  private boolean wTy;
  private int wTz;
  
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
    this.twz = new MMHandler(Looper.getMainLooper());
    this.wTx = false;
    this.wTy = false;
    this.wTz = 0;
    this.wPk = false;
    this.wTA = 0;
    this.gX = false;
    this.wTB = false;
    this.fEa = "";
    this.wTD = 0;
    this.txN = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.wTF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107563);
        if (FavVideoView.c(FavVideoView.this)) {
          FavVideoView.this.dmd();
        }
        AppMethodBeat.o(107563);
        return false;
      }
    }, false);
    this.wTG = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo()
      {
        AppMethodBeat.i(107564);
        FavVideoView.this.dmi();
        FavVideoView.this.wTF.stopTimer();
        AppMethodBeat.o(107564);
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(107565);
        if (!FavVideoView.this.isPlaying())
        {
          FavVideoView.d(FavVideoView.this).startTimer(500L);
          FavVideoView.this.setVideoStateIv(false);
        }
        FavVideoView.this.seek(paramAnonymousInt);
        FavVideoView.this.dmj();
        AppMethodBeat.o(107565);
      }
    };
    this.wTH = new a((byte)0);
    Log.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(s.f.fav_video_view, this);
    this.wPh = ((ImageView)findViewById(s.e.video_thumb));
    paramAttributeSet = (RelativeLayout)findViewById(s.e.image);
    ((TextView)findViewById(s.e.video_duration)).setVisibility(8);
    this.wTC = ((MMPinProgressBtn)findViewById(s.e.video_progress));
    this.pDL = ((ProgressBar)findViewById(s.e.video_loading));
    this.wPD = ((LinearLayout)findViewById(s.e.fav_expired_btn));
    this.wTu = ((ImageView)findViewById(s.e.video_close_btn));
    this.wTw = ((RelativeLayout)findViewById(s.e.cropimage_function_bar));
    this.wTt = findViewById(s.e.video_footer_root);
    this.wTv = ((VideoPlayerSeekBar)findViewById(s.e.video_player_seek_bar));
    this.wTs = ((TextView)findViewById(s.e.video_tips));
    if (com.tencent.mm.modelcontrol.e.bkB()) {
      this.wTy = true;
    }
    for (this.txH = new VideoPlayerTextureView(paramContext);; this.txH = new VideoTextureView(paramContext))
    {
      this.txH.setVideoCallback(this);
      dmd();
      setVideoStateIv(true);
      this.wTv.setIplaySeekCallback(this.wTG);
      this.wTv.setPlayBtnOnClickListener(this);
      this.wTu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (FavVideoView.e(FavVideoView.this) != null) {
            FavVideoView.e(FavVideoView.this).finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107566);
        }
      });
      this.wTv.setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.txH, paramContext);
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.wTH);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(this.wTH);
      boolean bool = ar.av(getContext());
      paramInt = ar.aB(getContext());
      Log.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if (bool)
      {
        paramContext = new RelativeLayout.LayoutParams(this.wTt.getLayoutParams());
        paramContext.addRule(12);
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramInt);
        this.wTw.setLayoutParams(paramContext);
      }
      AppMethodBeat.o(107576);
      return;
      this.wTy = false;
    }
  }
  
  private void dmh()
  {
    AppMethodBeat.i(107588);
    if ((!Util.isNullOrNil(this.fullPath)) && (u.agG(this.fullPath)))
    {
      Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      aAB(this.fullPath);
      AppMethodBeat.o(107588);
      return;
    }
    Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    nY(false);
    AppMethodBeat.o(107588);
  }
  
  private static boolean dmk()
  {
    AppMethodBeat.i(107593);
    boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vos, false);
    AppMethodBeat.o(107593);
    return bool;
  }
  
  private void nY(final boolean paramBoolean)
  {
    AppMethodBeat.i(107587);
    this.twz.post(new Runnable()
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
    this.twz.post(new Runnable()
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
  
  public final void aAB(String paramString)
  {
    AppMethodBeat.i(107594);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(107594);
      return;
    }
    if (this.txH != null)
    {
      if ((this.txH instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.txH).setNeedResetExtractor(dmk());
      }
      ((View)this.txH).setVisibility(0);
      ((View)this.txH).setAlpha(0.0F);
      this.wPh.setVisibility(0);
      this.txH.setVideoPath(paramString);
    }
    if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmY, Integer.valueOf(0))).intValue() == 1)
    {
      this.wTs.setText(com.tencent.mm.plugin.sight.base.f.aPw(paramString));
      this.wTs.setVisibility(0);
    }
    AppMethodBeat.o(107594);
  }
  
  public final void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(107577);
    this.fullPath = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.fEa = paramString2;
    }
    AppMethodBeat.o(107577);
  }
  
  public final void dmc()
  {
    AppMethodBeat.i(107582);
    if (!this.gX)
    {
      Log.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
      AppMethodBeat.o(107582);
      return;
    }
    if (this.wTB)
    {
      dmd();
      AppMethodBeat.o(107582);
      return;
    }
    dme();
    AppMethodBeat.o(107582);
  }
  
  public final void dmd()
  {
    AppMethodBeat.i(107583);
    Log.i("MicroMsg.FavVideoView", "hide video tool bar");
    this.wTt.setVisibility(8);
    this.wTu.setVisibility(8);
    this.wTB = false;
    AppMethodBeat.o(107583);
  }
  
  public final void dme()
  {
    AppMethodBeat.i(107584);
    Log.i("MicroMsg.FavVideoView", "show video tool bar");
    this.wTt.setVisibility(0);
    this.wTu.setVisibility(0);
    this.wTB = true;
    dmj();
    AppMethodBeat.o(107584);
  }
  
  public final void dmf()
  {
    AppMethodBeat.i(107585);
    dmi();
    this.txN.stopTimer();
    setVideoStateIv(true);
    this.wTF.stopTimer();
    AppMethodBeat.o(107585);
  }
  
  public final void dmg()
  {
    AppMethodBeat.i(107586);
    seek(this.wTv.getmPosition());
    this.txN.startTimer(500L);
    setVideoStateIv(false);
    dmj();
    AppMethodBeat.o(107586);
  }
  
  public final void dmi()
  {
    AppMethodBeat.i(107589);
    if (this.txH.isPlaying())
    {
      Log.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      this.txH.pause();
    }
    AppMethodBeat.o(107589);
  }
  
  protected final void dmj()
  {
    AppMethodBeat.i(107592);
    if (this.wTB) {
      this.wTF.startTimer(4000L);
    }
    AppMethodBeat.o(107592);
  }
  
  public final void eM(int paramInt1, int paramInt2) {}
  
  public final int fE(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getPalyPosition()
  {
    AppMethodBeat.i(107596);
    int i = this.txH.getCurrentPosition();
    AppMethodBeat.o(107596);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107590);
    if (this.txH == null)
    {
      AppMethodBeat.o(107590);
      return false;
    }
    boolean bool = this.txH.isPlaying();
    AppMethodBeat.o(107590);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107581);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.getId() == s.e.play_btn)
    {
      Log.i("MicroMsg.FavVideoView", "toggle video");
      if (!isPlaying()) {
        break label91;
      }
      dmf();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(107581);
      return;
      label91:
      dmg();
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(107598);
    Log.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.qX(18)) || (!this.wTy))
    {
      seek(0);
      AppMethodBeat.o(107598);
      return;
    }
    if (this.txH != null) {
      this.txH.stop();
    }
    AppMethodBeat.o(107598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107580);
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    this.txN.stopTimer();
    this.wTF.stopTimer();
    this.wTF.stopTimer();
    try
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.wTH);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(this.wTH);
      this.txH.stop();
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
    Log.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.wTy) });
    if (this.wPk)
    {
      onCompletion();
      AppMethodBeat.o(107599);
      return;
    }
    this.wTz = paramInt2;
    final String str = this.txH.getVideoPath();
    this.txH.stop();
    this.wTx = true;
    nY(false);
    if (this.wTz == -1)
    {
      this.wTD += 1;
      if (this.wTD <= 3)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107568);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.aAB(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107568);
          }
        });
        AppMethodBeat.o(107599);
        return;
      }
    }
    if ((!Util.isNullOrNil(str)) && (u.agG(str)))
    {
      Log.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.twz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107569);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          FileProviderHelper.setIntentDataAndType(FavVideoView.this.getContext(), (Intent)localObject, new com.tencent.mm.vfs.q(str), "video/*", false);
          try
          {
            Context localContext = FavVideoView.this.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(107569);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.p(FavVideoView.this.getContext(), s.i.favorite_no_match_msg, s.i.favorite_no_match_title);
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
    if (!this.wTx) {
      dmh();
    }
    AppMethodBeat.o(107579);
  }
  
  public final void qX()
  {
    AppMethodBeat.i(107597);
    this.wTz = 0;
    this.gX = true;
    nY(true);
    this.wPk = this.txH.start();
    int i = this.txH.getDuration() / 1000;
    this.txN.startTimer(500L);
    setVideoStateIv(false);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(107597);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(107595);
    Log.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(paramInt) });
    this.txH.q(paramInt * 1000);
    AppMethodBeat.o(107595);
  }
  
  public void setCallback(b paramb)
  {
    this.wTE = paramb;
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(107578);
    this.wPh.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F));
    AppMethodBeat.o(107578);
  }
  
  public void setVideoData(String paramString)
  {
    this.fullPath = paramString;
  }
  
  public void setVideoScaleType(i.e parame)
  {
    AppMethodBeat.i(230608);
    if (this.txH != null)
    {
      if ((this.txH instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.txH).setScaleType(parame);
        AppMethodBeat.o(230608);
        return;
      }
      if ((this.txH instanceof VideoTextureView)) {
        ((VideoTextureView)this.txH).setScaleType(parame);
      }
    }
    AppMethodBeat.o(230608);
  }
  
  public void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(107591);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = this.wTv;
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
    implements com.tencent.mm.plugin.fav.a.q, com.tencent.mm.plugin.record.a.d
  {
    private a() {}
    
    private void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(107575);
      Log.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (((paramInt1 == 3) || (paramInt1 == 2)) && (u.agG(paramString)))
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
              FavVideoView.this.aAB(FavVideoView.h(FavVideoView.this));
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
  
  public static abstract interface b
  {
    public abstract void finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView
 * JD-Core Version:    0.7.0.1
 */