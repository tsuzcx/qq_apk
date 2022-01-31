package com.tencent.mm.plugin.emojicapture.model;

import a.d.b.g;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import java.io.File;
import java.io.InputStream;

final class PluginEmojiCapture$c
  implements FilterRawGet.GetInputStream
{
  PluginEmojiCapture$c(PluginEmojiCapture paramPluginEmojiCapture) {}
  
  public final InputStream getInputStream(String paramString)
  {
    y.i(PluginEmojiCapture.access$getTAG$p(this.jkt), "get res: " + paramString);
    Object localObject = ae.getContext();
    g.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open("raw" + File.separator + paramString);
      return localObject;
    }
    catch (Exception localException)
    {
      localException = localException;
      y.e(PluginEmojiCapture.access$getTAG$p(this.jkt), "cannot find res " + paramString);
      return null;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture.c
 * JD-Core Version:    0.7.0.1
 */