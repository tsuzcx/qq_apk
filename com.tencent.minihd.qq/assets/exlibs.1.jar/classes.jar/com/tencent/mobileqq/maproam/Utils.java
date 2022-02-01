package com.tencent.mobileqq.maproam;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import jfd;
import jfe;

public class Utils
{
  public static Dialog a;
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = new Dialog(paramContext, 2131558902);
    paramContext.setContentView(2130904097);
    TextView localTextView = (TextView)paramContext.findViewById(2131297367);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)paramContext.findViewById(2131296606);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)paramContext.findViewById(2131297370);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)paramContext.findViewById(2131297371);
    if (paramString1 != null) {
      paramString1.setText(17039370);
    }
    paramContext.setOnDismissListener(paramOnDismissListener);
    return paramContext;
  }
  
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841600);
    paramContext = new ProgressDialog(paramContext, 2131558902);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903050);
    paramContext.setContentView(2130903050);
    ((TextView)paramContext.findViewById(2131296606)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131296605)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
  
  public static void a()
  {
    if ((a == null) || (a.isShowing())) {}
    try
    {
      a.dismiss();
      label21:
      a = null;
      return;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, paramContext.getResources().getString(paramInt), paramString, new jfd());
    paramString = (TextView)paramContext.findViewById(2131297371);
    if (paramString != null)
    {
      a();
      paramString.setOnClickListener(paramOnClickListener1);
    }
    paramString = (TextView)paramContext.findViewById(2131297370);
    if (paramString != null)
    {
      if (paramOnClickListener2 != null) {
        break label84;
      }
      paramString.setOnClickListener(new jfe());
    }
    for (;;)
    {
      a = paramContext;
      a.show();
      return;
      label84:
      paramString.setOnClickListener(paramOnClickListener2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.Utils
 * JD-Core Version:    0.7.0.1
 */