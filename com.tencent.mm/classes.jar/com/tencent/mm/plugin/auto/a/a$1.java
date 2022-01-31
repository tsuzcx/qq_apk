package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.s.d;
import android.support.v4.app.s.d.a;
import android.support.v4.app.s.d.a.a;
import android.support.v4.app.x;
import android.support.v4.app.x.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

final class a$1
  extends com.tencent.mm.sdk.b.c<v>
{
  a$1(a parama)
  {
    AppMethodBeat.i(17101);
    this.__eventId = v.class.getName().hashCode();
    AppMethodBeat.o(17101);
  }
  
  private static boolean a(v paramv)
  {
    AppMethodBeat.i(17102);
    if ((paramv instanceof v)) {}
    try
    {
      v.a locala = paramv.cnb;
      localObject1 = paramv.cnb.username;
      paramv = paramv.cnb.title;
      if (a.aSC()) {
        break label58;
      }
      paramv = null;
      locala.cnc = paramv;
    }
    catch (Throwable paramv)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        int i;
        Object localObject6;
        ab.printErrStackTrace("MicroMsg.auto.AutoLogic", paramv, "", new Object[0]);
        continue;
        continue;
        Object localObject1 = null;
        continue;
        continue;
        i -= 1;
        continue;
        paramv = (v)localObject2;
      }
    }
    AppMethodBeat.o(17102);
    return false;
    label58:
    localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
    e.aK((Intent)localObject2);
    localObject2 = PendingIntent.getBroadcast(ah.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
    localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
    e.aK((Intent)localObject3);
    localObject3 = PendingIntent.getBroadcast(ah.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
    localObject4 = new x.a("key_voice_reply_text");
    ((x.a)localObject4).zo = ah.getContext().getString(2131297058);
    localObject5 = new x(((x.a)localObject4).zn, ((x.a)localObject4).zo, ((x.a)localObject4).zp, ((x.a)localObject4).zq, ((x.a)localObject4).mExtras, ((x.a)localObject4).zr);
    localObject4 = new s.d.a.a(paramv);
    ((s.d.a.a)localObject4).yI = ((PendingIntent)localObject2);
    ((s.d.a.a)localObject4).yG = ((x)localObject5);
    ((s.d.a.a)localObject4).yH = ((PendingIntent)localObject3);
    int j = f.ly((String)localObject1);
    i = j;
    if (j > 10) {
      i = 10;
    }
    aw.aaz();
    localObject5 = com.tencent.mm.model.c.YC().cC((String)localObject1, i);
    i = ((List)localObject5).size() - 1;
    if (i >= 0)
    {
      localObject6 = (bi)((List)localObject5).get(i);
      localObject2 = null;
      if (!t.lA(((dd)localObject6).field_talker)) {
        break label1689;
      }
      localObject1 = ((dd)localObject6).field_talker;
      j = bf.pt(((dd)localObject6).field_content);
      paramv = (v)localObject1;
      if (j != -1)
      {
        localObject3 = ((dd)localObject6).field_content.substring(0, j).trim();
        paramv = (v)localObject1;
        if (localObject3 != null)
        {
          paramv = (v)localObject1;
          if (((String)localObject3).length() > 0) {
            paramv = (v)localObject3;
          }
        }
      }
      aw.aaz();
      localObject3 = com.tencent.mm.model.c.YA().arw(paramv);
      localObject1 = s.a((ad)localObject3, paramv);
      if ((!t.lA(paramv)) || ((!((aq)localObject3).field_username.equals(localObject1)) && (!bo.isNullOrNil((String)localObject1)))) {
        break label1695;
      }
      localObject1 = ah.getContext().getString(2131298302);
      if (((bi)localObject6).dvX()) {
        paramv = ah.getContext().getString(2131301931);
      }
      for (;;)
      {
        label464:
        localObject2 = paramv;
        if (paramv == null) {
          localObject2 = ah.getContext().getString(2131301958);
        }
        paramv = (v)localObject2;
        if (localObject1 != null) {
          paramv = String.format("%s: %s", new Object[] { localObject1, localObject2 });
        }
        ((s.d.a.a)localObject4).yM.add(paramv);
        if (i != 0) {
          break label1698;
        }
        ((s.d.a.a)localObject4).yL = ((dd)localObject6).field_createTime;
        break label1698;
        if (((bi)localObject6).isText())
        {
          if ((t.lA(((dd)localObject6).field_talker)) && (((dd)localObject6).field_isSend != 1))
          {
            j = bf.pt(((dd)localObject6).field_content);
            if (j != -1) {
              paramv = ((dd)localObject6).field_content.substring(j + 1).trim();
            } else {
              paramv = ((dd)localObject6).field_content;
            }
          }
          else
          {
            paramv = ((dd)localObject6).field_content;
          }
        }
        else if (((bi)localObject6).dvW())
        {
          paramv = ah.getContext().getString(2131301967);
        }
        else if (((bi)localObject6).byj())
        {
          paramv = ah.getContext().getString(2131301966);
        }
        else if (((bi)localObject6).byk())
        {
          paramv = ah.getContext().getString(2131301957);
        }
        else if (((bi)localObject6).bCn())
        {
          localObject3 = j.b.mY(((dd)localObject6).field_content);
          paramv = (v)localObject2;
          if (localObject3 == null) {}
        }
        else
        {
          switch (((j.b)localObject3).type)
          {
          case 2: 
            paramv = String.format(ah.getContext().getString(2131301931), new Object[0]);
            break;
          case 5: 
            paramv = String.format(ah.getContext().getString(2131301900), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 3: 
            paramv = String.format(ah.getContext().getString(2131301903), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 6: 
            paramv = String.format(ah.getContext().getString(2131301899), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 4: 
            paramv = String.format(ah.getContext().getString(2131301907), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 19: 
            paramv = String.format(ah.getContext().getString(2131301905), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 24: 
            paramv = ah.getContext().getString(2131299859);
            break;
          case 15: 
            paramv = String.format(ah.getContext().getString(2131301898), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 10: 
            paramv = String.format(ah.getContext().getString(2131301904), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 13: 
            paramv = String.format(ah.getContext().getString(2131301902), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 20: 
            paramv = String.format(ah.getContext().getString(2131301906), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 16: 
            paramv = String.format(ah.getContext().getString(2131301911), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            break;
          case 8: 
            paramv = String.format(ah.getContext().getString(2131301912), new Object[] { bo.bf(((j.b)localObject3).title, "") });
            continue;
            if (((bi)localObject6).dxS())
            {
              paramv = ah.getContext().getString(2131301920);
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
              if (localObject2 == null) {
                break label1686;
              }
              paramv = ((com.tencent.mm.pluginsdk.a.d)localObject2).Kt(((dd)localObject6).field_imgPath);
              if ((paramv == null) || (bo.isNullOrNil(((com.tencent.mm.pluginsdk.a.d)localObject2).Kx(paramv.Al())))) {
                paramv = ah.getContext().getString(2131301920);
              } else {
                paramv = "[" + ((com.tencent.mm.pluginsdk.a.d)localObject2).Kx(paramv.Al()) + "]";
              }
            }
            else if (((bi)localObject6).bCp())
            {
              paramv = ah.getContext().getString(2131301932);
            }
            else
            {
              if ((!((bi)localObject6).dxN()) && (!((bi)localObject6).dxO())) {
                break label1486;
              }
              if (!((dd)localObject6).field_content.equals(bi.yOb))
              {
                paramv = ((dd)localObject6).field_content;
                localObject2 = new ux();
                ((ux)localObject2).cLs.cut = 1;
                ((ux)localObject2).cLs.content = paramv;
                com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
                if (((ux)localObject2).cLt.type != 3) {
                  break label1718;
                }
                j = 1;
                break label1711;
              }
              paramv = ah.getContext().getString(2131301969);
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
      paramv = ah.getContext().getString(2131301968);
      break label464;
      label1486:
      if (((bi)localObject6).dxR())
      {
        aw.aaz();
        paramv = com.tencent.mm.model.c.YC().Ty(((dd)localObject6).field_content);
        paramv = String.format(ah.getContext().getString(2131301911), new Object[] { paramv.getDisplayName() });
        break label464;
      }
      paramv = (v)localObject2;
      if (((bi)localObject6).getType() != -1879048186) {
        break label464;
      }
      paramv = ah.getContext().getString(2131301901);
      break label464;
      paramv = new s.d();
      localObject1 = (String[])((s.d.a.a)localObject4).yM.toArray(new String[((s.d.a.a)localObject4).yM.size()]);
      localObject2 = ((s.d.a.a)localObject4).yN;
      localObject3 = ((s.d.a.a)localObject4).yG;
      localObject5 = ((s.d.a.a)localObject4).yH;
      localObject6 = ((s.d.a.a)localObject4).yI;
      long l = ((s.d.a.a)localObject4).yL;
      paramv.yE = new s.d.a((String[])localObject1, (x)localObject3, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a.1
 * JD-Core Version:    0.7.0.1
 */