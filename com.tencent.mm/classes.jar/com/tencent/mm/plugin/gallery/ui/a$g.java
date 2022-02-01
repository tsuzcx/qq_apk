package com.tencent.mm.plugin.gallery.ui;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$g
  implements Runnable
{
  private static HashMap<TextView, g> xnK;
  private boolean ifz;
  private WeakReference<TextView> sTx;
  private GalleryItem.VideoMediaItem xnI;
  private a xnJ;
  
  static
  {
    AppMethodBeat.i(111406);
    xnK = new HashMap();
    AppMethodBeat.o(111406);
  }
  
  private a$g(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
  {
    AppMethodBeat.i(111397);
    this.sTx = new WeakReference(paramTextView);
    this.xnI = paramVideoMediaItem;
    this.xnJ = parama;
    AppMethodBeat.o(111397);
  }
  
  public static void a(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111399);
    if ((paramTextView == null) || (paramVideoMediaItem == null))
    {
      Log.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
      AppMethodBeat.o(111399);
      return;
    }
    if (xnK.containsKey(paramTextView))
    {
      g localg = (g)xnK.get(paramTextView);
      if (localg != null)
      {
        if (localg.xnI.equals(paramVideoMediaItem))
        {
          AppMethodBeat.o(111399);
          return;
        }
        if (paramTextView.equals(localg.sTx.get()))
        {
          localg.sTx = new WeakReference(null);
          localg.ifz = true;
        }
      }
    }
    if (paramVideoMediaItem.jkS >= 0)
    {
      Log.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.jkS), paramVideoMediaItem });
      j(paramTextView, paramVideoMediaItem.jkS);
      xnK.remove(paramTextView);
      AppMethodBeat.o(111399);
      return;
    }
    paramTextView.setText("");
    paramVideoMediaItem = new g(paramTextView, paramVideoMediaItem, new a()
    {
      public final void a(a.g paramAnonymousg, int paramAnonymousInt)
      {
        AppMethodBeat.i(111396);
        if ((paramAnonymousg == null) || (a.g.c(paramAnonymousg) == null))
        {
          AppMethodBeat.o(111396);
          return;
        }
        paramAnonymousg = (TextView)a.g.c(paramAnonymousg).get();
        if (paramAnonymousg == null)
        {
          AppMethodBeat.o(111396);
          return;
        }
        a.g.k(paramAnonymousg, paramAnonymousInt);
        a.g.dRT().remove(paramAnonymousg);
        AppMethodBeat.o(111396);
      }
    });
    e.dQL().aq(paramVideoMediaItem);
    xnK.put(paramTextView, paramVideoMediaItem);
    AppMethodBeat.o(111399);
  }
  
  private static boolean ayX(String paramString)
  {
    AppMethodBeat.i(173745);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skT, "");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(173745);
      return false;
    }
    Log.i("MicroMsg.AlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
    Log.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Object localObject2 = ((JSONObject)localObject1).optString("devices");
      int j = ((JSONObject)localObject1).optInt("maxsize");
      localObject1 = new JSONArray((String)localObject2);
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if ((Build.MANUFACTURER.equalsIgnoreCase(((JSONObject)localObject2).optString("brand"))) && (Build.MODEL.equalsIgnoreCase(((JSONObject)localObject2).optString("model"))))
        {
          long l = s.boW(paramString);
          if ((j != 0) && (l > j * 1024 * 1024))
          {
            Log.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
            AppMethodBeat.o(173745);
            return false;
          }
          int k = ((JSONObject)localObject2).optInt("androidVersion");
          if (-1 == k)
          {
            Log.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
            AppMethodBeat.o(173745);
            return true;
          }
          if (Build.VERSION.SDK_INT == k)
          {
            Log.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
            AppMethodBeat.o(173745);
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.AlbumAdapter", paramString, "parse json error", new Object[0]);
      AppMethodBeat.o(173745);
    }
  }
  
  public static void dRR()
  {
    AppMethodBeat.i(111398);
    xnK.clear();
    AppMethodBeat.o(111398);
  }
  
  private void dRS()
  {
    AppMethodBeat.i(173746);
    if (this.xnI == null)
    {
      AppMethodBeat.o(173746);
      return;
    }
    long l = Util.currentTicks();
    try
    {
      String str = this.xnI.aQn();
      Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
      Log.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      this.xnI.jkS = ((JSONObject)localObject).getInt("videoDuration");
      this.xnI.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
      this.xnI.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
      this.xnI.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
      this.xnI.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
      this.xnI.ihS = SightVideoJNI.getMp4RotateVFS(str);
      this.xnI.videoIFrameInterval = 0;
      this.xnI.jkQ = com.tencent.mm.plugin.gallery.a.b.azg(((JSONObject)localObject).getString("videoType"));
      this.xnI.jkR = com.tencent.mm.plugin.gallery.a.b.azg(((JSONObject)localObject).getString("audioType"));
      Log.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.xnI });
      Log.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(173746);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AlbumAdapter", localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
      }
    }
  }
  
  private static void j(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(111400);
    if (paramTextView == null)
    {
      AppMethodBeat.o(111400);
      return;
    }
    if (paramInt < 0)
    {
      paramTextView.setText("--:--");
      AppMethodBeat.o(111400);
      return;
    }
    paramInt = Math.round(paramInt / 1000.0F);
    String str2 = String.valueOf(paramInt % 60);
    String str1 = str2;
    if (str2.length() < 2) {
      str1 = "0".concat(String.valueOf(str2));
    }
    paramTextView.setText(paramInt / 60 + ":" + str1);
    AppMethodBeat.o(111400);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(111401);
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(111401);
      return false;
    }
    boolean bool = this.xnI.equals(((g)paramObject).xnI);
    AppMethodBeat.o(111401);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(111402);
    int i = this.xnI.hashCode();
    AppMethodBeat.o(111402);
    return i;
  }
  
  public final void run()
  {
    AppMethodBeat.i(111404);
    if (this.ifz)
    {
      AppMethodBeat.o(111404);
      return;
    }
    int i;
    label123:
    long l;
    c localc;
    String str1;
    if (ayX(this.xnI.aQn()))
    {
      dRS();
      if (this.ifz) {
        break label818;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        if (this.xnJ != null) {
          this.xnJ.a(this, this.xnI.jkS);
        }
        AppMethodBeat.o(111404);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skt, 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label123;
        }
        dRS();
        break;
      }
      l = Util.currentTicks();
      localc = new c();
      str1 = this.xnI.aQn();
    }
    for (;;)
    {
      Object localObject4;
      Object localObject7;
      Object localObject8;
      try
      {
        localc.setDataSource(str1);
        int j = localc.gLF.getTrackCount();
        localObject1 = null;
        localObject4 = null;
        i = 0;
        localObject5 = localObject4;
        localObject6 = localObject1;
        if (i < j)
        {
          localMediaFormat = localc.getTrackFormat(i);
          if (!localMediaFormat.containsKey("mime"))
          {
            Log.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
            localObject7 = localObject4;
            localObject8 = localObject1;
            break label825;
          }
          str2 = localMediaFormat.getString("mime");
          Log.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
          localObject7 = localObject4;
          localObject8 = localObject1;
          if (str2 == null) {
            break label825;
          }
          if (!str2.startsWith("video/")) {
            continue;
          }
          localObject5 = localObject4;
          localObject6 = localObject1;
          if (localObject1 != null) {
            break label840;
          }
          localObject6 = localMediaFormat;
          localObject5 = localObject4;
          break label840;
        }
        if (this.xnI != null)
        {
          if (localObject6 != null)
          {
            localObject1 = this.xnI;
            if (localObject6.containsKey("durationUs")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).jkS = i;
            localObject1 = this.xnI;
            if (localObject6.containsKey("height")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
            localObject1 = this.xnI;
            if (localObject6.containsKey("width")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
            localObject4 = this.xnI;
            if (localObject6.containsKey("mime")) {
              continue;
            }
            localObject1 = "";
            ((GalleryItem.VideoMediaItem)localObject4).jkQ = ((String)localObject1);
            localObject1 = this.xnI;
            if (localObject6.containsKey("bitrate")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
            localObject1 = this.xnI;
            if (localObject6.containsKey("i-frame-interval")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoIFrameInterval = i;
            localObject1 = this.xnI;
            if (localObject6.containsKey("frame-rate")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
            this.xnI.ihS = SightVideoJNI.getMp4RotateVFS(str1);
          }
          if (localObject5 != null)
          {
            localObject4 = this.xnI;
            if (localObject5.containsKey("mime")) {
              continue;
            }
            localObject1 = "";
            ((GalleryItem.VideoMediaItem)localObject4).jkR = ((String)localObject1);
          }
        }
        Log.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.xnI });
        Log.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
        localc.gLF.release();
      }
      catch (Exception localException)
      {
        Object localObject1;
        MediaFormat localMediaFormat;
        String str2;
        Log.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
        localc.gLF.release();
        continue;
      }
      finally
      {
        localc.gLF.release();
        AppMethodBeat.o(111404);
      }
      Log.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      break;
      Object localObject5 = localObject4;
      Object localObject6 = localObject1;
      if (str2.startsWith("audio/"))
      {
        localObject5 = localObject4;
        localObject6 = localObject1;
        if (localObject4 == null)
        {
          localObject5 = localMediaFormat;
          localObject6 = localObject1;
          break label840;
          i = (int)(localObject6.getLong("durationUs") / 1000L);
          continue;
          i = localObject6.getInteger("height");
          continue;
          i = localObject6.getInteger("width");
          continue;
          localObject1 = localObject6.getString("mime");
          continue;
          i = localObject6.getInteger("bitrate");
          continue;
          i = localObject6.getInteger("i-frame-interval");
          continue;
          i = localObject6.getInteger("frame-rate");
          continue;
          localObject1 = localObject5.getString("mime");
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111395);
              if (a.g.a(a.g.this) != null) {
                a.g.a(a.g.this).a(a.g.this, a.g.b(a.g.this).jkS);
              }
              AppMethodBeat.o(111395);
            }
          });
          label818:
          AppMethodBeat.o(111404);
          return;
        }
      }
      label825:
      label840:
      do
      {
        do
        {
          i += 1;
          localObject4 = localObject7;
          Object localObject3 = localObject8;
          break;
          localObject7 = localObject5;
          localObject8 = localObject6;
        } while (localObject5 == null);
        localObject7 = localObject5;
        localObject8 = localObject6;
      } while (localObject6 == null);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(a.g paramg, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.g
 * JD-Core Version:    0.7.0.1
 */