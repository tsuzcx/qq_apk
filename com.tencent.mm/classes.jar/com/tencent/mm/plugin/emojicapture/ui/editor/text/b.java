package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.fontdecode.PathExtractor;
import com.tencent.mm.fontdecode.PathExtractor.Metrics;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "fontPaths", "", "", "textSize", "", "([Ljava/lang/String;I)V", "currFont", "dataMap", "", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "defaultDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontPath", "TextPathData", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  private CharSequence bba;
  private String yng;
  private Map<String, a> ynh;
  private final a yni;
  
  public b(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(826);
    this.yng = "";
    this.ynh = ((Map)new HashMap());
    this.yni = new a();
    int k = paramArrayOfString.length;
    int i = 0;
    label131:
    for (;;)
    {
      if (i < k)
      {
        String str = paramArrayOfString[i];
        i += 1;
        a locala = new a(str, paramInt);
        if (locala.ynj.msD != 0L) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label131;
          }
          this.ynh.put(str, locala);
          break;
        }
      }
      AppMethodBeat.o(826);
      return;
    }
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    AppMethodBeat.i(825);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    if (Util.isNullOrNil(this.bba))
    {
      AppMethodBeat.o(825);
      return;
    }
    a locala = (a)this.ynh.get(this.yng);
    if (locala == null)
    {
      this.yni.a(paramCanvas, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint, paramBoolean);
      AppMethodBeat.o(825);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    int j = -1;
    int i;
    if (paramInt1 < paramInt2) {
      i = paramInt1;
    }
    for (paramInt1 = j;; paramInt1 = j)
    {
      int k = i + 1;
      Object localObject;
      if (locala.ynk.get(i) != null)
      {
        localObject = locala.ynk.get(i);
        s.checkNotNull(localObject);
        paramCanvas.drawPath((Path)localObject, paramPaint);
        paramFloat1 = paramPaint.measureText(this.bba, i, i + 1);
      }
      for (;;)
      {
        paramCanvas.translate(paramFloat1, 0.0F);
        j = paramInt1;
        do
        {
          for (;;)
          {
            if (k < paramInt2) {
              break label424;
            }
            if (paramBoolean) {
              paramCanvas.drawText(c.a.dET(), 0.0F, 0.0F, paramPaint);
            }
            paramCanvas.restore();
            AppMethodBeat.o(825);
            return;
            localObject = this.bba;
            s.checkNotNull(localObject);
            if ((!kotlin.n.a.J(((CharSequence)localObject).charAt(i))) || (paramInt1 != -1)) {
              break;
            }
            j = i;
          }
          if (paramInt1 == -1) {
            break label377;
          }
          localObject = this.bba;
          s.checkNotNull(localObject);
          if (i >= ((CharSequence)localObject).length() - 1) {
            break;
          }
          localObject = this.bba;
          s.checkNotNull(localObject);
          j = paramInt1;
        } while (kotlin.n.a.J(((CharSequence)localObject).charAt(i + 1)));
        paramCanvas.save();
        localObject = this.bba;
        s.checkNotNull(localObject);
        paramCanvas.drawText((CharSequence)localObject, paramInt1, i + 1, 0.0F, 0.0F, paramPaint);
        paramCanvas.restore();
        paramFloat1 = paramPaint.measureText(this.bba, paramInt1, i + 1);
        paramInt1 = -1;
        continue;
        label377:
        localObject = this.bba;
        s.checkNotNull(localObject);
        paramCanvas.drawText((CharSequence)localObject, i, i + 1, 0.0F, 0.0F, paramPaint);
        paramFloat1 = paramPaint.measureText(this.bba, i, i + 1);
      }
      label424:
      i = k;
    }
  }
  
  public final void apq(String paramString)
  {
    AppMethodBeat.i(824);
    s.u(paramString, "fontPath");
    this.yng = paramString;
    AppMethodBeat.o(824);
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(823);
    Iterator localIterator = this.ynh.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      CharSequence localCharSequence = this.bba;
      locala.ynk.clear();
      locala.ynl.clear();
      if (localCharSequence != null)
      {
        int i = 0;
        while (i < localCharSequence.length())
        {
          char c = localCharSequence.charAt(i);
          i += 1;
          Path localPath = new Path();
          RectF localRectF = new RectF();
          if (locala.ynj.a(c, localPath, localRectF))
          {
            locala.ynk.add(localPath);
            locala.ynl.add(localRectF);
          }
          else
          {
            locala.ynk.add(null);
            locala.ynl.add(null);
          }
        }
      }
    }
    AppMethodBeat.o(823);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(822);
    s.u(paramCharSequence, "text");
    this.bba = paramCharSequence;
    this.yni.setText(paramCharSequence);
    AppMethodBeat.o(822);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "", "fontPath", "", "textSize", "", "(Ljava/lang/String;I)V", "boxList", "", "Landroid/graphics/RectF;", "getBoxList", "()Ljava/util/List;", "metrics", "Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "getMetrics", "()Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "pathExtractor", "Lcom/tencent/mm/fontdecode/PathExtractor;", "pathList", "Landroid/graphics/Path;", "getPathList", "isValid", "", "refresh", "", "text", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final PathExtractor ynj;
    final List<Path> ynk;
    final List<RectF> ynl;
    private final PathExtractor.Metrics ynm;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(821);
      this.ynj = new PathExtractor(paramString);
      this.ynm = new PathExtractor.Metrics();
      paramString = this.ynj;
      Log.i("MicroMsg.PathExtractor", "set text size %d, %d", new Object[] { Long.valueOf(paramString.msD), Integer.valueOf(paramInt) });
      PathExtractor.nSetTextSize(paramString.msD, paramInt);
      this.ynk = ((List)new ArrayList());
      this.ynl = ((List)new ArrayList());
      paramString = this.ynj;
      PathExtractor.Metrics localMetrics = this.ynm;
      if (localMetrics == null)
      {
        Log.w("MicroMsg.PathExtractor", "metrics is null");
        AppMethodBeat.o(821);
        return;
      }
      PathExtractor.nGetMetrics(paramString.msD, localMetrics);
      localMetrics.height *= 0.015625F;
      localMetrics.ascender *= 0.015625F;
      localMetrics.descender *= 0.015625F;
      AppMethodBeat.o(821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.b
 * JD-Core Version:    0.7.0.1
 */