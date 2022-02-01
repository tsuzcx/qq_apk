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
import com.tencent.mm.aj.m;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "friendReadTv", "Landroid/widget/TextView;", "getFriendReadTv", "()Landroid/widget/TextView;", "setFriendReadTv", "(Landroid/widget/TextView;)V", "itemView", "getItemView", "setItemView", "pressMask", "Landroid/widget/ImageView;", "getPressMask", "()Landroid/widget/ImageView;", "setPressMask", "(Landroid/widget/ImageView;)V", "singleDigest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getSingleDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setSingleDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "singleTitle", "getSingleTitle", "setSingleTitle", "singleTitleLayout", "Landroid/widget/LinearLayout;", "getSingleTitleLayout", "()Landroid/widget/LinearLayout;", "setSingleTitleLayout", "(Landroid/widget/LinearLayout;)V", "statLayout", "getStatLayout", "setStatLayout", "title", "getTitle", "setTitle", "titleLayout", "getTitleLayout", "setTitleLayout", "filling", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "hide", "inflate", "id", "", "inflateStatLayout", "needRoundBottom", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "onAppMsgClick", "convertView", "order", "refreshClickView", "refreshFriendInfo", "refreshTitle", "isSingleMsg", "plugin-brandservice_release"})
public abstract class f
{
  private View amk;
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private View sDd;
  MMNeat7extView sDe;
  ImageView sDf;
  private LinearLayout sDg;
  private LinearLayout sDh;
  private MMNeat7extView sDi;
  private MMNeat7extView sDj;
  private View sDk;
  TextView sDl;
  kotlin.g.a.a<x> sDm;
  
  public f(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.sCg = paramb;
  }
  
  private static boolean a(z paramz, pf parampf)
  {
    boolean bool = true;
    p.k(paramz, "$this$isSingleMsg");
    switch (paramz.hwL().style)
    {
    default: 
      return false;
    case 101: 
      if (parampf != null) {
        break;
      }
    }
    for (paramz = (pf)paramz.hwL().UsF.RVd.get(0);; paramz = parampf)
    {
      return paramz.RXM.size() <= 1;
      paramz = paramz.hwL().UsF.RVd;
      p.j(paramz, "tlRecCardWrapper.extraInfo.BizInfo");
      paramz = ((Iterable)j.c((Iterable)paramz, 2)).iterator();
      int j = 0;
      int i = 0;
      if (paramz.hasNext())
      {
        parampf = paramz.next();
        if (j < 0) {
          j.iBO();
        }
        if (((pf)parampf).RIs != 0) {
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
  
  public void W(View paramView, int paramInt)
  {
    p.k(paramView, "parent");
    if (this.amk != null) {
      return;
    }
    this.amk = ((ViewStub)paramView.findViewById(paramInt)).inflate();
  }
  
  public final void a(LinearLayout paramLinearLayout)
  {
    this.sDg = paramLinearLayout;
  }
  
  public final void a(z paramz, pe parampe)
  {
    p.k(paramz, "info");
    p.k(parampe, "appMsg");
    Object localObject = this.sDj;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.sDk;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (a(paramz, null)) {
      if (!Util.isNullOrNil(parampe.CPq))
      {
        paramz = this.sDj;
        if (paramz != null) {
          paramz.setVisibility(0);
        }
        paramz = this.sDj;
        if (paramz != null) {
          paramz.aL((CharSequence)parampe.CPq);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (Util.isNullOrNil(parampe.CPq));
      paramz = this.sDk;
      if (paramz != null) {
        paramz.setVisibility(0);
      }
      paramz = this.sDg;
      if (paramz != null) {
        paramz.setBackgroundResource(d.d.dmA);
      }
      paramz = this.sDl;
    } while (paramz == null);
    paramz.setText((CharSequence)parampe.CPq);
  }
  
  public final void a(z paramz, pf parampf, pe parampe)
  {
    p.k(paramz, "info");
    p.k(parampf, "bizInfo");
    p.k(parampe, "appMsg");
    Object localObject = this.sDe;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setTextColor(this.context.getResources().getColor(d.b.light_grey_text_color));
    }
    localObject = this.sDg;
    if (localObject != null) {
      ((LinearLayout)localObject).setBackgroundResource(d.d.mm_trans);
    }
    localObject = this.sDl;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.context.getResources().getColor(d.b.light_grey_text_color));
    }
    if (a(paramz, parampf))
    {
      paramz = this.sDh;
      if (paramz != null) {
        paramz.setVisibility(0);
      }
      paramz = this.sDe;
      if (paramz != null) {
        paramz.setVisibility(8);
      }
      paramz = this.sDi;
      if (paramz != null)
      {
        paramz.setMaxLines(2);
        paramz.aL((CharSequence)parampe.fwr);
        parampf = d.sTw;
        if (d.cEs())
        {
          parampf = d.sTw;
          d.e(paramz);
        }
      }
      return;
    }
    paramz = this.sDh;
    if (paramz != null) {
      paramz.setVisibility(8);
    }
    paramz = this.sDe;
    if (paramz != null) {
      paramz.setVisibility(0);
    }
    paramz = this.sDe;
    if (paramz != null) {
      paramz.aL((CharSequence)parampe.fwr);
    }
    paramz = d.sTw;
    d.e(this.sDe);
  }
  
  public final void b(LinearLayout paramLinearLayout)
  {
    this.sDh = paramLinearLayout;
  }
  
  public final void b(final z paramz, pf parampf, final pe parampe)
  {
    int k = 0;
    p.k(paramz, "info");
    p.k(parampf, "bizInfo");
    p.k(parampe, "appMsg");
    Object localObject;
    int i;
    if (a(paramz, parampf))
    {
      localObject = this.sDd;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(d.d.spE);
      }
      localObject = this.sDd;
      if (localObject != null)
      {
        localView = this.sDd;
        if (localView == null) {
          break label238;
        }
        i = localView.getPaddingLeft();
        localView = this.sDd;
        if (localView == null) {
          break label244;
        }
        j = localView.getPaddingRight();
        label96:
        ((View)localObject).setPadding(i, 0, j, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw);
      }
    }
    label238:
    label244:
    do
    {
      localObject = this.sDf;
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(d.d.spC);
      }
      localObject = this.sDd;
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)new a(this, paramz, parampe));
      }
      p.k(parampf, "bizInfo");
      p.k(parampe, "appMsg");
      j = parampf.RXM.size();
      i = k;
      if (j <= 1)
      {
        i = k;
        if (j == 1)
        {
          i = k;
          if (!Util.isNullOrNil(parampe.RTi)) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        paramz = this.sDf;
        if (paramz != null) {
          paramz.setBackgroundResource(d.d.spA);
        }
      }
      return;
      i = 0;
      break;
      j = 0;
      break label96;
      localObject = this.sDd;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(d.d.spF);
      }
      localObject = this.sDd;
    } while (localObject == null);
    View localView = this.sDd;
    if (localView != null)
    {
      i = localView.getPaddingLeft();
      label298:
      localView = this.sDd;
      if (localView == null) {
        break label336;
      }
    }
    label336:
    for (int j = localView.getPaddingRight();; j = 0)
    {
      ((View)localObject).setPadding(i, 0, j, 0);
      break;
      i = 0;
      break label298;
    }
  }
  
  public final void c(MMNeat7extView paramMMNeat7extView)
  {
    this.sDi = paramMMNeat7extView;
  }
  
  public final void cAo()
  {
    if (this.amk == null) {
      return;
    }
    Object localObject = this.amk;
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(d.e.sta);
      this.sDk = ((View)localObject);
      localObject = this.amk;
      if (localObject == null) {
        break label61;
      }
    }
    label61:
    for (localObject = (TextView)((View)localObject).findViewById(d.e.srT);; localObject = null)
    {
      this.sDl = ((TextView)localObject);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void d(MMNeat7extView paramMMNeat7extView)
  {
    this.sDj = paramMMNeat7extView;
  }
  
  public final void dR(View paramView)
  {
    this.sDd = paramView;
  }
  
  public final View getItemView()
  {
    return this.amk;
  }
  
  public final void hide()
  {
    View localView = this.amk;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(f paramf, z paramz, pe parampe) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(263588);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = this.sDn.sDm;
      if (paramView != null) {
        paramView.invoke();
      }
      paramView = this.sDn;
      localObject1 = paramz;
      pe localpe = parampe;
      p.k(localObject1, "info");
      if ((localpe != null) && (((z)localObject1).hwK() != null))
      {
        localObject2 = ((z)localObject1).hwK();
        if (localObject2 == null) {
          p.iCn();
        }
        if (((eqb)localObject2).Usy != null) {}
      }
      else
      {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(263588);
        return;
      }
      Object localObject2 = ((z)localObject1).hwK();
      if (localObject2 == null) {
        p.iCn();
      }
      Object localObject3 = ((eqb)localObject2).Usy;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 4L, 1L, false);
      Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localpe.RTk });
      Intent localIntent = new Intent();
      localObject2 = m.e(localpe.RTk, 169, 10000, 0);
      localIntent.putExtra("rawUrl", (String)localObject2);
      localIntent.putExtra("geta8key_scene", 56);
      localIntent.putExtra("geta8key_username", ((eqd)localObject3).UserName);
      localIntent.putExtra("srcUsername", ((eqd)localObject3).UserName);
      localIntent.putExtra("srcDisplayname", ((eqd)localObject3).rWI);
      localIntent.putExtra("prePublishId", "rec_card");
      localIntent.putExtra("KPublisherId", "rec_card");
      if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramView.context, (String)localObject2, localpe.lpx, 169, 10000, localIntent))) {
        Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
      }
      for (;;)
      {
        localObject3 = ((z)localObject1).hwL();
        int j;
        int i;
        if (localObject3 != null)
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
        com.tencent.mm.plugin.brandservice.ui.timeline.f.a((eqg)localObject3);
        paramView.sCg.szZ.a(((z)localObject1).field_talker, l, i, 15, ((eqg)localObject3).Uaw, "", 0, ((eqg)localObject3).UsF.RVm, ((eqg)localObject3).event, ((eqg)localObject3).UsF.RVi, localpe.RXJ, ((eqg)localObject3).style, localpe.RXK);
        paramView.sCg.b((z)localObject1, 0);
        break;
        com.tencent.mm.by.c.b(paramView.context, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.f
 * JD-Core Version:    0.7.0.1
 */