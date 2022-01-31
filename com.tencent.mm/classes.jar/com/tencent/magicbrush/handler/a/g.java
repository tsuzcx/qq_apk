package com.tencent.magicbrush.handler.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class g
{
  h bkR = new h(parame, this);
  HashMap<String, k> bkS = new HashMap();
  g.a bkT = new g.a();
  private FloatBuffer bkU;
  private List<k> bkV = new ArrayList();
  private j bkW;
  private StringBuilder bkX = new StringBuilder();
  
  g(e parame) {}
  
  private List<k> bq(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    this.bkV.clear();
    int i = 0;
    while (i < paramString.length())
    {
      int j;
      if (b.qF() == null) {
        j = 0;
      }
      int k;
      int m;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      while (j > 0) {
        if (j <= 0)
        {
          throw new IllegalStateException("There is no font drawable");
          j = b.qF().l(paramString, i);
        }
        else
        {
          this.bkX.setLength(0);
          k = j;
          m = i;
          while (k > 0)
          {
            this.bkX.append(paramString.charAt(m));
            m += 1;
            k -= 1;
          }
          this.bkX.append("|").append(this.bkW.fontSize);
          localObject2 = this.bkX.toString();
          localObject1 = (k)this.bkS.get(localObject2);
          if (localObject1 != null) {}
          for (;;)
          {
            i += j;
            if (localObject1 != null) {
              break;
            }
            this.bkV.clear();
            return null;
            if (b.qF() == null) {
              throw new IllegalStateException("FontDrawableProvider must support");
            }
            localObject3 = b.qF().m(paramString, i);
            if (localObject3 == null)
            {
              localObject1 = k.blt;
            }
            else
            {
              k = (int)this.bkW.fontSize;
              m = (int)this.bkW.fontSize;
              if ((k <= 0) || (m <= 0))
              {
                localObject1 = k.blt;
              }
              else
              {
                localObject4 = this.bkR;
                if ((k <= 0) || (m <= 0)) {
                  throw new IllegalArgumentException("width or height unexpected");
                }
                localObject1 = ((h)localObject4).bkZ.bkT.qM();
                ((k)localObject1).blu = k;
                ((k)localObject1).blv = 0.0F;
                ((h)localObject4).bla.b(k, m, ((h)localObject4).ble);
                localObject5 = ((h)localObject4).ble;
                if ((((Rect)localObject5).left < 0) || (((Rect)localObject5).right < 0) || (((Rect)localObject5).width() <= 0) || (((Rect)localObject5).height() <= 0)) {
                  localObject1 = null;
                }
                for (;;)
                {
                  if (localObject1 != null) {
                    break label538;
                  }
                  localObject1 = null;
                  break;
                  ((k)localObject1).z(k, m);
                  ((k)localObject1).d(((Rect)localObject5).left / ((h)localObject4).bla.width(), ((Rect)localObject5).top / ((h)localObject4).bla.height(), ((Rect)localObject5).right / ((h)localObject4).bla.width(), ((Rect)localObject5).bottom / ((h)localObject4).bla.height());
                  ((k)localObject1).blA = true;
                  ((h)localObject4).blb.save();
                  ((h)localObject4).blb.clipRect((Rect)localObject5);
                  ((Drawable)localObject3).setBounds((Rect)localObject5);
                  ((Drawable)localObject3).draw(((h)localObject4).blb);
                  ((h)localObject4).blb.restore();
                }
                label538:
                this.bkS.put(localObject2, localObject1);
              }
            }
          }
        }
      }
      char c = paramString.charAt(i);
      if (this.bkW == null) {
        localObject1 = null;
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.bkW == null)
        {
          localObject2 = null;
          localObject1 = (k)this.bkS.get(localObject2);
          if (localObject1 == null) {}
        }
        else
        {
          this.bkX.setLength(0);
          localObject2 = this.bkX.append(c).append("|").append(this.bkW.fontSize).append("|");
          if (this.bkW.blk == null) {}
          for (localObject1 = "null";; localObject1 = Integer.valueOf(this.bkW.blk.hashCode()))
          {
            localObject1 = ((StringBuilder)localObject2).append(localObject1);
            if (this.bkW.bll) {
              ((StringBuilder)localObject1).append("|").append(this.bkW.strokeWidth);
            }
            if (this.bkW.blm != null) {
              ((StringBuilder)localObject1).append("|").append(this.bkW.blm.blr);
            }
            localObject2 = ((StringBuilder)localObject1).toString();
            break;
          }
        }
        localObject3 = this.bkR;
        localObject1 = ((h)localObject3).bkZ.bkT.qM();
        ((k)localObject1).blA = false;
        k = (int)Math.ceil(((h)localObject3).blg.descent - ((h)localObject3).blg.ascent);
        ((h)localObject3).bld[0] = c;
        ((h)localObject3).blc.getTextBounds(((h)localObject3).bld, 0, 1, ((h)localObject3).ble);
        float f = ((h)localObject3).blc.measureText(((h)localObject3).bld, 0, 1);
        m = (int)Math.ceil(Math.max(((h)localObject3).ble.width(), f) + 1.0F);
        if (localObject1 != null)
        {
          ((k)localObject1).blu = m;
          localObject4 = ((h)localObject3).blc;
          if ((localObject4 != null) && ((((Paint)localObject4).getStyle() == Paint.Style.STROKE) || (((Paint)localObject4).getStyle() == Paint.Style.FILL_AND_STROKE)))
          {
            j = 1;
            label924:
            if (j == 0) {
              break label1042;
            }
            ((k)localObject1).blv = (-((h)localObject3).blc.getStrokeWidth() / 2.0F);
            ((k)localObject1).z(m + ((h)localObject3).blc.getStrokeWidth(), k);
          }
        }
        else
        {
          label965:
          if (((h)localObject3).bla.b((int)Math.ceil(((k)localObject1).width), (int)Math.ceil(((k)localObject1).height), ((h)localObject3).ble)) {
            break label1062;
          }
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            new StringBuilder("Load glyph failed. glyph == null [").append(c).append("]");
            localObject1 = null;
            break;
            j = 0;
            break label924;
            label1042:
            ((k)localObject1).blv = 0.0F;
            ((k)localObject1).z(m, k);
            break label965;
            label1062:
            localObject4 = ((h)localObject3).ble;
            ((k)localObject1).d(((Rect)localObject4).left / ((h)localObject3).bla.width(), ((Rect)localObject4).top / ((h)localObject3).bla.height(), ((Rect)localObject4).right / ((h)localObject3).bla.width(), ((Rect)localObject4).bottom / ((h)localObject3).bla.height());
            localObject4 = ((h)localObject3).ble;
            localObject5 = ((h)localObject3).blc;
            if ((localObject5 == null) || (localObject1 == null) || (localObject4 != null)) {
              for (;;)
              {
                ((h)localObject3).bld[0] = c;
                ((h)localObject3).blb.save();
                ((h)localObject3).blb.clipRect((Rect)localObject4);
                ((h)localObject3).blb.drawText(((h)localObject3).bld, 0, 1, ((Rect)localObject4).left - ((k)localObject1).blv, ((Rect)localObject4).top + ((k)localObject1).height - ((h)localObject3).blg.descent - 1.0F, (Paint)localObject5);
                ((h)localObject3).blb.restore();
              }
            }
          }
        }
        this.bkS.put(localObject2, localObject1);
      }
      this.bkV.add(localObject1);
    }
    return this.bkV;
  }
  
  final void a(j paramj)
  {
    int i = 0;
    this.bkW = paramj;
    h localh = this.bkR;
    localh.blc.setTypeface(paramj.blk);
    localh.blc.setTextSize(paramj.fontSize);
    if (paramj.bll)
    {
      localh.blc.setStyle(Paint.Style.STROKE);
      localh.blc.setStrokeWidth(paramj.strokeWidth);
    }
    for (;;)
    {
      localh.blc.setTextSkewX(0.0F);
      localh.blc.setFakeBoldText(false);
      if (paramj.blm != null)
      {
        if ((paramj.blk == null) || (paramj.blk.getStyle() != paramj.blm.blr))
        {
          if ((paramj.blm == j.a.blp) || (paramj.blm == j.a.blq)) {
            localh.blc.setTextSkewX(-0.25F);
          }
          if ((paramj.blm == j.a.blo) || (paramj.blm == j.a.blq)) {
            localh.blc.setFakeBoldText(true);
          }
        }
        paramj = paramj.blm;
        if ((paramj == j.a.blo) || (paramj == j.a.blq)) {
          i = 1;
        }
        if (i != 0) {
          localh.blc.setFakeBoldText(true);
        }
      }
      localh.blc.getFontMetrics(localh.blg);
      return;
      localh.blc.setStyle(Paint.Style.FILL);
    }
  }
  
  final FloatBuffer bp(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    List localList;
    do
    {
      return null;
      localList = bq(paramString);
    } while ((localList == null) || (localList.size() == 0));
    int i = Math.max(paramString.length(), 10) * 36 + 16;
    if ((this.bkU == null) || (this.bkU.capacity() * 4 < i)) {
      this.bkU = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.bkU.clear();
    paramString = this.bkU;
    float f = h.y(localList);
    Paint.FontMetrics localFontMetrics = this.bkR.blg;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.descent).put(localFontMetrics.descent - localFontMetrics.ascent);
    k.a(paramString, localList);
    paramString.flip();
    this.bkV.clear();
    return paramString;
  }
  
  final float br(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0.0F;
    }
    paramString = bq(paramString);
    if ((paramString == null) || (paramString.size() == 0)) {
      return -1.0F;
    }
    return h.y(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.g
 * JD-Core Version:    0.7.0.1
 */