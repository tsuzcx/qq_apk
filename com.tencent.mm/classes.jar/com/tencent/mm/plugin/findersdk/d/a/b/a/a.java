package com.tencent.mm.plugin.findersdk.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "defValue", "_title", "", "_keyName", "(ZLjava/lang/String;Ljava/lang/String;)V", "finder-sdk_release"})
public final class a
  extends b<Boolean>
{
  public a(boolean paramBoolean, String paramString1, String paramString2)
  {
    super(Boolean.valueOf(paramBoolean), paramString1);
    AppMethodBeat.i(209606);
    b(paramString2, (List)new ArrayList((Collection)j.listOf(new Boolean[] { Boolean.FALSE, Boolean.TRUE })), (List)new ArrayList((Collection)j.listOf(new String[] { "false", "true" })));
    AppMethodBeat.o(209606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */