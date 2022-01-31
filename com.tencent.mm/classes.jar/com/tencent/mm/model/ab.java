package com.tencent.mm.model;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class ab
{
  public static void He()
  {
    Object localObject = s.GZ().iterator();
    ad localad1;
    while (((Iterator)localObject).hasNext())
    {
      localad1 = (ad)((Iterator)localObject).next();
      if ((localad1 != null) && ((int)localad1.dBe != 0) && (localad1.field_showHead == 32))
      {
        localad1.fg(localad1.AE());
        y.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localad1.field_username);
        au.Hx();
        c.Fw().a(localad1.field_username, localad1);
      }
    }
    localObject = s.dVc;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localad1 = localObject[i];
      ad localad2 = c.Fw().abl(localad1);
      if ((localad2 != null) && (((int)localad2.dBe != 0) || (a.gR(localad2.field_type))))
      {
        localad2.AQ();
        c.Fw().a(localad1, localad2);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */