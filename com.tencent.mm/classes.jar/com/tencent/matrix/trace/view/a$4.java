package com.tencent.matrix.trace.view;

import android.widget.TextView;
import java.util.LinkedList;

final class a$4
  implements Runnable
{
  a$4(a parama, FloatFrameView paramFloatFrameView, float paramFloat, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11) {}
  
  public final void run()
  {
    FloatFrameView.LineChartView localLineChartView = this.fij.fhj;
    FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(localLineChartView, (int)this.fil, this.fim);
    if (localLineChartView.fhz.size() >= 50) {
      localLineChartView.fhz.removeLast();
    }
    localLineChartView.fhz.addFirst(locala);
    localLineChartView.invalidate();
    this.fij.fhi.setText(this.fin);
    this.fij.fhi.setTextColor(this.fim);
    this.fij.fhu.setText(this.fio);
    this.fij.fhk.setText(this.fip);
    this.fij.fhl.setText(this.fiq);
    this.fij.fhm.setText(this.fir);
    this.fij.fhn.setText(this.fit);
    this.fij.fhv.setText(this.fiu);
    this.fij.fho.setText(this.fiv);
    this.fij.fhp.setText(this.fiw);
    this.fij.fhq.setText(this.fix);
    this.fij.fhr.setText(this.fiy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a.4
 * JD-Core Version:    0.7.0.1
 */