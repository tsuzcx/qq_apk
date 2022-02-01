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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.x;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "friendReadTv", "Landroid/widget/TextView;", "getFriendReadTv", "()Landroid/widget/TextView;", "setFriendReadTv", "(Landroid/widget/TextView;)V", "itemView", "getItemView", "setItemView", "pressMask", "Landroid/widget/ImageView;", "getPressMask", "()Landroid/widget/ImageView;", "setPressMask", "(Landroid/widget/ImageView;)V", "singleDigest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getSingleDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setSingleDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "singleTitle", "getSingleTitle", "setSingleTitle", "singleTitleLayout", "Landroid/widget/LinearLayout;", "getSingleTitleLayout", "()Landroid/widget/LinearLayout;", "setSingleTitleLayout", "(Landroid/widget/LinearLayout;)V", "statLayout", "getStatLayout", "setStatLayout", "title", "getTitle", "setTitle", "titleLayout", "getTitleLayout", "setTitleLayout", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "hide", "inflate", "id", "", "inflateStatLayout", "needRoundBottom", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "onAppMsgClick", "convertView", "order", "refreshClickView", "refreshFriendInfo", "refreshTitle", "plugin-brandservice_release"})
public abstract class e
{
  View auu;
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
  View oio;
  MMNeat7extView oip;
  ImageView oiq;
  LinearLayout oir;
  LinearLayout ois;
  MMNeat7extView oit;
  MMNeat7extView oiu;
  private View oiv;
  TextView oiw;
  
  public e(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.ohs = paramb;
  }
  
  private static boolean a(om paramom, ol paramol)
  {
    p.h(paramom, "bizInfo");
    p.h(paramol, "appMsg");
    int i = paramom.Gcu.size();
    if (i > 1) {}
    while ((i != 1) || (bu.isNullOrNil(paramol.FYq))) {
      return false;
    }
    return true;
  }
  
  public void V(View paramView, int paramInt)
  {
    p.h(paramView, "parent");
    if (this.auu != null) {
      return;
    }
    this.auu = ((ViewStub)paramView.findViewById(paramInt)).inflate();
  }
  
  public final void a(ol paramol)
  {
    p.h(paramol, "appMsg");
    if (!bu.isNullOrNil(paramol.usP))
    {
      Object localObject = this.oiv;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.oir;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(2131231282);
      }
      localObject = this.oiw;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramol.usP);
      }
    }
    do
    {
      return;
      paramol = this.oiv;
    } while (paramol == null);
    paramol.setVisibility(8);
  }
  
  public final void b(w paramw, om paramom, ol paramol)
  {
    int k = 1;
    p.h(paramw, "info");
    p.h(paramom, "bizInfo");
    p.h(paramol, "appMsg");
    switch (paramw.ftk().style)
    {
    default: 
      i = 0;
    case 101: 
      for (;;)
      {
        paramw = this.oip;
        if (paramw != null) {
          paramw.setTextColor(this.context.getResources().getColor(2131100541));
        }
        paramw = this.oir;
        if (paramw != null) {
          paramw.setBackgroundResource(2131233299);
        }
        paramw = this.oiw;
        if (paramw != null) {
          paramw.setTextColor(this.context.getResources().getColor(2131100541));
        }
        if (i == 0) {
          break label438;
        }
        paramw = this.ois;
        if (paramw != null) {
          paramw.setVisibility(0);
        }
        paramw = this.oip;
        if (paramw != null) {
          paramw.setVisibility(8);
        }
        paramw = this.oit;
        if (paramw != null)
        {
          paramw.setMaxLines(2);
          paramw.aq((CharSequence)paramol.Title);
        }
        if (bu.isNullOrNil(paramol.FYq)) {
          break label422;
        }
        i = com.tencent.mm.cb.a.iu(this.context);
        j = com.tencent.mm.cb.a.fromDPToPix(this.context, 48);
        paramom = this.oiu;
        if (paramom != null)
        {
          paramom.aq((CharSequence)paramol.FYq);
          paramom.setVisibility(0);
          paramw = this.oit;
          if (paramw == null) {
            break;
          }
          paramw = paramw.kR(i - j, 2147483647);
          label255:
          if ((paramw == null) || (paramw.fXb() < 2)) {
            break label416;
          }
          i = k;
          label273:
          paramom.setMaxLines(i);
        }
        label279:
        return;
        if (paramom.Gcu.size() <= 1) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    paramw = paramw.ftk().HTS.Gal;
    p.g(paramw, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramw = ((Iterable)j.b((Iterable)paramw, 2)).iterator();
    int j = 0;
    int i = 0;
    label344:
    if (paramw.hasNext())
    {
      paramom = paramw.next();
      if (j < 0) {
        j.gkd();
      }
      if (((om)paramom).FNv != 0) {
        break label499;
      }
      i += 1;
    }
    label416:
    label422:
    label438:
    label499:
    for (;;)
    {
      j += 1;
      break label344;
      if (i < 2)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      paramw = null;
      break label255;
      i = 2;
      break label273;
      paramw = this.oiu;
      if (paramw == null) {
        break label279;
      }
      paramw.setVisibility(8);
      return;
      paramw = this.ois;
      if (paramw != null) {
        paramw.setVisibility(8);
      }
      paramw = this.oip;
      if (paramw != null) {
        paramw.setVisibility(0);
      }
      paramw = this.oip;
      if (paramw != null) {
        paramw.aq((CharSequence)paramol.Title);
      }
      paramw = com.tencent.mm.plugin.brandservice.ui.b.d.oyS;
      com.tencent.mm.plugin.brandservice.ui.b.d.a(this.oip);
      return;
    }
  }
  
  public final void bPv()
  {
    if (this.auu == null) {
      return;
    }
    Object localObject = this.auu;
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131305184);
      this.oiv = ((View)localObject);
      localObject = this.auu;
      if (localObject == null) {
        break label61;
      }
    }
    label61:
    for (localObject = (TextView)((View)localObject).findViewById(2131300305);; localObject = null)
    {
      this.oiw = ((TextView)localObject);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void c(final w paramw, om paramom, final ol paramol)
  {
    int k = 1;
    p.h(paramw, "info");
    p.h(paramom, "bizInfo");
    p.h(paramol, "appMsg");
    int i;
    switch (paramw.ftk().style)
    {
    default: 
      i = 0;
    }
    Object localObject1;
    Object localObject2;
    label108:
    int j;
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.oio;
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundResource(2131231256);
        }
        localObject1 = this.oio;
        if (localObject1 != null)
        {
          localObject2 = this.oio;
          if (localObject2 != null)
          {
            i = ((View)localObject2).getPaddingLeft();
            localObject2 = this.oio;
            if (localObject2 == null) {
              break label358;
            }
            j = ((View)localObject2).getPaddingRight();
            label126:
            ((View)localObject1).setPadding(i, 0, j, com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW);
          }
        }
        else
        {
          label139:
          localObject1 = this.oiq;
          if (localObject1 != null) {
            ((ImageView)localObject1).setBackgroundResource(2131231253);
          }
          localObject1 = this.oio;
          if (localObject1 != null) {
            ((View)localObject1).setOnClickListener((View.OnClickListener)new a(this, paramw, paramol));
          }
          if (a(paramom, paramol))
          {
            paramw = this.oiq;
            if (paramw != null) {
              paramw.setBackgroundResource(2131231251);
            }
          }
          return;
          if (paramom.Gcu.size() <= 1)
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
          localObject1 = paramw.ftk().HTS.Gal;
          p.g(localObject1, "info.tlRecCardWrapper.extraInfo.BizInfo");
          localObject1 = ((Iterable)j.b((Iterable)localObject1, 2)).iterator();
          j = 0;
          i = 0;
          label280:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (j < 0) {
              j.gkd();
            }
            if (((om)localObject2).FNv != 0) {
              break label456;
            }
            i += 1;
          }
        }
      }
    }
    label412:
    label450:
    label456:
    for (;;)
    {
      j += 1;
      break label280;
      if (i < 2) {}
      for (i = k;; i = 0) {
        break;
      }
      i = 0;
      break label108;
      label358:
      j = 0;
      break label126;
      localObject1 = this.oio;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundResource(2131231262);
      }
      localObject1 = this.oio;
      if (localObject1 == null) {
        break label139;
      }
      localObject2 = this.oio;
      if (localObject2 != null)
      {
        i = ((View)localObject2).getPaddingLeft();
        localObject2 = this.oio;
        if (localObject2 == null) {
          break label450;
        }
      }
      for (j = ((View)localObject2).getPaddingRight();; j = 0)
      {
        ((View)localObject1).setPadding(i, 0, j, 0);
        break;
        i = 0;
        break label412;
      }
    }
  }
  
  public final void hide()
  {
    View localView = this.auu;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame, w paramw, ol paramol) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208663);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      localObject1 = this.oix;
      w localw = paramw;
      ol localol = paramol;
      p.h(localw, "info");
      if ((localol != null) && (localw.ftj() != null))
      {
        localObject2 = localw.ftj();
        if (localObject2 == null) {
          p.gkB();
        }
        if (((dml)localObject2).HTL != null) {}
      }
      else
      {
        ae.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208663);
        return;
      }
      Object localObject2 = localw.ftj();
      if (localObject2 == null) {
        p.gkB();
      }
      Object localObject3 = ((dml)localObject2).HTL;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 4L, 1L, false);
      ae.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localol.FYs });
      Intent localIntent = new Intent();
      localObject2 = m.d(localol.FYs, 169, 10000, 0);
      localIntent.putExtra("rawUrl", (String)localObject2);
      localIntent.putExtra("geta8key_scene", 56);
      localIntent.putExtra("geta8key_username", ((dmn)localObject3).nIJ);
      localIntent.putExtra("srcUsername", ((dmn)localObject3).nIJ);
      localIntent.putExtra("srcDisplayname", ((dmn)localObject3).nJO);
      localIntent.putExtra("prePublishId", "rec_card");
      localIntent.putExtra("KPublisherId", "rec_card");
      int i;
      int j;
      if (localol.hFR == 5)
      {
        Object localObject4 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
        p.g(localObject4, "MMKernel.service(IBrandService::class.java)");
        if (((com.tencent.mm.plugin.brandservice.a.b)localObject4).bOe())
        {
          localIntent.putExtra(e.b.JoV, 169);
          localIntent.putExtra(e.b.JoW, 10000);
          localIntent.putExtra("biz_video_session_id", y.getSessionId());
          localObject4 = new x();
          ((x)localObject4).hFX = localIntent.getStringExtra("KPublisherId");
          ((x)localObject4).dpP = ((dmn)localObject3).nIJ;
          ((x)localObject4).hFW = ((dmn)localObject3).nJO;
          ((x)localObject4).hFY.url = ((String)localObject2);
          ((x)localObject4).hFY.title = localol.Title;
          ((x)localObject4).hFY.hGg = localol.FYq;
          ((x)localObject4).hFY.hGe = localol.FYu;
          ((x)localObject4).hFY.type = localol.hFR;
          ((x)localObject4).hFY.time = localol.CreateTime;
          ((x)localObject4).hFY.hGi = localol.FYG;
          ((x)localObject4).hFY.videoWidth = localol.FYE;
          ((x)localObject4).hFY.videoHeight = localol.FYF;
          ((x)localObject4).hFY.hCa = localol.FYD;
          ((x)localObject4).t(localIntent);
          ae.i("MicroMsg.BizTimeLineItem", "jump to native video");
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
      if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((e)localObject1).context, (String)localObject2, localol.hFR, 169, 10000, localIntent))) {
        ae.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
      }
      for (;;)
      {
        paramView = localw.ftk();
        if (paramView != null)
        {
          j = 0;
          i = j;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject2);
          i = j;
          j = bu.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
          i = j;
          l = bu.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l = 0L;
          }
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.g.f(paramView);
        ((e)localObject1).ohs.ogr.a(localw.field_talker, l, i, 15, paramView.HDI, "", 0, paramView.HTS.Gau, paramView.dmp, paramView.HTS.Gaq, localol.Gcq, paramView.style, localol.Gcr);
        ((e)localObject1).ohs.b(localw, 0);
        break;
        com.tencent.mm.br.d.b(((e)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.e
 * JD-Core Version:    0.7.0.1
 */