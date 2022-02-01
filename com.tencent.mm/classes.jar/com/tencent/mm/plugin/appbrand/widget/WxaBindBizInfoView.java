package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int uyg;
  private static int uyh;
  private ImageView rIe;
  private TextView sUt;
  private List<WxaAttributes.WxaEntryInfo> uya;
  private View uyb;
  private TextView uyc;
  private LinearLayout uyd;
  private ViewGroup uye;
  private View uyf;
  
  static
  {
    AppMethodBeat.i(49377);
    uyg = a.fromDPToPix(MMApplicationContext.getContext(), 15);
    uyh = a.fromDPToPix(MMApplicationContext.getContext(), 30);
    AppMethodBeat.o(49377);
  }
  
  public WxaBindBizInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49375);
    init();
    AppMethodBeat.o(49375);
  }
  
  public WxaBindBizInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49374);
    init();
    AppMethodBeat.o(49374);
  }
  
  private void init()
  {
    AppMethodBeat.i(49376);
    this.uya = new LinkedList();
    View localView = View.inflate(getContext(), ba.g.app_brand_profile_wxa_bind_biz_info_item, this);
    this.uyb = localView.findViewById(ba.f.firstItemV);
    this.rIe = ((ImageView)localView.findViewById(ba.f.iconIv));
    this.sUt = ((TextView)localView.findViewById(ba.f.titleTv));
    this.uyc = ((TextView)localView.findViewById(ba.f.countTv));
    this.uyf = localView.findViewById(ba.f.moreV);
    this.uyd = ((LinearLayout)localView.findViewById(ba.f.containerV));
    this.uye = ((ViewGroup)localView.findViewById(ba.f.itemContainerV));
    AppMethodBeat.o(49376);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.uya;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */