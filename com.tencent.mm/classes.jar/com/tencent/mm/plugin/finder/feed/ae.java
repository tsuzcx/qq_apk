package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.cc;
import com.tencent.mm.plugin.finder.convert.cd;
import com.tencent.mm.plugin.finder.convert.ce;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.model.bj;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract;", "", "()V", "IS_MOCK_DATA", "", "SelectPresenter", "SelectViewCallback", "plugin-finder_release"})
public final class ae
{
  public static final ae tQk;
  
  static
  {
    AppMethodBeat.i(244153);
    tQk = new ae();
    AppMethodBeat.o(244153);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b$c
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(244139);
      e locale;
      if (paramInt == bi.class.getName().hashCode())
      {
        locale = (e)new cc();
        AppMethodBeat.o(244139);
        return locale;
      }
      if (paramInt == bj.class.getName().hashCode())
      {
        locale = (e)new ce();
        AppMethodBeat.o(244139);
        return locale;
      }
      if (paramInt == com.tencent.mm.plugin.finder.model.l.class.getName().hashCode())
      {
        locale = (e)new cd();
        AppMethodBeat.o(244139);
        return locale;
      }
      p.hyc();
      AppMethodBeat.o(244139);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae
 * JD-Core Version:    0.7.0.1
 */