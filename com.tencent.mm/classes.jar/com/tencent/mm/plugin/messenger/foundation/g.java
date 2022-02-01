package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bs;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public final class g
  implements u
{
  public final void a(xd paramxd, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(116929);
    switch (paramxd.CYY)
    {
    default: 
      AppMethodBeat.o(116929);
      return;
    }
    paramx = (brj)new brj().parseFrom(paramArrayOfByte);
    com.tencent.mm.kernel.g.afB().afk().get(2, null);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    ad.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramx.DPj), Integer.valueOf(paramx.mBi), Integer.valueOf(paramx.CuI), Integer.valueOf(paramx.DPq) });
    paramArrayOfByte = z.a(paramx.Dby);
    Object localObject = z.a(paramx.DFJ);
    String str1 = z.a(paramx.DPk);
    String str2 = z.a(paramx.DPl);
    int i = paramx.CuF;
    paramxd = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramArrayOfByte);
    if ((paramxd == null) || (paramxd.field_username == null) || (!paramxd.field_username.equals(paramArrayOfByte))) {
      paramxd = new af(paramArrayOfByte);
    }
    label1038:
    label1182:
    label2083:
    for (;;)
    {
      paramxd.na(paramx.ijR);
      paramxd.nd((String)localObject);
      paramxd.nA(RegionCodeDecoder.aT(paramx.ijV, paramx.ijN, paramx.ijO));
      paramxd.jJ(paramx.ijM);
      paramxd.nu(paramx.ijP);
      paramxd.jE(paramx.DIZ);
      paramxd.ny(paramx.DIX);
      paramxd.ng(paramx.DIY);
      paramxd.setUin(i);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().ae(paramxd);
      localab.set(2, paramArrayOfByte);
      localab.set(4, localObject);
      localab.set(5, str1);
      localab.set(6, str2);
      localab.set(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramx.mBi;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramxd = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramxd = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramxd;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramxd + ", email-verified";
      }
      paramxd = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramxd = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramxd;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramxd + ", hide-qq-search";
      }
      paramxd = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramxd = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramxd;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramxd + ", need-verify";
      }
      paramxd = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramxd = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramxd;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramxd + ", no-qq-promote";
      }
      paramxd = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramxd = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramxd;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramxd + ", hide-mobile_search";
      }
      paramxd = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramxd = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramxd;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramxd + ", bind but not upload";
      }
      ad.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localab.set(7, Integer.valueOf(paramx.mBi));
      if (paramx.ijQ != 0)
      {
        paramxd = new bs();
        paramxd.evy = 1;
        paramxd.evp = paramx.ijM;
        paramxd.signature = paramx.ijP;
        paramxd.countryCode = paramx.ijV;
        paramxd.provinceCode = paramx.ijN;
        paramxd.cityCode = paramx.ijO;
        paramxd.evD = paramx.DIX;
        ad.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramxd.evD + " nickName :" + paramx.DIY);
        bs.a(paramxd);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramx.CuI;
      paramxd = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramxd = paramxd + ", QQMAIL_UNINSTALL";
        label1010:
        if ((i & 0x2) == 0) {
          break label1939;
        }
        paramxd = paramxd + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1963;
        }
        paramxd = paramxd + ", FM_UNINSTALL";
        label1066:
        if ((i & 0x8) == 0) {
          break label1987;
        }
        paramxd = paramxd + ", WEIBO_UNINSTALL";
        label1095:
        if ((i & 0x10) == 0) {
          break label2011;
        }
        paramxd = paramxd + ", MEDIANOTE_UNINSTALL";
        label1124:
        if ((i & 0x20) == 0) {
          break label2035;
        }
        paramxd = paramxd + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2059;
        }
        paramxd = paramxd + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2083;
        }
        paramxd = paramxd + ", QSYNC_UNISTALL";
        label1212:
        if ((i & 0x100) == 0) {
          break label2107;
        }
        paramxd = paramxd + ", SHAKE_UNISTALL";
        label1242:
        if ((i & 0x200) == 0) {
          break label2131;
        }
        paramxd = paramxd + ", LBS_UNISTALL";
        label1272:
        if ((i & 0x400) == 0) {
          break label2155;
        }
        paramxd = paramxd + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2179;
        }
        paramxd = paramxd + ",CHECKQQF_UNINSTALL";
        label1332:
        if ((i & 0x8000) == 0) {
          break label2203;
        }
        paramxd = paramxd + ",MM_FEEDSAPP_UNINSTALL";
        label1362:
        ad.i("MicroMsg.UserInfoSyncExtension", paramxd);
        localab.set(34, Integer.valueOf(paramx.CuI));
        if (1 != paramx.DOM.Dcu) {
          break label2227;
        }
      }
      label1963:
      label2227:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localab.set(8200, Boolean.valueOf(bt.a(Boolean.valueOf(paramBoolean), false)));
        localab.set(8201, Integer.valueOf(bt.a(Integer.valueOf(paramx.DOM.Dcv.Dcy), 22)));
        localab.set(8208, Integer.valueOf(bt.a(Integer.valueOf(paramx.DOM.Dcv.Dcz), 8)));
        localab.set(66049, Integer.valueOf(paramx.DIV));
        localab.set(66050, paramx.DIW);
        localab.set(40, Integer.valueOf(paramx.DPq));
        ay.gNa.aD("last_login_use_voice", paramx.DPq);
        localab.set(41, Integer.valueOf(paramx.DIZ));
        localab.set(43, paramx.DIY);
        ad.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramx.DPq + " WeiboFlag:" + paramx.DIZ);
        localab.set(868518889, Integer.valueOf(paramx.DPa));
        ad.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramx.DPa);
        localab.set(42, paramx.ijR);
        ad.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramx.Dfl + " username:" + paramx.Dfm);
        localab.set(65825, paramx.Dfl);
        localab.set(65826, paramx.Dfm);
        ad.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramx.ijS);
        ad.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramx.ijT);
        ad.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramx.ijU);
        paramxd = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(65830, null));
        if ((paramxd == null) || (paramxd.length() == 0))
        {
          paramxd = paramx.DPt;
          if ((paramxd != null) && (paramxd.length() > 0)) {
            com.tencent.mm.kernel.g.afB().afk().set(65830, paramxd);
          }
        }
        y.b(1, paramx);
        break;
        paramxd = paramxd + ", QQMAIL_INSTALL";
        break label1010;
        paramxd = paramxd + ", PM_INSTALL";
        break label1038;
        paramxd = paramxd + ", FM_INSTALL";
        break label1066;
        label1987:
        paramxd = paramxd + ", WEIBO_INSTALL";
        break label1095;
        label2011:
        paramxd = paramxd + ", MEDIANOTE_INSTALL";
        break label1124;
        label2035:
        paramxd = paramxd + ", QMSG_INSTALL";
        break label1153;
        paramxd = paramxd + ", BOTTLE_INSTALL";
        break label1182;
        paramxd = paramxd + ", QSYNC_INSTALL";
        break label1212;
        label2107:
        paramxd = paramxd + ", SHAKE_INSTALL";
        break label1242;
        label2131:
        paramxd = paramxd + ", LBS_INSTALL";
        break label1272;
        label2155:
        paramxd = paramxd + ", BOTTLE_CHART_INSTALL";
        break label1302;
        paramxd = paramxd + ",CHECKQQF_INSTALL";
        break label1332;
        paramxd = paramxd + ",MM_FEEDSAPP_INSTALL";
        break label1362;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */