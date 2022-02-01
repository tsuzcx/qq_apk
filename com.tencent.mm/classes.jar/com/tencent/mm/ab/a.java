package com.tencent.mm.ab;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements Cloneable
{
  public static Rect byy;
  private static int mzO;
  private static int mzP;
  public static float mzQ;
  public static float mzR;
  public static Path mzS;
  public static Path mzT;
  public static Paint mzU;
  public static Paint mzV;
  public static Paint mzW;
  public static Paint mzX;
  public static Paint mzY;
  public Rect Qv;
  public Matrix avQ;
  public Rect hbZ;
  public Rect mzZ;
  
  static
  {
    AppMethodBeat.i(9245);
    mzO = (int)MMApplicationContext.getResources().getDimension(a.c.box_line_width);
    mzP = (int)MMApplicationContext.getResources().getDimension(a.c.box_gird_width);
    mzQ = MMApplicationContext.getResources().getDimension(a.c.corner_width);
    mzR = MMApplicationContext.getResources().getDimension(a.c.corner_length);
    mzS = new Path();
    mzT = new Path();
    mzU = new Paint();
    mzV = new Paint();
    mzW = new Paint();
    mzX = new Paint();
    mzY = new Paint();
    byy = new Rect();
    mzW.setColor(-16777216);
    mzU.setColor(-1);
    mzU.setStrokeWidth(mzO);
    mzU.setStyle(Paint.Style.STROKE);
    mzU.setAntiAlias(true);
    mzX.set(mzU);
    mzX.setStrokeWidth(mzP);
    mzY.set(mzU);
    mzY.setStrokeWidth(mzQ);
    mzV.set(mzU);
    mzV.setStrokeWidth(mzO * 7);
    mzV.setColor(549174203);
    AppMethodBeat.o(9245);
  }
  
  public a()
  {
    AppMethodBeat.i(9241);
    this.mzZ = new Rect();
    this.Qv = new Rect();
    this.avQ = new Matrix();
    AppMethodBeat.o(9241);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(9240);
    this.mzZ = new Rect();
    this.Qv = new Rect();
    this.avQ = new Matrix();
    this.hbZ = paramRect;
    AppMethodBeat.o(9240);
  }
  
  public static void si(int paramInt)
  {
    AppMethodBeat.i(9242);
    mzY.setAlpha(paramInt);
    mzU.setAlpha(paramInt);
    mzX.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(9242);
  }
  
  public static void sj(int paramInt)
  {
    AppMethodBeat.i(9243);
    mzW.setAlpha((int)(0.9019608F * paramInt));
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
    AppMethodBeat.i(231218);
    this.avQ.set(paramMatrix);
    AppMethodBeat.o(231218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ab.a
 * JD-Core Version:    0.7.0.1
 */