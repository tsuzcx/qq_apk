package com.tencent.mm.ab;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements Cloneable
{
  public static Rect Si;
  private static int jZK;
  private static int jZL;
  public static float jZM;
  public static float jZN;
  public static Path jZO;
  public static Path jZP;
  public static Paint jZQ;
  public static Paint jZR;
  public static Paint jZS;
  public static Paint jZT;
  public static Paint jZU;
  public Matrix aqj;
  public Rect eYz;
  public Rect jZV;
  public Rect jZW;
  
  static
  {
    AppMethodBeat.i(9245);
    jZK = (int)MMApplicationContext.getResources().getDimension(a.c.box_line_width);
    jZL = (int)MMApplicationContext.getResources().getDimension(a.c.box_gird_width);
    jZM = MMApplicationContext.getResources().getDimension(a.c.corner_width);
    jZN = MMApplicationContext.getResources().getDimension(a.c.corner_length);
    jZO = new Path();
    jZP = new Path();
    jZQ = new Paint();
    jZR = new Paint();
    jZS = new Paint();
    jZT = new Paint();
    jZU = new Paint();
    Si = new Rect();
    jZS.setColor(-16777216);
    jZQ.setColor(-1);
    jZQ.setStrokeWidth(jZK);
    jZQ.setStyle(Paint.Style.STROKE);
    jZQ.setAntiAlias(true);
    jZT.set(jZQ);
    jZT.setStrokeWidth(jZL);
    jZU.set(jZQ);
    jZU.setStrokeWidth(jZM);
    jZR.set(jZQ);
    jZR.setStrokeWidth(jZK * 7);
    jZR.setColor(549174203);
    AppMethodBeat.o(9245);
  }
  
  public a()
  {
    AppMethodBeat.i(9241);
    this.jZV = new Rect();
    this.jZW = new Rect();
    this.aqj = new Matrix();
    AppMethodBeat.o(9241);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(9240);
    this.jZV = new Rect();
    this.jZW = new Rect();
    this.aqj = new Matrix();
    this.eYz = paramRect;
    AppMethodBeat.o(9240);
  }
  
  public static void sm(int paramInt)
  {
    AppMethodBeat.i(9242);
    jZU.setAlpha(paramInt);
    jZQ.setAlpha(paramInt);
    jZT.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(9242);
  }
  
  public static void sn(int paramInt)
  {
    AppMethodBeat.i(9243);
    jZS.setAlpha((int)(0.9019608F * paramInt));
    AppMethodBeat.o(9243);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(9244);
    Object localObject = super.clone();
    AppMethodBeat.o(9244);
    return localObject;
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(260298);
    this.aqj.set(paramMatrix);
    AppMethodBeat.o(260298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ab.a
 * JD-Core Version:    0.7.0.1
 */