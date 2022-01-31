package com.tencent.mm.plugin.emojicapture.ui.editor.a;

import a.f.b.j;
import a.l;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.fontdecode.PathExtractor;
import com.tencent.mm.fontdecode.PathExtractor.Metrics;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "fontPaths", "", "", "textSize", "", "([Ljava/lang/String;I)V", "currFont", "dataMap", "", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "defaultDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontPath", "TextPathData", "plugin-emojicapture_release"})
public final class b
  implements c
{
  private String lAv;
  private Map<String, a> lAw;
  private final a lAx;
  private CharSequence text;
  
  public b(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(3139);
    this.lAv = "";
    this.lAw = ((Map)new HashMap());
    this.lAx = new a();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      a locala = new a(str, paramInt);
      if (locala.lAy.isValid()) {
        this.lAw.put(str, locala);
      }
      i += 1;
    }
    AppMethodBeat.o(3139);
  }
  
  public final void Lq(String paramString)
  {
    AppMethodBeat.i(3137);
    j.q(paramString, "fontPath");
    this.lAv = paramString;
    AppMethodBeat.o(3137);
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    AppMethodBeat.i(3138);
    j.q(paramCanvas, "canvas");
    j.q(paramPaint, "paint");
    if (bo.aa(this.text))
    {
      AppMethodBeat.o(3138);
      return;
    }
    a locala = (a)this.lAw.get(this.lAv);
    if (locala == null)
    {
      this.lAx.a(paramCanvas, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint, paramBoolean);
      AppMethodBeat.o(3138);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    int i = -1;
    if (paramInt1 < paramInt2)
    {
      if (locala.lAz.get(paramInt1) != null)
      {
        paramCanvas.drawPath((Path)locala.lAz.get(paramInt1), paramPaint);
        paramFloat1 = paramPaint.measureText(this.text, paramInt1, paramInt1 + 1);
      }
      for (;;)
      {
        paramCanvas.translate(paramFloat1, 0.0F);
        int j = i;
        CharSequence localCharSequence;
        label216:
        do
        {
          for (;;)
          {
            paramInt1 += 1;
            i = j;
            break;
            localCharSequence = this.text;
            if (localCharSequence == null) {
              j.ebi();
            }
            if ((!a.l.a.isSurrogate(localCharSequence.charAt(paramInt1))) || (i != -1)) {
              break label216;
            }
            j = paramInt1;
          }
          if (i == -1) {
            break label331;
          }
          localCharSequence = this.text;
          if (localCharSequence == null) {
            j.ebi();
          }
          if (paramInt1 >= localCharSequence.length() - 1) {
            break label283;
          }
          localCharSequence = this.text;
          if (localCharSequence == null) {
            j.ebi();
          }
          j = i;
        } while (a.l.a.isSurrogate(localCharSequence.charAt(paramInt1 + 1)));
        label283:
        paramCanvas.save();
        paramCanvas.drawText(this.text, i, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramCanvas.restore();
        paramFloat1 = paramPaint.measureText(this.text, i, paramInt1 + 1);
        i = -1;
        continue;
        label331:
        paramCanvas.drawText(this.text, paramInt1, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramFloat1 = paramPaint.measureText(this.text, paramInt1, paramInt1 + 1);
      }
    }
    if (paramBoolean) {
      paramCanvas.drawText(c.a.bph(), 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
    AppMethodBeat.o(3138);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(3136);
    Iterator localIterator = this.lAw.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      CharSequence localCharSequence = this.text;
      locala.lAz.clear();
      locala.lAA.clear();
      if (localCharSequence != null)
      {
        int i = 0;
        label74:
        if (i < localCharSequence.length())
        {
          char c = localCharSequence.charAt(i);
          Path localPath = new Path();
          RectF localRectF = new RectF();
          if (!locala.lAy.a(c, localPath, localRectF)) {
            break label161;
          }
          locala.lAz.add(localPath);
          locala.lAA.add(localRectF);
        }
        for (;;)
        {
          i += 1;
          break label74;
          break;
          label161:
          locala.lAz.add(null);
          locala.lAA.add(null);
        }
      }
    }
    AppMethodBeat.o(3136);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(3135);
    j.q(paramCharSequence, "text");
    this.text = paramCharSequence;
    this.lAx.setText(paramCharSequence);
    AppMethodBeat.o(3135);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "", "fontPath", "", "textSize", "", "(Ljava/lang/String;I)V", "boxList", "", "Landroid/graphics/RectF;", "getBoxList", "()Ljava/util/List;", "metrics", "Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "getMetrics", "()Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "pathExtractor", "Lcom/tencent/mm/fontdecode/PathExtractor;", "pathList", "Landroid/graphics/Path;", "getPathList", "isValid", "", "refresh", "", "text", "", "plugin-emojicapture_release"})
  public static final class a
  {
    final List<RectF> lAA;
    private final PathExtractor.Metrics lAB;
    final PathExtractor lAy;
    final List<Path> lAz;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(3134);
      this.lAy = new PathExtractor(paramString);
      this.lAB = new PathExtractor.Metrics();
      this.lAy.setTextSize(paramInt);
      this.lAz = ((List)new ArrayList());
      this.lAA = ((List)new ArrayList());
      this.lAy.a(this.lAB);
      AppMethodBeat.o(3134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.a.b
 * JD-Core Version:    0.7.0.1
 */