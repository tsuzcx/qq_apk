package com.tencent.mm.media.editor.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ao;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/LyricsEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/media/editor/item/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "curIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "waveTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-mediaeditor_release"})
public final class k
  extends b
{
  private int alpha;
  private long duration;
  private int gPA;
  private long gPB;
  private int gPC;
  private final long gPD;
  private final long gPE;
  private final long gPF;
  private final long gPG;
  private final int gPH;
  private final int gPI;
  private final float gPJ;
  private final float gPK;
  private final int gPL;
  private final float gPM;
  private final float gPN;
  private final float gPO;
  private final int gPP;
  private final RectF[] gPQ;
  private final float[] gPR;
  private Paint gPS;
  private final List<j> gPT;
  
  public k(List<j> paramList, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(93581);
    this.gPT = paramList;
    this.gPD = 16L;
    this.gPE = 50L;
    this.gPF = 200L;
    this.gPG = 3000L;
    this.gPH = 11;
    this.gPI = ao.fromDPToPix(ai.getContext(), 1);
    this.gPJ = (this.gPI * 1.5F);
    this.gPK = (this.gPI * 9.0F);
    this.gPL = this.gPI;
    this.gPM = (this.gPI * 1.5F);
    this.gPN = (this.gPI * 12.0F);
    this.gPO = (this.gPI * 2.0F);
    this.gPP = this.gPI;
    int j = this.gPH;
    paramList = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.gPQ = paramList;
    this.gPR = new float[this.gPH];
    this.gPS = new Paint();
    AppMethodBeat.o(93581);
  }
  
  public final long aqx()
  {
    return this.gPD;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(93580);
    d.g.b.k.h(paramCanvas, "canvas");
    d.g.b.k.h(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((j)this.gPT.get(this.gPA)).bitmap;
    if (localBitmap != null)
    {
      this.duration += this.gPk;
      Object localObject1 = (j)d.a.j.C(this.gPT, this.gPA + 1);
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
        localObject1 = ((j)localObject1).gPz;
        if (localObject1 != null)
        {
          l1 = ((brn)localObject1).startTime;
          if (this.duration >= l1)
          {
            this.gPA += 1;
            if (this.gPA >= this.gPT.size())
            {
              this.gPA = 0;
              this.duration = 0L;
              this.gPB = 0L;
            }
          }
          if (this.gPA < this.gPT.size())
          {
            l2 = ((j)this.gPT.get(this.gPA)).gPz.startTime;
            localObject1 = (j)d.a.j.C(this.gPT, this.gPA + 1);
            if (localObject1 == null) {
              break label597;
            }
            localObject1 = ((j)localObject1).gPz;
            if (localObject1 == null) {
              break label597;
            }
            l1 = ((brn)localObject1).startTime;
            l3 = this.gPF;
            l4 = this.duration - l2;
            if (0L <= l4) {
              break label629;
            }
            l3 = this.gPF;
            l4 = l1 - this.duration;
            if (0L <= l4) {
              break label663;
            }
            if ((this.duration - l2 > this.gPF) && (l1 - this.duration > this.gPF)) {
              this.alpha = 255;
            }
          }
          paramPaint.setAlpha(this.alpha);
          paramCanvas.concat(this.eY);
          if (this.gPT.isEmpty()) {
            break label909;
          }
          if ((this.gPB != 0L) && (this.duration - this.gPB <= this.gPE)) {
            break label746;
          }
          this.gPB = this.duration;
          localObject1 = this.gPQ;
          i = 0;
          int k = localObject1.length;
          j = 0;
          f1 = 0.0F;
          if (j >= k) {
            break label746;
          }
          localObject2 = localObject1[j];
          f2 = localObject2.height();
          if (f2 > this.gPL) {
            break label697;
          }
          this.gPR[i] = ((float)(this.gPK * Math.random()));
          label447:
          if (f2 > this.gPR[i]) {
            break label725;
          }
        }
      }
      label663:
      label697:
      label725:
      for (float f2 = Math.min(f2 + this.gPO, this.gPK);; f2 = Math.max(f2 - this.gPP, this.gPL))
      {
        float f3 = this.gPM;
        float f4 = this.gPK / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.gPM;
        float f7 = this.gPJ;
        float f8 = this.gPK / 2.0F;
        localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localObject2.right;
        j += 1;
        i += 1;
        break label398;
        l1 = ((j)this.gPT.get(this.gPA)).gPz.startTime + this.gPG;
        break;
        label597:
        l1 = ((j)this.gPT.get(this.gPA)).gPz.startTime + this.gPG;
        break label236;
        label629:
        if (l3 < l4) {
          break label258;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.gPF));
        break label317;
        if (l3 < l4) {
          break label280;
        }
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.gPF * 255.0F));
        break label317;
        if (f2 < this.gPR[i]) {
          break label447;
        }
        this.gPR[i] = this.gPL;
        break label447;
      }
      label746:
      long l1 = ((j)this.gPT.get(0)).gPz.startTime;
      if (this.gPC < 255)
      {
        l2 = this.gPF;
        l3 = this.duration - l1;
        if (0L <= l3) {
          break label875;
        }
        if (this.duration - l1 <= this.gPF) {}
      }
      for (this.gPC = 255;; this.gPC = ((int)((float)(this.duration - l1) * 255.0F / (float)this.gPF)))
      {
        this.gPS.setAlpha(this.gPC);
        localObject1 = this.gPQ;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          paramCanvas.drawRect(localObject1[i], this.gPS);
          i += 1;
        }
        label875:
        if (l2 < l3) {
          break;
        }
      }
      label909:
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.gPN, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(93580);
  }
  
  public final void init()
  {
    AppMethodBeat.i(93579);
    this.gPS.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(93579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.k
 * JD-Core Version:    0.7.0.1
 */