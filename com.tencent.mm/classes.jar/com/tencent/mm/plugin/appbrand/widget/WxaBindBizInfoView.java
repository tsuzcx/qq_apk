package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int mTw;
  private static int mTx;
  private ImageView kAX;
  private TextView lCL;
  private List<WxaAttributes.WxaEntryInfo> mTq;
  private View mTr;
  private TextView mTs;
  private LinearLayout mTt;
  private ViewGroup mTu;
  private View mTv;
  
  static
  {
    AppMethodBeat.i(49377);
    mTw = a.fromDPToPix(aj.getContext(), 15);
    mTx = a.fromDPToPix(aj.getContext(), 30);
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
    this.mTq = new LinkedList();
    View localView = View.inflate(getContext(), 2131493032, this);
    this.mTr = localView.findViewById(2131300108);
    this.kAX = ((ImageView)localView.findViewById(2131300882));
    this.lCL = ((TextView)localView.findViewById(2131305906));
    this.mTs = ((TextView)localView.findViewById(2131298797));
    this.mTv = localView.findViewById(2131302454);
    this.mTt = ((LinearLayout)localView.findViewById(2131298737));
    this.mTu = ((ViewGroup)localView.findViewById(2131301138));
    AppMethodBeat.o(49376);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.mTq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */