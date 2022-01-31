package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

final class AlbumPreviewUI$16
  implements MenuItem.OnMenuItemClickListener
{
  AlbumPreviewUI$16(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    boolean bool = false;
    AppMethodBeat.i(21411);
    ab.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(e.bDX()), Boolean.valueOf(AlbumPreviewUI.l(this.neV)) });
    int i;
    if (AlbumPreviewUI.l(this.neV)) {
      i = 3;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    try
    {
      AlbumPreviewUI.b(this.neV).aK(11610, i + "," + e.bDX());
      if (AlbumPreviewUI.m(this.neV) >= 0) {}
    }
    catch (Exception paramMenuItem)
    {
      try
      {
        for (;;)
        {
          AlbumPreviewUI.a(this.neV, AlbumPreviewUI.b(this.neV).MY());
          e.bDW();
          if (AlbumPreviewUI.a(this.neV).bEn().size() != 0) {
            break;
          }
          ab.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
          this.neV.setResult(-2);
          this.neV.finish();
          AppMethodBeat.o(21411);
          return true;
          i = 2;
        }
        paramMenuItem = paramMenuItem;
        ab.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[] { paramMenuItem.getMessage() });
        ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", paramMenuItem, "", new Object[0]);
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          AlbumPreviewUI.a(this.neV, 26214400);
          ab.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", new Object[] { paramMenuItem.getMessage() });
          ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", paramMenuItem, "", new Object[0]);
        }
        paramMenuItem = new Intent();
        i = e.bDQ().ndz;
        if (AlbumPreviewUI.l(this.neV)) {
          i = 1;
        }
        if (AlbumPreviewUI.n(this.neV)) {
          i = 1;
        }
        if (e.bDQ().hQK == 14)
        {
          localObject2 = AlbumPreviewUI.a(this.neV).ndN;
          localObject1 = new ArrayList();
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((((GalleryItem.MediaItem)localObject3).mMimeType.equals("edit")) && (!bo.isNullOrNil(((GalleryItem.MediaItem)localObject3).ndo))) {
              ((ArrayList)localObject1).add(((GalleryItem.MediaItem)localObject3).ndo);
            } else {
              ((ArrayList)localObject1).add(((GalleryItem.MediaItem)localObject3).fQn);
            }
          }
          paramMenuItem.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          paramMenuItem.putExtra("key_is_photo_to_video", true);
          this.neV.setResult(-1, paramMenuItem);
          this.neV.finish();
          AppMethodBeat.o(21411);
          return true;
        }
        if (i != 1) {
          break label801;
        }
      }
    }
    if (AlbumPreviewUI.l(this.neV))
    {
      bool = true;
      paramMenuItem.putExtra("CropImage_Compress_Img", bool);
      localObject2 = AlbumPreviewUI.a(this.neV).ndN;
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label596;
      }
      localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      if ((((GalleryItem.MediaItem)localObject3).mMimeType.equals("edit")) && (!bo.isNullOrNil(((GalleryItem.MediaItem)localObject3).ndo)))
      {
        ((ArrayList)localObject1).add(((GalleryItem.MediaItem)localObject3).ndo);
        continue;
        if (!AlbumPreviewUI.d(this.neV))
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      ((ArrayList)localObject1).add(((GalleryItem.MediaItem)localObject3).fQn);
    }
    label596:
    paramMenuItem.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
    paramMenuItem.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.neV));
    AlbumPreviewUI.p(this.neV);
    this.neV.setResult(-1, paramMenuItem);
    AlbumPreviewUI.q(this.neV);
    if ((!bo.isNullOrNil(AlbumPreviewUI.j(this.neV))) && (!"medianote".equals(AlbumPreviewUI.k(this.neV))))
    {
      if (bo.yB() - AlbumPreviewUI.r(this.neV) < 1000L)
      {
        ab.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
        AppMethodBeat.o(21411);
        return true;
      }
      ab.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
      AlbumPreviewUI.a(this.neV, bo.yB());
      paramMenuItem.setClassName(this.neV, "com.tencent.mm.ui.chatting.SendImgProxyUI");
      paramMenuItem.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.neV));
      paramMenuItem.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.neV));
      this.neV.startActivityForResult(paramMenuItem, 4373);
    }
    for (;;)
    {
      AppMethodBeat.o(21411);
      return true;
      this.neV.finish();
      continue;
      label801:
      if (i == 2)
      {
        ab.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
        if (this.neV.getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {}
        for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject1).azZ())
        {
          if (i != 0) {
            break label957;
          }
          paramMenuItem.setData(Uri.fromFile(new File((String)AlbumPreviewUI.a(this.neV).bEn().get(0))));
          paramMenuItem.putStringArrayListExtra("key_select_video_list", AlbumPreviewUI.a(this.neV).bEn());
          this.neV.setResult(-1, paramMenuItem);
          AlbumPreviewUI.q(this.neV);
          this.neV.finish();
          break;
          localObject1 = com.tencent.mm.plugin.gallery.ui.a.a.PK((String)AlbumPreviewUI.a(this.neV).bEn().get(0));
          ((com.tencent.mm.plugin.gallery.ui.a.a)localObject1).mSize = AlbumPreviewUI.m(this.neV);
        }
        label957:
        if (i == 2)
        {
          AlbumPreviewUI.s(this.neV);
          AppMethodBeat.o(21411);
          return true;
        }
        AlbumPreviewUI.t(this.neV);
        AppMethodBeat.o(21411);
        return true;
      }
      if (i == 3)
      {
        GalleryItem.MediaItem localMediaItem;
        if ((!bo.isNullOrNil(AlbumPreviewUI.u(this.neV))) && (AlbumPreviewUI.u(this.neV).equals("album_business_bubble_media_by_coordinate")))
        {
          localObject3 = AlbumPreviewUI.a(this.neV).ndN;
          localObject1 = new ArrayList();
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject3).next();
            if (localMediaItem.getType() == 1)
            {
              if ((localMediaItem.mMimeType.equals("edit")) && (!bo.isNullOrNil(localMediaItem.ndo))) {
                ((ArrayList)localObject2).add(localMediaItem.ndo);
              } else {
                ((ArrayList)localObject2).add(localMediaItem.fQn);
              }
            }
            else if (localMediaItem.getType() == 2) {
              ((ArrayList)localObject1).add(localMediaItem.fQn);
            }
          }
          paramMenuItem.putExtra("CropImage_Compress_Img", false);
          paramMenuItem.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          paramMenuItem.putStringArrayListExtra("key_select_video_list", (ArrayList)localObject1);
          paramMenuItem.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.neV));
          paramMenuItem.putExtra("longitude", AlbumPreviewUI.v(this.neV));
          paramMenuItem.putExtra("latitude", AlbumPreviewUI.w(this.neV));
          AlbumPreviewUI.p(this.neV);
          this.neV.setResult(-1, paramMenuItem);
          this.neV.finish();
          AppMethodBeat.o(21411);
          return true;
        }
        if (bo.yB() - AlbumPreviewUI.r(this.neV) < 1000L)
        {
          ab.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
          AppMethodBeat.o(21411);
          return true;
        }
        AlbumPreviewUI.a(this.neV, bo.yB());
        localObject3 = AlbumPreviewUI.a(this.neV).ndN;
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject3).next();
          if (localMediaItem.getType() == 1)
          {
            if ((localMediaItem.mMimeType.equals("edit")) && (!bo.isNullOrNil(localMediaItem.ndo))) {
              ((ArrayList)localObject2).add(localMediaItem.ndo);
            } else {
              ((ArrayList)localObject2).add(localMediaItem.fQn);
            }
          }
          else if (localMediaItem.getType() == 2) {
            ((ArrayList)localObject1).add(localMediaItem.fQn);
          }
        }
        if (AlbumPreviewUI.l(this.neV)) {
          bool = true;
        }
        for (;;)
        {
          paramMenuItem.putExtra("CropImage_Compress_Img", bool);
          paramMenuItem.putStringArrayListExtra("key_select_video_list", (ArrayList)localObject1);
          paramMenuItem.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.neV));
          AlbumPreviewUI.p(this.neV);
          if (((ArrayList)localObject2).size() <= 0) {
            break label1626;
          }
          paramMenuItem.setClassName(this.neV, "com.tencent.mm.ui.chatting.SendImgProxyUI");
          paramMenuItem.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          paramMenuItem.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.neV));
          paramMenuItem.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.neV));
          paramMenuItem.putExtra("CropImage_limit_Img_Size", 26214400);
          ab.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
          this.neV.startActivityForResult(paramMenuItem, 4373);
          break;
          if (!AlbumPreviewUI.d(this.neV)) {
            bool = true;
          }
        }
        label1626:
        ab.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
        this.neV.setResult(-1, paramMenuItem);
        this.neV.finish();
      }
      else
      {
        ab.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
        this.neV.setResult(-2);
        this.neV.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.16
 * JD-Core Version:    0.7.0.1
 */