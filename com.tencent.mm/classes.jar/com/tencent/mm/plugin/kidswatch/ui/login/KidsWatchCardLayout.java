package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchCardLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageLoaderOptionsBuilder", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions$Builder;", "isLogin", "", "kidsAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "radius", "markLastCard", "", "prepareViews", "setData", "updateLoginStatus", "plugin-kidswatch_release"})
public final class KidsWatchCardLayout
  extends LinearLayout
{
  private HashMap _$_findViewCache;
  private final int radius;
  boolean sPq;
  private KidsWatchAcctInfo yAY;
  private final c.a yAZ;
  
  public KidsWatchCardLayout(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(256210);
    AppMethodBeat.o(256210);
  }
  
  public KidsWatchCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(256209);
    AppMethodBeat.o(256209);
  }
  
  public KidsWatchCardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(256208);
    this.radius = at.fromDPToPix(paramContext, 16);
    this.yAZ = new c.a();
    setNestedScrollingEnabled(true);
    View.inflate(paramContext, 2131495129, (ViewGroup)this);
    ((RoundCornerImageView)_$_findCachedViewById(2131297120)).ly(this.radius, this.radius);
    this.yAZ.ty(2131231957);
    this.yAZ.aw(this.radius).bdt();
    ebV();
    paramContext = com.tencent.mm.plugin.kidswatch.b.a.yBL;
    paramContext = getContext();
    p.g(paramContext, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a(paramContext, (LinearLayout)_$_findCachedViewById(2131298011), null);
    AppMethodBeat.o(256208);
  }
  
  private final void ebV()
  {
    AppMethodBeat.i(256207);
    if (this.sPq)
    {
      localTextView = (TextView)_$_findCachedViewById(2131303772);
      p.g(localTextView, "loginStatusIconTV");
      localTextView.setBackground(com.tencent.mm.cb.a.l(getContext(), 2131233215));
      localTextView = (TextView)_$_findCachedViewById(2131303773);
      p.g(localTextView, "loginStatusTV");
      localTextView.setText((CharSequence)getContext().getString(2131762085));
      AppMethodBeat.o(256207);
      return;
    }
    TextView localTextView = (TextView)_$_findCachedViewById(2131303772);
    p.g(localTextView, "loginStatusIconTV");
    localTextView.setBackground(com.tencent.mm.cb.a.l(getContext(), 2131233209));
    localTextView = (TextView)_$_findCachedViewById(2131303773);
    p.g(localTextView, "loginStatusTV");
    localTextView.setText((CharSequence)getContext().getString(2131762066));
    AppMethodBeat.o(256207);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256211);
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
    AppMethodBeat.o(256211);
    return localView1;
  }
  
  public final void setData(KidsWatchAcctInfo paramKidsWatchAcctInfo)
  {
    AppMethodBeat.i(256206);
    p.h(paramKidsWatchAcctInfo, "kidsAcctInfo");
    this.yAY = paramKidsWatchAcctInfo;
    q.bcV().a(paramKidsWatchAcctInfo.iAR, (RoundCornerImageView)_$_findCachedViewById(2131297120), this.yAZ.bdv());
    TextView localTextView = (TextView)_$_findCachedViewById(2131305437);
    p.g(localTextView, "nicknameTV");
    localTextView.setText((CharSequence)paramKidsWatchAcctInfo.nickName);
    if (paramKidsWatchAcctInfo.yAy == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.sPq = bool;
      localTextView = (TextView)_$_findCachedViewById(2131299574);
      p.g(localTextView, "deviceNameTV");
      localTextView.setText((CharSequence)paramKidsWatchAcctInfo.deviceName);
      ebV();
      AppMethodBeat.o(256206);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchCardLayout
 * JD-Core Version:    0.7.0.1
 */