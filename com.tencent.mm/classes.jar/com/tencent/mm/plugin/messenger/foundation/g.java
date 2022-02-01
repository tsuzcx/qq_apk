package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public final class g
  implements w
{
  public final void a(zu paramzu, byte[] paramArrayOfByte, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.z paramz)
  {
    AppMethodBeat.i(116929);
    switch (paramzu.FYU)
    {
    default: 
      AppMethodBeat.o(116929);
      return;
    }
    paramz = (caq)new caq().parseFrom(paramArrayOfByte);
    com.tencent.mm.kernel.g.ajC().ajl().get(2, null);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    ad.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramz.GVj), Integer.valueOf(paramz.nDG), Integer.valueOf(paramz.Fsi), Integer.valueOf(paramz.GVq) });
    paramArrayOfByte = com.tencent.mm.platformtools.z.a(paramz.GbY);
    Object localObject = com.tencent.mm.platformtools.z.a(paramz.GKC);
    String str1 = com.tencent.mm.platformtools.z.a(paramz.GVk);
    String str2 = com.tencent.mm.platformtools.z.a(paramz.GVl);
    int i = paramz.Fsf;
    paramzu = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramArrayOfByte);
    if ((paramzu == null) || (paramzu.field_username == null) || (!paramzu.field_username.equals(paramArrayOfByte))) {
      paramzu = new am(paramArrayOfByte);
    }
    label1038:
    label1182:
    label2083:
    for (;;)
    {
      paramzu.sQ(paramz.jdh);
      paramzu.sT((String)localObject);
      paramzu.tq(RegionCodeDecoder.bf(paramz.jdl, paramz.jdd, paramz.jde));
      paramzu.kf(paramz.jdc);
      paramzu.tk(paramz.jdf);
      paramzu.ka(paramz.GNY);
      paramzu.to(paramz.GNW);
      paramzu.sW(paramz.GNX);
      paramzu.setUin(i);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().af(paramzu);
      localai.set(2, paramArrayOfByte);
      localai.set(4, localObject);
      localai.set(5, str1);
      localai.set(6, str2);
      localai.set(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramz.nDG;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramzu = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramzu = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramzu;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramzu + ", email-verified";
      }
      paramzu = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramzu = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramzu;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramzu + ", hide-qq-search";
      }
      paramzu = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramzu = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramzu;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramzu + ", need-verify";
      }
      paramzu = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramzu = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramzu;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramzu + ", no-qq-promote";
      }
      paramzu = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramzu = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramzu;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramzu + ", hide-mobile_search";
      }
      paramzu = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramzu = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramzu;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramzu + ", bind but not upload";
      }
      ad.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localai.set(7, Integer.valueOf(paramz.nDG));
      if (paramz.jdg != 0)
      {
        paramzu = new com.tencent.mm.model.bt();
        paramzu.ePt = 1;
        paramzu.ePk = paramz.jdc;
        paramzu.signature = paramz.jdf;
        paramzu.countryCode = paramz.jdl;
        paramzu.provinceCode = paramz.jdd;
        paramzu.cityCode = paramz.jde;
        paramzu.ePy = paramz.GNW;
        ad.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramzu.ePy + " nickName :" + paramz.GNX);
        com.tencent.mm.model.bt.a(paramzu);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramz.Fsi;
      paramzu = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramzu = paramzu + ", QQMAIL_UNINSTALL";
        label1010:
        if ((i & 0x2) == 0) {
          break label1939;
        }
        paramzu = paramzu + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1963;
        }
        paramzu = paramzu + ", FM_UNINSTALL";
        label1066:
        if ((i & 0x8) == 0) {
          break label1987;
        }
        paramzu = paramzu + ", WEIBO_UNINSTALL";
        label1095:
        if ((i & 0x10) == 0) {
          break label2011;
        }
        paramzu = paramzu + ", MEDIANOTE_UNINSTALL";
        label1124:
        if ((i & 0x20) == 0) {
          break label2035;
        }
        paramzu = paramzu + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2059;
        }
        paramzu = paramzu + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2083;
        }
        paramzu = paramzu + ", QSYNC_UNISTALL";
        label1212:
        if ((i & 0x100) == 0) {
          break label2107;
        }
        paramzu = paramzu + ", SHAKE_UNISTALL";
        label1242:
        if ((i & 0x200) == 0) {
          break label2131;
        }
        paramzu = paramzu + ", LBS_UNISTALL";
        label1272:
        if ((i & 0x400) == 0) {
          break label2155;
        }
        paramzu = paramzu + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2179;
        }
        paramzu = paramzu + ",CHECKQQF_UNINSTALL";
        label1332:
        if ((i & 0x8000) == 0) {
          break label2203;
        }
        paramzu = paramzu + ",MM_FEEDSAPP_UNINSTALL";
        label1362:
        ad.i("MicroMsg.UserInfoSyncExtension", paramzu);
        localai.set(34, Integer.valueOf(paramz.Fsi));
        if (1 != paramz.GUL.GcX) {
          break label2227;
        }
      }
      label1963:
      label2227:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localai.set(8200, Boolean.valueOf(com.tencent.mm.sdk.platformtools.bt.a(Boolean.valueOf(paramBoolean), false)));
        localai.set(8201, Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.a(Integer.valueOf(paramz.GUL.GcY.Gdb), 22)));
        localai.set(8208, Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.a(Integer.valueOf(paramz.GUL.GcY.Gdc), 8)));
        localai.set(66049, Integer.valueOf(paramz.GNU));
        localai.set(66050, paramz.GNV);
        localai.set(40, Integer.valueOf(paramz.GVq));
        az.hFS.aM("last_login_use_voice", paramz.GVq);
        localai.set(41, Integer.valueOf(paramz.GNY));
        localai.set(43, paramz.GNX);
        ad.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramz.GVq + " WeiboFlag:" + paramz.GNY);
        localai.set(868518889, Integer.valueOf(paramz.GVa));
        ad.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramz.GVa);
        localai.set(42, paramz.jdh);
        ad.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramz.Ggd + " username:" + paramz.Gge);
        localai.set(65825, paramz.Ggd);
        localai.set(65826, paramz.Gge);
        ad.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramz.jdi);
        ad.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramz.jdj);
        ad.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramz.jdk);
        paramzu = com.tencent.mm.sdk.platformtools.bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(65830, null));
        if ((paramzu == null) || (paramzu.length() == 0))
        {
          paramzu = paramz.GVt;
          if ((paramzu != null) && (paramzu.length() > 0)) {
            com.tencent.mm.kernel.g.ajC().ajl().set(65830, paramzu);
          }
        }
        aa.b(1, paramz);
        break;
        paramzu = paramzu + ", QQMAIL_INSTALL";
        break label1010;
        paramzu = paramzu + ", PM_INSTALL";
        break label1038;
        paramzu = paramzu + ", FM_INSTALL";
        break label1066;
        label1987:
        paramzu = paramzu + ", WEIBO_INSTALL";
        break label1095;
        label2011:
        paramzu = paramzu + ", MEDIANOTE_INSTALL";
        break label1124;
        label2035:
        paramzu = paramzu + ", QMSG_INSTALL";
        break label1153;
        paramzu = paramzu + ", BOTTLE_INSTALL";
        break label1182;
        paramzu = paramzu + ", QSYNC_INSTALL";
        break label1212;
        label2107:
        paramzu = paramzu + ", SHAKE_INSTALL";
        break label1242;
        label2131:
        paramzu = paramzu + ", LBS_INSTALL";
        break label1272;
        label2155:
        paramzu = paramzu + ", BOTTLE_CHART_INSTALL";
        break label1302;
        paramzu = paramzu + ",CHECKQQF_INSTALL";
        break label1332;
        paramzu = paramzu + ",MM_FEEDSAPP_INSTALL";
        break label1362;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */