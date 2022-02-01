package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "coverContainer", "Landroid/view/View;", "icon", "iconContainer", "playTimeTv", "Landroid/widget/TextView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshVideoIcon", "plugin-brandservice_release"})
public final class f
  extends e
{
  private ImageView ka;
  TextView ocK;
  private View ocL;
  private View ocM;
  private ImageView ocn;
  private final com.tencent.mm.ai.v ocq;
  
  public f(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(209695);
    this.ocq = new com.tencent.mm.ai.v();
    AppMethodBeat.o(209695);
  }
  
  private final void a(w paramw, ok paramok, final oj paramoj)
  {
    AppMethodBeat.i(209693);
    final y.a locala = new y.a();
    locala.MLQ = false;
    label106:
    Object localObject;
    int i;
    int j;
    boolean bool;
    switch (paramw.fpm().style)
    {
    default: 
      this.ocq.type = paramoj.hCZ;
      this.ocq.hDm = paramoj.FFY;
      this.ocq.hDD = paramoj.FFY;
      this.ocq.url = paramoj.FFW;
      paramok = this.ocL;
      if (paramok != null)
      {
        paramok = paramok.getLayoutParams();
        if (paramok != null) {
          paramok.height = b.oae;
        }
        localObject = this.ocL;
        if (localObject != null) {
          ((View)localObject).setLayoutParams(paramok);
        }
        i = a.ip(this.context);
        j = b.oah;
        this.obC.oas.a(paramw.field_msgId, 0, this.ocq, paramoj.FFY, this.ocn, i - j, b.oae, false, (m.a)new a(this, locala, paramoj), false, paramw.ofe);
        AppMethodBeat.o(209693);
        return;
      }
      break;
    case 101: 
      if (paramok.FJV.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        locala.MLQ = bool;
        break;
      }
    case 102: 
      paramok = paramw.fpm().HAf.FHP;
      p.g(paramok, "info.tlRecCardWrapper.extraInfo.BizInfo");
      paramok = (Iterable)j.b((Iterable)paramok, 2);
      j = 0;
      paramok = paramok.iterator();
      i = 0;
      label281:
      if (paramok.hasNext())
      {
        localObject = paramok.next();
        if (j < 0) {
          j.gfB();
        }
        if (((ok)localObject).FuX != 0) {
          break label362;
        }
        i += 1;
      }
      break;
    }
    label362:
    for (;;)
    {
      j += 1;
      break label281;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        locala.MLQ = bool;
        break;
      }
      paramok = null;
      break label106;
    }
  }
  
  private final void b(oj paramoj)
  {
    AppMethodBeat.i(209694);
    float f = 0.5F;
    Object localObject = this.ocA;
    int i;
    if ((localObject != null) && (((MMNeat7extView)localObject).getVisibility() == 0))
    {
      i = a.ip(this.context);
      int j = a.fromDPToPix(this.context, 48);
      localObject = this.ocA;
      if (localObject != null) {
        ((MMNeat7extView)localObject).measure(i - j, 0);
      }
      localObject = this.ocL;
      if (localObject == null) {
        p.gfZ();
      }
      i = ((View)localObject).getLayoutParams().height;
      localObject = this.ocA;
      if (localObject == null) {
        p.gfZ();
      }
      j = ((MMNeat7extView)localObject).getMeasuredHeight();
      int k = b.oan;
      f = 0.56F;
      i = i - j - k;
      if (this.ocM == null) {
        break label234;
      }
      localObject = this.ocM;
      if (localObject == null) {
        break label202;
      }
    }
    label202:
    for (localObject = ((View)localObject).getLayoutParams();; localObject = null)
    {
      if (localObject != null) {
        break label208;
      }
      paramoj = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(209694);
      throw paramoj;
      localObject = this.ocL;
      if (localObject == null) {
        p.gfZ();
      }
      i = ((View)localObject).getLayoutParams().height;
      break;
    }
    label208:
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f - a.fromDPToPix(this.context, 48) / 2));
    label234:
    paramoj = m.oi(paramoj.FGk);
    if (!TextUtils.isEmpty((CharSequence)paramoj))
    {
      localObject = this.ocK;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.ocK;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramoj);
      }
      paramoj = this.ocK;
      if (paramoj != null) {
        paramoj.setTextColor(this.context.getResources().getColor(2131100541));
      }
    }
    for (;;)
    {
      paramoj = this.ocK;
      if (paramoj == null) {
        break;
      }
      paramoj.setShadowLayer(10.0F, 0.0F, 0.0F, this.context.getResources().getColor(2131099662));
      AppMethodBeat.o(209694);
      return;
      paramoj = this.ocK;
      if (paramoj != null) {
        paramoj.setVisibility(8);
      }
    }
    AppMethodBeat.o(209694);
  }
  
  public final void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(209692);
    p.h(paramView, "parent");
    if (this.auu == null)
    {
      super.V(paramView, paramInt);
      Object localObject = this.auu;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131298813); localObject == null; localObject = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(209692);
        throw paramView;
      }
      this.ocn = ((ImageView)localObject);
      localObject = this.auu;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131306344); localObject == null; localObject = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(209692);
        throw paramView;
      }
      this.ka = ((ImageView)localObject);
      localObject = this.auu;
      if (localObject != null) {}
      for (localObject = (TextView)((View)localObject).findViewById(2131303288); localObject == null; localObject = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(209692);
        throw paramView;
      }
      this.ocK = ((TextView)localObject);
      localObject = this.auu;
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131298187);
        this.ocL = ((View)localObject);
        localObject = this.auu;
        if (localObject == null) {
          break label292;
        }
        localObject = ((View)localObject).findViewById(2131306345);
        label224:
        this.ocM = ((View)localObject);
        bOx();
        this.ocz = paramView.findViewById(2131298112);
        paramView = this.auu;
        if (paramView == null) {
          break label297;
        }
      }
      label292:
      label297:
      for (paramView = (MMNeat7extView)paramView.findViewById(2131305948);; paramView = null)
      {
        if (paramView != null) {
          break label302;
        }
        paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(209692);
        throw paramView;
        localObject = null;
        break;
        localObject = null;
        break label224;
      }
      label302:
      this.ocA = paramView;
      paramView = this.auu;
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(2131303387); paramView == null; paramView = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(209692);
        throw paramView;
      }
      this.ocB = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label467;
      }
      paramView = (LinearLayout)paramView.findViewById(2131297367);
      this.ocC = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label472;
      }
      paramView = (LinearLayout)paramView.findViewById(2131304832);
      label405:
      this.ocD = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label477;
      }
      paramView = (MMNeat7extView)paramView.findViewById(2131304829);
      label430:
      this.ocE = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label482;
      }
    }
    label467:
    label472:
    label477:
    label482:
    for (paramView = (MMNeat7extView)paramView.findViewById(2131304827);; paramView = null)
    {
      this.ocF = paramView;
      AppMethodBeat.o(209692);
      return;
      paramView = null;
      break;
      paramView = null;
      break label405;
      paramView = null;
      break label430;
    }
  }
  
  public final void a(View paramView, w paramw, ok paramok)
  {
    AppMethodBeat.i(209691);
    p.h(paramView, "parent");
    p.h(paramw, "info");
    p.h(paramok, "bizInfo");
    V(paramView, 2131306455);
    if (this.auu == null)
    {
      AppMethodBeat.o(209691);
      return;
    }
    paramView = this.auu;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (oj)paramok.FJV.get(0);
    p.g(paramView, "appMsg");
    b(paramw, paramok, paramView);
    b(paramView);
    a(paramw, paramok, paramView);
    c(paramw, paramok, paramView);
    AppMethodBeat.o(209691);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(y.a parama, oj paramoj) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(209690);
      Object localObject = this.ocN.ocH;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.ocN.context.getResources().getColor(2131099674));
      }
      localObject = this.ocN.ocB;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!locala.MLQ)
      {
        localObject = this.ocN.ocA;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.ocN.context.getResources().getColor(2131101182));
        }
      }
      this.ocN.a(paramoj);
      localObject = this.ocN.ocK;
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.ocN.context.getResources().getColor(2131101182));
        AppMethodBeat.o(209690);
        return;
      }
      AppMethodBeat.o(209690);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.f
 * JD-Core Version:    0.7.0.1
 */