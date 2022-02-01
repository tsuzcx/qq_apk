package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int rol;
  private static int rom;
  private ImageView oFa;
  private TextView pPT;
  private List<WxaAttributes.WxaEntryInfo> rof;
  private View rog;
  private TextView roh;
  private LinearLayout roi;
  private ViewGroup roj;
  private View rok;
  
  static
  {
    AppMethodBeat.i(49377);
    rol = a.fromDPToPix(MMApplicationContext.getContext(), 15);
    rom = a.fromDPToPix(MMApplicationContext.getContext(), 30);
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
    this.rof = new LinkedList();
    View localView = View.inflate(getContext(), au.g.app_brand_profile_wxa_bind_biz_info_item, this);
    this.rog = localView.findViewById(au.f.firstItemV);
    this.oFa = ((ImageView)localView.findViewById(au.f.iconIv));
    this.pPT = ((TextView)localView.findViewById(au.f.titleTv));
    this.roh = ((TextView)localView.findViewById(au.f.countTv));
    this.rok = localView.findViewById(au.f.moreV);
    this.roi = ((LinearLayout)localView.findViewById(au.f.containerV));
    this.roj = ((ViewGroup)localView.findViewById(au.f.itemContainerV));
    AppMethodBeat.o(49376);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.rof;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */