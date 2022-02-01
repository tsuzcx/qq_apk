package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "friendReadTv", "Landroid/widget/TextView;", "getFriendReadTv", "()Landroid/widget/TextView;", "setFriendReadTv", "(Landroid/widget/TextView;)V", "itemView", "getItemView", "setItemView", "pressMask", "Landroid/widget/ImageView;", "getPressMask", "()Landroid/widget/ImageView;", "setPressMask", "(Landroid/widget/ImageView;)V", "singleDigest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getSingleDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setSingleDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "singleTitle", "getSingleTitle", "setSingleTitle", "singleTitleLayout", "Landroid/widget/LinearLayout;", "getSingleTitleLayout", "()Landroid/widget/LinearLayout;", "setSingleTitleLayout", "(Landroid/widget/LinearLayout;)V", "statLayout", "getStatLayout", "setStatLayout", "title", "getTitle", "setTitle", "titleLayout", "getTitleLayout", "setTitleLayout", "filling", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "hide", "inflate", "id", "", "inflateStatLayout", "needRoundBottom", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "onAppMsgClick", "convertView", "order", "refreshClickView", "refreshFriendInfo", "refreshTitle", "isSingleMsg", "plugin-brandservice_release"})
public abstract class f
{
  View aus;
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  View ptQ;
  MMNeat7extView ptR;
  ImageView ptS;
  LinearLayout ptT;
  LinearLayout ptU;
  MMNeat7extView ptV;
  MMNeat7extView ptW;
  private View ptX;
  TextView ptY;
  kotlin.g.a.a<kotlin.x> ptZ;
  
  public f(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.psQ = paramb;
  }
  
  private static boolean a(pj parampj, pi parampi)
  {
    p.h(parampj, "bizInfo");
    p.h(parampi, "appMsg");
    int i = parampj.KWy.size();
    if (i > 1) {}
    while ((i != 1) || (Util.isNullOrNil(parampi.KSh))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(z paramz, pj parampj)
  {
    boolean bool = true;
    p.h(paramz, "$this$isSingleMsg");
    switch (paramz.gAD().style)
    {
    default: 
      return false;
    case 101: 
      if (parampj != null) {
        break;
      }
    }
    for (paramz = (pj)paramz.gAD().Nga.KUf.get(0);; paramz = parampj)
    {
      return paramz.KWy.size() <= 1;
      paramz = paramz.gAD().Nga.KUf;
      p.g(paramz, "tlRecCardWrapper.extraInfo.BizInfo");
      paramz = ((Iterable)j.b((Iterable)paramz, 2)).iterator();
      int j = 0;
      int i = 0;
      if (paramz.hasNext())
      {
        parampj = paramz.next();
        if (j < 0) {
          j.hxH();
        }
        if (((pj)parampj).KHa != 0) {
          break label175;
        }
        i += 1;
      }
      label175:
      for (;;)
      {
        j += 1;
        break;
        if (i < 2) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
  }
  
  public void U(View paramView, int paramInt)
  {
    p.h(paramView, "parent");
    if (this.aus != null) {
      return;
    }
    this.aus = ((ViewStub)paramView.findViewById(paramInt)).inflate();
  }
  
  public final void a(z paramz, pi parampi)
  {
    p.h(paramz, "info");
    p.h(parampi, "appMsg");
    Object localObject = this.ptW;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.ptX;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (a(paramz, null)) {
      if (!Util.isNullOrNil(parampi.xLi))
      {
        paramz = this.ptW;
        if (paramz != null) {
          paramz.setVisibility(0);
        }
        paramz = this.ptW;
        if (paramz != null) {
          paramz.aw((CharSequence)parampi.xLi);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (Util.isNullOrNil(parampi.xLi));
      paramz = this.ptX;
      if (paramz != null) {
        paramz.setVisibility(0);
      }
      paramz = this.ptT;
      if (paramz != null) {
        paramz.setBackgroundResource(2131231342);
      }
      paramz = this.ptY;
    } while (paramz == null);
    paramz.setText((CharSequence)parampi.xLi);
  }
  
  public final void a(z paramz, pj parampj, pi parampi)
  {
    p.h(paramz, "info");
    p.h(parampj, "bizInfo");
    p.h(parampi, "appMsg");
    Object localObject = this.ptR;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setTextColor(this.context.getResources().getColor(2131100679));
    }
    localObject = this.ptT;
    if (localObject != null) {
      ((LinearLayout)localObject).setBackgroundResource(2131233974);
    }
    localObject = this.ptY;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.context.getResources().getColor(2131100679));
    }
    if (a(paramz, parampj))
    {
      paramz = this.ptU;
      if (paramz != null) {
        paramz.setVisibility(0);
      }
      paramz = this.ptR;
      if (paramz != null) {
        paramz.setVisibility(8);
      }
      paramz = this.ptV;
      if (paramz != null)
      {
        paramz.setMaxLines(2);
        paramz.aw((CharSequence)parampi.Title);
        parampj = d.pMy;
        if (d.crj())
        {
          parampj = d.pMy;
          d.c(paramz);
        }
      }
      return;
    }
    paramz = this.ptU;
    if (paramz != null) {
      paramz.setVisibility(8);
    }
    paramz = this.ptR;
    if (paramz != null) {
      paramz.setVisibility(0);
    }
    paramz = this.ptR;
    if (paramz != null) {
      paramz.aw((CharSequence)parampi.Title);
    }
    paramz = d.pMy;
    d.c(this.ptR);
  }
  
  public final void b(final z paramz, pj parampj, final pi parampi)
  {
    p.h(paramz, "info");
    p.h(parampj, "bizInfo");
    p.h(parampi, "appMsg");
    Object localObject;
    int i;
    if (a(paramz, parampj))
    {
      localObject = this.ptQ;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2131231316);
      }
      localObject = this.ptQ;
      if (localObject != null)
      {
        localView = this.ptQ;
        if (localView == null) {
          break label178;
        }
        i = localView.getPaddingLeft();
        localView = this.ptQ;
        if (localView == null) {
          break label184;
        }
        j = localView.getPaddingRight();
        label92:
        ((View)localObject).setPadding(i, 0, j, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry);
      }
    }
    label178:
    label184:
    do
    {
      localObject = this.ptS;
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(2131231313);
      }
      localObject = this.ptQ;
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)new a(this, paramz, parampi));
      }
      if (a(parampj, parampi))
      {
        paramz = this.ptS;
        if (paramz != null) {
          paramz.setBackgroundResource(2131231311);
        }
      }
      return;
      i = 0;
      break;
      j = 0;
      break label92;
      localObject = this.ptQ;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2131231322);
      }
      localObject = this.ptQ;
    } while (localObject == null);
    View localView = this.ptQ;
    if (localView != null)
    {
      i = localView.getPaddingLeft();
      label238:
      localView = this.ptQ;
      if (localView == null) {
        break label276;
      }
    }
    label276:
    for (int j = localView.getPaddingRight();; j = 0)
    {
      ((View)localObject).setPadding(i, 0, j, 0);
      break;
      i = 0;
      break label238;
    }
  }
  
  public final void cmH()
  {
    if (this.aus == null) {
      return;
    }
    Object localObject = this.aus;
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131308374);
      this.ptX = ((View)localObject);
      localObject = this.aus;
      if (localObject == null) {
        break label61;
      }
    }
    label61:
    for (localObject = (TextView)((View)localObject).findViewById(2131301796);; localObject = null)
    {
      this.ptY = ((TextView)localObject);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void hide()
  {
    View localView = this.aus;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(f paramf, z paramz, pi parampi) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195271);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = this.pua.ptZ;
      if (localObject1 != null) {
        ((kotlin.g.a.a)localObject1).invoke();
      }
      localObject1 = this.pua;
      z localz = paramz;
      pi localpi = parampi;
      p.h(localz, "info");
      if ((localpi != null) && (localz.gAC() != null))
      {
        localObject2 = localz.gAC();
        if (localObject2 == null) {
          p.hyc();
        }
        if (((efz)localObject2).NfT != null) {}
      }
      else
      {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195271);
        return;
      }
      Object localObject2 = localz.gAC();
      if (localObject2 == null) {
        p.hyc();
      }
      Object localObject3 = ((efz)localObject2).NfT;
      h.CyF.idkeyStat(1149L, 4L, 1L, false);
      Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localpi.KSj });
      Intent localIntent = new Intent();
      localObject2 = m.d(localpi.KSj, 169, 10000, 0);
      localIntent.putExtra("rawUrl", (String)localObject2);
      localIntent.putExtra("geta8key_scene", 56);
      localIntent.putExtra("geta8key_username", ((egb)localObject3).UserName);
      localIntent.putExtra("srcUsername", ((egb)localObject3).UserName);
      localIntent.putExtra("srcDisplayname", ((egb)localObject3).oUJ);
      localIntent.putExtra("prePublishId", "rec_card");
      localIntent.putExtra("KPublisherId", "rec_card");
      int i;
      int j;
      if (localpi.iAb == 5)
      {
        Object localObject4 = g.af(com.tencent.mm.plugin.brandservice.a.b.class);
        p.g(localObject4, "MMKernel.service(IBrandService::class.java)");
        if (((com.tencent.mm.plugin.brandservice.a.b)localObject4).cld())
        {
          localIntent.putExtra(e.b.OyQ, 169);
          localIntent.putExtra(e.b.OyR, 10000);
          localIntent.putExtra("biz_video_session_id", ab.getSessionId());
          localObject4 = new com.tencent.mm.ag.x();
          ((com.tencent.mm.ag.x)localObject4).iAh = localIntent.getStringExtra("KPublisherId");
          ((com.tencent.mm.ag.x)localObject4).dHc = ((egb)localObject3).UserName;
          ((com.tencent.mm.ag.x)localObject4).iAg = ((egb)localObject3).oUJ;
          ((com.tencent.mm.ag.x)localObject4).iAi.url = ((String)localObject2);
          ((com.tencent.mm.ag.x)localObject4).iAi.title = localpi.Title;
          ((com.tencent.mm.ag.x)localObject4).iAi.iAq = localpi.KSh;
          ((com.tencent.mm.ag.x)localObject4).iAi.iAo = localpi.KSl;
          ((com.tencent.mm.ag.x)localObject4).iAi.type = localpi.iAb;
          ((com.tencent.mm.ag.x)localObject4).iAi.time = localpi.CreateTime;
          ((com.tencent.mm.ag.x)localObject4).iAi.iAs = localpi.KSx;
          ((com.tencent.mm.ag.x)localObject4).iAi.videoWidth = localpi.KSv;
          ((com.tencent.mm.ag.x)localObject4).iAi.videoHeight = localpi.KSw;
          ((com.tencent.mm.ag.x)localObject4).iAi.vid = localpi.KSu;
          ((com.tencent.mm.ag.x)localObject4).t(localIntent);
          Log.i("MicroMsg.BizTimeLineItem", "jump to native video");
          localObject3 = new int[2];
          if (paramView != null)
          {
            i = paramView.getWidth();
            j = paramView.getHeight();
            paramView.getLocationInWindow((int[])localObject3);
            localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", localObject3[0]).putExtra("img_gallery_top", localObject3[1]);
          }
          localIntent.addFlags(268435456);
        }
      }
      if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(((f)localObject1).context, (String)localObject2, localpi.iAb, 169, 10000, localIntent))) {
        Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
      }
      for (;;)
      {
        paramView = localz.gAD();
        if (paramView != null)
        {
          j = 0;
          i = j;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject2);
          i = j;
          j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
          i = j;
          l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l = 0L;
          }
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.f.a(paramView);
        ((f)localObject1).psQ.pqZ.a(localz.field_talker, l, i, 15, paramView.MOC, "", 0, paramView.Nga.KUo, paramView.event, paramView.Nga.KUk, localpi.KWv, paramView.style, localpi.KWw);
        ((f)localObject1).psQ.b(localz, 0);
        break;
        c.b(((f)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.f
 * JD-Core Version:    0.7.0.1
 */