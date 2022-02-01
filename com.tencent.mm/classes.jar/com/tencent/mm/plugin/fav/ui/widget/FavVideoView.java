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
import com.tencent.mm.plugin.record.a.j;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.i;

public class FavVideoView
  extends RelativeLayout
  implements View.OnClickListener, h.a
{
  public boolean Zn;
  private String dsU;
  private String hdP;
  private ProgressBar ltc;
  private ap oGm;
  private h oHt;
  private av oHz;
  private ImageView rAT;
  private boolean rAW;
  public LinearLayout rBq;
  private TextView rEY;
  private View rEZ;
  private ImageView rFa;
  private VideoPlayerSeekBar rFb;
  private RelativeLayout rFc;
  private boolean rFd;
  private boolean rFe;
  private int rFf;
  private int rFg;
  private boolean rFh;
  private MMPinProgressBtn rFi;
  private int rFj;
  private b rFk;
  av rFl;
  private com.tencent.mm.plugin.sight.decode.ui.b rFm;
  private a rFn;
  
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
    this.oGm = new ap(Looper.getMainLooper());
    this.rFd = false;
    this.rFe = false;
    this.rFf = 0;
    this.rAW = false;
    this.rFg = 0;
    this.Zn = false;
    this.rFh = false;
    this.dsU = "";
    this.rFj = 0;
    this.oHz = new av(new av.a()
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
    this.rFl = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107563);
        if (FavVideoView.c(FavVideoView.this)) {
          FavVideoView.this.cxr();
        }
        AppMethodBeat.o(107563);
        return false;
      }
    }, false);
    this.rFm = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(107564);
        FavVideoView.this.cxw();
        FavVideoView.this.rFl.stopTimer();
        AppMethodBeat.o(107564);
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(107565);
        if (!FavVideoView.this.isPlaying())
        {
          FavVideoView.d(FavVideoView.this).az(500L, 500L);
          FavVideoView.this.setVideoStateIv(false);
        }
        FavVideoView.this.seek(paramAnonymousInt);
        FavVideoView.this.cxx();
        AppMethodBeat.o(107565);
      }
    };
    this.rFn = new a((byte)0);
    ad.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131493985, this);
    this.rAT = ((ImageView)findViewById(2131306398));
    paramAttributeSet = (RelativeLayout)findViewById(2131300914);
    ((TextView)findViewById(2131306332)).setVisibility(8);
    this.rFi = ((MMPinProgressBtn)findViewById(2131306379));
    this.ltc = ((ProgressBar)findViewById(2131306352));
    this.rBq = ((LinearLayout)findViewById(2131299788));
    this.rFa = ((ImageView)findViewById(2131306316));
    this.rFc = ((RelativeLayout)findViewById(2131298875));
    this.rEZ = findViewById(2131306342);
    this.rFb = ((VideoPlayerSeekBar)findViewById(2131306375));
    this.rEY = ((TextView)findViewById(2131306403));
    if (com.tencent.mm.modelcontrol.d.aHc()) {
      this.rFe = true;
    }
    for (this.oHt = new VideoPlayerTextureView(paramContext);; this.oHt = new VideoTextureView(paramContext))
    {
      this.oHt.setVideoCallback(this);
      cxr();
      setVideoStateIv(true);
      this.rFb.setIplaySeekCallback(this.rFm);
      this.rFb.setPlayBtnOnClickListener(this);
      this.rFa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (FavVideoView.e(FavVideoView.this) != null) {
            FavVideoView.e(FavVideoView.this).finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107566);
        }
      });
      this.rFb.setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.oHt, paramContext);
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.rFn);
      ((af)g.ad(af.class)).getFavCdnStorage().a(this.rFn);
      boolean bool = al.jR(getContext());
      paramInt = al.ej(getContext());
      ad.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if (bool)
      {
        paramContext = new RelativeLayout.LayoutParams(this.rEZ.getLayoutParams());
        paramContext.addRule(12);
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramInt);
        this.rFc.setLayoutParams(paramContext);
      }
      AppMethodBeat.o(107576);
      return;
      this.rFe = false;
    }
  }
  
  private void cxv()
  {
    AppMethodBeat.i(107588);
    if ((!bt.isNullOrNil(this.hdP)) && (i.fv(this.hdP)))
    {
      ad.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      agT(this.hdP);
      AppMethodBeat.o(107588);
      return;
    }
    ad.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    lI(false);
    AppMethodBeat.o(107588);
  }
  
  private static boolean cxy()
  {
    AppMethodBeat.i(107593);
    boolean bool = g.ajC().ajl().getBoolean(al.a.IxQ, false);
    AppMethodBeat.o(107593);
    return bool;
  }
  
  private void lI(final boolean paramBoolean)
  {
    AppMethodBeat.i(107587);
    this.oGm.post(new Runnable()
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
    this.oGm.post(new Runnable()
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
  
  public final void agT(String paramString)
  {
    AppMethodBeat.i(107594);
    ad.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(107594);
      return;
    }
    if (this.oHt != null)
    {
      if ((this.oHt instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.oHt).setNeedResetExtractor(cxy());
      }
      ((View)this.oHt).setVisibility(0);
      ((View)this.oHt).setAlpha(0.0F);
      this.rAT.setVisibility(0);
      this.oHt.setVideoPath(paramString);
    }
    if (((Integer)g.ajC().ajl().get(al.a.Iwy, Integer.valueOf(0))).intValue() == 1)
    {
      this.rEY.setText(com.tencent.mm.plugin.sight.base.e.aqM(paramString));
      this.rEY.setVisibility(0);
    }
    AppMethodBeat.o(107594);
  }
  
  public final void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(107577);
    this.hdP = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.dsU = paramString2;
    }
    AppMethodBeat.o(107577);
  }
  
  public final void cxq()
  {
    AppMethodBeat.i(107582);
    if (!this.Zn)
    {
      ad.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
      AppMethodBeat.o(107582);
      return;
    }
    if (this.rFh)
    {
      cxr();
      AppMethodBeat.o(107582);
      return;
    }
    cxs();
    AppMethodBeat.o(107582);
  }
  
  public final void cxr()
  {
    AppMethodBeat.i(107583);
    ad.i("MicroMsg.FavVideoView", "hide video tool bar");
    this.rEZ.setVisibility(8);
    this.rFa.setVisibility(8);
    this.rFh = false;
    AppMethodBeat.o(107583);
  }
  
  public final void cxs()
  {
    AppMethodBeat.i(107584);
    ad.i("MicroMsg.FavVideoView", "show video tool bar");
    this.rEZ.setVisibility(0);
    this.rFa.setVisibility(0);
    this.rFh = true;
    cxx();
    AppMethodBeat.o(107584);
  }
  
  public final void cxt()
  {
    AppMethodBeat.i(107585);
    cxw();
    this.oHz.stopTimer();
    setVideoStateIv(true);
    this.rFl.stopTimer();
    AppMethodBeat.o(107585);
  }
  
  public final void cxu()
  {
    AppMethodBeat.i(107586);
    seek(this.rFb.getmPosition());
    this.oHz.az(500L, 500L);
    setVideoStateIv(false);
    cxx();
    AppMethodBeat.o(107586);
  }
  
  public final void cxw()
  {
    AppMethodBeat.i(107589);
    if (this.oHt.isPlaying())
    {
      ad.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      this.oHt.pause();
    }
    AppMethodBeat.o(107589);
  }
  
  protected final void cxx()
  {
    AppMethodBeat.i(107592);
    if (this.rFh) {
      this.rFl.az(4000L, 4000L);
    }
    AppMethodBeat.o(107592);
  }
  
  public final int eT(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void eb(int paramInt1, int paramInt2) {}
  
  public int getPalyPosition()
  {
    AppMethodBeat.i(107596);
    int i = this.oHt.getCurrentPosition();
    AppMethodBeat.o(107596);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107590);
    if (this.oHt == null)
    {
      AppMethodBeat.o(107590);
      return false;
    }
    boolean bool = this.oHt.isPlaying();
    AppMethodBeat.o(107590);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107581);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView.getId() == 2131303281)
    {
      ad.i("MicroMsg.FavVideoView", "toggle video");
      if (!isPlaying()) {
        break label91;
      }
      cxt();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(107581);
      return;
      label91:
      cxu();
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(107598);
    ad.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.lA(18)) || (!this.rFe))
    {
      seek(0);
      AppMethodBeat.o(107598);
      return;
    }
    if (this.oHt != null) {
      this.oHt.stop();
    }
    AppMethodBeat.o(107598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107580);
    ad.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    this.oHz.stopTimer();
    this.rFl.stopTimer();
    this.rFl.stopTimer();
    try
    {
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.rFn);
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.rFn);
      this.oHt.stop();
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
    ad.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.rFe) });
    if (this.rAW)
    {
      onCompletion();
      AppMethodBeat.o(107599);
      return;
    }
    this.rFf = paramInt2;
    String str = this.oHt.getVideoPath();
    this.oHt.stop();
    this.rFd = true;
    lI(false);
    if (this.rFf == -1)
    {
      this.rFj += 1;
      if (this.rFj <= 3)
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107568);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.agT(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107568);
          }
        });
        AppMethodBeat.o(107599);
        return;
      }
    }
    if ((!bt.isNullOrNil(str)) && (i.fv(str)))
    {
      ad.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.oGm.post(new FavVideoView.8(this, str));
    }
    AppMethodBeat.o(107599);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107579);
    ad.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.rFd) {
      cxv();
    }
    AppMethodBeat.o(107579);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(107595);
    ad.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(paramInt) });
    this.oHt.p(paramInt * 1000);
    AppMethodBeat.o(107595);
  }
  
  public void setCallback(b paramb)
  {
    this.rFk = paramb;
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(107578);
    this.rAT.setImageBitmap(BackwardSupportUtil.b.o(paramString, 1.0F));
    AppMethodBeat.o(107578);
  }
  
  public void setVideoData(String paramString)
  {
    this.hdP = paramString;
  }
  
  public void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(107591);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = this.rFb;
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
  
  public final void ta()
  {
    AppMethodBeat.i(107597);
    this.rFf = 0;
    this.Zn = true;
    lI(true);
    this.rAW = this.oHt.start();
    int i = this.oHt.getDuration() / 1000;
    this.oHz.az(500L, 500L);
    setVideoStateIv(false);
    ad.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(107597);
  }
  
  final class a
    implements p, com.tencent.mm.plugin.record.a.d
  {
    private a() {}
    
    private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(107575);
      ad.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (((paramInt1 == 3) || (paramInt1 == 2)) && (i.fv(paramString)))
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
              FavVideoView.this.agT(FavVideoView.h(FavVideoView.this));
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