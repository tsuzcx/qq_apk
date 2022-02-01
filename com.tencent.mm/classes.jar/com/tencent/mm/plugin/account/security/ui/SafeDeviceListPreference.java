package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference
  extends Preference
  implements f
{
  private Context context;
  private ProgressDialog fMu;
  d jiq;
  private boolean jir = false;
  private Button jis;
  a jit;
  b jiu;
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
  
  private void aNO()
  {
    AppMethodBeat.i(125579);
    com.tencent.mm.kernel.g.aiU().b(362, this);
    AppMethodBeat.o(125579);
  }
  
  final void initView()
  {
    AppMethodBeat.i(125580);
    if (!this.jir)
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
      acw(0);
      AppMethodBeat.o(125580);
      return;
    case 1: 
      setWidgetLayoutResource(2131493690);
      if (this.jis != null) {
        this.jis.setOnClickListener(new SafeDeviceListPreference.3(this));
      }
      acw(8);
      AppMethodBeat.o(125580);
      return;
    }
    setWidgetLayoutResource(0);
    acw(0);
    AppMethodBeat.o(125580);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(125578);
    this.jir = true;
    this.jis = ((Button)paramView.findViewById(2131298960));
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
    aNO();
    if ((this.fMu != null) && (this.fMu.isShowing()))
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.account.security.a.g.aTG().delete(this.jiq, new String[0]);
      if (this.jiu != null)
      {
        this.jiu.JS(this.mKey);
        AppMethodBeat.o(125581);
      }
    }
    else
    {
      if (com.tencent.mm.plugin.account.a.a.iRH.a(this.context, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125581);
        return;
      }
      Toast.makeText(this.context, this.context.getString(2131762756, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.jit != null) {
        this.jit.onFailed(this.jiq.field_uid);
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
    public abstract void JS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference
 * JD-Core Version:    0.7.0.1
 */