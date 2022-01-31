package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

final class FTSSayFooter$2
  implements VoiceInputLayout.b
{
  String kFd = "";
  String kFe = "";
  String kFf = "";
  String kFg = "";
  
  FTSSayFooter$2(FTSSayFooter paramFTSSayFooter) {}
  
  private String aWQ()
  {
    if (this.kFd.length() > 0) {
      this.kFd = this.kFd.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
    }
    if ((bk.bl(this.kFd)) || (this.kFe.equals(this.kFd))) {
      return null;
    }
    String str = FTSSayFooter.b(this.kFc).getText();
    if ((!bk.bl(this.kFe)) && (str.endsWith(this.kFe))) {}
    for (str = str.substring(0, str.length() - this.kFe.length());; str = FTSSayFooter.b(this.kFc).getText())
    {
      FTSSayFooter.b(this.kFc).setText(str + this.kFd);
      this.kFe = this.kFd;
      return str;
    }
  }
  
  public final void aWL()
  {
    this.kFd = "";
    this.kFg = "";
    int i;
    int j;
    String str;
    if (this.kFf.equals(FTSSayFooter.b(this.kFc).getText()))
    {
      i = FTSSayFooter.b(this.kFc).getSelectionStart();
      j = FTSSayFooter.b(this.kFc).getSelectionEnd();
      str = FTSSayFooter.b(this.kFc).getText();
      if ((i >= 0) && (j > 0) && (j == FTSSayFooter.b(this.kFc).getText().length())) {
        break label170;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.kFe = "";
        y.d("MicroMsg.FTSSayFooter", "onDetectStart, reset lastAppendText");
      }
      y.d("MicroMsg.FTSSayFooter", "onDetectStart");
      h.nFQ.f(15490, new Object[] { Integer.valueOf(3), e.kvx });
      y.d("MicroMsg.FTSSayFooter", "15490 type:3, sessionId:%s", new Object[] { e.kvx });
      return;
      label170:
      if (!str.substring(i, j).equals(this.kFe)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void aWM()
  {
    y.d("MicroMsg.FTSSayFooter", "onDetectStop");
  }
  
  public final void aWN()
  {
    y.d("MicroMsg.FTSSayFooter", "onDetectCancel");
  }
  
  public final void aWO()
  {
    y.d("MicroMsg.FTSSayFooter", "onStateReset");
  }
  
  public final void aWP()
  {
    y.d("MicroMsg.FTSSayFooter", "onDetectFinish");
    aWQ();
    this.kFf = FTSSayFooter.b(this.kFc).getText();
    if (FTSSayFooter.b(this.kFc).getText().endsWith(this.kFd)) {
      FTSSayFooter.b(this.kFc).cV(FTSSayFooter.b(this.kFc).getText().length() - this.kFd.length(), FTSSayFooter.b(this.kFc).getText().length());
    }
    if (FTSSayFooter.c(this.kFc) != null) {
      FTSSayFooter.c(this.kFc).dl(this.kFg, this.kFd);
    }
    this.kFd = "";
    this.kFg = "";
  }
  
  public final void b(String[] paramArrayOfString, Set<String> paramSet)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].length() > 0))
    {
      this.kFd = paramArrayOfString[0];
      y.d("MicroMsg.FTSSayFooter", "onDetected text content: " + this.kFd);
      aWQ();
    }
    if ((paramSet != null) && (!paramSet.isEmpty()) && (paramSet.iterator().hasNext()))
    {
      this.kFg = ((String)paramSet.iterator().next());
      y.d("MicroMsg.FTSSayFooter", "set voiceId:%s", new Object[] { this.kFg });
    }
  }
  
  public final void rG(int paramInt)
  {
    if (paramInt == 12)
    {
      FTSSayFooter.a(this.kFc, n.g.fts_voice_input_please_check_network);
      return;
    }
    FTSSayFooter.a(this.kFc, n.g.fts_app_err_system_busy_tip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter.2
 * JD-Core Version:    0.7.0.1
 */