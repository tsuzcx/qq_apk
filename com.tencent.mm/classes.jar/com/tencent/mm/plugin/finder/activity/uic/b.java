package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activityDescText", "Landroid/widget/TextView;", "activityNameText", "avatarImage", "Landroid/widget/ImageView;", "avatartContainer", "Landroid/widget/LinearLayout;", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "coverImageView", "coverMaskContainer", "Landroid/view/ViewGroup;", "coverMaskImageView", "descTextContent", "", "exitActivityBtn", "nickNameText", "noteLine", "Landroid/view/View;", "noteTextView", "title", "adjustCoverImageView", "", "adjustCoverMaskImageView", "getAvailableDescWidth", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCover", "coverUrl", "setCoverMaskMargin", "setCoverStyle", "setNormalStyle", "setSuffixedDesc", "descText", "maxLineNum", "textView", "isCovered", "", "setTextColors", "color", "showBottomSheet", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public static final a AuB;
  private ImageView AuC;
  private ImageView AuD;
  private ViewGroup AuE;
  private TextView AuF;
  private TextView AuG;
  private TextView AuH;
  private TextView AuI;
  private LinearLayout AuJ;
  private TextView AuK;
  private View AuL;
  private String AuM;
  private ImageView enI;
  private TextView mll;
  private WeImageView nhB;
  
  static
  {
    AppMethodBeat.i(348267);
    AuB = new a((byte)0);
    AppMethodBeat.o(348267);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348156);
    this.AuM = "";
    AppMethodBeat.o(348156);
  }
  
  private final void MT(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(348171);
    Object localObject3 = this.AuF;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("nickNameText");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(paramInt);
    localObject3 = this.nhB;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("backBtn");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setIconColor(paramInt);
    localObject1 = this.mll;
    if (localObject1 == null)
    {
      s.bIx("title");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((TextView)localObject1).setTextColor(paramInt);
      localObject1 = this.AuK;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(paramInt);
      }
      AppMethodBeat.o(348171);
      return;
    }
  }
  
  private static final void a(b paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(348222);
    s.u(paramb, "this$0");
    ImageView localImageView2 = paramb.enI;
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      s.bIx("coverImageView");
      localImageView1 = null;
    }
    ViewGroup.LayoutParams localLayoutParams = localImageView1.getLayoutParams();
    localImageView2 = paramb.enI;
    localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      s.bIx("coverImageView");
      localImageView1 = null;
    }
    localLayoutParams.height = ((int)(localImageView1.getWidth() * 1.333333F));
    paramb = paramb.enI;
    if (paramb == null)
    {
      s.bIx("coverImageView");
      paramb = localObject;
    }
    for (;;)
    {
      paramb.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(348222);
      return;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(348204);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (!paramb.getActivity().isFinishing()) {
      paramb.getActivity().finish();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348204);
  }
  
  private static final void a(String paramString, b paramb, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(348241);
    s.u(paramb, "this$0");
    if (paramBitmap != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramb));
      Log.i("Finder.ActivityDescUIC", "[handleActivityProfileCover] [" + paramBitmap.getWidth() + ':' + paramBitmap.getHeight() + "] allocationByteCount=" + Util.getSizeKB(paramBitmap.getAllocationByteCount()) + " coverUrl=" + paramString);
    }
    AppMethodBeat.o(348241);
  }
  
  private static final void fl(View paramView)
  {
    AppMethodBeat.i(348188);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348188);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_activity_desc_ui_new;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(348410);
    Object localObject1 = getActivity().findViewById(e.e.activity_profile_header_name);
    s.s(localObject1, "activity.findViewById(R.…vity_profile_header_name)");
    this.AuF = ((TextView)localObject1);
    localObject1 = getActivity().findViewById(e.e.finder_activity_name);
    s.s(localObject1, "activity.findViewById(R.id.finder_activity_name)");
    this.AuG = ((TextView)localObject1);
    localObject1 = getActivity().findViewById(e.e.finder_activity_desc);
    s.s(localObject1, "activity.findViewById(R.id.finder_activity_desc)");
    this.AuH = ((TextView)localObject1);
    localObject1 = getActivity().findViewById(e.e.finder_activity_post_cancel_btn);
    s.s(localObject1, "activity.findViewById(R.…activity_post_cancel_btn)");
    this.nhB = ((WeImageView)localObject1);
    localObject1 = getActivity().findViewById(e.e.finder_activity_post_title);
    s.s(localObject1, "activity.findViewById(R.…nder_activity_post_title)");
    this.mll = ((TextView)localObject1);
    localObject1 = getActivity().findViewById(e.e.avatar_container);
    s.s(localObject1, "activity.findViewById(R.id.avatar_container)");
    this.AuJ = ((LinearLayout)localObject1);
    Object localObject4 = this.mll;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("title");
      localObject1 = null;
    }
    com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject1);
    localObject4 = this.AuG;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("activityNameText");
      localObject1 = null;
    }
    com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject1);
    this.AuK = ((TextView)getActivity().findViewById(e.e.activity_profile_header_note_text));
    this.AuL = getActivity().findViewById(e.e.activity_profile_header_note_line);
    localObject1 = getActivity().findViewById(e.e.activity_post_cover);
    s.s(localObject1, "activity.findViewById(R.id.activity_post_cover)");
    this.enI = ((ImageView)localObject1);
    localObject1 = getActivity().findViewById(e.e.activity_profile_cover_mask);
    s.s(localObject1, "activity.findViewById(R.…ivity_profile_cover_mask)");
    this.AuD = ((ImageView)localObject1);
    localObject1 = getActivity().findViewById(e.e.activity_profile_cover_container);
    s.s(localObject1, "activity.findViewById(R.…_profile_cover_container)");
    this.AuE = ((ViewGroup)localObject1);
    localObject4 = getIntent().getStringExtra("key_cover_url");
    long l = getIntent().getLongExtra("key_activity_display_mask", 0L);
    Log.i("Finder.ActivityDescUIC", s.X("initView coverUrl:", localObject4));
    int i;
    if (!Util.isNullOrNil((String)localObject4))
    {
      i = 1;
      if (i == 0) {
        break label1349;
      }
      if (localObject4 != null) {
        break label804;
      }
    }
    float f;
    label804:
    for (localObject1 = "";; localObject1 = localObject4)
    {
      localObject1 = new com.tencent.mm.plugin.finder.loader.i((String)localObject1);
      localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(localObject1);
      localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject5 = ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExU)).a(new b..ExternalSyntheticLambda2((String)localObject4, this));
      localObject4 = this.enI;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("coverImageView");
        localObject1 = null;
      }
      ((com.tencent.mm.loader.b)localObject5).d((ImageView)localObject1);
      ((MMActivity)getActivity()).getController().updataStatusBarIcon(true);
      MT(getResources().getColor(e.b.BW_100_Alpha_0_8));
      i = getResources().getColor(e.b.finder_activity_covered_white);
      localObject4 = this.AuH;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("activityDescText");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextColor(i);
      localObject4 = this.AuH;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("activityDescText");
        localObject1 = null;
      }
      ((TextView)localObject1).setHintTextColor(getResources().getColor(e.b.BW_100_Alpha_0_3));
      localObject4 = this.AuG;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("activityNameText");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextColor(i);
      localObject4 = this.enI;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("coverImageView");
        localObject1 = null;
      }
      ((ImageView)localObject1).setVisibility(0);
      localObject4 = this.AuE;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("coverMaskContainer");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setVisibility(0);
      localObject1 = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      f = ((DisplayMetrics)localObject1).widthPixels;
      localObject4 = this.AuD;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("coverMaskImageView");
        localObject1 = null;
      }
      localObject5 = ((ImageView)localObject1).getLayoutParams();
      if (localObject5 != null) {
        break label811;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(348410);
      throw ((Throwable)localObject1);
      i = 0;
      break;
    }
    label811:
    ((ViewGroup.LayoutParams)localObject5).height = ((int)(1.333333F * f));
    localObject4 = this.AuD;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("coverMaskImageView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    localObject1 = this.AuL;
    if (localObject1 != null) {
      ((View)localObject1).setBackgroundColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_5));
    }
    localObject4 = this.enI;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("coverImageView");
      localObject1 = null;
    }
    ((ImageView)localObject1).post(new b..ExternalSyntheticLambda3(this));
    localObject1 = getActivity().findViewById(e.e.activity_profile_header_avatar);
    s.s(localObject1, "activity.findViewById(R.…ty_profile_header_avatar)");
    this.AuC = ((ImageView)localObject1);
    localObject1 = getIntent().getStringExtra("key_avatar_url");
    localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
    Object localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
    com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
    localObject4 = this.AuC;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("avatarImage");
      localObject1 = null;
    }
    localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject5).a(localb, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    localObject4 = getIntent().getStringExtra("key_nick_name");
    localObject1 = this.AuF;
    if (localObject1 == null)
    {
      s.bIx("nickNameText");
      localObject1 = null;
      label1055:
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)localObject4));
      localObject1 = this.AuG;
      if (localObject1 != null) {
        break label1585;
      }
      s.bIx("activityNameText");
      localObject1 = null;
      label1098:
      ((TextView)localObject1).setText((CharSequence)getIntent().getStringExtra("key_activity_name"));
      localObject4 = getIntent().getStringExtra("key_activity_desc");
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = "";
      }
      this.AuM = ((String)localObject1);
      localObject1 = getActivity().findViewById(e.e.finder_activity_exit_btn);
      s.s(localObject1, "activity.findViewById(R.…finder_activity_exit_btn)");
      this.AuI = ((TextView)localObject1);
      localObject4 = this.AuI;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("exitActivityBtn");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(b..ExternalSyntheticLambda1.INSTANCE);
      localObject4 = this.nhB;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("backBtn");
        localObject1 = null;
      }
      ((WeImageView)localObject1).setOnClickListener(new b..ExternalSyntheticLambda0(this));
      s.s(getResources().getString(e.h.finder_activity_post_desc_prefix, new Object[] { this.AuM }), "resources.getString(R.st…_prefix, descTextContent)");
      localObject4 = this.AuH;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("activityDescText");
        localObject1 = null;
      }
      ((TextView)localObject1).setMovementMethod(ScrollingMovementMethod.getInstance());
      localObject1 = av.GiL;
      if (!av.qI(l)) {
        break label1591;
      }
      localObject1 = this.AuJ;
      if (localObject1 != null) {
        break label1588;
      }
      s.bIx("avatartContainer");
      localObject1 = localObject2;
    }
    label1585:
    label1588:
    for (;;)
    {
      ((LinearLayout)localObject1).setVisibility(0);
      AppMethodBeat.o(348410);
      return;
      label1349:
      ((MMActivity)getActivity()).getController().updataStatusBarIcon(aw.isDarkMode());
      MT(getResources().getColor(e.b.FG_0));
      localObject1 = this.AuL;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(getContext().getResources().getColor(e.b.FG_1));
      }
      i = getResources().getColor(e.b.black_color);
      localObject4 = this.AuH;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("activityDescText");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextColor(i);
      localObject4 = this.AuG;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("activityNameText");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextColor(i);
      localObject4 = this.AuH;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("activityDescText");
        localObject1 = null;
      }
      ((TextView)localObject1).setHintTextColor(getResources().getColor(e.b.FG_2));
      localObject4 = this.enI;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("coverImageView");
        localObject1 = null;
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject4 = this.AuE;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("coverMaskContainer");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setVisibility(8);
      break;
      break label1055;
      break label1098;
    }
    label1591:
    localObject1 = this.AuJ;
    if (localObject1 == null)
    {
      s.bIx("avatartContainer");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setVisibility(8);
      AppMethodBeat.o(348410);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348349);
    super.onCreate(paramBundle);
    AppMethodBeat.o(348349);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$Companion;", "", "()V", "FIX_RATIO", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.b
 * JD-Core Version:    0.7.0.1
 */