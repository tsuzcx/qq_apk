package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.kidswatch.b.d;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchCardLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageLoaderOptionsBuilder", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions$Builder;", "isLogin", "", "kidsAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "radius", "markLastCard", "", "prepareViews", "setData", "updateLoginStatus", "plugin-kidswatch_release"})
public final class KidsWatchCardLayout
  extends LinearLayout
{
  private KidsWatchAcctInfo Ecn;
  private final c.a Eco;
  private HashMap _$_findViewCache;
  boolean isLogin;
  private final int radius;
  
  public KidsWatchCardLayout(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(251906);
    AppMethodBeat.o(251906);
  }
  
  public KidsWatchCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(251904);
    AppMethodBeat.o(251904);
  }
  
  public KidsWatchCardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251902);
    this.radius = aw.fromDPToPix(paramContext, 16);
    this.Eco = new c.a();
    setNestedScrollingEnabled(true);
    View.inflate(paramContext, b.f.Ebf, (ViewGroup)this);
    ((RoundCornerImageView)_$_findCachedViewById(b.e.dsd)).mQ(this.radius, this.radius);
    this.Eco.wy(b.d.default_avatar);
    this.Eco.aw(this.radius).bmJ();
    eKT();
    paramContext = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    paramContext = getContext();
    p.j(paramContext, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a(paramContext, (LinearLayout)_$_findCachedViewById(b.e.Eaw), null);
    AppMethodBeat.o(251902);
  }
  
  private final void eKT()
  {
    AppMethodBeat.i(251900);
    if (this.isLogin)
    {
      localTextView = (TextView)_$_findCachedViewById(b.e.EaR);
      p.j(localTextView, "loginStatusIconTV");
      localTextView.setBackground(com.tencent.mm.ci.a.m(getContext(), b.d.Eas));
      localTextView = (TextView)_$_findCachedViewById(b.e.EaS);
      p.j(localTextView, "loginStatusTV");
      localTextView.setText((CharSequence)getContext().getString(b.h.EbD));
      AppMethodBeat.o(251900);
      return;
    }
    TextView localTextView = (TextView)_$_findCachedViewById(b.e.EaR);
    p.j(localTextView, "loginStatusIconTV");
    localTextView.setBackground(com.tencent.mm.ci.a.m(getContext(), b.d.Ear));
    localTextView = (TextView)_$_findCachedViewById(b.e.EaS);
    p.j(localTextView, "loginStatusTV");
    localTextView.setText((CharSequence)getContext().getString(b.h.Ebw));
    AppMethodBeat.o(251900);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251908);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(251908);
    return localView1;
  }
  
  public final void setData(KidsWatchAcctInfo paramKidsWatchAcctInfo)
  {
    AppMethodBeat.i(251898);
    p.k(paramKidsWatchAcctInfo, "kidsAcctInfo");
    this.Ecn = paramKidsWatchAcctInfo;
    q.bml().a(paramKidsWatchAcctInfo.lqp, (RoundCornerImageView)_$_findCachedViewById(b.e.dsd), this.Eco.bmL());
    TextView localTextView = (TextView)_$_findCachedViewById(b.e.dPq);
    p.j(localTextView, "nicknameTV");
    localTextView.setText((CharSequence)paramKidsWatchAcctInfo.nickName);
    if (paramKidsWatchAcctInfo.EbN == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isLogin = bool;
      localTextView = (TextView)_$_findCachedViewById(b.e.dEj);
      p.j(localTextView, "deviceNameTV");
      localTextView.setText((CharSequence)paramKidsWatchAcctInfo.deviceName);
      eKT();
      AppMethodBeat.o(251898);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchCardLayout
 * JD-Core Version:    0.7.0.1
 */