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
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class VoiceView
  extends FrameLayout
  implements a.a
{
  public int dhE;
  public int duration;
  public View gGk;
  private TextView oPO;
  private ViewGroup oUN;
  TextView oUO;
  private ImageButton oUP;
  private TextView oUQ;
  public a oUR;
  public a oUS;
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
  
  private void caZ()
  {
    AppMethodBeat.i(182029);
    this.oUS.stop();
    this.oUO.setKeepScreenOn(false);
    AppMethodBeat.o(182029);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(182024);
    LayoutInflater.from(paramContext).inflate(2131493750, this, true);
    AppMethodBeat.o(182024);
  }
  
  public final void Xr(String paramString)
  {
    AppMethodBeat.i(182025);
    if (!this.path.equals(paramString)) {
      caZ();
    }
    AppMethodBeat.o(182025);
  }
  
  public final void caU()
  {
    AppMethodBeat.i(182026);
    caZ();
    AppMethodBeat.o(182026);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(182027);
    super.onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.oUS.isPaused) });
    if (this.oUS.isPaused) {
      this.oUS.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182015);
          VoiceView.g(VoiceView.this).ajG();
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
    this.oUN = ((ViewGroup)findViewById(2131306507));
    this.oPO = ((TextView)findViewById(2131306505));
    this.oUQ = ((TextView)findViewById(2131306508));
    this.oUO = ((TextView)findViewById(2131306506));
    this.oUP = ((ImageButton)findViewById(2131306504));
    this.gGk = findViewById(2131306547);
    this.oUS = new a((byte)0);
    this.oUP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182016);
        if ((com.tencent.mm.r.a.ci(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.ck(paramAnonymousView.getContext())))
        {
          AppMethodBeat.o(182016);
          return;
        }
        if ((!e.YD()) && (!bs.isNullOrNil(VoiceView.h(VoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(182016);
          return;
        }
        if (!bs.bG(VoiceView.h(VoiceView.this), "").equals(VoiceView.i(VoiceView.this).path))
        {
          VoiceView.j(VoiceView.this);
          AppMethodBeat.o(182016);
          return;
        }
        if (VoiceView.i(VoiceView.this).caY())
        {
          paramAnonymousView = VoiceView.this;
          ac.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.oUR;
          ac.i("MicroMsg.RecordVoiceHelper", "pause play");
          am.aKP("keep_app_silent");
          if (((a)localObject).oUG == null) {
            ac.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.oUS;
            ((VoiceView.a)localObject).isPaused = true;
            ((VoiceView.a)localObject).removeMessages(4096);
            VoiceView.c(((VoiceView.a)localObject).oUT).setImageResource(2131691385);
            VoiceView.c(((VoiceView.a)localObject).oUT).setContentDescription(((VoiceView.a)localObject).oUT.getContext().getResources().getString(2131755856));
            paramAnonymousView.oUO.setKeepScreenOn(false);
            AppMethodBeat.o(182016);
            return;
            if (((a)localObject).oUG.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = VoiceView.this;
        ac.i("MicroMsg.NoteVoiceView", "resume play");
        Object localObject = paramAnonymousView.oUR;
        ac.i("MicroMsg.RecordVoiceHelper", "resume play");
        am.aKO("keep_app_silent");
        int i;
        if (((a)localObject).oUG == null)
        {
          ac.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.oUS;
          ((VoiceView.a)localObject).isPaused = false;
          ((VoiceView.a)localObject).sendEmptyMessage(4096);
          VoiceView.c(((VoiceView.a)localObject).oUT).setImageResource(2131691386);
          VoiceView.c(((VoiceView.a)localObject).oUT).setContentDescription(((VoiceView.a)localObject).oUT.getContext().getResources().getString(2131755838));
          paramAnonymousView.oUO.setKeepScreenOn(true);
          if (i == 0) {
            VoiceView.j(VoiceView.this);
          }
          AppMethodBeat.o(182016);
          return;
          bool = ((a)localObject).oUG.resume();
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
    this.oUR = parama;
    parama = this.oUR;
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
    extends ao
  {
    int fZQ;
    boolean isPaused;
    float oUU;
    float oUV;
    int oUW;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void AZ(int paramInt)
    {
      AppMethodBeat.i(182017);
      this.isPaused = false;
      this.oUU = b.tx(paramInt);
      this.oUV = this.oUU;
      this.oUW = com.tencent.mm.cc.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.a(VoiceView.this).setText(m.F(VoiceView.this.getContext(), (int)(this.oUU - this.oUV)));
      VoiceView.b(VoiceView.this).setText(m.F(VoiceView.this.getContext(), (int)this.oUU));
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      VoiceView.d(VoiceView.this).setWidth(this.oUW);
      AppMethodBeat.o(182017);
    }
    
    public final void ajG()
    {
      AppMethodBeat.i(182019);
      this.fZQ = ((int)((1.0F - this.oUV / this.oUU) * (VoiceView.f(VoiceView.this).getWidth() - this.oUW)) + this.oUW);
      VoiceView.a(VoiceView.this).setText(m.F(VoiceView.this.getContext(), (int)(this.oUU - this.oUV)));
      VoiceView.b(VoiceView.this).setText(m.F(VoiceView.this.getContext(), (int)this.oUU));
      VoiceView.d(VoiceView.this).setWidth(this.fZQ);
      AppMethodBeat.o(182019);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(182021);
      this.oUV = Math.max(0.0F, this.oUV - 0.256F);
      ajG();
      if (this.oUV <= 0.1F)
      {
        AppMethodBeat.o(182021);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(182021);
    }
    
    @SuppressLint({"ResourceType"})
    public final void kd(boolean paramBoolean)
    {
      AppMethodBeat.i(182020);
      this.oUW = com.tencent.mm.cc.a.fromDPToPix(VoiceView.this.getContext(), 0);
      VoiceView.c(VoiceView.this).setImageResource(2131691385);
      VoiceView.c(VoiceView.this).setContentDescription(VoiceView.this.getContext().getResources().getString(2131755856));
      ajG();
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
      AZ(VoiceView.e(VoiceView.this));
      AppMethodBeat.o(182018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.VoiceView
 * JD-Core Version:    0.7.0.1
 */