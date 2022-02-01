package com.tencent.mm.aa;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  implements Cloneable
{
  public static Rect TW;
  public static float gyA;
  public static Path gyB;
  public static Path gyC;
  public static Paint gyD;
  public static Paint gyE;
  public static Paint gyF;
  public static Paint gyG;
  public static Paint gyH;
  private static int gyx;
  private static int gyy;
  public static float gyz;
  public Rect cPO;
  public Rect gyI;
  public Rect gyJ;
  public Matrix mMatrix;
  
  static
  {
    AppMethodBeat.i(9245);
    gyx = (int)aj.getResources().getDimension(2131165935);
    gyy = (int)aj.getResources().getDimension(2131165934);
    gyz = aj.getResources().getDimension(2131166075);
    gyA = aj.getResources().getDimension(2131166074);
    gyB = new Path();
    gyC = new Path();
    gyD = new Paint();
    gyE = new Paint();
    gyF = new Paint();
    gyG = new Paint();
    gyH = new Paint();
    TW = new Rect();
    gyF.setColor(-16777216);
    gyD.setColor(-1);
    gyD.setStrokeWidth(gyx);
    gyD.setStyle(Paint.Style.STROKE);
    gyD.setAntiAlias(true);
    gyG.set(gyD);
    gyG.setStrokeWidth(gyy);
    gyH.set(gyD);
    gyH.setStrokeWidth(gyz);
    gyE.set(gyD);
    gyE.setStrokeWidth(gyx * 7);
    gyE.setColor(549174203);
    AppMethodBeat.o(9245);
  }
  
  public a()
  {
    AppMethodBeat.i(9241);
    this.gyI = new Rect();
    this.gyJ = new Rect();
    this.mMatrix = new Matrix();
    AppMethodBeat.o(9241);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(9240);
    this.gyI = new Rect();
    this.gyJ = new Rect();
    this.mMatrix = new Matrix();
    this.cPO = paramRect;
    AppMethodBeat.o(9240);
  }
  
  public static void mx(int paramInt)
  {
    AppMethodBeat.i(9242);
    gyH.setAlpha(paramInt);
    gyD.setAlpha(paramInt);
    gyG.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(9242);
  }
  
  public static void my(int paramInt)
  {
    AppMethodBeat.i(9243);
    gyF.setAlpha((int)(0.9019608F * paramInt));
    AppMethodBeat.o(9243);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(9244);
    Object localObject = super.clone();
    AppMethodBeat.o(9244);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aa.a
 * JD-Core Version:    0.7.0.1
 */