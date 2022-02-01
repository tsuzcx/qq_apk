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
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int lQN;
  private static int lQO;
  private ImageView jFL;
  private TextView kEu;
  private List<WxaAttributes.WxaEntryInfo> lQH;
  private View lQI;
  private TextView lQJ;
  private LinearLayout lQK;
  private ViewGroup lQL;
  private View lQM;
  
  static
  {
    AppMethodBeat.i(49377);
    lQN = a.fromDPToPix(aj.getContext(), 15);
    lQO = a.fromDPToPix(aj.getContext(), 30);
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
    this.lQH = new LinkedList();
    View localView = View.inflate(getContext(), 2131493032, this);
    this.lQI = localView.findViewById(2131300108);
    this.jFL = ((ImageView)localView.findViewById(2131300882));
    this.kEu = ((TextView)localView.findViewById(2131305906));
    this.lQJ = ((TextView)localView.findViewById(2131298797));
    this.lQM = localView.findViewById(2131302454);
    this.lQK = ((LinearLayout)localView.findViewById(2131298737));
    this.lQL = ((ViewGroup)localView.findViewById(2131301138));
    AppMethodBeat.o(49376);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.lQH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */