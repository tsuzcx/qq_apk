package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(7)
public final class GalleryEntryUI
  extends HellActivity
{
  private boolean mInit = false;
  private int tMr;
  private int tMs;
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111505);
    String str;
    if (paramIntent == null)
    {
      str = "";
      ad.i("MicroMsg.GalleryEntryUI", "on activity result, requestCode %d resultCode %d, data:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(111505);
      return;
      str = paramIntent.toString();
      break;
      ad.d("MicroMsg.GalleryEntryUI", "user choose canceld");
      setResult(0);
      continue;
      if (paramIntent == null)
      {
        AppMethodBeat.o(111505);
        return;
      }
      setResult(-1, paramIntent);
      continue;
      setResult(1);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111501);
    ad.i("MicroMsg.GalleryEntryUI", "on create");
    super.onCreate(paramBundle);
    ad.i("MicroMsg.GalleryEntryUI", "checktask onCreate:%s#0x%x task:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), bt.jl(this) });
    this.tMr = getIntent().getIntExtra("query_source_type", 3);
    this.tMs = getIntent().getIntExtra("query_media_type", 1);
    ad.i("MicroMsg.GalleryEntryUI", "query souce: " + this.tMr + ", queryType: " + this.tMs);
    e.cUM().setQueryType(this.tMs);
    e.cUM().kTx = this.tMr;
    AppMethodBeat.o(111501);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(111504);
    super.onNewIntent(paramIntent);
    ad.d("MicroMsg.GalleryEntryUI", "on new intent, #0x%x", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(111504);
  }
  
  protected final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111502);
    ad.d("MicroMsg.GalleryEntryUI", "onRestoreInstanceState");
    super.onRestoreInstanceState(paramBundle);
    this.mInit = true;
    AppMethodBeat.o(111502);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(111503);
    ad.i("MicroMsg.GalleryEntryUI", "on resume, init %B", new Object[] { Boolean.valueOf(this.mInit) });
    super.onResume();
    Object localObject;
    if (!this.mInit)
    {
      ad.i("MicroMsg.GalleryEntryUI", "doRedirect %s", new Object[] { bt.flS() });
      localObject = getIntent();
      if (!((Intent)localObject).getBooleanExtra("preview_image", false)) {
        break label284;
      }
      ad.d("MicroMsg.GalleryEntryUI", "jump to preview ui directly");
      ArrayList localArrayList = ((Intent)localObject).getStringArrayListExtra("preview_image_list");
      Intent localIntent = new Intent(this, ImagePreviewUI.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("max_select_count", ((Intent)localObject).getIntExtra("max_select_count", 9));
      localIntent.putExtra("query_source_type", this.tMr);
      localIntent.putExtra("isPreviewPhoto", ((Intent)localObject).getBooleanExtra("isPreviewPhoto", false));
      localIntent.putExtra("preview_image", ((Intent)localObject).getBooleanExtra("preview_image", false));
      localIntent.putExtra("key_force_hide_edit_image_button", getIntent().getBooleanExtra("key_force_hide_edit_image_button", false));
      localIntent.putExtra("key_force_show_raw_image_button", getIntent().getBooleanExtra("key_force_show_raw_image_button", false));
      localIntent.putExtra("key_is_raw_image_button_disable", getIntent().getBooleanExtra("key_is_raw_image_button_disable", false));
      localObject = getIntent().getStringExtra("GalleryUI_FromUser");
      String str = getIntent().getStringExtra("GalleryUI_ToUser");
      if (!bt.isNullOrNil((String)localObject)) {
        localIntent.putExtra("GalleryUI_FromUser", (String)localObject);
      }
      if (!bt.isNullOrNil(str)) {
        localIntent.putExtra("GalleryUI_ToUser", str);
      }
      localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
      startActivityForResult(localIntent, 1);
    }
    for (;;)
    {
      this.mInit = true;
      AppMethodBeat.o(111503);
      return;
      label284:
      ((Intent)localObject).setClass(this, AlbumPreviewUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
      ((Intent)localObject).putExtra("send_btn_string", getIntent().getStringExtra("send_btn_string"));
      ((Intent)localObject).putExtra("max_select_count", getIntent().getIntExtra("max_select_count", 9));
      ((Intent)localObject).putExtra("GalleryUI_FromUser", getIntent().getStringExtra("GalleryUI_FromUser"));
      ((Intent)localObject).putExtra("GalleryUI_ToUser", getIntent().getStringExtra("GalleryUI_ToUser"));
      ((Intent)localObject).putExtra("key_send_raw_image", getIntent().getBooleanExtra("key_send_raw_image", false));
      ((Intent)localObject).putExtra("key_force_hide_edit_image_button", getIntent().getBooleanExtra("key_force_hide_edit_image_button", false));
      ((Intent)localObject).putExtra("key_force_show_raw_image_button", getIntent().getBooleanExtra("key_force_show_raw_image_button", false));
      ((Intent)localObject).putExtra("key_is_raw_image_button_disable", getIntent().getBooleanExtra("key_is_raw_image_button_disable", false));
      ((Intent)localObject).putExtra("GalleryUI_SkipVideoSizeLimit", getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false));
      ((Intent)localObject).putExtra("album_business_tag", getIntent().getStringExtra("album_business_tag"));
      ((Intent)localObject).putExtra("album_video_max_duration", getIntent().getIntExtra("album_video_max_duration", 10));
      ((Intent)localObject).putExtra("album_video_min_duration", getIntent().getIntExtra("album_video_min_duration", 0));
      startActivityForResult((Intent)localObject, 0);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.GalleryEntryUI
 * JD-Core Version:    0.7.0.1
 */