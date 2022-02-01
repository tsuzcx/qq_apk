package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.fontdecode.PathExtractor;
import com.tencent.mm.fontdecode.PathExtractor.Metrics;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "fontPaths", "", "", "textSize", "", "([Ljava/lang/String;I)V", "currFont", "dataMap", "", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "defaultDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontPath", "TextPathData", "plugin-emojicapture_release"})
public final class b
  implements c
{
  private String qeJ;
  private Map<String, a> qeK;
  private final a qeL;
  private CharSequence text;
  
  public b(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(826);
    this.qeJ = "";
    this.qeK = ((Map)new HashMap());
    this.qeL = new a();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      a locala = new a(str, paramInt);
      if (locala.qeM.isValid()) {
        this.qeK.put(str, locala);
      }
      i += 1;
    }
    AppMethodBeat.o(826);
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    AppMethodBeat.i(825);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (bu.ah(this.text))
    {
      AppMethodBeat.o(825);
      return;
    }
    a locala = (a)this.qeK.get(this.qeJ);
    if (locala == null)
    {
      this.qeL.a(paramCanvas, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint, paramBoolean);
      AppMethodBeat.o(825);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    int i = -1;
    if (paramInt1 < paramInt2)
    {
      if (locala.qeN.get(paramInt1) != null)
      {
        paramCanvas.drawPath((Path)locala.qeN.get(paramInt1), paramPaint);
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
              p.gkB();
            }
            if ((!d.n.a.isSurrogate(localCharSequence.charAt(paramInt1))) || (i != -1)) {
              break label216;
            }
            j = paramInt1;
          }
          if (i == -1) {
            break label331;
          }
          localCharSequence = this.text;
          if (localCharSequence == null) {
            p.gkB();
          }
          if (paramInt1 >= localCharSequence.length() - 1) {
            break label283;
          }
          localCharSequence = this.text;
          if (localCharSequence == null) {
            p.gkB();
          }
          j = i;
        } while (d.n.a.isSurrogate(localCharSequence.charAt(paramInt1 + 1)));
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
      paramCanvas.drawText(c.a.clQ(), 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
    AppMethodBeat.o(825);
  }
  
  public final void adi(String paramString)
  {
    AppMethodBeat.i(824);
    p.h(paramString, "fontPath");
    this.qeJ = paramString;
    AppMethodBeat.o(824);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(823);
    Iterator localIterator = this.qeK.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      CharSequence localCharSequence = this.text;
      locala.qeN.clear();
      locala.qeO.clear();
      if (localCharSequence != null)
      {
        int i = 0;
        label74:
        if (i < localCharSequence.length())
        {
          char c = localCharSequence.charAt(i);
          Path localPath = new Path();
          RectF localRectF = new RectF();
          if (!locala.qeM.a(c, localPath, localRectF)) {
            break label161;
          }
          locala.qeN.add(localPath);
          locala.qeO.add(localRectF);
        }
        for (;;)
        {
          i += 1;
          break label74;
          break;
          label161:
          locala.qeN.add(null);
          locala.qeO.add(null);
        }
      }
    }
    AppMethodBeat.o(823);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(822);
    p.h(paramCharSequence, "text");
    this.text = paramCharSequence;
    this.qeL.setText(paramCharSequence);
    AppMethodBeat.o(822);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "", "fontPath", "", "textSize", "", "(Ljava/lang/String;I)V", "boxList", "", "Landroid/graphics/RectF;", "getBoxList", "()Ljava/util/List;", "metrics", "Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "getMetrics", "()Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "pathExtractor", "Lcom/tencent/mm/fontdecode/PathExtractor;", "pathList", "Landroid/graphics/Path;", "getPathList", "isValid", "", "refresh", "", "text", "", "plugin-emojicapture_release"})
  public static final class a
  {
    final PathExtractor qeM;
    final List<Path> qeN;
    final List<RectF> qeO;
    private final PathExtractor.Metrics qeP;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(821);
      this.qeM = new PathExtractor(paramString);
      this.qeP = new PathExtractor.Metrics();
      this.qeM.setTextSize(paramInt);
      this.qeN = ((List)new ArrayList());
      this.qeO = ((List)new ArrayList());
      this.qeM.a(this.qeP);
      AppMethodBeat.o(821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.b
 * JD-Core Version:    0.7.0.1
 */