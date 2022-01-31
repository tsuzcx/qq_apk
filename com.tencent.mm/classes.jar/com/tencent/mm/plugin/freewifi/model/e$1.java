package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class e$1
  implements f
{
  e$1(e parame, cd paramcd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (com.tencent.mm.plugin.freewifi.m.cR(paramInt1, paramInt2))
    {
      long l = ((d)paramm).aUx().sMM;
      if (l == 0L) {
        y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
      }
      for (;;)
      {
        return;
        paramString = this.koy;
        Object localObject1 = this.hSJ;
        paramm = ((d)paramm).aUx();
        if ((localObject1 == null) || (((cd)localObject1).svH == null))
        {
          y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
          return;
        }
        Object localObject2 = aa.a(((cd)localObject1).svH);
        y.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(((cd)localObject1).ndp), localObject2 });
        if (com.tencent.mm.plugin.freewifi.m.isEmpty((String)localObject2))
        {
          y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
          return;
        }
        localObject1 = com.tencent.mm.plugin.freewifi.c.a.Ds((String)localObject2);
        if (localObject1 == null)
        {
          y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
          return;
        }
        localObject2 = new com.tencent.mm.plugin.freewifi.f.a();
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqc = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).koh;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqe = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).koi;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqd = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).bssid;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqi = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).ssid;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqm = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).kok;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqg = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).kog;
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqf = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).koj;
        Object localObject3 = com.tencent.mm.plugin.freewifi.m.Dq("MicroMsg.FreeWifi.FreeWifiMessageService");
        ((com.tencent.mm.plugin.freewifi.f.a)localObject2).bHJ = ((String)localObject3);
        label325:
        label361:
        label368:
        boolean bool;
        if (((String)localObject3).equals(((com.tencent.mm.plugin.freewifi.c.a)localObject1).kog) == true)
        {
          paramInt1 = 0;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqh = paramInt1;
          localObject3 = com.tencent.mm.plugin.freewifi.m.Do("MicroMsg.FreeWifi.FreeWifiMessageService");
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqj = ((String)localObject3);
          if (((String)localObject3).equals(((com.tencent.mm.plugin.freewifi.c.a)localObject1).ssid) != true) {
            break label501;
          }
          paramInt1 = 0;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqk = paramInt1;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kql = l;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqm = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).kok;
          if (l <= ((com.tencent.mm.plugin.freewifi.c.a)localObject1).kok) {
            break label506;
          }
          paramInt1 = 1;
          if (paramInt1 != 1) {
            break label511;
          }
          paramInt2 = 1;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqn = paramInt2;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqr = paramm.sMD;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqs = ((String)localObject3);
          bool = ((String)localObject3).equals(paramm.sMD);
          if (!bool) {
            break label516;
          }
        }
        label516:
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqt = paramInt2;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqo = 1;
          ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqp = paramm.sML;
          localObject1 = ((com.tencent.mm.plugin.freewifi.c.a)localObject1).koj;
          if (!com.tencent.mm.plugin.freewifi.m.isEmpty((String)localObject1))
          {
            localObject3 = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher((CharSequence)localObject1);
            if (((Matcher)localObject3).find()) {
              ((com.tencent.mm.plugin.freewifi.f.a)localObject2).kqq = ((Matcher)localObject3).group(2);
            }
          }
          e.a((com.tencent.mm.plugin.freewifi.f.a)localObject2);
          if (bool) {
            break label521;
          }
          y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
          return;
          paramInt1 = 1;
          break;
          label501:
          paramInt1 = 1;
          break label325;
          label506:
          paramInt1 = 0;
          break label361;
          label511:
          paramInt2 = 0;
          break label368;
        }
        label521:
        if (paramInt1 != 0)
        {
          y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
          return;
        }
        if ((paramm.sML == 0) && (!com.tencent.mm.plugin.freewifi.m.isEmpty((String)localObject1)))
        {
          localObject3 = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher((CharSequence)localObject1);
          if (((Matcher)localObject3).find())
          {
            localObject2 = ((Matcher)localObject3).group(1);
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
              if (!paramString.kox.equals(localObject1))
              {
                paramString.kox = ((String)localObject1);
                b.aUE();
                b.G((Intent)localObject2);
                return;
              }
            }
            catch (UnsupportedEncodingException paramString)
            {
              y.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", new Object[] { "", Integer.valueOf(0), localObject1, localObject2, paramString.getMessage() });
              return;
            }
          }
        }
      }
    }
    paramString = new com.tencent.mm.plugin.freewifi.f.a();
    paramString.kqb = paramInt2;
    paramString.kqa = paramInt1;
    e.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.e.1
 * JD-Core Version:    0.7.0.1
 */