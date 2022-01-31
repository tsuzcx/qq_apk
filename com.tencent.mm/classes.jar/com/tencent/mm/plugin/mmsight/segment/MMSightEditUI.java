package com.tencent.mm.plugin.mmsight.segment;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.mmsight.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class MMSightEditUI
  extends MMActivity
{
  private com.tencent.mm.remoteservice.d evl;
  private String lup;
  private ViewGroup mmr;
  private VideoTransPara oHk;
  private VideoPlayerTextureView oKC;
  private VideoSeekBarEditorView oKD;
  private String oKE;
  private b oKF;
  private boolean oKG;
  private boolean oKH;
  private boolean oKI;
  private e.a oKJ;
  private String thumbPath;
  private String videoPath;
  
  public MMSightEditUI()
  {
    AppMethodBeat.i(54968);
    this.evl = new com.tencent.mm.remoteservice.d(ah.getContext());
    this.oKG = false;
    this.oKH = true;
    this.oKI = false;
    this.oKJ = new MMSightEditUI.3(this);
    AppMethodBeat.o(54968);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970288;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(54970);
    if ((this.oKF != null) && (this.oKF.onBackPressed()))
    {
      AppMethodBeat.o(54970);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(54970);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(54969);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    if (com.tencent.mm.compatible.util.d.fv(19))
    {
      getWindow().setFlags(201327616, 201327616);
      com.tencent.mm.plugin.mmsight.d.jm(true);
    }
    for (;;)
    {
      CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
      long l = bo.yB();
      this.evl.connect(new MMSightEditUI.1(this, l));
      AppMethodBeat.o(54969);
      return;
      getWindow().setFlags(1024, 1024);
      com.tencent.mm.plugin.mmsight.d.jm(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(54973);
    super.onDestroy();
    if (this.oKC != null) {
      this.oKC.stop();
    }
    if (this.oKF != null)
    {
      if (this.oKI) {
        com.tencent.mm.plugin.mmsight.a.a.a(new a.a(this.oKF.scene));
      }
      this.oKF.release();
    }
    AppMethodBeat.o(54973);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(54971);
    super.onPause();
    if (this.oKC != null) {
      this.oKC.pause();
    }
    AppMethodBeat.o(54971);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(54972);
    super.onResume();
    if (this.oKC != null) {
      this.oKC.start();
    }
    AppMethodBeat.o(54972);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI
 * JD-Core Version:    0.7.0.1
 */