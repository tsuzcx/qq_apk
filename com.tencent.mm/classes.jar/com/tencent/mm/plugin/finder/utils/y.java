package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderMsgUtil;", "", "()V", "EVENT_CODE_CLICK", "", "EVENT_CODE_EXPOSED", "checkInvalid", "", "userName", "", "commentId", "", "fansId", "likeId", "likeType", "isFollowPrivate", "scene", "relationType", "exposedReport", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "getReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "commentScene", "jumWxProfile", "v5UserName", "feedId", "isFollowApply", "wxUsername", "jumpBizProfile", "bizUsername", "jumpProfile", "username", "reportMsg", "eventCode", "reportSheet", "setClickListener", "msg", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "showToast", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  public static final y GgX;
  
  static
  {
    AppMethodBeat.i(333764);
    GgX = new y();
    AppMethodBeat.o(333764);
  }
  
  public static void a(View paramView, Context paramContext)
  {
    AppMethodBeat.i(333690);
    s.u(paramContext, "context");
    if (paramView != null) {
      f.a(paramView, (e.b)new a(paramContext));
    }
    AppMethodBeat.o(333690);
  }
  
  public static void a(View paramView, com.tencent.mm.plugin.finder.model.a parama, int paramInt)
  {
    AppMethodBeat.i(333676);
    s.u(parama, "msg");
    if (paramView != null) {
      paramView.setOnClickListener(new y..ExternalSyntheticLambda0(parama, paramInt, paramView));
    }
    AppMethodBeat.o(333676);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.model.a parama, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(333741);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(parama);
    ((b)localObject2).sc(paramInt);
    ((b)localObject2).cH(paramView1);
    ((b)localObject2).cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/utils/FinderMsgUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(parama, "$msg");
    com.tencent.mm.plugin.finder.storage.av localav = parama.ECa;
    localObject1 = localav.field_contact;
    long l1;
    long l2;
    long l3;
    long l4;
    int j;
    boolean bool1;
    label151:
    int k;
    if (localObject1 == null)
    {
      localObject1 = null;
      l1 = localav.field_objectId;
      l2 = localav.field_commentId;
      l3 = localav.field_likeId;
      l4 = localav.field_fansId;
      j = localav.field_likeType;
      localObject2 = localav.field_username;
      if ((!(parama instanceof bd)) && (!(parama instanceof be))) {
        break label333;
      }
      bool1 = true;
      k = localav.field_relationType;
      parama = paramView2.getContext();
      s.s(parama, "it.context");
      aB(parama, 1);
      parama = localav.field_contact;
      if (parama == null) {
        break label342;
      }
      parama = com.tencent.mm.plugin.finder.api.c.b(parama);
      if (parama == null) {
        break label342;
      }
      paramView1 = paramView1.getContext();
      s.s(paramView1, "view.context");
      parama = parama.ADE;
      if (parama != null) {
        break label339;
      }
      parama = "";
    }
    label333:
    label339:
    for (;;)
    {
      paramView2 = new Intent();
      localObject1 = as.GSQ;
      as.a.a(paramView1, paramView2, 0L, 0, false, 124);
      paramView2.putExtra("Contact_User", parama);
      paramView2.putExtra("Contact_Scene", 214);
      paramView2.putExtra("biz_profile_enter_from_finder", true);
      paramView2.putExtra("force_get_contact", true);
      paramView2.putExtra("key_use_new_contact_profile", true);
      paramView2.putExtra("biz_profile_tab_type", 1);
      com.tencent.mm.br.c.b(paramView1, "profile", ".ui.ContactInfoUI", paramView2);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/utils/FinderMsgUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(333741);
      return;
      localObject1 = ((FinderContact)localObject1).username;
      break;
      bool1 = false;
      break label151;
    }
    label342:
    parama = (CharSequence)localObject1;
    if ((parama == null) || (parama.length() == 0))
    {
      i = 1;
      if (i == 0) {
        if ((!n.rs((String)localObject1, "@stranger")) || (bool1) || (l2 != 0L) || (l4 != 0L) || (((j != 1) || (l3 != 0L)) && (j != 0))) {
          break label470;
        }
      }
    }
    label470:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label476;
      }
      parama = paramView2.getContext();
      s.s(parama, "it.context");
      hn(parama);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/utils/FinderMsgUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(333741);
      return;
      i = 0;
      break;
    }
    label476:
    if (n.rs((String)localObject1, "@finder"))
    {
      parama = paramView2.getContext();
      s.s(parama, "it.context");
      s.u(parama, "context");
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramView1 = new Intent();
        paramView1.putExtra("finder_username", (String)localObject1);
        a.GfO.enterFinderProfileUI(parama, paramView1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/utils/FinderMsgUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(333741);
      return;
      if (n.rs((String)localObject1, "@stranger"))
      {
        parama = paramView2.getContext();
        s.s(parama, "it.context");
        s.s(localObject2, "wxUsername");
        s.u(parama, "context");
        s.u(localObject2, "wxUsername");
        if (!Util.isNullOrNil((String)localObject1))
        {
          paramView2 = new Intent();
          paramView2.putExtra("V5UserName", (String)localObject1);
          paramView2.putExtra("FeedId", l1);
          paramView2.putExtra("CommentId", l2);
          paramView2.putExtra("LikeId", l3);
          paramView2.putExtra("LikeType", j);
          if (l4 > 0L) {
            paramView2.putExtra("FansId", d.hF(l4));
          }
          paramView2.putExtra("IsPoster", true);
          paramView2.putExtra("Action", 1);
          paramView2.putExtra("feedUser", z.bAW());
          if (paramInt == 1)
          {
            bool2 = true;
            label729:
            paramView2.putExtra("FromFinderMsg", bool2);
            if (bool2) {
              break label828;
            }
          }
          label828:
          for (boolean bool2 = true;; bool2 = false)
          {
            paramView2.putExtra("FromWxMsg", bool2);
            paramView2.putExtra("IsFollowApply", bool1);
            paramView2.putExtra("WxUserName", (String)localObject2);
            paramView2.putExtra("RelationType", k);
            localObject2 = av.GiL;
            av.b(parama, (String)localObject1, paramView2, 6);
            if (paramView1 == null) {
              break;
            }
            paramView1.post(new y..ExternalSyntheticLambda1(parama));
            break;
            bool2 = false;
            break label729;
          }
        }
      }
      else
      {
        parama = paramView2.getContext();
        s.s(parama, "it.context");
        hn(parama);
      }
    }
  }
  
  private static bui aA(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(333700);
    s.u(paramContext, "context");
    as.a locala = as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(333700);
      return null;
    }
    paramContext = paramContext.fou();
    if (paramContext == null)
    {
      AppMethodBeat.o(333700);
      return null;
    }
    paramContext.AJo = paramInt;
    AppMethodBeat.o(333700);
    return paramContext;
  }
  
  public static void aB(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(333708);
    s.u(paramContext, "context");
    paramContext = aA(paramContext, 117);
    bb localbb = bb.FuK;
    bb.a(paramContext, "protrait", paramInt);
    AppMethodBeat.o(333708);
  }
  
  public static void aC(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(333716);
    s.u(paramContext, "context");
    paramContext = aA(paramContext, 97);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scene", 6);
      label37:
      bb localbb = bb.FuK;
      bb.a(paramContext, "", paramInt, localJSONObject);
      AppMethodBeat.o(333716);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label37;
    }
  }
  
  private static void hn(Context paramContext)
  {
    AppMethodBeat.i(333684);
    Object localObject = paramContext.getResources();
    if (localObject == null)
    {
      localObject = null;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label71;
      }
    }
    label71:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        aa.makeText(paramContext, (CharSequence)localObject, 0).show();
      }
      AppMethodBeat.o(333684);
      return;
      localObject = ((Resources)localObject).getString(e.h.finder_msg_jump_profile_fail);
      break;
    }
  }
  
  private static final void ho(Context paramContext)
  {
    AppMethodBeat.i(333751);
    s.u(paramContext, "$context");
    aC(paramContext, 0);
    AppMethodBeat.o(333751);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderMsgUtil$exposedReport$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e.b
  {
    a(Context paramContext) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(333591);
      s.u(paramView, "view");
      if (paramBoolean)
      {
        paramView = y.GgX;
        y.aB(this.$context, 0);
      }
      AppMethodBeat.o(333591);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.y
 * JD-Core Version:    0.7.0.1
 */