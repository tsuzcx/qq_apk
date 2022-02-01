package com.tencent.mm.ab;

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
import com.tencent.mm.api.t;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  private Matrix avQ;
  public float hco;
  public boolean lCv;
  public String mAb;
  public t mAc;
  public Bitmap mAd;
  public PointF mAe;
  private float mAf;
  public PointF mAg;
  private float mAh;
  private float mAi;
  public boolean mAj;
  List<PointF> mAk;
  private float mAl;
  private float mAm;
  protected Context mContext;
  public int mRotation;
  private Rect mzZ;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(9251);
    this.mRotation = 0;
    this.hco = 1.0F;
    this.mAf = 1.0F;
    this.mAj = false;
    this.mAk = new ArrayList();
    this.mAb = paramString;
    this.avQ = paramMatrix;
    this.mContext = paramContext;
    this.mzZ = paramRect;
    this.mAe = new PointF();
    this.mAg = new PointF();
    AppMethodBeat.o(9251);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, t paramt, Rect paramRect)
  {
    AppMethodBeat.i(9250);
    this.mRotation = 0;
    this.hco = 1.0F;
    this.mAf = 1.0F;
    this.mAj = false;
    this.mAk = new ArrayList();
    this.mAb = paramString;
    this.avQ = paramMatrix;
    this.mAc = paramt;
    this.mContext = paramContext;
    this.mzZ = paramRect;
    this.mAe = new PointF();
    this.mAg = new PointF();
    AppMethodBeat.o(9250);
  }
  
  private Bitmap E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(9261);
    int i = (int)(paramBitmap.getWidth() + 80.0F);
    int j = (int)(paramBitmap.getHeight() + 80.0F);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localBitmap.setDensity(paramBitmap.getDensity());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 40.0F, 40.0F, null);
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), a.d.emoji_box).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), a.d.emoji_box), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(9261);
    return localBitmap;
  }
  
  private int aYO()
  {
    AppMethodBeat.i(9258);
    if (this.mAd != null)
    {
      int i = this.mAd.getWidth();
      AppMethodBeat.o(9258);
      return i;
    }
    AppMethodBeat.o(9258);
    return 0;
  }
  
  private int aYP()
  {
    AppMethodBeat.i(9259);
    if (this.mAd != null)
    {
      int i = this.mAd.getHeight();
      AppMethodBeat.o(9259);
      return i;
    }
    AppMethodBeat.o(9259);
    return 0;
  }
  
  private PointF bl(float paramFloat)
  {
    AppMethodBeat.i(9263);
    float f = this.hco / this.mAf / 2.0F;
    double d1 = aYO() * 1.0F / 2.0F * f;
    double d2 = f * (aYP() * 1.0F / 2.0F);
    this.mAm = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.mAe.x + (float)(this.mAm * Math.cos(d1)));
    paramFloat = this.mAe.y;
    d2 = this.mAm;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    AppMethodBeat.o(9263);
    return localPointF;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9252);
    this.mAd = E(aYQ());
    this.mAh = (1.2F * this.mzZ.width() / this.mAd.getWidth());
    this.mAi = (0.1F * this.mzZ.width() / this.mAd.getWidth());
    this.mAh *= paramFloat3;
    this.mAi *= paramFloat3;
    this.mAf = ((float)(this.mAi + 0.28D * (this.mAh - this.mAi)));
    this.mRotation = paramInt;
    this.hco *= this.mAf;
    Log.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.mAh), Float.valueOf(this.mAi), Float.valueOf(this.mAf) });
    this.mAe.set(paramFloat1, paramFloat2);
    Log.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.mAe });
    aYR();
    AppMethodBeat.o(9252);
  }
  
  public final boolean aYN()
  {
    AppMethodBeat.i(9253);
    Log.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.mAd == null) || (this.mAd.isRecycled()))
    {
      this.mAd = E(aYQ());
      AppMethodBeat.o(9253);
      return true;
    }
    AppMethodBeat.o(9253);
    return false;
  }
  
  protected Bitmap aYQ()
  {
    AppMethodBeat.i(9260);
    if ((this.mAd == null) || (this.mAd.isRecycled())) {
      this.mAd = this.mAc.F(this.mContext, 480);
    }
    if (this.mAd == null)
    {
      Log.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new BitmapUtil();
      this.mAd = BitmapUtil.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.mAd).drawColor(-7829368);
    }
    Bitmap localBitmap = this.mAd;
    AppMethodBeat.o(9260);
    return localBitmap;
  }
  
  public final void aYR()
  {
    AppMethodBeat.i(9262);
    float f = this.mAf;
    double d1 = aYO() * 1.0F / 2.0F * f;
    double d2 = f * (aYP() * 1.0F / 2.0F);
    this.mAm = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.mAl = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(9262);
  }
  
  public final c aYS()
  {
    AppMethodBeat.i(9264);
    label58:
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        Log.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          localc.mAe = new PointF(this.mAe.x, this.mAe.y);
          localc.mAc = this.mAc;
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
  
  public final boolean ah(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9254);
    this.mAk.clear();
    this.mAk.add(bl(this.mAl - 180.0F));
    this.mAk.add(bl(-this.mAl));
    this.mAk.add(bl(this.mAl));
    this.mAk.add(bl(-this.mAl + 180.0F));
    a locala = new a(this.mAk);
    int j = locala.mAp - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.mAp)
    {
      boolean bool2;
      if ((locala.mAo[i] >= paramFloat2) || (locala.mAo[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.mAo[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.mAo[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.mAn[i];
        float f2 = (paramFloat2 - locala.mAo[i]) / (locala.mAo[j] - locala.mAo[i]);
        bool2 = bool1;
        if ((locala.mAn[j] - locala.mAn[i]) * f2 + f1 < paramFloat1) {
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
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9255);
    this.mAe.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.hco = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(9255);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(9256);
    Log.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.mAd != null) && (!this.mAd.isRecycled()))
    {
      Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.mAd.toString() });
      this.mAd.recycle();
      this.mAd = null;
    }
    AppMethodBeat.o(9256);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9257);
    if ((this.mAd == null) || (this.mAd.isRecycled()))
    {
      Log.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(9257);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.mAh < this.hco)
    {
      this.hco = this.mAh;
      paramCanvas.save();
      paramCanvas.translate(this.mAe.x, this.mAe.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.hco, this.hco);
      paramCanvas.setDensity(this.mAd.getDensity());
      if (!this.lCv) {
        break label197;
      }
      paramCanvas.drawBitmap(this.mAd, -aYO() / 2, -aYP() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(9257);
      return;
      if (this.mAi <= this.hco) {
        break;
      }
      this.hco = this.mAi;
      break;
      label197:
      paramCanvas.clipRect(-aYO() / 2 + 40.0F, -aYP() / 2 + 40.0F, this.mAd.getWidth() / 2 - 40.0F, this.mAd.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.mAd, -aYO() / 2, -aYP() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.lCv = paramBoolean;
  }
  
  final class a
  {
    float[] mAn;
    float[] mAo;
    int mAp;
    
    public a()
    {
      AppMethodBeat.i(9249);
      Object localObject;
      this.mAp = localObject.size();
      this.mAn = new float[this.mAp];
      this.mAo = new float[this.mAp];
      int i = 0;
      while (i < this.mAp)
      {
        this.mAn[i] = ((PointF)localObject.get(i)).x;
        this.mAo[i] = ((PointF)localObject.get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.mAp);
      AppMethodBeat.o(9249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ab.c
 * JD-Core Version:    0.7.0.1
 */