package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.u;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView
  extends LinearLayout
{
  private String kGt;
  private TextView pej;
  private MMHorList pek;
  private ExdeviceProfileAffectedUserView.a pel;
  private ArrayList<String> pem;
  
  public ExdeviceProfileAffectedUserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24088);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493873, this, true);
    this.pej = ((TextView)paramAttributeSet.findViewById(2131303446));
    this.pek = ((MMHorList)paramAttributeSet.findViewById(2131303445));
    this.pek.setCenterInParent(true);
    int i = a.fromDPToPix(paramContext, 44);
    this.pek.setOverScrollEnabled(true);
    this.pek.setItemWidth(i);
    this.pek.setCenterInParent(true);
    this.pel = new ExdeviceProfileAffectedUserView.a(this, (byte)0);
    this.pek.setAdapter(this.pel);
    this.pek.setOnItemClickListener(new ExdeviceProfileAffectedUserView.1(this, paramContext));
    this.pej.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24080);
        paramAnonymousView = u.aqG();
        if ((paramAnonymousView != null) && (paramAnonymousView.equals(ExdeviceProfileAffectedUserView.a(ExdeviceProfileAffectedUserView.this))))
        {
          paramAnonymousView = ExdeviceProfileAffectedUserView.b(ExdeviceProfileAffectedUserView.this);
          if (ExdeviceProfileAffectedUserView.b(ExdeviceProfileAffectedUserView.this).getVisibility() != 0) {
            break label64;
          }
        }
        label64:
        for (int i = 8;; i = 0)
        {
          paramAnonymousView.setVisibility(i);
          AppMethodBeat.o(24080);
          return;
        }
      }
    });
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24081);
        ExdeviceProfileAffectedUserView.c(ExdeviceProfileAffectedUserView.this).performClick();
        AppMethodBeat.o(24081);
      }
    });
    setVisibility(8);
    AppMethodBeat.o(24088);
  }
  
  public void setAffectedUserInfo(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(24089);
    this.pem = paramArrayList;
    if ((this.pem == null) || (this.pem.size() == 0))
    {
      this.pej.setText("");
      setVisibility(8);
      AppMethodBeat.o(24089);
      return;
    }
    setVisibility(0);
    this.pej.setText(getResources().getString(2131758572, new Object[] { Integer.valueOf(this.pem.size()) }));
    this.pel.notifyDataSetChanged();
    AppMethodBeat.o(24089);
  }
  
  public void setUsername(String paramString)
  {
    this.kGt = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView
 * JD-Core Version:    0.7.0.1
 */