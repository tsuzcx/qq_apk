package com.tencent.av.smallscreen;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import bze;
import com.tencent.av.app.QavChatHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SmallScreenVideoControlUI
{
  private static final String b = "SmallScreenVideoControlUI";
  private Resources jdField_a_of_type_AndroidContentResResources = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  private QavAppInterface jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
  private QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
  private QavSession jdField_a_of_type_ComTencentQavSessionQavSession;
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
  
  public SmallScreenVideoControlUI(QavAppInterface paramQavAppInterface, SmallScreenService paramSmallScreenService)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = paramQavAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService);
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mRes is null. exit video progress");
      paramQavAppInterface = paramSmallScreenService.getString(2131362814) + " 0x03";
      QQToast.a(paramSmallScreenService.getApplicationContext(), paramQavAppInterface, 0).a();
      paramSmallScreenService.stopSelf();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = QavBussinessCtrl.a();
      this.jdField_a_of_type_ComTencentQavSessionQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
    } while (this.jdField_a_of_type_ComTencentQavSessionQavSession != null);
    QLog.d("SmallScreenVideoControlUI", 1, "mVideoController is null. exit video progress");
    paramQavAppInterface = this.jdField_a_of_type_AndroidContentResResources.getString(2131362814) + " 0x04";
    QQToast.a(paramSmallScreenService.getApplicationContext(), paramQavAppInterface, 0).a();
    paramSmallScreenService.stopSelf();
  }
  
  public void a()
  {
    int j = 2131363225;
    QLog.d("SmallScreenVideoControlUI", 1, "onCreate");
    f();
    if (this.jdField_a_of_type_ComTencentQavSessionQavSession.c()) {
      if (this.jdField_a_of_type_ComTencentQavSessionQavSession.c)
      {
        i = 2131362977;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
      }
    }
    do
    {
      return;
      i = 2131362845;
      break;
      if (this.jdField_a_of_type_ComTencentQavSessionQavSession.a())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363225);
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentQavSessionQavSession.b());
    if (this.jdField_a_of_type_ComTencentQavSessionQavSession.b)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentQavSessionQavSession.a != 1) {
        if (this.jdField_a_of_type_ComTencentQavSessionQavSession.a != 2) {
          break label128;
        }
      }
    }
    label128:
    for (int i = j;; i = 2131363013)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentQavAppQavAppInterface != null) {
      this.jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
    }
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  public void b() {}
  
  public void b(long paramLong)
  {
    QavChatHandler.a().b().post(new bze(this, paramLong));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onStop");
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131298295));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131298364);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131298364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI
 * JD-Core Version:    0.7.0.1
 */