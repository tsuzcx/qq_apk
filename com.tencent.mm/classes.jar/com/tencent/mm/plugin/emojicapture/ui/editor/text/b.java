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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "fontPaths", "", "", "textSize", "", "([Ljava/lang/String;I)V", "currFont", "dataMap", "", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "defaultDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontPath", "TextPathData", "plugin-emojicapture_release"})
public final class b
  implements c
{
  private String rvH;
  private Map<String, a> rvI;
  private final a rvJ;
  private CharSequence text;
  
  public b(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(826);
    this.rvH = "";
    this.rvI = ((Map)new HashMap());
    this.rvJ = new a();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      a locala = new a(str, paramInt);
      if (locala.rvK.isValid()) {
        this.rvI.put(str, locala);
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
    if (Util.isNullOrNil(this.text))
    {
      AppMethodBeat.o(825);
      return;
    }
    a locala = (a)this.rvI.get(this.rvH);
    if (locala == null)
    {
      this.rvJ.a(paramCanvas, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint, paramBoolean);
      AppMethodBeat.o(825);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    int i = -1;
    if (paramInt1 < paramInt2)
    {
      Object localObject;
      if (locala.rvL.get(paramInt1) != null)
      {
        localObject = locala.rvL.get(paramInt1);
        if (localObject == null) {
          p.hyc();
        }
        paramCanvas.drawPath((Path)localObject, paramPaint);
        paramFloat1 = paramPaint.measureText(this.text, paramInt1, paramInt1 + 1);
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
            localObject = this.text;
            if (localObject == null) {
              p.hyc();
            }
            if ((!kotlin.n.a.isSurrogate(((CharSequence)localObject).charAt(paramInt1))) || (i != -1)) {
              break label228;
            }
            j = paramInt1;
          }
          if (i == -1) {
            break label355;
          }
          localObject = this.text;
          if (localObject == null) {
            p.hyc();
          }
          if (paramInt1 >= ((CharSequence)localObject).length() - 1) {
            break label295;
          }
          localObject = this.text;
          if (localObject == null) {
            p.hyc();
          }
          j = i;
        } while (kotlin.n.a.isSurrogate(((CharSequence)localObject).charAt(paramInt1 + 1)));
        label295:
        paramCanvas.save();
        localObject = this.text;
        if (localObject == null) {
          p.hyc();
        }
        paramCanvas.drawText((CharSequence)localObject, i, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramCanvas.restore();
        paramFloat1 = paramPaint.measureText(this.text, i, paramInt1 + 1);
        i = -1;
        continue;
        label355:
        localObject = this.text;
        if (localObject == null) {
          p.hyc();
        }
        paramCanvas.drawText((CharSequence)localObject, paramInt1, paramInt1 + 1, 0.0F, 0.0F, paramPaint);
        paramFloat1 = paramPaint.measureText(this.text, paramInt1, paramInt1 + 1);
      }
    }
    if (paramBoolean) {
      paramCanvas.drawText(c.a.cJS(), 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
    AppMethodBeat.o(825);
  }
  
  public final void anr(String paramString)
  {
    AppMethodBeat.i(824);
    p.h(paramString, "fontPath");
    this.rvH = paramString;
    AppMethodBeat.o(824);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(823);
    Iterator localIterator = this.rvI.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      CharSequence localCharSequence = this.text;
      locala.rvL.clear();
      locala.rvM.clear();
      if (localCharSequence != null)
      {
        int i = 0;
        label74:
        if (i < localCharSequence.length())
        {
          char c = localCharSequence.charAt(i);
          Path localPath = new Path();
          RectF localRectF = new RectF();
          if (!locala.rvK.a(c, localPath, localRectF)) {
            break label161;
          }
          locala.rvL.add(localPath);
          locala.rvM.add(localRectF);
        }
        for (;;)
        {
          i += 1;
          break label74;
          break;
          label161:
          locala.rvL.add(null);
          locala.rvM.add(null);
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
    this.rvJ.setText(paramCharSequence);
    AppMethodBeat.o(822);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "", "fontPath", "", "textSize", "", "(Ljava/lang/String;I)V", "boxList", "", "Landroid/graphics/RectF;", "getBoxList", "()Ljava/util/List;", "metrics", "Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "getMetrics", "()Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "pathExtractor", "Lcom/tencent/mm/fontdecode/PathExtractor;", "pathList", "Landroid/graphics/Path;", "getPathList", "isValid", "", "refresh", "", "text", "", "plugin-emojicapture_release"})
  public static final class a
  {
    final PathExtractor rvK;
    final List<Path> rvL;
    final List<RectF> rvM;
    private final PathExtractor.Metrics rvN;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(821);
      this.rvK = new PathExtractor(paramString);
      this.rvN = new PathExtractor.Metrics();
      this.rvK.setTextSize(paramInt);
      this.rvL = ((List)new ArrayList());
      this.rvM = ((List)new ArrayList());
      this.rvK.a(this.rvN);
      AppMethodBeat.o(821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.b
 * JD-Core Version:    0.7.0.1
 */