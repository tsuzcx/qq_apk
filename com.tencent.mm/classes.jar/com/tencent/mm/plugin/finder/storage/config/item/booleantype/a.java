package com.tencent.mm.plugin.finder.storage.config.item.booleantype;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "defValue", "_title", "", "_keyName", "(ZLjava/lang/String;Ljava/lang/String;)V", "plugin-finder_release"})
public final class a
  extends b<Boolean>
{
  public a(boolean paramBoolean, String paramString1, String paramString2)
  {
    super(Boolean.valueOf(paramBoolean), paramString1);
    AppMethodBeat.i(251941);
    b(paramString2, (List)new ArrayList((Collection)j.listOf(new Boolean[] { Boolean.FALSE, Boolean.TRUE })), (List)new ArrayList((Collection)j.listOf(new String[] { "false", "true" })));
    AppMethodBeat.o(251941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.booleantype.a
 * JD-Core Version:    0.7.0.1
 */