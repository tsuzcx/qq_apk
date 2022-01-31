package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class n$c
{
  public LinkedList<n.b> fGo;
  public LinkedList<n.b> fGp;
  
  public n$c()
  {
    AppMethodBeat.i(78361);
    this.fGo = new LinkedList();
    this.fGp = new LinkedList();
    AppMethodBeat.o(78361);
  }
  
  private void ahx()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(78367);
        StringBuilder localStringBuilder = new StringBuilder();
        i = 0;
        if (i < this.fGo.size())
        {
          localStringBuilder.append(((n.b)this.fGo.get(i)).fGn);
          if (i != this.fGo.size() - 1) {
            localStringBuilder.append("-");
          }
        }
        else
        {
          ab.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
          com.tencent.mm.kernel.g.RL().Ru().set(348176, localStringBuilder.toString());
          AppMethodBeat.o(78367);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  private void ahy()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(78368);
        StringBuilder localStringBuilder = new StringBuilder();
        i = 0;
        if (i < this.fGp.size())
        {
          localStringBuilder.append(((n.b)this.fGp.get(i)).fGn);
          if (i != this.fGp.size() - 1) {
            localStringBuilder.append("-");
          }
        }
        else
        {
          ab.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
          com.tencent.mm.kernel.g.RL().Ru().set(348177, localStringBuilder.toString());
          AppMethodBeat.o(78368);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static n.b to(String paramString)
  {
    AppMethodBeat.i(78363);
    n.b localb = new n.b((byte)0);
    if (bo.isNullOrNil(paramString)) {}
    for (localb.fGn = g.ahn();; localb.fGn = paramString)
    {
      paramString = o.ahC().th(localb.fGn);
      if (tq(paramString)) {
        break;
      }
      AppMethodBeat.o(78363);
      return null;
    }
    localb.fGm = new b(paramString);
    AppMethodBeat.o(78363);
    return localb;
  }
  
  public static n.b tp(String paramString)
  {
    AppMethodBeat.i(78364);
    n.b localb = new n.b((byte)0);
    if (bo.isNullOrNil(paramString)) {}
    for (localb.fGn = g.ahn();; localb.fGn = paramString)
    {
      paramString = o.ahC().tg(localb.fGn);
      if (tq(paramString)) {
        break;
      }
      AppMethodBeat.o(78364);
      return null;
    }
    localb.fGm = new b(paramString);
    AppMethodBeat.o(78364);
    return localb;
  }
  
  private static boolean tq(String paramString)
  {
    AppMethodBeat.i(78365);
    if (com.tencent.mm.vfs.e.avI(paramString) > 0L)
    {
      ab.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
      AppMethodBeat.o(78365);
      return false;
    }
    AppMethodBeat.o(78365);
    return true;
  }
  
  public final void ahw()
  {
    int j = 0;
    try
    {
      AppMethodBeat.i(78362);
      int i = this.fGo.size();
      int k;
      n.b localb;
      if (i <= 0)
      {
        k = 5 - i;
        i = 0;
        while (i < k)
        {
          localb = to(null);
          this.fGo.add(localb);
          i += 1;
        }
        ab.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.fGo.size()) });
        ahx();
      }
      i = this.fGp.size();
      if (i <= 0)
      {
        k = 5 - i;
        i = j;
        while (i < k)
        {
          localb = tp(null);
          this.fGp.add(localb);
          i += 1;
        }
        ahy();
        ab.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.fGp.size()) });
      }
      AppMethodBeat.o(78362);
      return;
    }
    finally {}
  }
  
  public final n.b lC(int paramInt)
  {
    n.b localb1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(78366);
        if (paramInt == 1)
        {
          if (this.fGo.size() > 0)
          {
            localb1 = (n.b)this.fGo.remove();
            ahx();
            ahw();
            AppMethodBeat.o(78366);
            return localb1;
          }
          localb1 = to(null);
          continue;
        }
        if (paramInt == 2) {
          if (this.fGp.size() > 0)
          {
            localb1 = (n.b)this.fGp.remove();
            ahy();
          }
          else
          {
            n.b localb2 = tp(null);
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.n.c
 * JD-Core Version:    0.7.0.1
 */