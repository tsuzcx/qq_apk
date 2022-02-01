package com.tencent.kinda.framework.module.base;

import com.tencent.kinda.framework.widget.base.AlertDialogImpl;
import com.tencent.kinda.framework.widget.base.KCountryCallingCodeViewImpl;
import com.tencent.kinda.framework.widget.base.KindaActionSheetImpl;
import com.tencent.kinda.framework.widget.base.KindaBankCardTypePickerViewImpl;
import com.tencent.kinda.framework.widget.base.KindaBankEditViewImpl;
import com.tencent.kinda.framework.widget.base.KindaBarCodeViewImpl;
import com.tencent.kinda.framework.widget.base.KindaCardNumberEditViewImpl;
import com.tencent.kinda.framework.widget.base.KindaCardTypePickerView;
import com.tencent.kinda.framework.widget.base.KindaCountPickerViewImpl;
import com.tencent.kinda.framework.widget.base.KindaDatePickerView;
import com.tencent.kinda.framework.widget.base.KindaPayEditTextImpl;
import com.tencent.kinda.framework.widget.base.KindaPhoneEditTextImpl;
import com.tencent.kinda.framework.widget.base.KindaProfessionEditViewImpl;
import com.tencent.kinda.framework.widget.base.KindaPwdInputViewImpl;
import com.tencent.kinda.framework.widget.base.KindaQRCodeViewImpl;
import com.tencent.kinda.framework.widget.base.KindaRegionEditViewImpl;
import com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl;
import com.tencent.kinda.framework.widget.base.KindaSwitchViewImpl;
import com.tencent.kinda.framework.widget.base.KindaTableViewImpl;
import com.tencent.kinda.framework.widget.base.KindaValidDatePickerView;
import com.tencent.kinda.framework.widget.base.MMInputTipAlert;
import com.tencent.kinda.framework.widget.base.MMKAvatarImageView;
import com.tencent.kinda.framework.widget.base.MMKButton;
import com.tencent.kinda.framework.widget.base.MMKDashLineView;
import com.tencent.kinda.framework.widget.base.MMKEditText;
import com.tencent.kinda.framework.widget.base.MMKImage;
import com.tencent.kinda.framework.widget.base.MMKImageView;
import com.tencent.kinda.framework.widget.base.MMKLabelView;
import com.tencent.kinda.framework.widget.base.MMKListView;
import com.tencent.kinda.framework.widget.base.MMKLoadingImage;
import com.tencent.kinda.framework.widget.base.MMKOnePxLineView;
import com.tencent.kinda.framework.widget.base.MMKOptionsPicker;
import com.tencent.kinda.framework.widget.base.MMKPickerView;
import com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl;
import com.tencent.kinda.framework.widget.base.MMKRichLabelView;
import com.tencent.kinda.framework.widget.base.MMKRichText;
import com.tencent.kinda.framework.widget.base.MMKRichText.MMKLink;
import com.tencent.kinda.framework.widget.base.MMKScrollView;
import com.tencent.kinda.framework.widget.base.MMKView;
import com.tencent.kinda.framework.widget.base.MMKViewLayout;
import com.tencent.kinda.framework.widget.base.MMMoneyInputText;
import com.tencent.kinda.framework.widget.base.MMToastDialog;
import com.tencent.kinda.modularize.KindaModule;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaBaseViewModule
  extends KindaModule
{
  public void configModule()
  {
    AppMethodBeat.i(18619);
    registerView("kView", MMKView.class);
    registerView("kViewLayout", MMKViewLayout.class);
    registerView("kLabelView", MMKLabelView.class);
    registerView("kEditText", MMKEditText.class);
    registerView("kButton", MMKButton.class);
    registerView("kImageView", MMKImageView.class);
    registerView("kText", MMKRichText.class);
    registerView("kLink", MMKRichText.MMKLink.class);
    registerView("kMoneyInputText", MMMoneyInputText.class);
    registerView("kImage", MMKImage.class);
    registerView("kListView", MMKListView.class);
    registerView("kScrollView", MMKScrollView.class);
    registerView("kRichLabelView", MMKRichLabelView.class);
    registerView("kAvatarImageView", MMKAvatarImageView.class);
    registerView("kPayEditText", KindaPayEditTextImpl.class);
    registerView("kPwdInputView", KindaPwdInputViewImpl.class);
    registerView("kSecureEditText", KindaSecureEditTextImpl.class);
    registerView("kSwitchView", KindaSwitchViewImpl.class);
    registerView("kProfessionEditView", KindaProfessionEditViewImpl.class);
    registerView("kPhoneEditText", KindaPhoneEditTextImpl.class);
    registerView("kRegionEditView", KindaRegionEditViewImpl.class);
    registerView("kCardNumberEditView", KindaCardNumberEditViewImpl.class);
    registerView("kBankEditView", KindaBankEditViewImpl.class);
    registerView("kOnePxLineView", MMKOnePxLineView.class);
    registerView("kCardTypePickerView", KindaCardTypePickerView.class);
    registerView("kValidDatePickerView", KindaValidDatePickerView.class);
    registerView("kDatePickerView", KindaDatePickerView.class);
    registerView("kDashLineView", MMKDashLineView.class);
    registerView("kCountryCallingCodeView", KCountryCallingCodeViewImpl.class);
    registerView("kCountPickerView", KindaCountPickerViewImpl.class);
    registerView("kActionSheet", KindaActionSheetImpl.class);
    registerView("kInputTipAlert", MMInputTipAlert.class);
    registerView("kAlertDialog", AlertDialogImpl.class);
    registerView("kOptionPicker", MMKOptionsPicker.class);
    registerView("kProgressDialog", MMKProgressDialogImpl.class);
    registerView("kLoadingImage", MMKLoadingImage.class);
    registerView("KQRCodeView", KindaQRCodeViewImpl.class);
    registerView("KBarCodeView", KindaBarCodeViewImpl.class);
    registerView("kBankCardTypePickerView", KindaBankCardTypePickerViewImpl.class);
    registerView("kTableView", KindaTableViewImpl.class);
    registerView("kPickerView", MMKPickerView.class);
    registerView("kToastDialog", MMToastDialog.class);
    AppMethodBeat.o(18619);
  }
  
  public void onAppCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.base.KindaBaseViewModule
 * JD-Core Version:    0.7.0.1
 */