package com.tencent.mm.plugin.editor.widget.voiceview;

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
import com.tencent.mm.am.j;
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
import com.tencent.mm.ui.base.aa;
import java.util.Iterator;
import java.util.List;

public class VoiceView
  extends FrameLayout
  implements a.a
{
  public int duration;
  public int hIY;
  public View maskView;
  public String path;
  private ViewGroup xCX;
  TextView xCY;
  private ImageButton xCZ;
  private TextView xDa;
  public a xDb;
  public a xDc;
  private TextView xxU;
  
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
  
  private void dxF()
  {
    AppMethodBeat.i(182029);
    this.xDc.stop();
    this.xCY.setKeepScreenOn(false);
    AppMethodBeat.o(182029);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(182024);
    LayoutInflater.from(paramContext).inflate(d.f.xwr, this, true);
    AppMethodBeat.o(182024);
  }
  
  public final void anE(String paramString)
  {
    AppMethodBeat.i(182025);
    if (!this.path.equals(paramString)) {
      dxF();
    }
    AppMethodBeat.o(182025);
  }
  
  public final void dxA()
  {
    AppMethodBeat.i(182026);
    dxF();
    AppMethodBeat.o(182026);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(182027);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.xDc.isPaused) });
    if (this.xDc.isPaused) {
      this.xDc.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182015);
          VoiceView.g(VoiceView.this).bgE();
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
    this.xCX = ((ViewGroup)findViewById(d.e.voice_player_progress_bg));
    this.xxU = ((TextView)findViewById(d.e.voice_player_length));
    this.xDa = ((TextView)findViewById(d.e.voice_player_total_length));
    this.xCY = ((TextView)findViewById(d.e.voice_player_progress));
    this.xCZ = ((ImageButton)findViewById(d.e.voice_player_btn));
    this.maskView = findViewById(d.e.gdi);
    this.xDc = new a((byte)0);
    this.xCZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((com.tencent.mm.n.a.dm(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dl(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dp(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if ((!e.aPU()) && (!Util.isNullOrNil(VoiceView.h(VoiceView.this))))
        {
          aa.j(paramAnonymousView.getContext(), null);
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
        if (VoiceView.i(VoiceView.this).dxE())
        {
          paramAnonymousView = VoiceView.this;
          Log.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.xDb;
          Log.i("MicroMsg.RecordVoiceHelper", "pause play");
          MMEntryLock.unlock("keep_app_silent");
          if (((a)localObject).xCQ == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.xDc;
            ((VoiceView.a)localObject).isPaused = true;
            ((VoiceView.a)localObject).removeMessages(4096);
            VoiceView.c(((VoiceView.a)localObject).xDd).setImageResource(d.g.voicepost_beginicon);
            VoiceView.c(((VoiceView.a)localObject).xDd).setContentDescription(((VoiceView.a)localObject).xDd.getContext().getResources().getString(d.h.app_play));
            paramAnonymousView.xCY.setKeepScreenOn(false);
            break;
            if (((a)localObject).xCQ.pause())
            {
              localObject = ((a)localObject).bPE.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = VoiceView.this;
        Log.i("MicroMsg.NoteVoiceView", "resume play");
        localObject = paramAnonymousView.xDb;
        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
        MMEntryLock.lock("keep_app_silent");
        int i;
        if (((a)localObject).xCQ == null)
        {
          Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.xDc;
          ((VoiceView.a)localObject).isPaused = false;
          ((VoiceView.a)localObject).sendEmptyMessage(4096);
          VoiceView.c(((VoiceView.a)localObject).xDd).setImageResource(d.g.voicepost_pauseicon);
          VoiceView.c(((VoiceView.a)localObject).xDd).setContentDescription(((VoiceView.a)localObject).xDd.getContext().getResources().getString(d.h.app_pause));
          paramAnonymousView.xCY.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          VoiceView.j(VoiceView.this);
          break;
          bool = ((a)localObject).xCQ.resume();
          i = bool;
        } while (!bool);
        localObject = ((a)localObject).bPE.iterator();
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
    this.xDb = parama;
    parama = this.xDb;
    Iterator localIterator = parama.bPE.iterator();
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
      parama.bPE.add(this);
    }
  }
  
  public final class a
    extends MMHandler
  {
    boolean isPaused;
    int muX;
    float xDe;
    float xDf;
    int xDg;
    
    private a() {}
    
    public final void bgE()
    {
      AppMethodBeat.i(182019);
      this.muX = ((int)((1.0F - this.xDf / this.xDe) * (VoiceView.f(VoiceView.this).getWidth() - this.xDg)) + this.xDg);
      VoiceView.a(VoiceView.this).setText(m.Q(VoiceView.this.getContext(), (int)(this.xDe - this.xDf)));
      VoiceView.b(VoiceView.this).setText(m.Q(VoiceView.this.getContext(), (int)this.xDe));
      VoiceView.d(VoiceView.this).setWidth(this.muX);
      AppMethodBeat.o(182019);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(182021);
      this.xDf = Math.max(0.0F, this.xDf - 0.256F);
      bgE();
      if (this.xDf <= 0.1F)
      {
        AppMethodBeat.o(182021);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(182021);
    }
    
    public final void hi(int paramInt)
    {
      AppMethodBeat.i(182017);
      this.isPaused = false;
      this.xDe = com.tencent.mm.plugin.fav.a.b.mA(paramInt);
      this.xDf = this.xDe;
      this.xDg = com.tencent.mm.cd.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.a(VoiceView.this).setText(m.Q(VoiceView.this.getContext(), (int)(this.xDe - this.xDf)));
      VoiceView.b(VoiceView.this).setText(m.Q(VoiceView.this.getContext(), (int)this.xDe));
      VoiceView.c(VoiceView.this).setImageResource(d.g.voicepost_beginicon);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(d.h.app_play));
      VoiceView.d(VoiceView.this).setWidth(this.xDg);
      AppMethodBeat.o(182017);
    }
    
    public final void nX(boolean paramBoolean)
    {
      AppMethodBeat.i(182020);
      this.xDg = com.tencent.mm.cd.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.c(VoiceView.this).setImageResource(d.g.voicepost_beginicon);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(d.h.app_play));
      bgE();
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
      hi(VoiceView.e(VoiceView.this));
      AppMethodBeat.o(182018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.VoiceView
 * JD-Core Version:    0.7.0.1
 */