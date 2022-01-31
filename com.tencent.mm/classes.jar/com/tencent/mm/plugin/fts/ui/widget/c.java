package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.ViewPropertyAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.MMActivity;

public final class c
{
  MMActivity cmc;
  public c.a nbL;
  public boolean nbM;
  public FTSVoiceInputLayoutImpl nbN;
  public TextView nbO;
  public ProgressBar nbP;
  long nbQ;
  long nbR;
  long nbS;
  private FTSVoiceInputLayoutImpl.a nbT;
  Toast nbU;
  private VoiceInputLayout.a nbV;
  
  public c(Context paramContext, FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, TextView paramTextView, ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(156184);
    this.nbM = false;
    this.nbT = new c.1(this);
    this.nbV = new c.2(this);
    this.cmc = ((MMActivity)paramContext);
    this.nbN = paramFTSVoiceInputLayoutImpl;
    this.nbO = paramTextView;
    this.nbP = paramProgressBar;
    this.nbN.setFTSVoiceDetectListener(this.nbT);
    this.nbN.setLongClickLisnter(this.nbV);
    AppMethodBeat.o(156184);
  }
  
  public final void bDp()
  {
    AppMethodBeat.i(62179);
    this.nbN.setVisibility(8);
    AppMethodBeat.o(62179);
  }
  
  public final void show()
  {
    AppMethodBeat.i(62180);
    if (!aa.dsG().equals("zh_CN"))
    {
      AppMethodBeat.o(62180);
      return;
    }
    this.nbN.setAlpha(0.0F);
    this.nbN.animate().alpha(1.0F).setDuration(500L).start();
    this.nbN.setVisibility(0);
    this.nbP.setVisibility(8);
    this.nbO.setText("");
    AppMethodBeat.o(62180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */