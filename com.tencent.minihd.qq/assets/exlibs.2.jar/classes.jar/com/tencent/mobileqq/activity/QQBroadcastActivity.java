package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import eqm;
import eqn;
import java.util.Observer;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  static final int jdField_a_of_type_Int = 1010;
  static final long jdField_a_of_type_Long = 1000L;
  public Handler a;
  public eqn a;
  
  public QQBroadcastActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new eqm(this);
  }
  
  private void c()
  {
    int i = 999;
    QQMessageFacade localQQMessageFacade = this.app.a();
    int j;
    if (localQQMessageFacade != null)
    {
      j = localQQMessageFacade.e();
      if (j <= 0) {
        break label79;
      }
      if (j <= 999) {
        break label99;
      }
    }
    for (;;)
    {
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131366025) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131366025)));
      return;
      label99:
      i = j;
    }
  }
  
  public Cursor a()
  {
    return this.app.a(0).a(a(), 0);
  }
  
  protected CursorAdapter a()
  {
    if (this.jdField_a_of_type_Eqn == null) {
      this.jdField_a_of_type_Eqn = new eqn(this, this, this.app.a(0).a(a(), 0));
    }
    return this.jdField_a_of_type_Eqn;
  }
  
  protected CharSequence a()
  {
    return getString(2131367458);
  }
  
  public String a()
  {
    return String.valueOf(AppConstants.ag);
  }
  
  protected void a()
  {
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app.a().c(a(), 0);
    c();
    this.rightViewText.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Eqn != null) {
      this.jdField_a_of_type_Eqn.changeCursor(null);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */