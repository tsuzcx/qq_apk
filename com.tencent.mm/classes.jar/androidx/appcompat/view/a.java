package androidx.appcompat.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.appcompat.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public Context mContext;
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a I(Context paramContext)
  {
    AppMethodBeat.i(200638);
    paramContext = new a(paramContext);
    AppMethodBeat.o(200638);
    return paramContext;
  }
  
  public final int cr()
  {
    AppMethodBeat.i(200655);
    Configuration localConfiguration = this.mContext.getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((localConfiguration.smallestScreenWidthDp > 600) || (i > 600) || ((i > 960) && (j > 720)) || ((i > 720) && (j > 960)))
    {
      AppMethodBeat.o(200655);
      return 5;
    }
    if ((i >= 500) || ((i > 640) && (j > 480)) || ((i > 480) && (j > 640)))
    {
      AppMethodBeat.o(200655);
      return 4;
    }
    if (i >= 360)
    {
      AppMethodBeat.o(200655);
      return 3;
    }
    AppMethodBeat.o(200655);
    return 2;
  }
  
  public final boolean cs()
  {
    AppMethodBeat.i(200664);
    boolean bool = this.mContext.getResources().getBoolean(a.b.abc_action_bar_embed_tabs);
    AppMethodBeat.o(200664);
    return bool;
  }
  
  public final boolean ct()
  {
    AppMethodBeat.i(200674);
    if (this.mContext.getApplicationInfo().targetSdkVersion < 14)
    {
      AppMethodBeat.o(200674);
      return true;
    }
    AppMethodBeat.o(200674);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.a
 * JD-Core Version:    0.7.0.1
 */