package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.gen.KMoneyInputText;
import com.tencent.kinda.gen.KMoneyInputTextOnTextChangedCallback;
import com.tencent.kinda.gen.KMoneyInputTextOnkeyBoardVisibleAnchorCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class MMMoneyInputText
  extends MMKView<LinearLayout>
  implements KMoneyInputText
{
  private KMoneyInputTextOnkeyBoardVisibleAnchorCallback anchorCallback;
  private String content;
  private TenpaySecureEditText contentTv;
  private LinearLayout contentView;
  private KMoneyInputTextOnTextChangedCallback textChangedCallback;
  private String title;
  private TextView titleTv;
  
  public LinearLayout createView(final Context paramContext)
  {
    AppMethodBeat.i(19289);
    this.contentView = ((LinearLayout)View.inflate(paramContext, 2131495981, null));
    this.titleTv = ((TextView)this.contentView.findViewById(2131306836));
    this.contentTv = ((TenpaySecureEditText)this.contentView.findViewById(2131306718));
    this.contentTv.setBackgroundResource(2131233299);
    this.contentTv.setOnClickListener(new View.OnClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(19286);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/MMMoneyInputText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramContext instanceof BaseFrActivity)) {
          ((BaseFrActivity)paramContext).hideTenpayKB();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/MMMoneyInputText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(19286);
      }
    });
    this.contentTv.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(19287);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          paramAnonymousEditable.delete(i + 3, j);
        }
        if (MMMoneyInputText.this.textChangedCallback != null) {
          MMMoneyInputText.this.textChangedCallback.onTextChanged(paramAnonymousEditable.toString());
        }
        AppMethodBeat.o(19287);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if ((paramContext instanceof BaseFrActivity))
    {
      ((BaseFrActivity)paramContext).setEditFocusListener(this.contentView, 2, false);
      ((BaseFrActivity)paramContext).setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19288);
          View localView = MMMoneyInputText.this.findParentScrollView(MMMoneyInputText.this.contentView);
          if (MMMoneyInputText.this.anchorCallback != null)
          {
            Object localObject = MMMoneyInputText.this.anchorCallback.onkeyBoardVisibleAnchor();
            if (paramAnonymousBoolean)
            {
              if ((localObject instanceof MMKView))
              {
                ((BaseFrActivity)paramContext).scrollToFormEditPosAfterShowTenPay(localView, ((MMKView)localObject).getView(), 30);
                AppMethodBeat.o(19288);
                return;
              }
              localObject = KindaAnimatorViewProxy.unwrapProxyObject(localObject);
              if ((localObject instanceof MMKView)) {
                ((BaseFrActivity)paramContext).scrollToFormEditPosAfterShowTenPay(localView, ((MMKView)localObject).getView(), 30);
              }
              AppMethodBeat.o(19288);
              return;
            }
            ((BaseFrActivity)paramContext).scrollTo(localView, 0, 0);
          }
          AppMethodBeat.o(19288);
        }
      });
    }
    paramContext = this.contentView;
    AppMethodBeat.o(19289);
    return paramContext;
  }
  
  View findParentScrollView(View paramView)
  {
    AppMethodBeat.i(19290);
    if (paramView == null)
    {
      AppMethodBeat.o(19290);
      return null;
    }
    paramView = paramView.getParent();
    if (paramView == null)
    {
      AppMethodBeat.o(19290);
      return null;
    }
    if ((paramView instanceof ScrollView))
    {
      paramView = (View)paramView;
      AppMethodBeat.o(19290);
      return paramView;
    }
    if ((paramView instanceof View))
    {
      paramView = findParentScrollView((View)paramView);
      AppMethodBeat.o(19290);
      return paramView;
    }
    AppMethodBeat.o(19290);
    return null;
  }
  
  public boolean getFocus()
  {
    return false;
  }
  
  public String getInputText()
  {
    AppMethodBeat.i(19294);
    String str = this.contentTv.getText().toString();
    AppMethodBeat.o(19294);
    return str;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(19292);
    String str = this.titleTv.getText().toString();
    AppMethodBeat.o(19292);
    return str;
  }
  
  public void setFocus(boolean paramBoolean) {}
  
  public void setInputText(String paramString)
  {
    AppMethodBeat.i(19293);
    this.content = paramString;
    this.contentTv.setText(this.content);
    notifyChanged();
    AppMethodBeat.o(19293);
  }
  
  public void setOnTextChangedCallback(KMoneyInputTextOnTextChangedCallback paramKMoneyInputTextOnTextChangedCallback)
  {
    this.textChangedCallback = paramKMoneyInputTextOnTextChangedCallback;
  }
  
  public void setOnkeyBoardVisibleAnchorCallback(KMoneyInputTextOnkeyBoardVisibleAnchorCallback paramKMoneyInputTextOnkeyBoardVisibleAnchorCallback)
  {
    this.anchorCallback = paramKMoneyInputTextOnkeyBoardVisibleAnchorCallback;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(19291);
    this.title = paramString;
    this.titleTv.setText(this.title);
    notifyChanged();
    AppMethodBeat.o(19291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMMoneyInputText
 * JD-Core Version:    0.7.0.1
 */