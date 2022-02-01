package com.tencent.mm.plugin.editor.widget.voiceview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.d.f;
import com.tencent.mm.plugin.editor.d.g;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.List;

public class VoiceView
  extends FrameLayout
  implements a.a
{
  public int duration;
  public int fEi;
  public View maskView;
  public String path;
  private TextView urz;
  private ImageButton uwA;
  private TextView uwB;
  public a uwC;
  public a uwD;
  private ViewGroup uwy;
  TextView uwz;
  
  public VoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(182022);
    this.path = "";
    init(paramContext);
    AppMethodBeat.o(182022);
  }
  
  public VoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(182023);
    this.path = "";
    init(paramContext);
    AppMethodBeat.o(182023);
  }
  
  private void cTm()
  {
    AppMethodBeat.i(182029);
    this.uwD.stop();
    this.uwz.setKeepScreenOn(false);
    AppMethodBeat.o(182029);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(182024);
    LayoutInflater.from(paramContext).inflate(d.f.upU, this, true);
    AppMethodBeat.o(182024);
  }
  
  public final void atP(String paramString)
  {
    AppMethodBeat.i(182025);
    if (!this.path.equals(paramString)) {
      cTm();
    }
    AppMethodBeat.o(182025);
  }
  
  public final void cTh()
  {
    AppMethodBeat.i(182026);
    cTm();
    AppMethodBeat.o(182026);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(182027);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.uwD.isPaused) });
    if (this.uwD.isPaused) {
      this.uwD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182015);
          VoiceView.g(VoiceView.this).aMU();
          AppMethodBeat.o(182015);
        }
      }, 128L);
    }
    AppMethodBeat.o(182027);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(182028);
    super.onFinishInflate();
    this.uwy = ((ViewGroup)findViewById(d.e.voice_player_progress_bg));
    this.urz = ((TextView)findViewById(d.e.voice_player_length));
    this.uwB = ((TextView)findViewById(d.e.voice_player_total_length));
    this.uwz = ((TextView)findViewById(d.e.voice_player_progress));
    this.uwA = ((ImageButton)findViewById(d.e.voice_player_btn));
    this.maskView = findViewById(d.e.eas);
    this.uwD = new a((byte)0);
    this.uwA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((com.tencent.mm.q.a.cy(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cw(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cB(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if ((!e.avA()) && (!Util.isNullOrNil(VoiceView.h(VoiceView.this))))
        {
          w.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if (!Util.nullAs(VoiceView.h(VoiceView.this), "").equals(VoiceView.i(VoiceView.this).path))
        {
          VoiceView.j(VoiceView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if (VoiceView.i(VoiceView.this).cTl())
        {
          paramAnonymousView = VoiceView.this;
          Log.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.uwC;
          Log.i("MicroMsg.RecordVoiceHelper", "pause play");
          MMEntryLock.unlock("keep_app_silent");
          if (((a)localObject).uwr == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.uwD;
            ((VoiceView.a)localObject).isPaused = true;
            ((VoiceView.a)localObject).removeMessages(4096);
            VoiceView.c(((VoiceView.a)localObject).uwE).setImageResource(d.g.voicepost_beginicon);
            VoiceView.c(((VoiceView.a)localObject).uwE).setContentDescription(((VoiceView.a)localObject).uwE.getContext().getResources().getString(d.h.app_play));
            paramAnonymousView.uwz.setKeepScreenOn(false);
            break;
            if (((a)localObject).uwr.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = VoiceView.this;
        Log.i("MicroMsg.NoteVoiceView", "resume play");
        localObject = paramAnonymousView.uwC;
        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
        MMEntryLock.lock("keep_app_silent");
        int i;
        if (((a)localObject).uwr == null)
        {
          Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.uwD;
          ((VoiceView.a)localObject).isPaused = false;
          ((VoiceView.a)localObject).sendEmptyMessage(4096);
          VoiceView.c(((VoiceView.a)localObject).uwE).setImageResource(d.g.voicepost_pauseicon);
          VoiceView.c(((VoiceView.a)localObject).uwE).setContentDescription(((VoiceView.a)localObject).uwE.getContext().getResources().getString(d.h.app_pause));
          paramAnonymousView.uwz.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          VoiceView.j(VoiceView.this);
          break;
          bool = ((a)localObject).uwr.resume();
          i = bool;
        } while (!bool);
        localObject = ((a)localObject).callbacks.iterator();
        for (;;)
        {
          i = bool;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((Iterator)localObject).next();
        }
      }
    });
    AppMethodBeat.o(182028);
  }
  
  public void setVoiceHelper(a parama)
  {
    AppMethodBeat.i(182030);
    this.uwC = parama;
    parama = this.uwC;
    Iterator localIterator = parama.callbacks.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (this != (a.a)localIterator.next());
    for (;;)
    {
      AppMethodBeat.o(182030);
      return;
      parama.callbacks.add(this);
    }
  }
  
  public final class a
    extends MMHandler
  {
    boolean isPaused;
    int jUG;
    float uwF;
    float uwG;
    int uwH;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void Jl(int paramInt)
    {
      AppMethodBeat.i(182017);
      this.isPaused = false;
      this.uwF = com.tencent.mm.plugin.fav.a.b.Kc(paramInt);
      this.uwG = this.uwF;
      this.uwH = com.tencent.mm.ci.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.a(VoiceView.this).setText(m.N(VoiceView.this.getContext(), (int)(this.uwF - this.uwG)));
      VoiceView.b(VoiceView.this).setText(m.N(VoiceView.this.getContext(), (int)this.uwF));
      VoiceView.c(VoiceView.this).setImageResource(d.g.voicepost_beginicon);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(d.h.app_play));
      VoiceView.d(VoiceView.this).setWidth(this.uwH);
      AppMethodBeat.o(182017);
    }
    
    public final void aMU()
    {
      AppMethodBeat.i(182019);
      this.jUG = ((int)((1.0F - this.uwG / this.uwF) * (VoiceView.f(VoiceView.this).getWidth() - this.uwH)) + this.uwH);
      VoiceView.a(VoiceView.this).setText(m.N(VoiceView.this.getContext(), (int)(this.uwF - this.uwG)));
      VoiceView.b(VoiceView.this).setText(m.N(VoiceView.this.getContext(), (int)this.uwF));
      VoiceView.d(VoiceView.this).setWidth(this.jUG);
      AppMethodBeat.o(182019);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(182021);
      this.uwG = Math.max(0.0F, this.uwG - 0.256F);
      aMU();
      if (this.uwG <= 0.1F)
      {
        AppMethodBeat.o(182021);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(182021);
    }
    
    @SuppressLint({"ResourceType"})
    public final void mB(boolean paramBoolean)
    {
      AppMethodBeat.i(182020);
      this.uwH = com.tencent.mm.ci.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.c(VoiceView.this).setImageResource(d.g.voicepost_beginicon);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(d.h.app_play));
      aMU();
      if (paramBoolean)
      {
        VoiceView.c(VoiceView.this).setImageResource(d.g.voicepost_pauseicon);
        VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(d.h.app_pause));
        sendEmptyMessage(4096);
      }
      AppMethodBeat.o(182020);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(182018);
      this.isPaused = false;
      removeMessages(4096);
      Jl(VoiceView.e(VoiceView.this));
      AppMethodBeat.o(182018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.VoiceView
 * JD-Core Version:    0.7.0.1
 */