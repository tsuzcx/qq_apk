package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

final class AlbumPreviewUI$8$1
  implements View.OnClickListener
{
  AlbumPreviewUI$8$1(AlbumPreviewUI.8 param8) {}
  
  private void bEu()
  {
    AppMethodBeat.i(21400);
    String str1 = this.nfa.neV.getIntent().getStringExtra("to_user");
    String str2 = this.nfa.neV.getIntent().getStringExtra("file_name");
    String str3 = this.nfa.neV.getIntent().getStringExtra("video_path");
    String str4 = this.nfa.neV.getIntent().getStringExtra("video_full_path");
    String str5 = this.nfa.neV.getIntent().getStringExtra("video_thumb_path");
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(this.nfa.neV.getContext().getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
      localIntent.putExtra("VideoRecorder_ToUser", str1);
      localIntent.putExtra("VideoRecorder_FileName", str2);
      localIntent.putExtra("VideoRecorder_VideoPath", str3);
      localIntent.putExtra("VideoRecorder_VideoFullPath", str4);
      localIntent.putExtra("VideoRecorder_VideoThumbPath", str5);
      ab.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[] { localIntent });
      this.nfa.neV.startActivityForResult(localIntent, 4371);
      AppMethodBeat.o(21400);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.AlbumPreviewUI", localException.toString());
      if ((!com.tencent.mm.r.a.bN(this.nfa.neV.getContext())) && (!com.tencent.mm.r.a.bM(this.nfa.neV.getContext()))) {
        com.tencent.mm.compatible.j.b.r(this.nfa.neV.getContext());
      }
      AppMethodBeat.o(21400);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21401);
    ab.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", new Object[] { Integer.valueOf(AlbumPreviewUI.I(this.nfa.neV)) });
    if (AlbumPreviewUI.J(this.nfa.neV))
    {
      ab.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
      AppMethodBeat.o(21401);
      return;
    }
    AlbumPreviewUI.K(this.nfa.neV);
    AlbumPreviewUI.L(this.nfa.neV);
    if ((com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 2) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 13))
    {
      if (this.nfa.neV.getIntent().getBooleanExtra("record_video_force_sys_camera", false))
      {
        int i = this.nfa.neV.getIntent().getIntExtra("record_video_quality", 0);
        int j = this.nfa.neV.getIntent().getIntExtra("record_video_time_limit", 0);
        paramView = this.nfa.neV.getIntent().getStringExtra("video_full_path");
        n.a(this.nfa.neV.getContext(), paramView, 4372, j, i, false);
        AppMethodBeat.o(21401);
        return;
      }
      if (this.nfa.neV.getIntent().getBooleanExtra("record_video_is_sight_capture", false))
      {
        if ((SightParams)this.nfa.neV.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS") == null) {
          ab.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
        }
        if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 13)
        {
          n.a(this.nfa.neV.getContext(), 4375, this.nfa.neV.getIntent(), 3, 1);
          AppMethodBeat.o(21401);
          return;
        }
        paramView = RecordConfigProvider.cgp();
        if (AlbumPreviewUI.M(this.nfa.neV))
        {
          com.tencent.mm.plugin.recordvideo.jumper.a locala = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
          com.tencent.mm.plugin.recordvideo.jumper.a.b(this.nfa.neV.getContext(), 4378, paramView);
          AppMethodBeat.o(21401);
          return;
        }
        n.a(this.nfa.neV.getContext(), 4375, this.nfa.neV.getIntent(), 4, 1);
        AppMethodBeat.o(21401);
        return;
      }
      if (ac.erF.eoY == 2)
      {
        bEu();
        AppMethodBeat.o(21401);
        return;
      }
      if ((ac.erF.eoY == 1) && (!com.tencent.mm.r.a.bN(this.nfa.neV.getContext())) && (!com.tencent.mm.r.a.bM(this.nfa.neV.getContext())))
      {
        com.tencent.mm.compatible.j.b.r(this.nfa.neV.getContext());
        AppMethodBeat.o(21401);
        return;
      }
      bEu();
      AppMethodBeat.o(21401);
      return;
    }
    if ((com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 1) || (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 3))
    {
      paramView = new File(com.tencent.mm.compatible.util.e.esr);
      if ((!paramView.exists()) && (!paramView.mkdir()))
      {
        Toast.makeText(this.nfa.neV.getContext(), this.nfa.neV.getString(2131300274), 1).show();
        AppMethodBeat.o(21401);
        return;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.nfa.neV.getContext(), "android.permission.CAMERA", 16, "", "");
      ab.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.nfa.neV.getContext() });
      if (!bool)
      {
        AppMethodBeat.o(21401);
        return;
      }
      AlbumPreviewUI.N(this.nfa.neV);
    }
    AppMethodBeat.o(21401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.8.1
 * JD-Core Version:    0.7.0.1
 */