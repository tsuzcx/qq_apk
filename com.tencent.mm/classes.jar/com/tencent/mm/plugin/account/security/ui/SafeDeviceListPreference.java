package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference
  extends Preference
  implements com.tencent.mm.al.g
{
  private Context context;
  private ProgressDialog fpP;
  d ipb;
  private boolean ipc = false;
  private Button ipd;
  a ipe;
  b ipf;
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
  
  private void aDO()
  {
    AppMethodBeat.i(125579);
    com.tencent.mm.kernel.g.aeS().b(362, this);
    AppMethodBeat.o(125579);
  }
  
  final void initView()
  {
    AppMethodBeat.i(125580);
    if (!this.ipc)
    {
      ad.d("MicroMsg.SafeDeviceListPreference", "has not binded");
      AppMethodBeat.o(125580);
      return;
    }
    switch (this.mode)
    {
    case -1: 
    case 0: 
    default: 
      setWidgetLayoutResource(0);
      Yb(0);
      AppMethodBeat.o(125580);
      return;
    case 1: 
      setWidgetLayoutResource(2131493690);
      if (this.ipd != null) {
        this.ipd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125576);
            SafeDeviceListPreference.d(SafeDeviceListPreference.this);
            AppMethodBeat.o(125576);
          }
        });
      }
      Yb(8);
      AppMethodBeat.o(125580);
      return;
    }
    setWidgetLayoutResource(0);
    Yb(0);
    AppMethodBeat.o(125580);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(125578);
    this.ipc = true;
    this.ipd = ((Button)paramView.findViewById(2131298960));
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(125578);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(125577);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    if (localViewGroup != null)
    {
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131494855, localViewGroup);
    }
    AppMethodBeat.o(125577);
    return paramViewGroup;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125581);
    aDO();
    if ((this.fpP != null) && (this.fpP.isShowing()))
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.account.security.a.g.aJD().delete(this.ipb, new String[0]);
      if (this.ipf != null)
      {
        this.ipf.CA(this.mKey);
        AppMethodBeat.o(125581);
      }
    }
    else
    {
      if (com.tencent.mm.plugin.account.a.a.hYu.a(this.context, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125581);
        return;
      }
      Toast.makeText(this.context, this.context.getString(2131762756, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.ipe != null) {
        this.ipe.onFailed(this.ipb.field_uid);
      }
    }
    AppMethodBeat.o(125581);
  }
  
  public static abstract interface a
  {
    public abstract void onFailed(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void CA(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference
 * JD-Core Version:    0.7.0.1
 */