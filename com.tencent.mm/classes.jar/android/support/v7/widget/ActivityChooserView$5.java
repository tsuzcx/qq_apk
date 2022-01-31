package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

final class ActivityChooserView$5
  extends DataSetObserver
{
  ActivityChooserView$5(ActivityChooserView paramActivityChooserView) {}
  
  public final void onChanged()
  {
    super.onChanged();
    ActivityChooserView localActivityChooserView = this.ZI;
    if (localActivityChooserView.Zs.getCount() > 0)
    {
      localActivityChooserView.Zw.setEnabled(true);
      int i = localActivityChooserView.Zs.ZJ.gI();
      int j = localActivityChooserView.Zs.ZJ.getHistorySize();
      if ((i != 1) && ((i <= 1) || (j <= 0))) {
        break label186;
      }
      localActivityChooserView.Zy.setVisibility(0);
      Object localObject = localActivityChooserView.Zs.ZJ.gJ();
      PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
      localActivityChooserView.Zz.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (localActivityChooserView.ZH != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = localActivityChooserView.getContext().getString(localActivityChooserView.ZH, new Object[] { localObject });
        localActivityChooserView.Zy.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (localActivityChooserView.Zy.getVisibility() != 0) {
        break label198;
      }
      localActivityChooserView.Zu.setBackgroundDrawable(localActivityChooserView.Zv);
      return;
      localActivityChooserView.Zw.setEnabled(false);
      break;
      label186:
      localActivityChooserView.Zy.setVisibility(8);
    }
    label198:
    localActivityChooserView.Zu.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.5
 * JD-Core Version:    0.7.0.1
 */