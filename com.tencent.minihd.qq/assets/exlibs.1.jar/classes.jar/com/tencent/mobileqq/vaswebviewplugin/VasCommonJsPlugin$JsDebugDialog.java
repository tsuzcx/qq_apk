package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

class VasCommonJsPlugin$JsDebugDialog
  extends Dialog
{
  TextView textView;
  
  public VasCommonJsPlugin$JsDebugDialog(VasCommonJsPlugin paramVasCommonJsPlugin, Context paramContext)
  {
    super(paramContext);
    super.getWindow().setFlags(1024, 1024);
    super.requestWindowFeature(1);
    paramVasCommonJsPlugin = new RelativeLayout(paramContext);
    paramVasCommonJsPlugin.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ScrollView localScrollView = new ScrollView(paramContext);
    localScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.textView = new TextView(paramContext);
    this.textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localScrollView.addView(this.textView);
    paramVasCommonJsPlugin.addView(localScrollView);
    super.setContentView(paramVasCommonJsPlugin);
  }
  
  public void dismiss()
  {
    this.textView.setText("");
    super.dismiss();
  }
  
  public void log(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.textView.setText("");
    String str = (String)this.textView.getText();
    Iterator localIterator = paramList.iterator();
    for (paramList = str; localIterator.hasNext(); paramList = paramList + "log:" + str + "\n") {
      str = (String)localIterator.next();
    }
    this.textView.setText(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.JsDebugDialog
 * JD-Core Version:    0.7.0.1
 */