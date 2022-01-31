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
    AppMethodBeat.i(72112);
    paramTextView = ViewHierarchy.getTextOfView(paramTextView).replaceAll("\\s", "");
    int i = paramTextView.length();
    if ((i < 12) || (i > 19))
    {
      AppMethodBeat.o(72112);
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
        AppMethodBeat.o(72112);
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
      AppMethodBeat.o(72112);
      return true;
    }
    AppMethodBeat.o(72112);
    return false;
  }
  
  private static boolean isEmail(TextView paramTextView)
  {
    AppMethodBeat.i(72108);
    if (paramTextView.getInputType() == 32)
    {
      AppMethodBeat.o(72108);
      return true;
    }
    paramTextView = ViewHierarchy.getTextOfView(paramTextView);
    if ((paramTextView == null) || (paramTextView.length() == 0))
    {
      AppMethodBeat.o(72108);
      return false;
    }
    boolean bool = Patterns.EMAIL_ADDRESS.matcher(paramTextView).matches();
    AppMethodBeat.o(72108);
    return bool;
  }
  
  private static boolean isPassword(TextView paramTextView)
  {
    AppMethodBeat.i(72107);
    if (paramTextView.getInputType() == 128)
    {
      AppMethodBeat.o(72107);
      return true;
    }
    boolean bool = paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod;
    AppMethodBeat.o(72107);
    return bool;
  }
  
  private static boolean isPersonName(TextView paramTextView)
  {
    AppMethodBeat.i(72109);
    if (paramTextView.getInputType() == 96)
    {
      AppMethodBeat.o(72109);
      return true;
    }
    AppMethodBeat.o(72109);
    return false;
  }
  
  private static boolean isPhoneNumber(TextView paramTextView)
  {
    AppMethodBeat.i(72111);
    if (paramTextView.getInputType() == 3)
    {
      AppMethodBeat.o(72111);
      return true;
    }
    AppMethodBeat.o(72111);
    return false;
  }
  
  private static boolean isPostalAddress(TextView paramTextView)
  {
    AppMethodBeat.i(72110);
    if (paramTextView.getInputType() == 112)
    {
      AppMethodBeat.o(72110);
      return true;
    }
    AppMethodBeat.o(72110);
    return false;
  }
  
  public static boolean isSensitiveUserData(View paramView)
  {
    AppMethodBeat.i(72106);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((isPassword(paramView)) || (isCreditCard(paramView)) || (isPersonName(paramView)) || (isPostalAddress(paramView)) || (isPhoneNumber(paramView)) || (isEmail(paramView)))
      {
        AppMethodBeat.o(72106);
        return true;
      }
      AppMethodBeat.o(72106);
      return false;
    }
    AppMethodBeat.o(72106);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.SensitiveUserDataUtils
 * JD-Core Version:    0.7.0.1
 */