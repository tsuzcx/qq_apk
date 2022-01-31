package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public final class d
{
  Context context;
  ae<String, WeakReference<Bitmap>> evq;
  private ak faV;
  az nRu;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(22021);
    this.evq = new ae(50);
    this.faV = new ak(Looper.getMainLooper());
    this.nRu = new az(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    this.context = paramContext;
    AppMethodBeat.o(22021);
  }
  
  private static String Rn(String paramString)
  {
    AppMethodBeat.i(22029);
    paramString = paramString + "@username";
    AppMethodBeat.o(22029);
    return paramString;
  }
  
  private static String Ro(String paramString)
  {
    AppMethodBeat.i(22030);
    paramString = paramString + "@contactId";
    AppMethodBeat.o(22030);
    return paramString;
  }
  
  private boolean b(String paramString1, String paramString2, ImageView paramImageView)
  {
    AppMethodBeat.i(22027);
    boolean bool = g(eU(paramString1, paramString2), paramImageView);
    AppMethodBeat.o(22027);
    return bool;
  }
  
  private boolean d(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(22024);
    boolean bool = g(Ro(paramString), paramImageView);
    AppMethodBeat.o(22024);
    return bool;
  }
  
  public static String eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22031);
    paramString1 = paramString1 + "@" + paramString2 + "@contactId@username";
    AppMethodBeat.o(22031);
    return paramString1;
  }
  
  private boolean f(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(22026);
    boolean bool = g(Rn(paramString), paramImageView);
    AppMethodBeat.o(22026);
    return bool;
  }
  
  private boolean g(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(22028);
    Object localObject = (WeakReference)this.evq.get(paramString);
    if (localObject != null)
    {
      localObject = (Bitmap)((WeakReference)localObject).get();
      if ((localObject != null) && (paramImageView.getTag() != null) && (paramImageView.getTag().toString().equals(paramString)))
      {
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
          paramImageView.setImageBitmap((Bitmap)localObject);
        }
        AppMethodBeat.o(22028);
        return true;
      }
    }
    AppMethodBeat.o(22028);
    return false;
  }
  
  public final void a(String paramString1, String paramString2, ImageView paramImageView)
  {
    AppMethodBeat.i(22022);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (paramImageView == null))
    {
      AppMethodBeat.o(22022);
      return;
    }
    String str = eU(paramString1, paramString2);
    paramImageView.setTag(str);
    if (!b(paramString1, paramString2, paramImageView)) {
      this.nRu.e(new d.1(this, paramString1, str, paramImageView, paramString2));
    }
    AppMethodBeat.o(22022);
  }
  
  public final void c(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(22023);
    if ((bo.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(22023);
      return;
    }
    String str = Ro(paramString);
    paramImageView.setTag(str);
    if (!d(paramString, paramImageView)) {
      this.nRu.e(new d.3(this, paramString, paramImageView, str));
    }
    AppMethodBeat.o(22023);
  }
  
  public final void e(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(22025);
    if ((bo.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(22025);
      return;
    }
    String str = Rn(paramString);
    paramImageView.setTag(str);
    if (!f(paramString, paramImageView)) {
      this.nRu.e(new d.4(this, paramString, paramImageView, str));
    }
    AppMethodBeat.o(22025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d
 * JD-Core Version:    0.7.0.1
 */