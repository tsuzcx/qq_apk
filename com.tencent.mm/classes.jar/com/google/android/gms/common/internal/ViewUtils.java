package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewUtils
{
  public static String getXmlAttributeString(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    AppMethodBeat.i(4750);
    if (paramAttributeSet == null) {
      paramString1 = null;
    }
    for (;;)
    {
      paramAttributeSet = paramString1;
      String str;
      if (paramString1 != null)
      {
        paramAttributeSet = paramString1;
        if (paramString1.startsWith("@string/"))
        {
          paramAttributeSet = paramString1;
          if (paramBoolean1)
          {
            paramString3 = paramString1.substring(8);
            str = paramContext.getPackageName();
            paramAttributeSet = new TypedValue();
          }
        }
      }
      try
      {
        paramContext.getResources().getValue(String.valueOf(str).length() + 8 + String.valueOf(paramString3).length() + str + ":string/" + paramString3, paramAttributeSet, true);
        if (paramAttributeSet.string != null)
        {
          paramAttributeSet = paramAttributeSet.string.toString();
          if ((paramBoolean2) && (paramAttributeSet == null)) {
            new StringBuilder(String.valueOf(paramString2).length() + 33).append("Required XML attribute \"").append(paramString2).append("\" missing");
          }
          AppMethodBeat.o(4750);
          return paramAttributeSet;
          paramString1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
        }
      }
      catch (Resources.NotFoundException paramContext)
      {
        for (;;)
        {
          new StringBuilder(String.valueOf(paramString2).length() + 30 + String.valueOf(paramString1).length()).append("Could not find resource for ").append(paramString2).append(": ").append(paramString1);
          continue;
          paramContext = String.valueOf(paramAttributeSet);
          new StringBuilder(String.valueOf(paramString2).length() + 28 + String.valueOf(paramContext).length()).append("Resource ").append(paramString2).append(" was not a string: ").append(paramContext);
          paramAttributeSet = paramString1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.ViewUtils
 * JD-Core Version:    0.7.0.1
 */