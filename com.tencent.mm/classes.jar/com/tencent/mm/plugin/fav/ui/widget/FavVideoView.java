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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavVideoView
  extends RelativeLayout
  implements e.a
{
  private String eNO;
  private ak kuE;
  public com.tencent.mm.pluginsdk.ui.tools.e kvG;
  private ImageView mAM;
  private boolean mAP;
  public LinearLayout mBk;
  private String mBq;
  private int mEA;
  private FavVideoView.a mEB;
  private TextView mEu;
  private boolean mEv;
  private boolean mEw;
  private int mEx;
  private ProgressBar mEy;
  private MMPinProgressBtn mEz;
  
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
    AppMethodBeat.i(74724);
    this.kuE = new ak(Looper.getMainLooper());
    this.mEv = false;
    this.mEw = false;
    this.mEx = 0;
    this.mAP = false;
    this.mBq = "";
    this.mEA = 0;
    this.mEB = new FavVideoView.a(this, (byte)0);
    ab.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2130969567, this);
    this.mAM = ((ImageView)findViewById(2131822189));
    paramAttributeSet = (RelativeLayout)findViewById(2131820629);
    ((TextView)findViewById(2131822191)).setVisibility(8);
    this.mEz = ((MMPinProgressBtn)findViewById(2131822192));
    this.mEy = ((ProgressBar)findViewById(2131821842));
    this.mBk = ((LinearLayout)findViewById(2131824000));
    this.mEu = ((TextView)findViewById(2131822194));
    if (com.tencent.mm.modelcontrol.d.agf()) {
      this.mEw = true;
    }
    for (this.kvG = new VideoPlayerTextureView(paramContext);; this.kvG = new VideoTextureView(paramContext))
    {
      this.kvG.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      paramAttributeSet.addView((View)this.kvG, paramContext);
      ((a)g.G(a.class)).getRecordMsgCDNStorage().a(this.mEB);
      ((ae)g.G(ae.class)).getFavCdnStorage().a(this.mEB);
      AppMethodBeat.o(74724);
      return;
      this.mEw = false;
    }
  }
  
  private void byu()
  {
    AppMethodBeat.i(74730);
    if ((!bo.isNullOrNil(this.eNO)) && (com.tencent.mm.vfs.e.cN(this.eNO)))
    {
      ab.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
      Oh(this.eNO);
      AppMethodBeat.o(74730);
      return;
    }
    ab.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
    hF(false);
    AppMethodBeat.o(74730);
  }
  
  private static boolean byv()
  {
    AppMethodBeat.i(74731);
    boolean bool = g.RL().Ru().getBoolean(ac.a.yFa, false);
    AppMethodBeat.o(74731);
    return bool;
  }
  
  private void hF(boolean paramBoolean)
  {
    AppMethodBeat.i(74729);
    this.kuE.post(new FavVideoView.1(this, paramBoolean));
    AppMethodBeat.o(74729);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(74736);
    this.kuE.post(new FavVideoView.5(this));
    AppMethodBeat.o(74736);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(74734);
    ab.i("MicroMsg.FavVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if ((com.tencent.mm.compatible.util.d.iU(18)) || (!this.mEw))
    {
      ab.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[] { Integer.valueOf(0) });
      this.kvG.A(0.0D);
      AppMethodBeat.o(74734);
      return;
    }
    if (this.kvG != null) {
      this.kvG.stop();
    }
    AppMethodBeat.o(74734);
  }
  
  public final void Oh(String paramString)
  {
    AppMethodBeat.i(74732);
    ab.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(74732);
      return;
    }
    if (this.kvG != null)
    {
      if ((this.kvG instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.kvG).setNeedResetExtractor(byv());
      }
      ((View)this.kvG).setVisibility(0);
      ((View)this.kvG).setAlpha(0.0F);
      this.mAM.setVisibility(0);
      this.kvG.setVideoPath(paramString);
    }
    if (((Integer)g.RL().Ru().get(ac.a.yDR, Integer.valueOf(0))).intValue() == 1)
    {
      this.mEu.setText(com.tencent.mm.plugin.sight.base.d.TX(paramString));
      this.mEu.setVisibility(0);
    }
    AppMethodBeat.o(74732);
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(74725);
    this.eNO = paramString1;
    if (paramBoolean)
    {
      showLoading();
      this.mBq = paramString2;
    }
    AppMethodBeat.o(74725);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(74733);
    this.mEx = 0;
    hF(true);
    this.mAP = this.kvG.start();
    ab.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[] { Integer.valueOf(this.kvG.getDuration() / 1000) });
    AppMethodBeat.o(74733);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(74728);
    ab.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
    try
    {
      ((a)g.G(a.class)).getRecordMsgCDNStorage().b(this.mEB);
      ((ae)g.G(ae.class)).getFavCdnStorage().b(this.mEB);
      this.kvG.stop();
      AppMethodBeat.o(74728);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(74728);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74735);
    ab.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mEw) });
    if (this.mAP)
    {
      Es();
      AppMethodBeat.o(74735);
      return;
    }
    this.mEx = paramInt2;
    String str = this.kvG.getVideoPath();
    this.kvG.stop();
    this.mEv = true;
    hF(false);
    if (this.mEx == -1)
    {
      this.mEA += 1;
      if (this.mEA <= 3)
      {
        al.d(new FavVideoView.2(this));
        AppMethodBeat.o(74735);
        return;
      }
    }
    if ((!bo.isNullOrNil(str)) && (com.tencent.mm.vfs.e.cN(str)))
    {
      ab.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
      this.kuE.post(new FavVideoView.3(this, str));
    }
    AppMethodBeat.o(74735);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(74727);
    ab.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
    if (!this.mEv) {
      byu();
    }
    AppMethodBeat.o(74727);
  }
  
  public void setThumbView(String paramString)
  {
    AppMethodBeat.i(74726);
    this.mAM.setImageBitmap(BackwardSupportUtil.b.k(paramString, 1.0F));
    AppMethodBeat.o(74726);
  }
  
  public void setVideoData(String paramString)
  {
    this.eNO = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView
 * JD-Core Version:    0.7.0.1
 */