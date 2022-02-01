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
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int mYE;
  private static int mYF;
  private ImageView kEm;
  private TextView lHk;
  private TextView mYA;
  private LinearLayout mYB;
  private ViewGroup mYC;
  private View mYD;
  private List<WxaAttributes.WxaEntryInfo> mYy;
  private View mYz;
  
  static
  {
    AppMethodBeat.i(49377);
    mYE = a.fromDPToPix(ak.getContext(), 15);
    mYF = a.fromDPToPix(ak.getContext(), 30);
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
    this.mYy = new LinkedList();
    View localView = View.inflate(getContext(), 2131493032, this);
    this.mYz = localView.findViewById(2131300108);
    this.kEm = ((ImageView)localView.findViewById(2131300882));
    this.lHk = ((TextView)localView.findViewById(2131305906));
    this.mYA = ((TextView)localView.findViewById(2131298797));
    this.mYD = localView.findViewById(2131302454);
    this.mYB = ((LinearLayout)localView.findViewById(2131298737));
    this.mYC = ((ViewGroup)localView.findViewById(2131301138));
    AppMethodBeat.o(49376);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.mYy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */