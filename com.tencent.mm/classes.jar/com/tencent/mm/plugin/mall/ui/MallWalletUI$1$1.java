package com.tencent.mm.plugin.mall.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.plugin.wallet_core.utils.e.2;
import com.tencent.mm.plugin.wallet_core.utils.e.3;
import com.tencent.mm.plugin.wallet_core.utils.e.4;
import com.tencent.mm.plugin.wallet_core.utils.e.5;
import com.tencent.mm.plugin.wallet_core.utils.e.6;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

final class MallWalletUI$1$1
  implements Runnable
{
  MallWalletUI$1$1(MallWalletUI.1 param1, bqq parambqq) {}
  
  public final void run()
  {
    AppMethodBeat.i(43263);
    MallWalletUI localMallWalletUI;
    Object localObject2;
    MallWalletUI.1.1.1 local1;
    if (((MallWalletUI.e(this.oAU.oAS) == null) || (!MallWalletUI.e(this.oAU.oAS).isShowing())) && (!this.oAU.oAS.isFinishing()) && (!MallWalletUI.f(this.oAU.oAS)))
    {
      localMallWalletUI = this.oAU.oAS;
      localObject2 = this.oAU.oAS;
      localObject1 = this.oAT.wna.xJB;
      local1 = new MallWalletUI.1.1.1(this);
      if (localObject1 != null) {
        break label161;
      }
    }
    label161:
    com.tencent.mm.plugin.crashfix.b.a locala;
    for (Object localObject1 = null;; localObject1 = locala)
    {
      MallWalletUI.a(localMallWalletUI, (Dialog)localObject1);
      this.oAU.oAS.addDialog(MallWalletUI.e(this.oAU.oAS));
      MallWalletUI.e(this.oAU.oAS).show();
      MallWalletUI.g(this.oAU.oAS);
      AppMethodBeat.o(43263);
      return;
      locala = new com.tencent.mm.plugin.crashfix.b.a((Context)localObject2, 2131493881);
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from((Context)localObject2).inflate(2130971166, null, false);
      Object localObject3;
      int i;
      if ((((wb)localObject1).wOJ != null) && (((wb)localObject1).wOJ.xuD != null))
      {
        localObject3 = (CdnImageView)localViewGroup.findViewById(2131829100);
        localObject4 = ((wb)localObject1).wOJ.xuD;
        if (((bfq)localObject4).type == 1)
        {
          e.a((CdnImageView)localObject3, ((bfq)localObject4).wCC, 2130839146, true);
          i = BackwardSupportUtil.b.b((Context)localObject2, 50.0F);
          bo.n((View)localObject3, i, i, i, i);
          ((CdnImageView)localObject3).setOnClickListener(new e.2(locala));
        }
      }
      Object localObject4 = (LinearLayout)localViewGroup.findViewById(2131829101);
      if ((((wb)localObject1).wOL != null) && (!((wb)localObject1).wOL.isEmpty()))
      {
        Iterator localIterator = ((wb)localObject1).wOL.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (cqy)localIterator.next();
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          if (((cqy)localObject1).type == 1)
          {
            localObject3 = new TextView(((LinearLayout)localObject4).getContext());
            e.a((TextView)localObject3, ((cqy)localObject1).wNE, null);
            e.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((cqy)localObject1).xZC);
            ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          }
          else if (((cqy)localObject1).type == 11)
          {
            localObject3 = new CdnImageView(((LinearLayout)localObject4).getContext());
            i = com.tencent.mm.cb.a.fromDPToPix(((LinearLayout)localObject4).getContext(), 64);
            e.a((CdnImageView)localObject3, ((cqy)localObject1).wCC, -1, false);
            ((CdnImageView)localObject3).setMinimumWidth(i);
            ((CdnImageView)localObject3).setMinimumHeight(i);
            e.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((cqy)localObject1).xZC);
            ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          }
          else if (((cqy)localObject1).type == 20)
          {
            localObject2 = ((cqy)localObject1).xZB;
            cra localcra = ((cqy)localObject1).xZC;
            if (localObject2 != null)
            {
              ((LinearLayout)localObject4).setGravity(1);
              if (((no)localObject2).wCE != null)
              {
                LinearLayout localLinearLayout = new LinearLayout(((LinearLayout)localObject4).getContext());
                localLinearLayout.setGravity(48);
                localLinearLayout.setOrientation(0);
                localObject1 = ((LinearLayout)localObject4).getContext();
                localObject3 = ((no)localObject2).wCE.wND;
                label595:
                TextView localTextView;
                Context localContext;
                nn localnn;
                if (localObject3 != null) {
                  if (((ciz)localObject3).xTi == 0)
                  {
                    localObject1 = new MMSwitchBtn((Context)localObject1);
                    if (((ciz)localObject3).xED == 0)
                    {
                      ((MMSwitchBtn)localObject1).setCheck(false);
                      localTextView = new TextView(((LinearLayout)localObject4).getContext());
                      e.a(localTextView, ((no)localObject2).wCE.wNE, null);
                      localContext = ((LinearLayout)localObject4).getContext();
                      localnn = ((no)localObject2).wCF;
                      if (localnn == null) {
                        break label1177;
                      }
                      if (localnn.wCB != 1) {
                        break label1088;
                      }
                      localObject3 = new Button(localContext);
                      ((Button)localObject3).setTextSize(0, com.tencent.mm.cb.a.ao(localContext, 2131427769));
                      ((Button)localObject3).setTextColor(localContext.getResources().getColor(2131690799));
                      ((Button)localObject3).setBackgroundResource(2130838045);
                      ((Button)localObject3).setGravity(17);
                      ((Button)localObject3).setAllCaps(true);
                      ((Button)localObject3).setPadding(com.tencent.mm.cb.a.ao(localContext, 2131427848), 0, com.tencent.mm.cb.a.ao(localContext, 2131427848), 0);
                      ((Button)localObject3).setWidth(com.tencent.mm.cb.a.fromDPToPix(localContext, 184));
                      ((Button)localObject3).setHeight(com.tencent.mm.cb.a.fromDPToPix(localContext, 40));
                      if (localnn.state != 1) {
                        break label1079;
                      }
                      ((Button)localObject3).setEnabled(true);
                      label775:
                      ((Button)localObject3).setText(localnn.text);
                      localObject2 = localObject3;
                      if (localnn.knS == 1)
                      {
                        ((Button)localObject3).setOnClickListener(new e.5(localContext, localnn, local1));
                        localObject2 = localObject3;
                      }
                      label818:
                      localObject3 = new LinearLayout.LayoutParams(-2, -2);
                      if ((localcra != null) && (localcra.xZE != null)) {
                        ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)localcra.xZE.top);
                      }
                      ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 32);
                      ((LinearLayout)localObject4).addView(localLinearLayout, (ViewGroup.LayoutParams)localObject3);
                      if (localObject1 != null)
                      {
                        localLinearLayout.addView((View)localObject1);
                        if (!(localObject1 instanceof MMSwitchBtn)) {
                          break label1182;
                        }
                        ((MMSwitchBtn)localObject1).setSwitchListener(new e.3((View)localObject2));
                      }
                    }
                  }
                }
                for (;;)
                {
                  localLinearLayout.addView(localTextView);
                  if (localObject2 == null) {
                    break;
                  }
                  localObject1 = new LinearLayout.LayoutParams(-2, -2);
                  if ((localcra != null) && (localcra.xZE != null)) {
                    ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)localcra.xZE.bottom);
                  }
                  ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
                  break;
                  if (((ciz)localObject3).xED == 1)
                  {
                    ((MMSwitchBtn)localObject1).setCheck(true);
                    break label595;
                  }
                  ((MMSwitchBtn)localObject1).setEnabled(false);
                  break label595;
                  if (((ciz)localObject3).xTi == 1)
                  {
                    localObject1 = new CheckBox((Context)localObject1);
                    ((CheckBox)localObject1).setBackgroundResource(2130839637);
                    if (((ciz)localObject3).xED == 0)
                    {
                      ((CheckBox)localObject1).setChecked(false);
                      break label595;
                    }
                    if (((ciz)localObject3).xED == 1)
                    {
                      ((CheckBox)localObject1).setChecked(true);
                      break label595;
                    }
                    ((CheckBox)localObject1).setEnabled(false);
                    break label595;
                  }
                  localObject1 = null;
                  break label595;
                  label1079:
                  ((Button)localObject3).setEnabled(false);
                  break label775;
                  label1088:
                  if (localnn.wCB == 0)
                  {
                    localObject3 = new CdnImageView(localContext);
                    e.a((CdnImageView)localObject3, localnn.wCC);
                    if (localnn.state == 1) {
                      ((CdnImageView)localObject3).setEnabled(true);
                    }
                    for (;;)
                    {
                      localObject2 = localObject3;
                      if (localnn.knS != 1) {
                        break;
                      }
                      ((CdnImageView)localObject3).setOnClickListener(new e.6(localContext, localnn, local1));
                      localObject2 = localObject3;
                      break;
                      ((CdnImageView)localObject3).setEnabled(false);
                    }
                  }
                  label1177:
                  localObject2 = null;
                  break label818;
                  label1182:
                  if ((localObject1 instanceof CheckBox)) {
                    ((CheckBox)localObject1).setOnCheckedChangeListener(new e.4((View)localObject2));
                  }
                }
              }
            }
          }
        }
      }
      locala.setContentView(localViewGroup);
      locala.setCancelable(true);
      locala.setCanceledOnTouchOutside(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI.1.1
 * JD-Core Version:    0.7.0.1
 */