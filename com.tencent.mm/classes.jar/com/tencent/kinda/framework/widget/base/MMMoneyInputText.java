package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.kinda.framework.R.drawable;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.gen.KMoneyInputText;
import com.tencent.kinda.gen.KMoneyInputTextOnTextChangedCallback;
import com.tencent.kinda.gen.KMoneyInputTextOnkeyBoardVisibleAnchorCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;
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
    this.contentView = ((LinearLayout)View.inflate(paramContext, R.layout.wallet_money_input_text, null));
    this.titleTv = ((TextView)this.contentView.findViewById(R.id.wallet_title));
    this.contentTv = ((TenpaySecureEditText)this.contentView.findViewById(R.id.wallet_content));
    this.contentTv.setBackgroundResource(R.drawable.mm_trans);
    this.contentTv.setOnClickListener(new MMMoneyInputText.1(this, paramContext));
    this.contentTv.addTextChangedListener(new MMMoneyInputText.2(this));
    if ((paramContext instanceof BaseFrActivity))
    {
      ((BaseFrActivity)paramContext).setEditFocusListener(this.contentView, 2, false);
      ((BaseFrActivity)paramContext).setTenpayKBStateListener(new a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMMoneyInputText
 * JD-Core Version:    0.7.0.1
 */