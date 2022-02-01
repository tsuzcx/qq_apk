package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.p;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class d
{
  Context context;
  ag<String, WeakReference<Bitmap>> fLt;
  private ap gAC;
  be sFp;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(25637);
    this.fLt = new ag(50);
    this.gAC = new ap(Looper.getMainLooper());
    this.sFp = new be(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    this.context = paramContext;
    AppMethodBeat.o(25637);
  }
  
  private static String aeh(String paramString)
  {
    AppMethodBeat.i(25645);
    paramString = paramString + "@username";
    AppMethodBeat.o(25645);
    return paramString;
  }
  
  private static String aei(String paramString)
  {
    AppMethodBeat.i(25646);
    paramString = paramString + "@contactId";
    AppMethodBeat.o(25646);
    return paramString;
  }
  
  private boolean b(String paramString1, String paramString2, ImageView paramImageView)
  {
    AppMethodBeat.i(25643);
    boolean bool = g(gV(paramString1, paramString2), paramImageView);
    AppMethodBeat.o(25643);
    return bool;
  }
  
  private boolean d(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25640);
    boolean bool = g(aei(paramString), paramImageView);
    AppMethodBeat.o(25640);
    return bool;
  }
  
  private boolean f(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25642);
    boolean bool = g(aeh(paramString), paramImageView);
    AppMethodBeat.o(25642);
    return bool;
  }
  
  private boolean g(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25644);
    Object localObject = (WeakReference)this.fLt.get(paramString);
    if (localObject != null)
    {
      localObject = (Bitmap)((WeakReference)localObject).get();
      if ((localObject != null) && (paramImageView.getTag() != null) && (paramImageView.getTag().toString().equals(paramString)))
      {
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
          paramImageView.setImageBitmap((Bitmap)localObject);
        }
        AppMethodBeat.o(25644);
        return true;
      }
    }
    AppMethodBeat.o(25644);
    return false;
  }
  
  public static String gV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25647);
    paramString1 = paramString1 + "@" + paramString2 + "@contactId@username";
    AppMethodBeat.o(25647);
    return paramString1;
  }
  
  public final void a(final String paramString1, final String paramString2, final ImageView paramImageView)
  {
    AppMethodBeat.i(25638);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (paramImageView == null))
    {
      AppMethodBeat.o(25638);
      return;
    }
    final String str = gV(paramString1, paramString2);
    paramImageView.setTag(str);
    if (!b(paramString1, paramString2, paramImageView)) {
      this.sFp.c(new be.a()
      {
        private boolean ggk = false;
        
        public final boolean aus()
        {
          AppMethodBeat.i(25631);
          Bitmap localBitmap = a.aK(d.this.context, paramString1);
          if (localBitmap != null)
          {
            d.this.fLt.put(str, new WeakReference(localBitmap));
            this.ggk = true;
            d.a(d.this, paramImageView, str, localBitmap);
          }
          AppMethodBeat.o(25631);
          return true;
        }
        
        public final boolean aut()
        {
          AppMethodBeat.i(25632);
          if (!this.ggk)
          {
            d locald = d.this;
            String str2 = paramString1;
            String str1 = paramString2;
            ImageView localImageView = paramImageView;
            str2 = d.gV(str2, str1);
            locald.sFp.c(new d.2(locald, str1, localImageView, str2));
          }
          AppMethodBeat.o(25632);
          return true;
        }
      });
    }
    AppMethodBeat.o(25638);
  }
  
  public final void c(final String paramString, final ImageView paramImageView)
  {
    AppMethodBeat.i(25639);
    if ((bt.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25639);
      return;
    }
    final String str = aei(paramString);
    paramImageView.setTag(str);
    if (!d(paramString, paramImageView)) {
      this.sFp.c(new be.a()
      {
        public final boolean aus()
        {
          AppMethodBeat.i(25634);
          Bitmap localBitmap = a.aK(d.this.context, paramString);
          d.a(d.this, paramImageView, str, localBitmap);
          AppMethodBeat.o(25634);
          return true;
        }
        
        public final boolean aut()
        {
          return true;
        }
      });
    }
    AppMethodBeat.o(25639);
  }
  
  public final void e(final String paramString, final ImageView paramImageView)
  {
    AppMethodBeat.i(25641);
    if ((bt.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25641);
      return;
    }
    final String str = aeh(paramString);
    paramImageView.setTag(str);
    if (!f(paramString, paramImageView)) {
      this.sFp.c(new be.a()
      {
        public final boolean aus()
        {
          AppMethodBeat.i(25635);
          Bitmap localBitmap2 = c.a(paramString, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 == null)
          {
            p.auq();
            localBitmap1 = e.vV(paramString);
          }
          d.a(d.this, paramImageView, str, localBitmap1);
          AppMethodBeat.o(25635);
          return true;
        }
        
        public final boolean aut()
        {
          return false;
        }
      });
    }
    AppMethodBeat.o(25641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d
 * JD-Core Version:    0.7.0.1
 */