package com.tencent.mm.plugin.findersdk.storage.config.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "defValue", "_title", "", "_keyName", "(ZLjava/lang/String;Ljava/lang/String;)V", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<Boolean>
{
  public a(boolean paramBoolean, String paramString1, String paramString2)
  {
    super(Boolean.valueOf(paramBoolean), paramString1);
    AppMethodBeat.i(273828);
    c(paramString2, (List)new ArrayList((Collection)p.listOf(new Boolean[] { Boolean.FALSE, Boolean.TRUE })), (List)new ArrayList((Collection)p.listOf(new String[] { "false", "true" })));
    AppMethodBeat.o(273828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.a.a.a
 * JD-Core Version:    0.7.0.1
 */