package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements bx.a
{
  public final void a(e.a parama)
  {
    parama = parama.dBs;
    if (parama.kSW == 10002)
    {
      parama = aa.a(parama.svH);
      if (bk.bl(parama)) {
        y.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
      }
      Object localObject3;
      int i;
      label396:
      do
      {
        do
        {
          return;
          localObject2 = bn.s(parama, "sysmsg");
        } while ((localObject2 == null) || (((Map)localObject2).size() <= 0));
        localObject3 = (String)((Map)localObject2).get(".sysmsg.$type");
        Object localObject1 = bk.bG(com.tencent.mm.bv.b.bk(q.zg().getBytes()).EB(16).oY);
        int j;
        if ((!bk.bl((String)localObject3)) && (((String)localObject3).equalsIgnoreCase("EmojiBackup")))
        {
          i = Integer.valueOf((String)((Map)localObject2).get(".sysmsg.EmojiBackup.OpCode")).intValue();
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmojiBackup.DeviceID");
          y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[] { localObject1, localObject2 });
          if ((!bk.bl((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            return;
          }
          parama = b.AS(parama);
          if (i == 1)
          {
            if ((parama == null) || (parama.size() <= 0))
            {
              y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              return;
            }
            y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            localObject1 = new ArrayList();
            j = parama.size();
            i = 0;
            if (i < j)
            {
              localObject2 = (ut)parama.get(i);
              if (localObject2 != null)
              {
                localObject3 = i.getEmojiStorageMgr().uBb.acC(((ut)localObject2).jnU);
                if ((localObject3 != null) && (((EmojiInfo)localObject3).cwz()) && (((EmojiInfo)localObject3).field_catalog == EmojiInfo.uCZ)) {
                  break label396;
                }
                ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a(((ut)localObject2).jnU, ((ut)localObject2).kSC, ((ut)localObject2).mQp, ((ut)localObject2).sRs, ((ut)localObject2).sRt, ((ut)localObject2).sRu, ((ut)localObject2).syc, ((ut)localObject2).sRv, ((ut)localObject2).sRw, ((ut)localObject2).sRx, ((ut)localObject2).jnN));
              }
              for (;;)
              {
                i += 1;
                break;
                y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "md5:%s not need to download", new Object[] { ((ut)localObject2).jnU });
              }
            }
            if (((ArrayList)localObject1).size() > 0)
            {
              i.aHQ().u((ArrayList)localObject1);
              i.aHQ().jan.aIn();
            }
          }
          for (;;)
          {
            g.DP().Dz().c(ac.a.uod, Boolean.valueOf(true));
            return;
            if (i == 2)
            {
              if ((parama == null) || (parama.size() <= 0))
              {
                y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                return;
              }
              localObject1 = new ArrayList();
              if ((parama != null) && (parama.size() > 0))
              {
                parama = parama.iterator();
                while (parama.hasNext())
                {
                  localObject2 = (ut)parama.next();
                  if (localObject2 != null) {
                    ((ArrayList)localObject1).add(((ut)localObject2).jnU);
                  }
                }
              }
              i.getEmojiStorageMgr().uBb.dI((List)localObject1);
              g.DP().Dz().c(ac.a.unV, Boolean.valueOf(false));
            }
            else if (i == 3)
            {
              y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
              g.DP().Dz().c(ac.a.uog, Long.valueOf(0L));
            }
          }
        }
        if ((bk.bl((String)localObject3)) || (!((String)localObject3).equalsIgnoreCase("EmotionBackup"))) {
          break;
        }
        i = Integer.valueOf((String)((Map)localObject2).get(".sysmsg.EmotionBackup.OpCode")).intValue();
        Object localObject2 = (String)((Map)localObject2).get(".sysmsg.EmotionBackup.DeviceID");
        if ((!bk.bl((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
        {
          y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
          return;
        }
        parama = b.AT(parama);
        if ((parama == null) || (parama.size() <= 0))
        {
          y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
          return;
        }
        if (i == 1)
        {
          y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
          localObject1 = new ArrayList();
          j = parama.size();
          i = 0;
          while (i < j)
          {
            ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b((String)parama.get(i)));
            i += 1;
          }
          i.aHQ().v((ArrayList)localObject1);
          i.aHQ().jan.aIn();
          return;
        }
      } while (i != 2);
      y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
      i.getEmojiStorageMgr().uBc.ae(parama);
      return;
      y.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :" + (String)localObject3);
      return;
    }
    y.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.kSW) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */