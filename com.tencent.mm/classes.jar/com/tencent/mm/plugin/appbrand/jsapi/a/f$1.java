package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.Iterator;
import java.util.LinkedList;

final class f$1
  implements Runnable
{
  f$1(f paramf, v paramv, int paramInt1, fu paramfu, int paramInt2, String paramString, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(101965);
    f localf = this.hEH;
    v localv = this.hEe;
    int i = this.bAX;
    fu localfu = this.hED;
    int j = this.hEE;
    Object localObject2 = this.hEF;
    Object localObject3 = this.hEG;
    if (j == 2) {}
    String str2;
    String str3;
    View localView;
    Object localObject4;
    LinearLayout localLinearLayout;
    for (String str1 = localv.getContext().getString(2131296580);; str1 = localv.getContext().getString(2131296581))
    {
      str2 = localv.getContext().getString(2131296582);
      str3 = localv.getContext().getString(2131296579);
      String str4 = localv.getContext().getString(2131296578);
      localObject1 = (LayoutInflater)localv.getContext().getSystemService("layout_inflater");
      localView = ((LayoutInflater)localObject1).inflate(2130968665, null);
      TextView localTextView = (TextView)localView.findViewById(2131821162);
      localObject4 = (TextView)localView.findViewById(2131821164);
      localLinearLayout = (LinearLayout)localView.findViewById(2131821163);
      localTextView.setText((CharSequence)localObject2);
      ((TextView)localObject4).setText(str4);
      ((TextView)localObject4).setOnClickListener(new f.2(localf, localv));
      localLinearLayout.removeAllViews();
      if ((localObject3 == null) || (((LinkedList)localObject3).size() <= 0)) {
        break;
      }
      localLinearLayout.setVisibility(0);
      localObject2 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject3 = (TextView)((LayoutInflater)localObject1).inflate(2130968661, null);
        ((TextView)localObject3).setText((CharSequence)localObject4);
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject4).bottomMargin = localv.hmw.getResources().getDimensionPixelOffset(2131427982);
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localLinearLayout.addView((View)localObject3);
      }
    }
    Object localObject1 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setVisibility(8);
    ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
    new c.a(localv.getContext()).avm(str1).fu(localView).avs(str2).a(new f.4(localf, localfu, localv, i)).avt(str3).b(new f.3(localf, localfu, localv, i)).aLZ().show();
    AppMethodBeat.o(101965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.f.1
 * JD-Core Version:    0.7.0.1
 */