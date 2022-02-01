package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.a.y.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.m.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public final class a
{
  com.tencent.mm.sdk.b.c mRN;
  
  public a()
  {
    AppMethodBeat.i(21156);
    this.mRN = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(21154);
        if ((paramAnonymousy instanceof y)) {}
        try
        {
          y.a locala = paramAnonymousy.cZo;
          localObject1 = paramAnonymousy.cZo.username;
          paramAnonymousy = paramAnonymousy.cZo.title;
          if (a.bCG()) {
            break label58;
          }
          paramAnonymousy = null;
          locala.cZp = paramAnonymousy;
        }
        catch (Throwable paramAnonymousy)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            Object localObject4;
            Object localObject5;
            int i;
            Object localObject6;
            ac.printErrStackTrace("MicroMsg.auto.AutoLogic", paramAnonymousy, "", new Object[0]);
            continue;
            continue;
            Object localObject1 = null;
            continue;
            continue;
            i -= 1;
            continue;
            paramAnonymousy = (y)localObject2;
          }
        }
        AppMethodBeat.o(21154);
        return false;
        label58:
        localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
        com.tencent.mm.sdk.platformtools.g.be((Intent)localObject2);
        localObject2 = PendingIntent.getBroadcast(com.tencent.mm.sdk.platformtools.ai.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
        localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
        com.tencent.mm.sdk.platformtools.g.be((Intent)localObject3);
        localObject3 = PendingIntent.getBroadcast(com.tencent.mm.sdk.platformtools.ai.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
        localObject4 = new x.a("key_voice_reply_text");
        ((x.a)localObject4).GG = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131755875);
        localObject5 = new x(((x.a)localObject4).GF, ((x.a)localObject4).GG, ((x.a)localObject4).GH, ((x.a)localObject4).GI, ((x.a)localObject4).mExtras, ((x.a)localObject4).GJ);
        localObject4 = new s.d.a.a(paramAnonymousy);
        ((s.d.a.a)localObject4).Gc = ((PendingIntent)localObject2);
        ((s.d.a.a)localObject4).Ga = ((x)localObject5);
        ((s.d.a.a)localObject4).Gb = ((PendingIntent)localObject3);
        int j = f.sO((String)localObject1);
        i = j;
        if (j > 10) {
          i = 10;
        }
        az.ayM();
        localObject5 = com.tencent.mm.model.c.awD().dK((String)localObject1, i);
        i = ((List)localObject5).size() - 1;
        if (i >= 0)
        {
          localObject6 = (bo)((List)localObject5).get(i);
          localObject2 = null;
          if (!w.sQ(((dy)localObject6).field_talker)) {
            break label1689;
          }
          localObject1 = ((dy)localObject6).field_talker;
          j = bi.yi(((dy)localObject6).field_content);
          paramAnonymousy = (y)localObject1;
          if (j != -1)
          {
            localObject3 = ((dy)localObject6).field_content.substring(0, j).trim();
            paramAnonymousy = (y)localObject1;
            if (localObject3 != null)
            {
              paramAnonymousy = (y)localObject1;
              if (((String)localObject3).length() > 0) {
                paramAnonymousy = (y)localObject3;
              }
            }
          }
          az.ayM();
          localObject3 = com.tencent.mm.model.c.awB().aNt(paramAnonymousy);
          localObject1 = v.b((com.tencent.mm.storage.ai)localObject3, paramAnonymousy);
          if ((!w.sQ(paramAnonymousy)) || ((!((av)localObject3).field_username.equals(localObject1)) && (!bs.isNullOrNil((String)localObject1)))) {
            break label1695;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757293);
          if (((bo)localObject6).eZm()) {
            paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761693);
          }
          for (;;)
          {
            label464:
            localObject2 = paramAnonymousy;
            if (paramAnonymousy == null) {
              localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761720);
            }
            paramAnonymousy = (y)localObject2;
            if (localObject1 != null) {
              paramAnonymousy = String.format("%s: %s", new Object[] { localObject1, localObject2 });
            }
            ((s.d.a.a)localObject4).Gf.add(paramAnonymousy);
            if (i != 0) {
              break label1698;
            }
            ((s.d.a.a)localObject4).Ge = ((dy)localObject6).field_createTime;
            break label1698;
            if (((bo)localObject6).isText())
            {
              if ((w.sQ(((dy)localObject6).field_talker)) && (((dy)localObject6).field_isSend != 1))
              {
                j = bi.yi(((dy)localObject6).field_content);
                if (j != -1) {
                  paramAnonymousy = ((dy)localObject6).field_content.substring(j + 1).trim();
                } else {
                  paramAnonymousy = ((dy)localObject6).field_content;
                }
              }
              else
              {
                paramAnonymousy = ((dy)localObject6).field_content;
              }
            }
            else if (((bo)localObject6).eZl())
            {
              paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761729);
            }
            else if (((bo)localObject6).crt())
            {
              paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761728);
            }
            else if (((bo)localObject6).crv())
            {
              paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761719);
            }
            else if (((bo)localObject6).cKN())
            {
              localObject3 = k.b.vA(((dy)localObject6).field_content);
              paramAnonymousy = (y)localObject2;
              if (localObject3 == null) {}
            }
            else
            {
              switch (((k.b)localObject3).type)
              {
              case 2: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761693), new Object[0]);
                break;
              case 5: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761662), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 3: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761665), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 6: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761661), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 4: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761669), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 19: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761667), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 24: 
                paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759036);
                break;
              case 15: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761660), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 10: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761666), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 13: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761664), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 20: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761668), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 16: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761673), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                break;
              case 8: 
                paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761674), new Object[] { bs.bG(((k.b)localObject3).title, "") });
                continue;
                if (((bo)localObject6).fbC())
                {
                  paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761682);
                  localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                  if (localObject2 == null) {
                    break label1686;
                  }
                  paramAnonymousy = ((com.tencent.mm.pluginsdk.a.d)localObject2).XL(((dy)localObject6).field_imgPath);
                  if ((paramAnonymousy == null) || (bs.isNullOrNil(((com.tencent.mm.pluginsdk.a.d)localObject2).XP(paramAnonymousy.JC())))) {
                    paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761682);
                  } else {
                    paramAnonymousy = "[" + ((com.tencent.mm.pluginsdk.a.d)localObject2).XP(paramAnonymousy.JC()) + "]";
                  }
                }
                else if (((bo)localObject6).cKP())
                {
                  paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761694);
                }
                else
                {
                  if ((!((bo)localObject6).fbx()) && (!((bo)localObject6).fby())) {
                    break label1486;
                  }
                  if (!((dy)localObject6).field_content.equals(bo.GYO))
                  {
                    paramAnonymousy = ((dy)localObject6).field_content;
                    localObject2 = new xh();
                    ((xh)localObject2).dAb.dgL = 1;
                    ((xh)localObject2).dAb.content = paramAnonymousy;
                    com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
                    if (((xh)localObject2).dAc.type != 3) {
                      break label1718;
                    }
                    j = 1;
                    break label1711;
                  }
                  paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761733);
                }
                break;
              }
            }
          }
        }
        label1686:
        label1689:
        label1695:
        label1698:
        label1711:
        label1718:
        label1721:
        for (;;)
        {
          paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761732);
          break label464;
          label1486:
          if (((bo)localObject6).fbB())
          {
            az.ayM();
            paramAnonymousy = com.tencent.mm.model.c.awD().alw(((dy)localObject6).field_content);
            paramAnonymousy = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761673), new Object[] { paramAnonymousy.getDisplayName() });
            break label464;
          }
          paramAnonymousy = (y)localObject2;
          if (((bo)localObject6).getType() != -1879048186) {
            break label464;
          }
          paramAnonymousy = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761663);
          break label464;
          paramAnonymousy = new s.d();
          localObject1 = (String[])((s.d.a.a)localObject4).Gf.toArray(new String[((s.d.a.a)localObject4).Gf.size()]);
          localObject2 = ((s.d.a.a)localObject4).Gg;
          localObject3 = ((s.d.a.a)localObject4).Ga;
          localObject5 = ((s.d.a.a)localObject4).Gb;
          localObject6 = ((s.d.a.a)localObject4).Gc;
          long l = ((s.d.a.a)localObject4).Ge;
          paramAnonymousy.FY = new s.d.a((String[])localObject1, (x)localObject3, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
          break;
          for (;;)
          {
            if (j == 0) {
              break label1721;
            }
            break;
            j = 0;
          }
        }
      }
    };
    AppMethodBeat.o(21156);
  }
  
  static boolean bCG()
  {
    AppMethodBeat.i(21157);
    PackageManager localPackageManager = com.tencent.mm.sdk.platformtools.ai.getContext().getPackageManager();
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
    ac.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(21157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a
 * JD-Core Version:    0.7.0.1
 */