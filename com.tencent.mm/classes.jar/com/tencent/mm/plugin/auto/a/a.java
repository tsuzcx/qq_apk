package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.s.d;
import android.support.v4.app.s.d.a;
import android.support.v4.app.s.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.m.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public final class a
{
  com.tencent.mm.sdk.b.c mpM;
  
  public a()
  {
    AppMethodBeat.i(21156);
    this.mpM = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(com.tencent.mm.g.a.x paramAnonymousx)
      {
        AppMethodBeat.i(21154);
        if ((paramAnonymousx instanceof com.tencent.mm.g.a.x)) {}
        try
        {
          com.tencent.mm.g.a.x.a locala = paramAnonymousx.dbP;
          localObject1 = paramAnonymousx.dbP.username;
          paramAnonymousx = paramAnonymousx.dbP.title;
          if (a.bvK()) {
            break label58;
          }
          paramAnonymousx = null;
          locala.dbQ = paramAnonymousx;
        }
        catch (Throwable paramAnonymousx)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            Object localObject4;
            Object localObject5;
            int i;
            Object localObject6;
            ad.printErrStackTrace("MicroMsg.auto.AutoLogic", paramAnonymousx, "", new Object[0]);
            continue;
            continue;
            Object localObject1 = null;
            continue;
            continue;
            i -= 1;
            continue;
            paramAnonymousx = (com.tencent.mm.g.a.x)localObject2;
          }
        }
        AppMethodBeat.o(21154);
        return false;
        label58:
        localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
        com.tencent.mm.sdk.platformtools.g.bd((Intent)localObject2);
        localObject2 = PendingIntent.getBroadcast(aj.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
        localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
        com.tencent.mm.sdk.platformtools.g.bd((Intent)localObject3);
        localObject3 = PendingIntent.getBroadcast(aj.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
        localObject4 = new android.support.v4.app.x.a("key_voice_reply_text");
        ((android.support.v4.app.x.a)localObject4).FI = aj.getContext().getString(2131755875);
        localObject5 = new android.support.v4.app.x(((android.support.v4.app.x.a)localObject4).FH, ((android.support.v4.app.x.a)localObject4).FI, ((android.support.v4.app.x.a)localObject4).FJ, ((android.support.v4.app.x.a)localObject4).FK, ((android.support.v4.app.x.a)localObject4).mExtras, ((android.support.v4.app.x.a)localObject4).FL);
        localObject4 = new s.d.a.a(paramAnonymousx);
        ((s.d.a.a)localObject4).Fe = ((PendingIntent)localObject2);
        ((s.d.a.a)localObject4).Fc = ((android.support.v4.app.x)localObject5);
        ((s.d.a.a)localObject4).Fd = ((PendingIntent)localObject3);
        int j = f.pD((String)localObject1);
        i = j;
        if (j > 10) {
          i = 10;
        }
        az.arV();
        localObject5 = com.tencent.mm.model.c.apO().dE((String)localObject1, i);
        i = ((List)localObject5).size() - 1;
        if (i >= 0)
        {
          localObject6 = (bl)((List)localObject5).get(i);
          localObject2 = null;
          if (!w.pF(((du)localObject6).field_talker)) {
            break label1689;
          }
          localObject1 = ((du)localObject6).field_talker;
          j = bi.uc(((du)localObject6).field_content);
          paramAnonymousx = (com.tencent.mm.g.a.x)localObject1;
          if (j != -1)
          {
            localObject3 = ((du)localObject6).field_content.substring(0, j).trim();
            paramAnonymousx = (com.tencent.mm.g.a.x)localObject1;
            if (localObject3 != null)
            {
              paramAnonymousx = (com.tencent.mm.g.a.x)localObject1;
              if (((String)localObject3).length() > 0) {
                paramAnonymousx = (com.tencent.mm.g.a.x)localObject3;
              }
            }
          }
          az.arV();
          localObject3 = com.tencent.mm.model.c.apM().aHY(paramAnonymousx);
          localObject1 = v.b((af)localObject3, paramAnonymousx);
          if ((!w.pF(paramAnonymousx)) || ((!((au)localObject3).field_username.equals(localObject1)) && (!bt.isNullOrNil((String)localObject1)))) {
            break label1695;
          }
          localObject1 = aj.getContext().getString(2131757293);
          if (((bl)localObject6).eJO()) {
            paramAnonymousx = aj.getContext().getString(2131761693);
          }
          for (;;)
          {
            label464:
            localObject2 = paramAnonymousx;
            if (paramAnonymousx == null) {
              localObject2 = aj.getContext().getString(2131761720);
            }
            paramAnonymousx = (com.tencent.mm.g.a.x)localObject2;
            if (localObject1 != null) {
              paramAnonymousx = String.format("%s: %s", new Object[] { localObject1, localObject2 });
            }
            ((s.d.a.a)localObject4).Fh.add(paramAnonymousx);
            if (i != 0) {
              break label1698;
            }
            ((s.d.a.a)localObject4).Fg = ((du)localObject6).field_createTime;
            break label1698;
            if (((bl)localObject6).isText())
            {
              if ((w.pF(((du)localObject6).field_talker)) && (((du)localObject6).field_isSend != 1))
              {
                j = bi.uc(((du)localObject6).field_content);
                if (j != -1) {
                  paramAnonymousx = ((du)localObject6).field_content.substring(j + 1).trim();
                } else {
                  paramAnonymousx = ((du)localObject6).field_content;
                }
              }
              else
              {
                paramAnonymousx = ((du)localObject6).field_content;
              }
            }
            else if (((bl)localObject6).eJN())
            {
              paramAnonymousx = aj.getContext().getString(2131761729);
            }
            else if (((bl)localObject6).cjM())
            {
              paramAnonymousx = aj.getContext().getString(2131761728);
            }
            else if (((bl)localObject6).cjO())
            {
              paramAnonymousx = aj.getContext().getString(2131761719);
            }
            else if (((bl)localObject6).cxB())
            {
              localObject3 = k.b.rx(((du)localObject6).field_content);
              paramAnonymousx = (com.tencent.mm.g.a.x)localObject2;
              if (localObject3 == null) {}
            }
            else
            {
              switch (((k.b)localObject3).type)
              {
              case 2: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761693), new Object[0]);
                break;
              case 5: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761662), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 3: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761665), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 6: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761661), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 4: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761669), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 19: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761667), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 24: 
                paramAnonymousx = aj.getContext().getString(2131759036);
                break;
              case 15: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761660), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 10: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761666), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 13: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761664), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 20: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761668), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 16: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761673), new Object[] { bt.by(((k.b)localObject3).title, "") });
                break;
              case 8: 
                paramAnonymousx = String.format(aj.getContext().getString(2131761674), new Object[] { bt.by(((k.b)localObject3).title, "") });
                continue;
                if (((bl)localObject6).eLY())
                {
                  paramAnonymousx = aj.getContext().getString(2131761682);
                  localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                  if (localObject2 == null) {
                    break label1686;
                  }
                  paramAnonymousx = ((com.tencent.mm.pluginsdk.a.d)localObject2).Tz(((du)localObject6).field_imgPath);
                  if ((paramAnonymousx == null) || (bt.isNullOrNil(((com.tencent.mm.pluginsdk.a.d)localObject2).TD(paramAnonymousx.JS())))) {
                    paramAnonymousx = aj.getContext().getString(2131761682);
                  } else {
                    paramAnonymousx = "[" + ((com.tencent.mm.pluginsdk.a.d)localObject2).TD(paramAnonymousx.JS()) + "]";
                  }
                }
                else if (((bl)localObject6).cxD())
                {
                  paramAnonymousx = aj.getContext().getString(2131761694);
                }
                else
                {
                  if ((!((bl)localObject6).eLT()) && (!((bl)localObject6).eLU())) {
                    break label1486;
                  }
                  if (!((du)localObject6).field_content.equals(bl.FzM))
                  {
                    paramAnonymousx = ((du)localObject6).field_content;
                    localObject2 = new ww();
                    ((ww)localObject2).dCp.djq = 1;
                    ((ww)localObject2).dCp.content = paramAnonymousx;
                    com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
                    if (((ww)localObject2).dCq.type != 3) {
                      break label1718;
                    }
                    j = 1;
                    break label1711;
                  }
                  paramAnonymousx = aj.getContext().getString(2131761733);
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
          paramAnonymousx = aj.getContext().getString(2131761732);
          break label464;
          label1486:
          if (((bl)localObject6).eLX())
          {
            az.arV();
            paramAnonymousx = com.tencent.mm.model.c.apO().agC(((du)localObject6).field_content);
            paramAnonymousx = String.format(aj.getContext().getString(2131761673), new Object[] { paramAnonymousx.getDisplayName() });
            break label464;
          }
          paramAnonymousx = (com.tencent.mm.g.a.x)localObject2;
          if (((bl)localObject6).getType() != -1879048186) {
            break label464;
          }
          paramAnonymousx = aj.getContext().getString(2131761663);
          break label464;
          paramAnonymousx = new s.d();
          localObject1 = (String[])((s.d.a.a)localObject4).Fh.toArray(new String[((s.d.a.a)localObject4).Fh.size()]);
          localObject2 = ((s.d.a.a)localObject4).Fi;
          localObject3 = ((s.d.a.a)localObject4).Fc;
          localObject5 = ((s.d.a.a)localObject4).Fd;
          localObject6 = ((s.d.a.a)localObject4).Fe;
          long l = ((s.d.a.a)localObject4).Fg;
          paramAnonymousx.Fa = new s.d.a((String[])localObject1, (android.support.v4.app.x)localObject3, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
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
  
  static boolean bvK()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a
 * JD-Core Version:    0.7.0.1
 */