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
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "mContext", "Landroid/content/Context;", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;)V", "mContentView", "Landroid/view/View;", "mExistPhoneNum", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "mFinishBtn", "Landroid/widget/Button;", "mFormInputView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView;", "mFormVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "containPhoneNum", "", "number", "", "count", "", "getView", "reset", "showReplicaNumDialog", "luggage-wechat-full-sdk_release"})
public final class t
  implements m
{
  MMSwitchBtn ijk;
  MMFormInputView lKA;
  Button lKB;
  List<PhoneItem> lKC;
  l lKw;
  MMFormVerifyCodeInputView lKz;
  private View mContentView;
  final Context mContext;
  
  public t(Context paramContext, l paraml)
  {
    AppMethodBeat.i(148120);
    this.mContext = paramContext;
    this.lKw = paraml;
    this.mContentView = View.inflate(this.mContext, 2131493017, null);
    paramContext = this.mContentView;
    if (paramContext != null)
    {
      paramContext = (MMFormVerifyCodeInputView)paramContext.findViewById(2131296784);
      this.lKz = paramContext;
      paramContext = this.lKz;
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
      this.lKA = paramContext;
      paramContext = this.lKA;
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
      this.ijk = paramContext;
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
      this.lKB = paramContext;
      paramContext = r.lKd;
      this.lKC = r.bss();
      paramContext = this.lKz;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.lKz;
      if (paramContext != null) {
        paramContext.setSendSmsBtnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            Object localObject1 = null;
            AppMethodBeat.i(148112);
            Object localObject2 = this.lKD;
            paramAnonymousView = this.lKD.lKz;
            Object localObject3;
            if (paramAnonymousView != null)
            {
              paramAnonymousView = paramAnonymousView.getText();
              paramAnonymousView = String.valueOf(paramAnonymousView);
              if (((t)localObject2).lKC == null) {
                break label154;
              }
              localObject2 = ((t)localObject2).lKC;
              if (localObject2 == null) {
                k.fOy();
              }
              localObject2 = ((List)localObject2).iterator();
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localObject3 = (PhoneItem)((Iterator)localObject2).next();
              } while (!k.g(bs.nullAsNil(paramAnonymousView), ((PhoneItem)localObject3).dnz));
            }
            label154:
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label159;
              }
              paramAnonymousView = new d.a(this.lKD.mContext);
              paramAnonymousView.acJ(2131756014);
              paramAnonymousView.acM(2131761022);
              paramAnonymousView.show();
              AppMethodBeat.o(148112);
              return;
              paramAnonymousView = null;
              break;
            }
            label159:
            localObject2 = this.lKD.lKw;
            if (localObject2 != null)
            {
              localObject3 = this.lKD.lKz;
              paramAnonymousView = localObject1;
              if (localObject3 != null) {
                paramAnonymousView = ((MMFormVerifyCodeInputView)localObject3).getText();
              }
              ((l)localObject2).Qp(String.valueOf(paramAnonymousView));
              AppMethodBeat.o(148112);
              return;
            }
            AppMethodBeat.o(148112);
          }
        });
      }
      paramContext = this.lKz;
      if (paramContext != null) {
        paramContext.addTextChangedListener((TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148113);
            paramAnonymousCharSequence = this.lKD.lKB;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.lKD.lKz;
              if (localObject != null)
              {
                localObject = ((MMFormVerifyCodeInputView)localObject).getText();
                if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
              }
              else
              {
                localObject = this.lKD.lKA;
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
      paramContext = this.lKA;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.lKA;
      if (paramContext != null) {
        paramContext.addTextChangedListener((TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(148116);
            k.h(paramAnonymousEditable, "s");
            AppMethodBeat.o(148116);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148115);
            k.h(paramAnonymousCharSequence, "s");
            AppMethodBeat.o(148115);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148114);
            k.h(paramAnonymousCharSequence, "s");
            paramAnonymousCharSequence = this.lKD.lKB;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.lKD.lKz;
              if (localObject != null)
              {
                localObject = ((MMFormVerifyCodeInputView)localObject).getText();
                if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
              }
              else
              {
                localObject = this.lKD.lKA;
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
      paramContext = this.lKB;
      if (paramContext == null) {
        break label364;
      }
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject = null;
          AppMethodBeat.i(148117);
          l locall = this.lKD.lKw;
          if (locall != null)
          {
            paramAnonymousView = this.lKD.ijk;
            boolean bool;
            if (paramAnonymousView != null)
            {
              paramAnonymousView = Boolean.valueOf(paramAnonymousView.fuI());
              if (paramAnonymousView == null) {
                k.fOy();
              }
              bool = paramAnonymousView.booleanValue();
              paramAnonymousView = this.lKD.lKz;
              if (paramAnonymousView == null) {
                break label123;
              }
            }
            label123:
            for (paramAnonymousView = paramAnonymousView.getText();; paramAnonymousView = null)
            {
              String str = String.valueOf(paramAnonymousView);
              MMFormInputView localMMFormInputView = this.lKD.lKA;
              paramAnonymousView = localObject;
              if (localMMFormInputView != null) {
                paramAnonymousView = localMMFormInputView.getText();
              }
              locall.a(bool, str, String.valueOf(paramAnonymousView));
              AppMethodBeat.o(148117);
              return;
              paramAnonymousView = null;
              break;
            }
          }
          AppMethodBeat.o(148117);
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
  
  public final void bso()
  {
    AppMethodBeat.i(148118);
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.lKz;
    if (localMMFormVerifyCodeInputView != null)
    {
      localMMFormVerifyCodeInputView.bso();
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
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.lKz;
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