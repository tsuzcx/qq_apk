package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewPropertyAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

public final class b
{
  MMActivity gte;
  public ProgressBar hbv;
  public a xfn;
  public boolean xfo;
  public FTSVoiceInputLayoutImpl xfp;
  public TextView xfq;
  long xfr;
  long xfs;
  long xft;
  private FTSVoiceInputLayoutImpl.a xfu;
  Toast xfv;
  private VoiceInputLayout.a xfw;
  
  public b(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(112303);
    this.xfo = false;
    this.xfu = new FTSVoiceInputLayoutImpl.a()
    {
      String xfx = "";
      String xfy = "";
      
      private void dPU()
      {
        AppMethodBeat.i(112299);
        dPV();
        b.this.xfq.setText(this.xfx);
        b.this.hbv.setVisibility(0);
        b.this.xfn.ayO(this.xfx);
        AppMethodBeat.o(112299);
      }
      
      private void dPV()
      {
        AppMethodBeat.i(112300);
        if (this.xfx.length() > 0) {
          this.xfx = this.xfx.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
        }
        AppMethodBeat.o(112300);
      }
      
      private void report()
      {
        AppMethodBeat.i(112301);
        b.this.xft = System.currentTimeMillis();
        b localb = b.this;
        long l1;
        if (b.this.xfs > 0L)
        {
          l1 = b.this.xfs;
          localb.xfs = l1;
          if (!Util.isNullOrNil(this.xfx)) {
            break label219;
          }
        }
        label219:
        for (int i = 2;; i = 1)
        {
          l1 = b.this.xfs - b.this.xfr;
          long l2 = b.this.xft - b.this.xfr;
          h.CyF.a(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.wVm), Long.valueOf(l1), Long.valueOf(l2) });
          Log.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.wVm), Long.valueOf(l1), Long.valueOf(l2) });
          b.this.xfr = 0L;
          b.this.xfs = 0L;
          b.this.xft = 0L;
          AppMethodBeat.o(112301);
          return;
          l1 = b.this.xft;
          break;
        }
      }
      
      public final void Nx(int paramAnonymousInt)
      {
        AppMethodBeat.i(112298);
        b.this.xfo = false;
        report();
        if (paramAnonymousInt == 12)
        {
          b.this.xfn.c(false, true, this.xfx);
          AppMethodBeat.o(112298);
          return;
        }
        b.this.xfn.c(false, false, this.xfx);
        AppMethodBeat.o(112298);
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(112297);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          this.xfx = paramAnonymousArrayOfString[0];
          Log.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.xfx);
          dPU();
        }
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()) && (paramAnonymousList.iterator().hasNext()))
        {
          this.xfy = ((String)paramAnonymousList.iterator().next());
          Log.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.xfy });
        }
        AppMethodBeat.o(112297);
      }
      
      public final void dPN()
      {
        AppMethodBeat.i(112290);
        this.xfx = "";
        this.xfy = "";
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
        h.CyF.a(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.wVm), Integer.valueOf(1) });
        Log.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.wVm), Integer.valueOf(1) });
        b.this.xfo = true;
        b.this.xfn.dPy();
        AppMethodBeat.o(112290);
      }
      
      public final void dPO()
      {
        AppMethodBeat.i(112291);
        b.this.xfs = System.currentTimeMillis();
        if ((b.this.xfo) && (!Util.isNullOrNil(this.xfx))) {
          b.this.dPM();
        }
        AppMethodBeat.o(112291);
      }
      
      public final void dPP()
      {
        AppMethodBeat.i(112292);
        b.this.xfr = System.currentTimeMillis();
        AppMethodBeat.o(112292);
      }
      
      public final void dPQ()
      {
        AppMethodBeat.i(112293);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
        AppMethodBeat.o(112293);
      }
      
      public final void dPR()
      {
        AppMethodBeat.i(112294);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
        AppMethodBeat.o(112294);
      }
      
      public final void dPS()
      {
        AppMethodBeat.i(112295);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
        AppMethodBeat.o(112295);
      }
      
      public final void dPT()
      {
        AppMethodBeat.i(112296);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
        report();
        b.this.xfo = false;
        dPU();
        b.this.xfn.ayP(this.xfx);
        this.xfx = "";
        this.xfy = "";
        AppMethodBeat.o(112296);
      }
    };
    this.xfw = new VoiceInputLayout.a()
    {
      public final void dPW()
      {
        AppMethodBeat.i(112302);
        b localb = b.this;
        if (localb.xfv != null) {
          localb.xfv.cancel();
        }
        localb.xfv = Toast.makeText(localb.gte, localb.gte.getResources().getString(2131761046), 0);
        localb.xfv.setGravity(17, 0, 0);
        localb.xfv.show();
        b.this.xfn.c(true, false, "");
        AppMethodBeat.o(112302);
      }
    };
    this.gte = ((MMActivity)paramContext);
    this.xfp = paramFTSVoiceInputLayoutImpl;
    this.xfq = paramTextView;
    this.hbv = paramProgressBar;
    this.xfp.setFTSVoiceDetectListener(this.xfu);
    this.xfp.setLongClickLisnter(this.xfw);
    AppMethodBeat.o(112303);
  }
  
  public final void dPM()
  {
    AppMethodBeat.i(112304);
    this.xfp.setVisibility(8);
    AppMethodBeat.o(112304);
  }
  
  public final void show()
  {
    AppMethodBeat.i(112305);
    if (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))
    {
      AppMethodBeat.o(112305);
      return;
    }
    this.xfp.setAlpha(0.0F);
    this.xfp.animate().alpha(1.0F).setDuration(500L).start();
    this.xfp.setVisibility(0);
    this.hbv.setVisibility(8);
    this.xfq.setText("");
    AppMethodBeat.o(112305);
  }
  
  public static abstract interface a
  {
    public abstract void ayO(String paramString);
    
    public abstract void ayP(String paramString);
    
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void dPy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */