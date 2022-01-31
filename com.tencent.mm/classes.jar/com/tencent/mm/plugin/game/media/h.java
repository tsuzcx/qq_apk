package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  implements f
{
  private static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(151867);
    ab.i("MicroMsg.GameVideoEditorLauncher", "goToEditor, from[%d], businessType[%s], appid[%s], videoPath[%s], videoUrl[%s], needEdit[%b], gameInfo[%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4, Boolean.valueOf(paramBoolean), paramString6 });
    Intent localIntent = new Intent();
    localIntent.putExtra("from", paramInt1);
    localIntent.putExtra("business_type", paramString1);
    localIntent.putExtra("appid", paramString2);
    localIntent.putExtra("video_path", paramString3);
    localIntent.putExtra("video_url", paramString4);
    localIntent.putExtra("thumb_url", paramString5);
    localIntent.putExtra("game_info", paramString6);
    localIntent.putExtra("minigame_ext_data", paramBundle);
    paramString5 = paramContext;
    if (paramContext == null) {
      paramString5 = ah.getContext();
    }
    int i = 0;
    boolean bool = true;
    if (paramInt1 == 1) {
      if ((!bo.isNullOrNil(paramString3)) && (e.cN(paramString3)))
      {
        i = 0;
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      localIntent.putExtra("need_edit", paramBoolean);
      if (i == 0) {
        break label349;
      }
      if ((paramInt1 != 1) || (!bo.isNullOrNil(paramString4))) {
        break;
      }
      i.c(paramString1, "videoUrl is null", paramString2, -3, "videoUrl is null");
      AppMethodBeat.o(151867);
      return;
      if (!bo.isNullOrNil(paramString4))
      {
        if (paramBoolean)
        {
          i = 1;
          paramBoolean = bool;
        }
        else
        {
          i = 0;
          paramBoolean = false;
        }
      }
      else
      {
        i.c(paramString1, "videoPath and videoUrl is invalid", paramString2, -3, "videoPath and videoUrl is invalid");
        paramBoolean = bool;
        continue;
        paramBoolean = bool;
        if (paramInt1 == 4)
        {
          i = 1;
          paramBoolean = bool;
        }
      }
    }
    if ((paramString5 instanceof Activity))
    {
      d.b(paramString5, "game", ".media.GameVideoDownloadUI", localIntent, paramInt2);
      AppMethodBeat.o(151867);
      return;
    }
    d.b(ah.getContext(), "game", ".media.GameVideoDownloadUI", localIntent);
    AppMethodBeat.o(151867);
    return;
    label349:
    if ((paramString5 instanceof Activity))
    {
      d.b(paramString5, "game", ".media.GameVideoEditorProxyUI", localIntent, paramInt2);
      AppMethodBeat.o(151867);
      return;
    }
    d.b(ah.getContext(), "game", ".media.GameVideoEditorProxyUI", localIntent);
    AppMethodBeat.o(151867);
  }
  
  public final void U(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151863);
    ab.i("MicroMsg.GameVideoEditorLauncher", "businessType:%s; appid:%s; extInfo:%s", new Object[] { paramString1, paramString2, paramString3 });
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
        i.c(paramString1, "json is invalid", paramString2, -3, "json is invalid");
        AppMethodBeat.o(151863);
        return;
      }
      try
      {
        localObject = URLEncoder.encode(((JSONObject)localObject).optString("gameInfo"), "UTF-8");
        paramString3 = (String)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ab.i("MicroMsg.GameVideoEditorLauncher", "err:%s", new Object[] { localUnsupportedEncodingException.getMessage() });
        continue;
      }
      a(null, 1, paramString1, paramString2, str1, str2, str3, bool, paramString3, 0, null);
      AppMethodBeat.o(151863);
      return;
      boolean bool = false;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    AppMethodBeat.i(151864);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appName", paramString2);
      a(paramContext, 2, null, paramString1, paramString3, null, null, true, localJSONObject.toString(), 1000, paramBundle);
      AppMethodBeat.o(151864);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.GameVideoEditorLauncher", paramString2, "hy: put appname failed!", new Object[0]);
      }
    }
  }
  
  public final void ap(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151865);
    a(paramContext, 3, null, null, paramString, null, null, true, null, 4377, null);
    AppMethodBeat.o(151865);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(151866);
    a(paramContext, 4, null, paramString3, null, paramString1, paramString2, true, null, paramInt, null);
    AppMethodBeat.o(151866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */