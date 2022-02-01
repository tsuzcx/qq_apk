package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.graphics.Paint;
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
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.widget.recent.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class d
  extends RecyclerView.v
{
  public ImageView qps;
  public RelativeLayout rqh;
  public ImageView rqi;
  public ViewGroup rqj;
  public TextView rqk;
  public ImageView rql;
  public ImageView rqm;
  public AppBrandDesktopView.a rqn;
  public TextView titleTv;
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49643);
    this.rqh = ((RelativeLayout)paramView.findViewById(au.f.icon_container));
    this.qps = ((ImageView)paramView.findViewById(au.f.icon));
    this.rqi = ((ImageView)paramView.findViewById(au.f.icon_bg));
    this.rqj = ((ViewGroup)paramView.findViewById(au.f.icon_layout));
    this.titleTv = ((TextView)paramView.findViewById(au.f.title));
    this.rqk = ((TextView)paramView.findViewById(au.f.test_mask));
    this.rql = ((ImageView)paramView.findViewById(au.f.status_icon));
    this.rqm = ((ImageView)paramView.findViewById(au.f.image_mask));
    AppMethodBeat.o(49643);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(278086);
    cnC();
    this.qps.setColorFilter(null);
    this.amk.setVisibility(0);
    this.titleTv.setVisibility(0);
    if (this.rqn.rqa == null)
    {
      com.tencent.mm.modelappbrand.a.b.bhh().a(this.qps, "", com.tencent.mm.modelappbrand.a.a.bhg(), g.lzF);
      this.rqk.setVisibility(8);
      this.titleTv.setText("");
      Log.e("MicroMsg.AppBrandItemHolder", "item info is null!");
      AppMethodBeat.o(278086);
      return;
    }
    if (!Util.isNullOrNil(this.rqn.rqa.cxg))
    {
      this.titleTv.setText(this.rqn.rqa.cxg);
      this.titleTv.setVisibility(0);
      Log.i("MicroMsg.AppBrandItemHolder", "ccf-log [onBindViewHolder] name=%s iconUrl=%s", new Object[] { this.rqn.rqa.nickname, this.rqn.rqa.nQm });
      if (Util.isNullOrNil(this.rqn.rqa.nQm)) {
        break label474;
      }
      com.tencent.mm.modelappbrand.a.b.bhh().a(this.qps, this.rqn.rqa.nQm, com.tencent.mm.modelappbrand.a.a.bhg(), g.lzF);
      label214:
      this.rqk.setVisibility(8);
      this.rqm.setVisibility(8);
      if (Util.isNullOrNil(e.yZ(this.rqn.rqa.cBU))) {
        break label487;
      }
      this.rqk.setVisibility(0);
      this.rqk.setText(e.yZ(this.rqn.rqa.cBU));
    }
    for (;;)
    {
      this.amk.setTag(au.f.desktop_pop_menu, new com.tencent.mm.ui.widget.b.a(this.amk.getContext(), this.amk));
      this.amk.setOnClickListener(paramOnClickListener);
      this.amk.setHapticFeedbackEnabled(false);
      AppMethodBeat.o(278086);
      return;
      if (!Util.isNullOrNil(this.rqn.rqa.nickname))
      {
        this.titleTv.setText(this.rqn.rqa.nickname);
        this.titleTv.setVisibility(0);
        break;
      }
      if (!Util.isNullOrNil(this.rqn.rqa.username))
      {
        Log.w("MicroMsg.AppBrandItemHolder", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { this.rqn.rqa.username, this.rqn.rqa.appId });
        this.titleTv.setVisibility(0);
        this.titleTv.setText(this.rqn.rqa.username);
        break;
      }
      this.titleTv.setVisibility(0);
      this.titleTv.setText("");
      break;
      label474:
      this.qps.setImageDrawable(com.tencent.mm.modelappbrand.a.a.bhg());
      break label214;
      label487:
      if (this.rqn.rqa.nQp)
      {
        this.rqm.setVisibility(0);
        ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
        localShapeDrawable.getPaint().setColor(com.tencent.mm.plugin.multitask.ui.bg.a.fbG().jCp);
        this.rqm.setBackground(localShapeDrawable);
        this.rqm.setImageResource(au.h.app_brand_destop_view_third_party_running_flag);
      }
    }
  }
  
  public final void cnC()
  {
    AppMethodBeat.i(278088);
    int i = (int)f.ey(this.amk.getContext());
    this.amk.getLayoutParams().width = b.ex(this.amk.getContext());
    this.rqh.getLayoutParams().width = i;
    this.rqh.getLayoutParams().height = i;
    this.qps.getLayoutParams().width = -1;
    this.qps.getLayoutParams().height = -1;
    AppMethodBeat.o(278088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */