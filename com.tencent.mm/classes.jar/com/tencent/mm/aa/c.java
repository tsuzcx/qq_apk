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
import com.tencent.mm.sdk.platformtools.g;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  public float cQd;
  public boolean fOY;
  private Rect gyI;
  public String gyL;
  public p gyM;
  public Bitmap gyN;
  public PointF gyO;
  private float gyP;
  public PointF gyQ;
  private float gyR;
  private float gyS;
  public boolean gyT;
  List<PointF> gyU;
  private float gyV;
  private float gyW;
  protected Context mContext;
  private Matrix mMatrix;
  public int mRotation;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(9251);
    this.mRotation = 0;
    this.cQd = 1.0F;
    this.gyP = 1.0F;
    this.gyT = false;
    this.gyU = new ArrayList();
    this.gyL = paramString;
    this.mMatrix = paramMatrix;
    this.mContext = paramContext;
    this.gyI = paramRect;
    this.gyO = new PointF();
    this.gyQ = new PointF();
    AppMethodBeat.o(9251);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, p paramp, Rect paramRect)
  {
    AppMethodBeat.i(9250);
    this.mRotation = 0;
    this.cQd = 1.0F;
    this.gyP = 1.0F;
    this.gyT = false;
    this.gyU = new ArrayList();
    this.gyL = paramString;
    this.mMatrix = paramMatrix;
    this.gyM = paramp;
    this.mContext = paramContext;
    this.gyI = paramRect;
    this.gyO = new PointF();
    this.gyQ = new PointF();
    AppMethodBeat.o(9250);
  }
  
  private int ahQ()
  {
    AppMethodBeat.i(9258);
    if (this.gyN != null)
    {
      int i = this.gyN.getWidth();
      AppMethodBeat.o(9258);
      return i;
    }
    AppMethodBeat.o(9258);
    return 0;
  }
  
  private int ahR()
  {
    AppMethodBeat.i(9259);
    if (this.gyN != null)
    {
      int i = this.gyN.getHeight();
      AppMethodBeat.o(9259);
      return i;
    }
    AppMethodBeat.o(9259);
    return 0;
  }
  
  private PointF ai(float paramFloat)
  {
    AppMethodBeat.i(9263);
    float f = this.cQd / this.gyP / 2.0F;
    double d1 = ahQ() * 1.0F / 2.0F * f;
    double d2 = f * (ahR() * 1.0F / 2.0F);
    this.gyW = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.gyO.x + (float)(this.gyW * Math.cos(d1)));
    paramFloat = this.gyO.y;
    d2 = this.gyW;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    AppMethodBeat.o(9263);
    return localPointF;
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
    this.gyN = w(ahS());
    this.gyR = (1.2F * this.gyI.width() / this.gyN.getWidth());
    this.gyS = (0.1F * this.gyI.width() / this.gyN.getWidth());
    this.gyR *= paramFloat3;
    this.gyS *= paramFloat3;
    this.gyP = ((float)(this.gyS + 0.28D * (this.gyR - this.gyS)));
    this.mRotation = paramInt;
    this.cQd *= this.gyP;
    ad.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.gyR), Float.valueOf(this.gyS), Float.valueOf(this.gyP) });
    this.gyO.set(paramFloat1, paramFloat2);
    ad.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.gyO });
    ahT();
    AppMethodBeat.o(9252);
  }
  
  public final boolean ahP()
  {
    AppMethodBeat.i(9253);
    ad.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.gyN == null) || (this.gyN.isRecycled()))
    {
      this.gyN = w(ahS());
      AppMethodBeat.o(9253);
      return true;
    }
    AppMethodBeat.o(9253);
    return false;
  }
  
  protected Bitmap ahS()
  {
    AppMethodBeat.i(9260);
    if ((this.gyN == null) || (this.gyN.isRecycled())) {
      this.gyN = this.gyM.z(this.mContext, 480);
    }
    if (this.gyN == null)
    {
      ad.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new g();
      this.gyN = g.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.gyN).drawColor(-7829368);
    }
    Bitmap localBitmap = this.gyN;
    AppMethodBeat.o(9260);
    return localBitmap;
  }
  
  public final void ahT()
  {
    AppMethodBeat.i(9262);
    float f = this.gyP;
    double d1 = ahQ() * 1.0F / 2.0F * f;
    double d2 = f * (ahR() * 1.0F / 2.0F);
    this.gyW = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.gyV = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(9262);
  }
  
  public final c ahU()
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
          localc.gyO = new PointF(this.gyO.x, this.gyO.y);
          localc.gyM = this.gyM;
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
    this.gyO.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.cQd = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(9255);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(9256);
    ad.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.gyN != null) && (!this.gyN.isRecycled()))
    {
      ad.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.gyN.toString() });
      this.gyN.recycle();
      this.gyN = null;
    }
    AppMethodBeat.o(9256);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9257);
    if ((this.gyN == null) || (this.gyN.isRecycled()))
    {
      ad.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(9257);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.gyR < this.cQd)
    {
      this.cQd = this.gyR;
      paramCanvas.save();
      paramCanvas.translate(this.gyO.x, this.gyO.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.cQd, this.cQd);
      paramCanvas.setDensity(this.gyN.getDensity());
      if (!this.fOY) {
        break label197;
      }
      paramCanvas.drawBitmap(this.gyN, -ahQ() / 2, -ahR() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(9257);
      return;
      if (this.gyS <= this.cQd) {
        break;
      }
      this.cQd = this.gyS;
      break;
      label197:
      paramCanvas.clipRect(-ahQ() / 2 + 40.0F, -ahR() / 2 + 40.0F, this.gyN.getWidth() / 2 - 40.0F, this.gyN.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.gyN, -ahQ() / 2, -ahR() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.fOY = paramBoolean;
  }
  
  public final boolean x(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9254);
    this.gyU.clear();
    this.gyU.add(ai(this.gyV - 180.0F));
    this.gyU.add(ai(-this.gyV));
    this.gyU.add(ai(this.gyV));
    this.gyU.add(ai(-this.gyV + 180.0F));
    a locala = new a(this.gyU);
    int j = locala.gyZ - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.gyZ)
    {
      boolean bool2;
      if ((locala.gyY[i] >= paramFloat2) || (locala.gyY[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.gyY[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.gyY[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.gyX[i];
        float f2 = (paramFloat2 - locala.gyY[i]) / (locala.gyY[j] - locala.gyY[i]);
        bool2 = bool1;
        if ((locala.gyX[j] - locala.gyX[i]) * f2 + f1 < paramFloat1) {
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
    float[] gyX;
    float[] gyY;
    int gyZ;
    
    public a()
    {
      AppMethodBeat.i(9249);
      Object localObject;
      this.gyZ = localObject.size();
      this.gyX = new float[this.gyZ];
      this.gyY = new float[this.gyZ];
      int i = 0;
      while (i < this.gyZ)
      {
        this.gyX[i] = ((PointF)localObject.get(i)).x;
        this.gyY[i] = ((PointF)localObject.get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.gyZ);
      AppMethodBeat.o(9249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aa.c
 * JD-Core Version:    0.7.0.1
 */