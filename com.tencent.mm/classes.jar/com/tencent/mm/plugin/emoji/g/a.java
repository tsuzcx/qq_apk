package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  implements cf.a
{
  private static void c(int paramInt, ArrayList<agk> paramArrayList)
  {
    AppMethodBeat.i(108730);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      agk localagk = (agk)paramArrayList.next();
      EmojiInfo localEmojiInfo = be.fvc().JfU.aWl(localagk.Md5);
      if (localEmojiInfo == null)
      {
        localEmojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localagk, localEmojiInfo);
        if (paramInt == 1) {
          localEmojiInfo.field_groupId = "capture";
        }
        for (;;)
        {
          be.fvc().JfU.J(localEmojiInfo);
          break;
          localEmojiInfo.field_catalog = EmojiInfo.OAa;
        }
      }
      if (paramInt == 1) {
        localEmojiInfo.field_groupId = "capture";
      }
      for (;;)
      {
        be.fvc().JfU.K(localEmojiInfo);
        break;
        localEmojiInfo.field_catalog = EmojiInfo.OAa;
      }
    }
    AppMethodBeat.o(108730);
  }
  
  public final void a(e.a parama)
  {
    int i = 0;
    AppMethodBeat.i(108729);
    parama = parama.gte;
    if (parama.urJ == 10002)
    {
      parama = z.a(parama.FNI);
      if (bu.isNullOrNil(parama))
      {
        ae.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108729);
        return;
      }
      Object localObject2 = bx.M(parama, "sysmsg");
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        String str = (String)((Map)localObject2).get(".sysmsg.$type");
        if (bu.isNullOrNil(str))
        {
          ae.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
          AppMethodBeat.o(108729);
          return;
        }
        Object localObject1 = bu.cH(com.tencent.mm.bw.b.cm(q.aaH().getBytes()).aaf(16).zr);
        if (str.equalsIgnoreCase("EmojiBackup"))
        {
          i = bu.aSB((String)((Map)localObject2).get(".sysmsg.EmojiBackup.OpCode"));
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmojiBackup.DeviceID");
          ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[] { localObject1, localObject2 });
          if ((!bu.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          localObject1 = b.acK(parama);
          if (i == 1)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(0, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            parama = new ArrayList();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (agk)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  parama.add(((agk)localObject2).Md5);
                }
              }
            }
            k.getEmojiStorageMgr().JfU.hV(parama);
            g.ajR().ajA().set(am.a.IKJ, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
            g.ajR().ajA().set(am.a.IKR, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("EmotionBackup"))
        {
          int j = bu.getInt((String)((Map)localObject2).get(".sysmsg.EmotionBackup.OpCode"), 0);
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmotionBackup.DeviceID");
          if ((!bu.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          parama = b.acL(parama);
          if ((parama == null) || (parama.size() <= 0))
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 1)
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            localObject1 = new ArrayList();
            j = parama.size();
            while (i < j)
            {
              ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a((String)parama.get(i)));
              i += 1;
            }
            k.cih().Q((ArrayList)localObject1);
            k.cih().pMY.ciE();
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 2)
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            k.getEmojiStorageMgr().JfV.aR(parama);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("SelfieEmojiBackup"))
        {
          str = (String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.DeviceID");
          ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", new Object[] { localObject1, str });
          if ((!bu.isNullOrNil(str)) && (str.equalsIgnoreCase((String)localObject1)))
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          i = bu.aSB((String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.OpCode"));
          localObject1 = b.acK(parama);
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(108729);
            return;
          }
          ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((ArrayList)localObject1).size()) });
          if (i == 1)
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(1, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            parama = new ArrayList();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (agk)((Iterator)localObject1).next();
              if (localObject2 != null) {
                parama.add(((agk)localObject2).Md5);
              }
            }
            k.getEmojiStorageMgr().JfU.hW(parama);
            g.ajR().ajA().set(am.a.IKJ, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            g.ajR().ajA().set(am.a.IKS, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        ae.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(108729);
      return;
    }
    ae.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.urJ) });
    AppMethodBeat.o(108729);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */