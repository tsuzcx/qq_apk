package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewPropertyAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

public final class b
{
  MMActivity fNT;
  public ProgressBar gqv;
  public a tOo;
  public boolean tOp;
  public FTSVoiceInputLayoutImpl tOq;
  public TextView tOr;
  long tOs;
  long tOt;
  long tOu;
  private FTSVoiceInputLayoutImpl.a tOv;
  Toast tOw;
  private VoiceInputLayout.a tOx;
  
  public b(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(112303);
    this.tOp = false;
    this.tOv = new FTSVoiceInputLayoutImpl.a()
    {
      String tOy = "";
      String tOz = "";
      
      private void cWK()
      {
        AppMethodBeat.i(112299);
        cWL();
        b.this.tOr.setText(this.tOy);
        b.this.gqv.setVisibility(0);
        b.this.tOo.alK(this.tOy);
        AppMethodBeat.o(112299);
      }
      
      private void cWL()
      {
        AppMethodBeat.i(112300);
        if (this.tOy.length() > 0) {
          this.tOy = this.tOy.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
        }
        AppMethodBeat.o(112300);
      }
      
      private void report()
      {
        AppMethodBeat.i(112301);
        b.this.tOu = System.currentTimeMillis();
        b localb = b.this;
        long l1;
        if (b.this.tOt > 0L)
        {
          l1 = b.this.tOt;
          localb.tOt = l1;
          if (!bu.isNullOrNil(this.tOy)) {
            break label219;
          }
        }
        label219:
        for (int i = 2;; i = 1)
        {
          l1 = b.this.tOt - b.this.tOs;
          long l2 = b.this.tOu - b.this.tOs;
          g.yxI.f(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.tEn), Long.valueOf(l1), Long.valueOf(l2) });
          ae.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.tEn), Long.valueOf(l1), Long.valueOf(l2) });
          b.this.tOs = 0L;
          b.this.tOt = 0L;
          b.this.tOu = 0L;
          AppMethodBeat.o(112301);
          return;
          l1 = b.this.tOu;
          break;
        }
      }
      
      public final void Hx(int paramAnonymousInt)
      {
        AppMethodBeat.i(112298);
        b.this.tOp = false;
        report();
        if (paramAnonymousInt == 12)
        {
          b.this.tOo.b(false, true, this.tOy);
          AppMethodBeat.o(112298);
          return;
        }
        b.this.tOo.b(false, false, this.tOy);
        AppMethodBeat.o(112298);
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(112297);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          this.tOy = paramAnonymousArrayOfString[0];
          ae.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.tOy);
          cWK();
        }
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()) && (paramAnonymousList.iterator().hasNext()))
        {
          this.tOz = ((String)paramAnonymousList.iterator().next());
          ae.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.tOz });
        }
        AppMethodBeat.o(112297);
      }
      
      public final void cWD()
      {
        AppMethodBeat.i(112290);
        this.tOy = "";
        this.tOz = "";
        ae.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
        g.yxI.f(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.tEn), Integer.valueOf(1) });
        ae.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.tEn), Integer.valueOf(1) });
        b.this.tOp = true;
        b.this.tOo.cWn();
        AppMethodBeat.o(112290);
      }
      
      public final void cWE()
      {
        AppMethodBeat.i(112291);
        b.this.tOt = System.currentTimeMillis();
        if ((b.this.tOp) && (!bu.isNullOrNil(this.tOy))) {
          b.this.cWC();
        }
        AppMethodBeat.o(112291);
      }
      
      public final void cWF()
      {
        AppMethodBeat.i(112292);
        b.this.tOs = System.currentTimeMillis();
        AppMethodBeat.o(112292);
      }
      
      public final void cWG()
      {
        AppMethodBeat.i(112293);
        ae.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
        AppMethodBeat.o(112293);
      }
      
      public final void cWH()
      {
        AppMethodBeat.i(112294);
        ae.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
        AppMethodBeat.o(112294);
      }
      
      public final void cWI()
      {
        AppMethodBeat.i(112295);
        ae.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
        AppMethodBeat.o(112295);
      }
      
      public final void cWJ()
      {
        AppMethodBeat.i(112296);
        ae.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
        report();
        b.this.tOp = false;
        cWK();
        b.this.tOo.alL(this.tOy);
        this.tOy = "";
        this.tOz = "";
        AppMethodBeat.o(112296);
      }
    };
    this.tOx = new VoiceInputLayout.a()
    {
      public final void cWM()
      {
        AppMethodBeat.i(112302);
        b localb = b.this;
        if (localb.tOw != null) {
          localb.tOw.cancel();
        }
        localb.tOw = Toast.makeText(localb.fNT, localb.fNT.getResources().getString(2131759725), 0);
        localb.tOw.setGravity(17, 0, 0);
        localb.tOw.show();
        b.this.tOo.b(true, false, "");
        AppMethodBeat.o(112302);
      }
    };
    this.fNT = ((MMActivity)paramContext);
    this.tOq = paramFTSVoiceInputLayoutImpl;
    this.tOr = paramTextView;
    this.gqv = paramProgressBar;
    this.tOq.setFTSVoiceDetectListener(this.tOv);
    this.tOq.setLongClickLisnter(this.tOx);
    AppMethodBeat.o(112303);
  }
  
  public final void cWC()
  {
    AppMethodBeat.i(112304);
    this.tOq.setVisibility(8);
    AppMethodBeat.o(112304);
  }
  
  public final void show()
  {
    AppMethodBeat.i(112305);
    if (!ad.fom().equals("zh_CN"))
    {
      AppMethodBeat.o(112305);
      return;
    }
    this.tOq.setAlpha(0.0F);
    this.tOq.animate().alpha(1.0F).setDuration(500L).start();
    this.tOq.setVisibility(0);
    this.gqv.setVisibility(8);
    this.tOr.setText("");
    AppMethodBeat.o(112305);
  }
  
  public static abstract interface a
  {
    public abstract void alK(String paramString);
    
    public abstract void alL(String paramString);
    
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void cWn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */