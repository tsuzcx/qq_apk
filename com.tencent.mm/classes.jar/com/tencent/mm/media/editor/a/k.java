package com.tencent.mm.media.editor.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ao;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/LyricsEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/media/editor/item/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "curIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "waveTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-mediaeditor_release"})
public final class k
  extends b
{
  private int alpha;
  private long duration;
  private int goS;
  private long goT;
  private int goU;
  private final long goV;
  private final long goW;
  private final long goX;
  private final long goY;
  private final int goZ;
  private final int gpa;
  private final float gpb;
  private final float gpc;
  private final int gpd;
  private final float gpe;
  private final float gpf;
  private final float gpg;
  private final int gph;
  private final RectF[] gpi;
  private final float[] gpj;
  private Paint gpk;
  private final List<j> gpl;
  
  public k(List<j> paramList, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(93581);
    this.gpl = paramList;
    this.goV = 16L;
    this.goW = 50L;
    this.goX = 200L;
    this.goY = 3000L;
    this.goZ = 11;
    this.gpa = ao.fromDPToPix(aj.getContext(), 1);
    this.gpb = (this.gpa * 1.5F);
    this.gpc = (this.gpa * 9.0F);
    this.gpd = this.gpa;
    this.gpe = (this.gpa * 1.5F);
    this.gpf = (this.gpa * 12.0F);
    this.gpg = (this.gpa * 2.0F);
    this.gph = this.gpa;
    int j = this.goZ;
    paramList = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.gpi = paramList;
    this.gpj = new float[this.goZ];
    this.gpk = new Paint();
    AppMethodBeat.o(93581);
  }
  
  public final long ajy()
  {
    return this.goV;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(93580);
    d.g.b.k.h(paramCanvas, "canvas");
    d.g.b.k.h(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((j)this.gpl.get(this.goS)).bitmap;
    if (localBitmap != null)
    {
      this.duration += this.goC;
      Object localObject1 = (j)d.a.j.C(this.gpl, this.goS + 1);
      long l2;
      label236:
      long l3;
      long l4;
      label258:
      label280:
      label317:
      int i;
      int j;
      float f1;
      label398:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((j)localObject1).goR;
        if (localObject1 != null)
        {
          l1 = ((bmx)localObject1).startTime;
          if (this.duration >= l1)
          {
            this.goS += 1;
            if (this.goS >= this.gpl.size())
            {
              this.goS = 0;
              this.duration = 0L;
              this.goT = 0L;
            }
          }
          if (this.goS < this.gpl.size())
          {
            l2 = ((j)this.gpl.get(this.goS)).goR.startTime;
            localObject1 = (j)d.a.j.C(this.gpl, this.goS + 1);
            if (localObject1 == null) {
              break label597;
            }
            localObject1 = ((j)localObject1).goR;
            if (localObject1 == null) {
              break label597;
            }
            l1 = ((bmx)localObject1).startTime;
            l3 = this.goX;
            l4 = this.duration - l2;
            if (0L <= l4) {
              break label629;
            }
            l3 = this.goX;
            l4 = l1 - this.duration;
            if (0L <= l4) {
              break label663;
            }
            if ((this.duration - l2 > this.goX) && (l1 - this.duration > this.goX)) {
              this.alpha = 255;
            }
          }
          paramPaint.setAlpha(this.alpha);
          paramCanvas.concat(this.dY);
          if (this.gpl.isEmpty()) {
            break label909;
          }
          if ((this.goT != 0L) && (this.duration - this.goT <= this.goW)) {
            break label746;
          }
          this.goT = this.duration;
          localObject1 = this.gpi;
          i = 0;
          int k = localObject1.length;
          j = 0;
          f1 = 0.0F;
          if (j >= k) {
            break label746;
          }
          localObject2 = localObject1[j];
          f2 = localObject2.height();
          if (f2 > this.gpd) {
            break label697;
          }
          this.gpj[i] = ((float)(this.gpc * Math.random()));
          label447:
          if (f2 > this.gpj[i]) {
            break label725;
          }
        }
      }
      label663:
      label697:
      label725:
      for (float f2 = Math.min(f2 + this.gpg, this.gpc);; f2 = Math.max(f2 - this.gph, this.gpd))
      {
        float f3 = this.gpe;
        float f4 = this.gpc / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.gpe;
        float f7 = this.gpb;
        float f8 = this.gpc / 2.0F;
        localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localObject2.right;
        j += 1;
        i += 1;
        break label398;
        l1 = ((j)this.gpl.get(this.goS)).goR.startTime + this.goY;
        break;
        label597:
        l1 = ((j)this.gpl.get(this.goS)).goR.startTime + this.goY;
        break label236;
        label629:
        if (l3 < l4) {
          break label258;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.goX));
        break label317;
        if (l3 < l4) {
          break label280;
        }
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.goX * 255.0F));
        break label317;
        if (f2 < this.gpj[i]) {
          break label447;
        }
        this.gpj[i] = this.gpd;
        break label447;
      }
      label746:
      long l1 = ((j)this.gpl.get(0)).goR.startTime;
      if (this.goU < 255)
      {
        l2 = this.goX;
        l3 = this.duration - l1;
        if (0L <= l3) {
          break label875;
        }
        if (this.duration - l1 <= this.goX) {}
      }
      for (this.goU = 255;; this.goU = ((int)((float)(this.duration - l1) * 255.0F / (float)this.goX)))
      {
        this.gpk.setAlpha(this.goU);
        localObject1 = this.gpi;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          paramCanvas.drawRect(localObject1[i], this.gpk);
          i += 1;
        }
        label875:
        if (l2 < l3) {
          break;
        }
      }
      label909:
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.gpf, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(93580);
  }
  
  public final void init()
  {
    AppMethodBeat.i(93579);
    this.gpk.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(93579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.k
 * JD-Core Version:    0.7.0.1
 */