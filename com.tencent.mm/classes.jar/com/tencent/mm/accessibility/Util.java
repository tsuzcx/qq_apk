package com.tencent.mm.accessibility;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Util
{
  public static Activity getActivityOfView(View paramView)
  {
    AppMethodBeat.i(160019);
    if (paramView == null)
    {
      AppMethodBeat.o(160019);
      return null;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity))
      {
        paramView = (Activity)paramView;
        AppMethodBeat.o(160019);
        return paramView;
      }
    }
    AppMethodBeat.o(160019);
    return null;
  }
  
  public static String getViewIdName(View paramView)
  {
    AppMethodBeat.i(160020);
    if (paramView == null)
    {
      AppMethodBeat.o(160020);
      return "NO_ID";
    }
    int i = paramView.getId();
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject;
    if (i != -1)
    {
      localObject = paramView.getResources();
      if ((resourceHasPackage(i)) && (localObject != null)) {
        switch (0xFF000000 & i)
        {
        }
      }
    }
    for (;;)
    {
      try
      {
        paramView = ((Resources)localObject).getResourcePackageName(i);
        String str = ((Resources)localObject).getResourceTypeName(i);
        localObject = ((Resources)localObject).getResourceEntryName(i);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramView);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
      }
      finally
      {
        continue;
      }
      paramView = localStringBuilder.toString();
      AppMethodBeat.o(160020);
      return paramView;
      paramView = "app";
      continue;
      paramView = "android";
    }
  }
  
  public static boolean resourceHasPackage(int paramInt)
  {
    return paramInt >>> 24 != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.accessibility.Util
 * JD-Core Version:    0.7.0.1
 */