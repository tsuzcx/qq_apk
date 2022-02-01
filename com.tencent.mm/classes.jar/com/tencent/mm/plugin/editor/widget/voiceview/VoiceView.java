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
import com.tencent.mm.al.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.b;
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
  public int dkj;
  public int duration;
  public View lRB;
  private TextView omo;
  private ViewGroup orn;
  TextView oro;
  private ImageButton orp;
  private TextView orq;
  public a orr;
  public a ors;
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
  
  private void bTL()
  {
    AppMethodBeat.i(182029);
    this.ors.stop();
    this.oro.setKeepScreenOn(false);
    AppMethodBeat.o(182029);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(182024);
    LayoutInflater.from(paramContext).inflate(2131493750, this, true);
    AppMethodBeat.o(182024);
  }
  
  public final void Tf(String paramString)
  {
    AppMethodBeat.i(182025);
    if (!this.path.equals(paramString)) {
      bTL();
    }
    AppMethodBeat.o(182025);
  }
  
  public final void bTG()
  {
    AppMethodBeat.i(182026);
    bTL();
    AppMethodBeat.o(182026);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(182027);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.ors.isPaused) });
    if (this.ors.isPaused) {
      this.ors.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182015);
          VoiceView.g(VoiceView.this).akk();
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
    this.orn = ((ViewGroup)findViewById(2131306507));
    this.omo = ((TextView)findViewById(2131306505));
    this.orq = ((TextView)findViewById(2131306508));
    this.oro = ((TextView)findViewById(2131306506));
    this.orp = ((ImageButton)findViewById(2131306504));
    this.lRB = findViewById(2131306547);
    this.ors = new a((byte)0);
    this.orp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182016);
        if ((com.tencent.mm.r.a.ce(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cc(paramAnonymousView.getContext())))
        {
          AppMethodBeat.o(182016);
          return;
        }
        if ((!e.XG()) && (!bt.isNullOrNil(VoiceView.h(VoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(182016);
          return;
        }
        if (!bt.by(VoiceView.h(VoiceView.this), "").equals(VoiceView.i(VoiceView.this).path))
        {
          VoiceView.j(VoiceView.this);
          AppMethodBeat.o(182016);
          return;
        }
        if (VoiceView.i(VoiceView.this).bTK())
        {
          paramAnonymousView = VoiceView.this;
          ad.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.orr;
          ad.i("MicroMsg.RecordVoiceHelper", "pause play");
          an.aFy("keep_app_silent");
          if (((a)localObject).org == null) {
            ad.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.ors;
            ((VoiceView.a)localObject).isPaused = true;
            ((VoiceView.a)localObject).removeMessages(4096);
            VoiceView.c(((VoiceView.a)localObject).ort).setImageResource(2131691385);
            VoiceView.c(((VoiceView.a)localObject).ort).setContentDescription(((VoiceView.a)localObject).ort.getContext().getResources().getString(2131755856));
            paramAnonymousView.oro.setKeepScreenOn(false);
            AppMethodBeat.o(182016);
            return;
            if (((a)localObject).org.pause())
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
        Object localObject = paramAnonymousView.orr;
        ad.i("MicroMsg.RecordVoiceHelper", "resume play");
        an.aFx("keep_app_silent");
        int i;
        if (((a)localObject).org == null)
        {
          ad.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.ors;
          ((VoiceView.a)localObject).isPaused = false;
          ((VoiceView.a)localObject).sendEmptyMessage(4096);
          VoiceView.c(((VoiceView.a)localObject).ort).setImageResource(2131691386);
          VoiceView.c(((VoiceView.a)localObject).ort).setContentDescription(((VoiceView.a)localObject).ort.getContext().getResources().getString(2131755838));
          paramAnonymousView.oro.setKeepScreenOn(true);
          if (i == 0) {
            VoiceView.j(VoiceView.this);
          }
          AppMethodBeat.o(182016);
          return;
          bool = ((a)localObject).org.resume();
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
    this.orr = parama;
    parama = this.orr;
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
    int fVV;
    boolean isPaused;
    float oru;
    float orv;
    int orw;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void Ah(int paramInt)
    {
      AppMethodBeat.i(182017);
      this.isPaused = false;
      this.oru = b.pI(paramInt);
      this.orv = this.oru;
      this.orw = com.tencent.mm.cd.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.a(VoiceView.this).setText(m.C(VoiceView.this.getContext(), (int)(this.oru - this.orv)));
      VoiceView.b(VoiceView.this).setText(m.C(VoiceView.this.getContext(), (int)this.oru));
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      VoiceView.d(VoiceView.this).setWidth(this.orw);
      AppMethodBeat.o(182017);
    }
    
    public final void akk()
    {
      AppMethodBeat.i(182019);
      this.fVV = ((int)((1.0F - this.orv / this.oru) * (VoiceView.f(VoiceView.this).getWidth() - this.orw)) + this.orw);
      VoiceView.a(VoiceView.this).setText(m.C(VoiceView.this.getContext(), (int)(this.oru - this.orv)));
      VoiceView.b(VoiceView.this).setText(m.C(VoiceView.this.getContext(), (int)this.oru));
      VoiceView.d(VoiceView.this).setWidth(this.fVV);
      AppMethodBeat.o(182019);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(182021);
      this.orv = Math.max(0.0F, this.orv - 0.256F);
      akk();
      if (this.orv <= 0.1F)
      {
        AppMethodBeat.o(182021);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(182021);
    }
    
    @SuppressLint({"ResourceType"})
    public final void jA(boolean paramBoolean)
    {
      AppMethodBeat.i(182020);
      this.orw = com.tencent.mm.cd.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      akk();
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
      Ah(VoiceView.e(VoiceView.this));
      AppMethodBeat.o(182018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.VoiceView
 * JD-Core Version:    0.7.0.1
 */