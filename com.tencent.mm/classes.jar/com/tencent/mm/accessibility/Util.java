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
    AppMethodBeat.i(118645);
    if (paramView == null)
    {
      AppMethodBeat.o(118645);
      return null;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity))
      {
        paramView = (Activity)paramView;
        AppMethodBeat.o(118645);
        return paramView;
      }
    }
    AppMethodBeat.o(118645);
    return null;
  }
  
  public static String getViewIdName(View paramView)
  {
    AppMethodBeat.i(118646);
    if (paramView == null)
    {
      AppMethodBeat.o(118646);
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
      catch (Throwable paramView)
      {
        continue;
      }
      paramView = localStringBuilder.toString();
      AppMethodBeat.o(118646);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.Util
 * JD-Core Version:    0.7.0.1
 */