package com.tencent.mobileqq.dating.widget;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import ieq;
import ier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatingInputPopupWindow
  extends Dialog
  implements TextWatcher, View.OnClickListener, EmoticonCallback
{
  private static final int jdField_a_of_type_Int = 50;
  private static final int b = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private DatingComment jdField_a_of_type_ComTencentMobileqqDatingDatingComment;
  private DatingInputPopupWindow.IDatingInputPopupWindowCallback jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback;
  private InputBar jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int c;
  
  public DatingInputPopupWindow(BaseActivity paramBaseActivity, boolean paramBoolean, ListView paramListView, int paramInt, DatingComment paramDatingComment, DatingInputPopupWindow.IDatingInputPopupWindowCallback paramIDatingInputPopupWindowCallback, String paramString)
  {
    super(paramBaseActivity, 2131558921);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.c = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment = paramDatingComment;
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback = paramIDatingInputPopupWindowCallback;
    paramBaseActivity = LayoutInflater.from(paramBaseActivity).inflate(2130903900, null);
    setContentView(paramBaseActivity);
    a(paramBaseActivity);
    paramBaseActivity = getWindow().getAttributes();
    paramBaseActivity.x = 0;
    paramBaseActivity.y = 0;
    paramBaseActivity.width = -1;
    paramBaseActivity.windowAnimations = 16973824;
    paramBaseActivity.gravity = 83;
    paramBaseActivity.softInputMode = 21;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297032));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)paramView.findViewById(2131297030));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298135));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131298771));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298772);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar = ((InputBar)paramView.findViewById(2131297027));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = AbsPublishIphoneTitleBarActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentWidgetListView, this.c);
    DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(67);
    if (localDatingManager == null)
    {
      paramView = "";
      if (!android.text.TextUtils.isEmpty(paramView))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramView.length());
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setContentDescription("文本框，正在编辑");
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("发送按钮");
      }
    }
    else
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment == null) {}
      for (paramView = null;; paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_JavaLangString)
      {
        paramView = localDatingManager.a(str, paramView);
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(String.format("回复%s：", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.jdField_a_of_type_JavaLangString }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
      break;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("添加评论...");
    }
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    str = Pattern.compile("\n").matcher(str).replaceAll("");
    str = Pattern.compile("^ +").matcher(str).replaceAll("");
    str = Pattern.compile(" +$").matcher(str).replaceAll("");
    int i = str.length();
    if (i == 0) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131363903, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    do
    {
      return;
      if (i < 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363904, new Object[] { Integer.valueOf(0) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i > 50)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363905, new Object[] { Integer.valueOf(50) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (!HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131365807, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      dismiss();
    } while (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback.a(str, this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment);
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())
    {
      if ((android.text.TextUtils.isEmpty((CharSequence)localObject)) || ((!android.text.TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() < 49))) {
        paramEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, null);
      }
      return;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    paramEditable = Pattern.compile("\n").matcher(paramEditable).replaceAll("");
    paramEditable = Pattern.compile("^ +").matcher(paramEditable).replaceAll("");
    if (Pattern.compile(" +$").matcher(paramEditable).replaceAll("").length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  public void b() {}
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void d() {}
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    String str2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(67);
    String str3;
    if (localDatingManager != null)
    {
      str3 = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment != null) {
        break label103;
      }
    }
    label103:
    for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_JavaLangString)
    {
      localDatingManager.a(str3, str1, str2);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.a();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        super.dismiss();
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetImageView) {
          break;
        }
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.post(new ieq(this));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841082);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("键盘按钮");
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ier(this), 50L);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841083);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("表情按钮");
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        e();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        dismiss();
        return;
      }
    } while ((paramView != this.jdField_a_of_type_ComTencentWidgetXEditTextEx) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 0));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void show()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      super.show();
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */