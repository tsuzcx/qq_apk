package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.kinda.gen.KMoneyInputText;
import com.tencent.kinda.gen.KMoneyInputTextOnTextChangedCallback;
import com.tencent.kinda.gen.KMoneyInputTextOnkeyBoardVisibleAnchorCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(145125);
    this.contentView = ((LinearLayout)View.inflate(paramContext, 2130971205, null));
    this.titleTv = ((TextView)this.contentView.findViewById(2131820696));
    this.contentTv = ((TenpaySecureEditText)this.contentView.findViewById(2131820689));
    this.contentTv.setBackgroundResource(2130839676);
    this.contentTv.setOnClickListener(new MMMoneyInputText.1(this, paramContext));
    this.contentTv.addTextChangedListener(new MMMoneyInputText.2(this));
    if ((paramContext instanceof BaseFrActivity))
    {
      ((BaseFrActivity)paramContext).setEditFocusListener(this.contentView, 2, false);
      ((BaseFrActivity)paramContext).setTenpayKBStateListener(new MMMoneyInputText.3(this, paramContext));
    }
    paramContext = this.contentView;
    AppMethodBeat.o(145125);
    return paramContext;
  }
  
  View findParentScrollView(View paramView)
  {
    AppMethodBeat.i(145126);
    if (paramView == null)
    {
      AppMethodBeat.o(145126);
      return null;
    }
    paramView = paramView.getParent();
    if (paramView == null)
    {
      AppMethodBeat.o(145126);
      return null;
    }
    if ((paramView instanceof ScrollView))
    {
      paramView = (View)paramView;
      AppMethodBeat.o(145126);
      return paramView;
    }
    if ((paramView instanceof View))
    {
      paramView = findParentScrollView((View)paramView);
      AppMethodBeat.o(145126);
      return paramView;
    }
    AppMethodBeat.o(145126);
    return null;
  }
  
  public boolean getFocus()
  {
    return false;
  }
  
  public String getInputText()
  {
    AppMethodBeat.i(145130);
    String str = this.contentTv.getText().toString();
    AppMethodBeat.o(145130);
    return str;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(145128);
    String str = this.titleTv.getText().toString();
    AppMethodBeat.o(145128);
    return str;
  }
  
  public void setFocus(boolean paramBoolean) {}
  
  public void setInputText(String paramString)
  {
    AppMethodBeat.i(145129);
    this.content = paramString;
    this.contentTv.setText(this.content);
    notifyChanged();
    AppMethodBeat.o(145129);
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
    AppMethodBeat.i(145127);
    this.title = paramString;
    this.titleTv.setText(this.title);
    notifyChanged();
    AppMethodBeat.o(145127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMMoneyInputText
 * JD-Core Version:    0.7.0.1
 */