package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axl;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  final a[] FNq;
  
  public q(a[] paramArrayOfa)
  {
    AppMethodBeat.i(339303);
    this.FNq = paramArrayOfa;
    AppMethodBeat.o(339303);
  }
  
  public final a Tx(int paramInt)
  {
    AppMethodBeat.i(339315);
    a[] arrayOfa = this.FNq;
    int k = arrayOfa.length;
    int i = 0;
    a locala;
    int j;
    if (i < k)
    {
      locala = arrayOfa[i];
      if (locala.type == paramInt)
      {
        j = 1;
        label41:
        if (j == 0) {
          break label85;
        }
      }
    }
    for (;;)
    {
      if (locala != null) {
        break label98;
      }
      locala = new a(10000, "default_v3", new axl(), (byte)0);
      AppMethodBeat.o(339315);
      return locala;
      j = 0;
      break label41;
      label85:
      i += 1;
      break;
      locala = null;
    }
    label98:
    AppMethodBeat.o(339315);
    return locala;
  }
  
  public final void a(int paramInt, a parama)
  {
    AppMethodBeat.i(339320);
    s.u(parama, "page");
    a[] arrayOfa = this.FNq;
    int k = arrayOfa.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramInt == arrayOfa[j].type) {
        this.FNq[i] = parama;
      }
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(339320);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(339327);
    a[] arrayOfa = this.FNq;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.rNn = false;
      locala.a(new axl());
      i += 1;
    }
    AppMethodBeat.o(339327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.q
 * JD-Core Version:    0.7.0.1
 */