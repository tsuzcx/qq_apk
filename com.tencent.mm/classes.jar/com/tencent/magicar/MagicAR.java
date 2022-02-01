package com.tencent.magicar;

import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import java.util.ArrayList;

public class MagicAR
  implements a.a
{
  private byte _hellAccFlag_;
  private Context mContext;
  private a mDislayOrientationHelper;
  private long mInst;
  
  public MagicAR(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDislayOrientationHelper = new a(this.mContext);
    paramContext = this.mDislayOrientationHelper;
    paramContext.mListeners.add(this);
    paramContext.eGt.enable();
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("opencv_world");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramContext.aYi(), "com/tencent/magicar/MagicAR", "<init>", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramContext.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/magicar/MagicAR", "<init>", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("wechatxlog");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramContext.aYi(), "com/tencent/magicar/MagicAR", "<init>", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramContext.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/magicar/MagicAR", "<init>", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("magic-ar");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramContext.aYi(), "com/tencent/magicar/MagicAR", "<init>", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramContext.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/magicar/MagicAR", "<init>", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    nativeNotifyOrientationChanged(((WindowManager)this.mDislayOrientationHelper.mContext.getSystemService("window")).getDefaultDisplay().getRotation());
    this.mInst = nativeCreate();
  }
  
  public void bindTo(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.mInst != 0L) {
      nativeBindTo(this.mInst, paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void destroy()
  {
    if (this.mInst != 0L) {
      nativeDestroy(this.mInst);
    }
    for (;;)
    {
      a locala = this.mDislayOrientationHelper;
      locala.mListeners.remove(this);
      if (locala.mListeners.size() == 0) {
        locala.eGt.disable();
      }
      return;
      this.mInst = 0L;
    }
  }
  
  protected native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  protected native long nativeCreate();
  
  protected native void nativeDestroy(long paramLong);
  
  protected native void nativeNotifyOrientationChanged(int paramInt);
  
  public void onDisplayOrientationChanged(int paramInt)
  {
    nativeNotifyOrientationChanged(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicar.MagicAR
 * JD-Core Version:    0.7.0.1
 */