package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.pluginsdk.location.Location;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLocationView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickLocationListener", "Lcom/tencent/mm/pluginsdk/location/ILocationView$OnClickLocationListener;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "defaultLoadingPBarColor", "defaultLoadingTipColor", "defaultStateIconColor", "defaultStateTextColor", "getLocation", "Lcom/tencent/mm/modelgeo/LocationGeo;", "kotlin.jvm.PlatformType", "getGetLocation", "()Lcom/tencent/mm/modelgeo/LocationGeo;", "setGetLocation", "(Lcom/tencent/mm/modelgeo/LocationGeo;)V", "iconColor", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLocationIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLocationIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "locationListener", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getLocationListener", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "locationLoadingProBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getLocationLoadingProBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "setLocationLoadingProBar", "(Lcom/tencent/mm/ui/widget/MMProcessBar;)V", "locationLoadingTip", "Landroid/widget/TextView;", "getLocationLoadingTip", "()Landroid/widget/TextView;", "setLocationLoadingTip", "(Landroid/widget/TextView;)V", "locationLoadingView", "getLocationLoadingView", "setLocationLoadingView", "locationNormalView", "getLocationNormalView", "setLocationNormalView", "locationTv", "getLocationTv", "setLocationTv", "longitude", "getLongitude", "setLongitude", "textColor", "GDPRLocationConfirm", "", "doClickAfterPermission", "Lcom/tencent/mm/pluginsdk/location/Location;", "init", "onAttachedToWindow", "onDetachedFromWindow", "resetLocationColor", "setDefaultLoadingPBarColor", "setDefaultLoadingTipColor", "setDefaultState", "setDefaultStateIconColor", "setDefaultStateTextColor", "setIconColor", "setLoadingState", "setLocationIcon", "resId", "setLocationIconColor", "setLocationName", "locationName", "setLocationNameColor", "setLocationTipColor", "color", "setNormalState", "city", "poiName", "setOnClickLocationListener", "onClickLocationListener", "setSuggestView", "setTextColor", "updateLoadingView", "id", "plugin-finder_release"})
public final class FinderLiveLocationView
  extends LinearLayout
  implements b
{
  private final String TAG;
  public View contentView;
  private int iconColor;
  private float latitude;
  private float longitude;
  private int textColor;
  public WeImageView yUO;
  public TextView yUP;
  public View yUQ;
  public MMProcessBar yUR;
  public TextView yUS;
  public View yUT;
  private d yUU;
  private int yUV;
  private int yUW;
  private int yUX;
  private int yUY;
  com.tencent.mm.pluginsdk.location.b.a yUZ;
  private final com.tencent.mm.modelgeo.b.a yVa;
  
  public FinderLiveLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(292142);
    this.TAG = "Finder.FinderLiveLocationView";
    this.yUU = d.blq();
    this.latitude = -85.0F;
    this.longitude = -1000.0F;
    this.yVa = ((com.tencent.mm.modelgeo.b.a)new b(this));
    init();
    AppMethodBeat.o(292142);
  }
  
  public FinderLiveLocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(292143);
    this.TAG = "Finder.FinderLiveLocationView";
    this.yUU = d.blq();
    this.latitude = -85.0F;
    this.longitude = -1000.0F;
    this.yVa = ((com.tencent.mm.modelgeo.b.a)new b(this));
    init();
    AppMethodBeat.o(292143);
  }
  
  private void init()
  {
    AppMethodBeat.i(292129);
    Object localObject = View.inflate(getContext(), b.g.finder_live_location_geo_view, (ViewGroup)this);
    p.j(localObject, "View.inflate(context, R.…_location_geo_view, this)");
    this.contentView = ((View)localObject);
    localObject = findViewById(b.f.location_icon);
    p.j(localObject, "findViewById(R.id.location_icon)");
    this.yUO = ((WeImageView)localObject);
    localObject = findViewById(b.f.location_poi_name);
    p.j(localObject, "findViewById(R.id.location_poi_name)");
    this.yUP = ((TextView)localObject);
    localObject = findViewById(b.f.location_loading_view);
    p.j(localObject, "findViewById(R.id.location_loading_view)");
    this.yUQ = ((View)localObject);
    localObject = findViewById(b.f.location_verifying_icon);
    p.j(localObject, "findViewById(R.id.location_verifying_icon)");
    this.yUR = ((MMProcessBar)localObject);
    localObject = findViewById(b.f.location_verifying_tip);
    p.j(localObject, "findViewById(R.id.location_verifying_tip)");
    this.yUS = ((TextView)localObject);
    localObject = findViewById(b.f.location_normal_view);
    p.j(localObject, "findViewById(R.id.location_normal_view)");
    this.yUT = ((View)localObject);
    setBackgroundResource(b.e.comm_list_item_selector);
    localObject = (View.OnClickListener)new FinderLiveLocationView.a(this);
    View localView = this.contentView;
    if (localView == null) {
      p.bGy("contentView");
    }
    localView.setOnClickListener((View.OnClickListener)localObject);
    AppMethodBeat.o(292129);
  }
  
  public final void NM(int paramInt)
  {
    AppMethodBeat.i(292141);
    Object localObject = this.yUR;
    if (localObject == null) {
      p.bGy("locationLoadingProBar");
    }
    ((MMProcessBar)localObject).mO(paramInt, this.yUX);
    localObject = this.yUS;
    if (localObject == null) {
      p.bGy("locationLoadingTip");
    }
    ((TextView)localObject).setTextColor(this.yUY);
    AppMethodBeat.o(292141);
  }
  
  public final void dFc()
  {
    AppMethodBeat.i(292130);
    View localView = this.yUT;
    if (localView == null) {
      p.bGy("locationNormalView");
    }
    localView.setVisibility(8);
    localView = this.yUQ;
    if (localView == null) {
      p.bGy("locationLoadingView");
    }
    localView.setVisibility(0);
    AppMethodBeat.o(292130);
  }
  
  public final void dFd()
  {
    AppMethodBeat.i(292133);
    Object localObject = this.yUT;
    if (localObject == null) {
      p.bGy("locationNormalView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.yUQ;
    if (localObject == null) {
      p.bGy("locationLoadingView");
    }
    ((View)localObject).setVisibility(8);
    setLocationName(getContext().getString(b.j.finder_live_poi_default));
    localObject = this.yUO;
    if (localObject == null) {
      p.bGy("locationIv");
    }
    ((WeImageView)localObject).setIconColor(this.yUV);
    localObject = this.yUP;
    if (localObject == null) {
      p.bGy("locationTv");
    }
    ((TextView)localObject).setTextColor(this.yUW);
    setLocationIcon(b.i.icons_filled_location);
    AppMethodBeat.o(292133);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(292126);
    View localView = this.contentView;
    if (localView == null) {
      p.bGy("contentView");
    }
    AppMethodBeat.o(292126);
    return localView;
  }
  
  public final d getGetLocation()
  {
    return this.yUU;
  }
  
  public final float getLatitude()
  {
    return this.latitude;
  }
  
  public final Location getLocation()
  {
    AppMethodBeat.i(292140);
    Location localLocation = new Location(this.latitude, this.longitude);
    AppMethodBeat.o(292140);
    return localLocation;
  }
  
  public final WeImageView getLocationIv()
  {
    AppMethodBeat.i(292114);
    WeImageView localWeImageView = this.yUO;
    if (localWeImageView == null) {
      p.bGy("locationIv");
    }
    AppMethodBeat.o(292114);
    return localWeImageView;
  }
  
  public final com.tencent.mm.modelgeo.b.a getLocationListener()
  {
    return this.yVa;
  }
  
  public final MMProcessBar getLocationLoadingProBar()
  {
    AppMethodBeat.i(292120);
    MMProcessBar localMMProcessBar = this.yUR;
    if (localMMProcessBar == null) {
      p.bGy("locationLoadingProBar");
    }
    AppMethodBeat.o(292120);
    return localMMProcessBar;
  }
  
  public final TextView getLocationLoadingTip()
  {
    AppMethodBeat.i(292122);
    TextView localTextView = this.yUS;
    if (localTextView == null) {
      p.bGy("locationLoadingTip");
    }
    AppMethodBeat.o(292122);
    return localTextView;
  }
  
  public final View getLocationLoadingView()
  {
    AppMethodBeat.i(292118);
    View localView = this.yUQ;
    if (localView == null) {
      p.bGy("locationLoadingView");
    }
    AppMethodBeat.o(292118);
    return localView;
  }
  
  public final View getLocationNormalView()
  {
    AppMethodBeat.i(292124);
    View localView = this.yUT;
    if (localView == null) {
      p.bGy("locationNormalView");
    }
    AppMethodBeat.o(292124);
    return localView;
  }
  
  public final TextView getLocationTv()
  {
    AppMethodBeat.i(292116);
    TextView localTextView = this.yUP;
    if (localTextView == null) {
      p.bGy("locationTv");
    }
    AppMethodBeat.o(292116);
    return localTextView;
  }
  
  public final float getLongitude()
  {
    return this.longitude;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void hd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292132);
    View localView = this.yUT;
    if (localView == null) {
      p.bGy("locationNormalView");
    }
    localView.setVisibility(0);
    localView = this.yUQ;
    if (localView == null) {
      p.bGy("locationLoadingView");
    }
    localView.setVisibility(8);
    if (!Util.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(this.textColor);
      setLocationIcon(b.i.icons_filled_location);
      setLocationIconColor(this.iconColor);
      AppMethodBeat.o(292132);
      return;
      setLocationName(paramString1);
    }
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(292134);
    super.onAttachedToWindow();
    this.yUU.a(this.yVa);
    AppMethodBeat.o(292134);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(292135);
    super.onDetachedFromWindow();
    this.yUU.b(this.yVa);
    AppMethodBeat.o(292135);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(292127);
    p.k(paramView, "<set-?>");
    this.contentView = paramView;
    AppMethodBeat.o(292127);
  }
  
  public final void setDefaultLoadingPBarColor(int paramInt)
  {
    this.yUX = paramInt;
  }
  
  public final void setDefaultLoadingTipColor(int paramInt)
  {
    this.yUY = paramInt;
  }
  
  public final void setDefaultStateIconColor(int paramInt)
  {
    this.yUV = paramInt;
  }
  
  public final void setDefaultStateTextColor(int paramInt)
  {
    this.yUW = paramInt;
  }
  
  public final void setGetLocation(d paramd)
  {
    this.yUU = paramd;
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
    AppMethodBeat.i(292138);
    WeImageView localWeImageView = this.yUO;
    if (localWeImageView == null) {
      p.bGy("locationIv");
    }
    localWeImageView.setImageResource(paramInt);
    AppMethodBeat.o(292138);
  }
  
  public final void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(292137);
    WeImageView localWeImageView = this.yUO;
    if (localWeImageView == null) {
      p.bGy("locationIv");
    }
    localWeImageView.setIconColor(paramInt);
    AppMethodBeat.o(292137);
  }
  
  public final void setLocationIv(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(292115);
    p.k(paramWeImageView, "<set-?>");
    this.yUO = paramWeImageView;
    AppMethodBeat.o(292115);
  }
  
  public final void setLocationLoadingProBar(MMProcessBar paramMMProcessBar)
  {
    AppMethodBeat.i(292121);
    p.k(paramMMProcessBar, "<set-?>");
    this.yUR = paramMMProcessBar;
    AppMethodBeat.o(292121);
  }
  
  public final void setLocationLoadingTip(TextView paramTextView)
  {
    AppMethodBeat.i(292123);
    p.k(paramTextView, "<set-?>");
    this.yUS = paramTextView;
    AppMethodBeat.o(292123);
  }
  
  public final void setLocationLoadingView(View paramView)
  {
    AppMethodBeat.i(292119);
    p.k(paramView, "<set-?>");
    this.yUQ = paramView;
    AppMethodBeat.o(292119);
  }
  
  public final void setLocationName(String paramString)
  {
    AppMethodBeat.i(292136);
    TextView localTextView = this.yUP;
    if (localTextView == null) {
      p.bGy("locationTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(292136);
  }
  
  public final void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(292139);
    TextView localTextView = this.yUP;
    if (localTextView == null) {
      p.bGy("locationTv");
    }
    localTextView.setTextColor(paramInt);
    AppMethodBeat.o(292139);
  }
  
  public final void setLocationNormalView(View paramView)
  {
    AppMethodBeat.i(292125);
    p.k(paramView, "<set-?>");
    this.yUT = paramView;
    AppMethodBeat.o(292125);
  }
  
  public final void setLocationTipColor(int paramInt) {}
  
  public final void setLocationTv(TextView paramTextView)
  {
    AppMethodBeat.i(292117);
    p.k(paramTextView, "<set-?>");
    this.yUP = paramTextView;
    AppMethodBeat.o(292117);
  }
  
  public final void setLongitude(float paramFloat)
  {
    this.longitude = paramFloat;
  }
  
  public final void setOnClickLocationListener(com.tencent.mm.pluginsdk.location.b.a parama)
  {
    this.yUZ = parama;
  }
  
  public final void setSuggestView(String paramString)
  {
    AppMethodBeat.i(292131);
    View localView = this.yUT;
    if (localView == null) {
      p.bGy("locationNormalView");
    }
    localView.setVisibility(0);
    localView = this.yUQ;
    if (localView == null) {
      p.bGy("locationLoadingView");
    }
    localView.setVisibility(8);
    setLocationName(paramString);
    setLocationNameColor(this.textColor);
    setLocationIcon(b.i.icons_filled_location);
    setLocationIconColor(this.iconColor);
    AppMethodBeat.o(292131);
  }
  
  public final void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
  static final class b
    implements com.tencent.mm.modelgeo.b.a
  {
    b(FinderLiveLocationView paramFinderLiveLocationView) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(279617);
      if (!paramBoolean)
      {
        AppMethodBeat.o(279617);
        return true;
      }
      Log.d(this.yVb.getTAG(), "get location %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
      n.a(2015, paramFloat1, paramFloat2, 0);
      if ((this.yVb.getLatitude() == -85.0F) || (this.yVb.getLongitude() == -1000.0F))
      {
        this.yVb.setLatitude(paramFloat2);
        this.yVb.setLongitude(paramFloat1);
      }
      AppMethodBeat.o(279617);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLocationView
 * JD-Core Version:    0.7.0.1
 */