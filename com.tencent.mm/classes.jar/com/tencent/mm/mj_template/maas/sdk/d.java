package com.tencent.mm.mj_template.maas.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResConfigChain;", "", "()V", "compatVersion", "", "getCompatVersion", "()I", "configList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResConfig;", "getConfigList", "()Ljava/util/LinkedList;", "isCompatible", "", "()Z", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final int Ue = 8;
  final LinkedList<c> obH;
  
  public d()
  {
    AppMethodBeat.i(240065);
    this.obH = new LinkedList();
    AppMethodBeat.o(240065);
  }
  
  public final boolean axM()
  {
    AppMethodBeat.i(240086);
    if (bxM() == 10100003)
    {
      AppMethodBeat.o(240086);
      return true;
    }
    AppMethodBeat.o(240086);
    return false;
  }
  
  public final int bxM()
  {
    AppMethodBeat.i(240080);
    Iterator localIterator = ((Iterable)this.obH).iterator();
    Object localObject1;
    if (!localIterator.hasNext()) {
      localObject1 = null;
    }
    do
    {
      localObject1 = (c)localObject1;
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(240080);
      return 0;
      localObject1 = localIterator.next();
    } while (!localIterator.hasNext());
    int i = ((c)localObject1).obC;
    label76:
    Object localObject2 = localIterator.next();
    int j = ((c)localObject2).obC;
    if (i < j)
    {
      localObject1 = localObject2;
      i = j;
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        break;
        i = ((c)localObject1).obC;
        AppMethodBeat.o(240080);
        return i;
      }
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.sdk.d
 * JD-Core Version:    0.7.0.1
 */