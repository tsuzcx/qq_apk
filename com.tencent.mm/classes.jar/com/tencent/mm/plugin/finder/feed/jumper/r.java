package com.tencent.mm.plugin.finder.feed.jumper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.Html5Info;
import com.tencent.mm.protocal.protobuf.MiniAppInfo;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/JumperUtils;", "", "()V", "TAG", "", "checkNeedJumpTopic", "", "intent", "Landroid/content/Intent;", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "dispatchJump", "context", "Landroid/content/Context;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "entranceType", "", "getFeedPlayInfo", "Lkotlin/Pair;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isVideoPlayFinished", "", "getMutualTitle", "Landroid/text/SpannableString;", "cache", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderMutualJumpInfoCache;", "getTitle", "info", "jumpBizProfile", "necessaryParams", "Lorg/json/JSONObject;", "jumpCoupon", "jumpEvent", "eventName", "jumpH5", "jumpH5Full", "jumpH5WithUrl", "url", "jumpMiniApp", "jumpInfo", "source", "fromScene", "fromSceneNote", "weAppBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "jumpNative", "jumpSchema", "jumpSearch", "feedId", "", "jumpTopic", "jumpWeComKF", "username", "loadImage", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "preloadAdH5", "preloadAdMiniApp", "jumpInfoEx", "setFailImage", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r Bej;
  
  static
  {
    AppMethodBeat.i(364425);
    Bej = new r();
    AppMethodBeat.o(364425);
  }
  
  public static SpannableString a(com.tencent.mm.view.recyclerview.j paramj, l paraml)
  {
    AppMethodBeat.i(364352);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paraml, "cache");
    if (Util.isNullOrNil(paraml.BdX))
    {
      paraml = paraml.title;
      paramj = paraml;
      if (paraml == null) {
        paramj = (CharSequence)"";
      }
      paramj = new SpannableString(paramj);
      AppMethodBeat.o(364352);
      return paramj;
    }
    if (Util.isNullOrNil(paraml.title))
    {
      paraml = paraml.BdX;
      paramj = paraml;
      if (paraml == null) {
        paramj = (CharSequence)"";
      }
      paramj = new SpannableString(paramj);
      AppMethodBeat.o(364352);
      return paramj;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paraml.title).append(": ");
    paraml = paraml.BdX;
    paramj = paraml;
    if (paraml == null) {
      paramj = (CharSequence)"";
    }
    paramj = new SpannableString((CharSequence)paramj);
    AppMethodBeat.o(364352);
    return paramj;
  }
  
  public static String a(Context paramContext, FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(364382);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderJumpInfo, "info");
    String str = paramFinderJumpInfo.recommend_reason;
    Object localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      localObject = str;
      if (i != 0)
      {
        localObject = str;
        if (6 == paramFinderJumpInfo.business_type)
        {
          paramContext = paramContext.getResources();
          if (paramContext != null) {
            break label122;
          }
          paramContext = null;
          label74:
          localObject = paramContext;
        }
      }
      paramContext = (CharSequence)localObject;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label133;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramContext = paramFinderJumpInfo.wording;
        if (paramContext == null)
        {
          AppMethodBeat.o(364382);
          return "";
          i = 0;
          break;
          label122:
          paramContext = paramContext.getString(e.h.finder_jumper_emoji);
          break label74;
          label133:
          i = 0;
          continue;
        }
        AppMethodBeat.o(364382);
        return paramContext;
      }
    }
    paramContext = (CharSequence)paramFinderJumpInfo.wording;
    if ((paramContext == null) || (paramContext.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(364382);
      return localObject;
    }
    paramContext = localObject + ": " + paramFinderJumpInfo.wording;
    AppMethodBeat.o(364382);
    return paramContext;
  }
  
  public static kotlin.r<Integer, Integer> a(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(364394);
    kotlin.g.b.s.u(paramj, "holder");
    paramj = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    long l;
    int j;
    int i;
    if (paramj == null)
    {
      l = 0L;
      j = (int)(l / 1000L);
      if (paramj != null) {
        break label91;
      }
      i = 0;
      label43:
      if (!paramBoolean) {
        break label99;
      }
      j = i;
    }
    label91:
    label99:
    for (;;)
    {
      paramj = new kotlin.r(Integer.valueOf(i), Integer.valueOf((int)(j * 1.0F / i * 100.0F)));
      AppMethodBeat.o(364394);
      return paramj;
      l = paramj.getCurrentPosMs();
      break;
      i = paramj.getVideoDurationSec();
      break label43;
    }
  }
  
  private static void a(Context paramContext, long paramLong, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(364276);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramJSONObject, "necessaryParams");
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("object_hot_word") != true) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        localJSONObject = paramJSONObject.getJSONObject("object_hot_word");
      }
      catch (Exception localException1)
      {
        JSONObject localJSONObject;
        Log.printDebugStack("safeGetInt", "", new Object[] { localException1 });
        Object localObject2 = null;
        continue;
        try
        {
          if (((JSONObject)localObject2).has("hotword_text") == true)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            str1 = ((JSONObject)localObject2).getString("hotword_text");
            continue;
          }
          i = 0;
          continue;
        }
        catch (Exception localException2)
        {
          Log.printDebugStack("safeGetString", "", new Object[] { localException2 });
          localObject1 = null;
        }
        int i = 0;
        continue;
        Object localObject1 = null;
        continue;
      }
      localObject2 = localJSONObject;
      if (localObject2 != null) {
        continue;
      }
      localJSONObject = null;
      if (localObject2 != null) {}
      try
      {
        if (((JSONObject)localObject2).has("action_type") != true) {
          continue;
        }
        i = 1;
        if (i != 0) {
          ((JSONObject)localObject2).getInt("action_type");
        }
      }
      catch (Exception localException4)
      {
        String str2;
        Log.printDebugStack("safeGetInt", "", new Object[] { localException4 });
        continue;
        try
        {
          if (((JSONObject)localObject2).has("session_buffer") != true) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          localObject2 = ((JSONObject)localObject2).getString("session_buffer");
        }
        catch (Exception localException3)
        {
          Log.printDebugStack("safeGetString", "", new Object[] { localException3 });
          localObject3 = null;
          continue;
        }
        localObject4 = localObject2;
        if (localObject2 != null) {
          continue;
        }
        localObject4 = "";
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      if (localObject2 != null) {
        continue;
      }
      str2 = "";
      try
      {
        if (paramJSONObject.has("obj_hotword_info_buff") != true) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramJSONObject = paramJSONObject.getString("obj_hotword_info_buff");
      }
      catch (Exception paramJSONObject)
      {
        Intent localIntent;
        String str1;
        Object localObject4;
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        paramJSONObject = null;
        continue;
        paramJSONObject = null;
        continue;
        Object localObject3 = null;
        continue;
        localObject1 = null;
        continue;
      }
      localObject2 = paramJSONObject;
      if (paramJSONObject == null) {
        localObject2 = "";
      }
      localIntent = new Intent();
      if (!Util.isNullOrNil(localJSONObject))
      {
        paramJSONObject = localJSONObject;
        if (localJSONObject == null) {
          paramJSONObject = "";
        }
        localIntent.putExtra("key_search_query", paramJSONObject);
        localIntent.putExtra("key_search_session_buffer", Base64.decode(str2, 0));
        localIntent.putExtra("key_search_is_from_feed_list", true);
        localIntent.putExtra("key_search_feed_id", paramLong);
        localIntent.putExtra("key_search_hot_word_buffer", Base64.decode((String)localObject2, 0));
      }
      localIntent.putExtra("key_entrance_type", 1);
      paramJSONObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.b(paramContext, null, localIntent);
      AppMethodBeat.o(364276);
      return;
      i = 0;
    }
  }
  
  public static void a(Context paramContext, k paramk)
  {
    AppMethodBeat.i(364227);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramk, "infoEx");
    Object localObject = paramk.hVf.html5_info;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Html5Info)localObject).url)
    {
      a(paramContext, paramk, (String)localObject);
      AppMethodBeat.o(364227);
      return;
    }
  }
  
  public static void a(Context paramContext, k paramk, int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(364193);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramk, "infoEx");
    switch (paramk.hVf.jumpinfo_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(364193);
      return;
      a(paramContext, paramk.hVf, paramk.source, 0, paramk.hzx, paramk.Beb, 8);
      AppMethodBeat.o(364193);
      return;
      a(paramContext, paramk);
      AppMethodBeat.o(364193);
      return;
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramk, "infoEx");
      Object localObject1 = paramk.hVf.native_info;
      Integer localInteger;
      String str1;
      if (localObject1 == null)
      {
        localInteger = null;
        str1 = paramk.hVf.wording;
        localObject1 = paramk.hVf.native_info;
        if (localObject1 != null) {
          break label258;
        }
        localObject1 = "";
      }
      label258:
      Object localObject2;
      label301:
      label310:
      label332:
      label354:
      label377:
      do
      {
        do
        {
          long l;
          do
          {
            do
            {
              try
              {
                for (;;)
                {
                  localObject1 = new JSONObject((String)localObject1);
                  localObject3 = localObject1;
                  if (localObject1 == null) {
                    localObject3 = new JSONObject();
                  }
                  localObject1 = paramk.AUZ;
                  if (localObject1 != null) {
                    break label301;
                  }
                  l = 0L;
                  if (localInteger != null) {
                    break label310;
                  }
                  if (localInteger != null) {
                    break label332;
                  }
                  if (localInteger != null) {
                    break label354;
                  }
                  if (localInteger != null) {
                    break label377;
                  }
                  if (localInteger != null) {
                    break label400;
                  }
                  if (localInteger != null) {
                    break label456;
                  }
                  AppMethodBeat.o(364193);
                  return;
                  localInteger = Integer.valueOf(((NativeInfo)localObject1).native_type);
                  break;
                  String str2 = ((NativeInfo)localObject1).necessary_params;
                  localObject1 = str2;
                  if (str2 == null) {
                    localObject1 = "";
                  }
                }
              }
              catch (JSONException localJSONException)
              {
                do
                {
                  for (;;)
                  {
                    Log.e("Finder.JumperUtils", localJSONException.getMessage());
                    localObject2 = localObject3;
                    continue;
                    l = ((BaseFinderFeed)localObject2).bZA();
                  }
                } while (localInteger.intValue() != 1);
                b(paramContext, (JSONObject)localObject3);
                AppMethodBeat.o(364193);
                return;
              }
            } while (localInteger.intValue() != 2);
            c(paramContext, (JSONObject)localObject3);
            AppMethodBeat.o(364193);
            return;
          } while (localInteger.intValue() != 3);
          a(paramContext, l, (JSONObject)localObject3);
          AppMethodBeat.o(364193);
          return;
        } while (localInteger.intValue() != 4);
        a(paramContext, (JSONObject)localObject3, paramInt);
        AppMethodBeat.o(364193);
        return;
      } while (localInteger.intValue() != 7);
      label400:
      paramk = paramk.contact;
      if (paramk == null) {
        paramk = "";
      }
      for (;;)
      {
        a(paramContext, (JSONObject)localObject3, paramk);
        AppMethodBeat.o(364193);
        return;
        localObject2 = paramk.getUsername();
        paramk = (k)localObject2;
        if (localObject2 == null) {
          paramk = "";
        }
      }
      label456:
      if (localInteger.intValue() == 8) {
        if (str1 != null) {
          break label489;
        }
      }
      label489:
      for (paramk = "";; paramk = str1)
      {
        a(paramContext, (JSONObject)localObject3, paramk, paramInt);
        AppMethodBeat.o(364193);
        return;
      }
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramk, "infoEx");
    }
  }
  
  public static void a(Context paramContext, k paramk, String paramString)
  {
    AppMethodBeat.i(364240);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramk, "infoEx");
    Object localObject = paramk.hVf.html5_info;
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (paramString == null) {
        break label194;
      }
      CharSequence localCharSequence = (CharSequence)paramk.extra;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label100;
      }
      i = 1;
      label66:
      if (i == 0) {
        break label105;
      }
      label70:
      if (localObject != null) {
        break label135;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(364240);
        return;
        localObject = Integer.valueOf(((Html5Info)localObject).style);
        break;
        label100:
        i = 0;
        break label66;
        label105:
        paramString = paramString + '&' + paramk.extra;
        break label70;
        label135:
        if (((Integer)localObject).intValue() == 1)
        {
          com.tencent.mm.plugin.finder.webview.h.a(paramContext, paramString, paramk);
          AppMethodBeat.o(364240);
          return;
        }
      }
    }
    if (((Integer)localObject).intValue() == 2)
    {
      paramk = new Intent();
      paramk.putExtra("rawUrl", paramString);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramk);
    }
    label194:
    AppMethodBeat.o(364240);
  }
  
  private static void a(Context paramContext, FinderJumpInfo paramFinderJumpInfo, String paramString1, int paramInt, String paramString2, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(364217);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderJumpInfo, "jumpInfo");
    Object localObject1 = paramFinderJumpInfo.mini_app_info;
    Object localObject2;
    label49:
    String str;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = paramFinderJumpInfo.mini_app_info;
      if (localObject2 != null) {
        break label144;
      }
      localObject2 = "";
      localObject3 = paramFinderJumpInfo.mini_app_info;
      if (localObject3 != null) {
        break label166;
      }
      str = null;
      label63:
      if (((CharSequence)localObject1).length() != 0) {
        break label176;
      }
      i = 1;
      label79:
      if (i == 0) {
        break label188;
      }
      localObject3 = (CharSequence)str;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label182;
      }
    }
    label144:
    label166:
    label176:
    label182:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label188;
      }
      AppMethodBeat.o(364217);
      return;
      localObject2 = ((MiniAppInfo)localObject1).app_id;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject2 = ((MiniAppInfo)localObject2).path;
      if (localObject2 == null)
      {
        localObject2 = "";
        break label49;
      }
      break label49;
      str = ((MiniAppInfo)localObject3).appusername;
      break label63;
      i = 0;
      break label79;
    }
    label188:
    Object localObject3 = paramg;
    if (paramg == null) {
      localObject3 = new com.tencent.mm.plugin.appbrand.api.g();
    }
    ((com.tencent.mm.plugin.appbrand.api.g)localObject3).username = str;
    ((com.tencent.mm.plugin.appbrand.api.g)localObject3).appId = ((String)localObject1);
    ((com.tencent.mm.plugin.appbrand.api.g)localObject3).qAF = ((String)localObject2);
    i = paramInt;
    if (paramInt == 0) {}
    switch (paramFinderJumpInfo.business_type)
    {
    default: 
      i = 111166;
      ((com.tencent.mm.plugin.appbrand.api.g)localObject3).scene = i;
      paramFinderJumpInfo = (CharSequence)paramString2;
      if ((paramFinderJumpInfo != null) && (paramFinderJumpInfo.length() != 0)) {
        break;
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        paramFinderJumpInfo = e.BdD;
        paramString2 = String.valueOf(e.avS(paramString1));
      }
      ((com.tencent.mm.plugin.appbrand.api.g)localObject3).hzx = paramString2;
      ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, (com.tencent.mm.plugin.appbrand.api.g)localObject3);
      AppMethodBeat.o(364217);
      return;
      i = 1200;
      break;
      i = 1184;
      break;
      i = 1193;
      break;
      i = 1213;
      break;
    }
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject, int paramInt)
  {
    localObject3 = null;
    AppMethodBeat.i(364295);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramJSONObject, "necessaryParams");
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("topic") == true)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          str = paramJSONObject.getString("topic");
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
        if (paramJSONObject.has("by_pass_info") != true) {
          continue;
        }
        i = 1;
        localObject2 = localObject3;
        if (i != 0) {
          localObject2 = paramJSONObject.getString("by_pass_info");
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        localObject2 = localObject3;
        continue;
      }
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_topic_type", 1);
      paramJSONObject.putExtra("key_by_pass_info", (String)localObject2);
      paramJSONObject.putExtra("key_topic_title", str);
      paramJSONObject.putExtra("key_entrance_type", paramInt);
      com.tencent.mm.plugin.finder.utils.a.GfO.A(paramContext, paramJSONObject);
      AppMethodBeat.o(364295);
      return;
      i = 0;
    }
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(364310);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramJSONObject, "necessaryParams");
    kotlin.g.b.s.u(paramString, "username");
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("kf_url") != true) {
          continue;
        }
        i = 1;
        if (i != 0) {
          localObject = paramJSONObject.getString("kf_url");
        }
        paramJSONObject = (JSONObject)localObject;
      }
      catch (Exception paramJSONObject)
      {
        int i;
        OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest;
        dxm localdxm;
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        paramJSONObject = null;
        continue;
      }
      localObject = (com.tencent.mm.openim.api.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.d.class);
      if (localObject != null)
      {
        localOpenIMKefuStartConversationRequest = new OpenIMKefuStartConversationRequest();
        localOpenIMKefuStartConversationRequest.context = paramContext;
        localOpenIMKefuStartConversationRequest.hBk = System.currentTimeMillis();
        localOpenIMKefuStartConversationRequest.prw = 9;
        paramContext = new du();
        paramContext.url = paramJSONObject;
        localdxm = new dxm();
        localdxm.scene = localOpenIMKefuStartConversationRequest.prw;
        localdxm.url = paramJSONObject;
        localdxm.abdw = paramString;
        paramJSONObject = ah.aiuX;
        paramContext.YFX = localdxm;
        paramJSONObject = ah.aiuX;
        localOpenIMKefuStartConversationRequest.pry = paramContext;
        localOpenIMKefuStartConversationRequest.prx = com.tencent.mm.openim.api.h.a.xD(localOpenIMKefuStartConversationRequest.prw);
        paramContext = ah.aiuX;
        ((com.tencent.mm.openim.api.d)localObject).a(localOpenIMKefuStartConversationRequest);
      }
      AppMethodBeat.o(364310);
      return;
      i = 0;
    }
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt)
  {
    localObject3 = null;
    AppMethodBeat.i(364318);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramJSONObject, "necessaryParams");
    kotlin.g.b.s.u(paramString, "eventName");
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("topic_id") != true) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        localObject1 = paramJSONObject.getString("topic_id");
      }
      catch (Exception localException)
      {
        Object localObject1;
        Log.printDebugStack("safeGetString", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        long l = com.tencent.mm.ae.d.FK((String)localObject2);
        continue;
        int i = 0;
        continue;
        localObject2 = null;
        continue;
      }
      if (localObject1 != null) {
        continue;
      }
      l = 0L;
      try
      {
        if (paramJSONObject.has("by_pass_info") != true) {
          continue;
        }
        i = 1;
        localObject1 = localObject3;
        if (i != 0) {
          localObject1 = paramJSONObject.getString("by_pass_info");
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        localObject2 = localObject3;
        continue;
      }
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_activity_id", l);
      paramJSONObject.putExtra("key_by_pass_info", (String)localObject1);
      paramJSONObject.putExtra("key_activity_name", paramString);
      paramJSONObject.putExtra("key_entrance_type", paramInt);
      Log.i("Finder.JumperUtils", "eventTopicId :" + l + " eventName:" + paramString);
      paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.aq(paramContext, paramJSONObject);
      AppMethodBeat.o(364318);
      return;
      i = 0;
    }
  }
  
  public static void a(Intent paramIntent, kotlin.g.a.b<? super FinderJumpInfo, ah> paramb)
  {
    AppMethodBeat.i(364344);
    kotlin.g.b.s.u(paramb, "callback");
    if (paramIntent == null) {}
    for (paramIntent = null; paramIntent != null; paramIntent = paramIntent.getByteArrayExtra("KEY_JUMP_INFO"))
    {
      localObject = new FinderJumpInfo();
      ((FinderJumpInfo)localObject).parseFrom(paramIntent);
      paramb.invoke(localObject);
      AppMethodBeat.o(364344);
      return;
    }
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
    if (localObject != null)
    {
      paramIntent = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject).avK("FinderEntrance");
      localObject = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject).ASz.ZNl;
      if ((paramIntent != null) && (localObject != null) && (((FinderJumpInfo)localObject).jumpinfo_type == 3)) {
        paramb.invoke(localObject);
      }
    }
    AppMethodBeat.o(364344);
  }
  
  public static void a(j paramj, WeImageView paramWeImageView, com.tencent.mm.view.recyclerview.j paramj1)
  {
    AppMethodBeat.i(364366);
    kotlin.g.b.s.u(paramj, "cache");
    kotlin.g.b.s.u(paramWeImageView, "iconView");
    kotlin.g.b.s.u(paramj1, "holder");
    if (Util.isNullOrNil(paramj.iconUrl))
    {
      a(paramWeImageView, paramj);
      AppMethodBeat.o(364366);
      return;
    }
    paramj1 = com.tencent.mm.plugin.finder.loader.p.ExI;
    paramj1 = com.tencent.mm.plugin.finder.loader.p.eCl();
    com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(paramj.iconUrl, v.FKZ);
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    paramj1.a(locals, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExR)).a(new r..ExternalSyntheticLambda2(paramWeImageView, paramj)).a(new r..ExternalSyntheticLambda0(paramWeImageView, paramj)).a(new r..ExternalSyntheticLambda1(paramWeImageView, paramj)).d((ImageView)paramWeImageView);
    AppMethodBeat.o(364366);
  }
  
  private static void a(WeImageView paramWeImageView, j paramj)
  {
    AppMethodBeat.i(364373);
    if (paramj.BdY > 0) {
      paramWeImageView.setImageResource(paramj.BdY);
    }
    if (paramj.BdZ > 0) {
      paramWeImageView.setIconColor(paramWeImageView.getContext().getResources().getColor(paramj.BdZ));
    }
    AppMethodBeat.o(364373);
  }
  
  private static final void a(WeImageView paramWeImageView, final j paramj, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(364404);
    kotlin.g.b.s.u(paramWeImageView, "$iconView");
    kotlin.g.b.s.u(paramj, "$cache");
    if (paramBitmap == null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramWeImageView, paramj));
    }
    Log.i("Finder.JumperUtils", kotlin.g.b.s.X("loadLinkIcon resource :", paramBitmap));
    AppMethodBeat.o(364404);
  }
  
  private static final void a(WeImageView paramWeImageView, final j paramj, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(364417);
    kotlin.g.b.s.u(paramWeImageView, "$iconView");
    kotlin.g.b.s.u(paramj, "$cache");
    Log.i("Finder.JumperUtils", kotlin.g.b.s.X("loadLinkIcon path :", paramString));
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramWeImageView, paramj));
    AppMethodBeat.o(364417);
  }
  
  private static final void a(WeImageView paramWeImageView, final j paramj, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(364410);
    kotlin.g.b.s.u(paramWeImageView, "$iconView");
    kotlin.g.b.s.u(paramj, "$cache");
    Log.i("Finder.JumperUtils", kotlin.g.b.s.X("loadLinkIcon success :", Boolean.valueOf(paramBoolean)));
    if (!paramBoolean) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramWeImageView, paramj));
    }
    AppMethodBeat.o(364410);
  }
  
  public static void avT(String paramString)
  {
    AppMethodBeat.i(364327);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.JumperUtils", kotlin.g.b.s.X("[preloadAdH5] fail, stack:", Util.getStack()));
      AppMethodBeat.o(364327);
      return;
    }
    Log.i("Finder.JumperUtils", kotlin.g.b.s.X("[preloadAdH5] url:", paramString));
    localObject = new com.tencent.mm.plugin.brandservice.api.h.a();
    ((com.tencent.mm.plugin.brandservice.api.h.a)localObject).url = paramString;
    ((com.tencent.mm.plugin.brandservice.api.h.a)localObject).vAZ = 212;
    paramString = new ArrayList();
    paramString.add(localObject);
    ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ei((List)paramString);
    AppMethodBeat.o(364327);
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject)
  {
    localObject3 = null;
    AppMethodBeat.i(364251);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramJSONObject, "necessaryParams");
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
      AppMethodBeat.o(364251);
      return;
      i = 0;
    }
  }
  
  public static void b(k paramk)
  {
    AppMethodBeat.i(364335);
    kotlin.g.b.s.u(paramk, "jumpInfoEx");
    Object localObject = paramk.hVf.mini_app_info;
    if (localObject == null)
    {
      localObject = "";
      paramk = paramk.hVf.mini_app_info;
      if (paramk != null) {
        break label112;
      }
      paramk = "";
      label43:
      if (((CharSequence)localObject).length() != 0) {
        break label129;
      }
      i = 1;
      label57:
      if (i == 0) {
        break label139;
      }
      if (((CharSequence)paramk).length() != 0) {
        break label134;
      }
    }
    label129:
    label134:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label139;
      }
      Log.i("Finder.JumperUtils", "[preloadMiniApp] both appId and appUserName is empty");
      AppMethodBeat.o(364335);
      return;
      String str = ((MiniAppInfo)localObject).app_id;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label112:
      str = paramk.appusername;
      paramk = str;
      if (str != null) {
        break label43;
      }
      paramk = "";
      break label43;
      i = 0;
      break label57;
    }
    label139:
    Log.i("Finder.JumperUtils", "[preloadMiniApp] appId:" + (String)localObject + " , appUserName:" + paramk);
    ((y)com.tencent.mm.kernel.h.ax(y.class)).z(paramk, (String)localObject, 11);
    ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).b(ab.tUg);
    AppMethodBeat.o(364335);
  }
  
  private static void c(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(364259);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramJSONObject, "necessaryParams");
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
      AppMethodBeat.o(364259);
      return;
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(WeImageView paramWeImageView, j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(WeImageView paramWeImageView, j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(WeImageView paramWeImageView, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.r
 * JD-Core Version:    0.7.0.1
 */