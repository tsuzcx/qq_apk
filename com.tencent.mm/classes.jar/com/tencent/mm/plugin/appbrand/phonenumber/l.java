package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.k;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "appId", "", "content", "context", "Landroid/content/Context;", "height", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;I)V", "getAppId", "()Ljava/lang/String;", "backIv", "Landroid/widget/ImageView;", "getContent", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getDialogContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "setDialogContainer", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;)V", "getHeight", "()I", "rootView", "titleTv", "cancel", "", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class l
  implements k
{
  private final String appId;
  private final String content;
  private final Context context;
  private final TextView gMp;
  private final int height;
  public com.tencent.mm.plugin.appbrand.widget.b.l iDP;
  private final View iDQ;
  private final ImageView iDR;
  private final View iDS;
  private final TextView titleTv;
  
  public l(String paramString1, String paramString2, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(143953);
    this.appId = paramString1;
    this.content = paramString2;
    this.context = paramContext;
    this.height = paramInt;
    paramString1 = View.inflate(this.context, 2130968704, null);
    j.p(paramString1, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.iDS = paramString1;
    paramString1 = this.iDS.findViewById(2131821279);
    j.p(paramString1, "rootView.findViewById(R.…e_number_explain_content)");
    this.iDQ = paramString1;
    paramString1 = this.iDQ;
    if (paramString1 != null) {
      paramString1.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.height));
    }
    paramString1 = this.iDS.findViewById(2131821280);
    j.p(paramString1, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.iDR = ((ImageView)paramString1);
    paramString1 = this.iDR;
    if (paramString1 != null) {
      paramString1.setOnClickListener((View.OnClickListener)new l.1(this));
    }
    paramString1 = this.iDS.findViewById(2131821281);
    j.p(paramString1, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramString1);
    paramString1 = this.iDS.findViewById(2131821282);
    j.p(paramString1, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.gMp = ((TextView)paramString1);
    paramString2 = this.gMp;
    paramString1 = this.content;
    if (paramString1 != null) {}
    for (paramString1 = (CharSequence)paramString1;; paramString1 = (CharSequence)this.context.getString(2131297164))
    {
      paramString2.setText(paramString1);
      AppMethodBeat.o(143953);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.b.l paraml) {}
  
  public final boolean aKF()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss() {}
  
  public final View getContentView()
  {
    return this.iDS;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void pq(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.l
 * JD-Core Version:    0.7.0.1
 */