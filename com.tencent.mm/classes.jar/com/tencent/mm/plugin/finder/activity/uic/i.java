package com.tencent.mm.plugin.finder.activity.uic;

import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "acknowledgeBtn", "Landroid/widget/Button;", "container", "Landroid/widget/LinearLayout;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1;", "invalidDetailIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "invalidDetailText", "Landroid/widget/TextView;", "isInvokeOpenSdkCallback", "", "changeFeed", "", "responseCode", "", "initView", "type", "errMsg", "", "notifyOpenSdkCallback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends UIComponent
{
  public static final a Awq;
  private LinearLayout Api;
  private Button Awr;
  private TextView Aws;
  private WeImageView Awt;
  private final FinderInvalidActivityUIC.finderTopicInfoListener.1 Awu;
  private boolean Awv;
  
  static
  {
    AppMethodBeat.i(348149);
    Awq = new a((byte)0);
    AppMethodBeat.o(348149);
  }
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348116);
    this.Awu = new FinderInvalidActivityUIC.finderTopicInfoListener.1(this, paramAppCompatActivity, f.hfK);
    AppMethodBeat.o(348116);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(348124);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parami);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    if (!parami.getActivity().isFinishing()) {
      parami.getActivity().finish();
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348124);
  }
  
  public final void bs(int paramInt, String paramString)
  {
    AppMethodBeat.i(348181);
    Object localObject = (ViewStub)getActivity().findViewById(e.e.finder_activity_invalid_container_stub);
    if (localObject != null) {
      ((ViewStub)localObject).inflate();
    }
    this.Api = ((LinearLayout)getActivity().findViewById(e.e.finder_activity_invalid_container));
    localObject = this.Api;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = (TextView)getActivity().findViewById(e.e.finder_activity_invalid_title);
    if (localObject != null) {
      aw.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    }
    this.Aws = ((TextView)getActivity().findViewById(e.e.finder_activity_invalid_detail));
    this.Awt = ((WeImageView)getActivity().findViewById(e.e.finder_activity_invalid_icon));
    localObject = getResources().getString(e.h.finder_activity_invalid_detail);
    s.s(localObject, "resources.getString(R.st…_activity_invalid_detail)");
    int i = getResources().getColor(e.b.Blue_100);
    switch (paramInt)
    {
    default: 
      paramString = (String)localObject;
      paramInt = i;
      label197:
      localObject = this.Aws;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      paramString = this.Awt;
      if (paramString != null) {
        paramString.setIconColor(paramInt);
      }
      paramString = (Button)getActivity().findViewById(e.e.finder_activity_invalid_btn);
      if (paramString == null) {
        paramString = null;
      }
      break;
    }
    for (;;)
    {
      this.Awr = paramString;
      AppMethodBeat.o(348181);
      return;
      localObject = paramString;
      if (paramString == null)
      {
        localObject = getResources().getString(e.h.finder_activity_violation_detail);
        s.s(localObject, "resources.getString(R.st…ctivity_violation_detail)");
      }
      paramInt = getResources().getColor(e.b.Red_100);
      paramString = (String)localObject;
      break label197;
      localObject = getResources().getString(e.h.finder_activity_feed_removed);
      s.s(localObject, "resources.getString(R.st…er_activity_feed_removed)");
      paramString = (TextView)getActivity().findViewById(e.e.finder_activity_invalid_title);
      if (paramString != null) {
        paramString.setText((CharSequence)localObject);
      }
      TextView localTextView = this.Aws;
      paramString = (String)localObject;
      if (localTextView == null) {
        break;
      }
      localTextView.setVisibility(4);
      paramString = (String)localObject;
      break;
      paramString.setOnClickListener(new i..ExternalSyntheticLambda0(this));
      localObject = ah.aiuX;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348160);
    super.onCreate(paramBundle);
    this.Awu.alive();
    AppMethodBeat.o(348160);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348164);
    super.onDestroy();
    this.Awu.dead();
    AppMethodBeat.o(348164);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.i
 * JD-Core Version:    0.7.0.1
 */