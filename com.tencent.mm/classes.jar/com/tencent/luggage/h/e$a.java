package com.tencent.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.skyline.jni.ISkylineLibraryLoader;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/luggage/skyline/SkylineLogic$initLoader$1", "Lcom/tencent/skyline/jni/ISkylineLibraryLoader;", "afterLoad", "", "beforeLoad", "load", "libName", "", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$a
  implements ISkylineLibraryLoader
{
  public final boolean afterLoad()
  {
    return false;
  }
  
  public final boolean beforeLoad()
  {
    return false;
  }
  
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(219990);
    Log.i("SkylineLogic", s.X("load libName:", paramString));
    if (paramString == null)
    {
      AppMethodBeat.o(219990);
      return false;
    }
    try
    {
      k.load(paramString);
      AppMethodBeat.o(219990);
      return true;
    }
    catch (Error localError)
    {
      for (;;)
      {
        Log.e("SkylineLogic", "load fail: " + paramString + ", e: " + localError);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.e.a
 * JD-Core Version:    0.7.0.1
 */