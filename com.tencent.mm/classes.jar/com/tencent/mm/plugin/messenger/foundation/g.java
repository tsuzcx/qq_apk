package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;

public final class g
  implements r
{
  public final void a(ud paramud, byte[] paramArrayOfByte, boolean paramBoolean, u paramu)
  {
    AppMethodBeat.i(1065);
    switch (paramud.wMC)
    {
    default: 
      AppMethodBeat.o(1065);
      return;
    }
    paramu = (beq)new beq().parseFrom(paramArrayOfByte);
    com.tencent.mm.kernel.g.RL().Ru().get(2, null);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    ab.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramu.xug), Integer.valueOf(paramu.jJS), Integer.valueOf(paramu.wmt), Integer.valueOf(paramu.xun) });
    paramArrayOfByte = aa.a(paramu.wOT);
    Object localObject = aa.a(paramu.xmi);
    String str1 = aa.a(paramu.xuh);
    String str2 = aa.a(paramu.xui);
    int i = paramu.wmq;
    paramud = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramArrayOfByte);
    if ((paramud == null) || (paramud.field_username == null) || (!paramud.field_username.equals(paramArrayOfByte))) {
      paramud = new ad(paramArrayOfByte);
    }
    label1039:
    label1183:
    label2084:
    for (;;)
    {
      paramud.jm(paramu.gwU);
      paramud.jp((String)localObject);
      paramud.jL(RegionCodeDecoder.aF(paramu.gwY, paramu.gwQ, paramu.gwR));
      paramud.hy(paramu.gwP);
      paramud.jF(paramu.gwS);
      paramud.ht(paramu.xpi);
      paramud.jJ(paramu.xpg);
      paramud.js(paramu.xph);
      paramud.setUin(i);
      ((j)com.tencent.mm.kernel.g.E(j.class)).YA().X(paramud);
      localz.set(2, paramArrayOfByte);
      localz.set(4, localObject);
      localz.set(5, str1);
      localz.set(6, str2);
      localz.set(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramu.jJS;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramud = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramud = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramud;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramud + ", email-verified";
      }
      paramud = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramud = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramud;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramud + ", hide-qq-search";
      }
      paramud = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramud = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramud;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramud + ", need-verify";
      }
      paramud = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramud = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramud;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramud + ", no-qq-promote";
      }
      paramud = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramud = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramud;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramud + ", hide-mobile_search";
      }
      paramud = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramud = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramud;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramud + ", bind but not upload";
      }
      ab.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localz.set(7, Integer.valueOf(paramu.jJS));
      if (paramu.gwT != 0)
      {
        paramud = new bp();
        paramud.dqL = 1;
        paramud.dqC = paramu.gwP;
        paramud.signature = paramu.gwS;
        paramud.countryCode = paramu.gwY;
        paramud.fnC = paramu.gwQ;
        paramud.fnB = paramu.gwR;
        paramud.dqO = paramu.xpg;
        ab.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramud.dqO + " nickName :" + paramu.xph);
        bp.a(paramud);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramu.wmt;
      paramud = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramud = paramud + ", QQMAIL_UNINSTALL";
        label1011:
        if ((i & 0x2) == 0) {
          break label1940;
        }
        paramud = paramud + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1964;
        }
        paramud = paramud + ", FM_UNINSTALL";
        label1067:
        if ((i & 0x8) == 0) {
          break label1988;
        }
        paramud = paramud + ", WEIBO_UNINSTALL";
        label1096:
        if ((i & 0x10) == 0) {
          break label2012;
        }
        paramud = paramud + ", MEDIANOTE_UNINSTALL";
        label1125:
        if ((i & 0x20) == 0) {
          break label2036;
        }
        paramud = paramud + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2060;
        }
        paramud = paramud + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2084;
        }
        paramud = paramud + ", QSYNC_UNISTALL";
        label1213:
        if ((i & 0x100) == 0) {
          break label2108;
        }
        paramud = paramud + ", SHAKE_UNISTALL";
        label1243:
        if ((i & 0x200) == 0) {
          break label2132;
        }
        paramud = paramud + ", LBS_UNISTALL";
        label1273:
        if ((i & 0x400) == 0) {
          break label2156;
        }
        paramud = paramud + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2180;
        }
        paramud = paramud + ",CHECKQQF_UNINSTALL";
        label1333:
        if ((i & 0x8000) == 0) {
          break label2204;
        }
        paramud = paramud + ",MM_FEEDSAPP_UNINSTALL";
        label1363:
        ab.i("MicroMsg.UserInfoSyncExtension", paramud);
        localz.set(34, Integer.valueOf(paramu.wmt));
        if (1 != paramu.xtJ.wPD) {
          break label2228;
        }
      }
      label1964:
      label2228:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localz.set(8200, Boolean.valueOf(bo.a(Boolean.valueOf(paramBoolean), false)));
        localz.set(8201, Integer.valueOf(bo.a(Integer.valueOf(paramu.xtJ.wPE.wPH), 22)));
        localz.set(8208, Integer.valueOf(bo.a(Integer.valueOf(paramu.xtJ.wPE.wPI), 8)));
        localz.set(66049, Integer.valueOf(paramu.xpe));
        localz.set(66050, paramu.xpf);
        localz.set(40, Integer.valueOf(paramu.xun));
        av.flM.ao("last_login_use_voice", paramu.xun);
        localz.set(41, Integer.valueOf(paramu.xpi));
        localz.set(43, paramu.xph);
        ab.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramu.xun + " WeiboFlag:" + paramu.xpi);
        localz.set(868518889, Integer.valueOf(paramu.xtY));
        ab.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramu.xtY);
        localz.set(42, paramu.gwU);
        ab.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramu.wRQ + " username:" + paramu.wRR);
        localz.set(65825, paramu.wRQ);
        localz.set(65826, paramu.wRR);
        ab.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramu.gwV);
        ab.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramu.gwW);
        ab.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramu.gwX);
        paramud = bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(65830, null));
        if ((paramud == null) || (paramud.length() == 0))
        {
          paramud = paramu.xuq;
          if ((paramud != null) && (paramud.length() > 0)) {
            com.tencent.mm.kernel.g.RL().Ru().set(65830, paramud);
          }
        }
        v.b(1, paramu);
        break;
        paramud = paramud + ", QQMAIL_INSTALL";
        break label1011;
        paramud = paramud + ", PM_INSTALL";
        break label1039;
        paramud = paramud + ", FM_INSTALL";
        break label1067;
        label1988:
        paramud = paramud + ", WEIBO_INSTALL";
        break label1096;
        label2012:
        paramud = paramud + ", MEDIANOTE_INSTALL";
        break label1125;
        label2036:
        paramud = paramud + ", QMSG_INSTALL";
        break label1154;
        paramud = paramud + ", BOTTLE_INSTALL";
        break label1183;
        paramud = paramud + ", QSYNC_INSTALL";
        break label1213;
        label2108:
        paramud = paramud + ", SHAKE_INSTALL";
        break label1243;
        label2132:
        paramud = paramud + ", LBS_INSTALL";
        break label1273;
        label2156:
        paramud = paramud + ", BOTTLE_CHART_INSTALL";
        break label1303;
        paramud = paramud + ",CHECKQQF_INSTALL";
        break label1333;
        paramud = paramud + ",MM_FEEDSAPP_INSTALL";
        break label1363;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */