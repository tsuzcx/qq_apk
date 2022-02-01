package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "profileData", "Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "getProfileData", "()Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "setProfileData", "(Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;)V", "rankId", "getRankId", "setRankId", "inflateItemView", "Landroid/view/View;", "viewType", "", "updateItemView", "", "itemView", "username", "OtherBtnViewHolder", "ProfileViewHolder", "app_release"})
public final class e
  extends UIComponent
{
  String appName;
  String vil;
  public cew vsB;
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(286474);
    AppMethodBeat.o(286474);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281540);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      d.rE(8);
      paramView = new AppBrandStatObject();
      paramView.scene = 1063;
      ((r)h.ae(r.class)).a((Context)this.vsE.getActivity(), null, "wx3fca79fc5715b185", 0, 0, "", paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281540);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(275039);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if ((this.vsE.getActivity() instanceof ExdeviceProfileUI))
      {
        paramView = this.vsE.getActivity();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI");
          AppMethodBeat.o(275039);
          throw paramView;
        }
        ((ExdeviceProfileUI)paramView).daC();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275039);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279222);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = new Intent((Context)this.vsE.getActivity(), ExdeviceFollowsUI.class);
      paramView = this.vsE.getActivity();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279222);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282890);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if ((!Util.isNullOrNil(this.vsE.vil)) && ((p.h("#", this.vsE.vil) ^ true)))
      {
        Intent localIntent = new Intent((Context)this.vsE.getActivity(), ExdeviceLikeUI.class);
        localObject = this.vsE.appName;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localIntent.putExtra("app_username", paramView);
        localObject = this.vsE.vil;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localIntent.putExtra("rank_id", paramView);
        localIntent.putExtra("key_is_like_read_only", true);
        paramView = this.vsE.getActivity();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282890);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(e parame, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289929);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = new Intent((Context)this.vsE.getActivity(), SportHistoryUI.class);
      ((Intent)localObject).putExtra("username", this.kyF);
      paramView = this.vsE.getActivity();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289929);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(e parame, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289239);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = new Intent();
      paramView.putExtra("Contact_User", this.kyF);
      c.b((Context)this.vsE.getActivity(), "profile", ".ui.ContactInfoUI", paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e
 * JD-Core Version:    0.7.0.1
 */