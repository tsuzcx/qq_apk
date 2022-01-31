package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import java.util.ArrayList;

final class JsApiChooseImage$a$3
  implements Runnable
{
  JsApiChooseImage$a$3(JsApiChooseImage.a parama, String paramString) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    if (!this.gvv.gvr.gvo) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_send_raw_image", bool);
      localIntent.putExtra("max_select_count", this.gvv.gvr.count);
      localIntent.putExtra("query_source_type", this.gvv.gvt);
      localIntent.putExtra("isPreviewPhoto", true);
      localIntent.putExtra("max_select_count", 1);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(this.val$filePath);
      localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
      localIntent.putExtra("preview_image", true);
      localIntent.addFlags(67108864);
      JsApiChooseImage.a.a(this.gvv, "gallery", ".ui.GalleryEntryUI", localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.3
 * JD-Core Version:    0.7.0.1
 */