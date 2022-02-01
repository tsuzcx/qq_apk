package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class j$u
{
  private Boolean ahiw;
  private j.j ahix;
  private String hWq;
  private String path;
  
  static u dl(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229262);
    u localu = new u();
    localu.path = ((String)paramMap.get("path"));
    localu.ahiw = ((Boolean)paramMap.get("isVideo"));
    localu.hWq = ((String)paramMap.get("thumb"));
    localu.ahix = j.j.dk((Map)paramMap.get("finderItem"));
    AppMethodBeat.o(229262);
    return localu;
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229266);
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", this.path);
    localHashMap.put("isVideo", this.ahiw);
    localHashMap.put("thumb", this.hWq);
    if (this.ahix == null) {}
    for (Object localObject = null;; localObject = this.ahix.jRw())
    {
      localHashMap.put("finderItem", localObject);
      AppMethodBeat.o(229266);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.j.u
 * JD-Core Version:    0.7.0.1
 */