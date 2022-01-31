package com.tencent.mm.plugin.emojicapture.ui.editor.a;

import a.d.b.g;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mm.fontdecode.PathExtractor;
import com.tencent.mm.fontdecode.PathExtractor.Metrics;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements c
{
  private String jqK = "";
  private Map<String, a> jqL = (Map)new HashMap();
  private final a rpI = new a();
  private CharSequence text;
  
  public b(String[] paramArrayOfString, int paramInt)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      a locala = new a(str, paramInt);
      if (locala.jqM.isValid()) {
        this.jqL.put(str, locala);
      }
      i += 1;
    }
  }
  
  public final void Bo(String paramString)
  {
    g.k(paramString, "fontPath");
    this.jqK = paramString;
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    g.k(paramCanvas, "canvas");
    g.k(paramPaint, "paint");
    if (bk.L(this.text)) {
      return;
    }
    a locala = (a)this.jqL.get(this.jqK);
    if (locala == null)
    {
      this.rpI.a(paramCanvas, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint, paramBoolean);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    int i = -1;
    if (paramInt1 < paramInt2)
    {
      if (locala.jqN.get(paramInt1) != null)
      {
        paramCanvas.drawPath((Path)locala.jqN.get(paramInt1), paramPaint);
        paramFloat1 = paramPaint.measureText(this.text, paramInt1, paramInt1 + 1);
      }
      for (;;)
      {
        paramCanvas.translate(paramFloat1, 0.0F);
        int j = i;
        CharSequence localCharSequence;
        label198:
        do
        {
          for (;;)
          {
            paramInt1 += 1;
            i = j;
            break;
            localCharSequence = this.text;
            if (localCharSequence == null) {
              g.cUk();
            }
            if ((!a.h.a.isSurrogate(localCharSequence.charAt(paramInt1))) || (i != -1)) {
              break label198;
            }
            j = paramInt1;
          }
          if (i == -1) {
            break label313;
          }
          localCharSequence = this.text;
          if (localCharSequence == null) {
            g.cUk();
          }
          if (paramInt1 >= localCharSequence.length() - 1) {
            break label265;
          }
          localCharSequence = this.text;
          if (localCharSequence == null) {
            g.cUk();
          }
          j = i;
        } while (a.h.a.isSurrogate(localCharSequence.charAt(paramInt1 + 1)));
        label265:
        paramCanvas.save();
        paramCanvas.drawText(this.text, i, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramCanvas.restore();
        paramFloat1 = paramPaint.measureText(this.text, i, paramInt1 + 1);
        i = -1;
        continue;
        label313:
        paramCanvas.drawText(this.text, paramInt1, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramFloat1 = paramPaint.measureText(this.text, paramInt1, paramInt1 + 1);
      }
    }
    if (paramBoolean) {
      paramCanvas.drawText(c.a.ceH(), 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
  }
  
  public final void refresh()
  {
    Iterator localIterator = this.jqL.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      CharSequence localCharSequence = this.text;
      locala.jqN.clear();
      locala.jqO.clear();
      if (localCharSequence != null)
      {
        int i = 0;
        label68:
        if (i < localCharSequence.length())
        {
          char c = localCharSequence.charAt(i);
          Path localPath = new Path();
          RectF localRectF = new RectF();
          if (!locala.jqM.a(c, localPath, localRectF)) {
            break label155;
          }
          locala.jqN.add(localPath);
          locala.jqO.add(localRectF);
        }
        for (;;)
        {
          i += 1;
          break label68;
          break;
          label155:
          locala.jqN.add(null);
          locala.jqO.add(null);
        }
      }
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    g.k(paramCharSequence, "text");
    this.text = paramCharSequence;
    this.rpI.setText(paramCharSequence);
  }
  
  public static final class a
  {
    final PathExtractor jqM;
    final List<Path> jqN;
    final List<RectF> jqO;
    private final PathExtractor.Metrics jqP;
    
    public a(String paramString, int paramInt)
    {
      this.jqM = new PathExtractor(paramString);
      this.jqP = new PathExtractor.Metrics();
      this.jqM.setTextSize(paramInt);
      this.jqN = ((List)new ArrayList());
      this.jqO = ((List)new ArrayList());
      this.jqM.a(this.jqP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.a.b
 * JD-Core Version:    0.7.0.1
 */