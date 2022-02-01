package cooperation.qwallet.virtual;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import mao;
import map;
import maq;

public class QChongLotteryBrowser
  extends QQBrowserActivity
{
  protected static final int a = 1;
  protected static final String a = "QQ钱包";
  protected static final int b = 2;
  protected static final String b = "取消";
  protected static final int c = 3;
  protected static final String c = "易迅彩票";
  protected static final int d = 4;
  protected static int e;
  protected static int f;
  protected static int g;
  public String d = "";
  public String e;
  protected String f;
  private String g;
  
  static
  {
    jdField_e_of_type_Int = 1;
    jdField_f_of_type_Int = 2;
    jdField_g_of_type_Int = 3;
  }
  
  public QChongLotteryBrowser()
  {
    this.jdField_g_of_type_JavaLangString = "QChongLotteryBrowser";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
  }
  
  protected void a(TopBtnConfig paramTopBtnConfig)
  {
    if (paramTopBtnConfig == null) {}
    do
    {
      return;
      switch (paramTopBtnConfig.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        if (paramTopBtnConfig.jdField_b_of_type_Int == jdField_f_of_type_Int)
        {
          this.leftView.setVisibility(0);
          if ((paramTopBtnConfig.jdField_a_of_type_JavaLangString == null) || (paramTopBtnConfig.jdField_a_of_type_JavaLangString.equals("")))
          {
            this.leftView.setText("QQ钱包");
            this.d = "";
            return;
          }
          this.leftView.setText(paramTopBtnConfig.jdField_a_of_type_JavaLangString);
          this.d = paramTopBtnConfig.jdField_b_of_type_JavaLangString;
          return;
        }
        this.leftView.setVisibility(8);
        this.d = "";
        return;
      case 2: 
        if ((paramTopBtnConfig.jdField_a_of_type_JavaLangString == null) || (paramTopBtnConfig.jdField_a_of_type_JavaLangString.equals("")))
        {
          setTitle("易迅彩票");
          return;
        }
        setTitle(paramTopBtnConfig.jdField_a_of_type_JavaLangString);
        return;
      case 3: 
        if (paramTopBtnConfig.jdField_b_of_type_Int == jdField_e_of_type_Int)
        {
          this.rightViewText.setVisibility(8);
          this.rightViewImg.setVisibility(8);
          this.jdField_e_of_type_JavaLangString = "";
        }
        if (paramTopBtnConfig.jdField_b_of_type_Int == jdField_g_of_type_Int)
        {
          this.rightViewText.setVisibility(8);
          this.rightViewImg.setVisibility(0);
          this.jdField_e_of_type_JavaLangString = paramTopBtnConfig.jdField_b_of_type_JavaLangString;
        }
        break;
      }
    } while (paramTopBtnConfig.jdField_b_of_type_Int != jdField_f_of_type_Int);
    this.rightViewText.setVisibility(0);
    this.rightViewImg.setVisibility(8);
    if ((paramTopBtnConfig.jdField_a_of_type_JavaLangString == null) || (paramTopBtnConfig.jdField_a_of_type_JavaLangString.equals("")))
    {
      this.rightViewText.setText("取消");
      this.jdField_e_of_type_JavaLangString = "";
      return;
    }
    this.rightViewText.setText(paramTopBtnConfig.jdField_a_of_type_JavaLangString);
    this.jdField_e_of_type_JavaLangString = paramTopBtnConfig.jdField_b_of_type_JavaLangString;
    return;
    Log.v("SysBackEvent", paramTopBtnConfig.jdField_b_of_type_JavaLangString);
    this.jdField_f_of_type_JavaLangString = paramTopBtnConfig.jdField_b_of_type_JavaLangString;
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.leftView.setOnClickListener(new mao(this));
    this.rightViewImg.setOnClickListener(new map(this));
    this.rightViewText.setOnClickListener(new maq(this));
    return false;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.equals(""))) {
        onBackEvent();
      }
      for (;;)
      {
        return true;
        this.a.loadUrl(this.jdField_f_of_type_JavaLangString);
      }
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.virtual.QChongLotteryBrowser
 * JD-Core Version:    0.7.0.1
 */