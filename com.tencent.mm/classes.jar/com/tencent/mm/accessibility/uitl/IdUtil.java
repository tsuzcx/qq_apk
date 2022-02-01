package com.tencent.mm.accessibility.uitl;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.type.IdType;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/uitl/IdUtil;", "", "()V", "ID_MASK", "", "LAYOUT_ID_MASK", "STRING_MASK", "nameCache", "", "", "getName", "id", "getType", "Lcom/tencent/mm/accessibility/type/IdType;", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class IdUtil
{
  private static final int ID_MASK = 2131296256;
  public static final IdUtil INSTANCE;
  private static final int LAYOUT_ID_MASK = 2131492864;
  private static final int STRING_MASK = 2131755008;
  private static final Map<Integer, String> nameCache;
  
  static
  {
    AppMethodBeat.i(234117);
    INSTANCE = new IdUtil();
    nameCache = (Map)new LinkedHashMap();
    AppMethodBeat.o(234117);
  }
  
  public final String getName(int paramInt)
  {
    AppMethodBeat.i(234126);
    try
    {
      Map localMap = nameCache;
      Integer localInteger = Integer.valueOf(paramInt);
      Object localObject3 = localMap.get(localInteger);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = MMApplicationContext.getContext().getResources().getResourceName(paramInt);
        s.s(localObject1, "getContext().resources.getResourceName(id)");
        localMap.put(localInteger, localObject1);
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(234126);
      return localObject1;
    }
    finally
    {
      nameCache.put(Integer.valueOf(paramInt), "unknow Resource");
      AppMethodBeat.o(234126);
    }
    return "unknow Resource";
  }
  
  public final IdType getType(int paramInt)
  {
    if ((paramInt & 0x7F0C0000) == 2131492864) {
      return IdType.Layout;
    }
    if ((paramInt & 0x7F090000) == 2131296256) {
      return IdType.Id;
    }
    if ((paramInt & 0x7F100000) == 2131755008) {
      return IdType.String;
    }
    return IdType.Unknow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.uitl.IdUtil
 * JD-Core Version:    0.7.0.1
 */