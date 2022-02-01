package com.tencent.mm.plugin.fav.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ba;
import com.tencent.mm.f.a.uq;
import com.tencent.mm.f.a.ur;
import com.tencent.mm.f.a.ur.a;
import com.tencent.mm.f.b.a.fo;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.u;

public final class r
{
  MMActivity activity;
  private a.a wNa;
  private com.tencent.mm.plugin.scanner.word.a wNb;
  volatile int wNc;
  public int wNd;
  a wNe;
  ImageView wNf;
  private ImageView wNg;
  private ImageView wNh;
  private ValueAnimator wNi;
  private IListener<ur> wNj;
  private p wNk;
  
  public r(MMActivity paramMMActivity, a parama, a.a parama1)
  {
    AppMethodBeat.i(107073);
    this.wNd = 0;
    this.wNj = new IListener() {};
    this.wNk = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(107068);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107067);
            if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4) && (r.this.wNd == 1))
            {
              com.tencent.mm.ui.base.h.c(r.this.activity, r.this.activity.getString(s.i.app_network_unavailable), "", true);
              r.this.dlo();
            }
            AppMethodBeat.o(107067);
          }
        });
        AppMethodBeat.o(107068);
      }
    };
    this.wNa = parama1;
    this.activity = paramMMActivity;
    this.wNe = parama;
    this.wNg = ((ImageView)this.activity.findViewById(s.e.scan_translate_layer));
    this.wNh = ((ImageView)this.activity.findViewById(s.e.scan_translate_close_btn));
    this.wNf = ((ImageView)this.activity.findViewById(s.e.scan_translate_line));
    paramMMActivity = (FrameLayout.LayoutParams)this.wNh.getLayoutParams();
    paramMMActivity.bottomMargin += ar.aB(this.activity);
    this.wNh.setLayoutParams(paramMMActivity);
    this.wNh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107069);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new ba();
        paramAnonymousView.fwL.scene = 1;
        paramAnonymousView.fwL.fwM = r.this.wNc;
        EventCenter.instance.publish(paramAnonymousView);
        r.this.dlo();
        r.this.wNc = 0;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107069);
      }
    });
    this.wNi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.wNi.setDuration(5000L);
    this.wNi.addListener(new r.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.wNi.addUpdateListener(new r.5(this, i));
    this.wNj.alive();
    AppMethodBeat.o(107073);
  }
  
  private void dln()
  {
    AppMethodBeat.i(107077);
    if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4))
    {
      com.tencent.mm.ui.base.h.c(this.activity, this.activity.getString(s.i.app_network_unavailable), "", true);
      dlo();
      AppMethodBeat.o(107077);
      return;
    }
    this.wNd = 1;
    this.wNf.setVisibility(0);
    this.wNg.setVisibility(0);
    this.wNh.setVisibility(0);
    dlp();
    AppMethodBeat.o(107077);
  }
  
  private void dlp()
  {
    AppMethodBeat.i(107079);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(-1);
    this.wNi.start();
    AppMethodBeat.o(107079);
  }
  
  private void dlq()
  {
    AppMethodBeat.i(107080);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(0);
    this.wNi.end();
    AppMethodBeat.o(107080);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(107075);
    Object localObject1 = this.wNe.dlb();
    if (((this.wNd == 0) || (this.wNd == 2)) && (!Util.isNullOrNil((String)localObject1)))
    {
      Object localObject2 = new fo();
      ((fo)localObject2).gBe = 5L;
      if (this.wNd == 2) {}
      for (long l = 1L;; l = 0L)
      {
        ((fo)localObject2).gnP = l;
        ((fo)localObject2).gef = 3L;
        ((fo)localObject2).uU(this.wNe.getFileId());
        ((fo)localObject2).uV(this.wNe.getAesKey());
        ((fo)localObject2).bpa();
        this.wNc = ((int)(z.bcZ().hashCode() + System.currentTimeMillis()));
        localObject2 = ((f)com.tencent.mm.kernel.h.ag(f.class)).getTranslationResult((String)localObject1);
        if ((localObject2 == null) || (!u.agG(((ge)localObject2).field_resultFile))) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
        ((Intent)localObject2).putExtra("translate_source", 5);
        ((Intent)localObject2).setClass(this.activity, TranslationResultUI.class);
        ((Intent)localObject2).putExtra("fileid", this.wNe.getFileId());
        ((Intent)localObject2).putExtra("aeskey", this.wNe.getAesKey());
        localObject1 = this.activity;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.activity.finish();
        localObject1 = this.activity;
        int i = s.a.anim_not_change;
        ((MMActivity)localObject1).overridePendingTransition(i, i);
        AppMethodBeat.o(107075);
        return;
      }
      dln();
      Log.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(this.wNc) });
      localObject2 = new uq();
      ((uq)localObject2).fTT.scene = 2;
      ((uq)localObject2).fTT.filePath = ((String)localObject1);
      ((uq)localObject2).fTT.fwM = this.wNc;
      EventCenter.instance.publish((IEvent)localObject2);
    }
    AppMethodBeat.o(107075);
  }
  
  public final void dlo()
  {
    AppMethodBeat.i(107078);
    this.wNd = 0;
    this.wNf.setVisibility(8);
    this.wNg.setVisibility(8);
    this.wNh.setVisibility(8);
    dlq();
    AppMethodBeat.o(107078);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107074);
    dlq();
    this.wNi.removeAllUpdateListeners();
    this.wNj.dead();
    com.tencent.mm.kernel.h.aHF().b(this.wNk);
    this.wNa = null;
    this.activity = null;
    this.wNe = null;
    AppMethodBeat.o(107074);
  }
  
  public final void scan(String paramString)
  {
    AppMethodBeat.i(107076);
    if ((this.activity == null) || (this.activity.isFinishing()))
    {
      AppMethodBeat.o(107076);
      return;
    }
    if (this.wNb == null) {
      this.wNb = new ImageWordScanDetailEngine(this.activity, (byte)0);
    }
    this.wNb.a(paramString, this.wNa);
    AppMethodBeat.o(107076);
  }
  
  public static abstract interface a
  {
    public abstract String dlb();
    
    public abstract String getAesKey();
    
    public abstract String getFileId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r
 * JD-Core Version:    0.7.0.1
 */