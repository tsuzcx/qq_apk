package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.dh;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activityAvatarIcon", "", "activityCreateSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "activityCreatorNickName", "activityDesc", "activityDescSheet", "activityEndTime", "", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "setActivityEvent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "activityFromType", "activityItemLayout", "Landroid/widget/RelativeLayout;", "activityName", "activityNickName", "activityPostSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "activityTopicId", "getActivityTopicId", "()J", "setActivityTopicId", "(J)V", "activityType", "activityWordingInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventWordingInfo;", "getActivityWordingInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderEventWordingInfo;", "setActivityWordingInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderEventWordingInfo;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "coverUrl", "descTextView", "Landroid/widget/TextView;", "displayMask", "getDisplayMask", "setDisplayMask", "endTimeToString", "iconImageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isEnablePost", "", "localCoverUrl", "onClickListener", "Landroid/view/View$OnClickListener;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "titleTextView", "confirmActivityType", "intent", "Landroid/content/Intent;", "srcActivityType", "deleteActivity", "", "doCheckScene", "jumpToActivityDesc", "jumpToPost", "jumpToSelectActivity", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "setEnable", "isEnable", "setIntentParam", "setText", "title", "desc", "nickName", "showCreateActivitySheet", "showDescActivitySheet", "showPostActivitySheet", "update", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderExtendActivityView
  extends FrameLayout
  implements com.tencent.mm.am.h
{
  public static final a GxX;
  private static final int Gyh;
  private static final int Gyi;
  private static final int Gyj;
  private static final int Gyk;
  private static final int Gyl;
  private static final int Gym;
  private String AtM;
  private String Ava;
  private String Avx;
  private int Avy;
  private long FOe;
  private String FOf;
  private long FOi;
  private brg Gcw;
  private RelativeLayout GxY;
  private WeImageView GxZ;
  private d Gya;
  private String Gyb;
  private String Gyc;
  private awx Gyd;
  private String Gye;
  private boolean Gyf;
  private String Gyg;
  private m contact;
  private String coverUrl;
  private final View.OnClickListener dpY;
  private long hyN;
  private TextView lzN;
  private TextView uck;
  
  static
  {
    AppMethodBeat.i(345905);
    GxX = new a((byte)0);
    Gyh = 3001;
    Gyi = 3002;
    Gyj = 4001;
    Gyk = 4002;
    Gyl = 5001;
    Gym = 5002;
    AppMethodBeat.o(345905);
  }
  
  public FinderExtendActivityView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345701);
    this.Gcw = new brg();
    this.Avy = 100;
    this.Avx = "";
    this.coverUrl = "";
    this.AtM = "";
    this.Gyb = "";
    this.Gyc = "";
    this.Ava = "";
    this.Gye = "";
    this.FOf = "";
    this.Gyf = true;
    this.Gyg = "";
    this.dpY = new FinderExtendActivityView..ExternalSyntheticLambda0(this);
    paramContext = af.mU(getContext()).inflate(e.f.finder_post_activity_item_view, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(e.e.post_activity_item_title);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.post_activity_item_title)");
    this.lzN = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(e.e.post_activity_item_desc);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.post_activity_item_desc)");
    this.uck = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(e.e.fidner_post_activity_item_layout);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.f…ost_activity_item_layout)");
    this.GxY = ((RelativeLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(e.e.activity_flag_icon);
    kotlin.g.b.s.s(paramContext, "view.findViewById(R.id.activity_flag_icon)");
    this.GxZ = ((WeImageView)paramContext);
    setOnClickListener(this.dpY);
    AppMethodBeat.o(345701);
  }
  
  public FinderExtendActivityView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345713);
    this.Gcw = new brg();
    this.Avy = 100;
    this.Avx = "";
    this.coverUrl = "";
    this.AtM = "";
    this.Gyb = "";
    this.Gyc = "";
    this.Ava = "";
    this.Gye = "";
    this.FOf = "";
    this.Gyf = true;
    this.Gyg = "";
    this.dpY = new FinderExtendActivityView..ExternalSyntheticLambda0(this);
    paramContext = af.mU(getContext()).inflate(e.f.finder_post_activity_item_view, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(e.e.post_activity_item_title);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.post_activity_item_title)");
    this.lzN = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(e.e.post_activity_item_desc);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.post_activity_item_desc)");
    this.uck = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(e.e.fidner_post_activity_item_layout);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.f…ost_activity_item_layout)");
    this.GxY = ((RelativeLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(e.e.activity_flag_icon);
    kotlin.g.b.s.s(paramContext, "view.findViewById(R.id.activity_flag_icon)");
    this.GxZ = ((WeImageView)paramContext);
    setOnClickListener(this.dpY);
    AppMethodBeat.o(345713);
  }
  
  private static final void a(FinderExtendActivityView paramFinderExtendActivityView)
  {
    AppMethodBeat.i(345890);
    kotlin.g.b.s.u(paramFinderExtendActivityView, "this$0");
    paramFinderExtendActivityView.Gya = null;
    AppMethodBeat.o(345890);
  }
  
  private static final void a(FinderExtendActivityView paramFinderExtendActivityView, View paramView)
  {
    AppMethodBeat.i(345827);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramFinderExtendActivityView);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderExtendActivityView, "this$0");
    paramView = y.FrY;
    paramView = z.bAW();
    kotlin.g.b.s.s(paramView, "getMyFinderUsername()");
    y.c("1", paramView, null);
    switch (paramFinderExtendActivityView.Avy)
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345827);
      return;
      paramView = new Intent();
      paramFinderExtendActivityView.setIntentParam(paramView);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderExtendActivityView = paramFinderExtendActivityView.getContext();
      if (paramFinderExtendActivityView == null)
      {
        paramFinderExtendActivityView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(345827);
        throw paramFinderExtendActivityView;
      }
      com.tencent.mm.plugin.finder.utils.a.e((MMActivity)paramFinderExtendActivityView, paramView);
      continue;
      if (paramFinderExtendActivityView.Gya == null)
      {
        paramView = new d(paramFinderExtendActivityView.getContext());
        paramView.UD(e.f.finder_activity_cant_post_view);
        localObject1 = (RelativeLayout)paramView.rootView.findViewById(e.e.finder_activity_post);
        if (paramFinderExtendActivityView.Gyf)
        {
          localObject2 = (TextView)paramView.rootView.findViewById(e.e.activity_cant_post_title);
          TextView localTextView = (TextView)paramView.rootView.findViewById(e.e.activity_cant_post_desc);
          Object localObject3 = ((TextView)localObject2).getLayoutParams();
          if (localObject3 == null)
          {
            paramFinderExtendActivityView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(345827);
            throw paramFinderExtendActivityView;
          }
          localObject3 = (RelativeLayout.LayoutParams)localObject3;
          ((RelativeLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.fromDPToPix(paramFinderExtendActivityView.getContext(), 4);
          ((RelativeLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(paramFinderExtendActivityView.getContext(), 4);
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((TextView)localObject2).setTextColor(paramFinderExtendActivityView.getResources().getColor(e.b.FG_0));
          ((TextView)localObject2).setAlpha(1.0F);
          localTextView.setVisibility(8);
          ((RelativeLayout)localObject1).setBackground(paramFinderExtendActivityView.getContext().getResources().getDrawable(e.d.finder_activity_selector_click_bg));
        }
        paramView.rootView.findViewById(e.e.finder_activity_post).setOnClickListener(new FinderExtendActivityView..ExternalSyntheticLambda1(paramFinderExtendActivityView, paramView));
        paramView.rootView.findViewById(e.e.finder_activity_post_participate_btn).setOnClickListener(new FinderExtendActivityView..ExternalSyntheticLambda2(paramFinderExtendActivityView, paramView));
        paramView.rootView.findViewById(e.e.finder_activity_post_cancel_btn).setOnClickListener(new FinderExtendActivityView..ExternalSyntheticLambda3(paramView));
        paramView.GwT = new FinderExtendActivityView..ExternalSyntheticLambda4(paramFinderExtendActivityView);
        localObject1 = kotlin.ah.aiuX;
        paramFinderExtendActivityView.Gya = paramView;
      }
      paramFinderExtendActivityView = paramFinderExtendActivityView.Gya;
      if ((paramFinderExtendActivityView != null) && (!paramFinderExtendActivityView.isShowing())) {
        paramFinderExtendActivityView.dDn();
      }
    }
  }
  
  private static final void a(FinderExtendActivityView paramFinderExtendActivityView, d paramd, View paramView)
  {
    AppMethodBeat.i(345848);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderExtendActivityView);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderExtendActivityView, "this$0");
    kotlin.g.b.s.u(paramd, "$this_apply");
    if (paramFinderExtendActivityView.Gyf)
    {
      paramView = new Intent();
      paramFinderExtendActivityView.setIntentParam(paramView);
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderExtendActivityView = paramFinderExtendActivityView.getContext();
      if (paramFinderExtendActivityView == null)
      {
        paramFinderExtendActivityView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(345848);
        throw paramFinderExtendActivityView;
      }
      com.tencent.mm.plugin.finder.utils.a.d((MMActivity)paramFinderExtendActivityView, paramView);
      paramd.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345848);
  }
  
  private static final void b(FinderExtendActivityView paramFinderExtendActivityView, d paramd, View paramView)
  {
    AppMethodBeat.i(345864);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderExtendActivityView);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderExtendActivityView, "this$0");
    kotlin.g.b.s.u(paramd, "$this_apply");
    paramView = y.FrY;
    paramView = z.bAW();
    kotlin.g.b.s.s(paramView, "getMyFinderUsername()");
    y.c("2", paramView, null);
    paramView = new Intent();
    paramFinderExtendActivityView.setIntentParam(paramView);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramFinderExtendActivityView = paramFinderExtendActivityView.getContext();
    if (paramFinderExtendActivityView == null)
    {
      paramFinderExtendActivityView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(345864);
      throw paramFinderExtendActivityView;
    }
    com.tencent.mm.plugin.finder.utils.a.f((MMActivity)paramFinderExtendActivityView, paramView);
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345864);
  }
  
  private static boolean c(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(345726);
    if (((paramIntent.hasExtra("key_topic_id")) && ((paramInt == 101) || (paramInt == 102))) || (paramInt == 100))
    {
      AppMethodBeat.o(345726);
      return true;
    }
    AppMethodBeat.o(345726);
    return false;
  }
  
  private final void d(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(345741);
    Object localObject3;
    Object localObject1;
    if (paramIntent != null)
    {
      this.FOf = paramIntent.getStringExtra("key_nick_name");
      this.AtM = paramIntent.getStringExtra("key_activity_name");
      this.Ava = paramIntent.getStringExtra("key_activity_desc");
      setDisplayMask(paramIntent.getLongExtra("key_activity_display_mask", 0L));
      this.Gyb = paramIntent.getStringExtra("key_nick_name");
      localObject3 = paramIntent.getByteArrayExtra("key_wording_info");
      if (localObject3 != null) {
        localObject1 = (com.tencent.mm.bx.a)new awx();
      }
    }
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      setActivityWordingInfo((awx)localObject1);
      this.Gyc = paramIntent.getStringExtra("key_avatar_url");
      setActivityTopicId(paramIntent.getLongExtra("key_topic_id", 0L));
      this.FOe = paramIntent.getLongExtra("key_activity_end_time", 0L);
      localObject3 = paramIntent.getStringExtra("key_activity_src_type");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      this.Gyg = ((String)localObject1);
      localObject1 = av.GiL;
      long l = this.FOe;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      this.Gye = av.b(l * 1000L, (Context)localObject1);
      if (this.FOe != 0L)
      {
        i(this.AtM, this.Gye, this.FOf, paramInt);
        if (paramInt != 100)
        {
          if (paramInt != 102) {
            break label353;
          }
          i = 1;
          localObject1 = v.FrN;
          v.eG(com.tencent.mm.ae.d.hF(getActivityTopicId()), i);
        }
        switch (paramInt)
        {
        default: 
          this.Avx = "";
          this.coverUrl = "";
          AppMethodBeat.o(345741);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        i(this.AtM, null, this.FOf, paramInt);
        continue;
        label353:
        int i = 2;
      }
      this.Avx = paramIntent.getStringExtra("key_activity_local_cover_url");
      this.coverUrl = paramIntent.getStringExtra("key_cover_url");
      AppMethodBeat.o(345741);
      return;
    }
    this.coverUrl = paramIntent.getStringExtra("key_cover_url");
    AppMethodBeat.o(345741);
  }
  
  private final void fkw()
  {
    AppMethodBeat.i(345721);
    m localm = this.contact;
    if ((localm != null) && (this.Avy == 100))
    {
      com.tencent.mm.kernel.h.aZW().a(4050, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a((p)new dh(localm.getUsername(), null, null, null, 0L, 1, 30), 0);
    }
    AppMethodBeat.o(345721);
  }
  
  private final void i(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(345765);
    label12:
    int i;
    if (paramString2 == null)
    {
      paramString2 = null;
      if (paramString2 == null)
      {
        paramString2 = (CharSequence)paramString1;
        if ((paramString2 != null) && (paramString2.length() != 0)) {
          break label260;
        }
        i = 1;
        label37:
        if (i == 0)
        {
          paramString2 = (CharSequence)paramString3;
          if ((paramString2 != null) && (paramString2.length() != 0)) {
            break label266;
          }
          i = 1;
          label63:
          if (i == 0) {
            break label272;
          }
        }
        this.uck.setVisibility(0);
        this.uck.setText(e.h.finder_activity_default_desc);
      }
    }
    for (;;)
    {
      paramString2 = this.lzN;
      switch (paramInt)
      {
      default: 
        paramString2.setText(paramString2.getResources().getText(e.h.finder_activity_title));
        paramString2.setTextColor(paramString2.getResources().getColor(e.b.normal_text_color));
        paramString1 = this.GxZ;
        switch (paramInt)
        {
        default: 
          paramString1.setIconColor(paramString1.getResources().getColor(e.b.FG_0));
          paramString1.setImageResource(e.g.finder_outlined_activity);
          AppMethodBeat.o(345765);
          return;
          if (this.FOe != 4294967295L)
          {
            localObject = av.GiL;
            if (av.qJ(getDisplayMask())) {}
          }
          else
          {
            this.uck.setVisibility(8);
            break label12;
          }
          this.uck.setVisibility(0);
          this.uck.setText((CharSequence)paramString2);
          break label12;
          label260:
          i = 0;
          break label37;
          label266:
          i = 0;
          break label63;
          label272:
          this.uck.setVisibility(8);
        }
        break;
      }
    }
    Object localObject = av.GiL;
    if (av.qI(getDisplayMask())) {
      localObject = com.tencent.mm.plugin.finder.storage.ah.FMh;
    }
    for (paramString1 = (CharSequence)com.tencent.mm.plugin.finder.storage.ah.jdMethod_if(paramString3, paramString1);; paramString1 = (CharSequence)paramString1)
    {
      paramString2.setText(paramString1);
      paramString2.setTextColor(paramString2.getResources().getColor(e.b.Orange));
      break;
    }
    paramString1.setIconColor(paramString1.getResources().getColor(e.b.Orange));
    paramString1.setImageResource(e.g.finder_filled_activity);
    AppMethodBeat.o(345765);
  }
  
  private static final void l(d paramd, View paramView)
  {
    AppMethodBeat.i(345878);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "$this_apply");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendActivityView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345878);
  }
  
  private final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(345787);
    this.Gyf = paramBoolean;
    setAlpha(1.0F);
    setOnClickListener(this.dpY);
    this.uck.setTextColor(getContext().getResources().getColor(e.b.FG_2));
    if (paramBoolean)
    {
      this.uck.setText(e.h.finder_activity_default_desc);
      AppMethodBeat.o(345787);
      return;
    }
    this.uck.setText(e.h.finder_activity_desc_participate_only);
    AppMethodBeat.o(345787);
  }
  
  public final void b(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(346065);
    kotlin.g.b.s.u(paramIntent, "intent");
    if (c(paramIntent, paramInt))
    {
      this.Avy = paramInt;
      d(paramIntent, paramInt);
    }
    fkw();
    AppMethodBeat.o(346065);
  }
  
  public final brg getActivityEvent()
  {
    AppMethodBeat.i(345983);
    brg localbrg = this.Gcw;
    localbrg.ocD = getActivityTopicId();
    String str = this.AtM;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbrg.eventName = ((String)localObject);
    str = this.Gyb;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbrg.ZZl = ((String)localObject);
    localbrg.ZHN = getActivityWordingInfo();
    Log.i("Finder.ExtendActivityView", "get activityEvent " + this.Gcw.eventName + " eventTopicId:" + this.Gcw.ocD);
    localObject = this.Gcw;
    AppMethodBeat.o(345983);
    return localObject;
  }
  
  public final long getActivityTopicId()
  {
    return this.hyN;
  }
  
  public final awx getActivityWordingInfo()
  {
    return this.Gyd;
  }
  
  public final m getContact()
  {
    return this.contact;
  }
  
  public final long getDisplayMask()
  {
    return this.FOi;
  }
  
  public final View.OnClickListener getOnClickListener()
  {
    return this.dpY;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(346093);
    if ((paramp instanceof dh))
    {
      com.tencent.mm.kernel.h.aZW().b(4050, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setEnable(true);
        AppMethodBeat.o(346093);
        return;
      }
      if (paramInt2 == -4064) {
        setEnable(false);
      }
    }
    AppMethodBeat.o(346093);
  }
  
  public final void setActivityEvent(brg parambrg)
  {
    AppMethodBeat.i(345991);
    kotlin.g.b.s.u(parambrg, "<set-?>");
    this.Gcw = parambrg;
    AppMethodBeat.o(345991);
  }
  
  public final void setActivityTopicId(long paramLong)
  {
    this.hyN = paramLong;
  }
  
  public final void setActivityWordingInfo(awx paramawx)
  {
    this.Gyd = paramawx;
  }
  
  public final void setContact(m paramm)
  {
    this.contact = paramm;
  }
  
  public final void setDisplayMask(long paramLong)
  {
    this.FOi = paramLong;
  }
  
  public final void setIntentParam(Intent paramIntent)
  {
    AppMethodBeat.i(346082);
    Object localObject;
    label53:
    label84:
    String str;
    if (paramIntent != null)
    {
      localObject = getContact();
      if (localObject != null) {
        break label288;
      }
      localObject = "";
      paramIntent.putExtra("key_user_name", (String)localObject);
      if (!Util.isNullOrNil(this.Gyb)) {
        break label322;
      }
      localObject = getContact();
      if (localObject != null) {
        break label305;
      }
      localObject = "";
      paramIntent.putExtra("key_nick_name", (String)localObject);
      if (!Util.isNullOrNil(this.Gyc)) {
        break label347;
      }
      localObject = getContact();
      if (localObject != null) {
        break label330;
      }
      localObject = "";
      paramIntent.putExtra("key_avatar_url", (String)localObject);
      paramIntent.putExtra("key_topic_id", getActivityTopicId());
      str = this.AtM;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramIntent.putExtra("key_activity_name", (String)localObject);
      str = this.Ava;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramIntent.putExtra("key_activity_desc", (String)localObject);
      paramIntent.putExtra("key_activity_display_mask", getDisplayMask());
      paramIntent.putExtra("key_activity_end_time", this.FOe);
      paramIntent.putExtra("key_activity_src_type", this.Gyg);
      localObject = getActivityWordingInfo();
      if (localObject != null)
      {
        localObject = ((awx)localObject).toByteArray();
        if (localObject != null) {
          paramIntent.putExtra("key_wording_info", (byte[])localObject);
        }
      }
      if (this.Avy != 101) {
        break label355;
      }
      str = this.Avx;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramIntent.putExtra("key_activity_local_cover_url", (String)localObject);
      str = this.coverUrl;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramIntent.putExtra("key_cover_url", (String)localObject);
    }
    for (;;)
    {
      paramIntent.putExtra("key_activity_type", this.Avy);
      AppMethodBeat.o(346082);
      return;
      label288:
      str = ((m)localObject).field_username;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label305:
      str = ((m)localObject).getNickname();
      localObject = str;
      if (str != null) {
        break label53;
      }
      localObject = "";
      break label53;
      label322:
      localObject = this.Gyb;
      break label53;
      label330:
      str = ((m)localObject).amx();
      localObject = str;
      if (str != null) {
        break label84;
      }
      localObject = "";
      break label84;
      label347:
      localObject = this.Gyc;
      break label84;
      label355:
      if (this.Avy == 102)
      {
        str = this.coverUrl;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent.putExtra("key_cover_url", (String)localObject);
        paramIntent.putExtra("key_is_from_post", true);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView$Companion;", "", "()V", "ACTIVITY_TYPE_CREATE", "", "ACTIVITY_TYPE_NONE", "ACTIVITY_TYPE_SELECT", "MENU_ID_CREATE_DELETE", "MENU_ID_CREATE_MODIFY", "MENU_ID_DESC_DETAIL", "MENU_ID_DESC_EXIT", "MENU_ID_PARTICIPATE", "MENU_ID_POST_ACTIVITY", "REQUEST_CODE_PARTICIPATE_ACTIVITY", "REQUEST_CODE_PRE_POST_ACTIVITY", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendActivityView
 * JD-Core Version:    0.7.0.1
 */