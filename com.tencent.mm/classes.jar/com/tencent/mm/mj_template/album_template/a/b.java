package com.tencent.mm.mj_template.album_template.a;

import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"rememberLoaderPainter", "Lcom/tencent/mm/mj_template/album_template/widget/ImageLoaderPainter;", "url", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Lcom/tencent/mm/mj_template/album_template/widget/ImageLoaderPainter;", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a a(String paramString, h paramh)
  {
    AppMethodBeat.i(240585);
    s.u(paramString, "url");
    paramh.bx(-1817901268);
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramString);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!bool)
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new a(paramString);
      paramh.F(localObject1);
    }
    paramh.od();
    paramString = (a)localObject1;
    paramh.od();
    AppMethodBeat.o(240585);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.b
 * JD-Core Version:    0.7.0.1
 */