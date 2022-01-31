package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.LinkedList;

final class AlbumPreviewUI$2
  implements AdapterView.OnItemClickListener
{
  AlbumPreviewUI$2(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    if ((c.aXb().aXE() == 0) || (c.aXb().aXE() == 5) || (c.aXb().aXE() == 10) || (c.aXb().aXE() == 11))
    {
      if (c.aXb().aXF() == 2)
      {
        h.a(this.kIF, true, this.kIF.getString(R.l.gallery_send_video_to_chat), "", this.kIF.getString(R.l.app_send), this.kIF.getString(R.l.app_cancel), new AlbumPreviewUI.2.1(this, paramInt), null);
        return;
      }
      paramAdapterView = AlbumPreviewUI.a(this.kIF).rS(paramInt);
      if (paramAdapterView == null)
      {
        y.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", new Object[] { Integer.valueOf(paramInt) });
        this.kIF.setResult(0);
      }
      for (;;)
      {
        this.kIF.finish();
        return;
        paramView = new Intent();
        if (paramAdapterView.getType() == 2)
        {
          paramView.putExtra("is_video", true);
          paramView.putExtra("video_full_path", paramAdapterView.eAu);
        }
        if (c.aXb().aXE() == 10) {
          paramView.putExtra("CropImage_OutputPath", paramAdapterView.eAu);
        }
        paramView.setData(Uri.parse(Uri.encode(paramAdapterView.eAu)));
        y.i("MicroMsg.AlbumPreviewUI", "getItem ok");
        this.kIF.setResult(-1, paramView);
      }
    }
    Intent localIntent;
    if (c.aXb().aXE() == 4)
    {
      if (paramInt < AlbumPreviewUI.a(this.kIF).kHG.size())
      {
        y.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
        return;
      }
      paramAdapterView = AlbumPreviewUI.a(this.kIF).rS(paramInt);
      if (paramAdapterView == null)
      {
        y.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
        return;
      }
      if ((paramAdapterView.getType() == 2) && (AlbumPreviewUI.a(this.kIF).kHD.size() != 0))
      {
        h.bC(this.kIF.mController.uMN, com.tencent.mm.cb.a.ac(this.kIF.mController.uMN, R.l.gallery_pic_can_not_choose_video));
        return;
      }
      paramView = AlbumPreviewUI.a(this.kIF).rR(paramAdapterView.getType());
      c.y(paramView);
      localIntent = new Intent(this.kIF, ImagePreviewUI.class);
      localIntent.putExtra("key_edit_video_max_time_length", this.kIF.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
      localIntent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.kIF).aXJ());
      localIntent.putExtra("preview_all", true);
      localIntent.putExtra("preview_position", paramView.indexOf(paramAdapterView));
      this.kIF.P(paramInt - AlbumPreviewUI.a(this.kIF).kHG.size(), true);
      localIntent.putExtra("send_raw_img", AlbumPreviewUI.d(this.kIF));
      localIntent.putExtra("max_select_count", AlbumPreviewUI.i(this.kIF));
      localIntent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.kIF));
      localIntent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.kIF));
      this.kIF.startActivityForResult(localIntent, 0);
      return;
    }
    if (AlbumPreviewUI.n(this.kIF))
    {
      if (paramInt < AlbumPreviewUI.a(this.kIF).kHG.size())
      {
        y.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
        return;
      }
      paramAdapterView = AlbumPreviewUI.a(this.kIF).rS(paramInt);
      if (paramAdapterView == null)
      {
        y.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
        return;
      }
      if ((paramAdapterView.getType() == 2) && (AlbumPreviewUI.a(this.kIF).kHD.size() != 0))
      {
        h.bC(this.kIF.mController.uMN, com.tencent.mm.cb.a.ac(this.kIF.mController.uMN, R.l.gallery_pic_can_not_choose_video));
        return;
      }
      paramView = AlbumPreviewUI.a(this.kIF).rR(paramAdapterView.getType());
      c.y(paramView);
      localIntent = new Intent(this.kIF, ImagePreviewUI.class);
      localIntent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.kIF).aXJ());
      localIntent.putExtra("preview_all", true);
      localIntent.putExtra("preview_position", paramView.indexOf(paramAdapterView));
      this.kIF.P(paramInt - AlbumPreviewUI.a(this.kIF).kHG.size(), true);
      localIntent.putExtra("send_raw_img", AlbumPreviewUI.d(this.kIF));
      if (paramAdapterView.getType() == 2) {}
      for (paramInt = i;; paramInt = AlbumPreviewUI.i(this.kIF))
      {
        localIntent.putExtra("max_select_count", paramInt);
        localIntent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.kIF));
        localIntent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.kIF));
        this.kIF.startActivityForResult(localIntent, 0);
        return;
      }
    }
    if (paramInt < AlbumPreviewUI.a(this.kIF).kHG.size())
    {
      y.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
      return;
    }
    c.y(AlbumPreviewUI.a(this.kIF).kHC);
    paramAdapterView = new Intent(this.kIF, ImagePreviewUI.class);
    paramAdapterView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.kIF).aXJ());
    paramAdapterView.putExtra("preview_all", true);
    paramAdapterView.putExtra("preview_position", paramInt - AlbumPreviewUI.a(this.kIF).kHG.size());
    this.kIF.P(paramInt - AlbumPreviewUI.a(this.kIF).kHG.size(), true);
    paramAdapterView.putExtra("send_raw_img", AlbumPreviewUI.d(this.kIF));
    paramAdapterView.putExtra("max_select_count", AlbumPreviewUI.i(this.kIF));
    paramAdapterView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.kIF));
    paramAdapterView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.kIF));
    this.kIF.startActivityForResult(paramAdapterView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */