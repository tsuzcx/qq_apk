package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.j.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.File;

final class AlbumPreviewUI$7$1
  implements View.OnClickListener
{
  AlbumPreviewUI$7$1(AlbumPreviewUI.7 param7) {}
  
  private void aXO()
  {
    String str1 = this.kII.kIF.getIntent().getStringExtra("to_user");
    String str2 = this.kII.kIF.getIntent().getStringExtra("file_name");
    String str3 = this.kII.kIF.getIntent().getStringExtra("video_path");
    String str4 = this.kII.kIF.getIntent().getStringExtra("video_full_path");
    String str5 = this.kII.kIF.getIntent().getStringExtra("video_thumb_path");
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(this.kII.kIF.mController.uMN.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
      localIntent.putExtra("VideoRecorder_ToUser", str1);
      localIntent.putExtra("VideoRecorder_FileName", str2);
      localIntent.putExtra("VideoRecorder_VideoPath", str3);
      localIntent.putExtra("VideoRecorder_VideoFullPath", str4);
      localIntent.putExtra("VideoRecorder_VideoThumbPath", str5);
      y.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[] { localIntent });
      this.kII.kIF.startActivityForResult(localIntent, 4371);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        y.w("MicroMsg.AlbumPreviewUI", localException.toString());
      } while ((com.tencent.mm.r.a.bj(this.kII.kIF.mController.uMN)) || (com.tencent.mm.r.a.bi(this.kII.kIF.mController.uMN)));
      b.q(this.kII.kIF.mController.uMN);
    }
  }
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", new Object[] { Integer.valueOf(AlbumPreviewUI.B(this.kII.kIF)) });
    if (AlbumPreviewUI.C(this.kII.kIF)) {
      y.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
    }
    boolean bool;
    do
    {
      do
      {
        return;
        AlbumPreviewUI.D(this.kII.kIF);
        AlbumPreviewUI.E(this.kII.kIF);
        if ((c.aXb().aXF() == 2) || (c.aXb().aXE() == 13))
        {
          if (this.kII.kIF.getIntent().getBooleanExtra("record_video_force_sys_camera", false))
          {
            int i = this.kII.kIF.getIntent().getIntExtra("record_video_quality", 0);
            int j = this.kII.kIF.getIntent().getIntExtra("record_video_time_limit", 0);
            paramView = this.kII.kIF.getIntent().getStringExtra("video_full_path");
            com.tencent.mm.pluginsdk.ui.tools.l.a(this.kII.kIF.mController.uMN, paramView, 4372, j, i, false);
            return;
          }
          if (this.kII.kIF.getIntent().getBooleanExtra("record_video_is_sight_capture", false))
          {
            if ((SightParams)this.kII.kIF.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS") == null) {
              y.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
            }
            if (c.aXb().aXE() != 13)
            {
              com.tencent.mm.pluginsdk.ui.tools.l.a(this.kII.kIF.mController.uMN, 4375, this.kII.kIF.getIntent(), 3, 1);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.l.a(this.kII.kIF.mController.uMN, 4375, this.kII.kIF.getIntent(), 4, 1);
            return;
          }
          if (q.dyn.dxa == 2)
          {
            aXO();
            return;
          }
          if ((q.dyn.dxa == 1) && (!com.tencent.mm.r.a.bj(this.kII.kIF.mController.uMN)) && (!com.tencent.mm.r.a.bi(this.kII.kIF.mController.uMN)))
          {
            b.q(this.kII.kIF.mController.uMN);
            return;
          }
          aXO();
          return;
        }
      } while ((c.aXb().aXF() != 1) && (c.aXb().aXF() != 3));
      paramView = new File(e.dzD);
      if ((!paramView.exists()) && (!paramView.mkdir()))
      {
        Toast.makeText(this.kII.kIF.mController.uMN, this.kII.kIF.getString(R.l.chatting_toast_sdk_fail), 1).show();
        return;
      }
      bool = com.tencent.mm.pluginsdk.permission.a.a(this.kII.kIF.mController.uMN, "android.permission.CAMERA", 16, "", "");
      y.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.kII.kIF.mController.uMN });
    } while (!bool);
    AlbumPreviewUI.F(this.kII.kIF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.7.1
 * JD-Core Version:    0.7.0.1
 */