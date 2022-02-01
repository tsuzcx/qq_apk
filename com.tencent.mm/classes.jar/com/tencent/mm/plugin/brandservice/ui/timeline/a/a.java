package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.m;
import com.tencent.mm.model.o;
import com.tencent.mm.model.p.g;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.ens;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil;", "", "()V", "TAG", "", "allMsgEnd", "", "getAllMsgEnd", "()Z", "setAllMsgEnd", "(Z)V", "clickFirstVisibleItem", "", "getClickFirstVisibleItem", "()I", "setClickFirstVisibleItem", "(I)V", "value", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "clickInfo", "getClickInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setClickInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "clickScene", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil$BizTimelineClickScene;", "getClickScene", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil$BizTimelineClickScene;", "setClickScene", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil$BizTimelineClickScene;)V", "clickUrl", "getClickUrl", "()Ljava/lang/String;", "setClickUrl", "(Ljava/lang/String;)V", "firstGroupEnd", "getFirstGroupEnd", "setFirstGroupEnd", "sFirstVisibleItem", "getSFirstVisibleItem", "setSFirstVisibleItem", "showRecFeedList", "getShowRecFeedList", "setShowRecFeedList", "getBigPicFlag", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "initJumpLink", "", "jumpLinkTv", "Landroid/widget/TextView;", "wording", "iconType", "reporter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "pos", "index", "info", "txtJumpLink", "context", "Landroid/content/Context;", "initTag", "recommendTag", "Lcom/tencent/mm/protocal/protobuf/RecommendTagMsg;", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "isShowBigPic", "cardMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "isShowThreePic", "markScroll", "onAppMsgClick", "recommendItem", "saveClickInfo", "url", "scene", "BizTimelineClickScene", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static int vIc;
  public static final a vNK;
  private static boolean vNL;
  private static boolean vNM;
  private static boolean vNN;
  private static int vNO;
  private static ab vNP;
  private static String vNQ;
  private static a.a vNR;
  
  static
  {
    AppMethodBeat.i(302409);
    vNK = new a();
    vNL = true;
    vNR = a.a.vNU;
    AppMethodBeat.o(302409);
  }
  
  public static void Hp(int paramInt)
  {
    vIc = paramInt;
  }
  
  public static void a(Context paramContext, ab paramab, enp paramenp)
  {
    AppMethodBeat.i(302369);
    s.u(paramContext, "context");
    s.u(paramab, "info");
    s.u(paramenp, "recommendItem");
    if ((paramab.acFJ == null) || (paramenp.absd == null) || (paramenp.abse == null))
    {
      Log.w("Micromsg.BizTimeLineRecFeedsHelper", "onAppMsgClick appMsg is null");
      AppMethodBeat.o(302369);
      return;
    }
    nk localnk = paramenp.absd;
    paramenp = paramenp.abse;
    Object localObject = o.ojb;
    o.ir(21L);
    Log.i("Micromsg.BizTimeLineRecFeedsHelper", "onClick jump to url:%s", new Object[] { paramenp.YQK });
    localObject = new Intent();
    String str = m.e(paramenp.YQK, 169, 200, (int)System.currentTimeMillis() / 1000);
    ((Intent)localObject).putExtra("rawUrl", str);
    ((Intent)localObject).putExtra("geta8key_scene", 56);
    ((Intent)localObject).putExtra("geta8key_username", localnk.UserName);
    ((Intent)localObject).putExtra("srcUsername", localnk.UserName);
    ((Intent)localObject).putExtra("srcDisplayname", localnk.vhX);
    ((Intent)localObject).putExtra("prePublishId", "rec_feed");
    ((Intent)localObject).putExtra("KPublisherId", "rec_feed");
    a(paramab, str, a.a.vNU);
    if ((((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramContext, str, paramenp.nUA, 169, 200, (Intent)localObject)))
    {
      Log.i("Micromsg.BizTimeLineRecFeedsHelper", "jump to TmplWebview");
      AppMethodBeat.o(302369);
      return;
    }
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(302369);
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt)
  {
    AppMethodBeat.i(302356);
    if (paramTextView == null)
    {
      AppMethodBeat.o(302356);
      return;
    }
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        if (paramInt != p.g.ojA.value) {
          break label224;
        }
        localObject = bb.m(paramTextView.getContext(), d.h.icons_outlined_news, paramTextView.getContext().getResources().getColor(d.b.Link));
        paramInt = (int)(paramTextView.getTextSize() * 1.1D);
        ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
        localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
        SpannableString localSpannableString = new SpannableString((CharSequence)"@");
        localSpannableString.setSpan(localObject, 0, 1, 33);
        paramTextView.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localSpannableString, (CharSequence)s.X(" ", paramString) }));
      }
    }
    for (;;)
    {
      if ((paramTextView.getText() != null) && (paramTextView.getText().length() >= 2))
      {
        paramString = paramTextView.getText();
        s.s(paramString, "text");
        if (n.f(paramString, (CharSequence)"#")) {
          break label235;
        }
      }
      AppMethodBeat.o(302356);
      return;
      i = 0;
      break;
      label224:
      paramTextView.setText((CharSequence)paramString);
    }
    label235:
    paramString = am.aixg;
    paramString = paramTextView.getContext().getResources().getString(d.i.biz_timeline_topic);
    s.s(paramString, "context.resources.getStr…tring.biz_timeline_topic)");
    paramString = String.format(paramString, Arrays.copyOf(new Object[] { paramTextView.getText().subSequence(1, paramTextView.getText().length()) }, 1));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramTextView.setContentDescription((CharSequence)paramString);
    AppMethodBeat.o(302356);
  }
  
  public static void a(final com.tencent.mm.plugin.brandservice.ui.timeline.f paramf, final int paramInt, final ab paramab, enp paramenp, TextView paramTextView, final Context paramContext)
  {
    AppMethodBeat.i(302331);
    s.u(paramf, "reporter");
    s.u(paramab, "info");
    s.u(paramenp, "itemMsg");
    s.u(paramTextView, "txtJumpLink");
    s.u(paramContext, "context");
    Object localObject = (CharSequence)paramenp.Zxr;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0) {
        break label178;
      }
      localObject = (CharSequence)paramenp.Zxq;
      if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label178;
      }
      paramTextView.setVisibility(0);
      a(paramTextView, paramenp.Zxr, paramenp.Zwh);
      localObject = e.vYK;
      e.l(paramTextView);
      paramTextView.setOnClickListener(new a..ExternalSyntheticLambda0((kotlin.g.a.b)new b(paramenp, paramContext, paramf, paramab, paramInt, 0)));
      AppMethodBeat.o(302331);
      return;
      i = 0;
      break;
    }
    label178:
    paramTextView.setVisibility(8);
    AppMethodBeat.o(302331);
  }
  
  public static void a(ens paramens, BizRecTagTextView paramBizRecTagTextView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(302339);
    String str;
    label47:
    label69:
    int i;
    if (paramens == null)
    {
      str = null;
      if (Util.isNullOrNil(str)) {
        break label238;
      }
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setVisibility(0);
      }
      if (paramBizRecTagTextView != null)
      {
        if (paramens != null) {
          break label145;
        }
        str = null;
        paramBizRecTagTextView.setText((CharSequence)str);
      }
      if (!aw.isDarkMode()) {
        break label171;
      }
      if (paramens != null) {
        break label154;
      }
      str = null;
      i = com.tencent.mm.plugin.webview.ui.tools.f.fo(str, -16777216);
      if (paramens != null) {
        break label163;
      }
    }
    int j;
    label145:
    label154:
    label163:
    for (paramens = localObject1;; paramens = paramens.absi)
    {
      j = com.tencent.mm.plugin.webview.ui.tools.f.fo(paramens, -1);
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setFillColor(i);
      }
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setTextColor(j);
      }
      if (paramBizRecTagTextView == null) {
        break label262;
      }
      paramBizRecTagTextView.setTextSize(1, 12.0F * com.tencent.mm.cd.a.getScaleSize(paramBizRecTagTextView.getContext()));
      AppMethodBeat.o(302339);
      return;
      str = paramens.wording;
      break;
      str = paramens.wording;
      break label47;
      str = paramens.absj;
      break label69;
    }
    label171:
    if (paramens == null)
    {
      str = null;
      label178:
      i = com.tencent.mm.plugin.webview.ui.tools.f.fo(str, -1);
      if (paramens != null) {
        break label230;
      }
    }
    label230:
    for (paramens = localObject2;; paramens = paramens.absh)
    {
      j = com.tencent.mm.plugin.webview.ui.tools.f.fo(paramens, -16777216);
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setFillColor(i);
      }
      if (paramBizRecTagTextView == null) {
        break;
      }
      paramBizRecTagTextView.setTextColor(j);
      break;
      str = paramens.background_color;
      break label178;
    }
    label238:
    if (paramBizRecTagTextView != null) {
      paramBizRecTagTextView.setText((CharSequence)"");
    }
    if (paramBizRecTagTextView != null) {
      paramBizRecTagTextView.setVisibility(8);
    }
    label262:
    AppMethodBeat.o(302339);
  }
  
  public static void a(ab paramab, String paramString, a.a parama)
  {
    AppMethodBeat.i(302308);
    s.u(paramab, "info");
    s.u(parama, "scene");
    m(paramab);
    vNQ = paramString;
    vNR = parama;
    AppMethodBeat.o(302308);
  }
  
  public static final boolean a(ene paramene)
  {
    AppMethodBeat.i(302378);
    s.u(paramene, "cardMsg");
    boolean bool = com.tencent.mm.storage.ah.a(paramene);
    AppMethodBeat.o(302378);
    return bool;
  }
  
  public static void ajc(String paramString)
  {
    vNQ = paramString;
  }
  
  public static final boolean b(enp paramenp)
  {
    AppMethodBeat.i(302382);
    s.u(paramenp, "itemMsg");
    boolean bool = com.tencent.mm.storage.ah.b(paramenp);
    AppMethodBeat.o(302382);
    return bool;
  }
  
  public static final int c(enp paramenp)
  {
    AppMethodBeat.i(302389);
    s.u(paramenp, "itemMsg");
    if (com.tencent.mm.storage.ah.b(paramenp))
    {
      AppMethodBeat.o(302389);
      return 2;
    }
    if (com.tencent.mm.storage.ah.e(paramenp))
    {
      AppMethodBeat.o(302389);
      return 3;
    }
    if (com.tencent.mm.storage.ah.f(paramenp))
    {
      AppMethodBeat.o(302389);
      return 4;
    }
    if (com.tencent.mm.storage.ah.d(paramenp))
    {
      AppMethodBeat.o(302389);
      return 1;
    }
    AppMethodBeat.o(302389);
    return 0;
  }
  
  public static boolean ddY()
  {
    return vNL;
  }
  
  public static boolean ddZ()
  {
    return vNM;
  }
  
  public static boolean dea()
  {
    return vNN;
  }
  
  public static ab deb()
  {
    return vNP;
  }
  
  public static String dec()
  {
    return vNQ;
  }
  
  public static a.a ded()
  {
    return vNR;
  }
  
  public static boolean dee()
  {
    return vNO != vIc;
  }
  
  private static final void h(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(302401);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$funJump");
    paramb.invoke(Integer.valueOf(24));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302401);
  }
  
  public static void m(ab paramab)
  {
    vNP = paramab;
    vNO = vIc;
  }
  
  public static void mT(boolean paramBoolean)
  {
    vNL = paramBoolean;
  }
  
  public static void mU(boolean paramBoolean)
  {
    vNM = paramBoolean;
  }
  
  public static void mV(boolean paramBoolean)
  {
    vNN = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "opType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Integer, kotlin.ah>
  {
    b(enp paramenp, Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.f paramf, ab paramab, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */