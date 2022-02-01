package com.tencent.mm.plugin.finder.live.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.f.c;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/FinderJumperUtils;", "", "()V", "jumpBizProfile", "", "context", "Landroid/content/Context;", "necessaryParams", "Lorg/json/JSONObject;", "jumpCoupon", "jumpSearch", "feedId", "", "jumpTopic", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l DJa;
  
  static
  {
    AppMethodBeat.i(351327);
    DJa = new l();
    AppMethodBeat.o(351327);
  }
  
  public static void b(Context paramContext, JSONObject paramJSONObject)
  {
    localObject3 = null;
    AppMethodBeat.i(351287);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "necessaryParams");
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("bizUsername") == true)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          str = paramJSONObject.getString("bizUsername");
        }
      }
      catch (Exception localException)
      {
        String str;
        Object localObject2;
        Log.printDebugStack("safeGetString", "", new Object[] { localException });
        Object localObject1 = null;
        continue;
        int i = 0;
        continue;
        localObject1 = null;
        continue;
      }
      try
      {
        if (paramJSONObject.has("nickname") != true) {
          continue;
        }
        i = 1;
        localObject2 = localObject3;
        if (i != 0) {
          localObject2 = paramJSONObject.getString("nickname");
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        localObject2 = localObject3;
        continue;
      }
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("Contact_User", str);
      paramJSONObject.putExtra("Contact_Nick", (String)localObject2);
      paramJSONObject.putExtra("force_get_contact", true);
      paramJSONObject.putExtra("key_use_new_contact_profile", true);
      c.b(paramContext, "profile", ".ui.ContactInfoUI", paramJSONObject);
      AppMethodBeat.o(351287);
      return;
      i = 0;
    }
  }
  
  public static void c(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(351293);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "necessaryParams");
    localObject2 = null;
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("cardId") != true) {
          continue;
        }
        i = 1;
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = paramJSONObject.getString("cardId");
        }
      }
      catch (Exception paramJSONObject)
      {
        int i;
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        Object localObject1 = localObject2;
        continue;
      }
      paramJSONObject = new Intent(paramContext, f.c.class);
      paramJSONObject.putExtra("key_card_id", (String)localObject1);
      paramJSONObject.putExtra("key_card_ext", "");
      c.b(paramContext, "card", ".ui.CardDetailUI", paramJSONObject);
      AppMethodBeat.o(351293);
      return;
      i = 0;
    }
  }
  
  public static void d(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(351303);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "necessaryParams");
    ((f)h.ax(f.class)).a(paramContext, paramJSONObject);
    AppMethodBeat.o(351303);
  }
  
  public static void e(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(351316);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "necessaryParams");
    localObject2 = null;
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("topic") != true) {
          continue;
        }
        i = 1;
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = paramJSONObject.getString("topic");
        }
      }
      catch (Exception paramJSONObject)
      {
        int i;
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        Object localObject1 = localObject2;
        continue;
      }
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_topic_type", 1);
      paramJSONObject.putExtra("key_topic_title", (String)localObject1);
      ((f)h.ax(f.class)).A(paramContext, paramJSONObject);
      AppMethodBeat.o(351316);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.l
 * JD-Core Version:    0.7.0.1
 */