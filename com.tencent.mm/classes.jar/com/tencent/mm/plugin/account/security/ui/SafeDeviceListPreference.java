package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference
  extends Preference
  implements f
{
  private Context context;
  private ProgressDialog eeN;
  d gBH;
  private boolean gBI = false;
  private Button gBJ;
  SafeDeviceListPreference.a gBK;
  SafeDeviceListPreference.b gBL;
  int mode = -2;
  
  public SafeDeviceListPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SafeDeviceListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SafeDeviceListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  private void amI()
  {
    AppMethodBeat.i(69897);
    com.tencent.mm.kernel.g.Rc().b(362, this);
    AppMethodBeat.o(69897);
  }
  
  final void initView()
  {
    AppMethodBeat.i(69898);
    if (!this.gBI)
    {
      ab.d("MicroMsg.SafeDeviceListPreference", "has not binded");
      AppMethodBeat.o(69898);
      return;
    }
    switch (this.mode)
    {
    case -1: 
    case 0: 
    default: 
      setWidgetLayoutResource(0);
      OW(0);
      AppMethodBeat.o(69898);
      return;
    case 1: 
      setWidgetLayoutResource(2130969302);
      if (this.gBJ != null) {
        this.gBJ.setOnClickListener(new SafeDeviceListPreference.3(this));
      }
      OW(8);
      AppMethodBeat.o(69898);
      return;
    }
    setWidgetLayoutResource(0);
    OW(0);
    AppMethodBeat.o(69898);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69896);
    this.gBI = true;
    this.gBJ = ((Button)paramView.findViewById(2131823365));
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(69896);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(69895);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    if (localViewGroup != null)
    {
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2130970228, localViewGroup);
    }
    AppMethodBeat.o(69895);
    return paramViewGroup;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(69899);
    amI();
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.account.security.a.g.ard().delete(this.gBH, new String[0]);
      if (this.gBL != null)
      {
        this.gBL.xu(this.mKey);
        AppMethodBeat.o(69899);
      }
    }
    else
    {
      if (com.tencent.mm.plugin.account.a.a.gmP.a(this.context, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(69899);
        return;
      }
      Toast.makeText(this.context, this.context.getString(2131302844, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.gBK != null) {
        this.gBK.onFailed(this.gBH.field_uid);
      }
    }
    AppMethodBeat.o(69899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference
 * JD-Core Version:    0.7.0.1
 */