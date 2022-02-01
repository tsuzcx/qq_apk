package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "mContext", "Landroid/content/Context;", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;)V", "mContentView", "Landroid/view/View;", "mExistPhoneNum", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "mFinishBtn", "Landroid/widget/Button;", "mFormInputView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView;", "mFormVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "containPhoneNum", "", "number", "", "count", "", "getView", "reset", "showReplicaNumDialog", "luggage-wechat-full-sdk_release"})
public final class t
  implements m
{
  MMSwitchBtn iFu;
  private View mContentView;
  final Context mContext;
  l mpj;
  MMFormVerifyCodeInputView mpm;
  MMFormInputView mpn;
  Button mpo;
  List<PhoneItem> mpp;
  
  public t(Context paramContext, l paraml)
  {
    AppMethodBeat.i(148120);
    this.mContext = paramContext;
    this.mpj = paraml;
    this.mContentView = View.inflate(this.mContext, 2131493017, null);
    paramContext = this.mContentView;
    if (paramContext != null)
    {
      paramContext = (MMFormVerifyCodeInputView)paramContext.findViewById(2131296784);
      this.mpm = paramContext;
      paramContext = this.mpm;
      if (paramContext != null)
      {
        paramContext = paramContext.getContentEditText();
        if (paramContext != null) {
          paramContext.setTextColor(this.mContext.getResources().getColor(2131100710));
        }
      }
      paramContext = this.mContentView;
      if (paramContext == null) {
        break label349;
      }
      paramContext = (MMFormInputView)paramContext.findViewById(2131296786);
      label116:
      this.mpn = paramContext;
      paramContext = this.mpn;
      if (paramContext != null)
      {
        paramContext = paramContext.getContentEditText();
        if (paramContext != null) {
          paramContext.setTextColor(this.mContext.getResources().getColor(2131100710));
        }
      }
      paramContext = this.mContentView;
      if (paramContext == null) {
        break label354;
      }
      paramContext = (MMSwitchBtn)paramContext.findViewById(2131296785);
      label174:
      this.iFu = paramContext;
      paramContext = this.mContentView;
      if (paramContext == null) {
        break label359;
      }
    }
    label349:
    label354:
    label359:
    for (paramContext = (Button)paramContext.findViewById(2131296783);; paramContext = null)
    {
      this.mpo = paramContext;
      paramContext = r.moQ;
      this.mpp = r.bxo();
      paramContext = this.mpm;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.mpm;
      if (paramContext != null) {
        paramContext.setSendSmsBtnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            Object localObject1 = null;
            AppMethodBeat.i(148112);
            Object localObject2 = new b();
            ((b)localObject2).bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).ahF());
            localObject2 = this.mpq;
            paramAnonymousView = this.mpq.mpm;
            Object localObject3;
            int i;
            if (paramAnonymousView != null)
            {
              paramAnonymousView = paramAnonymousView.getText();
              paramAnonymousView = String.valueOf(paramAnonymousView);
              if (((t)localObject2).mpp == null) {
                break label198;
              }
              localObject2 = ((t)localObject2).mpp;
              if (localObject2 == null) {
                p.gkB();
              }
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (PhoneItem)((Iterator)localObject2).next();
                if (p.i(bu.nullAsNil(paramAnonymousView), ((PhoneItem)localObject3).dAs))
                {
                  i = 1;
                  label138:
                  if (i == 0) {
                    break label203;
                  }
                  paramAnonymousView = new d.a(this.mpq.mContext);
                  paramAnonymousView.afR(2131756014);
                  paramAnonymousView.afU(2131761022);
                  paramAnonymousView.show();
                }
              }
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(148112);
              return;
              paramAnonymousView = null;
              break;
              label198:
              i = 0;
              break label138;
              label203:
              localObject2 = this.mpq.mpj;
              if (localObject2 != null)
              {
                localObject3 = this.mpq.mpm;
                paramAnonymousView = localObject1;
                if (localObject3 != null) {
                  paramAnonymousView = ((MMFormVerifyCodeInputView)localObject3).getText();
                }
                ((l)localObject2).UE(String.valueOf(paramAnonymousView));
              }
            }
          }
        });
      }
      paramContext = this.mpm;
      if (paramContext != null) {
        paramContext.addTextChangedListener((TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148113);
            paramAnonymousCharSequence = this.mpq.mpo;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.mpq.mpm;
              if (localObject != null)
              {
                localObject = ((MMFormVerifyCodeInputView)localObject).getText();
                if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
              }
              else
              {
                localObject = this.mpq.mpn;
                if (localObject != null)
                {
                  localObject = ((MMFormInputView)localObject).getText();
                  if ((localObject != null) && (((Editable)localObject).length() == 0)) {
                    break label104;
                  }
                }
              }
              label104:
              for (boolean bool = true;; bool = false)
              {
                paramAnonymousCharSequence.setEnabled(bool);
                AppMethodBeat.o(148113);
                return;
              }
            }
            AppMethodBeat.o(148113);
          }
        });
      }
      paramContext = this.mpn;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.mpn;
      if (paramContext != null) {
        paramContext.addTextChangedListener((TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(148116);
            p.h(paramAnonymousEditable, "s");
            AppMethodBeat.o(148116);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148115);
            p.h(paramAnonymousCharSequence, "s");
            AppMethodBeat.o(148115);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148114);
            p.h(paramAnonymousCharSequence, "s");
            paramAnonymousCharSequence = this.mpq.mpo;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.mpq.mpm;
              if (localObject != null)
              {
                localObject = ((MMFormVerifyCodeInputView)localObject).getText();
                if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
              }
              else
              {
                localObject = this.mpq.mpn;
                if (localObject != null)
                {
                  localObject = ((MMFormInputView)localObject).getText();
                  if ((localObject != null) && (((Editable)localObject).length() == 0)) {
                    break label110;
                  }
                }
              }
              label110:
              for (boolean bool = true;; bool = false)
              {
                paramAnonymousCharSequence.setEnabled(bool);
                AppMethodBeat.o(148114);
                return;
              }
            }
            AppMethodBeat.o(148114);
          }
        });
      }
      paramContext = this.mpo;
      if (paramContext == null) {
        break label364;
      }
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject1 = null;
          AppMethodBeat.i(148117);
          Object localObject2 = new b();
          ((b)localObject2).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).ahF());
          localObject2 = this.mpq.mpj;
          boolean bool;
          if (localObject2 != null)
          {
            paramAnonymousView = this.mpq.iFu;
            if (paramAnonymousView == null) {
              break label162;
            }
            paramAnonymousView = Boolean.valueOf(paramAnonymousView.fPP());
            if (paramAnonymousView == null) {
              p.gkB();
            }
            bool = paramAnonymousView.booleanValue();
            paramAnonymousView = this.mpq.mpm;
            if (paramAnonymousView == null) {
              break label167;
            }
          }
          label162:
          label167:
          for (paramAnonymousView = paramAnonymousView.getText();; paramAnonymousView = null)
          {
            String str = String.valueOf(paramAnonymousView);
            MMFormInputView localMMFormInputView = this.mpq.mpn;
            paramAnonymousView = localObject1;
            if (localMMFormInputView != null) {
              paramAnonymousView = localMMFormInputView.getText();
            }
            ((l)localObject2).b(bool, str, String.valueOf(paramAnonymousView));
            a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(148117);
            return;
            paramAnonymousView = null;
            break;
          }
        }
      });
      AppMethodBeat.o(148120);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label116;
      paramContext = null;
      break label174;
    }
    label364:
    AppMethodBeat.o(148120);
  }
  
  public final void bxk()
  {
    AppMethodBeat.i(148118);
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.mpm;
    if (localMMFormVerifyCodeInputView != null)
    {
      localMMFormVerifyCodeInputView.bxk();
      AppMethodBeat.o(148118);
      return;
    }
    AppMethodBeat.o(148118);
  }
  
  public final View getView()
  {
    return this.mContentView;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(148119);
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.mpm;
    if (localMMFormVerifyCodeInputView != null)
    {
      localMMFormVerifyCodeInputView.reset();
      AppMethodBeat.o(148119);
      return;
    }
    AppMethodBeat.o(148119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t
 * JD-Core Version:    0.7.0.1
 */