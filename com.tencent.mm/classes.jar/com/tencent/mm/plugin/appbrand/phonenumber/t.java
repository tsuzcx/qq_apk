package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView.3;
import com.tencent.mm.plugin.appbrand.widget.a.c;
import com.tencent.mm.plugin.appbrand.widget.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "mContext", "Landroid/content/Context;", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;)V", "mContentView", "Landroid/view/View;", "mExistPhoneNum", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "mFinishBtn", "Landroid/widget/Button;", "mFormInputView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView;", "mFormVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "containPhoneNum", "", "number", "", "count", "", "getView", "reset", "showReplicaNumDialog", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements m
{
  private View mContentView;
  private final Context mContext;
  private MMSwitchBtn pkU;
  private l tHf;
  MMFormVerifyCodeInputView tHh;
  MMFormInputView tHi;
  Button tHj;
  private List<PhoneItem> tHk;
  
  public t(Context paramContext, l paraml)
  {
    AppMethodBeat.i(148120);
    this.mContext = paramContext;
    this.tHf = paraml;
    this.mContentView = View.inflate(this.mContext, a.e.app_brand_phone_number_add_ui, null);
    paramContext = this.mContentView;
    if (paramContext == null)
    {
      paramContext = null;
      this.tHh = paramContext;
      paramContext = this.tHh;
      if (paramContext != null)
      {
        paramContext = paramContext.getContentEditText();
        if (paramContext != null) {
          paramContext.setTextColor(this.mContext.getResources().getColor(a.a.normal_text));
        }
      }
      paramContext = this.mContentView;
      if (paramContext != null) {
        break label337;
      }
      paramContext = null;
      label104:
      this.tHi = paramContext;
      paramContext = this.tHi;
      if (paramContext != null)
      {
        paramContext = paramContext.getContentEditText();
        if (paramContext != null) {
          paramContext.setTextColor(this.mContext.getResources().getColor(a.a.normal_text));
        }
      }
      paramContext = this.mContentView;
      if (paramContext != null) {
        break label351;
      }
      paramContext = null;
      label155:
      this.pkU = paramContext;
      paramContext = this.mContentView;
      if (paramContext != null) {
        break label491;
      }
      paramContext = localObject;
      label171:
      this.tHj = paramContext;
      paramContext = r.tGQ;
      this.tHk = r.cHA();
      paramContext = this.tHh;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.tHh;
      if (paramContext != null) {
        paramContext.setSendSmsBtnClickListener(new t..ExternalSyntheticLambda1(this));
      }
      paramContext = this.tHh;
      if (paramContext != null)
      {
        paraml = (TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(148116);
            AppMethodBeat.o(148116);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(148115);
            AppMethodBeat.o(148115);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            boolean bool = true;
            AppMethodBeat.i(148114);
            paramAnonymousCharSequence = this.tHl.tHj;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.tHl.tHh;
              if (localObject == null) {
                break label116;
              }
              localObject = ((MMFormVerifyCodeInputView)localObject).getText();
              if ((localObject == null) || (((Editable)localObject).length() != 0)) {
                break label116;
              }
              paramAnonymousInt1 = 1;
              if (paramAnonymousInt1 != 0) {
                break label126;
              }
              localObject = this.tHl.tHi;
              if (localObject == null) {
                break label121;
              }
              localObject = ((MMFormInputView)localObject).getText();
              if ((localObject == null) || (((Editable)localObject).length() != 0)) {
                break label121;
              }
              paramAnonymousInt1 = 1;
              label100:
              if (paramAnonymousInt1 != 0) {
                break label126;
              }
            }
            for (;;)
            {
              paramAnonymousCharSequence.setEnabled(bool);
              AppMethodBeat.o(148114);
              return;
              label116:
              paramAnonymousInt1 = 0;
              break;
              label121:
              paramAnonymousInt1 = 0;
              break label100;
              label126:
              bool = false;
            }
          }
        };
        if (paramContext.tID == null) {
          break label505;
        }
        paramContext.tID.addTextChangedListener(paraml);
      }
    }
    for (;;)
    {
      paramContext = this.tHi;
      if (paramContext != null) {
        paramContext.setInputType(3);
      }
      paramContext = this.tHi;
      if (paramContext != null) {
        paramContext.addTextChangedListener((TextWatcher)new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(318912);
            s.u(paramAnonymousEditable, "s");
            AppMethodBeat.o(318912);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(318907);
            s.u(paramAnonymousCharSequence, "s");
            AppMethodBeat.o(318907);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            boolean bool = true;
            AppMethodBeat.i(318901);
            s.u(paramAnonymousCharSequence, "s");
            paramAnonymousCharSequence = this.tHl.tHj;
            if (paramAnonymousCharSequence != null)
            {
              Object localObject = this.tHl.tHh;
              if (localObject == null) {
                break label122;
              }
              localObject = ((MMFormVerifyCodeInputView)localObject).getText();
              if ((localObject == null) || (((Editable)localObject).length() != 0)) {
                break label122;
              }
              paramAnonymousInt1 = 1;
              if (paramAnonymousInt1 != 0) {
                break label132;
              }
              localObject = this.tHl.tHi;
              if (localObject == null) {
                break label127;
              }
              localObject = ((MMFormInputView)localObject).getText();
              if ((localObject == null) || (((Editable)localObject).length() != 0)) {
                break label127;
              }
              paramAnonymousInt1 = 1;
              label106:
              if (paramAnonymousInt1 != 0) {
                break label132;
              }
            }
            for (;;)
            {
              paramAnonymousCharSequence.setEnabled(bool);
              AppMethodBeat.o(318901);
              return;
              label122:
              paramAnonymousInt1 = 0;
              break;
              label127:
              paramAnonymousInt1 = 0;
              break label106;
              label132:
              bool = false;
            }
          }
        });
      }
      paramContext = this.tHj;
      if (paramContext != null) {
        paramContext.setOnClickListener(new t..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(148120);
      return;
      paramContext = (MMFormVerifyCodeInputView)paramContext.findViewById(a.d.app_brand_phone_number_input);
      break;
      label337:
      paramContext = (MMFormInputView)paramContext.findViewById(a.d.app_brand_phone_number_verify_code_input);
      break label104;
      label351:
      paraml = (MMSwitchBtn)paramContext.findViewById(a.d.app_brand_phone_number_switch);
      if (paraml == null)
      {
        paramContext = null;
        break label155;
      }
      paramContext = c.uyi;
      c.a.a((View)paraml, null, null, false, Integer.valueOf(a.g.app_brand_action_switch), null, Integer.valueOf(a.b.Edge_1_5_A), 4030);
      String str1 = this.mContext.getString(a.g.app_brand_state_selected_phone_number_add_for_use);
      s.s(str1, "mContext.getString(R.str…phone_number_add_for_use)");
      String str2 = this.mContext.getString(a.g.app_brand_state_unselected_phone_number_add_for_use);
      s.s(str2, "mContext.getString(R.str…phone_number_add_for_use)");
      if (paraml.afTT) {}
      for (paramContext = (CharSequence)str1;; paramContext = (CharSequence)str2)
      {
        paraml.setContentDescription(paramContext);
        paraml.setSwitchListener(new t..ExternalSyntheticLambda2(paraml, str1, str2));
        paramContext = ah.aiuX;
        paramContext = paraml;
        break;
      }
      label491:
      paramContext = (Button)paramContext.findViewById(a.d.app_brand_phone_number_finish);
      break label171;
      label505:
      Log.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paraml, paramContext.tID });
    }
  }
  
  private static final void a(t paramt, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(318889);
    Object localObject2 = new Object();
    b localb = new b();
    localb.cH(paramt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramt, "this$0");
    paramView = paramt.tHh;
    if (paramView == null)
    {
      paramView = null;
      if (!paramt.afz(String.valueOf(paramView))) {
        break label159;
      }
      paramt = new e.a(paramt.mContext);
      paramt.aEO(a.g.appbrand_phone_number_exist);
      paramt.aER(a.g.luggage_wxa_app_ok);
      paramt.jHH().show();
    }
    label159:
    do
    {
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318889);
      return;
      paramView = paramView.getText();
      break;
      paramView = paramt.tHf;
    } while (paramView == null);
    paramt = paramt.tHh;
    if (paramt == null) {}
    for (paramt = localObject1;; paramt = paramt.getText())
    {
      paramView.afv(String.valueOf(paramt));
      break;
    }
  }
  
  private static final void a(MMSwitchBtn paramMMSwitchBtn, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(318879);
    s.u(paramMMSwitchBtn, "$switchBtn");
    s.u(paramString1, "$checkedContentDesc");
    s.u(paramString2, "$unCheckedContentDesc");
    Log.i("MicroMsg.AppBrand.PhoneNumberAddView", s.X("onStatusChange, isChecked: ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean) {}
    for (paramString1 = (CharSequence)paramString1;; paramString1 = (CharSequence)paramString2)
    {
      paramMMSwitchBtn.setContentDescription(paramString1);
      AppMethodBeat.o(318879);
      return;
    }
  }
  
  private final boolean afz(String paramString)
  {
    AppMethodBeat.i(318876);
    if (this.tHk != null)
    {
      Object localObject = this.tHk;
      s.checkNotNull(localObject);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject).next();
        if (s.p(Util.nullAsNil(paramString), localPhoneItem.hRk))
        {
          AppMethodBeat.o(318876);
          return true;
        }
      }
    }
    AppMethodBeat.o(318876);
    return false;
  }
  
  private static final void b(t paramt, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(318892);
    Object localObject2 = new Object();
    b localb = new b();
    localb.cH(paramt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramt, "this$0");
    localObject2 = paramt.tHf;
    boolean bool;
    if (localObject2 != null)
    {
      paramView = paramt.pkU;
      if (paramView != null) {
        break label167;
      }
      paramView = null;
      s.checkNotNull(paramView);
      bool = paramView.booleanValue();
      paramView = paramt.tHh;
      if (paramView != null) {
        break label178;
      }
      paramView = null;
      label109:
      paramView = String.valueOf(paramView);
      paramt = paramt.tHi;
      if (paramt != null) {
        break label186;
      }
    }
    label167:
    label178:
    label186:
    for (paramt = localObject1;; paramt = paramt.getText())
    {
      ((l)localObject2).b(bool, paramView, String.valueOf(paramt));
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318892);
      return;
      paramView = Boolean.valueOf(paramView.afTT);
      break;
      paramView = paramView.getText();
      break label109;
    }
  }
  
  public final void cHv()
  {
    AppMethodBeat.i(148118);
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.tHh;
    if (localMMFormVerifyCodeInputView != null)
    {
      localMMFormVerifyCodeInputView.qaJ.setVisibility(8);
      localMMFormVerifyCodeInputView.tIE.setVisibility(0);
      localMMFormVerifyCodeInputView.tIE.setText(localMMFormVerifyCodeInputView.getContext().getString(a.g.appbrand_mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(localMMFormVerifyCodeInputView.tII) }));
      if (localMMFormVerifyCodeInputView.timerHandler != null)
      {
        localMMFormVerifyCodeInputView.timerHandler.stopTimer();
        localMMFormVerifyCodeInputView.timerHandler.startTimer(1000L);
        AppMethodBeat.o(148118);
        return;
      }
      if (localMMFormVerifyCodeInputView.getContext() != null)
      {
        localMMFormVerifyCodeInputView.timerHandler = new MTimerHandler(localMMFormVerifyCodeInputView.getContext().getMainLooper(), new MMFormVerifyCodeInputView.3(localMMFormVerifyCodeInputView), true);
        localMMFormVerifyCodeInputView.timerHandler.startTimer(1000L);
        AppMethodBeat.o(148118);
        return;
      }
      if (localMMFormVerifyCodeInputView.timerHandler != null) {
        localMMFormVerifyCodeInputView.timerHandler.stopTimer();
      }
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
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.tHh;
    if (localMMFormVerifyCodeInputView != null)
    {
      if (localMMFormVerifyCodeInputView.timerHandler != null) {
        localMMFormVerifyCodeInputView.timerHandler.stopTimer();
      }
      localMMFormVerifyCodeInputView.tID.setText("");
      localMMFormVerifyCodeInputView.tIE.setVisibility(8);
      localMMFormVerifyCodeInputView.tIJ = localMMFormVerifyCodeInputView.tII;
      localMMFormVerifyCodeInputView.qaJ.setVisibility(0);
    }
    AppMethodBeat.o(148119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t
 * JD-Core Version:    0.7.0.1
 */