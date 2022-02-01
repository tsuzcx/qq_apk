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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavVideoView
  extends RelativeLayout
  implements View.OnClickListener, h.a
{
  public boolean Xy;
  private String dhw;
  private String gKe;
  private ProgressBar kWd;
  private ao ocT;
  private h odZ;
  private au oef;
  private ImageView qQT;
  private boolean qQW;
  public LinearLayout qRq;
  private TextView qUK;
  private View qUL;
  private ImageView qUM;
  private VideoPlayerSeekBar qUN;
  private RelativeLayout qUO;
  private boolean qUP;
  private boolean qUQ;
  private int qUR;
  private int qUS;
  private boolean qUT;
  private MMPinProgressBtn qUU;
  private int qUV;
  private b qUW;
  au qUX;
  private b qUY;
  private a qUZ;
  
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
    this.ocT = new ao(Looper.getMainLooper());
    this.qUP = false;
    this.qUQ = false;
    this.qUR = 0;
    this.qQW = false;
    this.qUS = 0;
    this.Xy = false;
    this.qUT = false;
    this.dhw = "";
    this.qUV = 0;
    this.oef = new au(new au.a()
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
    this.qUX = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107563);
        if (FavVideoView.c(FavVideoView.this)) {
          FavVideoView.this.crF();
        }
        AppMethodBeat.o(107563);
        return false;
      }
    }, false);
    this.qUY = new b()
    {
      public final void anR()
      {
        AppMethodBeat.i(107564);
        FavVideoView.this.crK();
        FavVideoView.this.qUX.stopTimer();
        AppMethodBeat.o(107564);
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(107565);
        if (!FavVideoView.this.isPlaying())
        {
          FavVideoView.d(FavVideoView.this).au(500L, 500L);
          FavVideoView.this.setVideoStateIv(false);
        }
        FavVideoView.this.seek(paramAnonymousInt);
        FavVideoView.this.crL();
        AppMethodBeat.o(107565);
      }
    };
    this.qUZ = new a((byte)0);
    ac.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131493985, this);
    this.qQT = ((ImageView)findViewById(2131306398));
    paramAttributeSet = (RelativeLayout)findViewById(2131300914);
    ((TextView)findViewById(2131306332)).setVisibility(8);
    this.qUU = ((MMPinProgressBtn)findViewById(2131306379));
    this.kWd = ((ProgressBar)findViewById(2131306352));
    this.qRq = ((LinearLayout)findViewById(2131299788));
    this.qUM = ((ImageView)findViewById(2131306316));
    this.qUO = ((RelativeLayout)findViewById(2131298875));
    this.qUL = findViewById(2131306342);
    this.qUN = ((VideoPlayerSeekBar)findViewById(2131306375));
    this.qUK = ((TextView)findViewById(2131306403));
    if (com.tencent.mm.modelcontrol.d.aDX()) {
      this.qUQ = true;
    }
    for (this.odZ = new VideoPlayerTextureView(paramContext);; this.odZ = new VideoTextureView(paramContext))
    {
      this.odZ.setVideoCallback(this);
      crF();
      setVideoStateIv(true);
      this.qUN.setIplaySeekCallback(this.qUY);
      this.qUN.setPlayBtnOnClickListener(this);
      this.qUM.setOnClickListener(new View.OnClickListener()
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
      this.qUN.setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.odZ, paramContext);
      ((a)g.ad(a.class)).getRecordMsgCDNStorage().a(this.qUZ);
      ((af)g.ad(af.class)).getFavCdnStorage().a(this.qUZ);
      boolean bool = aj.jF(getContext());
      paramInt = aj.ej(getContext());
      ac.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if (bool)
      {
        paramContext = new RelativeLayout.LayoutParams(this.qUL.getLayoutParams());
        paramContext.addRule(12);
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramInt);
        this.qUO.setLayoutParams(paramContext);
      }
      AppMethodBeat.o(107576);
      return;
      this.qUQ = false;
    }
  }
  
  private void crJ()
  {
    AppMethodBeat.i(107588);
    if ((!bs.isNullOrNil(this.gKe)) && (com.tencent.mm.vfs.i.eA(this.gKe)))
    {
      ac.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      ade(this.gKe);
      AppMethodBeat.o(107588);
      return;
    }
    ac.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    lp(false);
    AppMethodBeat.o(107588);
  }
  
  private static boolean crM()
  {
    AppMethodBeat.i(107593);
    boolean bool = g.agR().agA().getBoolean(ah.a.GLy, false);
    AppMethodBeat.o(107593);
    return bool;
  }
  
  private void lp(final boolean paramBoolean)
  {
    AppMethodBeat.i(107587);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107567);
        ac.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[] { Boolean.valueOf(paramBoolean) });
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
    this.ocT.post(new Runnable()
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
  
  public final void ade(String paramString)
  {
    AppMethodBeat.i(107594);
    ac.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(107594);
      return;
    }
    if (this.odZ != null)
    {
      if ((this.odZ instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.odZ).setNeedResetExtractor(crM());
      }
      ((View)this.odZ).setVisibility(0);
      ((View)this.odZ).setAlpha(0.0F);
      this.qQT.setVisibility(0);
      this.odZ.setVideoPath(paramString);
    }
    if (((Integer)g.agR().agA().get(ah.a.GKg, Integer.valueOf(0))).intValue() == 1)
    {
      this.qUK.setText(com.tencent.mm.plugin.sight.base.e.alX(paramString));
      this.qUK.setVisibility(0);
    }
    AppMethodBeat.o(107594);
  }
  
  public final void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(107577);
    this.gKe = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.dhw = paramString2;
    }
    AppMethodBeat.o(107577);
  }
  
  public final void crE()
  {
    AppMethodBeat.i(107582);
    if (!this.Xy)
    {
      ac.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
      AppMethodBeat.o(107582);
      return;
    }
    if (this.qUT)
    {
      crF();
      AppMethodBeat.o(107582);
      return;
    }
    crG();
    AppMethodBeat.o(107582);
  }
  
  public final void crF()
  {
    AppMethodBeat.i(107583);
    ac.i("MicroMsg.FavVideoView", "hide video tool bar");
    this.qUL.setVisibility(8);
    this.qUM.setVisibility(8);
    this.qUT = false;
    AppMethodBeat.o(107583);
  }
  
  public final void crG()
  {
    AppMethodBeat.i(107584);
    ac.i("MicroMsg.FavVideoView", "show video tool bar");
    this.qUL.setVisibility(0);
    this.qUM.setVisibility(0);
    this.qUT = true;
    crL();
    AppMethodBeat.o(107584);
  }
  
  public final void crH()
  {
    AppMethodBeat.i(107585);
    crK();
    this.oef.stopTimer();
    setVideoStateIv(true);
    this.qUX.stopTimer();
    AppMethodBeat.o(107585);
  }
  
  public final void crI()
  {
    AppMethodBeat.i(107586);
    seek(this.qUN.getmPosition());
    this.oef.au(500L, 500L);
    setVideoStateIv(false);
    crL();
    AppMethodBeat.o(107586);
  }
  
  public final void crK()
  {
    AppMethodBeat.i(107589);
    if (this.odZ.isPlaying())
    {
      ac.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      this.odZ.pause();
    }
    AppMethodBeat.o(107589);
  }
  
  protected final void crL()
  {
    AppMethodBeat.i(107592);
    if (this.qUT) {
      this.qUX.au(4000L, 4000L);
    }
    AppMethodBeat.o(107592);
  }
  
  public final void dZ(int paramInt1, int paramInt2) {}
  
  public final int eP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getPalyPosition()
  {
    AppMethodBeat.i(107596);
    int i = this.odZ.getCurrentPosition();
    AppMethodBeat.o(107596);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107590);
    if (this.odZ == null)
    {
      AppMethodBeat.o(107590);
      return false;
    }
    boolean bool = this.odZ.isPlaying();
    AppMethodBeat.o(107590);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107581);
    if (paramView.getId() == 2131303281)
    {
      ac.i("MicroMsg.FavVideoView", "toggle video");
      if (isPlaying())
      {
        crH();
        AppMethodBeat.o(107581);
        return;
      }
      crI();
    }
    AppMethodBeat.o(107581);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(107598);
    ac.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.lb(18)) || (!this.qUQ))
    {
      seek(0);
      AppMethodBeat.o(107598);
      return;
    }
    if (this.odZ != null) {
      this.odZ.stop();
    }
    AppMethodBeat.o(107598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107580);
    ac.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    this.oef.stopTimer();
    this.qUX.stopTimer();
    this.qUX.stopTimer();
    try
    {
      ((a)g.ad(a.class)).getRecordMsgCDNStorage().b(this.qUZ);
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.qUZ);
      this.odZ.stop();
      AppMethodBeat.o(107580);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.FavVideoView", "onDestroy() %s %s", new Object[] { localThrowable.getClass().getSimpleName(), localThrowable.getMessage() });
      AppMethodBeat.o(107580);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107599);
    ac.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.qUQ) });
    if (this.qQW)
    {
      onCompletion();
      AppMethodBeat.o(107599);
      return;
    }
    this.qUR = paramInt2;
    String str = this.odZ.getVideoPath();
    this.odZ.stop();
    this.qUP = true;
    lp(false);
    if (this.qUR == -1)
    {
      this.qUV += 1;
      if (this.qUV <= 3)
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107568);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.ade(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107568);
          }
        });
        AppMethodBeat.o(107599);
        return;
      }
    }
    if ((!bs.isNullOrNil(str)) && (com.tencent.mm.vfs.i.eA(str)))
    {
      ac.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.ocT.post(new FavVideoView.8(this, str));
    }
    AppMethodBeat.o(107599);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107579);
    ac.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.qUP) {
      crJ();
    }
    AppMethodBeat.o(107579);
  }
  
  public final void rB()
  {
    AppMethodBeat.i(107597);
    this.qUR = 0;
    this.Xy = true;
    lp(true);
    this.qQW = this.odZ.start();
    int i = this.odZ.getDuration() / 1000;
    this.oef.au(500L, 500L);
    setVideoStateIv(false);
    ac.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(107597);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(107595);
    ac.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(paramInt) });
    this.odZ.p(paramInt * 1000);
    AppMethodBeat.o(107595);
  }
  
  public void setCallback(b paramb)
  {
    this.qUW = paramb;
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(107578);
    this.qQT.setImageBitmap(BackwardSupportUtil.b.n(paramString, 1.0F));
    AppMethodBeat.o(107578);
  }
  
  public void setVideoData(String paramString)
  {
    this.gKe = paramString;
  }
  
  public void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(107591);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = this.qUN;
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
      ac.e("MicroMsg.FavVideoView", "set video state iv error : " + localException.toString());
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
      ac.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (((paramInt1 == 3) || (paramInt1 == 2)) && (com.tencent.mm.vfs.i.eA(paramString)))
      {
        FavVideoView.f(FavVideoView.this).stop();
        FavVideoView.l(FavVideoView.this);
        FavVideoView.a(FavVideoView.this, paramString);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107572);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.ade(FavVideoView.h(FavVideoView.this));
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
      if ((bs.isNullOrNil(paramc.field_dataId)) || (!paramc.field_dataId.equals(FavVideoView.k(FavVideoView.this))))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView
 * JD-Core Version:    0.7.0.1
 */