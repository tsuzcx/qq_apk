package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class j
  implements ab
{
  public final void a(adw paramadw, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(116929);
    switch (paramadw.Zmc)
    {
    default: 
      AppMethodBeat.o(116929);
      return;
    }
    paramae = (dqk)new dqk().parseFrom(paramArrayOfByte);
    h.baE().ban().d(2, null);
    aq localaq = h.baE().ban();
    Log.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramae.aaWL), Integer.valueOf(paramae.vhk), Integer.valueOf(paramae.YBX), Integer.valueOf(paramae.aaWS) });
    paramArrayOfByte = w.a(paramae.ZqL);
    Object localObject = w.a(paramae.aaIz);
    String str1 = w.a(paramae.aaWM);
    String str2 = w.a(paramae.aaWN);
    int i = paramae.YBU;
    paramadw = ((n)h.ax(n.class)).bzA().JE(paramArrayOfByte);
    if ((paramadw == null) || (paramadw.field_username == null) || (!paramadw.field_username.equals(paramArrayOfByte))) {
      paramadw = new au(paramArrayOfByte);
    }
    label1038:
    label1182:
    label2083:
    for (;;)
    {
      paramadw.AV(paramae.pSk);
      paramadw.setNickname((String)localObject);
      paramadw.Bu(RegionCodeDecoder.bI(paramae.pSo, paramae.pSg, paramae.pSh));
      paramadw.pv(paramae.pSf);
      paramadw.Bo(paramae.pSi);
      paramadw.pq(paramae.aaMq);
      paramadw.Bs(paramae.aaMo);
      paramadw.Ba(paramae.aaMp);
      paramadw.setUin(i);
      ((n)h.ax(n.class)).bzA().aA(paramadw);
      localaq.B(2, paramArrayOfByte);
      localaq.B(4, localObject);
      localaq.B(5, str1);
      localaq.B(6, str2);
      localaq.B(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramae.vhk;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramadw = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramadw = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramadw;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramadw + ", email-verified";
      }
      paramadw = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramadw = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramadw;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramadw + ", hide-qq-search";
      }
      paramadw = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramadw = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramadw;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramadw + ", need-verify";
      }
      paramadw = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramadw = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramadw;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramadw + ", no-qq-promote";
      }
      paramadw = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramadw = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramadw;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramadw + ", hide-mobile_search";
      }
      paramadw = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramadw = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramadw;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramadw + ", bind but not upload";
      }
      Log.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localaq.B(7, Integer.valueOf(paramae.vhk));
      if (paramae.pSj != 0)
      {
        paramadw = new cb();
        paramadw.kag = 1;
        paramadw.sex = paramae.pSf;
        paramadw.signature = paramae.pSi;
        paramadw.countryCode = paramae.pSo;
        paramadw.provinceCode = paramae.pSg;
        paramadw.cityCode = paramae.pSh;
        paramadw.kai = paramae.aaMo;
        Log.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramadw.kai + " nickName :" + paramae.aaMp);
        cb.a(paramadw);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramae.YBX;
      paramadw = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramadw = paramadw + ", QQMAIL_UNINSTALL";
        label1010:
        if ((i & 0x2) == 0) {
          break label1939;
        }
        paramadw = paramadw + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1963;
        }
        paramadw = paramadw + ", FM_UNINSTALL";
        label1066:
        if ((i & 0x8) == 0) {
          break label1987;
        }
        paramadw = paramadw + ", WEIBO_UNINSTALL";
        label1095:
        if ((i & 0x10) == 0) {
          break label2011;
        }
        paramadw = paramadw + ", MEDIANOTE_UNINSTALL";
        label1124:
        if ((i & 0x20) == 0) {
          break label2035;
        }
        paramadw = paramadw + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2059;
        }
        paramadw = paramadw + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2083;
        }
        paramadw = paramadw + ", QSYNC_UNISTALL";
        label1212:
        if ((i & 0x100) == 0) {
          break label2107;
        }
        paramadw = paramadw + ", SHAKE_UNISTALL";
        label1242:
        if ((i & 0x200) == 0) {
          break label2131;
        }
        paramadw = paramadw + ", LBS_UNISTALL";
        label1272:
        if ((i & 0x400) == 0) {
          break label2155;
        }
        paramadw = paramadw + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2179;
        }
        paramadw = paramadw + ",CHECKQQF_UNINSTALL";
        label1332:
        if ((i & 0x8000) == 0) {
          break label2203;
        }
        paramadw = paramadw + ",MM_FEEDSAPP_UNINSTALL";
        label1362:
        Log.i("MicroMsg.UserInfoSyncExtension", paramadw);
        localaq.B(34, Integer.valueOf(paramae.YBX));
        if (1 != paramae.aaWm.ZrQ) {
          break label2227;
        }
      }
      label1963:
      label2227:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localaq.B(8200, Boolean.valueOf(Util.nullAs(Boolean.valueOf(paramBoolean), false)));
        localaq.B(8201, Integer.valueOf(Util.nullAs(Integer.valueOf(paramae.aaWm.ZrR.ZrU), 22)));
        localaq.B(8208, Integer.valueOf(Util.nullAs(Integer.valueOf(paramae.aaWm.ZrR.ZrV), 8)));
        localaq.B(66049, Integer.valueOf(paramae.aaMm));
        localaq.B(66050, paramae.aaMn);
        localaq.B(40, Integer.valueOf(paramae.aaWS));
        bg.okT.bc("last_login_use_voice", paramae.aaWS);
        localaq.B(41, Integer.valueOf(paramae.aaMq));
        localaq.B(43, paramae.aaMp);
        Log.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramae.aaWS + " WeiboFlag:" + paramae.aaMq);
        localaq.B(868518889, Integer.valueOf(paramae.aaWB));
        Log.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramae.aaWB);
        localaq.B(42, paramae.pSk);
        Log.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramae.ZxM + " username:" + paramae.ZxN);
        localaq.B(65825, paramae.ZxM);
        localaq.B(65826, paramae.ZxN);
        Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramae.pSl);
        Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramae.pSm);
        Log.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramae.pSn);
        paramadw = Util.nullAsNil((String)h.baE().ban().d(65830, null));
        if ((paramadw == null) || (paramadw.length() == 0))
        {
          paramadw = paramae.aaWV;
          if ((paramadw != null) && (paramadw.length() > 0)) {
            h.baE().ban().B(65830, paramadw);
          }
        }
        af.b(1, paramae);
        break;
        paramadw = paramadw + ", QQMAIL_INSTALL";
        break label1010;
        paramadw = paramadw + ", PM_INSTALL";
        break label1038;
        paramadw = paramadw + ", FM_INSTALL";
        break label1066;
        label1987:
        paramadw = paramadw + ", WEIBO_INSTALL";
        break label1095;
        label2011:
        paramadw = paramadw + ", MEDIANOTE_INSTALL";
        break label1124;
        label2035:
        paramadw = paramadw + ", QMSG_INSTALL";
        break label1153;
        paramadw = paramadw + ", BOTTLE_INSTALL";
        break label1182;
        paramadw = paramadw + ", QSYNC_INSTALL";
        break label1212;
        label2107:
        paramadw = paramadw + ", SHAKE_INSTALL";
        break label1242;
        label2131:
        paramadw = paramadw + ", LBS_INSTALL";
        break label1272;
        label2155:
        paramadw = paramadw + ", BOTTLE_CHART_INSTALL";
        break label1302;
        paramadw = paramadw + ",CHECKQQF_INSTALL";
        break label1332;
        paramadw = paramadw + ",MM_FEEDSAPP_INSTALL";
        break label1362;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.j
 * JD-Core Version:    0.7.0.1
 */