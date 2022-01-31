package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ac;
import android.support.v4.app.ac.a;
import android.support.v4.app.x.d;
import android.support.v4.app.x.d.a;
import android.support.v4.app.x.d.a.a;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.b;
import com.tencent.mm.h.a.v;
import com.tencent.mm.h.a.v.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.m.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

final class a$1
  extends com.tencent.mm.sdk.b.c<v>
{
  a$1(a parama)
  {
    this.udX = v.class.getName().hashCode();
  }
  
  private static boolean a(v paramv)
  {
    if ((paramv instanceof v)) {}
    label1669:
    label1675:
    label1678:
    label1680:
    label1693:
    label1700:
    label1703:
    for (;;)
    {
      Object localObject2;
      int j;
      int i;
      try
      {
        v.a locala = paramv.bFU;
        localObject1 = paramv.bFU.username;
        paramv = paramv.bFU.title;
        if (!a.ate())
        {
          paramv = null;
          locala.bFV = paramv;
          break label1678;
        }
        localObject2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", (String)localObject1);
        localObject2 = PendingIntent.getBroadcast(ae.getContext(), ((String)localObject1).hashCode(), (Intent)localObject2, 134217728);
        Object localObject3 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", (String)localObject1);
        localObject3 = PendingIntent.getBroadcast(ae.getContext(), ((String)localObject1).hashCode(), (Intent)localObject3, 134217728);
        Object localObject4 = new ac.a("key_voice_reply_text");
        ((ac.a)localObject4).yM = ae.getContext().getString(R.l.app_reply);
        Object localObject5 = new ac(((ac.a)localObject4).yL, ((ac.a)localObject4).yM, ((ac.a)localObject4).yN, ((ac.a)localObject4).yO, ((ac.a)localObject4).mExtras, ((ac.a)localObject4).yP);
        localObject4 = new x.d.a.a(paramv);
        ((x.d.a.a)localObject4).yh = ((PendingIntent)localObject2);
        ((x.d.a.a)localObject4).yf = ((ac)localObject5);
        ((x.d.a.a)localObject4).yg = ((PendingIntent)localObject3);
        j = f.fl((String)localObject1);
        i = j;
        if (j > 10) {
          i = 10;
        }
        au.Hx();
        localObject5 = com.tencent.mm.model.c.Fy().bM((String)localObject1, i);
        i = ((List)localObject5).size() - 1;
        Object localObject6;
        if (i >= 0)
        {
          localObject6 = (bi)((List)localObject5).get(i);
          localObject2 = null;
          if (!s.fn(((cs)localObject6).field_talker)) {
            break label1669;
          }
          localObject1 = ((cs)localObject6).field_talker;
          j = com.tencent.mm.model.bd.iH(((cs)localObject6).field_content);
          paramv = (v)localObject1;
          if (j != -1)
          {
            localObject3 = ((cs)localObject6).field_content.substring(0, j).trim();
            paramv = (v)localObject1;
            if (localObject3 != null)
            {
              paramv = (v)localObject1;
              if (((String)localObject3).length() > 0) {
                paramv = (v)localObject3;
              }
            }
          }
          au.Hx();
          localObject3 = com.tencent.mm.model.c.Fw().abl(paramv);
          localObject1 = r.a((ad)localObject3, paramv);
          if ((!s.fn(paramv)) || ((!((ao)localObject3).field_username.equals(localObject1)) && (!bk.bl((String)localObject1)))) {
            break label1675;
          }
          localObject1 = ae.getContext().getString(R.l.chatting_roominfo_noname);
          if (((bi)localObject6).ctB())
          {
            paramv = ae.getContext().getString(R.l.notification_img_content);
            localObject2 = paramv;
            if (paramv == null) {
              localObject2 = ae.getContext().getString(R.l.notification_simple_tip);
            }
            paramv = (v)localObject2;
            if (localObject1 != null) {
              paramv = String.format("%s: %s", new Object[] { localObject1, localObject2 });
            }
            ((x.d.a.a)localObject4).yk.add(paramv);
            if (i != 0) {
              break label1680;
            }
            ((x.d.a.a)localObject4).yj = ((cs)localObject6).field_createTime;
            break label1680;
          }
          if (((bi)localObject6).isText())
          {
            if ((s.fn(((cs)localObject6).field_talker)) && (((cs)localObject6).field_isSend != 1))
            {
              j = com.tencent.mm.model.bd.iH(((cs)localObject6).field_content);
              if (j != -1)
              {
                paramv = ((cs)localObject6).field_content.substring(j + 1).trim();
                continue;
              }
              paramv = ((cs)localObject6).field_content;
              continue;
            }
            paramv = ((cs)localObject6).field_content;
            continue;
          }
          if (((bi)localObject6).ctA())
          {
            paramv = ae.getContext().getString(R.l.notification_voice_content);
            continue;
          }
          if (((bi)localObject6).aRQ())
          {
            paramv = ae.getContext().getString(R.l.notification_video_content);
            continue;
          }
          if (((bi)localObject6).aRR())
          {
            paramv = ae.getContext().getString(R.l.notification_short_video_content);
            continue;
          }
          if (((bi)localObject6).aVK())
          {
            localObject3 = g.a.gp(((cs)localObject6).field_content);
            paramv = (v)localObject2;
            if (localObject3 == null) {
              continue;
            }
          }
        }
        switch (((g.a)localObject3).type)
        {
        case 2: 
          paramv = String.format(ae.getContext().getString(R.l.notification_img_content), new Object[0]);
          break;
        case 5: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_link_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 3: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_music_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 6: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_file_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 4: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_video_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 19: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_record_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 24: 
          paramv = ae.getContext().getString(R.l.favorite_wenote_msg);
          break;
        case 15: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_emoji_share_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 10: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_product_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 13: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_mall_product_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 20: 
          paramv = String.format(ae.getContext().getString(R.l.notification_app_tv_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 16: 
          paramv = String.format(ae.getContext().getString(R.l.notification_card_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          break;
        case 8: 
          paramv = String.format(ae.getContext().getString(R.l.notification_custom_emoji_content), new Object[] { bk.aM(((g.a)localObject3).title, "") });
          continue;
          if (((bi)localObject6).cvo())
          {
            paramv = ae.getContext().getString(R.l.notification_emoji_content);
            localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
            if (localObject2 != null)
            {
              paramv = ((com.tencent.mm.pluginsdk.a.d)localObject2).As(((cs)localObject6).field_imgPath);
              if ((paramv == null) || (bk.bl(((com.tencent.mm.pluginsdk.a.d)localObject2).Aw(paramv.Wv()))))
              {
                paramv = ae.getContext().getString(R.l.notification_emoji_content);
                continue;
              }
              paramv = "[" + ((com.tencent.mm.pluginsdk.a.d)localObject2).Aw(paramv.Wv()) + "]";
            }
          }
          else
          {
            if (((bi)localObject6).aVM())
            {
              paramv = ae.getContext().getString(R.l.notification_location_content);
              continue;
            }
            if ((((bi)localObject6).cvj()) || (((bi)localObject6).cvk()))
            {
              if (!((cs)localObject6).field_content.equals(bi.uBP))
              {
                paramv = ((cs)localObject6).field_content;
                localObject2 = new td();
                ((td)localObject2).ccJ.bNb = 1;
                ((td)localObject2).ccJ.content = paramv;
                com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
                if (((td)localObject2).ccK.type != 3) {
                  break label1700;
                }
                j = 1;
                break label1693;
              }
              paramv = ae.getContext().getString(R.l.notification_voip_voice_content);
              continue;
              paramv = ae.getContext().getString(R.l.notification_voip_content);
              continue;
            }
            if (((bi)localObject6).cvn())
            {
              au.Hx();
              paramv = com.tencent.mm.model.c.Fy().HN(((cs)localObject6).field_content);
              paramv = String.format(ae.getContext().getString(R.l.notification_card_content), new Object[] { paramv.getDisplayName() });
              continue;
            }
            paramv = (v)localObject2;
            if (((bi)localObject6).getType() != -1879048186) {
              continue;
            }
            paramv = ae.getContext().getString(R.l.notification_app_location_share_content);
            continue;
            paramv = new x.d();
            localObject1 = (String[])((x.d.a.a)localObject4).yk.toArray(new String[((x.d.a.a)localObject4).yk.size()]);
            localObject2 = ((x.d.a.a)localObject4).yl;
            localObject3 = ((x.d.a.a)localObject4).yf;
            localObject5 = ((x.d.a.a)localObject4).yg;
            localObject6 = ((x.d.a.a)localObject4).yh;
            long l = ((x.d.a.a)localObject4).yj;
            paramv.yd = new x.d.a((String[])localObject1, (ac)localObject3, (PendingIntent)localObject5, (PendingIntent)localObject6, new String[] { localObject2 }, l);
            continue;
          }
          continue;
        }
      }
      catch (Throwable paramv)
      {
        y.printErrStackTrace("MicroMsg.auto.AutoLogic", paramv, "", new Object[0]);
      }
      Object localObject1 = null;
      continue;
      continue;
      return false;
      i -= 1;
      continue;
      paramv = (v)localObject2;
      continue;
      for (;;)
      {
        if (j == 0) {
          break label1703;
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