package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.luggage.l.a.a;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "mContext", "Landroid/content/Context;", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;)V", "mContentView", "Landroid/view/View;", "mExistPhoneNum", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "mFinishBtn", "Landroid/widget/Button;", "mFormInputView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView;", "mFormVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "containPhoneNum", "", "number", "", "count", "", "getView", "reset", "showReplicaNumDialog", "luggage-wechat-full-sdk_release"})
public final class t
  implements m
{
  private View mContentView;
  final Context mContext;
  MMSwitchBtn mru;
  l qCg;
  MMFormVerifyCodeInputView qCj;
  MMFormInputView qCk;
  Button qCl;
  List<PhoneItem> qCm;
  
  public t(Context paramContext, l paraml)
  {
    AppMethodBeat.i(148120);
    this.mContext = paramContext;
    this.qCg = paraml;
    this.mContentView = View.inflate(this.mContext, a.e.app_brand_phone_number_add_ui, null);
    paramContext = this.mContentView;
    if (paramContext != null)
    {
      paramContext = (MMFormVerifyCodeInputView)paramContext.findViewById(a.d.app_brand_phone_number_input);
      this.qCj = paramContext;
      paramContext = this.qCj;
      if (paramContext != null)
      {
        paramContext = paramContext.getContentEditText();
        if (paramContext != null) {
          paramContext.setTextColor(this.mContext.getResources().getColor(a.a.normal_text));
        }
      }
      paramContext = this.mContentView;
      if (paramContext == null) {
        break label356;
      }
      paramContext = (MMFormInputView)paramContext.findViewById(a.d.app_brand_phone_number_verify_code_input);
      label120:
      this.qCk = paramContext;
      paramContext = this.qCk;
      if (paramContext != null)
      {
        paramContext = paramContext.getContentEditText();
        if (paramContext != null) {
          paramContext.setTextColor(this.mContext.getResources().getColor(a.a.normal_text));
        }
      }
      paramContext = this.mContentView;
      if (paramContext == null) {
        break label361;
      }
      paramContext = (MMSwitchBtn)paramContext.findViewById(a.d.app_brand_phone_number_switch);
      label180:
      this.mru = paramContext;
      paramContext = this.mContentView;
      if (paramContext == null) {
        break label366;
      }
    }
    label356:
    label361:
    label366:
    for (paramContext = (Button)paramContext.findViewById(a.d.app_brand_phone_number_finish);; paramContext = null)
    {
      this.qCl = paramContext;
      paramContext = r.qBN;
      this.qCm = r.cgD();
      paramContext = this.qCj;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.qCj;
      if (paramContext != null) {
        paramContext.setSendSmsBtnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            Object localObject1 = null;
            AppMethodBeat.i(148112);
            Object localObject2 = new b();
            ((b)localObject2).bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).aFi());
            localObject2 = this.qCn;
            paramAnonymousView = this.qCn.qCj;
            Object localObject3;
            int i;
            if (paramAnonymousView != null)
            {
              paramAnonymousView = paramAnonymousView.getText();
              paramAnonymousView = String.valueOf(paramAnonymousView);
              if (((t)localObject2).qCm == null) {
                break label200;
              }
              localObject2 = ((t)localObject2).qCm;
              if (localObject2 == null) {
                p.iCn();
              }
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (PhoneItem)((Iterator)localObject2).next();
                if (p.h(Util.nullAsNil(paramAnonymousView), ((PhoneItem)localObject3).fLC))
                {
                  i = 1;
                  label138:
                  if (i == 0) {
                    break label205;
                  }
                  paramAnonymousView = new d.a(this.qCn.mContext);
                  paramAnonymousView.ayg(a.g.appbrand_phone_number_exist);
                  paramAnonymousView.ayj(a.g.luggage_wxa_app_ok);
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
              label200:
              i = 0;
              break label138;
              label205:
              localObject2 = this.qCn.qCg;
              if (localObject2 != null)
              {
                localObject3 = this.qCn.qCj;
                paramAnonymousView = localObject1;
                if (localObject3 != null) {
                  paramAnonymousView = ((MMFormVerifyCodeInputView)localObject3).getText();
                }
                ((l)localObject2).amm(String.valueOf(paramAnonymousView));
              }
            }
          }
        });
      }
      paramContext = this.qCj;
      if (paramContext != null) {
        paramContext.addTextChangedListener((TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148113);
            paramAnonymousCharSequence = this.qCn.qCl;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.qCn.qCj;
              if (localObject != null)
              {
                localObject = ((MMFormVerifyCodeInputView)localObject).getText();
                if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
              }
              else
              {
                localObject = this.qCn.qCk;
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
      paramContext = this.qCk;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.qCk;
      if (paramContext != null) {
        paramContext.addTextChangedListener((TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(148116);
            p.k(paramAnonymousEditable, "s");
            AppMethodBeat.o(148116);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148115);
            p.k(paramAnonymousCharSequence, "s");
            AppMethodBeat.o(148115);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148114);
            p.k(paramAnonymousCharSequence, "s");
            paramAnonymousCharSequence = this.qCn.qCl;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.qCn.qCj;
              if (localObject != null)
              {
                localObject = ((MMFormVerifyCodeInputView)localObject).getText();
                if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
              }
              else
              {
                localObject = this.qCn.qCk;
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
      paramContext = this.qCl;
      if (paramContext == null) {
        break label371;
      }
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject1 = null;
          AppMethodBeat.i(148117);
          Object localObject2 = new b();
          ((b)localObject2).bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).aFi());
          localObject2 = this.qCn.qCg;
          boolean bool;
          if (localObject2 != null)
          {
            paramAnonymousView = this.qCn.mru;
            if (paramAnonymousView == null) {
              break label162;
            }
            paramAnonymousView = Boolean.valueOf(paramAnonymousView.isCheck());
            if (paramAnonymousView == null) {
              p.iCn();
            }
            bool = paramAnonymousView.booleanValue();
            paramAnonymousView = this.qCn.qCj;
            if (paramAnonymousView == null) {
              break label167;
            }
          }
          label162:
          label167:
          for (paramAnonymousView = paramAnonymousView.getText();; paramAnonymousView = null)
          {
            String str = String.valueOf(paramAnonymousView);
            MMFormInputView localMMFormInputView = this.qCn.qCk;
            paramAnonymousView = localObject1;
            if (localMMFormInputView != null) {
              paramAnonymousView = localMMFormInputView.getText();
            }
            ((l)localObject2).c(bool, str, String.valueOf(paramAnonymousView));
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
      break label120;
      paramContext = null;
      break label180;
    }
    label371:
    AppMethodBeat.o(148120);
  }
  
  public final void cgz()
  {
    AppMethodBeat.i(148118);
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.qCj;
    if (localMMFormVerifyCodeInputView != null)
    {
      localMMFormVerifyCodeInputView.cgz();
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
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.qCj;
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