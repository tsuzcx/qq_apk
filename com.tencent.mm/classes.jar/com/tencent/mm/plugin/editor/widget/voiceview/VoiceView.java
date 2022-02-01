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
import com.tencent.mm.ak.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import java.util.List;

public class VoiceView
  extends FrameLayout
  implements a.a
{
  public int dLt;
  public int duration;
  public View maskView;
  public String path;
  private TextView qPt;
  private ViewGroup qUs;
  TextView qUt;
  private ImageButton qUu;
  private TextView qUv;
  public a qUw;
  public a qUx;
  
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
  
  private void cEG()
  {
    AppMethodBeat.i(182029);
    this.qUx.stop();
    this.qUt.setKeepScreenOn(false);
    AppMethodBeat.o(182029);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(182024);
    LayoutInflater.from(paramContext).inflate(2131493899, this, true);
    AppMethodBeat.o(182024);
  }
  
  public final void alV(String paramString)
  {
    AppMethodBeat.i(182025);
    if (!this.path.equals(paramString)) {
      cEG();
    }
    AppMethodBeat.o(182025);
  }
  
  public final void cEB()
  {
    AppMethodBeat.i(182026);
    cEG();
    AppMethodBeat.o(182026);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(182027);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.qUx.isPaused) });
    if (this.qUx.isPaused) {
      this.qUx.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182015);
          VoiceView.g(VoiceView.this).aED();
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
    this.qUs = ((ViewGroup)findViewById(2131309967));
    this.qPt = ((TextView)findViewById(2131309965));
    this.qUv = ((TextView)findViewById(2131309968));
    this.qUt = ((TextView)findViewById(2131309966));
    this.qUu = ((ImageButton)findViewById(2131309964));
    this.maskView = findViewById(2131310007);
    this.qUx = new a((byte)0);
    this.qUu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((com.tencent.mm.q.a.cC(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cA(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cE(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182016);
          return;
        }
        if ((!e.apn()) && (!Util.isNullOrNil(VoiceView.h(VoiceView.this))))
        {
          u.g(paramAnonymousView.getContext(), null);
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
        if (VoiceView.i(VoiceView.this).cEF())
        {
          paramAnonymousView = VoiceView.this;
          Log.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.qUw;
          Log.i("MicroMsg.RecordVoiceHelper", "pause play");
          MMEntryLock.unlock("keep_app_silent");
          if (((a)localObject).qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.qUx;
            ((VoiceView.a)localObject).isPaused = true;
            ((VoiceView.a)localObject).removeMessages(4096);
            VoiceView.c(((VoiceView.a)localObject).qUy).setImageResource(2131691719);
            VoiceView.c(((VoiceView.a)localObject).qUy).setContentDescription(((VoiceView.a)localObject).qUy.getContext().getResources().getString(2131755942));
            paramAnonymousView.qUt.setKeepScreenOn(false);
            break;
            if (((a)localObject).qUl.pause())
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
        localObject = paramAnonymousView.qUw;
        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
        MMEntryLock.lock("keep_app_silent");
        int i;
        if (((a)localObject).qUl == null)
        {
          Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.qUx;
          ((VoiceView.a)localObject).isPaused = false;
          ((VoiceView.a)localObject).sendEmptyMessage(4096);
          VoiceView.c(((VoiceView.a)localObject).qUy).setImageResource(2131691720);
          VoiceView.c(((VoiceView.a)localObject).qUy).setContentDescription(((VoiceView.a)localObject).qUy.getContext().getResources().getString(2131755924));
          paramAnonymousView.qUt.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          VoiceView.j(VoiceView.this);
          break;
          bool = ((a)localObject).qUl.resume();
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
    this.qUw = parama;
    parama = this.qUw;
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
    int hiI;
    boolean isPaused;
    float qUA;
    int qUB;
    float qUz;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void FD(int paramInt)
    {
      AppMethodBeat.i(182017);
      this.isPaused = false;
      this.qUz = com.tencent.mm.plugin.fav.a.b.DO(paramInt);
      this.qUA = this.qUz;
      this.qUB = com.tencent.mm.cb.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.a(VoiceView.this).setText(m.J(VoiceView.this.getContext(), (int)(this.qUz - this.qUA)));
      VoiceView.b(VoiceView.this).setText(m.J(VoiceView.this.getContext(), (int)this.qUz));
      VoiceView.c(VoiceView.this).setImageResource(2131691719);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755942));
      VoiceView.d(VoiceView.this).setWidth(this.qUB);
      AppMethodBeat.o(182017);
    }
    
    public final void aED()
    {
      AppMethodBeat.i(182019);
      this.hiI = ((int)((1.0F - this.qUA / this.qUz) * (VoiceView.f(VoiceView.this).getWidth() - this.qUB)) + this.qUB);
      VoiceView.a(VoiceView.this).setText(m.J(VoiceView.this.getContext(), (int)(this.qUz - this.qUA)));
      VoiceView.b(VoiceView.this).setText(m.J(VoiceView.this.getContext(), (int)this.qUz));
      VoiceView.d(VoiceView.this).setWidth(this.hiI);
      AppMethodBeat.o(182019);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(182021);
      this.qUA = Math.max(0.0F, this.qUA - 0.256F);
      aED();
      if (this.qUA <= 0.1F)
      {
        AppMethodBeat.o(182021);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(182021);
    }
    
    @SuppressLint({"ResourceType"})
    public final void lp(boolean paramBoolean)
    {
      AppMethodBeat.i(182020);
      this.qUB = com.tencent.mm.cb.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.c(VoiceView.this).setImageResource(2131691719);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755942));
      aED();
      if (paramBoolean)
      {
        VoiceView.c(VoiceView.this).setImageResource(2131691720);
        VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755924));
        sendEmptyMessage(4096);
      }
      AppMethodBeat.o(182020);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(182018);
      this.isPaused = false;
      removeMessages(4096);
      FD(VoiceView.e(VoiceView.this));
      AppMethodBeat.o(182018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.VoiceView
 * JD-Core Version:    0.7.0.1
 */