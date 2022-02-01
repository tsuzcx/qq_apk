package com.tencent.mm.plugin.mmsight.segment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.mmsight.ui.b;
import com.tencent.mm.plugin.mmsight.ui.b.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
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
  private com.tencent.mm.remoteservice.d gVN;
  private ViewGroup hwr;
  private String rpE;
  private String thumbPath;
  private String videoPath;
  private VideoTransPara zua;
  private VideoPlayerTextureView zyd;
  private VideoSeekBarEditorView zye;
  private String zyf;
  private b zyg;
  private boolean zyh;
  private boolean zyi;
  private boolean zyj;
  private j.a zyk;
  
  public MMSightEditUI()
  {
    AppMethodBeat.i(94399);
    this.gVN = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.zyh = false;
    this.zyi = true;
    this.zyj = false;
    this.zyk = new j.a()
    {
      public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int fh(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(94398);
        MMSightEditUI.j(MMSightEditUI.this).d(0.0D, true);
        AppMethodBeat.o(94398);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(94396);
        Log.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(MMSightEditUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(94396);
      }
      
      public final void tf()
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
    };
    AppMethodBeat.o(94399);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495660;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94401);
    if ((this.zyg != null) && (this.zyg.onBackPressed()))
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
    if (com.tencent.mm.compatible.util.d.oD(19))
    {
      getWindow().setFlags(201327616, 201327616);
      com.tencent.mm.plugin.mmsight.d.rb(true);
    }
    for (;;)
    {
      CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
      final long l = Util.currentTicks();
      this.gVN.connect(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(94390);
          Log.i("MicroMsg.MMSightEditUI", "connect cost %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          if (CaptureMMProxy.getInstance() != null) {
            ae.DV(CaptureMMProxy.getInstance().getDeviceInfoConfig());
          }
          MMSightEditUI.a(MMSightEditUI.this);
          AppMethodBeat.o(94390);
        }
      });
      AppMethodBeat.o(94400);
      return;
      getWindow().setFlags(1024, 1024);
      com.tencent.mm.plugin.mmsight.d.rb(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94404);
    super.onDestroy();
    if (this.zyd != null) {
      this.zyd.stop();
    }
    if (this.zyg != null)
    {
      if (this.zyj) {
        com.tencent.mm.plugin.mmsight.a.a.a(new a.a(this.zyg.scene));
      }
      this.zyg.release();
    }
    AppMethodBeat.o(94404);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94402);
    super.onPause();
    if (this.zyd != null) {
      this.zyd.pause();
    }
    AppMethodBeat.o(94402);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(94403);
    super.onResume();
    if (this.zyd != null) {
      this.zyd.start();
    }
    AppMethodBeat.o(94403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI
 * JD-Core Version:    0.7.0.1
 */