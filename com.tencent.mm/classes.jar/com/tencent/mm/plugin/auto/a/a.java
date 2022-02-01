package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.core.app.e.e;
import androidx.core.app.e.e.a;
import androidx.core.app.e.e.a.a;
import androidx.core.app.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.f.a.ab.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.expt.b.b.a;
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
  IListener rKt;
  
  public a()
  {
    AppMethodBeat.i(21156);
    this.rKt = new IListener()
    {
      private static boolean a(com.tencent.mm.f.a.ab paramAnonymousab)
      {
        AppMethodBeat.i(21154);
        if ((paramAnonymousab instanceof com.tencent.mm.f.a.ab)) {}
        int j;
        for (;;)
        {
          try
          {
            ab.a locala = paramAnonymousab.fvE;
            localObject1 = paramAnonymousab.fvE.username;
            paramAnonymousab = paramAnonymousab.fvE.title;
            if (a.crO()) {
              continue;
            }
            paramAnonymousab = null;
            locala.fvF = paramAnonymousab;
          }
          catch (Throwable paramAnonymousab)
          {
            Object localObject1;
            Object localObject3;
            Object localObject4;
            Object localObject5;
            int i;
            Object localObject6;
            label523:
            Log.printErrStackTrace("MicroMsg.auto.AutoLogic", paramAnonymousab, "", new Object[0]);
            continue;
            continue;
            Object localObject2 = null;
            continue;
            localObject2 = paramAnonymousab;
            continue;
            i -= 1;
            continue;
            paramAnonymousab = null;
            continue;
          }
          AppMethodBeat.o(21154);
          return false;
          if (!a.crP())
          {
            Log.i("MicroMsg.auto.AutoLogic", "not open car mode");
            paramAnonymousab = null;
          }
          else if (!a.crQ())
          {
            Log.i("MicroMsg.auto.AutoLogic", "not install auto app");
            paramAnonymousab = null;
          }
          else
          {
            localObject2 = b.rKw;
            b.HG(0L);
            localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
            BroadcastHelper.setIntentPackageName((Intent)localObject2);
            localObject2 = PendingIntent.getBroadcast(MMApplicationContext.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
            localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
            BroadcastHelper.setIntentPackageName((Intent)localObject3);
            localObject4 = PendingIntent.getBroadcast(MMApplicationContext.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
            localObject3 = new i.a("key_voice_reply_text");
            ((i.a)localObject3).JI = MMApplicationContext.getContext().getString(R.l.app_reply);
            localObject5 = new androidx.core.app.i(((i.a)localObject3).JH, ((i.a)localObject3).JI, ((i.a)localObject3).JJ, ((i.a)localObject3).JK, ((i.a)localObject3).JL, ((i.a)localObject3).mExtras, ((i.a)localObject3).JM);
            localObject3 = new e.e.a.a(paramAnonymousab);
            ((e.e.a.a)localObject3).Jc = ((PendingIntent)localObject2);
            ((e.e.a.a)localObject3).Ja = ((androidx.core.app.i)localObject5);
            ((e.e.a.a)localObject3).Jb = ((PendingIntent)localObject4);
            j = g.Lh((String)localObject1);
            i = j;
            if (j > 10) {
              i = 10;
            }
            bh.beI();
            localObject4 = c.bbO().eX((String)localObject1, i);
            i = ((List)localObject4).size() - 1;
            if (i >= 0)
            {
              localObject5 = (ca)((List)localObject4).get(i);
              if (!com.tencent.mm.model.ab.Lj(((et)localObject5).field_talker)) {
                continue;
              }
              paramAnonymousab = ((et)localObject5).field_talker;
              j = bq.RI(((et)localObject5).field_content);
              localObject1 = paramAnonymousab;
              if (j != -1)
              {
                localObject2 = ((et)localObject5).field_content.substring(0, j).trim();
                localObject1 = paramAnonymousab;
                if (localObject2 != null)
                {
                  localObject1 = paramAnonymousab;
                  if (((String)localObject2).length() > 0) {
                    localObject1 = localObject2;
                  }
                }
              }
              bh.beI();
              localObject6 = c.bbL().RG((String)localObject1);
              localObject2 = aa.b((as)localObject6, (String)localObject1);
              paramAnonymousab = (com.tencent.mm.f.a.ab)localObject2;
              if (!com.tencent.mm.model.ab.Lj((String)localObject1)) {
                continue;
              }
              if (!((ax)localObject6).field_username.equals(localObject2))
              {
                paramAnonymousab = (com.tencent.mm.f.a.ab)localObject2;
                if (!Util.isNullOrNil((String)localObject2)) {
                  continue;
                }
              }
              paramAnonymousab = MMApplicationContext.getContext().getString(R.l.ewS);
              continue;
              if (((ca)localObject5).hwG()) {
                paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNr);
              }
              for (;;)
              {
                localObject1 = paramAnonymousab;
                if (paramAnonymousab == null) {
                  localObject1 = MMApplicationContext.getContext().getString(R.l.eNI);
                }
                paramAnonymousab = (com.tencent.mm.f.a.ab)localObject1;
                if (localObject2 != null) {
                  paramAnonymousab = String.format("%s: %s", new Object[] { localObject2, localObject1 });
                }
                ((e.e.a.a)localObject3).Jf.add(paramAnonymousab);
                if (i != 0) {
                  break label1738;
                }
                ((e.e.a.a)localObject3).Je = ((et)localObject5).field_createTime;
                break label1738;
                if (((ca)localObject5).hwH())
                {
                  if ((com.tencent.mm.model.ab.Lj(((et)localObject5).field_talker)) && (((et)localObject5).field_isSend != 1))
                  {
                    j = bq.RI(((et)localObject5).field_content);
                    if (j != -1) {
                      paramAnonymousab = ((et)localObject5).field_content.substring(j + 1).trim();
                    } else {
                      paramAnonymousab = ((et)localObject5).field_content;
                    }
                  }
                  else
                  {
                    paramAnonymousab = ((et)localObject5).field_content;
                  }
                }
                else if (((ca)localObject5).hwF())
                {
                  paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNL);
                }
                else if (((ca)localObject5).dlR())
                {
                  paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNK);
                }
                else if (((ca)localObject5).dlT())
                {
                  paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNH);
                }
                else
                {
                  if (((ca)localObject5).erk())
                  {
                    paramAnonymousab = k.b.OQ(((et)localObject5).field_content);
                    if (paramAnonymousab == null) {
                      break label1745;
                    }
                  }
                  switch (paramAnonymousab.type)
                  {
                  case 5: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNc), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 3: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNf), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 6: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNb), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 4: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNj), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 2: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNr), new Object[0]);
                    break;
                  case 19: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNh), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 24: 
                    paramAnonymousab = MMApplicationContext.getContext().getString(R.l.favorite_wenote_msg);
                    break;
                  case 15: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNa), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 10: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNg), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 13: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNe), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 20: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNi), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 16: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNm), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    break;
                  case 8: 
                    paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNn), new Object[] { Util.nullAs(paramAnonymousab.title, "") });
                    continue;
                    if (((ca)localObject5).hzB())
                    {
                      paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNo);
                      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                      if (localObject1 == null) {
                        break label1723;
                      }
                      paramAnonymousab = ((com.tencent.mm.pluginsdk.b.d)localObject1).aud(((et)localObject5).field_imgPath);
                      if ((paramAnonymousab == null) || (Util.isNullOrNil(((com.tencent.mm.pluginsdk.b.d)localObject1).auh(paramAnonymousab.getMd5())))) {
                        paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNo);
                      } else {
                        paramAnonymousab = "[" + ((com.tencent.mm.pluginsdk.b.d)localObject1).auh(paramAnonymousab.getMd5()) + "]";
                      }
                    }
                    else if (((ca)localObject5).erm())
                    {
                      paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNs);
                    }
                    else
                    {
                      if ((!((ca)localObject5).hzu()) && (!((ca)localObject5).hzv())) {
                        break label1527;
                      }
                      if (!((et)localObject5).field_content.equals(ca.VGx))
                      {
                        paramAnonymousab = ((et)localObject5).field_content;
                        localObject1 = new aaq();
                        ((aaq)localObject1).fZM.fDn = 1;
                        ((aaq)localObject1).fZM.content = paramAnonymousab;
                        EventCenter.instance.publish((IEvent)localObject1);
                        if (((aaq)localObject1).fZN.type != 3) {
                          break label1757;
                        }
                        j = 1;
                        break label1750;
                      }
                      paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNN);
                    }
                    break;
                  }
                }
              }
            }
          }
        }
        label1723:
        label1738:
        label1745:
        label1750:
        label1757:
        label1760:
        for (;;)
        {
          paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNM);
          break label523;
          label1527:
          if (((ca)localObject5).hzy())
          {
            bh.beI();
            paramAnonymousab = c.bbO().aOU(((et)localObject5).field_content);
            paramAnonymousab = String.format(MMApplicationContext.getContext().getString(R.l.eNm), new Object[] { paramAnonymousab.getDisplayName() });
            break label523;
          }
          if (((ca)localObject5).getType() == -1879048186)
          {
            paramAnonymousab = MMApplicationContext.getContext().getString(R.l.eNd);
            break label523;
            paramAnonymousab = new e.e();
            localObject1 = (String[])((e.e.a.a)localObject3).Jf.toArray(new String[((e.e.a.a)localObject3).Jf.size()]);
            localObject2 = ((e.e.a.a)localObject3).Jg;
            localObject4 = ((e.e.a.a)localObject3).Ja;
            localObject5 = ((e.e.a.a)localObject3).Jb;
            localObject6 = ((e.e.a.a)localObject3).Jc;
            long l = ((e.e.a.a)localObject3).Je;
            paramAnonymousab.IY = new e.e.a((String[])localObject1, (androidx.core.app.i)localObject4, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
            break;
          }
          for (;;)
          {
            if (j == 0) {
              break label1760;
            }
            break;
            j = 0;
          }
        }
      }
    };
    AppMethodBeat.o(21156);
  }
  
  public static boolean crO()
  {
    AppMethodBeat.i(244085);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOG, 1) == 1)
    {
      AppMethodBeat.o(244085);
      return true;
    }
    AppMethodBeat.o(244085);
    return false;
  }
  
  public static boolean crP()
  {
    AppMethodBeat.i(244086);
    if (((UiModeManager)MMApplicationContext.getContext().getSystemService("uimode")).getCurrentModeType() == 3)
    {
      AppMethodBeat.o(244086);
      return true;
    }
    AppMethodBeat.o(244086);
    return false;
  }
  
  public static boolean crQ()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a
 * JD-Core Version:    0.7.0.1
 */