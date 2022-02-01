package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader
  extends LinearLayout
{
  private Context mContext;
  private TextView titleTv;
  private ViewGroup vcE;
  private MMImageButton vcF;
  private MMImageButton vcG;
  
  public ShareHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55886);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(55886);
  }
  
  @TargetApi(11)
  public ShareHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55885);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(55885);
  }
  
  private void init()
  {
    AppMethodBeat.i(55887);
    View localView = View.inflate(this.mContext, 2131495426, this);
    this.vcE = ((ViewGroup)localView.findViewById(2131300707));
    this.vcF = ((MMImageButton)localView.findViewById(2131305935));
    this.vcG = ((MMImageButton)localView.findViewById(2131305942));
    this.titleTv = ((TextView)localView.findViewById(2131305902));
    AppMethodBeat.o(55887);
  }
  
  public ViewGroup getHeaderBar()
  {
    return this.vcE;
  }
  
  public void setOnLeftClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55888);
    this.vcF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55888);
  }
  
  public void setOnRightClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55889);
    this.vcG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55889);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(55890);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(55890);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(55891);
    this.titleTv.setTextColor(paramInt);
    AppMethodBeat.o(55891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.ShareHeader
 * JD-Core Version:    0.7.0.1
 */