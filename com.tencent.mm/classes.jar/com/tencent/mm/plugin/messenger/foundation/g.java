package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ay;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public final class g
  implements u
{
  public final void a(xv paramxv, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(116929);
    switch (paramxv.ErL)
    {
    default: 
      AppMethodBeat.o(116929);
      return;
    }
    paramx = (bwa)new bwa().parseFrom(paramArrayOfByte);
    com.tencent.mm.kernel.g.agR().agA().get(2, null);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    ac.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramx.FlA), Integer.valueOf(paramx.ndj), Integer.valueOf(paramx.DNd), Integer.valueOf(paramx.FlH) });
    paramArrayOfByte = z.a(paramx.EuE);
    Object localObject = z.a(paramx.Fbd);
    String str1 = z.a(paramx.FlB);
    String str2 = z.a(paramx.FlC);
    int i = paramx.DNa;
    paramxv = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramArrayOfByte);
    if ((paramxv == null) || (paramxv.field_username == null) || (!paramxv.field_username.equals(paramArrayOfByte))) {
      paramxv = new ai(paramArrayOfByte);
    }
    label1038:
    label1182:
    label2083:
    for (;;)
    {
      paramxv.qg(paramx.iJY);
      paramxv.qj((String)localObject);
      paramxv.qG(RegionCodeDecoder.aW(paramx.iKc, paramx.iJU, paramx.iJV));
      paramxv.jH(paramx.iJT);
      paramxv.qA(paramx.iJW);
      paramxv.jC(paramx.Feu);
      paramxv.qE(paramx.Fes);
      paramxv.qm(paramx.Fet);
      paramxv.setUin(i);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().af(paramxv);
      localae.set(2, paramArrayOfByte);
      localae.set(4, localObject);
      localae.set(5, str1);
      localae.set(6, str2);
      localae.set(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramx.ndj;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramxv = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramxv = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramxv;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramxv + ", email-verified";
      }
      paramxv = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramxv = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramxv;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramxv + ", hide-qq-search";
      }
      paramxv = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramxv = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramxv;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramxv + ", need-verify";
      }
      paramxv = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramxv = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramxv;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramxv + ", no-qq-promote";
      }
      paramxv = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramxv = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramxv;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramxv + ", hide-mobile_search";
      }
      paramxv = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramxv = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramxv;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramxv + ", bind but not upload";
      }
      ac.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localae.set(7, Integer.valueOf(paramx.ndj));
      if (paramx.iJX != 0)
      {
        paramxv = new com.tencent.mm.model.bs();
        paramxv.exU = 1;
        paramxv.exL = paramx.iJT;
        paramxv.signature = paramx.iJW;
        paramxv.countryCode = paramx.iKc;
        paramxv.provinceCode = paramx.iJU;
        paramxv.cityCode = paramx.iJV;
        paramxv.exZ = paramx.Fes;
        ac.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramxv.exZ + " nickName :" + paramx.Fet);
        com.tencent.mm.model.bs.a(paramxv);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramx.DNd;
      paramxv = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramxv = paramxv + ", QQMAIL_UNINSTALL";
        label1010:
        if ((i & 0x2) == 0) {
          break label1939;
        }
        paramxv = paramxv + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1963;
        }
        paramxv = paramxv + ", FM_UNINSTALL";
        label1066:
        if ((i & 0x8) == 0) {
          break label1987;
        }
        paramxv = paramxv + ", WEIBO_UNINSTALL";
        label1095:
        if ((i & 0x10) == 0) {
          break label2011;
        }
        paramxv = paramxv + ", MEDIANOTE_UNINSTALL";
        label1124:
        if ((i & 0x20) == 0) {
          break label2035;
        }
        paramxv = paramxv + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2059;
        }
        paramxv = paramxv + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2083;
        }
        paramxv = paramxv + ", QSYNC_UNISTALL";
        label1212:
        if ((i & 0x100) == 0) {
          break label2107;
        }
        paramxv = paramxv + ", SHAKE_UNISTALL";
        label1242:
        if ((i & 0x200) == 0) {
          break label2131;
        }
        paramxv = paramxv + ", LBS_UNISTALL";
        label1272:
        if ((i & 0x400) == 0) {
          break label2155;
        }
        paramxv = paramxv + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2179;
        }
        paramxv = paramxv + ",CHECKQQF_UNINSTALL";
        label1332:
        if ((i & 0x8000) == 0) {
          break label2203;
        }
        paramxv = paramxv + ",MM_FEEDSAPP_UNINSTALL";
        label1362:
        ac.i("MicroMsg.UserInfoSyncExtension", paramxv);
        localae.set(34, Integer.valueOf(paramx.DNd));
        if (1 != paramx.Fld.EvB) {
          break label2227;
        }
      }
      label1963:
      label2227:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localae.set(8200, Boolean.valueOf(com.tencent.mm.sdk.platformtools.bs.a(Boolean.valueOf(paramBoolean), false)));
        localae.set(8201, Integer.valueOf(com.tencent.mm.sdk.platformtools.bs.a(Integer.valueOf(paramx.Fld.EvC.EvF), 22)));
        localae.set(8208, Integer.valueOf(com.tencent.mm.sdk.platformtools.bs.a(Integer.valueOf(paramx.Fld.EvC.EvG), 8)));
        localae.set(66049, Integer.valueOf(paramx.Feq));
        localae.set(66050, paramx.Fer);
        localae.set(40, Integer.valueOf(paramx.FlH));
        ay.hnA.aL("last_login_use_voice", paramx.FlH);
        localae.set(41, Integer.valueOf(paramx.Feu));
        localae.set(43, paramx.Fet);
        ac.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramx.FlH + " WeiboFlag:" + paramx.Feu);
        localae.set(868518889, Integer.valueOf(paramx.Flr));
        ac.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramx.Flr);
        localae.set(42, paramx.iJY);
        ac.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramx.Eyr + " username:" + paramx.Eys);
        localae.set(65825, paramx.Eyr);
        localae.set(65826, paramx.Eys);
        ac.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramx.iJZ);
        ac.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramx.iKa);
        ac.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramx.iKb);
        paramxv = com.tencent.mm.sdk.platformtools.bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(65830, null));
        if ((paramxv == null) || (paramxv.length() == 0))
        {
          paramxv = paramx.FlK;
          if ((paramxv != null) && (paramxv.length() > 0)) {
            com.tencent.mm.kernel.g.agR().agA().set(65830, paramxv);
          }
        }
        y.b(1, paramx);
        break;
        paramxv = paramxv + ", QQMAIL_INSTALL";
        break label1010;
        paramxv = paramxv + ", PM_INSTALL";
        break label1038;
        paramxv = paramxv + ", FM_INSTALL";
        break label1066;
        label1987:
        paramxv = paramxv + ", WEIBO_INSTALL";
        break label1095;
        label2011:
        paramxv = paramxv + ", MEDIANOTE_INSTALL";
        break label1124;
        label2035:
        paramxv = paramxv + ", QMSG_INSTALL";
        break label1153;
        paramxv = paramxv + ", BOTTLE_INSTALL";
        break label1182;
        paramxv = paramxv + ", QSYNC_INSTALL";
        break label1212;
        label2107:
        paramxv = paramxv + ", SHAKE_INSTALL";
        break label1242;
        label2131:
        paramxv = paramxv + ", LBS_INSTALL";
        break label1272;
        label2155:
        paramxv = paramxv + ", BOTTLE_CHART_INSTALL";
        break label1302;
        paramxv = paramxv + ",CHECKQQF_INSTALL";
        break label1332;
        paramxv = paramxv + ",MM_FEEDSAPP_INSTALL";
        break label1362;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */