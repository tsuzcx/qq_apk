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
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.location.Location;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLocationView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickLocationListener", "Lcom/tencent/mm/pluginsdk/location/ILocationView$OnClickLocationListener;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "defaultLoadingPBarColor", "defaultLoadingTipColor", "defaultStateIconColor", "defaultStateTextColor", "getLocation", "Lcom/tencent/mm/modelgeo/LocationGeo;", "kotlin.jvm.PlatformType", "getGetLocation", "()Lcom/tencent/mm/modelgeo/LocationGeo;", "setGetLocation", "(Lcom/tencent/mm/modelgeo/LocationGeo;)V", "iconColor", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLocationIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLocationIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "locationListener", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getLocationListener", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "locationLoadingProBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getLocationLoadingProBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "setLocationLoadingProBar", "(Lcom/tencent/mm/ui/widget/MMProcessBar;)V", "locationLoadingTip", "Landroid/widget/TextView;", "getLocationLoadingTip", "()Landroid/widget/TextView;", "setLocationLoadingTip", "(Landroid/widget/TextView;)V", "locationLoadingView", "getLocationLoadingView", "setLocationLoadingView", "locationNormalView", "getLocationNormalView", "setLocationNormalView", "locationTipTv", "getLocationTipTv", "setLocationTipTv", "locationTv", "getLocationTv", "setLocationTv", "longitude", "getLongitude", "setLongitude", "textColor", "GDPRLocationConfirm", "", "doClickAfterPermission", "Lcom/tencent/mm/pluginsdk/location/Location;", "init", "onAttachedToWindow", "onDetachedFromWindow", "resetLocationColor", "setDefaultLoadingPBarColor", "setDefaultLoadingTipColor", "setDefaultState", "setDefaultStateIconColor", "setDefaultStateTextColor", "setIconColor", "setLoadingState", "setLocationIcon", "resId", "setLocationIconColor", "setLocationName", "locationName", "setLocationNameColor", "setLocationTipColor", "color", "setNormalState", "city", "poiName", "setOnClickLocationListener", "onClickLocationListener", "setSuggestView", "setTextColor", "updateLoadingView", "id", "plugin-finder_release"})
public final class FinderLiveLocationView
  extends LinearLayout
  implements b
{
  private final String TAG;
  public View contentView;
  private float dTj;
  private float latitude;
  private int textColor;
  public WeImageView uzl;
  public TextView uzm;
  public TextView uzn;
  public View uzo;
  public MMProcessBar uzp;
  public TextView uzq;
  public View uzr;
  private d uzs;
  private int uzt;
  private int uzu;
  private int uzv;
  private int uzw;
  private int uzx;
  com.tencent.mm.pluginsdk.location.b.a uzy;
  private final com.tencent.mm.modelgeo.b.a uzz;
  
  public FinderLiveLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247523);
    this.TAG = "Finder.FinderLiveLocationView";
    this.uzs = d.bca();
    this.latitude = -85.0F;
    this.dTj = -1000.0F;
    this.uzz = ((com.tencent.mm.modelgeo.b.a)new b(this));
    init();
    AppMethodBeat.o(247523);
  }
  
  public FinderLiveLocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247524);
    this.TAG = "Finder.FinderLiveLocationView";
    this.uzs = d.bca();
    this.latitude = -85.0F;
    this.dTj = -1000.0F;
    this.uzz = ((com.tencent.mm.modelgeo.b.a)new b(this));
    init();
    AppMethodBeat.o(247524);
  }
  
  private void init()
  {
    AppMethodBeat.i(247509);
    Object localObject = View.inflate(getContext(), 2131494421, (ViewGroup)this);
    p.g(localObject, "View.inflate(context, R.…_location_geo_view, this)");
    this.contentView = ((View)localObject);
    localObject = findViewById(2131303730);
    p.g(localObject, "findViewById(R.id.location_icon)");
    this.uzl = ((WeImageView)localObject);
    localObject = findViewById(2131303745);
    p.g(localObject, "findViewById(R.id.location_poi_name)");
    this.uzm = ((TextView)localObject);
    localObject = findViewById(2131303746);
    p.g(localObject, "findViewById(R.id.location_poi_tip_tv)");
    this.uzn = ((TextView)localObject);
    localObject = findViewById(2131303739);
    p.g(localObject, "findViewById(R.id.location_loading_view)");
    this.uzo = ((View)localObject);
    localObject = findViewById(2131303757);
    p.g(localObject, "findViewById(R.id.location_verifying_icon)");
    this.uzp = ((MMProcessBar)localObject);
    localObject = findViewById(2131303758);
    p.g(localObject, "findViewById(R.id.location_verifying_tip)");
    this.uzq = ((TextView)localObject);
    localObject = findViewById(2131303743);
    p.g(localObject, "findViewById(R.id.location_normal_view)");
    this.uzr = ((View)localObject);
    setBackgroundResource(2131231898);
    localObject = (View.OnClickListener)new FinderLiveLocationView.a(this);
    View localView = this.contentView;
    if (localView == null) {
      p.btv("contentView");
    }
    localView.setOnClickListener((View.OnClickListener)localObject);
    AppMethodBeat.o(247509);
  }
  
  public final void dix()
  {
    AppMethodBeat.i(247510);
    View localView = this.uzr;
    if (localView == null) {
      p.btv("locationNormalView");
    }
    localView.setVisibility(8);
    localView = this.uzo;
    if (localView == null) {
      p.btv("locationLoadingView");
    }
    localView.setVisibility(0);
    AppMethodBeat.o(247510);
  }
  
  public final void diy()
  {
    AppMethodBeat.i(247513);
    Object localObject = this.uzr;
    if (localObject == null) {
      p.btv("locationNormalView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.uzo;
    if (localObject == null) {
      p.btv("locationLoadingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.uzn;
    if (localObject == null) {
      p.btv("locationTipTv");
    }
    ((TextView)localObject).setVisibility(8);
    setLocationName(getContext().getString(2131762453));
    localObject = this.uzl;
    if (localObject == null) {
      p.btv("locationIv");
    }
    ((WeImageView)localObject).setIconColor(this.uzu);
    localObject = this.uzm;
    if (localObject == null) {
      p.btv("locationTv");
    }
    ((TextView)localObject).setTextColor(this.uzv);
    setLocationIcon(2131690826);
    AppMethodBeat.o(247513);
  }
  
  public final void diz()
  {
    AppMethodBeat.i(247522);
    Object localObject = this.uzp;
    if (localObject == null) {
      p.btv("locationLoadingProBar");
    }
    ((MMProcessBar)localObject).setBackground$255f295(this.uzw);
    localObject = this.uzq;
    if (localObject == null) {
      p.btv("locationLoadingTip");
    }
    ((TextView)localObject).setTextColor(this.uzx);
    AppMethodBeat.o(247522);
  }
  
  public final void gM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247512);
    Object localObject = this.uzr;
    if (localObject == null) {
      p.btv("locationNormalView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.uzo;
    if (localObject == null) {
      p.btv("locationLoadingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.uzn;
    if (localObject == null) {
      p.btv("locationTipTv");
    }
    ((TextView)localObject).setVisibility(8);
    if (!Util.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(this.textColor);
      setLocationIcon(2131690589);
      setLocationIconColor(this.uzt);
      AppMethodBeat.o(247512);
      return;
      setLocationName(paramString1);
    }
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(247507);
    View localView = this.contentView;
    if (localView == null) {
      p.btv("contentView");
    }
    AppMethodBeat.o(247507);
    return localView;
  }
  
  public final d getGetLocation()
  {
    return this.uzs;
  }
  
  public final float getLatitude()
  {
    return this.latitude;
  }
  
  public final Location getLocation()
  {
    AppMethodBeat.i(247520);
    Location localLocation = new Location(this.latitude, this.dTj);
    AppMethodBeat.o(247520);
    return localLocation;
  }
  
  public final WeImageView getLocationIv()
  {
    AppMethodBeat.i(247493);
    WeImageView localWeImageView = this.uzl;
    if (localWeImageView == null) {
      p.btv("locationIv");
    }
    AppMethodBeat.o(247493);
    return localWeImageView;
  }
  
  public final com.tencent.mm.modelgeo.b.a getLocationListener()
  {
    return this.uzz;
  }
  
  public final MMProcessBar getLocationLoadingProBar()
  {
    AppMethodBeat.i(247501);
    MMProcessBar localMMProcessBar = this.uzp;
    if (localMMProcessBar == null) {
      p.btv("locationLoadingProBar");
    }
    AppMethodBeat.o(247501);
    return localMMProcessBar;
  }
  
  public final TextView getLocationLoadingTip()
  {
    AppMethodBeat.i(247503);
    TextView localTextView = this.uzq;
    if (localTextView == null) {
      p.btv("locationLoadingTip");
    }
    AppMethodBeat.o(247503);
    return localTextView;
  }
  
  public final View getLocationLoadingView()
  {
    AppMethodBeat.i(247499);
    View localView = this.uzo;
    if (localView == null) {
      p.btv("locationLoadingView");
    }
    AppMethodBeat.o(247499);
    return localView;
  }
  
  public final View getLocationNormalView()
  {
    AppMethodBeat.i(247505);
    View localView = this.uzr;
    if (localView == null) {
      p.btv("locationNormalView");
    }
    AppMethodBeat.o(247505);
    return localView;
  }
  
  public final TextView getLocationTipTv()
  {
    AppMethodBeat.i(247497);
    TextView localTextView = this.uzn;
    if (localTextView == null) {
      p.btv("locationTipTv");
    }
    AppMethodBeat.o(247497);
    return localTextView;
  }
  
  public final TextView getLocationTv()
  {
    AppMethodBeat.i(247495);
    TextView localTextView = this.uzm;
    if (localTextView == null) {
      p.btv("locationTv");
    }
    AppMethodBeat.o(247495);
    return localTextView;
  }
  
  public final float getLongitude()
  {
    return this.dTj;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(247514);
    super.onAttachedToWindow();
    this.uzs.b(this.uzz);
    AppMethodBeat.o(247514);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(247515);
    super.onDetachedFromWindow();
    this.uzs.c(this.uzz);
    AppMethodBeat.o(247515);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(247508);
    p.h(paramView, "<set-?>");
    this.contentView = paramView;
    AppMethodBeat.o(247508);
  }
  
  public final void setDefaultLoadingPBarColor(int paramInt)
  {
    this.uzw = paramInt;
  }
  
  public final void setDefaultLoadingTipColor(int paramInt)
  {
    this.uzx = paramInt;
  }
  
  public final void setDefaultStateIconColor(int paramInt)
  {
    this.uzu = paramInt;
  }
  
  public final void setDefaultStateTextColor(int paramInt)
  {
    this.uzv = paramInt;
  }
  
  public final void setGetLocation(d paramd)
  {
    this.uzs = paramd;
  }
  
  public final void setIconColor(int paramInt)
  {
    this.uzt = paramInt;
  }
  
  public final void setLatitude(float paramFloat)
  {
    this.latitude = paramFloat;
  }
  
  public final void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(247518);
    WeImageView localWeImageView = this.uzl;
    if (localWeImageView == null) {
      p.btv("locationIv");
    }
    localWeImageView.setImageResource(paramInt);
    AppMethodBeat.o(247518);
  }
  
  public final void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(247517);
    WeImageView localWeImageView = this.uzl;
    if (localWeImageView == null) {
      p.btv("locationIv");
    }
    localWeImageView.setIconColor(paramInt);
    AppMethodBeat.o(247517);
  }
  
  public final void setLocationIv(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(247494);
    p.h(paramWeImageView, "<set-?>");
    this.uzl = paramWeImageView;
    AppMethodBeat.o(247494);
  }
  
  public final void setLocationLoadingProBar(MMProcessBar paramMMProcessBar)
  {
    AppMethodBeat.i(247502);
    p.h(paramMMProcessBar, "<set-?>");
    this.uzp = paramMMProcessBar;
    AppMethodBeat.o(247502);
  }
  
  public final void setLocationLoadingTip(TextView paramTextView)
  {
    AppMethodBeat.i(247504);
    p.h(paramTextView, "<set-?>");
    this.uzq = paramTextView;
    AppMethodBeat.o(247504);
  }
  
  public final void setLocationLoadingView(View paramView)
  {
    AppMethodBeat.i(247500);
    p.h(paramView, "<set-?>");
    this.uzo = paramView;
    AppMethodBeat.o(247500);
  }
  
  public final void setLocationName(String paramString)
  {
    AppMethodBeat.i(247516);
    TextView localTextView = this.uzm;
    if (localTextView == null) {
      p.btv("locationTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(247516);
  }
  
  public final void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(247519);
    TextView localTextView = this.uzm;
    if (localTextView == null) {
      p.btv("locationTv");
    }
    localTextView.setTextColor(paramInt);
    AppMethodBeat.o(247519);
  }
  
  public final void setLocationNormalView(View paramView)
  {
    AppMethodBeat.i(247506);
    p.h(paramView, "<set-?>");
    this.uzr = paramView;
    AppMethodBeat.o(247506);
  }
  
  public final void setLocationTipColor(int paramInt)
  {
    AppMethodBeat.i(247521);
    TextView localTextView = this.uzn;
    if (localTextView == null) {
      p.btv("locationTipTv");
    }
    localTextView.setTextColor(paramInt);
    AppMethodBeat.o(247521);
  }
  
  public final void setLocationTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(247498);
    p.h(paramTextView, "<set-?>");
    this.uzn = paramTextView;
    AppMethodBeat.o(247498);
  }
  
  public final void setLocationTv(TextView paramTextView)
  {
    AppMethodBeat.i(247496);
    p.h(paramTextView, "<set-?>");
    this.uzm = paramTextView;
    AppMethodBeat.o(247496);
  }
  
  public final void setLongitude(float paramFloat)
  {
    this.dTj = paramFloat;
  }
  
  public final void setOnClickLocationListener(com.tencent.mm.pluginsdk.location.b.a parama)
  {
    this.uzy = parama;
  }
  
  public final void setSuggestView(String paramString)
  {
    AppMethodBeat.i(247511);
    Object localObject = this.uzr;
    if (localObject == null) {
      p.btv("locationNormalView");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.uzo;
    if (localObject == null) {
      p.btv("locationLoadingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.uzn;
    if (localObject == null) {
      p.btv("locationTipTv");
    }
    ((TextView)localObject).setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(this.textColor);
    setLocationIcon(2131690589);
    setLocationIconColor(this.uzt);
    AppMethodBeat.o(247511);
  }
  
  public final void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
  static final class b
    implements com.tencent.mm.modelgeo.b.a
  {
    b(FinderLiveLocationView paramFinderLiveLocationView) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(247492);
      if (!paramBoolean)
      {
        AppMethodBeat.o(247492);
        return true;
      }
      Log.d(this.uzA.getTAG(), "get location %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
      o.a(2015, paramFloat1, paramFloat2, 0);
      if ((this.uzA.getLatitude() == -85.0F) || (this.uzA.getLongitude() == -1000.0F))
      {
        this.uzA.setLatitude(paramFloat2);
        this.uzA.setLongitude(paramFloat1);
      }
      AppMethodBeat.o(247492);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLocationView
 * JD-Core Version:    0.7.0.1
 */