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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public ProgressBar fUx;
  MMActivity iMV;
  public a sGE;
  public boolean sGF;
  public FTSVoiceInputLayoutImpl sGG;
  public TextView sGH;
  long sGI;
  long sGJ;
  long sGK;
  private FTSVoiceInputLayoutImpl.a sGL;
  Toast sGM;
  private VoiceInputLayout.a sGN;
  
  public b(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(112303);
    this.sGF = false;
    this.sGL = new FTSVoiceInputLayoutImpl.a()
    {
      String sGO = "";
      String sGP = "";
      
      private void cLM()
      {
        AppMethodBeat.i(112299);
        cLN();
        b.this.sGH.setText(this.sGO);
        b.this.fUx.setVisibility(0);
        b.this.sGE.ago(this.sGO);
        AppMethodBeat.o(112299);
      }
      
      private void cLN()
      {
        AppMethodBeat.i(112300);
        if (this.sGO.length() > 0) {
          this.sGO = this.sGO.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
        }
        AppMethodBeat.o(112300);
      }
      
      private void report()
      {
        AppMethodBeat.i(112301);
        b.this.sGK = System.currentTimeMillis();
        b localb = b.this;
        long l1;
        if (b.this.sGJ > 0L)
        {
          l1 = b.this.sGJ;
          localb.sGJ = l1;
          if (!bs.isNullOrNil(this.sGO)) {
            break label219;
          }
        }
        label219:
        for (int i = 2;; i = 1)
        {
          l1 = b.this.sGJ - b.this.sGI;
          long l2 = b.this.sGK - b.this.sGI;
          h.wUl.f(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.swV), Long.valueOf(l1), Long.valueOf(l2) });
          ac.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.swV), Long.valueOf(l1), Long.valueOf(l2) });
          b.this.sGI = 0L;
          b.this.sGJ = 0L;
          b.this.sGK = 0L;
          AppMethodBeat.o(112301);
          return;
          l1 = b.this.sGK;
          break;
        }
      }
      
      public final void FL(int paramAnonymousInt)
      {
        AppMethodBeat.i(112298);
        b.this.sGF = false;
        report();
        if (paramAnonymousInt == 12)
        {
          b.this.sGE.a(false, true, this.sGO);
          AppMethodBeat.o(112298);
          return;
        }
        b.this.sGE.a(false, false, this.sGO);
        AppMethodBeat.o(112298);
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(112297);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          this.sGO = paramAnonymousArrayOfString[0];
          ac.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.sGO);
          cLM();
        }
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()) && (paramAnonymousList.iterator().hasNext()))
        {
          this.sGP = ((String)paramAnonymousList.iterator().next());
          ac.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.sGP });
        }
        AppMethodBeat.o(112297);
      }
      
      public final void cLF()
      {
        AppMethodBeat.i(112290);
        this.sGO = "";
        this.sGP = "";
        ac.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
        h.wUl.f(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.swV), Integer.valueOf(1) });
        ac.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.swV), Integer.valueOf(1) });
        b.this.sGF = true;
        b.this.sGE.cLp();
        AppMethodBeat.o(112290);
      }
      
      public final void cLG()
      {
        AppMethodBeat.i(112291);
        b.this.sGJ = System.currentTimeMillis();
        if ((b.this.sGF) && (!bs.isNullOrNil(this.sGO))) {
          b.this.cLE();
        }
        AppMethodBeat.o(112291);
      }
      
      public final void cLH()
      {
        AppMethodBeat.i(112292);
        b.this.sGI = System.currentTimeMillis();
        AppMethodBeat.o(112292);
      }
      
      public final void cLI()
      {
        AppMethodBeat.i(112293);
        ac.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
        AppMethodBeat.o(112293);
      }
      
      public final void cLJ()
      {
        AppMethodBeat.i(112294);
        ac.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
        AppMethodBeat.o(112294);
      }
      
      public final void cLK()
      {
        AppMethodBeat.i(112295);
        ac.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
        AppMethodBeat.o(112295);
      }
      
      public final void cLL()
      {
        AppMethodBeat.i(112296);
        ac.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
        report();
        b.this.sGF = false;
        cLM();
        b.this.sGE.agp(this.sGO);
        this.sGO = "";
        this.sGP = "";
        AppMethodBeat.o(112296);
      }
    };
    this.sGN = new VoiceInputLayout.a()
    {
      public final void cLO()
      {
        AppMethodBeat.i(112302);
        b localb = b.this;
        if (localb.sGM != null) {
          localb.sGM.cancel();
        }
        localb.sGM = Toast.makeText(localb.iMV, localb.iMV.getResources().getString(2131759725), 0);
        localb.sGM.setGravity(17, 0, 0);
        localb.sGM.show();
        b.this.sGE.a(true, false, "");
        AppMethodBeat.o(112302);
      }
    };
    this.iMV = ((MMActivity)paramContext);
    this.sGG = paramFTSVoiceInputLayoutImpl;
    this.sGH = paramTextView;
    this.fUx = paramProgressBar;
    this.sGG.setFTSVoiceDetectListener(this.sGL);
    this.sGG.setLongClickLisnter(this.sGN);
    AppMethodBeat.o(112303);
  }
  
  public final void cLE()
  {
    AppMethodBeat.i(112304);
    this.sGG.setVisibility(8);
    AppMethodBeat.o(112304);
  }
  
  public final void show()
  {
    AppMethodBeat.i(112305);
    if (!ab.eUO().equals("zh_CN"))
    {
      AppMethodBeat.o(112305);
      return;
    }
    this.sGG.setAlpha(0.0F);
    this.sGG.animate().alpha(1.0F).setDuration(500L).start();
    this.sGG.setVisibility(0);
    this.fUx.setVisibility(8);
    this.sGH.setText("");
    AppMethodBeat.o(112305);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void ago(String paramString);
    
    public abstract void agp(String paramString);
    
    public abstract void cLp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */