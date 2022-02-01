package com.tencent.mm.plugin.auto.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.f.e;
import androidx.core.app.f.e.a;
import androidx.core.app.f.e.a.a;
import androidx.core.app.j;
import androidx.core.app.j.a;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.autogen.a.ae;
import com.tencent.mm.autogen.a.ae.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BroadcastHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

class AutoLogic$1
  extends IListener<ae>
{
  AutoLogic$1(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(260337);
    this.__eventId = ae.class.getName().hashCode();
    AppMethodBeat.o(260337);
  }
  
  private static boolean a(ae paramae)
  {
    AppMethodBeat.i(21154);
    if ((paramae instanceof ae)) {}
    int j;
    for (;;)
    {
      try
      {
        ae.a locala = paramae.hzZ;
        localObject1 = paramae.hzZ.username;
        paramae = paramae.hzZ.title;
        if (a.cUy()) {
          continue;
        }
        paramae = null;
        locala.hAa = paramae;
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        int i;
        Object localObject6;
        label523:
        Log.printErrStackTrace("MicroMsg.auto.AutoLogic", paramae, "", new Object[0]);
        continue;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = paramae;
        continue;
        i -= 1;
        continue;
        paramae = null;
        continue;
      }
      AppMethodBeat.o(21154);
      return false;
      if (!a.cUz())
      {
        Log.i("MicroMsg.auto.AutoLogic", "not open car mode");
        paramae = null;
      }
      else if (!a.cUA())
      {
        Log.i("MicroMsg.auto.AutoLogic", "not install auto app");
        paramae = null;
      }
      else
      {
        localObject2 = b.uVJ;
        b.jX(0L);
        localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
        BroadcastHelper.setIntentPackageName((Intent)localObject2);
        localObject2 = PendingIntent.getBroadcast(MMApplicationContext.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
        localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
        BroadcastHelper.setIntentPackageName((Intent)localObject3);
        localObject4 = PendingIntent.getBroadcast(MMApplicationContext.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
        localObject3 = new j.a("key_voice_reply_text");
        ((j.a)localObject3).bpL = MMApplicationContext.getContext().getString(R.l.app_reply);
        localObject5 = new j(((j.a)localObject3).bpK, ((j.a)localObject3).bpL, ((j.a)localObject3).bpM, ((j.a)localObject3).bpN, ((j.a)localObject3).bpO, ((j.a)localObject3).mExtras, ((j.a)localObject3).bpP);
        localObject3 = new f.e.a.a(paramae);
        ((f.e.a.a)localObject3).bpf = ((PendingIntent)localObject2);
        ((f.e.a.a)localObject3).bpd = ((j)localObject5);
        ((f.e.a.a)localObject3).bpe = ((PendingIntent)localObject4);
        j = com.tencent.mm.k.h.DO((String)localObject1);
        i = j;
        if (j > 10) {
          i = 10;
        }
        bh.bCz();
        localObject4 = c.bzD().fQ((String)localObject1, i);
        i = ((List)localObject4).size() - 1;
        if (i >= 0)
        {
          localObject5 = (cc)((List)localObject4).get(i);
          if (!au.bwE(((fi)localObject5).field_talker)) {
            continue;
          }
          paramae = ((fi)localObject5).field_talker;
          j = br.JG(((fi)localObject5).field_content);
          localObject1 = paramae;
          if (j != -1)
          {
            localObject2 = ((fi)localObject5).field_content.substring(0, j).trim();
            localObject1 = paramae;
            if (localObject2 != null)
            {
              localObject1 = paramae;
              if (((String)localObject2).length() > 0) {
                localObject1 = localObject2;
              }
            }
          }
          bh.bCz();
          localObject6 = c.bzA().JE((String)localObject1);
          localObject2 = aa.b((au)localObject6, (String)localObject1);
          paramae = (ae)localObject2;
          if (!au.bwE((String)localObject1)) {
            continue;
          }
          if (!((az)localObject6).field_username.equals(localObject2))
          {
            paramae = (ae)localObject2;
            if (!Util.isNullOrNil((String)localObject2)) {
              continue;
            }
          }
          paramae = MMApplicationContext.getContext().getString(R.l.gzv);
          continue;
          if (((cc)localObject5).iYk()) {
            paramae = MMApplicationContext.getContext().getString(R.l.gPE);
          }
          for (;;)
          {
            localObject1 = paramae;
            if (paramae == null) {
              localObject1 = MMApplicationContext.getContext().getString(R.l.gPW);
            }
            paramae = (ae)localObject1;
            if (localObject2 != null) {
              paramae = String.format("%s: %s", new Object[] { localObject2, localObject1 });
            }
            if (paramae != null) {
              ((f.e.a.a)localObject3).bpi.add(paramae);
            }
            if (i != 0) {
              break label1739;
            }
            ((f.e.a.a)localObject3).bph = ((cc)localObject5).getCreateTime();
            break label1739;
            if (((cc)localObject5).iYl())
            {
              if ((au.bwE(((fi)localObject5).field_talker)) && (((fi)localObject5).field_isSend != 1))
              {
                j = br.JG(((fi)localObject5).field_content);
                if (j != -1) {
                  paramae = ((fi)localObject5).field_content.substring(j + 1).trim();
                } else {
                  paramae = ((fi)localObject5).field_content;
                }
              }
              else
              {
                paramae = ((fi)localObject5).field_content;
              }
            }
            else if (((cc)localObject5).iYj())
            {
              paramae = MMApplicationContext.getContext().getString(R.l.gPZ);
            }
            else if (((cc)localObject5).dSH())
            {
              paramae = MMApplicationContext.getContext().getString(R.l.gPY);
            }
            else if (((cc)localObject5).dSJ())
            {
              paramae = MMApplicationContext.getContext().getString(R.l.gPV);
            }
            else
            {
              if (((cc)localObject5).fxR())
              {
                paramae = k.b.Hf(((fi)localObject5).field_content);
                if (paramae == null) {
                  break label1746;
                }
              }
              switch (paramae.type)
              {
              case 5: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPp), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 3: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPs), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 6: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPo), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 4: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPw), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 2: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPE), new Object[0]);
                break;
              case 19: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPu), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 24: 
                paramae = MMApplicationContext.getContext().getString(R.l.favorite_wenote_msg);
                break;
              case 15: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPn), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 10: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPt), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 13: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPr), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 20: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPv), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 16: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPz), new Object[] { Util.nullAs(paramae.title, "") });
                break;
              case 8: 
                paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPA), new Object[] { Util.nullAs(paramae.title, "") });
                continue;
                if (((cc)localObject5).jbG())
                {
                  paramae = MMApplicationContext.getContext().getString(R.l.gPB);
                  localObject1 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr();
                  if (localObject1 == null) {
                    break label1724;
                  }
                  paramae = ((com.tencent.mm.pluginsdk.b.d)localObject1).aoe(((fi)localObject5).field_imgPath);
                  if ((paramae == null) || (Util.isNullOrNil(((com.tencent.mm.pluginsdk.b.d)localObject1).aoi(paramae.getMd5())))) {
                    paramae = MMApplicationContext.getContext().getString(R.l.gPB);
                  } else {
                    paramae = "[" + ((com.tencent.mm.pluginsdk.b.d)localObject1).aoi(paramae.getMd5()) + "]";
                  }
                }
                else if (((cc)localObject5).fxT())
                {
                  paramae = MMApplicationContext.getContext().getString(R.l.gPF);
                }
                else
                {
                  if ((!((cc)localObject5).jbx()) && (!((cc)localObject5).jby())) {
                    break label1528;
                  }
                  if (!((fi)localObject5).field_content.equals(cc.adko))
                  {
                    paramae = ((fi)localObject5).field_content;
                    localObject1 = new acn();
                    ((acn)localObject1).ifU.hId = 1;
                    ((acn)localObject1).ifU.content = paramae;
                    ((acn)localObject1).publish();
                    if (((acn)localObject1).ifV.type != 3) {
                      break label1758;
                    }
                    j = 1;
                    break label1751;
                  }
                  paramae = MMApplicationContext.getContext().getString(R.l.gQb);
                }
                break;
              }
            }
          }
        }
      }
    }
    label1724:
    label1739:
    label1746:
    label1751:
    label1758:
    label1761:
    for (;;)
    {
      paramae = MMApplicationContext.getContext().getString(R.l.gQa);
      break label523;
      label1528:
      if (((cc)localObject5).jbB())
      {
        bh.bCz();
        paramae = c.bzD().aLU(((fi)localObject5).field_content);
        paramae = String.format(MMApplicationContext.getContext().getString(R.l.gPz), new Object[] { paramae.getDisplayName() });
        break label523;
      }
      if (((cc)localObject5).getType() == -1879048186)
      {
        paramae = MMApplicationContext.getContext().getString(R.l.gPq);
        break label523;
        paramae = new f.e();
        localObject1 = (String[])((f.e.a.a)localObject3).bpi.toArray(new String[((f.e.a.a)localObject3).bpi.size()]);
        localObject2 = ((f.e.a.a)localObject3).bpj;
        localObject4 = ((f.e.a.a)localObject3).bpd;
        localObject5 = ((f.e.a.a)localObject3).bpe;
        localObject6 = ((f.e.a.a)localObject3).bpf;
        long l = ((f.e.a.a)localObject3).bph;
        paramae.bpb = new f.e.a((String[])localObject1, (j)localObject4, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
        break;
      }
      for (;;)
      {
        if (j == 0) {
          break label1761;
        }
        break;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.model.AutoLogic.1
 * JD-Core Version:    0.7.0.1
 */