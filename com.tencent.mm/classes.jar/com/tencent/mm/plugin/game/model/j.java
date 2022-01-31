package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public final class j
  implements m
{
  private static Set<a> jmL;
  private static j nmD;
  private static HashMap<String, j.b> nmE;
  
  static
  {
    AppMethodBeat.i(111270);
    nmD = null;
    jmL = Collections.synchronizedSet(new HashSet());
    nmE = new HashMap();
    AppMethodBeat.o(111270);
  }
  
  private void A(long paramLong, int paramInt)
  {
    AppMethodBeat.i(111255);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    j.b localb;
    int i;
    if (locala != null)
    {
      localb = (j.b)nmE.get(locala.field_downloadUrl);
      switch (paramInt)
      {
      default: 
        i = 0;
        Object localObject = new b();
        ((b)localObject).i(locala);
        com.tencent.mm.plugin.downloader.f.a.a(i, (b)localObject);
        if ((locala.field_status == 2) || (locala.field_status == 5) || (locala.field_status == 4) || (locala.field_status == 3) || (locala.field_status == 0))
        {
          paramLong = locala.field_downloadId;
          ab.d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
          localObject = ah.getContext().getSharedPreferences("download_pref", 0);
          if (localObject != null) {
            ((SharedPreferences)localObject).edit().remove(String.valueOf(paramLong)).apply();
          }
        }
        if (localb == null) {
          com.tencent.mm.plugin.downloader.f.a.a(locala.field_appId, locala.field_scene, i, locala.field_md5, locala.field_downloadUrl, "", locala.field_extInfo);
        }
        break;
      }
    }
    for (;;)
    {
      al.d(new j.2(this, paramInt, locala.field_appId));
      AppMethodBeat.o(111255);
      return;
      int j = 1;
      com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 0L);
      i = j;
      if (localb == null) {
        break;
      }
      if (localb.nmI)
      {
        com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 1L);
        i = j;
        break;
      }
      com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 2L);
      i = j;
      break;
      i = 7;
      com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 4L);
      break;
      i = 6;
      com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 3L);
      break;
      com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 5L);
      i = 2;
      break;
      com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 6L);
      i = 3;
      break;
      i = 8;
      com.tencent.mm.plugin.downloader.f.a.I(locala.field_appId, 7L);
      break;
      com.tencent.mm.plugin.downloader.f.a.a(localb.appId, localb.scene, i, localb.cqq, locala.field_downloadUrl, localb.nmH, localb.cpH);
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(111251);
    synchronized (jmL)
    {
      jmL.add(parama);
      AppMethodBeat.o(111251);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(111267);
    int i;
    if (paramInt != 710)
    {
      i = paramInt;
      if (paramInt != 711) {}
    }
    else
    {
      i = com.tencent.mm.plugin.downloader.a.a.kVx;
    }
    ab.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[] { paramString1, Integer.valueOf(i) });
    if (!paramBoolean)
    {
      ((com.tencent.mm.plugin.game.api.d)g.E(com.tencent.mm.plugin.game.api.d.class)).bEQ();
      t.b(paramString1, 2, i, null, paramString2);
      AppMethodBeat.o(111267);
      return;
    }
    ((com.tencent.mm.plugin.game.api.d)g.E(com.tencent.mm.plugin.game.api.d.class)).bEQ();
    t.b(paramString1, 4, i, null, paramString2);
    AppMethodBeat.o(111267);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(111256);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(111256);
      return;
    }
    paramString2 = new j.b(paramString2, paramInt, paramString3, "", paramString4);
    paramString2.nmI = true;
    nmE.put(paramString1, paramString2);
    AppMethodBeat.o(111256);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(111258);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(111258);
      return;
    }
    nmE.put(paramString1, new j.b(paramString2, paramInt, paramString3, paramString4, paramString5));
    AppMethodBeat.o(111258);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(111252);
    synchronized (jmL)
    {
      jmL.remove(parama);
      ab.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[] { Integer.valueOf(jmL.size()), parama });
      AppMethodBeat.o(111252);
      return;
    }
  }
  
  public static j bGh()
  {
    AppMethodBeat.i(111250);
    if (nmD == null) {
      nmD = new j();
    }
    j localj = nmD;
    AppMethodBeat.o(111250);
    return localj;
  }
  
  public static void bje()
  {
    AppMethodBeat.i(111253);
    if (nmD == null) {
      nmD = new j();
    }
    com.tencent.mm.plugin.downloader.b.a.a(new j.1());
    f.bjl();
    c.a(nmD);
    AppMethodBeat.o(111253);
  }
  
  public static void bjf()
  {
    AppMethodBeat.i(111254);
    f.bjl();
    c.b(nmD);
    nmD = null;
    jmL.clear();
    nmE.clear();
    AppMethodBeat.o(111254);
  }
  
  private static void e(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111266);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    String str2;
    String str1;
    if (locala != null)
    {
      str2 = null;
      str1 = null;
      if (paramInt == com.tencent.mm.plugin.downloader.a.a.kVv) {
        str1 = str2;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      localJSONObject.put("ChannelId", locala.field_channelId);
      str1 = str2;
      localJSONObject.put("DownloadSize", locala.field_downloadedSize);
      str1 = str2;
      str2 = com.tencent.mm.plugin.game.e.a.lR(localJSONObject.toString());
      str1 = str2;
      ab.d("MicroMsg.GameDownloadEventBus", "extInfo = " + localJSONObject.toString());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + localException.getMessage());
      }
    }
    a(locala.field_appId, paramInt, paramBoolean, str1);
    AppMethodBeat.o(111266);
  }
  
  public static void eE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(111268);
    ((com.tencent.mm.plugin.game.api.d)g.E(com.tencent.mm.plugin.game.api.d.class)).bEQ();
    t.b(paramString1, 6, 0, null, paramString2);
    AppMethodBeat.o(111268);
  }
  
  public static void n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(111257);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(111257);
      return;
    }
    nmE.put(paramString1, new j.b(paramString2, 1002, paramString3, "", paramString4));
    AppMethodBeat.o(111257);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111261);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi) && (!at.isWifi(ah.getContext())))
    {
      ab.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
      locala.field_status = 2;
      locala.field_errCode = 0;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      b localb = new b();
      localb.i(locala);
      com.tencent.mm.plugin.downloader.f.a.a(13, localb);
      AppMethodBeat.o(111261);
      return;
    }
    A(paramLong, 5);
    e(paramLong, paramInt, paramBoolean);
    com.tencent.mm.plugin.game.c.a.kk(paramLong);
    com.tencent.mm.plugin.downloader.model.a.iy(paramLong);
    AppMethodBeat.o(111261);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111260);
    ab.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.vfs.e.cN(paramString)) });
    if ((!bo.isNullOrNil(paramString)) && (com.tencent.mm.vfs.e.cN(paramString)))
    {
      A(paramLong, 3);
      if (paramBoolean)
      {
        paramString = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
        if (paramString != null)
        {
          paramString = paramString.field_appId;
          ((com.tencent.mm.plugin.game.api.d)g.E(com.tencent.mm.plugin.game.api.d.class)).bEQ();
          t.b(paramString, 5, 0, null, null);
        }
      }
      com.tencent.mm.plugin.game.c.a.kk(paramLong);
      AppMethodBeat.o(111260);
      return;
    }
    paramString = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if (paramString != null)
    {
      paramString.field_status = 4;
      paramString.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVy;
      com.tencent.mm.plugin.downloader.model.d.e(paramString);
    }
    b(paramLong, com.tencent.mm.plugin.downloader.a.a.kVy, paramBoolean);
    if (paramString != null) {
      com.tencent.mm.plugin.downloader.f.a.I(paramString.field_appId, 9L);
    }
    AppMethodBeat.o(111260);
  }
  
  public final void hx(long paramLong)
  {
    AppMethodBeat.i(111264);
    A(paramLong, 6);
    AppMethodBeat.o(111264);
  }
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(111265);
    A(paramLong, 7);
    AppMethodBeat.o(111265);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(111263);
    A(paramLong, 2);
    AppMethodBeat.o(111263);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(111262);
    A(paramLong, 4);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if (locala != null) {
      e.as(ah.getContext(), locala.field_appId);
    }
    AppMethodBeat.o(111262);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(111259);
    A(paramLong, 1);
    AppMethodBeat.o(111259);
  }
  
  public static abstract interface a
  {
    public abstract void f(int paramInt, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.j
 * JD-Core Version:    0.7.0.1
 */