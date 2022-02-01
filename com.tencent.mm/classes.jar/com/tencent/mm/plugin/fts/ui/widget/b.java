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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public ProgressBar fQC;
  MMActivity imP;
  public a rxM;
  public boolean rxN;
  public FTSVoiceInputLayoutImpl rxO;
  public TextView rxP;
  long rxQ;
  long rxR;
  long rxS;
  private FTSVoiceInputLayoutImpl.a rxT;
  Toast rxU;
  private VoiceInputLayout.a rxV;
  
  public b(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(112303);
    this.rxN = false;
    this.rxT = new FTSVoiceInputLayoutImpl.a()
    {
      String rxW = "";
      String rxX = "";
      
      private void cyA()
      {
        AppMethodBeat.i(112299);
        cyB();
        b.this.rxP.setText(this.rxW);
        b.this.fQC.setVisibility(0);
        b.this.rxM.abw(this.rxW);
        AppMethodBeat.o(112299);
      }
      
      private void cyB()
      {
        AppMethodBeat.i(112300);
        if (this.rxW.length() > 0) {
          this.rxW = this.rxW.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
        }
        AppMethodBeat.o(112300);
      }
      
      private void report()
      {
        AppMethodBeat.i(112301);
        b.this.rxS = System.currentTimeMillis();
        b localb = b.this;
        long l1;
        if (b.this.rxR > 0L)
        {
          l1 = b.this.rxR;
          localb.rxR = l1;
          if (!bt.isNullOrNil(this.rxW)) {
            break label219;
          }
        }
        label219:
        for (int i = 2;; i = 1)
        {
          l1 = b.this.rxR - b.this.rxQ;
          long l2 = b.this.rxS - b.this.rxQ;
          h.vKh.f(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.rob), Long.valueOf(l1), Long.valueOf(l2) });
          ad.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.rob), Long.valueOf(l1), Long.valueOf(l2) });
          b.this.rxQ = 0L;
          b.this.rxR = 0L;
          b.this.rxS = 0L;
          AppMethodBeat.o(112301);
          return;
          l1 = b.this.rxS;
          break;
        }
      }
      
      public final void DP(int paramAnonymousInt)
      {
        AppMethodBeat.i(112298);
        b.this.rxN = false;
        report();
        if (paramAnonymousInt == 12)
        {
          b.this.rxM.a(false, true, this.rxW);
          AppMethodBeat.o(112298);
          return;
        }
        b.this.rxM.a(false, false, this.rxW);
        AppMethodBeat.o(112298);
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(112297);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          this.rxW = paramAnonymousArrayOfString[0];
          ad.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.rxW);
          cyA();
        }
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()) && (paramAnonymousList.iterator().hasNext()))
        {
          this.rxX = ((String)paramAnonymousList.iterator().next());
          ad.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.rxX });
        }
        AppMethodBeat.o(112297);
      }
      
      public final void cyt()
      {
        AppMethodBeat.i(112290);
        this.rxW = "";
        this.rxX = "";
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
        h.vKh.f(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.rob), Integer.valueOf(1) });
        ad.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.rob), Integer.valueOf(1) });
        b.this.rxN = true;
        b.this.rxM.cyd();
        AppMethodBeat.o(112290);
      }
      
      public final void cyu()
      {
        AppMethodBeat.i(112291);
        b.this.rxR = System.currentTimeMillis();
        if ((b.this.rxN) && (!bt.isNullOrNil(this.rxW))) {
          b.this.cys();
        }
        AppMethodBeat.o(112291);
      }
      
      public final void cyv()
      {
        AppMethodBeat.i(112292);
        b.this.rxQ = System.currentTimeMillis();
        AppMethodBeat.o(112292);
      }
      
      public final void cyw()
      {
        AppMethodBeat.i(112293);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
        AppMethodBeat.o(112293);
      }
      
      public final void cyx()
      {
        AppMethodBeat.i(112294);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
        AppMethodBeat.o(112294);
      }
      
      public final void cyy()
      {
        AppMethodBeat.i(112295);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
        AppMethodBeat.o(112295);
      }
      
      public final void cyz()
      {
        AppMethodBeat.i(112296);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
        report();
        b.this.rxN = false;
        cyA();
        b.this.rxM.abx(this.rxW);
        this.rxW = "";
        this.rxX = "";
        AppMethodBeat.o(112296);
      }
    };
    this.rxV = new VoiceInputLayout.a()
    {
      public final void cyC()
      {
        AppMethodBeat.i(112302);
        b localb = b.this;
        if (localb.rxU != null) {
          localb.rxU.cancel();
        }
        localb.rxU = Toast.makeText(localb.imP, localb.imP.getResources().getString(2131759725), 0);
        localb.rxU.setGravity(17, 0, 0);
        localb.rxU.show();
        b.this.rxM.a(true, false, "");
        AppMethodBeat.o(112302);
      }
    };
    this.imP = ((MMActivity)paramContext);
    this.rxO = paramFTSVoiceInputLayoutImpl;
    this.rxP = paramTextView;
    this.fQC = paramProgressBar;
    this.rxO.setFTSVoiceDetectListener(this.rxT);
    this.rxO.setLongClickLisnter(this.rxV);
    AppMethodBeat.o(112303);
  }
  
  public final void cys()
  {
    AppMethodBeat.i(112304);
    this.rxO.setVisibility(8);
    AppMethodBeat.o(112304);
  }
  
  public final void show()
  {
    AppMethodBeat.i(112305);
    if (!ac.eFu().equals("zh_CN"))
    {
      AppMethodBeat.o(112305);
      return;
    }
    this.rxO.setAlpha(0.0F);
    this.rxO.animate().alpha(1.0F).setDuration(500L).start();
    this.rxO.setVisibility(0);
    this.fQC.setVisibility(8);
    this.rxP.setText("");
    AppMethodBeat.o(112305);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void abw(String paramString);
    
    public abstract void abx(String paramString);
    
    public abstract void cyd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */