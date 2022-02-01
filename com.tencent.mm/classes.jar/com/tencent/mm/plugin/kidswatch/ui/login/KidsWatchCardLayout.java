package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.kidswatch.b.d;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchCardLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageLoaderOptionsBuilder", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions$Builder;", "isLogin", "", "kidsAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "radius", "markLastCard", "", "prepareViews", "setData", "updateLoginStatus", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchCardLayout
  extends LinearLayout
{
  private KidsWatchAcctInfo JTr;
  private final c.a JTs;
  boolean isLogin;
  private final int radius;
  
  public KidsWatchCardLayout(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(262199);
    AppMethodBeat.o(262199);
  }
  
  public KidsWatchCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(262191);
    AppMethodBeat.o(262191);
  }
  
  public KidsWatchCardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(262182);
    this.radius = bd.fromDPToPix(paramContext, 16);
    this.JTs = new c.a();
    setNestedScrollingEnabled(true);
    View.inflate(paramContext, b.f.JSn, (ViewGroup)this);
    ((RoundCornerImageView)findViewById(b.e.avatarIV)).oJ(this.radius, this.radius);
    this.JTs.oKB = b.d.default_avatar;
    paramContext = this.JTs;
    paramContext.oKI = this.radius;
    paramContext.nrc = true;
    fSQ();
    paramContext = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    paramContext = getContext();
    s.s(paramContext, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a(paramContext, (LinearLayout)findViewById(b.e.JRE), null);
    AppMethodBeat.o(262182);
  }
  
  private final void fSQ()
  {
    AppMethodBeat.i(262207);
    if (this.isLogin)
    {
      ((TextView)findViewById(b.e.JRZ)).setBackground(com.tencent.mm.cd.a.m(getContext(), b.d.JRA));
      ((TextView)findViewById(b.e.JSa)).setText((CharSequence)getContext().getString(b.h.JSL));
      AppMethodBeat.o(262207);
      return;
    }
    ((TextView)findViewById(b.e.JRZ)).setBackground(com.tencent.mm.cd.a.m(getContext(), b.d.JRz));
    ((TextView)findViewById(b.e.JSa)).setText((CharSequence)getContext().getString(b.h.JSE));
    AppMethodBeat.o(262207);
  }
  
  public final void setData(KidsWatchAcctInfo paramKidsWatchAcctInfo)
  {
    AppMethodBeat.i(262218);
    s.u(paramKidsWatchAcctInfo, "kidsAcctInfo");
    this.JTr = paramKidsWatchAcctInfo;
    r.bKe().a(paramKidsWatchAcctInfo.nVs, (ImageView)findViewById(b.e.avatarIV), this.JTs.bKx());
    ((TextView)findViewById(b.e.nicknameTV)).setText((CharSequence)paramKidsWatchAcctInfo.nickName);
    if (paramKidsWatchAcctInfo.JSV == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isLogin = bool;
      ((TextView)findViewById(b.e.fFc)).setText((CharSequence)paramKidsWatchAcctInfo.deviceName);
      fSQ();
      AppMethodBeat.o(262218);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchCardLayout
 * JD-Core Version:    0.7.0.1
 */