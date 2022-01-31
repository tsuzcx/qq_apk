package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.mm.modelsimple.q.a;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static q.a a(com.tencent.mm.modelsimple.q paramq)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("kscene_type", 73);
    return a(paramq, localBundle);
  }
  
  private static q.a a(com.tencent.mm.modelsimple.q paramq, Bundle paramBundle)
  {
    if (paramq == null) {
      return null;
    }
    if (((i.e)paramq.edR.HF()).spz.tPv == null) {
      return null;
    }
    Object localObject = ((i.e)paramq.edR.HF()).spz.tPv.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      q.a locala = new q.a();
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 19) {
          locala.bJY = localbwb.tMN;
        } else if (localbwb.nFi == 20) {
          locala.ezP = localbwb.tMN;
        } else if (localbwb.nFi == 21) {
          locala.bQZ = localbwb.tMN;
        }
      }
      locala.ezQ = paramBundle;
      locala.type = 0;
      if (!bk.bl(locala.bJY))
      {
        locala.username = ((i.d)paramq.edR.Kv()).spw.trj.hPY;
        return locala;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */