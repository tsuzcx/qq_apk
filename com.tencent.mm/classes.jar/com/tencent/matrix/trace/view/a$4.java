package com.tencent.matrix.trace.view;

import android.widget.TextView;
import java.util.LinkedList;

final class a$4
  implements Runnable
{
  a$4(a parama, FloatFrameView paramFloatFrameView, float paramFloat, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11) {}
  
  public final void run()
  {
    FloatFrameView.LineChartView localLineChartView = this.dix.dhu;
    FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(localLineChartView, (int)this.diz, this.diA);
    if (localLineChartView.dhK.size() >= 50) {
      localLineChartView.dhK.removeLast();
    }
    localLineChartView.dhK.addFirst(locala);
    localLineChartView.invalidate();
    this.dix.dht.setText(this.diB);
    this.dix.dht.setTextColor(this.diA);
    this.dix.dhF.setText(this.diC);
    this.dix.dhv.setText(this.diD);
    this.dix.dhw.setText(this.diE);
    this.dix.dhx.setText(this.diF);
    this.dix.dhy.setText(this.diG);
    this.dix.dhG.setText(this.diH);
    this.dix.dhz.setText(this.diI);
    this.dix.dhA.setText(this.diJ);
    this.dix.dhB.setText(this.diK);
    this.dix.dhC.setText(this.diL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a.4
 * JD-Core Version:    0.7.0.1
 */