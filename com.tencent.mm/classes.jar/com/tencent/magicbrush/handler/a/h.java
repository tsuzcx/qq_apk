package com.tencent.magicbrush.handler.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class h
{
  private List<k> bkV = new ArrayList();
  g bkZ;
  e bla;
  Canvas blb;
  Paint blc;
  char[] bld = new char[1];
  Rect ble = new Rect();
  private Rect blf = new Rect();
  Paint.FontMetrics blg = new Paint.FontMetrics();
  
  h(e parame, g paramg)
  {
    this.bla = parame;
    this.blb = new Canvas(this.bla.bkL);
    this.bkZ = paramg;
    this.blc = new Paint(1);
    this.blc.setTextAlign(Paint.Align.LEFT);
    this.blc.setColor(-1);
  }
  
  static float y(List<k> paramList)
  {
    float f2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      f2 = 0.0F;
      return f2;
    }
    paramList = paramList.iterator();
    float f1 = 0.0F;
    for (;;)
    {
      f2 = f1;
      if (!paramList.hasNext()) {
        break;
      }
      k localk = (k)paramList.next();
      if (localk != null) {
        f1 = localk.blu + f1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.h
 * JD-Core Version:    0.7.0.1
 */