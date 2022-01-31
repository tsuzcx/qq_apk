package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int jaT;
  private static int jaU;
  private ImageView iCl;
  private TextView iJG;
  private List<WxaAttributes.WxaEntryInfo> jaN;
  private View jaO;
  private TextView jaP;
  private LinearLayout jaQ;
  private ViewGroup jaR;
  private View jaS;
  
  static
  {
    AppMethodBeat.i(133657);
    jaT = a.fromDPToPix(ah.getContext(), 15);
    jaU = a.fromDPToPix(ah.getContext(), 30);
    AppMethodBeat.o(133657);
  }
  
  public WxaBindBizInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133655);
    init();
    AppMethodBeat.o(133655);
  }
  
  public WxaBindBizInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133654);
    init();
    AppMethodBeat.o(133654);
  }
  
  private void init()
  {
    AppMethodBeat.i(133656);
    this.jaN = new LinkedList();
    View localView = View.inflate(getContext(), 2130968713, this);
    this.jaO = localView.findViewById(2131821333);
    this.iCl = ((ImageView)localView.findViewById(2131821334));
    this.iJG = ((TextView)localView.findViewById(2131821335));
    this.jaP = ((TextView)localView.findViewById(2131821338));
    this.jaS = localView.findViewById(2131821337);
    this.jaQ = ((LinearLayout)localView.findViewById(2131821336));
    this.jaR = ((ViewGroup)localView.findViewById(2131821332));
    AppMethodBeat.o(133656);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.jaN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */