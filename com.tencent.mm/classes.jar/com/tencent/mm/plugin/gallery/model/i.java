package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class i
  extends k
{
  private String[] kHe = { "camera", "screenshot", "download" };
  
  protected final String Eq(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ImageQuery", "get media item selection, but album name is null, do select all");
      paramString = "_size>10240";
      String[] arrayOfString = this.kHe;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        paramString = paramString + " or lower(_data) like '%" + str + "%'";
        i += 1;
      }
      y.d("MicroMsg.ImageQuery", "where %s", new Object[] { paramString });
      return paramString;
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
  
  public final Uri aXx()
  {
    return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
  }
  
  protected final String[] aXy()
  {
    return new String[] { "_id", "_data", "COALESCE(" + k.kHi, k.kHh + ",0) AS " + kHj, k.kHi, k.kHh, "mime_type" };
  }
  
  public final String aXz()
  {
    return k.kHj + " desc,_id desc";
  }
  
  public final String[] getProjection()
  {
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.kHi, k.kHh + ",0) AS " + kHj, k.kHi, k.kHh, "mime_type" };
  }
  
  public final String getSelection()
  {
    return "0==0) GROUP BY (bucket_display_name";
  }
  
  protected final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.i
 * JD-Core Version:    0.7.0.1
 */