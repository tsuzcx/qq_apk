package com.tencent.mm.plugin.fts.ui.widget;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class c$1
  implements FTSVoiceInputLayoutImpl.a
{
  String nbW = "";
  String nbX = "";
  
  c$1(c paramc) {}
  
  private void IE()
  {
    AppMethodBeat.i(62176);
    this.nbY.nbS = System.currentTimeMillis();
    c localc = this.nbY;
    long l1;
    if (this.nbY.nbR > 0L)
    {
      l1 = this.nbY.nbR;
      localc.nbR = l1;
      if (!bo.isNullOrNil(this.nbW)) {
        break label219;
      }
    }
    label219:
    for (int i = 2;; i = 1)
    {
      l1 = this.nbY.nbR - this.nbY.nbQ;
      long l2 = this.nbY.nbS - this.nbY.nbQ;
      h.qsU.e(16346, new Object[] { Integer.valueOf(i), Long.valueOf(e.mRk), Long.valueOf(l1), Long.valueOf(l2) });
      ab.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", new Object[] { Integer.valueOf(i), Long.valueOf(e.mRk), Long.valueOf(l1), Long.valueOf(l2) });
      this.nbY.nbQ = 0L;
      this.nbY.nbR = 0L;
      this.nbY.nbS = 0L;
      AppMethodBeat.o(62176);
      return;
      l1 = this.nbY.nbS;
      break;
    }
  }
  
  private void bDx()
  {
    AppMethodBeat.i(62174);
    bDy();
    this.nbY.nbO.setText(this.nbW);
    this.nbY.nbP.setVisibility(0);
    this.nbY.nbL.Px(this.nbW);
    AppMethodBeat.o(62174);
  }
  
  private void bDy()
  {
    AppMethodBeat.i(62175);
    if (this.nbW.length() > 0) {
      this.nbW = this.nbW.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
    }
    AppMethodBeat.o(62175);
  }
  
  public final void bDq()
  {
    AppMethodBeat.i(62165);
    this.nbW = "";
    this.nbX = "";
    ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
    h.qsU.e(15490, new Object[] { Integer.valueOf(3), Long.valueOf(e.mRk), Integer.valueOf(1) });
    ab.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", new Object[] { Long.valueOf(e.mRk), Integer.valueOf(1) });
    this.nbY.nbM = true;
    this.nbY.nbL.bCV();
    AppMethodBeat.o(62165);
  }
  
  public final void bDr()
  {
    AppMethodBeat.i(62166);
    this.nbY.nbR = System.currentTimeMillis();
    if ((this.nbY.nbM) && (!bo.isNullOrNil(this.nbW))) {
      this.nbY.bDp();
    }
    AppMethodBeat.o(62166);
  }
  
  public final void bDs()
  {
    AppMethodBeat.i(62167);
    this.nbY.nbQ = System.currentTimeMillis();
    AppMethodBeat.o(62167);
  }
  
  public final void bDt()
  {
    AppMethodBeat.i(62168);
    ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
    AppMethodBeat.o(62168);
  }
  
  public final void bDu()
  {
    AppMethodBeat.i(62169);
    ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
    AppMethodBeat.o(62169);
  }
  
  public final void bDv()
  {
    AppMethodBeat.i(62170);
    ab.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
    AppMethodBeat.o(62170);
  }
  
  public final void bDw()
  {
    AppMethodBeat.i(62171);
    ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
    IE();
    this.nbY.nbM = false;
    bDx();
    this.nbY.nbL.Py(this.nbW);
    this.nbW = "";
    this.nbX = "";
    AppMethodBeat.o(62171);
  }
  
  public final void c(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(138302);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].length() > 0))
    {
      this.nbW = paramArrayOfString[0];
      ab.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.nbW);
      bDx();
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.iterator().hasNext()))
    {
      this.nbX = ((String)paramList.iterator().next());
      ab.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", new Object[] { this.nbX });
    }
    AppMethodBeat.o(138302);
  }
  
  public final void wE(int paramInt)
  {
    AppMethodBeat.i(62173);
    this.nbY.nbM = false;
    IE();
    if (paramInt == 12)
    {
      this.nbY.nbL.a(false, true, this.nbW);
      AppMethodBeat.o(62173);
      return;
    }
    this.nbY.nbL.a(false, false, this.nbW);
    AppMethodBeat.o(62173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.c.1
 * JD-Core Version:    0.7.0.1
 */