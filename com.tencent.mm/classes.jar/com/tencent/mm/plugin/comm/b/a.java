package com.tencent.mm.plugin.comm.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/kvstat/JsonLinkedHashMap;", "K", "T", "Ljava/util/LinkedHashMap;", "delimiter", "", "(Ljava/lang/String;)V", "getDelimiter", "()Ljava/lang/String;", "toString", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<K, T>
  extends LinkedHashMap<K, T>
{
  private final String xeM;
  
  public a(String paramString)
  {
    AppMethodBeat.i(260525);
    this.xeM = paramString;
    AppMethodBeat.o(260525);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260534);
    if (size() == 0)
    {
      AppMethodBeat.o(260534);
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = ((Map)this).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((CharSequence)localObject).length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label136;
        }
        ((StringBuilder)localObject).append("\"" + localEntry.getKey() + "\":\"" + localEntry.getValue() + '"');
        break;
      }
      label136:
      ((StringBuilder)localObject).append(this.xeM + '"' + localEntry.getKey() + "\":\"" + localEntry.getValue() + '"');
    }
    localObject = "{" + localObject + '}';
    AppMethodBeat.o(260534);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b.a
 * JD-Core Version:    0.7.0.1
 */