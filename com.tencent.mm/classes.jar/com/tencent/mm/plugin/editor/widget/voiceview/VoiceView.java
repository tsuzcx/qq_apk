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
import com.tencent.mm.al.h;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class VoiceView
  extends FrameLayout
  implements a.a
{
  public int dtc;
  public int duration;
  public View gZU;
  public String path;
  private TextView pty;
  private TextView pyA;
  public a pyB;
  public a pyC;
  private ViewGroup pyx;
  TextView pyy;
  private ImageButton pyz;
  
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
  
  private void cfD()
  {
    AppMethodBeat.i(182029);
    this.pyC.stop();
    this.pyy.setKeepScreenOn(false);
    AppMethodBeat.o(182029);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(182024);
    LayoutInflater.from(paramContext).inflate(2131493750, this, true);
    AppMethodBeat.o(182024);
  }
  
  public final void aaY(String paramString)
  {
    AppMethodBeat.i(182025);
    if (!this.path.equals(paramString)) {
      cfD();
    }
    AppMethodBeat.o(182025);
  }
  
  public final void cfy()
  {
    AppMethodBeat.i(182026);
    cfD();
    AppMethodBeat.o(182026);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(182027);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.pyC.isPaused) });
    if (this.pyC.isPaused) {
      this.pyC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182015);
          VoiceView.g(VoiceView.this).ams();
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
    this.pyx = ((ViewGroup)findViewById(2131306507));
    this.pty = ((TextView)findViewById(2131306505));
    this.pyA = ((TextView)findViewById(2131306508));
    this.pyy = ((TextView)findViewById(2131306506));
    this.pyz = ((ImageButton)findViewById(2131306504));
    this.gZU = findViewById(2131306547);
    this.pyC = new a((byte)0);
    this.pyz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((com.tencent.mm.s.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.s.a.cd(paramAnonymousView.getContext())) || (com.tencent.mm.s.a.ch(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if ((!e.abf()) && (!bt.isNullOrNil(VoiceView.h(VoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if (!bt.bI(VoiceView.h(VoiceView.this), "").equals(VoiceView.i(VoiceView.this).path))
        {
          VoiceView.j(VoiceView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if (VoiceView.i(VoiceView.this).cfC())
        {
          paramAnonymousView = VoiceView.this;
          ad.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.pyB;
          ad.i("MicroMsg.RecordVoiceHelper", "pause play");
          an.aQv("keep_app_silent");
          if (((a)localObject).pyq == null) {
            ad.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.pyC;
            ((VoiceView.a)localObject).isPaused = true;
            ((VoiceView.a)localObject).removeMessages(4096);
            VoiceView.c(((VoiceView.a)localObject).pyD).setImageResource(2131691385);
            VoiceView.c(((VoiceView.a)localObject).pyD).setContentDescription(((VoiceView.a)localObject).pyD.getContext().getResources().getString(2131755856));
            paramAnonymousView.pyy.setKeepScreenOn(false);
            break;
            if (((a)localObject).pyq.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = VoiceView.this;
        ad.i("MicroMsg.NoteVoiceView", "resume play");
        localObject = paramAnonymousView.pyB;
        ad.i("MicroMsg.RecordVoiceHelper", "resume play");
        an.aQu("keep_app_silent");
        int i;
        if (((a)localObject).pyq == null)
        {
          ad.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.pyC;
          ((VoiceView.a)localObject).isPaused = false;
          ((VoiceView.a)localObject).sendEmptyMessage(4096);
          VoiceView.c(((VoiceView.a)localObject).pyD).setImageResource(2131691386);
          VoiceView.c(((VoiceView.a)localObject).pyD).setContentDescription(((VoiceView.a)localObject).pyD.getContext().getResources().getString(2131755838));
          paramAnonymousView.pyy.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          VoiceView.j(VoiceView.this);
          break;
          bool = ((a)localObject).pyq.resume();
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
    this.pyB = parama;
    parama = this.pyB;
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
    extends ap
  {
    int gtm;
    boolean isPaused;
    float pyE;
    float pyF;
    int pyG;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void BH(int paramInt)
    {
      AppMethodBeat.i(182017);
      this.isPaused = false;
      this.pyE = com.tencent.mm.plugin.fav.a.b.vu(paramInt);
      this.pyF = this.pyE;
      this.pyG = com.tencent.mm.cc.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.a(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)(this.pyE - this.pyF)));
      VoiceView.b(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)this.pyE));
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      VoiceView.d(VoiceView.this).setWidth(this.pyG);
      AppMethodBeat.o(182017);
    }
    
    public final void ams()
    {
      AppMethodBeat.i(182019);
      this.gtm = ((int)((1.0F - this.pyF / this.pyE) * (VoiceView.f(VoiceView.this).getWidth() - this.pyG)) + this.pyG);
      VoiceView.a(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)(this.pyE - this.pyF)));
      VoiceView.b(VoiceView.this).setText(m.G(VoiceView.this.getContext(), (int)this.pyE));
      VoiceView.d(VoiceView.this).setWidth(this.gtm);
      AppMethodBeat.o(182019);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(182021);
      this.pyF = Math.max(0.0F, this.pyF - 0.256F);
      ams();
      if (this.pyF <= 0.1F)
      {
        AppMethodBeat.o(182021);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(182021);
    }
    
    @SuppressLint({"ResourceType"})
    public final void ko(boolean paramBoolean)
    {
      AppMethodBeat.i(182020);
      this.pyG = com.tencent.mm.cc.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      ams();
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
      BH(VoiceView.e(VoiceView.this));
      AppMethodBeat.o(182018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.VoiceView
 * JD-Core Version:    0.7.0.1
 */