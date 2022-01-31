package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.l.a.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class a
{
  private static final a gRU = new a.1();
  private static final HashMap<i, a> gRV = new HashMap();
  private final i gRW;
  private int gRX = 0;
  private int gRY;
  private a.a gRZ = a.a.gSc;
  
  private a(final i parami)
  {
    this.gRW = parami;
    if (parami == null) {
      return;
    }
    g.a(parami.mAppId, new g.b()
    {
      public final void onDestroy()
      {
        a.AD().remove(parami);
      }
    });
  }
  
  static void a(q paramq)
  {
    if (paramq == null) {
      return;
    }
    a locala = t(paramq.getRuntime());
    y.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "applyToUpcomingPage, textId: %d, status: %s", new Object[] { Integer.valueOf(locala.gRY), locala.gRZ });
    paramq.kZ(locala.gRY);
    paramq.gTC.setOptionBtnStatus(locala.gRZ);
  }
  
  public static a t(i parami)
  {
    if (parami == null) {
      localObject = gRU;
    }
    a locala;
    do
    {
      return localObject;
      locala = (a)gRV.get(parami);
      localObject = locala;
    } while (locala != null);
    Object localObject = new a(parami);
    gRV.put(parami, localObject);
    return localObject;
  }
  
  public int a(int paramInt, a.a parama)
  {
    try
    {
      y.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "blinkSubTitle, status: %s", new Object[] { parama });
      this.gRW.Zz().getCurrentPage().getCurrentPageView().kZ(paramInt);
      this.gRW.Zz().getCurrentPage().getCurrentPageView().gTC.setOptionBtnStatus(parama);
      this.gRY = paramInt;
      this.gRZ = parama;
      paramInt = this.gRX + 1;
      this.gRX = paramInt;
      return paramInt;
    }
    catch (NullPointerException parama) {}
    return 0;
  }
  
  public final int a(a.a parama)
  {
    int j = 0;
    int i = j;
    switch (a.3.gSb[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      return a(i, parama);
      i = a.f.luggage_app_brand_jsapi_getting_location;
      continue;
      i = a.f.luggage_app_brand_jsapi_recording;
    }
  }
  
  public void lX(int paramInt)
  {
    y.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "dismissBlink, seq: %d, currentSeq: %d, status: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.gRX), this.gRZ });
    if (paramInt == this.gRX) {}
    try
    {
      this.gRW.Zz().getCurrentPage().getCurrentPageView().kZ(0);
      q.runOnUiThread(new q.14(this.gRW.Zz().getCurrentPage().getCurrentPageView(), a.a.gSc));
      label86:
      this.gRY = 0;
      this.gRZ = a.a.gSc;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label86;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */