package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bn;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.ua;
import com.tencent.mm.protocal.c.ub;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;

public final class h
  implements r
{
  public final void a(qv paramqv, byte[] paramArrayOfByte, boolean paramBoolean, t paramt)
  {
    switch (paramqv.sOA)
    {
    default: 
      return;
    }
    paramt = (axx)new axx().aH(paramArrayOfByte);
    int i = paramt.tue;
    g.DP().Dz().get(2, null);
    z localz = g.DP().Dz();
    y.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramt.tue), Integer.valueOf(paramt.hQq), Integer.valueOf(paramt.stP), Integer.valueOf(paramt.tul) });
    paramArrayOfByte = aa.a(paramt.sQs);
    Object localObject = aa.a(paramt.tmw);
    String str1 = aa.a(paramt.tuf);
    String str2 = aa.a(paramt.tug);
    i = paramt.stM;
    paramqv = ((j)g.r(j.class)).Fw().abl(paramArrayOfByte);
    if ((paramqv == null) || (paramqv.field_username == null) || (!paramqv.field_username.equals(paramArrayOfByte))) {
      paramqv = new ad(paramArrayOfByte);
    }
    label1036:
    label1180:
    label2079:
    for (;;)
    {
      paramqv.cZ(paramt.ffm);
      paramqv.dk((String)localObject);
      paramqv.dF(RegionCodeDecoder.ao(paramt.ffq, paramt.ffi, paramt.ffj));
      paramqv.fm(paramt.ffh);
      paramqv.dz(paramt.ffk);
      paramqv.fh(paramt.tpk);
      paramqv.dD(paramt.tpi);
      paramqv.dn(paramt.tpj);
      paramqv.fn(i);
      ((j)g.r(j.class)).Fw().U(paramqv);
      localz.o(2, paramArrayOfByte);
      localz.o(4, localObject);
      localz.o(5, str1);
      localz.o(6, str2);
      localz.o(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramt.hQq;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramqv = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramqv = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramqv;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramqv + ", email-verified";
      }
      paramqv = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramqv = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramqv;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramqv + ", hide-qq-search";
      }
      paramqv = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramqv = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramqv;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramqv + ", need-verify";
      }
      paramqv = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramqv = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramqv;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramqv + ", no-qq-promote";
      }
      paramqv = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramqv = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramqv;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramqv + ", hide-mobile_search";
      }
      paramqv = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramqv = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramqv;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramqv + ", bind but not upload";
      }
      y.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localz.o(7, Integer.valueOf(paramt.hQq));
      if (paramt.ffl != 0)
      {
        paramqv = new bn();
        paramqv.cCz = 1;
        paramqv.sex = paramt.ffh;
        paramqv.signature = paramt.ffk;
        paramqv.countryCode = paramt.ffq;
        paramqv.dXv = paramt.ffi;
        paramqv.dXu = paramt.ffj;
        paramqv.cCE = paramt.tpi;
        y.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramqv.cCE + " nickName :" + paramt.tpj);
        bn.a(paramqv);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramt.stP;
      paramqv = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramqv = paramqv + ", QQMAIL_UNINSTALL";
        if ((i & 0x2) == 0) {
          break label1935;
        }
        paramqv = paramqv + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1959;
        }
        paramqv = paramqv + ", FM_UNINSTALL";
        label1064:
        if ((i & 0x8) == 0) {
          break label1983;
        }
        paramqv = paramqv + ", WEIBO_UNINSTALL";
        label1093:
        if ((i & 0x10) == 0) {
          break label2007;
        }
        paramqv = paramqv + ", MEDIANOTE_UNINSTALL";
        label1122:
        if ((i & 0x20) == 0) {
          break label2031;
        }
        paramqv = paramqv + ", QMSG_UNINSTALL";
        label1151:
        if ((i & 0x40) == 0) {
          break label2055;
        }
        paramqv = paramqv + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2079;
        }
        paramqv = paramqv + ", QSYNC_UNISTALL";
        label1210:
        if ((i & 0x100) == 0) {
          break label2103;
        }
        paramqv = paramqv + ", SHAKE_UNISTALL";
        label1240:
        if ((i & 0x200) == 0) {
          break label2127;
        }
        paramqv = paramqv + ", LBS_UNISTALL";
        label1270:
        if ((i & 0x400) == 0) {
          break label2151;
        }
        paramqv = paramqv + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2175;
        }
        paramqv = paramqv + ",CHECKQQF_UNINSTALL";
        label1330:
        if ((i & 0x8000) == 0) {
          break label2199;
        }
        paramqv = paramqv + ",MM_FEEDSAPP_UNINSTALL";
        label1360:
        y.i("MicroMsg.UserInfoSyncExtension", paramqv);
        localz.o(34, Integer.valueOf(paramt.stP));
        if (1 != paramt.ttK.sQN) {
          break label2223;
        }
      }
      label1959:
      label2223:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localz.o(8200, Boolean.valueOf(bk.a(Boolean.valueOf(paramBoolean), false)));
        localz.o(8201, Integer.valueOf(bk.a(Integer.valueOf(paramt.ttK.sQO.sQR), 22)));
        localz.o(8208, Integer.valueOf(bk.a(Integer.valueOf(paramt.ttK.sQO.sQS), 8)));
        localz.o(66049, Integer.valueOf(paramt.tpg));
        localz.o(66050, paramt.tph);
        localz.o(40, Integer.valueOf(paramt.tul));
        at.dVC.Y("last_login_use_voice", paramt.tul);
        localz.o(41, Integer.valueOf(paramt.tpk));
        localz.o(43, paramt.tpj);
        y.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramt.tul + " WeiboFlag:" + paramt.tpk);
        localz.o(868518889, Integer.valueOf(paramt.ttW));
        y.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramt.ttW);
        localz.o(42, paramt.ffm);
        y.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramt.sTU + " username:" + paramt.sTV);
        localz.o(65825, paramt.sTU);
        localz.o(65826, paramt.sTV);
        y.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramt.ffn);
        y.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramt.ffo);
        y.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramt.ffp);
        paramqv = bk.pm((String)g.DP().Dz().get(65830, null));
        if ((paramqv == null) || (paramqv.length() == 0))
        {
          paramqv = paramt.tuo;
          if ((paramqv != null) && (paramqv.length() > 0)) {
            g.DP().Dz().o(65830, paramqv);
          }
        }
        u.b(1, paramt);
        return;
        paramqv = paramqv + ", QQMAIL_INSTALL";
        break;
        paramqv = paramqv + ", PM_INSTALL";
        break label1036;
        paramqv = paramqv + ", FM_INSTALL";
        break label1064;
        label1983:
        paramqv = paramqv + ", WEIBO_INSTALL";
        break label1093;
        label2007:
        paramqv = paramqv + ", MEDIANOTE_INSTALL";
        break label1122;
        label2031:
        paramqv = paramqv + ", QMSG_INSTALL";
        break label1151;
        paramqv = paramqv + ", BOTTLE_INSTALL";
        break label1180;
        paramqv = paramqv + ", QSYNC_INSTALL";
        break label1210;
        label2103:
        paramqv = paramqv + ", SHAKE_INSTALL";
        break label1240;
        label2127:
        paramqv = paramqv + ", LBS_INSTALL";
        break label1270;
        label2151:
        paramqv = paramqv + ", BOTTLE_CHART_INSTALL";
        break label1300;
        label2175:
        paramqv = paramqv + ",CHECKQQF_INSTALL";
        break label1330;
        paramqv = paramqv + ",MM_FEEDSAPP_INSTALL";
        break label1360;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.h
 * JD-Core Version:    0.7.0.1
 */