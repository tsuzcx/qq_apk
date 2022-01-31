package com.tencent.mm.app.plugin.a;

import android.os.Looper;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.a.eb;
import com.tencent.mm.h.a.ji;
import com.tencent.mm.h.a.rb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.x;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private String byA;
  public Map<String, Boolean> byB;
  public boolean byC;
  public com.tencent.mm.ui.chatting.c.a byx;
  public a.b byy;
  public a.a byz;
  
  public a(com.tencent.mm.ui.chatting.c.a parama)
  {
    y.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.byx = parama;
    this.byC = true;
    if (this.byy == null) {
      this.byy = new a.b(this);
    }
    com.tencent.mm.sdk.b.a.udP.c(this.byy);
    if (this.byz == null) {
      this.byz = new a.a(this);
    }
    com.tencent.mm.sdk.b.a.udP.c(this.byz);
  }
  
  public static boolean a(d paramd)
  {
    if (paramd == null) {}
    do
    {
      do
      {
        return false;
      } while (paramd == null);
      paramd = paramd.bS(false);
    } while ((paramd == null) || (paramd.LS() == null) || (!paramd.LS().Mc()));
    return true;
  }
  
  public final void a(final int paramInt, d paramd)
  {
    if (this.byx == null) {
      y.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
    }
    while ((!s.hl(this.byx.getTalkerUserName())) || (!a(paramd))) {
      return;
    }
    au.DS().O(new Runnable()
    {
      public final void run()
      {
        if (1 == paramInt)
        {
          localObject = new eb();
          ((eb)localObject).bKB.op = 0;
          ((eb)localObject).bKB.userName = a.this.byx.getTalkerUserName();
          ((eb)localObject).bKB.context = a.this.byx.vtz.getContext();
          com.tencent.mm.sdk.b.a.udP.m((b)localObject);
          if (a.this.byx.getTalkerUserName().equals("gh_43f2581f6fd6"))
          {
            localObject = new rb();
            ((rb)localObject).cap.action = 1;
            com.tencent.mm.sdk.b.a.udP.a((b)localObject, Looper.getMainLooper());
          }
        }
        Object localObject = new ji();
        ((ji)localObject).bRE.opType = paramInt;
        ((ji)localObject).bRE.bRG = 1;
        ((ji)localObject).bRE.bRF = a.this.byx.getTalkerUserName();
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      }
    });
  }
  
  final void d(int paramInt, String paramString1, String paramString2)
  {
    for (;;)
    {
      d locald;
      try
      {
        y.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.byx == null) || (bk.bl(paramString1)))
        {
          y.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          return;
        }
        locald = f.kX(paramString1);
        if (!a(locald))
        {
          y.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          continue;
        }
        if (this.byB != null) {
          break label99;
        }
      }
      finally {}
      this.byB = new HashMap();
      label99:
      Map localMap = this.byB;
      if (!paramString1.equals(this.byA))
      {
        this.byA = paramString1;
        localMap.clear();
      }
      if (locald.bS(false).LS().efG == 1)
      {
        this.byx.vtz.setMMSubTitle(null);
      }
      else
      {
        y.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[] { localMap, paramString2 });
        switch (paramInt)
        {
        case -1: 
          this.byx.vtz.setMMSubTitle(null);
          break;
        case 0: 
          if (localMap.size() == 0) {
            this.byx.vtz.setMMSubTitle(R.l.exdevice_device_status_none);
          }
          break;
        case 2: 
          localMap.put(paramString2, Boolean.valueOf(true));
          this.byx.vtz.setMMSubTitle(this.byx.vtz.getString(R.l.exdevice_device_status_connected, new Object[] { Integer.valueOf(localMap.size()) }));
          y.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
          break;
        case 4: 
          if (localMap.remove(paramString2) != null) {
            y.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
          }
          this.byx.vtz.setMMSubTitle(this.byx.vtz.getString(R.l.exdevice_device_status_connected, new Object[] { Integer.valueOf(localMap.size()) }));
          break;
        case 1: 
          if (localMap.size() == 0) {
            this.byx.vtz.setMMSubTitle(R.l.exdevice_device_status_connecting);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */