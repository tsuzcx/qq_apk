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
  public static Rect Rm;
  private static int gag;
  private static int gah;
  public static float gai;
  public static float gaj;
  public static Path gak;
  public static Path gal;
  public static Paint gam;
  public static Paint gan;
  public static Paint gao;
  public static Paint gaq;
  public static Paint gar;
  public Rect cHB;
  public Rect gas;
  public Rect gat;
  public Matrix mMatrix;
  
  static
  {
    AppMethodBeat.i(9245);
    gag = (int)aj.getResources().getDimension(2131165935);
    gah = (int)aj.getResources().getDimension(2131165934);
    gai = aj.getResources().getDimension(2131166075);
    gaj = aj.getResources().getDimension(2131166074);
    gak = new Path();
    gal = new Path();
    gam = new Paint();
    gan = new Paint();
    gao = new Paint();
    gaq = new Paint();
    gar = new Paint();
    Rm = new Rect();
    gao.setColor(-16777216);
    gam.setColor(-1);
    gam.setStrokeWidth(gag);
    gam.setStyle(Paint.Style.STROKE);
    gam.setAntiAlias(true);
    gaq.set(gam);
    gaq.setStrokeWidth(gah);
    gar.set(gam);
    gar.setStrokeWidth(gai);
    gan.set(gam);
    gan.setStrokeWidth(gag * 7);
    gan.setColor(549174203);
    AppMethodBeat.o(9245);
  }
  
  public a()
  {
    AppMethodBeat.i(9241);
    this.gas = new Rect();
    this.gat = new Rect();
    this.mMatrix = new Matrix();
    AppMethodBeat.o(9241);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(9240);
    this.gas = new Rect();
    this.gat = new Rect();
    this.mMatrix = new Matrix();
    this.cHB = paramRect;
    AppMethodBeat.o(9240);
  }
  
  public static void lZ(int paramInt)
  {
    AppMethodBeat.i(9242);
    gar.setAlpha(paramInt);
    gam.setAlpha(paramInt);
    gaq.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(9242);
  }
  
  public static void ma(int paramInt)
  {
    AppMethodBeat.i(9243);
    gao.setAlpha((int)(0.9019608F * paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.a
 * JD-Core Version:    0.7.0.1
 */