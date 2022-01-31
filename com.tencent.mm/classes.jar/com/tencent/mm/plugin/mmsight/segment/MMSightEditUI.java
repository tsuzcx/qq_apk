package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.plugin.u.a.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class MMSightEditUI
  extends MMActivity
{
  private com.tencent.mm.remoteservice.d eMh = new com.tencent.mm.remoteservice.d(ae.getContext());
  private ViewGroup jRV;
  private String jkO;
  private VideoTransPara mgW;
  private boolean mlA = false;
  private f.a mlB = new MMSightEditUI.3(this);
  private VideoPlayerTextureView mlw;
  private VideoSeekBarEditorView mlx;
  private com.tencent.mm.plugin.mmsight.ui.a mly;
  private boolean mlz = false;
  private String thumbPath;
  private String videoPath;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.f.mmsight_video_edit_ui;
  }
  
  public void onBackPressed()
  {
    if ((this.mly != null) && (this.mly.qc())) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    if (com.tencent.mm.compatible.util.d.gF(19))
    {
      getWindow().setFlags(201327616, 201327616);
      com.tencent.mm.plugin.mmsight.d.hs(true);
    }
    for (;;)
    {
      CaptureMMProxy.createProxy(new CaptureMMProxy(this.eMh));
      long l = bk.UZ();
      this.eMh.connect(new MMSightEditUI.1(this, l));
      return;
      getWindow().setFlags(1024, 1024);
      com.tencent.mm.plugin.mmsight.d.hs(false);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mlw != null) {
      this.mlw.stop();
    }
    if (this.mly != null)
    {
      if (this.mlA) {
        com.tencent.mm.plugin.mmsight.a.a.a(new com.tencent.mm.plugin.mmsight.a.a.a(this.mly.scene));
      }
      this.mly.release();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mlw != null) {
      this.mlw.pause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mlw != null) {
      this.mlw.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI
 * JD-Core Version:    0.7.0.1
 */