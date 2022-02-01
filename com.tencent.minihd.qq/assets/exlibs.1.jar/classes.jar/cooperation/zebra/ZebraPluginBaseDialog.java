package cooperation.zebra;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class ZebraPluginBaseDialog
  extends Dialog
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  public ZebraPluginBaseDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    float f = paramInt1 / paramInt2;
    if (f > 0.667F) {
      return 0;
    }
    if (f < 0.6F) {
      return 1;
    }
    return 2;
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected int a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      int i = paramContext.heightPixels;
      int k = paramContext.widthPixels;
      int j;
      if (k < i)
      {
        j = k;
        k = a(j, i);
        i -= j * 4 / 3;
        if (k != 1) {
          break label75;
        }
        j = a(getContext(), 44.0F);
        i -= j;
      }
      label75:
      while (k == 2)
      {
        return i;
        j = i;
        i = k;
        break;
      }
      return 108;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 108;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.zebra.ZebraPluginBaseDialog
 * JD-Core Version:    0.7.0.1
 */