package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

final class AlbumPreviewUI$15
  implements MenuItem.OnMenuItemClickListener
{
  AlbumPreviewUI$15(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    boolean bool = false;
    y.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(c.aXi()), Boolean.valueOf(AlbumPreviewUI.l(this.kIF)) });
    int i;
    if (AlbumPreviewUI.l(this.kIF)) {
      i = 3;
    }
    try
    {
      AlbumPreviewUI.b(this.kIF).aq(11610, i + "," + c.aXi());
      if (AlbumPreviewUI.m(this.kIF) >= 0) {}
    }
    catch (Exception paramMenuItem)
    {
      try
      {
        for (;;)
        {
          AlbumPreviewUI.a(this.kIF, AlbumPreviewUI.b(this.kIF).Aj());
          c.aXh();
          if (AlbumPreviewUI.a(this.kIF).aXJ().size() != 0) {
            break;
          }
          y.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
          this.kIF.setResult(-2);
          this.kIF.finish();
          return true;
          i = 2;
        }
        paramMenuItem = paramMenuItem;
        y.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[] { paramMenuItem.getMessage() });
        y.printErrStackTrace("MicroMsg.AlbumPreviewUI", paramMenuItem, "", new Object[0]);
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          AlbumPreviewUI.a(this.kIF, 26214400);
          y.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", new Object[] { paramMenuItem.getMessage() });
          y.printErrStackTrace("MicroMsg.AlbumPreviewUI", paramMenuItem, "", new Object[0]);
        }
        paramMenuItem = new Intent();
        i = c.aXb().aXF();
        if (AlbumPreviewUI.l(this.kIF)) {
          i = 1;
        }
        if (AlbumPreviewUI.n(this.kIF)) {
          i = 1;
        }
        Object localObject2;
        Object localObject1;
        Object localObject3;
        if (i == 1)
        {
          if (AlbumPreviewUI.l(this.kIF))
          {
            bool = true;
            paramMenuItem.putExtra("CropImage_Compress_Img", bool);
            localObject2 = AlbumPreviewUI.a(this.kIF).kHD;
            localObject1 = new ArrayList();
            localObject2 = ((ArrayList)localObject2).iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label430;
            }
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((((GalleryItem.MediaItem)localObject3).mMimeType.equals("edit")) && (!bk.bl(((GalleryItem.MediaItem)localObject3).kGW)))
            {
              ((ArrayList)localObject1).add(((GalleryItem.MediaItem)localObject3).kGW);
              continue;
              if (!AlbumPreviewUI.d(this.kIF))
              {
                bool = true;
                break;
              }
              bool = false;
              break;
            }
            ((ArrayList)localObject1).add(((GalleryItem.MediaItem)localObject3).eAu);
          }
          label430:
          paramMenuItem.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          paramMenuItem.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.kIF));
          AlbumPreviewUI.p(this.kIF);
          this.kIF.setResult(-1, paramMenuItem);
          AlbumPreviewUI.q(this.kIF);
          if ((!bk.bl(AlbumPreviewUI.j(this.kIF))) && (!"medianote".equals(AlbumPreviewUI.k(this.kIF))))
          {
            if (bk.UZ() - AlbumPreviewUI.r(this.kIF) < 1000L)
            {
              y.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
              return true;
            }
            y.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
            AlbumPreviewUI.a(this.kIF, bk.UZ());
            paramMenuItem.setClassName(this.kIF, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            paramMenuItem.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.kIF));
            paramMenuItem.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.kIF));
            this.kIF.startActivityForResult(paramMenuItem, 4373);
            return true;
          }
          this.kIF.finish();
          return true;
        }
        if (i == 2)
        {
          y.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
          if (this.kIF.getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {}
          for (i = 0; i == 0; i = ((com.tencent.mm.pluginsdk.ui.c.a)localObject1).cnU())
          {
            paramMenuItem.setData(Uri.fromFile(new File((String)AlbumPreviewUI.a(this.kIF).aXJ().get(0))));
            paramMenuItem.putStringArrayListExtra("key_select_video_list", AlbumPreviewUI.a(this.kIF).aXJ());
            this.kIF.setResult(-1, paramMenuItem);
            AlbumPreviewUI.q(this.kIF);
            this.kIF.finish();
            return true;
            localObject1 = com.tencent.mm.pluginsdk.ui.c.a.WN((String)AlbumPreviewUI.a(this.kIF).aXJ().get(0));
            ((com.tencent.mm.pluginsdk.ui.c.a)localObject1).mSize = AlbumPreviewUI.m(this.kIF);
          }
          if (i == 2)
          {
            AlbumPreviewUI.s(this.kIF);
            return true;
          }
          AlbumPreviewUI.t(this.kIF);
          return true;
        }
        if (i == 3)
        {
          if (bk.UZ() - AlbumPreviewUI.r(this.kIF) < 1000L)
          {
            y.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
            return true;
          }
          AlbumPreviewUI.a(this.kIF, bk.UZ());
          localObject3 = AlbumPreviewUI.a(this.kIF).kHD;
          localObject1 = new ArrayList();
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject3).next();
            if (localMediaItem.getType() == 1)
            {
              if ((localMediaItem.mMimeType.equals("edit")) && (!bk.bl(localMediaItem.kGW))) {
                ((ArrayList)localObject2).add(localMediaItem.kGW);
              } else {
                ((ArrayList)localObject2).add(localMediaItem.eAu);
              }
            }
            else if (localMediaItem.getType() == 2) {
              ((ArrayList)localObject1).add(localMediaItem.eAu);
            }
          }
          if (AlbumPreviewUI.l(this.kIF)) {
            bool = true;
          }
          for (;;)
          {
            paramMenuItem.putExtra("CropImage_Compress_Img", bool);
            paramMenuItem.putStringArrayListExtra("key_select_video_list", (ArrayList)localObject1);
            paramMenuItem.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.kIF));
            AlbumPreviewUI.p(this.kIF);
            if (((ArrayList)localObject2).size() <= 0) {
              break;
            }
            paramMenuItem.setClassName(this.kIF, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            paramMenuItem.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
            paramMenuItem.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.kIF));
            paramMenuItem.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.kIF));
            paramMenuItem.putExtra("CropImage_limit_Img_Size", 26214400);
            y.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
            this.kIF.startActivityForResult(paramMenuItem, 4373);
            return true;
            if (!AlbumPreviewUI.d(this.kIF)) {
              bool = true;
            }
          }
          y.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
          this.kIF.setResult(-1, paramMenuItem);
          this.kIF.finish();
          return true;
        }
        y.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
        this.kIF.setResult(-2);
        this.kIF.finish();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */