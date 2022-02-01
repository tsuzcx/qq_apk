package com.tencent.mm.plugin.fav.offline.ui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private Context context;
  private com.tencent.mm.plugin.fav.offline.b.a rDh;
  
  public a(Context paramContext, com.tencent.mm.plugin.fav.offline.b.a parama)
  {
    this.context = paramContext;
    this.rDh = parama;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void doImgPreview(String paramString)
  {
    AppMethodBeat.i(73574);
    Object localObject1 = new k(Uri.parse(paramString));
    if (!((k)localObject1).exists())
    {
      ae.i("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s no exist", new Object[] { paramString });
      AppMethodBeat.o(73574);
      return;
    }
    if (u.aRG(w.B(((k)localObject1).mUri)))
    {
      ae.d("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s is a gif", new Object[] { paramString });
      AppMethodBeat.o(73574);
      return;
    }
    ae.i("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s", new Object[] { paramString });
    Object localObject2 = bu.lV(this.rDh.field_imgPaths, ",");
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < ((List)localObject2).size())
    {
      String str = this.rDh.field_imgDirPath + "/" + (String)((List)localObject2).get(j);
      int m = k;
      int n = i;
      if (!u.aRG(str))
      {
        localArrayList.add(str);
        if ((k != 0) || (bu.isNullOrNil(paramString)) || (!paramString.endsWith((String)((List)localObject2).get(j)))) {
          break label252;
        }
        m = 1;
        n = i;
      }
      for (;;)
      {
        j += 1;
        k = m;
        i = n;
        break;
        label252:
        m = k;
        n = i;
        if (k == 0)
        {
          n = i + 1;
          m = k;
        }
      }
    }
    localObject2 = new String[localArrayList.size()];
    k = 0;
    j = i;
    i = k;
    while (i < localArrayList.size())
    {
      localObject2[i] = ((String)localArrayList.get(i));
      if (bu.lX((String)localArrayList.get(i), ((k)localObject1).getName())) {
        j = i;
      }
      i += 1;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("nowUrlPath", paramString);
    ((Intent)localObject1).putExtra("nowUrl", localObject2[j]);
    ((Intent)localObject1).putExtra("urlList", (String[])localObject2);
    ((Intent)localObject1).putExtra("type", -255);
    ((Intent)localObject1).putExtra("isFromWebView", true);
    ((Intent)localObject1).putExtra("currentPos", j);
    ((Intent)localObject1).putExtra("shouldShowScanQrCodeMenu", false);
    if ((this.context instanceof Service)) {
      ((Intent)localObject1).addFlags(268435456);
    }
    paramString = new Bundle();
    paramString.putInt("stat_scene", 4);
    paramString.putString("stat_url", "");
    ((Intent)localObject1).putExtra("_stat_obj", paramString);
    com.tencent.mm.plugin.webview.a.a.iUz.q((Intent)localObject1, this.context);
    AppMethodBeat.o(73574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.ui.a
 * JD-Core Version:    0.7.0.1
 */