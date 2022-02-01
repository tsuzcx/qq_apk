package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ae;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a
  extends c
{
  private static int wPp = 7200;
  private int dJY;
  private String mac;
  private String ssid;
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24842);
    dNu();
    this.dJY = 4;
    ae localae = (ae)this.rr.iLK.iLR;
    localae.OpCode = 4;
    localae.URL = paramString1;
    localae.KCx = paramInt;
    localae.KCy = paramString2;
    localae.KCz = m.dMK();
    localae.KCw = new LinkedList();
    paramString2 = new ei();
    paramString2.ssid = m.axM("MicroMsg.FreeWifi.NetSceneAPAuth");
    paramString2.mac = m.axN("MicroMsg.FreeWifi.NetSceneAPAuth");
    localae.KCw.add(paramString2);
    localae.KCA = m.axO("MicroMsg.FreeWifi.NetSceneAPAuth");
    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[] { Integer.valueOf(localae.KCz), paramString2.ssid, paramString2.mac });
    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[] { Integer.valueOf(4), paramString1 });
    AppMethodBeat.o(24842);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(24841);
    dNu();
    this.ssid = paramString3;
    this.mac = paramString2;
    this.dJY = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new ei();
    ((ei)localObject).ssid = paramString3;
    ((ei)localObject).mac = paramString2;
    ((ei)localObject).gNm = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ae)this.rr.iLK.iLR;
    ((ae)localObject).OpCode = 1;
    ((ae)localObject).KCw = localLinkedList;
    ((ae)localObject).URL = paramString1;
    ((ae)localObject).KCx = paramInt2;
    ((ae)localObject).KCy = paramString4;
    ((ae)localObject).KCA = m.axO("MicroMsg.FreeWifi.NetSceneAPAuth");
    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[] { Integer.valueOf(1), paramString2, paramString3, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24841);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    AppMethodBeat.i(24840);
    dNu();
    this.ssid = paramString2;
    this.mac = paramString3;
    ae localae = (ae)this.rr.iLK.iLR;
    String str = URLDecoder.decode(paramString5);
    localae.OpCode = 0;
    localae.URL = paramString1;
    localae.SSID = paramString2;
    localae.KCt = paramString4;
    localae.KCu = str;
    localae.KCv = paramString6;
    localae.KCx = paramInt;
    localae.KCy = paramString7;
    paramString7 = new LinkedList();
    ei localei = new ei();
    localei.ssid = paramString2;
    localei.mac = paramString3;
    paramString7.add(localei);
    localae.KCw = paramString7;
    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, str, paramString6 });
    AppMethodBeat.o(24840);
  }
  
  protected final void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24843);
    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.dJY) });
    switch (this.dJY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24843);
      return;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Object localObject = j.dNn().aya(this.ssid);
        paramString = this.ssid;
        dyj localdyj;
        if (localObject == null)
        {
          bool = true;
          Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get freewifi by ssid :%s, is wifi info = null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
          paramInt1 = 0;
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramInt1 = 1;
            paramString = new com.tencent.mm.plugin.freewifi.g.c();
            paramString.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
          }
          paramString.field_wifiType = 1;
          localObject = (af)this.rr.iLL.iLR;
          localdyj = ((af)localObject).KCF;
          if (localdyj == null) {
            break label470;
          }
          Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdyj.MXX, localdyj.MXY, localdyj.MXZ });
          paramString.field_showWordCn = localdyj.MXY;
          paramString.field_showWordEn = localdyj.MXX;
        }
        for (paramString.field_showWordTw = localdyj.MXZ;; paramString.field_showWordTw = MMApplicationContext.getContext().getResources().getString(2131760979))
        {
          paramString.field_action = ((af)localObject).KCD;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (((af)localObject).KCN <= 0) {
            ((af)localObject).KCN = wPp;
          }
          paramString.field_expiredTime = (Util.nowSecond() + ((af)localObject).KCN);
          paramString.field_showUrl = ((af)localObject).KCE;
          paramString.field_action = ((af)localObject).KCD;
          paramString.field_ssid = this.ssid;
          paramString.field_mac = this.mac;
          paramString.field_wifiType = 1;
          if (paramInt1 == 0) {
            break label524;
          }
          bool = j.dNn().insert(paramString);
          Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(bool) });
          Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((af)localObject).KCC), Integer.valueOf(((af)localObject).KCD), ((af)localObject).KCE });
          AppMethodBeat.o(24843);
          return;
          bool = false;
          break;
          label470:
          paramString.field_showWordCn = MMApplicationContext.getContext().getResources().getString(2131760979);
          paramString.field_showWordEn = MMApplicationContext.getContext().getResources().getString(2131760979);
        }
        label524:
        boolean bool = j.dNn().update(paramString, new String[0]);
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((af)localObject).KCC), Integer.valueOf(((af)localObject).KCD), ((af)localObject).KCE });
        AppMethodBeat.o(24843);
        return;
        localObject = j.dNn().aya(this.ssid);
        paramInt1 = 0;
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramInt1 = 1;
          paramString = new com.tencent.mm.plugin.freewifi.g.c();
          paramString.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
        }
        if ((paramInt2 == 0) && (paramInt3 == 0))
        {
          localObject = (af)this.rr.iLL.iLR;
          paramString.field_ssid = this.ssid;
          paramString.field_showUrl = ((af)localObject).KCE;
          localdyj = ((af)localObject).KCF;
          Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Integer.valueOf(((af)localObject).KCC), Integer.valueOf(((af)localObject).KCD), ((af)localObject).KCE });
          if (localdyj != null)
          {
            Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdyj.MXX, localdyj.MXY, localdyj.MXZ });
            paramString.field_showWordCn = localdyj.MXY;
            paramString.field_showWordEn = localdyj.MXX;
            paramString.field_showWordTw = localdyj.MXZ;
            paramString.field_action = ((af)localObject).KCD;
            paramString.field_verifyResult = 1;
            paramString.field_connectState = -1;
            if (((af)localObject).KCN <= 0) {
              ((af)localObject).KCN = wPp;
            }
            paramString.field_expiredTime = (Util.nowSecond() + ((af)localObject).KCN);
            paramString.field_mac = this.mac;
            if (paramInt1 == 0) {
              break label979;
            }
            Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.dNn().insert(paramString)) });
          }
          for (;;)
          {
            j.dNn().ayb(this.ssid);
            AppMethodBeat.o(24843);
            return;
            paramString.field_showWordCn = MMApplicationContext.getContext().getResources().getString(2131760979);
            paramString.field_showWordEn = MMApplicationContext.getContext().getResources().getString(2131760979);
            paramString.field_showWordTw = MMApplicationContext.getContext().getResources().getString(2131760979);
            break;
            label979:
            Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.dNn().update(paramString, new String[0])) });
          }
        }
        Log.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
        if (paramInt1 == 0)
        {
          bool = j.dNn().delete(paramString, new String[0]);
          Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
        }
      }
    }
  }
  
  public final String ahV()
  {
    af localaf = (af)this.rr.iLL.iLR;
    if (localaf != null) {
      return localaf.KCM;
    }
    return null;
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24839);
    d.a locala = new d.a();
    locala.iLN = new ae();
    locala.iLO = new af();
    locala.uri = "/cgi-bin/micromsg-bin/apauth";
    locala.funcId = 640;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24839);
  }
  
  public final String dNv()
  {
    af localaf = (af)this.rr.iLL.iLR;
    if (localaf != null) {
      return localaf.KCB;
    }
    return null;
  }
  
  public final dho dNw()
  {
    af localaf = (af)this.rr.iLL.iLR;
    if (localaf != null) {
      return localaf.KCI;
    }
    return null;
  }
  
  public final boolean dNx()
  {
    af localaf = (af)this.rr.iLL.iLR;
    if ((localaf != null) && (localaf.KCJ != null)) {
      return localaf.KCJ.KCz == 1;
    }
    return false;
  }
  
  public final bfr dNy()
  {
    af localaf = (af)this.rr.iLL.iLR;
    if (localaf != null) {
      return localaf.KCJ;
    }
    return null;
  }
  
  public final ih dNz()
  {
    af localaf = (af)this.rr.iLL.iLR;
    if (localaf != null) {
      return localaf.KCK;
    }
    return null;
  }
  
  public final String getOpenId()
  {
    af localaf = (af)this.rr.iLL.iLR;
    if (localaf != null) {
      return localaf.KCL;
    }
    return null;
  }
  
  public final int getType()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.a
 * JD-Core Version:    0.7.0.1
 */