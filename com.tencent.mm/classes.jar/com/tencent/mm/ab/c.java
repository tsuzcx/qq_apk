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
import com.tencent.mm.api.r;
import com.tencent.mm.bv.a.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  private Matrix aqj;
  public float eYO;
  private Rect jZV;
  public String jZY;
  public r jZZ;
  public boolean jaA;
  public Bitmap kaa;
  public PointF kab;
  private float kac;
  public PointF kad;
  private float kae;
  private float kaf;
  public boolean kag;
  List<PointF> kah;
  private float kai;
  private float kaj;
  protected Context mContext;
  public int mRotation;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(9251);
    this.mRotation = 0;
    this.eYO = 1.0F;
    this.kac = 1.0F;
    this.kag = false;
    this.kah = new ArrayList();
    this.jZY = paramString;
    this.aqj = paramMatrix;
    this.mContext = paramContext;
    this.jZV = paramRect;
    this.kab = new PointF();
    this.kad = new PointF();
    AppMethodBeat.o(9251);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, r paramr, Rect paramRect)
  {
    AppMethodBeat.i(9250);
    this.mRotation = 0;
    this.eYO = 1.0F;
    this.kac = 1.0F;
    this.kag = false;
    this.kah = new ArrayList();
    this.jZY = paramString;
    this.aqj = paramMatrix;
    this.jZZ = paramr;
    this.mContext = paramContext;
    this.jZV = paramRect;
    this.kab = new PointF();
    this.kad = new PointF();
    AppMethodBeat.o(9250);
  }
  
  private int aFO()
  {
    AppMethodBeat.i(9258);
    if (this.kaa != null)
    {
      int i = this.kaa.getWidth();
      AppMethodBeat.o(9258);
      return i;
    }
    AppMethodBeat.o(9258);
    return 0;
  }
  
  private int aFP()
  {
    AppMethodBeat.i(9259);
    if (this.kaa != null)
    {
      int i = this.kaa.getHeight();
      AppMethodBeat.o(9259);
      return i;
    }
    AppMethodBeat.o(9259);
    return 0;
  }
  
  private PointF aq(float paramFloat)
  {
    AppMethodBeat.i(9263);
    float f = this.eYO / this.kac / 2.0F;
    double d1 = aFO() * 1.0F / 2.0F * f;
    double d2 = f * (aFP() * 1.0F / 2.0F);
    this.kaj = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.kab.x + (float)(this.kaj * Math.cos(d1)));
    paramFloat = this.kab.y;
    d2 = this.kaj;
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
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), a.d.emoji_box).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), a.d.emoji_box), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(9261);
    return localBitmap;
  }
  
  public final boolean B(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9254);
    this.kah.clear();
    this.kah.add(aq(this.kai - 180.0F));
    this.kah.add(aq(-this.kai));
    this.kah.add(aq(this.kai));
    this.kah.add(aq(-this.kai + 180.0F));
    a locala = new a(this.kah);
    int j = locala.kam - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.kam)
    {
      boolean bool2;
      if ((locala.kal[i] >= paramFloat2) || (locala.kal[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.kal[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.kal[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.kak[i];
        float f2 = (paramFloat2 - locala.kal[i]) / (locala.kal[j] - locala.kal[i]);
        bool2 = bool1;
        if ((locala.kak[j] - locala.kak[i]) * f2 + f1 < paramFloat1) {
          if (bool1) {
            break label293;
          }
        }
      }
      label293:
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
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9252);
    this.kaa = w(aFQ());
    this.kae = (1.2F * this.jZV.width() / this.kaa.getWidth());
    this.kaf = (0.1F * this.jZV.width() / this.kaa.getWidth());
    this.kae *= paramFloat3;
    this.kaf *= paramFloat3;
    this.kac = ((float)(this.kaf + 0.28D * (this.kae - this.kaf)));
    this.mRotation = paramInt;
    this.eYO *= this.kac;
    Log.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.kae), Float.valueOf(this.kaf), Float.valueOf(this.kac) });
    this.kab.set(paramFloat1, paramFloat2);
    Log.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.kab });
    aFR();
    AppMethodBeat.o(9252);
  }
  
  public final boolean aFN()
  {
    AppMethodBeat.i(9253);
    Log.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.kaa == null) || (this.kaa.isRecycled()))
    {
      this.kaa = w(aFQ());
      AppMethodBeat.o(9253);
      return true;
    }
    AppMethodBeat.o(9253);
    return false;
  }
  
  protected Bitmap aFQ()
  {
    AppMethodBeat.i(9260);
    if ((this.kaa == null) || (this.kaa.isRecycled())) {
      this.kaa = this.jZZ.C(this.mContext, 480);
    }
    if (this.kaa == null)
    {
      Log.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new BitmapUtil();
      this.kaa = BitmapUtil.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.kaa).drawColor(-7829368);
    }
    Bitmap localBitmap = this.kaa;
    AppMethodBeat.o(9260);
    return localBitmap;
  }
  
  public final void aFR()
  {
    AppMethodBeat.i(9262);
    float f = this.kac;
    double d1 = aFO() * 1.0F / 2.0F * f;
    double d2 = f * (aFP() * 1.0F / 2.0F);
    this.kaj = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.kai = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(9262);
  }
  
  public final c aFS()
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
          localc.kab = new PointF(this.kab.x, this.kab.y);
          localc.jZZ = this.jZZ;
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
    this.kab.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.eYO = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(9255);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(9256);
    Log.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.kaa != null) && (!this.kaa.isRecycled()))
    {
      Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.kaa.toString() });
      this.kaa.recycle();
      this.kaa = null;
    }
    AppMethodBeat.o(9256);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9257);
    if ((this.kaa == null) || (this.kaa.isRecycled()))
    {
      Log.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(9257);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.kae < this.eYO)
    {
      this.eYO = this.kae;
      paramCanvas.save();
      paramCanvas.translate(this.kab.x, this.kab.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.eYO, this.eYO);
      paramCanvas.setDensity(this.kaa.getDensity());
      if (!this.jaA) {
        break label197;
      }
      paramCanvas.drawBitmap(this.kaa, -aFO() / 2, -aFP() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(9257);
      return;
      if (this.kaf <= this.eYO) {
        break;
      }
      this.eYO = this.kaf;
      break;
      label197:
      paramCanvas.clipRect(-aFO() / 2 + 40.0F, -aFP() / 2 + 40.0F, this.kaa.getWidth() / 2 - 40.0F, this.kaa.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.kaa, -aFO() / 2, -aFP() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.jaA = paramBoolean;
  }
  
  final class a
  {
    float[] kak;
    float[] kal;
    int kam;
    
    public a()
    {
      AppMethodBeat.i(9249);
      Object localObject;
      this.kam = localObject.size();
      this.kak = new float[this.kam];
      this.kal = new float[this.kam];
      int i = 0;
      while (i < this.kam)
      {
        this.kak[i] = ((PointF)localObject.get(i)).x;
        this.kal[i] = ((PointF)localObject.get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.kam);
      AppMethodBeat.o(9249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ab.c
 * JD-Core Version:    0.7.0.1
 */