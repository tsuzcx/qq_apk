package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewPropertyAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public a HDg;
  public boolean HDh;
  public FTSVoiceInputLayoutImpl HDi;
  public TextView HDj;
  long HDk;
  long HDl;
  long HDm;
  private FTSVoiceInputLayoutImpl.a HDn;
  Toast HDo;
  private VoiceInputLayout.a HDp;
  MMActivity lzt;
  public ProgressBar mlF;
  
  public c(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(112303);
    this.HDh = false;
    this.HDn = new FTSVoiceInputLayoutImpl.a()
    {
      String HDq = "";
      String HDr = "";
      
      private void fzs()
      {
        AppMethodBeat.i(112299);
        fzt();
        c.this.HDj.setText(this.HDq);
        c.this.mlF.setVisibility(0);
        c.this.HDg.aEH(this.HDq);
        AppMethodBeat.o(112299);
      }
      
      private void fzt()
      {
        AppMethodBeat.i(112300);
        if (this.HDq.length() > 0) {
          this.HDq = this.HDq.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
        }
        AppMethodBeat.o(112300);
      }
      
      private void report()
      {
        AppMethodBeat.i(112301);
        c.this.HDm = System.currentTimeMillis();
        c localc = c.this;
        long l1;
        if (c.this.HDl > 0L)
        {
          l1 = c.this.HDl;
          localc.HDl = l1;
          if (!Util.isNullOrNil(this.HDq)) {
            break label219;
          }
        }
        label219:
        for (int i = 2;; i = 1)
        {
          l1 = c.this.HDl - c.this.HDk;
          long l2 = c.this.HDm - c.this.HDk;
          h.OAn.b(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.HrM), Long.valueOf(l1), Long.valueOf(l2) });
          Log.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.HrM), Long.valueOf(l1), Long.valueOf(l2) });
          c.this.HDk = 0L;
          c.this.HDl = 0L;
          c.this.HDm = 0L;
          AppMethodBeat.o(112301);
          return;
          l1 = c.this.HDm;
          break;
        }
      }
      
      public final void Ws(int paramAnonymousInt)
      {
        AppMethodBeat.i(112298);
        c.this.HDh = false;
        report();
        if (paramAnonymousInt == 12)
        {
          c.this.HDg.c(false, true, this.HDq);
          AppMethodBeat.o(112298);
          return;
        }
        c.this.HDg.c(false, false, this.HDq);
        AppMethodBeat.o(112298);
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(112297);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          this.HDq = paramAnonymousArrayOfString[0];
          Log.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.HDq);
          fzs();
        }
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()) && (paramAnonymousList.iterator().hasNext()))
        {
          this.HDr = ((String)paramAnonymousList.iterator().next());
          Log.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.HDr });
        }
        AppMethodBeat.o(112297);
      }
      
      public final void fzl()
      {
        AppMethodBeat.i(112290);
        this.HDq = "";
        this.HDr = "";
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
        h.OAn.b(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.HrM), Integer.valueOf(1) });
        Log.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.HrM), Integer.valueOf(1) });
        c.this.HDh = true;
        c.this.HDg.fyx();
        AppMethodBeat.o(112290);
      }
      
      public final void fzm()
      {
        AppMethodBeat.i(112291);
        c.this.HDl = System.currentTimeMillis();
        if ((c.this.HDh) && (!Util.isNullOrNil(this.HDq))) {
          c.this.fzk();
        }
        AppMethodBeat.o(112291);
      }
      
      public final void fzn()
      {
        AppMethodBeat.i(112292);
        c.this.HDk = System.currentTimeMillis();
        AppMethodBeat.o(112292);
      }
      
      public final void fzo()
      {
        AppMethodBeat.i(112293);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
        AppMethodBeat.o(112293);
      }
      
      public final void fzp()
      {
        AppMethodBeat.i(112294);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
        AppMethodBeat.o(112294);
      }
      
      public final void fzq()
      {
        AppMethodBeat.i(112295);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
        AppMethodBeat.o(112295);
      }
      
      public final void fzr()
      {
        AppMethodBeat.i(112296);
        Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
        report();
        c.this.HDh = false;
        fzs();
        c.this.mlF.setVisibility(8);
        c.this.HDg.iE(this.HDr, this.HDq);
        this.HDq = "";
        this.HDr = "";
        AppMethodBeat.o(112296);
      }
    };
    this.HDp = new VoiceInputLayout.a()
    {
      public final void fzu()
      {
        AppMethodBeat.i(112302);
        c localc = c.this;
        int i = p.g.fts_voice_input_speak_too_short;
        if (localc.HDo != null) {
          localc.HDo.cancel();
        }
        localc.HDo = Toast.makeText(localc.lzt, localc.lzt.getResources().getString(i), 0);
        localc.HDo.setGravity(17, 0, 0);
        localc.HDo.show();
        c.this.HDg.c(true, false, "");
        AppMethodBeat.o(112302);
      }
    };
    this.lzt = ((MMActivity)paramContext);
    this.HDi = paramFTSVoiceInputLayoutImpl;
    this.HDj = paramTextView;
    this.mlF = paramProgressBar;
    this.HDi.setFTSVoiceDetectListener(this.HDn);
    this.HDi.setLongClickLisnter(this.HDp);
    AppMethodBeat.o(112303);
  }
  
  public final void fzk()
  {
    AppMethodBeat.i(112304);
    this.HDi.setVisibility(8);
    AppMethodBeat.o(112304);
  }
  
  public final void release()
  {
    AppMethodBeat.i(265872);
    if (this.HDi != null)
    {
      this.HDi.bPI();
      this.HDi.fzG();
    }
    AppMethodBeat.o(265872);
  }
  
  public final void show()
  {
    AppMethodBeat.i(112305);
    if (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))
    {
      AppMethodBeat.o(112305);
      return;
    }
    this.HDi.setAlpha(0.0F);
    this.HDi.animate().alpha(1.0F).setDuration(500L).start();
    this.HDi.setVisibility(0);
    this.mlF.setVisibility(8);
    this.HDj.setText("");
    AppMethodBeat.o(112305);
  }
  
  public static abstract interface a
  {
    public abstract void aEH(String paramString);
    
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void fyx();
    
    public abstract void iE(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */