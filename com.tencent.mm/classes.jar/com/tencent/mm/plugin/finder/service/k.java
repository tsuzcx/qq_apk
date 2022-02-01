package com.tencent.mm.plugin.finder.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.biz.FinderBizProfileFragment;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.br.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderShowInBizService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderShowInBizService;", "()V", "enterFinderShareUI", "", "context", "Landroid/content/Context;", "prefix", "", "values", "", "contextId", "favFinderFeed", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "generateFinderFragment", "Lcom/tencent/mm/plugin/findersdk/api/IFinderShowInBizService$IFinderFragment;", "bizUsername", "readFeedId", "", "getFavShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getFinderAppMsgContent", "shareFinderToConversation", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements br
{
  public static final k.a Fzy;
  
  static
  {
    AppMethodBeat.i(330106);
    Fzy = new k.a((byte)0);
    AppMethodBeat.o(330106);
  }
  
  public final boolean a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    AppMethodBeat.i(330115);
    s.u(paramContext, "context");
    s.u(paramString1, "prefix");
    s.u(paramMap, "values");
    paramString1 = q.D(paramString1, paramMap);
    if (paramString1 != null)
    {
      paramMap = new Intent();
      paramMap.putExtra("key_context_id", paramString2);
      paramMap.putExtra("report_scene", 11);
      paramMap.putExtra("from_user", z.bAM());
      paramMap.putExtra("feed_object_id", d.FK(paramString1.objectId));
      paramMap.putExtra("feed_object_nonceId", paramString1.objectNonceId);
      paramMap.putExtra("key_comment_scene", 25);
      paramMap.putExtra("key_reuqest_scene", 3);
      ((cn)h.az(cn.class)).enterFinderShareFeedUI(paramContext, paramMap);
      AppMethodBeat.o(330115);
      return true;
    }
    AppMethodBeat.o(330115);
    return false;
  }
  
  public final boolean a(AppCompatActivity paramAppCompatActivity, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(330121);
    s.u(paramAppCompatActivity, "activity");
    s.u(paramString, "prefix");
    s.u(paramMap, "values");
    paramString = q.D(paramString, paramMap);
    if (paramString != null)
    {
      paramMap = an.GhR;
      s.u(paramAppCompatActivity, "context");
      s.u(paramString, "finerShareObject");
      paramString = an.a.a(paramString);
      paramMap = new Intent();
      paramMap.putExtra("Retr_Msg_Type", 18);
      paramMap.putExtra("Multi_Retr", true);
      paramMap.putExtra("Retr_Msg_content", k.b.a(paramString, null, null));
      paramMap.putExtra("Retr_go_to_chattingUI", false);
      paramMap.putExtra("Retr_show_success_tips", true);
      c.g((Context)paramAppCompatActivity, ".ui.transmit.MsgRetransmitUI", paramMap);
      AppMethodBeat.o(330121);
      return true;
    }
    AppMethodBeat.o(330121);
    return false;
  }
  
  public final br.a aE(String paramString, long paramLong)
  {
    AppMethodBeat.i(330158);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = (br.a)new FinderBizProfileFragment(str, paramLong);
    AppMethodBeat.o(330158);
    return paramString;
  }
  
  public final boolean b(AppCompatActivity paramAppCompatActivity, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(330131);
    s.u(paramAppCompatActivity, "activity");
    s.u(paramString, "prefix");
    s.u(paramMap, "values");
    paramString = q.D(paramString, paramMap);
    if (paramString != null)
    {
      paramMap = an.GhR;
      paramMap = an.a.b(paramString);
      if (paramMap != null)
      {
        paramMap.hDr.activity = ((Activity)paramAppCompatActivity);
        paramAppCompatActivity = n.Ggy;
        Log.i(n.getTAG(), s.X("publish fav event, id:", paramString.objectId));
        paramMap.publish();
      }
      AppMethodBeat.o(330131);
      return true;
    }
    AppMethodBeat.o(330131);
    return false;
  }
  
  public final String x(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(330139);
    s.u(paramString, "prefix");
    s.u(paramMap, "values");
    paramString = q.D(paramString, paramMap);
    if (paramString == null)
    {
      AppMethodBeat.o(330139);
      return null;
    }
    paramMap = an.GhR;
    paramString = k.b.a(an.a.a(paramString), null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(330139);
      return null;
    }
    AppMethodBeat.o(330139);
    return paramString;
  }
  
  public final bvl y(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(330150);
    s.u(paramString, "prefix");
    s.u(paramMap, "values");
    paramString = q.D(paramString, paramMap);
    AppMethodBeat.o(330150);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.k
 * JD-Core Version:    0.7.0.1
 */