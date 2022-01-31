package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class n
  extends k
{
  protected final String Eq(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.VideoQuery", "get media item selection, but album name is null, do select all");
      return null;
    }
    return "bucket_display_name=\"" + paramString + "\"";
  }
  
  protected final String aXA()
  {
    return "bucket_display_name";
  }
  
  public final ArrayList<GalleryItem.AlbumItem> aXv()
  {
    return super.aXv();
  }
  
  protected final Uri aXx()
  {
    return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
  }
  
  protected final String[] aXy()
  {
    return new String[] { "_id", "_data", "COALESCE(" + k.kHi, k.kHh + ",0) AS " + kHj, k.kHi, k.kHh, "mime_type" };
  }
  
  protected final String aXz()
  {
    return k.kHi + " desc,_id desc";
  }
  
  protected final String[] getProjection()
  {
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.kHi, k.kHh + ",0) AS " + kHj, k.kHi, k.kHh, "mime_type" };
  }
  
  protected final String getSelection()
  {
    return "0==0) GROUP BY (bucket_display_name";
  }
  
  protected final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.n
 * JD-Core Version:    0.7.0.1
 */