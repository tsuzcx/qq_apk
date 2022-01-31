package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;

public final class d
{
  Context context;
  private ah dPi = new ah(Looper.getMainLooper());
  av lub = new av(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
  ab<String, WeakReference<Bitmap>> luc = new ab(50);
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static String FL(String paramString)
  {
    return paramString + "@username";
  }
  
  private static String FM(String paramString)
  {
    return paramString + "@contactId";
  }
  
  public static String dC(String paramString1, String paramString2)
  {
    return paramString1 + "@" + paramString2 + "@contactId@username";
  }
  
  private boolean e(String paramString, ImageView paramImageView)
  {
    Object localObject = (WeakReference)this.luc.get(paramString);
    if (localObject != null)
    {
      localObject = (Bitmap)((WeakReference)localObject).get();
      if ((localObject != null) && (paramImageView.getTag() != null) && (paramImageView.getTag().toString().equals(paramString)))
      {
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
          paramImageView.setImageBitmap((Bitmap)localObject);
        }
        return true;
      }
    }
    return false;
  }
  
  public final void a(String paramString1, String paramString2, ImageView paramImageView)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (paramImageView == null)) {}
    String str;
    do
    {
      return;
      str = dC(paramString1, paramString2);
      paramImageView.setTag(str);
    } while (e(dC(paramString1, paramString2), paramImageView));
    this.lub.c(new d.1(this, paramString1, str, paramImageView, paramString2));
  }
  
  public final void c(String paramString, ImageView paramImageView)
  {
    if ((bk.bl(paramString)) || (paramImageView == null)) {}
    String str;
    do
    {
      return;
      str = FM(paramString);
      paramImageView.setTag(str);
    } while (e(FM(paramString), paramImageView));
    this.lub.c(new d.3(this, paramString, paramImageView, str));
  }
  
  public final void d(String paramString, ImageView paramImageView)
  {
    if ((bk.bl(paramString)) || (paramImageView == null)) {}
    String str;
    do
    {
      return;
      str = FL(paramString);
      paramImageView.setTag(str);
    } while (e(FL(paramString), paramImageView));
    this.lub.c(new d.4(this, paramString, paramImageView, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d
 * JD-Core Version:    0.7.0.1
 */