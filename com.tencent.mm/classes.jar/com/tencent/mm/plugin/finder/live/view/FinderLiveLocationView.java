package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.pluginsdk.location.Location;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLocationView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickLocationListener", "Lcom/tencent/mm/pluginsdk/location/ILocationView$OnClickLocationListener;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "defaultLoadingPBarColor", "defaultLoadingTipColor", "defaultStateIconColor", "defaultStateTextColor", "iconColor", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLocationIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLocationIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "locationListener", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getLocationListener", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "locationLoadingProBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getLocationLoadingProBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "setLocationLoadingProBar", "(Lcom/tencent/mm/ui/widget/MMProcessBar;)V", "locationLoadingTip", "Landroid/widget/TextView;", "getLocationLoadingTip", "()Landroid/widget/TextView;", "setLocationLoadingTip", "(Landroid/widget/TextView;)V", "locationLoadingView", "getLocationLoadingView", "setLocationLoadingView", "locationNormalView", "getLocationNormalView", "setLocationNormalView", "locationTv", "getLocationTv", "setLocationTv", "longitude", "getLongitude", "setLongitude", "textColor", "GDPRLocationConfirm", "", "doClickAfterPermission", "getLocation", "Lcom/tencent/mm/pluginsdk/location/Location;", "init", "resetLocationColor", "setDefaultLoadingPBarColor", "setDefaultLoadingTipColor", "setDefaultState", "setDefaultStateIconColor", "setDefaultStateTextColor", "setIconColor", "setLoadingState", "setLocationIcon", "resId", "setLocationIconColor", "setLocationName", "locationName", "setLocationNameColor", "setLocationTipColor", "color", "setNormalState", "city", "poiName", "setOnClickLocationListener", "onClickLocationListener", "setSuggestView", "setTextColor", "updateLoadingView", "id", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLocationView
  extends LinearLayout
  implements com.tencent.mm.pluginsdk.location.b
{
  public WeImageView DOg;
  public TextView DOh;
  public View DOi;
  public MMProcessBar DOj;
  public TextView DOk;
  public View DOl;
  private int DOm;
  private int DOn;
  private int DOo;
  private int DOp;
  private com.tencent.mm.pluginsdk.location.b.a DOq;
  private final com.tencent.mm.modelgeo.b.a DOr;
  private final String TAG;
  public View contentView;
  private int iconColor;
  private float latitude;
  private float longitude;
  private int textColor;
  
  public FinderLiveLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357778);
    this.TAG = "Finder.FinderLiveLocationView";
    this.latitude = -85.0F;
    this.longitude = -1000.0F;
    this.DOr = new FinderLiveLocationView..ExternalSyntheticLambda1(this);
    init();
    AppMethodBeat.o(357778);
  }
  
  public FinderLiveLocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357784);
    this.TAG = "Finder.FinderLiveLocationView";
    this.latitude = -85.0F;
    this.longitude = -1000.0F;
    this.DOr = new FinderLiveLocationView..ExternalSyntheticLambda1(this);
    init();
    AppMethodBeat.o(357784);
  }
  
  private static final void a(FinderLiveLocationView paramFinderLiveLocationView, View paramView)
  {
    AppMethodBeat.i(357808);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveLocationView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveLocationView, "this$0");
    paramView = h.baE().ban().d(274436, null);
    if ((paramView instanceof String))
    {
      paramView = (String)paramView;
      if (!com.tencent.mm.au.b.OE(paramView)) {
        break label294;
      }
      if (com.tencent.mm.pluginsdk.permission.b.s(paramFinderLiveLocationView.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
        break label372;
      }
      paramView = h.baE().ban().get(at.a.acXn, Boolean.FALSE);
      if (!(paramView instanceof Boolean)) {
        break label272;
      }
      paramView = (Boolean)paramView;
      label129:
      if (!s.p(paramView, Boolean.TRUE)) {
        break label277;
      }
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramFinderLiveLocationView.getResources().getString(p.h.location_use_scene_gdpr_url));
      paramView.putExtra("showShare", false);
      paramView.putExtra("show_bottom", false);
      paramView.putExtra("needRedirect", false);
      paramView.putExtra("neverGetA8Key", false);
      paramView.putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.YxF);
      paramView.putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.YxA);
      c.b(paramFinderLiveLocationView.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    for (;;)
    {
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357808);
      return;
      paramView = null;
      break;
      label272:
      paramView = null;
      break label129;
      label277:
      com.tencent.mm.pluginsdk.permission.b.b((Activity)paramFinderLiveLocationView.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
    }
    label294:
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramFinderLiveLocationView.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64, paramFinderLiveLocationView.getContext().getString(p.h.Csi), null, Boolean.TRUE);
    Log.i(paramFinderLiveLocationView.getTAG(), "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357808);
      return;
    }
    label372:
    paramFinderLiveLocationView = paramFinderLiveLocationView.DOq;
    if (paramFinderLiveLocationView != null) {
      paramFinderLiveLocationView.onClickLocationView();
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357808);
  }
  
  private static final boolean a(FinderLiveLocationView paramFinderLiveLocationView, boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(357817);
    s.u(paramFinderLiveLocationView, "this$0");
    if (!paramBoolean)
    {
      AppMethodBeat.o(357817);
      return true;
    }
    Log.d(paramFinderLiveLocationView.getTAG(), "get location %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    n.a(2015, paramFloat1, paramFloat2, 0);
    if (paramFinderLiveLocationView.getLatitude() == -85.0F)
    {
      paramInt = 1;
      if (paramInt == 0) {
        if (paramFinderLiveLocationView.getLongitude() != -1000.0F) {
          break label121;
        }
      }
    }
    label121:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        paramFinderLiveLocationView.setLatitude(paramFloat2);
        paramFinderLiveLocationView.setLongitude(paramFloat1);
      }
      AppMethodBeat.o(357817);
      return false;
      paramInt = 0;
      break;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(357794);
    Object localObject = View.inflate(getContext(), p.f.Ceq, (ViewGroup)this);
    s.s(localObject, "inflate(context, R.layou…_location_geo_view, this)");
    setContentView((View)localObject);
    localObject = findViewById(p.e.location_icon);
    s.s(localObject, "findViewById(R.id.location_icon)");
    setLocationIv((WeImageView)localObject);
    localObject = findViewById(p.e.location_poi_name);
    s.s(localObject, "findViewById(R.id.location_poi_name)");
    setLocationTv((TextView)localObject);
    localObject = findViewById(p.e.location_loading_view);
    s.s(localObject, "findViewById(R.id.location_loading_view)");
    setLocationLoadingView((View)localObject);
    localObject = findViewById(p.e.location_verifying_icon);
    s.s(localObject, "findViewById(R.id.location_verifying_icon)");
    setLocationLoadingProBar((MMProcessBar)localObject);
    localObject = findViewById(p.e.location_verifying_tip);
    s.s(localObject, "findViewById(R.id.location_verifying_tip)");
    setLocationLoadingTip((TextView)localObject);
    localObject = findViewById(p.e.location_normal_view);
    s.s(localObject, "findViewById(R.id.location_normal_view)");
    setLocationNormalView((View)localObject);
    setBackgroundResource(p.d.comm_list_item_selector);
    localObject = new FinderLiveLocationView..ExternalSyntheticLambda0(this);
    getContentView().setOnClickListener((View.OnClickListener)localObject);
    AppMethodBeat.o(357794);
  }
  
  public final void Px(int paramInt)
  {
    AppMethodBeat.i(358073);
    getLocationLoadingProBar().oH(paramInt, this.DOo);
    getLocationLoadingTip().setTextColor(this.DOp);
    AppMethodBeat.o(358073);
  }
  
  public final void dUm()
  {
    AppMethodBeat.i(358013);
    getLocationNormalView().setVisibility(0);
    getLocationLoadingView().setVisibility(8);
    setLocationName(getContext().getString(p.h.Cqz));
    getLocationIv().setIconColor(this.DOm);
    getLocationTv().setTextColor(this.DOn);
    setLocationIcon(p.g.icons_filled_location);
    AppMethodBeat.o(358013);
  }
  
  public final void dUn()
  {
    AppMethodBeat.i(357990);
    getLocationNormalView().setVisibility(8);
    getLocationLoadingView().setVisibility(0);
    AppMethodBeat.o(357990);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(357920);
    View localView = this.contentView;
    if (localView != null)
    {
      AppMethodBeat.o(357920);
      return localView;
    }
    s.bIx("contentView");
    AppMethodBeat.o(357920);
    return null;
  }
  
  public final float getLatitude()
  {
    return this.latitude;
  }
  
  public final Location getLocation()
  {
    AppMethodBeat.i(358059);
    Location localLocation = new Location(this.latitude, this.longitude);
    AppMethodBeat.o(358059);
    return localLocation;
  }
  
  public final WeImageView getLocationIv()
  {
    AppMethodBeat.i(357845);
    WeImageView localWeImageView = this.DOg;
    if (localWeImageView != null)
    {
      AppMethodBeat.o(357845);
      return localWeImageView;
    }
    s.bIx("locationIv");
    AppMethodBeat.o(357845);
    return null;
  }
  
  public final com.tencent.mm.modelgeo.b.a getLocationListener()
  {
    return this.DOr;
  }
  
  public final MMProcessBar getLocationLoadingProBar()
  {
    AppMethodBeat.i(357884);
    MMProcessBar localMMProcessBar = this.DOj;
    if (localMMProcessBar != null)
    {
      AppMethodBeat.o(357884);
      return localMMProcessBar;
    }
    s.bIx("locationLoadingProBar");
    AppMethodBeat.o(357884);
    return null;
  }
  
  public final TextView getLocationLoadingTip()
  {
    AppMethodBeat.i(357896);
    TextView localTextView = this.DOk;
    if (localTextView != null)
    {
      AppMethodBeat.o(357896);
      return localTextView;
    }
    s.bIx("locationLoadingTip");
    AppMethodBeat.o(357896);
    return null;
  }
  
  public final View getLocationLoadingView()
  {
    AppMethodBeat.i(357872);
    View localView = this.DOi;
    if (localView != null)
    {
      AppMethodBeat.o(357872);
      return localView;
    }
    s.bIx("locationLoadingView");
    AppMethodBeat.o(357872);
    return null;
  }
  
  public final View getLocationNormalView()
  {
    AppMethodBeat.i(357912);
    View localView = this.DOl;
    if (localView != null)
    {
      AppMethodBeat.o(357912);
      return localView;
    }
    s.bIx("locationNormalView");
    AppMethodBeat.o(357912);
    return null;
  }
  
  public final TextView getLocationTv()
  {
    AppMethodBeat.i(357858);
    TextView localTextView = this.DOh;
    if (localTextView != null)
    {
      AppMethodBeat.o(357858);
      return localTextView;
    }
    s.bIx("locationTv");
    AppMethodBeat.o(357858);
    return null;
  }
  
  public final float getLongitude()
  {
    return this.longitude;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void hT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(358005);
    getLocationNormalView().setVisibility(0);
    getLocationLoadingView().setVisibility(8);
    if (!Util.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(this.textColor);
      setLocationIcon(p.g.icons_filled_location);
      setLocationIconColor(this.iconColor);
      AppMethodBeat.o(358005);
      return;
      setLocationName(paramString1);
    }
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(357930);
    s.u(paramView, "<set-?>");
    this.contentView = paramView;
    AppMethodBeat.o(357930);
  }
  
  public final void setDefaultLoadingPBarColor(int paramInt)
  {
    this.DOo = paramInt;
  }
  
  public final void setDefaultLoadingTipColor(int paramInt)
  {
    this.DOp = paramInt;
  }
  
  public final void setDefaultStateIconColor(int paramInt)
  {
    this.DOm = paramInt;
  }
  
  public final void setDefaultStateTextColor(int paramInt)
  {
    this.DOn = paramInt;
  }
  
  public final void setIconColor(int paramInt)
  {
    this.iconColor = paramInt;
  }
  
  public final void setLatitude(float paramFloat)
  {
    this.latitude = paramFloat;
  }
  
  public final void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(358042);
    getLocationIv().setImageResource(paramInt);
    AppMethodBeat.o(358042);
  }
  
  public final void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(358034);
    getLocationIv().setIconColor(paramInt);
    AppMethodBeat.o(358034);
  }
  
  public final void setLocationIv(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(357852);
    s.u(paramWeImageView, "<set-?>");
    this.DOg = paramWeImageView;
    AppMethodBeat.o(357852);
  }
  
  public final void setLocationLoadingProBar(MMProcessBar paramMMProcessBar)
  {
    AppMethodBeat.i(357890);
    s.u(paramMMProcessBar, "<set-?>");
    this.DOj = paramMMProcessBar;
    AppMethodBeat.o(357890);
  }
  
  public final void setLocationLoadingTip(TextView paramTextView)
  {
    AppMethodBeat.i(357904);
    s.u(paramTextView, "<set-?>");
    this.DOk = paramTextView;
    AppMethodBeat.o(357904);
  }
  
  public final void setLocationLoadingView(View paramView)
  {
    AppMethodBeat.i(357879);
    s.u(paramView, "<set-?>");
    this.DOi = paramView;
    AppMethodBeat.o(357879);
  }
  
  public final void setLocationName(String paramString)
  {
    AppMethodBeat.i(358026);
    getLocationTv().setText((CharSequence)paramString);
    AppMethodBeat.o(358026);
  }
  
  public final void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(358048);
    getLocationTv().setTextColor(paramInt);
    AppMethodBeat.o(358048);
  }
  
  public final void setLocationNormalView(View paramView)
  {
    AppMethodBeat.i(357917);
    s.u(paramView, "<set-?>");
    this.DOl = paramView;
    AppMethodBeat.o(357917);
  }
  
  public final void setLocationTipColor(int paramInt) {}
  
  public final void setLocationTv(TextView paramTextView)
  {
    AppMethodBeat.i(357867);
    s.u(paramTextView, "<set-?>");
    this.DOh = paramTextView;
    AppMethodBeat.o(357867);
  }
  
  public final void setLongitude(float paramFloat)
  {
    this.longitude = paramFloat;
  }
  
  public final void setOnClickLocationListener(com.tencent.mm.pluginsdk.location.b.a parama)
  {
    this.DOq = parama;
  }
  
  public final void setSuggestView(String paramString)
  {
    AppMethodBeat.i(357997);
    getLocationNormalView().setVisibility(0);
    getLocationLoadingView().setVisibility(8);
    setLocationName(paramString);
    setLocationNameColor(this.textColor);
    setLocationIcon(p.g.icons_filled_location);
    setLocationIconColor(this.iconColor);
    AppMethodBeat.o(357997);
  }
  
  public final void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLocationView
 * JD-Core Version:    0.7.0.1
 */