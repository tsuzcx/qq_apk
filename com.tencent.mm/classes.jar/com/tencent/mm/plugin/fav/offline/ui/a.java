package com.tencent.mm.plugin.fav.offline.ui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private com.tencent.mm.plugin.fav.offline.b.a Afs;
  private Context context;
  
  public a(Context paramContext, com.tencent.mm.plugin.fav.offline.b.a parama)
  {
    this.context = paramContext;
    this.Afs = parama;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void doImgPreview(String paramString)
  {
    AppMethodBeat.i(73574);
    Object localObject1 = new u(Uri.parse(paramString));
    if (!((u)localObject1).jKS())
    {
      Log.i("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s no exist", new Object[] { paramString });
      AppMethodBeat.o(73574);
      return;
    }
    if (ImgUtil.isGif(ah.v(((u)localObject1).mUri)))
    {
      Log.d("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s is a gif", new Object[] { paramString });
      AppMethodBeat.o(73574);
      return;
    }
    Log.i("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s", new Object[] { paramString });
    Object localObject2 = Util.stringToList(this.Afs.field_imgPaths, ",");
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < ((List)localObject2).size())
    {
      String str = this.Afs.field_imgDirPath + "/" + (String)((List)localObject2).get(j);
      int m = k;
      int n = i;
      if (!ImgUtil.isGif(str))
      {
        localArrayList.add(str);
        if ((k != 0) || (Util.isNullOrNil(paramString)) || (!paramString.endsWith((String)((List)localObject2).get(j)))) {
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
      if (Util.isEqual((String)localArrayList.get(i), ((u)localObject1).getName())) {
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
    com.tencent.mm.plugin.webview.a.a.pFn.o((Intent)localObject1, this.context);
    AppMethodBeat.o(73574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.ui.a
 * JD-Core Version:    0.7.0.1
 */