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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.o;

public class FavVideoView
  extends RelativeLayout
  implements View.OnClickListener, h.a
{
  public boolean Zn;
  private String dua;
  private String hgD;
  private ProgressBar lxB;
  private aq oMO;
  private h oNV;
  private aw oOb;
  public LinearLayout rJB;
  private ImageView rJe;
  private boolean rJh;
  private TextView rNj;
  private View rNk;
  private ImageView rNl;
  private VideoPlayerSeekBar rNm;
  private RelativeLayout rNn;
  private boolean rNo;
  private boolean rNp;
  private int rNq;
  private int rNr;
  private boolean rNs;
  private MMPinProgressBtn rNt;
  private int rNu;
  private b rNv;
  aw rNw;
  private com.tencent.mm.plugin.sight.decode.ui.b rNx;
  private a rNy;
  
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
    this.oMO = new aq(Looper.getMainLooper());
    this.rNo = false;
    this.rNp = false;
    this.rNq = 0;
    this.rJh = false;
    this.rNr = 0;
    this.Zn = false;
    this.rNs = false;
    this.dua = "";
    this.rNu = 0;
    this.oOb = new aw(new aw.a()
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
    this.rNw = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107563);
        if (FavVideoView.c(FavVideoView.this)) {
          FavVideoView.this.cyS();
        }
        AppMethodBeat.o(107563);
        return false;
      }
    }, false);
    this.rNx = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(107564);
        FavVideoView.this.cyX();
        FavVideoView.this.rNw.stopTimer();
        AppMethodBeat.o(107564);
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(107565);
        if (!FavVideoView.this.isPlaying())
        {
          FavVideoView.d(FavVideoView.this).ay(500L, 500L);
          FavVideoView.this.setVideoStateIv(false);
        }
        FavVideoView.this.seek(paramAnonymousInt);
        FavVideoView.this.cyY();
        AppMethodBeat.o(107565);
      }
    };
    this.rNy = new a((byte)0);
    ae.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131493985, this);
    this.rJe = ((ImageView)findViewById(2131306398));
    paramAttributeSet = (RelativeLayout)findViewById(2131300914);
    ((TextView)findViewById(2131306332)).setVisibility(8);
    this.rNt = ((MMPinProgressBtn)findViewById(2131306379));
    this.lxB = ((ProgressBar)findViewById(2131306352));
    this.rJB = ((LinearLayout)findViewById(2131299788));
    this.rNl = ((ImageView)findViewById(2131306316));
    this.rNn = ((RelativeLayout)findViewById(2131298875));
    this.rNk = findViewById(2131306342);
    this.rNm = ((VideoPlayerSeekBar)findViewById(2131306375));
    this.rNj = ((TextView)findViewById(2131306403));
    if (com.tencent.mm.modelcontrol.d.aHt()) {
      this.rNp = true;
    }
    for (this.oNV = new VideoPlayerTextureView(paramContext);; this.oNV = new VideoTextureView(paramContext))
    {
      this.oNV.setVideoCallback(this);
      cyS();
      setVideoStateIv(true);
      this.rNm.setIplaySeekCallback(this.rNx);
      this.rNm.setPlayBtnOnClickListener(this);
      this.rNl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (FavVideoView.e(FavVideoView.this) != null) {
            FavVideoView.e(FavVideoView.this).finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107566);
        }
      });
      this.rNm.setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.oNV, paramContext);
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.rNy);
      ((af)g.ad(af.class)).getFavCdnStorage().a(this.rNy);
      boolean bool = al.jY(getContext());
      paramInt = al.en(getContext());
      ae.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if (bool)
      {
        paramContext = new RelativeLayout.LayoutParams(this.rNk.getLayoutParams());
        paramContext.addRule(12);
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramInt);
        this.rNn.setLayoutParams(paramContext);
      }
      AppMethodBeat.o(107576);
      return;
      this.rNp = false;
    }
  }
  
  private void cyW()
  {
    AppMethodBeat.i(107588);
    if ((!bu.isNullOrNil(this.hgD)) && (o.fB(this.hgD)))
    {
      ae.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      ahQ(this.hgD);
      AppMethodBeat.o(107588);
      return;
    }
    ae.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    lI(false);
    AppMethodBeat.o(107588);
  }
  
  private static boolean cyZ()
  {
    AppMethodBeat.i(107593);
    boolean bool = g.ajR().ajA().getBoolean(am.a.ISo, false);
    AppMethodBeat.o(107593);
    return bool;
  }
  
  private void lI(final boolean paramBoolean)
  {
    AppMethodBeat.i(107587);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107567);
        ae.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[] { Boolean.valueOf(paramBoolean) });
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
    this.oMO.post(new Runnable()
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
  
  public final void ahQ(String paramString)
  {
    AppMethodBeat.i(107594);
    ae.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(107594);
      return;
    }
    if (this.oNV != null)
    {
      if ((this.oNV instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.oNV).setNeedResetExtractor(cyZ());
      }
      ((View)this.oNV).setVisibility(0);
      ((View)this.oNV).setAlpha(0.0F);
      this.rJe.setVisibility(0);
      this.oNV.setVideoPath(paramString);
    }
    if (((Integer)g.ajR().ajA().get(am.a.IQW, Integer.valueOf(0))).intValue() == 1)
    {
      this.rNj.setText(com.tencent.mm.plugin.sight.base.e.arR(paramString));
      this.rNj.setVisibility(0);
    }
    AppMethodBeat.o(107594);
  }
  
  public final void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(107577);
    this.hgD = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.dua = paramString2;
    }
    AppMethodBeat.o(107577);
  }
  
  public final void cyR()
  {
    AppMethodBeat.i(107582);
    if (!this.Zn)
    {
      ae.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
      AppMethodBeat.o(107582);
      return;
    }
    if (this.rNs)
    {
      cyS();
      AppMethodBeat.o(107582);
      return;
    }
    cyT();
    AppMethodBeat.o(107582);
  }
  
  public final void cyS()
  {
    AppMethodBeat.i(107583);
    ae.i("MicroMsg.FavVideoView", "hide video tool bar");
    this.rNk.setVisibility(8);
    this.rNl.setVisibility(8);
    this.rNs = false;
    AppMethodBeat.o(107583);
  }
  
  public final void cyT()
  {
    AppMethodBeat.i(107584);
    ae.i("MicroMsg.FavVideoView", "show video tool bar");
    this.rNk.setVisibility(0);
    this.rNl.setVisibility(0);
    this.rNs = true;
    cyY();
    AppMethodBeat.o(107584);
  }
  
  public final void cyU()
  {
    AppMethodBeat.i(107585);
    cyX();
    this.oOb.stopTimer();
    setVideoStateIv(true);
    this.rNw.stopTimer();
    AppMethodBeat.o(107585);
  }
  
  public final void cyV()
  {
    AppMethodBeat.i(107586);
    seek(this.rNm.getmPosition());
    this.oOb.ay(500L, 500L);
    setVideoStateIv(false);
    cyY();
    AppMethodBeat.o(107586);
  }
  
  public final void cyX()
  {
    AppMethodBeat.i(107589);
    if (this.oNV.isPlaying())
    {
      ae.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      this.oNV.pause();
    }
    AppMethodBeat.o(107589);
  }
  
  protected final void cyY()
  {
    AppMethodBeat.i(107592);
    if (this.rNs) {
      this.rNw.ay(4000L, 4000L);
    }
    AppMethodBeat.o(107592);
  }
  
  public final int eU(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void eb(int paramInt1, int paramInt2) {}
  
  public int getPalyPosition()
  {
    AppMethodBeat.i(107596);
    int i = this.oNV.getCurrentPosition();
    AppMethodBeat.o(107596);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107590);
    if (this.oNV == null)
    {
      AppMethodBeat.o(107590);
      return false;
    }
    boolean bool = this.oNV.isPlaying();
    AppMethodBeat.o(107590);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107581);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView.getId() == 2131303281)
    {
      ae.i("MicroMsg.FavVideoView", "toggle video");
      if (!isPlaying()) {
        break label91;
      }
      cyU();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(107581);
      return;
      label91:
      cyV();
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(107598);
    ae.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.lC(18)) || (!this.rNp))
    {
      seek(0);
      AppMethodBeat.o(107598);
      return;
    }
    if (this.oNV != null) {
      this.oNV.stop();
    }
    AppMethodBeat.o(107598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107580);
    ae.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    this.oOb.stopTimer();
    this.rNw.stopTimer();
    this.rNw.stopTimer();
    try
    {
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.rNy);
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.rNy);
      this.oNV.stop();
      AppMethodBeat.o(107580);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.FavVideoView", "onDestroy() %s %s", new Object[] { localThrowable.getClass().getSimpleName(), localThrowable.getMessage() });
      AppMethodBeat.o(107580);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107599);
    ae.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.rNp) });
    if (this.rJh)
    {
      onCompletion();
      AppMethodBeat.o(107599);
      return;
    }
    this.rNq = paramInt2;
    String str = this.oNV.getVideoPath();
    this.oNV.stop();
    this.rNo = true;
    lI(false);
    if (this.rNq == -1)
    {
      this.rNu += 1;
      if (this.rNu <= 3)
      {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107568);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.ahQ(FavVideoView.h(FavVideoView.this));
            }
            AppMethodBeat.o(107568);
          }
        });
        AppMethodBeat.o(107599);
        return;
      }
    }
    if ((!bu.isNullOrNil(str)) && (o.fB(str)))
    {
      ae.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.oMO.post(new FavVideoView.8(this, str));
    }
    AppMethodBeat.o(107599);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107579);
    ae.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.rNo) {
      cyW();
    }
    AppMethodBeat.o(107579);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(107595);
    ae.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(paramInt) });
    this.oNV.p(paramInt * 1000);
    AppMethodBeat.o(107595);
  }
  
  public void setCallback(b paramb)
  {
    this.rNv = paramb;
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(107578);
    this.rJe.setImageBitmap(BackwardSupportUtil.b.p(paramString, 1.0F));
    AppMethodBeat.o(107578);
  }
  
  public void setVideoData(String paramString)
  {
    this.hgD = paramString;
  }
  
  public void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(107591);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = this.rNm;
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
      ae.e("MicroMsg.FavVideoView", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(107591);
    }
  }
  
  public final void ta()
  {
    AppMethodBeat.i(107597);
    this.rNq = 0;
    this.Zn = true;
    lI(true);
    this.rJh = this.oNV.start();
    int i = this.oNV.getDuration() / 1000;
    this.oOb.ay(500L, 500L);
    setVideoStateIv(false);
    ae.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(107597);
  }
  
  final class a
    implements p, com.tencent.mm.plugin.record.a.d
  {
    private a() {}
    
    private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(107575);
      ae.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (((paramInt1 == 3) || (paramInt1 == 2)) && (o.fB(paramString)))
      {
        FavVideoView.f(FavVideoView.this).stop();
        FavVideoView.l(FavVideoView.this);
        FavVideoView.a(FavVideoView.this, paramString);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107572);
            if (FavVideoView.f(FavVideoView.this) != null) {
              FavVideoView.this.ahQ(FavVideoView.h(FavVideoView.this));
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
      if ((bu.isNullOrNil(paramc.field_dataId)) || (!paramc.field_dataId.equals(FavVideoView.k(FavVideoView.this))))
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