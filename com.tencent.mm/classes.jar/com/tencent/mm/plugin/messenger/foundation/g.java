package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bv;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class g
  implements x
{
  public final void a(zx paramzx, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(116929);
    switch (paramzx.Gru)
    {
    default: 
      AppMethodBeat.o(116929);
      return;
    }
    paramaa = (cbk)new cbk().parseFrom(paramArrayOfByte);
    com.tencent.mm.kernel.g.ajR().ajA().get(2, null);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    ae.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramaa.HoK), Integer.valueOf(paramaa.nJb), Integer.valueOf(paramaa.FKG), Integer.valueOf(paramaa.HoR) });
    paramArrayOfByte = z.a(paramaa.GuF);
    Object localObject = z.a(paramaa.Hed);
    String str1 = z.a(paramaa.HoL);
    String str2 = z.a(paramaa.HoM);
    int i = paramaa.FKD;
    paramzx = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramArrayOfByte);
    if ((paramzx == null) || (paramzx.field_username == null) || (!paramzx.field_username.equals(paramArrayOfByte))) {
      paramzx = new an(paramArrayOfByte);
    }
    label1038:
    label1182:
    label2083:
    for (;;)
    {
      paramzx.tl(paramaa.jga);
      paramzx.to((String)localObject);
      paramzx.tL(RegionCodeDecoder.bg(paramaa.jge, paramaa.jfW, paramaa.jfX));
      paramzx.kh(paramaa.jfV);
      paramzx.tF(paramaa.jfY);
      paramzx.kc(paramaa.Hhy);
      paramzx.tJ(paramaa.Hhw);
      paramzx.tr(paramaa.Hhx);
      paramzx.setUin(i);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().am(paramzx);
      localaj.set(2, paramArrayOfByte);
      localaj.set(4, localObject);
      localaj.set(5, str1);
      localaj.set(6, str2);
      localaj.set(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramaa.nJb;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramzx = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramzx = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramzx;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramzx + ", email-verified";
      }
      paramzx = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramzx = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramzx;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramzx + ", hide-qq-search";
      }
      paramzx = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramzx = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramzx;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramzx + ", need-verify";
      }
      paramzx = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramzx = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramzx;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramzx + ", no-qq-promote";
      }
      paramzx = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramzx = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramzx;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramzx + ", hide-mobile_search";
      }
      paramzx = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramzx = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramzx;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramzx + ", bind but not upload";
      }
      ae.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localaj.set(7, Integer.valueOf(paramaa.nJb));
      if (paramaa.jfZ != 0)
      {
        paramzx = new bv();
        paramzx.eRe = 1;
        paramzx.eQV = paramaa.jfV;
        paramzx.signature = paramaa.jfY;
        paramzx.countryCode = paramaa.jge;
        paramzx.provinceCode = paramaa.jfW;
        paramzx.cityCode = paramaa.jfX;
        paramzx.eRj = paramaa.Hhw;
        ae.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramzx.eRj + " nickName :" + paramaa.Hhx);
        bv.a(paramzx);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramaa.FKG;
      paramzx = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramzx = paramzx + ", QQMAIL_UNINSTALL";
        label1010:
        if ((i & 0x2) == 0) {
          break label1939;
        }
        paramzx = paramzx + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1963;
        }
        paramzx = paramzx + ", FM_UNINSTALL";
        label1066:
        if ((i & 0x8) == 0) {
          break label1987;
        }
        paramzx = paramzx + ", WEIBO_UNINSTALL";
        label1095:
        if ((i & 0x10) == 0) {
          break label2011;
        }
        paramzx = paramzx + ", MEDIANOTE_UNINSTALL";
        label1124:
        if ((i & 0x20) == 0) {
          break label2035;
        }
        paramzx = paramzx + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2059;
        }
        paramzx = paramzx + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2083;
        }
        paramzx = paramzx + ", QSYNC_UNISTALL";
        label1212:
        if ((i & 0x100) == 0) {
          break label2107;
        }
        paramzx = paramzx + ", SHAKE_UNISTALL";
        label1242:
        if ((i & 0x200) == 0) {
          break label2131;
        }
        paramzx = paramzx + ", LBS_UNISTALL";
        label1272:
        if ((i & 0x400) == 0) {
          break label2155;
        }
        paramzx = paramzx + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2179;
        }
        paramzx = paramzx + ",CHECKQQF_UNINSTALL";
        label1332:
        if ((i & 0x8000) == 0) {
          break label2203;
        }
        paramzx = paramzx + ",MM_FEEDSAPP_UNINSTALL";
        label1362:
        ae.i("MicroMsg.UserInfoSyncExtension", paramzx);
        localaj.set(34, Integer.valueOf(paramaa.FKG));
        if (1 != paramaa.Hom.GvE) {
          break label2227;
        }
      }
      label1963:
      label2227:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localaj.set(8200, Boolean.valueOf(bu.a(Boolean.valueOf(paramBoolean), false)));
        localaj.set(8201, Integer.valueOf(bu.a(Integer.valueOf(paramaa.Hom.GvF.GvI), 22)));
        localaj.set(8208, Integer.valueOf(bu.a(Integer.valueOf(paramaa.Hom.GvF.GvJ), 8)));
        localaj.set(66049, Integer.valueOf(paramaa.Hhu));
        localaj.set(66050, paramaa.Hhv);
        localaj.set(40, Integer.valueOf(paramaa.HoR));
        bb.hIK.aM("last_login_use_voice", paramaa.HoR);
        localaj.set(41, Integer.valueOf(paramaa.Hhy));
        localaj.set(43, paramaa.Hhx);
        ae.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramaa.HoR + " WeiboFlag:" + paramaa.Hhy);
        localaj.set(868518889, Integer.valueOf(paramaa.HoB));
        ae.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramaa.HoB);
        localaj.set(42, paramaa.jga);
        ae.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramaa.GyM + " username:" + paramaa.GyN);
        localaj.set(65825, paramaa.GyM);
        localaj.set(65826, paramaa.GyN);
        ae.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramaa.jgb);
        ae.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramaa.jgc);
        ae.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramaa.jgd);
        paramzx = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(65830, null));
        if ((paramzx == null) || (paramzx.length() == 0))
        {
          paramzx = paramaa.HoU;
          if ((paramzx != null) && (paramzx.length() > 0)) {
            com.tencent.mm.kernel.g.ajR().ajA().set(65830, paramzx);
          }
        }
        ab.b(1, paramaa);
        break;
        paramzx = paramzx + ", QQMAIL_INSTALL";
        break label1010;
        paramzx = paramzx + ", PM_INSTALL";
        break label1038;
        paramzx = paramzx + ", FM_INSTALL";
        break label1066;
        label1987:
        paramzx = paramzx + ", WEIBO_INSTALL";
        break label1095;
        label2011:
        paramzx = paramzx + ", MEDIANOTE_INSTALL";
        break label1124;
        label2035:
        paramzx = paramzx + ", QMSG_INSTALL";
        break label1153;
        paramzx = paramzx + ", BOTTLE_INSTALL";
        break label1182;
        paramzx = paramzx + ", QSYNC_INSTALL";
        break label1212;
        label2107:
        paramzx = paramzx + ", SHAKE_INSTALL";
        break label1242;
        label2131:
        paramzx = paramzx + ", LBS_INSTALL";
        break label1272;
        label2155:
        paramzx = paramzx + ", BOTTLE_CHART_INSTALL";
        break label1302;
        paramzx = paramzx + ",CHECKQQF_INSTALL";
        break label1332;
        paramzx = paramzx + ",MM_FEEDSAPP_INSTALL";
        break label1362;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */