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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference
  extends Preference
  implements f
{
  private Context context;
  private ProgressDialog dnm;
  d fkq;
  private boolean fkr = false;
  private Button fks;
  SafeDeviceListPreference.a fkt;
  SafeDeviceListPreference.b fku;
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
  
  private void Tw()
  {
    com.tencent.mm.kernel.g.Dk().b(362, this);
  }
  
  final void initView()
  {
    if (!this.fkr) {
      y.d("MicroMsg.SafeDeviceListPreference", "has not binded");
    }
    do
    {
      return;
      switch (this.mode)
      {
      case -1: 
      case 0: 
      default: 
        setWidgetLayoutResource(a.b.mm_preference_submenu);
        return;
      case 1: 
        setWidgetLayoutResource(a.b.delete_safe_divice);
      }
    } while (this.fks == null);
    this.fks.setOnClickListener(new SafeDeviceListPreference.3(this));
    return;
    setWidgetLayoutResource(a.b.mm_preference_submenu);
  }
  
  protected final void onBindView(View paramView)
  {
    this.fkr = true;
    this.fks = ((Button)paramView.findViewById(a.a.del_safe_device_btn));
    initView();
    super.onBindView(paramView);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.a.content);
    if (localViewGroup != null)
    {
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(a.b.mm_preference_edit_safe_device, localViewGroup);
    }
    return paramViewGroup;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Tw();
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.account.security.a.g.XB().a(this.fkq, new String[0]);
      if (this.fku != null) {
        this.fku.pY(this.mKey);
      }
    }
    do
    {
      do
      {
        return;
      } while (com.tencent.mm.plugin.account.a.a.eUS.a(this.context, paramInt1, paramInt2, paramString));
      Toast.makeText(this.context, this.context.getString(a.d.safe_device_del_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    } while (this.fkt == null);
    this.fkt.onFailed(this.fkq.field_uid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference
 * JD-Core Version:    0.7.0.1
 */