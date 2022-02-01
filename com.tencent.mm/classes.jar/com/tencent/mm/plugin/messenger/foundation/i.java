package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.ca;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class i
  implements ab
{
  public final void a(abu paramabu, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(116929);
    switch (paramabu.SnG)
    {
    default: 
      AppMethodBeat.o(116929);
      return;
    }
    paramae = (czd)new czd().parseFrom(paramArrayOfByte);
    h.aHG().aHp().b(2, null);
    ao localao = h.aHG().aHp();
    Log.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramae.THd), Integer.valueOf(paramae.rVU), Integer.valueOf(paramae.RFu), Integer.valueOf(paramae.THk) });
    paramArrayOfByte = z.a(paramae.SrH);
    Object localObject = z.a(paramae.TtX);
    String str1 = z.a(paramae.THe);
    String str2 = z.a(paramae.THf);
    int i = paramae.RFr;
    paramabu = ((n)h.ae(n.class)).bbL().RG(paramArrayOfByte);
    if ((paramabu == null) || (paramabu.field_username == null) || (!paramabu.field_username.equals(paramArrayOfByte))) {
      paramabu = new as(paramArrayOfByte);
    }
    label1038:
    label1182:
    label2083:
    for (;;)
    {
      paramabu.Iq(paramae.mVD);
      paramabu.setNickname((String)localObject);
      paramabu.IP(RegionCodeDecoder.bl(paramae.mVH, paramae.mVz, paramae.mVA));
      paramabu.pw(paramae.mVy);
      paramabu.IJ(paramae.mVB);
      paramabu.pr(paramae.TxJ);
      paramabu.IN(paramae.TxH);
      paramabu.Iv(paramae.TxI);
      paramabu.setUin(i);
      ((n)h.ae(n.class)).bbL().au(paramabu);
      localao.i(2, paramArrayOfByte);
      localao.i(4, localObject);
      localao.i(5, str1);
      localao.i(6, str2);
      localao.i(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramae.rVU;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramabu = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramabu = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramabu;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramabu + ", email-verified";
      }
      paramabu = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramabu = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramabu;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramabu + ", hide-qq-search";
      }
      paramabu = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramabu = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramabu;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramabu + ", need-verify";
      }
      paramabu = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramabu = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramabu;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramabu + ", no-qq-promote";
      }
      paramabu = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramabu = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramabu;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramabu + ", hide-mobile_search";
      }
      paramabu = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramabu = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramabu;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramabu + ", bind but not upload";
      }
      Log.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localao.i(7, Integer.valueOf(paramae.rVU));
      if (paramae.mVC != 0)
      {
        paramabu = new ca();
        paramabu.hDk = 1;
        paramabu.sex = paramae.mVy;
        paramabu.signature = paramae.mVB;
        paramabu.countryCode = paramae.mVH;
        paramabu.provinceCode = paramae.mVz;
        paramabu.cityCode = paramae.mVA;
        paramabu.hDm = paramae.TxH;
        Log.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramabu.hDm + " nickName :" + paramae.TxI);
        ca.a(paramabu);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramae.RFu;
      paramabu = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramabu = paramabu + ", QQMAIL_UNINSTALL";
        label1010:
        if ((i & 0x2) == 0) {
          break label1939;
        }
        paramabu = paramabu + ", PM_UNINSTALL";
        if ((i & 0x4) == 0) {
          break label1963;
        }
        paramabu = paramabu + ", FM_UNINSTALL";
        label1066:
        if ((i & 0x8) == 0) {
          break label1987;
        }
        paramabu = paramabu + ", WEIBO_UNINSTALL";
        label1095:
        if ((i & 0x10) == 0) {
          break label2011;
        }
        paramabu = paramabu + ", MEDIANOTE_UNINSTALL";
        label1124:
        if ((i & 0x20) == 0) {
          break label2035;
        }
        paramabu = paramabu + ", QMSG_UNINSTALL";
        if ((i & 0x40) == 0) {
          break label2059;
        }
        paramabu = paramabu + ", BOTTLE_UNINSTALL";
        if ((i & 0x80) == 0) {
          break label2083;
        }
        paramabu = paramabu + ", QSYNC_UNISTALL";
        label1212:
        if ((i & 0x100) == 0) {
          break label2107;
        }
        paramabu = paramabu + ", SHAKE_UNISTALL";
        label1242:
        if ((i & 0x200) == 0) {
          break label2131;
        }
        paramabu = paramabu + ", LBS_UNISTALL";
        label1272:
        if ((i & 0x400) == 0) {
          break label2155;
        }
        paramabu = paramabu + ", BOTTLE_CHART_INSTALL";
        if ((i & 0x1000) == 0) {
          break label2179;
        }
        paramabu = paramabu + ",CHECKQQF_UNINSTALL";
        label1332:
        if ((i & 0x8000) == 0) {
          break label2203;
        }
        paramabu = paramabu + ",MM_FEEDSAPP_UNINSTALL";
        label1362:
        Log.i("MicroMsg.UserInfoSyncExtension", paramabu);
        localao.i(34, Integer.valueOf(paramae.RFu));
        if (1 != paramae.TGF.SsH) {
          break label2227;
        }
      }
      label1963:
      label2227:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localao.i(8200, Boolean.valueOf(Util.nullAs(Boolean.valueOf(paramBoolean), false)));
        localao.i(8201, Integer.valueOf(Util.nullAs(Integer.valueOf(paramae.TGF.SsI.SsL), 22)));
        localao.i(8208, Integer.valueOf(Util.nullAs(Integer.valueOf(paramae.TGF.SsI.SsM), 8)));
        localao.i(66049, Integer.valueOf(paramae.TxF));
        localao.i(66050, paramae.TxG);
        localao.i(40, Integer.valueOf(paramae.THk));
        bg.ltv.aS("last_login_use_voice", paramae.THk);
        localao.i(41, Integer.valueOf(paramae.TxJ));
        localao.i(43, paramae.TxI);
        Log.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramae.THk + " WeiboFlag:" + paramae.TxJ);
        localao.i(868518889, Integer.valueOf(paramae.TGU));
        Log.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramae.TGU);
        localao.i(42, paramae.mVD);
        Log.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramae.SwY + " username:" + paramae.SwZ);
        localao.i(65825, paramae.SwY);
        localao.i(65826, paramae.SwZ);
        Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramae.mVE);
        Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramae.mVF);
        Log.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramae.mVG);
        paramabu = Util.nullAsNil((String)h.aHG().aHp().b(65830, null));
        if ((paramabu == null) || (paramabu.length() == 0))
        {
          paramabu = paramae.THn;
          if ((paramabu != null) && (paramabu.length() > 0)) {
            h.aHG().aHp().i(65830, paramabu);
          }
        }
        af.b(1, paramae);
        break;
        paramabu = paramabu + ", QQMAIL_INSTALL";
        break label1010;
        paramabu = paramabu + ", PM_INSTALL";
        break label1038;
        paramabu = paramabu + ", FM_INSTALL";
        break label1066;
        label1987:
        paramabu = paramabu + ", WEIBO_INSTALL";
        break label1095;
        label2011:
        paramabu = paramabu + ", MEDIANOTE_INSTALL";
        break label1124;
        label2035:
        paramabu = paramabu + ", QMSG_INSTALL";
        break label1153;
        paramabu = paramabu + ", BOTTLE_INSTALL";
        break label1182;
        paramabu = paramabu + ", QSYNC_INSTALL";
        break label1212;
        label2107:
        paramabu = paramabu + ", SHAKE_INSTALL";
        break label1242;
        label2131:
        paramabu = paramabu + ", LBS_INSTALL";
        break label1272;
        label2155:
        paramabu = paramabu + ", BOTTLE_CHART_INSTALL";
        break label1302;
        paramabu = paramabu + ",CHECKQQF_INSTALL";
        break label1332;
        paramabu = paramabu + ",MM_FEEDSAPP_INSTALL";
        break label1362;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.i
 * JD-Core Version:    0.7.0.1
 */