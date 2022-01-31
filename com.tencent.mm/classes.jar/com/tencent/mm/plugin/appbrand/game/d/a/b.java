package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Map;

final class b
  extends l
{
  static final int CTRL_INDEX = -2;
  static final String NAME = "onKeyboardConfirm";
  
  final void a(String paramString, o paramo)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", paramString);
    o(localHashMap).d(paramo).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a.b
 * JD-Core Version:    0.7.0.1
 */