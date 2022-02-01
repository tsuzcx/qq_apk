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
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class d
{
  LruCache<String, WeakReference<Bitmap>> cache;
  Context context;
  private MMHandler hAk;
  QueueWorkerThread ytV;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(25637);
    this.cache = new LruCache(50);
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.ytV = new QueueWorkerThread(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    this.context = paramContext;
    AppMethodBeat.o(25637);
  }
  
  private static String aCi(String paramString)
  {
    AppMethodBeat.i(25645);
    paramString = paramString + "@username";
    AppMethodBeat.o(25645);
    return paramString;
  }
  
  private static String aCj(String paramString)
  {
    AppMethodBeat.i(25646);
    paramString = paramString + "@contactId";
    AppMethodBeat.o(25646);
    return paramString;
  }
  
  private boolean b(String paramString1, String paramString2, ImageView paramImageView)
  {
    AppMethodBeat.i(25643);
    boolean bool = h(in(paramString1, paramString2), paramImageView);
    AppMethodBeat.o(25643);
    return bool;
  }
  
  private boolean e(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25640);
    boolean bool = h(aCj(paramString), paramImageView);
    AppMethodBeat.o(25640);
    return bool;
  }
  
  private boolean g(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25642);
    boolean bool = h(aCi(paramString), paramImageView);
    AppMethodBeat.o(25642);
    return bool;
  }
  
  private boolean h(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25644);
    Object localObject = (WeakReference)this.cache.get(paramString);
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
  
  public static String in(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25647);
    paramString1 = paramString1 + "@" + paramString2 + "@contactId@username";
    AppMethodBeat.o(25647);
    return paramString1;
  }
  
  public final void a(final String paramString1, final String paramString2, final ImageView paramImageView)
  {
    AppMethodBeat.i(25638);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramImageView == null))
    {
      AppMethodBeat.o(25638);
      return;
    }
    final String str = in(paramString1, paramString2);
    paramImageView.setTag(str);
    if (!b(paramString1, paramString2, paramImageView)) {
      this.ytV.add(new QueueWorkerThread.ThreadObject()
      {
        private boolean htV = false;
        
        public final boolean doInBackground()
        {
          AppMethodBeat.i(25631);
          Bitmap localBitmap = a.bd(d.this.context, paramString1);
          if (localBitmap != null)
          {
            d.this.cache.put(str, new WeakReference(localBitmap));
            this.htV = true;
            d.a(d.this, paramImageView, str, localBitmap);
          }
          AppMethodBeat.o(25631);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(25632);
          if (!this.htV)
          {
            d locald = d.this;
            String str2 = paramString1;
            String str1 = paramString2;
            ImageView localImageView = paramImageView;
            str2 = d.in(str2, str1);
            locald.ytV.add(new d.2(locald, str1, localImageView, str2));
          }
          AppMethodBeat.o(25632);
          return true;
        }
      });
    }
    AppMethodBeat.o(25638);
  }
  
  public final void d(final String paramString, final ImageView paramImageView)
  {
    AppMethodBeat.i(25639);
    if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25639);
      return;
    }
    final String str = aCj(paramString);
    paramImageView.setTag(str);
    if (!e(paramString, paramImageView)) {
      this.ytV.add(new QueueWorkerThread.ThreadObject()
      {
        public final boolean doInBackground()
        {
          AppMethodBeat.i(25634);
          Bitmap localBitmap = a.bd(d.this.context, paramString);
          d.a(d.this, paramImageView, str, localBitmap);
          AppMethodBeat.o(25634);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          return true;
        }
      });
    }
    AppMethodBeat.o(25639);
  }
  
  public final void f(final String paramString, final ImageView paramImageView)
  {
    AppMethodBeat.i(25641);
    if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25641);
      return;
    }
    final String str = aCi(paramString);
    paramImageView.setTag(str);
    if (!g(paramString, paramImageView)) {
      this.ytV.add(new QueueWorkerThread.ThreadObject()
      {
        public final boolean doInBackground()
        {
          AppMethodBeat.i(25635);
          Bitmap localBitmap2 = c.a(paramString, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 == null)
          {
            p.aYn();
            localBitmap1 = e.Mn(paramString);
          }
          d.a(d.this, paramImageView, str, localBitmap1);
          AppMethodBeat.o(25635);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          return false;
        }
      });
    }
    AppMethodBeat.o(25641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d
 * JD-Core Version:    0.7.0.1
 */