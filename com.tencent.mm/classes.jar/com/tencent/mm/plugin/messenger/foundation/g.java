package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class g
  implements x
{
  public final void a(abn paramabn, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(116929);
    switch (paramabn.Lms)
    {
    default: 
      AppMethodBeat.o(116929);
      return;
    }
    paramaa = (cqm)new cqm().parseFrom(paramArrayOfByte);
    com.tencent.mm.kernel.g.aAh().azQ().get(2, null);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    Log.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramaa.Mwf), Integer.valueOf(paramaa.oTW), Integer.valueOf(paramaa.KEc), Integer.valueOf(paramaa.Mwm) });
    paramArrayOfByte = z.a(paramaa.Lqk);
    Object localObject = z.a(paramaa.Mjj);
    String str1 = z.a(paramaa.Mwg);
    String str2 = z.a(paramaa.Mwh);
    int i = paramaa.KDZ;
    paramabn = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramArrayOfByte);
    if ((paramabn == null) || (paramabn.field_username == null) || (!paramabn.field_username.equals(paramArrayOfByte))) {
      paramabn = new as(paramArrayOfByte);
    }
    label1038:
    label1182:
    label2083:
    for (;;)
    {
      paramabn.BC(paramaa.ked);
      paramabn.setNickname((String)localObject);
      paramabn.Cb(RegionCodeDecoder.bq(paramaa.keh, paramaa.kdZ, paramaa.kea));
      paramabn.nj(paramaa.kdY);
      paramabn.BV(paramaa.keb);
      paramabn.ne(paramaa.MmO);
      paramabn.BZ(paramaa.MmM);
      paramabn.BH(paramaa.MmN);
      paramabn.setUin(i);
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().ao(paramabn);
      localao.set(2, paramArrayOfByte);
      localao.set(4, localObject);
      localao.set(5, str1);
      localao.set(6, str2);
      localao.set(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramaa.oTW;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramabn = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramabn = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramabn;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramabn + ", email-verified";
      }
      paramabn = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramabn = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramabn;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramabn + ", hide-qq-search";
      }
      paramabn = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramabn = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramabn;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramabn + ", need-verify";
      }
      paramabn = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramabn = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramabn;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramabn + ", no-qq-promote";
      }
      paramabn = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramabn = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramabn;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramabn + ", hide-mobile_search";
      }
      paramabn = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramabn = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramabn;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramabn + ", bind but not upload";
      }
      Log.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localao.set(7, Integer.valueOf(paramaa.oTW));
      if (paramaa.kec != 0)
      {
        paramabn = new bz();
        paramabn.fuI = 1;
        paramabn.fuA = paramaa.kdY;
        paramabn.signature = paramaa.keb;
        paramabn.countryCode = paramaa.keh;
        paramabn.provinceCode = paramaa.kdZ;
        paramabn.cityCode = paramaa.kea;
        paramabn.fuM = paramaa.MmM;
        Log.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramabn.fuM + " nickName :" + paramaa.MmN);
        bz.a(paramabn);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramaa.KEc;
      paramabn = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramabn = paramabn + ", QQMAIL_UNINSTALL";
        label1010:
        if ((i & 0x2) == 0) {
          break label1939;
        }
        paramabn = paramabn + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1963;
        }
        paramabn = paramabn + ", FM_UNINSTALL";
        label1066:
        if ((i & 0x8) == 0) {
          break label1987;
        }
        paramabn = paramabn + ", WEIBO_UNINSTALL";
        label1095:
        if ((i & 0x10) == 0) {
          break label2011;
        }
        paramabn = paramabn + ", MEDIANOTE_UNINSTALL";
        label1124:
        if ((i & 0x20) == 0) {
          break label2035;
        }
        paramabn = paramabn + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2059;
        }
        paramabn = paramabn + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2083;
        }
        paramabn = paramabn + ", QSYNC_UNISTALL";
        label1212:
        if ((i & 0x100) == 0) {
          break label2107;
        }
        paramabn = paramabn + ", SHAKE_UNISTALL";
        label1242:
        if ((i & 0x200) == 0) {
          break label2131;
        }
        paramabn = paramabn + ", LBS_UNISTALL";
        label1272:
        if ((i & 0x400) == 0) {
          break label2155;
        }
        paramabn = paramabn + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2179;
        }
        paramabn = paramabn + ",CHECKQQF_UNINSTALL";
        label1332:
        if ((i & 0x8000) == 0) {
          break label2203;
        }
        paramabn = paramabn + ",MM_FEEDSAPP_UNINSTALL";
        label1362:
        Log.i("MicroMsg.UserInfoSyncExtension", paramabn);
        localao.set(34, Integer.valueOf(paramaa.KEc));
        if (1 != paramaa.MvH.Lrk) {
          break label2227;
        }
      }
      label1963:
      label2227:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localao.set(8200, Boolean.valueOf(Util.nullAs(Boolean.valueOf(paramBoolean), false)));
        localao.set(8201, Integer.valueOf(Util.nullAs(Integer.valueOf(paramaa.MvH.Lrl.Lro), 22)));
        localao.set(8208, Integer.valueOf(Util.nullAs(Integer.valueOf(paramaa.MvH.Lrl.Lrp), 8)));
        localao.set(66049, Integer.valueOf(paramaa.MmK));
        localao.set(66050, paramaa.MmL);
        localao.set(40, Integer.valueOf(paramaa.Mwm));
        bf.iDu.aO("last_login_use_voice", paramaa.Mwm);
        localao.set(41, Integer.valueOf(paramaa.MmO));
        localao.set(43, paramaa.MmN);
        Log.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramaa.Mwm + " WeiboFlag:" + paramaa.MmO);
        localao.set(868518889, Integer.valueOf(paramaa.MvW));
        Log.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramaa.MvW);
        localao.set(42, paramaa.ked);
        Log.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramaa.LuA + " username:" + paramaa.LuB);
        localao.set(65825, paramaa.LuA);
        localao.set(65826, paramaa.LuB);
        Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramaa.kee);
        Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramaa.kef);
        Log.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramaa.keg);
        paramabn = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(65830, null));
        if ((paramabn == null) || (paramabn.length() == 0))
        {
          paramabn = paramaa.Mwp;
          if ((paramabn != null) && (paramabn.length() > 0)) {
            com.tencent.mm.kernel.g.aAh().azQ().set(65830, paramabn);
          }
        }
        ab.b(1, paramaa);
        break;
        paramabn = paramabn + ", QQMAIL_INSTALL";
        break label1010;
        paramabn = paramabn + ", PM_INSTALL";
        break label1038;
        paramabn = paramabn + ", FM_INSTALL";
        break label1066;
        label1987:
        paramabn = paramabn + ", WEIBO_INSTALL";
        break label1095;
        label2011:
        paramabn = paramabn + ", MEDIANOTE_INSTALL";
        break label1124;
        label2035:
        paramabn = paramabn + ", QMSG_INSTALL";
        break label1153;
        paramabn = paramabn + ", BOTTLE_INSTALL";
        break label1182;
        paramabn = paramabn + ", QSYNC_INSTALL";
        break label1212;
        label2107:
        paramabn = paramabn + ", SHAKE_INSTALL";
        break label1242;
        label2131:
        paramabn = paramabn + ", LBS_INSTALL";
        break label1272;
        label2155:
        paramabn = paramabn + ", BOTTLE_CHART_INSTALL";
        break label1302;
        paramabn = paramabn + ",CHECKQQF_INSTALL";
        break label1332;
        paramabn = paramabn + ",MM_FEEDSAPP_INSTALL";
        break label1362;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */