package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.feed.jumper.r;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adContainer", "Landroid/view/View;", "adIcon", "Landroid/widget/ImageView;", "adMiniAppIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "adTextView", "Landroid/widget/TextView;", "hotSearchInfoDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "dismissDialog", "", "initDialog", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "jumpByJumpInfo", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "jumpByMiniProgram", "jumpToPage", "jumpToProfile", "username", "", "report21875", "eid", "action", "", "jumpInfoStr", "showDialog", "showJumpView", "showMiniProgram", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a FwE;
  private TextView AwD;
  private WeImageView AwE;
  com.google.android.material.bottomsheet.a FwF;
  private View FwG;
  private ImageView FwH;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(342804);
    FwE = new a((byte)0);
    AppMethodBeat.o(342804);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(342746);
    this.context = paramContext;
    AppMethodBeat.o(342746);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(342754);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.FwF = null;
    AppMethodBeat.o(342754);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(342798);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    Log.i("Finder.HotSearchInfoDialog", "dismissDialog");
    paramb = paramb.FwF;
    if (paramb != null) {
      paramb.dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342798);
  }
  
  private static final void a(b paramb, FinderContact paramFinderContact, View paramView)
  {
    AppMethodBeat.i(342770);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramFinderContact);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramFinderContact, "$it");
    paramView = paramFinderContact.username;
    paramFinderContact = paramView;
    if (paramView == null) {
      paramFinderContact = "";
    }
    paramView = new Intent();
    paramView.putExtra("finder_username", paramFinderContact);
    paramView.putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
    paramFinderContact = as.GSQ;
    as.a.a(paramb.context, paramView, 0L, 1, false, 64);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramb.context, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342770);
  }
  
  private static final void a(b paramb, awt paramawt, View paramView)
  {
    AppMethodBeat.i(342792);
    Object localObject1 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramawt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    label111:
    Object localObject4;
    long l;
    if (paramawt != null)
    {
      localObject1 = paramawt.hVf;
      if (localObject1 != null) {
        break label437;
      }
      paramView = null;
      if ((paramView == null) && (paramawt != null))
      {
        localObject3 = new StringBuilder();
        paramView = paramawt.contact;
        if (paramView != null) {
          break label621;
        }
        paramView = "";
        localObject3 = paramView + ':' + Util.getUuidRandom();
        localObject4 = com.tencent.mm.plugin.finder.utils.a.GfO;
        Context localContext = paramb.context;
        localObject1 = paramawt.WDP;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        localObject1 = paramawt.ZHI;
        paramawt = (awt)localObject1;
        if (localObject1 == null) {
          paramawt = "";
        }
        ((com.tencent.mm.plugin.finder.utils.a)localObject4).a(localContext, paramView, paramawt, 1191, (String)localObject3);
        kotlin.g.b.s.u("link_miniprogram", "eid");
        kotlin.g.b.s.u("", "jumpInfoStr");
        paramawt = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        paramView = com.tencent.mm.ui.component.k.aeZF;
        paramb = ((as)com.tencent.mm.ui.component.k.nq(paramb.context).q(as.class)).zIO;
        l = cn.bDu();
        paramView = new JSONObject();
      }
    }
    label437:
    label621:
    do
    {
      for (;;)
      {
        try
        {
          int i = "link_miniprogram".hashCode();
          switch (i)
          {
          }
        }
        finally
        {
          continue;
        }
        Log.i("Finder.HotSearchInfoDialog", "report21875 sessionId:" + paramawt + " contextId:" + paramb + " commentScene:59 action:1" + " eid:" + "link_miniprogram" + " udf_kv:" + paramView);
        com.tencent.mm.plugin.report.service.h.OAn.b(21875, new Object[] { paramawt, paramb, Integer.valueOf(59), Integer.valueOf(1), String.valueOf(l), "link_miniprogram", paramView.toString() });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(342792);
        return;
        switch (((FinderJumpInfo)localObject1).jumpinfo_type)
        {
        default: 
          paramView = (View)localObject1;
          break;
        case 1: 
          localObject4 = new StringBuilder();
          if (paramawt == null)
          {
            paramView = "";
            paramView = paramView + ':' + Util.getUuidRandom();
            localObject3 = as.GSQ;
            localObject3 = as.a.hu(paramb.context);
            if (localObject3 != null) {
              ((as)localObject3).fou();
            }
            localObject3 = r.Bej;
            r.a(paramb.context, (FinderJumpInfo)localObject1, null, 1191, paramView, null, 36);
            paramView = (View)localObject1;
            break;
          }
          paramView = paramawt.contact;
          if (paramView == null)
          {
            paramView = "";
          }
          else
          {
            localObject3 = paramView.username;
            paramView = (View)localObject3;
            if (localObject3 == null) {
              paramView = "";
            }
          }
          break;
        case 2: 
          paramView = r.Bej;
          r.a(paramb.context, new com.tencent.mm.plugin.finder.feed.jumper.k((FinderJumpInfo)localObject1));
          paramView = (View)localObject1;
          break;
          localObject1 = paramView.username;
          paramView = (View)localObject1;
          if (localObject1 != null) {
            break label111;
          }
          paramView = "";
          break label111;
          if ("link_miniprogram".equals("feed_jumpicon"))
          {
            paramView.put("scene", 3);
            paramView.put("type", 0);
          }
          break;
        }
      }
    } while (!"link_miniprogram".equals("link_h5"));
    for (;;)
    {
      paramView.put("TopicId", "");
      paramView.put("TopicName", "");
      break;
      boolean bool = "link_miniprogram".equals("link_miniprogram");
      if (!bool) {
        break;
      }
    }
  }
  
  final void a(awt paramawt)
  {
    Object localObject4 = null;
    AppMethodBeat.i(342838);
    Object localObject5 = af.mU(this.context).inflate(e.f.finder_hot_search_info_dailog_layout, null);
    this.FwF = new com.google.android.material.bottomsheet.a(this.context, e.i.BottomSheetDialog);
    Object localObject1 = this.FwF;
    if (localObject1 != null) {
      ((com.google.android.material.bottomsheet.a)localObject1).setContentView((View)localObject5);
    }
    localObject1 = this.FwF;
    if (localObject1 != null)
    {
      localObject1 = ((com.google.android.material.bottomsheet.a)localObject1).getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).setDimAmount(0.5F);
      }
    }
    localObject1 = this.FwF;
    if (localObject1 != null) {
      ((com.google.android.material.bottomsheet.a)localObject1).setOnDismissListener(new b..ExternalSyntheticLambda0(this));
    }
    Object localObject3;
    Object localObject2;
    label119:
    Object localObject6;
    if (localObject5 == null)
    {
      localObject3 = null;
      if (localObject5 != null) {
        break label582;
      }
      localObject2 = null;
      if (localObject3 != null)
      {
        aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
        if (paramawt != null) {
          break label597;
        }
        localObject1 = (CharSequence)"";
        label148:
        ((TextView)localObject3).setText((CharSequence)localObject1);
      }
      if (localObject2 != null)
      {
        if (paramawt != null) {
          break label623;
        }
        localObject1 = (CharSequence)"";
        label168:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject6 = ((View)localObject5).findViewById(e.e.hot_search_header_note);
      localObject1 = (ImageView)((View)localObject5).findViewById(e.e.hot_search_header_note_avatar);
      Object localObject7 = (TextView)((View)localObject5).findViewById(e.e.hot_search_header_note_text);
      localObject2 = ((View)localObject5).findViewById(e.e.finder_hot_search_dialog_close_1);
      if (paramawt != null)
      {
        localObject3 = paramawt.ZHP;
        if (localObject3 != null)
        {
          localObject3 = ((aws)localObject3).contact;
          if (localObject3 != null)
          {
            if (localObject6 != null) {
              ((View)localObject6).setVisibility(0);
            }
            ((TextView)localObject7).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)((FinderContact)localObject3).nickname));
            localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
            localObject6 = com.tencent.mm.plugin.finder.loader.p.eCp();
            localObject7 = new com.tencent.mm.plugin.finder.loader.b(((FinderContact)localObject3).headUrl);
            kotlin.g.b.s.s(localObject1, "dialogNoteAvatar");
            com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
            ((com.tencent.mm.loader.d)localObject6).a(localObject7, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
            ((ImageView)localObject1).setOnClickListener(new b..ExternalSyntheticLambda2(this, (FinderContact)localObject3));
          }
        }
      }
      if (localObject5 != null) {
        break label649;
      }
      localObject1 = null;
      label349:
      this.AwE = ((WeImageView)localObject1);
      if (localObject5 != null) {
        break label664;
      }
      localObject1 = null;
      label361:
      this.FwG = ((View)localObject1);
      if (localObject5 != null) {
        break label676;
      }
      localObject1 = null;
      label373:
      this.FwH = ((ImageView)localObject1);
      if (localObject5 != null) {
        break label691;
      }
      localObject1 = null;
      label385:
      this.AwD = ((TextView)localObject1);
      localObject1 = this.FwG;
      if (localObject1 != null) {
        ((View)localObject1).setBackground(this.context.getResources().getDrawable(e.d.finder_profile_normal_mini_program_bg));
      }
      if (paramawt != null)
      {
        localObject1 = paramawt.hVf;
        if (localObject1 != null) {
          break label706;
        }
        localObject1 = localObject4;
        if (localObject1 == null)
        {
          Log.i("Finder.HotSearchInfoDialog", "showJumpView by MiniProgram");
          if (paramawt != null)
          {
            if (Util.isNullOrNil(paramawt.WDP)) {
              break label889;
            }
            localObject1 = this.FwG;
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
            localObject1 = this.AwD;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)paramawt.ZHJ);
            }
            localObject1 = this.AwE;
            if (localObject1 != null) {
              ((WeImageView)localObject1).setVisibility(0);
            }
            localObject1 = this.FwH;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.FwG;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new b..ExternalSyntheticLambda3(this, paramawt));
      }
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener(new b..ExternalSyntheticLambda1(this));
      }
      AppMethodBeat.o(342838);
      return;
      localObject3 = (TextView)((View)localObject5).findViewById(e.e.finder_hot_search_dialog_title);
      break;
      label582:
      localObject2 = (TextView)((View)localObject5).findViewById(e.e.finder_hot_search_dialog_content);
      break label119;
      label597:
      localObject1 = paramawt.eventName;
      if (localObject1 == null)
      {
        localObject1 = (CharSequence)"";
        break label148;
      }
      localObject1 = (CharSequence)localObject1;
      break label148;
      label623:
      localObject1 = paramawt.description;
      if (localObject1 == null)
      {
        localObject1 = (CharSequence)"";
        break label168;
      }
      localObject1 = (CharSequence)localObject1;
      break label168;
      label649:
      localObject1 = (WeImageView)((View)localObject5).findViewById(e.e.hot_search_mini_app_icon);
      break label349;
      label664:
      localObject1 = ((View)localObject5).findViewById(e.e.hot_search_ad_container);
      break label361;
      label676:
      localObject1 = (ImageView)((View)localObject5).findViewById(e.e.hot_search_icon);
      break label373;
      label691:
      localObject1 = (TextView)((View)localObject5).findViewById(e.e.hot_search_ad_text);
      break label385;
      label706:
      Log.i("Finder.HotSearchInfoDialog", "showJumpView by jumpInfo");
      if (!Util.isNullOrNil(((FinderJumpInfo)localObject1).wording))
      {
        localObject3 = this.FwG;
        if (localObject3 != null) {
          ((View)localObject3).setVisibility(0);
        }
        localObject3 = this.AwD;
        if (localObject3 != null) {
          ((TextView)localObject3).setText((CharSequence)((FinderJumpInfo)localObject1).wording);
        }
        localObject3 = this.AwE;
        if (localObject3 != null) {
          ((WeImageView)localObject3).setVisibility(8);
        }
        localObject3 = this.FwH;
        if (localObject3 != null) {
          ((ImageView)localObject3).setVisibility(0);
        }
        localObject3 = this.FwH;
        if (localObject3 != null)
        {
          ((ImageView)localObject3).setVisibility(0);
          localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject4 = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject5 = new com.tencent.mm.plugin.finder.loader.s(((FinderJumpInfo)localObject1).icon_url, v.FKZ);
          localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject4).a(localObject5, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExR)).d((ImageView)localObject3);
        }
      }
      for (;;)
      {
        break;
        localObject3 = this.FwG;
        if (localObject3 != null) {
          ((View)localObject3).setVisibility(8);
        }
      }
      label889:
      localObject1 = this.FwG;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.b
 * JD-Core Version:    0.7.0.1
 */