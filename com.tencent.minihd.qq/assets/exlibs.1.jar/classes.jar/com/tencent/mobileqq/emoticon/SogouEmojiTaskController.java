package com.tencent.mobileqq.emoticon;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import ifi;
import ifj;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SogouEmojiTaskController
{
  public static final String a;
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private Map jdField_a_of_type_JavaUtilMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  static
  {
    jdField_a_of_type_JavaLangString = SogouEmojiTaskController.class.getSimpleName();
  }
  
  public SogouEmojiTaskController(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmojiTaskController begins");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    d();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmojiTaskController ends");
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func addTask begins, packId:" + paramString1 + ",exprId:" + paramString2);
    }
    ifj localifj = new ifj();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    localifj.jdField_a_of_type_JavaLangString = paramString1;
    localifj.b = paramString2;
    localifj.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localifj);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func addTask ends, mCurTaskId:" + this.jdField_a_of_type_Int + ",task size:" + this.jdField_a_of_type_JavaUtilMap.size());
    }
    b(2131368524);
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onDestroy begins");
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onDestroy ends");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func removeTask begins, taskId:" + paramInt + ",mEmojiTaskHashMap:" + this.jdField_a_of_type_JavaUtilMap);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func removeTask ends");
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func isTaskInMap begins, taskId:" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      if ((ifj)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "func isTaskInMap ends, taskId:" + paramInt + ",exists=" + bool);
        }
        return bool;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func isTaskInMap ends, taskId:" + paramInt + " NOT exist, cause map is null.");
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func showProgressDialog begins, textResId:" + paramInt);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        c();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.jdField_a_of_type_AndroidAppProgressDialog.show();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func showProgressDialog ends, ERROR! msg:" + localThrowable.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func showProgressDialog ends");
      }
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 2131558902);
      this.jdField_a_of_type_AndroidAppProgressDialog.setOnDismissListener(new ifi(this));
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903413);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298140));
    }
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func cancleProgressDailog begins");
    }
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func cancleProgressDailog ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmojiTaskController
 * JD-Core Version:    0.7.0.1
 */