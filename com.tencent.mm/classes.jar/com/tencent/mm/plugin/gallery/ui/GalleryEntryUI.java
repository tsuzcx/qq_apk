package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(7)
public final class GalleryEntryUI
  extends AppCompatActivity
{
  private boolean hdL = false;
  private int kIU;
  private int kIu;
  private boolean mInit = false;
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramIntent == null)
    {
      str = "";
      y.i("MicroMsg.GalleryEntryUI", "on activity result, requestCode %d resultCode %d, data:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      this.hdL = true;
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      label72:
      if (this.hdL) {
        finish();
      }
      do
      {
        return;
        str = paramIntent.toString();
        break;
        y.d("MicroMsg.GalleryEntryUI", "user choose canceld");
        setResult(0);
        break label72;
      } while (paramIntent == null);
      setResult(-1, paramIntent);
      continue;
      setResult(1);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    y.i("MicroMsg.GalleryEntryUI", "on create");
    super.onCreate(paramBundle);
    y.i("MicroMsg.GalleryEntryUI", "checktask onCreate:%s#0x%x task:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), bk.fW(this) });
    c.initialize();
    this.kIu = getIntent().getIntExtra("query_source_type", 3);
    this.kIU = getIntent().getIntExtra("query_media_type", 1);
    y.i("MicroMsg.GalleryEntryUI", "query souce: " + this.kIu + ", queryType: " + this.kIU);
    c.aXb().rO(this.kIU);
    c.aXb().rP(this.kIu);
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.GalleryEntryUI", "onDestroy %B", new Object[] { Boolean.valueOf(this.hdL) });
    c.release(this.hdL);
    y.i("MicroMsg.GalleryEntryUI", "checktask onDestroy:%s#0x%x task:%s ", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), bk.fW(this) });
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    y.d("MicroMsg.GalleryEntryUI", "on new intent, #0x%x", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  protected final void onRestoreInstanceState(Bundle paramBundle)
  {
    y.d("MicroMsg.GalleryEntryUI", "onRestoreInstanceState");
    super.onRestoreInstanceState(paramBundle);
    this.mInit = true;
  }
  
  protected final void onResume()
  {
    y.i("MicroMsg.GalleryEntryUI", "on resume, init %B", new Object[] { Boolean.valueOf(this.mInit) });
    super.onResume();
    Object localObject;
    if (!this.mInit)
    {
      y.e("MicroMsg.GalleryEntryUI", "doRedirect %s", new Object[] { bk.csb() });
      localObject = getIntent();
      if (!((Intent)localObject).getBooleanExtra("preview_image", false)) {
        break label223;
      }
      y.d("MicroMsg.GalleryEntryUI", "jump to preview ui directly");
      ArrayList localArrayList = ((Intent)localObject).getStringArrayListExtra("preview_image_list");
      Intent localIntent = new Intent(this, ImagePreviewUI.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("max_select_count", ((Intent)localObject).getIntExtra("max_select_count", 9));
      localIntent.putExtra("query_source_type", this.kIu);
      localIntent.putExtra("isPreviewPhoto", ((Intent)localObject).getBooleanExtra("isPreviewPhoto", false));
      localIntent.putExtra("preview_image", ((Intent)localObject).getBooleanExtra("preview_image", false));
      localObject = getIntent().getStringExtra("GalleryUI_FromUser");
      String str = getIntent().getStringExtra("GalleryUI_ToUser");
      if (!bk.bl((String)localObject)) {
        localIntent.putExtra("GalleryUI_FromUser", (String)localObject);
      }
      if (!bk.bl(str)) {
        localIntent.putExtra("GalleryUI_ToUser", str);
      }
      localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
      startActivityForResult(localIntent, 1);
    }
    for (;;)
    {
      this.mInit = true;
      return;
      label223:
      ((Intent)localObject).setClass(this, AlbumPreviewUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("send_btn_string", getIntent().getStringExtra("send_btn_string"));
      ((Intent)localObject).putExtra("max_select_count", getIntent().getIntExtra("max_select_count", 9));
      ((Intent)localObject).putExtra("GalleryUI_FromUser", getIntent().getStringExtra("GalleryUI_FromUser"));
      ((Intent)localObject).putExtra("GalleryUI_ToUser", getIntent().getStringExtra("GalleryUI_ToUser"));
      ((Intent)localObject).putExtra("key_send_raw_image", getIntent().getBooleanExtra("key_send_raw_image", false));
      ((Intent)localObject).putExtra("GalleryUI_SkipVideoSizeLimit", getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false));
      startActivityForResult((Intent)localObject, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.GalleryEntryUI
 * JD-Core Version:    0.7.0.1
 */