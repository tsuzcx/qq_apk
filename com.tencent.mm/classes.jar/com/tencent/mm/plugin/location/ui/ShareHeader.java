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
  private ViewGroup ocW;
  private MMImageButton ocX;
  private MMImageButton ocY;
  private TextView titleTv;
  
  public ShareHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113486);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(113486);
  }
  
  @TargetApi(11)
  public ShareHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113485);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(113485);
  }
  
  private void init()
  {
    AppMethodBeat.i(113487);
    View localView = View.inflate(this.mContext, 2130970722, this);
    this.ocW = ((ViewGroup)localView.findViewById(2131826116));
    this.ocX = ((MMImageButton)localView.findViewById(2131827759));
    this.ocY = ((MMImageButton)localView.findViewById(2131827761));
    this.titleTv = ((TextView)localView.findViewById(2131820680));
    AppMethodBeat.o(113487);
  }
  
  public ViewGroup getHeaderBar()
  {
    return this.ocW;
  }
  
  public void setOnLeftClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113488);
    this.ocX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113488);
  }
  
  public void setOnRightClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113489);
    this.ocY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113489);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(113490);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(113490);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(113491);
    this.titleTv.setTextColor(paramInt);
    AppMethodBeat.o(113491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.ShareHeader
 * JD-Core Version:    0.7.0.1
 */