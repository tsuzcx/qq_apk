package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class d
{
  QueueWorkerThread JLj;
  LruCache<String, WeakReference<Bitmap>> cache;
  Context context;
  private MMHandler mRi;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(25637);
    this.cache = new LruCache(50);
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.JLj = new QueueWorkerThread(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    this.context = paramContext;
    AppMethodBeat.o(25637);
  }
  
  private static String aJj(String paramString)
  {
    AppMethodBeat.i(25645);
    paramString = paramString + "@username";
    AppMethodBeat.o(25645);
    return paramString;
  }
  
  private static String aJk(String paramString)
  {
    AppMethodBeat.i(25646);
    paramString = paramString + "@contactId";
    AppMethodBeat.o(25646);
    return paramString;
  }
  
  private boolean b(String paramString1, String paramString2, ImageView paramImageView)
  {
    AppMethodBeat.i(25643);
    boolean bool = i(jK(paramString1, paramString2), paramImageView);
    AppMethodBeat.o(25643);
    return bool;
  }
  
  private boolean f(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25640);
    boolean bool = i(aJk(paramString), paramImageView);
    AppMethodBeat.o(25640);
    return bool;
  }
  
  private boolean h(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(25642);
    boolean bool = i(aJj(paramString), paramImageView);
    AppMethodBeat.o(25642);
    return bool;
  }
  
  private boolean i(String paramString, ImageView paramImageView)
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
  
  public static String jK(String paramString1, String paramString2)
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
    final String str = jK(paramString1, paramString2);
    paramImageView.setTag(str);
    if (!b(paramString1, paramString2, paramImageView)) {
      this.JLj.add(new QueueWorkerThread.ThreadObject()
      {
        private boolean hKy = false;
        
        public final boolean doInBackground()
        {
          AppMethodBeat.i(25631);
          Bitmap localBitmap = a.br(d.this.context, paramString1);
          if (localBitmap != null)
          {
            d.this.cache.put(str, new WeakReference(localBitmap));
            this.hKy = true;
            d.a(d.this, paramImageView, str, localBitmap);
          }
          AppMethodBeat.o(25631);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(25632);
          if (!this.hKy)
          {
            d locald = d.this;
            String str2 = paramString1;
            String str1 = paramString2;
            ImageView localImageView = paramImageView;
            str2 = d.jK(str2, str1);
            locald.JLj.add(new d.2(locald, str1, localImageView, str2));
          }
          AppMethodBeat.o(25632);
          return true;
        }
      });
    }
    AppMethodBeat.o(25638);
  }
  
  public final void e(final String paramString, final ImageView paramImageView)
  {
    AppMethodBeat.i(25639);
    if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25639);
      return;
    }
    final String str = aJk(paramString);
    paramImageView.setTag(str);
    if (!f(paramString, paramImageView)) {
      this.JLj.add(new QueueWorkerThread.ThreadObject()
      {
        public final boolean doInBackground()
        {
          AppMethodBeat.i(25634);
          Bitmap localBitmap = a.br(d.this.context, paramString);
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
  
  public final void g(final String paramString, final ImageView paramImageView)
  {
    AppMethodBeat.i(25641);
    if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(25641);
      return;
    }
    final String str = aJj(paramString);
    paramImageView.setTag(str);
    if (!h(paramString, paramImageView)) {
      this.JLj.add(new QueueWorkerThread.ThreadObject()
      {
        public final boolean doInBackground()
        {
          AppMethodBeat.i(25635);
          Bitmap localBitmap2 = com.tencent.mm.modelavatar.d.a(paramString, false, -1, null);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 == null)
          {
            q.bFp();
            localBitmap1 = AvatarStorage.LI(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d
 * JD-Core Version:    0.7.0.1
 */