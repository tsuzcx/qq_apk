package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.SystemClock;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.view.custom.dialog.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderChatTimelineShareDialog;", "", "context", "Landroid/content/Context;", "username", "", "type", "", "finderObject", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "finderLiveObject", "Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "(Landroid/content/Context;Ljava/lang/String;ILcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;)V", "build", "Lcom/tencent/mm/plugin/finder/view/custom/dialog/ConfirmDialog$build;", "getContext", "()Landroid/content/Context;", "getFinderLiveObject", "()Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "getFinderObject", "()Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "getUsername", "()Ljava/lang/String;", "initConfirmDialogContent", "", "builder", "initFinderLiveObjectDialog", "Landroid/view/View;", "initFinderObjectDialog", "setOkClickListener", "id", "", "listener", "Lcom/tencent/mm/plugin/finder/view/custom/dialog/IConfirmDialog$IOnDialogClick;", "tryHide", "tryShow", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a Gxh;
  private static r<Boolean, Long> Gxl;
  private static int count;
  private final f Gxi;
  private final com.tencent.mm.plugin.findersdk.a.b Gxj;
  private com.tencent.mm.plugin.finder.view.custom.dialog.a.a Gxk;
  private final Context context;
  private final int type;
  private final String username;
  
  static
  {
    AppMethodBeat.i(344811);
    Gxh = new e.a((byte)0);
    Gxl = new r(Boolean.FALSE, Long.valueOf(0L));
    AppMethodBeat.o(344811);
  }
  
  private e(Context paramContext, String paramString, int paramInt, f paramf, com.tencent.mm.plugin.findersdk.a.b paramb)
  {
    AppMethodBeat.i(344766);
    this.context = paramContext;
    this.username = paramString;
    this.type = paramInt;
    this.Gxi = paramf;
    this.Gxj = paramb;
    paramf = new com.tencent.mm.plugin.finder.view.custom.dialog.a.a(this.context);
    paramf.fI(this.username);
    paramContext = "";
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    switch (this.type)
    {
    default: 
      paramContext = "";
      paramInt = 1;
      paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramString = (emx)com.tencent.mm.plugin.secdata.ui.a.a.c(this.context, 14, emx.class);
      if (paramString != null)
      {
        paramString.scene = paramInt;
        paramString.lsO = 3;
        paramString.Qmp = ((int)(SystemClock.elapsedRealtime() - paramString.startTime));
        paramString.MFq = "";
        paramString.abrg = paramContext;
        paramString.toUser = this.username;
        if (this.type == 18)
        {
          paramContext = an.GhR;
          paramString.abrf = an.a.ffy();
        }
      }
      paramf.x(Boolean.TRUE);
      paramf.x(Boolean.TRUE);
      paramContext = ah.aiuX;
      this.Gxk = paramf;
      AppMethodBeat.o(344766);
      return;
    case 18: 
      paramString = this.Gxi;
      TextView localTextView1;
      if (paramString != null)
      {
        paramContext = new com.tencent.mm.loader.b.e.a();
        paramContext.nqd = true;
        paramContext.nqc = true;
        paramContext.nqp = true;
        localObject1 = paramContext.blI();
        paramContext = View.inflate(this.context, e.f.share_finder_feed_to_chat_view, null);
        paramb = paramContext.findViewById(e.e.finder_feed_container);
        localObject2 = (ImageView)paramb.findViewById(e.e.finder_avatar);
        localObject3 = com.tencent.mm.loader.e.noo;
        localObject3 = com.tencent.mm.loader.e.blh();
        localObject4 = Util.nullAsNil(paramString.bCr());
        s.s(localObject4, "nullAsNil(finderObject.getAvatar())");
        s.s(localObject2, "finderAvatar");
        ((com.tencent.mm.loader.a)localObject3).a((String)localObject4, (ImageView)localObject2, (com.tencent.mm.loader.b.e)localObject1);
        localObject1 = (TextView)paramb.findViewById(e.e.finder_nickname);
        localObject2 = this.context;
        localObject3 = av.GiL;
        ((TextView)localObject1).setText((CharSequence)p.b((Context)localObject2, (CharSequence)av.aBN(paramString.getNickname())));
        aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject3 = (ImageView)paramb.findViewById(e.e.finder_thumb);
        localObject4 = (ImageView)paramb.findViewById(e.e.finder_mediaType);
        localObject5 = (ImageIndicatorView)paramb.findViewById(e.e.chatting_item_finder_image_indicator);
        localTextView1 = (TextView)paramb.findViewById(e.e.finder_desc);
        localObject2 = (ImageView)paramb.findViewById(e.e.finder_auth_icon);
        if (paramString.oUc.GfT != 1) {
          break label761;
        }
        ((ImageView)localObject3).setVisibility(8);
        TextView localTextView2 = (TextView)paramb.findViewById(e.e.finder_text);
        localTextView2.setText((CharSequence)p.b(this.context, (CharSequence)paramString.oUc.desc));
        localTextView2.setVisibility(0);
        label542:
        localTextView1.setVisibility(8);
        label549:
        if ((paramString.oUc.GfT != 4) && (paramString.oUc.GfT != 6)) {
          break label854;
        }
        ((ImageView)localObject4).setVisibility(0);
        if (localObject5 != null) {
          ((ImageIndicatorView)localObject5).setVisibility(8);
        }
        label590:
        paramInt = (int)this.context.getResources().getDimension(e.c.Edge_18A);
        localObject4 = (bvj)paramString.oUc.mediaList.getFirst();
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt, (int)(androidx.core.b.a.g(1.0F * ((bvj)localObject4).height / ((bvj)localObject4).width, 1.0F, 1.333333F) * paramInt)));
        paramb.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
        paramb = av.GiL;
        s.s(localObject2, "authImageView");
        s.s(localObject1, "nickTv");
        paramb.a((ImageView)localObject2, (TextView)localObject1, paramString.oUc, (int)this.context.getResources().getDimension(e.c.Edge_2A));
        paramf.hg(paramContext);
        paramContext = this.Gxi;
        if (paramContext != null) {
          break label920;
        }
      }
      label920:
      for (paramContext = null;; paramContext = Integer.valueOf(paramContext.type))
      {
        paramContext = paramContext.toString();
        paramf.flU();
        paramInt = 1;
        break;
        label761:
        if (paramString.oUc.mediaList.size() > 0) {
          ((cn)h.az(cn.class)).loadImage(((bvj)paramString.oUc.mediaList.get(0)).thumbUrl, (ImageView)localObject3);
        }
        if (Util.isNullOrNil(paramString.oUc.desc)) {
          break label542;
        }
        localTextView1.setVisibility(0);
        localTextView1.setText((CharSequence)p.b(this.context, (CharSequence)paramString.oUc.desc));
        break label549;
        label854:
        if (paramString.oUc.GfT == 2)
        {
          ((ImageView)localObject4).setVisibility(8);
          if (localObject5 == null) {
            break label590;
          }
          ((ImageIndicatorView)localObject5).setVisibility(0);
          ((ImageIndicatorView)localObject5).RVj = paramString.oUc.hGP;
          break label590;
        }
        ((ImageView)localObject4).setVisibility(8);
        if (localObject5 == null) {
          break label590;
        }
        ((ImageIndicatorView)localObject5).setVisibility(8);
        break label590;
      }
    }
    paramb = this.Gxj;
    if (paramb != null)
    {
      paramContext = new com.tencent.mm.loader.b.e.a();
      paramContext.nqd = true;
      paramContext.nqc = true;
      paramContext.nqp = true;
      localObject2 = paramContext.blI();
      localObject1 = View.inflate(this.context, e.f.share_finder_live_feed_to_chat_view, null);
      paramContext = ((View)localObject1).findViewById(e.e.finder_feed_container);
      s.s(paramContext, "view.findViewById(R.id.finder_feed_container)");
      paramString = paramContext.findViewById(e.e.finder_avatar);
      s.s(paramString, "content.findViewById(R.id.finder_avatar)");
      localObject3 = (ImageView)paramString;
      paramString = paramContext.findViewById(e.e.finder_auth_icon);
      s.s(paramString, "content.findViewById(R.id.finder_auth_icon)");
      paramString = (ImageView)paramString;
      localObject4 = com.tencent.mm.loader.e.noo;
      localObject4 = com.tencent.mm.loader.e.blh();
      localObject5 = Util.nullAsNil(paramb.HbV.headUrl);
      s.s(localObject5, "nullAsNil(finderObject.shareObject.headUrl)");
      ((com.tencent.mm.loader.a)localObject4).a((String)localObject5, (ImageView)localObject3, (com.tencent.mm.loader.b.e)localObject2);
      localObject2 = paramContext.findViewById(e.e.finder_nickname);
      s.s(localObject2, "content.findViewById(R.id.finder_nickname)");
      localObject5 = (TextView)localObject2;
      ((TextView)localObject5).setText((CharSequence)p.b(this.context, (CharSequence)paramb.HbV.nickName));
      aw.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
      localObject2 = paramContext.findViewById(e.e.finder_thumb);
      s.s(localObject2, "content.findViewById(R.id.finder_thumb)");
      localObject2 = (ImageView)localObject2;
      localObject3 = paramContext.findViewById(e.e.finder_desc);
      s.s(localObject3, "content.findViewById(R.id.finder_desc)");
      localObject3 = (TextView)localObject3;
      localObject4 = paramContext.findViewById(e.e.finder_olympic_invite_view);
      s.s(localObject4, "content.findViewById(R.i…nder_olympic_invite_view)");
      if (!TextUtils.isEmpty((CharSequence)paramb.HbV.desc)) {
        break label1922;
      }
      ((TextView)localObject3).setVisibility(8);
      label1236:
      ((cn)h.az(cn.class)).loadImage(Util.nullAs(paramb.HbV.coverUrl, ""), (ImageView)localObject2);
      int i = (int)this.context.getResources().getDimension(e.c.Edge_18A);
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(i, (int)(1.333333F * i)));
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(i, (int)(1.333333F * i)));
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).fillAuthIcon((TextView)localObject5, paramString, paramb, 12.0F);
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).setFinderLiveTagText(((View)localObject1).findViewById(e.e.finder_live_icon), paramb.HbV.ZVl);
      paramContext = this.Gxj;
      if (paramContext != null) {
        break label1947;
      }
      paramContext = null;
      label1412:
      paramContext = (CharSequence)paramContext;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label1969;
      }
      paramInt = 1;
      label1432:
      if (paramInt != 0) {
        break label2085;
      }
      paramContext = this.Gxj;
      if (paramContext != null) {
        break label1974;
      }
      paramContext = null;
      label1447:
      paramContext = (CharSequence)paramContext;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label1996;
      }
      paramInt = 1;
      label1467:
      if (paramInt != 0) {
        break label2085;
      }
      paramContext = this.Gxj;
      if (paramContext != null) {
        break label2001;
      }
      paramContext = null;
      label1482:
      if (!s.p(paramContext, "1")) {
        break label2085;
      }
      paramContext = ((View)localObject4).findViewById(e.e.finder_olympic_invite_bg);
      s.s(paramContext, "finderOlympicView.findVi…finder_olympic_invite_bg)");
      paramContext = (ImageView)paramContext;
      paramString = ((View)localObject4).findViewById(e.e.finder_olympic_invite_icon);
      s.s(paramString, "finderOlympicView.findVi…nder_olympic_invite_icon)");
      paramString = (ImageView)paramString;
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage(paramContext, b.j.ahpn, e.d.finder_olympic_live_share_bg);
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage(paramString, b.j.ahpo, e.d.finder_olympic_live_share_icon);
      paramContext = ((View)localObject4).findViewById(e.e.finder_olympic_invite_text);
      s.s(paramContext, "finderOlympicView.findVi…nder_olympic_invite_text)");
      localObject5 = (TextView)paramContext;
      ((TextView)localObject5).setTextSize(1, 14.0F);
      paramContext = ((View)localObject4).findViewById(e.e.finder_olympic_invite_name);
      s.s(paramContext, "finderOlympicView.findVi…nder_olympic_invite_name)");
      paramContext = (TextView)paramContext;
      paramContext.setTextSize(1, 14.0F);
      paramString = ((View)localObject4).findViewById(e.e.finder_olympic_invite_you);
      s.s(paramString, "finderOlympicView.findVi…inder_olympic_invite_you)");
      paramString = (TextView)paramString;
      paramString.setTextSize(1, 13.0F);
      i.setTextBold((TextView)localObject5);
      i.setTextBold(paramContext);
      i.setTextBold(paramString);
      paramString = (CharSequence)this.Gxj.HbV.ZVr;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label2023;
      }
      paramInt = 1;
      label1707:
      if (paramInt == 0) {
        break label2028;
      }
      paramContext.setVisibility(8);
      label1717:
      paramContext = this.context.getResources().getString(e.h.finder_olympic_invite_text_3, new Object[] { this.Gxj.HbV.ZVq });
      s.s(paramContext, "context.resources.getStr…t.shareObject.relayIndex)");
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.context, 12);
      paramString = n.bV(paramContext, "\n", "");
      if (new StaticLayout((CharSequence)paramString, 0, paramString.length(), ((TextView)localObject5).getPaint(), i - paramInt * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
        break label2107;
      }
      paramContext = paramString;
    }
    label1849:
    label2107:
    for (;;)
    {
      ((TextView)localObject5).setText((CharSequence)paramContext);
      paramString = this.context.getResources();
      paramInt = e.h.finder_olympic_invite_text_1;
      paramContext = this.Gxj;
      if (paramContext == null)
      {
        paramContext = null;
        ((TextView)localObject5).setText((CharSequence)paramString.getString(paramInt, new Object[] { paramContext }));
        ((View)localObject4).setVisibility(0);
        ((ImageView)localObject2).setVisibility(8);
        ((TextView)localObject3).setVisibility(8);
      }
      for (;;)
      {
        paramf.hg((View)localObject1);
        paramContext = Integer.valueOf(paramb.type).toString();
        paramInt = 8;
        paramf.flU();
        break;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText((CharSequence)paramb.HbV.desc);
        break label1236;
        paramContext = paramContext.HbV;
        if (paramContext == null)
        {
          paramContext = null;
          break label1412;
        }
        paramContext = paramContext.ZVq;
        break label1412;
        paramInt = 0;
        break label1432;
        paramContext = paramContext.HbV;
        if (paramContext == null)
        {
          paramContext = null;
          break label1447;
        }
        paramContext = paramContext.eventId;
        break label1447;
        label1996:
        paramInt = 0;
        break label1467;
        label2001:
        paramContext = paramContext.HbV;
        if (paramContext == null)
        {
          paramContext = null;
          break label1482;
        }
        paramContext = paramContext.eventId;
        break label1482;
        label2023:
        paramInt = 0;
        break label1707;
        label2028:
        paramContext.setText((CharSequence)p.b(this.context, (CharSequence)this.Gxj.HbV.ZVr));
        paramContext.setVisibility(0);
        break label1717;
        paramContext = paramContext.HbV;
        if (paramContext == null)
        {
          paramContext = null;
          break label1849;
        }
        paramContext = paramContext.ZVq;
        break label1849;
        ((View)localObject4).setVisibility(8);
        ((ImageView)localObject2).setVisibility(0);
        ((TextView)localObject3).setVisibility(0);
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.view.custom.dialog.a.a parama, e parame, long paramLong, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(344785);
    s.u(parama, "$this_apply");
    s.u(parame, "this$0");
    parama.pRv.dismiss();
    parama = as.GSQ;
    parama = as.a.hu(parame.context);
    if (parama == null) {}
    for (parama = null;; parama = parama.fou())
    {
      parame = z.FrZ;
      z.a(paramLong, 6, 3L, "", parama, 0L, null, 96);
      AppMethodBeat.o(344785);
      return;
    }
  }
  
  private static final void a(c.a parama, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(344776);
    s.u(parama, "$listener");
    if (paramBoolean) {
      parama.onDialogClick(paramBoolean, paramString, paramInt);
    }
    AppMethodBeat.o(344776);
  }
  
  public final void a(long paramLong, c.a parama)
  {
    AppMethodBeat.i(344831);
    s.u(parama, "listener");
    com.tencent.mm.plugin.finder.view.custom.dialog.a.a locala = this.Gxk;
    if (locala != null)
    {
      locala.UL(e.h.app_send).a(new e..ExternalSyntheticLambda1(parama));
      locala.pRv.b(e.h.finder_liked_cancel, new e..ExternalSyntheticLambda0(locala, this, paramLong));
    }
    AppMethodBeat.o(344831);
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(344849);
    Object localObject = this.Gxk;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.custom.dialog.a.a)localObject).pRv;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).dismiss();
      }
    }
    AppMethodBeat.o(344849);
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(344841);
    Object localObject = this.Gxk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.view.custom.dialog.a.a)localObject).pRv.show();
    }
    localObject = com.tencent.mm.pluginsdk.j.a.XUW;
    com.tencent.mm.pluginsdk.j.a.ly(this.context);
    AppMethodBeat.o(344841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e
 * JD-Core Version:    0.7.0.1
 */