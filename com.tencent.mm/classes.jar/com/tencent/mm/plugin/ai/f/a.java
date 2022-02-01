package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static String TAG = "MicroMsg.AiMMKV";
  private String name = null;
  
  private String info()
  {
    AppMethodBeat.i(239779);
    String str = hashCode();
    AppMethodBeat.o(239779);
    return str;
  }
  
  public final MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(239776);
    d.dgX();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(239776);
      return null;
    }
    Object localObject = i + "_WxExptAiMMKV";
    if (!Util.isEqual(this.name, (String)localObject))
    {
      Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.name);
    AppMethodBeat.o(239776);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.a
 * JD-Core Version:    0.7.0.1
 */