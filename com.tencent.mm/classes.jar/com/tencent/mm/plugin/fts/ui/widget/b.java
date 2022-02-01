package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewPropertyAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public FTSVoiceInputLayoutImpl BRA;
  public TextView BRB;
  long BRC;
  long BRD;
  long BRE;
  private FTSVoiceInputLayoutImpl.a BRF;
  Toast BRG;
  private VoiceInputLayout.a BRH;
  public a BRy;
  public boolean BRz;
  MMActivity iXq;
  public ProgressBar jMF;
  
  public b(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(112303);
    this.BRz = false;
    this.BRF = new FTSVoiceInputLayoutImpl.a()
    {
      String BRI = "";
      String BRJ = "";
      
      private void est()
      {
        AppMethodBeat.i(112299);
        esu();
        b.this.BRB.setText(this.BRI);
        b.this.jMF.setVisibility(0);
        b.this.BRy.aIk(this.BRI);
        AppMethodBeat.o(112299);
      }
      
      private void esu()
      {
        AppMethodBeat.i(112300);
        if (this.BRI.length() > 0) {
          this.BRI = this.BRI.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
        }
        AppMethodBeat.o(112300);
      }
      
      private void report()
      {
        AppMethodBeat.i(112301);
        b.this.BRE = System.currentTimeMillis();
        b localb = b.this;
        long l1;
        if (b.this.BRD > 0L)
        {
          l1 = b.this.BRD;
          localb.BRD = l1;
          if (!Util.isNullOrNil(this.BRI)) {
            break label219;
          }
        }
        label219:
        for (int i = 2;; i = 1)
        {
          l1 = b.this.BRD - b.this.BRC;
          long l2 = b.this.BRE - b.this.BRC;
          h.IzE.a(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.BHi), Long.valueOf(l1), Long.valueOf(l2) });
          Log.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.BHi), Long.valueOf(l1), Long.valueOf(l2) });
          b.this.BRC = 0L;
          b.this.BRD = 0L;
          b.this.BRE = 0L;
          AppMethodBeat.o(112301);
          return;
          l1 = b.this.BRE;
          break;
        }
      }
      
      public final void SL(int paramAnonymousInt)
      {
        AppMethodBeat.i(112298);
        b.this.BRz = false;
        report();
        if (paramAnonymousInt == 12)
        {
          b.this.BRy.b(false, true, this.BRI);
          AppMethodBeat.o(112298);
          return;
        }
        b.this.BRy.b(false, false, this.BRI);
        AppMethodBeat.o(112298);
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(112297);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          this.BRI = paramAnonymousArrayOfString[0];
          Log.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.BRI);
          est();
        }
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()) && (paramAnonymousList.iterator().hasNext()))
        {
          this.BRJ = ((String)paramAnonymousList.iterator().next());
          Log.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.BRJ });
        }
        AppMethodBeat.o(112297);
      }
      
      public final void esm()
      {
        AppMethodBeat.i(112290);
        this.BRI = "";
        this.BRJ = "";
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
        h.IzE.a(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.BHi), Integer.valueOf(1) });
        Log.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.BHi), Integer.valueOf(1) });
        b.this.BRz = true;
        b.this.BRy.erU();
        AppMethodBeat.o(112290);
      }
      
      public final void esn()
      {
        AppMethodBeat.i(112291);
        b.this.BRD = System.currentTimeMillis();
        if ((b.this.BRz) && (!Util.isNullOrNil(this.BRI))) {
          b.this.esl();
        }
        AppMethodBeat.o(112291);
      }
      
      public final void eso()
      {
        AppMethodBeat.i(112292);
        b.this.BRC = System.currentTimeMillis();
        AppMethodBeat.o(112292);
      }
      
      public final void esp()
      {
        AppMethodBeat.i(112293);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
        AppMethodBeat.o(112293);
      }
      
      public final void esq()
      {
        AppMethodBeat.i(112294);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
        AppMethodBeat.o(112294);
      }
      
      public final void esr()
      {
        AppMethodBeat.i(112295);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
        AppMethodBeat.o(112295);
      }
      
      public final void ess()
      {
        AppMethodBeat.i(112296);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
        report();
        b.this.BRz = false;
        est();
        b.this.BRy.aIl(this.BRI);
        this.BRI = "";
        this.BRJ = "";
        AppMethodBeat.o(112296);
      }
    };
    this.BRH = new VoiceInputLayout.a()
    {
      public final void esv()
      {
        AppMethodBeat.i(112302);
        b localb = b.this;
        int i = o.g.fts_voice_input_speak_too_short;
        if (localb.BRG != null) {
          localb.BRG.cancel();
        }
        localb.BRG = Toast.makeText(localb.iXq, localb.iXq.getResources().getString(i), 0);
        localb.BRG.setGravity(17, 0, 0);
        localb.BRG.show();
        b.this.BRy.b(true, false, "");
        AppMethodBeat.o(112302);
      }
    };
    this.iXq = ((MMActivity)paramContext);
    this.BRA = paramFTSVoiceInputLayoutImpl;
    this.BRB = paramTextView;
    this.jMF = paramProgressBar;
    this.BRA.setFTSVoiceDetectListener(this.BRF);
    this.BRA.setLongClickLisnter(this.BRH);
    AppMethodBeat.o(112303);
  }
  
  public final void esl()
  {
    AppMethodBeat.i(112304);
    this.BRA.setVisibility(8);
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
    this.BRA.setAlpha(0.0F);
    this.BRA.animate().alpha(1.0F).setDuration(500L).start();
    this.BRA.setVisibility(0);
    this.jMF.setVisibility(8);
    this.BRB.setText("");
    AppMethodBeat.o(112305);
  }
  
  public static abstract interface a
  {
    public abstract void aIk(String paramString);
    
    public abstract void aIl(String paramString);
    
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void erU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */