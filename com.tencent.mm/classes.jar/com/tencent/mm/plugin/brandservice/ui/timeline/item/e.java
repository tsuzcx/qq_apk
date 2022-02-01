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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.x;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "friendReadTv", "Landroid/widget/TextView;", "getFriendReadTv", "()Landroid/widget/TextView;", "setFriendReadTv", "(Landroid/widget/TextView;)V", "itemView", "getItemView", "setItemView", "pressMask", "Landroid/widget/ImageView;", "getPressMask", "()Landroid/widget/ImageView;", "setPressMask", "(Landroid/widget/ImageView;)V", "singleDigest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getSingleDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setSingleDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "singleTitle", "getSingleTitle", "setSingleTitle", "singleTitleLayout", "Landroid/widget/LinearLayout;", "getSingleTitleLayout", "()Landroid/widget/LinearLayout;", "setSingleTitleLayout", "(Landroid/widget/LinearLayout;)V", "statLayout", "getStatLayout", "setStatLayout", "title", "getTitle", "setTitle", "titleLayout", "getTitleLayout", "setTitleLayout", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "hide", "inflate", "id", "", "inflateStatLayout", "needRoundBottom", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "onAppMsgClick", "convertView", "order", "refreshClickView", "refreshFriendInfo", "refreshTitle", "plugin-brandservice_release"})
public abstract class e
{
  View auu;
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b obC;
  MMNeat7extView ocA;
  ImageView ocB;
  LinearLayout ocC;
  LinearLayout ocD;
  MMNeat7extView ocE;
  MMNeat7extView ocF;
  private View ocG;
  TextView ocH;
  View ocz;
  
  public e(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.obC = paramb;
  }
  
  private static boolean a(ok paramok, oj paramoj)
  {
    p.h(paramok, "bizInfo");
    p.h(paramoj, "appMsg");
    int i = paramok.FJV.size();
    if (i > 1) {}
    while ((i != 1) || (bt.isNullOrNil(paramoj.FFU))) {
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
  
  public final void a(oj paramoj)
  {
    p.h(paramoj, "appMsg");
    if (!bt.isNullOrNil(paramoj.uhr))
    {
      Object localObject = this.ocG;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.ocC;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(2131231282);
      }
      localObject = this.ocH;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramoj.uhr);
      }
    }
    do
    {
      return;
      paramoj = this.ocG;
    } while (paramoj == null);
    paramoj.setVisibility(8);
  }
  
  public final void b(w paramw, ok paramok, oj paramoj)
  {
    int k = 1;
    p.h(paramw, "info");
    p.h(paramok, "bizInfo");
    p.h(paramoj, "appMsg");
    switch (paramw.fpm().style)
    {
    default: 
      i = 0;
    case 101: 
      for (;;)
      {
        paramw = this.ocA;
        if (paramw != null) {
          paramw.setTextColor(this.context.getResources().getColor(2131100541));
        }
        paramw = this.ocC;
        if (paramw != null) {
          paramw.setBackgroundResource(2131233299);
        }
        paramw = this.ocH;
        if (paramw != null) {
          paramw.setTextColor(this.context.getResources().getColor(2131100541));
        }
        if (i == 0) {
          break label438;
        }
        paramw = this.ocD;
        if (paramw != null) {
          paramw.setVisibility(0);
        }
        paramw = this.ocA;
        if (paramw != null) {
          paramw.setVisibility(8);
        }
        paramw = this.ocE;
        if (paramw != null)
        {
          paramw.setMaxLines(2);
          paramw.ar((CharSequence)paramoj.Title);
        }
        if (bt.isNullOrNil(paramoj.FFU)) {
          break label422;
        }
        i = com.tencent.mm.cc.a.ip(this.context);
        j = com.tencent.mm.cc.a.fromDPToPix(this.context, 48);
        paramok = this.ocF;
        if (paramok != null)
        {
          paramok.ar((CharSequence)paramoj.FFU);
          paramok.setVisibility(0);
          paramw = this.ocE;
          if (paramw == null) {
            break;
          }
          paramw = paramw.kK(i - j, 2147483647);
          label255:
          if ((paramw == null) || (paramw.fSB() < 2)) {
            break label416;
          }
          i = k;
          label273:
          paramok.setMaxLines(i);
        }
        label279:
        return;
        if (paramok.FJV.size() <= 1) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    paramw = paramw.fpm().HAf.FHP;
    p.g(paramw, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramw = ((Iterable)j.b((Iterable)paramw, 2)).iterator();
    int j = 0;
    int i = 0;
    label344:
    if (paramw.hasNext())
    {
      paramok = paramw.next();
      if (j < 0) {
        j.gfB();
      }
      if (((ok)paramok).FuX != 0) {
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
      paramw = this.ocF;
      if (paramw == null) {
        break label279;
      }
      paramw.setVisibility(8);
      return;
      paramw = this.ocD;
      if (paramw != null) {
        paramw.setVisibility(8);
      }
      paramw = this.ocA;
      if (paramw != null) {
        paramw.setVisibility(0);
      }
      paramw = this.ocA;
      if (paramw != null) {
        paramw.ar((CharSequence)paramoj.Title);
      }
      paramw = com.tencent.mm.plugin.brandservice.ui.b.d.osr;
      com.tencent.mm.plugin.brandservice.ui.b.d.a(this.ocA);
      return;
    }
  }
  
  public final void bOx()
  {
    if (this.auu == null) {
      return;
    }
    Object localObject = this.auu;
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131305184);
      this.ocG = ((View)localObject);
      localObject = this.auu;
      if (localObject == null) {
        break label61;
      }
    }
    label61:
    for (localObject = (TextView)((View)localObject).findViewById(2131300305);; localObject = null)
    {
      this.ocH = ((TextView)localObject);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void c(final w paramw, ok paramok, final oj paramoj)
  {
    int k = 1;
    p.h(paramw, "info");
    p.h(paramok, "bizInfo");
    p.h(paramoj, "appMsg");
    int i;
    switch (paramw.fpm().style)
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
        localObject1 = this.ocz;
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundResource(2131231256);
        }
        localObject1 = this.ocz;
        if (localObject1 != null)
        {
          localObject2 = this.ocz;
          if (localObject2 != null)
          {
            i = ((View)localObject2).getPaddingLeft();
            localObject2 = this.ocz;
            if (localObject2 == null) {
              break label358;
            }
            j = ((View)localObject2).getPaddingRight();
            label126:
            ((View)localObject1).setPadding(i, 0, j, com.tencent.mm.plugin.brandservice.ui.timeline.b.oag);
          }
        }
        else
        {
          label139:
          localObject1 = this.ocB;
          if (localObject1 != null) {
            ((ImageView)localObject1).setBackgroundResource(2131231253);
          }
          localObject1 = this.ocz;
          if (localObject1 != null) {
            ((View)localObject1).setOnClickListener((View.OnClickListener)new a(this, paramw, paramoj));
          }
          if (a(paramok, paramoj))
          {
            paramw = this.ocB;
            if (paramw != null) {
              paramw.setBackgroundResource(2131231251);
            }
          }
          return;
          if (paramok.FJV.size() <= 1)
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
          localObject1 = paramw.fpm().HAf.FHP;
          p.g(localObject1, "info.tlRecCardWrapper.extraInfo.BizInfo");
          localObject1 = ((Iterable)j.b((Iterable)localObject1, 2)).iterator();
          j = 0;
          i = 0;
          label280:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (j < 0) {
              j.gfB();
            }
            if (((ok)localObject2).FuX != 0) {
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
      localObject1 = this.ocz;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundResource(2131231262);
      }
      localObject1 = this.ocz;
      if (localObject1 == null) {
        break label139;
      }
      localObject2 = this.ocz;
      if (localObject2 != null)
      {
        i = ((View)localObject2).getPaddingLeft();
        localObject2 = this.ocz;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame, w paramw, oj paramoj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(209689);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      localObject1 = this.ocI;
      w localw = paramw;
      oj localoj = paramoj;
      p.h(localw, "info");
      if ((localoj != null) && (localw.fpl() != null))
      {
        localObject2 = localw.fpl();
        if (localObject2 == null) {
          p.gfZ();
        }
        if (((dlo)localObject2).HzY != null) {}
      }
      else
      {
        ad.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209689);
        return;
      }
      Object localObject2 = localw.fpl();
      if (localObject2 == null) {
        p.gfZ();
      }
      Object localObject3 = ((dlo)localObject2).HzY;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 4L, 1L, false);
      ad.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localoj.FFW });
      Intent localIntent = new Intent();
      localObject2 = m.d(localoj.FFW, 169, 10000, 0);
      localIntent.putExtra("rawUrl", (String)localObject2);
      localIntent.putExtra("geta8key_scene", 56);
      localIntent.putExtra("geta8key_username", ((dlq)localObject3).nDo);
      localIntent.putExtra("srcUsername", ((dlq)localObject3).nDo);
      localIntent.putExtra("srcDisplayname", ((dlq)localObject3).nEt);
      localIntent.putExtra("prePublishId", "rec_card");
      localIntent.putExtra("KPublisherId", "rec_card");
      int i;
      int j;
      if (localoj.hCZ == 5)
      {
        Object localObject4 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
        p.g(localObject4, "MMKernel.service(IBrandService::class.java)");
        if (((com.tencent.mm.plugin.brandservice.a.b)localObject4).bNg())
        {
          localIntent.putExtra(e.b.IUn, 169);
          localIntent.putExtra(e.b.IUo, 10000);
          localIntent.putExtra("biz_video_session_id", y.getSessionId());
          localObject4 = new x();
          ((x)localObject4).hDf = localIntent.getStringExtra("KPublisherId");
          ((x)localObject4).doK = ((dlq)localObject3).nDo;
          ((x)localObject4).hDe = ((dlq)localObject3).nEt;
          ((x)localObject4).hDg.url = ((String)localObject2);
          ((x)localObject4).hDg.title = localoj.Title;
          ((x)localObject4).hDg.hDo = localoj.FFU;
          ((x)localObject4).hDg.hDm = localoj.FFY;
          ((x)localObject4).hDg.type = localoj.hCZ;
          ((x)localObject4).hDg.time = localoj.CreateTime;
          ((x)localObject4).hDg.hDq = localoj.FGk;
          ((x)localObject4).hDg.videoWidth = localoj.FGi;
          ((x)localObject4).hDg.videoHeight = localoj.FGj;
          ((x)localObject4).hDg.hzm = localoj.FGh;
          ((x)localObject4).t(localIntent);
          ad.i("MicroMsg.BizTimeLineItem", "jump to native video");
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
      if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((e)localObject1).context, (String)localObject2, localoj.hCZ, 169, 10000, localIntent))) {
        ad.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
      }
      for (;;)
      {
        paramView = localw.fpm();
        if (paramView != null)
        {
          j = 0;
          i = j;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject2);
          i = j;
          j = bt.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
          i = j;
          l = bt.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l = 0L;
          }
        }
        ((e)localObject1).obC.oaB.a(localw.field_talker, l, i, 15, paramView.Hki, "", 0, paramView.HAf.FHY, paramView.dln, paramView.HAf.FHU, localoj.FJR, paramView.style, localoj.FJS);
        ((e)localObject1).obC.b(localw, 0);
        break;
        com.tencent.mm.bs.d.b(((e)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.e
 * JD-Core Version:    0.7.0.1
 */