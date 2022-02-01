package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "activityDesc", "", "activityEventId", "", "activityName", "avatarUrl", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "coverUrl", "descText", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getFinderTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setFinderTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1;", "fromObjectId", "headerAvatarView", "Landroid/widget/ImageView;", "headerCoverView", "headerDescTextView", "Landroid/widget/TextView;", "headerNameTextView", "headerParticipateTextView", "headerTitleTextView", "headerView", "Landroid/view/View;", "mDialogBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "nickName", "participateBtn", "Landroid/widget/LinearLayout;", "participateCount", "", "getAvailableDescWidth", "initParam", "", "initView", "loadAvatar", "url", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshHeader", "topicInfo", "setCover", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "textView", "setView", "showBottomSheet", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  public static final a AuQ;
  private ImageView AtF;
  String AtM;
  private awt AtP;
  private TextView AuR;
  private TextView AuS;
  private ImageView AuT;
  private TextView AuU;
  private TextView AuV;
  private LinearLayout AuW;
  private com.google.android.material.bottomsheet.a AuX;
  private BottomSheetBehavior<View> AuY;
  private String AuZ;
  String Ava;
  int Avb;
  long Avc;
  long Avd;
  bxv Ave;
  private final FinderActivityHeaderUIC.finderTopicInfoListener.1 Avf;
  String coverUrl;
  String nVM;
  String nickName;
  private View pUv;
  
  static
  {
    AppMethodBeat.i(348368);
    AuQ = new a((byte)0);
    AppMethodBeat.o(348368);
  }
  
  public d(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(348170);
    this.AuZ = "";
    this.nickName = "";
    this.AtM = "";
    this.Ava = "";
    this.nVM = "";
    this.coverUrl = "";
    this.Avf = new FinderActivityHeaderUIC.finderTopicInfoListener.1(this, f.hfK);
    AppMethodBeat.o(348170);
  }
  
  private final void MU(int paramInt)
  {
    AppMethodBeat.i(348201);
    String str = getActivity().getString(e.h.finder_activity_item_desc, new Object[] { r.ip(2, paramInt) });
    kotlin.g.b.s.s(str, "activity.getString(R.str…ewScene.SCENE_WX, count))");
    TextView localTextView2 = this.AuV;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      kotlin.g.b.s.bIx("headerParticipateTextView");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)str);
    AppMethodBeat.o(348201);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(348300);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    paramd = paramd.AuX;
    if (paramd != null) {
      paramd.hide();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348300);
  }
  
  private final void a(String paramString, TextView paramTextView)
  {
    AppMethodBeat.i(348240);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("SimpleUIComponent", "desc " + paramString + ", maxLineNum:2");
      AppMethodBeat.o(348240);
      return;
    }
    int i = dTy();
    Object localObject2 = paramTextView.getPaint();
    Object localObject1 = new StaticLayout((CharSequence)paramString, 0, paramString.length(), (TextPaint)localObject2, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
    if (((StaticLayout)localObject1).getLineCount() <= 2)
    {
      paramTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(348240);
      return;
    }
    int j = ((StaticLayout)localObject1).getLineEnd(1);
    int k = ((StaticLayout)localObject1).getLineEnd(0);
    localObject1 = paramTextView.getContext().getString(e.h.finder_desc_suffix_text);
    kotlin.g.b.s.s(localObject1, "textView.context.getStri….finder_desc_suffix_text)");
    float f1 = paramTextView.getPaint().measureText((String)localObject1);
    float f2 = i;
    localObject2 = new StaticLayout((CharSequence)paramString, k, j, (TextPaint)localObject2, (int)(f2 - f1), Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
    if (((StaticLayout)localObject2).getLineCount() > 0)
    {
      i = ((StaticLayout)localObject2).getLineEnd(0);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(348240);
        throw paramString;
      }
      paramString = paramString.substring(0, i);
      kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = kotlin.g.b.s.X(paramString, localObject1);
      localObject2 = new SpannableString((CharSequence)paramString);
      ((SpannableString)localObject2).setSpan(new q((String)localObject1, getResources().getColor(e.b.Link_80), getResources().getColor(e.b.BW_0_Alpha_0_2), false, (kotlin.g.a.b)new c(this)), i + 3, paramString.length(), 17);
      paramTextView.setText((CharSequence)localObject2);
    }
    AppMethodBeat.o(348240);
  }
  
  private static final void a(String paramString, d paramd, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(348282);
    kotlin.g.b.s.u(paramString, "$coverUrl");
    kotlin.g.b.s.u(paramd, "this$0");
    if (paramBitmap != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramd));
      Log.i("SimpleUIComponent", "[handleActivityProfileCover] [" + paramBitmap.getWidth() + ':' + paramBitmap.getHeight() + "] allocationByteCount=" + Util.getSizeKB(paramBitmap.getAllocationByteCount()) + " coverUrl=" + paramString);
    }
    AppMethodBeat.o(348282);
  }
  
  private final void auN(String paramString)
  {
    AppMethodBeat.i(348214);
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      com.tencent.mm.loader.d locald = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(paramString);
      localObject = this.AuT;
      paramString = (String)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("headerAvatarView");
        paramString = null;
      }
      localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      locald.a(localb, paramString, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    }
    AppMethodBeat.o(348214);
  }
  
  private final int dTy()
  {
    AppMethodBeat.i(348249);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = com.tencent.mm.cd.a.bs((Context)getActivity(), e.c.Edge_6A);
    AppMethodBeat.o(348249);
    return i - j;
  }
  
  private static final void fm(View paramView)
  {
    AppMethodBeat.i(348260);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348260);
  }
  
  private final void setCover(String paramString)
  {
    AppMethodBeat.i(348184);
    Object localObject1 = new i(paramString);
    Object localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(localObject1);
    localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject2 = ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExU)).a(new d..ExternalSyntheticLambda2(paramString, this));
    localObject1 = this.AtF;
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("headerCoverView");
      paramString = null;
    }
    ((com.tencent.mm.loader.b)localObject2).d(paramString);
    AppMethodBeat.o(348184);
  }
  
  final void dTx()
  {
    Object localObject3 = null;
    AppMethodBeat.i(348449);
    Object localObject1 = this.AuR;
    Object localObject2;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("headerTitleTextView");
      localObject1 = null;
      Context localContext = (Context)getActivity();
      String str = this.nickName;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)localObject2));
      localObject1 = this.AuU;
      if (localObject1 != null) {
        break label188;
      }
      kotlin.g.b.s.bIx("headerNameTextView");
      localObject1 = null;
      label84:
      ((TextView)localObject1).setText((CharSequence)this.AtM);
      localObject2 = this.nVM;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      auN((String)localObject1);
      localObject2 = this.Ava;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = this.AuS;
      if (localObject2 != null) {
        break label191;
      }
      kotlin.g.b.s.bIx("headerDescTextView");
      localObject2 = localObject3;
    }
    label188:
    label191:
    for (;;)
    {
      a((String)localObject1, (TextView)localObject2);
      MU(this.Avb);
      localObject2 = this.coverUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      setCover((String)localObject1);
      AppMethodBeat.o(348449);
      return;
      break;
      break label84;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(348422);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.nickName = paramBundle.getStringExtra("key_nick_name");
    this.AtM = paramBundle.getStringExtra("key_activity_name");
    this.Ava = paramBundle.getStringExtra("key_activity_desc");
    this.nVM = paramBundle.getStringExtra("key_avatar_url");
    this.coverUrl = paramBundle.getStringExtra("key_cover_url");
    this.Avb = paramBundle.getIntExtra("key_activity_participate_count", 0);
    this.Avc = paramBundle.getLongExtra("key_activity_id", 0L);
    paramBundle = getActivity().findViewById(e.e.activity_profile_header);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.….activity_profile_header)");
    this.pUv = paramBundle;
    paramBundle = getActivity().findViewById(e.e.activity_profile_cover);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.activity_profile_cover)");
    this.AtF = ((ImageView)paramBundle);
    Object localObject2 = this.pUv;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("headerView");
      paramBundle = null;
    }
    paramBundle = (TextView)paramBundle.findViewById(e.e.activity_profile_header_title);
    kotlin.g.b.s.s(paramBundle, "headerView.activity_profile_header_title");
    this.AuR = paramBundle;
    localObject2 = this.pUv;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("headerView");
      paramBundle = null;
    }
    paramBundle = (TextView)paramBundle.findViewById(e.e.activity_profile_header_desc);
    kotlin.g.b.s.s(paramBundle, "headerView.activity_profile_header_desc");
    this.AuS = paramBundle;
    localObject2 = this.pUv;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("headerView");
      paramBundle = null;
    }
    paramBundle = (ImageView)paramBundle.findViewById(e.e.activity_profile_header_avatar);
    kotlin.g.b.s.s(paramBundle, "headerView.activity_profile_header_avatar");
    this.AuT = paramBundle;
    localObject2 = this.pUv;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("headerView");
      paramBundle = null;
    }
    paramBundle = (TextView)paramBundle.findViewById(e.e.activity_profile_header_name);
    kotlin.g.b.s.s(paramBundle, "headerView.activity_profile_header_name");
    this.AuU = paramBundle;
    localObject2 = this.pUv;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("headerView");
      paramBundle = null;
    }
    paramBundle = (TextView)paramBundle.findViewById(e.e.activity_profile_header_participate);
    kotlin.g.b.s.s(paramBundle, "headerView.activity_profile_header_participate");
    this.AuV = paramBundle;
    localObject2 = this.pUv;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("headerView");
      paramBundle = null;
    }
    paramBundle = (LinearLayout)paramBundle.findViewById(e.e.activity_profile_header_participate_btn);
    kotlin.g.b.s.s(paramBundle, "headerView.activity_profile_header_participate_btn");
    this.AuW = paramBundle;
    localObject2 = this.AuW;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("participateBtn");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(d..ExternalSyntheticLambda1.INSTANCE);
    dTx();
    paramBundle = this.AuS;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("headerDescTextView");
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(paramBundle.getContext()));
      this.Avf.alive();
      AppMethodBeat.o(348422);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348435);
    super.onDestroy();
    this.Avf.dead();
    AppMethodBeat.o(348435);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$Companion;", "", "()V", "IS_MOCK_DATA", "", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "detailSuffix", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    c(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.d
 * JD-Core Version:    0.7.0.1
 */