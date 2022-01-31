package com.tencent.mm.ah;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

final class c$c
  implements az.a
{
  Bitmap frG = null;
  String username = null;
  
  public c$c(c paramc, String paramString)
  {
    this.username = paramString;
  }
  
  public final boolean acS()
  {
    Context localContext = null;
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(77858);
    if (bo.isNullOrNil(this.username))
    {
      AppMethodBeat.o(77858);
      return false;
    }
    String str1 = this.username;
    boolean bool;
    String str2;
    Object localObject2;
    if (str1 == null)
    {
      bool = false;
      if (bool)
      {
        str2 = (String)this.fry.frw.get(str1);
        if (!bo.isNullOrNil(str2))
        {
          localObject2 = o.adg().rj(str1);
          if ((localObject2 == null) || (!str1.equals(((h)localObject2).getUsername())))
          {
            localObject2 = o.adg();
            String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bo.wC(str2) + "\"";
            localObject2 = ((i)localObject2).fnw.a(str3, null, 2);
            if (localObject2 != null) {
              break label263;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (!bo.isNullOrNil(((h)localObject1).getUsername()))) {
        com.tencent.mm.vfs.e.C(b.qS(((h)localObject1).getUsername()), b.qS(str1));
      }
      localObject1 = new h();
      ((h)localObject1).username = str1;
      ((h)localObject1).dqB = 3;
      ((h)localObject1).fsk = str2;
      ((h)localObject1).fsl = str2;
      ((h)localObject1).bsY = 3;
      ((h)localObject1).cM(true);
      ((h)localObject1).bsY = 31;
      o.adg().b((h)localObject1);
      localObject1 = c.acQ();
      if (localObject1 != null) {
        break label308;
      }
      AppMethodBeat.o(77858);
      return false;
      bool = str1.startsWith("ammURL_");
      break;
      label263:
      localObject1 = localContext;
      if (((Cursor)localObject2).moveToFirst())
      {
        ((Cursor)localObject2).moveToFirst();
        localObject1 = new h();
        ((h)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
    label308:
    if (d.frJ.containsKey(this.username)) {
      i = ((Integer)d.frJ.get(this.username)).intValue();
    }
    if (i != 0)
    {
      o.adf();
      localContext = o.getContext();
      if (localContext != null) {
        ((d)localObject1).f(this.username, a.decodeResource(localContext.getResources(), i));
      }
    }
    this.frG = d.ra(this.username);
    AppMethodBeat.o(77858);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(77859);
    if (this.frG == null)
    {
      c localc = this.fry;
      String str = this.username;
      ab.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
      if (bo.isNullOrNil(str))
      {
        localObject = null;
        if (localObject != null) {
          break label475;
        }
        localc.frq.remove(str);
      }
      for (;;)
      {
        AppMethodBeat.o(77859);
        return false;
        if ((str.equals(localc.frv + "@bottle")) && (!bo.a((Boolean)g.RL().Ru().get(60, null), false)))
        {
          localObject = null;
          break;
        }
        if ((str.equals(localc.frv)) && (!bo.a((Boolean)g.RL().Ru().get(59, null), false)))
        {
          ab.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
          localObject = null;
          break;
        }
        long l = bo.aox();
        c.d locald = (c.d)localc.frr.Y(str);
        if ((locald != null) && (locald.ePG >= 5) && (l - locald.ePF < 600L))
        {
          ab.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
          localObject = null;
          break;
        }
        localObject = c.qW(str);
        if (localObject == null)
        {
          ab.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
          localObject = new c.d((byte)0);
          ((c.d)localObject).ePG = 5;
          ((c.d)localObject).ePF = l;
          localc.frr.f(str, localObject);
          localObject = null;
          break;
        }
        if ((locald == null) || (l - locald.ePF > 600L))
        {
          ab.d("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
          locald = new c.d((byte)0);
          locald.ePG = 1;
          locald.ePF = l;
          localc.frr.f(str, locald);
        }
        for (;;)
        {
          break;
          if (locald.ePG < 5)
          {
            ab.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(locald.ePG), Long.valueOf(l - locald.ePF) });
            locald.ePG += 1;
            locald.ePF = l;
            localc.frr.f(str, locald);
          }
        }
        label475:
        if (!bo.isNullOrNil(((h)localObject).acY()))
        {
          localc.a(new c.b(localc, (h)localObject));
        }
        else
        {
          ab.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((h)localObject).dqB) });
          if (4 == ((h)localObject).dqB)
          {
            ab.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
          }
          else
          {
            localc.frs.push(localObject);
            if (localc.frs.size() > 5) {
              localc.frx.ag(0L, 0L);
            } else {
              localc.frx.ag(1000L, 1000L);
            }
          }
        }
      }
    }
    Object localObject = c.acQ();
    if (localObject != null) {
      ((d)localObject).e(this.username, this.frG);
    }
    this.fry.frq.remove(this.username);
    AppMethodBeat.o(77859);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ah.c.c
 * JD-Core Version:    0.7.0.1
 */