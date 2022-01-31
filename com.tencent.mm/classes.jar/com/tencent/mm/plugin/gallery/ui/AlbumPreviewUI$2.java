package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import org.json.JSONObject;

final class AlbumPreviewUI$2
  implements AdapterView.OnItemClickListener
{
  AlbumPreviewUI$2(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(21389);
    paramView = AlbumPreviewUI.a(this.neV).wO(paramInt);
    if ((paramView == null) || (bo.isNullOrNil(paramView.fQn)))
    {
      if (paramView == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(21389);
        return;
      }
    }
    if ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 0) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 5) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 10) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 11))
    {
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 2)
      {
        com.tencent.mm.ui.base.h.a(this.neV, true, this.neV.getString(2131300320), "", this.neV.getString(2131297067), this.neV.getString(2131296888), new AlbumPreviewUI.2.1(this, paramView, paramInt), null);
        AppMethodBeat.o(21389);
        return;
      }
      if (paramView == null)
      {
        ab.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", new Object[] { Integer.valueOf(paramInt) });
        this.neV.setResult(0);
      }
      for (;;)
      {
        this.neV.finish();
        AppMethodBeat.o(21389);
        return;
        paramAdapterView = new Intent();
        if (paramView.getType() == 2)
        {
          paramAdapterView.putExtra("is_video", true);
          paramAdapterView.putExtra("video_full_path", paramView.fQn);
        }
        if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 10) {
          paramAdapterView.putExtra("CropImage_OutputPath", paramView.fQn);
        }
        paramAdapterView.setData(Uri.parse(Uri.encode(paramView.fQn)));
        ab.i("MicroMsg.AlbumPreviewUI", "getItem ok");
        this.neV.setResult(-1, paramAdapterView);
      }
    }
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 4)
    {
      if (paramInt < AlbumPreviewUI.a(this.neV).ndR.size())
      {
        ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
        AppMethodBeat.o(21389);
        return;
      }
      if (paramView == null)
      {
        ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
        AppMethodBeat.o(21389);
        return;
      }
      if ((paramView.getType() == 2) && (AlbumPreviewUI.a(this.neV).ndN.size() != 0))
      {
        com.tencent.mm.ui.base.h.bO(this.neV.getContext(), com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300282));
        AppMethodBeat.o(21389);
        return;
      }
      if (paramView.getType() == 2)
      {
        paramLong = 300000L;
        paramAdapterView = this.neV.getString(2131300300);
        if ((AlbumPreviewUI.u(this.neV) == null) || (!AlbumPreviewUI.u(this.neV).equals("album_business_bubble_media_by_coordinate"))) {
          break label2977;
        }
        paramLong = AlbumPreviewUI.A(this.neV) * 1000 + 500;
        paramAdapterView = this.neV.getString(2131300323, new Object[] { Integer.valueOf(AlbumPreviewUI.A(this.neV)) });
      }
    }
    label919:
    label2971:
    label2977:
    for (;;)
    {
      int i;
      if ((paramView instanceof GalleryItem.VideoMediaItem)) {
        if (("video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramView).fQo)) && (com.tencent.mm.plugin.n.e.bQq())) {
          i = 1;
        }
      }
      for (;;)
      {
        Object localObject = this.neV;
        String str = paramView.fQn;
        if (bo.isNullOrNil(str)) {
          paramInt = 1;
        }
        for (;;)
        {
          if ((paramInt == 0) && (i != 0) && ((bo.isNullOrNil(((GalleryItem.VideoMediaItem)paramView).fQp)) || ("audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramView).fQp)))) {
            break label919;
          }
          paramAdapterView = new e.a(this.neV.getContext());
          paramAdapterView.aj(com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300295));
          paramAdapterView.AHs = com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300279);
          paramAdapterView.b(new AlbumPreviewUI.2.2(this));
          paramAdapterView.show();
          AppMethodBeat.o(21389);
          return;
          if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramView).fQo)) {
            break label2971;
          }
          i = 1;
          break;
          if (((AlbumPreviewUI)localObject).neU == null)
          {
            ((AlbumPreviewUI)localObject).neU = new HashSet();
            ((AlbumPreviewUI)localObject).neU.add(".h264");
            ((AlbumPreviewUI)localObject).neU.add(".h26l");
            ((AlbumPreviewUI)localObject).neU.add(".264");
            ((AlbumPreviewUI)localObject).neU.add(".avc");
            ((AlbumPreviewUI)localObject).neU.add(".mov");
            ((AlbumPreviewUI)localObject).neU.add(".mp4");
            ((AlbumPreviewUI)localObject).neU.add(".m4a");
            ((AlbumPreviewUI)localObject).neU.add(".3gp");
            ((AlbumPreviewUI)localObject).neU.add(".3g2");
            ((AlbumPreviewUI)localObject).neU.add(".mj2");
            ((AlbumPreviewUI)localObject).neU.add(".m4v");
          }
          str = str.trim();
          paramInt = str.lastIndexOf(".");
          if ((paramInt < 0) || (paramInt >= str.length())) {
            paramInt = 1;
          } else if (!((AlbumPreviewUI)localObject).neU.contains(str.substring(paramInt).toLowerCase())) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
        }
        if (((GalleryItem.VideoMediaItem)paramView).fQq >= paramLong)
        {
          paramView = new e.a(this.neV.getContext());
          paramView.aj(paramAdapterView);
          paramView.AHs = com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300279);
          paramView.b(new e.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
          });
          paramView.show();
          AppMethodBeat.o(21389);
          return;
        }
        paramAdapterView = RecordConfigProvider.aa(paramView.fQn, "", "");
        paramAdapterView.qbx = (this.neV.getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
        paramAdapterView.scene = 2;
        paramView = new VideoCaptureReportInfo();
        paramView.mhr = 2;
        paramAdapterView.qbE = paramView;
        paramView = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.neV.getContext(), 4379, paramAdapterView, 3, 0);
        AppMethodBeat.o(21389);
        return;
        ab.d("leextime", "jump from sns : " + bo.yB());
        localObject = AlbumPreviewUI.a(this.neV).wN(paramView.getType());
        com.tencent.mm.plugin.gallery.model.e.B((ArrayList)localObject);
        paramAdapterView = new Intent(this.neV, ImagePreviewUI.class);
        paramAdapterView.putExtra("key_edit_video_max_time_length", this.neV.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        paramAdapterView.putExtra("key_edit_text_color", this.neV.getIntent().getStringExtra("key_edit_text_color"));
        paramAdapterView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.neV).bEn());
        paramAdapterView.putExtra("preview_all", true);
        paramAdapterView.putExtra("preview_position", ((ArrayList)localObject).indexOf(paramView));
        paramView = this.neV;
        paramView.X(paramInt - AlbumPreviewUI.a(paramView).ndR.size(), true);
        paramAdapterView.putExtra("send_raw_img", AlbumPreviewUI.d(this.neV));
        paramAdapterView.putExtra("max_select_count", AlbumPreviewUI.i(this.neV));
        paramAdapterView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.neV));
        paramAdapterView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.neV));
        this.neV.startActivityForResult(paramAdapterView, 0);
        AppMethodBeat.o(21389);
        return;
        if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 14)
        {
          if (paramInt < AlbumPreviewUI.a(this.neV).ndR.size())
          {
            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
            AppMethodBeat.o(21389);
            return;
          }
          if (paramView == null)
          {
            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
            AppMethodBeat.o(21389);
            return;
          }
          if ((paramView.getType() == 2) && (AlbumPreviewUI.a(this.neV).ndN.size() != 0))
          {
            com.tencent.mm.ui.base.h.bO(this.neV.getContext(), com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300282));
            AppMethodBeat.o(21389);
            return;
          }
          if (paramView.getType() == 1)
          {
            localObject = AlbumPreviewUI.a(this.neV).wN(paramView.getType());
            com.tencent.mm.plugin.gallery.model.e.B((ArrayList)localObject);
            paramAdapterView = new Intent(this.neV, ImagePreviewUI.class);
            paramAdapterView.putExtra("key_edit_video_max_time_length", this.neV.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
            paramAdapterView.putExtra("key_edit_text_color", this.neV.getIntent().getStringExtra("key_edit_text_color"));
            paramAdapterView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.neV).bEn());
            paramAdapterView.putExtra("preview_all", true);
            paramAdapterView.putExtra("preview_position", ((ArrayList)localObject).indexOf(paramView));
            paramView = this.neV;
            paramView.X(paramInt - AlbumPreviewUI.a(paramView).ndR.size(), true);
            paramAdapterView.putExtra("send_raw_img", AlbumPreviewUI.d(this.neV));
            paramAdapterView.putExtra("max_select_count", AlbumPreviewUI.i(this.neV));
            paramAdapterView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.neV));
            paramAdapterView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.neV));
            this.neV.startActivityForResult(paramAdapterView, 0);
            AppMethodBeat.o(21389);
            return;
          }
          if (!(paramView instanceof GalleryItem.VideoMediaItem)) {
            break label2960;
          }
          paramAdapterView = (GalleryItem.VideoMediaItem)paramView;
          paramInt = paramAdapterView.eWL;
          if ((paramInt == 0) || (paramInt == 180))
          {
            if (paramAdapterView.videoWidth >= paramAdapterView.videoHeight)
            {
              ab.i("MicroMsg.AlbumPreviewUI", "select story video, video ratio error, width:%s, height:%s, rotate:%s", new Object[] { Integer.valueOf(paramAdapterView.videoWidth), Integer.valueOf(paramAdapterView.videoHeight), Integer.valueOf(paramInt) });
              com.tencent.mm.plugin.report.service.h.qsU.j(1005L, 52L, 1L);
              com.tencent.mm.ui.base.h.bO(this.neV.getContext(), com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300297));
              AppMethodBeat.o(21389);
            }
          }
          else if (((paramInt == 270) || (paramInt == 90)) && (paramAdapterView.videoHeight >= paramAdapterView.videoWidth))
          {
            ab.i("MicroMsg.AlbumPreviewUI", "select story video, video ratio error, width:%s, height:%s, rotate:%s", new Object[] { Integer.valueOf(paramAdapterView.videoWidth), Integer.valueOf(paramAdapterView.videoHeight), Integer.valueOf(paramInt) });
            com.tencent.mm.plugin.report.service.h.qsU.j(1005L, 52L, 1L);
            com.tencent.mm.ui.base.h.bO(this.neV.getContext(), com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300297));
            AppMethodBeat.o(21389);
            return;
          }
          if (paramAdapterView.fQq <= 2000)
          {
            ab.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramAdapterView.fQq) });
            com.tencent.mm.plugin.report.service.h.qsU.j(1005L, 53L, 1L);
            com.tencent.mm.ui.base.h.bO(this.neV.getContext(), com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300303));
            AppMethodBeat.o(21389);
            return;
          }
          if ((paramAdapterView.videoFrameRate <= 1) && (paramAdapterView.videoFrameRate >= 0))
          {
            ab.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramAdapterView.videoFrameRate), paramAdapterView.fQn });
            if (paramAdapterView.videoFrameRate > 1) {}
          }
        }
        try
        {
          paramView = SightVideoJNI.getSimpleMp4Info(paramAdapterView.fQn);
          if (!bo.isNullOrNil(paramView))
          {
            double d = new JSONObject(paramView).optDouble("videoFPS");
            ab.i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", new Object[] { Double.valueOf(d) });
            if (d > 0.0D) {
              paramAdapterView.videoFrameRate = ((int)d);
            }
          }
        }
        catch (Exception paramView)
        {
          label2087:
          break label2087;
        }
        if (paramAdapterView.videoFrameRate <= 0)
        {
          ab.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramAdapterView.videoFrameRate), paramAdapterView.fQn });
          com.tencent.mm.plugin.report.service.h.qsU.j(1005L, 54L, 1L);
          com.tencent.mm.ui.base.h.bO(this.neV.getContext(), com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300295));
          AppMethodBeat.o(21389);
          return;
        }
        paramLong = this.neV.getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500;
        ab.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(paramLong) });
        if (paramAdapterView.fQq >= paramLong)
        {
          paramView = new Intent();
          paramView.putExtra("key_video_path", paramAdapterView.fQn);
          paramView.putExtra("key_need_clip_video_first", true);
          paramView.putExtra("key_need_remux_video", false);
          paramView.putExtra("key_text_color", this.neV.getIntent().getStringExtra("key_edit_text_color"));
          paramView.putExtra("key_max_duration_seconds", this.neV.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
          d.b(this.neV.getContext(), "mmsight", ".segment.MMSightEditUI", paramView, 4374);
          AppMethodBeat.o(21389);
          return;
        }
        paramView = new Intent();
        paramView.putExtra("K_SEGMENTVIDEOPATH", paramAdapterView.fQn);
        paramView.putExtra("KSEGMENTVIDEOTHUMBPATH", paramAdapterView.mnt);
        this.neV.setResult(-1, paramView);
        this.neV.finish();
        AppMethodBeat.o(21389);
        return;
        if (AlbumPreviewUI.n(this.neV))
        {
          if (paramInt < AlbumPreviewUI.a(this.neV).ndR.size())
          {
            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
            AppMethodBeat.o(21389);
            return;
          }
          if (paramView == null)
          {
            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
            AppMethodBeat.o(21389);
            return;
          }
          if ((paramView.getType() == 2) && (AlbumPreviewUI.a(this.neV).ndN.size() != 0))
          {
            com.tencent.mm.ui.base.h.bO(this.neV.getContext(), com.tencent.mm.cb.a.aq(this.neV.getContext(), 2131300282));
            AppMethodBeat.o(21389);
            return;
          }
          if ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 15) && (paramView.getType() == 2))
          {
            this.neV.PE(paramView.fQn);
            AppMethodBeat.o(21389);
            return;
          }
          localObject = AlbumPreviewUI.a(this.neV).wN(paramView.getType());
          com.tencent.mm.plugin.gallery.model.e.B((ArrayList)localObject);
          paramAdapterView = new Intent(this.neV, ImagePreviewUI.class);
          paramAdapterView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.neV).bEn());
          paramAdapterView.putExtra("preview_all", true);
          paramAdapterView.putExtra("preview_position", ((ArrayList)localObject).indexOf(paramView));
          localObject = this.neV;
          ((AlbumPreviewUI)localObject).X(paramInt - AlbumPreviewUI.a((AlbumPreviewUI)localObject).ndR.size(), true);
          paramAdapterView.putExtra("send_raw_img", AlbumPreviewUI.d(this.neV));
          if (paramView.getType() == 2) {}
          for (paramInt = 1;; paramInt = AlbumPreviewUI.i(this.neV))
          {
            paramAdapterView.putExtra("max_select_count", paramInt);
            paramAdapterView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.neV));
            paramAdapterView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.neV));
            this.neV.startActivityForResult(paramAdapterView, 0);
            AppMethodBeat.o(21389);
            return;
          }
        }
        if (paramInt < AlbumPreviewUI.a(this.neV).ndR.size())
        {
          ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
          AppMethodBeat.o(21389);
          return;
        }
        com.tencent.mm.plugin.gallery.model.e.B(AlbumPreviewUI.a(this.neV).ndM);
        paramAdapterView = new Intent(this.neV, ImagePreviewUI.class);
        paramAdapterView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.neV).bEn());
        paramAdapterView.putExtra("preview_all", true);
        paramAdapterView.putExtra("preview_position", paramInt - AlbumPreviewUI.a(this.neV).ndR.size());
        paramView = this.neV;
        paramView.X(paramInt - AlbumPreviewUI.a(paramView).ndR.size(), true);
        paramAdapterView.putExtra("send_raw_img", AlbumPreviewUI.d(this.neV));
        paramAdapterView.putExtra("max_select_count", AlbumPreviewUI.i(this.neV));
        paramAdapterView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.neV));
        paramAdapterView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.neV));
        paramAdapterView.putExtra("album_business_tag", AlbumPreviewUI.u(this.neV));
        paramAdapterView.putExtra("album_video_max_duration", AlbumPreviewUI.A(this.neV));
        this.neV.startActivityForResult(paramAdapterView, 0);
        AppMethodBeat.o(21389);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */