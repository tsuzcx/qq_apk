package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.storage.au;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelappbrand/AppBrandChatTypeLogic;", "", "()V", "isValid", "", "chatType", "", "parse", "talkerUserName", "", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a opM;
  
  static
  {
    AppMethodBeat.i(233811);
    opM = new a();
    AppMethodBeat.o(233811);
  }
  
  public static final int KG(String paramString)
  {
    AppMethodBeat.i(233808);
    int i = 1;
    if (au.bwO(paramString)) {
      i = 2;
    }
    for (;;)
    {
      if (ab.IG(paramString)) {
        i = 4;
      }
      AppMethodBeat.o(233808);
      return i;
      if (au.bwG(paramString)) {
        i = 3;
      }
    }
  }
  
  public static boolean uB(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (paramInt <= 4) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a
 * JD-Core Version:    0.7.0.1
 */