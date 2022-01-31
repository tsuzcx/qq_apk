package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

final class bb
{
  final View QR;
  final WindowManager.LayoutParams anh = new WindowManager.LayoutParams();
  final Rect ani = new Rect();
  final int[] anj = new int[2];
  final int[] ank = new int[2];
  final TextView ee;
  final Context mContext;
  
  bb(Context paramContext)
  {
    this.mContext = paramContext;
    this.QR = LayoutInflater.from(this.mContext).inflate(a.g.abc_tooltip, null);
    this.ee = ((TextView)this.QR.findViewById(a.f.message));
    this.anh.setTitle(getClass().getSimpleName());
    this.anh.packageName = this.mContext.getPackageName();
    this.anh.type = 1002;
    this.anh.width = -2;
    this.anh.height = -2;
    this.anh.format = -3;
    this.anh.windowAnimations = a.i.Animation_AppCompat_Tooltip;
    this.anh.flags = 24;
  }
  
  final void hide()
  {
    if (!isShowing()) {
      return;
    }
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.QR);
  }
  
  final boolean isShowing()
  {
    return this.QR.getParent() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bb
 * JD-Core Version:    0.7.0.1
 */