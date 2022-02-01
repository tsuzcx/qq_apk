package com.tencent.mm.mj_template.album_template.multi_template;

import androidx.compose.a.j;
import androidx.compose.foundation.lazy.ab;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.album_template.a.g;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"ExpandMusic", "", "musicState", "Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "expandMusicCardState", "Landroidx/compose/runtime/MutableState;", "", "(Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "Header", "onNextClick", "Lkotlin/Function0;", "Lcom/tencent/mm/mj_template/album_template/multi_template/OnClick;", "onBackClick", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MultiTemplatePreviewPage", "templateState", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/Composer;I)V", "FoldMusic", "Landroidx/compose/foundation/layout/BoxScope;", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "OnClick", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final void a(final a<ah> parama1, final a<ah> parama2, final com.tencent.mm.mj_template.album_template.multi_template.a.d paramd, final g paramg, final androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240728);
    s.u(parama1, "onNextClick");
    s.u(parama2, "onBackClick");
    s.u(paramd, "templateState");
    s.u(paramg, "musicState");
    androidx.compose.runtime.h localh = paramh.by(2003825167);
    localh.bx(-3687241);
    Object localObject = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = (androidx.compose.runtime.h)localObject;
    if (localObject == h.a.ox())
    {
      paramh = bj.T(Boolean.FALSE);
      localh.F(paramh);
    }
    localh.od();
    paramh = (an)paramh;
    localObject = ab.f(localh);
    if (!((Boolean)paramh.getValue()).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      androidx.compose.a.b.a(bool, null, j.lr(), j.ls(), (q)androidx.compose.runtime.c.c.a(localh, -819896234, new f(paramd, (androidx.compose.foundation.lazy.aa)localObject, parama1, parama2, paramInt, paramg, paramh)), localh, 28032, 2);
      androidx.compose.a.b.a(((Boolean)paramh.getValue()).booleanValue(), null, j.a((kotlin.g.a.b)b.g.nXa, (androidx.compose.a.a.aa)androidx.compose.a.a.h.a(300, null, 6)), j.b((kotlin.g.a.b)b.h.nXb, (androidx.compose.a.a.aa)androidx.compose.a.a.h.a(300, null, 6)), (q)androidx.compose.runtime.c.c.a(localh, -819893248, new i(paramg, paramh, paramInt)), localh, 24576, 2);
      paramh = localh.oh();
      if (paramh != null) {
        paramh.b((m)new j(parama1, parama2, paramd, paramg, paramInt));
      }
      AppMethodBeat.o(240728);
      return;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(an<Boolean> paraman)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    b(g paramg, an<Boolean> paraman, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements q<Boolean, androidx.compose.runtime.h, Integer, ah>
  {
    c(g paramg, an<Boolean> paraman, int paramInt)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(an<Boolean> paraman)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    d(androidx.compose.foundation.c.d paramd, com.tencent.mm.mj_template.album_template.multi_template.a.d paramd1, g paramg, an<Boolean> paraman, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    e(a<ah> parama1, a<ah> parama2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements q<androidx.compose.a.c, androidx.compose.runtime.h, Integer, ah>
  {
    f(com.tencent.mm.mj_template.album_template.multi_template.a.d paramd, androidx.compose.foundation.lazy.aa paramaa, a<ah> parama1, a<ah> parama2, int paramInt, g paramg, an<Boolean> paraman)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements q<androidx.compose.a.c, androidx.compose.runtime.h, Integer, ah>
  {
    i(g paramg, an<Boolean> paraman, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    j(a<ah> parama1, a<ah> parama2, com.tencent.mm.mj_template.album_template.multi_template.a.d paramd, g paramg, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.multi_template.b
 * JD-Core Version:    0.7.0.1
 */