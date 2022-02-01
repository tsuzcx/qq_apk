package com.tencent.mm.plugin.finder.storage.config.item.booleantype;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.b;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "defValue", "_title", "", "_keyName", "(ZLjava/lang/String;Ljava/lang/String;)V", "plugin-finder_release"})
public final class a
  extends b<Boolean>
{
  public a(boolean paramBoolean, String paramString1, String paramString2)
  {
    super(Boolean.valueOf(paramBoolean), paramString1);
    AppMethodBeat.i(203776);
    b(paramString2, (List)new ArrayList((Collection)j.listOf(new Boolean[] { Boolean.FALSE, Boolean.TRUE })), (List)new ArrayList((Collection)j.listOf(new String[] { "false", "true" })));
    AppMethodBeat.o(203776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.booleantype.a
 * JD-Core Version:    0.7.0.1
 */