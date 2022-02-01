package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader
  extends LinearLayout
{
  private ViewGroup Kfh;
  private MMImageButton Kfi;
  private MMImageButton Kfj;
  private Context mContext;
  private TextView titleTv;
  
  public ShareHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55886);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(55886);
  }
  
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
    View localView = View.inflate(this.mContext, a.f.share_header, this);
    this.Kfh = ((ViewGroup)localView.findViewById(a.e.header_bar));
    this.Kfi = ((MMImageButton)localView.findViewById(a.e.title_left_button));
    this.Kfj = ((MMImageButton)localView.findViewById(a.e.title_right_button));
    this.titleTv = ((TextView)localView.findViewById(a.e.title));
    AppMethodBeat.o(55887);
  }
  
  public ViewGroup getHeaderBar()
  {
    return this.Kfh;
  }
  
  public void setOnLeftClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55888);
    this.Kfi.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55888);
  }
  
  public void setOnRightClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55889);
    this.Kfj.setOnClickListener(paramOnClickListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.ShareHeader
 * JD-Core Version:    0.7.0.1
 */