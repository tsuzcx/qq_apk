package com.tencent.mm.media.camera;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.view.CameraKitView;
import com.tencent.mm.plugin.mmsight.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/CameraDemoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activityMainBinding", "Lcom/tencent/mm/media/camera/databinding/ActivityMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CameraDemoActivity
  extends AppCompatActivity
{
  public static final CameraDemoActivity.a nte;
  private static final String[] ntg;
  private com.tencent.mm.media.camera.c.a ntf;
  
  static
  {
    AppMethodBeat.i(237145);
    nte = new CameraDemoActivity.a((byte)0);
    ntg = new String[] { "android.permission.CAMERA" };
    AppMethodBeat.o(237145);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(237155);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.ys(true);
    getWindow().setFormat(-3);
    paramBundle = getLayoutInflater().inflate(m.c.activity_main, null, false);
    int i = m.b.camera_view;
    Object localObject2 = (CameraKitView)androidx.m.a.L(paramBundle, i);
    if (localObject2 != null)
    {
      paramBundle = new com.tencent.mm.media.camera.c.a((ConstraintLayout)paramBundle, (CameraKitView)localObject2);
      s.s(paramBundle, "inflate(layoutInflater)");
      this.ntf = paramBundle;
      localObject2 = this.ntf;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("activityMainBinding");
        paramBundle = null;
      }
      setContentView((View)paramBundle.nuo);
      paramBundle = this.ntf;
      if (paramBundle != null) {
        break label201;
      }
      s.bIx("activityMainBinding");
      paramBundle = localObject1;
    }
    label201:
    for (;;)
    {
      paramBundle.nup.n((q)this);
      AppMethodBeat.o(237155);
      return;
      paramBundle = new NullPointerException("Missing required view with ID: ".concat(paramBundle.getResources().getResourceName(i)));
      AppMethodBeat.o(237155);
      throw paramBundle;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(237164);
    super.onDestroy();
    AppMethodBeat.o(237164);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.CameraDemoActivity
 * JD-Core Version:    0.7.0.1
 */