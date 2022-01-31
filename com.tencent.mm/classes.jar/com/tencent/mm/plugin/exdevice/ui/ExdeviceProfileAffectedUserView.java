package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView
  extends LinearLayout
{
  private String hcm;
  private TextView jEa;
  private MMHorList jEb;
  private ExdeviceProfileAffectedUserView.a jEc;
  private ArrayList<String> jEd;
  
  public ExdeviceProfileAffectedUserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.exdevice_profile_affected_user_view, this, true);
    this.jEa = ((TextView)paramAttributeSet.findViewById(R.h.profile_affected_tv));
    this.jEb = ((MMHorList)paramAttributeSet.findViewById(R.h.profile_affected_lv));
    this.jEb.setCenterInParent(true);
    int i = a.fromDPToPix(paramContext, 44);
    this.jEb.setOverScrollEnabled(true);
    this.jEb.setItemWidth(i);
    this.jEb.setCenterInParent(true);
    this.jEc = new ExdeviceProfileAffectedUserView.a(this, (byte)0);
    this.jEb.setAdapter(this.jEc);
    this.jEb.setOnItemClickListener(new ExdeviceProfileAffectedUserView.1(this, paramContext));
    this.jEa.setOnClickListener(new ExdeviceProfileAffectedUserView.2(this));
    setOnClickListener(new ExdeviceProfileAffectedUserView.3(this));
    setVisibility(8);
  }
  
  public void setAffectedUserInfo(ArrayList<String> paramArrayList)
  {
    this.jEd = paramArrayList;
    if ((this.jEd == null) || (this.jEd.size() == 0))
    {
      this.jEa.setText("");
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.jEa.setText(getResources().getString(R.l.exdevice_profile_affect_wording, new Object[] { Integer.valueOf(this.jEd.size()) }));
    this.jEc.notifyDataSetChanged();
  }
  
  public void setUsername(String paramString)
  {
    this.hcm = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView
 * JD-Core Version:    0.7.0.1
 */