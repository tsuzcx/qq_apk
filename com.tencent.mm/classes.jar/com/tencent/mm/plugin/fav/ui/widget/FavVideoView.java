package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavVideoView
  extends RelativeLayout
  implements f.a
{
  private String erh;
  private ah itx = new ah(Looper.getMainLooper());
  public f iuC;
  private String kgC = "";
  private ImageView kga;
  private boolean kgd = false;
  public LinearLayout kgy;
  private TextView kjP;
  private boolean kjQ = false;
  private boolean kjR = false;
  private int kjS = 0;
  private ProgressBar kjT;
  private MMPinProgressBtn kjU;
  private int kjV = 0;
  private FavVideoView.a kjW = new FavVideoView.a(this, (byte)0);
  
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
    y.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(n.f.fav_video_view, this);
    this.kga = ((ImageView)findViewById(n.e.video_thumb));
    paramAttributeSet = (RelativeLayout)findViewById(n.e.image);
    ((TextView)findViewById(n.e.video_duration)).setVisibility(8);
    this.kjU = ((MMPinProgressBtn)findViewById(n.e.video_progress));
    this.kjT = ((ProgressBar)findViewById(n.e.video_loading));
    this.kgy = ((LinearLayout)findViewById(n.e.fav_expired_btn));
    this.kjP = ((TextView)findViewById(n.e.video_tips));
    if (com.tencent.mm.modelcontrol.d.Ns()) {
      this.kjR = true;
    }
    for (this.iuC = new VideoPlayerTextureView(paramContext);; this.iuC = new VideoTextureView(paramContext))
    {
      this.iuC.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.iuC, paramContext);
      ((a)g.t(a.class)).getRecordMsgCDNStorage().a(this.kjW);
      ((ae)g.t(ae.class)).getFavCdnStorage().a(this.kjW);
      return;
      this.kjR = false;
    }
  }
  
  private void ge(boolean paramBoolean)
  {
    this.itx.post(new FavVideoView.1(this, paramBoolean));
  }
  
  public final void Df(String paramString)
  {
    y.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (bk.bl(paramString)) {
      y.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
    }
    do
    {
      return;
      if (this.iuC != null)
      {
        if ((this.iuC instanceof VideoPlayerTextureView)) {
          ((VideoPlayerTextureView)this.iuC).setNeedResetExtractor(g.DP().Dz().getBoolean(ac.a.uuT, false));
        }
        ((View)this.iuC).setVisibility(0);
        ((View)this.iuC).setAlpha(0.0F);
        this.kga.setVisibility(0);
        this.iuC.setVideoPath(paramString);
      }
    } while (((Integer)g.DP().Dz().get(ac.a.utO, Integer.valueOf(0))).intValue() != 1);
    this.kjP.setText(com.tencent.mm.plugin.sight.base.d.Ik(paramString));
    this.kjP.setVisibility(0);
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.erh = paramString1;
    if (paramBoolean)
    {
      this.itx.post(new FavVideoView.5(this));
      this.kgC = paramString2;
    }
  }
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    this.kjS = 0;
    ge(true);
    this.kgd = this.iuC.start();
    y.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(this.iuC.getDuration() / 1000) });
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    try
    {
      ((a)g.t(a.class)).getRecordMsgCDNStorage().b(this.kjW);
      ((ae)g.t(ae.class)).getFavCdnStorage().b(this.kjW);
      this.iuC.stop();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kjR) });
    if (this.kgd) {
      ug();
    }
    String str;
    do
    {
      return;
      this.kjS = paramInt2;
      str = this.iuC.getVideoPath();
      this.iuC.stop();
      this.kjQ = true;
      ge(false);
      if (this.kjS == -1)
      {
        this.kjV += 1;
        if (this.kjV <= 3)
        {
          ai.d(new FavVideoView.2(this));
          return;
        }
      }
    } while ((bk.bl(str)) || (!com.tencent.mm.vfs.e.bK(str)));
    y.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
    this.itx.post(new FavVideoView.3(this, str));
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.kjQ)
    {
      if ((!bk.bl(this.erh)) && (com.tencent.mm.vfs.e.bK(this.erh)))
      {
        y.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
        Df(this.erh);
      }
    }
    else {
      return;
    }
    y.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    ge(false);
  }
  
  public void setThumbView(String paramString)
  {
    this.kga.setImageBitmap(BackwardSupportUtil.b.e(paramString, 1.0F));
  }
  
  public void setVideoData(String paramString)
  {
    this.erh = paramString;
  }
  
  public final void ug()
  {
    y.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.gH(18)) || (!this.kjR))
    {
      y.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(0) });
      this.iuC.x(0.0D);
    }
    while (this.iuC == null) {
      return;
    }
    this.iuC.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView
 * JD-Core Version:    0.7.0.1
 */