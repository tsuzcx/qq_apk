package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView
  extends LinearLayout
{
  private String ikj;
  private ExdeviceProfileAffectedUserView.a lNA;
  private ArrayList<String> lNB;
  private TextView lNy;
  private MMHorList lNz;
  
  public ExdeviceProfileAffectedUserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20018);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2130969461, this, true);
    this.lNy = ((TextView)paramAttributeSet.findViewById(2131823791));
    this.lNz = ((MMHorList)paramAttributeSet.findViewById(2131823792));
    this.lNz.setCenterInParent(true);
    int i = a.fromDPToPix(paramContext, 44);
    this.lNz.setOverScrollEnabled(true);
    this.lNz.setItemWidth(i);
    this.lNz.setCenterInParent(true);
    this.lNA = new ExdeviceProfileAffectedUserView.a(this, (byte)0);
    this.lNz.setAdapter(this.lNA);
    this.lNz.setOnItemClickListener(new ExdeviceProfileAffectedUserView.1(this, paramContext));
    this.lNy.setOnClickListener(new ExdeviceProfileAffectedUserView.2(this));
    setOnClickListener(new ExdeviceProfileAffectedUserView.3(this));
    setVisibility(8);
    AppMethodBeat.o(20018);
  }
  
  public void setAffectedUserInfo(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(20019);
    this.lNB = paramArrayList;
    if ((this.lNB == null) || (this.lNB.size() == 0))
    {
      this.lNy.setText("");
      setVisibility(8);
      AppMethodBeat.o(20019);
      return;
    }
    setVisibility(0);
    this.lNy.setText(getResources().getString(2131299442, new Object[] { Integer.valueOf(this.lNB.size()) }));
    this.lNA.notifyDataSetChanged();
    AppMethodBeat.o(20019);
  }
  
  public void setUsername(String paramString)
  {
    this.ikj = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView
 * JD-Core Version:    0.7.0.1
 */