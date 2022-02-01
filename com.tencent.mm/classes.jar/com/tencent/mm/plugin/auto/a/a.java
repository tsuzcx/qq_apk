package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.s.d;
import android.support.v4.app.s.d.a;
import android.support.v4.app.s.d.a.a;
import android.support.v4.app.x;
import android.support.v4.app.x.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.aa.a;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BroadcastHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public final class a
{
  IListener oID;
  
  public a()
  {
    AppMethodBeat.i(21156);
    this.oID = new IListener()
    {
      private static boolean a(com.tencent.mm.g.a.aa paramAnonymousaa)
      {
        AppMethodBeat.i(21154);
        if ((paramAnonymousaa instanceof com.tencent.mm.g.a.aa)) {}
        int j;
        for (;;)
        {
          try
          {
            aa.a locala = paramAnonymousaa.dCY;
            localObject1 = paramAnonymousaa.dCY.username;
            paramAnonymousaa = paramAnonymousaa.dCY.title;
            if (a.ceB()) {
              continue;
            }
            paramAnonymousaa = null;
            locala.dCZ = paramAnonymousaa;
          }
          catch (Throwable paramAnonymousaa)
          {
            Object localObject1;
            Object localObject3;
            Object localObject4;
            Object localObject5;
            int i;
            Object localObject6;
            label517:
            Log.printErrStackTrace("MicroMsg.auto.AutoLogic", paramAnonymousaa, "", new Object[0]);
            continue;
            continue;
            Object localObject2 = null;
            continue;
            localObject2 = paramAnonymousaa;
            continue;
            i -= 1;
            continue;
            paramAnonymousaa = null;
            continue;
          }
          AppMethodBeat.o(21154);
          return false;
          if (!a.ceC())
          {
            Log.i("MicroMsg.auto.AutoLogic", "not open car mode");
            paramAnonymousaa = null;
          }
          else if (!a.ceD())
          {
            Log.i("MicroMsg.auto.AutoLogic", "not install auto app");
            paramAnonymousaa = null;
          }
          else
          {
            localObject2 = b.oIG;
            b.Bt(0L);
            localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
            BroadcastHelper.setIntentPackageName((Intent)localObject2);
            localObject2 = PendingIntent.getBroadcast(MMApplicationContext.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
            localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
            BroadcastHelper.setIntentPackageName((Intent)localObject3);
            localObject4 = PendingIntent.getBroadcast(MMApplicationContext.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
            localObject3 = new x.a("key_voice_reply_text");
            ((x.a)localObject3).IJ = MMApplicationContext.getContext().getString(2131755964);
            localObject5 = new x(((x.a)localObject3).II, ((x.a)localObject3).IJ, ((x.a)localObject3).IK, ((x.a)localObject3).IL, ((x.a)localObject3).mExtras, ((x.a)localObject3).IM);
            localObject3 = new s.d.a.a(paramAnonymousaa);
            ((s.d.a.a)localObject3).Ie = ((PendingIntent)localObject2);
            ((s.d.a.a)localObject3).Ib = ((x)localObject5);
            ((s.d.a.a)localObject3).Ic = ((PendingIntent)localObject4);
            j = com.tencent.mm.n.g.Eo((String)localObject1);
            i = j;
            if (j > 10) {
              i = 10;
            }
            bg.aVF();
            localObject4 = c.aSQ().ew((String)localObject1, i);
            i = ((List)localObject4).size() - 1;
            if (i >= 0)
            {
              localObject5 = (ca)((List)localObject4).get(i);
              if (!ab.Eq(((eo)localObject5).field_talker)) {
                continue;
              }
              paramAnonymousaa = ((eo)localObject5).field_talker;
              j = bp.Kp(((eo)localObject5).field_content);
              localObject1 = paramAnonymousaa;
              if (j != -1)
              {
                localObject2 = ((eo)localObject5).field_content.substring(0, j).trim();
                localObject1 = paramAnonymousaa;
                if (localObject2 != null)
                {
                  localObject1 = paramAnonymousaa;
                  if (((String)localObject2).length() > 0) {
                    localObject1 = localObject2;
                  }
                }
              }
              bg.aVF();
              localObject6 = c.aSN().Kn((String)localObject1);
              localObject2 = com.tencent.mm.model.aa.b((as)localObject6, (String)localObject1);
              paramAnonymousaa = (com.tencent.mm.g.a.aa)localObject2;
              if (!ab.Eq((String)localObject1)) {
                continue;
              }
              if (!((ax)localObject6).field_username.equals(localObject2))
              {
                paramAnonymousaa = (com.tencent.mm.g.a.aa)localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  continue;
                }
              }
              paramAnonymousaa = MMApplicationContext.getContext().getString(2131757507);
              continue;
              if (((ca)localObject5).gAz()) {
                paramAnonymousaa = MMApplicationContext.getContext().getString(2131763661);
              }
              for (;;)
              {
                localObject1 = paramAnonymousaa;
                if (paramAnonymousaa == null) {
                  localObject1 = MMApplicationContext.getContext().getString(2131763688);
                }
                paramAnonymousaa = (com.tencent.mm.g.a.aa)localObject1;
                if (localObject2 != null) {
                  paramAnonymousaa = String.format("%s: %s", new Object[] { localObject2, localObject1 });
                }
                ((s.d.a.a)localObject3).Ih.add(paramAnonymousaa);
                if (i != 0) {
                  break label1730;
                }
                ((s.d.a.a)localObject3).Ig = ((eo)localObject5).field_createTime;
                break label1730;
                if (((ca)localObject5).isText())
                {
                  if ((ab.Eq(((eo)localObject5).field_talker)) && (((eo)localObject5).field_isSend != 1))
                  {
                    j = bp.Kp(((eo)localObject5).field_content);
                    if (j != -1) {
                      paramAnonymousaa = ((eo)localObject5).field_content.substring(j + 1).trim();
                    } else {
                      paramAnonymousaa = ((eo)localObject5).field_content;
                    }
                  }
                  else
                  {
                    paramAnonymousaa = ((eo)localObject5).field_content;
                  }
                }
                else if (((ca)localObject5).gAy())
                {
                  paramAnonymousaa = MMApplicationContext.getContext().getString(2131763697);
                }
                else if (((ca)localObject5).cWJ())
                {
                  paramAnonymousaa = MMApplicationContext.getContext().getString(2131763696);
                }
                else if (((ca)localObject5).cWL())
                {
                  paramAnonymousaa = MMApplicationContext.getContext().getString(2131763687);
                }
                else
                {
                  if (((ca)localObject5).dOQ())
                  {
                    paramAnonymousaa = k.b.HD(((eo)localObject5).field_content);
                    if (paramAnonymousaa == null) {
                      break label1737;
                    }
                  }
                  switch (paramAnonymousaa.type)
                  {
                  case 5: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763630), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 3: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763633), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 6: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763629), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 4: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763637), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 2: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763661), new Object[0]);
                    break;
                  case 19: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763635), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 24: 
                    paramAnonymousaa = MMApplicationContext.getContext().getString(2131759362);
                    break;
                  case 15: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763628), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 10: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763634), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 13: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763632), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 20: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763636), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 16: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763641), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    break;
                  case 8: 
                    paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763642), new Object[] { Util.nullAs(paramAnonymousaa.title, "") });
                    continue;
                    if (((ca)localObject5).gDn())
                    {
                      paramAnonymousaa = MMApplicationContext.getContext().getString(2131763650);
                      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                      if (localObject1 == null) {
                        break label1715;
                      }
                      paramAnonymousaa = ((com.tencent.mm.pluginsdk.a.d)localObject1).aml(((eo)localObject5).field_imgPath);
                      if ((paramAnonymousaa == null) || (Util.isNullOrNil(((com.tencent.mm.pluginsdk.a.d)localObject1).amp(paramAnonymousaa.getMd5())))) {
                        paramAnonymousaa = MMApplicationContext.getContext().getString(2131763650);
                      } else {
                        paramAnonymousaa = "[" + ((com.tencent.mm.pluginsdk.a.d)localObject1).amp(paramAnonymousaa.getMd5()) + "]";
                      }
                    }
                    else if (((ca)localObject5).dOS())
                    {
                      paramAnonymousaa = MMApplicationContext.getContext().getString(2131763662);
                    }
                    else
                    {
                      if ((!((ca)localObject5).gDh()) && (!((ca)localObject5).gDi())) {
                        break label1519;
                      }
                      if (!((eo)localObject5).field_content.equals(ca.OqB))
                      {
                        paramAnonymousaa = ((eo)localObject5).field_content;
                        localObject1 = new zj();
                        ((zj)localObject1).efx.dKy = 1;
                        ((zj)localObject1).efx.content = paramAnonymousaa;
                        EventCenter.instance.publish((IEvent)localObject1);
                        if (((zj)localObject1).efy.type != 3) {
                          break label1749;
                        }
                        j = 1;
                        break label1742;
                      }
                      paramAnonymousaa = MMApplicationContext.getContext().getString(2131763701);
                    }
                    break;
                  }
                }
              }
            }
          }
        }
        label1715:
        label1730:
        label1737:
        label1742:
        label1749:
        label1752:
        for (;;)
        {
          paramAnonymousaa = MMApplicationContext.getContext().getString(2131763700);
          break label517;
          label1519:
          if (((ca)localObject5).gDl())
          {
            bg.aVF();
            paramAnonymousaa = c.aSQ().aEK(((eo)localObject5).field_content);
            paramAnonymousaa = String.format(MMApplicationContext.getContext().getString(2131763641), new Object[] { paramAnonymousaa.getDisplayName() });
            break label517;
          }
          if (((ca)localObject5).getType() == -1879048186)
          {
            paramAnonymousaa = MMApplicationContext.getContext().getString(2131763631);
            break label517;
            paramAnonymousaa = new s.d();
            localObject1 = (String[])((s.d.a.a)localObject3).Ih.toArray(new String[((s.d.a.a)localObject3).Ih.size()]);
            localObject2 = ((s.d.a.a)localObject3).Ii;
            localObject4 = ((s.d.a.a)localObject3).Ib;
            localObject5 = ((s.d.a.a)localObject3).Ic;
            localObject6 = ((s.d.a.a)localObject3).Ie;
            long l = ((s.d.a.a)localObject3).Ig;
            paramAnonymousaa.HZ = new s.d.a((String[])localObject1, (x)localObject4, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
            break;
          }
          for (;;)
          {
            if (j == 0) {
              break label1752;
            }
            break;
            j = 0;
          }
        }
      }
    };
    AppMethodBeat.o(21156);
  }
  
  public static boolean ceB()
  {
    AppMethodBeat.i(231584);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seW, 1) == 1)
    {
      AppMethodBeat.o(231584);
      return true;
    }
    AppMethodBeat.o(231584);
    return false;
  }
  
  public static boolean ceC()
  {
    AppMethodBeat.i(231585);
    if (((UiModeManager)MMApplicationContext.getContext().getSystemService("uimode")).getCurrentModeType() == 3)
    {
      AppMethodBeat.o(231585);
      return true;
    }
    AppMethodBeat.o(231585);
    return false;
  }
  
  public static boolean ceD()
  {
    AppMethodBeat.i(21157);
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.projection.gearhead", 1);
      bool = true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    Log.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(21157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a
 * JD-Core Version:    0.7.0.1
 */