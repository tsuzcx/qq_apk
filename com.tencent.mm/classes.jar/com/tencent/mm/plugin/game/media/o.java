package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  implements g
{
  private static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, int paramInt2, Bundle paramBundle, int paramInt3)
  {
    AppMethodBeat.i(204139);
    Log.i("MicroMsg.Haowan.GameVideoEditorLauncher", "goToEditor, from[%d], businessType[%s], appid[%s], videoPath[%s], videoUrl[%s], needEdit[%b], gameInfo[%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4, Boolean.valueOf(paramBoolean), paramString6 });
    Intent localIntent = new Intent();
    localIntent.putExtra("from", paramInt1);
    localIntent.putExtra("business_type", paramString1);
    localIntent.putExtra("appid", paramString2);
    localIntent.putExtra("video_path", paramString3);
    localIntent.putExtra("video_url", paramString4);
    localIntent.putExtra("thumb_url", paramString5);
    localIntent.putExtra("need_edit", paramBoolean);
    localIntent.putExtra("game_info", paramString6);
    localIntent.putExtra("ext_data", paramBundle);
    localIntent.putExtra("game_haowan_source_scene_id", paramInt3);
    paramString5 = paramContext;
    if (paramContext == null) {
      paramString5 = MMApplicationContext.getContext();
    }
    if ((!Util.isNullOrNil(paramString3)) && (s.YS(paramString3))) {
      paramInt1 = 0;
    }
    while (paramInt1 != 0) {
      if ((paramString5 instanceof Activity))
      {
        c.b(paramString5, "game", ".media.GameVideoDownloadUI", localIntent, paramInt2);
        AppMethodBeat.o(204139);
        return;
        if (!Util.isNullOrNil(paramString4))
        {
          if (paramBoolean) {
            paramInt1 = 1;
          } else {
            paramInt1 = 0;
          }
        }
        else
        {
          Log.e("MicroMsg.Haowan.GameVideoEditorLauncher", "videoPath and videoUrl is invalid");
          if (paramInt1 == 3) {
            n.d(paramString1, "videoPath and videoUrl is invalid", paramString2, -3, "videoPath and videoUrl is invalid");
          }
          AppMethodBeat.o(204139);
        }
      }
      else
      {
        c.b(MMApplicationContext.getContext(), "game", ".media.GameVideoDownloadUI", localIntent);
        AppMethodBeat.o(204139);
        return;
      }
    }
    if ((paramString5 instanceof Activity))
    {
      c.b(paramString5, "game", ".media.GameVideoEditorProxyUI", localIntent, paramInt2);
      AppMethodBeat.o(204139);
      return;
    }
    c.b(MMApplicationContext.getContext(), "game", ".media.GameVideoEditorProxyUI", localIntent);
    AppMethodBeat.o(204139);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, Bundle paramBundle, int paramInt3)
  {
    AppMethodBeat.i(204138);
    a(paramContext, paramInt1, null, paramString1, paramString2, paramString3, paramString4, true, null, paramInt2, paramBundle, paramInt3);
    AppMethodBeat.o(204138);
  }
  
  public final void a(Context paramContext, String paramString, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(204136);
    a(paramContext, 4, null, null, paramString, null, null, true, null, paramInt1, paramBundle, paramInt2);
    AppMethodBeat.o(204136);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204137);
    a(paramContext, 5, null, paramString3, null, paramString1, paramString2, true, null, paramInt1, null, paramInt2);
    AppMethodBeat.o(204137);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(174302);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appName", paramString2);
      a(paramContext, 2, null, paramString1, paramString3, null, null, true, localJSONObject.toString(), paramInt, paramBundle, 30);
      AppMethodBeat.o(174302);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Haowan.GameVideoEditorLauncher", paramString2, "hy: put appname failed!", new Object[0]);
      }
    }
  }
  
  public final void ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(41143);
    Log.i("MicroMsg.Haowan.GameVideoEditorLauncher", "businessType:%s; appid:%s; extInfo:%s", new Object[] { paramString1, paramString2, paramString3 });
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString3);
        str1 = ((JSONObject)localObject).optString("videoPath");
        str2 = ((JSONObject)localObject).optString("videoUrl");
        str3 = ((JSONObject)localObject).optString("thumbUrl");
        if (((JSONObject)localObject).optInt("needEdit", 0) == 1)
        {
          bool = true;
          paramString3 = "";
        }
      }
      catch (Exception paramString3)
      {
        Object localObject;
        String str1;
        String str2;
        String str3;
        n.d(paramString1, "json is invalid", paramString2, -3, "json is invalid");
        AppMethodBeat.o(41143);
        return;
      }
      try
      {
        localObject = URLEncoder.encode(((JSONObject)localObject).optString("gameInfo"), "UTF-8");
        paramString3 = (String)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.i("MicroMsg.Haowan.GameVideoEditorLauncher", "err:%s", new Object[] { localUnsupportedEncodingException.getMessage() });
        continue;
      }
      a(null, 3, paramString1, paramString2, str1, str2, str3, bool, paramString3, 0, null, 12);
      AppMethodBeat.o(41143);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.o
 * JD-Core Version:    0.7.0.1
 */