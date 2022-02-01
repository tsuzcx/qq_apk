package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.o;
import com.tencent.mm.model.p.f;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil;", "", "()V", "TAG", "", "allMsgEnd", "", "getAllMsgEnd", "()Z", "setAllMsgEnd", "(Z)V", "clickFirstVisibleItem", "", "getClickFirstVisibleItem", "()I", "setClickFirstVisibleItem", "(I)V", "value", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "clickInfo", "getClickInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setClickInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "clickUrl", "getClickUrl", "()Ljava/lang/String;", "setClickUrl", "(Ljava/lang/String;)V", "firstGroupEnd", "getFirstGroupEnd", "setFirstGroupEnd", "sFirstVisibleItem", "getSFirstVisibleItem", "setSFirstVisibleItem", "showRecFeedList", "getShowRecFeedList", "setShowRecFeedList", "getBigPicFlag", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "initJumpLink", "", "jumpLinkTv", "Landroid/widget/TextView;", "wording", "iconType", "reporter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "pos", "index", "info", "txtJumpLink", "context", "Landroid/content/Context;", "initTag", "recommendTag", "Lcom/tencent/mm/protocal/protobuf/RecommendTagMsg;", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "isShowBigPic", "cardMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "isShowThreePic", "markScroll", "onAppMsgClick", "recommendItem", "plugin-brandservice_release"})
public final class a
{
  private static int sCk;
  private static boolean sIo;
  private static boolean sIp;
  private static boolean sIq;
  private static int sIr;
  private static z sIs;
  private static String sIt;
  public static final a sIu;
  
  static
  {
    AppMethodBeat.i(266864);
    sIu = new a();
    sIo = true;
    AppMethodBeat.o(266864);
  }
  
  public static void GP(int paramInt)
  {
    sCk = paramInt;
  }
  
  public static void a(Context paramContext, z paramz, dur paramdur)
  {
    AppMethodBeat.i(266858);
    p.k(paramContext, "context");
    p.k(paramz, "info");
    p.k(paramdur, "recommendItem");
    if ((paramz.Ven == null) || (paramdur.UaW == null) || (paramdur.UaX == null))
    {
      Log.w("Micromsg.BizTimeLineRecFeedsHelper", "onAppMsgClick appMsg is null");
      AppMethodBeat.o(266858);
      return;
    }
    mh localmh = paramdur.UaW;
    paramdur = paramdur.UaX;
    Object localObject = o.lrA;
    o.Gh(21L);
    Log.i("Micromsg.BizTimeLineRecFeedsHelper", "onClick jump to url:%s", new Object[] { paramdur.RTk });
    localObject = new Intent();
    String str = m.e(paramdur.RTk, 169, 200, 0);
    ((Intent)localObject).putExtra("rawUrl", str);
    ((Intent)localObject).putExtra("geta8key_scene", 56);
    ((Intent)localObject).putExtra("geta8key_username", localmh.UserName);
    ((Intent)localObject).putExtra("srcUsername", localmh.UserName);
    ((Intent)localObject).putExtra("srcDisplayname", localmh.rWI);
    ((Intent)localObject).putExtra("prePublishId", "rec_feed");
    ((Intent)localObject).putExtra("KPublisherId", "rec_feed");
    sIt = str;
    n(paramz);
    if ((((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramContext, str, paramdur.lpx, 169, 200, (Intent)localObject)))
    {
      Log.i("Micromsg.BizTimeLineRecFeedsHelper", "jump to TmplWebview");
      AppMethodBeat.o(266858);
      return;
    }
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(266858);
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt)
  {
    AppMethodBeat.i(266857);
    if (paramTextView == null)
    {
      AppMethodBeat.o(266857);
      return;
    }
    Object localObject1 = (CharSequence)paramString;
    int i;
    if ((localObject1 == null) || (n.ba((CharSequence)localObject1))) {
      i = 1;
    }
    while (i == 0) {
      if (paramInt == p.f.lrZ.value)
      {
        localObject1 = paramTextView.getContext();
        paramInt = d.h.icons_outlined_news;
        Object localObject2 = paramTextView.getContext();
        p.j(localObject2, "jumpLinkTv.context");
        localObject1 = au.o((Context)localObject1, paramInt, ((Context)localObject2).getResources().getColor(d.b.Link));
        paramInt = (int)(paramTextView.getTextSize() * 1.1D);
        ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
        localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
        localObject2 = new SpannableString((CharSequence)"@");
        ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
        paramTextView.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ".concat(String.valueOf(paramString)) }));
        AppMethodBeat.o(266857);
        return;
        i = 0;
      }
      else
      {
        paramTextView.setText((CharSequence)paramString);
      }
    }
    AppMethodBeat.o(266857);
  }
  
  public static void a(final f paramf, final int paramInt, final z paramz, dur paramdur, TextView paramTextView, final Context paramContext)
  {
    AppMethodBeat.i(266853);
    p.k(paramf, "reporter");
    p.k(paramz, "info");
    p.k(paramdur, "itemMsg");
    p.k(paramTextView, "txtJumpLink");
    p.k(paramContext, "context");
    Object localObject = (CharSequence)paramdur.SwI;
    if ((localObject == null) || (n.ba((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0) {
        break label181;
      }
      localObject = (CharSequence)paramdur.SwH;
      if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
        break label175;
      }
    }
    label175:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label181;
      }
      paramTextView.setVisibility(0);
      a(paramTextView, paramdur.SwI, paramdur.SvY);
      localObject = d.sTw;
      d.l(paramTextView);
      paramTextView.setOnClickListener((View.OnClickListener)new a.a((b)new b(paramdur, paramContext, paramf, paramz, paramInt, 0)));
      AppMethodBeat.o(266853);
      return;
      i = 0;
      break;
    }
    label181:
    paramTextView.setVisibility(8);
    AppMethodBeat.o(266853);
  }
  
  public static void a(duu paramduu, BizRecTagTextView paramBizRecTagTextView)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(266854);
    if (paramduu != null)
    {
      localObject1 = paramduu.wording;
      if (Util.isNullOrNil((String)localObject1)) {
        break label245;
      }
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setVisibility(0);
      }
      if (paramBizRecTagTextView != null)
      {
        if (paramduu == null) {
          break label159;
        }
        localObject1 = paramduu.wording;
        label53:
        paramBizRecTagTextView.setText((CharSequence)localObject1);
      }
      if (!ar.isDarkMode()) {
        break label171;
      }
      if (paramduu == null) {
        break label165;
      }
    }
    int i;
    int j;
    label159:
    label165:
    for (Object localObject1 = paramduu.Ubc;; localObject1 = null)
    {
      i = e.he((String)localObject1, -16777216);
      localObject1 = localObject2;
      if (paramduu != null) {
        localObject1 = paramduu.Ubb;
      }
      j = e.he((String)localObject1, -1);
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setFillColor(i);
      }
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setTextColor(j);
      }
      if (paramBizRecTagTextView == null) {
        break label238;
      }
      paramBizRecTagTextView.setTextSize(1, 12.0F * com.tencent.mm.ci.a.ez(paramBizRecTagTextView.getContext()));
      AppMethodBeat.o(266854);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label53;
    }
    label171:
    if (paramduu != null) {}
    for (localObject1 = paramduu.background_color;; localObject1 = null)
    {
      i = e.he((String)localObject1, -1);
      localObject1 = localObject3;
      if (paramduu != null) {
        localObject1 = paramduu.Uba;
      }
      j = e.he((String)localObject1, -16777216);
      if (paramBizRecTagTextView != null) {
        paramBizRecTagTextView.setFillColor(i);
      }
      if (paramBizRecTagTextView == null) {
        break;
      }
      paramBizRecTagTextView.setTextColor(j);
      break;
    }
    label238:
    AppMethodBeat.o(266854);
    return;
    label245:
    if (paramBizRecTagTextView != null)
    {
      paramBizRecTagTextView.setVisibility(8);
      AppMethodBeat.o(266854);
      return;
    }
    AppMethodBeat.o(266854);
  }
  
  public static final boolean a(dug paramdug)
  {
    AppMethodBeat.i(266859);
    p.k(paramdug, "cardMsg");
    boolean bool = af.a(paramdug);
    AppMethodBeat.o(266859);
    return bool;
  }
  
  public static void apC(String paramString)
  {
    sIt = paramString;
  }
  
  public static final boolean b(dur paramdur)
  {
    AppMethodBeat.i(266860);
    p.k(paramdur, "itemMsg");
    boolean bool = af.b(paramdur);
    AppMethodBeat.o(266860);
    return bool;
  }
  
  public static final int c(dur paramdur)
  {
    AppMethodBeat.i(266862);
    p.k(paramdur, "itemMsg");
    if (af.b(paramdur))
    {
      AppMethodBeat.o(266862);
      return 2;
    }
    if (af.e(paramdur))
    {
      AppMethodBeat.o(266862);
      return 3;
    }
    if (af.f(paramdur))
    {
      AppMethodBeat.o(266862);
      return 4;
    }
    if (af.d(paramdur))
    {
      AppMethodBeat.o(266862);
      return 1;
    }
    AppMethodBeat.o(266862);
    return 0;
  }
  
  public static boolean cAU()
  {
    return sIo;
  }
  
  public static boolean cAV()
  {
    return sIp;
  }
  
  public static boolean cAW()
  {
    return sIq;
  }
  
  public static z cAX()
  {
    return sIs;
  }
  
  public static String cAY()
  {
    return sIt;
  }
  
  public static boolean cAZ()
  {
    return sIr != sCk;
  }
  
  public static void lA(boolean paramBoolean)
  {
    sIo = paramBoolean;
  }
  
  public static void lB(boolean paramBoolean)
  {
    sIp = paramBoolean;
  }
  
  public static void lC(boolean paramBoolean)
  {
    sIq = paramBoolean;
  }
  
  public static void n(z paramz)
  {
    sIs = paramz;
    sIr = sCk;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "opType", "", "invoke"})
  static final class b
    extends q
    implements b<Integer, x>
  {
    b(dur paramdur, Context paramContext, f paramf, z paramz, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */