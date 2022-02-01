package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class d
{
  Context context;
  af<String, WeakReference<Bitmap>> fPf;
  private ao gox;
  bd tMW;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(25637);
    this.fPf = new af(50);
    this.gox = new ao(Looper.getMainLooper());
    this.tMW = new bd(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    this.context = paramContext;
    AppMethodBeat.o(25637);
  }
  
  private static String aiZ(String paramString)
  {
    AppMethodBeat.i(25645);
    paramString = paramString + "@username";
    AppMethodBeat.o(25645);
    return paramString;
  }
  
  private static String aja(String paramString)
  {
    AppMethodBeat.i(25646);
    paramString = paramString + "@contactId";
    AppMethodBeat.o(25646);
    return paramString;
  }
  
  private boolean b(String paramString1, String paramString2, ImageView paramImageView)
  {
    AppMethodBeat.i(25643);
    boolean bool = g(hm(paramString1, paramString2), paramImageView);
    AppMethodBeat.o(25643);
    return bool;
  }
  
  private boolean d(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25640);
    boolean bool = g(aja(paramString), paramImageView);
    AppMethodBeat.o(25640);
    return bool;
  }
  
  private boolean f(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25642);
    boolean bool = g(aiZ(paramString), paramImageView);
    AppMethodBeat.o(25642);
    return bool;
  }
  
  private boolean g(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25644);
    Object localObject = (WeakReference)this.fPf.get(paramString);
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
  
  public static String hm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25647);
    paramString1 = paramString1 + "@" + paramString2 + "@contactId@username";
    AppMethodBeat.o(25647);
    return paramString1;
  }
  
  public final void a(final String paramString1, final String paramString2, final ImageView paramImageView)
  {
    AppMethodBeat.i(25638);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (paramImageView == null))
    {
      AppMethodBeat.o(25638);
      return;
    }
    final String str = hm(paramString1, paramString2);
    paramImageView.setTag(str);
    if (!b(paramString1, paramString2, paramImageView)) {
      this.tMW.c(new bd.a()
      {
        private boolean gkQ = false;
        
        public final boolean aBj()
        {
          AppMethodBeat.i(25631);
          Bitmap localBitmap = a.aL(d.this.context, paramString1);
          if (localBitmap != null)
          {
            d.this.fPf.put(str, new WeakReference(localBitmap));
            this.gkQ = true;
            d.a(d.this, paramImageView, str, localBitmap);
          }
          AppMethodBeat.o(25631);
          return true;
        }
        
        public final boolean aBk()
        {
          AppMethodBeat.i(25632);
          if (!this.gkQ)
          {
            d locald = d.this;
            String str2 = paramString1;
            String str1 = paramString2;
            ImageView localImageView = paramImageView;
            str2 = d.hm(str2, str1);
            locald.tMW.c(new d.2(locald, str1, localImageView, str2));
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
    if ((bs.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25639);
      return;
    }
    final String str = aja(paramString);
    paramImageView.setTag(str);
    if (!d(paramString, paramImageView)) {
      this.tMW.c(new bd.a()
      {
        public final boolean aBj()
        {
          AppMethodBeat.i(25634);
          Bitmap localBitmap = a.aL(d.this.context, paramString);
          d.a(d.this, paramImageView, str, localBitmap);
          AppMethodBeat.o(25634);
          return true;
        }
        
        public final boolean aBk()
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
    if ((bs.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25641);
      return;
    }
    final String str = aiZ(paramString);
    paramImageView.setTag(str);
    if (!f(paramString, paramImageView)) {
      this.tMW.c(new bd.a()
      {
        public final boolean aBj()
        {
          AppMethodBeat.i(25635);
          Bitmap localBitmap2 = c.a(paramString, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 == null)
          {
            p.aBh();
            localBitmap1 = e.Ab(paramString);
          }
          d.a(d.this, paramImageView, str, localBitmap1);
          AppMethodBeat.o(25635);
          return true;
        }
        
        public final boolean aBk()
        {
          return false;
        }
      });
    }
    AppMethodBeat.o(25641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d
 * JD-Core Version:    0.7.0.1
 */