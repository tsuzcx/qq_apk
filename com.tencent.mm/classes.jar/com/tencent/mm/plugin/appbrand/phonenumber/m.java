package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.a.b;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getDialogHeight", "", "getPosition", "onDismiss", "plugin-appbrand-integration_release"})
public final class m
  extends a
{
  final String appId;
  private j iDU;
  a.f.a.a<y> iDV;
  public a.f.a.a<y> iDW;
  public a.f.a.a<y> iDX;
  public a.f.a.a<y> iDY;
  public a.f.a.a<y> iDZ;
  ArrayList<PhoneItem> iDe;
  public a.f.a.a<y> iEa;
  public b<? super PhoneItem, y> iEb;
  
  public m(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(134856);
    this.appId = paramString;
    this.iDe = new ArrayList();
    this.iDV = ((a.f.a.a)m.a.iEd);
    this.iDW = ((a.f.a.a)m.d.iEg);
    this.iDX = ((a.f.a.a)m.c.iEf);
    this.iDY = ((a.f.a.a)m.e.iEh);
    this.iDZ = ((a.f.a.a)m.b.iEe);
    this.iEa = ((a.f.a.a)m.f.iEi);
    this.iCy = ((a.b)new m.1(this));
    paramContext = paramContext.getResources();
    if (paramContext != null) {}
    for (paramContext = paramContext.getDrawable(2130837752);; paramContext = null)
    {
      this.iCz = paramContext;
      this.iCr.setVisibility(8);
      if (paramContext != null)
      {
        this.iCl.setImageDrawable(this.iCz);
        this.iCr.setVisibility(0);
      }
      paramContext = (View.OnClickListener)new m.2(this);
      this.iCr.setOnClickListener(paramContext);
      this.iCu.setOnClickListener((View.OnClickListener)new m.3(this));
      this.iCt.setVisibility(0);
      AppMethodBeat.o(134856);
      return;
    }
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(143965);
    onCancel();
    AppMethodBeat.o(143965);
  }
  
  public final void p(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(143964);
    a.f.b.j.q(paramArrayList, "value");
    this.iDe.clear();
    this.iDe.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.s.m.runOnUiThread((Runnable)new m.g(this));
    AppMethodBeat.o(143964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.m
 * JD-Core Version:    0.7.0.1
 */