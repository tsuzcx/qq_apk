package com.tencent.mm.plugin.ai.data.business.global;

import android.database.Cursor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adp;
import com.tencent.mm.autogen.a.mh;
import com.tencent.mm.autogen.a.pq;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.j;
import com.tencent.mm.autogen.mmdata.rpt.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.l.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.ArrayList;
import java.util.HashMap;

public final class f
{
  private static f qmC;
  long qmD;
  public boolean qmE;
  long qmF;
  private HashMap<Integer, Long> qmG;
  public IListener<pq> qmH;
  k qmI;
  public IListener<mh> qmJ;
  public IListener<adp> qmv;
  
  private f()
  {
    AppMethodBeat.i(267537);
    this.qmD = 0L;
    this.qmE = false;
    this.qmF = 0L;
    this.qmG = new HashMap();
    this.qmH = new AiWeixinData.1(this, com.tencent.mm.app.f.hfK);
    this.qmv = new AiWeixinData.2(this, com.tencent.mm.app.f.hfK);
    this.qmI = null;
    this.qmJ = new AiWeixinData.3(this, com.tencent.mm.app.f.hfK);
    this.qmG.put(Integer.valueOf(Process.myPid()), Long.valueOf(Util.nowMilliSecond()));
    String str = e.caH().qpt.O("last_gps_info", "");
    if (!Util.isNullOrNil(str))
    {
      this.qmI = new k(str);
      AppMethodBeat.o(267537);
      return;
    }
    this.qmI = new k();
    AppMethodBeat.o(267537);
  }
  
  public static f cao()
  {
    AppMethodBeat.i(267526);
    if (qmC == null) {
      qmC = new f();
    }
    f localf = qmC;
    AppMethodBeat.o(267526);
    return localf;
  }
  
  public static ArrayList<j> cap()
  {
    AppMethodBeat.i(267554);
    long l2 = Util.currentTicks();
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = null;
    Object localObject4 = null;
    for (;;)
    {
      int j;
      try
      {
        Cursor localCursor = ((n)h.ax(n.class)).bzG().pJ(ab.ojZ, a.maX);
        if (localCursor != null)
        {
          int i = 0;
          localObject4 = localCursor;
          localObject5 = localCursor;
          if (localCursor.moveToNext())
          {
            localObject4 = localCursor;
            localObject5 = localCursor;
            j localj = new j();
            localObject4 = localCursor;
            localObject5 = localCursor;
            localj.ikr = i;
            localObject4 = localCursor;
            localObject5 = localCursor;
            localj.ikw = localCursor.getInt(0);
            localObject4 = localCursor;
            localObject5 = localCursor;
            localj.iku = localCursor.getLong(1);
            localObject4 = localCursor;
            localObject5 = localCursor;
            String str2 = localCursor.getString(2);
            localObject4 = localCursor;
            localObject5 = localCursor;
            if (au.bwu(str2)) {
              break label748;
            }
            localObject4 = localCursor;
            localObject5 = localCursor;
            Object localObject2;
            if (au.bwA(str2))
            {
              break label748;
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (!"plugin".equals(localObject2)) {
                break label745;
              }
              localObject2 = str2;
              localObject4 = localCursor;
              localObject5 = localCursor;
              localj.iks = localj.F("usrType", (String)localObject2, true);
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (((localCursor.getLong(3) & 0x0 | Util.nowMilliSecond() & 0xFFFFFFFF) & 0x0) == 0L) {
                break label796;
              }
              j = 1;
              break label756;
              label291:
              localObject4 = localCursor;
              localObject5 = localCursor;
              Object localObject1;
              localj.ikt = localObject1;
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
                localj.ikv = 1L;
                localObject4 = localCursor;
                localObject5 = localCursor;
                localArrayList.add(localj);
                i += 1;
              }
            }
            else
            {
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (au.bwp(str2))
              {
                localObject2 = "subscribe";
                continue;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (ab.IW(str2)) {
                break label765;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (au.bxe(str2)) {
                break label765;
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
              localObject2 = ((n)h.ax(n.class)).bzA().JE(str2);
              if (localObject2 == null) {
                break label772;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (Util.isNullOrNil(((az)localObject2).field_username)) {
                break label772;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (au.bwE(str2))
              {
                localObject4 = localCursor;
                localObject5 = localCursor;
                if (((az)localObject2).kaf != 0) {
                  break label780;
                }
                localObject2 = "groupMute";
                continue;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (((au)localObject2).iZC())
              {
                localObject2 = "subscribe";
                continue;
              }
              localObject4 = localCursor;
              localObject5 = localCursor;
              if (!((au)localObject2).aGe()) {
                break label788;
              }
              localObject2 = "singleMute";
              continue;
            }
            localObject4 = localCursor;
            localObject5 = localCursor;
            localj.ikv = 0L;
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
        AppMethodBeat.o(267554);
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
        AppMethodBeat.o(267554);
      }
      label745:
      label748:
      String str1 = "notifyMessage";
      continue;
      for (;;)
      {
        label756:
        if (j == 0) {
          break label801;
        }
        l1 = 1L;
        break label291;
        label765:
        str1 = "plugin";
        break;
        label772:
        str1 = "error";
        break;
        label780:
        str1 = "group";
        break;
        label788:
        str1 = "single";
        break;
        label796:
        j = 0;
      }
      label801:
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.global.f
 * JD-Core Version:    0.7.0.1
 */