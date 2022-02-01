package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.widget.recent.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class d
  extends RecyclerView.v
{
  public TextView titleTv;
  public ImageView ttT;
  public RelativeLayout uAs;
  public ImageView uAt;
  public ViewGroup uAu;
  public TextView uAv;
  public ImageView uAw;
  public ImageView uAx;
  public AppBrandDesktopView.a uAy;
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49643);
    this.uAs = ((RelativeLayout)paramView.findViewById(ba.f.icon_container));
    this.ttT = ((ImageView)paramView.findViewById(ba.f.icon));
    this.uAt = ((ImageView)paramView.findViewById(ba.f.icon_bg));
    this.uAu = ((ViewGroup)paramView.findViewById(ba.f.icon_layout));
    this.titleTv = ((TextView)paramView.findViewById(ba.f.title));
    this.uAv = ((TextView)paramView.findViewById(ba.f.test_mask));
    this.uAw = ((ImageView)paramView.findViewById(ba.f.status_icon));
    this.uAx = ((ImageView)paramView.findViewById(ba.f.image_mask));
    AppMethodBeat.o(49643);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(324201);
    cPF();
    this.ttT.setColorFilter(null);
    this.caK.setVisibility(0);
    this.titleTv.setVisibility(0);
    if (this.uAy.uAl == null)
    {
      com.tencent.mm.modelappbrand.a.b.bEY().a(this.ttT, "", com.tencent.mm.modelappbrand.a.a.bEX(), g.org);
      this.uAv.setVisibility(8);
      this.titleTv.setText("");
      Log.e("MicroMsg.AppBrandItemHolder", "item info is null!");
      AppMethodBeat.o(324201);
      return;
    }
    label214:
    Object localObject;
    label279:
    String str;
    if (!Util.isNullOrNil(this.uAy.uAl.epy))
    {
      this.titleTv.setText(this.uAy.uAl.epy);
      this.titleTv.setVisibility(0);
      Log.i("MicroMsg.AppBrandItemHolder", "ccf-log [onBindViewHolder] name=%s iconUrl=%s", new Object[] { this.uAy.uAl.nickname, this.uAy.uAl.qQb });
      if (Util.isNullOrNil(this.uAy.uAl.qQb)) {
        break label536;
      }
      com.tencent.mm.modelappbrand.a.b.bEY().a(this.ttT, this.uAy.uAl.qQb, com.tencent.mm.modelappbrand.a.a.bEX(), g.org);
      this.uAv.setVisibility(8);
      this.uAx.setVisibility(8);
      if (Util.isNullOrNil(e.zm(this.uAy.uAl.euz))) {
        break label549;
      }
      this.uAv.setVisibility(0);
      this.uAv.setText(e.zm(this.uAy.uAl.euz));
      this.caK.setTag(ba.f.desktop_pop_menu, new com.tencent.mm.ui.widget.b.a(this.caK.getContext(), this.caK));
      this.caK.setOnClickListener(paramOnClickListener);
      this.caK.setHapticFeedbackEnabled(false);
      localObject = this.caK;
      str = this.titleTv.getText().toString();
      if (this.uAv.getVisibility() != 0) {
        break label619;
      }
    }
    label536:
    label549:
    label619:
    for (paramOnClickListener = this.uAv.getText().toString();; paramOnClickListener = "")
    {
      ((View)localObject).setContentDescription(String.format("%s,%s", new Object[] { str, paramOnClickListener }));
      AppMethodBeat.o(324201);
      return;
      if (!Util.isNullOrNil(this.uAy.uAl.nickname))
      {
        this.titleTv.setText(this.uAy.uAl.nickname);
        this.titleTv.setVisibility(0);
        break;
      }
      if (!Util.isNullOrNil(this.uAy.uAl.username))
      {
        Log.w("MicroMsg.AppBrandItemHolder", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { this.uAy.uAl.username, this.uAy.uAl.appId });
        this.titleTv.setVisibility(0);
        this.titleTv.setText(this.uAy.uAl.username);
        break;
      }
      this.titleTv.setVisibility(0);
      this.titleTv.setText("");
      break;
      this.ttT.setImageDrawable(com.tencent.mm.modelappbrand.a.a.bEX());
      break label214;
      if (!this.uAy.uAl.qQe) {
        break label279;
      }
      this.uAx.setVisibility(0);
      localObject = new ShapeDrawable(new OvalShape());
      ((ShapeDrawable)localObject).getPaint().setColor(com.tencent.mm.plugin.multitask.ui.bg.a.gkK().mcd);
      this.uAx.setBackground((Drawable)localObject);
      this.uAx.setImageResource(ba.h.app_brand_destop_view_third_party_running_flag);
      break label279;
    }
  }
  
  public final void cPF()
  {
    AppMethodBeat.i(324206);
    int i = (int)f.fu(this.caK.getContext());
    this.caK.getLayoutParams().width = b.ft(this.caK.getContext());
    this.uAs.getLayoutParams().width = i;
    this.uAs.getLayoutParams().height = i;
    this.ttT.getLayoutParams().width = -1;
    this.ttT.getLayoutParams().height = -1;
    AppMethodBeat.o(324206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */