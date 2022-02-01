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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

public final class b
{
  MMActivity fLP;
  public ProgressBar gnZ;
  public TextView tDA;
  long tDB;
  long tDC;
  long tDD;
  private FTSVoiceInputLayoutImpl.a tDE;
  Toast tDF;
  private VoiceInputLayout.a tDG;
  public a tDx;
  public boolean tDy;
  public FTSVoiceInputLayoutImpl tDz;
  
  public b(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(112303);
    this.tDy = false;
    this.tDE = new FTSVoiceInputLayoutImpl.a()
    {
      String tDH = "";
      String tDI = "";
      
      private void cUf()
      {
        AppMethodBeat.i(112299);
        cUg();
        b.this.tDA.setText(this.tDH);
        b.this.gnZ.setVisibility(0);
        b.this.tDx.akM(this.tDH);
        AppMethodBeat.o(112299);
      }
      
      private void cUg()
      {
        AppMethodBeat.i(112300);
        if (this.tDH.length() > 0) {
          this.tDH = this.tDH.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
        }
        AppMethodBeat.o(112300);
      }
      
      private void report()
      {
        AppMethodBeat.i(112301);
        b.this.tDD = System.currentTimeMillis();
        b localb = b.this;
        long l1;
        if (b.this.tDC > 0L)
        {
          l1 = b.this.tDC;
          localb.tDC = l1;
          if (!bt.isNullOrNil(this.tDH)) {
            break label219;
          }
        }
        label219:
        for (int i = 2;; i = 1)
        {
          l1 = b.this.tDC - b.this.tDB;
          long l2 = b.this.tDD - b.this.tDB;
          g.yhR.f(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.ttw), Long.valueOf(l1), Long.valueOf(l2) });
          ad.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.ttw), Long.valueOf(l1), Long.valueOf(l2) });
          b.this.tDB = 0L;
          b.this.tDC = 0L;
          b.this.tDD = 0L;
          AppMethodBeat.o(112301);
          return;
          l1 = b.this.tDD;
          break;
        }
      }
      
      public final void Ha(int paramAnonymousInt)
      {
        AppMethodBeat.i(112298);
        b.this.tDy = false;
        report();
        if (paramAnonymousInt == 12)
        {
          b.this.tDx.a(false, true, this.tDH);
          AppMethodBeat.o(112298);
          return;
        }
        b.this.tDx.a(false, false, this.tDH);
        AppMethodBeat.o(112298);
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(112297);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          this.tDH = paramAnonymousArrayOfString[0];
          ad.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.tDH);
          cUf();
        }
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()) && (paramAnonymousList.iterator().hasNext()))
        {
          this.tDI = ((String)paramAnonymousList.iterator().next());
          ad.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.tDI });
        }
        AppMethodBeat.o(112297);
      }
      
      public final void cTY()
      {
        AppMethodBeat.i(112290);
        this.tDH = "";
        this.tDI = "";
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
        g.yhR.f(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.ttw), Integer.valueOf(1) });
        ad.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.ttw), Integer.valueOf(1) });
        b.this.tDy = true;
        b.this.tDx.cTI();
        AppMethodBeat.o(112290);
      }
      
      public final void cTZ()
      {
        AppMethodBeat.i(112291);
        b.this.tDC = System.currentTimeMillis();
        if ((b.this.tDy) && (!bt.isNullOrNil(this.tDH))) {
          b.this.cTX();
        }
        AppMethodBeat.o(112291);
      }
      
      public final void cUa()
      {
        AppMethodBeat.i(112292);
        b.this.tDB = System.currentTimeMillis();
        AppMethodBeat.o(112292);
      }
      
      public final void cUb()
      {
        AppMethodBeat.i(112293);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
        AppMethodBeat.o(112293);
      }
      
      public final void cUc()
      {
        AppMethodBeat.i(112294);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
        AppMethodBeat.o(112294);
      }
      
      public final void cUd()
      {
        AppMethodBeat.i(112295);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
        AppMethodBeat.o(112295);
      }
      
      public final void cUe()
      {
        AppMethodBeat.i(112296);
        ad.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
        report();
        b.this.tDy = false;
        cUf();
        b.this.tDx.akN(this.tDH);
        this.tDH = "";
        this.tDI = "";
        AppMethodBeat.o(112296);
      }
    };
    this.tDG = new VoiceInputLayout.a()
    {
      public final void cUh()
      {
        AppMethodBeat.i(112302);
        b localb = b.this;
        if (localb.tDF != null) {
          localb.tDF.cancel();
        }
        localb.tDF = Toast.makeText(localb.fLP, localb.fLP.getResources().getString(2131759725), 0);
        localb.tDF.setGravity(17, 0, 0);
        localb.tDF.show();
        b.this.tDx.a(true, false, "");
        AppMethodBeat.o(112302);
      }
    };
    this.fLP = ((MMActivity)paramContext);
    this.tDz = paramFTSVoiceInputLayoutImpl;
    this.tDA = paramTextView;
    this.gnZ = paramProgressBar;
    this.tDz.setFTSVoiceDetectListener(this.tDE);
    this.tDz.setLongClickLisnter(this.tDG);
    AppMethodBeat.o(112303);
  }
  
  public final void cTX()
  {
    AppMethodBeat.i(112304);
    this.tDz.setVisibility(8);
    AppMethodBeat.o(112304);
  }
  
  public final void show()
  {
    AppMethodBeat.i(112305);
    if (!ac.fks().equals("zh_CN"))
    {
      AppMethodBeat.o(112305);
      return;
    }
    this.tDz.setAlpha(0.0F);
    this.tDz.animate().alpha(1.0F).setDuration(500L).start();
    this.tDz.setVisibility(0);
    this.gnZ.setVisibility(8);
    this.tDA.setText("");
    AppMethodBeat.o(112305);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void akM(String paramString);
    
    public abstract void akN(String paramString);
    
    public abstract void cTI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */