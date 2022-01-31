package com.tencent.mm.plugin.gallery.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

final class a$c
  implements Runnable
{
  private static HashMap<TextView, c> kHN = new HashMap();
  private WeakReference<TextView> jQH;
  private GalleryItem.VideoMediaItem kHL;
  private a.c.a kHM;
  
  private a$c(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, a.c.a parama)
  {
    this.jQH = new WeakReference(paramTextView);
    this.kHL = paramVideoMediaItem;
    this.kHM = parama;
  }
  
  static void a(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    Object localObject = null;
    if ((paramTextView == null) || (paramVideoMediaItem == null)) {
      y.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
    }
    do
    {
      return;
      if (!kHN.containsKey(paramTextView)) {
        break;
      }
      localc = (c)kHN.get(paramTextView);
    } while (localc.kHL.equals(paramVideoMediaItem));
    if (paramTextView.equals(localc.jQH.get())) {
      localc.f(null);
    }
    if (paramVideoMediaItem.eAx >= 0)
    {
      y.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.eAx), paramVideoMediaItem });
      d(paramTextView, paramVideoMediaItem.eAx);
      kHN.remove(paramTextView);
      return;
    }
    paramTextView.setText("");
    c localc = new c(paramTextView, paramVideoMediaItem, new a.c.2());
    if (e.ad(localc))
    {
      y.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
      Iterator localIterator = kHN.entrySet().iterator();
      do
      {
        paramVideoMediaItem = localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramVideoMediaItem = (Map.Entry)localIterator.next();
      } while (!localc.equals(paramVideoMediaItem.getValue()));
      if ((paramVideoMediaItem == null) || (paramVideoMediaItem.getValue() == null))
      {
        y.e("MicroMsg.AlbumAdapter", "no entry found");
        return;
      }
      ((c)paramVideoMediaItem.getValue()).f(paramTextView);
      kHN.remove(paramVideoMediaItem.getKey());
      kHN.put(paramTextView, paramVideoMediaItem.getValue());
      return;
    }
    e.post(localc, "load_duration_for_" + paramVideoMediaItem.eAu);
    kHN.put(paramTextView, localc);
  }
  
  private static void d(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramInt < 0)
    {
      paramTextView.setText("--:--");
      return;
    }
    paramInt = Math.round(paramInt / 1000.0F);
    paramTextView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) }));
  }
  
  private void f(TextView paramTextView)
  {
    this.jQH = new WeakReference(paramTextView);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof c))) {
      return false;
    }
    return this.kHL.equals(((c)paramObject).kHL);
  }
  
  public final int hashCode()
  {
    return this.kHL.hashCode();
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: new 218	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 219	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: aload_2
    //   11: aload_0
    //   12: getfield 42	com/tencent/mm/plugin/gallery/ui/a$c:kHL	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;
    //   15: invokevirtual 222	com/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem:aXs	()Ljava/lang/String;
    //   18: invokevirtual 225	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload_2
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 42	com/tencent/mm/plugin/gallery/ui/a$c:kHL	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;
    //   27: aload_2
    //   28: bipush 9
    //   30: invokevirtual 229	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   33: iconst_m1
    //   34: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   37: putfield 82	com/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem:eAx	I
    //   40: aload_2
    //   41: invokevirtual 238	android/media/MediaMetadataRetriever:release	()V
    //   44: invokestatic 244	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   47: invokestatic 247	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   50: if_acmpne +156 -> 206
    //   53: aload_0
    //   54: getfield 44	com/tencent/mm/plugin/gallery/ui/a$c:kHM	Lcom/tencent/mm/plugin/gallery/ui/a$c$a;
    //   57: ifnull +20 -> 77
    //   60: aload_0
    //   61: getfield 44	com/tencent/mm/plugin/gallery/ui/a$c:kHM	Lcom/tencent/mm/plugin/gallery/ui/a$c$a;
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 42	com/tencent/mm/plugin/gallery/ui/a$c:kHL	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;
    //   69: getfield 82	com/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem:eAx	I
    //   72: invokeinterface 250 3 0
    //   77: return
    //   78: astore_1
    //   79: ldc 49
    //   81: aload_1
    //   82: ldc 252
    //   84: iconst_1
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_1
    //   91: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   94: aastore
    //   95: invokestatic 259	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: goto -54 -> 44
    //   101: astore_3
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: astore_1
    //   106: ldc 49
    //   108: aload_3
    //   109: ldc_w 261
    //   112: iconst_2
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_0
    //   119: getfield 42	com/tencent/mm/plugin/gallery/ui/a$c:kHL	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;
    //   122: getfield 169	com/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem:eAu	Ljava/lang/String;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_3
    //   129: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 259	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_2
    //   137: ifnull -93 -> 44
    //   140: aload_2
    //   141: invokevirtual 238	android/media/MediaMetadataRetriever:release	()V
    //   144: goto -100 -> 44
    //   147: astore_1
    //   148: ldc 49
    //   150: aload_1
    //   151: ldc 252
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 259	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: goto -123 -> 44
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 238	android/media/MediaMetadataRetriever:release	()V
    //   181: aload_2
    //   182: athrow
    //   183: astore_1
    //   184: ldc 49
    //   186: aload_1
    //   187: ldc 252
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_1
    //   196: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   199: aastore
    //   200: invokestatic 259	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: goto -22 -> 181
    //   206: new 263	com/tencent/mm/plugin/gallery/ui/a$c$1
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 266	com/tencent/mm/plugin/gallery/ui/a$c$1:<init>	(Lcom/tencent/mm/plugin/gallery/ui/a$c;)V
    //   214: invokestatic 271	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   217: return
    //   218: astore_2
    //   219: goto -46 -> 173
    //   222: astore_3
    //   223: goto -119 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	c
    //   9	14	1	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   78	13	1	localException1	java.lang.Exception
    //   105	1	1	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   147	13	1	localException2	java.lang.Exception
    //   172	6	1	localObject1	Object
    //   183	13	1	localException3	java.lang.Exception
    //   7	134	2	localMediaMetadataRetriever3	android.media.MediaMetadataRetriever
    //   170	12	2	localObject2	Object
    //   218	1	2	localObject3	Object
    //   101	28	3	localException4	java.lang.Exception
    //   222	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   40	44	78	java/lang/Exception
    //   0	8	101	java/lang/Exception
    //   140	144	147	java/lang/Exception
    //   0	8	170	finally
    //   177	181	183	java/lang/Exception
    //   10	21	218	finally
    //   23	40	218	finally
    //   106	136	218	finally
    //   10	21	222	java/lang/Exception
    //   23	40	222	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.c
 * JD-Core Version:    0.7.0.1
 */