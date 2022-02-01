package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.mmsight.ui.b;
import com.tencent.mm.plugin.mmsight.ui.b.a;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.plugin.w.a.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class MMSightEditUI
  extends MMActivity
{
  private VideoTransPara KVn;
  private VideoPlayerTextureView KZh;
  private VideoSeekBarEditorView KZi;
  private String KZj;
  private b KZk;
  private boolean KZl;
  private boolean KZm;
  private boolean KZn;
  private i.a KZo;
  private ViewGroup mJe;
  private String outputPath;
  private com.tencent.mm.remoteservice.d pfZ;
  private String thumbPath;
  private String videoPath;
  
  public MMSightEditUI()
  {
    AppMethodBeat.i(94399);
    this.pfZ = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.KZl = false;
    this.KZm = true;
    this.KZn = false;
    this.KZo = new i.a()
    {
      public final void Qz()
      {
        AppMethodBeat.i(94397);
        if (MMSightEditUI.j(MMSightEditUI.this) != null)
        {
          MMSightEditUI.j(MMSightEditUI.this).start();
          MMSightEditUI.j(MMSightEditUI.this).setLoop(true);
          MMSightEditUI.j(MMSightEditUI.this).setAlpha(1.0F);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(94395);
              MMSightEditUI.k(MMSightEditUI.this);
              AppMethodBeat.o(94395);
            }
          }, 300L);
        }
        AppMethodBeat.o(94397);
      }
      
      public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(94398);
        MMSightEditUI.j(MMSightEditUI.this).c(0.0D, true);
        AppMethodBeat.o(94398);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(94396);
        Log.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(MMSightEditUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(94396);
      }
    };
    AppMethodBeat.o(94399);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.f.mmsight_video_edit_ui;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94401);
    if ((this.KZk != null) && (this.KZk.onBackPressed()))
    {
      AppMethodBeat.o(94401);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(94401);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94400);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    if (com.tencent.mm.compatible.util.d.rb(19))
    {
      getWindow().setFlags(201327616, 201327616);
      com.tencent.mm.plugin.mmsight.d.ys(true);
    }
    for (;;)
    {
      CaptureMMProxy.createProxy(new CaptureMMProxy(this.pfZ));
      final long l = Util.currentTicks();
      this.pfZ.connect(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(94390);
          Log.i("MicroMsg.MMSightEditUI", "connect cost %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          if (CaptureMMProxy.getInstance() != null) {
            af.Ds(CaptureMMProxy.getInstance().getDeviceInfoConfig());
          }
          MMSightEditUI.a(MMSightEditUI.this);
          AppMethodBeat.o(94390);
        }
      });
      AppMethodBeat.o(94400);
      return;
      getWindow().setFlags(1024, 1024);
      com.tencent.mm.plugin.mmsight.d.ys(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94404);
    super.onDestroy();
    if (this.KZh != null) {
      this.KZh.stop();
    }
    if (this.KZk != null)
    {
      if (this.KZn) {
        com.tencent.mm.plugin.mmsight.a.a.a(new a.a(this.KZk.scene));
      }
      this.KZk.release();
    }
    AppMethodBeat.o(94404);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94402);
    super.onPause();
    if (this.KZh != null) {
      this.KZh.pause();
    }
    AppMethodBeat.o(94402);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(94403);
    super.onResume();
    if (this.KZh != null) {
      this.KZh.start();
    }
    AppMethodBeat.o(94403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI
 * JD-Core Version:    0.7.0.1
 */