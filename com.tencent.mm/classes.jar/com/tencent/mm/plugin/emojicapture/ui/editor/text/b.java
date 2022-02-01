package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.fontdecode.PathExtractor;
import com.tencent.mm.fontdecode.PathExtractor.Metrics;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "fontPaths", "", "", "textSize", "", "([Ljava/lang/String;I)V", "currFont", "dataMap", "", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "defaultDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontPath", "TextPathData", "plugin-emojicapture_release"})
public final class b
  implements c
{
  private CharSequence LV;
  private String vbl;
  private Map<String, a> vbm;
  private final a vbn;
  
  public b(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(826);
    this.vbl = "";
    this.vbm = ((Map)new HashMap());
    this.vbn = new a();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      a locala = new a(str, paramInt);
      if (locala.vbo.isValid()) {
        this.vbm.put(str, locala);
      }
      i += 1;
    }
    AppMethodBeat.o(826);
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    AppMethodBeat.i(825);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    if (Util.isNullOrNil(this.LV))
    {
      AppMethodBeat.o(825);
      return;
    }
    a locala = (a)this.vbm.get(this.vbl);
    if (locala == null)
    {
      this.vbn.a(paramCanvas, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint, paramBoolean);
      AppMethodBeat.o(825);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    int i = -1;
    if (paramInt1 < paramInt2)
    {
      Object localObject;
      if (locala.vbp.get(paramInt1) != null)
      {
        localObject = locala.vbp.get(paramInt1);
        if (localObject == null) {
          p.iCn();
        }
        paramCanvas.drawPath((Path)localObject, paramPaint);
        paramFloat1 = paramPaint.measureText(this.LV, paramInt1, paramInt1 + 1);
      }
      for (;;)
      {
        paramCanvas.translate(paramFloat1, 0.0F);
        int j = i;
        label228:
        do
        {
          for (;;)
          {
            paramInt1 += 1;
            i = j;
            break;
            localObject = this.LV;
            if (localObject == null) {
              p.iCn();
            }
            if ((!kotlin.n.a.P(((CharSequence)localObject).charAt(paramInt1))) || (i != -1)) {
              break label228;
            }
            j = paramInt1;
          }
          if (i == -1) {
            break label355;
          }
          localObject = this.LV;
          if (localObject == null) {
            p.iCn();
          }
          if (paramInt1 >= ((CharSequence)localObject).length() - 1) {
            break label295;
          }
          localObject = this.LV;
          if (localObject == null) {
            p.iCn();
          }
          j = i;
        } while (kotlin.n.a.P(((CharSequence)localObject).charAt(paramInt1 + 1)));
        label295:
        paramCanvas.save();
        localObject = this.LV;
        if (localObject == null) {
          p.iCn();
        }
        paramCanvas.drawText((CharSequence)localObject, i, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramCanvas.restore();
        paramFloat1 = paramPaint.measureText(this.LV, i, paramInt1 + 1);
        i = -1;
        continue;
        label355:
        localObject = this.LV;
        if (localObject == null) {
          p.iCn();
        }
        paramCanvas.drawText((CharSequence)localObject, paramInt1, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramFloat1 = paramPaint.measureText(this.LV, paramInt1, paramInt1 + 1);
      }
    }
    if (paramBoolean) {
      paramCanvas.drawText(c.a.cYC(), 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
    AppMethodBeat.o(825);
  }
  
  public final void avq(String paramString)
  {
    AppMethodBeat.i(824);
    p.k(paramString, "fontPath");
    this.vbl = paramString;
    AppMethodBeat.o(824);
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(823);
    Iterator localIterator = this.vbm.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      CharSequence localCharSequence = this.LV;
      locala.vbp.clear();
      locala.vbq.clear();
      if (localCharSequence != null)
      {
        int i = 0;
        label74:
        if (i < localCharSequence.length())
        {
          char c = localCharSequence.charAt(i);
          Path localPath = new Path();
          RectF localRectF = new RectF();
          if (!locala.vbo.a(c, localPath, localRectF)) {
            break label161;
          }
          locala.vbp.add(localPath);
          locala.vbq.add(localRectF);
        }
        for (;;)
        {
          i += 1;
          break label74;
          break;
          label161:
          locala.vbp.add(null);
          locala.vbq.add(null);
        }
      }
    }
    AppMethodBeat.o(823);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(822);
    p.k(paramCharSequence, "text");
    this.LV = paramCharSequence;
    this.vbn.setText(paramCharSequence);
    AppMethodBeat.o(822);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "", "fontPath", "", "textSize", "", "(Ljava/lang/String;I)V", "boxList", "", "Landroid/graphics/RectF;", "getBoxList", "()Ljava/util/List;", "metrics", "Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "getMetrics", "()Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "pathExtractor", "Lcom/tencent/mm/fontdecode/PathExtractor;", "pathList", "Landroid/graphics/Path;", "getPathList", "isValid", "", "refresh", "", "text", "", "plugin-emojicapture_release"})
  public static final class a
  {
    final PathExtractor vbo;
    final List<Path> vbp;
    final List<RectF> vbq;
    private final PathExtractor.Metrics vbr;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(821);
      this.vbo = new PathExtractor(paramString);
      this.vbr = new PathExtractor.Metrics();
      this.vbo.setTextSize(paramInt);
      this.vbp = ((List)new ArrayList());
      this.vbq = ((List)new ArrayList());
      this.vbo.a(this.vbr);
      AppMethodBeat.o(821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.b
 * JD-Core Version:    0.7.0.1
 */