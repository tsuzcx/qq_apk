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
    ActivityChooserView localActivityChooserView = this.YX;
    if (localActivityChooserView.YH.getCount() > 0)
    {
      localActivityChooserView.YL.setEnabled(true);
      int i = localActivityChooserView.YH.YY.fO();
      int j = localActivityChooserView.YH.YY.getHistorySize();
      if ((i != 1) && ((i <= 1) || (j <= 0))) {
        break label186;
      }
      localActivityChooserView.YN.setVisibility(0);
      Object localObject = localActivityChooserView.YH.YY.fP();
      PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
      localActivityChooserView.YO.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (localActivityChooserView.YW != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = localActivityChooserView.getContext().getString(localActivityChooserView.YW, new Object[] { localObject });
        localActivityChooserView.YN.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (localActivityChooserView.YN.getVisibility() != 0) {
        break label198;
      }
      localActivityChooserView.YJ.setBackgroundDrawable(localActivityChooserView.YK);
      return;
      localActivityChooserView.YL.setEnabled(false);
      break;
      label186:
      localActivityChooserView.YN.setVisibility(8);
    }
    label198:
    localActivityChooserView.YJ.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.5
 * JD-Core Version:    0.7.0.1
 */