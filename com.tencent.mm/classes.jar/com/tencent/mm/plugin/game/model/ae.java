package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.cr;
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae
  extends y
{
  public static void a(bb parambb)
  {
    if ((parambb == null) || (bk.dk(parambb.kUA))) {}
    for (;;)
    {
      return;
      parambb = parambb.kUA.iterator();
      while (parambb.hasNext())
      {
        Object localObject = (ac)parambb.next();
        if ((((ac)localObject).kTm != null) && (((ac)localObject).kTm.kRQ != null))
        {
          d.a(a(((ac)localObject).kTm.kRQ));
        }
        else if ((((ac)localObject).kTo != null) && (!bk.dk(((ac)localObject).kTo.kSr)))
        {
          localObject = ((ac)localObject).kTo.kSr.iterator();
          while (((Iterator)localObject).hasNext()) {
            d.a(a(((x)((Iterator)localObject).next()).kRQ));
          }
        }
        else if ((((ac)localObject).kTn != null) && (((ac)localObject).kTn.kRQ != null))
        {
          d.a(a(((ac)localObject).kTn.kRQ));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ae
 * JD-Core Version:    0.7.0.1
 */