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
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class MMSightEditUI
  extends MMActivity
{
  private com.tencent.mm.remoteservice.d fLo;
  private String oLh;
  private ViewGroup pTc;
  private VideoTransPara tCr;
  private VideoPlayerTextureView tFN;
  private VideoSeekBarEditorView tFO;
  private String tFP;
  private b tFQ;
  private boolean tFR;
  private boolean tFS;
  private boolean tFT;
  private h.a tFU;
  private String thumbPath;
  private String videoPath;
  
  public MMSightEditUI()
  {
    AppMethodBeat.i(94399);
    this.fLo = new com.tencent.mm.remoteservice.d(aj.getContext());
    this.tFR = false;
    this.tFS = true;
    this.tFT = false;
    this.tFU = new h.a()
    {
      public final void dY(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int eM(int paramAnonymousInt1, int paramAnonymousInt2)
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
        ad.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(MMSightEditUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(94396);
      }
      
      public final void rq()
      {
        AppMethodBeat.i(94397);
        if (MMSightEditUI.j(MMSightEditUI.this) != null)
        {
          MMSightEditUI.j(MMSightEditUI.this).start();
          MMSightEditUI.j(MMSightEditUI.this).setLoop(true);
          MMSightEditUI.j(MMSightEditUI.this).setAlpha(1.0F);
          aq.n(new Runnable()
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
    return 2131494920;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94401);
    if ((this.tFQ != null) && (this.tFQ.onBackPressed()))
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
    if (com.tencent.mm.compatible.util.d.lf(19))
    {
      getWindow().setFlags(201327616, 201327616);
      com.tencent.mm.plugin.mmsight.d.ne(true);
    }
    for (;;)
    {
      CaptureMMProxy.createProxy(new CaptureMMProxy(this.fLo));
      final long l = bt.GC();
      this.fLo.connect(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(94390);
          ad.i("MicroMsg.MMSightEditUI", "connect cost %sms", new Object[] { Long.valueOf(bt.aS(l)) });
          if (CaptureMMProxy.getInstance() != null) {
            ae.ph(CaptureMMProxy.getInstance().getDeviceInfoConfig());
          }
          MMSightEditUI.a(MMSightEditUI.this);
          AppMethodBeat.o(94390);
        }
      });
      AppMethodBeat.o(94400);
      return;
      getWindow().setFlags(1024, 1024);
      com.tencent.mm.plugin.mmsight.d.ne(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94404);
    super.onDestroy();
    if (this.tFN != null) {
      this.tFN.stop();
    }
    if (this.tFQ != null)
    {
      if (this.tFT) {
        com.tencent.mm.plugin.mmsight.a.a.a(new a.a(this.tFQ.scene));
      }
      this.tFQ.release();
    }
    AppMethodBeat.o(94404);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94402);
    super.onPause();
    if (this.tFN != null) {
      this.tFN.pause();
    }
    AppMethodBeat.o(94402);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(94403);
    super.onResume();
    if (this.tFN != null) {
      this.tFN.start();
    }
    AppMethodBeat.o(94403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI
 * JD-Core Version:    0.7.0.1
 */