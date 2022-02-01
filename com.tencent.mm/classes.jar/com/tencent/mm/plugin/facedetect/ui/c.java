package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  String hJD = null;
  boolean pTA = false;
  boolean pTB = false;
  int pTC = 0;
  Bitmap pTD = null;
  public String pTE = null;
  String pTF = null;
  String pTG = null;
  int pTH = -1;
  String pTI = null;
  a.a pTJ = null;
  View.OnClickListener pTK;
  View.OnClickListener pTL;
  View.OnClickListener pTM;
  View.OnClickListener pTN;
  boolean pTv = false;
  public boolean pTw = true;
  boolean pTx = true;
  boolean pTy = false;
  boolean pTz = false;
  public int status = 1;
  
  public final String toString()
  {
    AppMethodBeat.i(104047);
    String str = "JumperConfig{isShowMainButton=" + this.pTv + ", isShowStatusWordingTv=" + this.pTw + ", isShowUploadStatusIv=" + this.pTx + ", isShowCancelBtn=" + this.pTy + ", isShowSubButton=" + this.pTz + ", isShowOneByOne=" + this.pTA + ", isShowFeedback=" + this.pTB + ", oneByOneIndexStart=" + this.pTC + ", bgBm=" + this.pTD + ", statusWording='" + this.pTE + '\'' + ", mainBtnText='" + this.pTF + '\'' + ", subBtnText='" + this.pTG + '\'' + ", cancelBtnText='" + this.hJD + '\'' + ", statusIvRes=" + this.pTH + ", feedbackText='" + this.pTI + '\'' + ", status=" + this.status + ", onJumperShowEndCallback=" + this.pTJ + ", onMainBtnClickListener=" + this.pTK + ", onSubBtnClickListener=" + this.pTL + ", onFeedbackClickListener=" + this.pTM + ", onCancelBtnClickListener=" + this.pTN + '}';
    AppMethodBeat.o(104047);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.c
 * JD-Core Version:    0.7.0.1
 */