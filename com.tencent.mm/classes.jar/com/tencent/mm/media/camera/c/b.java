package com.tencent.mm.media.camera.c;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.m.b;
import com.tencent.mm.media.camera.m.c;
import com.tencent.mm.media.camera.view.control.CameraFocusAndMeteringView;

public final class b
{
  public final CameraFocusAndMeteringView nuq;
  public final ViewStub nur;
  public final ViewStub nus;
  public final ViewStub nut;
  private final View rootView;
  
  private b(View paramView, CameraFocusAndMeteringView paramCameraFocusAndMeteringView, ViewStub paramViewStub1, ViewStub paramViewStub2, ViewStub paramViewStub3)
  {
    this.rootView = paramView;
    this.nuq = paramCameraFocusAndMeteringView;
    this.nur = paramViewStub1;
    this.nus = paramViewStub2;
    this.nut = paramViewStub3;
  }
  
  public static b a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(237141);
    paramLayoutInflater.inflate(m.c.camera_kit_layout, paramViewGroup);
    int i = m.b.control_view;
    paramLayoutInflater = (CameraFocusAndMeteringView)a.L(paramViewGroup, i);
    if (paramLayoutInflater != null)
    {
      i = m.b.debug_view;
      ViewStub localViewStub1 = (ViewStub)a.L(paramViewGroup, i);
      if (localViewStub1 != null)
      {
        i = m.b.surface_view;
        ViewStub localViewStub2 = (ViewStub)a.L(paramViewGroup, i);
        if (localViewStub2 != null)
        {
          i = m.b.texture_view;
          ViewStub localViewStub3 = (ViewStub)a.L(paramViewGroup, i);
          if (localViewStub3 != null)
          {
            paramLayoutInflater = new b(paramViewGroup, paramLayoutInflater, localViewStub1, localViewStub2, localViewStub3);
            AppMethodBeat.o(237141);
            return paramLayoutInflater;
          }
        }
      }
    }
    paramLayoutInflater = new NullPointerException("Missing required view with ID: ".concat(paramViewGroup.getResources().getResourceName(i)));
    AppMethodBeat.o(237141);
    throw paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.c.b
 * JD-Core Version:    0.7.0.1
 */