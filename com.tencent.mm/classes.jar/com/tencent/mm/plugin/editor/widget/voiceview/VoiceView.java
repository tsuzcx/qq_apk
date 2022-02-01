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
import com.tencent.mm.ak.h;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class VoiceView
  extends FrameLayout
  implements a.a
{
  public int dui;
  public int duration;
  public View hcH;
  private TextView pAc;
  private ViewGroup pFb;
  TextView pFc;
  private ImageButton pFd;
  private TextView pFe;
  public a pFf;
  public a pFg;
  public String path;
  
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
  
  private void cgT()
  {
    AppMethodBeat.i(182029);
    this.pFg.stop();
    this.pFc.setKeepScreenOn(false);
    AppMethodBeat.o(182029);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(182024);
    LayoutInflater.from(paramContext).inflate(2131493750, this, true);
    AppMethodBeat.o(182024);
  }
  
  public final void abP(String paramString)
  {
    AppMethodBeat.i(182025);
    if (!this.path.equals(paramString)) {
      cgT();
    }
    AppMethodBeat.o(182025);
  }
  
  public final void cgO()
  {
    AppMethodBeat.i(182026);
    cgT();
    AppMethodBeat.o(182026);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(182027);
    super.onConfigurationChanged(paramConfiguration);
    ae.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.pFg.isPaused) });
    if (this.pFg.isPaused) {
      this.pFg.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182015);
          VoiceView.g(VoiceView.this).amH();
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
    this.pFb = ((ViewGroup)findViewById(2131306507));
    this.pAc = ((TextView)findViewById(2131306505));
    this.pFe = ((TextView)findViewById(2131306508));
    this.pFc = ((TextView)findViewById(2131306506));
    this.pFd = ((ImageButton)findViewById(2131306504));
    this.hcH = findViewById(2131306547);
    this.pFg = new a((byte)0);
    this.pFd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((com.tencent.mm.r.a.ch(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cj(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if ((!e.abo()) && (!bu.isNullOrNil(VoiceView.h(VoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if (!bu.bI(VoiceView.h(VoiceView.this), "").equals(VoiceView.i(VoiceView.this).path))
        {
          VoiceView.j(VoiceView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if (VoiceView.i(VoiceView.this).cgS())
        {
          paramAnonymousView = VoiceView.this;
          ae.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.pFf;
          ae.i("MicroMsg.RecordVoiceHelper", "pause play");
          ao.aRS("keep_app_silent");
          if (((a)localObject).pEU == null) {
            ae.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.pFg;
            ((VoiceView.a)localObject).isPaused = true;
            ((VoiceView.a)localObject).removeMessages(4096);
            VoiceView.c(((VoiceView.a)localObject).pFh).setImageResource(2131691385);
            VoiceView.c(((VoiceView.a)localObject).pFh).setContentDescription(((VoiceView.a)localObject).pFh.getContext().getResources().getString(2131755856));
            paramAnonymousView.pFc.setKeepScreenOn(false);
            break;
            if (((a)localObject).pEU.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = VoiceView.this;
        ae.i("MicroMsg.NoteVoiceView", "resume play");
        localObject = paramAnonymousView.pFf;
        ae.i("MicroMsg.RecordVoiceHelper", "resume play");
        ao.aRR("keep_app_silent");
        int i;
        if (((a)localObject).pEU == null)
        {
          ae.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.pFg;
          ((VoiceView.a)localObject).isPaused = false;
          ((VoiceView.a)localObject).sendEmptyMessage(4096);
          VoiceView.c(((VoiceView.a)localObject).pFh).setImageResource(2131691386);
          VoiceView.c(((VoiceView.a)localObject).pFh).setContentDescription(((VoiceView.a)localObject).pFh.getContext().getResources().getString(2131755838));
          paramAnonymousView.pFc.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          VoiceView.j(VoiceView.this);
          break;
          bool = ((a)localObject).pEU.resume();
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
    this.pFf = parama;
    parama = this.pFf;
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
    extends aq
  {
    int gvT;
    boolean isPaused;
    float pFi;
    float pFj;
    int pFk;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void BT(int paramInt)
    {
      AppMethodBeat.i(182017);
      this.isPaused = false;
      this.pFi = com.tencent.mm.plugin.fav.a.b.vK(paramInt);
      this.pFj = this.pFi;
      this.pFk = com.tencent.mm.cb.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.a(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)(this.pFi - this.pFj)));
      VoiceView.b(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)this.pFi));
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      VoiceView.d(VoiceView.this).setWidth(this.pFk);
      AppMethodBeat.o(182017);
    }
    
    public final void amH()
    {
      AppMethodBeat.i(182019);
      this.gvT = ((int)((1.0F - this.pFj / this.pFi) * (VoiceView.f(VoiceView.this).getWidth() - this.pFk)) + this.pFk);
      VoiceView.a(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)(this.pFi - this.pFj)));
      VoiceView.b(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)this.pFi));
      VoiceView.d(VoiceView.this).setWidth(this.gvT);
      AppMethodBeat.o(182019);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(182021);
      this.pFj = Math.max(0.0F, this.pFj - 0.256F);
      amH();
      if (this.pFj <= 0.1F)
      {
        AppMethodBeat.o(182021);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(182021);
    }
    
    @SuppressLint({"ResourceType"})
    public final void kn(boolean paramBoolean)
    {
      AppMethodBeat.i(182020);
      this.pFk = com.tencent.mm.cb.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      amH();
      if (paramBoolean)
      {
        VoiceView.c(VoiceView.this).setImageResource(2131691386);
        VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755838));
        sendEmptyMessage(4096);
      }
      AppMethodBeat.o(182020);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(182018);
      this.isPaused = false;
      removeMessages(4096);
      BT(VoiceView.e(VoiceView.this));
      AppMethodBeat.o(182018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.VoiceView
 * JD-Core Version:    0.7.0.1
 */