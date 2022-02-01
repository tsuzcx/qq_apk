package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensitiveUserDataUtils
{
  private static boolean isCreditCard(TextView paramTextView)
  {
    AppMethodBeat.i(17548);
    paramTextView = ViewHierarchy.getTextOfView(paramTextView).replaceAll("\\s", "");
    int i = paramTextView.length();
    if ((i < 12) || (i > 19))
    {
      AppMethodBeat.o(17548);
      return false;
    }
    int k = 0;
    int m = 0;
    int j = i - 1;
    if (j >= 0)
    {
      i = paramTextView.charAt(j);
      if ((i < 48) || (i > 57))
      {
        AppMethodBeat.o(17548);
        return false;
      }
      int n = i - 48;
      i = n;
      if (k != 0)
      {
        n *= 2;
        i = n;
        if (n > 9) {
          i = n % 10 + 1;
        }
      }
      m += i;
      if (k == 0) {}
      for (i = 1;; i = 0)
      {
        j -= 1;
        k = i;
        break;
      }
    }
    if (m % 10 == 0)
    {
      AppMethodBeat.o(17548);
      return true;
    }
    AppMethodBeat.o(17548);
    return false;
  }
  
  private static boolean isEmail(TextView paramTextView)
  {
    AppMethodBeat.i(17544);
    if (paramTextView.getInputType() == 32)
    {
      AppMethodBeat.o(17544);
      return true;
    }
    paramTextView = ViewHierarchy.getTextOfView(paramTextView);
    if ((paramTextView == null) || (paramTextView.length() == 0))
    {
      AppMethodBeat.o(17544);
      return false;
    }
    boolean bool = Patterns.EMAIL_ADDRESS.matcher(paramTextView).matches();
    AppMethodBeat.o(17544);
    return bool;
  }
  
  private static boolean isPassword(TextView paramTextView)
  {
    AppMethodBeat.i(17543);
    if (paramTextView.getInputType() == 128)
    {
      AppMethodBeat.o(17543);
      return true;
    }
    boolean bool = paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod;
    AppMethodBeat.o(17543);
    return bool;
  }
  
  private static boolean isPersonName(TextView paramTextView)
  {
    AppMethodBeat.i(17545);
    if (paramTextView.getInputType() == 96)
    {
      AppMethodBeat.o(17545);
      return true;
    }
    AppMethodBeat.o(17545);
    return false;
  }
  
  private static boolean isPhoneNumber(TextView paramTextView)
  {
    AppMethodBeat.i(17547);
    if (paramTextView.getInputType() == 3)
    {
      AppMethodBeat.o(17547);
      return true;
    }
    AppMethodBeat.o(17547);
    return false;
  }
  
  private static boolean isPostalAddress(TextView paramTextView)
  {
    AppMethodBeat.i(17546);
    if (paramTextView.getInputType() == 112)
    {
      AppMethodBeat.o(17546);
      return true;
    }
    AppMethodBeat.o(17546);
    return false;
  }
  
  public static boolean isSensitiveUserData(View paramView)
  {
    AppMethodBeat.i(17542);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((isPassword(paramView)) || (isCreditCard(paramView)) || (isPersonName(paramView)) || (isPostalAddress(paramView)) || (isPhoneNumber(paramView)) || (isEmail(paramView)))
      {
        AppMethodBeat.o(17542);
        return true;
      }
      AppMethodBeat.o(17542);
      return false;
    }
    AppMethodBeat.o(17542);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.SensitiveUserDataUtils
 * JD-Core Version:    0.7.0.1
 */