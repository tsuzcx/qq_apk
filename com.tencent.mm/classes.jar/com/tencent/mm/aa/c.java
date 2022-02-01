package com.tencent.mm.aa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  public float cHQ;
  public boolean fsk;
  public PointF gaA;
  private float gaB;
  private float gaC;
  public boolean gaD;
  List<PointF> gaE;
  private float gaF;
  private float gaG;
  private Rect gas;
  public String gav;
  public p gaw;
  public Bitmap gax;
  public PointF gay;
  private float gaz;
  protected Context mContext;
  private Matrix mMatrix;
  public int mRotation;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(9251);
    this.mRotation = 0;
    this.cHQ = 1.0F;
    this.gaz = 1.0F;
    this.gaD = false;
    this.gaE = new ArrayList();
    this.gav = paramString;
    this.mMatrix = paramMatrix;
    this.mContext = paramContext;
    this.gas = paramRect;
    this.gay = new PointF();
    this.gaA = new PointF();
    AppMethodBeat.o(9251);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, p paramp, Rect paramRect)
  {
    AppMethodBeat.i(9250);
    this.mRotation = 0;
    this.cHQ = 1.0F;
    this.gaz = 1.0F;
    this.gaD = false;
    this.gaE = new ArrayList();
    this.gav = paramString;
    this.mMatrix = paramMatrix;
    this.gaw = paramp;
    this.mContext = paramContext;
    this.gas = paramRect;
    this.gay = new PointF();
    this.gaA = new PointF();
    AppMethodBeat.o(9250);
  }
  
  private PointF ab(float paramFloat)
  {
    AppMethodBeat.i(9263);
    float f = this.cHQ / this.gaz / 2.0F;
    double d1 = adO() * 1.0F / 2.0F * f;
    double d2 = f * (adP() * 1.0F / 2.0F);
    this.gaG = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.gay.x + (float)(this.gaG * Math.cos(d1)));
    paramFloat = this.gay.y;
    d2 = this.gaG;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    AppMethodBeat.o(9263);
    return localPointF;
  }
  
  private int adO()
  {
    AppMethodBeat.i(9258);
    if (this.gax != null)
    {
      int i = this.gax.getWidth();
      AppMethodBeat.o(9258);
      return i;
    }
    AppMethodBeat.o(9258);
    return 0;
  }
  
  private int adP()
  {
    AppMethodBeat.i(9259);
    if (this.gax != null)
    {
      int i = this.gax.getHeight();
      AppMethodBeat.o(9259);
      return i;
    }
    AppMethodBeat.o(9259);
    return 0;
  }
  
  private Bitmap w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(9261);
    int i = (int)(paramBitmap.getWidth() + 80.0F);
    int j = (int)(paramBitmap.getHeight() + 80.0F);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localBitmap.setDensity(paramBitmap.getDensity());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 40.0F, 40.0F, null);
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), 2131232007).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), 2131232007), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(9261);
    return localBitmap;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9252);
    this.gax = w(adQ());
    this.gaB = (1.2F * this.gas.width() / this.gax.getWidth());
    this.gaC = (0.1F * this.gas.width() / this.gax.getWidth());
    this.gaB *= paramFloat3;
    this.gaC *= paramFloat3;
    this.gaz = ((float)(this.gaC + 0.28D * (this.gaB - this.gaC)));
    this.mRotation = paramInt;
    this.cHQ *= this.gaz;
    ad.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.gaB), Float.valueOf(this.gaC), Float.valueOf(this.gaz) });
    this.gay.set(paramFloat1, paramFloat2);
    ad.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.gay });
    adR();
    AppMethodBeat.o(9252);
  }
  
  public final boolean adN()
  {
    AppMethodBeat.i(9253);
    ad.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.gax == null) || (this.gax.isRecycled()))
    {
      this.gax = w(adQ());
      AppMethodBeat.o(9253);
      return true;
    }
    AppMethodBeat.o(9253);
    return false;
  }
  
  protected Bitmap adQ()
  {
    AppMethodBeat.i(9260);
    if ((this.gax == null) || (this.gax.isRecycled())) {
      this.gax = this.gaw.z(this.mContext, 480);
    }
    if (this.gax == null)
    {
      ad.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new f();
      this.gax = f.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.gax).drawColor(-7829368);
    }
    Bitmap localBitmap = this.gax;
    AppMethodBeat.o(9260);
    return localBitmap;
  }
  
  public final void adR()
  {
    AppMethodBeat.i(9262);
    float f = this.gaz;
    double d1 = adO() * 1.0F / 2.0F * f;
    double d2 = f * (adP() * 1.0F / 2.0F);
    this.gaG = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.gaF = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(9262);
  }
  
  public final c adS()
  {
    AppMethodBeat.i(9264);
    label58:
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        ad.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          localc.gay = new PointF(this.gay.x, this.gay.y);
          localc.gaw = this.gaw;
          AppMethodBeat.o(9264);
          return localc;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException2)
        {
          break label58;
        }
        localCloneNotSupportedException1 = localCloneNotSupportedException1;
        localc = null;
      }
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9255);
    this.gay.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.cHQ = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(9255);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(9256);
    ad.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.gax != null) && (!this.gax.isRecycled()))
    {
      ad.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.gax.toString() });
      this.gax.recycle();
      this.gax = null;
    }
    AppMethodBeat.o(9256);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9257);
    if ((this.gax == null) || (this.gax.isRecycled()))
    {
      ad.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(9257);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.gaB < this.cHQ)
    {
      this.cHQ = this.gaB;
      paramCanvas.save();
      paramCanvas.translate(this.gay.x, this.gay.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.cHQ, this.cHQ);
      paramCanvas.setDensity(this.gax.getDensity());
      if (!this.fsk) {
        break label197;
      }
      paramCanvas.drawBitmap(this.gax, -adO() / 2, -adP() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(9257);
      return;
      if (this.gaC <= this.cHQ) {
        break;
      }
      this.cHQ = this.gaC;
      break;
      label197:
      paramCanvas.clipRect(-adO() / 2 + 40.0F, -adP() / 2 + 40.0F, this.gax.getWidth() / 2 - 40.0F, this.gax.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.gax, -adO() / 2, -adP() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.fsk = paramBoolean;
  }
  
  public final boolean v(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9254);
    this.gaE.clear();
    this.gaE.add(ab(this.gaF - 180.0F));
    this.gaE.add(ab(-this.gaF));
    this.gaE.add(ab(this.gaF));
    this.gaE.add(ab(-this.gaF + 180.0F));
    a locala = new a(this.gaE);
    int j = locala.gaJ - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.gaJ)
    {
      boolean bool2;
      if ((locala.gaI[i] >= paramFloat2) || (locala.gaI[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.gaI[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.gaI[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.gaH[i];
        float f2 = (paramFloat2 - locala.gaI[i]) / (locala.gaI[j] - locala.gaI[i]);
        bool2 = bool1;
        if ((locala.gaH[j] - locala.gaH[i]) * f2 + f1 < paramFloat1) {
          if (bool1) {
            break label295;
          }
        }
      }
      label295:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        j = i;
        i += 1;
        bool1 = bool2;
        break;
      }
    }
    AppMethodBeat.o(9254);
    return bool1;
  }
  
  final class a
  {
    float[] gaH;
    float[] gaI;
    int gaJ;
    
    public a()
    {
      AppMethodBeat.i(9249);
      Object localObject;
      this.gaJ = localObject.size();
      this.gaH = new float[this.gaJ];
      this.gaI = new float[this.gaJ];
      int i = 0;
      while (i < this.gaJ)
      {
        this.gaH[i] = ((PointF)localObject.get(i)).x;
        this.gaI[i] = ((PointF)localObject.get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.gaJ);
      AppMethodBeat.o(9249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.c
 * JD-Core Version:    0.7.0.1
 */