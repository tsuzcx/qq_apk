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
import android.support.v4.app.x.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.a.y.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public final class a
{
  com.tencent.mm.sdk.b.c nxF;
  
  public a()
  {
    AppMethodBeat.i(21156);
    this.nxF = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(21154);
        if ((paramAnonymousy instanceof y)) {}
        int j;
        for (;;)
        {
          try
          {
            y.a locala = paramAnonymousy.dlI;
            localObject1 = paramAnonymousy.dlI.username;
            paramAnonymousy = paramAnonymousy.dlI.title;
            if (a.bHK()) {
              continue;
            }
            paramAnonymousy = null;
            locala.dlJ = paramAnonymousy;
          }
          catch (Throwable paramAnonymousy)
          {
            Object localObject2;
            Object localObject3;
            Object localObject4;
            Object localObject5;
            int i;
            Object localObject6;
            label509:
            ae.printErrStackTrace("MicroMsg.auto.AutoLogic", paramAnonymousy, "", new Object[0]);
            continue;
            continue;
            Object localObject1 = null;
            continue;
            continue;
            i -= 1;
            continue;
            paramAnonymousy = (y)localObject2;
            continue;
          }
          AppMethodBeat.o(21154);
          return false;
          if (!a.bHL())
          {
            ae.i("MicroMsg.auto.AutoLogic", "not open car mode");
            paramAnonymousy = null;
          }
          else if (!a.bHM())
          {
            ae.i("MicroMsg.auto.AutoLogic", "not install auto app");
            paramAnonymousy = null;
          }
          else
          {
            localObject2 = b.nxI;
            b.tn(0L);
            localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
            com.tencent.mm.sdk.platformtools.i.bk((Intent)localObject2);
            localObject2 = PendingIntent.getBroadcast(ak.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
            localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
            com.tencent.mm.sdk.platformtools.i.bk((Intent)localObject3);
            localObject3 = PendingIntent.getBroadcast(ak.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
            localObject4 = new x.a("key_voice_reply_text");
            ((x.a)localObject4).Iy = ak.getContext().getString(2131755875);
            localObject5 = new android.support.v4.app.x(((x.a)localObject4).Ix, ((x.a)localObject4).Iy, ((x.a)localObject4).Iz, ((x.a)localObject4).IA, ((x.a)localObject4).mExtras, ((x.a)localObject4).IB);
            localObject4 = new s.d.a.a(paramAnonymousy);
            ((s.d.a.a)localObject4).HT = ((PendingIntent)localObject2);
            ((s.d.a.a)localObject4).HR = ((android.support.v4.app.x)localObject5);
            ((s.d.a.a)localObject4).HS = ((PendingIntent)localObject3);
            j = f.vZ((String)localObject1);
            i = j;
            if (j > 10) {
              i = 10;
            }
            bc.aCg();
            localObject5 = com.tencent.mm.model.c.azI().ei((String)localObject1, i);
            i = ((List)localObject5).size() - 1;
            if (i >= 0)
            {
              localObject6 = (bv)((List)localObject5).get(i);
              localObject2 = null;
              if (!com.tencent.mm.model.x.wb(((ei)localObject6).field_talker)) {
                continue;
              }
              localObject1 = ((ei)localObject6).field_talker;
              j = bl.BJ(((ei)localObject6).field_content);
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
              bc.aCg();
              localObject3 = com.tencent.mm.model.c.azF().BH(paramAnonymousy);
              localObject1 = w.b((an)localObject3, paramAnonymousy);
              if ((!com.tencent.mm.model.x.wb(paramAnonymousy)) || ((!((aw)localObject3).field_username.equals(localObject1)) && (!bu.isNullOrNil((String)localObject1)))) {
                continue;
              }
              localObject1 = ak.getContext().getString(2131757293);
              if (((bv)localObject6).ftg()) {
                paramAnonymousy = ak.getContext().getString(2131761693);
              }
              for (;;)
              {
                localObject2 = paramAnonymousy;
                if (paramAnonymousy == null) {
                  localObject2 = ak.getContext().getString(2131761720);
                }
                paramAnonymousy = (y)localObject2;
                if (localObject1 != null) {
                  paramAnonymousy = String.format("%s: %s", new Object[] { localObject1, localObject2 });
                }
                ((s.d.a.a)localObject4).HW.add(paramAnonymousy);
                if (i != 0) {
                  break label1741;
                }
                ((s.d.a.a)localObject4).HV = ((ei)localObject6).field_createTime;
                break label1741;
                if (((bv)localObject6).isText())
                {
                  if ((com.tencent.mm.model.x.wb(((ei)localObject6).field_talker)) && (((ei)localObject6).field_isSend != 1))
                  {
                    j = bl.BJ(((ei)localObject6).field_content);
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
                else if (((bv)localObject6).ftf())
                {
                  paramAnonymousy = ak.getContext().getString(2131761729);
                }
                else if (((bv)localObject6).cyG())
                {
                  paramAnonymousy = ak.getContext().getString(2131761728);
                }
                else if (((bv)localObject6).cyI())
                {
                  paramAnonymousy = ak.getContext().getString(2131761719);
                }
                else if (((bv)localObject6).cVH())
                {
                  localObject3 = k.b.zb(((ei)localObject6).field_content);
                  paramAnonymousy = (y)localObject2;
                  if (localObject3 == null) {}
                }
                else
                {
                  switch (((k.b)localObject3).type)
                  {
                  case 2: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761693), new Object[0]);
                    break;
                  case 5: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761662), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 3: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761665), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 6: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761661), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 4: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761669), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 19: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761667), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 24: 
                    paramAnonymousy = ak.getContext().getString(2131759036);
                    break;
                  case 15: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761660), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 10: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761666), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 13: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761664), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 20: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761668), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 16: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761673), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    break;
                  case 8: 
                    paramAnonymousy = String.format(ak.getContext().getString(2131761674), new Object[] { bu.bI(((k.b)localObject3).title, "") });
                    continue;
                    if (((bv)localObject6).fvG())
                    {
                      paramAnonymousy = ak.getContext().getString(2131761682);
                      localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                      if (localObject2 == null) {
                        break label1729;
                      }
                      paramAnonymousy = ((com.tencent.mm.pluginsdk.a.d)localObject2).aci(((ei)localObject6).field_imgPath);
                      if ((paramAnonymousy == null) || (bu.isNullOrNil(((com.tencent.mm.pluginsdk.a.d)localObject2).acm(paramAnonymousy.Lj())))) {
                        paramAnonymousy = ak.getContext().getString(2131761682);
                      } else {
                        paramAnonymousy = "[" + ((com.tencent.mm.pluginsdk.a.d)localObject2).acm(paramAnonymousy.Lj()) + "]";
                      }
                    }
                    else if (((bv)localObject6).cVJ())
                    {
                      paramAnonymousy = ak.getContext().getString(2131761694);
                    }
                    else
                    {
                      if ((!((bv)localObject6).fvA()) && (!((bv)localObject6).fvB())) {
                        break label1530;
                      }
                      if (!((ei)localObject6).field_content.equals(bv.JgK))
                      {
                        paramAnonymousy = ((ei)localObject6).field_content;
                        localObject2 = new yh();
                        ((yh)localObject2).dNE.dto = 1;
                        ((yh)localObject2).dNE.content = paramAnonymousy;
                        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
                        if (((yh)localObject2).dNF.type != 3) {
                          break label1761;
                        }
                        j = 1;
                        break label1754;
                      }
                      paramAnonymousy = ak.getContext().getString(2131761733);
                    }
                    break;
                  }
                }
              }
            }
          }
        }
        label1729:
        label1741:
        label1754:
        label1761:
        label1764:
        for (;;)
        {
          paramAnonymousy = ak.getContext().getString(2131761732);
          break label509;
          label1530:
          if (((bv)localObject6).fvE())
          {
            bc.aCg();
            paramAnonymousy = com.tencent.mm.model.c.azI().arp(((ei)localObject6).field_content);
            paramAnonymousy = String.format(ak.getContext().getString(2131761673), new Object[] { paramAnonymousy.getDisplayName() });
            break label509;
          }
          paramAnonymousy = (y)localObject2;
          if (((bv)localObject6).getType() != -1879048186) {
            break label509;
          }
          paramAnonymousy = ak.getContext().getString(2131761663);
          break label509;
          paramAnonymousy = new s.d();
          localObject1 = (String[])((s.d.a.a)localObject4).HW.toArray(new String[((s.d.a.a)localObject4).HW.size()]);
          localObject2 = ((s.d.a.a)localObject4).HX;
          localObject3 = ((s.d.a.a)localObject4).HR;
          localObject5 = ((s.d.a.a)localObject4).HS;
          localObject6 = ((s.d.a.a)localObject4).HT;
          long l = ((s.d.a.a)localObject4).HV;
          paramAnonymousy.HP = new s.d.a((String[])localObject1, (android.support.v4.app.x)localObject3, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
          break;
          for (;;)
          {
            if (j == 0) {
              break label1764;
            }
            break;
            j = 0;
          }
        }
      }
    };
    AppMethodBeat.o(21156);
  }
  
  public static boolean bHK()
  {
    AppMethodBeat.i(186396);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJu, 1) == 1)
    {
      AppMethodBeat.o(186396);
      return true;
    }
    AppMethodBeat.o(186396);
    return false;
  }
  
  public static boolean bHL()
  {
    AppMethodBeat.i(186397);
    if (((UiModeManager)ak.getContext().getSystemService("uimode")).getCurrentModeType() == 3)
    {
      AppMethodBeat.o(186397);
      return true;
    }
    AppMethodBeat.o(186397);
    return false;
  }
  
  public static boolean bHM()
  {
    AppMethodBeat.i(21157);
    PackageManager localPackageManager = ak.getContext().getPackageManager();
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
    ae.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(21157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a
 * JD-Core Version:    0.7.0.1
 */