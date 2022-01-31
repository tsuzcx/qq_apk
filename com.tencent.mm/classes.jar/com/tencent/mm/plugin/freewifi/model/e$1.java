package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.sd;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class e$1
  implements f
{
  e$1(e parame, cm paramcm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20717);
    ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (com.tencent.mm.plugin.freewifi.m.ep(paramInt1, paramInt2))
    {
      long l = ((d)paramm).bAX().wKz;
      if (l == 0L)
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
        AppMethodBeat.o(20717);
        return;
      }
      paramString = this.mKl;
      Object localObject1 = this.jMw;
      paramm = ((d)paramm).bAX();
      if ((localObject1 == null) || (((cm)localObject1).woR == null))
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
        AppMethodBeat.o(20717);
        return;
      }
      Object localObject2 = aa.a(((cm)localObject1).woR);
      ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(((cm)localObject1).pIG), localObject2 });
      if (com.tencent.mm.plugin.freewifi.m.isEmpty((String)localObject2))
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
        AppMethodBeat.o(20717);
        return;
      }
      localObject1 = com.tencent.mm.plugin.freewifi.c.a.OA((String)localObject2);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
        AppMethodBeat.o(20717);
        return;
      }
      localObject2 = new com.tencent.mm.plugin.freewifi.f.a();
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLO = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJU;
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLQ = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJV;
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLP = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).bssid;
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLU = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).ssid;
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLY = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJX;
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLS = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJT;
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLR = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJW;
      Object localObject3 = com.tencent.mm.plugin.freewifi.m.Oy("MicroMsg.FreeWifi.FreeWifiMessageService");
      ((com.tencent.mm.plugin.freewifi.f.a)localObject2).coY = ((String)localObject3);
      label355:
      boolean bool;
      if (((String)localObject3).equals(((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJT) == true)
      {
        paramInt1 = 0;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLT = paramInt1;
        localObject3 = com.tencent.mm.plugin.freewifi.m.Ow("MicroMsg.FreeWifi.FreeWifiMessageService");
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLV = ((String)localObject3);
        if (((String)localObject3).equals(((com.tencent.mm.plugin.freewifi.c.a)localObject1).ssid) != true) {
          break label537;
        }
        paramInt1 = 0;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLW = paramInt1;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLX = l;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLY = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJX;
        if (l <= ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJX) {
          break label542;
        }
        paramInt1 = 1;
        label391:
        if (paramInt1 != 1) {
          break label547;
        }
        paramInt2 = 1;
        label398:
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mLZ = paramInt2;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mMd = paramm.wKq;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mMe = ((String)localObject3);
        bool = ((String)localObject3).equals(paramm.wKq);
        if (!bool) {
          break label552;
        }
      }
      label537:
      label542:
      label547:
      label552:
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mMf = paramInt2;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mMa = 1;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mMb = paramm.wKy;
        localObject1 = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).mJW;
        if (!com.tencent.mm.plugin.freewifi.m.isEmpty((String)localObject1))
        {
          localObject3 = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher((CharSequence)localObject1);
          if (((Matcher)localObject3).find()) {
            ((com.tencent.mm.plugin.freewifi.f.a)localObject2).mMc = ((Matcher)localObject3).group(2);
          }
        }
        e.a((com.tencent.mm.plugin.freewifi.f.a)localObject2);
        if (bool) {
          break label557;
        }
        ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
        AppMethodBeat.o(20717);
        return;
        paramInt1 = 1;
        break;
        paramInt1 = 1;
        break label355;
        paramInt1 = 0;
        break label391;
        paramInt2 = 0;
        break label398;
      }
      label557:
      if (paramInt1 != 0)
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
        AppMethodBeat.o(20717);
        return;
      }
      if ((paramm.wKy == 0) && (!com.tencent.mm.plugin.freewifi.m.isEmpty((String)localObject1)))
      {
        localObject3 = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher((CharSequence)localObject1);
        if (((Matcher)localObject3).find()) {
          localObject2 = ((Matcher)localObject3).group(1);
        }
      }
      try
      {
        paramm = URLDecoder.decode((String)localObject2, "utf8");
        localObject1 = ((Matcher)localObject3).group(2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("free_wifi_ap_key", paramm);
        ((Intent)localObject2).putExtra("free_wifi_source", 5);
        ((Intent)localObject2).putExtra("free_wifi_threeone_startup_type", 3);
        ((Intent)localObject2).putExtra("free_wifi_schema_ticket", (String)localObject1);
        ((Intent)localObject2).putExtra("free_wifi_sessionkey", (String)localObject1);
        if (!paramString.mKk.equals(localObject1))
        {
          paramString.mKk = ((String)localObject1);
          b.bBe();
          b.Z((Intent)localObject2);
        }
        AppMethodBeat.o(20717);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", new Object[] { "", Integer.valueOf(0), localObject1, localObject2, paramString.getMessage() });
        AppMethodBeat.o(20717);
        return;
      }
    }
    paramString = new com.tencent.mm.plugin.freewifi.f.a();
    paramString.mLN = paramInt2;
    paramString.mLM = paramInt1;
    e.a(paramString);
    AppMethodBeat.o(20717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.e.1
 * JD-Core Version:    0.7.0.1
 */