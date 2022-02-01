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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference
  extends Preference
  implements com.tencent.mm.ak.g
{
  private Context context;
  private ProgressDialog fts;
  d iPh;
  private boolean iPi = false;
  private Button iPj;
  a iPk;
  b iPl;
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
  
  private void aKF()
  {
    AppMethodBeat.i(125579);
    com.tencent.mm.kernel.g.agi().b(362, this);
    AppMethodBeat.o(125579);
  }
  
  final void initView()
  {
    AppMethodBeat.i(125580);
    if (!this.iPi)
    {
      ac.d("MicroMsg.SafeDeviceListPreference", "has not binded");
      AppMethodBeat.o(125580);
      return;
    }
    switch (this.mode)
    {
    case -1: 
    case 0: 
    default: 
      setWidgetLayoutResource(0);
      aam(0);
      AppMethodBeat.o(125580);
      return;
    case 1: 
      setWidgetLayoutResource(2131493690);
      if (this.iPj != null) {
        this.iPj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125576);
            SafeDeviceListPreference.d(SafeDeviceListPreference.this);
            AppMethodBeat.o(125576);
          }
        });
      }
      aam(8);
      AppMethodBeat.o(125580);
      return;
    }
    setWidgetLayoutResource(0);
    aam(0);
    AppMethodBeat.o(125580);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(125578);
    this.iPi = true;
    this.iPj = ((Button)paramView.findViewById(2131298960));
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
    aKF();
    if ((this.fts != null) && (this.fts.isShowing()))
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.account.security.a.g.aQu().delete(this.iPh, new String[0]);
      if (this.iPl != null)
      {
        this.iPl.GD(this.mKey);
        AppMethodBeat.o(125581);
      }
    }
    else
    {
      if (com.tencent.mm.plugin.account.a.a.iyy.a(this.context, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125581);
        return;
      }
      Toast.makeText(this.context, this.context.getString(2131762756, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.iPk != null) {
        this.iPk.onFailed(this.iPh.field_uid);
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
    public abstract void GD(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference
 * JD-Core Version:    0.7.0.1
 */