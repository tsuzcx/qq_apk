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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.a.y.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public final class a
{
  com.tencent.mm.sdk.b.c nsm;
  
  public a()
  {
    AppMethodBeat.i(21156);
    this.nsm = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(21154);
        if ((paramAnonymousy instanceof y)) {}
        try
        {
          y.a locala = paramAnonymousy.dkG;
          localObject1 = paramAnonymousy.dkG.username;
          paramAnonymousy = paramAnonymousy.dkG.title;
          if (a.bGO()) {
            break label58;
          }
          paramAnonymousy = null;
          locala.dkH = paramAnonymousy;
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
            ad.printErrStackTrace("MicroMsg.auto.AutoLogic", paramAnonymousy, "", new Object[0]);
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
        h.bj((Intent)localObject2);
        localObject2 = PendingIntent.getBroadcast(aj.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
        localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
        h.bj((Intent)localObject3);
        localObject3 = PendingIntent.getBroadcast(aj.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
        localObject4 = new x.a("key_voice_reply_text");
        ((x.a)localObject4).Iy = aj.getContext().getString(2131755875);
        localObject5 = new x(((x.a)localObject4).Ix, ((x.a)localObject4).Iy, ((x.a)localObject4).Iz, ((x.a)localObject4).IA, ((x.a)localObject4).mExtras, ((x.a)localObject4).IB);
        localObject4 = new s.d.a.a(paramAnonymousy);
        ((s.d.a.a)localObject4).HT = ((PendingIntent)localObject2);
        ((s.d.a.a)localObject4).HR = ((x)localObject5);
        ((s.d.a.a)localObject4).HS = ((PendingIntent)localObject3);
        int j = f.vD((String)localObject1);
        i = j;
        if (j > 10) {
          i = 10;
        }
        ba.aBQ();
        localObject5 = com.tencent.mm.model.c.azs().eb((String)localObject1, i);
        i = ((List)localObject5).size() - 1;
        if (i >= 0)
        {
          localObject6 = (bu)((List)localObject5).get(i);
          localObject2 = null;
          if (!w.vF(((ei)localObject6).field_talker)) {
            break label1689;
          }
          localObject1 = ((ei)localObject6).field_talker;
          j = bj.Bh(((ei)localObject6).field_content);
          paramAnonymousy = (y)localObject1;
          if (j != -1)
          {
            localObject3 = ((ei)localObject6).field_content.substring(0, j).trim();
            paramAnonymousy = (y)localObject1;
            if (localObject3 != null)
            {
              paramAnonymousy = (y)localObject1;
              if (((String)localObject3).length() > 0) {
                paramAnonymousy = (y)localObject3;
              }
            }
          }
          ba.aBQ();
          localObject3 = com.tencent.mm.model.c.azp().Bf(paramAnonymousy);
          localObject1 = v.b((am)localObject3, paramAnonymousy);
          if ((!w.vF(paramAnonymousy)) || ((!((aw)localObject3).field_username.equals(localObject1)) && (!bt.isNullOrNil((String)localObject1)))) {
            break label1695;
          }
          localObject1 = aj.getContext().getString(2131757293);
          if (((bu)localObject6).fpi()) {
            paramAnonymousy = aj.getContext().getString(2131761693);
          }
          for (;;)
          {
            label464:
            localObject2 = paramAnonymousy;
            if (paramAnonymousy == null) {
              localObject2 = aj.getContext().getString(2131761720);
            }
            paramAnonymousy = (y)localObject2;
            if (localObject1 != null) {
              paramAnonymousy = String.format("%s: %s", new Object[] { localObject1, localObject2 });
            }
            ((s.d.a.a)localObject4).HW.add(paramAnonymousy);
            if (i != 0) {
              break label1698;
            }
            ((s.d.a.a)localObject4).HV = ((ei)localObject6).field_createTime;
            break label1698;
            if (((bu)localObject6).isText())
            {
              if ((w.vF(((ei)localObject6).field_talker)) && (((ei)localObject6).field_isSend != 1))
              {
                j = bj.Bh(((ei)localObject6).field_content);
                if (j != -1) {
                  paramAnonymousy = ((ei)localObject6).field_content.substring(j + 1).trim();
                } else {
                  paramAnonymousy = ((ei)localObject6).field_content;
                }
              }
              else
              {
                paramAnonymousy = ((ei)localObject6).field_content;
              }
            }
            else if (((bu)localObject6).fph())
            {
              paramAnonymousy = aj.getContext().getString(2131761729);
            }
            else if (((bu)localObject6).cxf())
            {
              paramAnonymousy = aj.getContext().getString(2131761728);
            }
            else if (((bu)localObject6).cxh())
            {
              paramAnonymousy = aj.getContext().getString(2131761719);
            }
            else if (((bu)localObject6).cTc())
            {
              localObject3 = k.b.yr(((ei)localObject6).field_content);
              paramAnonymousy = (y)localObject2;
              if (localObject3 == null) {}
            }
            else
            {
              switch (((k.b)localObject3).type)
              {
              case 2: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761693), new Object[0]);
                break;
              case 5: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761662), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 3: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761665), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 6: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761661), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 4: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761669), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 19: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761667), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 24: 
                paramAnonymousy = aj.getContext().getString(2131759036);
                break;
              case 15: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761660), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 10: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761666), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 13: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761664), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 20: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761668), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 16: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761673), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                break;
              case 8: 
                paramAnonymousy = String.format(aj.getContext().getString(2131761674), new Object[] { bt.bI(((k.b)localObject3).title, "") });
                continue;
                if (((bu)localObject6).frG())
                {
                  paramAnonymousy = aj.getContext().getString(2131761682);
                  localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                  if (localObject2 == null) {
                    break label1686;
                  }
                  paramAnonymousy = ((com.tencent.mm.pluginsdk.a.d)localObject2).abr(((ei)localObject6).field_imgPath);
                  if ((paramAnonymousy == null) || (bt.isNullOrNil(((com.tencent.mm.pluginsdk.a.d)localObject2).abv(paramAnonymousy.Lb())))) {
                    paramAnonymousy = aj.getContext().getString(2131761682);
                  } else {
                    paramAnonymousy = "[" + ((com.tencent.mm.pluginsdk.a.d)localObject2).abv(paramAnonymousy.Lb()) + "]";
                  }
                }
                else if (((bu)localObject6).cTe())
                {
                  paramAnonymousy = aj.getContext().getString(2131761694);
                }
                else
                {
                  if ((!((bu)localObject6).frA()) && (!((bu)localObject6).frB())) {
                    break label1486;
                  }
                  if (!((ei)localObject6).field_content.equals(bu.IMd))
                  {
                    paramAnonymousy = ((ei)localObject6).field_content;
                    localObject2 = new yb();
                    ((yb)localObject2).dMo.dsi = 1;
                    ((yb)localObject2).dMo.content = paramAnonymousy;
                    com.tencent.mm.sdk.b.a.IbL.l((b)localObject2);
                    if (((yb)localObject2).dMp.type != 3) {
                      break label1718;
                    }
                    j = 1;
                    break label1711;
                  }
                  paramAnonymousy = aj.getContext().getString(2131761733);
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
          paramAnonymousy = aj.getContext().getString(2131761732);
          break label464;
          label1486:
          if (((bu)localObject6).frE())
          {
            ba.aBQ();
            paramAnonymousy = com.tencent.mm.model.c.azs().aqk(((ei)localObject6).field_content);
            paramAnonymousy = String.format(aj.getContext().getString(2131761673), new Object[] { paramAnonymousy.getDisplayName() });
            break label464;
          }
          paramAnonymousy = (y)localObject2;
          if (((bu)localObject6).getType() != -1879048186) {
            break label464;
          }
          paramAnonymousy = aj.getContext().getString(2131761663);
          break label464;
          paramAnonymousy = new s.d();
          localObject1 = (String[])((s.d.a.a)localObject4).HW.toArray(new String[((s.d.a.a)localObject4).HW.size()]);
          localObject2 = ((s.d.a.a)localObject4).HX;
          localObject3 = ((s.d.a.a)localObject4).HR;
          localObject5 = ((s.d.a.a)localObject4).HS;
          localObject6 = ((s.d.a.a)localObject4).HT;
          long l = ((s.d.a.a)localObject4).HV;
          paramAnonymousy.HP = new s.d.a((String[])localObject1, (x)localObject3, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
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
  
  static boolean bGO()
  {
    AppMethodBeat.i(21157);
    PackageManager localPackageManager = aj.getContext().getPackageManager();
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
    ad.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(21157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a
 * JD-Core Version:    0.7.0.1
 */