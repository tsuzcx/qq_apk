package com.tencent.mm.plugin.ai.b.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abs;
import com.tencent.mm.f.a.oi;
import com.tencent.mm.f.b.a.i;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;

public final class c
{
  private static c npa;
  public IListener<abs> noW;
  long npb;
  public boolean npc;
  long npd;
  public IListener<oi> npe;
  
  public c()
  {
    AppMethodBeat.i(239330);
    this.npb = 0L;
    this.npc = false;
    this.npd = 0L;
    this.npe = new c.1(this);
    this.noW = new IListener() {};
    AppMethodBeat.o(239330);
  }
  
  public static c bBc()
  {
    AppMethodBeat.i(239332);
    if (npa == null) {
      npa = new c();
    }
    c localc = npa;
    AppMethodBeat.o(239332);
    return localc;
  }
  
  public static ArrayList<i> bBd()
  {
    AppMethodBeat.i(239333);
    long l2 = Util.currentTicks();
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = null;
    Object localObject4 = null;
    for (;;)
    {
      int j;
      try
      {
        Cursor localCursor = ((n)h.ae(n.class)).bbR().nL(ab.lsA, a.jxD);
        if (localCursor != null)
        {
          int i = 0;
          localObject4 = localCursor;
          localObject5 = localCursor;
          if (localCursor.moveToNext())
          {
            localObject4 = localCursor;
            localObject5 = localCursor;
            i locali = new i();
            localObject4 = localCursor;
            localObject5 = localCursor;
            locali.gdX = i;
            localObject4 = localCursor;
            localObject5 = localCursor;
            locali.gec = localCursor.getInt(0);
            localObject4 = localCursor;
            localObject5 = localCursor;
            locali.gea = localCursor.getLong(1);
            localObject4 = localCursor;
            localObject5 = localCursor;
            String str2 = localCursor.getString(2);
            localObject4 = localCursor;
            localObject5 = localCursor;
            if (ab.QQ(str2)) {
              break label740;
            }
            localObject4 = localCursor;
            localObject5 = localCursor;
            Object localObject2;
            if (ab.QV(str2))
            {
              break label740;
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (!"plugin".equals(localObject2)) {
                break label737;
              }
              localObject2 = str2;
              localObject4 = localCursor;
              localObject5 = localCursor;
              locali.gdY = locali.z("usrType", (String)localObject2, true);
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (((localCursor.getLong(3) & 0x0 | Util.nowMilliSecond() & 0xFFFFFFFF) & 0x0) == 0L) {
                break label788;
              }
              j = 1;
              break label748;
              label291:
              localObject4 = localCursor;
              localObject5 = localCursor;
              Object localObject1;
              locali.gdZ = localObject1;
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (!"groupMute".equals(localObject2))
              {
                localObject4 = localCursor;
                localObject5 = localCursor;
                if (!"singleMute".equals(localObject2)) {}
              }
              else
              {
                localObject4 = localCursor;
                localObject5 = localCursor;
                locali.geb = 1L;
                localObject4 = localCursor;
                localObject5 = localCursor;
                localArrayList.add(locali);
                i += 1;
              }
            }
            else
            {
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (ab.QL(str2))
              {
                localObject2 = "subscribe";
                continue;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (ab.QY(str2)) {
                break label757;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (ab.Qb(str2)) {
                break label757;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (str2.startsWith("gh_"))
              {
                localObject2 = "service";
                continue;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              localObject2 = ((n)h.ae(n.class)).bbL().RG(str2);
              if (localObject2 == null) {
                break label764;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (Util.isNullOrNil(((ax)localObject2).field_username)) {
                break label764;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (ab.Lj(str2))
              {
                localObject4 = localCursor;
                localObject5 = localCursor;
                if (((ax)localObject2).hDj != 0) {
                  break label772;
                }
                localObject2 = "groupMute";
                continue;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (((as)localObject2).hxX())
              {
                localObject2 = "subscribe";
                continue;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (!((as)localObject2).aeg()) {
                break label780;
              }
              localObject2 = "singleMute";
              continue;
            }
            localObject4 = localCursor;
            localObject5 = localCursor;
            locali.geb = 0L;
            continue;
          }
        }
        continue;
      }
      catch (Exception localException)
      {
        localObject5 = localObject4;
        Log.printErrStackTrace("MicroMsg.AiWeixinData", localException, "checkSesssionInfo", new Object[0]);
        if (localObject4 != null) {
          localObject4.close();
        }
        Log.i("MicroMsg.AiWeixinData", "checkToGetConversion limit[%d] size[%d] cost[%d]", new Object[] { Integer.valueOf(18), Integer.valueOf(localArrayList.size()), Long.valueOf(Util.ticksToNow(l2)) });
        AppMethodBeat.o(239333);
        return localArrayList;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
      }
      finally
      {
        if (localObject5 != null) {
          localObject5.close();
        }
        AppMethodBeat.o(239333);
      }
      label737:
      label740:
      String str1 = "notifyMessage";
      continue;
      for (;;)
      {
        label748:
        if (j == 0) {
          break label793;
        }
        l1 = 1L;
        break label291;
        label757:
        str1 = "plugin";
        break;
        label764:
        str1 = "error";
        break;
        label772:
        str1 = "group";
        break;
        label780:
        str1 = "single";
        break;
        label788:
        j = 0;
      }
      label793:
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */