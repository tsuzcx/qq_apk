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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int olJ;
  private static int olK;
  private ImageView lIM;
  private TextView mPa;
  private List<WxaAttributes.WxaEntryInfo> olD;
  private View olE;
  private TextView olF;
  private LinearLayout olG;
  private ViewGroup olH;
  private View olI;
  
  static
  {
    AppMethodBeat.i(49377);
    olJ = a.fromDPToPix(MMApplicationContext.getContext(), 15);
    olK = a.fromDPToPix(MMApplicationContext.getContext(), 30);
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
    this.olD = new LinkedList();
    View localView = View.inflate(getContext(), 2131493071, this);
    this.olE = localView.findViewById(2131301547);
    this.lIM = ((ImageView)localView.findViewById(2131302477));
    this.mPa = ((TextView)localView.findViewById(2131309199));
    this.olF = ((TextView)localView.findViewById(2131299256));
    this.olI = localView.findViewById(2131304859);
    this.olG = ((LinearLayout)localView.findViewById(2131299176));
    this.olH = ((ViewGroup)localView.findViewById(2131302792));
    AppMethodBeat.o(49376);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.olD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */