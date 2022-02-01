package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import krh;
import kri;

public class DialogUtil
{
  public static final int a = 230;
  private static final boolean a = true;
  public static final int b = 231;
  public static final int c = 232;
  public static final int d = 233;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = paramContext.getResources();
    Object localObject1 = ((Resources)localObject2).getString(paramInt2);
    String str2 = ((Resources)localObject2).getString(paramInt3);
    String str1 = ((Resources)localObject2).getString(paramInt4);
    paramContext = new Dialog(paramContext, 2131558902);
    paramContext.setContentView(2130903211);
    paramContext.setCanceledOnTouchOutside(true);
    Object localObject3 = (TextView)paramContext.findViewById(2131297367);
    TextView localTextView = (TextView)paramContext.findViewById(2131296606);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject3).getLayoutParams()).topMargin = 0;
      ((TextView)localObject3).setVisibility(8);
      ((TextView)localObject3).requestLayout();
      localObject3 = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
      paramInt1 = (int)((Resources)localObject2).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject3).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = (paramInt1 * 18);
      localTextView.requestLayout();
    }
    for (;;)
    {
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setContentDescription((CharSequence)localObject1);
      }
      localObject1 = (TextView)paramContext.findViewById(2131297370);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131297371);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
      }
      return paramContext;
      localObject2 = ((Resources)localObject2).getString(paramInt1);
      if (localObject3 != null)
      {
        ((TextView)localObject3).setText((CharSequence)localObject2);
        ((TextView)localObject3).setContentDescription((CharSequence)localObject2);
      }
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new Dialog(paramContext, 2131558902);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2130903862);
    ((TextView)paramContext.findViewById(2131299851)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131299852);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131299853);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131299854);
    localTextView1.setText(paramInt1);
    localTextView1.setGravity(3);
    if (paramInt2 == 0) {
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      localTextView3.setText(paramInt3);
      localTextView2.setOnClickListener(paramOnClickListener1);
      localTextView3.setOnClickListener(paramOnClickListener2);
      return paramContext;
      localTextView2.setText(paramInt2);
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Dialog localDialog = new Dialog(paramContext, paramInt1);
    localDialog.setContentView(paramInt2);
    ((TextView)localDialog.findViewById(2131296606)).setText(paramInt3);
    ((ProgressBar)localDialog.findViewById(2131296605)).setIndeterminateDrawable(paramContext.getResources().getDrawable(2130841600));
    localDialog.setCancelable(paramBoolean);
    return localDialog;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    paramContext = new Dialog(paramContext, 2131558873);
    paramContext.setContentView(2130903226);
    TextView localTextView = (TextView)paramContext.findViewById(2131296606);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131296300);
    localTextView.setText(paramInt1);
    localImageView.setImageResource(paramInt2);
    new Handler().postDelayed(new krh(paramContext), paramLong);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, ClickableColorSpanTextView.SpanClickListener paramSpanClickListener)
  {
    paramContext = new Dialog(paramContext, 2131558902);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2130903862);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131299851);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131299852);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131299853);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131299854);
    if (paramString == null)
    {
      localTextView3.setVisibility(8);
      localClickableColorSpanTextView.setText(paramCharSequence);
      if (paramInt1 != 0) {
        break label149;
      }
      localTextView1.setVisibility(8);
      label94:
      if (paramInt2 != 0) {
        break label158;
      }
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      paramString = new kri(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(paramSpanClickListener);
      return paramContext;
      localTextView3.setText(paramString);
      break;
      label149:
      localTextView1.setText(paramInt1);
      break label94;
      label158:
      localTextView2.setText(paramInt2);
    }
  }
  
  public static ProgressDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getResources().getDrawable(2130841600), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    paramContext = new ProgressDialog(paramContext, 2131558902);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903050);
    paramContext.setContentView(2130903050);
    ((TextView)paramContext.findViewById(2131296606)).setText(paramInt);
    ((ProgressBar)paramContext.findViewById(2131296605)).setIndeterminateDrawable(paramDrawable);
    return paramContext;
  }
  
  public static QQCustomContextMenuDialog a(Context paramContext, QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramQQCustomMenu == null) || (paramQQCustomMenu.a() <= 0)) {
      return null;
    }
    paramContext = new QQCustomContextMenuDialog(paramContext, 2131558902);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2130903216);
    paramContext.a(paramQQCustomMenu, paramOnClickListener);
    paramContext.a(2130903215);
    ((LinearLayout)paramContext.findViewById(2131297369)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    paramQQCustomMenu = (ListView)paramContext.findViewById(2131297372);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131297367);
    paramQQCustomMenu.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131365736, 2131365737, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131297378)).setVisibility(8);
      paramOnClickListener1 = (TextView)paramString.findViewById(2131296606);
      paramOnClickListener2 = new LinearLayout.LayoutParams(-2, -2);
      paramOnClickListener2.gravity = 17;
      paramOnClickListener1.setLayoutParams(paramOnClickListener2);
      paramOnClickListener1.setMinHeight(Utils.a(paramActivity, 35.0F));
      paramOnClickListener1.setGravity(17);
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131365736, 2131365737, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131558902);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131558902);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131558902);
    paramContext.setContentView(2130903216);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131365736, 2131365737, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131558902);
    paramContext.setContentView(2130903216);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131558902);
    paramContext.setContentView(2130903219);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131558902);
    paramContext.setContentView(2130903220);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131365736, paramOnClickListener2);
    paramContext.setPositiveButton(2131366313, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131558902);
    paramContext.setContentView(2130903221);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131365736, paramOnClickListener2);
    paramContext.setPositiveButton(2131365737, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomSingleButtonDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSingleButtonDialog(paramContext, 2131558902);
    paramContext.setContentView(2130903218);
    paramContext.a(paramString1.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130838241, 2131365736, paramOnClickListener2);
    paramContext.a(paramString3.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomSplitDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131365736, 2131365737, null, null);
  }
  
  public static QQCustomSplitDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSplitDialog(paramContext, 2131558902);
    paramContext.setContentView(2130903216);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.b(paramInt3, paramOnClickListener1);
    paramContext.c(paramInt2, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return c(paramContext, paramInt, null, null, 2131365736, 2131365737, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131558902);
    paramContext.setContentView(2130903217);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput b(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131558902);
    paramContext.a(7);
    paramContext.setContentView(2130903220);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131365736, paramOnClickListener2);
    paramContext.setPositiveButton(2131366313, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog c(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131558902);
    paramContext.setContentView(2130903216);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil
 * JD-Core Version:    0.7.0.1
 */