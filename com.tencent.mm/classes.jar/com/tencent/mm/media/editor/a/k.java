package com.tencent.mm.media.editor.a;

import a.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.al;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/LyricsEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/media/editor/item/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "curIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "waveTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-mediaeditor_release"})
public final class k
  extends b
{
  private int alpha;
  private final Matrix asO;
  private long duration;
  private int eSO;
  private long eSP;
  private int eSQ;
  private final long eSR;
  private final long eSS;
  private final long eST;
  private final long eSU;
  private final int eSV;
  private final int eSW;
  private final float eSX;
  private final float eSY;
  private final int eSZ;
  private final float eTa;
  private final float eTb;
  private final float eTc;
  private final int eTd;
  private final RectF[] eTe;
  private final float[] eTf;
  private Paint eTg;
  private final List<j> eTh;
  
  public k(List<j> paramList, Matrix paramMatrix)
  {
    AppMethodBeat.i(152085);
    this.eTh = paramList;
    this.asO = paramMatrix;
    this.eSR = 16L;
    this.eSS = 50L;
    this.eST = 200L;
    this.eSU = 3000L;
    this.eSV = 11;
    this.eSW = al.fromDPToPix(ah.getContext(), 1);
    this.eSX = (this.eSW * 1.5F);
    this.eSY = (this.eSW * 9.0F);
    this.eSZ = this.eSW;
    this.eTa = (this.eSW * 1.5F);
    this.eTb = (this.eSW * 12.0F);
    this.eTc = (this.eSW * 2.0F);
    this.eTd = this.eSW;
    int j = this.eSV;
    paramList = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.eTe = paramList;
    this.eTf = new float[this.eSV];
    this.eTg = new Paint();
    AppMethodBeat.o(152085);
  }
  
  public final long UG()
  {
    return this.eSR;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(152084);
    a.f.b.j.q(paramCanvas, "canvas");
    a.f.b.j.q(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((j)this.eTh.get(this.eSO)).bitmap;
    if (localBitmap != null)
    {
      this.duration += this.eSz;
      Object localObject1 = (j)a.a.j.w(this.eTh, this.eSO + 1);
      long l2;
      label236:
      long l3;
      long l4;
      label258:
      label280:
      label317:
      float f1;
      int i;
      int j;
      label398:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((j)localObject1).eSN;
        if (localObject1 != null)
        {
          l1 = ((baz)localObject1).startTime;
          if (this.duration >= l1)
          {
            this.eSO += 1;
            if (this.eSO >= this.eTh.size())
            {
              this.eSO = 0;
              this.duration = 0L;
              this.eSP = 0L;
            }
          }
          if (this.eSO < this.eTh.size())
          {
            l2 = ((j)this.eTh.get(this.eSO)).eSN.startTime;
            localObject1 = (j)a.a.j.w(this.eTh, this.eSO + 1);
            if (localObject1 == null) {
              break label597;
            }
            localObject1 = ((j)localObject1).eSN;
            if (localObject1 == null) {
              break label597;
            }
            l1 = ((baz)localObject1).startTime;
            l3 = this.eST;
            l4 = this.duration - l2;
            if (0L <= l4) {
              break label629;
            }
            l3 = this.eST;
            l4 = l1 - this.duration;
            if (0L <= l4) {
              break label663;
            }
            if ((this.duration - l2 > this.eST) && (l1 - this.duration > this.eST)) {
              this.alpha = 255;
            }
          }
          paramPaint.setAlpha(this.alpha);
          paramCanvas.concat(this.asO);
          if (this.eTh.isEmpty()) {
            break label909;
          }
          if ((this.eSP != 0L) && (this.duration - this.eSP <= this.eSS)) {
            break label746;
          }
          this.eSP = this.duration;
          f1 = 0.0F;
          localObject1 = this.eTe;
          i = 0;
          int k = localObject1.length;
          j = 0;
          if (j >= k) {
            break label746;
          }
          localObject2 = localObject1[j];
          f2 = localObject2.height();
          if (f2 > this.eSZ) {
            break label697;
          }
          this.eTf[i] = ((float)(this.eSY * Math.random()));
          label447:
          if (f2 > this.eTf[i]) {
            break label725;
          }
        }
      }
      label663:
      label697:
      label725:
      for (float f2 = Math.min(this.eTc + f2, this.eSY);; f2 = Math.max(f2 - this.eTd, this.eSZ))
      {
        float f3 = this.eTa;
        float f4 = this.eSY / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.eTa;
        float f7 = this.eSX;
        float f8 = this.eSY / 2.0F;
        localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localObject2.right;
        j += 1;
        i += 1;
        break label398;
        l1 = ((j)this.eTh.get(this.eSO)).eSN.startTime + this.eSU;
        break;
        label597:
        l1 = ((j)this.eTh.get(this.eSO)).eSN.startTime + this.eSU;
        break label236;
        label629:
        if (l3 < l4) {
          break label258;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.eST));
        break label317;
        if (l3 < l4) {
          break label280;
        }
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.eST * 255.0F));
        break label317;
        if (f2 < this.eTf[i]) {
          break label447;
        }
        this.eTf[i] = this.eSZ;
        break label447;
      }
      label746:
      long l1 = ((j)this.eTh.get(0)).eSN.startTime;
      if (this.eSQ < 255)
      {
        l2 = this.eST;
        l3 = this.duration - l1;
        if (0L <= l3) {
          break label875;
        }
        if (this.duration - l1 <= this.eST) {}
      }
      for (this.eSQ = 255;; this.eSQ = ((int)((float)(this.duration - l1) * 255.0F / (float)this.eST)))
      {
        this.eTg.setAlpha(this.eSQ);
        localObject1 = this.eTe;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          paramCanvas.drawRect(localObject1[i], this.eTg);
          i += 1;
        }
        label875:
        if (l2 < l3) {
          break;
        }
      }
      label909:
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.eTb, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(152084);
  }
  
  public final void init()
  {
    AppMethodBeat.i(152083);
    this.eTg.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(152083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.k
 * JD-Core Version:    0.7.0.1
 */