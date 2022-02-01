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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference
  extends Preference
  implements i
{
  private Context context;
  private ProgressDialog gtM;
  d kjm;
  private boolean kjn = false;
  private Button kjo;
  a kjp;
  b kjq;
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
  
  private void bit()
  {
    AppMethodBeat.i(125579);
    com.tencent.mm.kernel.g.azz().b(362, this);
    AppMethodBeat.o(125579);
  }
  
  final void initView()
  {
    AppMethodBeat.i(125580);
    if (!this.kjn)
    {
      Log.d("MicroMsg.SafeDeviceListPreference", "has not binded");
      AppMethodBeat.o(125580);
      return;
    }
    switch (this.mode)
    {
    case -1: 
    case 0: 
    default: 
      setWidgetLayoutResource(0);
      alO(0);
      AppMethodBeat.o(125580);
      return;
    case 1: 
      setWidgetLayoutResource(2131493821);
      if (this.kjo != null) {
        this.kjo.setOnClickListener(new SafeDeviceListPreference.3(this));
      }
      alO(8);
      AppMethodBeat.o(125580);
      return;
    }
    setWidgetLayoutResource(0);
    alO(0);
    AppMethodBeat.o(125580);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(125578);
    this.kjn = true;
    this.kjo = ((Button)paramView.findViewById(2131299454));
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(125578);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(125577);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    if (localViewGroup != null)
    {
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131495591, localViewGroup);
    }
    AppMethodBeat.o(125577);
    return paramViewGroup;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(125581);
    bit();
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.account.security.a.g.boR().delete(this.kjm, new String[0]);
      if (this.kjq != null)
      {
        this.kjq.onSucceed(this.mKey);
        AppMethodBeat.o(125581);
      }
    }
    else
    {
      if (com.tencent.mm.plugin.account.a.a.jRu.a(this.context, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125581);
        return;
      }
      Toast.makeText(this.context, this.context.getString(2131764841, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.kjp != null) {
        this.kjp.Tp(this.kjm.field_uid);
      }
    }
    AppMethodBeat.o(125581);
  }
  
  public static abstract interface a
  {
    public abstract void Tp(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void onSucceed(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference
 * JD-Core Version:    0.7.0.1
 */