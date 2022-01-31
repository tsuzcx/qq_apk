package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public final class y
{
  public static final class a
  {
    private Activity mActivity;
    public Intent mIntent;
    public ArrayList<String> zt;
    public ArrayList<String> zu;
    public ArrayList<String> zv;
    public ArrayList<Uri> zw;
    
    public a(Activity paramActivity)
    {
      this.mActivity = paramActivity;
      this.mIntent = new Intent().setAction("android.intent.action.SEND");
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramActivity.getPackageName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramActivity.getComponentName());
      this.mIntent.addFlags(524288);
    }
    
    public final void a(String paramString, ArrayList<String> paramArrayList)
    {
      String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
      if (arrayOfString1 != null) {}
      for (int i = arrayOfString1.length;; i = 0)
      {
        String[] arrayOfString2 = new String[paramArrayList.size() + i];
        paramArrayList.toArray(arrayOfString2);
        if (arrayOfString1 != null) {
          System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
        }
        this.mIntent.putExtra(paramString, arrayOfString2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.y
 * JD-Core Version:    0.7.0.1
 */